package it.aulab.model;

public class Prodotto {
    private Long id;
    private String nome;
    private String descrizione;
    private Float prezzo;

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
