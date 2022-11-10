package ar.edu.unlam.tallerweb1.domain.usuarios;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.domain.pedidos.Estado;
import ar.edu.unlam.tallerweb1.domain.pedidos.Solicitud;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioSolicitud;

@Service("servicioSolicitud")
@Transactional
public class ServicioSolicitudImpl implements ServicioSolicitud {
	
	private RepositorioSolicitud repositorioSolicitud;
	
	@Autowired
	public ServicioSolicitudImpl(RepositorioSolicitud repositorioSolicitud) {
		this.repositorioSolicitud = repositorioSolicitud;
	}

	@Override
	public void registrar(Solicitud solicitud) {
		repositorioSolicitud.registrar(solicitud);
	}

	@Override
	public void modificar(Solicitud solicitud) {
		repositorioSolicitud.modificar(solicitud);
	}

	@Override
	public Solicitud getByUsers(Integer User1, Integer User2) {
		return repositorioSolicitud.getByUsers(User1, User2);
	}

	@Override
	public void aprobarSolicitud(Solicitud solicitudEncontrada) {
		solicitudEncontrada.setEstado(Estado.APROBADO);
		repositorioSolicitud.modificar(solicitudEncontrada);
	}

	@Override
	public void rechazarSolicitud(Solicitud solicitudEncontrada) {
		solicitudEncontrada.setEstado(Estado.RECHAZADO);
		repositorioSolicitud.eliminar(solicitudEncontrada);
	}

}
