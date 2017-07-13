package core;

import view.ViewRollEmpleado;

public class RollEmpleado {
	private String codRollEmpleado;
	private String descRollEmpleado;
	private char estado;
	
	
	
	
	public RollEmpleado(String codRollEmpleado, String descRollEmpleado,
			char estado) {
	
		this.codRollEmpleado = codRollEmpleado;
		this.descRollEmpleado = descRollEmpleado;
		this.estado = estado;
	}

	public Boolean cumplo(String cod, String desc) {
		return null;
	
	}
	
	public ViewRollEmpleado mostrate() {
		
		return new ViewRollEmpleado(this.getCodRollEmpleado(),this.descRollEmpleado,this.getEstado());
	
	}

	public String getCodRollEmpleado() {
		return codRollEmpleado;
	}

	public void setCodRollEmpleado(String codRollEmpleado) {
		this.codRollEmpleado = codRollEmpleado;
	}

	public String getDescRollEmpleado() {
		return descRollEmpleado;
	}

	public void setDescRollEmpleado(String descRollEmpleado) {
		this.descRollEmpleado = descRollEmpleado;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
}
