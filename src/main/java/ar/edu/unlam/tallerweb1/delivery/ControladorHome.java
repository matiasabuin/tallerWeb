package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorHome {

	private ServicioLogin servicioLogin;
	private ServicioVideojuego servicioVideojuego;
	private ServicioPelicula servicioPelicula;

	@Autowired
	public ControladorHome(ServicioLogin servicioLogin, ServicioVideojuego servicioVideojuego, ServicioPelicula servicioPelicula){
		this.servicioLogin = servicioLogin;
		this.servicioVideojuego = servicioVideojuego;
		this.servicioPelicula = servicioPelicula;
	}
	
	@RequestMapping(path = "/buscar-recomendaciones", method = RequestMethod.GET)
	public ModelAndView buscarRecomendaciones(@RequestParam("horas") Integer horas, @RequestParam("tipo") String tipo, HttpServletRequest request) {
		
		return new ModelAndView("redirect:/home");
	}
}
