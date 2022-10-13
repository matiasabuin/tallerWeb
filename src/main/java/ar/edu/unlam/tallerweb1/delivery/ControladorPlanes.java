package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;

@Controller
public class ControladorPlanes {

	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorPlanes(ServicioLogin servicioLogin){
		this.servicioLogin = servicioLogin;
	}
	
	@RequestMapping("/editar-plan")
	public ModelAndView irAPlanes(HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		return new ModelAndView("editar-plan", modelo);
	}
	
	@RequestMapping(path = "/adquirir-premium", method = RequestMethod.POST)
	public ModelAndView adquirirPremium(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		usuarioBuscado.setPlan("Premium");
		
		return new ModelAndView("redirect:/editar-plan");
		
	}
	
	@RequestMapping(path = "/adquirir-free", method = RequestMethod.POST)
	public ModelAndView adquirirFree(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		usuarioBuscado.setPlan("Free");
		
		return new ModelAndView("redirect:/editar-plan");
	}
}
