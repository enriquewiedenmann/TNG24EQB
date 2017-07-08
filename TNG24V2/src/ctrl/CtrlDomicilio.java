package ctrl;

import java.util.ArrayList;
import java.util.List;

import complementos.Contrato;
import persistencia.DAOCiudad;
import persistencia.DAOCodigoPostal;
import persistencia.DAODomicilio;
import persistencia.DAOProvincia;
import core.*;
import view.*;

public  class CtrlDomicilio {
	private static CtrlDomicilio ctrlDomicilio;
	private ArrayList<CodigoPostal> codigosPostales;
	private ArrayList<Provincia> provinicias;
	private ArrayList<Ciudad> ciudades;
	private ArrayList<Domicilio> domicilios;
	
	
	public CtrlDomicilio() {
		this.codigosPostales = this.cargarCodigosPostales();
		this.provinicias =this.cargarProvincias();
		this.ciudades = this.cargarCiudades();
		this.domicilios = this.cargarDomicilios();
	}

	public static CtrlDomicilio getInstance() {
		
		if (ctrlDomicilio == null)
			ctrlDomicilio = new CtrlDomicilio();
		return ctrlDomicilio;

		
	}
	
	private ArrayList<Provincia>  cargarProvincias()
	{
		ArrayList<Provincia> p = DAOProvincia.getInstancia().select();
		return p != null ? p : null;
	}
	private ArrayList<Ciudad>  cargarCiudades()
	{
		ArrayList<Ciudad> c = DAOCiudad.getInstancia().select();
		
		return c != null ? c : null;
	}

	private ArrayList<CodigoPostal>  cargarCodigosPostales()
	{
		ArrayList<CodigoPostal> cp = DAOCodigoPostal.getInstancia().select();
		return cp != null ? cp : null;
	}
	
	private ArrayList<Domicilio>  cargarDomicilios()
	{
		ArrayList<Domicilio> dom = DAODomicilio.getInstancia().select();
		return dom != null ? dom : null;
	}	

			
	public ArrayList<ViewCodigoPostal> listarCodigosPostales() {
		ArrayList<ViewCodigoPostal> vcp  = new  ArrayList<ViewCodigoPostal>();
		for(CodigoPostal cp:codigosPostales){
			vcp.add(cp.mostrate());
		}
		
		return vcp;
	}
	
	public ArrayList<ViewDomicilio> listarDomicilios() {
		ArrayList<ViewDomicilio> vdom  = new  ArrayList<ViewDomicilio>();
		for(Domicilio dom: domicilios){
			vdom.add(dom.mostrate());
		}
		
		return vdom;
	}
	
	public ArrayList<ViewCiudad> listarCiudades() {
		ArrayList<ViewCiudad> vc  = new  ArrayList<ViewCiudad>();
		for(Ciudad c:ciudades){
			vc.add(c.mostrate());
		}
		
		return vc;
	}
	
	public ArrayList<ViewProvincia> listarProvincias() {
		 ArrayList<ViewProvincia> vp  = new  ArrayList<ViewProvincia>();
		for(Provincia p:provinicias){
			vp.add(p.mostrate());
		}
		
		return vp;
	}
	
	public CodigoPostal bucarCodigosPostal(int id, String cod, String desc, String codProv, String codCiudad, char e) {
		return null;
	}
	
	public Domicilio buscarDomicilio(int id, String calle, String nro, String piso, String dpto, String tel, String prov, String cdad, String cp, String desc) {
		return null;
	}
	
	public Ciudad buscarCiudad(int id, String cod, String desc, String codProv, char e) {
		return null;
	}
	
	public Provincia buscarProvincia(int id, String cod, String desc, char e) {
		return null;
	}
	
	public ViewCodigoPostal mostrarCodigosPostal(int id) {
		return null;
	}
	
	public ViewCiudad mostrarCiudad(int id) {
		return null;
	}
	
	public ViewDomicilio mostrarDomicilio(int id) {
		return null;
	}
	
	public ViewProvincia mostrarProvincia(int id) {
		return null;
	}
}
