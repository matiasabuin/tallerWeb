package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionPeliculaNoEncontrada;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPelicula;

@Service("servicioPelicula")
@Transactional
public class ServicioPeliculaImpl implements ServicioPelicula {

	private RepositorioPelicula servicioPeliculaDao;

	@Autowired
	public ServicioPeliculaImpl(RepositorioPelicula servicioPeliculaDao) {
		this.servicioPeliculaDao = servicioPeliculaDao;
	}

	@Override
	public Pelicula registrarPelicula(Pelicula pelicula) {
		servicioPeliculaDao.guardar(pelicula);
		return pelicula;
	}

	@Override
	public List<Pelicula> obtenerTodasLasPeliculas() {
		return servicioPeliculaDao.obtenerTodasLasPeliculas();
	}

	@Override
	public Pelicula consultarPelicula(Integer id) throws ExceptionPeliculaNoEncontrada {
		Pelicula pelicula = servicioPeliculaDao.buscar(id);
		if (pelicula == null) {
			throw new ExceptionPeliculaNoEncontrada("");
		}
		return pelicula;
	}

	@Override
	public List<Pelicula> obtenerPeliculaPorTiempo(Integer horas) {
		return servicioPeliculaDao.obtenerLasPeliculasPorTiempo(horas);
	}

	@Override
	public List<Pelicula> obtenerPeliculaPorBusqueda(String busqueda) {
		return servicioPeliculaDao.obtenerLasPeliculasPorBusqueda(busqueda);
	}

	@Override
	public void modificarPelicula(Pelicula datosPelicula) {
		servicioPeliculaDao.modificar(datosPelicula);
	}

}