<%-- 
	version		: 1.0
    Document  	: Frm_GAD_ObjetivoPlanDesarrollo
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
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
	<c:when test="${inf_estado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>OBJETIVOS DEL PLAN DE DESARROLLO DE SU TERRITORIO</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblObjetivosPlanDesarrollo" id="ObjetivosPlanNuevo"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarObjetivosPlan" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					
	   <tr>
        <th>DESCRIBA EL OBJETIVO DE SU PLAN DE DESARROLLO TERRITORIAL:</th>
       </tr>
					
					<tr>
					<th class="tablaObjetivo">OBJETIVO</th>
					<tr>
					<td scope="row">
									<textarea rows="2" cols="" class="form-control form-control-sm"
										id="objNombre" required="required"
										name="objNombre"
										placeholder="Ingrese el objetivo lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
					</td>
					</tr>
					</table>
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

});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#ObjetivosPlanNuevo').attr('data-opcion',	'guardarObjetivosPlan');
					var form = $("#ObjetivosPlanNuevo")
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
