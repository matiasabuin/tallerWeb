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
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionVideojuegoNoEncontrado;

@Controller
public class ControladorVideojuego {

	private ServicioVideojuego servicioVideojuego;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioReview servicioReview;
	private ServicioFiles servicioFiles;
	private ServicioFavoritos servicioFav;
	private ServicioHistorialUsuario servicioHistorial;

	@Autowired
	public ControladorVideojuego(ServicioVideojuego servicioVideojuego,
			ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioReview servicioReview, ServicioFiles servicioFiles, ServicioFavoritos servicioFav, ServicioHistorialUsuario servicioHisrotial) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioReview = servicioReview;
		this.servicioFiles = servicioFiles;
		this.servicioFav = servicioFav;
		this.servicioHistorial=servicioHisrotial;
	}

	@RequestMapping("/videojuego")
	public ModelAndView iraVideojuego(@RequestParam("id") Integer id, HttpServletRequest request) throws ExceptionVideojuegoNoEncontrado {

		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");

		Videojuego videojuego;
		try {
			videojuego = servicioVideojuego.consultarVideojuego(id);
		} catch (ExceptionVideojuegoNoEncontrado e) {
			return new ModelAndView("redirect:/home");
		}

		if (usuarioEncontrado != null) {
			Review reviewEncontrada = servicioReview.getByUserAndVideogameID(usuarioEncontrado.getId(), id);
			if (reviewEncontrada.getUsuario() != null) {
				modelo.addAttribute("datosReview", reviewEncontrada);
			} else {
				modelo.addAttribute("datosReview", reviewEncontrada);
			}
		}
		
		List<Review> reviewsCache = servicioReview.getAllByVideojuegoId(id);
		Set<Review> reviewsSinDuplicados = new HashSet<>(reviewsCache);
		List<Review> reviews = new ArrayList<>(reviewsSinDuplicados);
		
		if(usuarioEncontrado != null) {
			List<Favorito> listas = servicioFav.getAllByUserId(usuarioEncontrado.getId());
			if (servicioHistorial.getByUserId(usuarioEncontrado.getId()).buscarVideojuegoEnHistorial(id) == null) {
				Historial historial=servicioHistorial.getByUserId(usuarioEncontrado.getId());
				historial.getVideojuegos().add(servicioVideojuego.consultarVideojuego(id));
				servicioHistorial.update(historial);
			}
			modelo.addAttribute("listaFavs", listas);
		}

		modelo.addAttribute("datosVideojuego", videojuego);
		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosLista", new Favorito());

		return new ModelAndView("perfil-videojuego", modelo);
	}

	@RequestMapping("/registro-videojuego")
	public ModelAndView iraRegistrarVideojuego(HttpServletRequest request) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		if(request.getSession().getAttribute("usuarioActual") != null &&
				usuario.getPlanAdquirido().getPlan().getDescripcion().equals("Premium")) {

			ModelMap modelo = new ModelMap();
			Videojuego videojuego = new Videojuego();

			List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
			List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();

			modelo.addAttribute("datosVideojuego", videojuego);
			modelo.addAttribute("listaGeneros", generos);
			modelo.addAttribute("listaPlataformas", plataformas);

			return new ModelAndView("registro-videojuego", modelo);
		}
		return new ModelAndView("redirect:/home");
	}

	// Se aplica la anotacion a un metodo que sera el encargado de procesar
	// previamente la peticion enviada al controlador
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

	// Obtiene y almacena las opciones elegidas en el form que llegan como un array
	// de strings
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

	@RequestMapping(path = "/registrar-videojuego", method = RequestMethod.POST)
	public ModelAndView registrarVideojuego(@ModelAttribute("datosVideojuego") Videojuego datosVideojuego,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}
		
		try {
			servicioFiles.uploadImage(file);
		} catch (IOException e) {
			return new ModelAndView("registro-videojuego");
		}
		
		datosVideojuego.setPoster(file.getOriginalFilename());
		Videojuego videojuego = servicioVideojuego.registrarVideojuego(datosVideojuego);
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}

}