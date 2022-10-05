package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Videojuego extends Contenido{
	
	private String desarrollador;
	private Integer cantidadJugadores;
	
	@Column(length = 5000)
	private String requisitosMinimos;
	@Column(length = 5000)
	private String requisitosRecomendados;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "videojuego_genero", joinColumns = @JoinColumn(name = "videojuego_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private List<Genero> generos;
	
	@ManyToMany()
	@JoinTable(name = "videojuego_plataforma", joinColumns = {@JoinColumn(name="videojuego_id")}, inverseJoinColumns = {@JoinColumn(name="plataforma_id")})
	private List<Plataforma> plataformas;
	
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

}
