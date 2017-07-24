package test;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import complementos.*;

public class TSTFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date entra = FechasAux.getInstance().toDateDDMMYYY("24/07/2017");
		System.out.println(entra.toString());
		Calendar calendario = GregorianCalendar.getInstance();
		Date iniPro = calendario.getTime();
		System.out.println(iniPro.toString());
		Date entraM =  FechasAux.getInstance().sumarRestarDiasFecha(entra, 1);
		System.out.println(entraM.toString());
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));
		iniPro =  FechasAux.getInstance().sumarRestarDiasFecha(entra, 1);
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));
		iniPro =  FechasAux.getInstance().sumarRestarDiasFecha(entra, -3);
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));
	
	}

}
