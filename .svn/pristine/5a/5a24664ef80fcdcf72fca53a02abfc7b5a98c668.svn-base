<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasGadFase4
    Created on	: 01/03/2021; 9:14:10
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
						modelAttribute="TblMecanismoRendicionCuentas"
						id="RendicionCuentasFase4" data-rutaAplicacion="rendicion"
						data-opcion="guardarRendiconCuentasFase4" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>

					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
							<td class="tablaingreso">FASES</td>
								<td class="tablaingreso">PROCESO DE RENDICIÓN DE CUENTAS</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">DESCRIBA LA EJECUCIÓN DE LOS PASOS</td>
								<td class="tablaingreso">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td class="tablaingreso">OBSERVACIONES</td>
							</tr>
							<tr>
							 <td style="vertical-align: middle; font-size: x-small; width: 50px;" rowspan="9">
							 <label for="fase4" >FASE 4</label>
								    <input type="hidden" id="fase4" name="fase4" value="FASE 4">
							 </td>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl1" >1. LA ENTIDAD  ELABORÓ UN PLAN DE TRABAJO PARA INCORPORAR LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN</label>
								    <input type="hidden" id="rc1" name="rc1" value="1. LA ENTIDAD  ELABORÓ UN PLAN DE TRABAJO PARA INCORPORAR LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN">
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
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion1" id="descripcion1" name="descripcion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion1" id="observacion1" name="observacion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese el observación</div>
								 </td>														
							</tr>
							
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;"><label for="lbl2" >2. LA ENTIDAD ENTREGÓ EL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA, AL CONSEJO DE PLANIFICACIÓN Y A LA INSTANCIA DE PARTICIPACIÓN PARA SU MONITOREO</label>
								    <input type="hidden" id="rc2" name="rc2" value="2. LA ENTIDAD ENTREGÓ EL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA, AL CONSEJO DE PLANIFICACIÓN Y A LA INSTANCIA DE PARTICIPACIÓN PARA SU MONITOREO">
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
								  <td align="center" style="vertical-align: middle; font-size: x-small; ">
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="LA ASAMBLEA CIUDADANA"> LA ASAMBLEA CIUDADANA</label></td>											
										</tr>
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="dos"><input type="checkbox" class="case"
													 name="checks[]" value="CONSEJO DE PLANIFICACIÓN">
													CONSEJO DE PLANIFICACIÓN</label></td>										
										
										</tr>
										<tr>
														
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="tres"><input type="checkbox" class="case"
													 name="checks[]" value="INSTANCIA DE PARTICIPACIÓN"> INSTANCIA DE PARTICIPACIÓN</label></td>
										</tr>										

									</table>
									
								    <input type="hidden" class="form-control form-control-sm descripcion2" id="descripcion2" name="descripcion2"  >
									<div class="invalid-feedback">Seleccione al menos un check</div>

								</td>
							
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion2" id="observacion2" name="observacion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarRendicionCuentasF4"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaRendicionFase4"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">PROCESO DE RENDICIÓN DE CUENTAS</th>
						<th style="font-size: x-small;">PONGA SI O NO</th>
						<th style="font-size: x-small;">DESCRIBA LA EJECUCIÓN DE LOS PASOS</th>
						<th style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>
						<th style="font-size: x-small;">OBSERVACIONES</th>
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
		$(".case").prop("disabled", "disabled");
		$(".case1").prop("disabled", "disabled");
		$(".descripcion1").prop("disabled", "disabled");
		$(".observacion1").prop("disabled", "disabled");		
		$(".case2").prop("disabled", "disabled");
		$(".descripcion2").prop("disabled", "disabled");
		$(".observacion2").prop("disabled", "disabled");
		
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
		 $('[name="checks[]"]').click(function() {		      
			    var arr = $('[name="checks[]"]:checked').map(function(){
			      return this.value;
			    }).get();
			    var str = arr.join('<br>');	
			    $('#descripcion2').val(str);			  
			  });
		
	});

   $("#seleccion1").change(function() {
	     var url;
		   url=document.getElementById("link1");
				var seleccion = $("#seleccion1").val();
				if (seleccion == "SI") {			
					$(".observacion1").val(""); 
					$(".descripcion1").val(""); 
					$(".case1").val("http://");
					$(".case1").removeAttr("disabled");
					$(".case1").prop("required", true);
					$(".descripcion1").removeAttr("disabled");
					$(".descripcion1").prop("required", true);
					$(".observacion1").removeAttr("disabled");
					$(".observacion1").removeAttr("required");
					url.type = "url";
					
				} else if (seleccion == "NO") {
					$(".observacion1").val("S/N"); 
					$(".descripcion1").val("S/N");
					$(".case1").val("NO APLICA");
					$(".case1").prop("disabled", "disabled");
					$(".case1").removeAttr("required");
					$(".descripcion1").prop("disabled", "disabled");
					$(".descripcion1").removeAttr("required");
					$(".observacion1").prop("disabled", "disabled");
					$(".observacion1").removeAttr("required");
					url.type = "text";

				} else {
					$(".observacion1").val(""); 
					$(".descripcion1").val("");
					$(".case1").val("");
					$(".case1").prop("disabled", "disabled");
					$(".case1").removeAttr("required");
					$(".descripcion1").prop("disabled", "disabled");
					$(".descripcion1").removeAttr("required");
					$(".observacion1").prop("disabled", "disabled");
					$(".observacion1").removeAttr("required");
					url.type = "url";
					mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

				}

			});
			
			
	$("#seleccion2").change(function() {
		var url;
		 url=document.getElementById("link2");
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {									
			$(".observacion2").val(""); 
			$(".descripcion2").val(""); 
			$(".case2").val("http://");
			$(".case2").removeAttr("disabled");
			$(".case2").prop("required", true);
			$(".descripcion2").removeAttr("disabled");
			$(".descripcion2").prop("required", true);
			$(".observacion2").removeAttr("disabled");
			$(".observacion2").removeAttr("required");			
			$(".case").removeAttr("disabled");
			url.type = "url";
			
		} else if (seleccion == "NO") {
			$(".observacion2").val("S/N"); 
			$(".descripcion2").val("S/N");
			$(".case2").val("NO APLICA");
			$(".case2").get().type = 'text';
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".descripcion2").prop("disabled", "disabled");
			$(".descripcion2").removeAttr("required");
			$(".observacion2").removeAttr("required");
			$(".observacion2").removeAttr("required");
			$(".case").prop("checked", false);
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "text";
			

		} else {
			$(".observacion2").val(""); 
			$(".descripcion2").val("");
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".descripcion2").prop("disabled", "disabled");
			$(".descripcion2").removeAttr("required");
			$(".observacion2").prop("disabled", "disabled");
			$(".observacion2").removeAttr("required");
			$(".case").prop("checked", false);
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		
		}
	});
	
	$("#btnGuardarRendicionCuentasF4").click(function(event) {
		var form = $("#RendicionCuentasFase4")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {	
					var seleccion = $("#seleccion2").val();
					if (seleccion == "SI") {
					if ($('input[type=checkbox]:checked').length === 0) {
					mostrarMensaje("Debe seleccionar al menos un valor de los checkbox","ERROR-NOTIFICACION");

					} else{
						desbloqueo();
						ejecutarJson(form);

						}
					}
					 else {
					
						 desbloqueo();
						ejecutarJson(form);

					      }

					
			}
			form.addClass('was-validated');

	});

function desbloqueo(){
	  $(".case1").removeAttr("disabled");
		$(".descripcion1").removeAttr("disabled");
		$(".observacion1").removeAttr("disabled");
		$(".case2").removeAttr("disabled");
		$(".descripcion2").removeAttr("disabled");
		$(".observacion2").removeAttr("disabled");	
	
}
	
	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaRendicionFase4').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerRendicionFase4",
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
			{data : "proceso"},
			{data : "seleccion"}, 
			{data : "describa"},
			{data : "link"}, 
			{data : "observaciones"},
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
				$(row).attr('id', data.mecanismo_cod);
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_RendicionCuentasGadFasesActl');
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
		$('#TablaRendicionFase4 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
	
</script>