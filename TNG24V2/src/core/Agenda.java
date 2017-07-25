package core;

import java.util.ArrayList;
import java.util.Date;

import complementos.FechasAux;
import persistencia.DAOVisita;
import view.ViewAgenda;
import view.ViewVisita;

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
		for(Visita v: visitas){
			if(v.cumplo(id)){
				visitas.remove(v);
				v.baja();
				return true;
			}
		}
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

	public ViewAgenda mostrate(Date fecha) {
		
		ViewAgenda va =new ViewAgenda(this.getIdAgenda(),this.getTecnico(),this.getEstado(),this.getVisitas(fecha));
		return va;
	}

	private ArrayList<Visita> getVisitas(Date fecha) {
		Date manana = FechasAux.getInstance().sumarRestarDiasFecha(fecha, 1);
		 ArrayList<Visita> vd = new ArrayList<Visita>();
		 for(Visita v: visitas){
			
			 if(v.getInicioProgramado().after(fecha) & v.getInicioProgramado().before(manana)){
				 vd.add(v);
			 }
			 
		 }
		return vd;
	}

	

	public int nuevaVisita(Presupuesto p, String motivo, Cliente cl,
			Domicilio dom, Date inicioProgramado, Date finProgramado) {
		int id=-1;
		boolean band=true;
		/*for(Visita ex:visitas){
			if(inicioProgramado.after(ex.getInicioProgramado()) & inicioProgramado.before(ex.getFinProgramado())){
				band=false;
			}
			if(finProgramado.after(ex.getInicioProgramado()) & finProgramado.before(ex.getFinProgramado())){
				band=false;
			}
		}*/
		if(band){
		Visita v= new Visita(p, cl, dom, inicioProgramado, finProgramado, null, null, motivo, this.getTecnico());
		 id=DAOVisita.getInstancia().insert(this.getIdAgenda(), v);
		v.setId(id);
		visitas.add(v);
		}
		return id;
	}

	public ViewVisita mostraVisita(int id) {
		for(Visita v:visitas){
			if(v.cumplo(id)){
				return v.mostrate(this.getTecnico());
			}
		}
		return null;
	}

	public boolean editarVisita(int id, String motivo, Cliente cl,
			Domicilio dom, Presupuesto p) {
		for(Visita v:visitas){
			if(v.cumplo(id)){
				v.meEdito(motivo,cl,dom,p);
				return true;
			}
		}
		return false;
	}
	
	
	
}
