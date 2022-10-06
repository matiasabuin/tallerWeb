package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;

@Repository("repositorioSerie")
public class RepositorioSerieImpl implements RepositorioSerie {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioSerieImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public void guardar(Serie serie) {
      this.sessionFactory.getCurrentSession().save(serie);	
	}

	@Override
	public Serie buscar(Integer id) {
		
		return (Serie)this.sessionFactory.getCurrentSession().createCriteria(Serie.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		
	}

	@Override
	public List<Serie> obtenerTodasLasSeries() {
		// TODO Auto-generated method stub
	     return sessionFactory.getCurrentSession()
	                .createCriteria(Serie.class)
	                .list();
	}
	
	
	
	

}
