package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import complementos.FechasAux;
import controller.CtrlAgenda;
import view.ViewAgenda;
import view.ViewCliente;
import view.ViewVisita;

/**
 * Servlet implementation class AgendaCTSERVLET
 */
public class AgendaCTSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaCTSERVLET() {
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
		System.out.println("www");
		try{
			if(request.getParameter("buscar").equals("buscar")){
				System.out.println("2");
				CtrlAgenda sys = CtrlAgenda.getInstance();
				Date fecha=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("fecBucada"));
				
				ArrayList<ViewAgenda> va = sys.listarAgendas(fecha);
				
				
				HttpSession session = request.getSession(true);
				session.setAttribute("listaAgTec", (ArrayList<ViewAgenda>)sys.listarAgendas(fecha));
				request.getRequestDispatcher("PantallaAgendaCT.jsp").forward(request,response);
			}
			
			
			
		}catch(Exception e){
			
		}
		
		
		
	}

	
}
