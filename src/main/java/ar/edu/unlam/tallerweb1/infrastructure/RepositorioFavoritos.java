package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface RepositorioFavoritos {

	void guardar(Favorito fav);
	void eliminar(Favorito lista);
	Favorito buscar(Integer id);
	List<Favorito> obtenerFavoritos();
	List<Favorito> obtenerListasDelUsuarioPorId(Integer id);



}
