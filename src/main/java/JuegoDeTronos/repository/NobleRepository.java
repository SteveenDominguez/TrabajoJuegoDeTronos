package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Noble;

@Repository
public interface NobleRepository extends JpaRepository<Noble, Integer> {
	Noble findById(int id);
	List<Noble> findByNombre(String nombre);
}
