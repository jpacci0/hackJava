import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, Car> carMap = new HashMap<>();
        carMap.put(123, new Car("500", 1990, 12000, 123));
        carMap.put(234, new Car("Ferrari", 2021, 500000, 234));
        carMap.put(345, new Car("Porsche", 2022, 350000, 345));
        carMap.put(456, new Car("Lamborghini", 2023, 600000, 456));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la chiave:");
        int key = scanner.nextInt();

        Car car = carMap.get(key);
        if (car != null) {
            System.out.println("Auto trovata: " + car.getModel());
        } else {
            System.out.println("Auto non trovata.");
        }
    }
}
