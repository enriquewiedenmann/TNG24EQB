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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPtoPedido() {
		return ptoPedido;
	}

	public void setPtoPedido(int ptoPedido) {
		this.ptoPedido = ptoPedido;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
}
