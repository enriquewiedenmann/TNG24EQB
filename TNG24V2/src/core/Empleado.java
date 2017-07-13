package core;

import view.ViewEmpleado;


public class Empleado extends Ente {
	

	private String telefono;
	private String mail;
	private RollEmpleado Rol;
	public boolean cumplo(int id, String apellido, String nombre, String roll, String documento, char e) {
		return false;
	
	}
	
	
		public Empleado(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado, Usuario user,
			String telefono, String mail, RollEmpleado rol) {
			
			
		super(idEnte, nombre, apellido, tipoDoc, nroDoc, estado, user);
		this.telefono = telefono;
		this.mail = mail;
		Rol = rol;
	}




	public ViewEmpleado mostrate() {
		
		return new ViewEmpleado(this.getTelefono(),this.getMail(),this.getIdEnte(),this.getNombre(),this.getApellido(),this.getTipoDoc(),this.getNroDoc(),
				this.getEstado(),this.getRol(),this.getUser());
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public RollEmpleado getRol() {
		return Rol;
	}


	public void setRol(RollEmpleado rol) {
		Rol = rol;
	}
	
	
}
