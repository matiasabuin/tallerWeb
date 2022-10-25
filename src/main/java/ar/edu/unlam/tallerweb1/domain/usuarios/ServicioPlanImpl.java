package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioPlan;

@Service("servicioPlan")
@Transactional
public class ServicioPlanImpl implements ServicioPlan {

	private RepositorioPlan servicioPlanDao;
	
	@Autowired
	public ServicioPlanImpl(RepositorioPlan servicioPlanDao) {
		this.servicioPlanDao=servicioPlanDao;
	}
	
	@Override
	public List<Plan> obtenerTodosLosPlanes() {
		return this.servicioPlanDao.obtenerTodosLosPlanes();
	}

	@Override
	public Plan ObtenerPlanPremium() {
		return this.servicioPlanDao.obtenerPlanPremium();
	}

	@Override
	public Plan ObtenerPlanFree() {
		return this.servicioPlanDao.obtenerPlanFree();
	}
	
	@Override
	public Plan ObtenerPlanBasico() {
		return this.servicioPlanDao.obtenerPlanBasico();
	}
}