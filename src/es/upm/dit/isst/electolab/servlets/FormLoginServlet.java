package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.DiputadoDAOImplementation;
import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final String ADMIN_EMAIL = "electolab@gmail.com";
	private final String ADMIN_PASSWORD = "electolab";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		List<Prediccion> predicciones = (List<Prediccion>) PrediccionDAOImplementation.getInstance().readAll();
		List<Usuario> usuarios = (List<Usuario>) UsuarioDAOImplementation.getInstance().readAll();
		
		Usuario usuario = UsuarioDAOImplementation.getInstance().login(email, password);
		req.getSession().setAttribute("usuarios", usuarios);
		req.getSession().setAttribute("predicciones", predicciones);
		
		if(ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
			req.getSession().setAttribute("admin", true);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		}else if ( null != usuario ) {
			req.getSession().setAttribute("usuario", UsuarioDAOImplementation.getInstance().read(usuario.getId()));
			getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
