package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
