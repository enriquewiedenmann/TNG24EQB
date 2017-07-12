package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import view.ViewCliente;
import view.ViewTipoDocumento;
import ctrl.CtrlEnte;

/**
 * Servlet implementation class Cliente
 */
public class Cliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cliente() {
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
		
		CtrlEnte sys = CtrlEnte.getInstance();
		String accion = request.getParameter("accion");
		
		if(accion.equals("mostrarCliente")){
			int idCliente =Integer.parseInt(request.getParameter("idm"));
			request.setAttribute("setModal", "mostarCliente");
			request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(idCliente));
			request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);	
			}
		
		
		
		
		if(accion.equals("buscarCliente")){
			String nombre=request.getParameter("bnombreCliente");
			String apellido=request.getParameter("bapellidoCliente");
			String nroDoc=request.getParameter("bnroDocmento");
			if(nombre.length()==0){
				nombre=null;
			}
			if(apellido.length()==0){
				apellido=null;
			}
			if(nroDoc.length()==0){
				nroDoc=null;
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("listaCliente", (ArrayList<ViewCliente>)sys.listarClientes(nombre,apellido,nroDoc));
			request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);
		}
		
		
		
		
		
		if(accion.equals("nuevoCliente")){
			String nombre=request.getParameter("nombreCliente");
			String apellido=request.getParameter("apellidoCliente");
			String tipoDoc=request.getParameter("tipoDocumento");
			String nroDoc=request.getParameter("nroDocmento");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");
			String dom = request.getParameter("domicilio");	
			
			
			int nuevo =	sys.nuevoCliente(nombre, apellido, nroDoc,tipoDoc, telefono, mail, Integer.parseInt(dom));
			if(nuevo!=0){
				request.setAttribute("setModal", "mostarCliente");
				refrescarLista(request.getSession(true));
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(nuevo));
			}else{
				request.setAttribute("setModal", "1");
				
			}
			
			request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);	
		
		
		}
		
		
		if(accion.equals("editarCliente")){
			
			
			String nombre=request.getParameter("nombreCliente");
			String apellido=request.getParameter("apellidoCliente");
			String tipoDoc=request.getParameter("tipoDocumento");
			String nroDoc=request.getParameter("nroDocmento");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");
			String dom = request.getParameter("domicilio");
			String id = request.getParameter("idCliente");
			
					
			
			boolean band = false;
			band=sys.editarCliente(Integer.parseInt(id),nombre, apellido, nroDoc, tipoDoc, telefono, mail, Integer.parseInt(dom));
			if(band){
				request.setAttribute("setModal", "mostarCliente");
				
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
				refrescarLista(request.getSession(true));
				refrescarLista(request.getSession());
			}else{
				request.setAttribute("setModal", "2");
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
				
				
				}
				request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);	
		
		}
		
		
		
		if(accion.equals("bajaCliente")){
			String id = request.getParameter("idCliente");
			boolean band = false;
			band=sys.bajaCliente(Integer.parseInt(id));
			
			if(band){
				request.setAttribute("setModal", "mostarCliente");
				refrescarLista(request.getSession(true));
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
			}else{
				request.setAttribute("setModal", "3");
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
				
				
			}
			
			request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);	
			
			
			}
		if(accion.equals("rehabilitarCliente")){
			String id = request.getParameter("idCliente");
			boolean band = false;
			band=sys.rehabilitarCliente(Integer.parseInt(id));
			
			
			if(band){
				request.setAttribute("setModal", "mostarCliente");
				refrescarLista(request.getSession(true));
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
			}else{
				request.setAttribute("setModal", "4");
				request.setAttribute("viewCliente", (ViewCliente)sys.mostrarCliente(Integer.parseInt(id)));
				
				
			}
				request.getRequestDispatcher("PantallaCliente.jsp").forward(request,response);	
			}
		
	}

	private void refrescarLista(HttpSession session) {
		ArrayList<ViewCliente> lista = (ArrayList<ViewCliente>) session.getAttribute("listaCliente");
		ArrayList<ViewCliente> listaN = new  ArrayList<ViewCliente>();
		CtrlEnte sys = CtrlEnte.getInstance();
		if(lista!=null){
        	for(ViewCliente vc: lista){
        		
        		listaN.add(sys.mostrarCliente(vc.getIdEnte()));
           				}
        	session.setAttribute("listaCliente", listaN);
        }
		
	}

}
