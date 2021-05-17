package ma.edu.gestioncinema.controllers;


import ma.edu.gestioncinema.entities.Cinema;
import ma.edu.gestioncinema.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/lists")
    public ResponseEntity<List<Cinema>> getAllCinemas() {
        List<Cinema> cinemas = cinemaService.listeCinema();
        return new ResponseEntity<> (cinemas, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cinema> findCinemaById(@PathVariable Long id) {
        Cinema cinema = cinemaService.getCinemaById(id);
        return new ResponseEntity<>(cinema,HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Cinema> saveCinema(@RequestBody Cinema cinema) {
        Cinema newCinema = cinemaService.ajouterCinema(cinema);
        return new ResponseEntity<>(newCinema, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema) {
        Cinema updatedCinema = cinemaService.modifierCinema(cinema);
        return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable Long id) {
        cinemaService.supprimerCinema(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
