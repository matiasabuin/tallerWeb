package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.pedidos.DatosLogin;
import ar.edu.unlam.tallerweb1.domain.pedidos.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuarioPlan;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionEmailRegistrado;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionNombreDeUsuarioRepetido;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ControladorLogin {

	// La anotacion @Autowired indica a Spring que se debe utilizar el contructor
	// como mecanismo de inyección de dependencias,
	// es decir, qeue lo parametros del mismo deben ser un bean de spring y el
	// framewrok automaticamente pasa como parametro
	// el bean correspondiente, en este caso, un objeto de una clase que implemente
	// la interface ServicioLogin,
	// dicha clase debe estar anotada como @Service o @Repository y debe estar en un
	// paquete de los indicados en
	// applicationContext.xml
	private ServicioLogin servicioLogin;
	private ServicioPlan servicioPlan;
	private ServicioUsuarioPlan servicioUsuarioPlan;
	private ServicioNotificacion servicioNotificacion;
	private ServicioHistorialUsuario servicioHistorial;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioPlan servicioPlan, 
			ServicioUsuarioPlan servicioUsuarioPlan, ServicioNotificacion servicioNoticacion,
			ServicioHistorialUsuario servicioHistorial){
		
		this.servicioLogin = servicioLogin;
		this.servicioPlan= servicioPlan;
		this.servicioUsuarioPlan = servicioUsuarioPlan;
		this.servicioNotificacion = servicioNoticacion;
		this.servicioHistorial=servicioHistorial;
	}

	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es
	// invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") != null) {
			return new ModelAndView("redirect:/home");
		}
		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto con key 'datosLogin' para que el mismo sea
		// asociado
		// al model attribute del form que esta definido en la vista 'login'
		modelo.put("datosLogin", new DatosLogin());
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando
		// el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con
	// metodo http POST
	// El metodo recibe un objeto Usuario el que tiene los datos ingresados en el
	// form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) {
		ModelMap model = new ModelMap();

		// invoca el metodo consultarUsuario del servicio y hace un redirect a la URL
		// /home, esto es, en lugar de enviar a una vista
		// hace una llamada a otro action a traves de la URL correspondiente a esta

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());

		if (usuarioBuscado != null) {

			request.getSession().setAttribute("usuarioActual", usuarioBuscado);
			
			if(!usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion().equals("Free")
					&& LocalDate.now().isAfter(usuarioBuscado.getPlanAdquirido().getFechaVencimiento())) {
				
				Notificacion notificacion = new Notificacion();
				notificacion.setUsuario(usuarioBuscado);
				notificacion.setMensaje("Tu plan " + usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion() 
						+  " venció el dia " + usuarioBuscado.getPlanAdquirido().getFechaVencimiento());
				servicioNotificacion.registrar(notificacion);
				
				Plan planFree = servicioPlan.ObtenerPlanFree();
				UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planFree,
											(usuarioBuscado.getPlanAdquirido().getFechaVencimiento()));
				usuarioBuscado.setPlanAdquirido(usuarioplan);
				servicioLogin.editarPerfil(usuarioBuscado);
				request.getSession().setAttribute("usuarioPlan", usuarioplan);
			} 
		
			Integer cantNotificacionesNoLeidas = servicioNotificacion.getAllByUserId(usuarioBuscado.getId()).size();
			request.getSession().setAttribute("cantNotificaciones", cantNotificacionesNoLeidas);
			return new ModelAndView("redirect:/home");
			
		} else {
//			 si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	


	@RequestMapping(path = "/cerrar-sesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/home");
	}

	// Escucha la url /, y redirige a la URL /login, es lo mismo que si se invoca la
	// url /login directamente.
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ModelAndView registrar(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro) {
		
		ModelMap modelo = new ModelMap();
		
		try {
			Usuario usuario = servicioLogin.registrarUsuario(
								datosRegistro.getEmail(), 
								datosRegistro.getPassword(),
								datosRegistro.getNombre());
			Plan planBuscado = servicioPlan.ObtenerPlanFree();
			UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario, planBuscado, LocalDate.now().minusDays(1));
			usuario.setPlanAdquirido(usuarioplan);
			servicioLogin.editarPerfil(usuario);
			servicioHistorial.registrarHistorial(usuario);
			usuario.setHistorialUsuario(servicioHistorial.getByUserId(usuario.getId()));
		} catch (ExceptionRegistroCamposVacios e){
			return registroFallidoCampos(datosRegistro, modelo, e);
		} catch (ExceptionNombreDeUsuarioRepetido e) {
			return registroFallidoNombre(datosRegistro, modelo, e);
		} catch (ExceptionEmailRegistrado e) {
			return registroFallidoEmail(datosRegistro, modelo, e);
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/registro-usuario")
	public ModelAndView registrarUsuario(HttpServletRequest request) {
		if (request.getSession().getAttribute("usuarioActual") != null) {
			return new ModelAndView("redirect:/home");
		}
		
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", new Usuario());
		return new ModelAndView("registro-usuario", modelo);
	}
	
	private ModelAndView registroFallidoEmail(DatosRegistro datosRegistro, ModelMap modelo,
			ExceptionEmailRegistrado e) {
		modelo.put("errorEmail", e.getMessage());
		modelo.put("usuario", datosRegistro);
		return new ModelAndView("registro-usuario", modelo);
	}

	private ModelAndView registroFallidoNombre(DatosRegistro datosRegistro, ModelMap modelo,
			ExceptionNombreDeUsuarioRepetido e) {
		modelo.put("errorNombre", e.getMessage());
		modelo.put("usuario", datosRegistro);
		return new ModelAndView("registro-usuario", modelo);
	}

	private ModelAndView registroFallidoCampos(DatosRegistro datosRegistro, ModelMap modelo,
			ExceptionRegistroCamposVacios e) {
		modelo.put("errorCampos", e.getMessage());
		modelo.put("usuario", datosRegistro);
		return new ModelAndView("registro-usuario", modelo);
	}
	
}