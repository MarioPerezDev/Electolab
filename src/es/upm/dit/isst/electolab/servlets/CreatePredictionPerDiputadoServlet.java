package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.DiputadoDAOImplementation;
import es.upm.dit.isst.electolab.dao.LeyDAOImplementation;
import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.electolab.dao.VotacionPorDiputadoDAOImplementation;
import es.upm.dit.isst.electolab.model.Diputado;
import es.upm.dit.isst.electolab.model.Ley;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.Usuario;
import es.upm.dit.isst.electolab.model.VotacionPorDiputado;
import es.upm.dit.isst.electolab.model.VotacionPorGrupo;
import es.upm.dit.isst.electolab.model.VotacionPorPartido;

/**
 * Servlet implementation class CreatePredictionPerPartidoServlet
 */
@WebServlet("/CreatePredictionPerDiputadoServlet")
public class CreatePredictionPerDiputadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePredictionPerDiputadoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("typeOfPrediction");
		Usuario usuarioQueCrea = UsuarioDAOImplementation.getInstance().read(Integer.parseInt(req.getParameter("ownUserId")));
		Ley ley = LeyDAOImplementation.getInstance().read(Integer.parseInt(req.getParameter("leyId")));


		DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
		Date date = new Date();

		Prediccion prediccion = new Prediccion();
		prediccion.setFecha(dateFormat.format(date));
		prediccion.setLey(ley);
		prediccion.setAnalista(usuarioQueCrea);
		PrediccionDAOImplementation.getInstance().create(prediccion);


		//Calculo de votos

		int votosFavor = 0;
		int votosContra = 0;
		int abstenciones = 0;

		for(int i= 1; i<DiputadoDAOImplementation.getInstance().readAll().size()+1; i++) {
			String voto = req.getParameter("voto"+Integer.toString(i));
			Diputado diputado = DiputadoDAOImplementation.getInstance().read(i);
			if(voto.equals("favor")) {
				votosFavor++;
			}
			if(voto.equals("contra")) {
				votosContra++;
			}
			if(voto.equals("abstencion")) {
				abstenciones++;
			}

			VotacionPorDiputado votacionpordiputado = new VotacionPorDiputado();
			votacionpordiputado.setDiputado(diputado);
			votacionpordiputado.setVoto(voto);
			votacionpordiputado.setPrediccion(PrediccionDAOImplementation.getInstance().read(prediccion.getId()));
			VotacionPorDiputadoDAOImplementation.getInstance().create(votacionpordiputado);


		}		

		HashMap<String, Integer> votos = new HashMap<String, Integer>();
		votos.put("favor",votosFavor);	
		votos.put("contra",votosContra);	
		votos.put("abstenciones",abstenciones);	

		req.getSession().setAttribute("predicciones",PrediccionDAOImplementation.getInstance().readAll());
		Prediccion currentPrediction = PrediccionDAOImplementation.getInstance().read(prediccion.getId());
		req.getSession().setAttribute("currentPrediction", currentPrediction);

		req.getSession().setAttribute("currentPredictionVotos", votos);

		getServletContext().getRequestDispatcher("/Prediccion.jsp").forward(req,resp);
	}


}
