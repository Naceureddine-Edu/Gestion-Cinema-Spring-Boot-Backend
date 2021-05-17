package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Salle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;
}
