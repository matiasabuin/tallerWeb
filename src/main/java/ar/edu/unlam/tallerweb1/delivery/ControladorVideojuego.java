package ar.edu.unlam.tallerweb1.delivery;

import java.io.IOException;
import java.util.List;
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
import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionImagenNoIngresada;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionVideojuegoNoEncontrado;

@Controller
public class ControladorVideojuego {

	private ServicioVideojuego servicioVideojuego;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioReview servicioReview;
	private ServicioFiles servicioFiles;
	private ServicioFavoritos servicioFav;

	@Autowired
	public ControladorVideojuego(ServicioVideojuego servicioVideojuego,
			ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioReview servicioReview, ServicioFiles servicioFiles, ServicioFavoritos servicioFav) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioReview = servicioReview;
		this.servicioFiles = servicioFiles;
		this.servicioFav = servicioFav;
	}

	@RequestMapping("/videojuego")
	public ModelAndView iraVideojuego(@RequestParam("id") Integer id, HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");

//		if (request.getSession().getAttribute("usuarioActual") != null) {
//		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
//		usuarioBuscado.getHistorial().add(servicioVideojuego.consultarVideojuego(id));
//	}

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
		
		List<Review> reviews = servicioReview.getAllByVideojuegoId(id);
		
		if(usuarioEncontrado != null) {
			List<Favorito> listas = servicioFav.getAllByUserId(usuarioEncontrado.getId());
			modelo.addAttribute("listaFavs", listas);
		}

		modelo.addAttribute("datosVideojuego", videojuego);
		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosLista", new Favorito());

		return new ModelAndView("perfil-videojuego", modelo);
	}

	@RequestMapping("/registro-videojuego")
	public ModelAndView iraRegistrarVideojuego(HttpServletRequest request) {

		if(request.getSession().getAttribute("usuarioActual") != null &&
				request.getSession().getAttribute("usuarioPlan").equals("Premium")) {

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
			@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}
		
		try {
			servicioFiles.uploadImage(file);
			servicioVideojuego.validar(datosVideojuego);
		} catch (ExceptionRegistroCamposVacios e) {
			ModelMap modelo = new ModelMap();
			modelo.put("errorCampos", e.getMessage());
			modelo.put("datosVideojuego", datosVideojuego);
			return new ModelAndView("redirect:/registro-videojuego", modelo);
		} 

		datosVideojuego.setPoster(file.getOriginalFilename());
		Videojuego videojuego = servicioVideojuego.registrarVideojuego(datosVideojuego);
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}

}