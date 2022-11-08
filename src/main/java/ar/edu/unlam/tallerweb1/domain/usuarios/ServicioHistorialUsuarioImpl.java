package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Contenido;
import ar.edu.unlam.tallerweb1.domain.pedidos.Historial;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioHistorialUsuario;

@Service("servicioHistorial")
@Transactional
public class ServicioHistorialUsuarioImpl implements ServicioHistorialUsuario {

	
	private RepositorioHistorialUsuario servicioHistorialUsuarioDao;
	
	@Autowired
	public ServicioHistorialUsuarioImpl(RepositorioHistorialUsuario servicioHistorialUsuarioDao) {
	this.servicioHistorialUsuarioDao=servicioHistorialUsuarioDao;
	}


	@Override
	public Historial getByUserId(Integer id) {
		// TODO Auto-generated method stub
		return this.servicioHistorialUsuarioDao.obtenerHistorialDelUsuario(id);
	}

	@Override
	public Historial registrarHistorial(Usuario usuario) {
		// TODO Auto-generated method stub
		    Historial historial = new Historial();
			
	        historial.setUsuario(usuario);
			
			this.servicioHistorialUsuarioDao.guardar(historial);
			
			return historial;
		}


	@Override
	public void update(Historial historial) {
		
		this.servicioHistorialUsuarioDao.update(historial);
	}
	

}
	

	