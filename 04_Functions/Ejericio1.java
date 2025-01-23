/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad3uf2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author eduardolucasmunozdelucas
 */
public class Ejericio1 {

    /*
    *Creo una función para cada vez que tenga que solicitar un numero por teclado.
    *La función permite decidir que texto mostrar por pantalla y retorna un valor entero.
    *También contemplo la excepción de que introduzcan un formato erróneo con un try-catch
    y restando una iteración en caso de error para que el bucle for vuelva a solicitar el numero.    
    */
    
    public static int introduceNumeroEntero(String texto) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1; i++) {
            try {
                System.out.println(texto);
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("el valor introducido es invalido, debe de ser un número entero");
                sc.next();
                i--;
            }
        }

        return num;
    }

    /*
    *Creo una función para mostrar por pantalla el tipo de menú que desée pudiendo introducir diferentes
    cadenas de texto.
    En este caso no hay valor de retorno solo muestra por pantalla los distientos mensajes.
    */
    public static void mostrarMenu(String... texto) {
        for (String t : texto) {
            System.out.println(t);
        }
    }
    
    /*
    *Creo 5 funciones de operaciones matemáticas en las que se les llama con dos valores y retorna una numero
    */
    public static int sumar(int a, int b) {
        int suma = a + b;
        return suma;
    }

    public static int restar(int a, int b) {
        int resta = a - b;
        return resta;
    }

    public static double dividir(int a, int b) {
        if (b == 0) {       //Estructura if para contemplar si el dividendo es 0 o no
        System.out.println("Error: División entre cero."); //Contemplo la opción de que el dividendo sea 0 
        return Double.NaN;  //En cuyo caso retorna un mensaje de no es un numero (Not a NUmber).
    } else {                //Si el dividendo no es 0 retorna el resultado
        double divi = (double) a / b;
        return divi;
    }

    }

    public static int multiplicar(int a, int b) {
        int x = a * b;
        return x;
    }

    public static double potencia(int a, int b) {
        double potencia = Math.pow(a, b);
        return potencia;
    }

    /*
    *En el metodo principal llamo a las distintas funciones creadas anteriormente para evitar escribir 
    (en algunos casos) repetidas veces el código
    */
    public static void main(String[] args) {
         boolean correcto = true;   //Creo una variable booleana para utilizar en los bucles do while
        int a, b, opcion;           //Creo las variables enteras que se utilizarán para los numeros introducidos por el usuario
        
        /*
        *Hago dos bucles do while, uno por si quiere volver a escribir dos numeros con los que realizar operaciones
        y otro por si quiere realizar distintas operaciones con los 2 mismos numeros.
        */
        do {
            a = introduceNumeroEntero("Introduce un número:");   //Llamo a la función de introducir entero a con el texto que quiero mostrar
            b = introduceNumeroEntero("Introduce un segundo número:"); //Llamo a la función de introducir entero b con el texto que quiero mostrar
            do {
                System.out.println(" ");  //Cuestion de estéica visual para que no haya muchas lineas de texto seguidas
                 //Muestro el menú y elijo lo que quiero mostrar en cada linea
                mostrarMenu("Opciones: ", "1: Sumar", "2: Restar", "3: Dividir", "4: Multiplicar", "5: Potencia", "6: Salir del programa");
                System.out.println(" ");
                opcion = introduceNumeroEntero("Elige una opción");     //LLamo a la función de introducir un numero (referencia a el menú mostrado)

                /*
                *Estructura switch para contemplar las opciones validas y que mostrar por pantalla en cada elección.
                *En cada case llamo a una función matemática creada anteriormente, y pregunto si quieren seguir realizando 
                más operaciones
                */
                switch (opcion) {   
                    case 1 -> {
                        System.out.println("Valor a --> " + a);     //Yo haría solo loa linea116, pero el enunciado ide que mostremos cada variable (a y b)
                        System.out.println("Valor b --> " + b);
                        System.out.println("la suma de " + a + " + " + b + " es --> " + sumar(a, b));
                        System.out.println("¿Quieres realizar otra operación o salir del programa?");
                    }
                    case 2 -> {
                        System.out.println("Valor a --> " + a);
                        System.out.println("Valor b --> " + b);
                        System.out.println("la resta de " + a + " - " + b + " es --> " + restar(a, b));
                        System.out.println("¿Quieres realizar otra operación o salir del programa?");
                    }
                    case 3 -> {
                        System.out.println("Valor a --> " + a);
                        System.out.println("Valor b --> " + b);
                        System.out.println("la división de " + a + " / " + b + " es --> " + dividir(a, b));
                        System.out.println("¿Quieres realizar otra operación o salir del programa?");
                    }
                    case 4 -> {
                        System.out.println("Valor a --> " + a);
                        System.out.println("Valor b --> " + b);
                        System.out.println("la multiplicación de " + a + " x " + b + " es --> " + multiplicar(a, b));
                        System.out.println("¿Quieres realizar otra operación o salir del programa?");
                    }
                    case 5 -> {
                        System.out.println("Valor a --> " + a);
                        System.out.println("Valor b --> " + b);
                        System.out.println("la potencia de " + a + " elevado a " + b + " es --> " + potencia(a, b));
                        System.out.println("¿Quieres realizar otra operación o salir del programa?");
                    }
                    case 6 -> {
                        System.out.println("Gracias por participar.");
                        correcto = false;   //En el caso de escoger la opción 6 modifico la variable booleana correcto a falso para salir del bucle
                    }
                    default -> System.out.println("Opcion no válida, vuelve a intentarlo");
                }
            } while (correcto);     //El bucle se repetirá salvo que la variable booleana correcto cambie a falso
            
            /*
            *Repito la estructura del bucle anterior mostrando al usuario un menú en el que se le da la opción de elegir
            otros dos numeros o salir de la aplicación.
            *En caso de elegir la opción 1 repite el programa entero.
            *En caso de elegir la 2 sale del programa.
            */
            System.out.println(" ");    
            mostrarMenu("¿¿Qué quieres hacer ahora?", "1: introducir dos numeros nuevos.", "2: Salir del programa.");
            System.out.println(" ");
            int opcion2 = introduceNumeroEntero("Elije entre la opción 1 y 2:"); //
            
            switch (opcion2) {
                case 1 -> correcto= true;
                case 2 -> { 
                    System.out.println("Gracias por participar.");
                    correcto = false;
                }
                default -> {
                    System.out.println("Opcion no válida, vuelve a intentarlo.");
                    correcto = true;
                }
            }
            
        } while (correcto);
        

    }
}
