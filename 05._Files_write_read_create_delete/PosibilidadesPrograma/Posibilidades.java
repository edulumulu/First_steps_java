package PosibilidadesPrograma;

import static IntroducciónDatos.Rutas.*;
import static MostrarPorConsola.Menues.menuGeneral;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author edulumulu
 * carpeta
 */
public class Posibilidades {

    /**
     * crea una carpeta en la rita predeterminada
     */
    public static void carpetaArchivos() {      
        File carpeta = new File(rutaCarpetaArchivos());
        if (carpeta.mkdir() == true) {
            System.out.println("Carpeta -Archivos- creada con éxito");  
        }

    }

    
    /**
     * @author eduardolucasmunozdelucas En esta clase he reunido todas las funciones
     * relacionadas con las posibilidades del menú incluyendo la de crear una
     * carpeta
     */
    public static String nuevoArchivo() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = "Vacío";     //Doy un nombreopcional al archivo que modificaré cuando el usuario lo modifique
        String textoArchivo;                //Variable para el contnido del archivo
        boolean ok = true;                  //Variable booleana para bucle while

        while (ok) {
            try {
                System.out.println(" ");
                System.out.println("Escribe el nombre del nuevo archivo:");
                nombreArchivo = sc.nextLine();      //Recojo el nombre introducido por el usuario

                String rutaArchivo = rutaArchivo(nombreArchivo);    //Creo ruta de archivo con el nombre eque el usuario ha introducido
                File archivoNuevo = new File(rutaArchivo);          //Creo el objeto
                if (!archivoNuevo.exists()) {                       //Si no existe el nombre el documento (File ArchivoNuevo)
                    archivoNuevo.createNewFile();                   //Entonces creo el documento (File ArchivoNuevo)

                    if (archivoNuevo.exists()) {                    // Si el documento (File ArchivoNuevo) se ha creado
                        System.out.println("Escribe el contenido del archivo:");        //solicito al usuario el contenido
                        textoArchivo = sc.nextLine();               //Recojo el contenido escrito
                        FileWriter fw = new FileWriter(archivoNuevo);       //creo objeto para poder escribir en el documento 
                        BufferedWriter bw = new BufferedWriter(fw);         //creo el buffered writer para no tener que escribir caracter por caracter
                        bw.write(textoArchivo);                             //Escribo el texto del usuario
                        bw.flush();                                         //Me aseguro que todo se traspasa
                        bw.close();                                         //Cierro el Bw (Buferedwriter/

                        ok = false;                                         //Terminado este proceso cambio booleana para salir del bucle
                    } else {                                                // En caso de que no se hubiera creado el documento (File ArchivoNuevo), mensaje de error
                        System.out.println("Algo a fallado, vuelve a intentarlo");
                    }

                } else {            //Si ya existia aviso que debe escoger otro nombre para crear archivo
                    System.out.println(" ");
                    System.out.println("El archivo ya existe, escoge otro nombre para el archivo");
                }

            } catch (IOException e) {       //Controlo la excepcion de entrada de datos relacionada con le tratamiento de ficheros
                System.out.println(" ");
                System.out.println("Algo a fallado, vuelve a intentarlo");
            }

        }

        return nombreArchivo;
    }

    /**
     * Lista por pantalla los archivos y retorna un array con las rutas de los archivos
     * @return 
     */
    public static String[] listarArchivos() {  //Funcion que ademas de listar por pantalla el nombre de los archivos numerados, retorna un array con sus rutas

        String rutaCarpeta = rutaCarpetaArchivos();     //Obengo ruta de carpeta
        File carpetaArchivos = new File(rutaCarpeta);   //creo File con esa ruta

        if (carpetaArchivos.exists() && carpetaArchivos.isDirectory()) {        //si existe la ruta y es un directorio paso a lo siguiente
            File[] archivos = carpetaArchivos.listFiles();                      //Creo un Array de File llamado archivo  que sea el listado de la carpeta archivos
            if (archivos != null) {                                                         //Si el contenido es diferente a null lo siguiente
                if (archivos.length > 0) {                                                  //Si la longitud del array es mayor que 0 lo siguiente
                    String[] listadoRutasArchivos = new String[archivos.length];            //Creo un array de strings con la misma longitud del listado de Files
                    System.out.println("Listado:");
                    for (int i = 0; i < archivos.length; i++) {                             //Bucle for para recorrer el array 
                        if (archivos[i].isFile()) {
                            System.out.println((i + 1) + " - " + archivos[i].getName());    //imprimo a cada iteracion el nombre del archivo de la ruta recorrida del listado File
                            listadoRutasArchivos[i] = archivos[i].getPath();                // Otorgo la ruta al String listadoRutasArchivos en la misma posicion que el listado File
                        }
                    }
                    return listadoRutasArchivos;        //Una vez recorrido el listado entero y obtenidas todas las direcciones retorno el array
                } else {                                //En caso de que no hubiera archivos mensaje de error y retorna un array con 0
                    System.out.println("La carpeta está vacía.");
                    System.out.println("Antes de usar esta opción debes de crear archivos.");
                    return new String[0];
                }
            } else {                        //En caso de que no hubiera archivos mensaje de error 
                System.out.println("Esto no es un directorio");
                return new String[0];       //mensaje de error y retorna un array con 0
            }
        } else {                            //En caso de que la carpeta no existiera, cosa qeu no puede pasar por que la creo al principio en el main, pero bueno
            System.out.println("La carpeta Archivos no existe");
            return new String[0];           //mensaje de error y retorna un array con 0
        }
    }

    /**
     * Muestra el conteido del archivo selecionado del menú de archivos dentro de la carpeta
     */
    public static void mostrarArchivo() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;

        while (ok) { // Bucle while
            try {
                String[] listado = listarArchivos();         // Creo un array de string que sea igual que el que retorna de la función lista de archivos

                if (listado.length > 0) {                    // Si la longitud del array es mayor que 0, es decir, si hay archivos en la carpeta archivos lo siguiente
                    System.out.println("Elige el archivo que quieras leer:");

                    int num = sc.nextInt();                 // num igual que el valor introducido por teclado

                    if (num < 1 || num > listado.length) {                     // Si el número no está entre 1 y la longitud del array, la opción no es válida
                        System.out.println("La opción elegida no es válida");
                        System.out.println("El número tiene que estar comprendido entre las opciones señaladas:");
                        ok = true;      
                        
                    } else {                                 // En caso de que esté dentro de los valores comprendidos en la longitud del array lo siguiente
                                                            // Muestro la ruta de la posición del array del número pedido al usuario menos 1 ya que los arrays empiezan por 0
                        System.out.println("La ruta del documento elegido es: " + listado[num - 1]);

                        File seleccionado = new File(listado[num - 1]);           // Creo el File con la ruta correspondiente
                        FileReader fr = new FileReader(seleccionado);             // Creo el File Reader para poder leer el documento
                        BufferedReader br = new BufferedReader(fr);               // Creo el BR para poder leer conjuntos de caracteres
                        System.out.println("El contenido del documento es:");
                        for (String linea = br.readLine(); linea != null; linea = br.readLine()) { // Bucle for para recorrer todas las líneas del contenido
                            System.out.println(linea);                            // Muestro por consola el texto leído línea a línea
                        }
                        br.close(); 
                        ok = false;
                    }
                }else{
                    ok= false;     
                }

            } catch (java.util.InputMismatchException | java.lang.ArrayIndexOutOfBoundsException | IOException ex) {
                // Control de excepción triple, ya sea error de introducción de datos, relacionados con las posiciones de un array o problemas de io out.
                System.out.println(" ");
                System.out.println("La opción elegida no es válida.");
                System.out.println("El número tiene que estar comprendido entre las opciones señaladas:");
                sc.next();         
            }
        }
    }

    /**
    * Elimina un archivo del menú de archivos de la carpeta
    */
    public static void borrarArchivo() {
        Scanner sc = new Scanner(System.in);
        boolean ok = true;

        /*
        En esta función utilizo un bucle while, en caso de que los datos introducidos no sean correctos se repite mostrando nuevamente el menú relacionado con
        los archivos que se pueden borrar.
        El proceso es similar al de mostrar archivos, un array de string con las rutas obtenidas en la función listar archivos. En caso de existir archivos 
        en la carpeta permito que elija una opción, muestro por pantalla la ruta de la opción y por trastear he incluido que aparece un menú en el que pregunta 
        si confirma borrar el documento o salir de la función borrar archivo
         */
        while (ok) {

            String[] listado = listarArchivos();
            if (listado.length > 0) {
                System.out.println("Elige el archivo que quieras borrar:");
                try {
                    int num = sc.nextInt();
                    if (num >= 1 && num <= listado.length) {
                        System.out.println("La ruta del documento elegido es: " + listado[num - 1]);
                        menuGeneral("¿Quieres confirmar que se borre? ", "(1) Si. ", "(2) No, quiero borrar otro archivo", "(3) No, quiero volver al menú prnincipal");
                        int respuesta = sc.nextInt();
                        if (respuesta == 1) {               //Con una estructura condicional (por cambiar) si el usiario elige la opción uno se intenta borrar el archivo
                            File elegido = new File(listado[num - 1]);
                            try {
                                if (elegido.delete()) {
                                    System.out.println("Has eliminado el archivo");         //En caso de haberlo borrado correctamente
                                } else {                                                    //En caso de que no se haya podido borrar te avisa
                                    System.out.println("No se pudo eliminar el archivo");
                                }
                                ok = false;                                 //modifico la booleana para que se salga del bucle
                            } catch (SecurityException e) {                 //contemplo la excepción de avisar si no tiene permisos para borrar el archivo
                                System.out.println("No tienes permisos para borrar este archivo");
                            }
                        } else if (respuesta == 3) {                        //En caso de que el usuario se arrepienta de borrar archivos
                            ok = false;                                     //modifico la booleana para que se salga del bucle
                        } else {                                           //En caso de que no quiera borrar el archivo en concreto regresa al menú que le muestra las opciones de archivos a borrar
                            System.out.println("No se ha borrado el archivo, vuelve a intentarlo");
                        }

                    } else {                    //Controla que si el numero no esta dentro del rango indicado mustra una alerta 
                        System.out.println("La opción elegida no es válida");
                        
                    }
                } catch (java.util.InputMismatchException | java.lang.ArrayIndexOutOfBoundsException ex) {  //Excepciones de posiciones inadecuadas array  y introducion por teclado inadecuada
                    System.out.println(" ");
                    System.out.println("La opción elegida no es válida.");
                    System.out.println("El numero tiene que estar comprendido entre las opciones señaladas:");
                    sc.next();      
                }

            } else {        
                ok = false;
            }
        }

    }

    /**
    * Permite selecionar un archivo de la lista de archivos de la carpeta y renombrarlo.
    */
    public static void renombrarArchivo() {
        /*
        Metodo totalmente simitlar al anterior (BorrarArchivo). Lo único que en este no he contemplado un menú que pregunta
        al usuario si está seguro de que quiere mostrar el documento o no y por tanto no te permite salir del metodo hasta que selecionas un
        archivo de la lista
         */
        Scanner sc = new Scanner(System.in);
        boolean ok = true;

        while (ok) {

            String[] listado = listarArchivos();
            if (listado.length > 0) {

                try {
                    System.out.println("Elige el archivo que quieras renombrar:");

                    int num = sc.nextInt();
                    if (num >= 1 && num <= listado.length) {
                        System.out.println("La ruta del documento elegido es: " + listado[num - 1]);
                        File elegido = new File(listado[num - 1]);
                        System.out.println("Introduce el nuevo nombre para el archivo:");
                        String nuevoNombre = sc.next();
                        File nuevoArchivo = new File(elegido.getParent(), nuevoNombre);
                        if (nuevoArchivo.exists()) {
                            System.out.println("¡El nombre '" + nuevoNombre + "' ya está en uso! Prueba otra vez.");
                            System.out.println(" ");
                        } else {
                            if (elegido.renameTo(nuevoArchivo)) {
                                System.out.println("El archivo se ha renombrado correctamente.");
                                ok = false;
                            } else {
                                System.out.println("No se ha podido renombrar el archivo");
                            }

                        }

                    } else {
                        System.out.println("la Opción selecionada no es correcta, escoja otra.");
                    }

                } catch (java.util.InputMismatchException | java.lang.ArrayIndexOutOfBoundsException ex) {
                    System.out.println(" ");
                    System.out.println("La opción elegida no es válida.");
                    System.out.println("El numero tiene que estar comprendido entre las opciones señaladas:");
                    sc.next();
                }
            } else {        //En caso de que no haya archivos dentro de la carpeta sale del bucle y del método
                ok = false;
            }
        }
    }

}
