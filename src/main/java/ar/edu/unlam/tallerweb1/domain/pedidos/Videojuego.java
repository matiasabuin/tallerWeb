package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Videojuego extends Contenido{
	
	private String desarrollador;
	private Integer cantidadJugadores;
	
	@Column(length = 5000)
	private String requisitosMinimos;
	@Column(length = 5000)
	private String requisitosRecomendados;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "videojuego_genero", joinColumns = @JoinColumn(name = "videojuego_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private List<Genero> generos = new ArrayList<>();
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "videojuego_plataforma", joinColumns = @JoinColumn(name="videojuego_id"), inverseJoinColumns = @JoinColumn(name="plataforma_id"))
	private List<Plataforma> plataformas;

	@OneToMany(mappedBy = "videojuego")
	private List<Review> reviews = new ArrayList<Review>();
	
	
	public String getRequisitosMinimos() {
		return requisitosMinimos;
	}
	public void setRequisitosMinimos(String requisitosMinimos) {
		this.requisitosMinimos = requisitosMinimos;
	}
	public String getRequisitosRecomendados() {
		return requisitosRecomendados;
	}
	public void setRequisitosRecomendados(String requisitosRecomendados) {
		this.requisitosRecomendados = requisitosRecomendados;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public Integer getCantidadJugadores() {
		return cantidadJugadores;
	}
	public void setCantidadJugadores(Integer cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
