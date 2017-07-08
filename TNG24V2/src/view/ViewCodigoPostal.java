package view;

import core.Ciudad;
import core.Provincia;

public class ViewCodigoPostal {
	private int idCodigoPostal;
	private String codigoPostal;
	private String descCodigoPostal;
	private Provincia provincia;
	private Ciudad ciudad;
	private char estado;
	public ViewCodigoPostal(int idCodigoPostal, String codigoPostal,
			String descCodigoPostal, Provincia provincia, Ciudad ciudad,
			char estado) {
		
		this.idCodigoPostal = idCodigoPostal;
		this.codigoPostal = codigoPostal;
		this.descCodigoPostal = descCodigoPostal;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.estado = estado;
	}
	
	public String vistaLinea(){
	String l = "id: "+this.getIdCodigoPostal()+", cp: "+this.getCodigoPostal()+", descCP"+this.getDescCodigoPostal()+this.getCiudad().mostrate().vistaLinea()+
			", estado"+this.getEstado();
			
		return l;
	}
	
	
	public int getIdCodigoPostal() {
		return idCodigoPostal;
	}
	public void setIdCodigoPostal(int idCodigoPostal) {
		this.idCodigoPostal = idCodigoPostal;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getDescCodigoPostal() {
		return descCodigoPostal;
	}
	public void setDescCodigoPostal(String descCodigoPostal) {
		this.descCodigoPostal = descCodigoPostal;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
}
