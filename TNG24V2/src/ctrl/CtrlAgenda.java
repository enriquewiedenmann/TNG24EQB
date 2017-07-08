package ctrl;

import java.util.Date;
import java.util.ArrayList;

import core.*;
import view.*;

public abstract class CtrlAgenda {
	private CtrlAgenda ctrlAgenda;
	private ArrayList<Agenda> agendas;
	private ArrayList<Presupuesto> presupuestos;
	private ArrayList<Factura> facturas;
	public abstract CtrlAgenda getInstance();
	
	
	
	public ArrayList<ViewAgenda> listarAgendas() {
		return null;
	
	}
	
	public ArrayList<ViewVisita> listarVisitas() {
		return null;
	
	}
	
	public ArrayList<ViewPresupuesto> listarPresupuestos(int id, Date fecha, int docCliente, int nomCliente, int apellido) {
		return null;
	
	}
	
	public ArrayList<ViewItemDocumento> listaritemsDocumento(int id) {
		return null;
	
	}
	
	public Visita buscarVisita(Date fecha, int cliente, int tecnico, int agenda, int domicilio, char estado) {
		return null;
	
	}
	
	public Agenda buscarAgenda(int id) {
		return null;
	
	}
	
	public Presupuesto buscarPresupuesto(int id, Date fecha, int docCliente, int nomCliente, int apellido) {
		return null;
	
	}
	
	public ItemDocumento buscarItemDocumento(int idPresupuesto, int idIPre, Producto prod, int cant, int monto, int nroItem) {
		return null;
	
	}
	
	public ViewAgenda mostrarAgenda(int id) {
		return null;
	
	}
	
	public ViewVisita mostrarVisita(int id) {
		return null;
	
	}
	
	public ViewPresupuesto mostrarPresupuesto(int id) {
		return null;
	
	}
	
	public ViewItemDocumento mostrarItemDocumento(int id) {
		return null;
	
	}
	
	public boolean rehabilitarAgenda(int id) {
	return true;
	
	}
	
	public int nuevaVisita(int idCliente, int idDomicilio, Date inicioProgramado, Date finProgramado, int idAgenda) {
	return 0;
	}
	
	public boolean bajaVisita(int id) {
	return true;
	}
	
	public boolean rehabilitarVisita(int id) {
		return true;
	}
	
	public boolean nuevoPresupuesto(int idVisita) {
		return true;
	}
	
	public int nuevoItemPresupuesto(String cod, int cant) {
		return 0;
	}
	
	public int ConfirmarAltaPresupuesto(int tiempoManoObra, int tecnico, int montoManoObra) {
		return 0;
	}
	
	public boolean bajaItemPresupuesto(int nro) {
		return true;
	}
	
	public int disponibilidadTecnicos(Date inicioProgramado, Date finProgramado, int idAgenda) {
		return 0;
	}
	
	public boolean modificarVisita(int id, String motivo) {
		return true;
	}
}
