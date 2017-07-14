package core;

import java.util.Date;

import view.ViewPresupuesto;
import view.ViewVisita;

public class Visita {
	private int id;
	private Factura factura;
	private Presupuesto presupuesto;
	private Cliente cliente;
	private Domicilio domicilio;
	private Date inicioProgramado;
	private Date finProgramado;
	private Date inicioReal;
	private Date finReal;
	private char estado;
	private String motivo;
	private Empleado tecnico;
	
	
	
	
	
	
	
	
	public Visita(int id, Factura factura, Presupuesto presupuesto,
			Cliente cliente, Domicilio domicilio, Date inicioProgramado,
			Date finProgramado, Date inicioReal, Date finReal, char estado,
			String motivo, Empleado tecnico) {
		super();
		this.id = id;
		this.factura = factura;
		this.presupuesto = presupuesto;
		this.cliente = cliente;
		this.domicilio = domicilio;
		this.inicioProgramado = inicioProgramado;
		this.finProgramado = finProgramado;
		this.inicioReal = inicioReal;
		this.finReal = finReal;
		this.estado = estado;
		this.motivo = motivo;
		this.tecnico = tecnico;
	}

	public boolean cumplo(int id, Factura fac, Presupuesto pres, Cliente cli, Domicilio dom, Date iniProg, Date finProg, Date iniReal, Date finReal, char e) {
		return false;
	
	}
	
	public ViewVisita mostrate() {
		return null;
	
	}
	
	public Presupuesto nuevoPresupuesto() {
		return presupuesto;
	
	}
	
	public boolean esTuPresupuesto(int idPresupuesto) {
		return false;
	
	}
	
	public ViewPresupuesto mostraPresupuesto() {
		return null;
	
	}
	
	public void crearVisita(Cliente cli, Date inicioProgramado, Date finProgramado, String motivo, Empleado tecnico) {
	
	}
	
	public void modificarVisita(String motivo) {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Presupuesto getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Date getInicioProgramado() {
		return inicioProgramado;
	}

	public void setInicioProgramado(Date inicioProgramado) {
		this.inicioProgramado = inicioProgramado;
	}

	public Date getFinProgramado() {
		return finProgramado;
	}

	public void setFinProgramado(Date finProgramado) {
		this.finProgramado = finProgramado;
	}

	public Date getInicioReal() {
		return inicioReal;
	}

	public void setInicioReal(Date inicioReal) {
		this.inicioReal = inicioReal;
	}

	public Date getFinReal() {
		return finReal;
	}

	public void setFinReal(Date finReal) {
		this.finReal = finReal;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Empleado getTecnico() {
		return tecnico;
	}

	public void setTecnico(Empleado tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
}
