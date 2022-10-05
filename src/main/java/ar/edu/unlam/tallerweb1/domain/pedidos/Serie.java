package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Serie extends Contenido{
	
	private String genero;
	private String plataforma;

	private Integer cantDeTemps;
	private Integer cantDeCaps;
	private Integer duracionPorCaps;

	
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
	
}
