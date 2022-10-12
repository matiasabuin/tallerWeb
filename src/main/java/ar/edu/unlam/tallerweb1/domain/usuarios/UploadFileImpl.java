package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//@Service
//public class UploadFileImpl implements UploadFile {
//    private final Path fileStorageLocation;
//    private final String uploadDir;
//    
//    @Autowired
//    private AdjuntoService adjuntoService;
//    
//    @Autowired
//    private NotaService notaService;
//    
//    @Autowired
//    public UploadFileImpl(Environment env) {
//        this.uploadDir = env.getProperty("app.file.upload-dir", "./uploads/files");
//        this.fileStorageLocation = Paths.get(this.uploadDir)
//                .toAbsolutePath().normalize();
//        try {
//            Files.createDirectories(this.fileStorageLocation);
//        } catch (Exception ex) {
//            throw new RuntimeException(
//                    "Could not create the directory where the uploaded files will be stored.", ex);
//        }
//    }
//    
//    public String getFileExtension(String fileName) {
//        if (fileName == null) {
//            return null;
//        }
//        String[] fileNameParts = fileName.split("\\.");
//        return fileNameParts[fileNameParts.length - 1];
//    }
//    
//    public String storeFile(MultipartFile file, Long notaId) {
//        Nota nota = this.notaService.getById(notaId);
//        int cantidadDefiles = this.adjuntoService.findAllByNota (nota).size();
//        cantidadDefiles += 1 ;
//        String fileName="(" +cantidadDefiles +")" + " " + file.getOriginalFilename();
//        try {
//            // Check if the filename contains invalid characters
//            if (fileName.contains("..")) {
//                throw new FileException(
//                        "Sorry! Filename contains invalid path sequence " + fileName);
//            }
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//            String extension = getFileExtension(fileName);
//            Long tamanio = Files.size(targetLocation);
//            String path = this.uploadDir.substring(1) + "/" + fileName;
//            Adjunto adjunto = new Adjunto();
//            adjunto.setFecha(LocalDate.now());
//            adjunto.setNombre(fileName);
//            adjunto.setNota(nota);
//            adjunto.setExtension(extension);
//            adjunto.setTamanio(tamanio);
//            adjunto.setPath(path);
//            this.adjuntoService.save(adjunto);
//            return fileName;
//        } catch (IOException | FileException ex) {
//            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//    }
//    
//    @Override
//    public void deleteFile(String nombre) {
//        try {
//            Path path = this.fileStorageLocation.resolve(nombre);
//            Files.delete(path);
//        } catch (IOException ex) {
//            throw new RuntimeException("Could not delete file. Please try again!", ex);
//        }
//    }
//}