package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Favorito;
import ar.edu.unlam.tallerweb1.domain.pedidos.Pelicula;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioFavoritos;

@Service("servicioFavoritos")
@Transactional
public class ServicioFavoritosImpl implements ServicioFavoritos {


	private RepositorioFavoritos servicioFavoritosDao;

	@Autowired
	public ServicioFavoritosImpl(RepositorioFavoritos servicioFavoritosDao){
		this.servicioFavoritosDao = servicioFavoritosDao;
	}


	@Override
	public Favorito getById(Integer id) {
		return servicioFavoritosDao.buscar(id);
	}

	@Override
	public List<Favorito> getAll() {
		return servicioFavoritosDao.obtenerFavoritos();
	}


	@Override
	public void guardar(Favorito favoritos) {
		servicioFavoritosDao.guardar(favoritos);;
	
	}

	public void eliminar(Favorito lista) {
		this.servicioFavoritosDao.eliminar(lista);
	}


	@Override
	public List<Favorito> getAllByUserId(Integer id) {
		return this.servicioFavoritosDao.obtenerListasDelUsuarioPorId(id);
	}
	
}
