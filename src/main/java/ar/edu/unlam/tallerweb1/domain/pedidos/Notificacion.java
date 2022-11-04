package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Notificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String mensaje;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate leido;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDate getLeido() {
		return leido;
	}

	public void setLeido(LocalDate leido) {
		this.leido = leido;
	}
	
	
}
