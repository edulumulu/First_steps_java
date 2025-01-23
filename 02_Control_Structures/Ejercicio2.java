import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edulumulu
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        //Defino sc para leer datos
        Scanner sc = new Scanner(System.in);
        double a, b = -1;
        boolean exit;

        do {
                System.out.println("Escribe un primer valor");
            
            a = sc.nextDouble();

            if (a > 0) {
                System.out.println("El valor  es correcto");
                System.out.println("Escribe un segundo valor");
                b = sc.nextDouble();
                if (b > 0) {
                    System.out.println("El valor es correcto");
                    System.out.println("Los valores elegidos han sido el: " + a + " y el :" + b);
                    exit = true;
                } else {
                    System.out.println("El valor del segundo número no es correcto");
                    System.out.println("Empecemos de nuevo");
                    exit = false;
                }
            } else {
                System.out.println("El valor del primer número no es correcto");
                System.out.println("Empecemos de nuevo");
                exit = false;
            }
        } while (!exit);

        int menuOpcion;
        boolean menuOk;
        menuOk = true;


        do {
            //Estructura de control que controla la excepcion InputMismatchException
            
            try {
                System.out.println(" ");
                System.out.println("Elige una de eestas opciones: ");
                System.out.println("(1) - Sumar valores ");
                System.out.println("(2) - Restar los valores");
                System.out.println("(3) - Multiplicar los valores ");
                System.out.println("(4) - Dividir los valores ");
                System.out.println("(0) - Salir del programa ");

                menuOpcion = sc.nextInt();
                
                switch (menuOpcion) {
                    case 1:
                        double suma = a + b;
                        System.out.println("La suma de: " + a + " + " + b + " = " + suma);
                        menuOk = false;
                        break;
                    case 2:
                        double resta = a - b;
                        System.out.println("La resta de: " + a + " - " + b + " = " + resta);
                        menuOk = false;
                        break;

                    case 3:
                        double producto = a * b;
                        System.out.println("La multiplicación de: " + a + " X " + b + " = " + producto);
                        menuOk = false;
                        break;

                    case 4:
                        double division = a / b;
                        System.out.println("La división de: " + a + " / " + b + " = " + division);
                        menuOk = false;
                        break;

                    case 0:
                        System.out.println("Gracias por participar, cierro el programa.");
                        System.out.println("¡¡¡Pasa un buen día!!!");

                        menuOk = true;
                        break;
                    default:
                        System.out.println("La opción escogida es incorrecta, elije de nuevo:");
                        menuOk = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("No es un número de la opción del menú.");
                
                sc.nextLine();
                menuOk = false;
                       
            }
        } while (!menuOk);
        sc.close();
    }
}
