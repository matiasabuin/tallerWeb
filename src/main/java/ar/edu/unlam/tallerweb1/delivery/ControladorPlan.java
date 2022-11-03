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
		
        Preference preferenciaBasico = new Preference();
        try{
            MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
            Preference p = new Preference();
            Item item = new Item();
            item.setTitle("Adquirir Basico").setQuantity(1).setUnitPrice((float) 500);
            p.appendItem(item);
            Payer payer = new Payer();
            payer.setEmail(usuario.getEmail());
            p.setPayer(payer);
            p.setBinaryMode(true);
            preferenciaBasico = p.save();
        }catch (MPException e){
            System.out.println("Exeception MP\n");
            e.printStackTrace();
        }
		
        Preference preferenciaPremium = new Preference();
        try{
            MercadoPago.SDK.setAccessToken("TEST-1735674503019884-032202-d54a673969e467b857cf50292aaedaa6-201226814");
            Preference p = new Preference();
            Item item = new Item();
            item.setTitle("Adquirir Premium").setQuantity(1).setUnitPrice((float) 1000);
            p.appendItem(item);
            Payer payer = new Payer();
            payer.setEmail(usuario.getEmail());
            p.setPayer(payer);
            p.setBinaryMode(true);
            preferenciaPremium = p.save();
        }catch (MPException e){
            System.out.println("Exeception MP\n");
            e.printStackTrace();
        }
        
		modelo.addAttribute("preferenceBasico", preferenciaBasico);
		modelo.addAttribute("preferencePremium", preferenciaPremium);
		return new ModelAndView("editar-plan", modelo);
	}
	
	@RequestMapping(path = "/adquirir-free", method = RequestMethod.POST)
	public ModelAndView adquirirFree(HttpServletRequest request) throws Exception {
		
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
	public ModelAndView adquirirBasico(@RequestParam(value = "payment_status") String estado, HttpServletRequest request) throws Exception {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanBasico();
		
		if(estado.equals("approved")){
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioBuscado);
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		} 
		
		return new ModelAndView("redirect:/editar-plan");
	}
	
	@RequestMapping(path = "/adquirir-premium", method = RequestMethod.POST)
	public ModelAndView adquirirPremium(@RequestParam(value = "payment_status") String estado, HttpServletRequest request) throws Exception {
		
		Usuario usuarioBuscado = (Usuario) request.getSession().getAttribute("usuarioActual");
		Plan planBuscado = servicioPlan.ObtenerPlanPremium();
		
		if(estado.equals("approved")){
		UsuarioPlan usuarioplan = servicioUsuarioPlan.registrarUsuarioPlan(usuarioBuscado, planBuscado, LocalDate.now().plusMonths(1));
		usuarioBuscado.setPlanAdquirido(usuarioplan);
		servicioLogin.editarPerfil(usuarioBuscado);
		request.getSession().setAttribute("usuarioPlan", usuarioBuscado.getPlanAdquirido().getPlan().getDescripcion());
		}
		
		return new ModelAndView("redirect:/editar-plan");
	}
}
