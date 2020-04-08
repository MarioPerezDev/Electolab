package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.PartidoDAOImplementation;
import es.upm.dit.isst.electolab.model.Partido;

@WebServlet("/InfoPartidosServlet")
public class InfoPartidosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoPartidosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer partidoActivo = Integer.parseInt(req.getParameter("infoPartido"));
		System.out.println(partidoActivo);
		Partido partido = PartidoDAOImplementation.getInstance().read(partidoActivo);
		req.getSession().setAttribute("partido", partido);

		getServletContext().getRequestDispatcher("/InfoPartidos.jsp").forward(req,resp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
