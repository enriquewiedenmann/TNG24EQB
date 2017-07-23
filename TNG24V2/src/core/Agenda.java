package core;

import java.util.ArrayList;

import persistencia.DAOVisita;
import view.ViewAgenda;

public class Agenda {
	private int idAgenda;
	private Empleado tecnico;
	private char estado;
	private ArrayList<Visita> visitas;
	
	

	public Agenda(int idAgenda, Empleado tecnico, char estado) {
		this.idAgenda = idAgenda;
		this.tecnico = tecnico;
		this.estado = estado;
		this.visitas = DAOVisita.getInstancia().selectVisita(idAgenda); //codeo Pendiente
	}

	public boolean cumplo(int id, Empleado tec, char e) {
		return false;
	
	}
	
	public ViewAgenda mostrate() {
		ViewAgenda va =new ViewAgenda(this.getIdAgenda(),this.getTecnico(),this.getEstado(),this.getVisitas());
	return va;
	}
	
	public boolean esTuVisita(int idVisita) {
		
		for(Visita v: visitas){
			if(v.cumplo(idVisita)){
				return true;
			}
		}
		return false;
	}
	
	public Visita buscarVisitaPresupuesto(int id) {
		for(Visita v: visitas){
			if(v.cumplo(id)){
				return v;
			}
		}
		return null;
	}
	
	public boolean bajaVisita(int id, String motivo) {
		return false;
	}
	
	public void cambiarEstado(char e) {
	
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

	public ArrayList<Visita> getVisitas() {
		return visitas;
	}

	public void setVisitas(ArrayList<Visita> visitas) {
		this.visitas = visitas;
	}
	
	
	
}
