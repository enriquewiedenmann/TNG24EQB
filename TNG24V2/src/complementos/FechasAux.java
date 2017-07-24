package complementos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import controller.CtrlAgenda;
import core.Agenda;
import core.Factura;
import core.Presupuesto;
import core.Visita;

public class FechasAux {
	private static FechasAux fechaAux;
	
	public static FechasAux getInstance() {

		if (fechaAux == null)
			fechaAux = new FechasAux();
		return fechaAux;

	}

	
	
   public FechasAux() {
		
	}



public Date toDateDDMMYYY(String strFecha){
	SimpleDateFormat formatoDelTexto  = new SimpleDateFormat("dd/MM/yyyy");
   
   Date fecha = null;
   try {

       fecha = formatoDelTexto.parse(strFecha);

   } catch (Exception ex) {

       ex.printStackTrace();

   }

   return fecha;
	
}

public String toStringDDMMYY(Date dia){

SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/YYYY");
String diaS= formatoDeFecha.format(dia);

return diaS;
}

public String toStringHHMM(Date dia){

SimpleDateFormat formatoDeFecha = new SimpleDateFormat("HH:mm");
String diaS= formatoDeFecha.format(dia);

return diaS;
}

//Suma los días recibidos a la fecha  
public Date sumarRestarDiasFecha(Date fecha, int dias){

   Calendar calendar = Calendar.getInstance();
   calendar.setTime(fecha); // Configuramos la fecha que se recibe
   calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

   return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

}
//Suma o resta las horas recibidos a la fecha  
public Date sumarRestarHorasFecha(Date fecha, int horas){

   Calendar calendar = Calendar.getInstance();
   calendar.setTime(fecha); // Configuramos la fecha que se recibe
   calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0

   return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas

}


}
