<%-- 
	version		: 1.0
    Document  	: Frm_ImplementacionGadsActul
    Created on	: 19/02/2021; 13:19:12
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
<div class="card card-secondary">
	<form:form class="needs-validation" novalidate=""
		modelAttribute="TblImplementacionPresupuesto"
		id="ImplementacionPresupuesto" data-rutaAplicacion="rendicion"
		data-opcion="guardarImplementacionPreActu" data-accionEnExito="ACTUALIZAR">
		<h5 class="card-header text-white carHeaderBlue" align="center">IMPLEMENTACIÓN
			DE POLÍTICAS PÚBLICAS GRUPOS DE ATENCIÓN PRIORITARIA: PRESUPUESTO</h5>
		<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
		<div class="col-md-12 text-left">

			<table class="table registros table-bordered ">
				<tr>
					<td class="tablaingreso">SE ASIGNÓ UN PORCENTAJE DE LOS
						INGRESOS NO TRIBUTARIOS DEL GAD A LOS GRUPOS DE ATENCIÓN PRIORITARIA</td>
					<td class="tablaingreso">IDENTIFIQUE A QUÉ GRUPO DE ATENCIÓN
						PRIORITARIA</td>
					<td class="tablaingreso">QUÉ PORCENTAJE SE ASIGNÓ A LOS
						DISTINTOS GRUPOS</td>
				</tr>
				<tr>
					<td style=" width: 300px;" align="center"><select
						class="custom-select custom-select-sm" id="seleccion"
						name="seleccion" required="required">
							<option value="">Seleccione...</option>
							<option value="SI">SI</option>							
					</select></td>
					<td><select class="custom-select custom-select-sm case"
						id="listaopciones" name="listaopciones">
							<option value="">Seleccione...</option>
							<c:forEach var="listaopciones"
								items="${listaopciones}">
								<option value="${listaopciones}">${listaopciones}</option>
							</c:forEach>
					</select>
						<div class="invalid-feedback">Por favor seleccione la
							el grupo de atención prioritario</div>
					<td style="width: 150px;"><input type="number"
						id="porcentaje1" name="porcentaje1" min="1" max="100" step="0.01"  onkeypress="javascript:return validarnro(event);"
						class="form-control form-control-sm number">
						<div class="invalid-feedback">Ingrese el porcentaje</div></td>
				</tr>


			</table>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarI"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		$(".case").prop("disabled", "disabled");
		$(".number").prop("disabled", "disabled");
		
	});

	$("#seleccion").change(function() {
		var seleccion = $("#seleccion").val();
		if (seleccion == "SI") {
			$(".case").removeAttr("disabled");
			$(".number").removeAttr("disabled");
			$(".case").removeAttr("required",true);
			$("#porcentaje1").prop("required", true);

		} else {
			$("#porcentaje1").removeAttr("required");
			$(".number").removeAttr("required");
			$(".case").removeAttr("required");
			$(".number").val("");
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			
			$(".number").prop("disabled", "disabled");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});


	$("#btnGuardarI").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
	var form = $("#ImplementacionPresupuesto")
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
	mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
				} else {
								ejecutarJson(form);
						}
						form.addClass('was-validated');

					});
</script>