package it.aulab.learningplatform.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    // @AttributeOverrides({
    //     @AttributeOverride(
    //         name = "firstname", 
    //         column = @Column(
    //             name = "firstname", 
    //             nullable = false
    //         )),
    //     @AttributeOverride(
    //         name = "lastname", 
    //         column = @Column(
    //             name = "lastname", 
    //             nullable = false
    //         )),
    // })
    private Person data;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<Course>();

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getData() {
        return data;
    }

    public void setData(Person data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}

/* Il modello Student è una classe annotata come @Entity e mappata alla tabella students. La classe contiene i seguenti campi dati:

id: campo di tipo Long che rappresenta l'identificativo univoco dello studente. Il campo è annotato con @Id, @GeneratedValue e GenerationType.IDENTITY per indicare che il valore è generato automaticamente dal database.
data: campo di tipo Person che rappresenta le informazioni personali dello studente, quali nome e cognome. Il campo è annotato con @Embedded per indicare che i suoi attributi sono mappati alla stessa tabella del campo.
email: campo di tipo String che rappresenta l'indirizzo email dello studente. Il campo è annotato con @Column per specificare la lunghezza massima e se il campo deve essere unico.
courses: campo di tipo List<Course> che rappresenta i corsi a cui lo studente è iscritto. Il campo è annotato con @ManyToMany e mappedBy per specificare che la relazione è gestita dalla classe Course.
La classe Student contiene anche un costruttore vuoto e i metodi getter e setter per i suoi campi dati. */
