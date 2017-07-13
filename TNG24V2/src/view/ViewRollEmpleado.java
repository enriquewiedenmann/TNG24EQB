package view;

public class ViewRollEmpleado {

	
	private String codRollEmpleado;
	private String descRollEmpleado;
	private char estado;
	
	public ViewRollEmpleado(String codRollEmpleado, String descRollEmpleado,
			char estado) {
		

		this.codRollEmpleado = codRollEmpleado;
		this.descRollEmpleado = descRollEmpleado;
		this.estado = estado;
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public String toString() {
		return "codRollEmpleado:" + codRollEmpleado
				+ ", descRollEmpleado:" + descRollEmpleado + ", estado:"
				+ estado;
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
