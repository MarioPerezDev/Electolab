package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
		if(req.getSession().getAttribute("templeyes") == null) {	
			List<Ley> leyes = new ArrayList<Ley>();
			leyes.add(LeyDAOImplementation.getInstance().read(1));
			leyes.add(LeyDAOImplementation.getInstance().read(5));	
			leyes.add(LeyDAOImplementation.getInstance().read(11));	
			leyes.add(LeyDAOImplementation.getInstance().read(13));	
			leyes.add(LeyDAOImplementation.getInstance().read(14));	
			leyes.add(LeyDAOImplementation.getInstance().read(15));	
			req.getSession().setAttribute("templeyes", leyes);
		}
		req.getSession().setAttribute("typeOfPrediction", type);
		getServletContext().getRequestDispatcher("/CreatePrediction.jsp").forward(req, resp);
	}

}
