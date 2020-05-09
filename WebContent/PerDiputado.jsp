
<form class="creationform" action="CreatePredictionPerDiputadoServlet">
	<%@ include file="LeyForm.jsp"%>
	<div class="row">
		<c:forEach items="${diputados}" var="diputadoi">
			<c:if test="${diputadoi.id < 116}">
				<div class="col-12 col-md-4">
					<label for="voto${diputadoi.id}">Voto de ${diputadoi.nombre} ${diputadoi.apellido1} ${diputadoi.apellido2}:</label>
					<select name="voto${diputadoi.id}"
						class="form-control optionSelection">
						<option value="favor">A favor</option>
						<option value="contra">En contra</option>
						<option value="abstencion">Abstencion</option>
					</select>
				</div>
			</c:if>
			<c:if test="${diputadoi.id >= 116 and diputadoi.id < 232}">
				<div class="col-12 col-md-4">
					<label for="voto${diputadoi.id}">Voto de ${diputadoi.nombre} ${diputadoi.apellido1} ${diputadoi.apellido2}:</label>
					<select name="voto${diputadoi.id}"
						class="form-control optionSelection">
						<option value="favor">A favor</option>
						<option value="contra">En contra</option>
						<option value="abstencion">Abstencion</option>
					</select>
				</div>
			</c:if>
			<c:if test="${diputadoi.id >= 232}">
				<div class="col-12 col-md-4">
					<label for="voto${diputadoi.id}">Voto de ${diputadoi.nombre} ${diputadoi.apellido1} ${diputadoi.apellido2}:</label>
					<select name="voto${diputadoi.id}"
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