package core;

import java.util.ArrayList;
import java.util.Date;

import view.ViewItemDocumento;

public class Documento {
	private int id;
	private Date fechaEmision;
	private Cliente cliente;
	private int tiempoManoObra;
	private int montoManoObra;
	private ArrayList<ItemDocumento> items;
	public ArrayList<ViewItemDocumento> listaritemsDocumento() {
		return null;
	
	}
	
	public int nuevoItem(Producto cod, int cant) {
		return 0;
	
	}
	
	public boolean bajaItem(int nro) {
		return false;
	
	}
}
