package servlets;

import java.io.EOFException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import complementos.FechasAux;

import view.ViewCliente;
import view.ViewPresupuesto;
import controller.CtrlAgenda;

/**
 * Servlet implementation class PresupuestosSERVLET
 */
public class PresupuestosSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresupuestosSERVLET() {
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

		
		CtrlAgenda sys = CtrlAgenda.getInstance();
		
		
		
		if(request.getParameter("buscar").equals("buscarPresupuestos")){
		
			if(request.getParameter("bNroPresupuesto").equals("")){
			String fecha = request.getParameter("fechaEmision");
			Date fechaEmision = null;
			if (fecha != null && !fecha.equals("")){
				fechaEmision = FechasAux.getInstance().toDateDDMMYYY(fecha);
			}
			
			String nombre= request.getParameter("bNombre");
			String apellido = request.getParameter("bApellido");
			String documento = request.getParameter("bDocumento");
			
			if(nombre.length()==0){
				nombre=null;
			}
			if(apellido.length()==0){
				apellido=null;
			}
			if(documento.length()==0){
				documento=null;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("listaPresupuestos", (ArrayList<ViewPresupuesto>)sys.listarPresupuestos(fechaEmision, documento, nombre, apellido));
		
			request.getRequestDispatcher("PantallaPresupuesto.jsp").forward(request,response);	
			}else{
				
				int id = Integer.parseInt(request.getParameter("bNroPresupuesto"));
				HttpSession session = request.getSession(true);
				session.setAttribute("listaPresupuestos",(ArrayList<ViewPresupuesto>)sys.listarPresupuestos(id));
				request.getRequestDispatcher("PantallaPresupuesto.jsp").forward(request,response);	
				
			}
			
			
		}
	}

	private Date convertirFecha(String date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try{
			return df.parse(date);
		}catch(Exception e){
			return null;	
		}
		
	}

}
