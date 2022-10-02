package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioVideojuego;

@Service("servicioVideojuego")
@Transactional
public class ServicioVideojuegoImpl implements ServicioVideojuego {
	
	private RepositorioVideojuego servicioVideojuegoDao;

	@Autowired
	public ServicioVideojuegoImpl(RepositorioVideojuego servicioVideojuegoDao){
		this.servicioVideojuegoDao = servicioVideojuegoDao;
	}

	public Videojuego consultarVideojuego (Integer id) {
		return servicioVideojuegoDao.buscar(id);
	}

	@Override
	public Videojuego registrarVideojuego(Videojuego videojuego) {
		servicioVideojuegoDao.guardar(videojuego);
		return videojuego;
	}

	@Override
	public List<Videojuego> obtenerTodosLosVideojuegos() {
		return servicioVideojuegoDao.obtenerTodosLosVideojuegos();
	}


}
