package pe.egcc.eurekacs.dao.espec;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Gustavo Coronel
 */
public interface DaoCuentaEspec {
  
  List<Map<String,?>> conMovimientos(String cuenta);
  
}
