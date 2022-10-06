package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import java.util.List;
import org.hibernate.SessionFactory;
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
	public List<Pelicula> obtenerLasPeliculasPorTiempo(Integer horas) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Pelicula.class)
				.add(Restrictions.eq("duracion", horas))
				.list();
	}


	
}