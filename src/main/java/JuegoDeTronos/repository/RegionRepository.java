package JuegoDeTronos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JuegoDeTronos.model.Region;
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
	Region findById(int id);
	List<Region> findByNombre(String nombre);
}
