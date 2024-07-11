<%-- 
	version		: 1.0
    Document  	: Frm_FasesPresupuesto
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
		<c:when test="${infestado=='activo'}">
			<div class="card-header text-white carHeaderBlue">
				<h5>ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblAnteproyectoPresupuesto" id="anteCod"
							data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
							data-accionEnExito="ACTUALIZAR">
							<table class="table registros table-bordered">
								<tr>
									<th colspan="2" class="tablaingreso"></th>
								</tr>
								<tr>
									<td>PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y
										PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE
										REALIZÓ LA POBLACIÓN DEL TERRITORIO:</td>
									<td colspan="2" scope="row">
										<div class="input-group date">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i> </span> <input type="text"
												required="required" id="ante_fecha" name="ante_fecha"
												value="${anteFecha}" class="form-control form-control-sm"
												value="" maxlength="10"
												pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
											<div class="invalid-feedback">Por favor ingrese la
												fecha de inicio de gestión</div>
										</div>
									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnActualizar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
				</div>
				<input type="hidden" id="ante_cod" name="ante_cod"
					value="${anteCod}">
			</div>
		</c:when>
		<c:when test="${infestado=='matriz'}">
			<table id="TablaAnteproyectoPresupuesto2"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th colspan="6"></th>
					</tr>
					<tr>
						<th class="tablaingreso" width="5%">#</th>
						<th class="tablaingreso" width="80%">ANTEPROYECTOS</th>
						<th class="tablaingreso" width="10%">FECHA</th>
						<th class="tablaingreso" width="5%"></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
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
	$(document).ready(function() {
		var f = new Date();
		var dia1 = "01";
		var dia30 = "30";
		var mes1 = "01";
		var dia31 = "31";
		var mes12 = "12";
		var anio = f.getFullYear() - 2;
		var anioFin = f.getFullYear() -1;
		var fechaInicio = (dia1 + "/" + mes1 + "/" + anio);
		var fechaFin = (dia31 + "/" + mes12 + "/" + anioFin);
		$('#ante_fecha').datepicker({
			forceParse : true,
			todayBtn : false
		}).datepicker('setStartDate', fechaInicio);
		$('#ante_fecha').datepicker({}).datepicker('setEndDate', fechaFin);
		$('#ante_fecha').datepicker({}).datepicker('setStartDate', fechaInicio);
		//$('#ante_fecha').datepicker({}).datepicker('update', '');
	});

	$("#btnActualizar")
			.click(
					function(event) {
						var form = $("#anteCod")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							var columnas = '';
							var x = $(form).serializeArray();
							$.each(x, function(i, field) {
								columnas += field.name + ',99';
								if (columnas.length > 0) {
									columnas = columnas.substr(0,
											columnas.length - 1);
								}
							});
							var valores = '';
							var x = $(form).serializeArray();
							$.each(x, function(i, field) {
								valores += field.value + ',99';
								if (valores.length > 0) {
									valores = valores.substr(0,
											valores.length - 1);
								}
							});
							var data = {
								tabla : 'esq_rendicioncuentas.tbl_anteproyecto_presupuesto',
								columns : columnas,
								values : valores,
								condicion : 'ante_cod',
								valorcondicion : $("#ante_cod").val()
							};
							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');
					});

	function Actualizar2(element) {
		$('#TablaAnteproyectoPresupuesto2 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
	}
</script>
