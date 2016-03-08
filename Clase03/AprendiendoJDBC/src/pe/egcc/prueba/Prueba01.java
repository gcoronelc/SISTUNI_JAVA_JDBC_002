package pe.egcc.prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Coronel
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    Connection cn; 
    try { 
      // Paso 1: Cargar el driver a memoria 
      Class.forName("oracle.jdbc.OracleDriver").newInstance(); 
      // Paso 2: Obtener el objeto Connection 
      String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
      cn = DriverManager.getConnection(url, "eureka", "admin"); 
      // Mensaje
      System.out.println("Conexión OK.");
      // Cerrar conexión
      cn.close();
      System.out.println("Conexión cerrada.");
    } catch (SQLException e) { 
      System.err.println("Error: " + e.getMessage());
    } catch (ClassNotFoundException e) { 
      System.err.println("No se encontró el driver de la base de datos.");
    } catch (Exception e) { 
      System.err.println("No se puede establecer la conexión con la BD.");
    } 
  }
}
