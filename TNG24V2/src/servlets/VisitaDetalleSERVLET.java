package servlets;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.ViewAgenda;
import view.ViewVisita;
import complementos.FechasAux;
import controller.CtrlAgenda;

/**
 * Servlet implementation class VisitaDetalleSERVLET
 */
public class VisitaDetalleSERVLET extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitaDetalleSERVLET() {
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
		try{
		String accion= request.getParameter("accion");
		CtrlAgenda sys=CtrlAgenda.getInstance();
		
		switch (accion){
		
		case "altaVisita":
			int id;
			String motivo=request.getParameter("fmotivo");
			int cliente= Integer.parseInt(request.getParameter("fcliente"));
			int domicilio=Integer.parseInt(request.getParameter("fdomicilio"));
			int tecnico=Integer.parseInt(request.getParameter("ftecnico"));
			Date fIni=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("ffini"));
			String hi=request.getParameter("fhini");
			Date dhi=FechasAux.getInstance().toDateHHMM(hi);
			String hf =request.getParameter("fhfin");
			Date dhf=FechasAux.getInstance().toDateHHMM(hf);
			fIni= FechasAux.getInstance().sumarRestarHorasFecha(fIni, dhi.getHours());
			fIni= FechasAux.getInstance().sumarRestarMinutosFecha(fIni, dhi.getMinutes());
			Date fFin=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("ffini"));
			fFin= FechasAux.getInstance().sumarRestarHorasFecha(fFin, dhf.getHours());
			fFin= FechasAux.getInstance().sumarRestarMinutosFecha(fFin, dhf.getMinutes());
			int presupuesto=0;
			if(isNumeric(request.getParameter("fpresupuesto"))){
				presupuesto=Integer.parseInt(request.getParameter("fpresupuesto"));
				id= sys.nuevaVisita(motivo,cliente, domicilio, fIni, fFin, tecnico,presupuesto);
				request.setAttribute("visita", (ViewVisita)sys.mostrarVisita(id));
				
				request.getRequestDispatcher("PantallaDetalleVisita.jsp").forward(request,response);	
			}else{
				id= sys.nuevaVisita(motivo,cliente, domicilio, fIni, fFin, tecnico);
				request.setAttribute("visita", (ViewVisita)sys.mostrarVisita(id));
				request.getRequestDispatcher("PantallaDetalleVisita.jsp").forward(request,response);	
				System.out.println("alta:"+id);
			}
			
		
			
			break;
			
			
	
		case "EditarVisita":
			 
			if(isNumeric(request.getParameter("fidVisita"))){
				id = Integer.parseInt(request.getParameter("fidVisita"));
			
			
			 
			 
			 motivo=request.getParameter("fmotivo");
			 cliente= Integer.parseInt(request.getParameter("fcliente"));
			 domicilio=Integer.parseInt(request.getParameter("fdomicilio"));
			 tecnico=Integer.parseInt(request.getParameter("ftecnico"));
			 fIni=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("ffini"));
			 hi=request.getParameter("fhini");
			 dhi=FechasAux.getInstance().toDateHHMM(hi);
			 hf =request.getParameter("fhfin");
			 dhf=FechasAux.getInstance().toDateHHMM(hf);
			fIni= FechasAux.getInstance().sumarRestarHorasFecha(fIni, dhi.getHours());
			fIni= FechasAux.getInstance().sumarRestarMinutosFecha(fIni, dhi.getMinutes());
			 fFin=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("ffini"));
			fFin= FechasAux.getInstance().sumarRestarHorasFecha(fFin, dhf.getHours());
			fFin= FechasAux.getInstance().sumarRestarMinutosFecha(fFin, dhf.getMinutes());
			 presupuesto=0;
			if(isNumeric(request.getParameter("fpresupuesto"))){
				presupuesto=Integer.parseInt(request.getParameter("fpresupuesto"));
				if(sys.modificarVisita(id, motivo,cliente,domicilio,presupuesto)){
				request.setAttribute("visita", (ViewVisita)sys.mostrarVisita(id));
				request.getRequestDispatcher("PantallaDetalleVisita.jsp").forward(request,response);
				}else{
					System.out.println("ERROR en editar visita");
			}
			}else{
				id= sys.nuevaVisita(motivo,cliente, domicilio, fIni, fFin, tecnico);
				request.setAttribute("visita", (ViewVisita)sys.mostrarVisita(id));
				request.getRequestDispatcher("PantallaDetalleVisita.jsp").forward(request,response);	
				System.out.println("alta:"+id);
			}
			}else{
				System.out.println("error");
			}
			break;
		
			
			
			
		case "mostrar":
			System.out.println("mostrar");
			if(isNumeric(request.getParameter("idVisita"))){
				id = Integer.parseInt(request.getParameter("idVisita"));
				ViewVisita v =sys.mostrarVisita(id);
				request.setAttribute("visita", (ViewVisita)v);
				request.getRequestDispatcher("PantallaDetalleVisita.jsp").forward(request,response);	
			}else{
				System.out.println("error");
			}
			break;
			
		case "baja":
			if(isNumeric(request.getParameter("idVisita"))){
				id = Integer.parseInt(request.getParameter("idVisita"));
				Date fecha=FechasAux.getInstance().toDateDDMMYYY(request.getParameter("bmfecbuscada"));
				sys.bajaVisita(id);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("listaAgTec", (ArrayList<ViewAgenda>)sys.listarAgendas(fecha));
				session.setAttribute("fecha", request.getParameter("bmfecbuscada"));
				request.getRequestDispatcher("PantallaAgendaCT.jsp").forward(request,response);
				
			}else{
				System.out.println("error");
			}
			break;	
		
		}
		
			
		}catch(Exception e){
			
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
