package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.domain.pedidos.Solicitud;

public interface RepositorioSolicitud {

	void registrar(Solicitud solicitud);

	void modificar(Solicitud solicitud);

	Solicitud getByUsers(Integer user1, Integer user2);

	void eliminar(Solicitud solicitudEncontrada);

}
