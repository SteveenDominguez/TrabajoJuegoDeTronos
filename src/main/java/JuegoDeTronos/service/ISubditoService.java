package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Subdito;


public interface ISubditoService {
	List<Subdito> listarSubditos();
	Subdito encontrarPorId(int id);
	List<Subdito> listarPorNombre(String nombre);
	void guardar(Subdito subdito);
	void eliminar(int id);
}
