package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.excepciones.ExceptionImagenNoIngresada;

public interface ServicioFiles {

	void uploadImage(MultipartFile file) throws IOException;

}
