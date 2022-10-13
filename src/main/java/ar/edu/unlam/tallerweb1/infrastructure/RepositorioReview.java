package ar.edu.unlam.tallerweb1.infrastructure;
import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

public interface RepositorioReview {
	
	void guardar(Review review);
    Review buscar(Integer id);
	void modificar(Review review);
	List<Review> obtenerReviews();
	List<Review> obtenerReviewsDeVideojuegoPorId(Integer id);
	List<Review> obtenerReviewsDePeliculaPorId(Integer id);

}
