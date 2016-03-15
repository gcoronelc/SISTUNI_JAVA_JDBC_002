/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.egcc.proyecto.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Dialogo {
    	public static final int YES_OPTION = JOptionPane.YES_OPTION;
	public static final int NO_OPTION = JOptionPane.NO_OPTION;

	/**
	 * Constructor privado para que no se puedan crear instancias
	 */
	private Dialogo() {
	}

	public static void info(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "INFO", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void error(Component parent, String message) {
		JOptionPane.showMessageDialog(parent, message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public static int confirmYesNo(Component parent, String question) {
		int rpta = JOptionPane.showConfirmDialog(
				parent,
				question,
				"PREGUNTA",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		return rpta;
	}
}
