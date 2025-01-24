
package IntroducciónDatos;

import java.io.File;

/**
 * @author eduardolucasmunozdelucas
 * Esto lo he hecho diferente a como lo propusiste en clase, pero ya lo había hecho así y quería saber si era correcto
 * Decidí hacer dos funciones que me devolvieran un string con la ruta tanto de la carpeta como de un archivo.
 */
public class Rutas {
    public static String rutaCarpetaArchivos (){
        String rutaProyecto = System.getProperty("user.dir");
        String sep = File.separator;
        String rutaCarpeta = rutaProyecto + sep + "Archivos";
        
        return rutaCarpeta;
    }
    
    public static String rutaArchivo(String texto){     //En este caso pido que se escriba el nombre que se le quiere dar como ruta despues del separador
        String r = rutaCarpetaArchivos();
        String sep = File.separator;
        String rutaArchivo = r + sep + texto;
        
        return rutaArchivo;
    }
}
