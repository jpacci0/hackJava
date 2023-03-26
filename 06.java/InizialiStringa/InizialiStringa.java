//Scrivere un programma che chieda all’utente una stringa e ritorni le iniziali di ogni parola con il . Esempio: “Ciao sono una stringa” => c.s.u.s

import java.util.Scanner;

class InizialiStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una stringa: ");
        String stringa = scanner.nextLine();
        String[] parole = stringa.split(" ");
        String[] iniziali = new String[parole.length];
        for (int i = 0; i < parole.length; i++) {
            char iniziale = parole[i].charAt(0);
            iniziali[i] = Character.toString(iniziale);
        }
        String risultato = String.join(".", iniziali);
        System.out.println(risultato);
    }
}

