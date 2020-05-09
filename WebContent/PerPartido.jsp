
<form class="creationform" action="CreatePredictionPerPartidoServlet">
	<%@ include file="LeyForm.jsp"%>
	<div class="row">
		<c:forEach items="${partidos}" var="partidoi">
			<c:if test="${partidoi.id < 12}">
				<div class="col-12 col-md-6">
					<label for="voto${partidoi.id}">Voto de ${partidoi.nombre}:</label>
					<select name="voto${partidoi.id}"
						class="form-control optionSelection">
						<option value="favor">A favor</option>
						<option value="contra">En contra</option>
						<option value="abstencion">Abstencion</option>
					</select>
				</div>
			</c:if>
			<c:if test="${partidoi.id >= 12}">
				<div class="col-12 col-md-6">
					<label for="voto${partidoi.id}">Voto de ${partidoi.nombre}:</label>
					<select name="voto${partidoi.id}"
						class="form-control optionSelection">
						<option value="favor">A favor</option>
						<option value="contra">En contra</option>
						<option value="abstencion">Abstencion</option>
					</select>
				</div>
			</c:if>
		</c:forEach>
	</div>
	<input type="hidden" name="ownUserId" value="${usuario.id}" />
	<button type="submit" class="btn btn-outline-dark btn-sm">Crear</button>
</form>