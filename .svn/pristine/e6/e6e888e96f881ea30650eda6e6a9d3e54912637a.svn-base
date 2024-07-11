<%-- 
	version		: 1.0
    Document  	: Frm_Plan_trabajo_Autoridad_Nuevo.jsp
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
<div class = "card body">
<div class="card text-center mb-card20">

	
		<h4 class="card-header text-white carHeaderBlue">
									CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL
										ORGANISMO COMPETENTE
								</h4>

	<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Ingrese uno a uno las registos</div>
		</div>
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
						modelAttribute="TblPlanTrabajo" id="FmrGuardarPlanFin"
						data-rutaAplicacion="gestion"
						data-opcion="guardarPlanTrabajoFin">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">

					<tr>
					<th width="100%" colspan="2" style="text-align: center;">CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL ORGANISMO COMPETENTE</th>
			
					</tr>
					
					<tr>
					
					<td scope="row" width="20%">
						EJE DEL PLAN DE TRABAJO PLANTEADO FORMALMENTE AL CNE
					</td>
					
						<td scope="row" width="80%">
												
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id=pltPlan required="required"
										name="pltPlan"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRINCIPALES ACCIONES REALIZADAS  
					</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlAcciones" required="required"
										name="ptlAcciones"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
							PRINCIPALES RESULTADOS OBTENIDOS 
												</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlResultados" required="required"
										name="ptlResultados"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
				OBSERVACIONES							</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlObs" required="required"
										name="ptlObs"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					
					</table>
						
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarPlanFin2"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
	
</div>		
</div>
</html>

<script type="text/javascript">

 
	$("#btnGuardarPlanFin2").click(function(event) {
		var form = $("#FmrGuardarPlanFin")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
					ejecutarJson(form);
					abrir($("#menuAplicacion #menu a.linkAbierto"),
							null, true);
		}
			form.addClass('was-validated');
	});

	
</script>