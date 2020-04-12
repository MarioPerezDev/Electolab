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
		<h1>${active}</h1>
		<div class="row">
			<div class="col-12 col-md-9 text-center">
				<h4>
					<p>1)Esta p�gina puede ser usada como Usuario sin loggear,
						Usuario y Analista. Para registrarse, seleccione "Entrar ->
						Registrarse" y cree su cuenta, seleccionando la pesta�a de
						analista si procede.</p>
					<p>2)Si quieres buscar informaci�n, accede en la barra de
						navegaci�n a "Informaci�n" y podr�s ver la informaci�n completa.
						En esta secci�n no es necesario estar loggeado en la p�gina.</p>
					<p>3)Si quieres observar diferentes predicciones realizadas por
						analistas debes estar loggeado. Posteriormente, accede a
						"Predicciones" Saldr� un listado de las predicciones realizadas
						hasta el momento. Puede acceder a cualquiera de ellas y valorarlas
						seg�n su criterio.</p>
					<p>4)Si es analista y quiere realizar una predicci�n acceda a
						su cuenta de analista y seleccione "Crear Predcici�n". A
						continuaci�n se le mostrar� una serie de pesta�as que deber�
						seleccionar en funci�n de la predicci�n que quiera realizar, ya
						sea por partidos, por grupos parlamentarios o por diputados.</p>


				</h4>
			</div>
			<div class="col-12 col-md-3 text-center">
				<img width="300" height="150"
					src="https://www.upm.es/sfs/Rectorado/Gabinete%20del%20Rector/Logos/UPM/Logotipo%20con%20Leyenda/LOGOTIPO%20leyenda%20color%20PNG.png">

			</div>
		</div>
	</div>
	<%@ include file="Variables.jsp"%>
</body>
<footer>
	<div class="container">
		<h5>Para cualquier duda, no dude en consultar con nosotros en
			electolab@gmail.com</h5>
	</div>
</footer>
</html>