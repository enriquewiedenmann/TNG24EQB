package core;

import view.ViewItemDocumento;

public class ItemDocumento {
	
	private int nroItem;
	private Producto producto;
	private int cantProd;
	private int montoItem;
	private static int autoNro=1;
	
	
	private static int incrementar(){
		return autoNro++;
	}
	
	
	public ItemDocumento(Producto producto, int cantProd,
			int montoItem) {
		
		this.nroItem = this.incrementar();
		this.producto = producto;
		this.cantProd = cantProd;
		this.montoItem = montoItem;
	}
	
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
		ViewItemDocumento vit = new ViewItemDocumento(this.getNroItem(),this.getProducto(),this.getCantProd(),this.getMontoItem());
		return vit;
	
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
