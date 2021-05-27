package ma.edu.gestioncinema.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String nomClient;
    private double prix;
    @Column(unique = false, nullable = true)
    private int codePayement;
    private boolean reservee;

    @ManyToOne
    private Place place;

    @ManyToOne
    private ProjectionFilm projectionFilm;
}
