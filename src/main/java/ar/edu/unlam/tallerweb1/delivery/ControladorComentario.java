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
import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioComentario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionDescripcionVacia;

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
	
	@RequestMapping("/comentarios")
	public ModelAndView verComentarios(@RequestParam("id") Integer id, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Usuario usuarioPerfil = servicioLogin.getById(id);
		List<Comentario> comentariosCache = servicioComentario.getAllByUser(usuarioPerfil.getId());

		modelo.addAttribute("usuario", usuarioPerfil);
		modelo.addAttribute("listaComentarios",comentariosCache);
		return new ModelAndView("usuario-comentarios", modelo);
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
		
		try {
			servicioComentario.registrar(datosComentario);
		} catch (ExceptionDescripcionVacia e) {
			return new ModelAndView("redirect:/review?id=" + datosComentario.getReview().getId());
		}
		
		return new ModelAndView("redirect:/review?id=" + datosComentario.getReview().getId());
	}
	
	@RequestMapping(path = "/eliminar-comentario-review")
	public ModelAndView eliminarComentarioReview(@RequestParam("id") Integer id) {
		Comentario comentarioEncontrado = servicioComentario.getById(id);
		servicioComentario.eliminar(comentarioEncontrado);
		return new ModelAndView("redirect:/review?id=" + comentarioEncontrado.getReview().getId());
	}
	
	@RequestMapping(path = "/eliminar-comentario")
	public ModelAndView eliminarComentario(@RequestParam("id") Integer id) {
		Comentario comentarioEncontrado = servicioComentario.getById(id);
		servicioComentario.eliminar(comentarioEncontrado);
		return new ModelAndView("redirect:/comentarios?id=" + comentarioEncontrado.getUsuario().getId());
	}
	
	@RequestMapping(path = "/editar-comentario", method = RequestMethod.POST)
	public ModelAndView editarComentario(@ModelAttribute("comentario") Comentario comentario) {
		servicioComentario.modificar(comentario);
		return new ModelAndView("redirect:/comentarios?id=" + comentario.getUsuario().getId());
	}
	
	@RequestMapping("/comentario-editar")
	public ModelAndView irEditarReview(@RequestParam("id") Integer id) {
		ModelMap modelo = new ModelMap();
		Comentario comentarioEncontrado = servicioComentario.getById(id);
		modelo.addAttribute("comentario", comentarioEncontrado);
		return new ModelAndView("editar-comentario", modelo);
	}
	
}
