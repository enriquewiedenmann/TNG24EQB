package ctrl;

import java.util.Date;
import java.util.ArrayList;

import persistencia.DAOAgenda;
import persistencia.DAOPresupuesto;
import persistencia.DAOProducto;
import core.*;
import view.*;

public class CtrlAgenda {
	private static CtrlAgenda ctrlAgenda;
	private ArrayList<Agenda> agendas;
	private ArrayList<Presupuesto> presupuestos;
	private ArrayList<Factura> facturas;
	

	public static CtrlAgenda getInstance() {
		
		if (ctrlAgenda == null)
			ctrlAgenda = new CtrlAgenda();
		return ctrlAgenda;

		
	}
	
	
	
	public CtrlAgenda() {
		
		this.agendas = cargarAgendas();
		this.presupuestos = cargarPresupuestos();
		this.facturas = null;
	}



	private ArrayList<Presupuesto> cargarPresupuestos() {
		{
			ArrayList<Presupuesto> p = DAOPresupuesto.getInstancia().selectAllPresupuesto();
			return p != null ? p : null;
		}
	}



	private ArrayList<Agenda> cargarAgendas() {
		{
			ArrayList<Agenda> a = DAOAgenda.getInstancia().selectAll();
			return a != null ? a : null;
		}
	}



	
	public ArrayList<ViewAgenda> listarAgendas() {
		return null;
	
	}
	
	public ArrayList<ViewVisita> listarVisitas() {
		return null;
	
	}
	
	public ArrayList<ViewPresupuesto> listarPresupuestos(int id, Date fecha, int docCliente, int nomCliente, int apellido) {
		ArrayList<ViewPresupuesto> vp = new ArrayList<ViewPresupuesto>();
		for(Presupuesto p:presupuestos){
			vp.add(p.mostrate());
			}
			
		
		
		return vp;
	
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
