package core;

import java.util.List;

import complementos.Contrato;
import view.ViewProvincia;

public class Provincia {
	private int idProvincia;
	private String codProvincia;
	private String descProvincia;
	private char estado;
	
	


	
	public Provincia(int idProvincia, String codProvincia,
			String descProvincia, char estado) {
		
		this.idProvincia = idProvincia;
		this.codProvincia = codProvincia;
		this.descProvincia = descProvincia;
		this.estado = estado;
	}
	
	
	
	






	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Provincia other = (Provincia) obj;
		if (codProvincia == null) {
			if (other.codProvincia != null)
				return false;
		} else if (!codProvincia.equals(other.codProvincia))
			return false;
		if (descProvincia == null) {
			if (other.descProvincia != null)
				return false;
		} else if (!descProvincia.equals(other.descProvincia))
			return false;
		if (estado != other.estado)
			return false;
		if (idProvincia != other.idProvincia)
			return false;
		return true;
	}

	public ViewProvincia mostrate() {
		ViewProvincia vp = new ViewProvincia(this.getIdProvincia(),this.getCodProvincia(),this.getDescProvincia(),this.getEstado());
		
		return vp;
	
	}
	
	public boolean cumplo(int id, String cod, String desc, char e) {
		return false;
	
	}
	
	
	
	

	
	
	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getDescProvincia() {
		return descProvincia;
	}

	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
}
