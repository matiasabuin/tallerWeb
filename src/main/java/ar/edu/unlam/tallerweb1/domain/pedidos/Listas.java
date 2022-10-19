package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Listas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	private String nombre;
	private String descripcion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="videojuego_id")
	private Videojuego videojuego;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pelicula_id")
	private Pelicula pelicula;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="serie_id")
	private Serie serie;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	
	public Serie getSerie() {
		return this.serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Videojuego getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(Videojuego videojuego) {
		this.videojuego = videojuego;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

}
