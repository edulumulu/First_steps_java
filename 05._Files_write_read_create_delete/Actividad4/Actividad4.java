ue
package Actividad4;


import static IntroducciónDatos.IntroduccionDatos.numeroEntreDosOpciones;   //Importo del paquete propio
import static MostrarPorConsola.Menues.menuGeneral;                         //Importo del paquete propio
import static MostrarPorConsola.MostrarArray.mostrarArray;                  //Importo del paquete propio
import static PosibilidadesPrograma.Posibilidades.*;                        //Importo del paquete propio

/**
 * @author edulumulu
 * 
 */
public class Ejercicio {

    public static void main(String[] args)  {

        boolean ok = true;                      //Creo booleana que utilizare en el bucle while
        int opcion;                             //Variable que recibira el numero de la opción del menú que se elija
        System.out.println("Bienvenid@, ");     //Muestro mensajes de bienvenida que solo apareceran cuando se abra el programa
        System.out.println("con este programa puedes manipular archivos de la carpeta -Archivos-. ");
        carpetaArchivos();                      //Con la esta función creo la carpeta Archivos si no está creada.

        while (ok) {                            //Hago bucle while para no salir de la aplicación al menos que el usuario escoja la opcion 6
            System.out.println(" ");            //Cuestion de estética visual
            menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                    "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                 
            //Llamo a la función menú General y escribo titulo y opciones. Cada vez que se repita el bucle m mostrará el menú y me permitira elegir numero    
            opcion = numeroEntreDosOpciones("Elige una opción:", 1, 6);     

            //Estructura de control para elegir en base a la opción elegida
            switch (opcion) {       
                
                case 1:     
                    String nombre = nuevoArchivo();     //llamo a la funcion nuevo archivo
                    System.out.println(" ");            //Estético
                    
                    //Muestro por pantalla el archivo creado mostrando el return de la función nuevo archivo.
                    System.out.println("El archivo -" + nombre + "- ha sido creado con éxito.");    
                    break;      
                case 2:
                    String[] listar = listarArchivos();     //Creo arrays que sea igual que el arrays que retorna la funcion listar archivos
                    System.out.println(" ");
                    if(listar.length>0){                    //En el caso de que existan archivos (que las posiciones del array sean superior a 0) mostrar lo 
                        System.out.println("Listado de rutas");
                        mostrarArray(listar);               //Llamo al metodo mostrar array para que muestre los arrays de las rutas linea a linea
                    }     
                    
                    break;
                case 3:
                    mostrarArchivo();   
                    break;
                case 4:
                    borrarArchivo();    
                    break;
                case 5:
                    renombrarArchivo(); 
                    break;
                case 6:
                    ok = false;                             //Cambio el valor de la booleana para que deje de ejecutarse el bucle y termine el programa
                    System.out.println("Gracias por usar el programa.");    
                    break;

            }
        }

    }
}
