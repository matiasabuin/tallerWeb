package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface ServicioFavoritos {
	
	void guardar(Favorito lista);
	void eliminar(Favorito lista);
	Favorito getById(Integer id);
	List<Favorito> getAll();
	List<Favorito> getAllByUserId(Integer id);


}
