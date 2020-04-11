<div class="col-3">
			<div class="userLogedArea">
				<h3 class="userLogedAreaTitle">Usuario</h3>
				<p>Nombre de usuario: ${usuario.name}</p>
				<p>Correo: ${usuario.email}</p>
				<c:choose>
					<c:when test="${usuario.analist}">
						<p>Rango: Analista</p>
						<c:if test="${usuario.analist and usuario.accepted}">
							<a href="CreatePrediction.jsp"><button
									class="btn btn-outline-light btn-sm">Crear predicción</button></a>
							<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
						</c:if>
					</c:when>
					<c:otherwise>
						<p>Rango: Usuario</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>