package view;

public class ViewUsuario {
	private String userName;
	private String pass;
	private char estado;
	public ViewUsuario(String userName, String pass, char estado) {
		
		this.userName = userName;
		this.pass = pass;
		this.estado = estado;
	}
	
	
	
	@Override
	public String toString() {
		return "ViewUsuario [userName=" + userName + ", pass=" + pass
				+ ", estado=" + estado + "]";
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
