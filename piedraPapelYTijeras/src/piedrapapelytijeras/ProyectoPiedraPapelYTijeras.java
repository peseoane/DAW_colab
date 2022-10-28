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
        String salirdeljuego;

        Scanner entrada = new Scanner(System.in, encoding);

        while (seguirJugando) {
            System.out.println("Elije piedra, papel o tijera: ");
            System.out.println("Elije 0 para piedra");
            System.out.println("Elije 1 para papel");
            System.out.println("Elije 2 para tijera");

            int elecUsr = entrada.nextInt();
            int elecPC = new java.util.Random().nextInt(3);

            // PIEDRA PAPEL TIJERA PARA R.>n0 a n_x -> CRB (-1,1)U(1,0)€0.0
            final int[][] soluciones = {
                    { 1, 2, 0 },
                    { 0, 1, 2 },
                    { 2, 0, 1 }
            };

            resultadoJugada = soluciones[elecUsr][elecPC];

            System.out.println("PC escoge: " + elecPC);

            switch (resultadoJugada) {
                case 0:
                    puntosJugador++;

                    System.out.println("Gana el jugador.");
                    System.out.printf("PLAYER [%d][%d] PC", puntosJugador, puntosMaquina);
                    System.out.println();
                    break;
                case 1:
                    System.out.println("Empate");
                    System.out.printf("PLAYER [%d][%d] PC", puntosJugador, puntosMaquina);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Gana el PC");
                    puntosMaquina++;
                    System.out.printf("PLAYER [%d][%d] PC", puntosJugador, puntosMaquina);
                    System.out.println();
                    break;
                
            }

            if (puntosJugador >= 3 || puntosMaquina >= 3) {
                System.out.println("¿Deseas seguir jugando Y/N?");
                entrada.nextLine(); // Limpieza de bufer.
                salirdeljuego = entrada.nextLine();
                if (salirdeljuego.toLowerCase().equals("n")) {
                    System.out.println("saliendo...");
                    seguirJugando = false;
                    entrada.close();}
                else{
                    System.out.println("Reiniciando juego...");
                    puntosJugador = 0;
                    puntosMaquina = 0;
                
                }
            }
        }
    }
}
