package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

@Repository("repositorioFavoritos")
public class RepositorioFavoritosImpl implements RepositorioFavoritos {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioFavoritosImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Favorito> obtenerFavoritos() {
		return sessionFactory.getCurrentSession().createCriteria(Favorito.class).list();

	}

	@Override
	public Favorito buscar(Integer id) {
		return (Favorito) sessionFactory.getCurrentSession().createCriteria(Favorito.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardar(Favorito fav) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(fav);
	}

	@Override
	public void eliminar(Favorito lista) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().remove(lista);
	}

	@Override
	public List<Favorito> obtenerListasDelUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Favorito.class).add(Restrictions.eq("usuario.id", id)).list();	
		}


}
