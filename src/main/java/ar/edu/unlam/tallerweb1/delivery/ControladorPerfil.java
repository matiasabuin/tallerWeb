package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFavoritos;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorPerfil {

	private ServicioLogin servicioLogin;
	private ServicioFiles servicioFiles;
	private ServicioReview servicioReview;
	private ServicioNotificacion servicioNotificacion;
	private ServicioHistorialUsuario servicioHistorial;
	private ServicioFavoritos servicioListas;

	@Autowired
	public ControladorPerfil(ServicioLogin servicioLogin, ServicioFiles servicioFiles, 
			ServicioReview servicioReview, ServicioFavoritos servicioListas, 
			ServicioNotificacion servicioNotificacion, ServicioHistorialUsuario servicioHisrotial) {
		this.servicioLogin = servicioLogin;
		this.servicioFiles = servicioFiles;
		this.servicioReview = servicioReview;
		this.servicioListas = servicioListas;
		this.servicioNotificacion = servicioNotificacion;
		this.servicioHistorial=servicioHisrotial;

	}

	@RequestMapping("/perfil")
	public ModelAndView irAPerfil(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		
		Usuario usuarioPerfil = servicioLogin.getById(id);
		
		List<Favorito> listas = servicioListas.getAllByUserId(usuarioPerfil.getId());

		modelo.addAttribute("usuario", usuarioPerfil);
		
		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		List<Pelicula> cacheHistorialPeli=servicioHistorial.getByUserId(usuarioPerfil.getId()).getPeliculas();
		List<Pelicula> historialPeli=servicioHistorial.getByUserId(usuarioPerfil.getId()).invertirListaDePeliculas(cacheHistorialPeli);
		
		List<Serie> cacheHistorialSeries=servicioHistorial.getByUserId(usuarioPerfil.getId()).getSeries();
		List<Serie> historialSeries=servicioHistorial.getByUserId(usuarioPerfil.getId()).invertirListaDeSeries(cacheHistorialSeries);

		List<Videojuego> cacheHistorialVideoJ=servicioHistorial.getByUserId(usuarioPerfil.getId()).getVideojuegos();
		List<Videojuego> historialVideoJ=servicioHistorial.getByUserId(usuarioPerfil.getId()).invertirListaDeVideojuegos(cacheHistorialVideoJ);

		modelo.addAttribute("historialPelis",historialPeli);
		modelo.addAttribute("historialSeries",historialSeries);
		modelo.addAttribute("historialVideoJ",historialVideoJ);
		
		modelo.addAttribute("listaFavs", listas);
		
		return new ModelAndView("perfil-usuario", modelo);
	}

	@RequestMapping("/editar-perfil")
	public ModelAndView editarPerfil(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		modelo.put("datosPerfil", request.getSession().getAttribute("usuarioActual"));
		return new ModelAndView("editar-perfil", modelo);
	}

	@RequestMapping(path = "/editar-usuario", method = RequestMethod.POST)
	public ModelAndView editorPerfil(@ModelAttribute("datosPerfil") Usuario datosPerfil,
			@RequestParam("file") MultipartFile foto, HttpServletRequest request) throws IOException {

		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");

        if(foto.getBytes() != null) {
        	servicioFiles.uploadImage(foto);
        	usuarioBuscado.setFoto(foto.getOriginalFilename());
        } else {
        	usuarioBuscado.setFoto(usuarioBuscado.getFoto());
        }
	
		usuarioBuscado.setNombre(datosPerfil.getNombre());
		usuarioBuscado.setBiografia(datosPerfil.getBiografia());

		servicioLogin.editarPerfil(usuarioBuscado);

		return new ModelAndView("redirect:/perfil");
	}

	@RequestMapping("/reviews")
	public ModelAndView verReviews(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}

		ModelMap modelo = new ModelMap();
		
		Usuario usuarioPerfil = servicioLogin.getById(id);
		List<Review> reviewsCache = servicioReview.getAllByUserId(usuarioPerfil.getId());
		
		Set<Review> reviewsSinDuplicados = new HashSet<>(reviewsCache);
		List<Review> reviews = new ArrayList<>(reviewsSinDuplicados);

		modelo.addAttribute("usuario", usuarioPerfil);
		modelo.addAttribute("listaReviews", reviews);
		return new ModelAndView("usuario-reviews", modelo);
	}
	
	@RequestMapping("/notificaciones")
	public ModelAndView verNotificaciones(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}

		ModelMap modelo = new ModelMap();
		Usuario usuarioEncontrado = (Usuario) request.getSession().getAttribute("usuarioActual");
		
		List<Notificacion> notificacionesLeidasCache = servicioNotificacion.getAllLeidosByUserId(usuarioEncontrado.getId());
		List<Notificacion> notificacionesCache = servicioNotificacion.getAllByUserId(usuarioEncontrado.getId());

		modelo.addAttribute("listaNotificacionesLeidas", notificacionesLeidasCache);
		modelo.addAttribute("listaNotificaciones", notificacionesCache);
		return new ModelAndView("usuario-notificaciones", modelo);
	}

	@RequestMapping(path = "/lista-completa")
	public ModelAndView irAListaFav(@RequestParam("id") Integer id, HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		
		Usuario usuarioPerfil = servicioLogin.getById(id);
		List<Favorito> listas = servicioListas.getAllByUserId(usuarioPerfil.getId());
		
		modelo.addAttribute("usuario", usuarioPerfil);
		modelo.addAttribute("listaFavs", listas);
		return new ModelAndView("favs-completo", modelo);

	}

}