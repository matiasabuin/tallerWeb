package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorHome {

	private ServicioVideojuego servicioVideojuego;
	private ServicioPelicula servicioPelicula;
	private ServicioSerie servicioSerie;

	@Autowired
	public ControladorHome(ServicioVideojuego servicioVideojuego, ServicioPelicula servicioPelicula,ServicioSerie servicioSerie) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioPelicula = servicioPelicula;
		this.servicioSerie=servicioSerie;
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome(HttpServletRequest request) {
		ModelMap model = new ModelMap();

		List<Videojuego> videojuegosRegistrados = servicioVideojuego.obtenerTodosLosVideojuegos();
		List<Pelicula> peliculasRegistradas = servicioPelicula.obtenerTodasLasPeliculas();
		List<Serie> seriesRegistradas = servicioSerie.obtenerTodasLasSeries();

		model.addAttribute("series", seriesRegistradas);
		model.addAttribute("peliculas", peliculasRegistradas);
		model.addAttribute("videojuegos", videojuegosRegistrados);
		return new ModelAndView("home", model);
	}
	
}
