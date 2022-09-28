package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;

public interface ServicioVideojuego {

	Videojuego consultarVideojuego(Integer id);

	Videojuego registrarVideojuego(Videojuego datosVideojuego);
}
