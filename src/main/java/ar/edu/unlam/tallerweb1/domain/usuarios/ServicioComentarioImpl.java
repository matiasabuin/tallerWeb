package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Comentario;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionDescripcionVacia;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioComentario;

@Service("servicioComentario")
@Transactional
public class ServicioComentarioImpl implements ServicioComentario {

	private RepositorioComentario servicioComentarioDao;

	@Autowired
	public ServicioComentarioImpl(RepositorioComentario servicioComentarioDao){
		this.servicioComentarioDao = servicioComentarioDao;
	}
	
	@Override
	public void registrar(Comentario comentario) throws ExceptionDescripcionVacia {
		if(comentario.getDescripcion().isEmpty()) {
			throw new ExceptionDescripcionVacia("Debe escribir un comentario");
		}
		servicioComentarioDao.guardar(comentario);
	}

	@Override
	public List<Comentario> getAllByReview(Integer id) {
		return servicioComentarioDao.obtenerComentarios(id);
	}
	
	@Override
	public void eliminar(Comentario comentario) {
		servicioComentarioDao.elimimar(comentario);
	}

	@Override
	public Comentario getById(Integer id) {
		return servicioComentarioDao.buscar(id);
	}

	@Override
	public void modificar(Comentario comentarioEncontrado) {
		servicioComentarioDao.modificar(comentarioEncontrado);
	}

	@Override
	public List<Comentario> getAllByUser(Integer id) {
		return servicioComentarioDao.obtenerComentariosUsuario(id);
	}

}
