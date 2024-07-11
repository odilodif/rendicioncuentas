

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set var="rutaImagenCpccsTexto" value="<%=Constantes.RUTA_IMAGEN_CPCCSTEXTO%>" />
<c:set var="keySitio" value="<%=Constantes.KEY_SITIO_RECAPTCHA%>" />
<c:set var="CorreoSoporte" value="<%=Constantes.CORREO_SOPORTE_SISTEMA%>" />
<c:set var="nombreModulo" value="<%=Constantes.NOMBRE_MODULO_MINUSCULA%>" />
<spring:url value="/resources/" var="urlPublic" />
<!DOCTYPE html>
<html>
<head>
<title>Formulario de reseteo de contraseña</title>
<link rel="shortcut icon" type="image/x-icon" href="${urlPublic}img/favicon.ico" />
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/fontawesome-all.css">
<link rel="stylesheet" href="${urlPublic}css/bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/datepicker.css" />
<script src="${urlPublic}js/rendicion.bloqueo.js"></script>
</head>
<body>
	<div class="card text-center">
		<div id="card-header" class="card-header ">
			<h5>Recuperar contraseñas del ${nombreModulo} </h5>
			<div class="col-md-3 text-left">
	 <div class="texto-cursivo color-olvide-contrasenia">
		<a href="/rendicioncuentas"><h5>Regresar</h5></a>
	 </div>
	 </div>
		</div>
		
		
		<div id="card-body" class="card-body">
			<img alt="Logo cpccs" class=""
				src="${urlPublic}${rutaImagenCpccsTexto}" />
			<div class="row">
				<div class="col-md-2 order-md-1"></div>
				<div class="col-md-8 order-md-1">
					<form class="needs-validation" novalidate	action="generarClave" id="formularioRegistro"	method="POST">
							<input type="hidden" id="g-recaptcha-response"	name="g-recaptcha-response">
									
						<div class="card">
						<h5  class="card-header text-white carHeaderBlue">Recuperar contraseña</h5>
						<div  class="card-body">
							<div class="form-group row notaAclara">
								<div class="col-md-12 text-left labelColorRojo">
									<label for="notaDevolver"><b>NOTA: </b> Si necesita ayuda comunicarse al correo electrónico  ${CorreoSoporte}</label>
								</div>
							</div>
				
							<div class="form-group row">
								<div class="col-md-4 text-left">
									<label for="identificador" class="col-form-label">Cédula</label>
								</div>
								<div class="col-md-8 text-left">
									<input type="text" class="form-control form-control-sm"
										id="identificador" required="required" name="identificador"
										 minlength="10" maxlength="10"
										pattern="^([a-zA-Z0-9]{7,13})+$" />
									<div class="invalid-feedback">Por favor ingrese su # de cédula</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-4 text-left">
									<label class="font-noraml">Fecha de nacimiento<span class="text-muted"> (dd/mm/yyyy)</span></label>
								</div>
								<div class="col-md-8 text-left">
									<div class="input-group date" >
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="fechaNacimiento" name="fechaNacimiento"
											class="form-control form-control-sm" value=""
											 maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la
											fecha de nacimiento con la que se registro en el sistema</div>
									</div>
								</div>
							</div>
						</div>
					</div>
							
					<div class="col-md-12 mt-3">
						<button type="submit" id="btnEnviar" class="btn btn-primary">Enviar</button>
					</div>
				
						
										
											
						
					</form>
				
				<div class="col-md-2 order-md-1"></div>
				</div>
			</div>
			</div>
		
		<div id="card-footer" class="card-footer text-muted">© CPCCS 2018 - ${anio}</div>
	</div>
<script src="${urlPublic}js/jquery-3.3.1.js"></script>
<script src="${urlPublic}js/bootstrap.min.js"></script>
<script src="${urlPublic}js/bootstrap.datepicker.js"></script>
<script src="${urlPublic}js/jquery.inputmask.js"></script>
<script src="${urlPublic}js/rendicion.ingreso.js"></script>
<script src='https://www.google.com/recaptcha/api.js?render=${keySitio}'></script>
<script type="text/javascript">
$(document).ready(function() {
     ajustarAltoVentanaAplicacion();
	construirValidador();
 
  	var keySitio = '<c:out value="${keySitio}" />';
    	grecaptcha.ready(function() {
      		grecaptcha.execute(keySitio, {
        	action: 'homepage'
      		}).then(function(token) {
      		$('#g-recaptcha-response').val(token);
      		});
    	});
    	if (typeof grecaptcha !== 'undefined' && typeof keySitio !== 'undefined') {
        	grecaptcha.ready(grecaptcha.execute);
        	setInterval(grecaptcha.execute, 120000);
    	}
	$('#fechaNacimiento').datepicker({
		forceParse: true,
	  	todayBtn: false
	}).datepicker('setStartDate', '01/01/1900');
	
	$('#fechaNacimiento').datepicker({

	}).datepicker('setEndDate', '31/12/2002');
	
	$('#fechaNacimiento').datepicker({

	}).datepicker('update', '01/06/1970');
	
	$('#fechaNacimiento').datepicker({

	}).datepicker('update','');

 
});


$("#btnEnviar").click(function(event) {
	var form = $("#formularioRegistro")
   
    if (form[0].checkValidity() === false  ) {
    	event.preventDefault();
        event.stopPropagation();
   		mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
	}else{
    	$(".card:first").append("<div id='cargando'>Cargando...</div>").fadeIn();
       	setTimeout(function(){
           	$(".card:first").delay("slow").fadeOut();
    	}, 5000);
    		
    }
	form.addClass('was-validated');
});


</script>
</body>
</html>