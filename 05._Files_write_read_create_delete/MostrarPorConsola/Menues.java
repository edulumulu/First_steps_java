
package MostrarPorConsola;

/**
 * @author edulumulu
 */
public class Menues {

       /**
     * Permite crear un menú general añadiendo un array de Strings como textos en cada linea
     * @param texto 
     */ 
    public static void menuGeneral(String... texto){        
        for (String t : texto){
            System.out.println(t);
        }
    }
}
