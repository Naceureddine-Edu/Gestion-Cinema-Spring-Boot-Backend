package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Seance implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIME)
    private Date heureDebut;

    /*
    @OneToMany(mappedBy = "seance")
    private Collection<ProjectionFilm> projectionFilms;
     */
}
