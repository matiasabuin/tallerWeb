package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorRecomendaciones {

	private ServicioVideojuego servicioVideojuego;
	private ServicioPelicula servicioPelicula;
	private ServicioSerie servicioSerie;
	
	@Autowired
	public ControladorRecomendaciones(ServicioVideojuego servicioVideojuego, ServicioPelicula servicioPelicula, 
			ServicioSerie servicioSerie) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioPelicula = servicioPelicula;
		this.servicioSerie = servicioSerie;
	}
	
	@RequestMapping(path = "/recomendaciones", method = RequestMethod.GET)
	public ModelAndView irARecomendaciones(@RequestParam("horas") Integer horas, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		model.addAttribute("horasRecomendacion", horas);
		model.addAttribute("videojuegosRecomendados", request.getSession().getAttribute("videojuegosRecomendados"));
		model.addAttribute("peliculasRecomendadas", request.getSession().getAttribute("peliculasRecomendadas"));
		model.addAttribute("seriesRecomendadas", request.getSession().getAttribute("seriesRecomendadas"));
		return new ModelAndView("recomendaciones", model);
	}

	@RequestMapping(path = "/buscar-recomendaciones", method = RequestMethod.GET)
	public ModelAndView buscarRecomendaciones(@RequestParam("horas") Integer horas,
			HttpServletRequest request) {
		
		if(horas != null) {
		List<Videojuego> videojuegosRecomendados = servicioVideojuego.obtenerVideojuegoPorTiempo(horas);
		List<Pelicula> peliculasRecomendadas = servicioPelicula.obtenerPeliculaPorTiempo(horas);
		List<Serie> seriesRecomendadas = servicioSerie.obtenerSeriePorTiempo(horas);
		
		request.getSession().setAttribute("peliculasRecomendadas", peliculasRecomendadas);
		request.getSession().setAttribute("videojuegosRecomendados", videojuegosRecomendados);
		request.getSession().setAttribute("seriesRecomendadas", seriesRecomendadas);
		
		return new ModelAndView("redirect:/recomendaciones?horas=" + horas);
		}
		return new ModelAndView("redirect:/home");
	}
	
}