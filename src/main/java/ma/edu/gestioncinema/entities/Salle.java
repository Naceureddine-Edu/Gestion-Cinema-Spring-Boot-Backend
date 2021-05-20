package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Salle implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "salle")
    private Collection<Place> places;

    @OneToMany(mappedBy = "salle")
    private Collection<ProjectionFilm> projectionFilms;
}
