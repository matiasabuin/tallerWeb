package ar.edu.unlam.tallerweb1.delivery;

import java.util.ArrayList;
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
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
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

	@RequestMapping(path = "/buscar-recomendaciones", method = RequestMethod.GET)
	public ModelAndView buscarRecomendaciones(@RequestParam("horas") Integer horas, @RequestParam("tipo") String tipo,
			HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		switch (tipo) {
		case "pelicula":
			break;

		case "videojuego":
			List<Videojuego> recomendaciones = new ArrayList<>();
			List<Videojuego> videojuegos = servicioVideojuego.obtenerTodosLosVideojuegos();
			for (Videojuego videojuego : videojuegos) {
				if (videojuego.getDuracion() <= horas.intValue())
					recomendaciones.add(videojuego);
			}
			modelo.addAttribute("recomendaciones", recomendaciones);
			return new ModelAndView("redirect:/home", modelo);
		default:
			break;
		}

		return new ModelAndView("redirect:/home");
	}
}
