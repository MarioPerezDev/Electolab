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
		<h1>Información</h1>
		<div class="row">
			<h2>
				<div class="col-12">Seleccione la información a la que quiere
					acceder</div>
			</h2>
			<div class="col-6"><h3>Partidos Políticos</h3></div>
			<div class="col-6"><h3>Leyes Pasadas</div>

			<div class="col-6">
				<c:forEach items="${partidos}" var="partidoi">
					<div class="pruebagonzalo">
						${partidoi.nombre}
						<form class="form-inline my-2 my-lg-0"
							action="InfoPartidosServlet">
							<button type="submit" class="btn btn-outline-dark">Entrar</button>
						</form>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>