package core;

import view.ViewItemDocumento;

public class ItemDocumento {
	
	private int nroItem;
	private Producto producto;
	private int cantProd;
	private int montoItem;
	
	
	
	
	public ItemDocumento(int nroItem, Producto producto, int cantProd,
			int montoItem) {
	
		this.nroItem = nroItem;
		this.producto = producto;
		this.cantProd = cantProd;
		this.montoItem = montoItem;
	}

	private boolean cumplo( Producto prod, int cant, int monto, int nroItem) {
		return false;
	
	}
	
	public ViewItemDocumento mostrate() {
		return null;
	
	}

	public int getNroItem() {
		return nroItem;
	}

	public void setNroItem(int nroItem) {
		this.nroItem = nroItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantProd() {
		return cantProd;
	}

	public void setCantProd(int cantProd) {
		this.cantProd = cantProd;
	}

	public int getMontoItem() {
		return montoItem;
	}

	public void setMontoItem(int montoItem) {
		this.montoItem = montoItem;
	}
	
	
	
}
