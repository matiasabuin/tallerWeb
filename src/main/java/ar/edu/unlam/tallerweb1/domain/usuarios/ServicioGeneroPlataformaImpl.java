package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Genero;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plataforma;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioGeneroPlataforma;

@Service("servicioGeneroPlataforma")
@Transactional
public class ServicioGeneroPlataformaImpl implements ServicioGeneroPlataforma{

	private RepositorioGeneroPlataforma servicioGeneroPlataformaDao;

	@Autowired
	public ServicioGeneroPlataformaImpl(RepositorioGeneroPlataforma servicioGeneroPlataformaDao){
		this.servicioGeneroPlataformaDao = servicioGeneroPlataformaDao;
	}
	
	@Override
	public List<Genero> obtenerGeneros() {
		return servicioGeneroPlataformaDao.obtenerGeneros();
	}

	@Override
	public List<Plataforma> obtenerPlataformas() {
		return servicioGeneroPlataformaDao.obtenerPlataformas();
	}

	@Override
	public void guardarGenero(Genero genero) {
		servicioGeneroPlataformaDao.guardarGenero(genero);
	}

	@Override
	public Genero getByDesc(String descripcion) {
		return servicioGeneroPlataformaDao.getByDesc(descripcion);
	}

	@Override
	public Genero getGeneroById(Integer id) {
		return  servicioGeneroPlataformaDao.getGeneroById(id);
	}

	@Override
	public Plataforma getPlataformaById(Integer id) {
		return  servicioGeneroPlataformaDao.getPlataformaById(id);
	}

}
