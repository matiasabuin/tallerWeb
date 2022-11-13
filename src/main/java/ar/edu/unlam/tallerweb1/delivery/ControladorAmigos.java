package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Amigo;
import ar.edu.unlam.tallerweb1.domain.pedidos.Estado;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Solicitud;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioAmigos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSolicitud;

@Controller
public class ControladorAmigos {

	private ServicioLogin servicioLogin;
	private ServicioNotificacion servicioNotificacion;
	private ServicioAmigos servicioAmigos;
	private ServicioSolicitud servicioSolicitud;

	@Autowired
	public ControladorAmigos(ServicioLogin servicioLogin, ServicioNotificacion servicioNotificacion, ServicioAmigos servicioAmigos, ServicioSolicitud servicioSolicitud) {
		this.servicioLogin = servicioLogin;
		this.servicioNotificacion = servicioNotificacion;
		this.servicioAmigos = servicioAmigos;
		this.servicioSolicitud = servicioSolicitud;
	}
	
	@RequestMapping(path="/enviar-solicitud")
	public ModelAndView enviarSolicitud(@RequestParam("usuario") Integer id, HttpServletRequest request) {
		Usuario usuarioReceptor = servicioLogin.getById(id);
		Usuario usuarioRemitente = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		Solicitud solicitud = new Solicitud();
		solicitud.setUsuario1(usuarioRemitente);
		solicitud.setUsuario2(usuarioReceptor);
		solicitud.setEstado(Estado.PENDIENTE);
		servicioSolicitud.registrar(solicitud);
		
		Notificacion notificacion = new Notificacion();
		servicioNotificacion.registrar(notificacion);
		notificacion.setUsuario(usuarioReceptor);
		notificacion.setMensaje(usuarioRemitente.getNombre() + " Te ha enviado una solicitud de amistad " + "<a href='aprobar-solicitud?usuario="+usuarioRemitente.getId()+"&notificacion="+notificacion.getId()+"'>Aceptar</a>" + "<a href='rechazar-solicitud?usuario="+usuarioRemitente.getId()+"&notificacion="+notificacion.getId()+"'>Rechazar</a>");
		servicioNotificacion.modificar(notificacion);
		
		return new ModelAndView("redirect:/perfil?id=" + id);
	}
	
	@RequestMapping(path="/aprobar-solicitud")
	public ModelAndView aprobarSolicitud(@RequestParam("usuario") Integer usuario, @RequestParam("notificacion") Integer notificacion, HttpServletRequest request) {
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuarioActual");
		Solicitud solicitudEncontrada = servicioSolicitud.getByUsers(usuario, usuarioActual.getId());
		servicioSolicitud.aprobarSolicitud(solicitudEncontrada);
		
		Usuario usuarioPeticion = servicioLogin.getById(usuario);
		Amigo amigo1 = new Amigo();
		amigo1.setUsuario(usuarioActual);
		amigo1.setAmigo(usuarioPeticion);
		servicioAmigos.registar(amigo1);
		
		Amigo amigo2 = new Amigo();
		amigo2.setUsuario(usuarioPeticion);
		amigo2.setAmigo(usuarioActual);
		servicioAmigos.registar(amigo2);
		
		Notificacion notificacionAprobado = new Notificacion();
		notificacionAprobado.setUsuario(usuarioPeticion);
		notificacionAprobado.setMensaje(usuarioActual.getNombre() + " ha aceptado tu solicitud de amistad, ahora son amigos!");
		servicioNotificacion.registrar(notificacionAprobado);
		
		Notificacion notificacionEncontrada = servicioNotificacion.getById(notificacion);
		notificacionEncontrada.setMensaje(usuarioPeticion.getNombre() + " Te ha enviado una solicitud de amistad ");
		servicioNotificacion.modificar(notificacionEncontrada);
		return new ModelAndView("redirect:/leido?id=" + notificacionEncontrada.getId());
	}
	
	@RequestMapping(path="/rechazar-solicitud")
	public ModelAndView rechazarSolicitud(@RequestParam("usuario") Integer usuario, @RequestParam("notificacion") Integer notificacion, HttpServletRequest request) {
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuarioActual");
		Solicitud solicitudEncontrada = servicioSolicitud.getByUsers(usuario, usuarioActual.getId());
		servicioSolicitud.rechazarSolicitud(solicitudEncontrada);
		
		Usuario usuarioPeticion = servicioLogin.getById(usuario);
		
		Notificacion notificacionRechazado = new Notificacion();
		notificacionRechazado.setUsuario(usuarioPeticion);
		notificacionRechazado.setMensaje(usuarioActual.getNombre() + " ha rechazado tu solicitud de amistad :(");
		servicioNotificacion.registrar(notificacionRechazado);
		
		Notificacion notificacionEncontrada = servicioNotificacion.getById(notificacion);
		notificacionEncontrada.setMensaje(usuarioPeticion.getNombre() + " Te ha enviado una solicitud de amistad ");
		servicioNotificacion.modificar(notificacionEncontrada);
		return new ModelAndView("redirect:/leido?id=" + notificacionEncontrada.getId());
	}

}
