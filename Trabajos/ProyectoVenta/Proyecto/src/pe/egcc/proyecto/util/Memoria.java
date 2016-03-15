/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Memoria {
    	private static Map<String,Object> datos;

	static {
	datos = new HashMap<String,Object>();
	}
	
	/**
	 * Constructor privado para que no se puedan crear objetos
	 */
	private Memoria() {
	}
	
	public static Object get(String key) {
		return datos.get(key);
	}
	
	public static void put(String key, Object value){
		datos.put(key, value);
	}
}
