package ar.edu.unlam.tallerweb1.delivery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.pedidos.DatosRegistro;
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

public class ControladorUsuarioTest {

	ServicioLogin servicioLogin = mock(ServicioLogin.class);
	ServicioPlan servicioPlan = mock(ServicioPlan.class);
	ServicioUsuarioPlan servicioUsuarioPlan = mock(ServicioUsuarioPlan.class);
	ServicioNotificacion servicioNoticacion = mock(ServicioNotificacion.class);
	ServicioHistorialUsuario servicioHistorialUsuario = mock(ServicioHistorialUsuario.class);
	
	ControladorLogin controladorLogin = new ControladorLogin(servicioLogin, servicioPlan, 
			servicioUsuarioPlan, servicioNoticacion, servicioHistorialUsuario);
	
	@Test
	public void siTodoLosDatosSonCorrectosElRegistroEsExitoso() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro1 = new DatosRegistro("matias@gmail.com","123","matias");
		String email1 = datosRegistro1.getEmail();
		String password1 = datosRegistro1.getPassword();
		String nombre1 = datosRegistro1.getNombre();	
		
		when(servicioLogin.registrarUsuario(email1, password1, nombre1)).thenReturn(new Usuario());
		Usuario usuario = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario, planBuscado, LocalDate.now().minusDays(1));
	
		usuario.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuario);
		
		ModelAndView mav = whenRegistroUsuario(datosRegistro1);
		 
		thenRegistroExitoso(mav);
	}
	
	@Test
	public void siLosCamposDeRegistroEstanVaciosRegistroFallido() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
		
		DatosRegistro datosRegistro1 = new DatosRegistro();
		String email1 = datosRegistro1.getEmail();
		String password1 = datosRegistro1.getPassword();
		String nombre1 = datosRegistro1.getNombre();	
		
		when(servicioLogin.registrarUsuario(email1, password1, nombre1)).thenReturn(new Usuario());
		Usuario usuario = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario, planBuscado, LocalDate.now().minusDays(1));

		usuario.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuario);
		
		doThrow(ExceptionRegistroCamposVacios.class).when(servicioLogin).registrarUsuario(email1, password1, nombre1);
		
		ModelAndView mav = whenRegistroUsuario(datosRegistro1);

		thenRegistroFallido(mav);
	}
	
	@Test
	public void siElNombreDeUsuarioEsRepetidoElRegistroFalla() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro1 = new DatosRegistro("matias@gmail.com","123","matias");
		String email1 = datosRegistro1.getEmail();
		String password1 = datosRegistro1.getPassword();
		String nombre1 = datosRegistro1.getNombre();	
			
		DatosRegistro datosRegistro2 = new DatosRegistro("matias@gmail.com","123","matias");
		String email2 = datosRegistro2.getEmail();
		String password2 = datosRegistro2.getPassword();
		String nombre2 = datosRegistro2.getNombre();
		
		when(servicioLogin.registrarUsuario(email1, password1, nombre1)).thenReturn(new Usuario());
		when(servicioLogin.registrarUsuario(email2, password2, nombre2)).thenReturn(new Usuario());

		Usuario usuario1 = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado1 = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan1 = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario1, planBuscado1, LocalDate.now().minusDays(1));

		usuario1.setPlanAdquirido(usuarioplan1);
		servicioLogin.editarPerfil(usuario1);
		
		Usuario usuario2 = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado2 = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan2 = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario2, planBuscado2, LocalDate.now().minusDays(1));

		usuario1.setPlanAdquirido(usuarioplan2);
		servicioLogin.editarPerfil(usuario2);
		
		doThrow(ExceptionNombreDeUsuarioRepetido.class).when(servicioLogin).registrarUsuario(email2, password2, nombre2);
		 
		ModelAndView mav = whenRegistroUsuario(datosRegistro2);
		 
		thenRegistroFallido(mav);
	}
	
	@Test
	public void siElMailYaEstaRegistradoElRegistroFalla() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro1 = new DatosRegistro("matias@gmail.com","123","matias");
		String email1 = datosRegistro1.getEmail();
		String password1 = datosRegistro1.getPassword();
		String nombre1 = datosRegistro1.getNombre();	
			
		DatosRegistro datosRegistro2 = new DatosRegistro("matias@gmail.com","123","matias");
		String email2 = datosRegistro2.getEmail();
		String password2 = datosRegistro2.getPassword();
		String nombre2 = datosRegistro2.getNombre();
		
		when(servicioLogin.registrarUsuario(email1, password1, nombre1)).thenReturn(new Usuario());
		when(servicioLogin.registrarUsuario(email2, password2, nombre2)).thenReturn(new Usuario());
	
		Usuario usuario1 = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado1 = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan1 = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario1, planBuscado1, LocalDate.now().minusDays(1));
	
		usuario1.setPlanAdquirido(usuarioplan1);
		servicioLogin.editarPerfil(usuario1);
		
		Usuario usuario2 = servicioLogin.registrarUsuario(email1, password1, nombre1);
		
		Plan planBuscado2 = servicioPlan.ObtenerPlanFree();
		UsuarioPlan usuarioplan2 = servicioUsuarioPlan.registrarUsuarioPlan
					(usuario2, planBuscado2, LocalDate.now().minusDays(1));
	
		usuario1.setPlanAdquirido(usuarioplan2);
		servicioLogin.editarPerfil(usuario2);
		
		doThrow(ExceptionEmailRegistrado.class).when(servicioLogin).registrarUsuario(email2, password2, nombre2);
		 
		ModelAndView mav = whenRegistroUsuario(datosRegistro2);
		 
		thenRegistroFallido(mav);
	}
	
	private void thenRegistroFallido(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
	}
	
	private void thenRegistroExitoso(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
	}
	
	private ModelAndView whenRegistroUsuario(DatosRegistro datosRegistro) {
		return controladorLogin.registrar(datosRegistro);
	}


	
}
