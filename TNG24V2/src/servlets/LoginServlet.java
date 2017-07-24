package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.DAOUsuarios;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4261016544681578021L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		
		if(request.getParameter("login") != null &&request.getParameter("login").equals("login")){
			try {
				String usuario = request.getParameter("usuario");
				String contraseña = request.getParameter("contraseña");

				if (DAOUsuarios.getInstancia().login(usuario, contraseña)) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentUser", usuario);
					request.getRequestDispatcher("PantallaCliente.jsp").forward(request, response);
				}
				else {
					request.setAttribute("loginError", "invalid");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			catch (Throwable theException) {
				System.out.println(theException);
			}
		}else if (request.getParameter("logout") != null && request.getParameter("logout").equals("logout")){
			HttpSession session = request.getSession(false);
			session.setAttribute("currentUser", null);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			if (session.getAttribute("currentUser") != null){
				request.getRequestDispatcher("PantallaCliente.jsp").forward(request, response);
			}
	}
	
	
}