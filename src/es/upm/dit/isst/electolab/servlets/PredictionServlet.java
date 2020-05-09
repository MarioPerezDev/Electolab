package es.upm.dit.isst.electolab.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.electolab.dao.PrediccionDAOImplementation;
import es.upm.dit.isst.electolab.model.Prediccion;
import es.upm.dit.isst.electolab.model.VotacionPorDiputado;
import es.upm.dit.isst.electolab.model.VotacionPorGrupo;
import es.upm.dit.isst.electolab.model.VotacionPorPartido;

/**
 * Servlet implementation class PredictionServlet
 */
@WebServlet("/PredictionServlet")
public class PredictionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredictionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer prediccionid = Integer.parseInt(req.getParameter("prediction"));
		Prediccion currentPrediction = PrediccionDAOImplementation.getInstance().read(prediccionid);
		
		int votosFavor = 0;
		int votosContra = 0;
		int abstenciones = 0;

		if(!currentPrediction.getVotacionesGrupo().isEmpty()) {
			List<VotacionPorGrupo> votaciones = (List<VotacionPorGrupo>) currentPrediction.getVotacionesGrupo();
			 for (VotacionPorGrupo votacion : votaciones) {
				 if(votacion.getVoto().equals("favor")) {
						votosFavor++;
					}
					if(votacion.getVoto().equals("contra")) {
						votosContra++;
					}
					if(votacion.getVoto().equals("abstencion")) {
						abstenciones++;
					}
		        }	
			}	
		if(!currentPrediction.getVotacionesPartido().isEmpty()) {
			List<VotacionPorPartido> votaciones = (List<VotacionPorPartido>) currentPrediction.getVotacionesPartido();
			 for (VotacionPorPartido votacion : votaciones) {
				 if(votacion.getVoto().equals("favor")) {
						votosFavor++;
					}
					if(votacion.getVoto().equals("contra")) {
						votosContra++;
					}
					if(votacion.getVoto().equals("abstencion")) {
						abstenciones++;
					}
		        }	
		}
		if(!currentPrediction.getVotacionesDiputado().isEmpty()) {
			List<VotacionPorDiputado> votaciones = (List<VotacionPorDiputado>) currentPrediction.getVotacionesDiputado();
			 for (VotacionPorDiputado votacion : votaciones) {
				 if(votacion.getVoto().equals("favor")) {
						votosFavor++;
					}
					if(votacion.getVoto().equals("contra")) {
						votosContra++;
					}
					if(votacion.getVoto().equals("abstencion")) {
						abstenciones++;
					}
		        }
			 int step = votaciones.size()/350;
			 votosFavor= votosFavor/step;
			 votosContra= votosContra/step;
			 abstenciones= abstenciones/step;
			 req.getSession().setAttribute("step", step);
		}
				
		HashMap<String, Integer> votos = new HashMap<String, Integer>();
		votos.put("favor",votosFavor);	
		votos.put("contra",votosContra);	
		votos.put("abstenciones",abstenciones);	
		
		req.getSession().setAttribute("currentPrediction", currentPrediction);
		req.getSession().setAttribute("currentPredictionVotos", votos);
		getServletContext().getRequestDispatcher("/Prediccion.jsp").forward(req,resp);
	}


}
