package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;

public interface ServicioSerie {

	Serie consultarSerie(Integer id);
	Serie registrarSerie(Serie datosSerie);
	List<Serie> obtenerTodasLasSeries();
}
