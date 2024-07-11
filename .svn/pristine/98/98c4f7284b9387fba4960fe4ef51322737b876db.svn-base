<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasGadFase1
    Created on	: 25/02/2021; 10:35:04
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
						id="RendicionCuentasFase1" data-rutaAplicacion="rendicion"
						data-opcion="guardarRendiconCuentasFase1" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>

					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
							<td class="tablaingreso">FASES</td>
								<td class="tablaingreso" style="font-size: x-small;">PROCESO DE RENDICIÓN DE CUENTAS</td>
								<td class="tablaingreso" style="font-size: x-small;">PONGA SI O NO</td>
								<td class="tablaingreso" style="font-size: x-small;">DESCRIBA LA EJECUCIÓN DE LOS PASOS</td>
								<td class="tablaingreso" style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td class="tablaingreso" style="font-size: x-small;">OBSERVACIONES</td>
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px; font-size: x-small;" rowspan="3">
							 <label for="fase1" >FASE 1</label>
								    <input type="hidden" id="fase1" name="fase1" value="FASE 1">
							 </td>
								<td style="vertical-align: middle; width: 200px; font-size: x-small;">
								<label for="lbl1" >1. LA CIUDADANÍA / ASAMBLEA LOCAL CIUDADANA PRESENTÓ LA LISTA DE TEMAS SOBRE LOS QUE DESEA SER INFORMADA</label>
								    <input type="hidden" id="rc1" name="rc1" value="1. LA CIUDADANÍA / ASAMBLEA LOCAL CIUDADANA PRESENTÓ LA LISTA DE TEMAS SOBRE LOS QUE DESEA SER INFORMADA">
								</td>
								<td style="vertical-align: middle; width: 120px; font-size: x-small;">
								<select
									class="custom-select custom-select-sm" id="seleccion1"
									name="seleccion1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px; font-size: x-small;">
								<select
									class="custom-select custom-select-sm descripcion1" id="descripcion1"
									name="descripcion1">
										<option value="">Seleccione...</option>
										<option value="ASAMBLEA CIUDADANA">ASAMBLEA CIUDADANA</option>
										<option value="CIUDADANOS DEL CONSEJO DE PLANIFICACIÓN Y/O CIUDADANOS DE LA INSTANCIA DE PARTICIPACIÓN O LOS CIUDADANOS DESDE LA CONVOCATORIA DIRECTA DEL GAD">CIUDADANOS DEL CONSEJO DE PLANIFICACIÓN Y/O CIUDADANOS DE LA INSTANCIA DE PARTICIPACIÓN O LOS CIUDADANOS DESDE LA CONVOCATORIA DIRECTA DEL GAD</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="3" cols="" class="form-control form-control-sm observacion1" id="observacion1" name="observacion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							
							<tr>
								<td style="vertical-align: middle; width: 200px;"><label for="lbl2" >2. LA INSTANCIA DE PARTICIPACIÓN DEL TERRITORIO Y LA ENTIDAD CREARON EL EQUIPO TÉCNICO MIXTO Y PARITARIO (CIUDADANOS Y AUTORIDADES/TÉCNICOS) QUE SE ENCARGARÁ DE ORGANIZAR Y FACILITAR EL PROCESO</label>
								    <input type="hidden" id="rc2" name="rc2" value="2. LA INSTANCIA DE PARTICIPACIÓN DEL TERRITORIO Y LA ENTIDAD CREARON EL EQUIPO TÉCNICO MIXTO Y PARITARIO (CIUDADANOS Y AUTORIDADES/TÉCNICOS) QUE SE ENCARGARÁ DE ORGANIZAR Y FACILITAR EL PROCESO">
								</td>
								<td style="vertical-align: middle; width: 120px; font-size: x-small;">
								<select
									class="custom-select custom-select-sm" id="seleccion2"
									name="seleccion2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion2" id="descripcion2" name="descripcion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
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
							<tr>
								<td style="vertical-align: middle; width: 200px; font-size: x-small;">
								<label for="lbl3" >3. EL EQUIPO TÉCNICO MIXTO Y PARITARIO (CIUDADANOS Y AUTORIDADES/TÉCNICOS) CONFORMARON  2 SUBCOMISIONES PARA LA IMPLEMENTACIÓN DEL PROCESO: UNA LIDERADA POR LA ENTIDAD Y UNA LIDERADA POR LA CIUDADANÍA / ASAMBLEA CIUDADANA</label>
								    <input type="hidden" id="rc3" name="rc3" value="3. EL EQUIPO TÉCNICO MIXTO Y PARITARIO (CIUDADANOS Y AUTORIDADES/TÉCNICOS) CONFORMARON  2 SUBCOMISIONES PARA LA IMPLEMENTACIÓN DEL PROCESO: UNA LIDERADA POR LA ENTIDAD Y UNA LIDERADA POR LA CIUDADANÍA / ASAMBLEA CIUDADANA">
								</td>
								<td style="vertical-align: middle; width: 120px; font-size: x-small;">
								<select
									class="custom-select custom-select-sm" id="seleccion3"
									name="seleccion3" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion3" id="descripcion3" name="descripcion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case3" id="link3" name="link3" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion3" id="observacion3" name="observacion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarRendicionCuentas"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaRendicionFase1"
				class="table table-striped table-bordered" style="width: 100%;">
				<thead>
					<tr >
						<th style="font-size: x-small;">#</th>
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
		$(".case1").prop("disabled", "disabled");
		$(".descripcion1").prop("disabled", "disabled");
		$(".observacion1").prop("disabled", "disabled");		
		$(".case2").prop("disabled", "disabled");
		$(".descripcion2").prop("disabled", "disabled");
		$(".observacion2").prop("disabled", "disabled");
		$(".case3").prop("disabled", "disabled");
		$(".descripcion3").prop("disabled", "disabled");
		$(".observacion3").prop("disabled", "disabled");
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
			$(".descripcion1").val("");
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
			url.type = "url";
			
		} else if (seleccion == "NO") {
			$(".observacion2").val("S/N"); 
			$(".descripcion2").val("S/N");
			$(".case2").val("NO APLICA");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".descripcion2").prop("disabled", "disabled");
			$(".descripcion2").removeAttr("required");
			$(".observacion2").prop("disabled", "disabled");
			$(".observacion2").removeAttr("required");
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
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion3").change(function() {
		 var url;
		 url=document.getElementById("link3");
		var seleccion = $("#seleccion3").val();
		if (seleccion == "SI") {			
			$(".observacion3").val(""); 
			$(".descripcion3").val(""); 
			$(".case3").val("http://");
			$(".case3").removeAttr("disabled");
			$(".case2").prop("required", true);
			$(".descripcion3").removeAttr("disabled");
			$(".descripcion3").prop("required", true);
			$(".observacion3").removeAttr("disabled");
			$(".observacion3").removeAttr("required");
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".observacion3").val("S/N"); 
			$(".descripcion3").val("S/N");
			$(".case3").val("NO APLICA");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".descripcion3").prop("disabled", "disabled");
			$(".descripcion3").removeAttr("required");
			$(".observacion3").prop("disabled", "disabled");
			$(".observacion3").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion3").val(""); 
			$(".descripcion3").val("");
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".descripcion3").prop("disabled", "disabled");
			$(".descripcion3").removeAttr("required");
			$(".observacion3").prop("disabled", "disabled");
			$(".observacion3").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	
	$("#btnGuardarRendicionCuentas").click(function(event) {
		var form = $("#RendicionCuentasFase1")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {	
				$(".case1").removeAttr("disabled");
				$(".descripcion1").removeAttr("disabled");
				$(".observacion1").removeAttr("disabled");
				$(".case2").removeAttr("disabled");
				$(".descripcion2").removeAttr("disabled");
				$(".observacion2").removeAttr("disabled");;			
				$(".case3").removeAttr("disabled");
				$(".descripcion3").removeAttr("disabled");
				$(".observacion3").removeAttr("disabled");	
			
					ejecutarJson(form);

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaRendicionFase1').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerRendicionFase1",
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
		$('#TablaRendicionFase1 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
</script>