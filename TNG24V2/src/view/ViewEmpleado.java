package view;

import core.RollEmpleado;
import core.TipoDocumento;
import core.Usuario;

public class ViewEmpleado {

	private String telefono;
	private String mail;
	private RollEmpleado Rol;
	private int idEnte;
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDoc;
	private String nroDoc;
	private Usuario user;
	private char estado;
	
	
	public ViewEmpleado(String telefono, String mail,int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado,RollEmpleado rol, Usuario user) {
		this.telefono =telefono;
		this.mail=mail;
		this.Rol =rol;
		this.idEnte=idEnte;
		this.nombre =nombre;
		this.apellido=apellido;
		this.tipoDoc= tipoDoc;
		this.nroDoc=nroDoc;
		this.user=user;
		this.estado=estado;
		
	}

	
	
	
	

	@Override
	public String toString() {
		return "ViewEmpleado [telefono=" + telefono + ", mail=" + mail
				+ ", Rol=" + Rol.mostrate().toString() + ", idEnte=" + idEnte + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", tipoDoc=" + tipoDoc.getDescTipoDoc()
				+ ", nroDoc=" + nroDoc + ", user=" + user.mostrate().toString() + ", estado="
				+ estado + "]";
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


	public int getIdEnte() {
		return idEnte;
	}


	public void setIdEnte(int idEnte) {
		this.idEnte = idEnte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public TipoDocumento getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(TipoDocumento tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getNroDoc() {
		return nroDoc;
	}


	public void setNroDoc(String nroDoc) {
		this.nroDoc = nroDoc;
	}


	public Usuario getUser() {
		return user;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}


	public char getEstado() {
		return estado;
	}


	public void setEstado(char estado) {
		this.estado = estado;
	}

	
	
	
}
