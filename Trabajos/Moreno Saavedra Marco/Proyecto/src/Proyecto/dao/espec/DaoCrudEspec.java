package Proyecto.dao.espec;

import java.util.List;

/**
 *
 * @author Josué Moreno
 */
public interface DaoCrudEspec<T> {

    T readForId(String codigo);

    List<T> readAll();

    List<T> readForCriteria(T bean);

    void insert(T bean,String ruta);

    void update(T bean,String ruta);

    void delete(T bean);
}
