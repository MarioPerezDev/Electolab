
<form action="CreatePredictionPerPartidoServlet">
	<%@ include file="LeyForm.jsp"%>
	<c:forEach items="${partidos}" var="partidoi">
		<label for="voto${partidoi.id}">Voto de ${partidoi.nombre}:</label>
		<select name="voto${partidoi.id}" class="form-control optionSelection">
			<option value="favor">A favor</option>
			<option value="contra">En contra</option>
			<option value="abstencion">Abstencion</option>
		</select>
	</c:forEach>
	<input type="hidden" name="ownUserId" value="${usuario.id}" />
	<button type="submit" class="btn btn-outline-dark btn-sm">Crear</button>
</form>