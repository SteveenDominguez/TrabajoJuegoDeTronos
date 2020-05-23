package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Dragon;


public interface IDragonService {
	List<Dragon> listarDragones();
	Dragon encontrarPorId(int id);
	List<Dragon> listarPorNombre(String nombre);
	void guardar(Dragon dragon);
	void eliminar(int id);
}
