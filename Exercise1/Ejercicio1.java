

import java.util.Scanner;

/**
 *
 * @author edulumulu
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        //1.2 Introduzco datos relacionados con cantidades
        int cantidadMelones = 10;
        int cantidadPeras = 20;
        int cantidadManzanas = 15;
        
        // 1.3 Introduzco los precios de cada fruta
        double precioMelon = 1.55;
        double precioPera = 0.75;
        double precioManzana = 0.88;
     
        // creo la variable donde se va almacenar la cantidad que escoja el cliente
        Scanner sc = new Scanner(System.in);
        
        //Pregunto al cliente cuantos melones va a comprar
        System.out.println("¿Cuántos melones quieres comprar?");
        //Le resto la cantidad de melones que ha comprado a la cantidad original
        cantidadMelones = cantidadMelones - sc.nextInt();
        
         //Pregunto al cliente cuantas peras va a comprar
        System.out.println("¿Cuántas peras quieres comprar?");
        //Le resto la cantidad de melones que ha comprado a la cantidad original
        cantidadPeras = cantidadPeras - sc.nextInt();
        
         //Pregunto al cliente cuantas manzanas va a comprar
        System.out.println("¿Cuántas manzanas quieres comprar?");
        //Le resto la cantidad de melones que ha comprado a la cantidad original
        cantidadManzanas = cantidadManzanas - sc.nextInt();

        //Muestro por pantalla las existencias despues de la compra
        System.out.println("adespues de la última compra en la tienda quedan:");
        System.out.println(cantidadMelones+" melones, "+cantidadPeras+" peras y "+cantidadManzanas+" manzanas.");
        System.out.println("--- PROGRAMA FINALIZADO ---");
    }
    
}
