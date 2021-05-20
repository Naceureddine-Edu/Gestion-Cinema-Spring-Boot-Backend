package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProjectionFilm implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProjection;
    private double prix;

    @ManyToOne
    private Salle salle;

    @ManyToOne
    private Film film;

    @OneToMany(mappedBy = "projectionFilm")
    private Collection<Ticket> tickets;

    @ManyToOne
    private Seance seance;
}
