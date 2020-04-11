
<form action="CreatePredictionPerGroupServlet">
	<input type="hidden" name="ownUserId" value="${usuario.id}" /> <label
		for="leyId">Seleccione la ley para la predicción:</label> <select
		name="leyId" class="form-control optionSelection">
		<c:forEach items="${leyes}" var="leyi">
			<option value="${leyi.id}">${leyi.nombre}</option>
		</c:forEach>
	</select>
	
	<c:forEach items="${gruposparlamentarios}" var="grupoi">
		<label for="voto${grupoi.id}">Voto de ${grupoi.nombre}:</label>
		<select name="voto${grupoi.id}" class="form-control optionSelection">
			<option value="favor">A favor</option>
			<option value="contra">En contra</option>
			<option value="abstencion">Abstencion</option>
		</select>
	</c:forEach>
	<input type="hidden" name="ownUserId" value="${usuario.id}" />
	<button type="submit" class="btn btn-outline-dark btn-sm">Crear</button>
</form>