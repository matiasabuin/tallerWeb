package ar.edu.unlam.tallerweb1.delivery;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.Preference.AutoReturn;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;

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
		
		if(request.getSession().getAttribute("usuarioActual") == null){
			return new ModelAndView("redirect:/home");
		}
		
		ModelMap modelo = new ModelMap();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioActual");
		
        Plan planPremium = servicioPlan.ObtenerPlanPremium();
        Preference preferenciaPremium = new Preference();
        try{
            MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
            Preference p2 = new Preference();
            Item item2 = new Item();
            item2.setTitle("Adquirir Premium").setQuantity(1).setUnitPrice((float) planPremium.getPrecio());
            p2.appendItem(item2);
            Payer payer2 = new Payer();
            payer2.setEmail(usuario.getEmail());
            p2.setPayer(payer2);
            BackUrls backUrls2 = new BackUrls(
                    "http://localhost:8080/proyecto-limpio-spring/adquirir-premium",
                    "http://localhost:8080/proyecto-limpio-spring/editar-plan",
                    "http://localhost:8080/proyecto-limpio-spring/editar-plan");
            p2.setBackUrls(backUrls2);
            p2.setBinaryMode(true);
            preferenciaPremium = p2.save();
        }catch (MPException e){
            System.out.println("Exeception MP\n");
            e.printStackTrace();
        }
        
		Plan planBasico = servicioPlan.ObtenerPlanBasico();
        Preference preferenciaBasico = new Preference();
        try{
            MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
            Preference p1 = new Preference();
            Item item1 = new Item();
            item1.setTitle("Adquirir Basico").setQuantity(1).setUnitPrice((float)planBasico.getPrecio());
            p1.appendItem(item1);
            Payer payer1 = new Payer();
            payer1.setEmail(usuario.getEmail());
            p1.setPayer(payer1);
            BackUrls backUrls1 = new BackUrls(
                    "http://localhost:8080/proyecto-limpio-spring/adquirir-basico",
                    "http://localhost:8080/proyecto-limpio-spring/editar-plan",
                    "http://localhost:8080/proyecto-limpio-spring/editar-plan");
            p1.setBackUrls(backUrls1);
            p1.setBinaryMode(true);
            preferenciaBasico = p1.save();
        }catch (MPException e){
            System.out.println("Exeception MP\n");
            e.printStackTrace();
        }
        
		modelo.addAttribute("preferenceBasico", preferenciaBasico);
		modelo.addAttribute("preferencePremium", preferenciaPremium);
		return new ModelAndView("editar-plan", modelo);
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
	
	@RequestMapping(path = "/adquirir-basico")
	public ModelAndView adquirirBasico(HttpServletRequest request) throws Exception {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanBasico();
		
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioBuscado);
		request.getSession().setAttribute("usuarioActual", usuarioBuscado);
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		
		return new ModelAndView("redirect:/editar-plan");
	}
	
	@RequestMapping(path = "/adquirir-premium")
	public ModelAndView adquirirPremium(HttpServletRequest request) throws Exception {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanPremium();
				
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioBuscado);
		request.getSession().setAttribute("usuarioActual", usuarioBuscado);
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		
		return new ModelAndView("redirect:/editar-plan");
	}
	
}
