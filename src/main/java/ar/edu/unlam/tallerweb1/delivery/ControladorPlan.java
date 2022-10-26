package ar.edu.unlam.tallerweb1.delivery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuarioPlan;

@Controller
public class ControladorPlan {

	private ServicioPlan servicioPlan;
	private ServicioUsuarioPlan servicioUsuarioPlan;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorPlan(ServicioPlan servicioPlan, ServicioUsuarioPlan servicioUsuarioPlan, ServicioLogin servicioLogin){
		this.servicioPlan = servicioPlan;
		this.servicioUsuarioPlan = servicioUsuarioPlan;
		this.servicioLogin = servicioLogin;
	}
	
	@RequestMapping("/editar-plan")
	public ModelAndView irAPlanes(HttpServletRequest request){
		
		if(request.getSession().getAttribute("usuarioActual") != null){
		ModelMap modelo = new ModelMap();
		
//		MercadoPagoConfig.setAccessToken("TEST-1201136963232493-101808-75b094b9e2177fe6f2f324f2ea3b1185-204992006");
//		// Crea un objeto de preferencia
//		PreferenceClient client = new PreferenceClient();
//
//		// Crea un ítem en la preferencia
//		List<PreferenceItemRequest> items = new ArrayList<>();
//		PreferenceItemRequest item =
//		   PreferenceItemRequest.builder()
//		   		.id("compra")
//		        .title("Plan Premium")
//		        .quantity(1)
//		        .unitPrice(new BigDecimal("200"))
//		        .build();
//		items.add(item);
//
//		PreferenceRequest request1 = PreferenceRequest.builder().items(items).build();
//
//	    try {
//	    	client.create(request1);
//	      } catch (MPApiException ex) {
//	        System.out.printf(
//	            "MercadoPago Error. Status: %s, Content: %s%n",
//	            ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
//	      } catch (MPException ex) {
//	        ex.printStackTrace();
//	      }
//		modelo.addAttribute("compra", item);
		
		return new ModelAndView("editar-plan", modelo);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path = "/adquirir-free", method = RequestMethod.POST)
	public ModelAndView adquirirFree(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanFree();
		
		UsuarioPlan usuarioplan = 
				servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().minusDays(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		
		servicioLogin.editarPerfil(usuarioBuscado);
		
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		
		return new ModelAndView("redirect:/editar-plan");
	}
	
	@RequestMapping(path = "/adquirir-basico", method = RequestMethod.POST)
	public ModelAndView adquirirBasico(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanBasico();
		
		UsuarioPlan usuarioplan = 
				servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		
		servicioLogin.editarPerfil(usuarioBuscado);
		
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		
		return new ModelAndView("redirect:/editar-plan");
	}
	
	@RequestMapping(path = "/adquirir-premium", method = RequestMethod.POST)
	public ModelAndView adquirirPremium(HttpServletRequest request) {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanPremium();
		
		UsuarioPlan usuarioplan = 
				servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		
		servicioLogin.editarPerfil(usuarioBuscado);
		
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		
		return new ModelAndView("redirect:/editar-plan");
	}
}
