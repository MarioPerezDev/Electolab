package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.DiputadoDAOImplementation;
import es.upm.dit.isst.electolab.dao.LeyDAOImplementation;
import es.upm.dit.isst.electolab.dao.PartidoDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.Ley;
import es.upm.dit.isst.electolab.model.Partido;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("mensaje");
		String active = req.getParameter("infoLink");
		req.getSession().setAttribute("active", active);
		if(req.getSession().getAttribute("diputados") == null) {
			List<Diputado> diputados = (List<Diputado>) DiputadoDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("diputados", diputados);
		}
		if(req.getSession().getAttribute("partidos") == null) {
			List<Partido> partidos = (List<Partido>) PartidoDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("partidos", partidos);
		}
		if(req.getSession().getAttribute("leyes") == null) {
			List<Ley> leyes = (List<Ley>) LeyDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("leyes", leyes);
		}
		getServletContext().getRequestDispatcher("/"+active+".jsp").forward(req,resp);
	}
}
