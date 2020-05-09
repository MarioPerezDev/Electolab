<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html lang="es">
<%@ include file="Head.jsp"%>

<body>
	<%@ include file="Navbar.jsp"%>
	<div class="container">

		<h1>Introduzca los datos para crear una predicción</h1>
		<div class="row">
			<div class="col-9">
				<c:if test="${(usuario.analist and usuario.accepted) or admin == true}">
					<c:if test="${typeOfPrediction == null}">
						<Form action="TypeSelectionServlet">
							<select name="eleccion" class="form-control typeSelection">
								<option value="perGrupo">Por grupo</option>
								<option value="perPartido">Por partido</option>
								<option value="perDiputado">Por diputado</option>
							</select>
							<button type="submit" class="btn btn-outline-dark btn-sm">Elegir
								tipo</button>
						</Form>
					</c:if>
					<c:choose>
						<c:when test="${ typeOfPrediction == 'perGrupo'}">
							<%@ include file="PerGroup.jsp"%>
						</c:when>
						<c:when test="${ typeOfPrediction == 'perPartido'}">
							<%@ include file="PerPartido.jsp"%>
						</c:when>
						<c:when test="${ typeOfPrediction == 'perDiputado'}">
							<%@ include file="PerDiputado.jsp"%>
						</c:when>
					</c:choose>

				</c:if>
			</div>
			<%@ include file="ZonaUsuario.jsp"%>
		</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
</body>
</html>