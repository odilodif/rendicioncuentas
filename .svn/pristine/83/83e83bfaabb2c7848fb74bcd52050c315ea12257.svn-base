<%-- 
	version		: 1.0
    Document  	: Frm_Mecanismos_Autoridades

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
			
			<div class="card-header text-white carHeaderBlue">
							<h5>MECANISMOS DE PARTICIPACION CIUDADANA</h5>
						</div>
				<div class="card-body">
				<div class="row">
				<div class="col-md-12 order-md-1">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblAmecanismosPc" id="AmecanismosPc"
						data-rutaAplicacion="rendicion"
						data-opcion="guardarAmecanismosPc"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
						<div class="row">
							<div class="col-md-12 order-md-1">
								<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso"  width="20%">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th class="tablaingreso" width="20%">PONGA SI O NO</th>
										<th class="tablaingreso" width="60%">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</th>
									<tr>
										<td scope="row">

											ASAMBLEA LOCAL
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc1"
									name="ameDesc1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ameMedio1" name="ameMedio1" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											AUDIENCIA PÚBLICA
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc2"
									name="ameDesc2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ameMedio2" name="ameMedio2" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											CABILDO POPULAR
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc3"
									name="ameDesc3" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ameMedio3" name="ameMedio3" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											CONSEJO DE PLANIFICACIÓN LOCAL
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc4"
									name="ameDesc4" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ameMedio4" name="ameMedio4" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											OTROS
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc5"
									name="ameDesc5" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ameMedio5" name="ameMedio5" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
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
			</div>
		</c:when>
	<c:when test="${inf_estado=='matriz'}">
	<div class="card-body">
	<div class="row">
		<div class="col-md-12 order-md-1">	
		
			<div id="AmecanismosActualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblAmecanismosPc" id="AmecanismosPcActualizar"
						data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos"
						data-accionEnExito="ACTUALIZAR">
						
						<div class="card-header text-white carHeaderBlue">
							<h5>MECANISMOS DE PARTICIPACION CIUDADANA</h5>
						</div>
								<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso"  width="20%">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th class="tablaingreso" width="20%">PONGA SI O NO</th>
										<th class="tablaingreso" width="60%">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</th>
									<tr>
										<td scope="row">
											<input type="text" class="form-control form-control-sm"
													id="ame_tipo" name="ame_tipo" 
												 required="required"  disabled>
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ame_desc"
									name="ame_desc" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ame_medio" name="ame_medio" 
								 required="required" >							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
									</tr>
								</table>
							
						
						<div class="col-md-12 text-center">
				<button type="submit" id="btnAmecanismosActualizar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=ame_cod name="ame_cod">
					</form:form>
				</div>
			
			
			
			<div id="tablaMecanismos">
				<table id="TablaAmecanismosPc"
					class="table table-striped table-bordered" style="width: 100%">
						<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="5" style="font-size: xx-small;"><p style="color: white;">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS</p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">PONGA SI O NO</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</p></th>
							<th></th>
						</tr>
					</thead>
					
				</table>
			</div>
		
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
$(document)
.ready(
		function() {
			$('#tablaMecanismos').show();
			$('#AmecanismosActualizar').hide();

			if ('${inf_estado}' == 'matriz') {
				tabla();
			}

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

			
			if ('${inf_aut_tributo}' == 'SI') {
				$("SinfAutTributo").val("SI");
			}else{
				$("SinfAutTributo").val("NO");
				}
			
		});

$("#btnActualizar").click(function(event) {
$('#tablaMecanismos').hide();
$('#AmecanismosActualizar').show();
});



$("#btnGuardar")
.click(
		function(event) {
			$('#AmecanismosPc').attr('data-opcion',
					'guardarAmecanismosPc');
			var form = $("#AmecanismosPc")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {

				$("#ameMedio1").prop("required", false);
				$("#ameMedio2").prop("required", false);
				$("#ameMedio3").prop("required", false);
				$("#ameMedio4").prop("required", false);
				$("#ameMedio5").prop("required", false);
				
				$("#ameMedio1").removeAttr("disabled");
				$("#ameMedio2").removeAttr("disabled");
				$("#ameMedio3").removeAttr("disabled");
				$("#ameMedio4").removeAttr("disabled");
				$("#ameMedio5").removeAttr("disabled");
				ejecutarJson(form);
			}
			form.addClass('was-validated');

		});


$("#ame_desc").change(function() {
	var seleccion = $("#ame_desc").val();
	if (seleccion == "SI") {
		$(".url").removeAttr("disabled");
		$(".url").prop("required", true);
		$(".url").val("http://");

	} else if (seleccion == "NO") {
		$(".url").val("NO APLICA");
		$(".url").prop("disabled", "disabled");
		$(".url").removeAttr("required");
		

	} else {
		$(".url").val("");
		$(".url").prop("disabled", "disabled");
		$(".url").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

	}

});

$("#ameDesc1").change(function() {
	var seleccion = $("#ameDesc1").val();
	if (seleccion == "SI") {
		$("#ameMedio1").removeAttr("disabled");
		$("#ameMedio1").prop("required", true);
		$("#ameMedio1").val("http://");

	} else if (seleccion == "NO") {
		$("#ameMedio1").val("NO APLICA");
		$("#ameMedio1").prop("disabled", "disabled");
		$("#ameMedio1").removeAttr("required");
	} else {
		$(".ameMedio1").val("");
		$("#ameMedio1").prop("disabled", "disabled");
		$("#ameMedio1").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
});
$("#ameDesc2").change(function() {
	var seleccion = $("#ameDesc2").val();
	if (seleccion == "SI") {
		$("#ameMedio2").removeAttr("disabled");
		$("#ameMedio2").prop("required", true);
		$("#ameMedio2").val("http://");

	} else if (seleccion == "NO") {
		$("#ameMedio2").val("NO APLICA");
		$("#ameMedio2").prop("disabled", "disabled");
		$("#ameMedio2").removeAttr("required");
	} else {
		$(".ameMedio2").val("");
		$("#ameMedio2").prop("disabled", "disabled");
		$("#ameMedio2").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
});
$("#ameDesc3").change(function() {
	var seleccion = $("#ameDesc3").val();
	if (seleccion == "SI") {
		$("#ameMedio3").removeAttr("disabled");
		$("#ameMedio3").prop("required", true);
		$("#ameMedio3").val("http://");

	} else if (seleccion == "NO") {
		$("#ameMedio3").val("NO APLICA");
		$("#ameMedio3").prop("disabled", "disabled");
		$("#ameMedio3").removeAttr("required");
	} else {
		$(".ameMedio3").val("");
		$("#ameMedio3").prop("disabled", "disabled");
		$("#ameMedio3").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
});
$("#ameDesc4").change(function() {
	var seleccion = $("#ameDesc4").val();
	if (seleccion == "SI") {
		$("#ameMedio4").removeAttr("disabled");
		$("#ameMedio4").prop("required", true);
		$("#ameMedio4").val("http://");

	} else if (seleccion == "NO") {
		$("#ameMedio4").val("NO APLICA");
		$("#ameMedio4").prop("disabled", "disabled");
		$("#ameMedio4").removeAttr("required");
	} else {
		$(".ameMedio4").val("");
		$("#ameMedio4").prop("disabled", "disabled");
		$("#ameMedio4").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
});
$("#ameDesc5").change(function() {
	var seleccion = $("#ameDesc5").val();
	if (seleccion == "SI") {
		$("#ameMedio5").removeAttr("disabled");
		$("#ameMedio5").prop("required", true);
		$("#ameMedio5").val("http://");

	} else if (seleccion == "NO") {
		$("#ameMedio5").val("NO APLICA");
		$("#ameMedio5").prop("disabled", "disabled");
		$("#ameMedio5").removeAttr("required");
	} else {
		$(".ameMedio5").val("");
		$("#ameMedio5").prop("disabled", "disabled");
		$("#ameMedio5").removeAttr("required");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
});


function tabla() {
	var parametros = {
		"infAutCod" : '${infAutCod}'
	};
	$('#TablaAmecanismosPc')
			.DataTable(
					{
						ajax : {
							data : parametros,
							url : "obtenerTablaAmecanismosPc",
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
								{data : "contador"},
								{data : "tipo"},
								{data : "descripcion"},
								{data : "medio"},
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
								
								} ],
						language : {
							url : "resources/json/lenguajeTablaDataTable.json"
						},
						createdRow : function(row, data, dataIndex) {
							$(row).attr('id', data.ame_cod);
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
							$(row).find("td:eq(6)").css({
								"vertical-align" : "middle",
							});
						},
					});
}

function Modificar(element) {

	var codigo = $(element).closest('tr').attr('id');
	var tipo = $(element).parent().parent().find("td:eq(1)").text();
	var descripcion = $(element).parent().parent().find("td:eq(2)").text();
	var medio = $(element).parent().parent().find("td:eq(3)").text();

	$("#tablaMecanismos").hide();
	$("#AmecanismosActualizar").show();
	$("#ame_cod").val(codigo);
	$("#ame_tipo").val(tipo);
	$("#ame_desc").val(descripcion);
	$("#ame_medio").val(medio);

}
$("#btnAmecanismosActualizar")
		.click(
				function(event) {
					//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#AmecanismosPcActualizar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {

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
							tabla : 'esq_rendicioncuentas.tbl_amecanismos_pc',
							columns : columnas,
							values : valores,
							condicion : 'ame_cod',
							valorcondicion : $("#ame_cod").val()
						};

					
						
						ejecutarJsonUpdate(form, data);
					}
					form.addClass('was-validated');

				});
</script>
