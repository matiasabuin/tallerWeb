package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.time.LocalDate;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;

public interface ServicioUsuarioPlan {
	
	UsuarioPlan registrarUsuarioPlan(Usuario usuario, Plan plan, LocalDate fechaVencimiento);
}
