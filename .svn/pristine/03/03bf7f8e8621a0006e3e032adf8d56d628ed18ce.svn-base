
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<c:set var="nombreCpccsMinuscula"
	value="<%=Constantes.NOMBRE_MODULO_MINUSCULA%>" />
<spring:url value="/resources/" var="urlPublic" />
<spring:url value="/" var="urlRoot" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
<title>Rendicion de Cuentas</title>
<link rel="shortcut icon" type="image/x-icon"
	href="${urlPublic}img/favicon.ico" />
<link rel="stylesheet" href="${urlPublic}css/bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/datepicker.css" />
<link rel="stylesheet" href="${urlPublic}css/fontawesome-all.css" />
<link rel="stylesheet" href="${urlPublic}css/metisMenu.min.css" />
<link rel="stylesheet"
	href="${urlPublic}css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/jquery-ui.css" />
<link rel="stylesheet" href="${urlPublic}css/rendicion.css" />
<link rel="stylesheet" href="${urlPublic}css/summernote-lite.css" />
<link rel="stylesheet" href="${urlPublic}css/sweetalert.css" />
<link rel="stylesheet" href="${urlPublic}css/main.css" />
<%-- <link rel="stylesheet" href="${urlPublic}css/select2.css" />--%>
<script src="${urlPublic}js/jquery-3.3.1.js"></script>
<script src="${urlPublic}js/notificacion-aplicacion.js"></script>
<script src="${urlPublic}js/rendicion-complemento.js"></script>
<script src="${urlPublic}js/highcharts.js"></script>
<script src="${urlPublic}js/data.js"></script>
<script src="${urlPublic}js/drilldown.js"></script>
<script src="${urlPublic}js/exporting.js"></script>
<script src="${urlPublic}js/export-data.js"></script>
<script src="${urlPublic}js/accessibility.js"></script>
</head>
<body>
	<div id="contenedor_carga">
		<div id="carga"></div>
	</div>
	<div id="wrapper">
		<a id="11" style="display: none" data-rutaAplicacion="general"
			class="_inicio" data-nombreAplicacion="Inicio"
			data-destino="menuAplicaciona">Inicio</a>
		<nav class="navbar-default navbar-static-side">
			<div class="sidebar-collapse">
				<div class="nav-header inicioAplicacion">
					<div class="dropdown profile-element">
						<span style="padding-left: 20px;"> <a href="#"
							title="Inicio" id="0" data-rutaAplicacion="plantillasIndex"
							class="_inicio" data-nombreAplicacion="Aplicaciones"
							data-destino="seccionVentanaAplicacion"> <img
								alt="Logo cpccs" class="img-circle"
								src="${urlPublic}img/cpccsLogo2.png" />
						</a>
						</span>
					</div>
				</div>
				<div id="contenidoMenu">
					<div id="menuAplicaciona" style="border-top: 1px solid #253848;"></div>
					<div id="menuAplicacion" style="border-top: 1px solid #253848;"></div>
				</div>
			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg dashbard-1">
			<jsp:include page="plantillasIndex/menuTopLogout.jsp"></jsp:include>
			<section id="seccionVentanaAplicacion">
				<jsp:include page="plantillasIndex/aplicaciones.jsp"></jsp:include>
			</section>
			<section class="footer navbar-fixed-bottom" id="footer">
				<div class="arrow">NUEVO CPCCS</div>
				<div>${nombreCpccsMinuscula}</div>
			</section>
		</div>
	</div>


	<script src="${urlPublic}js/jquery-ui.js"></script>
	<script src="${urlPublic}js/popper.min.js"></script>
	<script src="${urlPublic}js/bootstrap.min.js"></script>
	<script src="${urlPublic}js/metisMenu.min.js"></script>
	<script src="${urlPublic}js/jquery.dataTables.min.js"></script>
	<script src="${urlPublic}js/dataTables.bootstrap.min.js"></script>
	<script src="${urlPublic}js/dataTables.botones.min.js"></script>
	<script src="${urlPublic}js/bootstrap.datepicker.js"></script>
	<script src="${urlPublic}js/jquery.inputmask.js"></script>
	<script src="${urlPublic}js/jquery.numeric.min.js"></script>
	<script src="${urlPublic}js/summernote-lite.js"></script>
	<script src="${urlPublic}js/select2.js"></script>
	<script src="${urlPublic}js/sweetalert.js"></script>
	<script src="${urlPublic}js/rendicion.js"></script>
    <script src="${urlPublic}js/rendicion.bloqueo.js"></script> 
    <script src="${urlPublic}js/font-awesome.js"></script>
    

	<script type="text/javascript">
		window.onload = function() {
			var contenedor = document.getElementById('contenedor_carga');
			contenedor.style.visibility = 'hidden';
			contenedor.style.opacity = '0';

		}

		$(document).ready(function() {			
			abrir($("#wrapper a").first(), "", true);
			ajustarAltoVentanaAplicacion();
/* 			visualizarMensajeConfirmacion('ATENCIÓN', 'el ingreso a la plataforma para completar su formulario será activado desde el mes de JUNIO/JULIO!','', 'registro');
 */			
		});
	</script>
</body>
</html>