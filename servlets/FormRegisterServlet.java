package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.AnalistaDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Analista;
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
		String password = req.getParameter("password1");
		String username = req.getParameter("username");
		if(req.getParameter("analistcheck") != null) {
		Analista analista = new Analista();
		analista.setEmail(email);
		analista.setPassword(password);
		analista.setName(username);
		AnalistaDAOImplementation.getInstance().create(analista);
		req.getSession().setAttribute("analista", analista);
		} else {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setName(username);
		UsuarioDAOImplementation.getInstance().create(usuario);
		req.getSession().setAttribute("usuario", usuario);
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}
