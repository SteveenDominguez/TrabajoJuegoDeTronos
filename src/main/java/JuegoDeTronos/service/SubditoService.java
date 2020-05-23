package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Subdito;
import JuegoDeTronos.repository.SubditoRepository;
@Service
public class SubditoService implements ISubditoService {
	@Autowired
	SubditoRepository sub;
	@Override
	public List<Subdito> listarSubditos() {
		// TODO Auto-generated method stub
		return sub.findAll();
	}

	@Override
	public Subdito encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return sub.findById(id);
	}

	@Override
	public List<Subdito> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return sub.findByNombre(nombre);
	}

	@Override
	public void guardar(Subdito subdito) {
		// TODO Auto-generated method stub
		sub.save(subdito);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		sub.deleteById(id);
	}

}
