<%-- 
    Document  	: login
    Created on	: 01/04/2018, 08:14:13
    Author		: Carlos Anchundia
    Mail		: e.du.ingcharles@hotmail.com
    Property   	: CPCCS
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<spring:url value="/resources/" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<c:set var="rutaImagenCpccsTexto"
	value="<%=Constantes.RUTA_IMAGEN_CPCCSTEXTO%>" />
<c:set var="keySitio" value="<%=Constantes.KEY_SITIO_RECAPTCHA%>" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
<title>Login Sistema Nacional de Rendición de Cuentas</title>
</head>
<link type="image/x-icon" rel="shortcut icon"
	href="${urlPublic}img/favicon.ico" />
<link rel="stylesheet" href="${urlPublic}css/bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/fontawesome-all.css">
<link rel="stylesheet" href="${urlPublic}css/rendicion.login.css">
<link rel="stylesheet" href="${urlPublic}css/main.css" />


<body class="gray-bg">
	<div id="contenedor_carga">
		<div id="carga"></div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-3 mx-auto">
						<div class="card rounded-8 cuadro-login animated fadeInDown">
							<div class="card-body rounded-8">
								<img src="${urlPublic}${rutaImagenCpccsTexto}" class="img-fluid" />
								<hr />
								<div class="panel-title text-center">
									<h4>Ingreso a la Plataforma de Rendición de Cuentas </h4>
								</div>
								<hr />
								<div class="animated zoomIn atencion"></div>
						<div>
									¡Favor realice su registro! 
									<div class="texto-cursivo color-olvide-contrasenia">
										<a href="registroAutoridad">Registro Autoridades</a>
									</div>
								</div>
											<div class="texto-cursivo color-olvide-contrasenia">
										<a href="RegistroInstitucion">Registro Instituciones</a>
									</div>
						
									<div class="texto-cursivo color-olvide-contrasenia">
 										<!-- <a href="https://sudappstest.cpccs.gob.ec/rendicion/" target="_blank">Revise el catastro de Instituciones</a> -->
										<a href="https://plataforma.cpccs.gob.ec/rendicion/" target="_blank">Revise el catastro de Instituciones</a>
									
									</div>
							
								
								<hr />
								<form class="needs-validation" novalidate id="formularioLogin"
									action="${urlRoot}login" method="post">
									<div class="form-group">
										<c:if test="${not empty error}">
											<div class="alert alert-danger" role="alert">
												<span class="fas fa-exclamation-triangle" aria-hidden="true"></span>
												${error}
											</div>
										</c:if>
										<c:if test="${not empty message}">
											<div class="alert alert-success" role="alert">
												<span class="fa fa-check" aria-hidden="true"></span>
												${message}
											</div>
										</c:if>
										<label for="username" class="cols-sm-2 control-label">Usuario</label>
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="basic-addon1"><i
													class="fa fa-user fa-lg" aria-hidden="true"></i></span>
											</div>
											<input type="text" class="form-control" name="username"
												id="username" minlength="7" maxlength="100"
												placeholder="Ingrese su email" aria-label="Username"
												aria-describedby="basic-addon1" required>
											<div class="invalid-feedback">Por favor ingrese su
												email</div>
										</div>
									</div>
									<div class="form-group">
										<label for="Password" class="cols-sm-2 control-label">Contraseña</label>
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<span class="input-group-text" id="basic-addon1"><i
													class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
											</div>
											<input type="password" class="form-control"
												placeholder="Ingrese su contraseña" name="password"
												id="password" aria-label="password" minlength="6"
												maxlength="12"
												pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$"
												aria-describedby="basic-addon1" required>

											<div class="invalid-feedback">Por favor ingrese su
												contraseña</div>
											<!-- <input	type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" /> -->

											<sec:csrfInput />
										</div>
									</div>
									<input type="hidden" id="g-recaptcha-response"
										name="g-recaptcha-response">

									<button class="btn btn-success btn-md btn-block" id="btnEnviar"
										type="submit">Ingresar</button>
									<a href="recuperarClave"
										class="texto-cursivo color-olvide-contrasenia">Olvidó su
										contraseña? </a>
								</form> 
							<!--  	<p class="text-justify texto-rojo texto-cursivo">
									“En cumplimiento de los artículos 20 y 21 del Reglamento de Rendición de Cuentas vigente, se informa que el Sistema Informático se habilitará después de quince días de concluido el plazo (30 de junio del 2023) parala entrega del Informe de Rendición de Cuentas al Consejo de Participación Ciudadana y Control Social.Luego de ello, éste sistema se habilitará hasta el 31 de diciembre del año en curso para aquellas institucionesy entidades que no entregaron su informe en el plazo establecido, sin modificar la condición de incumplido.”
								</p> -->
								
								<hr />
<!-- 								<p class="m-n text-center texto-gris"> -->
<!-- 									<small>Plataforma Informática del Nuevo</small> -->
<!-- 								</p> -->
								<p class="m-n text-center texto-gris">
									<small>© CPCCS ${anio} <label
										style="color: black;">versión: ${version}</label></small>
								</p>
								<p class="text-center texto-gris">
									<small>Subcoordinación Nacional de Tecnologías</small>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	<script src="${urlPublic}js/jquery-3.3.1.js"></script>
	<script src="${urlPublic}js/bootstrap.min.js"></script>
	<script src="${urlPublic}js/bootstrap.datepicker.js"></script>
	<script src="${urlPublic}js/rendicion.ingreso.js"></script>
	<script src="${urlPublic}js/rendicion.bloqueo.js"></script>
	
	<script
		src='https://www.google.com/recaptcha/api.js?render=${keySitio}'></script>
	<script type="text/javascript">
		window.onload = function() {
			var contenedor = document.getElementById('contenedor_carga');
			contenedor.style.visibility = 'hidden';
			contenedor.style.opacity = '0';
		}
	$(document).ready(function() {
		 console.log("Sistema Desarrollado por: Carlos Morocho, Wilmer Guaman, Juan Carlos Vega, contacto: jc.vega@live.com");
				var keySitio = '<c:out value="${keySitio}" />';
				grecaptcha.ready(function() {
					grecaptcha.execute(keySitio, {
						action : 'login'
					}).then(function(token) {
						$('#g-recaptcha-response').val(token);
					});
				});

							//console.log($(".cuadro-login").html());
							//console.log($(".cuadro-login").parents("div").find("#page-wrapper").length);
				if ($(".cuadro-login").parents("div").find(
						"#page-wrapper").length) {
					window.location.href = "login?error=4";
				}

			});

		$("#btnEnviar").click(function(event) {
				var form = $("#formularioLogin")
				if (form[0].checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} /* else {
					$(".gray-bg").append(
							"<div id='cargando'>Cargando...</div>")
							.fadeIn();
					setTimeout(function() {
						$(".gray-bg").delay("slow").fadeOut();
					}, 700);
				} */
				form.addClass('was-validated');
			});

		
		
</script>
</body>
</html>