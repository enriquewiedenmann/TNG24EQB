package tst;

import core.Ente;
import view.*;
import ctrl.CtrlDomicilio;
import ctrl.CtrlEnte;

public class TSTListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CtrlDomicilio d = CtrlDomicilio.getInstance();
		CtrlEnte e = CtrlEnte.getInstance();
		/*
		for(ViewProvincia vp: d.listarProvincias()){
			//	System.out.println(vp.vistaLinea());
			
		}
		

		for(ViewCiudad vp: d.listarCiudades()){
			//System.out.println(vp.vistaLinea());
			
		}
		
		for(ViewCodigoPostal vcp:d.listarCodigosPostales()){
			//System.out.println(vcp.vistaLinea());
		}
		
		for(ViewDomicilio dom : d.listarDomicilios()){
			
			//System.out.println(dom.vistaTabla());
			//System.out.println(dom.vistaLinea());
			
		}
		
		for(ViewTipoDocumento td : e.listarTipoDocs()){
			
			//System.out.println(td.vistaLinea());
			
			
		}
		
		for(ViewCliente c : e.listarClientes(null,"zanette",null)){
			System.out.println(c.vistaTabla());
		}
		
		
		System.out.println("Cliente: "+ e.mostrarCliente(5).getApellido());
		
		System.out.println("Cliente: "+ e.mostrarCliente(3).vistaLinea());
		System.out.println(e.mostrarCliente(3).getTipoDoc().getCodTipoDoc());
		e.editarCliente(3, "Zanette", "olgaaaaa", "6553781", "DN ", "4783-4151", "Olga.Zanette@marsh.com" , 2001);
		
		System.out.println("Cliente: "+ e.mostrarCliente(3).vistaLinea());
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("PRUEBA DE BAJA");
		System.out.println("ANTES: ");
		System.out.println(e.mostrarCliente(3).getEstado());
		if(e.bajaCliente(3)){
		System.out.println("ok");
	}else{
		System.out.println("fail");
	}
		System.out.println("DESPUES: ");
		System.out.println(e.mostrarCliente(3).vistaLinea());
		System.out.println(e.mostrarCliente(3).getEstado());
		System.out.println("----------------------------------------------------------------");
		System.out.println("PRUEBA DE Alta:");
		System.out.println("nuevo cliente: "+ e.nuevoCliente("Wiedenmann", "Enrique", "33914089", "DN ", "4320-5844", "enrique.wiedenmann@gamil.com",1204));
		
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("PRUEBA DE rreahbilitar");
		System.out.println("ANTES: ");
		System.out.println(e.mostrarCliente(3).getEstado());
		if(e.rehabilitarCliente(3)){
		System.out.println("ok");
	}else{
		System.out.println("fail");
	}
		System.out.println("DESPUES: ");
		System.out.println(e.mostrarCliente(3).vistaLinea());
		System.out.println(e.mostrarCliente(3).getEstado());
		System.out.println("----------------------------------------------------------------");
		System.out.println();
		
	
	*/
		System.out.println("----------------------------------------------------------------");
		System.out.println("ROLL DE EMPLEADOS");
		for(ViewRollEmpleado r: e.listarRoles()){
			System.out.println(r.toString());
		}
		
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("EMPLEADOS");
		for(ViewEmpleado em: e.listaEmpleados()){
			System.out.println(em.toString());
		}
		
	}
}
