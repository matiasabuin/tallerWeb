package ar.edu.unlam.tallerweb1.delivery;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioComentario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionCalificacionVacia;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionPeliculaNoEncontrada;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionSerieNoEncontrada;

@Controller
public class ControladorReview {
	
	private ServicioReview servicioReview;
	private ServicioComentario servicioComentario;
	private ServicioPelicula servicioPelicula;
	private ServicioSerie servicioSerie;

	@Autowired
	public ControladorReview(ServicioReview servicioReview, ServicioComentario servicioComentario,
			ServicioPelicula servicioPelicula, ServicioSerie servicioSerie) {
		this.servicioReview = servicioReview;
		this.servicioComentario = servicioComentario;
		this.servicioPelicula = servicioPelicula;
		this.servicioSerie = servicioSerie;
	}
	
	@RequestMapping("/review")
	public ModelAndView verReview(@RequestParam("id") Integer id) {
		
		ModelMap modelo = new ModelMap();
		Review review = servicioReview.getById(id);
		Comentario comentario = new Comentario();
		
		List<Comentario> comentarios = servicioComentario.getAllByReview(id); 
		
		modelo.addAttribute("review", review);
		modelo.addAttribute("comentario", comentario);
		modelo.addAttribute("listaComentarios", comentarios);
	
		return new ModelAndView("review", modelo);	
	}
	
	@RequestMapping(path = "/registrarReviewVideojuego", method = RequestMethod.POST)
	public ModelAndView registrarReviewVideojuego(@ModelAttribute("datosReview") Review datosReview) 
			throws ExceptionCalificacionVacia {
		
		Videojuego videojuego = datosReview.getVideojuego();
		
		servicioReview.registrar(datosReview);
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}

	@RequestMapping(path = "/registrarReviewPelicula", method = RequestMethod.POST)
	public ModelAndView registrarReviewPelicula(@ModelAttribute("datosReview") Review datosReview) 
			throws ExceptionPeliculaNoEncontrada {
		
		ModelMap modelo = new ModelMap();
		
		Pelicula pelicula = servicioPelicula.consultarPelicula(datosReview.getPelicula().getId());
		
	    try {
			servicioReview.registrar(datosReview);
		} catch (ExceptionCalificacionVacia e) {
			modelo.put("errorCalificacion", e.getMessage());
			return new ModelAndView("redirect:/perfil-pelicula?id=" + datosReview.getPelicula().getId(), modelo);
		}
		
		List<Review> reviews = servicioReview.getAllByPeliculaId(datosReview.getPelicula().getId());
		
	    Double calificacion = 0.0;
	    
	    for (Review element : reviews) {
	    	calificacion += element.getCalificacion();
	    }

	    Double calificacionFinal = calificacion / reviews.size();
	    
	    pelicula.setCalificacion(calificacionFinal);
	    
	    servicioPelicula.modificarPelicula(pelicula);
		
		return new ModelAndView("redirect:/perfil-pelicula?id=" + datosReview.getPelicula().getId(), modelo);
	}
	
	@RequestMapping(path = "/registrarReviewSerie", method = RequestMethod.POST)
	public ModelAndView registrarReviewSerie(@ModelAttribute("datosReview") Review datosReview) 
			throws ExceptionSerieNoEncontrada {
		
		ModelMap modelo = new ModelMap();
		
		Serie serie = servicioSerie.consultarSerie(datosReview.getSerie().getId());
		
	    try {
			servicioReview.registrar(datosReview);
		} catch (ExceptionCalificacionVacia e) {
			modelo.put("errorCalificacion", e.getMessage());
			return new ModelAndView("redirect:/perfil-serie?id=" + datosReview.getSerie().getId(), modelo);
		}
		
		List<Review> reviews = servicioReview.getAllBySerieId(datosReview.getSerie().getId());
		
	    Double calificacion = 0.0;
	    
	    for (Review element : reviews) {
	    	calificacion += element.getCalificacion();
	    }

	    Double calificacionFinal = calificacion / reviews.size();
	    
	    serie.setCalificacion(calificacionFinal);
	    
	    servicioSerie.modificarSerie(serie);
		
		return new ModelAndView("redirect:/perfil-serie?id=" + datosReview.getSerie().getId(), modelo);
		
	}
	
	@RequestMapping(path = "/eliminar-review")
	public ModelAndView eliminarReview(@RequestParam("id") Integer id, HttpServletRequest request) {
		
		Review reviewEncontrada = servicioReview.getById(id);
		
		servicioReview.eliminar(reviewEncontrada);
		
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		return new ModelAndView("redirect:/reviews?id=" + usuarioEncontrado.getId());
	}
	
	@RequestMapping("/review-editar")
	public ModelAndView irEditarReview(@RequestParam("id") Integer id) {
		ModelMap modelo = new ModelMap();
		
		Review reviewEncontrada = servicioReview.getById(id);
		
		modelo.addAttribute("review", reviewEncontrada);
		return new ModelAndView("editar-review", modelo);
	}
	
	
	@RequestMapping(path = "/editar-review", method = RequestMethod.POST)
	public ModelAndView editarReview(@ModelAttribute("review") Review reviewActualizada) {
		
		servicioReview.modificar(reviewActualizada);
		
		return new ModelAndView("redirect:/review?id=" + reviewActualizada.getId());
	}
	
}
