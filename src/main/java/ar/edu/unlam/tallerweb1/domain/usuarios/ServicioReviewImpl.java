package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
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
	public void registrar(Review review) {
		servicioReviewDao.guardar(review);;
	}

	@Override
	public void modificar(Review review) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(Review review) {
		// TODO Auto-generated method stub
	}

	@Override
	public Review getById(Integer id) {
		return servicioReviewDao.buscar(id);
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

}
