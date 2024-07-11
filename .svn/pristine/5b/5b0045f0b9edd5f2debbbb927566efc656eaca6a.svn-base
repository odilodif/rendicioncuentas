<%-- 
	version		: 1.0
    Document  	: Frm_ImplemetacionPoliticas
    Created on	: 22/02/2021; 10:52:42
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

<div class="card mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblImplementacionIgualdad"
						id="ImplementacionPoltIgualdad" data-rutaAplicacion="rendicion"
						data-opcion="guardarImplementacionPolitIgualdad" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso" style="font-size: x-small;">POLÍTICAS PÚBLICAS PARA LA IGUALDAD</td>
								<td class="tablaingreso" style="font-size: x-small;">PONGA SI O NO</td>
								<td class="tablaingreso" style="font-size: x-small;">DESCRIBA LA POLÍTICA / PROYECTO / ACCIÓN IMPLEMENTADA</td>
								<td class="tablaingreso" style="font-size: x-small;">DETALLE PRINCIPALES RESULTADOS OBTENIDOS</td>
								<td class="tablaingreso" style="font-size: x-small;">EXPLIQUE COMÓ APORTA EL RESULTADO AL CUMPLIMIENTO DE LAS AGENDAS DE IGUALDAD</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl1" >IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS INTERCULTURALES</label>
								    <input type="hidden" id="polit1" name="polit1" value="IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS INTERCULTURALES">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion1"
									name="seleccion1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case1" id="descripcion1" name="descripcion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case1" id="detalle1" name="detalle1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case1" id="explicacion1" name="explicacion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl2" >IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS GENERACIONALES</label>
								    <input type="hidden" id="polit2" name="polit2" value="IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS GENERACIONALES">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion2"
									name="seleccion2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case2" id="descripcion2" name="descripcion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case2" id="detalle2" name="detalle2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case2" id="explicacion2" name="explicacion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl3" >IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE DISCAPACIDADES</label>
								    <input type="hidden" id="polit3" name="polit3" value="IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE DISCAPACIDADES">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion3"
									name="seleccion3" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case3" id="descripcion3" name="descripcion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case3" id="detalle3" name="detalle3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case3" id="explicacion3" name="explicacion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl4" >IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE GÉNERO</label>
								    <input type="hidden" id="polit4" name="polit4" value="IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE GÉNERO">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion4"
									name="seleccion4" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case4" id="descripcion4" name="descripcion4" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case4" id="detalle4" name="detalle4" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case4" id="explicacion4" name="explicacion4" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl5" >IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE MOVILIDAD HUMANA</label>
								    <input type="hidden" id="polit5" name="polit5" value="IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS DE MOVILIDAD HUMANA">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion5"
									name="seleccion5" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case5" id="descripcion5" name="descripcion5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case5" id="detalle5" name="detalle5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
							    </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm case5" id="explicacion5" name="explicacion5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarIgualdad"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaImpleIgualdad"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</th>
						<th style="font-size: x-small;">PONGA SI O NO</th>
						<th style="font-size: x-small;">DESCRIBA LA POLÍTICA / PROYECTO / ACCIÓN IMPLEMENTADA </th>
						<th style="font-size: x-small;">DETALLE PRINCIPALES RESULTADOS OBTENIDOS</th>
						<th style="font-size: x-small;">EXPLIQUE CÓMO APORTA EL RESULTADO AL CUMPLIMIENTO DE LAS AGENDAS DE IGUALDAD</th>
						<th> </th>
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
		$(".case1").prop("disabled", "disabled");
		$(".case2").prop("disabled", "disabled");
		$(".case3").prop("disabled", "disabled");
		$(".case4").prop("disabled", "disabled");
		$(".case5").prop("disabled", "disabled");
		if ('${inf_estado}' == 'matriz') {
			tabla();			
		}
if('${infestadoinforme}' == 'finalizado'){
			
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

	$("#seleccion1").change(function() {
		var seleccion = $("#seleccion1").val();
		if (seleccion == "SI") {
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			

		} else {
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion2").change(function() {
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {
			$(".case2").removeAttr("disabled");
			$(".case2").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			

		} else {
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion3").change(function() {
		var seleccion = $("#seleccion3").val();
		if (seleccion == "SI") {
			$(".case3").removeAttr("disabled");
			$(".case3").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			

		} else {
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	$("#seleccion4").change(function() {
		var seleccion = $("#seleccion4").val();
		if (seleccion == "SI") {
			$(".case4").removeAttr("disabled");
			$(".case4").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case4").val("");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			

		} else {
			$(".case4").val("");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	$("#seleccion5").change(function() {
		var seleccion = $("#seleccion5").val();
		if (seleccion == "SI") {
			$(".case5").removeAttr("disabled");
			$(".case5").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case5").val("");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			

		} else {
			$(".case5").val("");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	

	$("#btnGuardarIgualdad").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#ImplementacionPoltIgualdad")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {				
					ejecutarJson(form);

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaImpleIgualdad').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerImpletIgualdad",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],	
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,	
		columns : [
			{data : "contador"},
			{data : "politica"},
			{data : "seleccion"}, 
			{data : "descripcion"}, 
			{data : "detalle"}, 
			{data : "explique"},
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{		
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             }
     			  return data; 
     			}}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pi_cod);
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_ImplemetacionPoliticasActul');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});		
				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	
				$(row).find("td:eq(6)").css({
					"vertical-align" : "middle",									
				});				
		
			},	
			
		});

	}

	function Actualizar(element) {	
		$('#TablaImpleIgualdad tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
</script>