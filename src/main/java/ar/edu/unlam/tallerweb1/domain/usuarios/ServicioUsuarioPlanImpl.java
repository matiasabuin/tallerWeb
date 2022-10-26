package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;
import ar.edu.unlam.tallerweb1.infrastructure.RepositorioUsuarioPlan;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioPlanImpl implements ServicioUsuarioPlan {
	
	private RepositorioUsuarioPlan servicioUsuarioPlanDao;
	
	@Autowired
	public ServicioUsuarioPlanImpl(RepositorioUsuarioPlan servicioUsuarioPlanDao) {
		this.servicioUsuarioPlanDao=servicioUsuarioPlanDao;
	}
	
	@Override
	public UsuarioPlan registrarUsuarioPlan(Usuario usuario, Plan plan, LocalDate fechaVencimiento) {
		
		UsuarioPlan usuarioPlan = new UsuarioPlan();
		
		usuarioPlan.setUsuario(usuario);
		usuarioPlan.setPlan(plan);
		usuarioPlan.setFechaVencimiento(fechaVencimiento);
		
		this.servicioUsuarioPlanDao.guardar(usuarioPlan);
		return usuarioPlan;
	}
	
}
