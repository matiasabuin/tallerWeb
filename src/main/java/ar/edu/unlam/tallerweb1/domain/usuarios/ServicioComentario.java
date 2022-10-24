package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;

public interface ServicioComentario {

	void registrar(Comentario comentario);

	List<Comentario> getAllByReview(Integer id);
}
