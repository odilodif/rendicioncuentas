<%-- 
	version		: 1.0
    Document  	: DatosActivarInformeInstitucion
    Created on	: 03/02/2021; 14:23:30
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<spring:url value="/resources/" var="urlPublic" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<c:set var="tamanioArchivo" value="<%=Constantes.TAMANIO_ARCHIVO_5_MEGAS%>" />
<c:set var="rutaModuloRegistro" value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<!DOCTYPE">
<html>
<head>

</head>
<div class="card text-center mb-card15">
	<h5 class="card-header text-white carHeaderBlue">Activar Informe</h5>
	<div class="card-body">

		<div class="card card-secondary">
			<form:form class="needs-validation" novalidate=""
							modelAttribute="TblInforme" id="ActivarInforme"
							data-rutaAplicacion="tecnicoNacional"
							data-opcion="GuardarActivarInformeAutoridad" data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
					<input type="hidden" id="instCod" name="instCod"
					value="${instCod}">
					<br>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="infCod">Número de Informe:</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="infCod"
								 disabled="disabled" name="infCod"
								value="${infCod}"  />
						</div>
							</div>
							
								<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="Ruc">Cédula:</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"  disabled="disabled"
								class="form-control form-control-sm " id="instRuc"
								 name="instRuc"
								 value="${rucInstitucion}"  />
						</div>
							</div>
			
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="CargoResponRegis">Nombre de la Autoridad:</label>
						</div>
						<div class="col-md-10 text-left ">
							<input type="text" style="text-transform: uppercase;" disabled="disabled"
								class="form-control form-control-sm" id="instNom"
								 name="instNom"		value="${nombreInstitucion}">
						</div>
							</div>
							
		<c:choose>
		<c:when test="${aperturaPrevia=='aperturaPrevia'}">				
		
		<br>
		<div class="form-group row">
								<div class="col-md-6 text-left">
									<label for="apertura">Última acción de apertura de Informe</label>
								</div>
								</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="infCod">Fecha de apertura:</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="apertura"
								 disabled="disabled" name="apertura"
								value="${fechaReapertura}"  />
						</div>
							</div>
							
								<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="archivoAdjunto">Archivo de respaldo</label>
								</div>
								<div class="col-md-9 text-left">
									<c:choose>
										<c:when test="${rutaAnexo==null}">
											<span class="alerta">No ha subido ningún archivo aún</span>
										</c:when>
										<c:otherwise>
											<a href="${rutaArchivosAplicacion}${rutaAnexo}" target="_blank"
												class="archivoCargado" id="archivoCargado">Click aquí para ver archivo</a>
											<br />
										</c:otherwise>
									</c:choose>
								</div>
							</div>
			
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="Tecnico">Técnico que realizó la última apertura:</label>
						</div>
						<div class="col-md-10 text-left ">
							<input type="text" style="text-transform: uppercase;" disabled="disabled"
								class="form-control form-control-sm" id="Tecnico"
								 name="Tecnico"		value="${tecnicoAnterior}">
						</div>
							</div>
		
		
		</c:when>
		</c:choose>	
		<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Recuerde verificar los datos de la autoridad antes de realizar la apertura del informe</div>
		</div>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="cargo">Adjunte la solicitud de apertura o el memorando de autorización en formato .pdf .jpeg, .jpg, .png:</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="informe"
										name="informe" accept=".png, .jpg, .jpeg,.pdf">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaAnexo" id="rutaAnexo"
										name="rutaAnexo" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo"
										class="subirArchivo adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRegistro}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>



					<div class="form-group row">			
					<div class="col-md-2 text-left">
							<label for="passwordResponRegis">Razón de la apertura de informe:</label>
						</div>
						<div class="col-md-10 text-left">
							<input type="text" class="form-control form-control-sm"
								id="razonApertura" required="required"
								name="razonApertura" minlength="3"  
								placeholder="INGRESE EL DETALLE">
							<div class="invalid-feedback">
								Detalle la razón de la apertura del informe
							</div>
						</div>
					</div>
				
				
			<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="CargoResponRegis">Aprobado Por:</label>
						</div>
						<div class="col-md-10 text-left ">
							<input type="text" style="text-transform: uppercase;" disabled="disabled"
								class="form-control form-control-sm" id="nombreSubcoordinador"
								 name="nombreSubcoordinador"		value="${subcoordinador}">
						</div>
							</div>
			
				<button type="submit" id="btnRegistro"
										class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</form:form>
		</div>

	<!--  -->



	</div>


</div>


</html>

<script>

$(document).ready(function() {	

	
});

$("#btnRegistro").click(function(event) {
		var form = $("#ActivarInforme")	
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			$("#infCod").removeAttr("disabled");
			$("#nombreSubcoordinador").removeAttr("disabled");
				ejecutarJson(form);	
				//abrir($("#Frm_ListaRegistro"),event,false);
		}
		form.addClass('was-validated');
	
	});


$('button.subirArchivo').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaAnexo");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = 
					$("#infCod").val()
					+ "_Informe_"
					+ fecha.getFullYear()
					+ "_"
					+ (fecha.getMonth() + 1)
					+ "_"
					+ fecha.getDate()
					+ "-"
					+ fecha.getHours()
					+ "_"
					+ fecha.getMinutes()
					+ "_"
					+ fecha.getSeconds();


			if (extension[extension.length - 1].toUpperCase() == 'PDF' ||extension[extension.length - 1].toUpperCase() == 'JPEG'||extension[extension.length - 1].toUpperCase() == 'JPG' ||extension[extension.length - 1].toUpperCase() == 'PNG') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo, new carga(estado, archivo, boton), "${tamanioArchivo}");
				$('#EliminarArchivo').show();
				$('#EliminarArchivo').removeAttr("disabled");
				$('#subirArchivo').hide();

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF, JPG, JPEG, PNG');
				archivo.val("");
			}
		});

$('button.EliminarArchivo').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaAnexo");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo').removeAttr("disabled");
	$('#EliminarArchivo').hide();
	$('#subirArchivo').show();
	
	$('#informe').val('');

});

</script>