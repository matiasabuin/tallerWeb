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

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionPeliculaNoEncontrada;

@Controller
public class ControladorPelicula {

	private ServicioPelicula servicioPelicula;
	private ServicioReview servicioReview;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioFavoritos servicioFav;
	private ServicioFiles servicioFiles;
	private ServicioHistorialUsuario servicioHistorial;

	@Autowired
	public ControladorPelicula(ServicioPelicula servicioPelicula, ServicioReview servicioReview,
			ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioFavoritos servicioFav,
			ServicioFiles servicioFiles, ServicioHistorialUsuario servicioHisrotial) {
		this.servicioPelicula = servicioPelicula;
		this.servicioReview = servicioReview;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioFav = servicioFav;
		this.servicioFiles = servicioFiles;
		this.servicioHistorial = servicioHisrotial;
	}

	@RequestMapping(path = "/registro-pelicula")
	public ModelAndView iraRegistroPeliSerie(HttpServletRequest request) {
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		if(request.getSession().getAttribute("usuarioActual") != null &&
				
				usuario.getPlanAdquirido().getPlan().getDescripcion().equals("Premium")){
			ModelMap modelo = new ModelMap();
			Pelicula pelicula = new Pelicula();

			List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
			List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();

			modelo.addAttribute("listaGeneros", generos);
			modelo.addAttribute("listaPlataformas", plataformas);
			modelo.put("datosPelicula", pelicula);
			return new ModelAndView("registro-pelicula", modelo);
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

	@RequestMapping(path = "/registrar-pelicula", method = RequestMethod.POST)
	public ModelAndView registrarPelicula(@ModelAttribute("datosPelicula") Pelicula datosPelicula,
			@RequestParam("file") MultipartFile file, HttpServletRequest request)  {

		try {
			servicioFiles.uploadImage(file);
		} catch (IOException e) {
			return new ModelAndView("registro-pelicula");
		}

		datosPelicula.setPoster(file.getOriginalFilename());
		Pelicula pelicula = servicioPelicula.registrarPelicula(datosPelicula);
		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());

	}

	@RequestMapping("/perfil-pelicula")
	public ModelAndView VerPerfilPeli(@RequestParam("id") Integer id, HttpServletRequest request)
			throws ExceptionPeliculaNoEncontrada {

		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");

		Pelicula pelicula;
		try {
			pelicula = servicioPelicula.consultarPelicula(id);
		} catch (ExceptionPeliculaNoEncontrada e) {
			return new ModelAndView("redirect:/home");
		}

		if (usuarioEncontrado != null) {
			Review reviewEncontrada = servicioReview.getByUserAndPeliculaID(usuarioEncontrado.getId(), id);
			if (reviewEncontrada.getUsuario() != null) {
				modelo.addAttribute("datosReview", reviewEncontrada);
			} else {
				modelo.addAttribute("datosReview", reviewEncontrada);
			}
		}

		Favorito fav = new Favorito();

		List<Review> reviewsCache = servicioReview.getAllByPeliculaId(id);
		Set<Review> reviewsSinDuplicados = new HashSet<>(reviewsCache);
		List<Review> reviews = new ArrayList<>(reviewsSinDuplicados);
		
		if (usuarioEncontrado != null) {
			List<Favorito> listas = servicioFav.getAllByUserId(usuarioEncontrado.getId());
			if (servicioHistorial.getByUserId(usuarioEncontrado.getId()).buscarPeliEnHistorial(id) == null) {
				Historial historial=servicioHistorial.getByUserId(usuarioEncontrado.getId());
				historial.getPeliculas().add(servicioPelicula.consultarPelicula(id));
				servicioHistorial.update(historial);
				
			}
			modelo.addAttribute("listaFavs", listas);
		}

		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosPelicula", pelicula);
		modelo.addAttribute("datosLista", fav);
		return new ModelAndView("perfil-pelicula", modelo);
	}
}
