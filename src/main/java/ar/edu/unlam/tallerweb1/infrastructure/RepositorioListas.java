package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Lista;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface RepositorioListas {

	void guardar(Lista fav);
	void eliminar(Lista lista);

	Lista buscar(Integer id);

	List<Lista> obtenerFavoritos();
	List<Lista> obtenerListasDelUsuarioPorId(Integer id);



}
