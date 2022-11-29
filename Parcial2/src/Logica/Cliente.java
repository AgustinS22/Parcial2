package Logica;

public class Cliente {
	private String nombre;
	private boolean tarjeta;
	private int DNI;
	
	public Cliente(String nombre, boolean tarjeta, int dNI) {
		super();
		this.nombre = nombre;
		this.tarjeta = tarjeta;
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(boolean tarjeta) {
		this.tarjeta = tarjeta;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	@Override
	public String toString() {
		return "Cliente: " + nombre + " Tarjeta socio:" + tarjeta + " DNI: " + DNI;
	}
	
	
}
