import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class App {

    static void show(List<Car> x){
        for(Car car : x){
            System.out.println(car.getModel());
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        //arrayList
        
        List<Car> macchina = new ArrayList<Car>();
        
        macchina.add(new Car("500", 2010, 15000));
        macchina.add(new Car("yaris", 2015, 13000));
        macchina.add(new Car("panda", 1999, 9999.99));
        macchina.add(new Car("mini", 2022, 39999));
        macchina.add(new Car("ferrari", 2020, 200000));
        
        System.out.println("Ci sono " + macchina.size() + " modelli nel concessionario.\n");
        
        show(macchina);
        
        for(Car car : macchina){
            if(car.getModel().equals("500") && car.getYear() == 2010 && car.getPrice() == 15000){
                System.out.println("\nL'auto 500 del 2010 con prezzo 15000 è presente nel concessionario.");
                break;
            }
        }
        
        System.out.println("\nLa macchina " + macchina.get(0).getModel() + " è stata comprata.\n");
        macchina.remove(0);
        
        
        
        //linkedList

        System.out.println("linkedList\n");
        LinkedList<Car> auto = new LinkedList<>(
            List.of(
                new Car("500", 2011, 3400),
                new Car("yaris", 2000, 1000),
                new Car("panda", 1990, 500)
            )
        );

        auto.addFirst(new Car("impreza", 1995, 20000));

        show(auto);
        
        
        
    }
}
