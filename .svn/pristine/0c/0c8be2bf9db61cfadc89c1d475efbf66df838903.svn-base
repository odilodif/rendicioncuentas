<%-- 
	version		: 1.0
    Document  	: Frm_ParticipacionCiudadanaGadActul
    Created on	: 24/02/2021; 11:47:06
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
			<div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblParticipacionCiudadana" 
						id="ParticipacionCiudadanaActual" data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">PARTICIPACIÓN CIUDADANA</h5>
					<input type="hidden" id="pc_cod" name="pc_cod" value="${pc_cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">SISTEMA DE PARTICIPACIÓN CIUDADANA Art. 304</td>
								<c:choose>
								<c:when test="${pc_sistema=='DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN'}">	
								<td colspan="2" class="tablaingreso">DESCRIBA LOS RESULTADOS ALCANZADOS</td>							
								</c:when>
								<c:otherwise>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</td>
							   
								</c:otherwise>									
								</c:choose>  								
								
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 300px;">
								<label for="lbl1" >${pc_sistema}</label>
								    <input type="hidden" id="pc_sistema" name="pc_sistema" value="${pc_sistema}">
								</td>
								
								
								<c:choose>
								<c:when test="${pc_sistema=='DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN'}">	
								<td colspan="2" style="vertical-align: middle;">
								<textarea rows="1" cols="" class="form-control form-control-sm case8" id="pc_describa" name="pc_describa" required="required" >${pc_describa}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese el link</div>
								 </td>	
								</c:when>
								<c:otherwise>
									
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="pc_valida"
									name="pc_valida" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case" id="pc_link" name="pc_link"  value="${pc_link}"
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
							   
								</c:otherwise>		
															
								</c:choose>  
								
														
							</tr>
						

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarPartCiudActul"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>	
</div>
</html>

<script type="text/javascript">

	$(document).ready(function() {
		cargarValorComboPorDefecto("pc_valida",'${pc_valida}');
		if('${pc_valida}'=='NO'){
			var url;
			url=document.getElementById("pc_link");	
			url.type = "text";
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			}
	
		
	});

	$("#pc_valida").change(function() {
		var url;
		url=document.getElementById("pc_link");		
		var seleccion = $("#pc_valida").val();
		if (seleccion == "SI") {
			http://
			$(".case").val("http://");
			$(".case").removeAttr("disabled");
			$(".case").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".case").val("NO APLICA");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "text";

		} else {
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	

	$("#btnGuardarPartCiudActul").click(function(event) {
		var form = $("#ParticipacionCiudadanaActual")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			  $(".case").removeAttr("disabled");				
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
			  var data = {tabla: 'esq_rendicioncuentas.tbl_participacion_ciudadana',columns:columnas,values:valores,condicion:'pc_cod',valorcondicion:$("#pc_cod").val()};	
			  ejecutarJsonUpdate(form,data);
		}
		form.addClass('was-validated');

	});

	
	


</script>