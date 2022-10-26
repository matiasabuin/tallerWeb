package ar.edu.unlam.tallerweb1.delivery;

import java.util.ArrayList;
import java.util.List;

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
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;

@Controller
public class ControladorReview {
	
	private ServicioReview servicioReview;
	private ServicioComentario servicioComentario;

	@Autowired
	public ControladorReview(ServicioReview servicioReview, ServicioComentario servicioComentario) {
		this.servicioReview = servicioReview;
		this.servicioComentario = servicioComentario;
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
	public ModelAndView registrarReviewVideojuego(@ModelAttribute("datosReview") Review datosReview) {
		
		Videojuego videojuego = datosReview.getVideojuego();
		
		servicioReview.registrar(datosReview);
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}

	@RequestMapping(path = "/registrarReviewPelicula", method = RequestMethod.POST)
	public ModelAndView registrarReviewPelicula(@ModelAttribute("datosReview") Review datosReview) {
		
		Pelicula pelicula = datosReview.getPelicula();
		
		servicioReview.registrar(datosReview);

		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
	}
	
	@RequestMapping(path = "/registrarReviewSerie", method = RequestMethod.POST)
	public ModelAndView registrarReviewSerie(@ModelAttribute("datosReview") Review datosReview) {
		
		Serie serie = datosReview.getSerie();
		
		servicioReview.registrar(datosReview);

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}
	
	@RequestMapping(path = "/eliminar-review")
	public ModelAndView eliminarReview(@RequestParam("id") Integer id) {
		
		Review reviewEncontrada = servicioReview.getById(id);
		
		servicioReview.eliminar(reviewEncontrada);
		
		return new ModelAndView("redirect:/reviews");
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
