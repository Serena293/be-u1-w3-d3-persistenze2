package epicode.dao;

import epicode.entities.Location;
import epicode.entities.Partecipazione;

import javax.persistence.EntityManager;

public class PartecipazioneDAO {

    private EntityManager em;

    public PartecipazioneDAO(EntityManager em){
        this.em = em;
    }

    public void  save (Partecipazione partecipazione){
        em.getTransaction().begin();

        try{
            em.persist(partecipazione);
            em.getTransaction().commit();

    } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    finally {
            em.close();
        }
        }

    public Partecipazione getById(Long id){
        return em.find(Partecipazione.class,id);
    }

    public void  delete(Long id){
        em.getTransaction().begin();
        try{
           Partecipazione trovata = em.find(partecipazione.class, id);
            if(trovata != null){
                em.remove(trovata);
                em.getTransaction().commit();
                System.out.println("Elemento eliminato");
            }
        }
        catch(Exception e){
            em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
        finally {
            em.close();
        }
    }
}
