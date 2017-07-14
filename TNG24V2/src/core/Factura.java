package core;

import java.util.ArrayList;
import java.util.Date;

import view.ViewFactura;

public class Factura extends Documento {
	private char codTipoFactura;
	
	public Factura(int id, Date fechaEmision, Cliente cliente,
			int tiempoManoObra, int montoManoObra,
			ArrayList<ItemDocumento> items, char codTipoFactura) {
		super(id, fechaEmision, cliente, tiempoManoObra, montoManoObra, items);
		this.codTipoFactura = codTipoFactura;
	}
	
	public boolean cumplo(int id, Date fec, Cliente cli, int TMO, int MMO, char tFact) {
		return false;
	
	}
	
	public ViewFactura mostrate() {
		return null;
	
	}


	
}
