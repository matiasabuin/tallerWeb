package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.pedidos.Solicitud;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public interface ServicioSolicitud {

	void registrar(Solicitud solicitud);
	void modificar(Solicitud solicitud);
	Solicitud getByUsers(Integer User1, Integer User2);
	void aprobarSolicitud(Solicitud solicitudEncontrada);
	void rechazarSolicitud(Solicitud solicitudEncontrada);
}