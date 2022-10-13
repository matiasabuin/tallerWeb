package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPerfil {

	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorPerfil(ServicioLogin servicioLogin, ServicioVideojuego servicioVideojuego, ServicioPelicula servicioPelicula){
		this.servicioLogin = servicioLogin;
	}

	@RequestMapping("/perfil")
	public ModelAndView irAPerfil(HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		return new ModelAndView("perfil-usuario", modelo);
	}
	
	@RequestMapping("/editar-perfil")
	public ModelAndView editarPerfil(HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		modelo.put("datosPerfil", request.getSession().getAttribute("usuarioActual"));
		return new ModelAndView("editar-perfil", modelo);
	}
	
	@RequestMapping(path = "/perfil-usuario", method = RequestMethod.POST)
	public ModelAndView editorPerfil(@ModelAttribute("datosPerfil") Usuario datosPerfil,
			HttpServletRequest request) {

		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		usuarioBuscado.setNombre(datosPerfil.getNombre());
		
		usuarioBuscado.setBiografia(datosPerfil.getBiografia());
		
		usuarioBuscado.setFoto(datosPerfil.getFoto());
		
		servicioLogin.editarPerfil(datosPerfil);
		
		return irAPerfil(request);
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
		
		return irAPerfil(request);
		
	}
	
	@RequestMapping(path = "/adquirir-free", method = RequestMethod.POST)
	public ModelAndView adquirirFree(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		usuarioBuscado.setPlan("Free");
		
		return irAPerfil(request);
		
	}
	
}