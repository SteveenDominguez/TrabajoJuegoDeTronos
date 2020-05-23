package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Amorio;

@Repository
public interface AmorioRepository extends JpaRepository<Amorio, Integer> {
	Amorio findById(int id);
}
