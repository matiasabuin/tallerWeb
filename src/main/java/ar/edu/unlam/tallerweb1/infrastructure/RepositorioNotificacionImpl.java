package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;

@Repository("repositorioNotificacion")
public class RepositorioNotificacionImpl implements RepositorioNotificacion {
	
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioNotificacionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().save(notificacion);
	}

	@Override
	public Notificacion getById(Integer id) {
		return (Notificacion) sessionFactory.getCurrentSession().createCriteria(Notificacion.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	
	@Override
	public void editar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().update(notificacion);
	}

	@Override
	public void eliminar(Notificacion notificacion) {
		sessionFactory.getCurrentSession().remove(notificacion);
	}

	@Override
	public List<Notificacion> getAllByUserId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Notificacion.class)
				.add(Restrictions.eq("usuario.id", id))
				.add(Restrictions.isNull("leido"))
				.list();
	}

	@Override
	public List<Notificacion> getAllLeidosByUserId(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Notificacion.class)
				.add(Restrictions.eq("usuario.id", id))
				.add(Restrictions.isNotNull("leido"))
				.list();
	}

}
