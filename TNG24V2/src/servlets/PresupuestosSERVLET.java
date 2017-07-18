package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(request.getParameter("accion").equals("mostarPresupuesto")){
			int idPresupuesto = Integer.parseInt(request.getParameter("IdPresupuesto"));
			
			request.setAttribute("viewPresupuesto", (ViewPresupuesto)sys.mostrarPresupuesto(idPresupuesto));
			request.getRequestDispatcher("PantallaPresupuesto.jsp").forward(request,response);	
			
		}
	}

}
