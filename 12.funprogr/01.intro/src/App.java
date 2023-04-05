import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        //! data una lista di oggetti di classe person, filtrare le persone in base al genere
        List<Person> people = List.of(
        new Person("Jacopo", Gender.MALE),
        new Person("Riccardo", Gender.MALE),
        new Person("Rosa", Gender.FEMALE),
        new Person("Giorgia", Gender.FEMALE)
        );
        
        //? imperativo
        /* 
        List<Person> females = new ArrayList<>();
        for(Person p : people){
            if (Gender.FEMALE.equals(p.gender)) females.add(p);
        }
        for(Person f : females){
            System.out.println(f.name);
        }
        */

        //? dichiarativo
        //? dalla list genero una stream
        people.stream()
            .filter(person -> Gender.FEMALE.equals(person.gender)) //? dico alla filter in base a cosa deve filtrare
            .collect(Collectors.toList()) //? qui trasformo la stream in una lista
            .forEach(person -> System.out.println(person.name)); //? ciclo e stampo la lista



        //! altro esempio
        List<Integer> numero = new ArrayList<Integer>();
        numero.add(1);
        numero.add(2);
        numero.add(3);
        numero.add(4);
        numero.add(5);
        numero.stream()
            .filter(el -> el % 2 == 0)
            // .limit(5)
            .forEach(el -> System.out.println(el));
    }
}
