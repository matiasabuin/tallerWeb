package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="videojuego")
public class Videojuego{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String poster;
	
	private String nombre;
	private String desarrollador;
	private Integer duracion;
	private Integer cantidadJugadores;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaEstreno;
	
	@Column(length = 9000)
	private String sinopsis;
	@Column(length = 5000)
	private String requisitosMinimos;
	@Column(length = 5000)
	private String requisitosRecomendados;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "videojuego_genero", joinColumns = @JoinColumn(name = "videojuego_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "genero_id", referencedColumnName = "id"))
	private List<Genero> generos = new ArrayList<Genero>();
	
	@ManyToMany()
	@JoinTable(name = "videojuego_plataforma", joinColumns = {@JoinColumn(name="videojuego_id")}, inverseJoinColumns = {@JoinColumn(name="plataforma_id")})
	private List<Plataforma> plataformas = new ArrayList<Plataforma>();
	
	
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
	
	public Integer getCantidadJugadores() {
		return cantidadJugadores;
	}
	public void setCantidadJugadores(Integer cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}


}
