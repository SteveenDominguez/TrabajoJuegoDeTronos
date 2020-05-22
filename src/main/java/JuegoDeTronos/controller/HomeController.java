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

import JuegoDeTronos.model.Noble;
import JuegoDeTronos.model.Plebeyo;
import JuegoDeTronos.model.Region;
import JuegoDeTronos.service.INobleService;
import JuegoDeTronos.service.IPlebeyoService;
import JuegoDeTronos.service.IRegionService;

@Controller
public class HomeController {

	@Autowired
	private IRegionService regi;
	@Autowired
	private INobleService nob;
	@Autowired
	private IPlebeyoService pleb;

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
	//Controladores para insertar regiones
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
	//Fin controladores para insertar regiones
	
	@RequestMapping(value = "/eliminarRegion/{id}")
	public String eliminarRegion(@PathVariable("id") int id,Model modelo) {
		regi.eliminar(id);
		List<Region> regiones=regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		return "redirect:/listarRegiones";
	}

	@RequestMapping(value="/editarRegion/{id}")
	public String editarRegion(@PathVariable("id") int id,Model modelo) {
		Region eldato=regi.encontrarPorId(id);
		modelo.addAttribute("region",eldato);
		return "editarRegiones";
	}

	@PostMapping(value="/editarRegion/guardarNuevaRegion")
	public String guardarNuevaRegion(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("clima") String clima, @RequestParam("mapa") String mapa)
	{
		Region eldato=regi.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setClima(clima);
		eldato.setMapa(mapa);
		regi.guardar(eldato);
		List<Region> regiones=regi.listarRegiones();

		modelo.addAttribute("regiones",regiones);
		return "redirect:/listarRegiones";
	}
	
	@RequestMapping(value= "/listarNobles", method = RequestMethod.GET)
	public String ListarNobles(Model modelo) {
		List<Noble> nobles= nob.listarNobles();
		modelo.addAttribute("nobles",nobles);
		return "listarNobles";
	}
	//Controladores para insertar nobles
	@RequestMapping(value = "/insertarNobles")
	public String InsertarNobles() {
		return "insertarNobles";
	}

	@PostMapping(value = "/guardarNobles")
	public String guardarNobles(Model modelo, @RequestParam("id") int id, 
			@RequestParam("nombre") String nombre) {
		String digno;
		double probabilidad=Math.random()*100;
		if (probabilidad<=15) {
			digno="SI";
		} else {
			digno="NO";
		}
		Noble noble= new Noble(id,nombre,digno);
		nob.guardar(noble);
		List<Noble> nobles= nob.listarNobles();
		modelo.addAttribute("nobles",nobles);
		return "listarNobles";
	}
	//Fin controladores para insertar nobles
	
	@RequestMapping(value = "/eliminarNoble/{id}")
	public String eliminarNoble(@PathVariable("id") int id,Model modelo) {
		nob.eliminar(id);
		List<Noble> nobles=nob.listarNobles();
		modelo.addAttribute("nobles",nobles);
		return "redirect:/listarNobles";
	}

	@RequestMapping(value="/editarNoble/{id}")
	public String editarNoble(@PathVariable("id") int id,Model modelo) {
		Noble eldato=nob.encontrarPorId(id);
		modelo.addAttribute("noble",eldato);
		return "editarNobles";
	}

	@PostMapping(value="/editarNoble/guardarNuevoNoble")
	public String guardarNuevoNoble(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("digno") String digno)
	{
		Noble eldato=nob.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setDigno(digno);
		nob.guardar(eldato);
		List<Noble> nobles=nob.listarNobles();
		modelo.addAttribute("nobles",nobles);
		return "redirect:/listarNobles";
	}
	
	@RequestMapping(value= "/listarPlebeyos", method = RequestMethod.GET)
	public String ListarPlebeyos(Model modelo) {
		List<Plebeyo> plebeyos= pleb.listarPlebeyos();
		modelo.addAttribute("plebeyos",plebeyos);
		return "listarPlebeyos";
	}
	//Controladores para insertar plebeyos
	@RequestMapping(value = "/insertarPlebeyos")
	public String InsertarPlebeyos() {
		return "insertarPlebeyos";
	}

	@PostMapping(value = "/guardarPlebeyos")
	public String guardarPlebeyos(@ModelAttribute Plebeyo plebeyo, BindingResult result,Model modelo) {
		pleb.guardar(plebeyo);
		List<Plebeyo> plebeyos= pleb.listarPlebeyos();
		modelo.addAttribute("plebeyos",plebeyos);
		return "listarPlebeyos";
	}
	//Fin controladores para insertar plebeyos
	
	@RequestMapping(value = "/eliminarPlebeyo/{id}")
	public String eliminarPlebeyo(@PathVariable("id") int id,Model modelo) {
		pleb.eliminar(id);
		List<Plebeyo>plebeyos=pleb.listarPlebeyos();
		modelo.addAttribute("plebeyos",plebeyos);
		return "redirect:/listarPlebeyos";
	}

	@RequestMapping(value="/editarPlebeyo/{id}")
	public String editarPlebeyo(@PathVariable("id") int id,Model modelo) {
		Plebeyo eldato=pleb.encontrarPorId(id);
		modelo.addAttribute("plebeyo",eldato);
		return "editarPlebeyos";
	}

	@PostMapping(value="/editarPlebeyo/guardarNuevoPlebeyo")
	public String guardarNuevoPlebeyo(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("foto") String foto)
	{
		Plebeyo eldato=pleb.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setFoto(foto);
		pleb.guardar(eldato);
		List<Plebeyo> plebeyos=pleb.listarPlebeyos();
		modelo.addAttribute("plebeyos",plebeyos);
		return "redirect:/listarPlebeyos";
	}
	
}
