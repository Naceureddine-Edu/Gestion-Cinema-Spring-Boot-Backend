package ma.edu.gestioncinema.repositorys;


import ma.edu.gestioncinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long> {

}
