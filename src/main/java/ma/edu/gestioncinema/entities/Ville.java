package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double longitude;
    private double altitude;
    private double latitude;
}
