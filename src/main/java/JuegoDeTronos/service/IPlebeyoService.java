package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Plebeyo;

public interface IPlebeyoService {
	List<Plebeyo> listarPlebeyos();
	Plebeyo encontrarPorId(int id);
	List<Plebeyo> listarPorNombre(String nombre);
	void guardar(Plebeyo plebeyo);
	void eliminar(int id);
}
