package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;

@Controller
public class ControladorSerie{
	
	private ServicioSerie servicioSerie;
	
	
	public ControladorSerie(ServicioSerie servicioSerie) {
		this.servicioSerie=servicioSerie;
		
	}
	@RequestMapping(path = "/registro-serie")
	public ModelAndView iraRegistroSerie( HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		Serie serie = new Serie();
		modelo.put("datosSerie", serie);
		return new ModelAndView("registro-serie", modelo);
	}
	@RequestMapping(path = "/registrar-serie", method = RequestMethod.POST)
	public ModelAndView registrarSerie(@ModelAttribute("datosSerie") Serie datosSerie, HttpServletRequest request) {
		
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}

		Serie serie = this.servicioSerie.registrarSerie(datosSerie);

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}
	@RequestMapping("/perfil-serie")
	public ModelAndView VerPerfilSerie(@RequestParam("id") Integer id) {

		ModelMap modelo = new ModelMap();
		Serie serie = servicioSerie.consultarSerie(id);
		modelo.addAttribute("datosSerie", serie);
		return new ModelAndView("perfil-serie", modelo);
	}
	
}