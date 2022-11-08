package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

@Repository("repositorioHistorialUsuario")
public class RepositorioHistorialUsuarioImpl implements RepositorioHistorialUsuario {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioHistorialUsuarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Historial historial) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(historial);

	}

	@Override
	public Historial obtenerHistorialDelUsuario(Integer id) {

		return (Historial) sessionFactory.getCurrentSession().createCriteria(Historial.class)
				.add(Restrictions.eq("usuario.id", id)).uniqueResult();

	}

	@Override
	public void update(Historial historial) {
		sessionFactory.getCurrentSession().update(historial);

		
	}


}