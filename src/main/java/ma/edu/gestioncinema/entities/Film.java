package ma.edu.gestioncinema.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String titre;
    private double duree;
    @Column(length = 30)
    private String realisateur;
    private String description;
    private String photo;
    private Date dateSortie;

    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionFilm> projectionFilms;

    @ManyToOne
    private Categorie categorie;
}
