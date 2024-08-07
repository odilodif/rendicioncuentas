<%-- 
    Document  	: registroAutoriad
    Created on	: 30/01/2021, 10:39:23
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ page session="false"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<c:set var="rutaImagenCpccsTexto" value="<%=Constantes.RUTA_IMAGEN_CPCCSTEXTO%>" />
<c:set var="keySitio" value="<%=Constantes.KEY_SITIO_RECAPTCHA%>" />
<c:set var="tamanioArchivo" value="<%=Constantes.TAMANIO_ARCHIVO_5_MEGAS%>" />
<c:set var="rutaModuloRegistro" value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_ARCHIVOS_APLICACION%>" />

<spring:url value="/resources/" var="urlPublic" />



<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">

<title>Registro de Autoridades Electas</title>

<link rel="stylesheet" href="${urlPublic}css/sweetalert.css" />
<link rel="shortcut icon" type="image/x-icon" href="${urlPublic}img/favicon.ico" />
<link rel="stylesheet" href="${urlPublic}css/fontawesome-all.css">
<link rel="stylesheet" href="${urlPublic}css/bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/datepicker.css" />
<link rel="stylesheet" href="${urlPublic}css/rendicion.css">
</head>
<body>
	<div class="card text-center">
		<div id="card-header" class="card-header ">
			<h5>Formulario para el registro de Autoridades Electas</h5>
			<div class="col-md-3 text-left">
				<div class="texto-cursivo color-olvide-contrasenia">
					<a href="/rendicioncuentas">Regresar</a>
				</div>
			</div>
		</div>
		<div id="card-body" class="card-body">
			<img alt="Logo cpccs" class=""
				src="${urlPublic}${rutaImagenCpccsTexto}" style="width: 200px" />
			<div class="row">
				<div class="col-md-2 order-md-1"></div>
				<div class="col-md-8 order-md-1">
					<form class="needs-validation" novalidate action="guardarAutoridad" id="formularioRegistro" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<div class="panel panel-default" style="border: 1px solid rgba(0, 0, 0, .125);">
								<div class="panel-heading active panelHeaderBlue" role="tab"
									id="headingOne">
									<h6 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">FORMULARIO PARA EL REGISTRO DE AUTORIDADES ELECTAS:</a>
									</h6>
								</div>
								<div id="collapseOne" class="panel-collapse in collapse show"
									role="tabpanel" aria-labelledby="headingOne">

									<div class="panel-body">
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="identificador" class="col-form-label">Nro.
													de Cédula</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" class="form-control form-control-sm"
													id="identificador" required="required" name="identificador"
													placeholder="9999999999" maxlength="10"  onchange="validarDocumento(this.value)"
													pattern="^([a-zA-Z0-9]{10,10})+$" />
												<div class="invalid-feedback">Por favor ingrese su #
													de cédula</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="nombre">Nombres y Apellidos de la
													Autoridad</label>
											</div>
											<div class="col-md-9">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="nombre"
													required="required" name="nombre"
													placeholder="Ingrese Nombres y Apellidos" maxlength="64"
													value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese sus Apellidos y Nombres</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="provincia">Provincia</label>
											</div>
											<div class="col-md-2 text-left">
												<select class="custom-select custom-select-sm"
													id="provincia" required="required" name="provincia">
													<option value="">Seleccione...</option>
													<c:forEach var="listadoLocalizacionProvincia"
														items="${listadoLocalizacionProvincia}">
														<option
															value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													provincia</div>
											</div>
											<div class="col-md-1 text-left">
												<label for="canton">Cantón</label>
											</div>
											<div class="col-md-2 text-left">
												<select class="custom-select custom-select-sm" id="canton"
													required="required" name="canton">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													cantón</div>
											</div>
											<div class="col-md-2 text-left">
												<label for="parroquia">Parroquia</label>
											</div>
											<div class="col-md-2  text-left">
												<select class="custom-select custom-select-sm"
													required="required"
													id="parroquia" name="parroquia">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													parroquia</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="direccion" class="col-form-label">Dirección</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm" id="direccion"
													required="required" name="direccion"
													placeholder="Ingrese su dirección" maxlength="256" value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$">
												<div class="invalid-feedback">Por favor ingrese la
													dirección o no tiene el minimo de caracteres permitidos</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="web">Página Web o red social</label>
											</div>
											<div class="col-md-9">
												<input type="url" 
													class="form-control form-control-sm " id="web"
													required="required" name="web"
													placeholder="Dirección de página web" 
													value="http://" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="telefono" class="col-form-label">Teléfono<span class="text-muted"> (Opcional)</span>
													
												</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" class="form-control form-control-sm"
													id="telefono" name="telefono" placeholder="(00) 000-0000"
													maxlength="13" 
													pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
													data-inputmask="'mask': '(99) 999-9999'">
												<div class="invalid-feedback">Por favor ingrese su
													teléfono</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="celular" class="col-form-label">Celular</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" class="form-control form-control-sm"
													id="celular" required="required" name="celular"
													placeholder="(00) 0000-0000" maxlength="14"
													pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
													data-inputmask="'mask': '(99) 9999-9999'">
												<div class="invalid-feedback">Por favor ingrese su
													celular</div>
											</div>
										</div>
										<%-- <div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="rutaArchivoValidador">Adjunte el Nombramiento del
													CNE:</label>
											</div>
											<div class="col-md-6 text-left waves-effect float-left">
												<input type="file" class="form-control-file archivo gris"
													id="rutaArchivoValidador" name="rutaArchivoValidador"
													accept="application/pdf">

												<div class="estadoCarga">Tamaño máximo ${tamanioArchivo}</div>
												<input type="hidden" class="rutaArchivoValidador" id="rutaArchivoValidador"
													name="rutaArchivoValidador" value="" />
												<div class="invalid-feedback">Por favor seleccione un
													archivo</div>
											</div>
											<div class="col-md-3 text-center">
												<button type="button" id="subirArchivo"
													class="subirArchivo adjunto btn _nuevoColor btn-sm"
													data-rutaCarga="${rutaModuloAdmision}">
													<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir</button>
												<button type="button"
													class="EliminarArchivo adjunto btn _eliminarColor btn-sm"
													id="EliminarArchivo" disabled="disabled">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>
										</div> 
										
										<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="cargo">Adjunte el Nombramiento del
													CNE en formato .jpeg, .jpg, .png, .pdf:</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="informe"
										name="informe" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaModuloRegistro" id="pathModuloRegistro"
										name="pathModuloRegistro" value="" />
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
							
							--%>
							
						<div id="divevidencia3" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia3">Adjunte el Nombramiento del
													CNE en formato .jpeg, .jpg, .png, .pdf:</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia3"
										name="evidencia3" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo3" id="rutaArchivo3"
										name="rutaArchivo3" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo3"
										class="subirArchivo3 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRegistro}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo3 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo3" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
							</div>
							</div>	
							
						<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia2">Adjunte Documento de Identidad: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia2"
										name="evidencia2" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo2" id="rutaArchivo2"
										name="rutaArchivo2" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo2"
										class="subirArchivo2 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRegistro}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>
									<button type="button"
										class="EliminarArchivo2 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo2" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
							</div>
							
							<hr>
									
									<div class="form-group row">
										    <div class="col-md-3 text-left">
												<label for="dignidad">Institución en la que ejerce la dignidad:</label>
											</div>
											<div class="col-md-9">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="institucion_dignidad"
													required="required" name="institucion_dignidad"
													placeholder="Nombre de la institución en la que ejerce la diginidad" maxlength="64"
													value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese la dignidad</div>
											</div>
				</div>										

										
										<div class="form-group row">
										<div class="col-md-3 text-left">
											<label for="dignidad">Dignidad que ejerce:</label>
										</div>
										<div class="col-md-4  text-left">
											<select class="custom-select custom-select-sm" id="dignidad"
												name="dignidad" required="required">
												<option value="">Seleccione...</option>
												<option value="VOCALES DE GAD PARROQUIAL">VOCALES DE GAD PARROQUIAL</option>
												<option value="VICEPRESIDENTA/ VICEPRESIDENTE DE GAD PARROQUIAL">VICEPRESIDENTA/ VICEPRESIDENTE DE GAD PARROQUIAL</option>
												<option value="PRESIDENTA/ PRESIDENTE DE GAD PARROQUIAL">PRESIDENTA/ PRESIDENTE DE GAD PARROQUIAL</option>
												<option value="CONSEJALAS/ CONCEJALES RURALES">CONSEJALAS/ CONCEJALES RURALES</option>
												<option value="CONSEJALAS/CONCEJALES URBANOS">CONSEJALAS/CONCEJALES URBANOS</option>
												<option value="VICEALCALDESA/ VICEALCALDE">VICEALCALDESA/ VICEALCALDE</option>
												<option value="ALCALDESA/ ALCALDE">ALCALDESA/ ALCALDE</option>
												<option value="VICEPREFECTA/ VICEPREFECTO">VICEPREFECTA/ VICEPREFECTO</option>
												<option value="PREFECTA/PREFECTO">PREFECTA/PREFECTO</option>
												<option value="ASAMBLEÍSTA NACIONAL">ASAMBLEÍSTA NACIONAL</option>
												<option value="ASAMBLEÍSTA PROVINCIAL">ASAMBLEÍSTA PROVINCIAL</option>
												<option value="ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL">ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL</option>
												<option value="ASAMBLEÍSTA REPRESENTANTE EXTRANJERO">ASAMBLEÍSTA REPRESENTANTE EXTRANJERO</option>
												<option value="PARLAMENTARIA / PARLAMENTARIO ANDINO">PARLAMENTARIA / PARLAMENTARIO ANDINO</option>
												<option value="CONSEJERA/ CONSEJERO DEL CPCCS">CONSEJERA/ CONSEJERO DEL CPCCS</option>
												<option value="VICEPRESIDENTE DE LA REPÚBLICA">VICEPRESIDENTE DE LA REPÚBLICA</option>
												<option value="PRESIDENTE DE LA REPÚBLICA">PRESIDENTE DE LA REPÚBLICA</option>
												
											</select>
											<div class="invalid-feedback">Por favor seleccione el
												ámbito</div>
											</div>
										</div>
										
										
										
								<!-- 		<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="dignidad">Dignidad que ejerce:</label>
											</div>
											<div class="col-md-9">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="dignidad"
													required="required" name="dignidad"
													placeholder="Que dignidad que ejerce" maxlength="64"
													value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese la dignidad</div>
											</div>
										</div> -->
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="ambito">Ámbito </label>
											</div>
											<div class="col-md-4  text-left">
												<select class="custom-select custom-select-sm" id="ambito"
													name="ambito" required="required">
													<option value="">Seleccione...</option>
													<option value="NACIONAL">Nacional</option>
													<option value="PROVINCIAL">Provincial</option>
													<option value="DISTRITO METROPOLITANO">Distrito Metropolitano</option>
													<option value="CANTONAL">Cantonal</option>
													<option value="PARROQUIAL">Parroquial</option>
													<option value="EXTERIOR">Exterior</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													ámbito</div>
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="ambito">Tipo de Autoridad </label>
											</div>
											<div class="col-md-4  text-left">
												<select class="custom-select custom-select-sm" id="tipoAutoridad"
													name="tipoAutoridad" required="required">
													<option value="">Seleccione...</option>
													<option value="PRINCIPAL">PRINCIPAL</option>
													<option value="SUPLENTE PRINCIPALIZADO">SUPLENTE PRINCIPALIZADO</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													ámbito</div>
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="email">Correo electrónico</label>
												<span class="text-muted"> (usuario)</span>
											</div>
											<div class="col-md-9 text-left">
												<input type="email" class="form-control form-control-sm"
													id="email" required="required"
													name="email" placeholder="Ingrese su email"
													pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

												<div class="invalid-feedback">Por favor ingrese una
													dirección de correo electrónico válida</div>
											</div>
										</div>
										<div class="form-group row">
											<hr>
											<label for="clave text-left">* Su contraseña debe
												contener entre 6 y 12 caracteres, letras minúsculas,
												 números <b></b>, Ejemplo: procesorc2021
											</label>
											<hr>
											</div>
												<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="password">Cree su contraseña</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="password" class="form-control form-control-sm"
													id="password" required="required" name="password"
													maxlength="12" placeholder="Ingrese una contraseña"
													pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
												<div class="invalid-feedback">
													Su contraseña no cumple con: tener de 6 a 12 caracteres,
													letras minúsculas números )
												</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="contrseniaConfirmacion">Confirme su
													contraseña</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="password" class="form-control form-control-sm"
													id="claveConfirmacion" required="required"
													name="claveConfirmacion"
													placeholder="Confirme su contraseña" maxlength="12"
													pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
												<div class="invalid-feedback">Por favor confirme su
													contraseña</div>
											</div>
											</div>
										<!-- <div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="nombre_abuela" class="col-form-label">Nombre de su abuela materna</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm" id="nombre_abuela"
													required="required" name="nombre_abuela"
													placeholder="Ingrese nombre de su abuela materna" maxlength="256" value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$">
												<div class="invalid-feedback">Por favor ingrese el dato solicitado</div>
											</div>
										</div> -->
										<div class="form-group row">
										
										
												        	<div class="col-md-3 text-left">
													<label for="fechaNacimiento">Fecha de Nacimiento:</label>
												</div>
												<div class="col-md-3 text-left">
													<div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text"
															required="required" id="fechaNacimiento"
															name="fechaNacimiento"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese su
															fecha de nacimiento con formato dd/mm/aaaa</div>
													</div>
												</div>
										</div>
										</div>
										<input type="hidden" id="g-recaptcha-response"
											name="g-recaptcha-response">
									</div>
							</div>
							<div class="col-md-12 mt-3">
								<button type="button" id="btnEnviar" class="btn btn-primary1">Enviar</button>
							</div>
							</div>
					</form>
				</div>
				<div class="col-md-2 order-md-1"></div>
			</div>
		</div>
	<div id="card-footer" class="card-footer text-muted">©CPCCS 2018 - ${anio}</div>
</div>
    <script src="${urlPublic}js/sweetalert.js"></script>
	<script src="${urlPublic}js/jquery-3.3.1.js"></script>
	<script src="${urlPublic}js/bootstrap.min.js"></script>
	<script src="${urlPublic}js/bootstrap.datepicker.js"></script>
	<script src="${urlPublic}js/jquery.inputmask.js"></script>
	<script src="${urlPublic}js/rendicion.ingreso.js"></script>
	<script src="${urlPublic}js/rendicion.js"></script>
	<script src="${urlPublic}js/rendicion.bloqueo.js"></script>
	<script src='https://www.google.com/recaptcha/api.js?render=${keySitio}'></script>
	
	
	<script type="text/javascript">
		var csrfToken = $('input[name="_csrf"]').val();

		$(document).ready(
				function() {
/* 					visualizarMensajeConfirmacion('ATENCIÓN', 'el ingreso a la plataforma para completar su formulario será activado desde el mes de JUNIO/JULIO', '', 'registro');
 */					ajustarAltoIngreso();
					construirValidador();
					var keySitio = '<c:out value="${keySitio}" />';
					function reCAPTCHA_execute() {
						grecaptcha.ready(function() {
							grecaptcha.execute(keySitio, {
								action : 'homepage'
							}).then(function(token) {
								$('#g-recaptcha-response').val(token);
							});
						});
					}

					if (typeof grecaptcha !== 'undefined'
							&& typeof keySitio !== 'undefined') {
						grecaptcha.ready(reCAPTCHA_execute);
						setInterval(reCAPTCHA_execute, 120000);
					}


					$('#EliminarArchivo3').hide();
					$('#EliminarArchivo2').hide();

					
					$('#fechaNacimiento').datepicker({
						  forceParse: true,
						  todayBtn: false
					}).datepicker('setStartDate', '01/01/1900');
					
					var fecha = new Date();
					var fechanueva = ("31/12/"+ (fecha.getFullYear()-19));
					
					$('#fechaNacimiento').datepicker({						
					}).datepicker('setEndDate', fechanueva);
						
					$('#fechaNacimiento').datepicker({

					}).datepicker('update', '01/06/1970');
					

					});
		
		


		$("#provincia").change(
				function() {
					scanton = '0';
					scanton = '<option value="">Seleccione...</option>';
					<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
					if ($("#provincia").val() == "${listadoLocalizacionCanton.idLocalizacionPadre}") {
						scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
					}
					</c:forEach>
					$('#canton').html(scanton);
					$('#parroquia').html(
							'<option value="">Seleccione...</option>');
				});

		$("#canton").change(
				function() {
					sparroquia = '0';
					sparroquia = '<option value="">Seleccione...</option>';
					<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
					if ($("#canton").val() == "${listadoLocalizacionParroquia.idLocalizacionPadre}") {
						sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
					}
					</c:forEach>
					$('#parroquia').html(sparroquia);
				});

		$("#btnEnviar").click(function(event) {
							var form = $("#formularioRegistro")
							if (form[0].checkValidity() === false
									|| ($("#password").val() != $(
											"#claveConfirmacion").val())) {
								if ($("#password").val() != $(
										"#claveConfirmacion").val()) {
									notificacionBottomRight();
									toastr
											.error("Las contraseñas ingresadas no coinciden");
								}
								event.preventDefault()
								event.stopPropagation()
							} else {

								 if($("#rutaArchivo3").val()=="" ){
							          $("#evidencia3").addClass('rojo');
									mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
							     } else if ($("#rutaArchivo2").val()=="" ){
							    	 $("#evidencia2").addClass('rojo');
										mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
							     }else {									

								$("#btnEnviar").attr("type", "submit");
								$(".card").append("<div id='cargando'>Cargando...</div>").fadeIn();
								setTimeout(function() {	$(".card").delay("slow").fadeOut();
									}, 1500);

							     }
														}
							form.addClass('was-validated');
						});

		$("#cedula").change(function() {
			$("#identificador").attr("minlength", "10");

		});


		validarDocumento  = function() {          		
			 numero = $("#identificador").val();
				      var suma = 0;      
			      var residuo = 0;      
			      var pri = false;      
			      var pub = false;            
			      var nat = false;      
			      var numeroProvincias = 24;                  
			      var modulo = 11;
			                  
			      /* Verifico que el campo no contenga letras */                  
			      var ok=1;
			      for (i=0; i<numero.length && ok==1 ; i++){
			         var n = parseInt(numero.charAt(i));
			         if (isNaN(n)) ok=0;
			      }
			      if (ok==0){
			         mostrarMensaje("No puede ingresar caracteres aquí",	"ERROR");        
			         $("#identificador").val("");					
			         return false;
			      }
			      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
			      if (numero.length < 10 ){              
			         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
			         $("#identificador").val("");	
				         return false;
			         
			      }

			      if (numero=="1212121212" || numero=="1010101010" || numero=="2222222222" || numero=="1414141414" || numero=="1616161616" || numero=="2424242424" || numero=="2020202020"  ) {
						 mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");	
						 $("#identificador").val("");	
				     	 return false;
			      }
				     
			      /* Los primeros dos digitos corresponden al codigo de la provincia */
			      provincia = numero.substr(0,2);      
			      if (provincia < 1 || provincia > numeroProvincias){           
			         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
			         $("#identificador").val("");	
			         return false;       
			      }

			      /* Aqui almacenamos los digitos de la cedula en variables. */
			      d1  = numero.substr(0,1);         
			      d2  = numero.substr(1,1);         
			      d3  = numero.substr(2,1);         
			      d4  = numero.substr(3,1);         
			      d5  = numero.substr(4,1);         
			      d6  = numero.substr(5,1);         
			      d7  = numero.substr(6,1);         
			      d8  = numero.substr(7,1);         
			      d9  = numero.substr(8,1);         
			      d10 = numero.substr(9,1);                
			         
			      /* El tercer digito es: */                           
			      /* 9 para sociedades privadas y extranjeros   */         
			      /* 6 para sociedades publicas */         
			      /* menor que 6 (0,1,2,3,4,5) para personas naturales */ 

			      if (d3==7 || d3==8){           
			         mostrarMensaje("El tercer dígito ingresado es inválido!",	"ERROR");                  
			         $("#identificador").val("");	
			         return false;
			      }         
			         
			      /* Solo para personas naturales (modulo 10) */         
			      if (d3 < 6){           
			         nat = true;            
			         p1 = d1 * 2;  if (p1 >= 10) p1 -= 9;
			         p2 = d2 * 1;  if (p2 >= 10) p2 -= 9;
			         p3 = d3 * 2;  if (p3 >= 10) p3 -= 9;
			         p4 = d4 * 1;  if (p4 >= 10) p4 -= 9;
			         p5 = d5 * 2;  if (p5 >= 10) p5 -= 9;
			         p6 = d6 * 1;  if (p6 >= 10) p6 -= 9; 
			         p7 = d7 * 2;  if (p7 >= 10) p7 -= 9;
			         p8 = d8 * 1;  if (p8 >= 10) p8 -= 9;
			         p9 = d9 * 2;  if (p9 >= 10) p9 -= 9;             
			         modulo = 10;
			      }         

			      /* Solo para sociedades publicas (modulo 11) */                  
			      /* Aqui el digito verficador esta en la posicion 9, en las otras 2 en la pos. 10 */
			      else if(d3 == 6){           
			         pub = true;             
			         p1 = d1 * 3;
			         p2 = d2 * 2;
			         p3 = d3 * 7;
			         p4 = d4 * 6;
			         p5 = d5 * 5;
			         p6 = d6 * 4;
			         p7 = d7 * 3;
			         p8 = d8 * 2;            
			         p9 = 0;            
			      }         
			         
			      /* Solo para entidades privadas (modulo 11) */         
			      else if(d3 == 9) {           
			         pri = true;                                   
			         p1 = d1 * 4;
			         p2 = d2 * 3;
			         p3 = d3 * 2;
			         p4 = d4 * 7;
			         p5 = d5 * 6;
			         p6 = d6 * 5;
			         p7 = d7 * 4;
			         p8 = d8 * 3;
			         p9 = d9 * 2;            
			      }
			                
			      suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;                
			      residuo = suma % modulo;                                         

			      /* Si residuo=0, dig.ver.=0, caso contrario 10 - residuo*/
			      digitoVerificador = residuo==0 ? 0: modulo - residuo;                

			      /* ahora comparamos el elemento de la posicion 10 con el dig. ver.*/                         
			      if (pub==true){           
			         if (digitoVerificador != d9){                          
			            mostrarMensaje("El ruc de la empresa del sector público es incorrecto!",	"ERROR");         
			            $("#identificador").val("");	
			            return false;
			         }                  
			         /* El ruc de las empresas del sector publico terminan con 0001*/         
			         if ( numero.substr(9,4) != '0001' ){                    
			            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
			            $("#identificador").val("");	
			            return false;
			         }
			      }         
			      else if(pri == true){         
			         if (digitoVerificador != d10){                          
			            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
			            $("#identificador").val("");	
			            return false;
			         }         
			         if ( numero.substr(10,3) != '001' ){                    
			            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
			            $("#identificador").val("");	
			            return false;
			         }
			      }      

			      else if(nat == true){         
			         if (digitoVerificador != d10){                          
			            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
			            $("#identificador").val("");	
			            return false;
			         }         
			         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
			            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
			            $("#identificador").val("");	
			            return false;
			         }
			      }      
			      mostrarMensaje("El dato ingresado es correto!",	"EXITO");
			      return true; 
		}
		 



/*		$('button.subirArchivo').click(
				function(event) {
					var boton = $(this);
					var archivo = boton.parent('div').parent('div').find(".archivo");
					var rutaArchivo = boton.parent('div').parent('div').find(".rutaModuloRegistro");
					var extension = archivo.val().split('.');
					var estado = boton.parent('div').parent('div').find(".estadoCarga");
					var fecha = new Date();
					var nombreNuevoArchivo = $("#identificador")
							.val()
							+ "_nombramiento-"
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
						$('#evidenciaLink2').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo2').val());	

					} else {
						estado
								.html('Formato incorrecto, solo se admite archivos en formato PDF, JPG, JPEG, PNG');
						archivo.val("");
					}
				});
$('button.EliminarArchivo').click(function(event) {
			var boton = $(this);
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var archivourl = $("#rutaArchivo").val();
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo");
			var archivo = boton.parent('div').parent('div').find(".archivo");
			EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
			$('#subirArchivo').removeAttr("disabled");
			$('#EliminarArchivo').hide();
			$('#subirArchivo').show();
			$('#evidenciaLink2').attr('href', '');	
			$('#informe').val('');

		});*/

$("#email").change(function(event) {	
	 var opcion = $("#email").val().toLowerCase();	
	  $.ajax({
      url: 'ValidarUsuario',
      headers: {"X-CSRF-TOKEN": csrfToken},
      type: "POST",
      dataType: 'json',
      data: {codigo: opcion},
      success: function (result) {
         
    	  if(result.valida ==="nuevo"){   
    		  mostrarMensaje("Ususario disponible!","EXITO-NOTIFICACION","3000");       		
      		}
    	  else if(result.valida ==="existe"){   
    		  mostrarMensaje("Email ya registrado, ingrese uno diferente!","ERROR-NOTIFICACION","3000"); 
    		  $("#email").val("");
      		}
      	  else if(result.valida ==="vacio"){   
    		  mostrarMensaje("Ingrese email de usuario !","ERROR-NOTIFICACION","3000");       		
      		}
	  
      },
      error: function (result) {       
    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
    		

      }
  });

});


$('button.subirArchivo2').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo2");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificador")
								.val()
								+ "_cedula-"
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
			.toUpperCase() == 'JPEG'
				|| extension[extension.length - 1]
						.toUpperCase() == 'JPG'
				|| extension[extension.length - 1]
						.toUpperCase() == 'PNG'	
				|| extension[extension.length - 1]
						.toUpperCase() == 'BMP'
				|| extension[extension.length - 1]
						.toUpperCase() == 'DOC'
				|| extension[extension.length - 1]
						.toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton
						.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),
						"${tamanioArchivo}");
				$('#EliminarArchivo2').show();
				$('#EliminarArchivo2').removeAttr("disabled");
				$('#subirArchivo2').hide();
				$('#evidenciaLink2').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo2').val());							
				$("#evidenciaRutaLink2").val($('#rutaArchivo2').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo2').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo2").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo2");
	var archivo = boton.parent('div').parent('div').find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
	$('#subirArchivo2').removeAttr("disabled");
	$('#evidencia2').val('');
	$('#EliminarArchivo2').hide();
	$('#subirArchivo2').show();
	$('#evidenciaLink2').attr('href', '');							
	$("#evidenciaRutaLink2").val('');
});
	

$('button.subirArchivo3').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo3");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificador")
							.val()
							+ "_nombramiento-"
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
			.toUpperCase() == 'JPEG'
				|| extension[extension.length - 1]
						.toUpperCase() == 'JPG'
				|| extension[extension.length - 1]
						.toUpperCase() == 'PNG'	
				|| extension[extension.length - 1]
						.toUpperCase() == 'BMP'
				|| extension[extension.length - 1]
						.toUpperCase() == 'DOC'
				|| extension[extension.length - 1]
						.toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton
						.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),
						"${tamanioArchivo}");
				$('#EliminarArchivo3').show();
				$('#EliminarArchivo3').removeAttr("disabled");
				$('#subirArchivo3').hide();
				$('#evidenciaLink3').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo3').val());							
				$("#evidenciaRutaLink3").val($('#rutaArchivo3').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo3').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo3").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo3");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo3').removeAttr("disabled");
	$('#evidencia3').val('');	
	$('#EliminarArchivo3').hide();
	$('#subirArchivo3').show();
	$('#evidenciaLink3').attr('href', '');							
	$("#evidenciaRutaLink3").val('');
});
		
	</script>
</body>
</html>