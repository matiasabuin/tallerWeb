package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;

public interface RepositorioPlan {
	List<Plan> obtenerTodosLosPlanes();
	Plan obtenerPlanPremium();
	Plan obtenerPlanFree();
	Plan obtenerPlanBasico();
}
