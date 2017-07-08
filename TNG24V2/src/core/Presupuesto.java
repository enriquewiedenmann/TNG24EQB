package core;

import java.util.Date;

import view.ViewPresupuesto;

public class Presupuesto extends Documento {
	private Empleado tecnico;
	
	
	
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
}
