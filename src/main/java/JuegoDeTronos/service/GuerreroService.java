package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Guerrero;
import JuegoDeTronos.repository.GuerreroRepository;
@Service
public class GuerreroService implements IGuerreroService {
	@Autowired
	GuerreroRepository guerre;
	@Override
	public List<Guerrero> listarGuerreros() {
		// TODO Auto-generated method stub
		return guerre.findAll();
	}

	@Override
	public Guerrero encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return guerre.findById(id);
	}

	@Override
	public List<Guerrero> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return guerre.findByNombre(nombre);
	}

	@Override
	public void guardar(Guerrero guerrero) {
		// TODO Auto-generated method stub
		guerre.save(guerrero);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		guerre.deleteById(id);
	}

}
