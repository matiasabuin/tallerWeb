package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Listas;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface RepositorioListas {

	void guardar(Listas fav);

	Listas buscar(Integer id);

	List<Listas> obtenerFavoritos();

	Videojuego buscarVideojuegoId(Integer id);
	Pelicula buscarPeliculaId(Integer id);
	Serie buscarSerieId(Integer id);

}
