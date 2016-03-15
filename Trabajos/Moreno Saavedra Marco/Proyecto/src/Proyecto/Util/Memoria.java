
package Proyecto.Util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Josué Moreno
 */
public final class Memoria {
    private Memoria(){
    }
    private static Map<String,Object> datos;
    static{
        datos = new HashMap<>();
    }
    public static void put(String key, Object value){
        datos.put(key,value);
    }
    public static Object get(String key){
        return datos.get(key);
    }
}
