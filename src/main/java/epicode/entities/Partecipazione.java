package epicode.entities;

import javax.persistence.*;

public class Partecipazione {

    @Id
    @GeneratedValue
    private Long id_partecipazione;
    @Column(name = "evento")
    private  Event evento;
    @Column (name="Stato")
    @Enumerated(EnumType.STRING)
    private Stato stato;




    public Long getId_partecipazione() {
        return id_partecipazione;
    }

    public void setId_partecipazione(Long id_partecipazione) {
        this.id_partecipazione = id_partecipazione;
    }

    public Event getEvento() {
        return evento;
    }

    public void setEvento(Event evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public enum Stato{
        CONFERMATO,
        DA_CONFERMARE
    }




    @Override
    public String toString() {
        return "Partecipazione{" +
                "id_partecipazione=" + id_partecipazione +
                ", evento=" + (evento.toString()) +
                ", stato=" + stato +
                '}';
    }




}



