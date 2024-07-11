<%-- 
	version		: 1.0
    Document  	: NuevoInscripcion
    Created on	: 24/07/2020, 12:11:34
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com

--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="com.sistema.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<c:set var="tamanioArchivo"
	value="<%=Constantes.TAMANIO_ARCHIVO_25_MEGAS%>" />
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_ARCHIVOS_APLICACION%>" />
<c:set var="rutaModuloInscripcion"
	value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />
<c:set var="valor"
	value="<%=Constantes.valorPago1%>" />

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
<div class="card text-center mb-card20">
	<c:choose>
		<c:when test="${estadoMatricula=='preinscrito'||estadoMatricula=='inscrito'|| estadoMatricula=='completar-informacion' || estadoMatricula=='validado'|| estadoMatricula=='habilitado' || estadoMatricula=='informacion-completada'}">
		<div class="card card-secondary">
				<div >
					<div id="informacion">
						¡Excelente!... Usted ya se encuentra inscrito revise su bandeja de
						Seguimiento Matricula para revisar el estado de su inscripción.<br />
						<span style="font-weight: bold;"></span> <br />Gracias por preferirnos.
					</div>
				</div>
		
			</div>
		
		</c:when>
		<c:otherwise>
				
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDocumento" id="NuevoInscripcion"
					data-rutaAplicacion="inscripcion"
					data-opcion="GuardarNuevoInscripcion" data-destino="detalleItem"
					data-accionEnExito="ACTUALIZAR">
					<input type="hidden" id="identificadorSolicitante"
						name="identificadorSolicitante" value="${usuario.username}">
						<input type="hidden" id="acuedo"
						name="acuerdo" value="${acuerdo}">
					<div class="card">
						<h4 class="card-header text-white carHeaderBlue">Registro
							Matricula Online</h4>
						<div class="card-body">
							<!-- -->
							<input type="hidden" id="fechanacimiento"
						name="fechanacimiento" value="${fechanacimiento}">


							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="Cedula">Cédula</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="identificador" required readonly="readonly"
										name="identificador" placeholder="Ingrese Cédula"
										minlength="10" maxlength="10" value="${identificador}"
										pattern="[0-9]{10,10}">
									<div class="invalid-feedback">Ingrese Cedula</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="nombreApellido">Nombres/Apellidos</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="nombreApellido" required readonly="readonly"
										name="nombreApellido" placeholder="Ingrese Nombres/Apellidos"
										minlength="6" maxlength="100" value="${nombreApellido}"
										pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$">
									<div class="invalid-feedback">Ingrese Nombre Alumno</div>
								</div>

							</div>
							<!-- -->

							<!-- -->
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="celular"># Celular Alumno</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="celular" required readonly="readonly" name="celular"
										placeholder="(00) 0000-0000" maxlength="14" value="${celular}"
										pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
										data-inputmask="'mask': '(99) 9999-9999'">
									<div class="invalid-feedback">Ingrese # celular Alumno</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="mailAlumno">Email Alumno</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="email" class="form-control form-control-sm"
										id="email" required name="email" readonly="readonly"
										placeholder="Ingrese su email" value="${email}"
										pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Ingrese una dirección de
										correo valida</div>
								</div>
							</div>
							<!-- -->
							<!-- -->
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="tipotiutlo" class="col-form-label">Tipo
										Licencia</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										required="required" id="tipoTitulo" name="tipoTitulo">
										<option value="">Seleccione...</option>
										<!--	<option value="A">TIPO A</option>
										<option value="B">TIPO B</option>-->
										<option value="C">TIPO C</option>
										<option value="E-Convalidada">TIPO E - Convalidada</option>
										<option value="E-Regulada">TIPO E - Regulada</option>

									</select>
									<div class="invalid-feedback">Seleccione el tipo de
										licencia</div>
								</div>
								<div class="col-md-3 ">
									<label for="tipotiutlo" class="col-form-label">Modalidad de Estudio:</label>
								</div>
								<div class="col-md-3 ">
									<select class="custom-select custom-select-sm"
										required="required" id="modalidad" name="modalidad">
										<option value="">Seleccione...</option>
										<!--	<option value="A">TIPO A</option>
										<option value="B">TIPO B</option>-->
										<option value="virtual_semana">Virtual - Lunes a Viernes</option>
										<option value="virtual_fin_semana">Virtual - Sábado a Domingo</option>

									</select>
									<div class="invalid-feedback">Seleccione la Modalidad de Estudios</div>
								</div>
							</div>
							<!-- -->


						</div>
					</div>



					
					
					<div id="MensajeEdad">
					<div class="alert alert-warning" role="alert">Usted no cumple con la edad requerida para matricularse en este periodo, la edad registrada en la inscripción es:  <strong id="edad">	</strong> </div>
				     </div>
							<!--
							<div id="fileuploader"></div>
					<fieldset>
						<div class="alert alert-warning" role="alert">
							Requisitos para la inscripción tipo  <strong id="tipo">
							</strong>  <strong id="pago"> </strong>
						</div>
						<legend>Requisitos Matricula</legend>
						<table style="width: 100%">
							<tr>
								<td style="width: 30%"><label for="cargo">Adjuntar
										Cédula o Pasaporte, Papeleta de votación de los ultimos comicios y Carné de tipo sanguíneo emitido por la Cruz Roja Ecuatoriana o por un Laboratorio en formato pdf</label></td>
								<td>
									<div class="form-group row">

										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file" required="required"
												class="form-control-file archivo gris" id="informe"
												name="informe" accept="application/pdf">

											<div class="estadoCarga">En espera de archivo...
												(Tamaño máximo ${tamanioArchivo})</div>
											<input type="hidden" class="rutaArchivo" id="pathcedula"
												name="pathcedula" value="" />
											<div class="invalid-feedback">Por favor seleccione un
												archivo</div>
										</div>

										<div class="col-md-3 text-left">
											<button type="button" id="subirArchivo"
												class="subirArchivo adjunto btn _nuevoColor btn-sm"
												data-rutaCarga="${rutaModuloInscripcion}">
												<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>
											</button>

											<button type="button"
												class="EliminarArchivo adjunto btn _eliminarColor btn-sm"
												id="EliminarArchivo" disabled="disabled">
												<i class="fas fa-trash mr-1" aria-hidden="true"></i>
											</button>
										</div>

									</div>
								</td>
							</tr>
							<tr>
								<td style="width: 30%"><label for="cargo">Adjuntar
										Visa en formato pdf (Opcional)</label></td>
								<td>
									<div class="form-group row">
										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file"  class="form-control-file archivovisa gris" id="visa" name="visa" accept="application/pdf">
											<div class="estadoCarga">En espera de archivo...(Tamaño máximo ${tamanioArchivo})</div>
											<input type="hidden" class="rutaArchivovisa" id="pathvisa" name="pathvisa" value="" />
											<div class="invalid-feedback">Por favor seleccione un archivo</div>
										</div>

										<div class="col-md-3 text-left">
											<button type="button" id="subirvisa" class="subirvisa adjunto btn _nuevoColor btn-sm" data-rutaCarga="${rutaModuloInscripcion}">
												<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>
											</button>

											<button type="button" class="Eliminarvisa adjunto btn _eliminarColor btn-sm" id="Eliminarvisa" disabled="disabled">
												<i class="fas fa-trash mr-1" aria-hidden="true"></i>
											</button>
										</div>

									</div>
								</td>
							</tr>
									
								<tr>
								<td style="width: 30%"><label for="cargo">Adjuntar
										Certificado de Valoración Médica (Sólo Escuelas Profesionales) en formato pdf</label></td>
								<td>
									<div class="form-group row">

										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file" required="required"
												class="form-control-file archivocertificado gris" id="certificado"
												name="certificado" accept="application/pdf">

											<div class="estadoCarga">En espera de archivo...
												(Tamaño máximo ${tamanioArchivo})</div>
											<input type="hidden" class="rutaArchivocertificado"
												id="pathcertificado" name="pathcertificado" value="" />
											<div class="invalid-feedback">Por favor seleccione un
												archivo</div>
										</div>

										<div class="col-md-3 text-left">
											<button type="button" id="subircertificado"
												class="subircertificado adjunto btn _nuevoColor btn-sm"
												data-rutaCarga="${rutaModuloInscripcion}">
												<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>
											</button>

											<button type="button"
												class="Eliminarcertificado adjunto btn _eliminarColor btn-sm"
												id="Eliminarcertificado" disabled="disabled">
												<i class="fas fa-trash mr-1" aria-hidden="true"></i>
											</button>
										</div>

									</div>
								</td>
							</tr>
						
							
								<tr>
								<td style="width: 30%"><label for="cargo">Título de Bachiller o Certificado de aprobación de
								 primer de bachillerato en formato pdf</label></td>
								<td>
									<div class="form-group row">

										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file" required="required"
												class="form-control-file archivobachiller gris" id="bachiller"
												name="bachiller" accept="application/pdf">

											<div class="estadoCarga">En espera de archivo...
												(Tamaño máximo ${tamanioArchivo})</div>
											<input type="hidden" class="rutaArchivobachiller"
												id="pathbachiller" name="pathbachiller" value="" />
											<div class="invalid-feedback">Por favor seleccione un
												archivo</div>
										</div>

										<div class="col-md-3 text-left">
											<button type="button" id="subirbachiller"
												class="subirbachiller adjunto btn _nuevoColor btn-sm"
												data-rutaCarga="${rutaModuloInscripcion}">
												<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>
											</button>

											<button type="button"
												class="Eliminarbachiller adjunto btn _eliminarColor btn-sm"
												id="Eliminarbachiller" disabled="disabled">
												<i class="fas fa-trash mr-1" aria-hidden="true"></i>
											</button>
										</div>

									</div>
								</td>
							</tr>
							
							<tr>
								<td style="width: 30%"><label for="cargo">Fotografia  Tamaño carnet en formato png-jpg</label></td>
								<td>
									<div class="form-group row">

										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file" required="required"
												class="form-control-file archivofoto gris" id="foto"
												name="foto" accept="application/png/jpg">

											<div class="estadoCarga">En espera de archivo...
												(Tamaño máximo ${tamanioArchivo})</div>
											<input type="hidden" class="rutaArchivofoto"
												id="pathfoto" name="pathfoto" value="" />
											<div class="invalid-feedback">Por favor seleccione un
												archivo</div>
										</div>

										<div class="col-md-3 text-left">
											<button type="button" id="subirfoto"
												class="subirfoto adjunto btn _nuevoColor btn-sm"
												data-rutaCarga="${rutaModuloInscripcion}">
												<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>
											</button>

											<button type="button"
												class="Eliminarfoto adjunto btn _eliminarColor btn-sm"
												id="Eliminarfoto" disabled="disabled">
												<i class="fas fa-trash mr-1" aria-hidden="true"></i>
											</button>
										</div>

									</div>
								</td>
							</tr>
							
						
						</table>


					</fieldset>
					 -->
				</form:form>
			</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Enviar</button>
			</div>

			
		</c:otherwise>

	</c:choose>


</div>


</html>
<script type="text/javascript">
	$(document).ready(function() {
		
		$('#MensajeEdad').hide();
		$('#btnGuardar').hide();
		$('#EliminarArchivo').hide();
		$('#Eliminarvisa').hide();
		$('#Eliminarcertificado').hide();
		$('#Eliminarbachiller').hide();
		$('#Eliminarfoto').hide();
		

		
		if(calcularEdad()>=18){
			$('#btnGuardar').show();
			$('#subirArchivo').show();			
			$('#subirvisa').show();		
			$('#subircertificado').show();
			$('#subirbachiller').show();	
			$('#MensajeEdad').hide();
			}
		else if(calcularEdad()===undefined){
			
			}
		else{			
			$('#btnGuardar').hide();			
			$('#subirArchivo').hide();			
			$('#subirvisa').hide();		
			$('#subircertificado').hide();
			$('#subirbachiller').hide();				
			$('#MensajeEdad').show();
			$('#edad').text(calcularEdad());
			mostrarMensaje("No tiene la edad suficiente para realizar el curso, comuníquese con el departamento de SISTEMAS!","ERROR");
			}
		//return edad;
	
	});
	$("#tipoTitulo").change(function() {

		var opcion = $("#tipoTitulo").val();
		if (opcion === "A") {
			$('#tipo').text("A");
			$('#pago').text("200$");

		} else if (opcion === "B") {
			$('#tipo').text("B");
			$('#pago').text("201$");

		} else if (opcion === "C") {
			$('#tipo').text("C");
			$('#pago').text("y el valor total del curso es de USD 1100 ");

		} else if (opcion === "E") {
			$('#tipo').text("E");
			$('#pago').text("Etapa Inscripción ");

		}
	});
	$("#btnGuardar")
			.click(
					function(event) {
						$('#NuevoInscripcion').attr('data-opcion',
								'GuardarNuevoInscripcion');
						var form = $("#NuevoInscripcion");
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							if ($("#pathcedula").val() == "") {
								$("#informe").addClass('rojo');
								mostrarMensaje(
										"Por favor subir el archivo seleccionado!",
										"ERROR");
							} else {
								ejecutarJson(form);
								
							}
						}
						form.addClass('was-validated');

					});

	$('button.subirArchivo')
			.click(
					function(event) {
						var boton = $(this);
						var archivo = boton.parent('div').parent('div').find(
								".archivo");
						var rutaArchivo = boton.parent('div').parent('div')
								.find(".rutaArchivo");
						var extension = archivo.val().split('.');
						var estado = boton.parent('div').parent('div').find(
								".estadoCarga");
						var fecha = new Date();
						var nombreNuevoArchivo = $("#identificadorSolicitante")
								.val()
								+ "_cedula_o_pasaporte-"
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
						if (extension[extension.length - 1].toUpperCase() == 'PDF') {
							subirArchivo(archivo, nombreNuevoArchivo, boton
									.attr("data-rutaCarga"), rutaArchivo,
									new carga(estado, archivo, boton),
									"${tamanioArchivo}");
							$('#EliminarArchivo').show();
							$('#subirArchivo').hide();
							$('#EliminarArchivo').removeAttr("disabled");
						

						} else {
							estado
									.html('Formato incorrecto, solo se admite archivos en formato PDF');
							archivo.val("");
						}
					});
	$('button.subirvisa')
			.click(
					function(event) {
						var boton = $(this);
						var archivo = boton.parent('div').parent('div').find(
								".archivovisa");
						var rutaArchivo = boton.parent('div').parent('div')
								.find(".rutaArchivovisa");
						var extension = archivo.val().split('.');
						var estado = boton.parent('div').parent('div').find(
								".estadoCarga");
						var fecha = new Date();
						var nombreNuevoArchivo = $("#identificadorSolicitante")
								.val()
								+ "_visa-"
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
						if (extension[extension.length - 1].toUpperCase() == 'PDF') {
							subirArchivo(archivo, nombreNuevoArchivo, boton
									.attr("data-rutaCarga"), rutaArchivo,
									new carga(estado, archivo, boton),
									"${tamanioArchivo}");
							$('#Eliminarvisa').show();
							$('#subirvisa').hide();
							$('#Eliminarvisa').removeAttr("disabled");

						} else {
							estado
									.html('Formato incorrecto, solo se admite archivos en formato PDF');
							archivo.val("");
						}
					});
	
	$('button.subircertificado').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivocertificado");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivocertificado");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#identificadorSolicitante").val()
						+ "_Certificado_Medico-"
						+ fecha.getFullYear()
						+ "_"
						+ (fecha.getMonth() + 1)
						+ "_"
						+ fecha.getDate()
						+ "-"
						+ fecha.getHours()
						+ "_"
						+ fecha.getMinutes()
						+ "_"+ fecha.getSeconds();
				if (extension[extension.length - 1].toUpperCase() == 'PDF') {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
							new carga(estado, archivo, boton),
							"${tamanioArchivo}");
					$('#Eliminarcertificado').show();
					$('#subircertificado').hide();
					$('#Eliminarcertificado').removeAttr("disabled");

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	$('button.Eliminarcertificado').click(
			function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var archivourl = $("#pathcertificado").val();
				var rutaArchivo = boton.parent('div').parent('div').find(
						".archivocertificado");
				var archivo = boton.parent('div').parent('div')
						.find(".archivocertificado");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
						estado, archivo, boton));
				$('#Eliminarcertificado').hide();
				$('#subircertificado').show();
				$('#subircertificado').removeAttr("disabled");
				$('#certificado').val('');

			});

	$('button.subirbachiller').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivobachiller");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivobachiller");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#identificadorSolicitante").val()
						+ "_Certificado_Bachiller-"
						+ fecha.getFullYear()
						+ "_"
						+ (fecha.getMonth() + 1)
						+ "_"
						+ fecha.getDate()
						+ "-"
						+ fecha.getHours()
						+ "_"
						+ fecha.getMinutes()
						+ "_"+ fecha.getSeconds();
				if (extension[extension.length - 1].toUpperCase() == 'PDF') {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
							new carga(estado, archivo, boton),
							"${tamanioArchivo}");
					$('#Eliminarbachiller').show();
					$('#subirbachiller').hide();
					$('#Eliminarbachiller').removeAttr("disabled");

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	$('button.Eliminarbachiller').click(
			function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var archivourl = $("#pathbachiller").val();
				var rutaArchivo = boton.parent('div').parent('div').find(
						".archivobachiller");
				var archivo = boton.parent('div').parent('div')
						.find(".archivobachiller");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
						estado, archivo, boton));
				$('#Eliminarbachiller').hide();
				$('#subirbachiller').show();
				$('#subirbachiller').removeAttr("disabled");
				$('#bachiller').val('');

			});
	
	$('button.subirfoto').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivofoto");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivofoto");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#identificadorSolicitante").val()
						+ "_Foto_Carnet-"
						+ fecha.getFullYear()
						+ "_"
						+ (fecha.getMonth() + 1)
						+ "_"
						+ fecha.getDate()
						+ "-"
						+ fecha.getHours()
						+ "_"
						+ fecha.getMinutes()
						+ "_"+ fecha.getSeconds();
				if (extension[extension.length - 1].toUpperCase() == 'PNG' || extension[extension.length - 1].toUpperCase() == 'JPG'  ) {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
							new carga(estado, archivo, boton),
							"${tamanioArchivo}");
					$('#Eliminarfoto').show();
					$('#subirfoto').hide();
					$('#Eliminarfoto').removeAttr("disabled");

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PNJ-JPG');
					archivo.val("");
				}
			});
	$('button.Eliminarfoto').click(
			function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var archivourl = $("#pathfoto").val();
				var rutaArchivo = boton.parent('div').parent('div').find(
						".archivofoto");
				var archivo = boton.parent('div').parent('div')
						.find(".archivofoto");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
						estado, archivo, boton));
				$('#Eliminarfoto').hide();
				$('#subirfoto').show();
				$('#subirfoto').removeAttr("disabled");
				$('#foto').val('');

			});

	$('button.EliminarArchivo').click(
			function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var archivourl = $("#path").val();
				var rutaArchivo = boton.parent('div').parent('div').find(
						".rutaArchivo");
				var archivo = boton.parent('div').parent('div')
						.find(".archivo");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
						estado, archivo, boton));
				$('#EliminarArchivo').hide();
				$('#subirArchivo').show();
				$('#subirArchivo').removeAttr("disabled");
				$('#informe').val('');

			});
	$('button.Eliminarvisa').click(
			function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var archivourl = $("#path").val();
				var rutaArchivo = boton.parent('div').parent('div').find(
						".rutaArchivovisa");
				var archivo = boton.parent('div').parent('div').find(
						".archivovisa");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
						estado, archivo, boton));
				$('#Eliminarvisa').hide();
				$('#subirvisa').show();
				$('#subirvisa').removeAttr("disabled");
				$('#visa').val('');

			});


	 function calcularEdad() {
         	 
		 var str = $("#fechanacimiento").val();	
		 
		 if(str=="" || str===undefined){
			
		 }else{
			// alert(str);
			 str=str.replace("-","/");
			 var srt1=str;
			 srt1=srt1.replace("-","/");
	         // alert(srt1);
	         fecha = srt1;
	         var hoy = new Date();
	         var cumpleanos = new Date(fecha);
	         var edad = hoy.getFullYear() - cumpleanos.getFullYear();
	         var m = hoy.getMonth() - cumpleanos.getMonth();

	         if (m < 0 || (m === 0 && hoy.getDate() < cumpleanos.getDate())) {
	             edad--;
	         }
	         return edad;
			 }
        
     }	
</script>
