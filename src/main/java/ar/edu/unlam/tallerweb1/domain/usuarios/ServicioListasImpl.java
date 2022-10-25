package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

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

	public void eliminar(Lista lista) {
		this.servicioFavoritosDao.eliminar(lista);
	}


	@Override
	public List<Lista> getAllByUserId(Integer id) {
		return this.servicioFavoritosDao.obtenerListasDelUsuarioPorId(id);
	}
	
}
