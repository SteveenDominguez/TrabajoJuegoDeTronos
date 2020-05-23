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

import JuegoDeTronos.model.Amorio;
import JuegoDeTronos.model.Dragon;
import JuegoDeTronos.model.Guerrero;
import JuegoDeTronos.model.Noble;
import JuegoDeTronos.model.Plebeyo;
import JuegoDeTronos.model.Producto;
import JuegoDeTronos.model.Region;
import JuegoDeTronos.model.Subdito;
import JuegoDeTronos.service.IAmorioService;
import JuegoDeTronos.service.IDragonService;
import JuegoDeTronos.service.IGuerreroService;
import JuegoDeTronos.service.INobleService;
import JuegoDeTronos.service.IPlebeyoService;
import JuegoDeTronos.service.IProductoService;
import JuegoDeTronos.service.IRegionService;
import JuegoDeTronos.service.ISubditoService;

@Controller
public class HomeController {

	@Autowired
	private IRegionService regi;
	@Autowired
	private INobleService nob;
	@Autowired
	private IPlebeyoService pleb;
	@Autowired
	private IDragonService drago;
	@Autowired
	private IGuerreroService guerre;
	@Autowired
	private IProductoService prod;
	@Autowired
	private IAmorioService amo;
	@Autowired
	private ISubditoService sub;

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

	@RequestMapping(value= "/listarDragones", method = RequestMethod.GET)
	public String ListarDragones(Model modelo) {
		List<Dragon> dragones= drago.listarDragones();
		modelo.addAttribute("dragones",dragones);
		return "listarDragones";
	}
	//Controladores para insertar dragones
	@RequestMapping(value = "/insertarDragones")
	public String InsertarDragones(Model model) {
		List<Region> regiones= regi.listarRegiones();
		model.addAttribute("regiones",regiones);
		return "insertarDragones";
	}

	@PostMapping(value = "/guardarDragones")
	public String guardarDragones(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("edad") String edad, @RequestParam("fuerza") String fuerza, @RequestParam("color") String color, @RequestParam("numAsesinatos") String numAsesinatos,
	@RequestParam("comidaFavorita") String comidaFavorita, @RequestParam("region") int id_region) {
		Region region= regi.encontrarPorId(id_region);
		Dragon dragon= new Dragon(id, nombre, edad, fuerza, color, numAsesinatos, comidaFavorita, region);
		drago.guardar(dragon);
		List<Dragon> dragones= drago.listarDragones();
		modelo.addAttribute("dragones",dragones);
		return "listarDragones";
	}
	//Fin controladores para insertar dragones

	@RequestMapping(value = "/eliminarDragon/{id}")
	public String eliminarDragon(@PathVariable("id") int id,Model modelo) {
		drago.eliminar(id);
		List<Dragon>dragones=drago.listarDragones();
		modelo.addAttribute("dragones",dragones);
		return "redirect:/listarDragones";
	}

	@RequestMapping(value="/editarDragon/{id}")
	public String editarDragon(@PathVariable("id") int id,Model modelo) {
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		Dragon eldato=drago.encontrarPorId(id);
		modelo.addAttribute("dragon",eldato);
		return "editarDragones";
	}

	@PostMapping(value="/editarDragon/guardarNuevoDragon")
	public String guardarNuevoDragon(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("edad") String edad, @RequestParam("fuerza") String fuerza, @RequestParam("color") String color, @RequestParam("numAsesinatos") String numAsesinatos,
	@RequestParam("comidaFavorita") String comidaFavorita, @RequestParam("region") int id_region)
	{
		Dragon eldato=drago.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setEdad(edad);
		eldato.setFuerza(fuerza);
		eldato.setColor(color);
		eldato.setNumAsesinatos(numAsesinatos);
		eldato.setComidaFavorita(comidaFavorita);
		Region region= regi.encontrarPorId(id_region);
		eldato.setRegion(region);

		drago.guardar(eldato);
		List<Dragon> dragones=drago.listarDragones();
		modelo.addAttribute("dragones",dragones);
		return "redirect:/listarDragones";
	}
	
	@RequestMapping(value= "/listarGuerreros", method = RequestMethod.GET)
	public String ListarGuerreros(Model modelo) {
		List<Guerrero> guerreros= guerre.listarGuerreros();
		modelo.addAttribute("guerreros",guerreros);
		return "listarGuerreros";
	}
	//Controladores para insertar guerreros
	@RequestMapping(value = "/insertarGuerreros")
	public String InsertarGuerreros(Model model) {
		List<Region> regiones= regi.listarRegiones();
		model.addAttribute("regiones",regiones);
		return "insertarGuerreros";
	}

	@PostMapping(value = "/guardarGuerreros")
	public String guardarGuerreros(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("especialidad") String especialidad, @RequestParam("cargo") String cargo, @RequestParam("numAsesinatos") String numAsesinatos,
	@RequestParam("interes") String interes, @RequestParam("region") int id_region) {
		Region region= regi.encontrarPorId(id_region);
		Guerrero guerrero= new Guerrero(id, nombre, especialidad, cargo, numAsesinatos, interes, region);
		guerre.guardar(guerrero);
		List<Guerrero> guerreros= guerre.listarGuerreros();
		modelo.addAttribute("guerreros",guerreros);
		return "listarGuerreros";
	}
	//Fin controladores para insertar guerreros

	@RequestMapping(value = "/eliminarGuerrero/{id}")
	public String eliminarGuerrero(@PathVariable("id") int id,Model modelo) {
		guerre.eliminar(id);
		List<Guerrero>guerreros=guerre.listarGuerreros();
		modelo.addAttribute("guerreros",guerreros);
		return "redirect:/listarGuerreros";
	}

	@RequestMapping(value="/editarGuerrero/{id}")
	public String editarGuerrero(@PathVariable("id") int id,Model modelo) {
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		Guerrero eldato=guerre.encontrarPorId(id);
		modelo.addAttribute("guerrero",eldato);
		return "editarGuerreros";
	}

	@PostMapping(value="/editarGuerrero/guardarNuevoGuerrero")
	public String guardarNuevoGuerrero(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("especialidad") String especialidad, @RequestParam("cargo") String cargo, @RequestParam("numAsesinatos") String numAsesinatos,
	@RequestParam("interes") String interes, @RequestParam("region") int id_region)
	{
		Guerrero eldato=guerre.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setEspecialdiad(especialidad);
		eldato.setCargo(cargo);
		eldato.setNumAsesinatos(numAsesinatos);
		eldato.setInteres(interes);
		Region region= regi.encontrarPorId(id_region);
		eldato.setRegion(region);

		guerre.guardar(eldato);
		List<Guerrero> guerreros=guerre.listarGuerreros();
		modelo.addAttribute("guerreros",guerreros);
		return "redirect:/listarGuerreros";
	}
	
	@RequestMapping(value= "/listarProductos", method = RequestMethod.GET)
	public String ListarProductos(Model modelo) {
		List<Producto> productos= prod.listarProductos();
		modelo.addAttribute("productos",productos);
		return "listarProductos";
	}
	//Controladores para insertar productos
	@RequestMapping(value = "/insertarProductos")
	public String InsertarProductos(Model modelo) {
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		return "insertarProductos";
	}

	@PostMapping(value = "/guardarProductos")
	public String guardarProductos(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("region") int id_region) {
		Region region= regi.encontrarPorId(id_region);
		Producto producto= new Producto(id,nombre,region);
		prod.guardar(producto);
		List<Producto> productos= prod.listarProductos();
		modelo.addAttribute("productos",productos);
		return "listarProductos";
	}
	//Fin controladores para insertar productos
	
	@RequestMapping(value = "/eliminarProducto/{id}")
	public String eliminarProductos(@PathVariable("id") int id,Model modelo) {
		prod.eliminar(id);
		List<Producto> productos=prod.listarProductos();
		modelo.addAttribute("productos",productos);
		return "redirect:/listarProductos";
	}

	@RequestMapping(value="/editarProducto/{id}")
	public String editarProducto(@PathVariable("id") int id,Model modelo) {
		Producto eldato=prod.encontrarPorId(id);
		List<Region> region=regi.listarRegiones();
		modelo.addAttribute("producto",eldato);
		modelo.addAttribute("region", region);
		return "editarProductos";
	}

	@PostMapping(value="/editarProducto/guardarNuevoProducto")
	public String guardarNuevoProducto(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("region") int id_region)
	{
		Producto eldato=prod.encontrarPorId(id);
		eldato.setNombre(nombre);
		Region region=regi.encontrarPorId(id_region);
		eldato.setRegion(region);
		prod.guardar(eldato);
		List<Producto> productos=prod.listarProductos();
		modelo.addAttribute("productos",productos);
		return "redirect:/listarProductos";
	}
	
	@RequestMapping(value= "/listarAmorios", method = RequestMethod.GET)
	public String ListarAmorios(Model modelo) {
		List<Amorio> amorios= amo.listarAmorios();
		modelo.addAttribute("amorios",amorios);
		return "listarAmorios";
	}
	//Controladores para insertar productos
	@RequestMapping(value = "/insertarAmorios")
	public String InsertarAmorios(Model modelo) {
		List<Plebeyo> plebeyos=pleb.listarPlebeyos();
		List<Noble> nobles=nob.listarNobles();
		List<Region> regiones=regi.listarRegiones();
		modelo.addAttribute("plebeyos", plebeyos);
		modelo.addAttribute("nobles", nobles);
		modelo.addAttribute("regiones", regiones);
		return "insertarAmorios";
	}

	@PostMapping(value = "/guardarAmorios")
	public String guardarAmorios(Model modelo, @RequestParam("id") int id, @RequestParam("plebeyo") 
	int id_plebeyo, @RequestParam("noble") int id_noble,@RequestParam("region") int id_region) {
		Plebeyo plebeyo=pleb.encontrarPorId(id_plebeyo);
		Noble noble= nob.encontrarPorId(id_noble);
		Region region= regi.encontrarPorId(id_region);
		Amorio amorio= new Amorio(id,plebeyo,noble,region);
		amo.guardar(amorio);
		List<Amorio> amorios= amo.listarAmorios();
		modelo.addAttribute("amorios",amorios);
		return "listarAmorios";
	}
	//Fin controladores para insertar productos
	
	@RequestMapping(value = "/eliminarAmorio/{id}")
	public String eliminarAmorio(@PathVariable("id") int id,Model modelo) {
		amo.eliminar(id);
		List<Amorio> amorios=amo.listarAmorios();
		modelo.addAttribute("amorios",amorios);
		return "redirect:/listarAmorios";
	}

	@RequestMapping(value="/editarAmorio/{id}")
	public String editarAmorio(@PathVariable("id") int id,Model modelo) {
		Amorio eldato=amo.encontrarPorId(id);
		modelo.addAttribute("amorio",eldato);
		List<Plebeyo> plebeyos=pleb.listarPlebeyos();
		List<Noble> nobles=nob.listarNobles();
		List<Region> regiones=regi.listarRegiones();
		modelo.addAttribute("plebeyos", plebeyos);
		modelo.addAttribute("nobles", nobles);
		modelo.addAttribute("regiones", regiones);
		return "editarAmorios";
	}

	@PostMapping(value="/editarAmorio/guardarNuevoAmorio")
	public String guardarNuevoAmorio(Model modelo, @RequestParam("id") int id, @RequestParam("plebeyo") 
	int id_plebeyo, @RequestParam("noble") int id_noble, @RequestParam("region") int id_Region)
	{
		Amorio eldato=amo.encontrarPorId(id);
		Plebeyo plebeyo=pleb.encontrarPorId(id_plebeyo);
		Noble noble=nob.encontrarPorId(id_noble);
		Region region=regi.encontrarPorId(id_Region);
		eldato.setPlebeyo(plebeyo);
		eldato.setNoble(noble);
		eldato.setRegion(region);
		amo.guardar(eldato);
		List<Amorio> amorios=amo.listarAmorios();
		modelo.addAttribute("amorios",amorios);
		return "redirect:/listarAmorios";
	}
	
	@RequestMapping(value= "/listarSubditos", method = RequestMethod.GET)
	public String ListarSubditos(Model modelo) {
		List<Subdito> subditos= sub.listarSubditos();
		modelo.addAttribute("subditos",subditos);
		return "listarSubditos";
	}
	//Controladores para insertar subditos
	@RequestMapping(value = "/insertarSubditos")
	public String InsertarSubditos(Model model) {
		List<Subdito> subditos= sub.listarSubditos();
		model.addAttribute("subditos",subditos);
		List<Region> regiones= regi.listarRegiones();
		model.addAttribute("regiones",regiones);
		return "insertarSubditos";
	}

	@PostMapping(value = "/guardarSubditos")
	public String guardarSubditos(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("numHijos") int numHijos, @RequestParam("problema") String problema,
	@RequestParam("padre") int id_padre, @RequestParam("region") int id_region) {
		Subdito padre= sub.encontrarPorId(id_padre);
		Region region= regi.encontrarPorId(id_region);
		Subdito subdito= new Subdito(id, nombre, numHijos, problema, padre, region);
		sub.guardar(subdito);
		List<Subdito> subditos= sub.listarSubditos();
		modelo.addAttribute("subditos",subditos);
		return "listarSubditos";
	}
	//Fin controladores para insertar subditos

	@RequestMapping(value = "/eliminarSubdito/{id}")
	public String eliminarSubdito(@PathVariable("id") int id,Model modelo) {
		sub.eliminar(id);
		List<Subdito>subditos=sub.listarSubditos();
		modelo.addAttribute("subditos",subditos);
		return "redirect:/listarSubditos";
	}

	@RequestMapping(value="/editarSubdito/{id}")
	public String editarSubdito(@PathVariable("id") int id,Model modelo) {
		List<Subdito> subditos= sub.listarSubditos();
		modelo.addAttribute("subditos",subditos);
		List<Region> regiones= regi.listarRegiones();
		modelo.addAttribute("regiones",regiones);
		Subdito eldato=sub.encontrarPorId(id);
		modelo.addAttribute("subdito",eldato);
		return "editarSubditos";
	}

	@PostMapping(value="/editarSubdito/guardarNuevoSubdito")
	public String guardarNuevoSubdito(Model modelo, @RequestParam("id") int id, @RequestParam("nombre") 
	String nombre, @RequestParam("numHijos") int numHijos, @RequestParam("problema") String problema,
	@RequestParam("padre") int id_padre, @RequestParam("region") int id_region)
	{
		Subdito eldato=sub.encontrarPorId(id);
		eldato.setNombre(nombre);
		eldato.setNumHijos(numHijos);
		eldato.setProblema(problema);
		Subdito subdito= sub.encontrarPorId(id_padre);
		eldato.setPadre(subdito);
		Region region= regi.encontrarPorId(id_region);
		eldato.setRegion(region);

		sub.guardar(eldato);
		List<Subdito> subditos=sub.listarSubditos();
		modelo.addAttribute("subditos",subditos);
		return "redirect:/listarSubditos";
	}
	
}
