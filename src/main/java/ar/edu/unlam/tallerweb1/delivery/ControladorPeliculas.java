package ar.edu.unlam.tallerweb1.delivery;

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
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;

@Controller
public class ControladorPeliculas {

	private ServicioPelicula servicioPelicula;

	@Autowired
	public ControladorPeliculas(ServicioPelicula servicioPelicula) {
		this.servicioPelicula = servicioPelicula;
	}

	@RequestMapping(path = "/registro-pelicula")
	public ModelAndView iraRegistroPeliSerie(HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		Pelicula pelicula = new Pelicula();
		modelo.put("datosPelicula", pelicula);
		return new ModelAndView("registro-pelicula", modelo);
	}

	@RequestMapping(path = "/registrar-pelicula", method = RequestMethod.POST)
	public ModelAndView registrarPelicula(@ModelAttribute("datosPelicula") Pelicula datosPelicula, HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}

		Pelicula pelicula = this.servicioPelicula.registrarPelicula(datosPelicula);

		return new ModelAndView("redirect:/perfil-pelicula?id=" + pelicula.getId());
	}

	@RequestMapping("/perfil-pelicula")
	public ModelAndView VerPerfilPeli(@RequestParam("id") Integer id) {

		ModelMap modelo = new ModelMap();
		Pelicula pelicula = servicioPelicula.consultarPelicula(id);
		modelo.addAttribute("datosPelicula", pelicula);
		return new ModelAndView("perfil-pelicula", modelo);
	}
}
