package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Subdito;

@Repository
public interface SubditoRepository extends JpaRepository<Subdito, Integer> {
	Subdito findById(int id);
	List<Subdito> findByNombre(String nombre);
}
