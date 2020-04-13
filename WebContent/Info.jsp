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

		<div class="text-center">
			<h1>Información</h1>
			<h2>Seleccione la información a la que quiere acceder</h2>
		</div>
		<div class="row">
			<div class="col-12 col-md-6 text-center">
				<h3 class="cabecera">Partidos Políticos</h3>
				<div class="row">
					<div class="col-12 col-md-4 text-center columna">
						<c:forEach items="${partidos}" var="partidoi">
							<c:if test="${partidoi.id <= 8}">
								<div class="partido">
									<a href="InfoPartidosServlet?infoPartido=${partidoi.id}">
										<div class="text-center">
											${partidoi.siglas} <img class="imgRedonda" align="middle"
												src="${partidoi.logo}">
										</div>
									</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="col-12 col-md-4 text-center columna">
						<c:forEach items="${partidos}" var="partidoi">
							<c:if test="${partidoi.id > 8 && partidoi.id<= 16}">
								<div class="partido">
									<a href="InfoPartidosServlet?infoPartido=${partidoi.id}">
										<div class="text-center">
											${partidoi.siglas} <img class="imgRedonda" align="middle"
												src="${partidoi.logo}">
										</div>
									</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
					<div class="col-12 col-md-4 text-center columna">
						<c:forEach items="${partidos}" var="partidoi">
							<c:if test="${partidoi.id > 16}">
								<div class="partido">
									<a href="InfoPartidosServlet?infoPartido=${partidoi.id}">
										<div class="text-center">
											${partidoi.siglas} <img class="imgRedonda" align="middle"
												src="${partidoi.logo}">
										</div>
									</a>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-12 col-md-6 text-center">
				<h3>Leyes Pasadas</h3>
				<div class="row text-center">
					<div class="col-12 text-center columna">
						<c:forEach items="${leyes}" var="leyi">
							<a class="text-center" href="InfoLeyesServlet?infoLey=${leyi.id}">
								<div class="singleLey">${leyi.nombre} del ${leyi.fecha}</div>
							</a>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>