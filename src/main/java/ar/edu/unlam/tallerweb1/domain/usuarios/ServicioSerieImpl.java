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
	
	private RepositorioSerie servicioSerieDao;
	
	@Autowired
	public ServicioSerieImpl(RepositorioSerie reposotorioSerieDao) {
		this.servicioSerieDao=reposotorioSerieDao;
		
	}

	@Override
	public Serie consultarSerie(Integer id) {
		
	return	this.servicioSerieDao.buscar(id);
	
	}

	@Override
	public Serie registrarSerie(Serie datosSerie) {
		this.servicioSerieDao.guardar(datosSerie);
		return datosSerie;
	}

	@Override
	public List<Serie> obtenerTodasLasSeries() {
		return this.servicioSerieDao.obtenerTodasLasSeries();
	}

	@Override
	public List<Serie> obtenerSeriePorTiempo(Integer horas) {
		return servicioSerieDao.obtenerLasSeriesPorTiempo(horas);
	}
	

}
