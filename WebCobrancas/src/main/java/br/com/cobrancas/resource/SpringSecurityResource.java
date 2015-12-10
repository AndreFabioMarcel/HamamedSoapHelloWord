package br.com.cobrancas.resource;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Path("auth")
@Stateless
@RestController
@Consumes("application/json")
//@Produces("text/plain")
public class SpringSecurityResource {
	
	//@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
        @GET
        @Path("/")
        @Produces("text/plain")        
	public String homePage(ModelMap model) {
		model.addAttribute("greeting", "Hi, Welcome to mysite");
		return "welcome";
	}

	//@RequestMapping(value = "/admin", method = RequestMethod.GET)
        @GET
        @Path("/admin")
        @Produces("text/plain")
	public  String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "admin";
	}
	
	//@RequestMapping(value = "/db", method = RequestMethod.GET)
        @GET
        @Path("/db")
        @Produces("text/plain")
	public  String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

	//@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
        @GET
        @Path("/Access_Denied")
	public  String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	//@RequestMapping(value = "/login", method = RequestMethod.GET)
        @GET
        @Path("/login")
        @Produces("text/plain")
	public  String loginPage() {
		return "login";
	}

	//@RequestMapping(value="/logout", method = RequestMethod.GET)
        @GET
        @Path("/logout")
        @Produces("application/json")
	public @ResponseBody String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}