package ar.edu.unlam.tallerweb1.delivery;

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
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;

@Controller
public class ControladorPeliculas {

	private ServicioPelicula servicioPelicula;
	private ServicioReview servicioReview;

	@Autowired
	public ControladorPeliculas(ServicioPelicula servicioPelicula, ServicioReview servicioReview) {
		this.servicioPelicula = servicioPelicula;
		this.servicioReview = servicioReview;
	}

	@RequestMapping(path = "/registro-pelicula")
	public ModelAndView iraRegistroPeliSerie( HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			ModelMap modelo = new ModelMap();
			Pelicula pelicula = new Pelicula();
			modelo.put("datosPelicula", pelicula);
			
			return new ModelAndView("registro-pelicula", modelo);		
		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(path = "/registrar-pelicula", method = RequestMethod.POST)
	public ModelAndView registrarPelicula(@ModelAttribute("datosPelicula") Pelicula datosPelicula, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuarioActual") == null){

			Pelicula pelicula = this.servicioPelicula.registrarPelicula(datosPelicula);

			return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
		}
		
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/perfil-pelicula")
	public ModelAndView VerPerfilPeli(@RequestParam("id") Integer id) {

		ModelMap modelo = new ModelMap();
		Pelicula pelicula = servicioPelicula.consultarPelicula(id);
		Review review = new Review();
		
		List<Review> reviews = servicioReview.getAllByPeliculaId(id);
		
		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosReview", review);
		modelo.addAttribute("datosPelicula", pelicula);
		
		return new ModelAndView("perfil-pelicula", modelo);
	}
}
