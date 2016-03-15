/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.dao.interfases;

import java.util.List;
import pe.egcc.proyecto.entity.Empleado;

/**
 *
 * @author Usuario
 */
public interface EmpleadoDao {
    	void create(Empleado emp);

	List<Empleado> readAll();

	Empleado readForId(int id);

	Empleado readForUser(String user);

	List<Empleado> readForCriteria(String dato);

	void update(Empleado emp);

	void delete(int id);
}
