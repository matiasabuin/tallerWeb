package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPerfil {

	private ServicioLogin servicioLogin;
	private ServicioFiles servicioFiles;
	private ServicioReview servicioReview;

	@Autowired
	public ControladorPerfil(ServicioLogin servicioLogin,ServicioFiles servicioFiles, ServicioReview servicioReview){
		this.servicioLogin = servicioLogin;
		this.servicioFiles = servicioFiles;
		this.servicioReview = servicioReview;
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
	
	@RequestMapping(path = "/editar-usuario", method = RequestMethod.POST)
	public ModelAndView editorPerfil(@ModelAttribute("datosPerfil") Usuario datosPerfil, @RequestParam("file") MultipartFile foto,
			HttpServletRequest request) throws IOException {

		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		servicioFiles.uploadImage(foto);
		
		usuarioBuscado.setNombre(datosPerfil.getNombre());
		
		usuarioBuscado.setBiografia(datosPerfil.getBiografia());
		
		usuarioBuscado.setFoto(foto.getOriginalFilename());
		
		servicioLogin.editarPerfil(usuarioBuscado);
		
		return new ModelAndView("redirect:/perfil");

	}
	
	@RequestMapping("/reviews")
	public ModelAndView verReviews(HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		
		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");
		List<Review> reviews = servicioReview.getAllByUserId(usuarioEncontrado.getId());
		
		modelo.addAttribute("listaReviews", reviews);
		return new ModelAndView("usuario-reviews", modelo);
	}
	
	@RequestMapping(path = "/lista-completa")
	public ModelAndView irAListaFav(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") != null) {

		ModelMap model = new ModelMap();
		
		return new ModelAndView("lista-completa", model);
		}
		return new ModelAndView("redirect:/home");
	}
	
}