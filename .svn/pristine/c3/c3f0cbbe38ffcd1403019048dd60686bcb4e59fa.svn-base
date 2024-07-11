
<%-- 
	version		: 1.0
    Document  	: ListaEditarUsuInstitucion
    Created on	:  02/02/2021, 13:35:59
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<%@ page session="false"%>
<sec:authentication var="usuario" property="principal" />
<!DOCTYPE">
<html>
<head>
<style>
.table-striped  tbody tr:nth-of-type(odd) {
	background-color: none;
}

.colorAzul {
	background-color: #17a2b826;
}

.colorNaranja {
	background-color: #f7be8130;
}

.colorVerde {
	background-color: #51A351;
}
</style>
</head>
<div class="card text-center mb-card15">
	<h5 class="card-header text-white carHeaderBlue">Técnico ${rol}
	 <br>
	 Listado de Usuario Institución </h5>
	<div class="card-body">
		
		<form:form class="needs-validation" name="listaPerfil"
			id="listaPerfil" data-rutaAplicacion="tecnicoNacional"
			data-opcion="TablaPerilInstitucion" data-destino="tabla"
			data-nombre="Editar perfiles Institución">
			<div class="form-group row">
				<div class="col-md-2 text-left">
					<label for="provincia">Provincia:</label>
				</div>
				<div class="col-md-6 text-left">
					<select class="custom-select custom-select-sm" id="provincia"
						required="required" name="provincia">
						<option value="">Seleccione...</option>
						<c:forEach var="listadoLocalizacionProvincia"
							items="${listadoLocalizacionProvincia}">
							<option value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
						</c:forEach>
					</select>
					<div class="invalid-feedback">Por favor seleccione la
						provincia</div>
				</div>
				<div class="col-md-2 text-left">
					<button type="submit" id="btnGuardar"
						class="btn _nuevoColor _buscar btn-sm ">Buscar</button>
				</div>
			</div>

		</form:form>
		<hr />
		<div id="tabla" class="col-md-12"></div>
		

	</div>


</div>


</html>

<script>
	$("#btnGuardar").click(	function(event) {
		var form = $("#listaPerfil");
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
				} else
					{
						abrir($("#listaPerfil"), event, false);
					}
			});
</script>