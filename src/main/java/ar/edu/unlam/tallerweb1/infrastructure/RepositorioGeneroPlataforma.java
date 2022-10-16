package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;

public interface RepositorioGeneroPlataforma {

	void guardarGenero(Genero genero);
    void guardarPlataforma(Plataforma plataforma); 
    
	void buscarGenero(Genero genero);
    void buscarPlataforma(Plataforma plataforma);
    
	List<Genero> obtenerGeneros();
	List<Plataforma> obtenerPlataformas();
	
	Genero getByDesc(String descripcion);
	
	Genero getGeneroById(Integer id);
	Plataforma getPlataformaById(Integer id);
}
