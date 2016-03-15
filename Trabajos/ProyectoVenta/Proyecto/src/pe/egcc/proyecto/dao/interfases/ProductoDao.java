/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.dao.interfases;

import java.util.List;
import pe.egcc.proyecto.entity.Producto;

/**
 *
 * @author Usuario
 */
public interface ProductoDao {
    /**
	 * Transacción controlada desde el cliente
	 *
	 * @param prod
	 */
	void create1(Producto prod);

	/*
	 * Transacción controlada en la Base de Datos
	 */
	void create2(Producto prod);

	List<Producto> readAll();

	Producto readForId(int id);

	List<Producto> readForName(String name);

	void update(Producto prod);

	void delete(int id);
}
