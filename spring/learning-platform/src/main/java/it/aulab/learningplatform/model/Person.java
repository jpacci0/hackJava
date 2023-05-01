package it.aulab.learningplatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Person {
    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    public Person() {
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

/* Questo codice definisce la classe Person come un oggetto embeddable che può essere utilizzato come attributo in altre entità JPA.

La classe Person ha due campi dati: firstname e lastname, che sono entrambi di tipo String. La classe ha anche un costruttore vuoto e i metodi getter e setter per i campi dati.

L'annotazione @Embeddable indica a JPA che questa classe deve essere incorporata in un'altra entità come un campo, e l'annotazione @Column specifica i metadati per i campi dati della classe quando sono mappati alle colonne della tabella del database. */