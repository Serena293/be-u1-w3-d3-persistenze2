package epicode.dao;

import epicode.entities.Location;
import epicode.entities.Persona;

import javax.persistence.EntityManager;

public class LocationDAO {
    public EntityManager em; //salviamo EntityManager in em

    //costruttore
    public LocationDAO(EntityManager em){
        this.em = em;
    }

    public void save(Location location){
        em.getTransaction().begin();
        try{
            //se id di location è diverso da null e il metodo find trova un'id diversa da null
            if(location.getId_location() != null && em.find(Location.class, location.getId_location()) != null)
                // Aggiorna l'entità esistente
                em.merge(location);
         else {
            // Salva una nuova entità
            em.persist(location);
        }
         em.getTransaction().commit();
        }
        catch (Exception e){
        em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }

    public Location getById(Long id_location){
        return em.find(Location.class, id_location);
    }


    public void delete(Long id){
        em.getTransaction().begin();
        try{
            Location trovata = em.find(Location.class, id);
            if(trovata != null){
                em.remove(trovata);
                em.getTransaction().commit();
                System.out.println("Eliminato");
            }
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }
}
