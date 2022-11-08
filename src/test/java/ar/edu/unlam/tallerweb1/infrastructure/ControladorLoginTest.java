package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.delivery.ControladorLogin;
import ar.edu.unlam.tallerweb1.domain.pedidos.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioHistorialUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuarioPlan;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionEmailRegistrado;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionNombreDeUsuarioRepetido;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;

//36
public class ControladorLoginTest {

	ServicioLogin servicioLogin = mock(ServicioLogin.class);
	ServicioPlan servicioPlan = mock(ServicioPlan.class);
	ServicioUsuarioPlan servicioUsuarioPlan = mock(ServicioUsuarioPlan.class);
	ServicioNotificacion servicioNoticacion = mock(ServicioNotificacion.class);
	ServicioHistorialUsuario  servicioHistorialUsuario = mock(ServicioHistorialUsuario.class);
			
	ControladorLogin controladorLogin = new ControladorLogin(servicioLogin, servicioPlan, 
			servicioUsuarioPlan, servicioNoticacion, servicioHistorialUsuario);
	
	@Test
	public void test() {
		assertEquals(1,1);
	}
	
	@Test
	public void siLosCamposDeRegistroEstanVaciosRegistroFallido() throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
		
	 givenCamposVacios();
	 
	 DatosRegistro datosRegistro = new DatosRegistro();
	 String email = datosRegistro.getEmail();
	 String password = datosRegistro.getPassword();
	 String nombre = datosRegistro.getNombre();

	 
	 doThrow(ExceptionRegistroCamposVacios.class).when(servicioLogin).registrarUsuario(
			 email, password, nombre);
	 
	 ModelAndView mav = whenRegistroUsuario(datosRegistro);
	 
	 thenRegistroFallido(mav);
	}
	
	private void givenCamposVacios() {
		
	}

	private void thenRegistroFallido(ModelAndView mav) {
		assertThat(mav.getViewName()).isEqualTo("registro-usuario");
	}

	private ModelAndView whenRegistroUsuario(DatosRegistro datosRegistro) {
		return controladorLogin.registrar(datosRegistro);
	}


	
}
