package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Noble;
import JuegoDeTronos.repository.NobleRepository;

@Service
public class NobleService implements INobleService {
	@Autowired
	NobleRepository nob;
	@Override
	public List<Noble> listarNobles() {
		// TODO Auto-generated method stub
		return nob.findAll();
	}

	@Override
	public Noble encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return nob.findById(id);
	}

	@Override
	public List<Noble> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return nob.findByNombre(nombre);
	}

	@Override
	public void guardar(Noble noble) {
		// TODO Auto-generated method stub
		nob.save(noble);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		nob.deleteById(id);
	}

}
