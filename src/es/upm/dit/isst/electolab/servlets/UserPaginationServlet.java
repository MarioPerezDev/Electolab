package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class UserPaginationServlet
 */
@WebServlet("/UserPaginationServlet")
public class UserPaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPaginationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().removeAttribute("active");
		req.getSession().removeAttribute("mensaje");
		req.getSession().removeAttribute("typeOfPrediction");
		Integer userId = Integer.parseInt(req.getParameter("userId"));
		Usuario usuario = UsuarioDAOImplementation.getInstance().read(userId);
		List<Prediccion> predicciones = (List<Prediccion>) usuario.getDonePredicciones();
		int page = 1;
		int recordsPerPage = 5;
		int noOfRecords =predicciones.size();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		if(req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		int remaining = noOfRecords - recordsPerPage*(page-1);
		if (remaining > recordsPerPage) {
			List<Prediccion> newList = predicciones.subList(recordsPerPage*(page-1),recordsPerPage*page);	
			req.getSession().setAttribute("noOfPages", noOfPages);
			req.getSession().setAttribute("currentPage", page);
			req.getSession().setAttribute("prediccionesPag", newList);
		} else {
			List<Prediccion> newList = predicciones.subList(recordsPerPage*(page-1),noOfRecords);
			req.getSession().setAttribute("noOfPages", noOfPages);
			req.getSession().setAttribute("currentPage", page);
			req.getSession().setAttribute("prediccionesPag", newList);
		}
		getServletContext().getRequestDispatcher("/Usuario.jsp").forward(req,resp);
	}
}
