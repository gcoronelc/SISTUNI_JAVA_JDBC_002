/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.dao.interfases;

import java.util.List;
import pe.egcc.proyecto.entity.Categoria;

/**
 *
 * @author Usuario
 */
public interface CategoriaDao {
    void create(Categoria cat);

	List<Categoria> readAll();

	Categoria readForId(int id);

	List<Categoria> readForCriteria(String dato);

	void update(Categoria cat);

	void delete(int id);
}
