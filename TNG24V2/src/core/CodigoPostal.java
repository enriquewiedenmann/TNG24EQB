package core;

import view.ViewCodigoPostal;

public class CodigoPostal {
	private int idCodigoPostal;
	private String codigoPostal;
	private String descCodigoPostal;
	private Provincia provincia;
	private Ciudad ciudad;
	private char estado;
	
	
	public CodigoPostal(int idCodigoPostal, String codigoPostal,
			String descCodigoPostal, Provincia provincia, Ciudad ciudad,
			char estado) {
		
		this.idCodigoPostal = idCodigoPostal;
		this.codigoPostal = codigoPostal;
		this.descCodigoPostal = descCodigoPostal;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.estado = estado;
	}

	public ViewCodigoPostal mostrate() {
		ViewCodigoPostal vcp = new ViewCodigoPostal(this.getIdCodigoPostal(), this.getCodigoPostal(),
				this.getDescCodigoPostal(), this.getProvincia(), this.getCiudad(),
				this.getEstado());
		
		return vcp;
	
	}
	
	public boolean cumplo(int id, String cod, String desc, String codProv, String codCiudad, char e) {
		return false;
	
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
