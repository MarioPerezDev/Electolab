
<form action="CreatePredictionPerGroupServlet">
<%@ include file = "LeyForm.jsp" %>
	
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