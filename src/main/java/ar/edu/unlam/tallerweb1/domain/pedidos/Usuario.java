package ar.edu.unlam.tallerweb1.domain.pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private List<Review> reviews = new ArrayList<Review>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="plan_id")
	private Plan plan;
	
	private LocalDate fechaVencimientoPlan = LocalDate.now().minusDays(1);
	
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Listas> favoritos = new ArrayList<Listas>();
	
	public List<Listas> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Listas> favoritos) {
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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
	
	public LocalDate getFechaVencimientoPlan() {
		return fechaVencimientoPlan;
	}
	public void setFechaVencimientoPlan(LocalDate fechaVencimientoPlan) {
		this.fechaVencimientoPlan = fechaVencimientoPlan;
	}
}
