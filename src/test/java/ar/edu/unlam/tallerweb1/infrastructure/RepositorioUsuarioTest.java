package ar.edu.unlam.tallerweb1.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.delivery.SpringTest;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public class RepositorioUsuarioTest extends SpringTest{

	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	@Test
	@Transactional
	@Rollback
	public void seGuardaElUsuario() {
		
		Usuario usuario = new Usuario();
		
		repositorioUsuario.guardar(usuario);
		
		assertThat(usuario.getId()).isNotNull();
	}
	//1:22
}
