<%-- 
	version		: 1.0
    Document  	: EditarDatosUsuario
    Created on	: 22 nov. 2022; 14:36:42
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
    Celular		: 0995491200
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
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/rendicion.css">
</head>

	<div class="card-body text-center">

		<div class="card card-secondary">
		
		<h5 class="card-header text-white carHeaderBlue">EDITAR DATOS
		  ${tipo=='empresa'?'INSTITUCIÓN':tipo} </h5>
		 <hr>
		<c:choose>
		<c:when test="${categoria == 'empresa' }">
						<form:form class="needs-validation" novalidate=""
				modelAttribute="TblUsuario" id="EditarInstitucion"
				data-rutaAplicacion="uath"
				data-opcion="EditarPerfilUser" data-destino="detalleItem"
				data-accionEnExito="">
				<input type="hidden" id="codigo" name="codigo" value="${codigo}">
               <input type="hidden" id="categoria" name="categoria" value="${categoria}">
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="nombre">Nombre:</label>
							</div>
							<div class="col-md-3 text-lef">
								<input type="text" style="text-transform: uppercase;"
									class="form-control form-control-sm "
									id="nombre" required="required"
									name="nombre" value="${nombre}"
									placeholder="Ingrese Nombres y Apellidos" minlength="3"
									maxlength="64" value=""
								>
								<div class="invalid-feedback">Por
									favor ingrese el Nombre</div>
								<!-- <div class="valid-tooltip">todo bien</div> -->
							</div>
							<div class="col-md-1 text-left"></div>

							<div class="col-md-2 text-left">
								<label for="Cargo">Página web</label>
							</div>
							<div class="col-md-3 text-left ">
								<input type="text"  class="form-control form-control-sm"
									id="paginaWeb" required="required" value="${pagina}" 
									name="paginaWeb" placeholder="INGRESE LA PÁGINA WEB"
									minlength="6" maxlength="64">
								<div class="invalid-feedback">Por favor ingrese la página web</div>
							</div>
						</div>
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="correo">Email de
										Notificación:</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="email" class="form-control form-control-sm"
										id="correo" required="required" value="${correo}"
										name="correo" placeholder="INGRESE SU EMAIL"
										pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Por favor ingrese una
										dirección de correo eletrónico válida</div>
								</div>
								<div class="col-md-1"></div>

								<div class="col-md-2 text-left">
									<label for="telf" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="telf" name="telf"  value="${telf}"
										placeholder="(00) 000-0000" maxlength="13"
										pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
										data-inputmask="'mask': '(99) 999-9999'">
									<div class="invalid-feedback">Por favor ingrese su
										teléfono</div>
								</div>
							</div>
							<hr>							
							<div class="form-group row">
								<div class="col-md-12 text-center">
									<button type="submit" id="btnUpdate"	class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
								</div>
								
								
							</div>
							
				
				</form:form>	
    	</c:when>
    	<c:when test="${categoria == 'institucion'||categoria == 'autoridad'}">
						<form:form class="needs-validation" novalidate=""
				modelAttribute="TblUsuario" id="EditarPerfil"
				data-rutaAplicacion="uath"
				data-opcion="EditarPerfilUser" data-destino="detalleItem"
				data-accionEnExito="">
				<input type="hidden" id="codigo" name="codigo" value="${codigo}">
               <input type="hidden" id="categoria" name="categoria" value="${categoria}">
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="nombre">Nombres:</label>
							</div>
							<div class="col-md-3 text-lef">
								<input type="text" style="text-transform: uppercase;"
									class="form-control form-control-sm "
									id="nombre" required="required"
									name="nombre" value="${nombre}"
									placeholder="Ingrese Nombres y Apellidos" minlength="3"
									maxlength="64" value=""
									pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
								<div class="invalid-feedback">Por
									favor ingrese sus Apellidos y Nombres</div>
								<!-- <div class="valid-tooltip">todo bien</div> -->
							</div>
							<div class="col-md-1 text-left"></div>

							<div class="col-md-2 text-left">
								<label for="Cargo"> ${tipo == 'autoridad' ? 'Dignidad:': 'Cargo:'}</label>
							</div>
							<div class="col-md-3 text-left ">
								<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
									id="cargo" required="required" value="${cargo}" 
									name="cargo" placeholder="INGRESE EL CARGO"
									minlength="3" maxlength="64">
								<div class="invalid-feedback">Por favor ingrese el
									Cargo</div>
							</div>
						</div>
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="correo">Email de
										Notificación:</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="email" class="form-control form-control-sm"
										id="correo" required="required" value="${correo}"
										name="correo" placeholder="INGRESE SU EMAIL"
										pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Por favor ingrese una
										dirección de correo eletrónica valida</div>
								</div>
								<div class="col-md-1"></div>

								<div class="col-md-2 text-left">
									<label for="FechaRepreLegal">${categoria=='institucion'?'Fecha de Designación':'Fecha de Nacimiento'}</label>
								</div>
								<div class="col-md-3 text-left">
									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="fecha"
											name="fecha"
											class="form-control form-control-sm" value="${fecha}"
											maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha de designación
											con formato dd/mm/aaaa</div>
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="telf" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="telf" name="telf"  value="${telf}"
										placeholder="(00) 000-0000" maxlength="13"
										pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
										data-inputmask="'mask': '(99) 999-9999'">
									<div class="invalid-feedback">Por favor ingrese su
										teléfono</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="celular" class="col-form-label">Celular:</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="celular" required="required"  value="${celular}"
										name="celular" placeholder="(00) 0000-0000"
										maxlength="14" pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
										data-inputmask="'mask': '(99) 9999-9999'">
									<div class="invalid-feedback">Por favor ingrese su
										celular</div>
								</div>
							</div>
							<hr>							
							<div class="form-group row">
								<div class="col-md-12 text-center">
									<button type="submit" id="btnRegistros"	class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
								</div>
								
								
							</div>
							
				
				</form:form>	
    	</c:when>
	</c:choose>
		
		</div>
	</div>

</html>
  <script src="${urlPublic}js/rendicion.ingreso.js"></script>
<script>
	$(document).ready(function() {			
		construirValidador();
		var f = new Date();
		var fecha=(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());		
		$('#fecha').datepicker({
			  forceParse: true,
			  todayBtn: false
			}).datepicker('setStartDate', '01/01/2000');
			
			$('#fecha').datepicker({
			}).datepicker('setEndDate', fecha);			
			
			if('${tipo}' == 'autoridad'){
				$('#cargo' ).attr('disabled', 'disabled');				
			}else{			
			    $('#cargo' ).removeAttr('disabled');
			}

	});

	$("#correo").change(function(event) {
		var opcion = $("#correo").val().toLowerCase();
		$.ajax({
			url : 'ValidarUsuario',
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST",
			dataType : 'json',
			data : {
				codigo : opcion
			},
			success : function(result) {
				if (result.valida === "nuevo") {
					mostrarMensaje(
							"Ususario disponible!",
							"EXITO-NOTIFICACION",
							"3000");

				} else if (result.valida === "existe") {
					mostrarMensaje(
							"Email ya registrado, ingrese uno diferente!",
							"ERROR-NOTIFICACION",
							"3000");
					$("#correo").val("");
				} else if (result.valida === "vacio") {
					mostrarMensaje(
							"Ingrese email de usuario !",
							"ERROR-NOTIFICACION",
							"3000");

				}

			},
			error : function(result) {
				mostrarMensaje(
						"Consulta no encontrada !",
						"ERROR-NOTIFICACION", "3000");

			}
		});

	});
	
	$("#btnUpdate").click(function(event) {
		var form = $("#EditarInstitucion");		
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

	$("#btnRegistros").click(function(event) {
			var form = $("#EditarPerfil");		
			
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

	/*

	$("#btnRegistros").click(	function(event) {	
		var form = $("#EditarPerfil")
			event.preventDefault();
			event.stopPropagation();

			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR")
			} else {
				var obj = ejecutarJson(form,
						new exitoDatosUsuario(), null, null);
			}
			form.addClass('was-validated');

		});

	function exitoDatosUsuario() {
		this.ejecutar = function(msg) {
			
			mostrarMensaje("Los datos han sido actualizados correctamente",
					"EXITO");
			$("#nombre").html($("#nombreUsuario").val());
		};
	}*/
	
	
</script>