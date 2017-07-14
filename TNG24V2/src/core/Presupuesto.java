package core;

import java.util.ArrayList;
import java.util.Date;

import view.ViewPresupuesto;

public class Presupuesto extends Documento {
	private Empleado tecnico;
	
	
	
	
	

	public Presupuesto(int id, Date fechaEmision, Cliente cliente,
			int tiempoManoObra, int montoManoObra,
			ArrayList<ItemDocumento> items, Empleado tecnico) {
		super(id, fechaEmision, cliente, tiempoManoObra, montoManoObra, items);
		this.tecnico = tecnico;
	}
	
	
	
	
	

	public boolean cumplo(int id, Date fec, Cliente cli, int TMO, int MMO, Empleado tec) {
		return false;
	
	}
	
	public ViewPresupuesto mostrate(Domicilio dom) {
		return null;
	
	}
	
	public int cerrarme(int TMO, int MMO) {
		return MMO;
	
	}
	
	public ViewPresupuesto mostrate() {
		return null;
	
	}




	public Empleado getTecnico() {
		return tecnico;
	}




	public void setTecnico(Empleado tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
}
