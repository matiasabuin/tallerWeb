package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPelicula;

@Service("servicioPelicula")
@Transactional
public class ServicioPeliculaImpl implements ServicioPelicula {

	private RepositorioPelicula servicioPeliculaDao;
	
	@Autowired
	public ServicioPeliculaImpl(RepositorioPelicula servicioPeliculaDao){
		this.servicioPeliculaDao = servicioPeliculaDao;
	}
	@Override
	public Pelicula registrarPelicula(String nombre) {
		
		Pelicula pelicula = new Pelicula();

		pelicula.setNombre(nombre);
		servicioPeliculaDao.guardar(pelicula);
		
		return pelicula;
	}

	@Override
	public List<Pelicula> obtenerTodasLasPeliculas() {
		
		return servicioPeliculaDao.obtenerTodasLasPeliculas();
	}


}