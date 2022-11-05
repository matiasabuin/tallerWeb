package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioComentario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;

@Controller
public class ControladorComentario {

	private ServicioComentario servicioComentario;
	private ServicioNotificacion servicioNotificacion;
	private ServicioLogin servicioLogin;
	private ServicioReview servicioReview;

	@Autowired
	public ControladorComentario(ServicioComentario servicioComentario, ServicioNotificacion servicioNotificacion, ServicioLogin servicioLogin, ServicioReview servicioReview) {
		this.servicioComentario = servicioComentario;
		this.servicioNotificacion = servicioNotificacion;
		this.servicioLogin = servicioLogin;
		this.servicioReview = servicioReview;
	}

	@RequestMapping(path = "/registrar-comentario", method = RequestMethod.POST)
	public ModelAndView registrarComentario(@ModelAttribute("datosComentario") Comentario datosComentario, HttpServletRequest request) {
		
		Review reviewEncontrada = servicioReview.getById(datosComentario.getReview().getId());
		
		Usuario usuarioReceptor = servicioLogin.getById(reviewEncontrada.getUsuario().getId());
		Usuario usuarioRemitente = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		Notificacion notificacion = new Notificacion();
		notificacion.setUsuario(usuarioReceptor);
		notificacion.setMensaje(usuarioRemitente.getNombre() + " Te ha dejado un comentario a una review que hiciste " + "<a href='review?id=" + reviewEncontrada.getId() +"'>Ver review</a>");
		servicioNotificacion.registrar(notificacion);
		
		servicioComentario.registrar(datosComentario);
		return new ModelAndView("redirect:/review?id=" + datosComentario.getReview().getId());
	}
}
