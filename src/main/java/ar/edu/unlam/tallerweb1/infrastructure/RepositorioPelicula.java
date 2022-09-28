package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioPelicula {
	
	void guardar(Pelicula pelicula);
    Pelicula buscar(String nombre);
	List<Pelicula> obtenerTodasLasPeliculas();
}
