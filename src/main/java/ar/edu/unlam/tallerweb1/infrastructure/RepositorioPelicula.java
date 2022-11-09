package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioPelicula {
	
	void guardar(Pelicula pelicula);
    Pelicula buscar(Integer id);
	List<Pelicula> obtenerTodasLasPeliculas();
	List<Pelicula> obtenerLasPeliculasPorTiempo(Integer horas);
	List<Pelicula> obtenerLasPeliculasPorBusqueda(String busqueda);
	void modificar(Pelicula datosPelicula);
}
