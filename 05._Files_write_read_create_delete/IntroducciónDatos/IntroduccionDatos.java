
package IntroducciónDatos;

import static MostrarPorConsola.Menues.menuGeneral;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edulumulu
 */
public class IntroduccionDatos {

    /**
     * Pide al usuario un número que esté entre los valores a y b
     * @param texto
     * @param a
     * @param b
     * @return 
     */
    public static int numeroEntreDosOpciones(String texto, int a, int b) {
     
        Scanner sc = new Scanner(System.in);    //Objeto Scanner 
        boolean ok = true;                      //inicializo variable boleana para bucle while
        int n = 0;                              //inicializo variable que se modificará una vez reciba el valor por teclado

        while (ok) {
            try {
                System.out.println(texto);      //Muestro texto
                n = sc.nextInt();               //Igualo n al valor introducido por el usuario

                if (n >= a && n <= b) {         //Si n mayor o igual que a y menor o igual que b (si cumple la restriccion) cambio la boleana para que terminte el bucle
                    ok = false;
                } else {                        //Si no cumple muestro mensaje de que no es correcto y vuelvo a mostrar el menú para que elija de nuevo
                    System.out.println("El dato introducido es incorrecto, debe de ser un numero entero del 1 al 6.");
                    System.out.println("Vuelve a intentarlo.");
                    System.out.println(" ");
                    menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                            "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                }
            } catch (InputMismatchException e) {        //Controlo la excepción en caso de introducir caractres no numéricos 
                System.out.println("El dato introducido es incorrecto, debe de ser un numero entero del 1 al 6.");
                System.out.println("Vuelve a intentarlo");
                System.out.println(" ");
                menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                        "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                sc.next();
            }
        }
        return n;       //retorno n
    }

}
