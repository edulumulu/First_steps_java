import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edulumulu
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Creo variable sc escanner para luego almacenar valores introducidos por usuario
        double[] notas = new double[10]; //Creo el array para almacenar calificaciones

        for (int i = 0; i < notas.length; i++) {    //Utilizo un bucle para solicitar al usuario las 10 notas
            try {
                System.out.println("Escribe la nota " + (i + 1) + " :"); 
                notas[i] = sc.nextDouble();                //Guardar el valor introducido en cada espacio del array 

                // Condición de un número entre 0 y 10
                if (notas[i] < 0 | notas[i] > 10) {
                    System.out.println("La nota introducida no es correcta. El valor debe estar entre 0 y 10 ");
                    i--;        // Resto una iteración para que vuelva a pedirle el valor para la misma posición del array 
                }
            } catch (InputMismatchException e) {          //controlo la esxecepcion de caracter no válido
                System.out.println("La entrada no es valida, debe ser un número entre 0 y 10");
                sc.next();       // Doy paso para la siguiente introducción de caracteres
                --i;             // Resto una iteración para que vuelva a pedirle el valor para la misma posición del array 
            }
        }
        
        System.out.println(" ");
        System.out.println("Tus notas son: ");
        
        // Recorro el Array y dependiendo del valor de la nota incluyo un texto
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
