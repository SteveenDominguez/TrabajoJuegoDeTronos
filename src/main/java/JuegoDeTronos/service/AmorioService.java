package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Amorio;
import JuegoDeTronos.repository.AmorioRepository;

@Service
public class AmorioService implements IAmorioService {
	@Autowired
	AmorioRepository amo;
	@Override
	public List<Amorio> listarAmorios() {
		// TODO Auto-generated method stub
		return amo.findAll();
	}

	@Override
	public Amorio encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return amo.findById(id);
	}

	@Override
	public void guardar(Amorio amorio) {
		// TODO Auto-generated method stub
		amo.save(amorio);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		amo.deleteById(id);
	}

}
