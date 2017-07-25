package test;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import persistencia.DBConnection;
import complementos.*;
import controller.CtrlAgenda;

public class TSTFechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date entra = FechasAux.getInstance().toDateDDMMYYY("25/07/2017");
		Date sale = FechasAux.getInstance().toDateDDMMYYY("25/07/2017");
		System.out.println(entra.toString());
		Calendar calendario = GregorianCalendar.getInstance();
		Date iniPro = calendario.getTime();
		/*System.out.println(iniPro.toString());
		Date entraM =  FechasAux.getInstance().sumarRestarDiasFecha(entra, 1);
		System.out.println(entraM.toString());
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));
		iniPro =  FechasAux.getInstance().sumarRestarDiasFecha(entra, 1);
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));
		iniPro =  FechasAux.getInstance().sumarRestarDiasFecha(entra, -3);
		System.out.println(iniPro.after(entra));
		System.out.println(iniPro.before(entraM));*/
		
		String tiempo="9:45";
		Date sum=FechasAux.getInstance().toDateHHMM(tiempo);
		//entra=entra+sum;
		System.out.println(sum.toString());
		System.out.println(sum.getHours());
		System.out.println(sum.getMinutes());
		entra= FechasAux.getInstance().sumarRestarHorasFecha(entra, sum.getHours());
		System.out.println(entra.toString());
		sale= FechasAux.getInstance().sumarRestarHorasFecha(sale, sum.getHours());
		
		sale= FechasAux.getInstance().sumarRestarMinutosFecha(sale, sum.getMinutes());
		System.out.println(sale.toString());
	int id = CtrlAgenda.getInstance().nuevaVisita("prueba", 1, 1199, entra, sale, 39, 2);
	System.out.println(id);
	}
	
	/*
	
	Connection con = DBConnection.getPoolConnection().getConnection();
	CallableStatement sp;
	try {
		sp = con.prepareCall("INSERT INTO TNG24V1.dbo.FECHA(FECHA) VALUES (?)");
		sp.setDate(1, "");
	sp.execute();
	// confirmar si se ejecuto sin errores
	
	DBConnection.getPoolConnection().realeaseConnection(con);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ERROR ALTA CLIENTE " + e.getMessage());
	}*/

}
