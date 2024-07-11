<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoCoberturaGeografica
    Created on	: 15 mar. 2021; 11:19:51
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

			<div class="card-header text-white carHeaderBlue"
				style="width: 100%;">
				<h5>COBERTURA GEOGRÁFICA: UNIDADES DE ATENCIÓN O GESTIÓN QUE
					INTEGRA</h5>
			</div>
			<div class="card-body">

				<div class="col-md-12 order-md-1">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblCoberturaCeografica" id="CoberturaGeografica"
						data-rutaAplicacion="rendicion"
						data-opcion="guardarCoberturaGeografica"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
						<div class="ibox-content">
							<div class="table-responsive">
								<table class="table registros table-bordered">

									<tr>
										<th rowspan="1" scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">NIVEL DE
											UNIDADES DE ATENCIÓN</th>
										<th rowspan="1" scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">NO. DE
											UNIDADES DE ATENCIÓN</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											COBERTURA</th>

										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">N.
											USUARIOS</th>
										<th scope="col" class="tablaingreso" colspan="3"
											style="text-align: center; font-size: x-small;">GÉNERO</th>
										<th scope="col" class="tablaingreso" colspan="5"
											style="text-align: center; font-size: x-small;">PUEBLOS
											Y NACIONALIDADES</th>
										<th scope="col" class="tablaingreso" colspan="5"
											style="text-align: center; font-size: x-small;">LINK AL
											MEDIO DE VERIFICACIÓN</th>
									</tr>
									<tr>
										<td scope="row" rowspan="2" style="vertical-align: middle;">
											<select class="custom-select custom-select-sm"
											id="cgTipocobertura" name="cgTipocobertura"
											required="required">
												<option value="">Seleccione...</option>
												<option value="NACIONAL">NACIONAL</option>
												<option value="ZONA">ZONA</option>
												<option value="REGIÓN">REGIÓN</option>
												<option value="PROVINCIA">PROVINCIA</option>
												<option value="DISTRITO">DISTRITO</option>
												<option value="CIRCUITO">CIRCUITO</option>
												<option value="CANTÓN">CANTÓN</option>
												<option value="PARROQUIA">PARROQUIA</option>
												<option value="COMUNIDAD O RECINTO">COMUNIDAD O
													RECINTO</option>
										</select>
											<div class="invalid-feedback">Por Seleccione una opción</div>
										</td>
										<td scope="row" rowspan="2" style="vertical-align: middle;">
											<input type="text" class="form-control form-control-sm"
											id="cgCantidad" name="cgCantidad" placeholder="000"
											maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por favor ingrese No. de
												unidades de atención</div>
										</td>
										<td scope="row" rowspan="2" style="vertical-align: middle;">
											<textarea rows="3" cols=""
												class="form-control form-control-sm" id="cgDescCobertura"
												name="cgDescCobertura" required="required"></textarea>
											<div class="invalid-feedback">Por favor Ingrese la
												observación</div>
										</td>
										<td scope="row" rowspan="2" style="vertical-align: middle;">
											<input type="text" class="form-control form-control-sm usuarios"
											id="cgTotal" name="cgTotal" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por favor ingrese No. de
												usuario</div>
										</td>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											MASCULINO</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											FEMENINO</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">GLBTI</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											MONTUBIOS</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">CHOLOS</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											INDIGENAS</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											MESTIZOS</th>
										<th scope="col" class="tablaingreso"
											style="text-align: center; font-size: x-small;">
											AFROECUATORIANOS</th>
										<td scope="row" rowspan="2"
											style="vertical-align: middle; width: 20%;"><input
											type="url" class="form-control form-control-sm case2"
											id="cgLink" name="cgLink" required="required"
											placeholder="Dirección de página web" value="https://">
											<div class="invalid-feedback">Por favor ingrese su
												página web con el siguiente formato https:// o
												http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr align="center">

										<td scope="row"><input type="text"
											class="form-control form-control-sm hombres" id="cgHombres"
											name="cgHombres" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm mujeres" id="cgMujeres"
											name="cgMujeres" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm glbti" id="cgGlbti"
											name="cgGlbti" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm montubios" id=cgMontubios
											name="cgMontubios" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm cholos" id="cgCholos"
											name="cgCholos" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm indegenas" id="cgIndigenas"
											name="cgIndigenas" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
										<td scope="row"><input type="text"
											class="form-control form-control-sm mestizo" id="cgMestizos"
											name="cgMestizos" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>

										<td scope="row"><input type="text"
											class="form-control form-control-sm afro" id="cgAfroecuatoriano"
											name="cgAfroecuatoriano" placeholder="000" maxlength="20"
											onkeypress="javascript:return validarnro(event);"
											required="required" min="0">
											<div class="invalid-feedback">Por Ingrese número
												Participantes</div></td>
									</tr>
								</table>
							</div>
						</div>
					</form:form>
				</div>

				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardarGrografica"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>

		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			<c:choose>
				<c:when test="${infestadoinforme=='activo'}">
					<div id="botones"
						class="row justify-content-center align-items-center">
						<div class="botones" role="group">
							<c:forEach items="${acciones}" var="a">
								<a class="btn ${a[5]} btn-sm" id="${a[2]}"
									data-rutaAplicacion="${a[4]}" data-opcion="${a[1]}"
									data-destino="detalleItem"> <c:if
										test="${a[2]=='_seleccionar'}">
										<span class='cantidadItemsSeleccionados'>0</span>
									</c:if> <c:if test="${a[2]!='_seleccionar'}">
										<span class="${a[2]}"></span>
									</c:if> <span>${a[3]}</span></a>
							</c:forEach>
						</div>
					</div>
				</c:when>
			</c:choose>
			<div id="actualizar">
				<div class="col-md-12 order-md-1">
					<div class="card-header text-white carHeaderBlue">
						<h5>COBERTURA GEOGRÁFICA: UNIDADES DE ATENCIÓN O GESTIÓN QUE
							INTEGRA</h5>
					</div>
					<div class="card-body">

						<div class="col-md-12 order-md-1">
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblCoberturaCeografica"
								id="CoberturaGeograficaActual" data-rutaAplicacion="rendicion"
								data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
								<div class="ibox-content">
									<div class="table-responsive">
										<table class="table registros table-bordered">
											<tr>
												<th rowspan="1" scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">NIVEL
													DE UNIDADES DE ATENCIÓN</th>
												<th rowspan="1" scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">NO. DE
													UNIDADES DE ATENCIÓN</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													COBERTURA</th>

												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">N.
													USUARIOS</th>
												<th scope="col" class="tablaingreso" colspan="3"
													style="text-align: center; font-size: x-small;">
													GÉNERO</th>
												<th scope="col" class="tablaingreso" colspan="5"
													style="text-align: center; font-size: x-small;">
													PUEBLOS Y NACIONALIDADES</th>
												<th scope="col" class="tablaingreso" colspan="5"
													style="text-align: center; font-size: x-small;">LINK
													AL MEDIO DE VERIFICACIÓN</th>
											</tr>
											<tr>
												<td scope="row" rowspan="2" style="vertical-align: middle;">
													<select class="custom-select custom-select-sm"
													id="cg_tipocobertura" name="cg_tipocobertura"
													required="required">
														<option value="">Seleccione...</option>
														<option value="NACIONAL">NACIONAL</option>
														<option value="ZONA">ZONA</option>
														<option value="REGIÓN">REGIÓN</option>
														<option value="PROVINCIA">PROVINCIA</option>
														<option value="DISTRITO">DISTRITO</option>
														<option value="CIRCUITO">CIRCUITO</option>
														<option value="CANTÓN">CANTÓN</option>
														<option value="PARROQUIA">PARROQUIA</option>
														<option value="COMUNIDAD O RECINTO">COMUNIDAD O
															RECINTO</option>
												</select>
													<div class="invalid-feedback">Por Seleccione una
														opción</div>
												</td>
												<td scope="row" rowspan="2" style="vertical-align: middle;">
													<input type="text" class="form-control form-control-sm"
													id="cg_cantidad" name="cg_cantidad" placeholder="000"
													maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por favor ingrese No.
														de unidades de atención</div>
												</td>
												<td scope="row" rowspan="2" style="vertical-align: middle;">
													<textarea rows="3" cols=""
														class="form-control form-control-sm"
														id="cg_desc_cobertura" name="cg_desc_cobertura"
														required="required"></textarea>
													<div class="invalid-feedback">Por favor Ingrese la
														observación</div>
												</td>
												<td scope="row" rowspan="2" style="vertical-align: middle;">
													<input type="text" class="form-control form-control-sm usuarios"
													id="cg_total" name="cg_total" placeholder="000"
													maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por favor ingrese No.
														de usuario</div>
												</td>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													MASCULINO</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													FEMENINO</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">GLBTI
												</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													MONTUBIOS</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													CHOLOS</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													INDIGENAS</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													MESTIZOS</th>
												<th scope="col" class="tablaingreso"
													style="text-align: center; font-size: x-small;">
													AFROECUATORIANOS</th>
												<td scope="row" rowspan="2" style="vertical-align: middle;">
													<input type="url"
													class="form-control form-control-sm case2" id="cg_link"
													name="cg_link" required="required"
													placeholder="Dirección de página web" value="https://">
													<div class="invalid-feedback">Por favor ingrese su
														página web con el siguiente formato https:// o
														http://dirreccionDePaginaWeb</div>
												</td>
											</tr>
											<tr align="center">

												<td scope="row"><input type="text"
													class="form-control form-control-sm hombres" id="cg_hombres"
													name="cg_hombres" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm mujeres" id="cg_mujeres"
													name="cg_mujeres" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm glbti" id="cg_glbti"
													name="cg_glbti" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm montubios" id=cg_montubios
													name="cg_montubios" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm cholos" id="cg_cholos"
													name="cg_cholos" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm indegenas" id="cg_indigenas"
													name="cg_indigenas" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm mestizo" id="cg_mestizos"
													name="cg_mestizos" placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>

												<td scope="row"><input type="text"
													class="form-control form-control-sm afro"
													id="cg_afroecuatoriano" name="cg_afroecuatoriano"
													placeholder="000" maxlength="20"
													onkeypress="javascript:return validarnro(event);"
													required="required" min="0">
													<div class="invalid-feedback">Por Ingrese número
														Participantes</div></td>
											</tr>
										</table>
									</div>
								</div>
							</form:form>
						</div>

						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarGrograficaActul"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>

						</div>
						<input type="hidden" id="cg_cod" name="cg_cod">
					</div>

				</div>
			</div>

			<div id="tabla" class="col-md-12 order-md-1">
				<div class="ibox-content">
					<div class="table-responsive">
						<table id="TablaCoberturaGeografica"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>#</th>
									<th width="5%" style="text-align: center; font-size: x-small;">NIVEL</th>
									<th width="5%" style="text-align: center; font-size: x-small;">NO.
										DE UNIDADES DE ATENCIÓN</th>
									<th width="20%" style="text-align: center; font-size: x-small;">COBERTURA</th>
									<th width="5%" style="text-align: center; font-size: x-small;">N.
										USUARIOS</th>
									<th width="20%" style="text-align: center; font-size: x-small;">GÉNERO</th>
									<th width="30%" style="text-align: center; font-size: x-small;">PUEBLOS
										Y NACIONALIDADES</th>
									<th width="15%" style="text-align: center; font-size: x-small;">LINK
										AL MEDIO DE VERIFICACIÓN</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
					</div>
				</div>
				<hr />
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

	$("#btnGuardarGrografica")
			.click(
					function(event) {

						var form = $("#CoberturaGeografica")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							 if(validargenero()==true && validarpueblos()==true){
								 ejecutarJson(form);
								 }
							  
							
						}
						form.addClass('was-validated');

					});

	function tabla() {
		var parametros = {
			"infCod" : '${inf_Cod}'
		};
		$('#TablaCoberturaGeografica')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerCoberturaGeografica",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							responsive : true,
							order : [ 0, "asc" ],
							buttons : [],
							paging : false,
							info : false,
							searching : false,
							responsive : true,
							scrollX : true,
							bDestroy : true,
							columns : [
									{
										data : "contador"
									},
									{
										data : "nivel"
									},
									{
										data : "numeroatencion"
									},
									{
										data : "cobertura"
									},
									{
										data : "numerousuarios"
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											data = '<table class="table registros table-bordered"> <tr> <th style="font-size: 7px;" class="tablainterna" width="3%">MASCULINO</th><th style="font-size: 7px;" class="tablainterna" width="3%">FEMENINO</th><th style="font-size: 7px;" class="tablainterna" width="3%">GLBTI</th> </tr><tr><td>'
													+ full.hombre
													+ '</td><td>'
													+ full.mujer
													+ '</td><td>'
													+ full.glbti
													+ '</td> </tr></table>'
											return data;
										}
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											data = '<table class="table registros table-bordered"> <tr> <th style="font-size: 7px;" class="tablainterna" width="3%">MONTUBIOS</th><th style="font-size: 7px;" class="tablainterna" width="3%">CHOLOS</th><th style="font-size: 7px;" class="tablainterna" width="3%">INDIGENAS</th><th style="font-size: 7px;" class="tablainterna" width="3%">MESTIZOS</th><th style="font-size: 7px;" class="tablainterna" width="3%">AFROECUATORIANOS</th> </tr><tr><td>'
													+ full.montubios
													+ '</td><td>'
													+ full.cholos
													+ '</td><td>'
													+ full.indigenas
													+ '</td> <td>'
													+ full.mestizos
													+ '</td><td>'
													+ full.afroecuatorianos
													+ '</td></tr></table>'
											return data;
										}
									},
									{
										data : "link"
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';
											}
											return data;
										}
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';
											}
											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},

							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.cg_cod);
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

								$(row).find("td:eq(3)").attr('title',
										data.nombres);

							},

						});

	}

	function Modificar(element) {
		var codigo = $(element).closest('tr').attr('id');
		var tipo = $(element).parent().parent().find("td:eq(1)").text();
		var cantidad = $(element).parent().parent().find("td:eq(2)").text();
		var cobertura = $(element).parent().parent().find("td:eq(3)").text();
		var total = $(element).parent().parent().find("td:eq(4)").text();
		var hombres = $(element).parent().parent().find("td:eq(6)").text();
		var mujeres = $(element).parent().parent().find("td:eq(7)").text();
		var glbti = $(element).parent().parent().find("td:eq(8)").text();

		var montubios = $(element).parent().parent().find("td:eq(10)").text();

		var cholos = $(element).parent().parent().find("td:eq(11)").text();
		var indigenas = $(element).parent().parent().find("td:eq(12)").text();
		var mestizos = $(element).parent().parent().find("td:eq(13)").text();
		var afros = $(element).parent().parent().find("td:eq(14)").text();

		var link = $(element).parent().parent().find("td:eq(15)").text();
		$("#actualizar").show();
		$("#tabla").hide();
		$("#botones").hide();

		$("#cg_cod").val(codigo);
		$("#cg_tipocobertura").val(tipo);
		$("#cg_cantidad").val(cantidad);
		$("#cg_desc_cobertura").val(cobertura);
		$("#cg_total").val(total);
		$("#cg_hombres").val(hombres);
		$("#cg_mujeres").val(mujeres);
		$("#cg_glbti").val(glbti);
		$("#cg_montubios").val(montubios);
		$("#cg_mestizos").val(mestizos);
		$("#cg_cholos").val(cholos);
		$("#cg_indigenas").val(indigenas);
		$("#cg_afroecuatoriano").val(afros);
		$("#cg_link").val(link);

	}
	$("#btnGuardarGrograficaActul")
			.click(
					function(event) {
						var form = $("#CoberturaGeograficaActual")
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
								tabla : 'esq_rendicioncuentas.tbl_cobertura_geografica',
								columns : columnas,
								values : valores,
								condicion : 'cg_cod',
								valorcondicion : $("#cg_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});

	function Eliminar(element) {
		var codigo = $(element).closest('tr').attr('id');
		$.ajax({
			url : 'view/rendicion/eliminarDatos',
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST",
			dataType : 'json',
			bDestroy : true,
			data : {
				codigo : codigo,
				tabla : 'esq_rendicioncuentas.tbl_cobertura_geografica',
				campo : 'cg_cod'
			},
			success : function(msg) {
				if (msg.estado == "exito") {
					mostrarMensaje(msg.mensaje, "EXITO");
					var td = element.parentNode;
					var tr = td.parentNode;
					var table = tr.parentNode;
					table.removeChild(tr);
					var nFilas = $("#TablaCoberturaGeografica tr").length - 1;
					if (nFilas == 0) {
						abrir($("#menuAplicacion #menu a.linkAbierto"), null,
								true);
					}

				} else {
					$("#cargando").delay("slow").fadeOut();

					mostrarMensaje(msg.mensaje, "ERROR");
				}
			},
			error : function(result) {

			}
		});
	}


	
	$(".hombres").change(function(){
		validargenero();
		});
	$(".mujeres").change(function() {
		validargenero();
		});
	$(".glbti").change(function() {
		validargenero();
		});
	$(".montubios").change(function() {
		validarpueblos();
		});
	$(".cholos").change(function() {
		validarpueblos();
		});
	$(".indegenas").change(function() {
		validarpueblos();
		});
	$(".mestizo").change(function() {
		validarpueblos();
		});
	$(".afro").change(function() {
		validarpueblos();
		});
	function validargenero() {
		var valida;
		var  h = ($(".hombres").val()===""?0:parseInt($(".hombres").val())) ;
		var m = ($(".mujeres").val()===""?0:parseInt($(".mujeres").val())) ;
		var  gl = ($(".glbti").val()===""?0:parseInt($(".glbti").val())) ; 
		var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
		var total = h+m+gl;
		
		 if(total>usuario)
		 {
			 mostrarMensaje("No se puede exeder el Número de Usuarios Género!", "ERROR");
				$("#btnGuardarGrografica").attr("disabled", true);
				$("#btnGuardarGrograficaActul").attr("disabled", true);
				valida=false;
				
		 }else{
			 $("#btnGuardarGrografica").attr("disabled", false);
				$("#btnGuardarGrograficaActul").attr("disabled", false);
				valida=true;
		 }
		 return valida;
	}

	function validarpueblos() {
		var valida;
		var  mo = ($(".montubios").val()===""?0:parseInt($(".montubios").val())) ;
		var cho = ($(".cholos").val()===""?0:parseInt($(".cholos").val())) ;
		var  ind = ($(".indegenas").val()===""?0:parseInt($(".indegenas").val())) ; 
		var  mes = ($(".mestizo").val()===""?0:parseInt($(".mestizo").val())) ; 
		var  afro = ($(".afro").val()===""?0:parseInt($(".afro").val())) ; 
		var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
		var total = mo+cho+ind+mes+afro;
		
		 if(total>usuario)
		 {
			 mostrarMensaje("No se puede exeder el Número de Usuarios Registrados Nacionalidades O Pueblos!", "ERROR");
			 $("#btnGuardarGrografica").attr("disabled", true);
				$("#btnGuardarGrograficaActul").attr("disabled", true);
				valida=false;	
		 }else{
			 $("#btnGuardarGrografica").attr("disabled", false);
				$("#btnGuardarGrograficaActul").attr("disabled", false);
				valida=true;	
		 }		 
		 return valida;
	}
		
		
</script>
