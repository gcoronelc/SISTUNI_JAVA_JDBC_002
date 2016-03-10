package pe.egcc.eurekacs.controller;

import java.util.List;
import pe.egcc.eurekacs.domain.Cliente;
import pe.egcc.eurekacs.service.ClienteService;

/**
 *
 * @author Gustavo Coronel
 */
public class ClienteController {
  
  private ClienteService service;

  public ClienteController() {
    service = new ClienteService();
  }
  
  public List<Cliente> getClientes(Cliente bean) {
    return service.getClientes(bean);
  }
}
