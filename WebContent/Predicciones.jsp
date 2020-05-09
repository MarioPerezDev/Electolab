<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file="Head.jsp"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<%@ include file="Navbar.jsp"%>
	<div class="container">
		<h1>Predicciones registradas</h1>
		<c:choose>
			<c:when test="${usuario != null or admin== true}">
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
									<c:when test="${ not prediccioni.votacionesDiputado.isEmpty()}">
									[Por Diputado]
								</c:when>
								</c:choose>
								<br>
								<Form class="likeform" action="dislikeServlet">
									<input type="hidden" name="userId" value="${usuario.id}" /> <input
										type="hidden" name="predictionId" value="${prediccioni.id}" />
									<c:choose>
										<c:when
											test="${prediccioni.analista.id == Integer.parseInt(usuario.id)}">
											<button type="submit" name="likebutton" disabled
												class="btn btn-outline-dark">${prediccioni.usuariosQueDieronDislike.size()}<i
													style="font-size: 24px" class="fa">&#xf165;</i>
											</Button>
										</c:when>
										<c:otherwise>
											<button type="submit" name="likebutton"
												class="btn btn-outline-dark">${prediccioni.usuariosQueDieronDislike.size()}<i
													style="font-size: 24px" class="fa">&#xf165;</i>
											</Button>
										</c:otherwise>
									</c:choose>
								</Form>
								<Form class="likeform" action="likeServlet">
									<input type="hidden" name="userId" value="${usuario.id}" /> <input
										type="hidden" name="predictionId" value="${prediccioni.id}" />
									<c:choose>
										<c:when
											test="${prediccioni.analista.id == Integer.parseInt(usuario.id)}">
											<button type="submit" name="likebutton" disabled
												class="btn btn-outline-dark">${prediccioni.usuariosQueDieronLike.size()}<i
													style="font-size: 24px" class="fa">&#xf087;</i>
											</Button>
										</c:when>
										<c:otherwise>
											<button type="submit" name="likebutton"
												class="btn btn-outline-dark">${prediccioni.usuariosQueDieronLike.size()}<i
													style="font-size: 24px" class="fa">&#xf087;</i>
											</Button>
										</c:otherwise>
									</c:choose>
								</Form>
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

					<%@ include file="ZonaUsuario.jsp"%>
				</div>
			</c:when>
			<c:otherwise>
				<h3>
					Para visualizar el contenido debes loguearte.
					</h2>
			</c:otherwise>
		</c:choose>


	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>