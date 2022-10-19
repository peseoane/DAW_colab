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
     * Esta función simplemente acepta el si va ganando o perdiendo el jugador, y devuelve el ser invencible o no
     * 
     * @param estado Se le pasa por un booleano si va ganando o perdiendo
     * @return Nivel de dificultad calculado.
     */

    public static byte tramposo(boolean estado){
       return 0;
    }
    
    public static void main(String[] args) {
        
        final String encoding = "ISO-8859-1";
        Scanner entrada = new Scanner(System.in, encoding);

        // Zona principal
        System.out.println("Elije piedra, papel o tijeras: ");
        short puntosJugador = 0;
        short puntosMaquina = 0;
        String eleccion = entrada.nextLine();
        
        // Zona de Amely
        if (puntosJugador > 3 || puntosMaquina > 3) {
            
        }
        // Zona de Pedro
        
        
        
    }
    
}
