package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

public interface ServicioComentario {

	void registrar(Comentario comentario);
	void eliminar(Comentario comentario);
	Comentario getById(Integer id);
	
	List<Comentario> getAllByReview(Integer id);
}
