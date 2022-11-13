package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioPelicula")
public class RepositorioPeliculaImpl implements RepositorioPelicula {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioPeliculaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Pelicula pelicula) {
		sessionFactory.getCurrentSession().save(pelicula);
	}

	@Override
	public Pelicula buscar(Integer id) {
		return (Pelicula) sessionFactory.getCurrentSession().createCriteria(Pelicula.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public List<Pelicula> obtenerTodasLasPeliculas() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Pelicula.class)
                .list();
	}

	@Override
	public List<Pelicula> obtenerLasPeliculasPorTiempo(Integer minutos) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Pelicula.class)
				.add(Restrictions.between("duracion", 0, minutos))
				.list();
	}

	@Override
	public List<Pelicula> obtenerLasPeliculasPorBusqueda(String busqueda) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Pelicula.class)
				.add(Restrictions.ilike("nombre", busqueda, MatchMode.ANYWHERE))
				.list();
	}

	@Override
	public void modificar(Pelicula datosPelicula) {
		sessionFactory.getCurrentSession().update(datosPelicula);
	}


	
}