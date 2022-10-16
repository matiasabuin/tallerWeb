package ar.edu.unlam.tallerweb1.delivery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

@Controller
public class ControladorVideojuego {

	private ServicioVideojuego servicioVideojuego;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioReview servicioReview;
	private ServletContext servletContext;

	@Autowired
	public ControladorVideojuego(ServicioVideojuego servicioVideojuego,
			ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioReview servicioReview, ServletContext servletContext) {
		this.servicioVideojuego = servicioVideojuego;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioReview = servicioReview;
		this.servletContext = servletContext;
	}

	@RequestMapping("/videojuego")
	public ModelAndView iraVideojuego(@RequestParam("id") Integer id, HttpServletRequest request) {
		
//		if (request.getSession().getAttribute("usuarioActual") != null) {
//			Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
//			usuarioBuscado.getHistorial().add(servicioVideojuego.consultarVideojuego(id));
//		}
		
		ModelMap modelo = new ModelMap();
		Videojuego videojuego = servicioVideojuego.consultarVideojuego(id);
		Review review = new Review();
		
		List<Review> reviews = servicioReview.getAllByVideojuegoId(id);
		
		modelo.addAttribute("datosReview", review);
		modelo.addAttribute("datosVideojuego", videojuego);
		modelo.addAttribute("listaReviews", reviews);
		
		return new ModelAndView("perfil-videojuego", modelo);
	}

	@RequestMapping("/registro-videojuego")
	public ModelAndView iraRegistrarVideojuego(HttpServletRequest request) {

		if (request.getSession().getAttribute("usuarioActual") != null) {

			ModelMap modelo = new ModelMap();
			Videojuego videojuego = new Videojuego();

			List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
			List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();
			
			modelo.addAttribute("datosVideojuego", videojuego);
			modelo.addAttribute("listaGeneros", generos);
			modelo.addAttribute("listaPlataformas", plataformas);

			return new ModelAndView("registro-videojuego", modelo);
		}

		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(path = "/registrar-videojuego", method = RequestMethod.POST)
	public ModelAndView registrarVideojuego(@ModelAttribute("datosVideojuego") Videojuego datosVideojuego, @RequestParam("file") MultipartFile file, 
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		if (request.getSession().getAttribute("usuarioActual") != null) {
	        
			String uploadPath = "C:\\Program Files\\Java\\proyectoWeb\\tallerWeb\\src\\main\\webapp\\images\\";
			
	        byte[] data = file.getBytes();
	        Path path = Paths.get( uploadPath + file.getOriginalFilename());
	        Files.write(path, data);
	     
	        datosVideojuego.setPoster(file.getOriginalFilename());
			
			Videojuego videojuego = servicioVideojuego.registrarVideojuego(datosVideojuego);
			
			return new ModelAndView("redirect:/videojuego?id=" + videojuego.getId());

		}
		return new ModelAndView("redirect:/home");

	}

}

//File directory = new File(path);
//String fileName = file.getOriginalFilename();
//File f = new File(directory, fileName);
//BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(f));
//byte[] data = file.getBytes();
//bufferedOutputStream.write(data);
//bufferedOutputStream.close();

// @RequestParam("file") MultipartFile file

/*
 * Path directorioImagenes = Paths.get("src//main//webapp//images"); String
 * rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath(); try {
 * 
 * byte[] bytesImg = file.getBytes(); Path rutaCompleta = Paths.get(rutaAbsoluta
 * + "//" + file.getOriginalFilename()); Files.write(rutaCompleta, bytesImg);
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * videojuego.setImagen(file.getOriginalFilename());
 */
