import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = new Integer[10];
        
        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci un numero:");
            int number = scanner.nextInt();
            numbers[i] = number;
        }

        //check per controllare l'array
        System.out.println("I numeri inseriti nell'array sono");
        for(int number : numbers) {
            System.out.println(number);
        }
        
        
        Numeri<Integer> filter = new Numeri<>(numbers);
        
        System.out.println("Numeri pari: " + filter.filterEven());
        System.out.println("Numeri dispari: " + filter.filterOdd());
        System.out.println("Numeri primi: " + filter.filterPrime());
    }
}
