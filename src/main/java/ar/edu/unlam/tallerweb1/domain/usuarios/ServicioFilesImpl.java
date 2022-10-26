package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ar.edu.unlam.tallerweb1.excepciones.ExceptionImagenNoIngresada;


@Service("servicioFiles")
@Transactional
public class ServicioFilesImpl implements ServicioFiles{
	
	@Autowired
	HttpSession session;

	@Override
	public void uploadImage(MultipartFile file) throws IOException {
		
//		if(file.getBytes() != null) {
			String path = session.getServletContext().getRealPath("/images");
	        String filename = file.getOriginalFilename();
	        
	        byte[] data = file.getBytes();
	        
	        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path+"/"+filename));
	     	bufferedOutputStream.write(data);
	     	bufferedOutputStream.flush();
	     	bufferedOutputStream.close();
//		}
//     	
//		throw new ExceptionImagenNoIngresada("No se ha insertado una imagen");
     	
	}

}
