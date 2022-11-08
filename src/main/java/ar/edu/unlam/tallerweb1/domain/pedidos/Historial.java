package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Historial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "historial_pelicula", joinColumns = @JoinColumn(name = "historial_id"), inverseJoinColumns = @JoinColumn(name = "pelicula_id"))
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "historial_serie", joinColumns = @JoinColumn(name = "historial_id"), inverseJoinColumns = @JoinColumn(name = "serie_id"))
	private List<Serie> series = new ArrayList<Serie>();

	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "historial_videojuego", joinColumns = @JoinColumn(name = "historial_id"), inverseJoinColumns = @JoinColumn(name = "videojuego_id"))
	private List<Videojuego> videojuegos = new ArrayList<Videojuego>();

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Serie> getSeries() {
		return this.series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Videojuego> getVideojuegos() {
		return this.videojuegos;
	}

	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula buscarPeliEnHistorial(Integer id) {
		for (Pelicula p : peliculas) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public Serie buscarSerieEnHistorial(Integer id) {
		for (Serie p : series) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public Videojuego buscarVideojuegoEnHistorial(Integer id) {
		for (Videojuego p : videojuegos) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public List<Pelicula> invertirListaDePeliculas(List<Pelicula> peli) {
		List<Pelicula> nuevaLista = new ArrayList<>(peli);
		Collections.reverse(nuevaLista);
		return nuevaLista;

	}

	public List<Serie> invertirListaDeSeries(List<Serie> series) {
		List<Serie> nuevaLista = new ArrayList<>(series);
		Collections.reverse(nuevaLista);
		return nuevaLista;

	}

	public List<Videojuego> invertirListaDeVideojuegos(List<Videojuego> videojuegos) {
		List<Videojuego> nuevaLista = new ArrayList<>(videojuegos);
		Collections.reverse(nuevaLista);
		return nuevaLista;

	}

}