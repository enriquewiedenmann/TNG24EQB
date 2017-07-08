package core;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import view.ViewCliente;

public class Cliente extends Ente {

	private String telefono;
	private String mail;
	private Domicilio domicilio;
	
	
	
	public Cliente(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado, String telefono,
			String mail, Domicilio domicilio) {
		super(idEnte, nombre, apellido, tipoDoc, nroDoc, estado);
		this.telefono = telefono;
		this.mail = mail;
		this.domicilio = domicilio;
	}

	public boolean cumplo(int id, String nombre, String apellido, String documento) {
		
		
		
		
		return this.getIdEnte()==id && this.cumplo(nombre, apellido, documento);
	
	}
	
	public boolean cumplo( String nombre, String apellido, String documento) {
		
		boolean band = true;
		if(nombre!=null){
		if(this.getNombre().toUpperCase().equals(nombre.toUpperCase())){
			band = true;
		}else{
			band = false;
		}
			
		
		}
		if(apellido!=null){
			if(getApellido().toUpperCase().equals(apellido.toUpperCase())){
				band = true;
			}else{
				band = false;
			
			}
			}
		
		if(documento!=null){
			if(this.getNroDoc().toUpperCase().equals(documento.toUpperCase())){
				band = true;
			}else{
				band = false;
			
			}
			}
		
		
		return band;
	
	}
	
	public ViewCliente mostrate() {
		ViewCliente vc = new ViewCliente(
				this.getIdEnte(),
				this.getNombre(),
				this.getApellido(),
				this.getTipoDoc(),
				this.getNroDoc(),
				this.getEstado(),
				this.getTelefono(),
				this.getMail(),
				this.getDomicilio()
				);
		return vc;
	
	}
	
	public void editate(String apellido, String nombre, String documento, String codDoc, String tel, String mail, int dom) {
	
	}
	
	public void bajate() {
	
	}
	
	public void rehabilitate() {
	
	}
	
	public boolean sosCliente(int id) {
		return false;
	
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
	
	
}
