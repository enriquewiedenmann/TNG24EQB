package test;

import controller.CtrlAgenda;

public class TstAltaPresupuesto {

	public static void main(String[] args) {
		CtrlAgenda sys = CtrlAgenda.getInstance();
		
		sys.nuevoPresupuesto(11);
		System.out.println(sys.getPa().mostrate().toString());
		
		
		

	}

}
