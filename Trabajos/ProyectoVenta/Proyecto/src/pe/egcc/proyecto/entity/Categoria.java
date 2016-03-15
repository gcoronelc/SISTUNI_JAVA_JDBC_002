/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.entity;

/**
 *
 * @author Usuario
 */
public class Categoria {
    private int idcat;
	private String nombre;

	public Categoria() {
	}

	public Categoria(int idcat, String nombre) {
		this.idcat = idcat;
		this.nombre = nombre;
	}

	public int getIdcat() {
		return idcat;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
}
