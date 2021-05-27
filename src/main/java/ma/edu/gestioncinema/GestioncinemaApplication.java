package ma.edu.gestioncinema;


import ma.edu.gestioncinema.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GestioncinemaApplication implements CommandLineRunner {

    @Autowired
    private ICinemaInitService CinemaInitService;


    public static void main(String[] args) {
        SpringApplication.run(GestioncinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CinemaInitService.initVilles();
        CinemaInitService.initCinemas();
        CinemaInitService.initSalles();
        CinemaInitService.initPlaces();
        CinemaInitService.initSeances();
        CinemaInitService.initCategories();
        CinemaInitService.initFilmes();
        CinemaInitService.initProjectionsFilm();
        CinemaInitService.initTickets();
    }
}
