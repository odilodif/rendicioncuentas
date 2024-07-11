<%-- 
	version		: 1.0
    Document  	: Frm_SeguroGeneral
    Created on	: 25 mar. 2021; 13:57:01
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card text-center mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card-header text-white carHeaderBlue">
				<h5>SEGURO SOCIAL CAMPESINO</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblSeguroGeneral" id="SeguroGeneral"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarSeguroGeneral"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
							<div class="ibox-content">
								<div class="table-responsive">
									<table class="table registros table-bordered" id="tablaid">

										<tr>

											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small; ">
												TOTAL PRESUPUESTO INSTITUCIONAL</th>
											<th scope="col" class="tablaingreso" colspan="5"
												style="text-align: center; font-size: x-small; ">
												INGRESOS</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small; ">
												PRESUPUESTO CODIFICADO</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small; ">
												PRESUPUESTO EJECUTADO</th>
										</tr>
										<tr>
											<td scope="row" rowspan="2" style="vertical-align: middle;">
												<input type="text"
												class="form-control form-control-sm valor numero"
												id="sgPresin" name="sgPresin" placeholder="000"
												maxlength="20" onkeypress="mascara(this,cpf)" onpaste="return false"
												required="required" min="0">
												<div class="invalid-feedback">Por favor ingrese la
													cantidad</div>
											</td>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN APORTES PERSONALES (SIN RELACIÓN DE DEPENDENCIA
												Y VOLUNTARIOS EN EL EXTERIOR)</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN APORTES PATRONALES Y PERSONALES (RELACIÓN DE
												DEPENDENCIA)</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												INGRESOS POR FONDOS DE RESERVA</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												UTILIDADES INVERSIONES</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DEL ESTADO DEL 40% PARA LAS PENSIONES DE
												JUBILACIÓN</th>
											<td scope="row" rowspan="2"
												style="vertical-align: middle;"><input
												type="text" class="form-control form-control-sm campo valor"
												id="sgPcod" name="sgPcod" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row" rowspan="2"
												style="vertical-align: middle; "><input
												type="text" class="form-control form-control-sm campo valor"
												id="sgPejec" name="sgPejec" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
										</tr>
										<tr align="center">

											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="sgAposr" name="sgAposr" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="sgApopp" name="sgApopp" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="sgIngfr" name="sgIngfr" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id=sgUtilinv name="sgUtilinv" placeholder="000"
												maxlength="20" onkeypress="mascara(this,cpf)"
												required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="sgJubil" name="sgJubil" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" onpaste="return false"required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>

										</tr>
									</table>
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">

			<div id="actualizar">
				<div class="col-md-12 order-md-1">
					<div class="card-header text-white carHeaderBlue">
						<h5>COBERTURA GEOGRÁFICA: UNIDADES DE ATENCIÓN O GESTIÓN QUE
							INTEGRA</h5>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-md-12 order-md-1">
								<form:form class="needs-validation" novalidate=""
									modelAttribute="TblSeguroGeneral" id="SeguroGeneralActul"
									data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
									data-accionEnExito="ACTUALIZAR">
									<div class="ibox-content">
										<div class="table-responsive">
											<table class="table registros table-bordered" id="tablaid">

												<tr>

													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														TOTAL PRESUPUESTO INSTITUCIONAL</th>
													<th scope="col" class="tablaingreso" colspan="5"
														style="text-align: center; font-size: x-small;">
														INGRESOS</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														PRESUPUESTO CODIFICADO</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														PRESUPUESTO EJECUTADO</th>
												</tr>
												<tr>
													<td scope="row" rowspan="2" style="vertical-align: middle;">
														<input type="text"
														class="form-control form-control-sm valor numero"
														id="sg_presin" name="sg_presin" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por favor ingrese la
															cantidad</div>
													</td>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN APORTES PERSONALES (SIN RELACIÓN DE
														DEPENDENCIA Y VOLUNTARIOS EN EL EXTERIOR)</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN APORTES PATRONALES Y PERSONALES (RELACIÓN DE
														DEPENDENCIA)</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														INGRESOS POR FONDOS DE RESERVA</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														UTILIDADES INVERSIONES</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DEL ESTADO DEL 40% PARA LAS PENSIONES DE
														JUBILACIÓN</th>
													<td scope="row" rowspan="2"
														style="vertical-align: middle;"><input
														type="text"
														class="form-control form-control-sm campo valor campo valor"
														id="sg_pcod" name="sg_pcod" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row" rowspan="2"
														style="vertical-align: middle;"><input
														type="text"
														class="form-control form-control-sm campo valor"
														id="sg_pejec" name="sg_pejec" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
												</tr>
												<tr align="center">

													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sg_aposr" name="sg_aposr" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sg_apopp" name="sg_apopp" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sg_ingfr" name="sg_ingfr" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id=sg_utilinv name="sg_utilinv" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sg_jubil" name="sg_jubil" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>

												</tr>
											</table>

										</div>
									</div>
								</form:form>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>

						</div>
						<input type="hidden" id="sg_cod" name="sg_cod">
					</div>

				</div>
			</div>

			<div id="tabla" class="col-md-12 order-md-1">
				<div class="ibox-content">
					<div class="table-responsive">
						<table id="TablaSeguroGeneral"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th  style="text-align: center; font-size: x-small;">TOTAL
										PRESUPUESTO INSTITUCIONAL</th>
									<th style="text-align: center; font-size: x-small;">INGRESOS</th>
									<th style="text-align: center; font-size: x-small;">PRESUPUESTO
										CODIFICADO</th>
									<th style="text-align: center; font-size: x-small;">PRESUPUESTO
										EJECUTADO</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<hr />
					</div>
				</div>
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
	$(document).ready(function() {

		$("#actualizar").hide();
		if ('${inf_estado}' == 'matriz') {
			tabla();
			$("#botones").show();
		}
		if ('${infestadoinforme}' == 'finalizado') {

			var inputs = document.getElementsByTagName("input");
			for (var i = 0; i < inputs.length; i++) {
				inputs[i].disabled = true;
			}
			var buttons = document.getElementsByTagName("button");
			for (var i = 0; i < buttons.length; i++) {
				buttons[i].disabled = true;
			}
		}

	});

	$("#btnGuardar")
			.click(
					function(event) {

						var form = $("#SeguroGeneral")
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

	function tabla() {
		var parametros = {
			"infCod" : '${inf_Cod}'
		};
		$('#TablaSeguroGeneral')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerSeguroGeneral",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							responsive : true,
							order : [ 0, "asc" ],
							buttons : [],
							columns : [
									{
										data : "sgPresin"
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											data = '<table class="table registros table-bordered"  width="100%"> '
													+ '<tr>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN APORTES PERSONALES (SIN RELACIÓN DE DEPENDENCIA Y VOLUNTARIOS EN EL EXTERIOR)</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN APORTES PATRONALES Y PERSONALES (RELACIÓN DE DEPENDENCIA) </th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">INGRESOS POR FONDOS DE RESERVA</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">UTILIDADES INVERSIONES</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DEL ESTADO DEL 40% PARA LAS PENSIONES DE JUBILACIÓN</th>'
													+ '</tr>'
													+ ' <tr>'
													+ '<td>'
													+ full.sgAposr
													+ '</td>'
													+ '<td>'
													+ full.sgApopp
													+ '</td>'
													+ '<td>'
													+ full.sgIngfr
													+ '</td>'
													+ '<td>'
													+ full.sgUtilinv
													+ '</td>'
													+ '<td>'
													+ full.sgJubil
													+ '</td>'
													+ '</tr>'
													+ '</table>'
											return data;
										}
									},

									{
										data : "sgPcod"
									},
									{
										data : "sgPejec"
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-xs"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';
											}
											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},

							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.sgCod);
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td:eq(9)").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	function Modificar(element) {
		var codigo = $(element).closest('tr').attr('id');
		var cant1 = $(element).parent().parent().find("td:eq(0)").text();

		var cant2 = $(element).parent().parent().find("td:eq(2)").text();
		var cant3 = $(element).parent().parent().find("td:eq(3)").text();
		var cant4 = $(element).parent().parent().find("td:eq(4)").text();
		var cant5 = $(element).parent().parent().find("td:eq(5)").text();
		var cant6 = $(element).parent().parent().find("td:eq(6)").text();

		var cant7 = $(element).parent().parent().find("td:eq(7)").text();
		var cant8 = $(element).parent().parent().find("td:eq(8)").text();

		$("#actualizar").show();
		$("#tabla").hide();
		$("#sg_cod").val(codigo);
		$("#sg_presin").val(cant1);
		$("#sg_aposr").val(cant2);
		$("#sg_apopp").val(cant3);
		$("#sg_ingfr").val(cant4);
		$("#sg_utilinv").val(cant5);
		$("#sg_jubil").val(cant6);
		$("#sg_pcod").val(cant7);
		$("#sg_pejec").val(cant8);

	}
	function replazarmiles(Numero) {
		return Numero.replace(/[^\d,]/g, "");

	}

	function replazarmilesActualizar(Numero) {
		var a = Numero.replace(/[^\d.]/g, "");
		return a

	}

	function milesNumeros(numero) {
		return numero.toString().replace(/(\.\d+)|\B(?=(\d{3})+(?!\d))/g,
				function(m, g1) {
					return g1 || ","
				});
	};

	$("#btnActualizar")
			.click(
					function(event) {
						var form = $("#SeguroGeneralActul")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							$("#sg_presin").val(
									replazarmilesActualizar($("#sg_presin")
											.val()));
							$("#sg_aposr").val(
									replazarmilesActualizar($("#sg_aposr")
											.val()));
							$("#sg_apopp").val(
									replazarmilesActualizar($("#sg_apopp")
											.val()));
							$("#sg_ingfr").val(
									replazarmilesActualizar($("#sg_ingfr")
											.val()));
							$("#sg_utilinv").val(
									replazarmilesActualizar($("#sg_utilinv")
											.val()));
							$("#sg_jubil").val(
									replazarmilesActualizar($("#sg_jubil")
											.val()));
							$("#sg_pcod")
									.val(
											replazarmilesActualizar($(
													"#sg_pcod").val()));
							$("#sg_pejec").val(
									replazarmilesActualizar($("#sg_pejec")
											.val()));

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
								tabla : 'esq_rendicioncuentas.tbl_seguro_general',
								columns : columnas,
								values : valores,
								condicion : 'sg_cod',
								valorcondicion : $("#sg_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});

	/*
	function ValidarCampoCero(val) {

	if (val == 0) {

		$("#infGastplan").val(0);
		$("#infGastejec").val(0);
		$("#infGastinvplan").val(0);
		$("#infGastinvejec").val(0);
		$("#infGastplan").attr("disabled", true);
		$("#infGastejec").attr("disabled", true);
		$("#infGastinvplan").attr("disabled", true);
		$("#infGastinvejec").attr("disabled", true);
		
		
		}else{
			$("#infGastplan").attr("disabled", false);
			$("#infGastejec").attr("disabled", false);
			$("#infGastinvplan").attr("disabled", false);
			$("#infGastinvejec").attr("disabled", false); 

			$("#infGastplan").val(null);
			$("#infGastejec").val(null);
			$("#infGastinvplan").val(null);
			$("#infGastinvejec").val(null);
			 
	}
	}*/
</script>
