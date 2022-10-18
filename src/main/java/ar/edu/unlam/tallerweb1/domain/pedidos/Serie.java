package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Serie extends Contenido{
	
	private String genero;
	private String plataforma;

	private Integer cantDeTemps;
	private Integer cantDeCaps;
	private Integer duracionPorCaps;

	@OneToMany(mappedBy = "serie")
	private List<Listas> favoritos = new ArrayList<Listas>();	
	
	public List<Listas> getFavoritos() {
		return favoritos;
	}
	public void setFavoritos(List<Listas> favoritos) {
		this.favoritos = favoritos;
	}
	
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
