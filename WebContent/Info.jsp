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
		<h1>Informaci�n</h1>
		<div class="row">
			<h2>
				<div class="col-12">Seleccione la informaci�n a la que quiere
					acceder</div>
			</h2>
			<div class="col-12 col-md-6 text-center">
				<h3>Partidos Pol�ticos</h3>
			</div>
			<div class="col-12 col-md-6 text-center">
				<h3>Leyes Pasadas</h3>
			</div>

			<div class="col-12 col-md-6 text-center">
				<table class="table table-striped" >
				<thead>
				<tr>
					<td>
					<c:forEach items="${partidos}" var="partidoi">
					<c:if test="${partidoi.id < 12 || partdidoi.id > 1}">
						<div>
							${partidoi.nombre}
							<div class="text-center">
							<form class="form-inline my-2 my-lg-0"
								action="InfoPartidosServlet">
								<input type="hidden" name="infoPartido" value="${partidoi.id}" />
								<div class="text-center">
								<button type="submit" name="button${partidoi.id}"
									class="btn btn-outline-dark">Informaci�n</button>
								</div>
	
							</form>
							</div>
						</div>
					</c:if>
					</c:forEach>
					</td>
					<td>
					<c:forEach items="${partidos}" var="partidoi">
					<c:if test="${partidoi.id > 12}">
						<div>
							<div align = center>${partidoi.nombre}</div>
							<form class="form-inline my-2 my-lg-0"
								action="InfoPartidosServlet">
								<input type="hidden" name="infoPartido" value="${partidoi.id}" />
								<div class="text-center">
								<button type="submit" name="button${partidoi.id}"
									class="btn btn-outline-dark">Informaci�n</button>
								</div>
	
							</form>
						</div>
					</c:if>
					</c:forEach>
					</td>
				</tr>
				</thead>
				</table>
			</div>
			<div class="col-12 col-md-6 text-center">
				<table class="table table-striped">
				<thead>
				<tr>
					<td>
					<c:forEach items="${leyes}" var="leyi">
						<div>
							${leyi.nombre}
							<form class="form-inline my-2 my-lg-0" action="InfoLeyesServlet">
								<input type="hidden" name="infoLey" value="${leyi.id}" />
								<button type="submit" name="${leyi.id}"
								class="btn btn-outline-dark">Informaci�n</button>
							</form>
						</div>
					</c:forEach>
					</td>
				</tr>
				</thead>
				</table>
			</div>

		</div>
	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>