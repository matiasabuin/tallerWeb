package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Lista;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioListas;

@Service("servicioFavoritos")
@Transactional
public class ServicioListasImpl implements ServicioListas {


	private RepositorioListas servicioFavoritosDao;

	@Autowired
	public ServicioListasImpl(RepositorioListas servicioFavoritosDao){
		this.servicioFavoritosDao = servicioFavoritosDao;
	}


	@Override
	public Lista getById(Integer id) {
		return servicioFavoritosDao.buscar(id);
	}

	@Override
	public List<Lista> getAll() {
		return servicioFavoritosDao.obtenerFavoritos();
	}

	@Override
	public void guardar(Lista favoritos) {
		servicioFavoritosDao.guardar(favoritos);;
	
	}

	@Override
	public Videojuego consultarVideojuegoId(Integer id) {
		// TODO Auto-generated method stub
		return servicioFavoritosDao.buscarVideojuegoId(id);
	}


	@Override
	public Pelicula consultarPeliculaId(Integer id) {
		// TODO Auto-generated method stub
		return servicioFavoritosDao.buscarPeliculaId(id);
	}


	@Override
	public Serie consultarSerieId(Integer id) {
		// TODO Auto-generated method stub
		return servicioFavoritosDao.buscarSerieId(id);
	}


	@Override
	public void eliminar(Lista lista) {
		this.servicioFavoritosDao.eliminar(lista);
	}
	
}
