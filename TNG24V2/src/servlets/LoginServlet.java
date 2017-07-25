package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistencia.DAOUsuarios;
import core.UserSession;

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

				UserSession userSession = DAOUsuarios.getInstancia().login(usuario, contraseña);
				if (userSession != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("currentUser", usuario);
					session.setAttribute("rol", userSession.getRole());
					session.setAttribute("userId", userSession.getId());
					System.out.println("***************" + userSession.getId());
					
					if(userSession.getRole().equals("TEC")){
						// TODO TODO REDIRECCIONAR A PANTALLA DEL TECNICO
						request.getRequestDispatcher("PantallaCliente.jsp").forward(request, response);
					}
					else if (userSession.getRole().equals("CTO")){
						
						// TODO REDIRECCIONAR A PANTALLA DE LA COORDINADORA
						request.getRequestDispatcher("PantallaCliente.jsp").forward(request, response);
					}
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