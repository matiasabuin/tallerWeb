package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.domain.pedidos.Listas;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface ServicioListas {
	
	void guardar(Listas review);
	
	Listas getById(Integer id);
	
	List<Listas> getAll();

    Videojuego consultarVideojuegoId(Integer id);
	Pelicula consultarPeliculaId(Integer id);
	Serie consultarSerieId(Integer id);

	
	

}
