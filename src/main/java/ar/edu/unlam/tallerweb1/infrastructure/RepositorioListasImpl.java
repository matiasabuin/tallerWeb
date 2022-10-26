package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Lista;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

@Repository("repositorioFavoritos")
public class RepositorioListasImpl implements RepositorioListas {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioListasImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Lista> obtenerFavoritos() {
		return sessionFactory.getCurrentSession().createCriteria(Lista.class).list();

	}

	@Override
	public Lista buscar(Integer id) {
		return (Lista) sessionFactory.getCurrentSession().createCriteria(Lista.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardar(Lista fav) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(fav);
	}

	@Override
	public void eliminar(Lista lista) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().remove(lista);
	}

	@Override
	public List<Lista> obtenerListasDelUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(Lista.class).add(Restrictions.eq("usuario.id", id)).list();	
		}


}
