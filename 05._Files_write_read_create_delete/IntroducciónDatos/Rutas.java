
package IntroducciónDatos;

import java.io.File;

/**
 * @author eduardolucasmunozdelucas
 * Esto lo he hecho diferente a como lo propusiste en clase, pero ya lo había hecho así y quería saber si era correcto
 * Decidí hacer dos funciones que me devolvieran un string con la ruta tanto de la carpeta como de un archivo.
 */
public class Rutas {

    /**
     * Obtengo la ruta de la carpeta "ARCHIVOS"
     * @return 
     */
    public static String rutaCarpetaArchivos (){
        String rutaProyecto = System.getProperty("user.dir");
        String sep = File.separator;
        String rutaCarpeta = rutaProyecto + sep + "Archivos";
        
        return rutaCarpeta;
    }

    /**
     * Obtengo ruta de un archivo en concreto dentro de la carpeta "Archivos"
     * @param texto
     * @return 
     */
    public static String rutaArchivo(String texto){     
        String r = rutaCarpetaArchivos();
        String sep = File.separator;
        String rutaArchivo = r + sep + texto;
        
        return rutaArchivo;
    }
}
