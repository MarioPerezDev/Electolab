<!doctype html>
<html lang="es">
<%@ include file = "Head.jsp" %>

  <body>
   <%@ include file = "Navbar.jsp" %>

    
    <!-- Cuerpo de la p�gina -->
    <div class="container">
   		<c:if test="${mensaje != null}">
			<div class="alert alert-danger" role="alert">
			${mensaje}</div>
		</c:if>
      <div class="row">
        <div class="col-12 col-md-6 text-center">
          <h1>Hello, INDEX!</h1>
          <p>Esto es una columna que se podr� cambiar.</p>
        </div>
        <div class="col-12 col-md-6 text-center">
          <h1>Hello, INDEX!</h1>
          <p>Esto es una columna que se podr� cambiar.</p>
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-md-6 text-center">
          <h1>Hello, INDEX!</h1>
          <p>Esto es una columna que se podr� cambiar.</p>
        </div>
        <div class="col-12 col-md-6 text-center">
          <h1>Hello, INDEX!</h1>
          <p>Esto es una columna que se podr� cambiar.</p>
        </div>
      </div>
    </div>
 	<%@ include file = "Variables.jsp" %>
  </body>
