<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file = "Head.jsp" %>
<body>
   <%@ include file = "Navbar.jsp" %>
   <div class="container">
	<h1>Esta será la página para un admin.</h1>
	<h2>Analistas pendientes de confirmación</h2>
		<c:forEach items="${usuarios}" var="usuarioi">
		
		<c:if test="${not usuarioi.accepted}">
			<table>
				<tr>
					<td>${usuarioi.name}</td>
					<td>${usuarioi.email}</td>

					<td>				
						<form action="AcceptAnalistServlet">
							<input type="hidden" name="userid" value="${usuarioi.id}" />
							<button type="submit" class="btn btn-outline-dark btn-sm">Aceptar analista</button>
						</form>
					</td>
				</tr>
			</table>
		</c:if>
		</c:forEach>
		</div>
	<%@ include file = "Variables.jsp" %>
</body>
</html>