package view;

import core.Domicilio;
import core.TipoDocumento;

public class ViewCliente {
	
	
	private int idEnte;
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDoc;
	private String nroDoc;
	private char estado;
	private String telefono;
	private String mail;
	private Domicilio domicilio;
	
	public ViewCliente(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado, String telefono,
			String mail, Domicilio domicilio) {
	
		this.idEnte = idEnte;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.estado = estado;
		this.telefono = telefono;
		this.mail = mail;
		this.domicilio = domicilio;
	}

	
	public String vistaLinea(){
		String l  = "id: "+this.getIdEnte()+
				",  nombre: "+this.getNombre()+
				", apellido: "+this.getApellido()+
				", tipoDoc: "+this.getTipoDoc().getDescTipoDoc()+
				", nroDoc: "+this.getNroDoc()+
				", telefono: "+this.getTelefono()+
				", mail: "+this.getMail()+
				"DOMICILIO: "+this.getDomicilio().mostrate().vistaLinea();
				
		return l;
	}
	
	
	public String vistaTabla(){
		return  "<tr class=\"bodyTableCliente\" ><th id=\"id\" >"+this.getIdEnte()+"</th><th>"+
		       this.getApellido()+", "+this.getNombre()+"</th><th>"+
		        this.getTipoDoc().getDescTipoDoc()+"</th><th>"+
		        this.getNroDoc()+"</th><th>"+
		        this.getTelefono()+"</th><th>"+
		        this.getMail()+"</th><th>"+
		        this.getEstado()+"</th></tr>";
			
	}
	
	public int getIdEnte() {
		return idEnte;
	}
	
	public String getIdEnteString() {
		return Integer.toString(idEnte);
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

	public String getEstado() {
		
		
		return String.valueOf(this.estado);
	}

	public void setEstado(char estado) {
		this.estado = estado;
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
