package ma.edu.gestioncinema.entities;


import lombok.*;
import javax.persistence.*;
import java.util.Collection;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "categorie")
    private Collection<Film> films;
}
