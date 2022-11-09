package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionSerieNoEncontrada;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioSerie;

@Service("servicioSerie")
@Transactional
public class ServicioSerieImpl implements ServicioSerie {

	private RepositorioSerie servicioSerieDao;

	@Autowired
	public ServicioSerieImpl(RepositorioSerie reposotorioSerieDao) {
		this.servicioSerieDao = reposotorioSerieDao;

	}

	@Override
	public Serie consultarSerie(Integer id) throws ExceptionSerieNoEncontrada {
		Serie serie = servicioSerieDao.buscar(id);
		if(serie == null) {
			throw new ExceptionSerieNoEncontrada("");
		}
		return serie;
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

	@Override
	public List<Serie> obtenerSeriePorBusqueda(String busqueda) {
		return servicioSerieDao.obtenerLasSeriesPorBusqueda(busqueda);
	}
	
	@Override
	public void modificarSerie(Serie datosserie) {
		servicioSerieDao.modificar(datosserie);
	}
}
