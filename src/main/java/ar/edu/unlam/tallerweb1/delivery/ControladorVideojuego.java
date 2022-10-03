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

import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;

import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorVideojuego {

	private ServicioVideojuego servicioVideojuego;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;

	@Autowired
	public ControladorVideojuego(ServicioVideojuego servicioVideojuego,
			ServicioGeneroPlataforma servicioGeneroPlataforma) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
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

		List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
		List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();

		modelo.addAttribute("datosVideojuego", videojuego);
		modelo.addAttribute("listaGeneros", generos);
		modelo.addAttribute("listaPlataformas", plataformas);

		return new ModelAndView("registro-videojuego", modelo);
	}

	@RequestMapping(path = "/registrar-videojuego", method = RequestMethod.POST)
	public ModelAndView registrarVideojuego(@ModelAttribute("datosVideojuego") Videojuego datosVideojuego) {

		/*@RequestParam("file") MultipartFile file, MultipartHttpServletRequest request*/
		Videojuego videojuego = servicioVideojuego.registrarVideojuego(datosVideojuego);

		/*Path directorioImagenes = Paths.get("src//main//webapp//images");
		String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
		try {

			byte[] bytesImg = file.getBytes();
			Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + file.getOriginalFilename());
			Files.write(rutaCompleta, bytesImg);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		videojuego.setImagen(file.getOriginalFilename());*/
		
		return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());

	}

}
