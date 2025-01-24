
package Actividad4;


import static IntroducciónDatos.IntroduccionDatos.numeroEntreDosOpciones;   //Importo para poder usar funcion de elegir entre dos números
import static MostrarPorConsola.Menues.menuGeneral;             //Importo para poder usar el metodo menuGeneral
import static MostrarPorConsola.MostrarArray.mostrarArray;      //Importo para mostrar metodo mostrar Array
import static PosibilidadesPrograma.Posibilidades.*;            //Importo para poder usar todos los metodos del paqueteposibilidadesPrograma, clase Posibilidades

/**
 * @author eduardolucasmunozdelucas
 * 
 */
public class Actividad4 {

    public static void main(String[] args)  {

        boolean ok = true;      //Creo booleana que utilizare en el bucle while
        int opcion;             //Variable que recibira el numero de la opción del menú que se elija
        System.out.println("Bienvenid@, ");     //Muestro mensajes de bienvenida que solo apareceran cuando se abra el programa
        System.out.println("con este programa puedes manipular archivos de la carpeta -Archivos-. ");
        carpetaArchivos();      //Con la esta función creo la carpeta Archivos si no está creada.

        while (ok) {            //Hago bucle while para no salir de la aplicación al menos que el usuario escoja la opcion 6
            System.out.println(" ");        //Cuestion de estética visual
            menuGeneral("Opciones:", "(1) Crea un nuevo Archivo. ", "(2) Lista los archivos de la carpeta.", "(3) Muestra un archivo. ",
                    "(4) Borra un archivo.", "(5) Renombra un archivo", "(6) Sal del programa ");
                 //Llamo a la función menú General y escribo titulo y opciones.
                 //Cada vez que se repita el bucle m mostrará el menú y me permitira elegir numero
                 
            opcion = numeroEntreDosOpciones("Elige una opción:", 1, 6);     

            switch (opcion) {       //Estructura para elegir en base a la opción elegida
                
                case 1:     
                    String nombre = nuevoArchivo();     //llamo a la funcion nuevo archivo
                    System.out.println(" ");            //Estético
                        //Muestro por pantalla el archivo creado mostrando el return de la función nuevo archivo.
                    System.out.println("El archivo -" + nombre + "- ha sido creado con éxito.");    
                    break;      
                case 2:
                    String[] listar = listarArchivos();     //Creo arrays que sea igual que el arrays que retorna la funcion listar archivos
                    System.out.println(" ");
                    if(listar.length>0){        //En el caso de que existan archivos (que las posiciones del array sean superior a 0) mostrar lo 
                        System.out.println("Listado de rutas");
                        mostrarArray(listar);   //Llamo al metodo mostrar array para que muestre los arrays de las rutas linea a linea
                            //Podría usar --> System.out.println(Arrays.toString(listar)); Pero queda una linea de arrays de texto muy liosa
                    }     //Muestro por pantalla el título de lo siguiente que voy a mostrar
                    
                    
                    break;
                case 3:
                    mostrarArchivo();   //Llamo al metodo
                    break;
                case 4:
                    borrarArchivo();    //Llamo al metodo
                    break;
                case 5:
                    renombrarArchivo(); //Llamo al metodo
                    break;
                case 6:
                    ok = false;             //Cambio el valor de la booleana para que deje de ejecutarse el bucle y termine el programa
                    System.out.println("Gracias por usar el programa.");    //Muestro por pantalla mensaje de despedida
                    break;

            }
        }

    }
}
