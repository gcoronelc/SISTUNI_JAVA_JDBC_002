package pe.egcc.eurekacs.dao.espec;

import pe.egcc.eurekacs.domain.Empleado;

/**
 *
 * @author Gustavo Coronel
 */
public interface DaoEmpleadoEspec extends DaoCrudEspec<Empleado>{
  
  
  Empleado validar(String usuario, String clave);
  
}
