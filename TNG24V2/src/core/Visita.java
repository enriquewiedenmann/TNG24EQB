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
}
