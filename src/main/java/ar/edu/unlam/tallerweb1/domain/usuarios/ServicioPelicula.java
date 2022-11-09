package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionPeliculaNoEncontrada;

public interface ServicioPelicula {
	
	Pelicula consultarPelicula(Integer id) throws ExceptionPeliculaNoEncontrada;
	Pelicula registrarPelicula(Pelicula datosPelicula);
	void modificarPelicula(Pelicula datosPelicula);
	List<Pelicula> obtenerTodasLasPeliculas();
	List<Pelicula> obtenerPeliculaPorTiempo(Integer horas);
	List<Pelicula> obtenerPeliculaPorBusqueda(String busqueda);
}