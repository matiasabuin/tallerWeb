package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

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
	public Review buscarPorUsuario(Integer id) {
		return (Review) sessionFactory.getCurrentSession().createCriteria(Review.class).add(Restrictions.eq("usuario.id", id))
				.uniqueResult();
	}

	@Override
	public void modificar(Review review) {
		sessionFactory.getCurrentSession().update(review);
	}
	
	@Override
	public void elimimar(Review review) {
		sessionFactory.getCurrentSession().remove(review);
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
	
	@Override
	public List<Review> obtenerReviewsDePeliculaPorId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("pelicula.id", id))
				.list();
	}

	@Override
	public List<Review> obtenerReviewsDeSeriePorId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("serie.id", id))
				.list();
	}

	@Override
	public List<Review> obtenerReviewsDeUsuarioPorId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("usuario.id", id))
				.list();
	}

	@Override
	public Review buscarPorUsuarioyVideojuego(Integer userId, Integer videogameId) {
		return (Review) sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("usuario.id", userId))
				.add(Restrictions.eq("videojuego.id", videogameId))
				.uniqueResult();
	}

	@Override
	public Review buscarPorUsuarioyPelicula(Integer userId, Integer peliculaId) {
		return (Review) sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("usuario.id", userId))
				.add(Restrictions.eq("pelicula.id", peliculaId))
				.uniqueResult();
	}

	@Override
	public Review buscarPorUsuarioySerie(Integer userId, Integer serieId) {
		return (Review) sessionFactory.getCurrentSession()
				.createCriteria(Review.class)
				.add(Restrictions.eq("usuario.id", userId))
				.add(Restrictions.eq("serie.id", serieId))
				.uniqueResult();
	}

}
