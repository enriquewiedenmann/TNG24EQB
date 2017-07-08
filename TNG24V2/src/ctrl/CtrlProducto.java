package ctrl;
import java.util.ArrayList;

import core.*;
import view.*;




public abstract class CtrlProducto {
	private CtrlProducto ctrlProduto;
	private ArrayList<Agenda> productos;
	private ArrayList<Retiro> retiros;
	private ArrayList<Devolucion> devoluciones;
	
	
	public abstract CtrlProducto getInstance();
	
	
	
	
	public ArrayList<ViewProducto> listarProductos() {
		return null;
	}
	
	public ViewProducto mostrarProducto(int id) {
		return null;
	}
	
	public Producto bucarProducto(int id, String cod, String desc) {
		return null;
	}
}
