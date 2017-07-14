package core;

import view.ViewProducto;

public class Producto {
	private int id;
	private String codProducto;
	private String desc;
	private int stock;
	private int ptoPedido;
	private int precio;
	private char estado;

	
	
	
	public Producto(int id, String codProducto, String desc, int stock,
			int ptoPedido, int precio, char estado) {
		super();
		this.id = id;
		this.codProducto = codProducto;
		this.desc = desc;
		this.stock = stock;
		this.ptoPedido = ptoPedido;
		this.precio = precio;
		this.estado = estado;
	}

	public ViewProducto mostrate() {
		return null;
	
	}
	
	public Boolean cumplo(String cod, String desc) {
		return null;
	
	}
}
