package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String nombre=request.getParameter("nombreCliente");
		String apellido=request.getParameter("apellidoCliente");
		String tipoDoc=request.getParameter("tipoDocumento");
		String nroDoc=request.getParameter("nroDocmento");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		String dom = request.getParameter("domicilio");
		CtrlEnte sys = CtrlEnte.getInstance();
		
		
		System.out.println("id: " +sys.nuevoCliente(apellido, nombre, nroDoc, "DN ", telefono, mail, Integer.parseInt(dom)));
	}

}
