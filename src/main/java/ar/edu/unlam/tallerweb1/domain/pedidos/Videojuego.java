package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Videojuego {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String desarrollador;
	
	private Integer duracion;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaEstreno;
	
	private String sinopsis;
	private String cantidadJugadores;
	
	private String requisitosMinimos;
	private String requisitosRecomendados;
	
	private String genero;
	private String plataforma;
	
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public String getDesarrollador() {
		return desarrollador;
	}
	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getCantidadJugadores() {
		return cantidadJugadores;
	}
	public void setCantidadJugadores(String cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	

}
