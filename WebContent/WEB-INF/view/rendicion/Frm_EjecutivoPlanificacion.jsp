<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoPlanificacion
    Created on	: 19 mar. 2021; 12:47:23
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
						id="PlanificacionParticipativa" data-rutaAplicacion="rendicion"
						data-opcion="guardarPlanificacionPart" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">PLANIFICACIÓN PARTICIPATIVA </h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">PLANIFICACIÓN PARTICIPATIVA</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">LINK DE VERIFICACIÓN</td>
						   </tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl1" >SE HAN IMPLEMENTADO MECANISMOS DE PARTICIPACIÓN CIUDADANA PARA LA FORMULACIÓN DE POLÍTICAS Y PLANES INSTITUCIONALES</label>
								    <input type="hidden" id="part1" name="part1" value="SE HAN IMPLEMENTADO MECANISMOS DE PARTICIPACIÓN CIUDADANA PARA LA FORMULACIÓN DE POLÍTICAS Y PLANES INSTITUCIONALES">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion1"
									name="seleccion1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm url1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
							</tr>
								<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl2" >SE COORDINA CON LAS INSTANCIAS DE PARTICIPACIÓN EXISTENTES EN EL TERRITORIO</label>
								    <input type="hidden" id="part2" name="part2" value="SE COORDINA CON LAS INSTANCIAS DE PARTICIPACIÓN EXISTENTES EN EL TERRITORIO">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion2"
									name="seleccion2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm url2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
							</tr>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarPlanificacion"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			 <div id="actualizar">
			 <div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblImplementacionIgualdad"
						id="PlanificacionParticipativaActul" data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">PLANIFICACIÓN PARTICIPATIVA</h5>
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">PLANIFICACIÓN PARTICIPATIVA</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">INK DE VERIFICACIÓN</td>
						   </tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label id="pla_descripcion"></label>
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="pla_cumple"
									name="pla_cumple" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm url" id="pla_link" name="pla_link" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
							</tr>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarPlanificacionActul"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					
				</form:form>
				<input type="hidden" id="pla_cod" name="pla_cod">
				
			</div>
	
			 </div>
			<div id="tabla" class="col-md-12 order-md-1">
			<table id="TablaPlanificacionPart"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th style="font-size: xx-small;">#</th>
						<th style="font-size: xx-small;">PLANIFICACIÓN PARTICIPATIVA</th>
						<th style="font-size: xx-small;">PONGA SI O NO</th>
						<th style="font-size: xx-small;">LINK DE VERIFICACIÓN</th>					
						<th style="font-size: xx-small;"> </th>
					</tr>
				</thead>
				<tbody>
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
	$(document).ready(function() {
	    $("#actualizar").hide();	
		$(".url1").prop("disabled", "disabled");
		$(".url2").prop("disabled", "disabled");
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
			$(".url1").removeAttr("disabled");
			$(".url1").prop("required", true);
			$(".url1").val("http://");

		} else if (seleccion == "NO") {
			$(".url1").val("");
			$(".url1").prop("disabled", "disabled");
			$(".url1").removeAttr("required");
			

		} else {
			$(".url1").val("");
			$(".url1").prop("disabled", "disabled");
			$(".url1").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion2").change(function() {
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {
			$(".url2").removeAttr("disabled");
			$(".url2").prop("required", true);
			$(".url2").val("http://");

		} else if (seleccion == "NO") {
			$(".url2").val("");
			$(".url2").prop("disabled", "disabled");
			$(".url2").removeAttr("required");
			

		} else {
			$(".url2").val("");
			$(".url2").prop("disabled", "disabled");
			$(".url2").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});

	$("#pla_cumple").change(function() {
		var seleccion = $("#pla_cumple").val();
		if (seleccion == "SI") {
			$(".url").removeAttr("disabled");
			$(".url").prop("required", true);
			$(".url").val("http://");

		} else if (seleccion == "NO") {
			$(".url").val("");
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");
			

		} else {
			$(".url").val("");
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	

	$("#btnGuardarPlanificacion").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#PlanificacionParticipativa")
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
		$('#TablaPlanificacionPart').DataTable({
		ajax : {
		data : parametros,
		url : "PlanificacionParticipativa",
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
			{data : "planificacion"},
			{data : "seleccion"}, 
			{data : "link"}, 			
		    {data: "" ,"render": function (data, type, full, meta) {
					 if('${infestadoinforme}' === "finalizado"){
		           	 data = '';     
		            }else{
		               data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
		            }return data;
		       }},
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pla_cod);	    
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});				
				$(row).find("td:eq(4)").css({
					"vertical-align" : "middle",									
				});				
		
			},	
			
		});

	}

	function Modificar(element) {	
		var codigo = $(element).closest('tr').attr('id');	
		var tipo = $(element).parent().parent().find("td:eq(1)").text();
		var seleccion = $(element).parent().parent().find("td:eq(2)").text();
		var link = $(element).parent().parent().find("td:eq(3)").text();
		  $("#actualizar").show();
		  $("#tabla").hide();	
		 $("#pla_descripcion").text(tipo);
		  if(seleccion=="NO"){
			  $("#pla_cod").val(codigo); 
			  $("#pla_cumple").val(seleccion);			  
			  $("#pla_link").prop("disabled", "disabled");
			  $("#pla_link").removeAttr("required");
			  $("#pla_link").val(null);
		     }
		  else{
			  $("#pla_cod").val(codigo);	 
			  $("#pla_cumple").val(seleccion);
			  $("#pla_link").val(link);
			}
		  
		 		  
	}
	$("#btnGuardarPlanificacionActul").click(
			function(event) {
				var form = $("#PlanificacionParticipativaActul")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {				
					  $("#pla_link").removeAttr("disabled");
					var columnas = '';
					 var x = $(form).serializeArray();
					    $.each(x, function(i, field){
					    	columnas+= field.name+ ',99';
					    	if (columnas.length > 0) {
					    		columnas = columnas.substr(0, columnas.length - 1);
	                        }
					    });
					    var valores = '';
						 var x = $(form).serializeArray();
						    $.each(x, function(i, field){
						    	valores+= field.value+ ',99';
						    	if (valores.length > 0) {
						    		valores = valores.substr(0, valores.length - 1);
		                        }
						    });
					  var data = {tabla: 'esq_rendicioncuentas.tbl_planificacion_participativa',columns:columnas,values:valores,condicion:'pla_cod',valorcondicion:$("#pla_cod").val()};
					  
					  ejecutarJsonUpdate(form,data);
				}
				form.addClass('was-validated');

			});	
	 
</script>