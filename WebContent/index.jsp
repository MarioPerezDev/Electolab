<!doctype html>
<html lang="es">
<%@ include file = "Head.jsp" %>

  <body>
   <%@ include file = "Navbar.jsp" %>

    
    <!-- Cuerpo de la página -->
    <div class="container">
   		<c:if test="${mensaje != null}">
			<div class="alert alert-danger" role="alert">
			${mensaje}</div>
		</c:if>
      <div class="row">
        <div class="col-12 col-md-6 text-center">
          <h1><img width="300" height="300"
					src="https://scontent-mad1-1.xx.fbcdn.net/v/t1.0-9/53646143_948372078693647_5977699288883396608_n.jpg?_nc_cat=111&_nc_sid=85a577&_nc_ohc=Obcuqk_rV9gAX8uNnfj&_nc_ht=scontent-mad1-1.xx&oh=90e8d997da3dc17608e76596495ecdcf&oe=5EB8BE33"></h1>
        </div>
        <div class="col-12 col-md-6 text-center">
          <h1>Bienvenido a Electolab 2.0!</h1>
          <h4><p>Electolab 2.0 permite que relacionar a personas sin conocimientos extensos de política puedan acceder a diferente información y predicciones 
          y opiniones de analistas expertos en el tema. De esta forma cualquier analista puede compartir sus estimaciones sobre determinadas leyes y mostrarlas 
          a los demás usuarios, mientras éstos pueden valorar positiva o negativamente cada predicción.</p></h4>
        </div>
      </div>
      <div class="row">
        <div class="col-12 col-md-6 text-center">
          <h1>Para empezar</h1>
          <h4><p>En la barra de navegación superior puede acceder al apartado que prefiera.
          Para cualquier duda o ayuda que necesite, acceda a la pestaña de "Ayuda"</p></h4>
        </div>
        <div class="col-12 col-md-6 text-center">
          <img width="300" height="300"
					src="https://cdn.pixabay.com/photo/2015/04/12/16/33/hammer-719066_1280.jpg"></h1>
       
          
        </div>
      </div>
    </div>
 	<%@ include file = "Variables.jsp" %>
  </body>
