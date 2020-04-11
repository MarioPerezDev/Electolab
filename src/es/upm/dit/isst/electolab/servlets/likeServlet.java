package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.Usuario;

/**
 * Servlet implementation class likeServlet
 */
@WebServlet("/likeServlet")
public class likeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public likeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Obtenemos la prediccion y el usuario
		Integer prediccionid = Integer.parseInt(req.getParameter("predictionId"));
		Integer usuarioid = Integer.parseInt(req.getParameter("userId"));
		Prediccion currentPrediction = PrediccionDAOImplementation.getInstance().read(prediccionid);
		Usuario currentUsuario = UsuarioDAOImplementation.getInstance().read(usuarioid);
		
		//Obtenemos los usuarios que ya habían dado like y dislike a esta prediccion
		List<Usuario> usuariosConDislike = (List<Usuario>) currentPrediction.getUsuariosQueDieronDislike();
		List<Usuario> usuariosConLike = (List<Usuario>) currentPrediction.getUsuariosQueDieronLike();
		
		//Si este usuario tenía dislike, se elimina su dislike y se le añade el like
		if(usuariosConDislike.contains(currentUsuario)) {
			currentPrediction.removeUserDislike(currentUsuario);
		}
		try {
		currentPrediction.addUserLike(currentUsuario);
		PrediccionDAOImplementation.getInstance().update(currentPrediction);
		req.getSession().setAttribute("predicciones",PrediccionDAOImplementation.getInstance().readAll());
		getServletContext().getRequestDispatcher("/Predicciones.jsp").forward(req,resp);
		} catch (Exception e) {
			getServletContext().getRequestDispatcher("/Predicciones.jsp").forward(req,resp);
		}
		getServletContext().getRequestDispatcher("/Predicciones.jsp").forward(req,resp);
	}	

}
