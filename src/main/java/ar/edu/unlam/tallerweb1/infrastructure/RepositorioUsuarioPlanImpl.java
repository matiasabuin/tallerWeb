package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuarioPlan")
public class RepositorioUsuarioPlanImpl implements RepositorioUsuarioPlan {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioUsuarioPlanImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(UsuarioPlan usuarioPlan) {
		sessionFactory.getCurrentSession().save(usuarioPlan);
	}
}