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

    /**
     * @param args
     */
    public static void main(String[] args) {

        final String encoding = "ISO-8859-1";

        // Menú principal

        boolean seguirJugando = true;
        byte puntosJugador = 0;
        byte puntosMaquina = 0;

        int resultadoJugada;
        Scanner entrada = new Scanner(System.in, encoding);
        while (seguirJugando) {
            System.out.println("Elije piedra, papel o tijera: ");
            System.out.println("Elije 0 para piedra");
            System.out.println("Elije 1 para papel");
            System.out.println("Elije 2 para tijera");

            int elecUsr = entrada.nextInt();
            
            int elecPC = new java.util.Random().nextInt(3);

            // Zona de Amely

            final int[][] soluciones = {
                    { 1, 2, 0 },
                    { 0, 1, 2 },
                    { 2, 0, 1 }
            };

            resultadoJugada = soluciones[elecUsr][elecPC];

            System.out.println("PC escoge: " + elecPC);

            switch (resultadoJugada) {
                case 0:
                    System.out.println("Gano YO");
                    puntosJugador++;
                    break;
                case 1:
                    System.out.println("Empate");
                    break;
                case 2:
                    System.out.println("Gana PC");
                    puntosMaquina++;
                    break;
            }

            System.out.println("¿Deseas seguir jugando Y/N?");
          
            entrada.nextLine();

            String salirdeljuego = entrada.nextLine();

            if (salirdeljuego.toLowerCase().equals("n")) {
                System.out.println("saliendo");
            }
        }
    }
}
