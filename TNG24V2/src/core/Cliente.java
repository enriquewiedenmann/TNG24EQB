package core;



import persistencia.DAOCliente;
import view.ViewCliente;

public class Cliente extends Ente {

	private String telefono;
	private String mail;
	private Domicilio domicilio;
	
	public Cliente( String nombre, String apellido,String nroDoc ,
			TipoDocumento tipoDoc, String telefono,
			String mail, Domicilio domicilio) {
		
		
		super( nombre, apellido, tipoDoc, nroDoc);
		this.telefono = telefono;
		this.mail = mail;
		this.domicilio = domicilio;
		
		DAOCliente c =DAOCliente.getInstancia();
		
		this.setIdEnte(c.insert(nombre, apellido, tipoDoc.getCodTipoDoc(), nroDoc, telefono, mail, domicilio.getIdDomicilio()));
		
	}
	
	
	public Cliente(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado, String telefono,
			String mail, Domicilio domicilio) {
		super(idEnte, nombre, apellido, tipoDoc, nroDoc, estado,null);
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
		
		if(this.getNombre().toUpperCase().startsWith(nombre.toUpperCase())){
			band = true;
		}else{
			band = false;
		}
			
		
		}
		if(apellido!=null){
			if(getApellido().toUpperCase().startsWith(apellido.toUpperCase())){
				band = true;
			}else{
				band = false;
			
			}
			}
		
		if(documento!=null){
			if(this.getNroDoc().toUpperCase().startsWith(documento.toUpperCase())){
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
	
	public void editate(String apellido, String nombre, String documento, TipoDocumento codDoc, String tel, String mail, Domicilio dom) {
		
		
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setNroDoc(documento);
		this.setTipoDoc(codDoc);
		this.telefono = tel;
		this.mail = mail;
		this.domicilio = dom;
		this.setEstado('M');
		DAOCliente c = DAOCliente.getInstancia();
		c.update(this);
		c.updateEnte(this);
	}
	
	public void bajate() {
	this.setEstado('B');
	DAOCliente dao = DAOCliente.getInstancia();
	dao.baja(this);
	}
	
	public void rehabilitate() {
		this.setEstado('M');
		DAOCliente dao = DAOCliente.getInstancia();
		dao.rehabilitar(this);
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
