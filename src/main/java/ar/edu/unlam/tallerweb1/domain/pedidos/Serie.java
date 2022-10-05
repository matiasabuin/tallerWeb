package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

public class Serie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nombre;
	private Integer duracion;
	private String genero;
	private String plataforma;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaEstreno;
	private String poster;
	private Integer cantDeTemps;
	private Integer cantDeCaps;
	private Integer duracionPorCaps;
	@Column(length = 5000)
	private String sinopsis;
	
	public Integer getDuracionPorCaps() {
		return duracionPorCaps;
	}
	public void setDuracionPorCaps(Integer duracionPorCaps) {
		this.duracionPorCaps = duracionPorCaps;
	}
	public Integer getCantDeTemps() {
		return cantDeTemps;
	}
	public void setCantDeTemps(Integer cantDeTemps) {
		this.cantDeTemps = cantDeTemps;
	}
	public Integer getCantDeCaps() {
		return cantDeCaps;
	}
	public void setCantDeCaps(Integer cantDeCaps) {
		this.cantDeCaps = cantDeCaps;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
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
	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
