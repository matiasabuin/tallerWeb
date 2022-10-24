package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuario;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	private RepositorioUsuario servicioLoginDao;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario servicioLoginDao){
		this.servicioLoginDao = servicioLoginDao;
	}

	@Override
	public Usuario consultarUsuario (String email, String password) {
		return servicioLoginDao.buscarUsuario(email, password);
	}
	

	@Override
	public Usuario registrarUsuario(String email, String password, String nombre) {
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setNombre(nombre);
		servicioLoginDao.guardar(usuario);
		
		return usuario;
	}

	@Override
	public List<Usuario> obtenerTodosLosUsarios() {
		
		return servicioLoginDao.obtenerTodosLosUsarios();
	}

	@Override
	public void editarPerfil(Usuario usuario) {
		servicioLoginDao.modificar(usuario);
	
	}

}
