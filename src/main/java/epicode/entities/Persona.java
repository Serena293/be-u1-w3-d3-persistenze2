package epicode.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table (name = "perosne")
public class Persona {
    @Id
    @GeneratedValue
    private Long id;

    @Column (name="nome")
    private String nome;
    @Column (name="cognome")
    private String cognome;
    @Column (name="e-mail")
    private String email;
    @Column (name="Data di nascita")
    private LocalDate dataDiNascita;
    @Column (name="Sesso")
    private char sesso;
    @Column (name="Lista Partecipazioni")
    private List<Partecipazione> listaPartecipazioni;

    public Persona(){}

    public Persona(String n, String c, String e, LocalDate dn, char s, List<Partecipazione> lp){
        this.nome = n;
        this.cognome = c;
        this.email=e;
        this.dataDiNascita = dn;
        this.sesso =s;
        this.listaPartecipazioni = lp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazioni() {
        return listaPartecipazioni;
    }

    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
        this.listaPartecipazioni = listaPartecipazioni;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", sesso=" + sesso +
                ", listaPartecipazioni=" +  listaPartecipazioni.toString() +
                '}';

        //(listaPartecipazioni != null ? listaPartecipazioni.toString() : "[]"


    }

}

