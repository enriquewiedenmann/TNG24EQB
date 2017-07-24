package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.ViewCliente;
import view.ViewPresupuesto;
import controller.CtrlAgenda;

/**
 * Servlet implementation class PresupuestoDetalleSERVLET
 */
public class PresupuestoDetalleSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresupuestoDetalleSERVLET() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("acciones de presupuesto");
		CtrlAgenda sys = CtrlAgenda.getInstance();
		String accion = "error";
		try{
			
			if(request.getParameter("accion").equals("altaPresupuesto")){
				accion="altaPresupuesto";
			}
		}catch(Exception f){
		try{
			if(request.getParameter("mostrarPresupuesto").equals("mostrarPresupuesto")){
			accion="mostrarPresupuesto";
			}
		}catch(Exception d){
				
		try{
			if(request.getParameter("altaItem").equals("altaItem")){
			accion="altaItem";
			}
		}catch(Exception a){
			try{
				if(request.getParameter("bajaItem").equals("bajaItem")){
				accion="bajaItem";
				}
			}catch(Exception b){
				try{
					if(request.getParameter("cerrarPresupuesto").equals("cerrarPresupuesto")){
					accion="cerrarPresupuesto";
					}
				}catch(Exception c){
					
				}
			}
		}
		}
		}
		
		
		System.out.println(accion);
		switch (accion){
		
		case "mostrarPresupuesto":
		try{		
		
		if(!isNumeric(request.getParameter("idm"))){
			request.getRequestDispatcher("PantallaPresupuesto.jsp");
			
		}else{
			int id = Integer.parseInt(request.getParameter("idm"));
			HttpSession session = request.getSession(true);
			session.setAttribute("presupuesto", (ViewPresupuesto)sys.mostrarPresupuesto(id));
			//request.setAttribute("presupuesto", (ViewPresupuesto)sys.mostrarPresupuesto(id));
			request.setAttribute("estado", "mostrar");
			//request.getRequestDispatcher("PantallaPresupuesto2.jsp").forward(request,response);
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);	
		}
		}catch(Exception e){}
		
		break;
		
		case "altaPresupuesto":
		
		try{	
	
			
		if(isNumeric(request.getParameter("idnp"))){
			int id =Integer.parseInt(request.getParameter("idnp"));
			if(sys.nuevoPresupuesto(id)){
				ViewPresupuesto vp=sys.getPa().mostrate();
				HttpSession session = request.getSession(true);
				session.setAttribute("presupuesto",(ViewPresupuesto)vp);
				request.setAttribute("estado", "alta");
				request.setAttribute("error", "");
				//request.getRequestDispatcher("PantallaPresupuesto2.jsp").forward(request,response);
				request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			}else{
				request.setAttribute("error", "Error en alta Presupuesto");
				request.getRequestDispatcher("provisoria.jsp").forward(request,response);	
			}
		}else{
			request.setAttribute("error", "Error en alta Presupuesto");
			request.getRequestDispatcher("Provisoria.jsp").forward(request,response);	
		}}catch(Exception e){}
		
		break;
		
		case "altaItem":
		
		try{
			

			System.out.println(request.getParameter("codProductoModal"));
			System.out.println(request.getParameter("cantProductoModal"));
		if(!request.getParameter("codProductoModal").equals("") & isNumeric(request.getParameter("cantProductoModal"))){
			
			String codigoItem= request.getParameter("codProductoModal");
			int cantItem = Integer.parseInt(request.getParameter("cantProductoModal"));
				
			sys.nuevoItemPresupuesto(codigoItem, cantItem);
			HttpSession session = request.getSession(true);
			session.setAttribute("presupuesto", (ViewPresupuesto)sys.getPa().mostrate());
			request.setAttribute("estado", "alta");
			request.setAttribute("error", "");
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			
		}else{
			request.setAttribute("estado", "alta");
			request.setAttribute("error", "No se pudo dar de alta el item");
		}}catch(Exception e){}
		
		break;
		
		case "bajaItem":
		
		
		try{
				if(isNumeric(request.getParameter("idip"))){
			int id = 	Integer.parseInt(request.getParameter("idip"));
			sys.bajaItemPresupuesto(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("presupuesto",(ViewPresupuesto)sys.getPa().mostrate());
			request.setAttribute("estado", "alta");
			request.setAttribute("error", "");
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			
		}else{
			request.setAttribute("estado", "alta");
			request.setAttribute("error", "No se pudo dar de baja el item");
		}}catch(Exception e){}
		break;
		
		case "cerrarPresupuesto":
			
		try{
		
			if(isNumeric(request.getParameter("cptiempo")) & isNumeric(request.getParameter("cpmonto"))){
				int tiempoManoObra= Integer.parseInt(request.getParameter("cptiempo"));
				int montoManoObra= Integer.parseInt(request.getParameter("cpmonto"));
				String motivo="-";
				motivo= request.getParameter("cpmotivo");
				int id =sys.ConfirmarAltaPresupuesto(tiempoManoObra, montoManoObra,motivo);
				if(id!=-1){
				HttpSession session = request.getSession(true);
				session.setAttribute("presupuesto",(ViewPresupuesto)sys.mostrarPresupuesto(id));
				request.setAttribute("estado", "mostrar");
				request.setAttribute("error", "");
				request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
				
			}else{
				request.setAttribute("estado", "alta");
				request.setAttribute("error", "No se pudo Cerrar el presupuesto");
			}
				request.setAttribute("estado", "alta");
				request.setAttribute("error", "No se pudo Cerrar el presupuesto");
			}}catch(Exception e){}
		break;
		
		
		
		
		
		}
		
	
	}

	
	
	
	
	
	private static boolean isNumeric(String parameter) {
		try{
			Integer.parseInt(parameter);
			return true;
		}catch(Exception e){
			return false;
		}
		
		
	}

	
	
	
}
