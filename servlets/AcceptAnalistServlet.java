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
 * Servlet implementation class AcceptAnalistServlet
 */
@WebServlet("/AcceptAnalistServlet")
public class AcceptAnalistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptAnalistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("userid"));
		Usuario usuario = UsuarioDAOImplementation.getInstance().read(id);
		usuario.setAccepted(true);
		UsuarioDAOImplementation.getInstance().update(usuario);
		req.getSession().setAttribute("usuarios",UsuarioDAOImplementation.getInstance().readAll());
		getServletContext().getRequestDispatcher("/Admin.jsp").forward(req,resp);
	}

}
