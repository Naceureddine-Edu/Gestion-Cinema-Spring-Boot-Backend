package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private double duree;
    private String realisateur;
    private String description;
    private String photo;
    private Date dateSortie;
}
