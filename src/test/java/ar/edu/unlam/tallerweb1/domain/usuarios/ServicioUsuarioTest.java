package ar.edu.unlam.tallerweb1.domain.usuarios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.domain.pedidos.DatosRegistro;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionEmailRegistrado;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionNombreDeUsuarioRepetido;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

public class ServicioUsuarioTest {

	RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
	ServicioLogin servicioLogin = new ServicioLoginImpl(repositorioUsuario);
	
	@Test
	public void siTodoLosDatosSonCorrectosElRegistroEsExitoso() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro = new DatosRegistro("matias@gmail.com","123","matias");
		
		Usuario usuario = whenRegistroUsuario(datosRegistro);
		 
		thenRegistroExitoso(usuario);
	}
	
	@Test(expected = ExceptionRegistroCamposVacios.class)
	public void siHayCamposVaciosElRegistroFalla() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro = new DatosRegistro("","","");
		
		whenRegistroUsuario(datosRegistro);
		 
		thenRegistroFallido();
	}
	
	@Test(expected = ExceptionNombreDeUsuarioRepetido.class)
	public void siElNombreDeUsuarioEsRepetidoElRegistroFalla() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro = new DatosRegistro("matias@gmail.com","123","matias");
		
		DatosRegistro datosRegistro2 = new DatosRegistro("matias@gmail.com","123","matias123");
		
		givenExisteUsuario(datosRegistro);
		
		when(repositorioUsuario.findByName(datosRegistro2.getNombre())).thenReturn(new Usuario());
		
		whenRegistroUsuario(datosRegistro2);
		 
		thenRegistroFallido();
	}
	
	@Test(expected = ExceptionEmailRegistrado.class)
	public void siElMailEsRepetidoElRegistroFalla() 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios{
	
		DatosRegistro datosRegistro = new DatosRegistro("matias123@gmail.com","123","matias");
		
		DatosRegistro datosRegistro2 = new DatosRegistro("matias@gmail.com","123","matias");
		
		givenExisteUsuario(datosRegistro);
		
		when(repositorioUsuario.findByEmail(datosRegistro2.getEmail())).thenReturn(new Usuario());
		
		whenRegistroUsuario(datosRegistro2);
		 
		thenRegistroFallido();
	}

	private Usuario whenRegistroUsuario(DatosRegistro datosRegistro) 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios {
		
		String email = datosRegistro.getEmail();
		String password = datosRegistro.getPassword();
		String nombre = datosRegistro.getNombre();
		
		return servicioLogin.registrarUsuario(email, password, nombre);
	}

	private void givenExisteUsuario(DatosRegistro datosRegistro) 
			throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios {
		String email = datosRegistro.getEmail();
		String password = datosRegistro.getPassword();
		String nombre = datosRegistro.getNombre();
		
		servicioLogin.registrarUsuario(email, password, nombre);
	}
	
	private void thenRegistroFallido() {
	}

	private void thenRegistroExitoso(Usuario usuario) {
		assertThat(usuario).isNotNull();
		verify(repositorioUsuario, times(1)).guardar(usuario);
	}
	
}
