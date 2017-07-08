package view;

public class ViewProvincia {
	private int idProvincia;
	private String codProvincia;
	private String descProvincia;
	private char estado;
	
	
	public ViewProvincia(int idProvincia, String codProvincia,
			String descProvincia, char estado) {
		this.idProvincia = idProvincia;
		this.codProvincia = codProvincia;
		this.descProvincia = descProvincia;
		this.estado = estado;
	}

	public String vistaLinea(){
		return "id: "+Integer.toString(this.getIdProvincia())+", cod: "+this.getCodProvincia()+", descripcion: "+this.getDescProvincia()+", estado: "+this.getEstado();
	}
	
	
	public int getIdProvincia() {
		return idProvincia;
	}


	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}


	public String getCodProvincia() {
		return codProvincia;
	}


	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}


	public String getDescProvincia() {
		return descProvincia;
	}


	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}


	public char getEstado() {
		return estado;
	}


	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
}
