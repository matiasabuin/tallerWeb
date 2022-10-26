package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionEmailRegistrado;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionNombreDeUsuarioRepetido;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
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
	public Usuario registrarUsuario(String email, String password, String nombre) throws ExceptionNombreDeUsuarioRepetido, ExceptionEmailRegistrado, ExceptionRegistroCamposVacios {
		Usuario usuario = new Usuario();
		
		if(email == "" || password == "" || nombre == "") {
			throw new ExceptionRegistroCamposVacios("No debe haber campos vacios");
		}
		
		if(servicioLoginDao.findByName(nombre) == null) {
			usuario.setNombre(nombre);
		} else {
			throw new ExceptionNombreDeUsuarioRepetido("Ya existe un usuario con este nombre");
		}
		
		if(servicioLoginDao.findByEmail(email) == null) {
			usuario.setEmail(email);
		} else {
			throw new ExceptionEmailRegistrado("Ya existe un usuario con este email");
		}
		
		usuario.setPassword(password);
		servicioLoginDao.guardar(usuario);
		return usuario;
	}

	@Override
	public List<Usuario> obtenerTodosLosUsarios() {
		return servicioLoginDao.obtenerTodosLosUsarios();
	}

	@Override
	public void editarPerfil(Usuario usuario) {
//		if(servicioLoginDao.findByName(usuario.getNombre()) != null) {
//			throw new ExceptionNombreDeUsuarioRepetido("Ya existe un usuario con este nombre");
//		}
		servicioLoginDao.modificar(usuario);
	}

	@Override
	public Usuario getById(Integer id) {
		return servicioLoginDao.getById(id);
	}

}
