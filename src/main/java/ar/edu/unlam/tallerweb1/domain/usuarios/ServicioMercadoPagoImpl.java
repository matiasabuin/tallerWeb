package ar.edu.unlam.tallerweb1.domain.usuarios;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;

@Service("servicioMercadoPago")
@Transactional
public class ServicioMercadoPagoImpl implements ServicioMercadoPago {

	public ServicioMercadoPagoImpl() {

	}

	@Override
	public Preference obtenerPreferenciaPremium(Plan planPremium, Plan planBasico, Usuario usuario) throws MPException {
		Float precio;
		
		if (usuario.getPlanAdquirido().getPlan().getDescripcion().equals("Basico")) {
			precio = (float) (planPremium.getPrecio() - planBasico.getPrecio());
		} else {
			precio = (float) planPremium.getPrecio();
		}
		
		Preference preferenciaPremium = new Preference();
		MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
		Preference p2 = new Preference();
		Item item2 = new Item();
		item2.setTitle("Adquirir Premium").setQuantity(1).setUnitPrice(precio);
		p2.appendItem(item2);
		Payer payer2 = new Payer();
		payer2.setEmail(usuario.getEmail());
		p2.setPayer(payer2);
		BackUrls backUrls2 = new BackUrls("http://localhost:8080/proyecto-limpio-spring/adquirir-premium",
				"http://localhost:8080/proyecto-limpio-spring/editar-plan",
				"http://localhost:8080/proyecto-limpio-spring/editar-plan");
		p2.setBackUrls(backUrls2);
		p2.setBinaryMode(true);
		preferenciaPremium = p2.save();
		return preferenciaPremium;
	}

	@Override
	public Preference obtenerPreferenciaBasico(Plan planBasico, Usuario usuario) throws MPException {
		Preference preferenciaBasico = new Preference();
		MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
		Preference p1 = new Preference();
		Item item1 = new Item();
		item1.setTitle("Adquirir Basico").setQuantity(1).setUnitPrice((float) planBasico.getPrecio());
		p1.appendItem(item1);
		Payer payer1 = new Payer();
		payer1.setEmail(usuario.getEmail());
		p1.setPayer(payer1);
		BackUrls backUrls1 = new BackUrls("http://localhost:8080/proyecto-limpio-spring/adquirir-basico",
				"http://localhost:8080/proyecto-limpio-spring/editar-plan",
				"http://localhost:8080/proyecto-limpio-spring/editar-plan");
		p1.setBackUrls(backUrls1);
		p1.setBinaryMode(true);
		preferenciaBasico = p1.save();
		return preferenciaBasico;
	}

}
