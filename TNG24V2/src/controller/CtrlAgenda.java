package controller;

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
	private Presupuesto pa;
	private Visita va;

	public static CtrlAgenda getInstance() {
		if (ctrlAgenda == null)
			ctrlAgenda = new CtrlAgenda();
		return ctrlAgenda;
	}

	public CtrlAgenda() {
		this.pa = null;
		this.agendas = cargarAgendas();
		this.presupuestos = cargarPresupuestos();
		this.facturas = null;
	}

	private ArrayList<Presupuesto> cargarPresupuestos() {
		{
			ArrayList<Presupuesto> p = DAOPresupuesto.getInstancia()
					.selectAllPresupuesto();
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
		ArrayList<ViewAgenda> va = new ArrayList<ViewAgenda>();
		for (Agenda a : agendas) {
			va.add(a.mostrate());
		}
		return va;
	}

	public ArrayList<ViewVisita> listarVisitas() {
		return null;
	}

	public ArrayList<ViewPresupuesto> listarPresupuestos(Date fecha,
			String docCliente, String nomCliente, String apellido) {
		ArrayList<ViewPresupuesto> vp = new ArrayList<ViewPresupuesto>();
		for (Presupuesto p : presupuestos) {

			if (p.cumplo(fecha, docCliente, nomCliente, apellido)) {
				vp.add(p.mostrate());
			}
		}
		return vp;
	}

	public ArrayList<ViewPresupuesto> listarPresupuestos(int id) {
		ArrayList<ViewPresupuesto> vp = new ArrayList<ViewPresupuesto>();
		for (Presupuesto p : presupuestos) {
			if (p.cumplo(id)) {
				vp.add(p.mostrate());
			}
		}
		return vp;
	}

	public ArrayList<ViewItemDocumento> listaritemsDocumento(int id) {
		return null;
	}

	public Visita buscarVisita(Date fecha, int cliente, int tecnico,
			int agenda, int domicilio, char estado) {
		return null;

	}

	public Agenda buscarAgenda(int id) {
		return null;

	}

	public Presupuesto buscarPresupuesto(int id) {
		for (Presupuesto p : presupuestos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;

	}

	public ItemDocumento buscarItemDocumento(int idPresupuesto, int idIPre,
			Producto prod, int cant, int monto, int nroItem) {
		return null;

	}

	public ViewAgenda mostrarAgenda(int id) {
		return null;

	}

	public ViewVisita mostrarVisita(int id) {
		for (Agenda a : agendas) {
			if (a.esTuVisita(id)) {
				return a.mostraVisita(id);
			}
		}
		return null;
	}

	public ViewPresupuesto mostrarPresupuesto(int id) {
		for (Presupuesto p : presupuestos) {
			if (p.cumplo(id)) {
				return p.mostrate();
			}
		}

		return null;

	}

	public ViewItemDocumento mostrarItemDocumento(int id) {
		return null;

	}

	public boolean rehabilitarAgenda(int id) {
		return true;

	}

	public int nuevaVisita(String motivo, int idCliente, int idDomicilio,

	Date inicioProgramado, Date finProgramado, int tecnico) {
		int nuevaV = -1;
		Agenda ag = null;
		Empleado ente = CtrlEnte.getInstance().buscarEmpelado(tecnico, null,
				null, null, null, 'A');
		if (ente != null) {
			for (Agenda a : agendas) {
				if (a.getTecnico().getIdEnte() == ente.getIdEnte()) {
					ag = a;
				}
			}
			if (ag != null) {
				Cliente cl = CtrlEnte.getInstance().buscarCliente(idCliente,
						null, null, null);
				if (cl != null) {
					Domicilio dom = CtrlDomicilio.getInstance()
							.buscarDomicilio(idDomicilio, null, null, null,
									null, null, null, null, null, null);
					if (dom != null) {
						nuevaV = ag.nuevaVisita(null, motivo, cl, dom,
								inicioProgramado, finProgramado);
					}
				}

			}
		}

		return nuevaV;
	}

	public int nuevaVisita(String motivo, int idCliente, int idDomicilio,
			Date inicioProgramado, Date finProgramado, int tecnico,
			int presupuesto) {
		int nuevaV = -1;
		Agenda ag = null;
		Empleado ente = CtrlEnte.getInstance().buscarEmpelado(tecnico, null,
				null, null, null, 'A');
		if (ente != null) {
			for (Agenda a : agendas) {
				if (a.getTecnico().getIdEnte() == ente.getIdEnte()) {
					ag = a;
				}
			}
			if (ag != null) {
				Cliente cl = CtrlEnte.getInstance().buscarCliente(idCliente,
						null, null, null);
				if (cl != null) {
					Domicilio dom = CtrlDomicilio.getInstance()
							.buscarDomicilio(idDomicilio, null, null, null,
									null, null, null, null, null, null);
					if (dom != null) {
						Presupuesto p = null;
						p = this.buscarPresupuesto(presupuesto);
						if (p != null) {
							nuevaV = ag.nuevaVisita(p, motivo, cl, dom,
									inicioProgramado, finProgramado);
						}
					}
				}

			}
		}

		return nuevaV;
	}

	public boolean bajaVisita(int id) {
		for (Agenda a : agendas) {
			if (a.esTuVisita(id)) {
				return a.bajaVisita(id, null);

			}
		}

		return false;
	}

	public boolean rehabilitarVisita(int id) {
		return true;
	}

	public boolean nuevoPresupuesto(int idVisita) {

		Agenda ae = null;
		for (Agenda a : agendas) {
			if (a.esTuVisita(idVisita)) {
				va = a.buscarVisitaPresupuesto(idVisita);
				ae = a;
			}

		}
		if (va != null) {
			pa = new Presupuesto(va.getCliente(), va.getMotivo(),
					ae.getTecnico());
			return true;
		}
		return false;
	}

	public int nuevoItemPresupuesto(String cod, int cant) {
		if (pa != null) {
			Producto p = null;
			p = CtrlProducto.getInstancia().bucarProducto(cod);
			if (p != null) {

				return pa.nuevoItem(p, cant);
			}
		}
		return -1;
	}

	public void cancelarPresupuesto() {
		pa = null;
		va = null;

	}

	public int ConfirmarAltaPresupuesto(int tiempoManoObra, int montoManoObra,
			String motivo) {

		int nro = -1;
		nro = pa.cerrarme(tiempoManoObra, montoManoObra, motivo);
		pa.setId(nro);
		presupuestos.add(pa);
		va.setPresupuesto(pa);
		pa = null;
		va = null;

		return nro;
	}

	public boolean bajaItemPresupuesto(int nro) {
		if (pa != null) {
			return pa.bajaItem(nro);
		}

		return false;
	}

	public int disponibilidadTecnicos(Date inicioProgramado,
			Date finProgramado, int idAgenda) {
		return 0;
	}

	public boolean modificarVisita(int id, String motivo, int cliente,
			int domicilio, int presupuesto) {
		Agenda ag = null;

		for (Agenda a : agendas) {
			if (a.esTuVisita(id)) {
				ag = a;
			}
		}
		if (ag != null) {
			Cliente cl = CtrlEnte.getInstance().buscarCliente(cliente, null,
					null, null);
			if (cl != null) {
				Domicilio dom = CtrlDomicilio.getInstance().buscarDomicilio(
						domicilio, null, null, null, null, null, null, null,
						null, null);
				if (dom != null) {
					Presupuesto p = null;
					p = this.buscarPresupuesto(presupuesto);
					if (p != null) {
						return ag.editarVisita(id, motivo, cl, dom, p);
					}
				}
			}

		}

		return false;
	}

	public Presupuesto getPa() {
		return pa;
	}

	public ArrayList<ViewAgenda> listarAgendas(Date fecha) {
		ArrayList<ViewAgenda> va = new ArrayList<ViewAgenda>();
		for (Agenda a : agendas) {

			va.add(a.mostrate(fecha));

		}
		return va;
	}
}
