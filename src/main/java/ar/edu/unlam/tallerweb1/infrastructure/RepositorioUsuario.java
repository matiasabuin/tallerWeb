package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Usuario buscarUsuario(String email, String password);
	void guardar(Usuario usuario);
    Usuario buscar(String email);
	void modificar(Usuario usuario);
	List<Usuario> obtenerTodosLosUsarios();
	Usuario getById(Integer id);
	
	Usuario findByName(String name);
	Usuario findByEmail(String email);
}
