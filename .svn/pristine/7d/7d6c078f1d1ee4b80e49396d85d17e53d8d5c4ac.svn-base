<%-- 
	version		: 1.0
    Document  	: Frm_Aportes_Ciudadanos_Autoridad.jsp

    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
    Property   	: CPCCS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<%@ page session="false"%>
<sec:authentication var="usuario" property="principal" />

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card text-center mb-card15">
	<c:choose>
		
		<c:when test="${inf_estado=='activo'}">
			
				<div class="card-body">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblInformeAutoridad" id="InformeAutoridadAporte"
						data-rutaAplicacion="rendicion"
						data-opcion="actualizarInformeAutoridadAporte"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
						<div class="card-header text-white carHeaderBlue">
							<h5>APORTES CIUDADANOS</h5>
						</div>
						<div class="row">
							<div class="col-md-12 order-md-1">
							
								<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso">PRINCIPALES APORTES CIUDADANOS RECIBIDOS EN EL PROCESO DE RENDICIÓN DE CUENTAS</th>
									<tr>
										<td scope="row">
											<textarea rows="12" cols=""
											class="form-control form-control-sm" id=inaAportesCiu
											required="required" name="inaAportesCiu"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div>
											
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				</div>
			
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			<div id="actRC">
				<div class="card-body">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblInformeAutoridad" id="InformeAutoridadAporte"
						data-rutaAplicacion="rendicion"
						data-opcion="actualizarInformeAutoridad"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
						<div class="card-header text-white carHeaderBlue">
							<h5>APORTES CIUDADANOS</h5>
						</div>
						<div class="row">
							<div class="col-md-12 order-md-1">
							
								<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso">PRINCIPALES APORTES CIUDADANOS RECIBIDOS EN EL PROCESO DE RENDICIÓN DE CUENTAS</th>
									<tr>
										<td scope="row">
											<textarea rows="12" cols=""
											class="form-control form-control-sm" id=inaAportesCiu
											required="required" name="inaAportesCiu"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div>
											
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				</div>
			</div>
			<div id="tablaRC">
				<table
					class="table table-striped table-bordered dataTable no-footer">
					<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="3" style="font-size: xx-small;"><p style="color: white;"></p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">PRINCIPALES APORTES CIUDADANOS RECIBIDOS EN EL PROCESO DE RENDICIÓN DE CUENTAS</p></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th style="font-size: xx-small;">1</th>
							<th style="font-size: xx-small;">${ina_aportes_ciu}</th>
							<th>
							<c:choose>
							<c:when test="${infestadoinforme=='finalizado'}">
							
									</c:when>
									<c:when test="${infestadoinforme=='activo'}">
							<button type="submit" id="btnActualizar"  style="text-align: center; font-size: x-small;"
									class="_modificar btn _actualizarColor btn-sm">Editar</button>
									</c:when>
									</c:choose>
									</th>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<div>
				<div id="informacion">
					¡Información!... Usted aun no cuenta con un informe.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Informe.
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
</html>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#tablaRC').show();
						$('#actRC').hide();

						if ('${infestadoinforme}' == 'finalizado') {
							var inputs = document.getElementsByTagName("input");
							for (var i = 0; i < inputs.length; i++) {
								inputs[i].disabled = true;
							}
							var buttons = document
									.getElementsByTagName("button");
							for (var i = 0; i < buttons.length; i++) {
								buttons[i].disabled = true;
							}
						}

						
					});

	$("#btnActualizar").click(function(event) {
		$('#tablaRC').hide();
		$('#inaAportesCiu').val("${ina_aportes_ciu}")
		$('#actRC').show();
	});

	$("#btnGuardar")
			.click(
					function(event) {
						$('#InformeAutoridadAporte').attr('data-opcion',
								'actualizarInformeAutoridadAporte');
						var form = $("#InformeAutoridadAporte")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {

							ejecutarJson(form);
						}
						form.addClass('was-validated');

					});
</script>
