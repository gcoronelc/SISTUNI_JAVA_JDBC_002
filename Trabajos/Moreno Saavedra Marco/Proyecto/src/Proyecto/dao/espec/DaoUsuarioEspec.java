package Proyecto.dao.espec;

import Proyecto.domain.Usuario;

/**
 *
 * @author Josué Moreno
 */
public interface DaoUsuarioEspec extends DaoCrudEspec<Usuario> {

    Usuario validar(String U, String C);
}
