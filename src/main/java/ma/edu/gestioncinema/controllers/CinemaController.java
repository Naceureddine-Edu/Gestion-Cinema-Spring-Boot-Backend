package ma.edu.gestioncinema.controllers;


import lombok.Data;
import ma.edu.gestioncinema.entities.Film;
import ma.edu.gestioncinema.entities.Ticket;
import ma.edu.gestioncinema.repositorys.FilmRepository;
import ma.edu.gestioncinema.repositorys.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CinemaController {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path ="/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] images(@PathVariable Long id) throws Exception {
        Film film = filmRepository.findById(id).get();
        String nomPhoto = film.getPhoto();// Recuperer Le Nom De La Photo Dun Film En Question(findById=prm ID)

        File file = new File(System.getProperty("user.home")+
                "/eclipse-workspace/cinemaFilmImages/"+nomPhoto);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketFormModel ticketFormModel) {
        List<Ticket> ticketList = new ArrayList<>();
        ticketFormModel.getTickets().forEach(idTicket -> {
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketFormModel.getNomClient());
            ticket.setCodePayement(ticketFormModel.getCodePayment());
            ticket.setReservee(true);
            ticketRepository.save(ticket);
            ticketList.add(ticket);
        });
        return ticketList;
    }
}

 @Data
 class TicketFormModel implements Serializable
{
    private String nomClient;
    private int codePayment;
    private List<Long> tickets = new ArrayList<>();
}