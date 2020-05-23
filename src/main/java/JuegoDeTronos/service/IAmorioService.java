package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Amorio;

public interface IAmorioService {
	List<Amorio> listarAmorios();
	Amorio encontrarPorId(int id);
	void guardar(Amorio amorio);
	void eliminar(int id);
}
