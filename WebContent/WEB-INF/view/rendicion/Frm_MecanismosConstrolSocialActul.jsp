<%-- 
	version		: 1.0
    Document  	: Frm_MecanismosConstrolSocialActul
    Created on	: 24/02/2021; 17:35:15
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
						modelAttribute="TblMecanismosContolSocial"
						id="MecanismosControlSocialActl" data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">MECANISMOS DE CONTROL SOCIAL<br>SE REFIERE A LOS MECANISMOS DE CONTROL SOCIAL QUE HA GENERADO LA CIUDADANÍA EN EL PERÍODO DEL CUAL RINDEN CUENTAS, RESPECTO DE LA GESTIÓN INSTITUCIONAL:</h5>

					<input type="hidden" id="mec_cod" name="mec_cod" value="${mec_cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">MECANISMOS DE CONTROL SOCIAL GENERADOS POR LA COMUNIDAD</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">NÚMERO DE MECANISMOS</td>
								<td class="tablaingreso">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</td>
								
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 300px;">
								<label for="lbl1" >${mec_nombre}</label>
								    <input type="hidden" id="mec_nombre" name="mec_nombre" value="${mec_nombre}">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="mec_implementado"
									name="mec_implementado" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="width: 150px;">
								 <input type="number" id="mec_numero" name="mec_numero" min="0"  value="${mec_numero}"
									step="1" class="form-control form-control-sm numero" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Ingrese el Numero</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case" id="mec_medioverifica" name="mec_medioverifica" value="${mec_medioverifica}"
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>								
							</tr>
													

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarContSocialActul"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
</div>
</html>

<script type="text/javascript">

	$(document).ready(function() {
		cargarValorComboPorDefecto("mec_implementado",'${mec_implementado}');
		if('${mec_implementado}'=='NO'){
			var url;
			url=document.getElementById("mec_medioverifica");
			url.type = "text";			
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			$(".numero").prop("disabled", "disabled");
			$(".numero").removeAttr("required");
			}
		
	});

	$("#mec_implementado").change(function() {
		var url;
		url=document.getElementById("mec_medioverifica");
		var seleccion = $("#mec_implementado").val();
		if (seleccion == "SI") {
			$(".numero").val("");			
			$(".case").val("http://");
			$(".case").removeAttr("disabled");
			$(".case").prop("required", true);
			$(".numero").removeAttr("disabled");
			$(".numero").prop("required", true);
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".numero").val("0");
			$(".case").val("NO APLICA");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			$(".numero").prop("disabled", "disabled");
			$(".numero").removeAttr("required");
			url.type = "text";

		} else {
			$(".numero").val("");
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			$(".numero").prop("disabled", "disabled");
			$(".numero").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
		
	$("#btnGuardarContSocialActul").click(function(event) {
		var form = $("#MecanismosControlSocialActl")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {	
			  $(".case").removeAttr("disabled");
			  $(".numero").removeAttr("disabled");			
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
			  var data = {tabla: 'esq_rendicioncuentas.tbl_mecanismos_contol_social',columns:columnas,values:valores,condicion:'mec_cod',valorcondicion:$("#mec_cod").val()};
			
			  ejecutarJsonUpdate(form,data);
		}
		form.addClass('was-validated');


	});

	
</script>