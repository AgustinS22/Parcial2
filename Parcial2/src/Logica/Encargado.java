package Logica;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Encargado {
	private int id_encargado;
	private String nombre;
	private String contraseña;
	
	public Encargado(int id_encargado, String nombre, String contraseña) {
		super();
		this.id_encargado = id_encargado;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getId_encargado() {
		return id_encargado;
	}
	public void setId_encargado(int id_encargado) {
		this.id_encargado = id_encargado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Encargado [id_encargado=" + id_encargado + ", nombre=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	public static boolean validarEncargado(Encargado encargado) {
		int id;
		String nomb, contra;
		 	id = Integer.parseInt(JOptionPane.showInputDialog("Por favor, ingrese su id de encargado"));
			nomb = JOptionPane.showInputDialog("Por favor, ingrese su nombre");
			contra = JOptionPane.showInputDialog("Por favor, ingrese su contraseña");
			if (contra.equalsIgnoreCase(encargado.getContraseña()) && id == encargado.getId_encargado() && nomb.equalsIgnoreCase(encargado.getNombre())) {
				JOptionPane.showMessageDialog(null, "Usted ha ingresado con exito! Bienvenido " + encargado.getNombre());
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Datos ingresados incorrectamente, vuelva a intentarlo mas tarde.");
				return false;
			}
	}
	
	
}
