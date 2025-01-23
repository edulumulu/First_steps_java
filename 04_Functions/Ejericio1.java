import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author edulumulu
 */
public class Ejericio1 {

    /**
     * Solicita número al usuario por consola controlando que no sea otro caracter.
     * @param texto --> texto que se mostrará para solicitar el número
     * @return 
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

    /**
     * Crear un menú a partir de distintas cadenas de texto
     * @param texto --> Cada cadena de texto se muestra en una linea
     */
    public static void mostrarMenu(String... texto) {
        for (String t : texto) {
            System.out.println(t);
        }
    }
    
    /**
     * Suma parámetro a y b y devuelve el resultado
     * @param a
     * @param b
     * @return 
     */
    public static int sumar(int a, int b) {
        int suma = a + b;
        return suma;
    }
    
    /**
     * Resta el número a menos b y devuelve el resultado
     * @param a
     * @param b
     * @return 
     */
    public static int restar(int a, int b) {
        int resta = a - b;
        return resta;
    }

    /**
     * Divde el número a entre el número b y devuelve el resultado. el número b no puede ser 0.
     * @param a
     * @param b
     * @return 
     */
    public static double dividir(int a, int b) {
        if (b == 0) {       
            System.out.println("Error: División entre cero."); 
            return Double.NaN;  
        } else {                
            double divi = (double) a / b;
            return divi;
        }
    }

    /**
     * Multiplica el los dos números (a y b)
     * @param a
     * @param b
     * @return 
     */
    public static int multiplicar(int a, int b) {
        int x = a * b;
        return x;
    }

    /**
     * Realiza la potencia del primer número elevado al segundo
     * @param a
     * @param b
     * @return 
     */
    public static double potencia(int a, int b) {
        double potencia = Math.pow(a, b);
        return potencia;
    }

    /**
     * Mostrar números por pantalla
     * @param a
     * @param b 
     */
    public static void mostrarNumeros(int a, int b){
         System.out.println("Valor a --> " + a);    
         System.out.println("Valor b --> " + b);
    }

    
    public static void main(String[] args) {
        boolean correcto = true;       //Creo una variable booleana para utilizar en los bucles do while
        int a, b, opcion;              //Creo las variables enteras que se utilizarán para los numeros introducidos por el usuario
   
        // Bucle que incorpora la solicitud de dos números con los que realizar las operaciones
        do {
            a = introduceNumeroEntero("Introduce un número:");   
            b = introduceNumeroEntero("Introduce un segundo número:"); 
            
            // Bucle para realizar varias operaciones con los mismos números
            do {
                System.out.println(" ");  
                
                // Llamo a lafunción de escribir un menú
                mostrarMenu("Opciones: ", "1: Sumar", "2: Restar", "3: Dividir", "4: Multiplicar", "5: Potencia", "6: Salir del programa");
                System.out.println(" ");
                opcion = introduceNumeroEntero("Elige una opción");     

                /*
                *Estructura switch para contemplar las opciones validas y que mostrar por pantalla en cada elección.
                *En cada case llamo a una función matemáticadistinta, y pregunto si quieren seguir realizando 
                más operaciones
                */
                switch (opcion) {   
                    case 1 -> {
                        mostrarNumeros(a,b);
                        System.out.println("la suma de " + a + " + " + b + " es --> " + sumar(a, b));
                    }
                    case 2 -> {
                        mostrarNumeros(a,b);
                        System.out.println("la resta de " + a + " - " + b + " es --> " + restar(a, b));
                    }
                    case 3 -> {
                        mostrarNumeros(a,b);
                        System.out.println("la división de " + a + " / " + b + " es --> " + dividir(a, b));
                    }
                    case 4 -> {
                         mostrarNumeros(a,b);
                        System.out.println("la multiplicación de " + a + " x " + b + " es --> " + multiplicar(a, b));
                    }
                    case 5 -> {
                        mostrarNumeros(a,b);
                        System.out.println("la potencia de " + a + " elevado a " + b + " es --> " + potencia(a, b));
                    }
                    case 6 -> {
                        System.out.println("Gracias por participar.");
                        correcto = false;   //Modifico la variable booleana correcto a falso para salir del bucle
                    }
                    default -> System.out.println("Opcion no válida, vuelve a intentarlo");
                }

                 System.out.println("¿Quieres realizar otra operación o salir del programa?");
                
            } while (correcto);     

            //Pregnuto si el usuario quiere introducir nuevos números o salir del programa
            System.out.println(" ");    
            mostrarMenu("¿¿Qué quieres hacer ahora?", "1: introducir dos numeros nuevos.", "2: Salir del programa.");
            System.out.println(" ");
            int opcion2 = introduceNumeroEntero("Elije entre la opción 1 y 2:"); //

            // Estructura de control de flujo
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
