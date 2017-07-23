package test;

import controller.CtrlAgenda;
import controller.CtrlDomicilio;
import controller.CtrlEnte;
import controller.CtrlProducto;
import core.Ente;
import view.*;
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
		

		System.out.println("----------------------------------------------------------------");
		System.out.println("productos");
		CtrlProducto ctrlp = CtrlProducto.getInstancia();
		for(ViewProducto p: ctrlp.listarProductos()){
			System.out.println(p.toString());
		}
	*/
		System.out.println("----------------------------------------------------------------");
		System.out.println("Presupuestos");
		CtrlAgenda ca = CtrlAgenda.getInstance();
		for(ViewPresupuesto p: ca.listarPresupuestos( null, null, null,null)){
		System.out.println(p.toString());	
		for(ViewItemDocumento vid: p.getVli()){
			System.out.println("                                        "+vid.toString());
		}
		}
		ca.nuevoPresupuesto(389);
		ca.ConfirmarAltaPresupuesto(100, 100);
		/*
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Agendas y Visitas");
		CtrlAgenda ca = CtrlAgenda.getInstance();
		for(ViewAgenda va: ca.listarAgendas()){
		System.out.println(va.toString());	
		for(ViewVisita vv: va.getVVV()){
			System.out.println("                                        "+vv.toString());
		}
		}
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Nuevo Presupuesto");
		//CtrlAgenda ca = CtrlAgenda.getInstance();
		if(ca.nuevoPresupuesto(389)){
			System.out.println("it: "+ca.nuevoItemPresupuesto("cam001", 1));
			System.out.println("it: "+ca.nuevoItemPresupuesto("cam002", 2));
			System.out.println("it: "+ca.nuevoItemPresupuesto("cam003", 3));
			if(ca.bajaItemPresupuesto(2)){
				System.out.println("ok baja");
			}else{
				System.out.println("VER");
			}
			System.out.println("it: "+ca.nuevoItemPresupuesto("cam002", 2));
			System.out.println("it: "+ca.nuevoItemPresupuesto("cam002", 2));
			ca.ConfirmarAltaPresupuesto(100, 100);
			
			
			
		}	*/
		
	/*	System.out.println("----------------------------------------------------------------");
		System.out.println("Presupuestos");
		//CtrlAgenda ca = CtrlAgenda.getInstance();
		for(ViewPresupuesto p: ca.listarPresupuestos(0, null, 0, 0, 0)){
		System.out.println(p.toString());	
		for(ViewItemDocumento vid: p.getVli()){
			System.out.println("                                        "+vid.toString());
		}
		}*/
	}}

