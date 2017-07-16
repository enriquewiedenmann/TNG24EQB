package view;

import java.util.Date;

import core.Cliente;
import core.Domicilio;
import core.Empleado;
import core.Factura;
import core.Presupuesto;

public class ViewVisita {
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
	
	
	public ViewVisita(int id, Factura factura, Presupuesto presupuesto,
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


/*	public String toString() {
		return "ViewVisita [id=" + id + ", presupuesto=" + presupuesto
				+ ", cliente=" + cliente.getApellido() + ", domicilio=" + domicilio.getDescLocalidad()
				+ ", inicioProgramado=" + inicioProgramado + ", finProgramado="
				+ finProgramado + ", inicioReal=" + inicioReal + ", finReal="
				+ finReal + ", estado=" + estado + ", motivo=" + motivo
				+ ", tecnico=" + tecnico.getApellido() + "]";
	}

*/
	public String toString() {
		return "ViewVisita [id=" + id + ", motivo=" + motivo + "]";
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
