package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Solicitud;

@Repository("repositorioSolicitud")
public class RepositorioSolicitudImpl implements RepositorioSolicitud{
	
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioSolicitudImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void registrar(Solicitud solicitud) {
		sessionFactory.getCurrentSession().save(solicitud);
	}

	@Override
	public void modificar(Solicitud solicitud) {
		sessionFactory.getCurrentSession().update(solicitud);
	}

	@Override
	public Solicitud getByUsers(Integer user1, Integer user2) {
		return (Solicitud)sessionFactory.getCurrentSession()
				.createCriteria(Solicitud.class)
				.add(Restrictions.eq("usuario1.id", user1))
				.add(Restrictions.eq("usuario2.id", user2))
				.uniqueResult();
	}

	@Override
	public void eliminar(Solicitud solicitud) {
		sessionFactory.getCurrentSession().remove(solicitud);
	}

}
