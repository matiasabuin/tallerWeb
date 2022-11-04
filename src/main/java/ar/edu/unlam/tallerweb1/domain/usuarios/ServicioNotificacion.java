package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;

public interface ServicioNotificacion {
	
	void registrar(Notificacion notificacion);
	void modificar(Notificacion notificacion);
	void eliminar(Notificacion notificacion);
	Notificacion getById(Integer id);

	List<Notificacion> getAllByUserId(Integer id);
	List<Notificacion> getAllLeidosByUserId(Integer id);
	
}
