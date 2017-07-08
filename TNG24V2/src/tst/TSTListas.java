package tst;

import view.*;
import ctrl.CtrlDomicilio;
import ctrl.CtrlEnte;

public class TSTListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CtrlDomicilio d = CtrlDomicilio.getInstance();
		CtrlEnte e = CtrlEnte.getInstance();
		
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
			
			//System.out.println(dom.vistaLinea());
			
			
		}
		
		for(ViewTipoDocumento td : e.listarTipoDocs()){
			
			//System.out.println(td.vistaLinea());
			
			
		}
		
		for(ViewCliente c : e.listarClientes(null,"zanette",null)){
			System.out.println(c.vistaLinea());
		}
		
		
		System.out.println("Cliente: "+ e.mostrarCliente(5).getApellido());
		
		
	}

}
