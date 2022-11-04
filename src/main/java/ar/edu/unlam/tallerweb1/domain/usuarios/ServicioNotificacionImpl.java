package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.pedidos.Notificacion;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioNotificacion;

@Service("servicioNotificacion")
@Transactional
public class ServicioNotificacionImpl implements ServicioNotificacion {

	private RepositorioNotificacion servicioNotificacionDao;
	
	@Autowired
	public ServicioNotificacionImpl(RepositorioNotificacion servicioNotificacionDao) {
		this.servicioNotificacionDao = servicioNotificacionDao;
	}
	
	@Override
	public void registrar(Notificacion notificacion) {
		servicioNotificacionDao.guardar(notificacion);
	}

	@Override
	public void modificar(Notificacion notificacion) {
		servicioNotificacionDao.editar(notificacion);		
	}

	@Override
	public void eliminar(Notificacion notificacion) {
		servicioNotificacionDao.eliminar(notificacion);		
	}

	@Override
	public Notificacion getById(Integer id) {
		return servicioNotificacionDao.getById(id);
	}

	@Override
	public List<Notificacion> getAllByUserId(Integer id) {
		return servicioNotificacionDao.getAllByUserId(id);
	}

	@Override
	public List<Notificacion> getAllLeidosByUserId(Integer id) {
		return servicioNotificacionDao.getAllLeidosByUserId(id);
	}

}

