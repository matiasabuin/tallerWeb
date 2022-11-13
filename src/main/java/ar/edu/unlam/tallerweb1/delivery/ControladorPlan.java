package ar.edu.unlam.tallerweb1.delivery;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import ar.edu.unlam.tallerweb1.domain.pedidos.Plan;
import ar.edu.unlam.tallerweb1.domain.pedidos.Usuario;
import ar.edu.unlam.tallerweb1.domain.pedidos.UsuarioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioMercadoPago;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioNotificacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioPlan;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuarioPlan;

@Controller
public class ControladorPlan {

	private ServicioPlan servicioPlan;
	private ServicioUsuarioPlan servicioUsuarioPlan;
	private ServicioLogin servicioLogin;
	private ServicioMercadoPago servicioMercadoPago;

	@Autowired
	public ControladorPlan(ServicioPlan servicioPlan, ServicioUsuarioPlan servicioUsuarioPlan,
			ServicioLogin servicioLogin, ServicioMercadoPago servicioMercadoPago) {
		this.servicioPlan = servicioPlan;
		this.servicioUsuarioPlan = servicioUsuarioPlan;
		this.servicioLogin = servicioLogin;
		this.servicioMercadoPago = servicioMercadoPago;
	}

	@RequestMapping("/editar-plan")
	public ModelAndView irAPlanes(HttpServletRequest request) {

		if (request.getSession().getAttribute("usuarioActual") == null) {
			return new ModelAndView("redirect:/home");
		}

		ModelMap modelo = new ModelMap();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioActual");

		Plan planBasico = servicioPlan.ObtenerPlanBasico();
		Preference preferenciaBasico = new Preference();
		try {
			preferenciaBasico = servicioMercadoPago.obtenerPreferenciaBasico(planBasico, usuario);
		} catch (MPException e) {
			e.printStackTrace();
		}

		Plan planPremium = servicioPlan.ObtenerPlanPremium();
		Preference preferenciaPremium = new Preference();
		try {
			preferenciaPremium = servicioMercadoPago.obtenerPreferenciaPremium(planPremium, planBasico, usuario);
		} catch (MPException e) {
			e.printStackTrace();
		}

		Float precioDescuento = preferenciaPremium.getItems().get(0).getUnitPrice();
		Float precioBasico = (float) planBasico.getPrecio();
		Float precioPremium = (float) planPremium.getPrecio();
		
		modelo.addAttribute("precioBasico", precioBasico);
		modelo.addAttribute("precioPremium", precioPremium);
		modelo.addAttribute("descuento", precioDescuento);
		modelo.addAttribute("preferenceBasico", preferenciaBasico);
		modelo.addAttribute("preferencePremium", preferenciaPremium);
		return new ModelAndView("editar-plan", modelo);
	}

	@RequestMapping(path = "/adquirir-basico")
	public ModelAndView adquirirBasico(HttpServletRequest request) throws Exception {

		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanBasico();

		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioActual, planBuscado,
				LocalDate.now().plusMonths(1));
		usuarioActual.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioActual);

		request.getSession().setAttribute("usuarioActual", usuarioActual);
		request.getSession().setAttribute("usuarioPlan", usuarioActual.getPlanAdquirido().getPlan().getDescripcion());

		return new ModelAndView("redirect:/editar-plan");
	}

	@RequestMapping(path = "/adquirir-premium")
	public ModelAndView adquirirPremium(HttpServletRequest request) throws Exception {

		Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanPremium();

		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioActual, planBuscado,
				LocalDate.now().plusMonths(1));
		usuarioActual.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioActual);

		request.getSession().setAttribute("usuarioActual", usuarioActual);
		request.getSession().setAttribute("usuarioPlan", usuarioActual.getPlanAdquirido().getPlan().getDescripcion());

		return new ModelAndView("redirect:/editar-plan");
	}

//	@RequestMapping(path = "/adquirir-free", method = RequestMethod.GET)
//	public ModelAndView adquirirFree(HttpServletRequest request) throws Exception {
//		
//		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
//		Plan planBuscado = servicioPlan.ObtenerPlanFree();
//		
//		UsuarioPlan usuarioplan = 
//				servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().minusDays(1));
//		usuarioBuscado.setPlanAdquirido(usuarioplan);
//		
//		servicioLogin.editarPerfil(usuarioBuscado);
//		
//		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
//		
//		return new ModelAndView("redirect:/editar-plan");
//	}

}
