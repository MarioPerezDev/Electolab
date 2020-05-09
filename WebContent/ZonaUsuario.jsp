<div class="col-12 col-md-3">
	<div class="userLogedArea">
		<h3 class="userLogedAreaTitle">Usuario</h3>
		<c:choose>
			<c:when test="${admin == true}">
				<p>Nombre de usuario: Admin</p>
			</c:when>
			<c:otherwise>
				<p>Nombre de usuario: ${usuario.name}</p>
				<p>Correo: ${usuario.email}</p>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${admin == true}">
				<p>Rango: Admin</p>
				<a href="PrepareToCreateAgainServlet"><button
						class="btn btn-outline-light btn-sm">Crear predicción</button></a>
				<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
			</c:when>
			<c:when test="${usuario.analist}">
				<p>Rango: Analista</p>
				<c:if test="${usuario.analist and usuario.accepted}">
					<a href="PrepareToCreateAgainServlet"><button
							class="btn btn-outline-light btn-sm">Crear predicción</button></a>
					<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<p>Rango: Usuario</p>
				<a style="margin-left: 20px;" href="LogoutServlet">Salir</a>
			</c:otherwise>
		</c:choose>
	</div>
</div>