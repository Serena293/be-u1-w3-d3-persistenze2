package epicode;

import com.github.javafaker.Faker;
import epicode.dao.EventsDAO;
import epicode.entities.Event;
import epicode.entities.Partecipazione;
import epicode.entities.Persona;
import epicode.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercizioGestioneEventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        //serve per generare nomi casuali
        Faker faker = new Faker(Locale.ITALY);
        EventsDAO eventsDAO = new EventsDAO(em);
        Random rndm = new Random();

        for (int i = 0; i < 20; i++) {
            eventsDAO.save(new Event(
                    faker.chuckNorris().fact(),
                    LocalDate.of(rndm.nextInt(2023, 2025),
                            rndm.nextInt(1, 13),
                            rndm.nextInt(1, 29)),
                    faker.lorem().fixedString(50),
                    rndm.nextInt(1, 3) == 1 ? TipoEvento.PRIVATO : TipoEvento.PUBBLICO,
                    rndm.nextInt(1, 1000)));
        }

        Event found = eventsDAO.getById(6);
        if (found != null)
            System.out.println(found);
        else System.out.println("Elemento non trovato");


        eventsDAO.delete(5);
        // Crea una lista di partecipazioni finte
        ArrayList<Object> partecipazioni = new ArrayList<>();
        partecipazioni.add(new Partecipazione(1L, null, Partecipazione.Stato.CONFERMATO));
        partecipazioni.add(new Partecipazione(2L, null, Partecipazione.Stato.DA_CONFERMARE));

        // Crea una persona con dati casuali
        Persona persona = new Persona(
                faker.name().firstName(),            // Nome casuale
                faker.name().lastName(),             // Cognome casuale
                faker.internet().emailAddress(),     // Email casuale
                faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate(), // Data di nascita casuale
                faker.options().option('M', 'F'),    // Sesso casuale (M o F)
                partecipazioni                      // Lista di partecipazioni
        );

        // Stampa la persona
        System.out.println(persona);

        em.close();
        emf.close();
   }
}
