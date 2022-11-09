package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double calificacion;
	
	@Column(length = 1000)
	private String descripcion;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="videojuego_id")
	private Videojuego videojuego;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pelicula_id")
	private Pelicula pelicula;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="serie_id")
	private Serie serie;

	@OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(id, other.id);
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}
}
