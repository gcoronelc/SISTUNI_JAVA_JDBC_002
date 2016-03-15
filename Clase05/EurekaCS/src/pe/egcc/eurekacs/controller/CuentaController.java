package pe.egcc.eurekacs.controller;

import java.util.List;
import java.util.Map;
import pe.egcc.eurekacs.service.CuentaService;

/**
 *
 * @author Gustavo Coronel
 */
public class CuentaController {

  private CuentaService cuentaService;

  public CuentaController() {
    cuentaService = new CuentaService();
  }
  
  public List<Map<String,?>> traerMovimientos(String cuenta){
    return cuentaService.traerMovimientos(cuenta);
  }
  
}
