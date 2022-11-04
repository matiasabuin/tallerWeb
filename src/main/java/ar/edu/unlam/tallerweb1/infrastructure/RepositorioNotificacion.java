package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;

public interface RepositorioNotificacion {

	void guardar(Notificacion notificacion);

	void editar(Notificacion notificacion);

	void eliminar(Notificacion notificacion);

	Notificacion getById(Integer id);

	List<Notificacion> getAllByUserId(Integer id);

	List<Notificacion> getAllLeidosByUserId(Integer id);

}
