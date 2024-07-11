<%-- 
    Document  	: registroIntitucion
    Created on	: 14/01/2021, 10:39:23
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set var="rutaImagenCpccsTexto" value="<%=Constantes.RUTA_IMAGEN_CPCCSTEXTO%>" />
<c:set var="keySitio" value="<%=Constantes.KEY_SITIO_RECAPTCHA%>" />
<c:set var="urlWebServicesValidacionBsg" value="<%=Constantes.URL_WEB_SERVICES_VALIDACION_BSG1%>" />
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
<title>Formulario para el registro de Instituciones</title>
<link rel="shortcut icon" type="image/x-icon" href="${urlPublic}img/favicon.ico" />
 <link rel="stylesheet" href="${urlPublic}css/sweetalert.css" />
<link rel="stylesheet" href="${urlPublic}css/fontawesome-all.css">
<link rel="stylesheet" href="${urlPublic}css/bootstrap.min.css" />
<link rel="stylesheet" href="${urlPublic}css/datepicker.css" />
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/rendicion.css">
</head>
<body>

	<div class="card text-center">
	
		<div id="card-header" class="card-header ">
			<h5>Registro de Instituciones a Rendir Cuentas</h5>			
			<div class="col-md-3 text-left">
	 <div class="texto-cursivo color-olvide-contrasenia">
		<a href="/rendicioncuentas"><h4>Regresar</h4></a>
	 </div>
	 </div>
		</div>
		<div id="card-body" class="card-body">
			<img alt="Logo cpccs" class="" 
				src="${urlPublic}${rutaImagenCpccsTexto}" style="width:200px"/>
				    
			<div class="row">
				<div class="col-md-2 order-md-1"></div>
				<div class="col-md-8 order-md-1">
					<form class="needs-validation" novalidate	action="guardarUsuarioIntitucion" id="formularioRegistroInstitucion" autocomplete="off" method="POST">
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class="panel-group" id="accordion" role="tablist"
							aria-multiselectable="true">
							<!-- Datos Institucion -->
							<div class="panel panel-default"
								style="border: 1px solid rgba(0, 0, 0, .125);">
								<div class="panel-heading active panelHeaderBlue" role="tab"
									id="headingOne">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">FORMULARIO PARA EL REGISTRO DE INSTITUCIONES</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse in collapse show"
									role="tabpanel" aria-labelledby="headingOne">

									<div class="panel-body">
									
										<div class="alert alert-warning" role="alert">
											<strong>Los datos ingresados en este formulario son de responsabilidad de la institución registrada</strong>
										</div>
										
											<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="tipoIdentificacion" class="col-form-label">Tipo
													de Identificación</label>
											</div>
											
											<div class="col-md-2 text-left">
												<div class="custom-control custom-radio">
													<input id="ruc" value="Ruc"  
														name="tipoIdentificacion" type="radio" checked="checked"
														class="custom-control-input"> <label
														class="custom-control-label" for="ruc">RUC</label>
												</div>
											</div>																					
											<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="identificador" required="required" name="identificador"
													placeholder="9999999999999" minlength="13" maxlength="13"
													pattern="^([a-zA-Z0-9]{10,13})+$" />
												<div class="invalid-feedback">Por favor ingrese su Ruc</div>
											</div>
											<div class="col-md-3 text-left">
												<button type="button" id="BtnVerificar"  class="botonimagen"></button>
											</div>
										</div>					
									<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="nombres">Institución:</label>
											</div>
											<div class="col-md-9 text-lef" id="contenedor">
												<select class="custom-select custom-select-sm"
													id="institucion" name="institucion" required="required">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Seleccione la
													institución</div> 

											</div>

										</div>
										
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="funcion">Función a la que Pertenece:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" style="text-transform:uppercase;"  class="form-control form-control-sm "
													id="funcion" required="required" disabled="disabled" name="funcion"
													placeholder="Ingrese la Función" minlength="3"
													maxlength="64"  value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback">Seleccione la Función Correspondiente</div>
											</div>
											<div class="col-md-1"></div>
											<div class="col-md-2 text-left">
												<label for="sector">Sector:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" style="text-transform:uppercase;"  class="form-control form-control-sm "
													id="sector" required="required" disabled="disabled" name="sector"
													placeholder="Ingrese el Sector" minlength="3"
													maxlength="64"  value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback">Seleccione el Sector Correspondiente</div>
											</div>
										</div>
										
										
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="tipoMedio">Tipo de Medio:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" style="text-transform:uppercase;"  class="form-control form-control-sm "
													id="tipoMedio" required="required" disabled="disabled" name="tipoMedio"
													placeholder="Ingrese el Tipo de Medio" minlength="3"
													maxlength="64"  value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback">Seleccione el tipo de Medio Correspondiente</div>
											</div>
											<div class="col-md-1"></div>
											<div class="col-md-2 text-left">
												<label for="nivel">Nivel que Rinde Cuentas:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" style="text-transform:uppercase;"  class="form-control form-control-sm "
													id="nivel" required="required" disabled="disabled" name="nivel"
													placeholder="Ingrese el Nivel que Rinde Cuentas" minlength="3"
													maxlength="64"  value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback">Seleccione el Sector Correspondiente</div>
											</div>
										</div>
										
										
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="provincia">Provincia:</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="provincia" required="required" name="provincia">
													<option value="">Seleccione...</option>
													<c:forEach var="listadoLocalizacionProvincia"
														items="${listadoLocalizacionProvincia}">
														<option
															value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione la provincia</div>
											</div>
											<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
												<label for="canton">Cantón:</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="canton" required="required" name="canton">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													cantón</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="parroquia">Parroquia:</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm" required="required"
													id="parroquia"  name="parroquia">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													parroquia</div>
											</div>
											<div class="col-md-1"></div>
											<div class="col-md-2 text-left">
												<label for="direccion" class="col-form-label">Dirección:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" style="text-transform:uppercase;" class="form-control form-control-sm"
													id="direccion" required="required" name="direccion"
													placeholder="INGRESAR DIRECCIÓN" maxlength="256" value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$" minlength="8">
												<div class="invalid-feedback">Por favor ingrese la
													dirección o no tiene el mínimo de caracteres permitidos</div>
											</div>
										</div>
											<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="correoElectronico">Email:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="email" class="form-control form-control-sm"
													id="correoElectronico" required="required"
													name="correoElectronico" placeholder="INGRESE EL EMAIL"
													pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

												<div class="invalid-feedback">Por favor ingrese una
													dirección de correo electrónico valida</div>
											</div>
												<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
												<label for="telefono" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="telefono" name="telefono"
													placeholder="(00) 000-0000" maxlength="13"
													pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
													data-inputmask="'mask': '(99) 999-9999'">
												<div class="invalid-feedback">Por favor ingrese su
													teléfono</div>
											</div>
										</div>
											<div class="form-group row">										
											<div class="col-md-2 text-left">
												<label for="PaginaWeb" class="col-form-label">Página Web o Red Social:</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="url" class="form-control form-control-sm"
													id="PaginaWeb" required="required" name="PaginaWeb"
													placeholder="INGRESAR PAGINA WEB" value="http://">												
												<div class="invalid-feedback">Por favor ingrese la
													dirección en el siguiente formato http://dirreccionDePaginaWeb</div>
											</div>
										</div>

										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="cargo">Adjuntar Documento Oficial del
													RUC: Formato .jpeg, .jpg, .png, .pdf</label>
											</div>
											<div class="col-md-5 text-left waves-effect float-left">
												<input type="file" required="required"
													class="form-control-file archivo gris" id="informe"
													name="informe" accept=".png, .jpg, .jpeg, .pdf">

												<div class="estadoCarga">En espera de archivo...
													(Tamaño máximo ${tamanioArchivo})</div>
												<input type="hidden" class="rutaModuloRegistro"
													id="pathModuloRegistro" name="pathModuloRegistro" value="" />
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
													style="display:none;"
													id="EliminarArchivo" disabled="disabled" >
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>


									</div>
								</div>
							</div>
							<!--Datos Funcionarios  -->
							<div class="panel panel-default"
								style="border: 1px solid rgba(0, 0, 0, .125);">
								<div class="panel-heading active panelHeaderBlue" role="tab"
									id="headingTwo">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											data-parent="#accordion" href="#collapseTwo"
											aria-expanded="true" aria-controls="collapseTwo">Datos Responsables</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse in collapse show"
									role="tabpanel" aria-labelledby="headingTwo">

									<div class="panel-body">
										<fieldset>

											<legend>Representante Legal de Institución</legend>

											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="NombreRepreLegal">Nombres del
														Representante:</label>
												</div>
												<div class="col-md-3 text-lef">
													<input type="text" style="text-transform: uppercase;"
														class="form-control form-control-sm "
														id="NombreRepreLegal" required="required"
														name="NombreRepreLegal"
														placeholder="Ingrese Nombres y Apellidos" minlength="3"
														maxlength="64" value=""
														pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
													<div class="invalid-feedback">Por
														favor ingrese sus Apellidos y Nombres</div>
													<!-- <div class="valid-tooltip">todo bien</div> -->
												</div>
												<div class="col-md-1 text-left"></div>

												<div class="col-md-2 text-left">
													<label for="CargoRepreLegal">Cargo del
														Representante:</label>
												</div>
												<div class="col-md-3 text-left ">
													<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
														id="CargoRepreLegal" required="required"
														name="CargoRepreLegal" placeholder="INGRESE EL CARGO"
														minlength="3" maxlength="64" value="">
													<div class="invalid-feedback">Por favor ingrese el
														Cargo</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="CorreoRepreLegal">Email de
														Notificación:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="email" class="form-control form-control-sm"
														id="CorreoRepreLegal" required="required"
														name="CorreoRepreLegal" placeholder="INGRESE SU EMAIL"
														pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

													<div class="invalid-feedback">Por favor ingrese una
														dirección de correo eletrónica valida</div>
												</div>
												<div class="col-md-1"></div>

												<div class="col-md-2 text-left">
													<label for="FechaRepreLegal">Fecha de Designación:</label>
												</div>
												<div class="col-md-3 text-left">
													<div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text"
															required="required" id="FechaRepreLegal"
															name="FechaRepreLegal"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="TelfRepreLegal" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="TelfRepreLegal" name="TelfRepreLegal" 
														placeholder="(00) 000-0000" maxlength="13"
														pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
														data-inputmask="'mask': '(99) 999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														teléfono</div>
												</div>
												<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
													<label for="celularRepreLegal" class="col-form-label">Celular:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="celularRepreLegal" required="required"
														name="celularRepreLegal" placeholder="(00) 0000-0000"
														maxlength="14" pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
														data-inputmask="'mask': '(99) 9999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														celular</div>
												</div>
											</div>

										</fieldset>
										<fieldset>

											<legend>Responsable del Proceso de Rendición de
												Cuentas:</legend>

											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="NombreResponPro">Nombres del
														Responsable:</label>
												</div>
												<div class="col-md-3 text-lef">
													<input type="text" style="text-transform: uppercase;"
														class="form-control form-control-sm " id="NombreResponPro"
														required="required" name="NombreResponPro"
														placeholder="INGRESAR NOMBRES Y APELLIDOS" minlength="3"
														maxlength="64" value=""
														pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
													<div class="invalid-feedback">Por
														favor ingrese sus Apellidos y Nombres</div>
													<!-- <div class="valid-tooltip">todo bien</div> -->
												</div>
												<div class="col-md-1 text-left"></div>

												<div class="col-md-2 text-left">
													<label for="CargoResponPro">Cargo del Responsable:</label>
												</div>
												<div class="col-md-3 text-left ">
													<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
														id="CargoResponPro" required="required"
														name="CargoResponPro" placeholder="INGRESE EL CARGO"
														minlength="3" maxlength="64" value="">
													<div class="invalid-feedback">Por favor ingrese el
														Cargo</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="CorreoResponPro">Email de Notificación:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="email" class="form-control form-control-sm"
														id="CorreoResponPro" required="required"
														name="CorreoResponPro" placeholder="INGRESE SU EMAIL"
														pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

													<div class="invalid-feedback">Por favor ingrese una
														dirección de correo electrónico valida</div>
												</div>
												<div class="col-md-1"></div>

												<div class="col-md-2 text-left">
													<label for="FechaResponPro">Fecha de Designación:</label>
												</div>
												<div class="col-md-3 text-left">
													<div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text"
															required="required" id="FechaResponPro"
															name="FechaResponPro"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															 con formato dd/mm/aaaa</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="TelfResponPro" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="TelfResponPro" name="TelfResponPro"  
														placeholder="(00) 000-0000" maxlength="13"
														pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
														data-inputmask="'mask': '(99) 999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														teléfono</div>
												</div>
												<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
													<label for="celularResponPro" class="col-form-label">Celular:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="celularResponPro" required="required"
														name="celularResponPro" placeholder="(00) 0000-0000"
														maxlength="14" pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
														data-inputmask="'mask': '(99) 9999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														celular</div>
												</div>
											</div>

										</fieldset>
										<fieldset>

											<legend>Responsable del Registro del Informe de
												Rendición de Cuentas:</legend>

											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="NombreResponRegis">Nombres Responsable del Registro:</label>
												</div>
												<div class="col-md-3 text-lef">
													<input type="text" style="text-transform: uppercase;"
														class="form-control form-control-sm "
														id="NombreResponRegis" required="required"
														name="NombreResponRegis"
														placeholder="INGRESE NOMBRES Y PELLIDOS" minlength="3"
														maxlength="64" value=""
														pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
													<div class="invalid-feedback">Por
														favor ingrese sus Apellidos y Nombres</div>
													<!-- <div class="valid-tooltip">todo bien</div> -->
												</div>
												<div class="col-md-1 text-left"></div>

												<div class="col-md-2 text-left">
													<label for="CargoResponRegis">Cargo Responsable del Registro:</label>
												</div>
												<div class="col-md-3 text-left ">
													<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
														id="CargoResponRegis" required="required"
														name="CargoResponRegis" placeholder="INGRESE EL CARGO"
														minlength="3" maxlength="64" value="">
														
													<div class="invalid-feedback">Por favor ingrese el
														Cargo</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="FechaResponRegis">Fecha de Designación:</label>
												</div>
												<div class="col-md-3 text-left">
													<div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text"
															required="required" id="FechaResponRegis"
															name="FechaResponRegis"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la
															fecha de designación con formato dd/mm/aaaa</div>
													</div>
												</div>

												<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
													<label for="TelfResponRegis" class="col-form-label">Teléfono:<span class="text-muted"> (Opcional)</span></label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="TelfResponRegis" name="TelfResponRegis"
														placeholder="(00) 000-0000" maxlength="13"
														pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
														data-inputmask="'mask': '(99) 999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														teléfono</div>
												</div>

											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="celularResponRegis" class="col-form-label">Celular:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="celularResponRegis" required="required"
														name="celularResponRegis" placeholder="(00) 0000-0000"
														maxlength="14" pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
														data-inputmask="'mask': '(99) 9999-9999'">
													<div class="invalid-feedback">Por favor ingrese su
														celular</div>
												</div>
												<div class="col-md-1"></div>
												<div class="col-md-2 text-left">
													<label for="CedulaResponRegis" class="col-form-label">Cédula
														de Ciudadania:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" class="form-control form-control-sm"
														id="CedulaResponRegis" required="required"
														name="CedulaResponRegis" placeholder="9999999999" onchange="validarDocumento(this.value)"
														maxlength="10" pattern="^([a-zA-Z0-9]{10,10})+$" />
													<div class="invalid-feedback">Por favor ingrese su #
														de cédula</div>
												</div>
											</div>

											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="CorreoResponRegis"> Email de Notificación:
													<span class="text-muted"> (Usuario)</span> </label>
												</div>
												<div class="col-md-3 text-left">
													<input type="email" class="form-control form-control-sm"  autocomplete="new-email"
														id="CorreoResponRegis" required="required"
														name="CorreoResponRegis" placeholder="INGRESE SU EMAIL">

													<div class="invalid-feedback">Por favor ingrese una
														dirección de correo válida</div>
												</div>
												<div class="col-md-1"></div>
												        	<div class="col-md-2 text-left">
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
										<!-- 	<div class="form-group row">
											
											<div class="col-md-2 text-left">
													<label for="NombreAbuelaResponRegistro"
														class="col-form-label">Nombre Abuela Materna:</label>
												</div>
												<div class="col-md-3 text-left">
													<input type="text" style="text-transform: uppercase;"
														class="form-control form-control-sm"
														id="NombreAbuelaResponRegistro" required="required"
														name="NombreAbuelaResponRegistro"
														placeholder="INGRESE EL NOMBRE DE SU ABUELA MATERNA"
														maxlength="256" value=""
														pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$">
													<div class="invalid-feedback">Por favor ingrese el
														dato solicitado</div>
												</div>
											</div>	 -->	
										<div class="form-group row">
										<div class="col-md-12 text-center">
									
											<label for="clave text-center">* Su contraseña debe
												contener entre 6 y 12 caracteres, letras minúsculas,
												 números  Ejemplo: procesorc2021
											</label>
										</div>
										
										</div>
										
										   <div class="form-group row">
										   
																		
												<div class="col-md-2 text-left">
													<label for="passwordResponRegis">Cree su contraseña:</label>
												</div>
												<div class="col-md-9 text-left">
													<input type="password" class="form-control form-control-sm" autocomplete="new-password"
														id="passwordResponRegis" required="required"
														name="passwordResponRegis" maxlength="12"
														placeholder="INGRESE SU CONTRASEÑA"
														pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
													<div class="invalid-feedback">
														Su contraseña no cumple con: tener de 6 a 12 caracteres,
														letras minúsculas, números  Ejemplo: consejo2021
													</div>
												</div>
											</div>
											<div class="form-group row">
												<div class="col-md-2 text-left">
													<label for="contrseniaConfirmacion">Confirme su
														contraseña:</label>
												</div>
												<div class="col-md-9 text-left">
												
													<input type="password" class="form-control form-control-sm"
														id="claveConfirmacion" required="required"
														name="claveConfirmacion"
														placeholder="CONFIRME SU CONTRASEÑA" maxlength="12"
														pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
													<div class="invalid-feedback">Por favor confirme su
														contraseña</div>
												</div>
											</div>
												
											</fieldset>	

										<br> <input type="hidden" id="g-recaptcha-response"
											name="g-recaptcha-response">
									</div>
								</div>
							</div>
							<!-- Datos Competencias  -->

							<div class="col-md-12 mt-3">
								<button type="button" id="btnEnviar" class="btn btn-primary">Enviar</button>
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


$(document).ready(function() {	
	  $("#formularioRegistroInstitucion").removeClass("required");
	$('#EliminarArchivo').hide();
	$('#btnEnviar').hide();
	
/* 	visualizarMensajeConfirmacion('ATENCIÓN', 'el ingreso a la plataforma para completar su formulario será activado desde el mes de JUNIO/JULIO', '', 'registro');
 */  	ajustarAltoIngreso();
	construirValidador();
  	var keySitio = '<c:out value="${keySitio}" />';
  	function reCAPTCHA_execute() {
    	grecaptcha.ready(function() {
      		grecaptcha.execute(keySitio, {
        		action: 'homepage'
      		}).then(function(token) {
      			$('#g-recaptcha-response').val(token);
      		});
    	});
 	}

	if (typeof grecaptcha !== 'undefined' && typeof keySitio !== 'undefined') {
    	grecaptcha.ready(reCAPTCHA_execute);
    	setInterval(reCAPTCHA_execute, 120000);
	}
	var f = new Date();
	var fecha=(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
	
	$('#FechaRepreLegal').datepicker({
	  forceParse: true,
	  todayBtn: false
	}).datepicker('setStartDate', '01/01/2000');
	
	$('#FechaRepreLegal').datepicker({

	}).datepicker('setEndDate', fecha);
	
	$('#FechaRepreLegal').datepicker({

	}).datepicker('update', fecha);
	
	$('#FechaRepreLegal').datepicker({

	}).datepicker('update','');

	
	$('#FechaResponPro').datepicker({
		  forceParse: true,
		  todayBtn: false
	}).datepicker('setStartDate', '01/01/2000');
		
	$('#FechaResponPro').datepicker({

	}).datepicker('setEndDate', fecha);
		
	$('#FechaResponPro').datepicker({

	}).datepicker('update', fecha);
	$('#FechaResponPro').datepicker({

	}).datepicker('update','');
	

	$('#FechaResponRegis').datepicker({
		  forceParse: true,
		  todayBtn: false
	}).datepicker('setStartDate', '01/01/2000');
		
	$('#FechaResponRegis').datepicker({

	}).datepicker('setEndDate', fecha);
		
	$('#FechaResponRegis').datepicker({

	}).datepicker('update', fecha);
	$('#FechaResponRegis').datepicker({

	}).datepicker('update','');


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
	$('#fechaNacimiento').datepicker({

	}).datepicker('update','');
	

	
	 
});


$("#btnEnviar").click(function(event) {
	var form = $("#formularioRegistroInstitucion")
    if (form[0].checkValidity() === false  || ($("#passwordResponRegis").val() != $("#claveConfirmacion").val())) {
      if ($("#passwordResponRegis").val() != $("#claveConfirmacion").val()) {
        notificacionBottomRight();
        toastr.error("Las contraseñas ingresadas no coinciden");
      }
      event.preventDefault()
      event.stopPropagation()
    } else {
    	 if($("#pathModuloRegistro").val()==""){
	          $("#informe").addClass('rojo');
			mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
	     } else {
						  
							$("#btnEnviar").attr("type", "submit");

							$(".card").append(
									"<div id='cargando'>Cargando...</div>")
									.fadeIn();
							setTimeout(function() {
								$(".card").delay("slow").fadeOut();
							}, 1500);
	     }
	     
	     }
	         
				form.addClass('was-validated');
    
			});

$("#provincia").change(function() {
	scanton = '';
	scanton = '<option value="">Seleccione...</option>';
	<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
	if ($("#provincia").val() == "${listadoLocalizacionCanton.idLocalizacionPadre}") {
		scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
	}
	</c:forEach>
	$('#canton').html(scanton);
});

$("#canton").change(function() {
	sparroquia = '';
	sparroquia = '<option value="" selected="true">Seleccione...</option>';
	<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
	if ($("#canton").val() == "${listadoLocalizacionParroquia.idLocalizacionPadre}") {
	  sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
	}
	</c:forEach>
	$('#parroquia').html(sparroquia);
});
/*
$("#identificador").change(function(event){
	
	var ruc = $("#identificador").val();

    //Preguntamos si la cedula consta de 10 digitos
    if(ruc.length == 14){
        
	event.preventDefault();
	var $botones = $("form").find("button[type='submit'],button[type='button']");
	url = "${urlWebServicesValidacionBsg}";
    $botones.attr("disabled", "disabled");
    if($("#identificador").val()!=""){
     var resultado = $.ajax({
	    url: url,
	    type: "post",
	    headers: {"X-CSRF-TOKEN": csrfToken},
	    data: { tipoIdentificacion: $("input:radio[name=tipoIdentificacion]:checked").val(), identificador: $("#identificador").val() ,tipo:"interno"},
	    dataType: "json",
	    async:   true,
	    beforeSend: function(){
	    	if ( $("#cargando").length ) {
        	    $("#card-body").find("#cargando").fadeIn();
            }else{
            	$("#card-body").append("<div id='cargando'>Cargando...</div>").fadeIn();
           	}
	    	
		},
		
	    success: function(msg){
	    	if(msg.estado=="exito"){
		     if(msg.mensaje==="RUC válido."){
			    	// $("#fechaNacimiento").val(msg.datos.fechaNacimiento);
			  		 $("#nombreUsuario").val(msg.datos.razonSocial);
				     }else
				     {}
		    	$botones.removeAttr("disabled");
		    	mostrarMensaje(msg.mensaje,"EXITO");	
		    			    	
	    	}else{
		    	$botones.attr("disabled", true);
	    		mostrarMensaje(msg.mensaje,"ERROR",3000);
		    }
	  	},
	  	error: function(jqXHR, textStatus, errorThrown){
	    	$("#cargando").delay("slow").fadeOut();
	    	mostrarMensaje("ERROR: " + textStatus + ", " +errorThrown,"FALLO");
	    },
        complete: function(){
        	$("#cargando").delay("slow").fadeOut();
        }
	});
}else{
	$botones.attr("disabled", true);
}
    }else{
    	
        mostrarMensaje("Esta Ruc tiene menos de 13 Digitos","ERROR");

      }    
      
    
});
*/

$('button.subirArchivo').click(
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

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});
$('button.EliminarArchivo').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaModuloRegistro");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo').removeAttr("disabled");
	$('#informe').val('');	
	$('#EliminarArchivo').hide();
	$('#subirArchivo').show();
	

});





$("#BtnVerificar").click(function(event) {	
	$("#funcion").val("");
	 $("#sector").val("");
	 $("#tipoMedio").val("");
	 $("#nivel").val("");
	var opcion = $("#identificador").val();
	  $.ajax({
      url: 'consultaRuc',
      headers: {"X-CSRF-TOKEN": csrfToken},
      type: "POST",
      dataType: 'html',
      data: {ruc: opcion},
      success: function (result) {
          if(result==="vacio"){   
        		mostrarMensaje("Ruc incorrecto o no se encuentra en el catastro del CPCCS o ya fue registrado Verifique con los técnicos del CPCCS!","ERROR-NOTIFICACION","3000");
        		   $('#institucion').html("");
        		 $('#institucion').html("<option value='0'>Seleccione...</option>");
        		 $('#btnEnviar').hide();
        		}
          else{
        	  mostrarMensaje("Seleccione su institución en el campo INSTITUCIÓN !","EXITO-NOTIFICACION","3000"); 
                $('#institucion').html("<option value='0'>Seleccione...</option>");
                 $('#institucion').append(result);   
                 $('#btnEnviar').show();
         
              }
      },
      error: function (result) {
    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
    		$('#institucion').html("");
    		 $('#institucion').html("<option value='0'>Seleccione...</option>");
    		 $('#btnEnviar').hide();

      }
  });

	  

});


$("#CorreoResponRegis").change(function(event) {	
	 var opcion = $("#CorreoResponRegis").val().toLowerCase();	 
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
    		  $("#CorreoResponRegis").val("");
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


$("#institucion").change(function(event) {	
	$("#funcion").val("");
	 $("#sector").val("");
	 $("#tipoMedio").val("");
	 $("#nivel").val("");
	 var opcion = $("#institucion").val();
	
	  $.ajax({
      url: 'cargardatosRuc',
      headers: {"X-CSRF-TOKEN": csrfToken},
      type: "POST",
      dataType: 'json',
      data: {codigo: opcion},
      success: function (result) {
    	  if(result.valida ==="vacio"){   
      		mostrarMensaje("Selecione una intitucion  !","ERROR-NOTIFICACION","3000");
      		
      		}
    		 else{
        		 $("#funcion").val(result.funcion);
        		 $("#sector").val(result.sector);
        		 $("#tipoMedio").val(result.tipoMI);
        		 $("#nivel").val(result.nivel);
        		 
        		 
        		 	  }
	  
      },
      error: function (result) {
    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
    		

      }
  });

});


validarDocumento  = function() {          		
	 numero = $("#CedulaResponRegis").val();
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
	         $("#CedulaResponRegis").val("");
	         return false;
	      }
	      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
	      if (numero.length < 10 ){              
	         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
	         $("#CedulaResponRegis").val("");
	         return false;
	      }

	      if (numero=="1212121212" || numero=="1010101010" || numero=="2222222222" || numero=="1414141414" || numero=="1616161616" || numero=="2424242424" || numero=="2020202020"  ) {
				 mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");	
				 $("#CedulaResponRegis").val("");
		     	 return false;
	      }
		     
	      /* Los primeros dos digitos corresponden al codigo de la provincia */
	      provincia = numero.substr(0,2);      
	      if (provincia < 1 || provincia > numeroProvincias){           
	         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
	         $("#CedulaResponRegis").val("");
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
	         $("#CedulaResponRegis").val("");
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
	            $("#CedulaResponRegis").val("");
	            return false;
	         }                  
	         /* El ruc de las empresas del sector publico terminan con 0001*/         
	         if ( numero.substr(9,4) != '0001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }         
	      else if(pri == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }         
	         if ( numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }      

	      else if(nat == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }         
	         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }      
	      mostrarMensaje("El dato ingresado es correto!",	"EXITO");
	      return true; 
}
 
</script>
</body>
</html>