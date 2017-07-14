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
	
	
	
	
	
	public Documento(int id, Date fechaEmision, Cliente cliente,
			int tiempoManoObra, int montoManoObra,
			ArrayList<ItemDocumento> items) {
		
		this.id = id;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
		this.tiempoManoObra = tiempoManoObra;
		this.montoManoObra = montoManoObra;
		this.items = items;
	}

	public ArrayList<ViewItemDocumento> listaritemsDocumento() {
		return null;
	
	}
	
	public int nuevoItem(Producto cod, int cant) {
		return 0;
	
	}
	
	public boolean bajaItem(int nro) {
		return false;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTiempoManoObra() {
		return tiempoManoObra;
	}

	public void setTiempoManoObra(int tiempoManoObra) {
		this.tiempoManoObra = tiempoManoObra;
	}

	public int getMontoManoObra() {
		return montoManoObra;
	}

	public void setMontoManoObra(int montoManoObra) {
		this.montoManoObra = montoManoObra;
	}

	public ArrayList<ItemDocumento> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemDocumento> items) {
		this.items = items;
	}
	
}
