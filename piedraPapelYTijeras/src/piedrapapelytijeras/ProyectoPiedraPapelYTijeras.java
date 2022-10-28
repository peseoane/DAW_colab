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

    /**
     * @param args
     */
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

        final int[][] soluciones = {
                { 1, 2, 0 },
                { 0, 1, 2 },
                { 2, 0, 1 }
        };

        for (int fila = 0; fila < soluciones.length; fila++) {
            for (int col = 0; col < soluciones[fila].length; col++) {
                System.out.println(
                        "Nuevo valor para [" + fila + "][" + col + "]: "+ soluciones[fila][col]);
            }
        }

    }
}
