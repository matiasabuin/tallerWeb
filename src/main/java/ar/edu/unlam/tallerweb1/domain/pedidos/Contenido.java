package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;


import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Contenido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String poster;
	
	private String nombre;
	private Integer duracion;
	
	@Column(length = 9000)
	private String sinopsis;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaEstreno;

//	@ManyToMany(mappedBy = "contenidos")
//	private List<Historial> historiales = new ArrayList<Historial>();

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
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
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
//	public List<Historial> getHistoriales() {
//		return historiales;
//	}
//	public void setHistoriales(List<Historial> historiales) {
//		this.historiales = historiales;
//	}
	
	
}
