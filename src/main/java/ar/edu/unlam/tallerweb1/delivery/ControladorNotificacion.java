package ar.edu.unlam.tallerweb1.delivery;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;

@Controller
public class ControladorNotificacion {

	private ServicioNotificacion servicioNotificacion;
	
	@Autowired
	public ControladorNotificacion(ServicioNotificacion servicioNotificacion) {
		this.servicioNotificacion = servicioNotificacion;
	}
	
	@RequestMapping(path = "/leido")
	public ModelAndView marcarLeido(@RequestParam("id") Integer id, HttpServletRequest request) {
		Notificacion notificacion = servicioNotificacion.getById(id);
		notificacion.setLeido(LocalDate.now());
		servicioNotificacion.modificar(notificacion);
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Integer cantNotificacionesNoLeidas = servicioNotificacion.getAllByUserId(usuarioBuscado.getId()).size();
		request.getSession().setAttribute("cantNotificaciones", cantNotificacionesNoLeidas);
		return new ModelAndView("redirect:/notificaciones");
	}
	
	@RequestMapping("/ver-leidos")
	public ModelAndView verLeidos(HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		List<Notificacion> notificacionesLeidasCache = servicioNotificacion.getAllLeidosByUserId(usuarioBuscado.getId());
		modelo.addAttribute("listaNotificacionesLeidas", notificacionesLeidasCache);
		return new ModelAndView("usuario-notificacionesLeidas", modelo);
	}
}
