package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Plebeyo;

@Repository
public interface PlebeyoRepository extends JpaRepository<Plebeyo, Integer> {
	Plebeyo findById(int id);
	List<Plebeyo> findByNombre(String nombre);
}
