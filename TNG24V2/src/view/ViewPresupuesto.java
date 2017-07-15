package view;

import java.util.ArrayList;
import java.util.Date;

import core.Cliente;
import core.Empleado;

public class ViewPresupuesto {

	
	private int id;
	private Date fechaEmision;
	private Cliente cliente;
	private int tiempoManoObra;
	private int montoManoObra;
	private Empleado tecnico;
	private ArrayList<ViewItemDocumento> vli;
	
	public ViewPresupuesto(int id, Date fechaEmision, Cliente cliente,
			int tiempoManoObra, int montoManoObra, Empleado tecnico, ArrayList<ViewItemDocumento> li) {
		super();
		this.id = id;
		this.fechaEmision = fechaEmision;
		this.cliente = cliente;
		this.tiempoManoObra = tiempoManoObra;
		this.montoManoObra = montoManoObra;
		this.tecnico = tecnico;
		this.vli= li;
	}
	
	public String toString() {
		return "ViewPresupuesto [id=" + id + ", fechaEmision=" + fechaEmision
				+ ", cliente=" + cliente.getApellido()+", "+cliente.getNombre() + ", tiempoManoObra=" + tiempoManoObra
				+ ", montoManoObra=" + montoManoObra + ", tecnico=" + tecnico.getApellido()
				+", "+tecnico.getNombre()+"]";
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
	public Empleado getTecnico() {
		return tecnico;
	}
	public void setTecnico(Empleado tecnico) {
		this.tecnico = tecnico;
	}

	public ArrayList<ViewItemDocumento> getVli() {
		return vli;
	}

	public void setVli(ArrayList<ViewItemDocumento> vli) {
		this.vli = vli;
	}
	
	
	
	
}
