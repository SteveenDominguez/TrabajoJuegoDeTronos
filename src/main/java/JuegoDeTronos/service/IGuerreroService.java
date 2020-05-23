package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Guerrero;


public interface IGuerreroService {
	List<Guerrero> listarGuerreros();
	Guerrero encontrarPorId(int id);
	List<Guerrero> listarPorNombre(String nombre);
	void guardar(Guerrero guerrero);
	void eliminar(int id);
}
