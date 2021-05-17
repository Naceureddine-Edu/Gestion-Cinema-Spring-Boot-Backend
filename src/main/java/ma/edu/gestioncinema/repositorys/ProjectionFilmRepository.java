package ma.edu.gestioncinema.repositorys;


import ma.edu.gestioncinema.entities.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProjectionFilmRepository extends JpaRepository<ProjectionFilm, Long> {

}
