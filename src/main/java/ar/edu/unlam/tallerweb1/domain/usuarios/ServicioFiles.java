package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface ServicioFiles {

	void uploadImage(MultipartFile file) throws IOException;

}
