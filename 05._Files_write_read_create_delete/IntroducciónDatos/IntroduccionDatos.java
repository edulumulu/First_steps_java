
package IntroducciónDatos;

import static MostrarPorConsola.Menues.menuGeneral;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author eduardolucasmunozdelucas
 * Clase que utilizo para crear funciones que restrinjan los datos introducidos por el teclado
 */
public class IntroduccionDatos {

    public static int numeroEntreDosOpciones(String texto, int a, int b) {
        /*
        FUncion que recibe un string como linea par mostrar por pantalla y dos numeros enteros, haciendo un return de un entero
        */
        Scanner sc = new Scanner(System.in);    //Objeto Scanner 
        boolean ok = true;                      //inicializo variable boleana para bucle while
        int n = 0;                              //inicializo variable que se modificará una vez reciba el valor por teclado

        while (ok) {
            try {
                System.out.println(texto);      //Muestro texto
                n = sc.nextInt();               //modifico valor de n al valor introducido

                if (n >= a && n <= b) {         //Si n mayor o igual que a y menor o igual que b (si cumple la restriccion) cambio la boleana para que terminte el bucle
                    ok = false;
                } else {        //Si no cumple muestro mensaje de que no es correcto y vuelvo a mostrar el menú para que elija de nuevo
                    System.out.println("El dato introducido es incorrecto, debe de ser un numero entero del 1 al 6.");
                    System.out.println("Vuelve a intentarlo.");
                    System.out.println(" ");
                    menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                            "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                }
            } catch (InputMismatchException e) {    //En caso de introducir caractres no numéricos salata la excepción mostrando mensaje y nuevamente el menú
                System.out.println("El dato introducido es incorrecto, debe de ser un numero entero del 1 al 6.");
                System.out.println("Vuelve a intentarlo");
                System.out.println(" ");
                menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                        "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                sc.next();
            }
        }
        return n;       //Por último retorno el valor de la variable de retorno
    }

    
    //Esta función al final no la utilicé lo creé para elegir un número comprendido entre la cantidad de posiciones de un array
    public static int introducirNumero(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean ok = true;
        while (ok) {
            try {
                System.out.println("Elige un archivo (escribe el número correspondiente):");
                n = sc.nextInt();
                if (n >= 1 && n <= a.length) {
                    ok = false;
                    return n;

                } else {
                    System.out.println("El numero introducido debe de estar entre 1 y " + a.length);
                }
            } catch (InputMismatchException e) {
                System.out.println("El numero introducido debe de estar entre 1 y " + a.length);
            }

        }

        return n;
    }

}
