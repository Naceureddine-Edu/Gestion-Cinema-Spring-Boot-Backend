package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomClient;
    private double prix;
    @Column(unique = true)
    private int codePayement;
    private boolean reservee;

    @ManyToOne
    private Place place;

    @ManyToOne
    private ProjectionFilm projectionFilm;
}
