package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionCalificacionVacia;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionDescripcionVacia;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioReview;

@Service("servicioReview")
@Transactional
public class ServicioReviewImpl implements ServicioReview {

	private RepositorioReview servicioReviewDao;

	@Autowired
	public ServicioReviewImpl(RepositorioReview servicioReviewDao){
		this.servicioReviewDao = servicioReviewDao;
	}
	
	@Override
	public void registrar(Review review) throws ExceptionCalificacionVacia, ExceptionDescripcionVacia {
		
		if(review.getCalificacion() == null) {
			throw new ExceptionCalificacionVacia("Por favor seleccionar una calificacion");
		}
		
		if(review.getDescripcion().isEmpty()) {
			throw new ExceptionDescripcionVacia("Debe escribir una review");
		}
		
		servicioReviewDao.guardar(review);
	}

	@Override
	public void modificar(Review review) {
		servicioReviewDao.modificar(review);
	}

	@Override
	public void eliminar(Review review) {
		servicioReviewDao.elimimar(review);
	}

	@Override
	public Review getById(Integer id) {
		return servicioReviewDao.buscar(id);
	}
	
	@Override
	public Review getByUserId(Integer id) {
		return servicioReviewDao.buscarPorUsuario(id);
	}

	@Override
	public List<Review> getAll() {
		return servicioReviewDao.obtenerReviews();
	}
	
	public List<Review> getAllByVideojuegoId(Integer id) {
		return servicioReviewDao.obtenerReviewsDeVideojuegoPorId(id);
	}
	
	public List<Review> getAllByPeliculaId(Integer id) {
		return servicioReviewDao.obtenerReviewsDePeliculaPorId(id);
	}

	@Override
	public List<Review> getAllBySerieId(Integer id) {
		return servicioReviewDao.obtenerReviewsDeSeriePorId(id);
	}

	@Override
	public List<Review> getAllByUserId(Integer id) {
		return servicioReviewDao.obtenerReviewsDeUsuarioPorId(id);
	}

	@Override
	public Review getByUserAndVideogameID(Integer userId, Integer videogameId) {
		Review review;
		if(servicioReviewDao.buscarPorUsuarioyVideojuego(userId, videogameId) != null) {
			review = servicioReviewDao.buscarPorUsuarioyVideojuego(userId, videogameId);
		} else {
			review = new Review();
		}
		return review;
	}

	@Override
	public Review getByUserAndPeliculaID(Integer userId, Integer peliculaId) {
		Review review;
		if(servicioReviewDao.buscarPorUsuarioyPelicula(userId, peliculaId) != null) {
			review = servicioReviewDao.buscarPorUsuarioyPelicula(userId, peliculaId);
		} else {
			review = new Review();
		}
		return review;
	}

	@Override
	public Review getByUserAndSerieID(Integer userId, Integer serieId) {
		Review review;
		if(servicioReviewDao.buscarPorUsuarioySerie(userId, serieId) != null) {
			review = servicioReviewDao.buscarPorUsuarioySerie(userId, serieId);
		} else {
			review = new Review();
		}
		return review;
	}

}
