import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car("yaris", 1995, 200);
        Car car2 = new Car("500", 2000, 1000);
        Car car3 = new Car("mini", 2019, 15000);
        // Car car4 = new Car("mini", 2019, 15000);

        Set<Car> macchina = Set.of(car1, car2, car3);

        for(Car car : macchina) {
            System.out.println(car.print());
        }
       

    }
}
