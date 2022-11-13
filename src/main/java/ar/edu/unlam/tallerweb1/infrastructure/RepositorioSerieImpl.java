package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
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

	@Override
	public List<Serie> obtenerLasSeriesPorTiempo(Integer horas) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Serie.class)
				.add(Restrictions.between("duracion", 0, horas))
				.list();
	}

	@Override
	public List<Serie> obtenerLasSeriesPorBusqueda(String busqueda) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Serie.class)
				.add(Restrictions.ilike("nombre", busqueda, MatchMode.ANYWHERE))
				.list();
	}
	
	
	@Override
	public void modificar(Serie datosSerie) {
		sessionFactory.getCurrentSession().update(datosSerie);
	}

	

}
