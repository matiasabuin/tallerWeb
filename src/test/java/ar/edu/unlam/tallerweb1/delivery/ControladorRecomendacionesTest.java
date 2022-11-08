package ar.edu.unlam.tallerweb1.delivery;

import static org.mockito.Mockito.mock;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPelicula;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioSerie;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioVideojuego;

public class ControladorRecomendacionesTest {

	ServicioVideojuego servicioVideojuego=mock(ServicioVideojuego.class);
	ServicioPelicula servicioPelicula=mock(ServicioPelicula.class);
	ServicioSerie servicioSerie=mock(ServicioSerie.class);

	ControladorRecomendaciones controladorRecomendaciones = new ControladorRecomendaciones(servicioVideojuego,servicioPelicula,servicioSerie);

	@Test
	public void QueNoSePuedeIngresarCeroHorasDeTiempoEnRecomendar() {
		
	}
	
	
}
