package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Amigo;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

@Repository("repositorioAmigos")
public class RepositorioAmigosImpl implements RepositorioAmigos{
	
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioAmigosImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Usuario> getAllByUser(Integer id) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Amigo.class)
				.add(Restrictions.eq("usuario.id", id))
				.list();
	}

	@Override
	public void registrar(Amigo amigo) {
		sessionFactory.getCurrentSession().save(amigo);
	}

}
