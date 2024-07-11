<%-- 
	version		: 1.0
	Document  	: gestionarDenunciasPedidosTecnico
	Property   	: CPCCS
	Author		: wilmer guaman
	Mail		: e.du.ingcharles@hotmail.com
    Date		: 02/25/2018, 10:16:19
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
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<head>
</head>
<div class="card text-center mb-card10">
	<div class="card-header">
		<h5>Formulario para la Activación o Negación de Instituciones</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblAutoridad" id="gestionarActivacion"
					data-rutaAplicacion="rendicion" data-opcion="guardarActivacionAutoridad"
					data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${usuario.username}">
					<input type="hidden" name="instCod" id="instCod" value="${id}">
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Datos de la
							Autoridad</h5>
						<div class="card-body">
							<div class="form-group row">
							<div class="col-md-2 text-left">
									<label for="esServidorPublico">Nombre Autoridad</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="ntramite" name="ntramite" value="${institucion}" />

								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">Número de Cédula</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="ingreso" name="ingreso" value="${ruc}" />

								</div>
								
							</div>
						
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="provincia">Provincia </label>
								</div>
								<div class="col-md-2 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="nombreProvincia" name="nombreProvincia"
										value="${nombreProvincia}" />

									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
								<div class="col-md-1 text-left">
									<label for="provincia">Cantón </label>
								</div>
								<div class="col-md-2 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="nombreProvincia" name="nombreProvincia"
										value="${canton}" />

									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
								<div class="col-md-1 text-left">
									<label for="provincia">Parroquia </label>
								</div>
								<div class="col-md-2 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="nombreProvincia" name="nombreProvincia"
										value="${parroquia}" />

									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
							</div>
							
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="dignidad">Dignidad </label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="dignidad" name="dignidad"
										value="${dignidad}" />

									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="dignidad">Tipo de Autoridad </label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										disabled id="dignidad" name="dignidad"
										value="${tipoAutoridad}" />

									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
							</div>
							
					<c:choose>	
							<c:when test="${otros=='si'}">
					<div id="Mensaje">
					<div class="alert alert-danger" role="alert">Existe una autoridad registrada con el mismo número de cédula, revise el listado de autoridades activas
					</div>
					</div>
		</c:when>

<c:otherwise>

		</c:otherwise>
</c:choose>

							
  <p></p>
						<div class="form-group row">
							<div class="col-md-3"></div>
							<div class="col-md-2 text-center">
								<button type="submit" id="btnGuardaraprobar"
									class="btn _nuevoColor _aprobar btn-sm mt-2">Aceptar Autoridad</button>
							</div>
							
							<div class="col-md-2 text-center">
								<button type="button" id="btnGuardarRechazar"
									class="btn _seleccionarColor _negar btn-sm mt-2">Negar Autoridad </button>
							</div>
							
						</div>
						 	<hr />
						
							<div class="form-group row">
								<div class="col-md-1 text-left">
									<label for="archivoAdjunto">Cédula Archivo</label>
								</div>
								<div class="col-md-5 text-left">
									<c:choose>
										<c:when test="${tipo1=='pdf'}">
										<iframe id="inlineFrameExample"
                                          title="Inline Frame Example"
                                           width="400px"
                                           height="500px"
                                              src="${rutaArchivosAplicacion}${archivoRespaldoCedula}">
                                        </iframe>
<%-- 											<a href="${rutaArchivosAplicacion}${archivoRespaldo}" --%>
<!-- 												target="framename" class="archivoCargado" id="archivoCargado">Click -->
<!-- 												aquí para ver archivo</a> -->
										</c:when>
										
										<c:otherwise>
										<%-- 	<img src="${rutaArchivosAplicacion}${archivoRespaldoCedula}" class="img-fluid"  width="400px"
                                           height="500px"/> --%>
                                           <iframe id="inlineFrameExample"
                                          title="Inline Frame Example"
                                           width="400px"
                                           height="500px"
                                              src="${rutaArchivosAplicacion}${archivoRespaldoCedula}">
                                        </iframe>
											
										</c:otherwise>
									</c:choose>
								</div>
								
								<div class="col-md-1 ">
									<label for="archivoAdjunto">Nombramiento Archivo</label>
								</div>
								<div class="col-md-2 text-left">
									<c:choose>
										<c:when test="${tipo=='pdf'}">
										<iframe id="inlineFrameExample"
                                          title="Inline Frame Example"
                                           width="400px"
                                           height="500px"
                                              src="${rutaArchivosAplicacion}${archivoRespaldo}">
                                        </iframe>
<%-- 											<a href="${rutaArchivosAplicacion}${archivoRespaldo}" --%>
<!-- 												target="framename" class="archivoCargado" id="archivoCargado">Click -->
<!-- 												aquí para ver archivo</a> -->
										</c:when>
										
										<c:otherwise>
										<%--	<img src="${rutaArchivosAplicacion}${archivoRespaldo}" class="img-fluid"  width="400px"
                                           height="500px"/>--%>
										  <iframe id="inlineFrameExample"
                                          title="Inline Frame Example"
                                           width="400px"
                                           height="500px"
                                              src="${rutaArchivosAplicacion}${archivoRespaldo}">
                                        </iframe>	
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
                   
				</form:form>
			</div>
		</div>
	</div>
</div>
	<div class="modal fade bd-example-modal-sm" id="Historial1" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-camm" role="document">
		<div class="modal-content">
			<div class="modal-header">	
				<h5 class="modal-title" id="HistorialLabel">Negar Autoridad</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<span aria-hidden="true"></span>
				
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblInstitucion" id="formularioNegar"
							data-rutaAplicacion="rendicion"
							data-opcion="GuardarNegacionAutoridad" data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="codinst" name="codinst">            
                             <div class="form-group">
                            <label for="message-text" class="col-form-label">Describa el motivo de la negación:</label>
                               <textarea rows="4" cols="" class="form-control form-control-sm"
										id="descripcionAsunto" required="required"
										name="descripcionAsunto"
										placeholder="Ingrese la descripción de la solicitud lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese la descripción de la negación</div>
                            </div>
							
						</form:form>
						<div class="modal-footer">
								<button type="button" class="btn btn-secondary  btn-sm mt-2"
									data-dismiss="modal">Close</button>
								<button type="submit" id="btnGuardarNegar"
									class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					 </div>
					
			</div>
		</div>
	</div>
</div>
</html>

<script type="text/javascript">
$("#btnGuardaraprobar").click(function(event) {
	
		var form = $("#gestionarActivacion")
		event.preventDefault();
		event.stopPropagation();
	
	if (form[0].checkValidity() === false  ) {
		mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR")
	}else{
		
				ejecutarJson(form);    	
			
		}
	form.addClass('was-validated');
	
});
$("#btnGuardarNegar").click(function(event) {
	
	var form = $("#formularioNegar")
	event.preventDefault();
	event.stopPropagation();

if (form[0].checkValidity() === false  ) {
	mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR")
}else{
	
			ejecutarJson(form);   
			$("#Historial1").modal('hide');//ocultamos el modal
		    $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
		    $('.modal-backdrop').remove();
		
	}
form.addClass('was-validated');

});

$("#btnGuardarRechazar").click(function(event) {	
	var codigo = $("#instCod").val();
	$("#codinst").val(codigo);			
	$("#Historial1").modal("show");
	
});


</script>
