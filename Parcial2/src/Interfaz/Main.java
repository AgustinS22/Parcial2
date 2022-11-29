package Interfaz;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Logica.*;


public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		Cafe latte = new Cafe(1, "Cafe Latte", 1.5, 0);
		Cafe flat_white = new Cafe(2, "Cafe Flat White", 2.5, 0);
		Cafe lagrima = new Cafe(3, "Cafe Lagrima", 1.3, 0);
		Cafe expresso = new Cafe(4, "Cafe Expresso", 1, 0);
		LinkedList<Cafe> cafes = new LinkedList<>();
		cafes.add(latte);
		cafes.add(flat_white);
		cafes.add(lagrima);
		cafes.add(expresso);
		Encargado encargado = new Encargado(123,"Agustin", "1567");
		LinkedList<Venta> ventas = new LinkedList<>();
		LinkedList<Cliente> clientes = new LinkedList<>();
		int dato;
		boolean verd;
		String op;
		verd= encargado.validarEncargado(encargado);
		if (verd) {
		do  {
			dato = menu();
			if (dato == 1) {
				menuVenta(ventas, cafes, clientes);
			} else if (dato == 2) {
				menuConsulta(ventas, cafes);
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta.");
			}	
		op = JOptionPane.showInputDialog("Desea volver a realizar una consulta? \nSI o NO");
		} while (op.equalsIgnoreCase("si"));
		}

		
		
		
	}

	
	
	public static int menu() {
		int op;
		op = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea realizar? \n 1 - Ingresar una nueva venta \n 2 - Finalizar el dia"));
		return op;		
	}
	
	public static void menuVenta(LinkedList<Venta> ventas, LinkedList<Cafe> cafes, LinkedList<Cliente> clientes) {
		int id = 0;
		String tipo, cliente, tarjeta, repetir;
		int dni, cantidad;
		double precio_tot, precio, desc;
		
		do {
			cliente = JOptionPane.showInputDialog("Por favor, para comenzar, ingrese el nombre del cliente que realizo la compra");
			dni = (int)(Math.random()*66666666+20000000);
			tarjeta = JOptionPane.showInputDialog("El cliente dispone de tarjeta de socio?");
			if (tarjeta.equalsIgnoreCase("si")) {
				clientes.add(new Cliente(cliente, true, dni));		
			} else {
				clientes.add(new Cliente(cliente, false, dni));
			}
			tipo = JOptionPane.showInputDialog("Que tipo de cafe se llevo el cliente? \n Las opciones son las siguientes: \n" + cafes.get(0).getTipo_cafe() + "\n" + cafes.get(1).getTipo_cafe() + "\n" + cafes.get(2).getTipo_cafe() + "\n" + cafes.get(3).getTipo_cafe());
			switch (tipo.toLowerCase()) {
			case "cafe latte":
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("El cafe se ha cargado con exito \n Cuanta cantidad llevo el cliente?"));
				precio = cafes.get(0).getPrecio() * cantidad;
				cafes.get(0).setCant_vendida(cafes.get(0).getCant_vendida()+cantidad);
				if (clientes.get(id).isTarjeta()) {
					desc = precio * 0.15;
					precio_tot = precio - desc;
				} else {
					precio_tot = precio;
				}
				ventas.add(new Venta(id, cafes.get(0), cantidad, clientes.get(id), precio_tot));
				break;
			case "cafe flat white":
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("El cafe se ha cargado con exito \n Cuanta cantidad llevo el cliente?"));
				precio = cafes.get(1).getPrecio() * cantidad;
				cafes.get(1).setCant_vendida(cafes.get(1).getCant_vendida()+cantidad);
				if (clientes.get(id).isTarjeta()) {
					desc = precio * 0.15;
					precio_tot = precio - desc;
				} else {
					precio_tot = precio;
				}
				ventas.add(new Venta(id, cafes.get(1), cantidad, clientes.get(id), precio_tot));
				break;
			case "cafe lagrima":
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("El cafe se ha cargado con exito \n Cuanta cantidad llevo el cliente?"));
				precio = cafes.get(2).getPrecio() * cantidad;
				cafes.get(2).setCant_vendida(cafes.get(2).getCant_vendida()+cantidad);
				if (clientes.get(id).isTarjeta()) {
					desc = precio * 0.15;
					precio_tot = precio - desc;
				} else {
					precio_tot = precio;
				}
				ventas.add(new Venta(id, cafes.get(2), cantidad, clientes.get(id), precio_tot));
				break;
			case "cafe expresso":
				cantidad = Integer.parseInt(JOptionPane.showInputDialog("El cafe se ha cargado con exito \n Cuanta cantidad llevo el cliente?"));
				precio = cafes.get(3).getPrecio() * cantidad;	
				cafes.get(3).setCant_vendida(cafes.get(3).getCant_vendida()+cantidad);
				if (clientes.get(id).isTarjeta()) {
					desc = precio * 0.15;
					precio_tot = precio - desc;
				} else {
					precio_tot = precio;
				}
				ventas.add(new Venta(id, cafes.get(3), cantidad, clientes.get(id), precio_tot));		
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta, no existe este tipo de cafe");
				break;
			}
			
			
			id++;
			repetir = JOptionPane.showInputDialog("Desea cargar otra venta?");
		} while (repetir.equalsIgnoreCase("si"));
		
	}
	
	public static void menuConsulta(LinkedList<Venta> ventas, LinkedList<Cafe> cafes) {
		int op;
		op = Integer.parseInt(JOptionPane.showInputDialog("¿Que desea realizar? \n 1 - Mostrar todas las ventas \n 2 - Mostrar que tipo de cafe se vendio mas \n 3 - Mostrar recaudacion total \n 4 - Mostrar las ventas con descuento \n 5 - Quiero eliminar una venta"));
		switch (op) {
		case 1:
			JOptionPane.showMessageDialog(null, "Las ventas durante el dia fueron las siguientes");
			for (int i = 0; i < ventas.size(); i++) {
				JOptionPane.showMessageDialog(null, ventas.get(i).getCliente() + " \nEl cliente compro: " + ventas.get(i).getCantidad() + " " + ventas.get(i).getCafe().getTipo_cafe() + "\n El valor individual es de: $" + ventas.get(i).getCafe().getPrecio() + "\n El valor total de la venta fue de: $" + ventas.get(i).getPrecio_total() );
			}
			break;
		case 2:
			Comparator <Cafe> comp = Comparator.comparing(Cafe::getCant_vendida);
			Collections.sort(cafes, comp.reversed());
			JOptionPane.showMessageDialog(null, "El cafe mas vendido fue el siguiente: " + cafes.get(0).getTipo_cafe() + "\n Con un total de: " + cafes.get(0).getCant_vendida() + " Unidades vendidas");
			break;
		case 3:
			double total=0;
			for (int i = 0; i < ventas.size(); i++) {
				total = total + ventas.get(i).getPrecio_total();
			}
			JOptionPane.showMessageDialog(null, "La recaudacion total del dia fue de: $" + total);
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Las ventas con descuento fueron las siguientes");
			for (Venta venta : ventas) {
				if (venta.getCliente().isTarjeta()) {
					JOptionPane.showMessageDialog(null, venta);
				}
			}
			break;
		case 5:
			int eliminar;
			JOptionPane.showMessageDialog(null, "A continuacion tendra la lista de ventas realizadas con su ID, recuerde que para eliminarla tiene que indicar el ID correspondiente.");
			eliminar = Integer.parseInt(JOptionPane.showInputDialog(ventas + "\n Indique el ID de la venta que desea eliminar"));
			for (Venta venta : ventas) {
				if (venta.getID() == eliminar) {
					ventas.remove(ventas.indexOf(venta));
					JOptionPane.showMessageDialog(null, "La venta se removio exitosamente");
				}
			}
			
			break;
		default:
			break;
			
		}
	
	}
}


