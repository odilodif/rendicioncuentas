<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoCoberturaTerritorialActul
    Created on	: 17 mar. 2021; 15:23:12
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

<div class="card text-center mb-card15">

			<div class="card-header text-white carHeaderBlue">
				<h5>CANTIDAD DE ENTIDADES OPERATIVAS DESCONCENTRADAS</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblCoberturaNacional" id="CoberturaTerritorialActul"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarCoberturaTerritorial"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
						

							<table class="table registros table-bordered">
								<tr>
									<th class="tablaingreso">COBERTURA /NIVEL</th>
									<th class="tablaingreso">NO. DE UNIDADES</th>
									<th class="tablaingreso">DESCRIPCIÓN DE LA COBERTURA</th>
								</tr>
								<tr>
									<td style="vertical-align: middle;" width="150px" ><select
										class="custom-select custom-select-sm" id="cnCobertura"
										name="cnCobertura" required="required">
											<option value="">Seleccione...</option>
											<option value="ZONAL">ZONAL</option>
											<option value="REGIONAL">REGIONAL</option>
											<option value="PROVINCIAL">PROVINCIAL</option>
											<option value="DISTRITAL">DISTRITAL</option>
											<option value="CIRCUITOS">CIRCUITOS</option>
									</select></td>
									<td style="vertical-align: middle;"  width="120px"><input type="number"
										class="form-control form-control-sm" id="cnUnidades"
										name="cnUnidades" placeholder="000" maxlength="20"
										required="required" pattern="^[0-9]+"
										min="0" onkeypress="mascaraEnteros(this)" onpaste="return false">
										<div class="invalid-feedback">Por favor ingrese la información solicitada</div></td>

									<td style="vertical-align: middle;"><textarea rows="1"
											cols="" class="form-control form-control-sm observacion1"
											id="cnDescripcion" name="cnDescripcion" required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese la
											Descripción</div> <input type="hidden" id="tipo" name="tipo"
										value="EOD"></td>


								</tr>
							</table>
						</form:form>
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardarTerritorialActul"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>

	

</div>
</html>

<script type="text/javascript">

$(document).ready(function() {

			
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
			
$("#btnGuardarTerritorialActul").click(function(event) {
				
	var form = $("#CoberturaTerritorialActul")
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
