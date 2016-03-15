package Proyecto.service;

import Proyecto.domain.Usuario;
import Proyecto.dao.espec.DaoUsuarioEspec;
import Proyecto.dao.impl.DaoUsuarioImpl;
import java.util.List;

/**
 *
 * @author Josué Moreno
 */
public class AccesoService {

    private DaoUsuarioEspec dao;

    public AccesoService() {
        dao = new DaoUsuarioImpl();
    }

    public Usuario validar(String U, String C) {
        Usuario bean = null;
        bean = dao.validar(U, C);
        return bean;
    }

    public List<Usuario> readAll() {
        return dao.readAll();
    }
    public List<Usuario> getClientes(Usuario bean) {
        return dao.readForCriteria(bean);
    }
    public void insert(Usuario bean,String ruta) {
         dao.insert(bean,ruta);
    }
    public void delete(Usuario bean) {
         dao.delete(bean);
    }
    public void update(Usuario bean,String ruta){
        dao.update(bean,ruta);
    }
}
