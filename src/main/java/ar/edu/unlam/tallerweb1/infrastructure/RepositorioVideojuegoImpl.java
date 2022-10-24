package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

@Repository("repositorioVideojuego")
public class RepositorioVideojuegoImpl implements RepositorioVideojuego {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioVideojuegoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
    @Override
	public Videojuego buscar(Integer id) {
		return (Videojuego) sessionFactory.getCurrentSession().createCriteria(Videojuego.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void guardar(Videojuego videojuego) {
		sessionFactory.getCurrentSession().save(videojuego);
	}

	@Override
	public void modificar(Videojuego videojuego) {
		sessionFactory.getCurrentSession().update(videojuego);
	}

	@Override
	public List<Videojuego> obtenerTodosLosVideojuegos() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Videojuego.class)
                .list();
	}

	@Override
	public List<Videojuego> obtenerLosVideojuegosPorTiempo(Integer horas) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Videojuego.class)
				.add(Restrictions.eq("duracion", horas))
				.list();
	}

	@Override
	public List<Videojuego> obtenerLosVideojuegosPorBusqueda(String busqueda) {
		return sessionFactory.getCurrentSession()
				.createCriteria(Videojuego.class)
				.add(Restrictions.ilike("nombre", busqueda, MatchMode.ANYWHERE))
				.list();
		
	}

}
