package core;

import java.util.ArrayList;
import java.util.Date;

import controller.CtrlEnte;
import persistencia.DAOPresupuesto;
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
	
	
	
	
	

	
	
	public ViewPresupuesto mostrate(Domicilio dom) {
		return null;
	
	}
	
	public int cerrarme(int TMO, int MMO) {
		Date d= new Date();
		int nro =-1;
		this.setFechaEmision(d);
		this.setMontoManoObra(MMO);
		this.setTiempoManoObra(TMO);
		
		nro=DAOPresupuesto.getInstancia().insertPresupuesto(this);
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




	public boolean cumplo( int id) {
		
		return this.getId()==id;
		}

	public boolean cumplo( Date fecha, String docCliente,
			String nomCliente, String apellido) {
		boolean band = true;
		if(fecha!=null){
			band = fecha.equals(this.getFechaEmision());
		}
		band = this.getCliente().cumplo(nomCliente, apellido, docCliente);
		return band;
	}





	
}
