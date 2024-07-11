<%-- 
	version		: 1.0
    Document  	: Frm_NuevoDatosInforme
    Author		: Wilmer Guaman
    Mail		: guamanw@gmail.com
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
	<c:when test="${infestado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>DATOS DEL MEDIO:</h5>
	</div>
	<div class="card-body">
      
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosMedio" id="TblDatosMedioid"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarDatosMedio" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
		       
                <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia">FRECUENCIA (S) DEL ESPECTRO RADIOELÉCTRICO (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmFrecuencia" name="dmFrecuencia" required="required"></textarea>
								    <div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
				</div>
                
                    <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">NÚMERO DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dmNumrepetidoras" name="dmNumrepetidoras" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">UBICACIÓN DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmUbicrepetidoras" name="dmUbicrepetidoras" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">FECHA DE OTORGAMIENTO DE LA CONCESIÓN/ CREACIÓN DEL MEDIO IMPRESO:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dmFechinicioconcesion"
															name="dmFechinicioconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
                 <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia"> FECHA DE VENCIMIENTO DE LA CONCESIÓN:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dmFechfinconcesion"
															name="dmFechfinconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
            <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> NÚMERO DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dmNumscursales" name="dmNumscursales" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
            </div>
             <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> UBICACIÓN DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmUbicsucursales" name="dmUbicsucursales" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
               <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> DETALLAR LOS PRODUCTOS IMPRESOS (REVISTAS, PERIÓDICOS):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmProductos" name="dmProductos" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
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

$(document).ready(
		function() {



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
			$('#dmFechinicioconcesion').datepicker();
			$('#dmFechfinconcesion').datepicker();
			
});
			
$("#btnGuardar")
		.click(
				function(event) {
					var form = $("#TblDatosMedioid")
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






 
				
</script>
