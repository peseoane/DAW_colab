package piedrapapelytijeras;

import javax.print.DocFlavor;
import java.util.Locale;
import java.util.Scanner;

public class RCgamePSR {
    public static void main(String[] args) {

        // create a new locale
        Locale locale1 = new Locale("en", "US", "WIN");

        // print locale
        System.out.println("Locale:" + locale1);

        // set another default locale
        Locale.setDefault(new Locale("es", "ES"));

        // create a new locale based on new default settings
        Locale locale2 = Locale.getDefault();

        // print the new locale
        System.out.println("Locale::" + locale2);

        Scanner prueba = new Scanner(System.in);
        String prueba1 = prueba.nextLine();
        System.out.println(prueba1);
    }
}

