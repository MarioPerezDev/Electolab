package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.DiputadoDAOImplementation;
import es.upm.dit.isst.electolab.dao.GrupoParlamentarioDAOImplementation;
import es.upm.dit.isst.electolab.dao.LeyDAOImplementation;
import es.upm.dit.isst.electolab.dao.PartidoDAOImplementation;
import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.GrupoParlamentario;
import es.upm.dit.isst.electolab.model.Ley;
import es.upm.dit.isst.electolab.model.Partido;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class PaginationServlet
 */
@WebServlet("/PaginationServlet")
public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;





	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaginationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().removeAttribute("mensaje");
		req.getSession().removeAttribute("typeOfPrediction");
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
		if(req.getSession().getAttribute("predicciones") == null) {
			List<Prediccion> predicciones = (List<Prediccion>) PrediccionDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("predicciones", predicciones);
		}
		if(req.getSession().getAttribute("gruposparlamentarios") == null) {
			List<GrupoParlamentario> gruposparlamentarios = (List<GrupoParlamentario>) GrupoParlamentarioDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("gruposparlamentarios", gruposparlamentarios);
		}
		if(req.getSession().getAttribute("leyes") == null) {
			List<Ley> leyes = (List<Ley>) LeyDAOImplementation.getInstance().readAll();
			req.getSession().setAttribute("leyes", leyes);
		}
		if(req.getParameter("infoLink") != null) {
			req.getSession().setAttribute("currentPage", 1);
		}
		
		List<Prediccion> predicciones = (List<Prediccion>) PrediccionDAOImplementation.getInstance().readAll();
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
		req.getSession().setAttribute("active", "Predicciones");
		getServletContext().getRequestDispatcher("/Predicciones.jsp").forward(req,resp);
	}

}
