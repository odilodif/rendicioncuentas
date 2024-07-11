<%-- 
	version		: 1.0
    Document  	: Frm_ReporteGestionCatastro
    Created on	: 9 jun. 2021; 09:01:44 
    Author		: Juan Carlos Vega
    Mail		: jcmono@gmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<!DOCTYPE>
<html>
<spring:url value="/resources/" var="urlPublic" />

<div class="card">
	<div class="card-body">
	
			<h5 class="card-header text-white carHeaderBlue" align="center">Técnico ${rol} <br>GESTIÓN CATASTRO</h5>
			<div class="card-body">
				<form:form class="needs-validation" novalidate=""
					id="listarReportesGestionCatastro" data-rutaAplicacion="tecnicoNacional"
					data-opcion="ReporteGestionCatastro" data-destino="tablaGestionCatastro"
					data-nombre="Reporte">
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="provincia">Periodo</label>
						</div>
						<div class="col-md-3 text-left">
							<select class="custom-select custom-select-sm" id="periodo"
								required="required" name="periodo">
								
									<c:forEach var="i" begin="${anio}" end="${anioActual-1}" step="1" varStatus ="status">
								    <c:set var="selected" value="" />
								    <c:choose>
							   			<c:when test="${anio==i}">
							   				<option value="">Seleccione...</option>
							   			</c:when>
							   		</c:choose>
							   		<option ${selected} value="${i}">${i}</option>
								</c:forEach>
							</select>
							<div class="invalid-feedback">Por favor seleccione el
								año</div>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2 ">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _buscar btn-sm ">Generar</button>
						</div>
					</div>


				</form:form>
			</div>

			<hr />
			<div id="tablaGestionCatastro"></div>

	</div>
</div>


</html>

<script type="text/javascript">
$("#btnGuardar").click(function(event){
	   var form = $("#listarReportesGestionCatastro")
		
	    if (form[0].checkValidity() === false   ) {
		mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
	    }else{
	   
	    	abrir($("#listarReportesGestionCatastro"),event,false);
	    }
});
</script>