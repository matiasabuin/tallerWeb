package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);

	Usuario registrarUsuario(String email, String password, String nombre);
	
	List<Usuario> obtenerTodosLosUsarios();

	void editarPerfil(Usuario usuario);
	
	Usuario getById(Integer id);
}
