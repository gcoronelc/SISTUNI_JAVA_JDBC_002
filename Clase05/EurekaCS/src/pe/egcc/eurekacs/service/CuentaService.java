package pe.egcc.eurekacs.service;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekacs.dao.espec.DaoCuentaEspec;
import pe.egcc.eurekacs.dao.impl.DaoCuentaImpl;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaService {

  private DaoCuentaEspec daoCuenta;

  public CuentaService() {
    daoCuenta = new DaoCuentaImpl();
  }
  
  public List<Map<String, ?>> traerMovimientos(String cuenta) {
    return daoCuenta.conMovimientos(cuenta);
  }

}
