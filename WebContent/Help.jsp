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
			<div class="col-12 col-md-9">
				<div class="row">
				  <div class="col-4">
				    <div class="list-group" id="list-tab" role="tablist">
				      <a class="list-group-item list-group-item-action active list-group-item-secondary" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home">Inicio</a>
				      <a class="list-group-item list-group-item-action list-group-item-secondary" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile">Informaci�n</a>
				      <a class="list-group-item list-group-item-action list-group-item-secondary" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages">Predicciones</a>
				      <a class="list-group-item list-group-item-action list-group-item-secondary" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings">Perfil</a>
				      <a class="list-group-item list-group-item-action list-group-item-secondary" id="list-contacts-list" data-toggle="list" href="#list-contacts" role="tab" aria-controls="contacts">Contacto</a>
				    </div>
				  </div>
				  <div class="col-8">
				    <div class="tab-content" id="nav-tabContent">
				      <div class="tab-pane fade show active text-justify" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
				      	Esta p�gina puede ser usada como Usuario sin loggear,
						Usuario y Analista. Para registrarse, seleccione "Entrar ->
						Registrarse" y cree su cuenta, seleccionando la pesta�a de
						analista si procede.</div>
				      <div class="tab-pane fade text-justify" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
				      	Si quieres buscar informaci�n, accede en la barra de
						navegaci�n a "Informaci�n" y podr�s ver la informaci�n completa.
						En esta secci�n no es necesario estar loggeado en la p�gina.</div>
				      <div class="tab-pane fade text-justify" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">
				      	Si quieres observar diferentes predicciones realizadas por analistas debes estar loggeado. Posteriormente, accede a
						"Predicciones" Saldr� un listado de las predicciones realizadas
						hasta el momento. Puede acceder a cualquiera de ellas y valorarlas
						seg�n su criterio.</div>
				      <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list"> 
      							<div class="row">
      								<div class="col-4">
    									<div class="list-group" id="list-tab" role="tablist">
	      									<ul class="list-group">
											  <li class="list-group-item-secondary"><a class="list-group-item list-group-item-action list-group-item-secondary" id="list-usuario-list" data-toggle="list" href="#list-usuario" role="tab" aria-controls="usuario">Usuario</a></li>
											  <li class="list-group-item-secondary"><a class="list-group-item list-group-item-action list-group-item-secondary" id="list-analista-list" data-toggle="list" href="#list-analista" role="tab" aria-controls="analista">Analista</a></li>
											</ul>
										</div>
									</div>
										<div class="col-6">
											<div class="tab-content " id="nav-tabContent">
												<div class="tab-pane fade show text-justify" id="list-usuario" role="tabpanel" aria-labelledby="list-usuario-list">
												Siendo usuario las opciones que tiene en la p�gina web, es la observaci�n de las diferentes predicci�nes
												realizadas por los analistas, incluso pudiendo dar like a la predicci�n visualizada. Adem�s puede acceder a 
												a cualquier tipo de informaci�n relacionada con los partidos pol�ticos y las leyes votadas en el Pleno. </div>
												<div class="tab-pane fade show text-justify" id="list-analista" role="tabpanel" aria-labelledby="list-analista-list">
												Siendo analista, adem�s de todas las posibilidades y opciones que tiene el usuario, puede realizar 
												una serie de predicciones. Si quiere realizar una predicci�n acceda a
												su cuenta de analista y seleccione "Crear Predicci�n". A
												continuaci�n se le mostrar� una serie de pesta�as que deber�
												seleccionar en funci�n de la predicci�n que quiera realizar, ya
												sea por partidos, por grupos parlamentarios o por diputados.</div>
											</div>
  										</div>
  								</div>
					  </div>
				      <div class="tab-pane fade" id="list-contacts" role="tabpanel" aria-labelledby="list-contacts-list">
				      Para cualquier duda, no dude en consultar con nosotros en
					  electolab@gmail.com</div>
				    </div>
				  </div>
				</div>
			<div class="col-12 col-md-3 text-center">
				<img width="300" height="150"
					src="https://www.upm.es/sfs/Rectorado/Gabinete%20del%20Rector/Logos/UPM/Logotipo%20con%20Leyenda/LOGOTIPO%20leyenda%20color%20PNG.png">

			</div>
		</div>
	</div>
	<%@ include file="Variables.jsp"%>
</body>
</html>