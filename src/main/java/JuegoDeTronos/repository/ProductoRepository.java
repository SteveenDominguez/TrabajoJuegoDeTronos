package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	Producto findById(int id);
	List<Producto> findByNombre(String nombre);
}
