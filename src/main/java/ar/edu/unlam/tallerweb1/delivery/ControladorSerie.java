package ar.edu.unlam.tallerweb1.delivery;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Listas;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioFiles;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioGeneroPlataforma;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioListas;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioReview;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;

@Controller
public class ControladorSerie{
	
	private ServicioListas servicioFav;
	private ServicioSerie servicioSerie;
	private ServicioReview servicioReview;
	private ServicioGeneroPlataforma servicioGeneroPlataforma;
	private ServicioFiles servicioFiles;
	
	@Autowired
	public ControladorSerie(ServicioSerie servicioSerie, ServicioReview servicioReview, ServicioGeneroPlataforma servicioGeneroPlataforma, ServicioListas servicioFav,ServicioFiles servicioFiles) {
		this.servicioSerie = servicioSerie;
		this.servicioReview = servicioReview;
		this.servicioGeneroPlataforma = servicioGeneroPlataforma;
		this.servicioFav= servicioFav;
		this.servicioFiles=servicioFiles;
		
	}
	@RequestMapping(path = "/registro-serie")
	public ModelAndView iraRegistroSerie( HttpServletRequest request) {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		
		ModelMap modelo = new ModelMap();
		Serie serie = new Serie();
		
		List<Genero> generos = servicioGeneroPlataforma.obtenerGeneros();
		List<Plataforma> plataformas = servicioGeneroPlataforma.obtenerPlataformas();

		modelo.addAttribute("listaGeneros", generos);
		modelo.addAttribute("listaPlataformas", plataformas);
		modelo.put("datosSerie", serie);
		return new ModelAndView("registro-serie", modelo);
	}
	
	@InitBinder
    protected void initBinderGenero(WebDataBinder binder) throws Exception{
		List<Genero> generosCache = servicioGeneroPlataforma.obtenerGeneros();
        binder.registerCustomEditor(List.class,"generos", new CustomCollectionEditor(List.class){
            protected Object convertElement(Object element){
                if (element instanceof String) {
                    Genero generos = servicioGeneroPlataforma.getGeneroById(Integer.parseInt(element.toString()));
                    return generos;
                }
                return null;
            }
        });
    }
	
	@InitBinder
    protected void initBinderPlataforma(WebDataBinder binder) throws Exception{
		List<Plataforma> plataformasCache = servicioGeneroPlataforma.obtenerPlataformas();
        binder.registerCustomEditor(List.class,"plataformas", new CustomCollectionEditor(List.class){
            protected Object convertElement(Object element){
                if (element instanceof String) {
                    Plataforma plataformas = servicioGeneroPlataforma.getPlataformaById(Integer.parseInt(element.toString()));
                    return plataformas;
                }
                return null;
            }
        });
    }
	
	@RequestMapping(path = "/registrar-serie", method = RequestMethod.POST)
	public ModelAndView registrarSerie(@ModelAttribute("datosSerie") Serie datosSerie,@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		servicioFiles.uploadImage(file);
		
	    datosSerie.setPoster(file.getOriginalFilename());

		Serie serie = this.servicioSerie.registrarSerie(datosSerie);

		return new ModelAndView("redirect:/perfil-serie?id=" + serie.getId());
	}
	
	@RequestMapping("/perfil-serie")
	public ModelAndView VerPerfilSerie(@RequestParam("id") Integer id) {

		ModelMap modelo = new ModelMap();
		Listas fav=new Listas();		
		Review review = new Review();

		Serie serie = servicioSerie.consultarSerie(id);
		
		List<Review> reviews = servicioReview.getAllBySerieId(id);
		
		modelo.addAttribute("listaReviews", reviews);
		modelo.addAttribute("datosReview", review);
		modelo.addAttribute("datosSerie", serie);
		modelo.addAttribute("datosLista",fav);

		return new ModelAndView("perfil-serie", modelo);
	}
	
	
	
}