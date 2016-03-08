package pe.egcc.eurekacs.service;

import java.util.List;
import pe.egcc.eurekacs.dao.espec.DaoClienteEspec;
import pe.egcc.eurekacs.dao.impl.DaoClienteImpl;
import pe.egcc.eurekacs.domain.Cliente;

/**
 *
 * @author Gustavo Coronel
 */
public class ClienteService {

  private DaoClienteEspec dao;

  public ClienteService() {
    dao = new DaoClienteImpl();
  }

  public List<Cliente> getClientes(Cliente bean) {
    return dao.readForCriteria(bean);
  }
}
