package ma.edu.gestioncinema.services;


import ma.edu.gestioncinema.entities.*;
import ma.edu.gestioncinema.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


@Service @Transactional
public class CinemaInitServiceImplementation implements ICinemaInitService {

    @Autowired
    private VilleRepository villeRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private SeanceRepository seanceRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ProjectionFilmRepository projectionFilmRepository;

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public void initVilles() {
        Stream.of("casablanca","Marrakech","Rabat","Tanger").forEach(villeNames -> {
            Ville ville = new Ville();
            ville.setName(villeNames);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(ville -> {
            Stream.of("Megaramma","IMAX","Founoun","Chahrazad","Daouliz").forEach(cinemaName -> {
                Cinema cinema = new Cinema();
                cinema.setName(cinemaName);
                cinema.setVille(ville);
                cinema.setNombreSalles(3 + (int)(Math.random()*7));
                cinemaRepository.save(cinema);
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i=0; i< cinema.getNombreSalles(); i++) {
                Salle salle = new Salle();
                salle.setName("Salle"+(i+1));
                salle.setCinema(cinema);
                salle.setNombrePlaces(15 + (int)(Math.random()*20));
                salleRepository.save(salle);
            }});
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(salle -> {
            for(int i=0; i<salle.getNombrePlaces(); i++) {
                Place place = new Place();
                place.setSalle(salle);
                place.setNumero(i + 1);
                placeRepository.save(place);
            }});
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(seanceHeureDebut -> {
            Seance seance = new Seance();
            try
            {
                seance.setHeureDebut(dateFormat.parse(seanceHeureDebut));
                seanceRepository.save(seance);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action","Drame","Thriller","Comedie").forEach(catName -> {
            Categorie categorie = new Categorie();
            categorie.setName(catName);
            categorieRepository.save(categorie);
        } );
    }

    @Override
    public void initFilmes() {
        double duree[] = new double[] {1,1.5,2,2.5,3};
        List<Categorie> categories = categorieRepository.findAll();
        Stream.of("Game of thrones", "Vikings", "Sons of anarchy").forEach(filmName -> {
            Film film = new Film();
            film.setTitre(filmName);
            film.setDuree(duree[new Random().nextInt(duree.length)]);
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            film.setPhoto(filmName.replaceAll(" ","")+".jpeg");
            filmRepository.save(film);
            });
    }

    @Override @Transactional
    public void initProjectionsFilm() {
        double[] price = new double[] {30,50,60,70,90,100};
        villeRepository.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                   filmRepository.findAll().forEach(film -> {
                       seanceRepository.findAll().forEach(seance -> {
                           ProjectionFilm projectionF = new ProjectionFilm();
                           projectionF.setDateProjection(new Date());
                           projectionF.setFilm(film);
                           projectionF.setPrix(price[new Random().nextInt(price.length)]);
                           projectionF.setSalle(salle);
                           projectionF.setSeance(seance);
                           projectionFilmRepository.save(projectionF);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionFilmRepository.findAll().forEach(projectionFilm -> {
           projectionFilm.getSalle().getPlaces().forEach(place -> {
               Ticket ticket = new Ticket();
               ticket.setPlace(place);
               ticket.setPrix(projectionFilm.getPrix());
               ticket.setProjectionFilm(projectionFilm);
               ticket.setReservee(false);
               ticketRepository.save(ticket);
           });
        });
    }
}
