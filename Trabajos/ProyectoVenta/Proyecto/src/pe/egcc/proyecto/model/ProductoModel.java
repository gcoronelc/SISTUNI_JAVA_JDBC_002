/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.model;

import java.util.List;
import pe.egcc.proyecto.dao.interfases.CategoriaDao;
import pe.egcc.proyecto.dao.oracle.OracleCategoriaDao;
import pe.egcc.proyecto.dao.oracle.OracleProductoDao;
import pe.egcc.proyecto.entity.Categoria;
import pe.egcc.proyecto.entity.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoModel {
    private OracleProductoDao productoDao;

	public ProductoModel() {
		productoDao = new OracleProductoDao();
	}

	public List<Producto> buscar(String nombre){
		return productoDao.readForName(nombre);
	}

	public void eliminar(int id) {
		productoDao.delete(id);
	}

	public List<Categoria> traerCategorias() {
		CategoriaDao dao = new OracleCategoriaDao();
		return dao.readAll();
	}

	public Producto buscar(int id) {
		return productoDao.readForId(id);
	}

	/**
	 * Control de transacción en el cliente
	 * @param prod 
	 */
	public void insertar1(Producto prod) {
		productoDao.create1(prod);
	}
	
	/**
	 * Control de trabsacción en el procedimiento almacenado
	 * @param prod 
	 */
	public void insertar2(Producto prod) {
		productoDao.create2(prod);
	}
	
	public void actualizar(Producto prod){
		productoDao.update(prod);
	}
}
