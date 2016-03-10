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
  
  public void insert(Cliente bean) {
    dao.insert(bean);
  }

  public void update(Cliente bean) {
    throw new UnsupportedOperationException("Debes programarlo."); //To change body of generated methods, choose Tools | Templates.
  }

  public void delete(Cliente bean) {
    throw new UnsupportedOperationException("Debes programarlo."); //To change body of generated methods, choose Tools | Templates.
  }
}
