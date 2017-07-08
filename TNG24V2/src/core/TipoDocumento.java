package core;

import view.ViewTipoDocumento;

public class TipoDocumento {
	private String codTipoDoc;
	private String descTipoDoc;
	private char estado;
	
	
	
	
	public TipoDocumento(String codTipoDoc, String descTipoDoc, char estado) {
		
		this.codTipoDoc = codTipoDoc;
		this.descTipoDoc = descTipoDoc;
		this.estado = estado;
	}

	public Boolean cumplo(String cod, String desc) {
		
		boolean band =true;
		if(cod!=null){
			if(this.getCodTipoDoc().toUpperCase().equals(cod.toUpperCase())){
				
				band = true;
			}else{
				band= false;
			}
			
		}
		if(desc!=null){
			if(desc.toUpperCase().equals(this.getDescTipoDoc().toUpperCase())){
				band = true;
			}else{
				band= false;
			}
			
		}
		return band;
	
	}
	
	public ViewTipoDocumento mostrate() {
		ViewTipoDocumento vtd = new ViewTipoDocumento(this.getCodTipoDoc(),this.getDescTipoDoc(),this.getEstado());
		
		return vtd;
	
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
