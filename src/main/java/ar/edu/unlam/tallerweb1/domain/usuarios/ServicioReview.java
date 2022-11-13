package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionCalificacionVacia;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionDescripcionVacia;

public interface ServicioReview {
	
	void registrar(Review review) throws ExceptionCalificacionVacia, ExceptionDescripcionVacia;
	void modificar(Review review);
	void eliminar(Review review);
	Review getById(Integer id);
	
	Review getByUserId(Integer id);
	Review getByUserAndVideogameID(Integer userId, Integer videogameId);
	Review getByUserAndPeliculaID(Integer userId, Integer peliculaId);
	Review getByUserAndSerieID(Integer userId, Integer serieId);
	
	List<Review> getAll();
	List<Review> getAllByVideojuegoId(Integer id);
	List<Review> getAllByPeliculaId(Integer id);
	List<Review> getAllBySerieId(Integer id);
	List<Review> getAllByUserId(Integer id);

}
