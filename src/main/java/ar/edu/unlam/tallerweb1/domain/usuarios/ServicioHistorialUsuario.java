package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public interface ServicioHistorialUsuario {

	Historial registrarHistorial(Usuario usuario);
	Historial getByUserId(Integer id);
	void update(Historial historial);

	
}
