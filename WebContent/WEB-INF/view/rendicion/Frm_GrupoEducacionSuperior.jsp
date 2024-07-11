<%-- 
	version		: 1.0
    Document  	: Frm_GrupoEducacionSuperior
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
		<h5>GRUPO DEL SISTEMA DE EDUCACIÓN SUPERIOR</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInforme" id="infCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarGrupoEducacion" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					
	   <tr>
        <th>A QUE GRUPO DEL SISTEMA DE EDUCACIÓN SUPERIOR PERTENECE (Art. 352 Constitución del Ecuador)</th>
       </tr>
					
					<tr>
					<td scope="row">
						<select class="custom-select custom-select-sm" id="infGprEducacion"
												name="infGprEducacion" required="required">
												<option value="">Seleccione...</option>
												<option value="UNIVERSIDAD">UNIVERSIDAD</option>
												<option value="ESCUELA POLITÉCNICA">ESCUELA POLITÉCNICA</option>
												<option value="INSTITUTO TÉCNICO SUPERIOR">INSTITUTO TÉCNICO SUPERIOR</option>
												<option value="INSTITUTO SUPERIOR TECNOLÓGICO">INSTITUTO SUPERIOR TECNOLÓGICO</option>
												<option value="CONSERVATORIO SUPERIOR DE MÚSICA Y ARTES">CONSERVATORIO SUPERIOR DE MÚSICA Y ARTES</option>
											</select>
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
<c:when test="${inf_estado=='matriz'}">

<div class="row justify-content-center align-items-center">
				
				<div class="botones" role="group">
					<c:forEach items="${acciones}" var="a">
						<a class="btn ${a[5]} btn-sm" id="${a[2]}"
							data-rutaAplicacion="${a[4]}" data-opcion="${a[1]}"
							data-destino="detalleItem"> <c:if
								test="${a[2]=='_seleccionar'}">
								<span class='cantidadItemsSeleccionados'>0</span>
							</c:if> <c:if test="${a[2]!='_seleccionar'}">
								<span class="${a[2]}"></span>
							</c:if> <span>${a[3]}</span></a>
					</c:forEach>
				</div>
			
			</div>
		
	<div id="grupo">
	<div class="card-header text-white carHeaderBlue">
		<h5>GRUPO DEL SISTEMA DE EDUCACIÓN SUPERIOR</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInforme" id="infCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarGrupoEducacion" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					
	   <tr>
        <th>A QUE GRUPO DEL SISTEMA DE EDUCACIÓN SUPERIOR PERTENECE (Art. 352 Constitución del Ecuador)</th>
       </tr>
					
					<tr>
					<td scope="row">
						<select class="custom-select custom-select-sm" id="infGprEducacion"
												name="infGprEducacion" required="required">
												<option value="">Seleccione...</option>
												<option value="UNIVERSIDAD">UNIVERSIDAD</option>
												<option value="ESCUELA POLITÉCNICA">ESCUELA POLITÉCNICA</option>
												<option value="INSTITUTO TÉCNICO SUPERIOR">INSTITUTO TÉCNICO SUPERIOR</option>
												<option value="INSTITUTO SUPERIOR TECNOLÓGICO">INSTITUTO SUPERIOR TECNOLÓGICO</option>
												<option value="CONSERVATORIO SUPERIOR DE MÚSICA Y ARTES">CONSERVATORIO SUPERIOR DE MÚSICA Y ARTES</option>
											</select>
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
	
	</div>
	
	<div id="tablaGrupo">
			<table class="table table-striped table-bordered dataTable no-footer">
				<thead style="background-color: rgb(31, 137, 72);">
					 <tr>
     				  </tr>
					<tr>
						<th>#</th>
						<th>  <p style="color:white;">GRUPO DEL SISTEMA DE EDUCACIÓN SUPERIOR PERTENECE (Art. 352 Constitución del Ecuador)</p></th>
						<th> </th>
					</tr>
					</thead>
					 <tr>
					<td scope="row">
									1
					</td>
					<td scope="row">
									${inf_gpr_educacion}
					</td>
					<td scope="row">
					<c:choose>
							<c:when test="${infestadoinforme=='finalizado'}">
							
									</c:when>
									<c:when test="${infestadoinforme=='activo'}">
					<button type="submit" id="btnActualizar"
					class="_modificar btn _actualizarColor btn-sm">Editar</button>
					</c:when>
									</c:choose>
					</td>
					</tr>
				<tbody>
				</tbody>				
			</table>
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

			if ('${inf_estado}' == 'matriz') {
				tabla();			
			}
			$('#grupo').hide();


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
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#infCod').attr('data-opcion',	'guardarGrupoEducacion');
					var form = $("#infCod")
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


$("#btnActualizar")
.click(
		function(event) {
			$('#tablaGrupo').hide();
			$('#infGprEducacion').val("${inf_gpr_educacion}")
			$('#grupo').show();
});


 
				
</script>
