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
	public ModelAndView irARecomendaciones(HttpServletRequest request) {
		
		ModelMap model = new ModelMap();

		List<Videojuego> videojuegosRegistrados = servicioVideojuego.obtenerTodosLosVideojuegos();
		List<Pelicula> peliculasRegistradas = servicioPelicula.obtenerTodasLasPeliculas();
		List<Serie> seriesRegistradas = servicioSerie.obtenerTodasLasSeries();
		
		request.getSession().setAttribute("peliculas", peliculasRegistradas);
		request.getSession().setAttribute("videojuegos", videojuegosRegistrados);
		request.getSession().setAttribute("series", seriesRegistradas);

		model.addAttribute("peliculas", peliculasRegistradas);
		model.addAttribute("videojuegos", videojuegosRegistrados);
		model.addAttribute("series", seriesRegistradas);
		
		model.addAttribute("horasRecomendacion", request.getSession().getAttribute("horasRecomendacion"));
		
		model.addAttribute("videojuegosRecomendados", request.getSession().getAttribute("videojuegosRecomendados"));
		model.addAttribute("peliculasRecomendadas", request.getSession().getAttribute("peliculasRecomendadas"));
		model.addAttribute("seriesRecomendadas", request.getSession().getAttribute("seriesRecomendadas"));
		
		return new ModelAndView("recomendaciones", model);
	}

	@RequestMapping(path = "/buscar-recomendaciones", method = RequestMethod.GET)
	public ModelAndView buscarRecomendaciones(@RequestParam("horas") Integer horas,
			HttpServletRequest request) {

		if(horas != null) {
		
		request.getSession().setAttribute("horasRecomendacion", horas);
		
		List<Videojuego> videojuegosRecomendados = servicioVideojuego.obtenerVideojuegoPorTiempo(horas);
		List<Pelicula> peliculasRecomendadas = servicioPelicula.obtenerPeliculaPorTiempo(horas);
		List<Serie> seriesRecomendadas = servicioSerie.obtenerSeriePorTiempo(horas);
		
		request.getSession().setAttribute("peliculasRecomendadas", peliculasRecomendadas);
		request.getSession().setAttribute("videojuegosRecomendados", videojuegosRecomendados);
		request.getSession().setAttribute("seriesRecomendadas", seriesRecomendadas);
		
		return irARecomendaciones(request);
		}
		
		return new ModelAndView("redirect:/home");
	}
	
}