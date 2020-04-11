package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.LeyDAOImplementation;
import es.upm.dit.isst.electolab.model.Ley;

/**
 * Servlet implementation class TypeSelectionServlet
 */
@WebServlet("/TypeSelectionServlet")
public class TypeSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TypeSelectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("eleccion");
		if(req.getSession().getAttribute("leyes") == null) {
			List<Ley> leyes = (List<Ley>) LeyDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("leyes", leyes);
		}
		req.getSession().setAttribute("typeOfPrediction", type);
		getServletContext().getRequestDispatcher("/CreatePrediction.jsp").forward(req, resp);
	}

}
