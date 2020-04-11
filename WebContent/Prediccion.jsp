<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file="Head.jsp"%>
<body>
	<%@ include file="Navbar.jsp"%>
	<div class="container">

		<h1 class="predictionAnouncer">Datos de la predicción sobre
			${currentPrediction.ley.nombre}</h1>
		<div class="row">
			<div class="col-9">
				<h4>${currentPrediction.analista.name}
					(${currentPrediction.fecha})</h4>
				<ul>
					<c:if test="${ null != currentPrediction.votacionesGrupo}">
						<c:forEach items="${currentPrediction.votacionesGrupo}"
							var="votacioni" varStatus="loop">
							<li>Voto de ${votacioni.grupoParlamentario.nombre} :
								${votacioni.voto}</li>
						</c:forEach>
					</c:if>
					<c:if test="${ null != currentPrediction.votacionesPartido}">
						<c:forEach items="${currentPrediction.votacionesPartido}"
							var="votacioni">
							<li>Voto de ${votacioni.partido.nombre} : ${votacioni.voto}</li>
						</c:forEach>
					</c:if>
					<c:if test="${ null != currentPrediction.votacionesDiputado}">
						<c:forEach items="${currentPrediction.votacionesDiputado}"
							var="votacioni" varStatus="loop">
							<li>Voto de ${votacioni.diputado.nombre} : ${votacioni.voto}</li>
						</c:forEach>
					</c:if>
				</ul>
				<div class="zonaVotos row">
					<div class="votosFavor">Votos totales a favor:
						${currentPredictionVotos.get("favor")}</div>
					<div class="votosContra">Votos totales en contra:
						${currentPredictionVotos.get("contra")}</div>
					<div class="abstenciones">Abstenciones totales:
						${currentPredictionVotos.get("abstenciones")}</div>
				</div>


				<c:choose>
					<c:when
						test="${currentPredictionVotos.get('favor') ge ((currentPredictionVotos.get('favor') + currentPredictionVotos.get('contra') + currentPredictionVotos.get('abstenciones'))/2) }">
						<div class="mayoriaAbsoluta">Resultado:Mayoria absoluta</div>
					</c:when>
					<c:when
						test="${currentPredictionVotos.get('favor') gt currentPredictionVotos.get('contra') }">
						<div class="mayoriaSimple">Resultado:Mayoria simple</div>
					</c:when>
					<c:otherwise>
						<div class="rechazo">Rechazada</div>
					</c:otherwise>
				</c:choose>
			</div>
			<%@ include file="ZonaUsuario.jsp"%>
		</div>
		<%@ include file="Variables.jsp"%>
</body>
</html>