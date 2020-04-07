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
		<h1>Esta ser� la p�gina de ${active}.</h1>


		<div class="row">
			<div class="col-12 col-md-6 col-lg-3 columna1">En esta columna
				ir�n todas las predicciones existentes.</div>
			<div class="col-12 col-md-6 col-lg-3 columna2">En esta columna
				ir� la segunda parte</div>
			<div class="col-12 col-md-6 col-lg-3 columna1">En esta columna
				ir�n todas las predicciones existentes.</div>
			<div class="col-12 col-md-6 col-lg-3 columna2">En esta columna
				ir� la segunda parte</div>
		</div>

	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>