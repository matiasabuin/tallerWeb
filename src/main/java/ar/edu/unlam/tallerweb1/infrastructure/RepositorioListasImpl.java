package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Listas;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

@Repository("repositorioFavoritos")
public class RepositorioListasImpl implements RepositorioListas {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioListasImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Listas> obtenerFavoritos() {
		return sessionFactory.getCurrentSession().createCriteria(Listas.class).list();

	}

	@Override
	public Listas buscar(Integer id) {
		return (Listas) sessionFactory.getCurrentSession().createCriteria(Listas.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardar(Listas fav) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(fav);
	}

	@Override
	public Videojuego buscarVideojuegoId(Integer id) {
		// TODO Auto-generated method stub

		final Session session = sessionFactory.getCurrentSession();
		return (Videojuego) session.createCriteria(Listas.class).add(Restrictions.eq("videojuego.id", id))
				.uniqueResult();

	}

	@Override
	public Pelicula buscarPeliculaId(Integer id) {
		// TODO Auto-generated method stub
		return (Pelicula) this.sessionFactory.getCurrentSession().createCriteria(Listas.class)
				.add(Restrictions.eq("videojuego.id", id)).uniqueResult();
	}

	@Override
	public Serie buscarSerieId(Integer id) {
		// TODO Auto-generated method stub
		return (Serie) this.sessionFactory.getCurrentSession().createCriteria(Listas.class)
				.add(Restrictions.eq("videojuego.id", id)).uniqueResult();
	}

	@Override
	public void eliminar(Listas lista) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(lista);

	}

}
