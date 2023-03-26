//Scrivere un programma che prenda in input dall’utente un numero peso e un numero altezza e calcoli il BMI. Formula BMI => peso / (altezza * altezza) * 703

import java.util.Scanner;

class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il tuo peso: ");
        double peso = scanner.nextDouble();

        System.out.println("Inserisci la tua altezza: ");
        double altezza = scanner.nextDouble();

        double bmi = peso / (altezza * altezza);
        double risultato = Math.floor(bmi * 100.0) / 100.0;
        
        System.out.println("Il tuo BMI è: " + risultato);

    }
}
