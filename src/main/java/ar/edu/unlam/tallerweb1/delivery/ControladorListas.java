package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Listas;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
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
	public ModelAndView guardarFavVideojuego(@ModelAttribute("datosFav") Listas datosFavoritos) {

		Videojuego videojuego = datosFavoritos.getVideojuego();

		// Videojuego videojuegoBuscado = servicioFav.consultarVideojuegoId(datosFavoritos.getId());

//		if (videojuegoBuscado != null) {
//			
//			return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
//		}
//		else {
		servicioFav.guardar(datosFavoritos);
		// }
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}
	@RequestMapping(path = "/eliminarFavVideojuego", method = RequestMethod.POST)
	public ModelAndView eliminarFavVideojuego(@ModelAttribute("datosFav") Listas datosFavoritos) {

		Videojuego videojuego = datosFavoritos.getVideojuego();

		servicioFav.eliminar(datosFavoritos);
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}

	@RequestMapping(path = "/guardarFavPelicula", method = RequestMethod.POST)
	public ModelAndView guardarFavPelicula(@ModelAttribute("datosFav") Listas datosFavoritos) {

		Pelicula pelicula = datosFavoritos.getPelicula();

		// Pelicula peliculabuscada =
		// servicioFav.consultarPeliculaId(datosFavoritos.getId());

//		if (peliculabuscada != null) {
//			
//			return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
//		}
//		else {
		servicioFav.guardar(datosFavoritos);
		// }

		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
	}
	@RequestMapping(path = "/eliminarFavPelicula", method = RequestMethod.POST)
	public ModelAndView eliminarFavPelicula(@ModelAttribute("datosFav") Listas datosFavoritos) {

		Pelicula pelicula = datosFavoritos.getPelicula();

		servicioFav.eliminar(datosFavoritos);
		
		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
	}

	@RequestMapping(path = "/guardarFavSerie", method = RequestMethod.POST)
	public ModelAndView guardarFavSerie(@ModelAttribute("datosFav") Listas datosFavoritos) {

		Serie serie = datosFavoritos.getSerie();

//		Serie seriebuscada = servicioFav.consultarSerieId(datosFavoritos.getId());
//
//		if (seriebuscada != null) {
//			
//			return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
//		}
//		else {
		servicioFav.guardar(datosFavoritos);
		// }

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}
	@RequestMapping(path = "/eliminarFavSerie", method = RequestMethod.POST)
	public ModelAndView eliminarFavSerie(@ModelAttribute("datosFav") Listas datosFavoritos) {
		Serie serie = datosFavoritos.getSerie();

//		Serie seriebuscada = servicioFav.consultarSerieId(datosFavoritos.getId());
//
//		if (seriebuscada != null) {
//			
//			return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
//		}
//		else {
		servicioFav.eliminar(datosFavoritos);
		// }

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}

	@RequestMapping(path = "/lista-completa")
	public ModelAndView irAListaFav(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") != null) {

		ModelMap model = new ModelMap();
		
		return new ModelAndView("lista-completa", model);
		}
		return new ModelAndView("redirect:/home");
	}
}
