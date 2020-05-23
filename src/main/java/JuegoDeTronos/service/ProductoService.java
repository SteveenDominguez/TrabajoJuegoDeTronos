package JuegoDeTronos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JuegoDeTronos.model.Producto;
import JuegoDeTronos.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {
	@Autowired
	ProductoRepository prod;
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return prod.findAll();
	}

	@Override
	public Producto encontrarPorId(int id) {
		// TODO Auto-generated method stub
		return prod.findById(id);
	}

	@Override
	public List<Producto> listarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return prod.findByNombre(nombre);
	}

	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		prod.save(producto);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		prod.deleteById(id);
	}

}
