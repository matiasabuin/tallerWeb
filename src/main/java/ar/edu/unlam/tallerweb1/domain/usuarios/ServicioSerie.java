package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionSerieNoEncontrada;

public interface ServicioSerie {

	Serie consultarSerie(Integer id) throws ExceptionSerieNoEncontrada;
	Serie registrarSerie(Serie datosSerie);
	List<Serie> obtenerTodasLasSeries();
	void modificarSerie(Serie datosSerie);
	List<Serie> obtenerSeriePorTiempo(Integer horas);
	List<Serie> obtenerSeriePorBusqueda(String busqueda);
}
