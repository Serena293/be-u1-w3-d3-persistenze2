package epicode.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Location {
    @Id
    @GeneratedValue
    private Long id_location;

    @Column (name = "nome")
    private String nome_location;
    @Column (name = "Città")
    private String comune;

    public Long getId_location() {
        return id_location;
    }

    public void setId_location(Long id_location) {
        this.id_location = id_location;
    }

    public String getNome_location() {
        return nome_location;
    }

    public void setNome_location(String nome_location) {
        this.nome_location = nome_location;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }
}
