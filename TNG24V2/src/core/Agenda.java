package core;

import java.util.ArrayList;

import view.ViewAgenda;

public class Agenda {
	private int idAgenda;
	private Empleado tecnico;
	private char estado;
	private ArrayList<Visita> visitas;
	
	
	public boolean cumplo(int id, Empleado tec, char e) {
		return false;
	
	}
	
	public ViewAgenda mostrate() {
	return null;
	}
	
	public boolean esTuVisita(int idVisita) {
		return false;
	}
	
	public Visita buscarVisitaPresupuesto(int id) {
		return null;
	}
	
	public boolean bajaVisita(int id, String motivo) {
		return false;
	}
	
	public void cambiarEstado(char e) {
	
	}
}
