package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioSerie;

@Service("servicioSerie")
@Transactional
public class ServicioSerieImpl implements ServicioSerie {
	
	private RepositorioSerie repositorioSerieDao;
	
	@Autowired
	public ServicioSerieImpl(RepositorioSerie reposotorioSerieDao) {
		this.repositorioSerieDao=reposotorioSerieDao;
		
	}

	@Override
	public Serie consultarSerie(Integer id) {
		
	return	this.repositorioSerieDao.buscar(id);
	
	}

	@Override
	public Serie registrarSerie(Serie datosSerie) {
		this.repositorioSerieDao.guardar(datosSerie);
		return datosSerie;
	}

	@Override
	public List<Serie> obtenerTodasLasSeries() {
		return this.repositorioSerieDao.obtenerTodasLasSeries();
	}
	

}
