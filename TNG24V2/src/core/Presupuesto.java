package core;

import java.util.ArrayList;
import java.util.Date;

import view.ViewItemDocumento;
import view.ViewPresupuesto;

public class Presupuesto extends Documento {
	private Empleado tecnico;
	
	
	
	
	

	public Presupuesto(int id, Date fechaEmision, Cliente cliente,
			int tiempoManoObra, int montoManoObra,
			ArrayList<ItemDocumento> items,Empleado e) {
		super(id, fechaEmision, cliente, tiempoManoObra, montoManoObra, items);
		this.tecnico=e;
	}






	public Presupuesto(Cliente cliente, Empleado empleado) {
		super(cliente);
		this.tecnico = empleado;
	}
	
	
	
	
	

	public boolean cumplo(int id, Date fec, Cliente cli, int TMO, int MMO, Empleado tec) {
		return false;
	
	}
	
	public ViewPresupuesto mostrate(Domicilio dom) {
		return null;
	
	}
	
	public int cerrarme(int TMO, int MMO) {
		Date d= new Date();
		int nro =-1;
		this.setFechaEmision(d);
		this.setMontoManoObra(MMO);
		this.setTiempoManoObra(TMO);
		
		System.out.println("no lo codeeeeee,");
		return nro;
	
	}
	
	public ViewPresupuesto mostrate() {
		ArrayList<ViewItemDocumento> li = new ArrayList<ViewItemDocumento> ();
		for(ItemDocumento idoc:this.getItems()){
			
			li.add(idoc.mostrate());
		}
	
		ViewPresupuesto vp = new ViewPresupuesto(this.getId(), this.getFechaEmision(),this.getCliente(),
				this.getTiempoManoObra(),this.getMontoManoObra(), this.getTecnico(),li);
		
		return vp;
	
	}




	public Empleado getTecnico() {
		return tecnico;
	}




	public void setTecnico(Empleado tecnico) {
		this.tecnico = tecnico;
	}





	
}
