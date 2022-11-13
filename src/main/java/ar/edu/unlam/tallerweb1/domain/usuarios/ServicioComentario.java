package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionDescripcionVacia;

public interface ServicioComentario {

	void registrar(Comentario comentario) throws ExceptionDescripcionVacia;
	void eliminar(Comentario comentario);
	void modificar(Comentario comentarioEncontrado);
	Comentario getById(Integer id);
	List<Comentario> getAllByReview(Integer id);
	List<Comentario> getAllByUser(Integer id);
}
