<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<%@ include file = "Head.jsp" %>
<body>
 	<%@ include file = "Navbar.jsp" %>
		<h1>Esta ser� la p�gina de ${active}.</h1>
	<%@ include file = "Variables.jsp" %>
</body>
</html>