
<input type="hidden" name="ownUserId" value="${usuario.id}" />
<label for="leyId">Seleccione la ley para la predicci�n:</label>
<select name="leyId" class="form-control optionSelection">
	<c:forEach items="${leyes}" var="leyi">
		<option value="${leyi.id}">${leyi.nombre} de ${leyi.fecha}</option>
	</c:forEach>
</select>