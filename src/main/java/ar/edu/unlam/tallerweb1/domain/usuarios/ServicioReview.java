package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

public interface ServicioReview {
	
	void registrar(Review review);
	void modificar(Review review);
	void eliminar(Review review);
	Review getById(Integer id);
	
	List<Review> getAll();
	List<Review> getAllByVideojuegoId(Integer id);
	List<Review> getAllByPeliculaId(Integer id);
	List<Review> getAllBySerieId(Integer id);
	List<Review> getAllByUserId(Integer id);

}
