package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Region;
import JuegoDeTronos.repository.RegionRepository;
@Service
public class RegionService implements IRegionService {
	@Autowired
	RegionRepository regi;
	@Override
	public List<Region> listarRegiones() {
		// TODO Auto-generated method stub
		return regi.findAll();
	}

	@Override
	public Region encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return regi.findById(id);
	}

	@Override
	public List<Region> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return regi.findByNombre(nombre);
	}

	@Override
	public void guardar(Region region) {
		// TODO Auto-generated method stub
		regi.save(region);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		regi.deleteById(id);
	}

}
