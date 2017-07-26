package test;

import java.util.Calendar;
import java.util.Date;

import complementos.FechasAux;

import view.ViewAgenda;
import view.ViewVisita;
import controller.CtrlAgenda;
import core.Agenda;

public class tstHojaRuta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CtrlAgenda sys= CtrlAgenda.getInstance();
		Date hoy = FechasAux.getInstance().toDateDDMMYYY("14/07/2017");
		int i = 40;
		ViewAgenda a = sys.listarVisitas(hoy, i);
			
			for(ViewVisita v:a.getVVV() ){
				System.out.println(v.toString());
			}
		}
		

	}

