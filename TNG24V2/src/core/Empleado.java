package core;

import view.ViewEmpleado;


public class Empleado extends Ente {
	public Empleado(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado) {
		super(idEnte, nombre, apellido, tipoDoc, nroDoc, estado);
		// TODO Auto-generated constructor stub
	}

	private String telefono;
	private String mail;
	private RollEmpleado Rol;
	public boolean cumplo(int id, String apellido, String nombre, String roll, String documento, char e) {
		return false;
	
	}
	
	public ViewEmpleado mostrate() {
		return null;
	
	}
}
