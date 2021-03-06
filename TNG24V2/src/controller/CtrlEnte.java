package controller;

import java.util.ArrayList;

import persistencia.DAOCliente;
import persistencia.DAOEmpleado;
import persistencia.DAORollEmpleado;
import persistencia.DAOTipoDocumento;
import view.ViewCliente;
import view.ViewEmpleado;
import view.ViewRollEmpleado;
import view.ViewTipoDocumento;
import core.Cliente;
import core.Domicilio;
import core.Empleado;
import core.Ente;
import core.RollEmpleado;
import core.TipoDocumento;

public class CtrlEnte {
	private static CtrlEnte ctrlEnte;
	private ArrayList<RollEmpleado> rolles;
	private ArrayList<TipoDocumento> tipodocumentos;
	private ArrayList<Ente> entes;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;

	private CtrlEnte() {
		this.rolles = cargarRolesEmpleadp();
		this.tipodocumentos = this.cargarTipoDocumentos();
		this.entes = null;
		this.empleados = cargarEmpleados();
		this.clientes = this.cargarClientes();
	}

	public static CtrlEnte getInstance() {
		if (ctrlEnte == null)
			ctrlEnte = new CtrlEnte();
		return ctrlEnte;
	}

	private ArrayList<Empleado> cargarEmpleados() {
		ArrayList<Empleado> e = DAOEmpleado.getInstancia().select();
		return e != null ? e : null;
	}

	private ArrayList<RollEmpleado> cargarRolesEmpleadp() {
		ArrayList<RollEmpleado> re = DAORollEmpleado.getInstancia().selectAll();
		return re != null ? re : null;
	}

	private ArrayList<TipoDocumento> cargarTipoDocumentos() {
		ArrayList<TipoDocumento> td = DAOTipoDocumento.getInstancia().select();
		return td != null ? td : null;
	}

	private ArrayList<Cliente> cargarClientes() {
		ArrayList<Cliente> c = DAOCliente.getInstancia().select();
		return c != null ? c : null;
	}

	public ArrayList<ViewRollEmpleado> listarRoles() {
		ArrayList<ViewRollEmpleado> re = new ArrayList<ViewRollEmpleado>();
		for (RollEmpleado r : rolles) {
			re.add(r.mostrate());
		}
		return re;
	}

	public ArrayList<ViewTipoDocumento> listarTipoDocs() {
		ArrayList<ViewTipoDocumento> ltd = new ArrayList<ViewTipoDocumento>();
		for (TipoDocumento td : tipodocumentos) {
			ltd.add(td.mostrate());
		}
		return ltd;
	}

	
	public ArrayList<ViewEmpleado> listaTecnicos(){
		ArrayList<ViewEmpleado> lista = new ArrayList<ViewEmpleado>();
		for (Empleado e : empleados) {
			
			if(e.getRol().getCodRollEmpleado().equals("TEC")){
				
			lista.add(e.mostrate());
			}

		}
		return lista;
	}
	public ArrayList<ViewEmpleado> listaEmpleados() {
		ArrayList<ViewEmpleado> lista = new ArrayList<ViewEmpleado>();
		for (Empleado e : empleados) {
			lista.add(e.mostrate());

		}
		return lista;
	}

	public ArrayList<ViewCliente> listarClientes(String nombre,
			String apellido, String nroDoc) {
		ArrayList<ViewCliente> vc = new ArrayList<ViewCliente>();
		for (Cliente c : clientes) {
			if (c.cumplo(nombre, apellido, nroDoc)) {
				vc.add(c.mostrate());
			}
		}
		return vc;
	}

	public ViewRollEmpleado mostrarRoll(int id) {
		return null;
	}

	public ViewTipoDocumento mostrarTipoDoc(String cod) {
		return null;
	}

	public ViewEmpleado mostrarEmpelado(int id) {
		return null;
	}

	public ViewCliente mostrarCliente(int id) {
		for (Cliente c : clientes) {
			if (c.cumplo(id, null, null, null)) {
				return c.mostrate();
			}
		}

		return null;
	}

	public RollEmpleado buscarRoll(String cod, String desc) {
		return null;
	}

	public TipoDocumento buscarTipoDoc(String cod, String desc) {
		for (TipoDocumento td : tipodocumentos) {
			if (td.cumplo(cod, desc)) {

				return td;
			}
		}
		return null;
	}

	public Empleado buscarEmpelado(int id, String apellido, String nombre,
			String roll, String documento, char e) {
		for(Empleado em:empleados){
			if(em.getIdEnte()==id){
				return em;
			}
		}
		return null;
	}

	public Cliente buscarCliente(int id, String nombre, String apellido,
			String documento) {

		for (Cliente c : clientes) {
			if (c.cumplo(id, nombre, apellido, documento)) {
				return c;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String nombre, String apellido,
			String documento) {

		for (Cliente c : clientes) {
			if (c.cumplo(nombre, apellido, documento)) {
				return c;
			}
		}
		return null;
	}

	public int nuevoCliente(String apellido, String nombre, String documento,
			String codDoc, String tel, String mail, int dom) {
		TipoDocumento td = null;

		td = this.buscarTipoDoc(codDoc, null);
		if (td != null) {
			Domicilio oDom = null;
			oDom = CtrlDomicilio.getInstance().buscarDomicilio(dom, null, null,
					null, null, null, null, null, null, null);
			if (oDom != null) {
				Cliente c = null;
				c = this.buscarCliente(null, null, documento);
				if (c == null) {
					Cliente nc = new Cliente(apellido, nombre, documento, td,
							tel, mail, oDom);
					this.clientes.add(nc);

					return nc.getIdEnte();
				}
			}
		}

		return 0;
	}

	public boolean editarCliente(int id, String nombre, String apellido,
			String documento, String codDoc, String tel, String mail, int dom) {

		Cliente c = null;

		c = this.buscarCliente(id, null, null, null);

		if (c != null) {
			TipoDocumento td = null;
			td = this.buscarTipoDoc(codDoc, null);
			if (td != null) {

				Domicilio d = null;
				CtrlDomicilio cd = CtrlDomicilio.getInstance();
				d = cd.buscarDomicilio(dom, null, null, null, null, null, null,
						null, null, null);

				if (cd.buscarDomicilio(dom, null, null, null, null, null, null,
						null, null, null) != null) {
					int encontrado = -1;
					encontrado = this.buscarCliente(null, null, documento)
							.getIdEnte();

					if (encontrado == id) {
						c.editate(apellido, nombre, documento, td, tel, mail,
								cd.buscarDomicilio(dom, null, null, null, null,
										null, null, null, null, null));
						return true;
					}
				}
			}

		}

		return false;
	}

	public boolean bajaCliente(int id) {
		try {
			this.buscarCliente(id, null, null, null).bajate();
			return true;
		} catch (Exception e) {
			System.out.println("no se pudo ejecutar la baja : "
					+ e.getMessage());
			return false;
		}

	}

	public boolean rehabilitarCliente(int id) {
		try {
			this.buscarCliente(id, null, null, null).rehabilitate();
			return true;
		} catch (Exception e) {
			System.out.println("no se pudo ejecutar la rehabilitacion : "
					+ e.getMessage());
			return false;
		}
	}

	public void add() {

	}
}
