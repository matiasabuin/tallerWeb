package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Serie extends Contenido {

	private String genero;
	private String plataforma;

	private Integer cantDeTemps;
	private Integer cantDeCaps;
	private Integer duracionPorCaps;
	
	private Double calificacion = 0.0;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "serie_genero", joinColumns = @JoinColumn(name = "serie_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private List<Genero> generos = new ArrayList<Genero>();

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "serie_plataforma", joinColumns = @JoinColumn(name = "serie_id"), inverseJoinColumns = @JoinColumn(name = "plataforma_id"))
	private List<Plataforma> plataformas = new ArrayList<Plataforma>();
	
	@ManyToMany(mappedBy = "series")
	private List<Historial> historiales = new ArrayList<Historial>();

	@OneToMany(mappedBy = "serie")
	private Set<Review> reviews = new HashSet<Review>();

	@OneToMany(mappedBy = "serie")
	private List<Favorito> favoritos = new ArrayList<Favorito>();

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

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
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

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

}
