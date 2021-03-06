package view;

import core.Producto;

public class ViewItemDocumento {

	private int nroItem;
	private Producto producto;
	private int cantProd;
	private int montoItem;
	
	
	public ViewItemDocumento(int nroItem, Producto producto, int cantProd,
			int montoItem) {
		
		this.nroItem = nroItem;
		this.producto = producto;
		this.cantProd = cantProd;
		this.montoItem = montoItem;
	}
	@Override
	public String toString() {
		return "ViewItemDocumento [nroItem=" + nroItem + ", producto="
				+ producto.getDesc() + ", cantProd=" + cantProd + ", montoItem="
				+ montoItem + "]";
	}
	
	public String vistaTabla() {
		return "<tr   class=\"bodytablaItemP\" ><th  style=\"display: none;\" id=\"id\" >"+this.getNroItem()+"</th><th>"+
				this.getProducto().getDesc()+"</th><th>"+
			       this.getProducto().getCodProducto()+"</th><th>"+
			      this.getCantProd()+"</th><th>"+
			       this.getMontoItem()+"</th></tr>";
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
