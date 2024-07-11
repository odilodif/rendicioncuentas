<%-- 
	version		: 1.0
    Document  	: Frm_MecanismosConstrolSocial
    Created on	: 24/02/2021; 9:21:03
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
						modelAttribute="TblMecanismosContolSocial"
						id="MecanismosControlSocial" data-rutaAplicacion="rendicion"
						data-opcion="guardarMecaContSocial" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">MECANISMOS DE CONTROL SOCIAL<br>SE REFIERE A LOS MECANISMOS DE CONTROL SOCIAL QUE HA GENERADO LA CIUDADANÍA EN EL PERÍODO DEL CUAL RINDEN CUENTAS, RESPECTO DE LA GESTIÓN INSTITUCIONAL:</h5>

					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso" style="font-size: x-small;">MECANISMOS DE CONTROL SOCIAL GENERADOS POR LA COMUNIDAD</td>
								<td class="tablaingreso" style="font-size: x-small;">PONGA SI O NO</td>
								<td class="tablaingreso" style="font-size: x-small;">NÚMERO DE MECANISMOS</td>
								<td class="tablaingreso" style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</td>
								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl1" >VEEDURÍAS CIUDADANAS</label>
								    <input type="hidden" id="part1" name="part1" value="VEEDURÍAS CIUDADANAS">
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
								 <td style="width: 150px;">
								 <input type="number"
									id="numero1" name="numero1" min="0"
									step="1" class="form-control form-control-sm numero1" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl2" >OBSERVATORIOS CIUDADANOS</label>
								    <input type="hidden" id="part2" name="part2" value="OBSERVATORIOS CIUDADANOS">
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
								  <td style="width: 150px;">
								  <input type="number"
									id="numero2" name="numero2" min="0" 
									step="1" class="form-control form-control-sm numero2" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl3" >DEFENSORÍAS COMUNITARIAS</label>
								    <input type="hidden" id="part3" name="part3" value="DEFENSORÍAS COMUNITARIAS">
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
								  <td style="width: 150px;">
								  <input type="number"
									id="numero3" name="numero3" min="0" 
									step="1" class="form-control form-control-sm numero3" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case3" id="link3" name="link3" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl4" >COMITÉS DE USUARIOS DE SERVICIOS</label>
								    <input type="hidden" id="part4" name="part4" value="COMITÉS DE USUARIOS DE SERVICIOS">
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
								 <td style="width: 150px;">
								  <input type="number"
									id="numero4" name="numero4" min="0" 
									step="1" class="form-control form-control-sm numero4" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
							     <input type="url" class="form-control form-control-sm case4" id="link4" name="link4" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl5" >OTROS</label>
								    <input type="hidden" id="part5" name="part5" value="OTROS">
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
								 <td style="width: 150px;">
								  <input type="number"
									id="numero5" name="numero5" min="0" 
									step="1" class="form-control form-control-sm numero5" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case5" id="link5" name="link5" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>							

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarContSocial"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaContSocial"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th style="font-size: x-small;">#</th>
						<th style="font-size: x-small;">MECANISMOS DE  CONTROL SOCIAL GENERADOS POR LA COMUNIDAD</th>
						<th style="font-size: x-small;">PONGA SI O NO</th>
						<th style="font-size: x-small;">NÚMERO DE MECANISMOS</th>
						<th style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
		$(".numero1").prop("disabled", "disabled");
		$(".numero2").prop("disabled", "disabled");
		$(".numero3").prop("disabled", "disabled");
		$(".numero4").prop("disabled", "disabled");
		$(".numero5").prop("disabled", "disabled");		
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
		 var url,numero;
		 url=document.getElementById("link1");
		 numero=document.getElementById("numero1");
		var seleccion = $("#seleccion1").val();
		if (seleccion == "SI") {
			$(".numero1").val("");
			$(".case1").val("http://");
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);
			$(".numero1").removeAttr("disabled");
			$(".numero1").prop("required", true);
			$(".numero1").prop("required", true);
			numero.min="1";			
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".numero1").val("0");
			$(".case1").val("NO APLICA");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".numero1").prop("disabled", "disabled");
			$(".numero1").removeAttr("required");
			url.type = "text";	
			numero.min="0";		

		} else {
			$(".numero1").val("");
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".numero1").prop("disabled", "disabled");
			$(".numero1").removeAttr("required");
			url.type = "url";
			numero.min="0";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion2").change(function() {
		 var url,numero;
		 url=document.getElementById("link2");
		 numero=document.getElementById("numero2");
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {
			$(".numero2").val("");
			$(".case2").val("http://");
			$(".case2").removeAttr("disabled");
			$(".case2").prop("required", true);
			$(".numero2").removeAttr("disabled");
			$(".numero2").prop("required", true);
			numero.min="1";	
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".numero2").val("0");
			$(".case2").val("NO APLICA");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".numero2").prop("disabled", "disabled");
			$(".numero2").removeAttr("required");
			numero.min="0";	
			url.type = "text";

		} else {
			$(".numero2").val("");
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".numero2").prop("disabled", "disabled");
			$(".numero2").removeAttr("required");
			url.type = "url";
			numero.min="0";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});	
	$("#seleccion3").change(function() {
		 var url,numero;
		 url=document.getElementById("link3");
		 numero=document.getElementById("numero3");
		var seleccion = $("#seleccion3").val();
		if (seleccion == "SI") {
			$(".numero3").val("");
			$(".case3").val("http://");
			$(".case3").removeAttr("disabled");
			$(".case3").prop("required", true);
			$(".numero3").removeAttr("disabled");
			$(".numero3").prop("required", true);
			url.type = "url";
			numero.min="1";	

		} else if (seleccion == "NO") {
			$(".numero3").val("0");
			$(".case3").val("NO APLICA");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".numero3").prop("disabled", "disabled");
			$(".numero3").removeAttr("required");
			url.type = "text";
			numero.min="0";	

		} else {
			$(".numero3").val("");
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".numero3").prop("disabled", "disabled");
			$(".numero3").removeAttr("required");
			url.type = "url";
			numero.min="0";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion4").change(function() {
		 var url,numero;
		 url=document.getElementById("link4");
		 numero=document.getElementById("numero4");
		var seleccion = $("#seleccion4").val();
		if (seleccion == "SI") {
			$(".numero4").val("");
			$(".case4").val("http://");
			$(".case4").removeAttr("disabled");
			$(".case4").prop("required", true);
			$(".numero4").removeAttr("disabled");
			$(".numero4").prop("required", true);
			url.type = "url";
			numero.min="1";	

		} else if (seleccion == "NO") {
			$(".numero4").val("0");
			$(".case4").val("NO APLICA");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			$(".numero4").prop("disabled", "disabled");
			$(".numero4").removeAttr("required");
			url.type = "text";
			numero.min="0";	

		} else {
			$(".numero4").val("");
			$(".case4").val("");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			$(".numero4").prop("disabled", "disabled");
			$(".numero4").removeAttr("required");
			url.type = "url";
			numero.min="0";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion5").change(function() {
		 var url,numero;
		 url=document.getElementById("link5");
		 numero=document.getElementById("numero5");
		var seleccion = $("#seleccion5").val();
		if (seleccion == "SI") {
			$(".numero5").val("");
			$(".case5").val("http://");
			$(".case5").removeAttr("disabled");
			$(".case5").prop("required", true);
			$(".numero5").removeAttr("disabled");
			$(".numero5").prop("required", true);
			url.type = "url";
			numero.min="1";	

		} else if (seleccion == "NO") {
			$(".numero5").val("0");
			$(".case5").val("NO APLICA");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			$(".numero5").prop("disabled", "disabled");
			$(".numero5").removeAttr("required");
			url.type = "text";
			numero.min="0";	

		} else {
			$(".numero5").val("");
			$(".case5").val("");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			$(".numero5").prop("disabled", "disabled");
			$(".numero5").removeAttr("required");
			url.type = "url";
			numero.min="0";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	$("#btnGuardarContSocial").click(function(event) {
		var form = $("#MecanismosControlSocial")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {	
				
				$(".case1").removeAttr("disabled");
				$(".case2").removeAttr("disabled");
				$(".case3").removeAttr("disabled");
				$(".case4").removeAttr("disabled");
				$(".case5").removeAttr("disabled");	
				$(".numero1").removeAttr("disabled");
				$(".numero2").removeAttr("disabled");
				$(".numero3").removeAttr("disabled");
				$(".numero4").removeAttr("disabled");
				$(".numero5").removeAttr("disabled");			
					
			
					ejecutarJson(form);

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaContSocial').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerControlSocial",
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
			{data : "sistema"},
			{data : "seleccion"}, 
			{data : "numero"},
			{data : "link"}, 			
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
				$(row).attr('id', data.mec_cod);
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_MecanismosConstrolSocialActul');
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
				$(row).find("td:eq(5)").css({
					"vertical-align" : "middle",									
				});				
		           
			},	
			
		});

	}
	

	function Actualizar(element) {	
		$('#TablaContSocial tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
</script>