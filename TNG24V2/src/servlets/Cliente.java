package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("EN EL SERVLET");
		CtrlEnte sys = CtrlEnte.getInstance();
		String accion = request.getParameter("accion");
		
		
		if(accion.equals("buscarCliente")){
			String nombre=request.getParameter("bnombreCliente");
			String apellido=request.getParameter("bapellidoCliente");
			String nroDoc=request.getParameter("bnroDocmento");
			request.setAttribute("listaCliente", (ArrayList<ViewCliente>)sys.listarClientes(nombre, apellido, nroDoc));
			request.getRequestDispatcher("ClientePre.jsp").forward(request,response);
		}
		
		
		
		
		
		if(accion.equals("nuevoCliente")){
			String nombre=request.getParameter("nombreCliente");
			String apellido=request.getParameter("apellidoCliente");
			String tipoDoc=request.getParameter("tipoDocumento");
			String nroDoc=request.getParameter("nroDocmento");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");
			String dom = request.getParameter("domicilio");	
			
		System.out.println("id: " +sys.nuevoCliente(apellido, nombre, nroDoc,tipoDoc, telefono, mail, Integer.parseInt(dom)));
		}
		if(accion.equals("editarCliente")){
			
			System.out.println("editar");
			String nombre=request.getParameter("nombreCliente");
			String apellido=request.getParameter("apellidoCliente");
			String tipoDoc=request.getParameter("tipoDocumento");
			String nroDoc=request.getParameter("nroDocmento");
			String telefono = request.getParameter("telefono");
			String mail = request.getParameter("mail");
			String dom = request.getParameter("domicilio");
			String id = request.getParameter("idCliente");
			sys.editarCliente(Integer.parseInt(id),apellido, nombre, nroDoc, tipoDoc, telefono, mail, Integer.parseInt(dom));
			}
		if(accion.equals("bajaCliente")){
			System.out.println("baja");
			String id = request.getParameter("idCliente");
			sys.bajaCliente(Integer.parseInt(id));
			}
		if(accion.equals("rehabilitarCliente")){
			System.out.println("reahbilitar");
			String id = request.getParameter("idCliente");
			sys.rehabilitarCliente(Integer.parseInt(id));
			}
		
	}

}
