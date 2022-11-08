package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;

public interface RepositorioHistorialUsuario {
	
	void guardar(Historial historial);
	
	Historial obtenerHistorialDelUsuario(Integer id);

	void update(Historial historial);


}
