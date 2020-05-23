package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Guerrero;

@Repository
public interface GuerreroRepository extends JpaRepository<Guerrero, Integer> {
	Guerrero findById(int id);
	List<Guerrero> findByNombre(String nombre);
}
