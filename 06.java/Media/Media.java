//Scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e ne faccia la media

import java.util.Scanner;
class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero: ");
        int len = scanner.nextInt();

        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            System.out.println("Inserisci il " + (i+1) + "° elemento: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        int somma = 0;
        for (int i = 0; i < len; i++) {
            somma += array[i];
        }
        int media = somma / len;

        System.out.println("La media dei numeri inseriti è: " + media);

    }
}