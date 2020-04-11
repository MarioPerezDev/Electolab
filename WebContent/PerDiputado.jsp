<form action="CreatePredictionPerDiputadoServlet">
<%@ include file = "LeyForm.jsp" %>

<c:forEach items="${diputados}" var="diputadoi">
	<label for="voto${diputado.id}">Voto de ${diputadoi.nombre}:</label>
	<select name="voto${diputadoi.id}" class="form-control optionSelection">
		<option value="favor">A favor</option>
		<option value="contra">En contra</option>
		<option value="abstencion">Abstencion</option>
	</select>
</c:forEach>
<input type="hidden" name="ownUserId" value="${usuario.id}" />
<button type="submit" class="btn btn-outline-dark btn-sm">Crear</button>
</form>