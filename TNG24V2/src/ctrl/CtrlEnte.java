package ctrl;

import java.util.ArrayList;

import persistencia.DAOCliente;
import persistencia.DAOProvincia;
import persistencia.DAOTipoDocumento;
import core.*;
import view.*;



public class CtrlEnte {
	private static CtrlEnte ctrlEnte;
	private ArrayList<RollEmpleado> rolles;
	private ArrayList<TipoDocumento> tipodocumentos;
	private ArrayList<Ente> entes;
	private ArrayList<Empleado> empelados;
	private ArrayList<Cliente> clientes;
	
	
	
	
	
	
	public CtrlEnte() {
		
		this.rolles = null;
		this.tipodocumentos = this.cargarTipoDocumentos() ;
		this.entes = null;
		this.empelados = null;
		this.clientes = this.cargarClientes();
	}




	public static CtrlEnte getInstance() {
		
		if (ctrlEnte == null)
			ctrlEnte = new CtrlEnte();
		return ctrlEnte;

		
	}
	
	
	
	private ArrayList<TipoDocumento>  cargarTipoDocumentos()
	{
		ArrayList<TipoDocumento> td = DAOTipoDocumento.getInstancia().select();
		return td != null ? td : null;
	}
	
	private ArrayList<Cliente>  cargarClientes()
	{
		ArrayList<Cliente> c = DAOCliente.getInstancia().select();
		return c != null ? c : null;
	}
	
	
	public ArrayList<ViewRollEmpleado> listarRoles() {
		return null;
	}
	
	public ArrayList<ViewTipoDocumento> listarTipoDocs() {
		ArrayList<ViewTipoDocumento> ltd = new ArrayList<ViewTipoDocumento> ();
		for(TipoDocumento td: tipodocumentos ){
			ltd.add(td.mostrate());
		}
		return ltd;
	}
	
	public ArrayList<ViewEmpleado> listaEmpleados() {
		return null;
	}
	
	public ArrayList<ViewCliente> listarClientes(String nombre,String apellido,String nroDoc) {
		ArrayList<ViewCliente> vc = new ArrayList<ViewCliente> ();
		for(Cliente c: clientes ){
			if(c.cumplo(nombre, apellido, nroDoc)){
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
		for(Cliente c: clientes){
			if(c.cumplo(id,null,null, null)){
				return c.mostrate();
			}
		}
		
		return null;
	}
	
	public RollEmpleado buscarRoll(String cod, String desc) {
		return null;
	}
	
	public TipoDocumento buscarTipoDoc(String cod, String desc) {
		for(TipoDocumento td:tipodocumentos){
			if(td.cumplo(cod, desc)){
				
				return td;
				
			}
		}
		return null;
	}
	
	public Empleado buscarEmpelado(int id, String apellido, String nombre, String roll, String documento, char e) {
		return null;
	}
	
	public Cliente buscarCliente(int id, String nombre, String apellido, String documento) {
		
		for(Cliente c : clientes){
			if(c.cumplo(id, nombre, apellido, documento)){
				return c;
			}
		}
		return null;
	}
	
	
public Cliente buscarCliente(String nombre, String apellido, String documento) {
		
		for(Cliente c : clientes){
			if(c.cumplo(nombre, apellido, documento)){
				return c;
			}
		}
		return null;
	}
	
	public int nuevoCliente(String apellido, String nombre, String documento, String codDoc, String tel, String mail, int dom) {
		return 0;
	}
	
	public boolean editarCliente(int id, String apellido, String nombre, String documento, String codDoc, String tel, String mail, int dom) {
		
		Cliente c= null;
		
		c= this.buscarCliente(id, null, null, null);
		
		if(c!=null){
			TipoDocumento td = null;
			td = this.buscarTipoDoc(codDoc, null);
			if(td!=null){
				
				Domicilio d=null;
				CtrlDomicilio cd = CtrlDomicilio.getInstance();
				d = cd.buscarDomicilio(dom, null, null, null, null, null, null, null, null, null);
				
				if(cd.buscarDomicilio(dom, null, null, null, null, null, null, null, null, null)!=null){
					
				
					
					if(!this.buscarCliente(null, null, documento).getNroDoc().equals(id)){
					c.editate(apellido, nombre, documento, td, tel, mail, cd.buscarDomicilio(dom, null, null, null, null, null, null, null, null, null));	
					return true;
					}
				}
			}
			
			
		}
		
		
		return false;
	}
	
	public boolean bajaCliente(int id) {
		return true;
	}
	
	public boolean rehabilitarCliente(int id) {
	return true;
	}
	
	public void add() {
	
	}
}
