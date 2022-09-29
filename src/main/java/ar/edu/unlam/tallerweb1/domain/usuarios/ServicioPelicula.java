package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;

public interface ServicioPelicula {
	
	
	Pelicula consultarPelicula(Integer id);
	Pelicula registrarPelicula(Pelicula datosPelicula);
	List<Pelicula> obtenerTodasLasPeliculas();
}