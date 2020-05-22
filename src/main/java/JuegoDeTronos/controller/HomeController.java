package JuegoDeTronos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import JuegoDeTronos.model.Region;
import JuegoDeTronos.service.IRegionService;

@Controller
public class HomeController {

	@Autowired
	private IRegionService regi;

	@RequestMapping(value= "/", method = RequestMethod.GET)
	public String HomePage() {
		return "home";
	}

	@RequestMapping(value= "/listarRegiones", method = RequestMethod.GET)
	public String ListarRegiones(Model modelo) {
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		return "listarRegiones";
	}

	@RequestMapping(value = "/insertarRegiones")
	public String InsertarRegiones() {
		return "insertarRegiones";
	}

	@PostMapping(value = "/guardarRegiones")
	public String guardarRegiones(@ModelAttribute Region region, BindingResult result,Model modelo) {
		regi.guardar(region);
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		return "listarRegiones";
	}

	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarRegion(@PathVariable("id") int id,Model modelo) {
		regi.eliminar(id);
		List<Region> regiones=regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		return "redirect:/listarRegiones";
	}

	@RequestMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int id,Model modelo) {
		Region eldato=regi.encontrarPorId(id);
		modelo.addAttribute("region",eldato);
		return "editarRegiones";
	}

	@PostMapping(value="/edit/guardarNuevaRegion")
	public String guardar(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("clima") String clima, @RequestParam("mapa") String mapa)
	{
		Region eldato=regi.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setClima(clima);
		eldato.setMapa(mapa);
		regi.guardar(eldato);
		List<Region> regiones=regi.listarRegiones();

		modelo.addAttribute("regiones",regiones);
		return "listarRegiones";
	}


}
