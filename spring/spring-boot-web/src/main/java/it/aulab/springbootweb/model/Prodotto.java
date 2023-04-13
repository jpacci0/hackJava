package it.aulab.springbootweb.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotti")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;
    
    @Column(name = "descrizione", length = 100)
    private String descrizione;

    @Column(name = "prezzo")
    private Float prezzo;

    @Column(name = "netto")
    private Float prezzoNetto;

    @OneToMany(mappedBy = "prodotto")
    List<Variante> varianti;

    @ManyToMany(mappedBy = "prodotti")
    List<Fornitore> fornitori;

    public Float getPrezzoNetto() {
        return prezzoNetto;
    }

    public void setPrezzoNetto(Float prezzoNetto) {
        this.prezzoNetto = prezzoNetto;
    }

    public Prodotto() {
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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }
}

