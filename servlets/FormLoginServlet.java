package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.AnalistaDAOImplementation;
import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.model.Analista;
import es.upm.dit.isst.electolab.model.Prediccion;

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
		boolean registerButtonPressed = (req.getParameter("registerButton") != null);
		if ( registerButtonPressed ) {
			getServletContext().getRequestDispatcher("/Register.jsp").forward(req,resp);
		} else {
		String email = req.getParameter("email");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		boolean passwordsSame = (password1.compareTo(password2) == 0);
		List<Analista> analistas = (List<Analista>) AnalistaDAOImplementation.getInstance().readAll();
		List<Prediccion> predicciones = (List<Prediccion>) PrediccionDAOImplementation.getInstance().readAll();
		Analista analista = AnalistaDAOImplementation.getInstance().login(email, password1);
		if(passwordsSame && ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password1) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("analistas", analistas);
			req.getSession().setAttribute("predicciones", predicciones);
			getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
		} else if ( null != analista ) {
			req.getSession().setAttribute("analista", AnalistaDAOImplementation.getInstance().read(analista.getEmail()));
			getServletContext().getRequestDispatcher("/Analista.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
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
