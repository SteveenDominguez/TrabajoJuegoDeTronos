package JuegoDeTronos.service;

import java.util.List;

import JuegoDeTronos.model.Producto;

public interface IProductoService {
	List<Producto> listarProductos();
	Producto encontrarPorId(int id);
	List<Producto> listarPorNombre(String nombre);
	void guardar(Producto producto);
	void eliminar(int id);
}
