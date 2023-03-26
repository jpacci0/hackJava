//Scrivere un programma che prenda in input un numero, che crei un array di lunghezza pari al numero inserito, che chieda un numero di elementi pari al numero inserito e stampi solo gli elmenti in posizione pari

import java.util.Scanner;

class ArrayPari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero: ");
        int numElementi = Integer.parseInt(scanner.nextLine());

        int[] array = new int[numElementi];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Inserisci un numero da inserire nell'array: ");
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < numElementi; i = i + 2) {
            System.out.println(array[i]);
        }

    }
}