//Scrivere un programma che prenda in input un numero e ritorni se il numero è pari o dispari

import java.util.Scanner;
class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il numero: ");
        int number = Integer.parseInt(scanner.nextLine());

        if(number % 2 == 0) {
            System.out.println("Il numero " + number + " è pari");
        } else {
            System.out.println("Il numero " + number + " è dispari");
        }

    }
}