package ar.edu.unlam.tallerweb1.delivery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;
import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionSerieNoEncontrada;

@Controller
public class ControladorSerie {

	private ServicioFavoritos servicioFav;
	private ServicioSerie servicioSerie;
	private ServicioReview servicioReview;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioFiles servicioFiles;
	private ServicioHistorialUsuario servicioHistorial;

	@Autowired
	public ControladorSerie(ServicioSerie servicioSerie, ServicioReview servicioReview,
			ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioFavoritos servicioFav,
			ServicioFiles servicioFiles, ServicioHistorialUsuario servicioHisrotial) {
		this.servicioSerie = servicioSerie;
		this.servicioReview = servicioReview;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioFav = servicioFav;
		this.servicioFiles = servicioFiles;
		this.servicioHistorial = servicioHisrotial;

	}

	@RequestMapping(path = "/registro-serie")
	public ModelAndView iraRegistroSerie(HttpServletRequest request) {
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		if(request.getSession().getAttribute("usuarioActual") != null &&
				usuario.getPlanAdquirido().getPlan().getDescripcion().equals("Premium")){

			ModelMap modelo = new ModelMap();
			Serie serie = new Serie();

			List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
			List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();

			modelo.addAttribute("listaGeneros", generos);
			modelo.addAttribute("listaPlataformas", plataformas);
			modelo.put("datosSerie", serie);

			return new ModelAndView("registro-serie", modelo);
		}
		return new ModelAndView("redirect:/home");
	}

	@InitBinder
	protected void initBinderGenero(WebDataBinder binder) throws Exception {
		List<Genero> generosCache = servicioGeneroPlataforma.obtenerGeneros();
		binder.registerCustomEditor(List.class, "generos", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Genero generos = servicioGeneroPlataforma.getGeneroById(Integer.parseInt(element.toString()));
					return generos;
				}
				return null;
			}
		});
	}

	@InitBinder
	protected void initBinderPlataforma(WebDataBinder binder) throws Exception {
		List<Plataforma> plataformasCache = servicioGeneroPlataforma.obtenerPlataformas();
		binder.registerCustomEditor(List.class, "plataformas", new CustomCollectionEditor(List.class) {
			protected Object convertElement(Object element) {
				if (element instanceof String) {
					Plataforma plataformas = servicioGeneroPlataforma
							.getPlataformaById(Integer.parseInt(element.toString()));
					return plataformas;
				}
				return null;
			}
		});
	}

	@RequestMapping(path = "/registrar-serie", method = RequestMethod.POST)
	public ModelAndView registrarSerie(@ModelAttribute("datosSerie") Serie datosSerie,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}

		try {
			servicioFiles.uploadImage(file);
		} catch (IOException e) {
			return new ModelAndView("registro-serie");
		}
		
		datosSerie.setPoster(file.getOriginalFilename());
		Serie serie = servicioSerie.registrarSerie(datosSerie);
		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}

	@RequestMapping("/perfil-serie")
	public ModelAndView VerPerfilSerie(@RequestParam("id") Integer id, HttpServletRequest request)
			throws ExceptionSerieNoEncontrada {

		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");

		Serie serie;
		try {
			serie = servicioSerie.consultarSerie(id);
		} catch (ExceptionSerieNoEncontrada e) {
			return new ModelAndView("redirect:/home");
		}

		if (usuarioEncontrado != null) {
			Review reviewEncontrada = servicioReview.getByUserAndSerieID(usuarioEncontrado.getId(), id);
			if (reviewEncontrada.getUsuario() != null) {
				modelo.addAttribute("datosReview", reviewEncontrada);
			} else {
				modelo.addAttribute("datosReview", reviewEncontrada);
			}
		}

		List<Review> reviewsCache = servicioReview.getAllBySerieId(id);
		Set<Review> reviewsSinDuplicados = new HashSet<>(reviewsCache);
		List<Review> reviews = new ArrayList<>(reviewsSinDuplicados);

		if (usuarioEncontrado != null) {
			List<Favorito> listas = servicioFav.getAllByUserId(usuarioEncontrado.getId());
			if (servicioHistorial.getByUserId(usuarioEncontrado.getId()).buscarSerieEnHistorial(id) == null) {
				Historial historial=servicioHistorial.getByUserId(usuarioEncontrado.getId());
				historial.getSeries().add(servicioSerie.consultarSerie(id));
				servicioHistorial.update(historial);
			}
			modelo.addAttribute("listaFavs", listas);
		}

		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosSerie", serie);
		modelo.addAttribute("datosLista", new Favorito());

		return new ModelAndView("perfil-serie", modelo);
	}

}