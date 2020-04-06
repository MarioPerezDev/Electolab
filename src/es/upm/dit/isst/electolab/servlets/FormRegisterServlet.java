package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Usuario;


/**
 * Servlet implementation class FormRegisterServlet
 */
@WebServlet("/FormRegisterServlet")
public class FormRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String email = req.getParameter("email");
		//Aqui falta comprobar que la contraseña coincide
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		boolean passwordsSame = (password1.compareTo(password2) == 0);
		if(passwordsSame){
		String username = req.getParameter("username");
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password1);
		usuario.setName(username);
		if(req.getParameter("analistcheck") != null) {
		usuario.setAnalist(true);
		usuario.setAccepted(false);
		} else {
			usuario.setAnalist(false);
			usuario.setAccepted(true);
		}try {
		UsuarioDAOImplementation.getInstance().create(usuario);
		req.getSession().setAttribute("usuario", usuario);
		req.getSession().removeAttribute("mensaje");
		} catch (Exception existing) {
			String mensaje = "Ese nombre de usuario o correo electrónico ya existe.";
			req.getSession().setAttribute("mensaje", mensaje);
			getServletContext().getRequestDispatcher("/Register.jsp").forward(req, resp);
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		} else {
			getServletContext().getRequestDispatcher("/Register.jsp").forward(req, resp);
		}
	}

}
