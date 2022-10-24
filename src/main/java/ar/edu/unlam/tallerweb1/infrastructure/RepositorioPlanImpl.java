package ar.edu.unlam.tallerweb1.infrastructure;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Serie;

@Repository("repositorioPlan")
public class RepositorioPlanImpl implements RepositorioPlan {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioPlanImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	public List<Plan> obtenerTodosLosPlanes() {
	     return sessionFactory.getCurrentSession()
	                .createCriteria(Plan.class)
	                .list();
	}
	
	@Override
	public Plan obtenerPlanFree() {
		return (Plan)this.sessionFactory.getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.eq("descripcion", "Free"))
				.uniqueResult();
	}
	
	@Override
	public Plan obtenerPlanBasico() {
		return (Plan)this.sessionFactory.getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.eq("descripcion", "Basico"))
				.uniqueResult();
	}
	
	@Override
	public Plan obtenerPlanPremium() {
		return (Plan)this.sessionFactory.getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.eq("descripcion", "Premium"))
				.uniqueResult();
	}
	
}