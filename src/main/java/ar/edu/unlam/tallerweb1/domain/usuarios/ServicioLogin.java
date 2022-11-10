package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionEmailRegistrado;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionNombreDeUsuarioRepetido;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {
	
	Usuario consultarUsuario(String email, String password);
	Usuario registrarUsuario(String email, String password, String nombre) throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios;
	void editarPerfil(Usuario usuario);
	List<Usuario> obtenerTodosLosUsarios();
	Usuario getById(Integer id);

}
