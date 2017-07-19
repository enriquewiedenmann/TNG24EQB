package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		if(!isNumeric(request.getParameter("idm"))){
			request.getRequestDispatcher("PantallaPresupuesto.jsp");
		}else{
			int id = 	Integer.parseInt(request.getParameter("idm"));
			request.setAttribute("presupuesto", (ViewPresupuesto)sys.mostrarPresupuesto(id));
			request.getRequestDispatcher("PantallaDetallePresupuesto.jsp").forward(request,response);	
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
