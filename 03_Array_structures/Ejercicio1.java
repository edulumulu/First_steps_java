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
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Creo variable sc escanner para luego almacenar valores introducidos por usuario
        double[] notas = new double[10]; //Creo el array para almacenar calificaciones

        for (int i = 0; i < notas.length; i++) {    //Utilizo un bucle para solicitar al usuario las 10 notas
            try {
                System.out.println("Escribe la nota " + (i + 1) + " :"); //pido las notas desde la nº1 a la10
                notas[i] = sc.nextDouble();                //Guardar el valor introducido en cada espacio del arrays 
                if (notas[i] < 0 | notas[i] > 10) {
                    //En caso de de que el valor sea un double pero no está entre 0 y 10 aviso al cliente y le pido que meta un valor valido
                    System.out.println("La nota introducida no es correcta. El valor debe estar entre 0 y 10 ");
                    i--;        //Como ha introducido un valor no válido resto una iteración para que vuelva a pedirle el valor erroneo y no el siguiente
                }
            } catch (InputMismatchException e) {          //Introduzco una excepción por si introducen por teclado valor no válido
                System.out.println("La entrada no es valida, debe ser un número entre 0 y 10");
                sc.next();      //Para que no se quede bloqueado el escaner en caso de que salte el catch
                --i;         //Como ha introducido un valor no válido resto una iteración para que vuelva a pedirle el valor erroneo y no el siguiente

            }

        }
        System.out.println(" ");
        System.out.println("Tus notas son: ");
        //A la hora de mostrar los valores por pantalla hago un for con los condicionales de cada nota válida introducida
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 0 && notas[i] < 3) {
                System.out.println("Nota: "+notas[i] + " - Deficiente");
            } else if (notas[i] >= 3 && notas[i] < 5) {
                System.out.println("Nota: "+notas[i] + " - Insuficiente");
            } else if (notas[i] >= 5 && notas[i] < 8) {
                System.out.println("Nota: "+notas[i] + " - Bien");
            } else if (notas[i] >= 8 && notas[i] < 10) {
                System.out.println("Nota: "+notas[i] + " - Notable");
            } else {
                System.out.println("Nota: "+notas[i] + " - Excelente");
            }

        }

    }
}

//También podría hacer esta estructura con un switch
//        System.out.println(" ");
//        System.out.println("Opción 2 --> estructura con switch - cases: ");

//        for (int i = 0; i < notas.length; i++) {
//            switch ((int) notas[i]) {   //Para ello hago una conversión explícita ya que solo puede evaluar expresiones que sean tipos primitivos enteros
//                case 0:
//                case 1:
//                case 2:
//                    System.out.println("Nota: "+notas[i] + " - Deficiente");
//                    break;     //Para que no siga recorriendo el resto de cases y haga la sigiente iteración del bucle
//                case 3:
//                case 4:
//                    System.out.println("Nota: "+notas[i] + " - Insuficiente");
//                    break;      
//                case 5:
//                case 6:
//                case 7:
//                    System.out.println("Nota: "+notas[i] + " - Bien");
//                    break;      
//                case 8:
//                case 9:
//                    System.out.println("Nota: "+notas[i] + " - Notable");
//                    break;      
//                case 10:
//                    System.out.println("Nota: "+notas[i] + " - Excelente");
//                    break;
                  /*En este caso no sería necesario el defalult ya que debido a la preveción de errores cuando solictamos las notas, 
                    nunca podría tener un valor que no estuviera dentro de los cases señalados*/  
//                default:
//                    System.out.println("Nota no válida");
//                    break;
//            }
//        }
