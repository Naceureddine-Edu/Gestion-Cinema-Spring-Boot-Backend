package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private double longitude;
    private double altitude;
    private double latitude;

    @ManyToOne
    private Salle salle;

    @OneToMany(mappedBy = "place")
    private Collection<Ticket> tickets;
}
