package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Dragon;
import JuegoDeTronos.repository.DragonRepository;
@Service
public class DragonService implements IDragonService {
	@Autowired
	DragonRepository drago;
	@Override
	public List<Dragon> listarDragones() {
		// TODO Auto-generated method stub
		return drago.findAll();
	}

	@Override
	public Dragon encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return drago.findById(id);
	}

	@Override
	public List<Dragon> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return drago.findByNombre(nombre);
	}

	@Override
	public void guardar(Dragon dragon) {
		// TODO Auto-generated method stub
		drago.save(dragon);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		drago.deleteById(id);
	}

}
