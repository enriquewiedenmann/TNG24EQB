package ctrl;
import java.util.ArrayList;

import persistencia.DAOProducto;
import persistencia.DAOProvincia;
import persistencia.DAOVisita;
import core.*;
import view.*;




public  class CtrlProducto {
	private static CtrlProducto ctrlProduto;
	private ArrayList<Producto> productos;
	private ArrayList<Retiro> retiros;
	private ArrayList<Devolucion> devoluciones;
	
	
	
	
	
	
	
	private  CtrlProducto() {
		super();
		this.productos = this.cargarProductos();
		this.retiros = null;
		this.devoluciones = null;
	}



	public static  CtrlProducto getInstancia()
	{
		if (ctrlProduto == null)
			ctrlProduto = new  CtrlProducto();
		return ctrlProduto;
	}
	
	
	private ArrayList<Producto> cargarProductos()
		{
			ArrayList<Producto> p = DAOProducto.getInstancia().selectAll();
			return p != null ? p : null;
		}
	
	
	
	public ArrayList<ViewProducto> listarProductos() {
		ArrayList<ViewProducto> lista = new ArrayList<ViewProducto>();
		for(Producto p: productos){
			lista.add(p.mostrate());
		}
			
		return lista;
	}
	
	public ViewProducto mostrarProducto(int id) {
		return null;
	}
	
	public Producto bucarProducto(int id, String cod, String desc) {
		return null;
	}



	public Producto bucarProducto(String cod) {
		for(Producto p: productos){
			if(p.cumplo(cod, null)){
				return p;
			}
			
		}
		return null;
	}
}
