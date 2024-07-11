<%-- 
	version		: 1.0
    Document  	: Frm_CumplimientoFunciones_Autoridad.jsp
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
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


<c:choose>
	<c:when test="${inf_estado=='activo'}">
		<div class="card text-center mb-card20">

			<div class="card-header text-white carHeaderBlue">
				<h5>CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE
					LA AUTORIDAD</h5>
			</div>
<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Ingrese uno a uno las registos</div>
		</div>
			<div class="card-body">

				<div class="card card-secondary">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblFuncionesAutoridades" id="FuncionesAutoridades"
						data-rutaAplicacion="rendicion"
						data-opcion="guardarFuncionesAutoridades"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered">

								<tr>
									<td scope="row" width="20%">FUNCIÓN ATRIBUIDA POR LA CONSTITUCIÓN Y LA LEY</td>
									<td scope="row" width="80%"><textarea rows="2" cols=""
											class="form-control form-control-sm" id=faFuncion
											required="required" name="faFuncion"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">PRINCIPALES ACCIONES REALIZADAS PARA
										CUMPLIR CON LAS FUNCIONES A SU CARGO</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faAcciones"
											required="required" name="faAcciones"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">PRINCIPALES RESULTADOS ALCANZADOS EN EL
										CUMPLIMIENTO DE SUS FUNCIONES</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faResultado"
											required="required" name="faResultado"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">OBSERVACIONES</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faObs"
											required="required" name="faObs"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>

							</table>

						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarI"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>


	</c:when>

	<c:when test="${inf_estado=='matriz'}">


		<div id="ActualizarDatos">

			<form:form class="needs-validation" novalidate=""
				modelAttribute="TblFuncionesAutoridades"
				id="ActualziarFuncionesAutoridades" data-rutaAplicacion="rendicion"
				data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
				<div class="card-header text-white carHeaderBlue">
					<h5>CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE
						LA AUTORIDAD</h5>
				</div>
				<div class="table-responsive">
					<table class="table registros table-bordered">

						<tr>
							<td scope="row" width="20%">FUNCIONES ATRIBUÍDAS POR LA
								CONSTITUCIÓN Y LA LEY</td>
							<td scope="row" width="80%"><textarea rows="2" cols=""
									class="form-control form-control-sm" id=fa_funcion
									required="required" name="fa_funcion"></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>


							</td>
						</tr>
						<tr>
							<td scope="row">PRINCIPALES ACCIONES REALIZADAS PARA CUMPLIR
								CON LAS FUNCIONES A SU CARGO</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_acciones"
									required="required" name="fa_acciones" ></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
						<tr>
							<td scope="row">PRINCIPALES RESULTADOS ALCANZADOS EN EL
								CUMPLIMIENTO DE SUS FUNCIONES</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_resultado"
									required="required" name="fa_resultado"></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
						<tr>
							<td scope="row">OBSERVACIONES</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_obs"
									required="required" name="fa_obs" ></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
					</table>
				</div>
			</form:form>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualziarFuncionesAutoridades"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=fa_cod name="fa_cod">
		</div>
		<div id="Datos">
			<div class="card text-center mb-card20">
				<div class="card-body">


					<c:choose>
						<c:when test="${infestadoinforme=='activo'}">
							<div class="row justify-content-center align-items-center">
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
					<table id="TablaFuncionesAutoridades"
						class="table table-striped table-bordered" style="width: 100%">
						<thead style="background-color: rgb(31, 137, 72);">
							<tr>
								<th colspan="7" style="font-size: x-small;"><p
										style="color: white;">CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE
					LA AUTORIDAD</p></th>
							</tr>

							<tr>
								<th width="6%" style="font-size: xx-small;">#</th>
								<th width="21%" style="font-size: xx-small;">FUNCIONES ATRIBUÍDAS POR LA
								CONSTITUCIÓN Y LA LEY</th>
								<th width="21%" style="font-size: xx-small;">PRINCIPALES ACCIONES REALIZADAS PARA CUMPLIR
								CON LAS FUNCIONES A SU CARGO</th>
								<th width="21%" style="font-size: xx-small;">PRINCIPALES RESULTADOS ALCANZADOS EN EL
								CUMPLIMIENTO DE SUS FUNCIONES</th>
								<th width="21%" style="font-size: xx-small;">OBSERVACIONES</th>
								<th width="5%"></th>
								<th width="5%"></th>
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

</html>

<script type="text/javascript">

	$(document).ready(function() {
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
		$("#Datos").show();
		$("#ActualizarDatos").hide();
	});

	$("#btnGuardarI")
			.click(
					function(event) {
						var form = $("#FuncionesAutoridades")
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
			"infAutCod" : '${infAutCod}'
		};

		$('#TablaFuncionesAutoridades')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerFuncionesAutoridades",
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
										data : "funcion"
									},
									{
										data : "accion"
									},
									{
										data : "resultado"
									},
									{
										data : "observacion"
									},

									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
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
												data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;" > Eliminar</button>';
											}
											return data;
										}
									} ],
							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},
							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.fa_cod);
								//$(row).attr('class', 'item');
								//$(row).attr('data-rutaAplicacion', '');
								//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td:eq(3)").attr('title',
										data.nombres);

								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td").css({
									"vertical-align" : "middle",
								});
							},
						});
	}

	function Eliminar(element) {
		var codigo = $(element).closest('tr').attr('id');
	
		$.ajax({
			url : 'view/rendicion/eliminarDatos',
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST",
			dataType : 'json',
			data : {
				codigo : codigo,
				tabla : 'esq_rendicioncuentas.tbl_funciones_autoridades',
				campo : 'fa_cod'
			},
			success : function(msg) {
				if (msg.estado == "exito") {
					mostrarMensaje(msg.mensaje, "EXITO");

					var td = element.parentNode;
					var tr = td.parentNode;
					var table = tr.parentNode;
					table.removeChild(tr);
					var nFilas = $("#TablaFuncionesAutoridades tr").length - 2;
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

	function Modificar(element) {

		var codigo = $(element).closest('tr').attr('id');
		var faFuncion = $(element).parent().parent().find("td:eq(1)").text();
		var faAcciones = $(element).parent().parent().find("td:eq(2)").text();
		var faResultado = $(element).parent().parent().find("td:eq(3)").text();
		var faObs = $(element).parent().parent().find("td:eq(4)").text();

		$("#Datos").hide();
		$("#ActualizarDatos").show();
		$("#fa_cod").val(codigo);
		$("#fa_funcion").val(faFuncion);
		$("#fa_acciones").val(faAcciones);
		$("#fa_resultado").val(faResultado);
		$("#fa_obs").val(faObs);

	}
	$("#btnActualziarFuncionesAutoridades")
			.click(
					function(event) {
						//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
						var form = $("#ActualziarFuncionesAutoridades")
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
								tabla : 'esq_rendicioncuentas.tbl_funciones_autoridades',
								columns : columnas,
								values : valores,
								condicion : 'fa_cod',
								valorcondicion : $("#fa_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});
</script>