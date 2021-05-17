package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date heureDebut;
}