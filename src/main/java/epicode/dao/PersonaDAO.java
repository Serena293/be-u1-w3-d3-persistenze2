package epicode.dao;

import epicode.entities.Event;
import epicode.entities.Persona;

import javax.persistence.EntityManager;

public class PersonaDAO {
    // memorizziamo EntityManager in una variabile em
    private EntityManager em;

    //costruttore che prende em come parametro
    public PersonaDAO(EntityManager em) {
        this.em = em;
    };


    //metodo per salvare o modifica  (Create, Update)
    public void save(Persona persona){
        //inizia la transazione
        em.getTransaction().begin();
        try{
            // Verifica se l'entità esiste già
            if (persona.getId() != null && em.find(Persona.class, persona.getId()) != null) {
                // Aggiorna l'entità esistente
                em.merge(persona);
            } else {
                // Salva una nuova entità
                em.persist(persona);
            }

            // Conferma la transazione
            em.getTransaction().commit();
    }
        catch (Exception e)
        {
            em.getTransaction().rollback(); // Annulla la transazione in caso di errore
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
    }
        finally {
            em.close();
        }
        }
        //read, recupera l'id dell'istanza persona
    public Persona getById(Long id){
        return  em.find(Persona.class, id);
    }


   //delete
    public void delete(Long id){
        em.getTransaction().begin();
        try{
            Event trovato = em.find(Event.class, id);
            if(trovato != null){
                em.remove(trovato);
                em.getTransaction().commit();
                System.out.println("Elemento eliminato");
            }

        }
        catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            em.close();


        }
    }


}
