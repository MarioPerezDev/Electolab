<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file="Head.jsp"%>
<%@ include file="Variables.jsp"%>
<body>
	<%@ include file="Navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<img width="500" height="300"
					src="${partido.logo}">
			</div>
			<div class="col-6">

				<h2>Información del ${partido.nombre}</h2>

				
			</div>

		</div>
		<p>${partido.descripcion}</p>
		
	</div>
</body>