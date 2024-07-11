package gob.cpccs.controller.rendicion;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gob.cpccs.utilidades.Constantes;


@Controller
public class SubCoordinadorController {


	@RequestMapping("/view/rendicion/listaSubCoordinador")
	public String listaInstituciones(Model model) {

		if (hasRole("ROLE_NACIONAL")) {
			model.addAttribute("rol", "Nacional");
		} else if (hasRole("ROLE_PROVINCIAL")) {
			model.addAttribute("rol", "Provincial");
		} else if (hasRole("ROLE_ADMIN")) {
			model.addAttribute("rol", "Adminnistrador");
		}
				
		List<Integer> anios = IntStream.range(Integer.parseInt(Constantes.PERIODP_INICIO_SISTEMA), Calendar.getInstance()
				.get(Calendar.YEAR))
				.boxed()
				.collect(Collectors.toList());

		model.addAttribute("anios", anios);
		
		return "rendicion/listaSubCoordinador";
	}

	private boolean hasRole(String role) {

		SecurityContext context = SecurityContextHolder.getContext();

		if (context == null) {
			return false;
		}

		Authentication auth = context.getAuthentication();

		if (auth == null) {
			return false;
		}

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		return authorities.contains(new SimpleGrantedAuthority(role));

	}

}
