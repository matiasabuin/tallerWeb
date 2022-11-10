package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Amigo;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public interface ServicioAmigos {

	void registar(Amigo amigo);
	List<Usuario> getAllByUser(Integer id);
}
