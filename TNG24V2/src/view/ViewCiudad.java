package view;

import core.Provincia;

public class ViewCiudad {
	private int idCiudad;
	private String codCiudad;
	private String descCiudad;
	private Provincia provincia;
	private char estado;
	
	
	
	public ViewCiudad(int idCiudad, String codCiudad, String descCiudad,
			Provincia provincia, char estado) {
		
		this.idCiudad = idCiudad;
		this.codCiudad = codCiudad;
		this.descCiudad = descCiudad;
		this.provincia = provincia;
		this.estado = estado;
	}

	public String vistaLinea() {
		
		return "id: "+this.getIdCiudad()+", cod: "+this.getCodCiudad()+", desc: "+this.getDescCiudad()+", codProv: "+
		this.getProvincia().getCodProvincia()+",descProvincia:"+this.getProvincia().getDescProvincia()+", idProv"+this.getProvincia().getIdProvincia()+
		", estado: "+this.getEstado();
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getCodCiudad() {
		return codCiudad;
	}

	public void setCodCiudad(String codCiudad) {
		this.codCiudad = codCiudad;
	}

	public String getDescCiudad() {
		return descCiudad;
	}

	public void setDescCiudad(String descCiudad) {
		this.descCiudad = descCiudad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	

}
