package Logica;

public class Venta {
	private int ID;
	private Cafe cafe;
	private int cantidad;
	private Cliente cliente;
	private double precio_total;
	
	public Venta(int iD, Cafe cafe, int cantidad, Cliente cliente, double precio_total) {
		super();
		ID = iD;
		this.cafe = cafe;
		this.cantidad = cantidad;
		this.cliente = cliente;
		this.precio_total = precio_total;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Cafe getCafe() {
		return cafe;
	}
	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente= cliente;
	}

	@Override
	public String toString() {
		return cliente + "\nID de venta:" + ID + " " + cafe + " Cantidad: " + cantidad + " Precio total: " + precio_total + "\n";
	}
	
	
}
