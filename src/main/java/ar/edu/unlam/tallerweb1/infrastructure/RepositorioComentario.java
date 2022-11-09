package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

public interface RepositorioComentario {

	void guardar(Comentario comentario);
	void elimimar(Comentario comentario);
	void modificar(Comentario comentarioEncontrado);
	Comentario buscar(Integer id);
	List<Comentario> obtenerComentarios(Integer id);
	List<Comentario> obtenerComentariosUsuario(Integer id);
}
