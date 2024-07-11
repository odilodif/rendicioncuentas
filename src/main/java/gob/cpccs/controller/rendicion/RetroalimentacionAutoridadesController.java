package gob.cpccs.controller.rendicion;


import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class RetroalimentacionAutoridadesController {


	@RequestMapping("/view/rendicion/listaInformesValoradosAutoridades")
	public String AsignacionInformes(Model model, @RequestParam("opcion") int idMenu, Authentication authentication) {
		
		List<Integer> anios = IntStream.range(2020, Calendar.getInstance().get(Calendar.YEAR))
										.boxed()
										.collect(Collectors.toList());
		
			model.addAttribute("anios", anios);
			
			Calendar fecha = Calendar.getInstance();
			fecha.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE);
			
		return "rendicion/listaInformesValoradosAutoridades";
	}


}
