package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descripcion;
	
	@ManyToMany(mappedBy="generos")
    private List<Videojuego> videojuegos = new ArrayList<Videojuego>();
    
    @ManyToMany(mappedBy="generos")
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
    
    
    public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	public List<Videojuego> getContenidos() {
		return videojuegos;
	}
	public void setContenidos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
