<%-- 
	version		: 1.0
    Document  	: Frm_SeguroCampesino
    Created on	: 29 mar. 2021; 09:49:13
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
				<h5>SEGURO GENERAL OBLIGATORIO</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblSeguroCampesino" id="SeguroCampesino"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarSeguroCampesino"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
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
												id="scPresins" name="scPresins" placeholder="000"
												maxlength="13" onkeypress="mascara(this,cpf)"
												required="required" min="0">
												<div class="invalid-feedback">Por favor ingrese la
													cantidad</div>
											</td>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DEL JEFE DE FAMILIA</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DE LOS TRABAJADORES (0.35%)</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DE LOS PATRONOS (0.35%)</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DEL ESTADO (0.30%)</th>
											<th scope="col" class="tablaingreso"
												style="text-align: center; font-size: x-small;">
												CONTRIBUCIÓN DE LAS EMPRESAS DE SEGUROS PRIVADOS (0.5%)</th>
											<td scope="row" rowspan="2"
												style="vertical-align: middle;"><input
												type="text" class="form-control form-control-sm campo valor"
												id="scPresc" name="scPresc" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row" rowspan="2"
												style="vertical-align: middle;"><input
												type="text" class="form-control form-control-sm campo valor"
												id="scPrese" name="scPrese" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
										</tr>
										<tr align="center">

											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="scConjf" name="scConjf" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="scConpat" name="scConpat" placeholder="000"
												maxlength="20" onkeypress="mascara(this,cpf)"
												required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="scContraba" name="scContraba" placeholder="000"
												maxlength="20" onkeypress="mascara(this,cpf)"
												required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor"
												id="scConest" name="scConest" placeholder="000"
												maxlength="20" onkeypress="mascara(this,cpf)"
												required="required" min="0">
												<div class="invalid-feedback">Por Ingrese número
													Participantes</div></td>
											<td scope="row"><input type="text"
												class="form-control form-control-sm campo valor" id=scConsp
												name="scConsp" placeholder="000" maxlength="20"
												onkeypress="mascara(this,cpf)" required="required" min="0">
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
									modelAttribute="TblSeguroCampesino" id="SeguroCampesinoActul"
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
														id="sc_presins" name="sc_presins" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por favor ingrese la
															cantidad</div>
													</td>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DEL JEFE DE FAMILIA</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DE LOS TRABAJADORES (0.35%)</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DE LOS PATRONOS (0.35%)</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DEL ESTADO (0.30%)</th>
													<th scope="col" class="tablaingreso"
														style="text-align: center; font-size: x-small;">
														CONTRIBUCIÓN DE LAS EMPRESAS DE SEGUROS PRIVADOS (0.5%)</th>
													<td scope="row" rowspan="2"
														style="vertical-align: middle;"><input
														type="text"
														class="form-control form-control-sm campo valor campo valor"
														id="sc_presc" name="sc_presc" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row" rowspan="2"
														style="vertical-align: middle;"><input
														type="text"
														class="form-control form-control-sm campo valor"
														id="sc_prese" name="sc_prese" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
												</tr>
												<tr align="center">

													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sc_conjf" name="sc_conjf" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sc_conpat" name="sc_conpat" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sc_contraba" name="sc_contraba" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sc_conest" name="sc_conest" placeholder="000"
														maxlength="20" onkeypress="mascara(this,cpf)"
														required="required" min="0">
														<div class="invalid-feedback">Por Ingrese número
															Participantes</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm campo valor"
														id="sc_consp" name="sc_consp" placeholder="000"
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
						<input type="hidden" id="sc_cod" name="sc_cod">
					</div>

				</div>
			</div>

		<div id="tabla" class="col-md-12 order-md-1">
				<div class="ibox-content">
					<div class="table-responsive">
						<table id="TablaSeguroCampesino"
								class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th style="text-align: center; font-size: x-small;">TOTAL
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

						var form = $("#SeguroCampesino")
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
		$('#TablaSeguroCampesino')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerSeguroCampesino",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},						
							bDestroy : true,
							order : [ 0, "asc" ],
							buttons : [],
							columns : [

									{
										data : "scPresins"
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											data = '<table class="table registros table-bordered"  width="100%"> '
													+ '<tr>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DEL JEFE DE FAMILIA</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DE LOS TRABAJADORES (0.35%)</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DE LOS PATRONOS (0.35%)</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DEL ESTADO (0.30%)</th>'
													+ '<th style="font-size: 7px;" class="tablainterna"  width="5%">CONTRIBUCIÓN DE LAS EMPRESAS DE SEGUROS PRIVADOS (0.5%)</th>'
													+ '</tr>'
													+ ' <tr>'
													+ '<td>'
													+ full.scConjf
													+ '</td>'
													+ '<td>'
													+ full.scConpat
													+ '</td>'
													+ '<td>'
													+ full.scContraba
													+ '</td>'
													+ '<td>'
													+ full.scConest
													+ '</td>'
													+ '<td>'
													+ full.scConsp
													+ '</td>'
													+ '</tr>'
													+ '</table>'
											return data;
										}
									},

									{
										data : "scPresc"
									},
									{
										data : "scPrese"
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
								$(row).attr('id', data.sc_cod);
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
		$("#sc_cod").val(codigo);
		$("#sc_presins").val(cant1);
		$("#sc_conjf").val(cant2);
		$("#sc_conpat").val(cant3);
		$("#sc_contraba").val(cant4);
		$("#sc_conest").val(cant5);
		$("#sc_consp").val(cant6);
		$("#sc_presc").val(cant7);
		$("#sc_prese").val(cant8);

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
						var form = $("#SeguroCampesinoActul")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {

							$("#sc_presins").val(replazarmilesActualizar($("#sc_presins").val()));
							$("#sc_conjf").val(replazarmilesActualizar($("#sc_conjf").val()));
							$("#sc_conpat").val(replazarmilesActualizar($("#sc_conpat").val()));
							$("#sc_contraba").val(replazarmilesActualizar($("#sc_contraba").val()));
							$("#sc_conest").val(replazarmilesActualizar($("#sc_conest").val()));						
							$("#sc_prese").val(replazarmilesActualizar($("#sc_prese").val()));
							$("#sc_consp").val(replazarmilesActualizar($("#sc_consp").val()));
							$("#sc_presc").val(replazarmilesActualizar($("#sc_presc").val()));
							
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
								tabla : 'esq_rendicioncuentas.tbl_seguro_campesino',
								columns : columnas,
								values : valores,
								condicion : 'sc_cod',
								valorcondicion : $("#sc_cod").val()
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
