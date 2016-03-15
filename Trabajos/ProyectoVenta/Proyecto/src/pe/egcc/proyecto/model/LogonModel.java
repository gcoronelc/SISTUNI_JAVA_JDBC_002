/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.model;

import pe.egcc.proyecto.dao.interfases.EmpleadoDao;
import pe.egcc.proyecto.dao.oracle.OracleEmpleadoDao;
import pe.egcc.proyecto.dto.LogonDto;
import pe.egcc.proyecto.entity.Empleado;

/**
 *
 * @author Usuario
 */
public class LogonModel {
    public Empleado validarUsuario(LogonDto dto){
		Empleado emp;
		EmpleadoDao dao = new OracleEmpleadoDao();
		emp = dao.readForUser(dto.getUsuario());
		if(emp == null){
			throw new RuntimeException("Usuario no es correcto.");
		}
		if(!emp.getClave().equals(dto.getClave())){
			throw new RuntimeException("Clave no es correcta.");
		}
		return emp;
	}
}
