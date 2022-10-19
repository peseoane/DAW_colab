/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package piedrapapelytijeras;

import java.util.Scanner;

/**
 * Piedra, papel y tijera.
 * 
 * @author a22pedrovsp
 * @author a20amelych
 */

public class ProyectoPiedraPapelYTijeras {

    /**
     * Esta función simplemente acepta el si va ganando o perdiendo el jugador, y
     * devuelve el ser invencible o no
     * 
     * @param estado Se le pasa por un booleano si va ganando o perdiendo
     * @return Nivel de dificultad calculado.
     */

    public static byte tramposo(boolean estado) {
        return 0;
    }

    public static String ganador(String[] jugadorA, String[] jugadorB) {
        return "test";
    }

    public static void main(String[] args) {

        final String encoding = "ISO-8859-1";
        Scanner entrada = new Scanner(System.in, encoding);

        // Zona principal
        System.out.println("Elije piedra, papel o tijera: ");
        System.out.println("Elije 0 para piedra");
        System.out.println("Elije 1 para papel");
        System.out.println("Elije 2 para tijera");

        byte puntosJugador = 0;
        byte puntosMaquina = 0;

        int elecUsr = 0;
        int elecOrd = 0;

        // Zona de Amely

        boolean seguirJugando = true;

        while (seguirJugando) {
            while (puntosJugador < 3 || puntosMaquina < 3) {

                elecUsr = entrada.nextInt();
                elecOrd = new java.util.Random().nextInt(3);

                if (elecUsr == (elecOrd + 1) % 3) {
                    System.out.println("PC: " + elecOrd + " YO: " + elecUsr);
                    System.out.println("Gana PC");
                    puntosMaquina += 1;
                }
                // Condición del que gane yo (u1 0o)
                else if (elecOrd == (elecUsr + 1) % 3) {
                    System.out.println("PC: " + elecOrd + " YO: " + elecUsr);
                    System.out.println("Gano YO");
                    puntosJugador += 1;
                }

                else {
                    System.out.println("PC: " + elecOrd + " YO: " + elecUsr);
                    System.out.println("Empate");
                }
            }
            System.out.println("¿Deseas seguir jugando Y/N?");
            
        }

    }
}
