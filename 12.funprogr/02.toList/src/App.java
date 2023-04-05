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

        //? dichiarativo
        List<Person> females = people.stream().filter(p -> Gender.FEMALE.equals(p.gender)).toList();
        for(Person p : females){
            System.out.println(p.name);
        }
    }
}
