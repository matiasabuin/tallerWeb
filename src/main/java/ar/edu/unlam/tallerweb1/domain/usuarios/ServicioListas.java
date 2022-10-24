package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.domain.pedidos.Lista;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface ServicioListas {
	
	void guardar(Lista lista);
	void eliminar(Lista lista);

	Lista getById(Integer id);
	
	List<Lista> getAll();

    Videojuego consultarVideojuegoId(Integer id);
	Pelicula consultarPeliculaId(Integer id);
	Serie consultarSerieId(Integer id);

}
