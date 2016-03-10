package pe.egcc.eurekacs.controller;

import java.util.List;
import pe.egcc.eurekacs.domain.Cliente;
import pe.egcc.eurekacs.service.ClienteService;
import pe.egcc.eurekacs.util.Eureka;

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

  public void grabar(Cliente bean, String accion) {
    switch(accion){
      case Eureka.CRUD_NUEVO:
        service.insert(bean);
        break;
        
      case Eureka.CRUD_EDITAR:
        service.update(bean);
        break;
        
      case Eureka.CRUD_ELIMINAR:
        service.delete(bean);
        break;
        
    }
  }
  
  
}
