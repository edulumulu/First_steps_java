import java.util.Scanner;

/**
 *
 * @author edulumulu
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        //Defino sc para leer datos
        Scanner sc = new Scanner(System.in); 

        //Declaro las dos variables de tipo double
        double a, b = -1;       

        //Declro variable boleana para poder hacer el bucle en el caso de que no se cumpla la condición de los números positivos.
        boolean exit;
        
        //Utilizo un do-while hasta que se cumplan las condiciones
        do {
            //Pido al usuario que escriba nun número por pantalla
            System.out.println("Escribe un primer valor");
            //Asocio el numero escogido por el usuario a la variable a
            a = sc.nextDouble();
           
            //hago la estuctura condicional, si a > 0 es correcto
            if (a > 0) {
                System.out.println("El valor  es correcto");
                //Si es correcto pido al usuario que escriba un 2º número por pantalla
                System.out.println("Escribe un segundo valor");
               //Asocio ese numero a la variable b
                b = sc.nextDouble();
                //hago la estuctura condicional, si b > 0 es correcto
                if (b > 0) {
                    System.out.println("El valor es correcto");
                    //Si es correcto muestro los dos números escogidos por pantalla
                    System.out.println("Los valores elegidos han sido el: " + a + " y el :" + b);
                    exit = true; //Le pongo el valor true a la variable para salir del bucle para que salga de el
                } else {
                    //En caso de no scumplir la condición el numero 2 escogido se lo comunico por pantalla 
                    System.out.println("El valor del segundo número no es correcto");
                    System.out.println("Empecemos de nuevo");
                    exit = false; //Le pongo el valor false a la variable para que vuelva a repetir desde el principio
                }
            } else {
                //En caso de no scumplir la condición el numero 1 escogido se lo comunico por pantalla 
                System.out.println("El valor del primer número no es correcto");
                System.out.println("Empecemos de nuevo");
                exit = false;
            }
        } while (!exit);

        int menuOpcion; //Declaro la variable que va a contener las opciones de menú que elija el usuario
        boolean menuOk; //Declro variable bolean para poder hacer el bucle en el caso de que no escoja una opción contemplada en el menú.
        //Comienzo segunda estructura do while
        do {
            //Enseño por pantalla el munú de opciones
            System.out.println(" ");
            System.out.println("Elige una opción: ");
            System.out.println("(1) - Sumar valores ");
            System.out.println("(2) - Restar los valores");
            System.out.println("(3) - Multiplicar los valores ");
            System.out.println("(4) - Dividir los valores ");
            System.out.println("(0) - Salir del programa ");
            menuOpcion = sc.nextInt(); //Asocio la opción (numero entero) escogido por el usuario a la variable menuOpcion
            menuOk = true;      
            
            switch (menuOpcion) {       

                case 1:
                    double suma = a + b; //declaro variable suma y en cada caso (2,3,4) su respectiva
                    System.out.println("La suma de: " + a + " + " + b + " = " + suma);
                    menuOk = false;   
                    break; //Utilizo el break para que no se ejecuten automaticamente los siguientes lineas en cada caso (2,3,4,0 y default)

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

                    menuOk = true; //Elijo true para que se cierre el bucle y por tanto el programa
                    break;
                default:
                    System.out.println("La opción escogida es incorrecta, elije de nuevo:");
                    menuOk = false;
                    break;
            }

        } while (!menuOk); //En caso de que la salida de la variable menuOk sea false entonces se repite el bucle
    sc.close(); //libero recursos cerrando el Scanner
    }
}


