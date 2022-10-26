package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionVideojuegoNoEncontrado;

public interface ServicioVideojuego {

	Videojuego consultarVideojuego(Integer id) throws ExceptionVideojuegoNoEncontrado;
	Videojuego registrarVideojuego(Videojuego datosVideojuego);
	
	List<Videojuego> obtenerTodosLosVideojuegos();
	List<Videojuego> obtenerVideojuegoPorTiempo(Integer horas);
	void actualizarVideojuego(Videojuego datosVideojuego);
	List<Videojuego> obtenerVideojuegoPorBusqueda(String busqueda);
	
//	void validarCampos(Videojuego datosVideojuego);
}
