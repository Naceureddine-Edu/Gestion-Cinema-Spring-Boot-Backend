package ma.edu.gestioncinema.services;

import org.springframework.stereotype.Service;

@Service
public interface ICinemaInitService {
    
    public void initVilles();
    public void initCinemas();
    public void initSalles();
    public void initPlaces();
    public void initSeances();
    public void initCategories();
    public void initFilmes();
    public void initProjectionsFilm();
    public void initTickets();
}
