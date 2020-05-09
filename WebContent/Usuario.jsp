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
		<c:if test="${prediccionesPag == null}">
			<h1>No hay predicciones de ${usuario.name} registradas todavía</h1>
		</c:if>
		<c:if test="${prediccionesPag != null}">

			<h1>Predicciones de ${usuario.name} registradas</h1>
			<c:choose>
				<c:when test="${usuario != null}">
					<div class="row text-justify">
						<div class="col-12 col-md-9">
							<c:if test="${mensaje != null}">
								<div class="alert alert-danger" role="alert">${mensaje}</div>
							</c:if>
							<c:forEach items="${prediccionesPag}" var="prediccioni">
								<div class="predictionZone">
									<a href="PredictionServlet?prediction=${prediccioni.id}">
										Predicción creada por ${prediccioni.analista.name} sobre
										${prediccioni.ley.nombre} (${prediccioni.fecha})</a>
									<c:choose>
										<c:when test="${ not prediccioni.votacionesGrupo.isEmpty()}">
									[Por Grupo]
								</c:when>
										<c:when test="${ not prediccioni.votacionesPartido.isEmpty()}">
									[Por Partido]
								</c:when>
										<c:when
											test="${ not prediccioni.votacionesDiputado.isEmpty()}">
									[Por Diputado]
								</c:when>
									</c:choose>
									<br>
								</div>
							</c:forEach>


							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:if test="${currentPage != 1}">
										<li class="page-item"><a class="page-link"
											href="PaginationServlet?page=${currentPage - 1}">Anterior</a></li>
									</c:if>
									<c:forEach begin="1" end="${noOfPages}" var="i">
										<c:choose>
											<c:when test="${currentPage eq i}">
												<li class="page-item active"><div class="page-link">${i}</div></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="PaginationServlet?page=${i}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${currentPage lt noOfPages}">
										<li class="page-item"><a class="page-link"
											href="PaginationServlet?page=${currentPage + 1}">Next</a></li>
									</c:if>
								</ul>
							</nav>
						</div>

						<div class="col-12 col-md-3">
							<div class="userLogedArea">
								<h3 class="userLogedAreaTitle">Usuario</h3>
								<c:choose>
									<c:when test="${admin == true}">
										<p>Nombre de usuario: Admin</p>
									</c:when>
									<c:otherwise>
										<p>Nombre de usuario: ${usuario.name}</p>
										<p>Correo: ${usuario.email}</p>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${admin == true}">
										<p>Rango: Admin</p>
										<a href="PrepareToCreateAgainServlet"><button
												class="btn btn-outline-light btn-sm">Crear
												predicción</button></a>
										<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
									</c:when>
									<c:when test="${usuario.analist}">
										<p>Rango: Analista</p>
										<c:if test="${usuario.analist and usuario.accepted}">
											<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
										</c:if>
									</c:when>
									<c:otherwise>
										<p>Rango: Usuario</p>
										<a style="margin-left: 0px;" href="LogoutServlet">Salir</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<h3>
						Para visualizar el contenido debes loguearte.
						</h2>
				</c:otherwise>
			</c:choose>
		</c:if>

	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>