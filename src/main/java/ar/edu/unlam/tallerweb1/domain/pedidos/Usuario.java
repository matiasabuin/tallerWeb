package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria
	// de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// para el resto de los atributo no se usan anotaciones entonces se usa el
	// default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de
	// dato de java.
	private String email;
	private String password;
	private String nombre;
	private String biografia;
	private String foto = "perfil.jpg";
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private Set<Review> reviews = new HashSet<Review>();
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Comentario> comentarios = new ArrayList<Comentario>();

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Favorito> favoritos = new ArrayList<Favorito>();
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Notificacion> notifaciones = new ArrayList<Notificacion>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="historial_id")
	private Historial historialUsuario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="planAdquirido_id")
	private UsuarioPlan planAdquirido;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Amigo> amigos = new ArrayList<Amigo>();

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario1", fetch = FetchType.EAGER)
	private List<Solicitud> solicitudes = new ArrayList<Solicitud>();


	public Historial getHistorialUsuario() {
		return historialUsuario;
	}

	public void setHistorialUsuario(Historial historialUsuario) {
		this.historialUsuario = historialUsuario;
	}

	public UsuarioPlan getPlanAdquirido(){
		return planAdquirido;
	}

	public void setPlanAdquirido(UsuarioPlan plan) {
		this.planAdquirido = plan;
	}
	
	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public Integer cantFav() {
		return this.favoritos.size();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	public List<Notificacion> getNotifaciones() {
		return notifaciones;
	}

	public void setNotifaciones(List<Notificacion> notifaciones) {
		this.notifaciones = notifaciones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public List<Amigo> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Amigo> amigos) {
		this.amigos = amigos;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
}
