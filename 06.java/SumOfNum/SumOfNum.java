import java.util.Scanner;
class SumOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il primo numero: ");
        int number1 = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Inserisci il secondo numero: ");
        int number2 = Integer.parseInt(scanner.nextLine());

        int somma = number1 + number2;

        System.out.println("La somma dei due numeri inseriti: " + somma);
    }
}