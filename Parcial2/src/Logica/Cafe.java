package Logica;

public class Cafe {
	private int ID;
	private String tipo_cafe;
	private double precio;
	private int cant_vendida;
	public Cafe(int iD, String tipo_cafe, double precio, int cant_vendida) {
		super();
		ID = iD;
		this.tipo_cafe = tipo_cafe;
		this.precio = precio;
		this.cant_vendida = cant_vendida;
	}
	
	public int getCant_vendida() {
		return cant_vendida;
	}

	public void setCant_vendida(int cant_vendida) {
		this.cant_vendida = cant_vendida;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTipo_cafe() {
		return tipo_cafe;
	}
	public void setTipo_cafe(String tipo_cafe) {
		this.tipo_cafe = tipo_cafe;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Tipo de cafe: " + tipo_cafe + " Precio: $" + precio;
	}
	
}
