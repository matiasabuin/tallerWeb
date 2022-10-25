package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Lista;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioListas;

@Controller
public class ControladorListas {

	private ServicioListas servicioFav;

	@Autowired
	public ControladorListas(ServicioListas servicioFav) {
		this.servicioFav = servicioFav;
	}

	@RequestMapping(path = "/guardarFavVideojuego", method = RequestMethod.POST)
	public ModelAndView guardarFavVideojuego(@ModelAttribute("datosFav") Lista datosFavoritos) {

		Videojuego videojuego = datosFavoritos.getVideojuego();

		servicioFav.guardar(datosFavoritos);
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}
	
	@RequestMapping(path = "/eliminar-Fav")
	public ModelAndView eliminarFavVideojuego(@RequestParam("id") Integer id) {

		Lista fav = servicioFav.getById(id); 

		servicioFav.eliminar(fav);
		
		return new ModelAndView ("redirect:/home");
	}


	@RequestMapping(path = "/guardarFavPelicula", method = RequestMethod.POST)
	public ModelAndView guardarFavPelicula(@ModelAttribute("datosFav") Lista datosFavoritos) {

		Pelicula pelicula = datosFavoritos.getPelicula();

		servicioFav.guardar(datosFavoritos);

		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
	}
	
	@RequestMapping(path = "/guardarFavSerie", method = RequestMethod.POST)
	public ModelAndView guardarFavSerie(@ModelAttribute("datosFav") Lista datosFavoritos) {

		Serie serie = datosFavoritos.getSerie();

		servicioFav.guardar(datosFavoritos);

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}


}
