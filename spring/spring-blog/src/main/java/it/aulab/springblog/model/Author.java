package it.aulab.springblog.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//entità gestita da jpa
@Entity
@Table(name = "authors") //il nome scritto qui corrisponde al nome della tabella
public class Author {
    @Id //questa notazione dice che sarà la nostra chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //usiamo genvalue quando abbiamo una chiave gestita in automatico dal database
    private Long id;

    @Column(length = 100, nullable = false)
    private String firstname;

    @Column(length = 100, nullable = false)
    private String lastname;

    @Column(length = 100, nullable = false)
    private String email;

    //onetomany si usa sull'entità principale, cioè quella con relazione uno
    @OneToMany(mappedBy = "author") //per non sbagliare author far riferimento alla classe
    private List<Post> posts = new ArrayList<Post>();

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
