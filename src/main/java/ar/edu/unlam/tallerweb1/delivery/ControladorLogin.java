package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.pedidos.DatosLogin;
import ar.edu.unlam.tallerweb1.domain.pedidos.DatosPelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private ServicioPelicula servicioPelicula;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioPelicula servicioPelicula){
		this.servicioLogin = servicioLogin;
		this.servicioPelicula = servicioPelicula;
	}
	

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a esta
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			
			request.getSession().setAttribute("usuarioActual", usuarioBuscado.getNombre());
			
			request.getSession().getAttribute("usuarioActual");
			
			// request.getSession().setAttribute("usuarios", servicioLogin.obtenerTodosLosUsarios());
			
			
			return new ModelAndView("redirect:/home");
		} else {
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	// Escucha la URL /home por GET, y redirige a una vista.
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView registrar(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {

		servicioLogin.registrarUsuario(datosRegistro.getEmail(), datosRegistro.getPassword(), datosRegistro.getNombre());

		return irALogin();
	}
	
	@RequestMapping("/registro-usuario")
	public ModelAndView registrarUsuario() {

		ModelMap modelo = new ModelMap();
		modelo.put("usuario", new Usuario());
		return new ModelAndView("registro-usuario", modelo);
	}
	
	@RequestMapping("/perfil")
	public ModelAndView irAPerfil(HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		return new ModelAndView("perfilUsuario", modelo);
		
	}
	
	@RequestMapping(path = "/perfil-fvs")
	public ModelAndView VerPerfilPeli() {
		return new ModelAndView("perfil-fvs");
	}
	
	@RequestMapping(path = "/registro-peli-serie")
	public ModelAndView RegistroPeliSerie() {
		
		ModelMap modelo = new ModelMap();
		modelo.put("pelicula", new Pelicula());
		return new ModelAndView("registro-peli-serie", modelo);
	}
	
	@RequestMapping(path = "/perfilUsuario", method = RequestMethod.POST)
	public ModelAndView registrarPelicula(@ModelAttribute("datosPelicula") DatosPelicula datosPelicula, HttpServletRequest request) {
		
		this.servicioPelicula.registrarPelicula(datosPelicula.getNombre());
		
		request.getSession().setAttribute("peliculas", servicioPelicula.obtenerTodasLasPeliculas());
		return irAHome();
	}
	
	
}
