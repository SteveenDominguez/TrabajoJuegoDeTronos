package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Noble;

public interface INobleService {
	List<Noble> listarNobles();
	Noble encontrarPorId(int id);
	List<Noble> listarPorNombre(String nombre);
	void guardar(Noble noble);
	void eliminar(int id);
}
