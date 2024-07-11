<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoIncorporacion
    Created on	: 01/03/2021; 12:32:08
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
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card  mb-card22"
	style="width: 100%; height: auto; overflow: scroll;">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblIncoporacionRecomendaciones"
					id="IncorporacionRecomendaciones" data-rutaAplicacion="rendicion"
					data-opcion="guardarRecomenIncorp" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">INCORPORACIÓN
						DE RECOMENDACIONES Y DICTÁMENES</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">


						<table class="table registros table-bordered">
							<tr>
								<td colspan="2" class="tablaingreso" align="center"
									style="font-size: x-small;">INCORPORACIÓN DE
									RECOMENDACIONES Y DICTÁMENES POR PARTE DE LAS ENTIDADES DE LA
									FUNCIÓN DE TRANSPARENCIA Y CONTROL SOCIAL, LA PROCURADURÍA
									GENERAL DEL ESTADO Y CACES</td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="entidad">ENTIDAD
										QUE RECOMIENDA </label></td>
								<td style="font-size: x-small;"><select
									class="custom-select custom-select-sm" id="seleccion"
									name="seleccion" required="required">
										<option value="">Seleccione...</option>
										<option value="CONTRALORÍA GENERAL DEL ESTADO">CONTRALORÍA
											GENERAL DEL ESTADO</option>
										<option value="SUPERINTENDENCIA DE ORDENAMIENTO TERRITORIAL">SUPERINTENDENCIA
												 DE ORDENAMIENTO TERRITORIAL</option>
										<option value="SUPERINTENDENCIA DE BANCOS Y SEGUROS">SUPERINTENDENCIA
											DE BANCOS Y SEGUROS</option>
										<option value="SUPERINTENDENCIA DE COMPAÑIAS Y VALORES">SUPERINTENDENCIA
											DE COMPAÑIAS Y VALORES</option>
										<option value="SUPERINTENDENCIA DE TELECOMUNICACIONES">SUPERINTENDENCIA
											DE TELECOMUNICACIONES</option>
										<option value="DEFENSORÍA DEL PUEBLO">DEFENSORÍA DEL
											PUEBLO</option>
										<option
											value="CONSEJO DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL">CONSEJO
											DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL</option>
										<option
											value="SUPERINTENDENCIA DE ECONOMÍA POPULAR Y SOLIDARIA">SUPERINTENDENCIA
											DE ECONOMÍA POPULAR Y SOLIDARIA</option>
										<option
											value="SUPERINTENDENCIA DE CONTROL DEL PODER DE MERCADO">SUPERINTENDENCIA
											DE CONTROL DEL PODER DE MERCADO</option>
										<option
											value="CONSEJO DE REGULACION Y DESARROLLO DE LA INFORMACION Y COMUNICACIÓN">CONSEJO
											DE REGULACION Y DESARROLLO DE LA INFORMACION Y COMUNICACIÓN</option>
										<option value="PROCURADURÍA GENERAL DEL ESTADO">PROCURADURÍA
											GENERAL DEL ESTADO</option>
										<option
											value="CONSEJO DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR">CONSEJO
											DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR</option>
										<option
											value="NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR">NO
											HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR</option>
								</select>
									<div class="invalid-feedback">Seleccione una opción</div></td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="InformeR">NO.
										DE INFORME DE LA ENTIDAD QUE RECOMIENDA</label></td>
								<td style="font-size: x-small;"><textarea rows="1"
										class="form-control form-control-sm case" id="informeRecom"
										name="informeRecom" required="required"></textarea>
									<div class="invalid-feedback">Por favor Ingrese el N° de
										informe de la entidad que recomienda</div></td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="InformeC">NO.
										DE INFORME DE CUMPLIMIENTO</label></td>
								<td style="font-size: x-small;"><textarea rows="1"
										class="form-control form-control-sm case" id="informeCumpli"
										name="informeCumpli" required="required"></textarea>
									<div class="invalid-feedback">Por favor Ingrese el N° de
										informe</div></td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="porcetaje">%
										DE CUMPLIMIENTO DE LAS RECOMENDACIONES</label></td>
								<td style="font-size: x-small;"><input type="number"
									onkeypress="javascript:return validarnro(event);"
									id="porcentaje" name="porcentaje" min="" max="100" step="0.01"
									class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="observacion">OBSERVACIONES</label></td>
								<td style="font-size: x-small;"><textarea rows="1"
										class="form-control form-control-sm case" id="observacion"
										name="observacion" required="required"></textarea>
									<div class="invalid-feedback">Por favor Ingrese el N° de
										informe</div></td>
							</tr>
							<tr>
								<td style="font-size: x-small;"><label for="observacion">LINK
										AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
										INSTITUCIÓN</label></td>
								<td style="font-size: x-small;"><input type="url"
									class="form-control form-control-sm url" id="link" name="link"
									required="required" placeholder="Dirección de página web">
									<div class="invalid-feedback">Por favor ingrese su página
										web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>

						</table>



					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarIncorpRecom"
							class="btn _nuevoColor _guardar btn-sm mt-2">Añadir</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">

			<c:choose>
				<c:when test="${infestadoinforme=='activo'}">
					<div class="row justify-content-center align-items-center">
						<div id="botones" class="botones" role="group">
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
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblIncoporacionRecomendaciones"
						id="IncorporacionRecomendacionesActual"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-accionEnExito="ACTUALIZAR">
						<h5 class="card-header text-white carHeaderBlue" align="center">INCORPORACIÓN
							DE RECOMENDACIONES Y DICTÁMENES</h5>
						<div class="col-md-12 text-left">


							<table class="table registros table-bordered">
								<tr>
									<td colspan="2" class="tablaingreso" align="center"
										style="font-size: x-small;">INCORPORACIÓN DE
										RECOMENDACIONES Y DICTÁMENES POR PARTE DE LAS ENTIDADES DE LA
										FUNCIÓN DE TRANSPARENCIA Y CONTROL SOCIAL, LA PROCURADURÍA
										GENERAL DEL ESTADO Y CEAACES</td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label for="ire_entidad">ENTIDAD
											QUE RECOMIENDA </label></td>
									<td style="font-size: x-small;"><select
										class="custom-select custom-select-sm" id="ire_entidad"
										name="ire_entidad" required="required">
											<option value="">Seleccione...</option>
											<option value="CONTRALORÍA GENERAL DEL ESTADO">CONTRALORÍA
												GENERAL DEL ESTADO</option>
											<option value="SUPERINTENDENCIA DE ORDENAMIENTO TERRITORIAL">SUPERINTENDENCIA
												 DE ORDENAMIENTO TERRITORIAL</option>
											<option value="SUPERINTENDENCIA DE BANCOS Y SEGUROS">SUPERINTENDENCIA
												DE BANCOS Y SEGUROS</option>
											<option value="SUPERINTENDENCIA DE COMPAÑIAS Y VALORES">SUPERINTENDENCIA
												DE COMPAÑIAS Y VALORES</option>
											<option value="SUPERINTENDENCIA DE TELECOMUNICACIONES">SUPERINTENDENCIA
												DE TELECOMUNICACIONES</option>
											<option value="DEFENSORÍA DEL PUEBLO">DEFENSORÍA DEL
												PUEBLO</option>
											<option
												value="CONSEJO DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL">CONSEJO
												DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL</option>
											<option
												value="SUPERINTENDENCIA DE ECONOMÍA POPULAR Y SOLIDARIA">SUPERINTENDENCIA
												DE ECONOMÍA POPULAR Y SOLIDARIA</option>
											<option
												value="SUPERINTENDENCIA DE CONTROL DEL PODER DE MERCADO">SUPERINTENDENCIA
												DE CONTROL DEL PODER DE MERCADO</option>
											<option
												value="CONSEJO DE REGULACIÓN, DESARROLLO Y PROMOCIÓN DE LA INFORMACIÓN Y COMUNICACIÓN">CONSEJO
												DE REGULACIÓN, DESARROLLO Y PROMOCIÓN DE LA INFORMACIÓN Y
												COMUNICACIÓN</option>
											<option value="PROCURADURÍA GENERAL DEL ESTADO">PROCURADURÍA
												GENERAL DEL ESTADO</option>
											<option
												value="CONSEJO DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR">CONSEJO
												DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR</option>
											<option
												value="NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR">NO
												HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR</option>
									</select>
										<div class="invalid-feedback">Seleccione una opción</div></td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label
										for="ire_descripcion">NO. DE INFORME DE LA ENTIDAD QUE
											RECOMIENDA</label></td>
									<td style="font-size: x-small;"><textarea rows="1"
											class="form-control form-control-sm case"
											id="ire_descripcion" name="ire_descripcion"
											required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe de la entidad que recomienda</div></td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label
										for="ire_cumplimiento">NO. DE INFORME DE CUMPLIMIENTO</label></td>
									<td style="font-size: x-small;"><textarea rows="1"
											class="form-control form-control-sm case"
											id="ire_cumplimiento" name="ire_cumplimiento"
											required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe</div></td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label
										for="ire_porcentaje">% DE CUMPLIMIENTO DE LAS
											RECOMENDACIONES</label></td>
									<td style="font-size: x-small;"><input type="number"
										onkeypress="javascript:return validarnro(event);"
										id="ire_porcentaje" name="ire_porcentaje" min="" max="100"
										step="0.01" class="form-control form-control-sm number">
										<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label for="ire_obs">OBSERVACIONES</label></td>
									<td style="font-size: x-small;"><textarea rows="1"
											class="form-control form-control-sm case" id="ire_obs"
											name="ire_obs" required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe</div></td>
								</tr>
								<tr>
									<td style="font-size: x-small;"><label for="ire_link">LINK
											AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
											INSTITUCIÓN</label></td>
									<td style="font-size: x-small;"><input type="url"
										class="form-control form-control-sm url" id="ire_link"
										name="ire_link" required="required"
										placeholder="Dirección de página web">
										<div class="invalid-feedback">Por favor ingrese su
											página web con el siguiente formato
											http://dirreccionDePaginaWeb</div></td>
								</tr>

							</table>


						</div>

					</form:form>


				</div>

				<div class="col-md-12 text-center">
					<button type="submit" id="btnActualizar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
				</div>
				<input type="hidden" id="ire_cod" name="ire_cod">
			</div>
			<div id="tabla" class="col-md-12 order-md-1">
				<div class="ibox-content">
					<div class="table-responsive">
						<table id="TablaIncorporacionRecom"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th style="font-size: x-small;">#</th>
									<th style="font-size: x-small;">ENTIDAD QUE RECOMIENDA</th>
									<th style="font-size: x-small;">NO. DE INFORME DE LA
										ENTIDAD QUE RECOMIENDA</th>
									<th style="font-size: x-small;">NO. DE INFORME DE
										CUMPLIMIENTO</th>
									<th style="font-size: x-small;">% DE CUMPLIMIENTO DE LAS
										RECOMENDACIONES</th>
									<th style="font-size: x-small;">OBSERVACIONES</th>
									<th style="font-size: x-small;">LINK AL MEDIO DE
										VERIFICACIÓN</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>

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
		$(".case").prop("disabled", "disabled");
		$(".number").prop("disabled", "disabled");
		$(".url").prop("disabled", "disabled");
		if ('${inf_estado}' == 'matriz') {
			tabla();
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

	$("#seleccion")
			.change(
					function() {
						var url;
						url = document.getElementById("link");
						var seleccion = $("#seleccion").val();
						if (seleccion != "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {

							$(".case").val("");
							$(".case").removeAttr("disabled");
							$(".case").prop("required", true);
							$(".number").val("");
							$(".number").removeAttr("disabled");
							$(".number").prop("required", true);
							$(".url").val("http://");
							$(".url").removeAttr("disabled");
							$(".url").prop("required", true);
							url.type = "url";

						} else if (seleccion == "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {
							$(".case").val("S/N");
							$(".case").prop("disabled", "disabled");
							$(".case").removeAttr("required");
							$(".number").val("0");
							$(".number").prop("disabled", "disabled");
							$(".number").removeAttr("required");
							$(".url").val("NO APLICA");
							$(".url").prop("disabled", "disabled");
							$(".url").removeAttr("required");
							url.type = "text";

						} else {
							$(".case").val("");
							$(".case").prop("disabled", "disabled");
							$(".case").removeAttr("required");
							$(".number").val("");
							$(".number").prop("disabled", "disabled");
							$(".number").removeAttr("required");
							$(".url").val("");
							$(".url").prop("disabled", "disabled");
							$(".url").removeAttr("required");
							url.type = "url";
							mostrarMensaje("Seleccione una opcion",
									"ERROR-NOTIFICACION");

						}

					});

	$("#ire_entidad")
			.change(
					function() {
						var url;
						url = document.getElementById("ire_link");
						var seleccion = $("#ire_entidad").val();
						if (seleccion != "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {

							$(".case").val("");
							$(".case").removeAttr("disabled");
							$(".case").prop("required", true);
							$(".number").val("");
							$(".number").removeAttr("disabled");
							$(".number").prop("required", true);
							$(".url").val("http://");
							$(".url").removeAttr("disabled");
							$(".url").prop("required", true);
							url.type = "url";

						} else if (seleccion == "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {
							$(".case").val("S/N");
							$(".case").prop("disabled", "disabled");
							$(".case").removeAttr("required");
							$(".number").val("0");
							$(".number").prop("disabled", "disabled");
							$(".number").removeAttr("required");
							$(".url").val("NO APLICA");
							$(".url").prop("disabled", "disabled");
							$(".url").removeAttr("required");
							url.type = "text";

						} else {
							$(".case").val("");
							$(".case").prop("disabled", "disabled");
							$(".case").removeAttr("required");
							$(".number").val("");
							$(".number").prop("disabled", "disabled");
							$(".number").removeAttr("required");
							$(".url").val("");
							$(".url").prop("disabled", "disabled");
							$(".url").removeAttr("required");
							url.type = "url";
							mostrarMensaje("Seleccione una opcion",
									"ERROR-NOTIFICACION");

						}

					});

	$("#btnGuardarIncorpRecom")
			.click(
					function(event) {
						var form = $("#IncorporacionRecomendaciones")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							$(".case").removeAttr("disabled");
							$(".number").removeAttr("disabled");
							$(".url").removeAttr("disabled");
							ejecutarJson(form);
						}
						form.addClass('was-validated');

					});

	function tabla() {
		var parametros = {
			"infCod" : '${inf_Cod}'
		};
		$('#TablaIncorporacionRecom')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerIncorporacionRecom",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
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
										data : "entidad"
									},
									{
										data : "informeRecom"
									},
									{
										data : "informeCumpl"
									},
									{
										data : "porcentaje"
									},
									{
										data : "observacion"
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
												data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';
											}
											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},

							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.ireCod);
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
								$(row).find("td:eq(7)").css({
									"vertical-align" : "middle",
								});
								$(row).find("td:eq(8)").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	function Eliminar(element) {
		var codigo = $(element).closest('tr').attr('id');
		$
				.ajax({
					url : 'view/rendicion/eliminarDatos',
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST",
					dataType : 'json',
					data : {
						codigo : codigo,
						tabla : 'esq_rendicioncuentas.tbl_incoporacion_recomendaciones',
						campo : 'ire_cod'
					},
					success : function(msg) {
						if (msg.estado == "exito") {
							mostrarMensaje(msg.mensaje, "EXITO");
							var td = element.parentNode;
							var tr = td.parentNode;
							var table = tr.parentNode;
							table.removeChild(tr);
							var nFilas = $("#TablaIncorporacionRecom tr").length - 1;

							if (nFilas == 0) {
								abrir($("#menuAplicacion #menu a.linkAbierto"),
										null, true);
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

	function Modificar(element) {
		var codigo = $(element).closest('tr').attr('id');
		var cant1 = $(element).parent().parent().find("td:eq(1)").text();
		var cant2 = $(element).parent().parent().find("td:eq(2)").text();
		var cant3 = $(element).parent().parent().find("td:eq(3)").text();
		var cant4 = $(element).parent().parent().find("td:eq(4)").text();
		var cant5 = $(element).parent().parent().find("td:eq(5)").text();
		var cant6 = $(element).parent().parent().find("td:eq(6)").text();

		$("#actualizar").show();
		$("#tabla").hide();
		$("#botones").hide();

		$("#ire_cod").val(codigo);
		$("#ire_entidad").val(cant1);
		$("#ire_descripcion").val(cant2);
		$("#ire_cumplimiento").val(cant3);
		$("#ire_porcentaje").val(cant4);
		$("#ire_obs").val(cant5);
		$("#ire_link").val(cant6);
		var url;
		url = document.getElementById("ire_link");
		if (cant1 !== "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {

			$(".case").removeAttr("disabled");
			$(".number").removeAttr("disabled");
			$(".url").removeAttr("disabled");
			url.type = "url";

		} else {
			$(".case").prop("disabled", "disabled");
			$(".number").prop("disabled", "disabled");
			$(".url").prop("disabled", "disabled");
			url.type = "text";

		}
	}

	$("#btnActualizar")
			.click(
					function(event) {
						var form = $("#IncorporacionRecomendacionesActual")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							$(".case").removeAttr("disabled");
							$(".number").removeAttr("disabled");
							$(".url").removeAttr("disabled");
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
								tabla : 'esq_rendicioncuentas.tbl_incoporacion_recomendaciones',
								columns : columnas,
								values : valores,
								condicion : 'ire_cod',
								valorcondicion : $("#ire_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});
</script>