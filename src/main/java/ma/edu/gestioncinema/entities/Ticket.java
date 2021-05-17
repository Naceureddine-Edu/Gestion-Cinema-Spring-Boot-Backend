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
    private int codePayement;
    private boolean reservee;
}
