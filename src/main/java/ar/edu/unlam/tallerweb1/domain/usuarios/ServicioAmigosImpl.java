package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.pedidos.Amigo;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioAmigos;

@Service("servicioAmigos")
@Transactional
public class ServicioAmigosImpl implements ServicioAmigos{
	
	private RepositorioAmigos servicioAmigosDao;

	@Autowired
	public ServicioAmigosImpl(RepositorioAmigos servicioAmigosDao){
		this.servicioAmigosDao = servicioAmigosDao;
	}

	@Override
	public List<Usuario> getAllByUser(Integer id) {
		return servicioAmigosDao.getAllByUser(id);
	}

	@Override
	public void registar(Amigo amigo) {
		servicioAmigosDao.registrar(amigo);
	}

}
