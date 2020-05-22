package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Plebeyo;
import JuegoDeTronos.repository.PlebeyoRepository;

@Service
public class PlebeyoService implements IPlebeyoService {
	@Autowired
	PlebeyoRepository pleb;
	
	@Override
	public List<Plebeyo> listarPlebeyos() {
		// TODO Auto-generated method stub
		return pleb.findAll();
	}

	@Override
	public Plebeyo encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return pleb.findById(id);
	}

	@Override
	public List<Plebeyo> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return pleb.findByNombre(nombre);
	}

	@Override
	public void guardar(Plebeyo plebeyo) {
		// TODO Auto-generated method stub
		pleb.save(plebeyo);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		pleb.deleteById(id);
	}

}
