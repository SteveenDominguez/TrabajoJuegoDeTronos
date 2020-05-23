package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Dragon;

@Repository
public interface DragonRepository extends JpaRepository<Dragon, Integer> {
	Dragon findById(int id);
	List<Dragon> findByNombre(String nombre);
}
