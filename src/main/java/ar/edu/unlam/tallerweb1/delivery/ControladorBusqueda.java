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
public class ControladorBusqueda {

	private ServicioVideojuego servicioVideojuego;
	private ServicioPelicula servicioPelicula;
	private ServicioSerie servicioSerie;
	
	@Autowired
	public ControladorBusqueda(ServicioVideojuego servicioVideojuego, ServicioPelicula servicioPelicula, 
			ServicioSerie servicioSerie) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioPelicula = servicioPelicula;
		this.servicioSerie = servicioSerie;
	}
	
	@RequestMapping(path = "/busqueda", method = RequestMethod.GET)
	public ModelAndView irABusqueda(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		model.addAttribute("busquedaBuscado", request.getSession().getAttribute("busquedaBuscado"));
		model.addAttribute("videojuegosEncontrados", request.getSession().getAttribute("videojuegosEncontrados"));
		model.addAttribute("peliculasEncontradas", request.getSession().getAttribute("peliculasEncontradas"));
		model.addAttribute("seriesEncontradas", request.getSession().getAttribute("seriesEncontradas"));
		return new ModelAndView("busqueda", model);
	}

	@RequestMapping(path = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscarRecomendaciones(@RequestParam("busqueda") String busqueda,
			HttpServletRequest request) {
		
		request.getSession().setAttribute("busquedaBuscado", busqueda);
		
		List<Videojuego> videojuegosRecomendados = servicioVideojuego.obtenerVideojuegoPorBusqueda(busqueda);
		List<Pelicula> peliculasRecomendadas = servicioPelicula.obtenerPeliculaPorBusqueda(busqueda);
		List<Serie> seriesRecomendadas = servicioSerie.obtenerSeriePorBusqueda(busqueda);
		
		request.getSession().setAttribute("peliculasEncontradas", peliculasRecomendadas);
		request.getSession().setAttribute("videojuegosEncontrados", videojuegosRecomendados);
		request.getSession().setAttribute("seriesEncontradas", seriesRecomendadas);
		
		return new ModelAndView("redirect:/busqueda");
	}
}