package servlets;

import java.io.EOFException;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				System.out.println("alta:"+id);
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
