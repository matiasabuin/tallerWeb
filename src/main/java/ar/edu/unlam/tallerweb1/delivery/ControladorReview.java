package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;

@Controller
public class ControladorReview {
	
	private ServicioReview servicioReview;

	@Autowired
	public ControladorReview(ServicioReview servicioReview) {
		this.servicioReview = servicioReview;
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
	
}
