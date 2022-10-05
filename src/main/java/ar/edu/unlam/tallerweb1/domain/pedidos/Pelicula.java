package ar.edu.unlam.tallerweb1.domain.pedidos;

import javax.persistence.Entity;

@Entity
public class Pelicula extends Contenido {
	
	private String director;
	private String genero;
	private String plataforma;
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
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