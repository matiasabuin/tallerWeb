package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

@Repository("repositorioReview")
public class RepositorioReviewImpl implements RepositorioReview {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioReviewImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Review review) {
		sessionFactory.getCurrentSession().save(review);
	}

	@Override
	public Review buscar(Integer id) {
		return (Review) sessionFactory.getCurrentSession().createCriteria(Review.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Review review) {
		sessionFactory.getCurrentSession().update(review);
	}

	@Override
	public List<Review> obtenerReviews() {
		return sessionFactory.getCurrentSession().createCriteria(Review.class).list();
	}

	@Override
	public List<Review> obtenerReviewsDeVideojuegoPorId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("videojuego.id", id))
				.list();
	}
	
	public List<Review> obtenerReviewsDePeliculaPorId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("pelicula.id", id))
				.list();
	}


}
