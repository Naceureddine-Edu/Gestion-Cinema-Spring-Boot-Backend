package ma.edu.gestioncinema.services;


import ma.edu.gestioncinema.entities.Cinema;
import ma.edu.gestioncinema.exception.CinemaNotFoundException;
import ma.edu.gestioncinema.repositorys.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    /** CRUD Methodes **/

    public Cinema getCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseThrow(
                () ->
                new CinemaNotFoundException("Le Cinema Avec le id : "+ id +" n'existe pas dans la BD")
        );
    }

    public List<Cinema> listeCinema() {
        return cinemaRepository.findAll();
    }

    public Cinema ajouterCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public Cinema modifierCinema(Cinema cinema) {
        return cinemaRepository.save(cinema);
    }

    public void supprimerCinema(Long id) {
        cinemaRepository.deleteById(id);
    }
}
