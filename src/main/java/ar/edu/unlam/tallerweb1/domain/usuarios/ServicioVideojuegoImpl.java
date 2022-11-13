package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Review;
import ar.edu.unlam.tallerweb1.domain.pedidos.Videojuego;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionRegistroCamposVacios;
import ar.edu.unlam.tallerweb1.excepciones.ExceptionVideojuegoNoEncontrado;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioVideojuego;

@Service("servicioVideojuego")
@Transactional
public class ServicioVideojuegoImpl implements ServicioVideojuego {
	
	private RepositorioVideojuego servicioVideojuegoDao;

	@Autowired
	public ServicioVideojuegoImpl(RepositorioVideojuego servicioVideojuegoDao){
		this.servicioVideojuegoDao = servicioVideojuegoDao;
	}

	public Videojuego consultarVideojuego (Integer id) throws ExceptionVideojuegoNoEncontrado {
		Videojuego videojuego = servicioVideojuegoDao.buscar(id);
		
		if(videojuego == null){
			throw new ExceptionVideojuegoNoEncontrado("");
		}
		
		Set<Review> reviews = videojuego.getReviews();
	    Double calificacion = 0.0;
	    for (Review element : reviews) {
	    	calificacion += element.getCalificacion();
	    }
	    Double calificacionFinal = calificacion / reviews.size();
	    videojuego.setCalificacion(calificacionFinal);
	    actualizarVideojuego(videojuego);
	    
		return videojuego;
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

	@Override
	public List<Videojuego> obtenerVideojuegoPorTiempo(Integer horas) {
		return servicioVideojuegoDao.obtenerLosVideojuegosPorTiempo(horas);
	}

	public void actualizarVideojuego(Videojuego datosVideojuego) {
		servicioVideojuegoDao.modificar(datosVideojuego);
	}

	@Override
	public List<Videojuego> obtenerVideojuegoPorBusqueda(String busqueda) {
		return servicioVideojuegoDao.obtenerLosVideojuegosPorBusqueda(busqueda);
	}

//	@Override
//	public void validarCampos(Videojuego datosVideojuego) {
//		String msg = "";
//		
//		if(datosVideojuego.getNombre() == "") {
//			msg = msg + "Rellene campo Nombre <br>";
//		}
//		
//		if(datosVideojuego.getNombre() == null) {
//			msg = msg + "Rellene campo Nombre <br>";
//		}
//		
//		if(datosVideojuego.getDesarrollador().isEmpty()) {
//			msg = msg + "Rellene campo desarrollador <br>";
//		}
//		
//		if(datosVideojuego.getSinopsis().isEmpty()) {
//			msg = msg + "Redacte una sinopsis <br>";
//		}
//		
//		if(datosVideojuego.getCantidadJugadores() == null) {
//			msg = msg + "Indique cantidad Jugadores <br>";
//		}
//		
//		if(datosVideojuego.getDuracion() == null) {
//			msg = msg + "Indique la duracion <br>";
//		}
//		
//		if(datosVideojuego.getFechaEstreno() == null) {
//			msg = msg + "Indique la fecha de estreno <br>";
//		}
//		
////		if(datosVideojuego.getGeneros().isEmpty()) {
////			msg = msg + "Seleccione al menos un genero <br>";
////		}
////		
////		if(datosVideojuego.getPlataformas().isEmpty()) {
////			msg = msg + "Seleccione al menos una plataforma <br>";
////		}
//		
//		if(msg != "") {
//			throw new ExceptionRegistroCamposVacios("No deben haber campos vacios");
//		} 
//	}

}
