package pe.egcc.eurekacs.controller;

import pe.egcc.eurekacs.domain.Empleado;
import pe.egcc.eurekacs.service.LogonService;
import pe.egcc.eurekacs.util.Memoria;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonController {
  
  public void validar(String usuario, String clave){
    LogonService service = new LogonService();
    Empleado empleado = service.validar(usuario, clave);
    if(empleado == null){
      throw new RuntimeException("Datos incorrectos.");
    } else {
      Memoria.put("usuario", empleado);
    }
  }
}
