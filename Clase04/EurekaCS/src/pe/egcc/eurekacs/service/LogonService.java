package pe.egcc.eurekacs.service;

import pe.egcc.eurekacs.dao.espec.DaoEmpleadoEspec;
import pe.egcc.eurekacs.dao.impl.DaoEmpleadoImpl;
import pe.egcc.eurekacs.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public class LogonService {
  
  public Empleado validar(String usuario, String clave){
    Empleado bean = null;
    DaoEmpleadoEspec dao = new DaoEmpleadoImpl();
    bean = dao.validar(usuario, clave);
    return bean;
  }
  
}
