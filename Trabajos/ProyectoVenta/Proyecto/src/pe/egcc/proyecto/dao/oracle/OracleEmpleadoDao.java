/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import pe.egcc.proyecto.dao.db.AccesoDB;
import pe.egcc.proyecto.dao.interfases.EmpleadoDao;
import pe.egcc.proyecto.entity.Empleado;

/**
 *
 * @author Usuario
 */
public class OracleEmpleadoDao implements EmpleadoDao {

    @Override
    public void create(Empleado emp) {
       
    }

    @Override
    public List<Empleado> readAll() {
      return null;
    }

    @Override
    public Empleado readForId(int id) {
      return null;
    }

    @Override
    public Empleado readForUser(String user) {
        Empleado bean = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String query = "select idemp, nombre, apellido, usuario, clave "
					+ "from empleado where usuario=? ";
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setString(1, user);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				bean = rsToBean(rs);
			}
			rs.close();
			pstm.close();
		} catch(SQLException e){
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error al consultar datos del usuario.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return bean;
    }

    @Override
    public List<Empleado> readForCriteria(String dato) {
        return null;
    }

    @Override
    public void update(Empleado emp) {
       }

    @Override
    public void delete(int id) {
        
    }

    private Empleado rsToBean(ResultSet rs) throws SQLException {
        Empleado bean = new Empleado();
	bean.setIdemp(rs.getInt("idemp"));
	bean.setNombre(rs.getString("nombre"));
	bean.setApellido(rs.getString("apellido"));
	bean.setUsuario(rs.getString("usuario"));
	bean.setClave(rs.getString("clave"));
        return bean;
    }
    
    
}
