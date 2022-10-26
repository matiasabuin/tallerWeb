package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;

public interface RepositorioComentario {

	void guardar(Comentario comentario);

	List<Comentario> obtenerComentarios(Integer id);

}
