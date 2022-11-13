package ar.edu.unlam.tallerweb1.domain.usuarios;

import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

public interface ServicioMercadoPago {

	Preference obtenerPreferenciaPremium(Plan planPremium, Plan planBasico, Usuario usuario) throws MPException;
	Preference obtenerPreferenciaBasico(Plan planBasico, Usuario usuario) throws MPException;
	
}
