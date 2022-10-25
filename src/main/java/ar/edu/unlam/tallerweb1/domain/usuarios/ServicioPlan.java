package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;

public interface ServicioPlan {
	List<Plan> obtenerTodosLosPlanes();
	Plan ObtenerPlanPremium();
	Plan ObtenerPlanFree();
	Plan ObtenerPlanBasico();
}
