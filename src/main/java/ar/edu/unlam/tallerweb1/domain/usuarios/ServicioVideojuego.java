package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface ServicioVideojuego {

	Videojuego consultarVideojuego(Integer id);
	Videojuego registrarVideojuego(Videojuego datosVideojuego);
	List<Videojuego> obtenerTodosLosVideojuegos();
	List<Videojuego> obtenerVideojuegoPorTiempo(Integer horas);
	void actualizarVideojuego(Videojuego datosVideojuego);
	List<Videojuego> obtenerVideojuegoPorBusqueda(String busqueda);
}
