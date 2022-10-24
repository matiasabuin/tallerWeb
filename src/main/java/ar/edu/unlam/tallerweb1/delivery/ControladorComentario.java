package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioComentario;

@Controller
public class ControladorComentario {
	
	@Autowired
	ServicioComentario servicioComentario;

	@RequestMapping(path = "/registrar-comentario")
	public ModelAndView registrarComentario(@ModelAttribute("datosComentario") Comentario datosComentario) {
		
		servicioComentario.registrar(datosComentario);
		
		return new ModelAndView("redirect:/review?id=" + datosComentario.getReview().getId());
	}
}
