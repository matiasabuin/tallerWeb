package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;

public interface ServicioGeneroPlataforma {
	
	void guardarGenero(Genero genero);

	List<Genero> obtenerGeneros();
	
	List<Plataforma> obtenerPlataformas();

}
