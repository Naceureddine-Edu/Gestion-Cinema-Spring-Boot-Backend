package ma.edu.gestioncinema.exception;

public class CinemaNotFoundException extends RuntimeException {
   
    public CinemaNotFoundException(String message) {
        super(message);
    }
}
