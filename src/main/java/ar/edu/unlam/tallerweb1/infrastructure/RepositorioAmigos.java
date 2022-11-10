package ar.edu.unlam.tallerweb1.infrastructure;
import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Amigo;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public interface RepositorioAmigos {

	List<Usuario> getAllByUser(Integer id);
	void registrar(Amigo amigo);
}
