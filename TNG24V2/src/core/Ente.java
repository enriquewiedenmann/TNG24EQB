package core;



public class Ente {
	private int idEnte;
	private String nombre;
	private String apellido;
	private TipoDocumento tipoDoc;
	private String nroDoc;
	private Usuario user;
	private char estado;
	
	public Ente(int idEnte, String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc, char estado, Usuario user) {
		
		this.idEnte = idEnte;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.estado = estado;
		this.user = user;
	}
	
	public Ente( String nombre, String apellido,
			TipoDocumento tipoDoc, String nroDoc) {
		
		this.idEnte = 0;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.nroDoc = nroDoc;
		this.estado = 'A';
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
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
	
}
