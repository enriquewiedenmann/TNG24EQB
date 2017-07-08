package view;

public class ViewTipoDocumento {
	private String codTipoDoc;
	private String descTipoDoc;
	private char estado;
	
	
	
	
	public ViewTipoDocumento(String codTipoDoc, String descTipoDoc, char estado) {
		
		this.codTipoDoc = codTipoDoc;
		this.descTipoDoc = descTipoDoc;
		this.estado = estado;
	}



	public String vistaLinea(){
		return "cod: "+this.getCodTipoDoc()+", desc: "+this.getDescTipoDoc()+", estado: "+this.getEstado();
	}
	
	
	public String getCodTipoDoc() {
		return codTipoDoc;
	}




	public void setCodTipoDoc(String codTipoDoc) {
		this.codTipoDoc = codTipoDoc;
	}




	public String getDescTipoDoc() {
		return descTipoDoc;
	}




	public void setDescTipoDoc(String descTipoDoc) {
		this.descTipoDoc = descTipoDoc;
	}




	public char getEstado() {
		return estado;
	}




	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
