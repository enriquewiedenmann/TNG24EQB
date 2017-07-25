package view;

import java.util.ArrayList;

import core.Empleado;
import core.Visita;

public class ViewAgenda {
	private int idAgenda;
	private Empleado tecnico;
	private char estado;
	private ArrayList<Visita> vv;
	
	
	
	
	
	public ViewAgenda(int idAgenda, Empleado tecnico, char estado,
			ArrayList<Visita> vv) {
		super();
		this.idAgenda = idAgenda;
		this.tecnico = tecnico;
		this.estado = estado;
		this.vv = vv;
	}
	
	
	
	@Override
	public String toString() {
		return "ViewAgenda [idAgenda=" + idAgenda + ", tecnico=" + tecnico.getApellido()+", "+tecnico.getNombre()
				+ ", estado=" + estado + "]";
	}



	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	public Empleado getTecnico() {
		return tecnico;
	}
	public void setTecnico(Empleado tecnico) {
		this.tecnico = tecnico;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public ArrayList<Visita> getVv() {
		return vv;
	}
	public void setVv(ArrayList<Visita> vv) {
		this.vv = vv;
	}
	
	public ArrayList<ViewVisita> getVVV() {
		ArrayList<ViewVisita> vvv= new ArrayList<ViewVisita>();
		for(Visita v:this.getVv()){
			vvv.add(v.mostrate(this.getTecnico()));
		}
		return vvv;
	}
	
}
