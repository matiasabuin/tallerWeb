package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface RepositorioVideojuego {

	void guardar(Videojuego videojuego);
    Videojuego buscar(Integer id);
	void modificar(Videojuego videojuego);
}
