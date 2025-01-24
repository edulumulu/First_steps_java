
package MostrarPorConsola;

/**
 * @author eduardolucasmunozdelucas
 * Creo una clse para que en cso de tener distintos menues pudiera hacer distintas funciones
 */
public class Menues {
       
    public static void menuGeneral(String... texto){        //Menú que admite un valor indefinido de String como lineas que mostrar por pantalla
        for (String t : texto){
            System.out.println(t);
        }
    }
}
