package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorVideojuego {
	
	private ServicioVideojuego servicioVideojuego;

	@Autowired
	public ControladorVideojuego(ServicioVideojuego servicioVideojuego){
		this.servicioVideojuego = servicioVideojuego;
	}
	
	@RequestMapping("/videojuego")
	public ModelAndView iraVideojuego(@RequestParam("id") Integer id) {
		ModelMap modelo = new ModelMap();
		Videojuego videojuego = servicioVideojuego.consultarVideojuego(id);
		modelo.addAttribute("datosVideojuego", videojuego);
		return new ModelAndView("perfil-videojuego", modelo);
	}
	
	@RequestMapping("/registro-videojuego")
	public ModelAndView iraRegistrarVideojuego() {
		ModelMap modelo = new ModelMap();
		Videojuego videojuego = new Videojuego();
		modelo.addAttribute("datosVideojuego", videojuego);
		return new ModelAndView("registro-videojuego", modelo);
	}
	
	@RequestMapping(path = "/registrar-videojuego", method = RequestMethod.POST)
	public ModelAndView registrarVideojuego(@ModelAttribute("datosVideojuego") Videojuego datosVideojuego, HttpServletRequest request) {
		
		Videojuego videojuego = this.servicioVideojuego.registrarVideojuego(datosVideojuego);
		
		List<Videojuego> videojuegosRegistrados = servicioVideojuego.obtenerTodosLosVideojuegos();
		
		request.getSession().setAttribute("videojuegos", videojuegosRegistrados);

		request.getSession().getAttribute("videojuegos");
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());
	}
	
//	@RequestMapping("/menu")
//	public ModelAndView iraMenu() {
//		ModelMap modelo = new ModelMap();
//		modelo.put("datosMenu", new DatosMenu());
//		return new ModelAndView("menu", modelo);
//	}
//	
//	@RequestMapping("/crear-menu")
//	public ModelAndView iraCrearMenu() {
//		ModelMap modelo = new ModelMap();
//		modelo.put("datosMenu", new DatosMenu());
//		return new ModelAndView("crear-menu", modelo);
//	}
//	
//	@RequestMapping(path = "/guardar-menu", method = RequestMethod.POST)
//	public ModelAndView guardarMenu(@ModelAttribute("datosMenu") DatosMenu datosMenu) {
//		ModelMap modelo = new ModelMap();
//		todos.add(datosMenu);
//		modelo.put("todos", todos);
//		return new ModelAndView("menu", modelo);
//	}
}
