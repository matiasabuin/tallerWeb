package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface RepositorioVideojuego {

	void guardar(Videojuego videojuego);
    Videojuego buscar(Integer id);
	void modificar(Videojuego videojuego);
	List<Videojuego> obtenerTodosLosVideojuegos();
	List<Videojuego> obtenerLosVideojuegosPorTiempo(Integer horas);
	List<Videojuego> obtenerLosVideojuegosPorBusqueda(String busqueda);
}
