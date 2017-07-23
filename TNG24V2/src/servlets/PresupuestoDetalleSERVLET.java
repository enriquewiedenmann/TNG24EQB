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
		
		
		CtrlAgenda sys = CtrlAgenda.getInstance();
		try{		
		if(request.getParameter("accion1").equals("mostrarPresupuesto")){
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
		}}catch(Exception e){}
		
		
		try{	
		if(request.getParameter("accion").equals("altaPresupuesto")){
			
		if(isNumeric(request.getParameter("idnp"))){
			int id =Integer.parseInt(request.getParameter("idnp"));
			if(sys.nuevoPresupuesto(id)){
				ViewPresupuesto vp=sys.getPa().mostrate();
				HttpSession session = request.getSession(true);
				session.setAttribute("presupuesto",(ViewPresupuesto)vp);
				request.setAttribute("estado", "alta");
				//request.getRequestDispatcher("PantallaPresupuesto2.jsp").forward(request,response);
				request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			}else{
				request.setAttribute("error", "Error en alta Presupuesto");
				request.getRequestDispatcher("provisoria.jsp").forward(request,response);	
			}
		}else{
			request.setAttribute("error", "Error en alta Presupuesto");
			request.getRequestDispatcher("Provisoria.jsp").forward(request,response);	
		}}}catch(Exception e){}
		
		
		
		try{
			System.out.println(request.getParameter("accion"));
		if(request.getParameter("accion").equals("altaItem")){
			System.out.println(request.getParameter("codProductoModal"));
			System.out.println(request.getParameter("cantProductoModal"));
		if(!request.getParameter("codProductoModal").equals("") & isNumeric(request.getParameter("cantProductoModal"))){
			
			String codigoItem= request.getParameter("codProductoModal");
			int cantItem = Integer.parseInt(request.getParameter("cantProductoModal"));
				
			sys.nuevoItemPresupuesto(codigoItem, cantItem);
			HttpSession session = request.getSession(true);
			session.setAttribute("presupuesto", (ViewPresupuesto)sys.getPa().mostrate());
			request.setAttribute("estado", "alta");
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			
		}else{
			request.setAttribute("error", "No se pudo dar de alta el item");
		}}}catch(Exception e){}
		
		
		
		
		
		try{
		if(request.getParameter("accion").equals("bajaItem")){
		if(isNumeric(request.getParameter("idip"))){
			int id = 	Integer.parseInt(request.getParameter("idip"));
			sys.bajaItemPresupuesto(id);
			HttpSession session = request.getSession(true);
			session.setAttribute("presupuesto",(ViewPresupuesto)sys.getPa().mostrate());
			request.setAttribute("estado", "alta");
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);
			
		}else{
			request.setAttribute("error", "No se pudo dar de baja el item");
		}}}catch(Exception e){}
		
		
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
