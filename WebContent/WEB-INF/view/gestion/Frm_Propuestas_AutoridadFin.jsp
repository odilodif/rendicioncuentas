<%-- 
	version		: 1.0
    Document  	: Frm_Propuestas_Autoridad.jsp
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
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

			<h4 class="card-header text-white carHeaderBlue">
									PROPUESTAS DE ACCIONES DE LEGISLACIÓN, FISCALIZACIÓN,POLÍTICA PÚBLICA
								</h4>
			<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Ingrese uno a uno las registos</div>
		</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblPropuestas" id="PropuestasAutoridades"
							data-rutaAplicacion="gestion"
							data-opcion="guardarPropuestasAutoridadFin">
							<input type="hidden" id="infAutCod" name="infAutCod"
								value="${infAutCod}">
							<div class="col-md-12 text-left">
								<table class="table registros table-bordered">

									<tr>
										<td scope="row" width="20%">PROPUESTAS</td>
										<td scope="row" width="80%"><textarea rows="2" cols=""
												class="form-control form-control-sm" id=proDescripcion
												required="required" name="proDescripcion"
												placeholder="Ingrese la información lo más detalladamente posible"
												></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
									<tr>
										<td scope="row">RESULTADOS</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm" id="proResultados"
												required="required" name="proResultados"
												placeholder="Ingrese la información lo más detalladamente posible"
												></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
								</table>

							</div>
							<div class="col-md-12 text-center">
								<button type="submit" id="btnGuardarI"
									class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>


</div>
</html>

<script type="text/javascript">

	$("#btnGuardarI")
			.click(
					function(event) {
						var form = $("#PropuestasAutoridades")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							ejecutarJson(form);
							abrir($("#menuAplicacion #menu a.linkAbierto"),null, true);
						}
						form.addClass('was-validated');
					});

	
</script>