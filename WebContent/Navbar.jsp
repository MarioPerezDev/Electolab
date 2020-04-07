<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ include file="Variables.jsp"%>
<link rel="stylesheet" href="Styles.css">
<!-- Navbar -->

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="NavigationServlet?infoLink=index">Home</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<c:choose>
				<c:when test="${ active == 'Info'}">
					<li class="nav-item active activo" id="infoLink">
				</c:when>
				<c:otherwise>
					<li class="nav-item" id="infoLink">
				</c:otherwise>
			</c:choose>
			<a class="nav-link" href="NavigationServlet?infoLink=Info">Información</a>
			</li>
			<c:choose>
				<c:when test="${ active == 'Predicciones'}">
					<li class="nav-item active activo" id="predictionsLink">
				</c:when>
				<c:otherwise>
					<li class="nav-item" id="predictionsLink">
				</c:otherwise>
			</c:choose>
			<a class="nav-link" href="NavigationServlet?infoLink=Predicciones">Predicciones</a>
			</li>
			<c:choose>
				<c:when test="${ active == 'AboutUs'}">
					<li class="nav-item active activo" id="aboutUsLink">
				</c:when>
				<c:otherwise>
					<li class="nav-item" id="aboutUsLink">
				</c:otherwise>
			</c:choose>
			<a class="nav-link" href="NavigationServlet?infoLink=AboutUs">Sobre
				Nosotros</a>
			</li>
			<li class="nav-item" id="helpLink"><c:choose>
					<c:when test="${ active == 'Help'}">
						<li class="nav-item active activo" id="helpLink">
					</c:when>
					<c:otherwise>
						<li class="nav-item" id="helpLink">
					</c:otherwise>
				</c:choose><a class="nav-link" href="NavigationServlet?infoLink=Help">Ayuda</a></li>
		</ul>
		<c:choose>
			<c:when test="${ null != usuario}">
				<a id="texto" href="NavigationServlet?infoLink=Usuario" class="usernameText">${usuario.name}</a>
				<form action="LogoutServlet">
					<button type="submit" class="btn btn-outline-light btn-sm">Salir</button>
				</form>
			</c:when>
			<c:when test="${ null != admin}">
				<a href="NavigationServlet?infoLink=Admin" id="texto" class="usernameText">Admin</a>
				<form action="LogoutServlet">
					<button type="submit" class="btn btn-outline-light btn-sm">Salir</button>
				</form>
			</c:when>
			<c:otherwise>
				<form class="form-inline my-2 my-lg-0">
					<button type="button" class="btn btn-outline-light btn-sm"
						data-toggle="modal" data-target="#exampleModalCenter">Entrar</button>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</nav>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Log In o
					Registro</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="FormLoginServlet">
					<div class="form-group">
						<label for="emailinput">Correo electrónico</label> <input
							type="email" class="form-control" name="email" id="emailinput"
							aria-describedby="emailHelp" placeholder="Introduzca su email">
					</div>
					<div class="form-group">
						<label for="passwordinput">Contraseña</label> <input
							type="password" class="form-control" name="password"
							id="passwordinput" placeholder="Introduzca su contraseña">
					</div>
			</div>
			<div class="modal-footer">
				¿No tienes cuenta? Haz click <a href="NavigationServlet?infoLink=Register"
					name="registerButton">Registrarse</a> <input type="submit"
					value="Login" name="loginButton" class="btn btn-outline-light btn-sm">
			</div>
			</form>
		</div>
	</div>
</div>