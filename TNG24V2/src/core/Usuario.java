package core;

import view.ViewUsuario;




public class Usuario {
	
	private String userName;
	private String pass;
	private char estado;
	public Usuario(String userName, String pass, char estado) {
		super();
		this.userName = userName;
		this.pass = pass;
		this.estado = estado;
	}
	
	public ViewUsuario mostrate(){
		
		return new ViewUsuario(this.getUserName(),this.getPass(),this.getEstado());
		
		
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
}
