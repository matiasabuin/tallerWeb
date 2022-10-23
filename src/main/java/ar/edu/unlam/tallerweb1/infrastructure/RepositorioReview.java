package ar.edu.unlam.tallerweb1.infrastructure;
import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

public interface RepositorioReview {
	
	void guardar(Review review);
	void elimimar(Review review);
    Review buscar(Integer id);
	void modificar(Review review);
	
	List<Review> obtenerReviews();
	List<Review> obtenerReviewsDeVideojuegoPorId(Integer id);
	List<Review> obtenerReviewsDePeliculaPorId(Integer id);
	List<Review> obtenerReviewsDeSeriePorId(Integer id);
	List<Review> obtenerReviewsDeUsuarioPorId(Integer id);
	
	Review buscarPorUsuario(Integer id);
	Review buscarPorUsuarioyVideojuego(Integer userId, Integer videogameId);
	Review buscarPorUsuarioyPelicula(Integer userId, Integer peliculaId);
	Review buscarPorUsuarioySerie(Integer userId, Integer serieId);

}
