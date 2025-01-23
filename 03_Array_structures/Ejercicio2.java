/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad2uf1tema3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3]; //Creo una matriz de 3x3

        // Hago un bucle for para solicitar que ingresen los valores para cada celda de la matriz (entiendo que es como una tabla)
        for (int p1 = 0; p1 < matriz.length; p1++) {       //recorro las filas
            for (int p2 = 0; p2 < matriz[p1].length; p2++) {      //Recorro las columnas. Entiendo que al sr 3x3 podria utilizar matriz.length, porque es el mismo tamaño.
                
                try{
                   System.out.println("Escoje el valor para la fila " + (p1 + 1) + " y la coumna " + (p2 + 1) + " :");
                matriz[p1][p2] = sc.nextInt();  //Guardo el valor solicitado en el llugar correspondiente
                
                }catch (InputMismatchException e){      //Hago una excepción por si introducen algo que no sea un entero
                    System.out.println("Debes introducir un número entero");
                    sc.nextLine();
                    p2--;
                }
                
            }
        }

        int maximo = matriz[0][0];      // Creo y doy un valor (de la primera celda) a la variable para almacenar  más adelante el valor máximo 
        int minimo = matriz[0][0];      //Hago igual con el valor mínimo
        
        System.out.println(" ");        //Dejo un espacio para diferenciar mejor el texto
        System.out.println("Los valores introducidos son:");
        // Recorro la matriz para mostrar los valores introducidos y encontrar el valor máximo y mínimo
        for (int p1 = 0; p1 < matriz.length; p1++) {
            for (int p2 = 0; p2 < matriz.length; p2++) {
                        //Muestro el valor de cada celda (este paso no sería necesario pero me ayudaba a ver si lo estaba haciendo bien)
                System.out.println("El valor de la matriz [" + p1 + "] [" + p2 + "] es --> " + matriz[p1][p2]);
                
                // Comparo el valor de la celda con el  máximo y el mínimo de ahora
                if (matriz[p1][p2] > maximo) {  // Si el valor de la celda es mayor que el valor máximo actual lo cambio 
                    maximo = matriz[p1][p2];        //lo Cambio
                }
                if (matriz[p1][p2] < minimo) {     //igual con el mínimo
                    minimo = matriz[p1][p2];
                }
            }
        }
        
        System.out.println(" ");        //Dejo un espacio para diferenciar mejor el texto 
        // Muestro el valor máximo y mínimo 
        System.out.println("El valor máximo en la matriz es: " + maximo);
        System.out.println("El valor mínimo en la matriz es: " + minimo);

    }
}
