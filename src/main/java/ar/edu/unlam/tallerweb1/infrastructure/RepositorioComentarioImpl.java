package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;

@Repository("repositorioComentario")
public class RepositorioComentarioImpl implements RepositorioComentario {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioComentarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void guardar(Comentario comentario) {
		sessionFactory.getCurrentSession().save(comentario);
	}

	@Override
	public List<Comentario> obtenerComentarios(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Comentario.class)
				.add(Restrictions.eq("review.id", id))
				.list();
	}
	
	@Override
	public Comentario buscar(Integer id) {
		return (Comentario) sessionFactory.getCurrentSession().createCriteria(Comentario.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void elimimar(Comentario comentario) {
		sessionFactory.getCurrentSession().remove(comentario);
	}

	@Override
	public void modificar(Comentario comentario) {
		sessionFactory.getCurrentSession().update(comentario);
	}

	@Override
	public List<Comentario> obtenerComentariosUsuario(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Comentario.class)
				.add(Restrictions.eq("usuario.id", id))
				.list();
	}
	
}
