package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;

public interface RepositorioSerie {
	
	void guardar(Serie serie);
    Serie buscar(Integer id);
	List<Serie> obtenerTodasLasSeries();
	List<Serie> obtenerLasSeriesPorTiempo(Integer horas);
	List<Serie> obtenerLasSeriesPorBusqueda(String busqueda);
	void modificar(Serie datosSerie);
}
