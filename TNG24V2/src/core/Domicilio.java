package core;

import view.ViewDomicilio;

public class Domicilio {
	private int idDomicilio;
	private String calle;
	private String numero;
	private String piso;
	private String dpto;
	private String telefono;
	private Provincia provincia;
	private Ciudad ciudad;
	private CodigoPostal codigoPostal;
	private String descLocalidad;
	private char estado;
	
	
	
	
	
	
	
	
	public Domicilio(int idDomicilio, String calle, String numero,
			String piso, String dpto, String telefono, Provincia provincia,
			Ciudad ciudad, CodigoPostal codigoPostal, String descLocalidad,
			char estado) {
		
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.dpto = dpto;
		this.telefono = telefono;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.descLocalidad = descLocalidad;
		this.estado = estado;
	}
	
	

	public ViewDomicilio mostrate() {
		ViewDomicilio vdom = new ViewDomicilio(
				this.getIdDomicilio(),
				this.getCalle(),
				this.getNumero(),
				this.getPiso(),
				this.getDpto(),
				this.getTelefono(),
				this.getProvincia(),
				this.getCiudad(),
				this.getCodigoPostal(),
				this.getDescLocalidad(),
				this.getEstado()
				
				);
	return vdom;
	}
	
	public boolean cumplo(int id, String calle , String nro, String piso, String dpto, String tel, String prov, String cdad, String cp, String desc) {
		return false;
	
	}



	public int getIdDomicilio() {
		return idDomicilio;
	}



	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}



	public String getCalle() {
		return calle;
	}



	public void setCalle(String calle) {
		this.calle = calle;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getPiso() {
		return piso;
	}



	public void setPiso(String piso) {
		this.piso = piso;
	}



	public String getDpto() {
		return dpto;
	}



	public void setDpto(String dpto) {
		this.dpto = dpto;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
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



	public CodigoPostal getCodigoPostal() {
		return codigoPostal;
	}



	public void setCodigoPostal(CodigoPostal codigoPostal) {
		this.codigoPostal = codigoPostal;
	}



	public String getDescLocalidad() {
		return descLocalidad;
	}



	public void setDescLocalidad(String descLocalidad) {
		this.descLocalidad = descLocalidad;
	}



	public char getEstado() {
		return estado;
	}



	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
}
