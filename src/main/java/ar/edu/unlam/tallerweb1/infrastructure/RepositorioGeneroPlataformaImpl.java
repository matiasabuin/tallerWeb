package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;

@Repository("repositorioGeneroPlataforma")
public class RepositorioGeneroPlataformaImpl implements RepositorioGeneroPlataforma {
	
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioGeneroPlataformaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardarGenero(Genero genero) {
		sessionFactory.getCurrentSession().save(genero);
	}

	@Override
	public void guardarPlataforma(Plataforma plataforma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarGenero(Genero genero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPlataforma(Plataforma plataforma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Genero> obtenerGeneros() {
        return (List<Genero>) sessionFactory.getCurrentSession().createCriteria(Genero.class).list();       
	}

	public List<Plataforma> obtenerPlataformas() {
		return (List<Plataforma>) sessionFactory.getCurrentSession().createCriteria(Plataforma.class).list();
	}

	public Genero getByDesc(String descripcion) {
		final Session session = sessionFactory.getCurrentSession();
		return (Genero) session.createCriteria(Genero.class)
				.add(Restrictions.eq("descripcion", descripcion))
				.uniqueResult();
	}


	public Genero getGeneroById(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Genero) session.createCriteria(Genero.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}


	public Plataforma getPlataformaById(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Plataforma) session.createCriteria(Plataforma.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

}
