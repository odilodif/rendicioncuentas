<%-- 
	version		: 1.0
    Document  	: Lista Tabla Autoridades
    Created on	: 03/02/2021; 9:32:24
    Author		: Wilmer Guamán
    Mail		: guamanw@gmail.com
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
		<div class="card">
			<h5 class="card-header text-white carHeaderBlue" align="center">Técnico ${rol} <br>Listado de
				Autoridades Registradas</h5>
			<div class="card-body">
				<form:form class="needs-validation" novalidate=""
					id="listarReportes" data-rutaAplicacion="tecnicoNacional"
					data-opcion="ListaTablaAutoridades" data-destino="tabla"
					data-nombre="Reportes">
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="provincia">Provincia</label>
						</div>
						<div class="col-md-3 text-left">
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
						<div class="col-md-1"></div>
						<div class="col-md-2 ">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _buscar btn-sm ">Buscar</button>
						</div>
					</div>


				</form:form>
			</div>

			<hr />
			<div id="tabla"></div>

		</div>
	</div>
</div>


</html>

<script type="text/javascript">
$("#btnGuardar").click(function(event){
	   var form = $("#listarReportes")
		
	    if (form[0].checkValidity() === false   ) {
		mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
	    }else{
	   
	    	abrir($("#listarReportes"),event,false);
	    }
});
</script>