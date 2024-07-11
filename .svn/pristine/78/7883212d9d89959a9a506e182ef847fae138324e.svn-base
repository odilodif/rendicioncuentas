<%-- 
	version		: 1.0
    Document  	: Frm_ParticipacionCiudadanaGad 
    Created on	: 22/02/2021; 20:36:23
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
						modelAttribute="TblParticipacionCiudadana" 
						id="ParticipacionCiudadana" data-rutaAplicacion="rendicion"
						data-opcion="guardarParticipacionCiudadana" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">PARTICIPACIÓN CIUDADANA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso" style="font-size: x-small;">SISTEMA DE PARTICIPACIÓN CIUDADANA Art. 304</td>
								<td class="tablaingreso" style="font-size: x-small;">PONGA SI O NO</td>
								<td class="tablaingreso" style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</td>
								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl1" >¿CUENTA CON UN SISTEMA DE PARTICIPACIÓN CIUDADANA ART. 304 EN FUNCIONAMIENTO?</label>
								    <input type="hidden" id="part1" name="part1" value="¿CUENTA CON UN SISTEMA DE PARTICIPACIÓN CIUDADANA ART. 304 EN FUNCIONAMIENTO?">
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
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl2" >¿ESTÁ NORMADO EL SISTEMA DE PARTICIPACIÓN POR MEDIO DE UNA ORDENANZA/ RESOLUCIÓN?</label>
								    <input type="hidden" id="part2" name="part2" value="¿ESTÁ NORMADO EL SISTEMA DE PARTICIPACIÓN POR MEDIO DE UNA ORDENANZA/ RESOLUCIÓN?">
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
								<input type="url" class="form-control form-control-sm case2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl3" >¿PARTICIPÓ LA CIUDADANÍA EN LA ELABORACIÓN DE ESTA ORDENANZA / RESOLUCIÓN?</label>
								    <input type="hidden" id="part3" name="part3" value="¿PARTICIPÓ LA CIUDADANÍA EN LA ELABORACIÓN DE ESTA ORDENANZA / RESOLUCIÓN?">
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
								<input type="url" class="form-control form-control-sm case3" id="link3" name="link3" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl4" >¿LA ORDENANZA / RESOLUCIÓN FUE DIFUNDIDA Y SOCIALIZADA A LA CIUDADANÍA?</label>
								    <input type="hidden" id="part4" name="part4" value="¿LA ORDENANZA / RESOLUCIÓN FUE DIFUNDIDA Y SOCIALIZADA A LA CIUDADANÍA?">
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
							     <input type="url" class="form-control form-control-sm case4" id="link4" name="link4" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl5" >¿LA ORDENANZA / RESOLUCIÓN TIENE REGLAMENTOS QUE NORMAN LOS PROCEDIMIENTOS REFERIDOS EN LA MISMA?</label>
								    <input type="hidden" id="part5" name="part5" value="¿LA ORDENANZA / RESOLUCIÓN TIENE REGLAMENTOS QUE NORMAN LOS PROCEDIMIENTOS REFERIDOS EN LA MISMA?">
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
								<input type="url" class="form-control form-control-sm case5" id="link5" name="link5" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl6" >¿CUÁLES SON ESOS REGLAMENTOS?</label>
								    <input type="hidden" id="part6" name="part6" value="¿CUÁLES SON ESOS REGLAMENTOS?">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion6"
									name="seleccion6" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case6" id="link6" name="link6" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
								<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl7" >¿SE IMPLEMENTÓ EN ESTE PERIODO EL SISTEMA DE PARTICIPACIÓN DE ACUERDO A LA ORDENANZA / RESOLUCIÓN Y REGLAMENTO?</label>
								    <input type="hidden" id="part7" name="part7" value="¿SE IMPLEMENTÓ EN ESTE PERIODO EL SISTEMA DE PARTICIPACIÓN DE ACUERDO A LA ORDENANZA / RESOLUCIÓN Y REGLAMENTO?">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion7"
									name="seleccion7" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case7" id="link7" name="link7" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 300px;">
								<label for="lbl8" >DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN</label>
								    <input type="hidden" id="part8" name="part8" value="DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN">
								</td>
								
								<td colspan="2" style="vertical-align: middle; font-size: x-small;">
								<textarea rows="1" cols="" class="form-control form-control-sm case8" id="descripcion8" name="descripcion8" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarPartCiud"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaPartipCiudad"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th style="font-size: x-small;">#</th>
						<th style="font-size: x-small;">SISTEMA DE PARTICIPACIÓN CIUDADANA Art. 304</th>
						<th style="font-size: x-small;">PONGA SI O NO</th>
						<th style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
						<th style="font-size: x-small;"> </th>
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
		$(".case6").prop("disabled", "disabled");
		$(".case7").prop("disabled", "disabled");		
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
			http://
			$(".case1").val("http://");
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case1").val("NO APLICA");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			url.type = "text";

		} else {
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion2").change(function() {
		 var url;
		 url=document.getElementById("link2");
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {
			$(".case2").val("http://");
			$(".case2").removeAttr("disabled");
			$(".case2").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case2").val("NO APLICA");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			url.type = "text";

		} else {
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion3").change(function() {
		 var url;
		 url=document.getElementById("link3");
		var seleccion = $("#seleccion3").val();
		if (seleccion == "SI") {
			$(".case3").val("http://");
			$(".case3").removeAttr("disabled");
			$(".case3").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case3").val("NO APLICA");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			url.type = "text";

		} else {
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	$("#seleccion4").change(function() {
		 var url;
		 url=document.getElementById("link4");
		var seleccion = $("#seleccion4").val();
		if (seleccion == "SI") {
			$(".case4").val("http://");
			$(".case4").removeAttr("disabled");
			$(".case4").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case4").val("NO APLICA");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			url.type = "text";

		} else {
			$(".case4").val("");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	$("#seleccion5").change(function() {
		 var url;
		 url=document.getElementById("link5");
		var seleccion = $("#seleccion5").val();
		if (seleccion == "SI") {
			$(".case5").val("http://");
			$(".case5").removeAttr("disabled");
			$(".case5").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case5").val("NO APLICA");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			url.type = "text";

		} else {
			$(".case5").val("");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion6").change(function() {
		 var url;
		 url=document.getElementById("link6");
		var seleccion = $("#seleccion6").val();
		if (seleccion == "SI") {
			$(".case6").val("http://");
			$(".case6").removeAttr("disabled");
			$(".case6").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case6").val("NO APLICA");
			$(".case6").prop("disabled", "disabled");
			$(".case6").removeAttr("required");
			url.type = "text";

		} else {
			$(".case6").val("");
			$(".case6").prop("disabled", "disabled");
			$(".case6").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion7").change(function() {
		 var url;
		 url=document.getElementById("link7");
		var seleccion = $("#seleccion7").val();
		if (seleccion == "SI") {
			$(".case7").val("http://");
			$(".case7").removeAttr("disabled");
			$(".case7").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case7").val("NO APLICA");
			$(".case7").prop("disabled", "disabled");
			$(".case7").removeAttr("required");
			url.type = "text";

		} else {
			$(".case7").val("");
			$(".case7").prop("disabled", "disabled");
			$(".case7").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	

	$("#btnGuardarPartCiud").click(function(event) {
		var form = $("#ParticipacionCiudadana")
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
				$(".case6").removeAttr("disabled");
				$(".case7").removeAttr("disabled");						
			
					ejecutarJson(form);

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaPartipCiudad').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerPartCiudadana",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		bDestroy : true,
		columns : [			
			{data : "contador"},
			{data : "sistema"},
			{data : "seleccion"}, 
			{data : "link"}, 			
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
		            	 data = '';     
		             }else{	
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
		             }
      			  return data;
              }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pc_cod);
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_ParticipacionCiudadanaGadActul');
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
					$(row).find("td").css({
						"font-size"   : "x-small",			
					});	
				if(data.sistema ==='DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN'){
			        $('td:eq(3)', row).attr('colspan', 2);		          
		            $('td:eq(2)', row).css('display', 'none');	      
		         
		           
		       }	
		
			},	
			
		});

	}
	

	function Actualizar(element) {	
		$('#TablaPartipCiudad tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
</script>