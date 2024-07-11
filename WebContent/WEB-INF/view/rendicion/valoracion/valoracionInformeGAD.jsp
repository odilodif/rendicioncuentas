<%-- 
	version		: 1.0
	Document  	: valoracionInformeGAD
	Property   	: CPCCS
	Author		: Juan Carlos Vega
	Mail		: jc.vega@live.com
    Date		: 15/10/2021, 7:39
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
<c:set var="tamanioArchivo"
	value="<%=Constantes.TAMANIO_ARCHIVO_25_MEGAS%>" />
<c:set var="rutaModuloRetroalimentacion"
	value="<%=Constantes.RUTA_ARCHIVOS_MODULO_RETROALIMENTACION%>" />
	<c:set var="periodo"
	value="<%=Constantes.periodo()%>" />
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<div class="card text-center mb-card20">
	<div class="card-header ">
		<h5>Formulario para la valoración de informes</h5>
	</div>
	<div class="card-body">
	<input type="hidden" name="codigo" id="codigo" value="">		
	<input type="hidden" name="codigo1" id="codigo1" value="">	

		<div class="row">

			<div class="col-md-12 order-md-1">
			
					
<!-- Nav pills -->
				<ul class="nav nav-tabs nav-pills">
					<li class="nav-item"><a class="nav-link active" data-toggle="pill" href="#home">MATRIZ 1</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu1">MATRIZ 2</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu2">MATRIZ 3</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu3">MATRIZ 4</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu4">MATRIZ 5</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu5">MATRIZ 6</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu6">MATRIZ 7</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu7">MATRIZ 8</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu8">MATRIZ 9</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu9">MATRIZ 10</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu10">MATRIZ 11</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu11">MATRIZ 12</a></li>
				</ul>	
					<!-- Tab panes -->		
					<div class="tab-content">	
					<div class="tab-pane container active" id="home">
					
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario1"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP1" data-destino="detalleItem"
								data-accionEnExito="">
					
					
					<input type="hidden" name="pre1" id="pre1" value="">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Datos de la
							institución</h5>
						<div class="card-body">
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="nombreInstitución">Nombre de la
										Institución:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="nombreInstitución" name="nombreInstitución" disabled
										value="${nombreInstitución}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="identificadorInstitucion">Ruc:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="identificadorInstitucion" name="Institucion"
										disabled value="${identificadorInstitucion}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="funcionInstitucion">Función:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="funcionInstitucion" name="funcionInstitucion" disabled
										value="${funcionInstitucion}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="descripcionInstitucion">Descripción:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="descripcionInstitucion" name="descripcionInstitucion"
										disabled value="${descripcionInstitucion}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="sectorInstitucion">Sector:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="sectorInstitucion" name="sectorInstitucion" disabled
										value="${sectorInstitucion}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="representanteLegal">Representante Legal:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="representanteLegal" name="representanteLegal" disabled
										value="${representanteLegal}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="numeroInforme">Número de Informe:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="numeroInforme" name="numeroInforme" disabled
										value="${infcod}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="tipoInforme">Tipo de Informe:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="tipoInforme" name="tipoInforme" disabled
										value="${tipoFormulario}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="fechaFinInforme">Fecha de presentación:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="fechaFinInforme" name="fechaFinInforme" disabled
										value="${fecha}" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="estadoInforme">Estado Informe:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="estadoInforme" name="estadoInforme" disabled
										value="${estado}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta1">¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?</label>
									
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										id="cmbpregunta1" required="required" name="cmbpregunta1">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>

						</div>
					</div>	
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP1"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					
					</form:form>		
					</div>
					<div class="tab-pane container fade" id="menu1">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario2"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP2" data-destino="detalleItem"
								data-accionEnExito="">
								
					<input type="hidden" name="pre2" id="pre2" value="">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					<div class="card">
					
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
							DE LA EJECUCIÓN PRESUPUESTARIA</h5>
						<div class="card-body">

							<table id="TablaActualizarDetallePoa"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th width="5%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
										<th width="5%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO</th>
										<th width="30%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">DESCRIPCIÓN</th>
										<th width="10%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO
											CODIFICADO</th>
										<th width="10%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO
											EJECUTADO</th>
										<th width="10%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">%
											CUMPLIMIENTO DEL PRESUPUESTO</th>
										<th width="20%"
											style="text-align: center; vertical-align: middle; font-size: x-small;">LINK
											AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
											INSTITUCIÓN</th>

									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta2">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia1);"
										id="cmbPregunta2" required="required" name="cmbPregunta2">
										<option value="">Seleccione...</option>
										<option value="1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS">1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS</option>
										<option value="2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE">2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE</option>
										<option value="3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA">3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA</option>
										<option value="4. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN">4. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN</option>
										<option value="5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA">5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA</option>
										<option value="6. NO ABRE EL LINK">6. NO ABRE EL LINK</option>
										<option value="7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="8. RESPONDE EN 0">8. RESPONDE EN 0</option>
										<option value="9. OTROS, NO CUMPLE">9. OTROS, NO CUMPLE</option>
										<option value="10. VACÍO">10. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia1" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia1">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia1"
										name="evidencia1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo1" id="rutaArchivo1"
										name="rutaArchivo1" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo1"
										class="subirArchivo1 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo1 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo1" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
						 <div id="VerArchivoEvdidencia1" class="form-group row">
							<div class="col-md-3 text-left">
							<label for="linkEvidencia1">Archivo de Verificación </label>
							</div>
							<div class="col-md-3 text-left">
							   <a id="evidenciaLink1"  target="_blank"
							     class="archivoCargado" >Click aquí para ver archivo</a>
							        <input type="hidden" name="evidenciaRutaLink1" id="evidenciaRutaLink1" value="">
							</div>
							<div class="col-md-3 text-left">
								<button type="button" class="adjunto btn _eliminarColor btn-sm"
								id="EliminarArchiServer1">
								<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
								</button>
							</div>							
						</div>
					</div>	
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP2"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>
					<div class="tab-pane container fade" id="menu2">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario3"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP3" data-destino="detalleItem"
								data-accionEnExito="">
					<input type="hidden" name="pre3" id="pre3" value="">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">

					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
							CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
						<div class="card-body">
							<table id="tablaRegistrosProcesosContratacion"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th>TIPO DE CONTRATACIÓN</th>
										<th>ESTADO ACTUAL</th>
										<th>LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG.
											WEB DE LA INSTITUCIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia2);"
										id="cmbPregunta3" required="required" name="cmbPregunta3">
										<option value="">Seleccione...</option>
										<option value="1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP">1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP</option>
										<option value="2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS">2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS</option>
										<option value="3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN">3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN</option>
										<option value="4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)">4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)</option>
										<option value="5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA">5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA</option>
										<option value="6. NO ABRE EL LINK">6. NO ABRE EL LINK</option>
										<option value="7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="8. RESPONDE EN 0">8. RESPONDE EN 0</option>
										<option value="9. OTROS, NO CUMPLE">9. OTROS, NO CUMPLE</option>
										<option value="10. VACÍO">10. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia2" style="display:visible">
						<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia2">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
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
										data-rutaCarga="${rutaModuloRetroalimentacion}">
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
							</div>	
							<div id="VerArchivoEvdidencia1" class="form-group row">
									<div class="col-md-3 text-left">
									<label for="linkEvidencia2">Archivo de Verificación </label>
									</div>
									<div class="col-md-3 text-left">
									   <a id="evidenciaLink2"  target="_blank"
									     class="archivoCargado" >Click aquí para ver archivo</a>
									        <input type="hidden" name="evidenciaRutaLink2" id="evidenciaRutaLink2" value="">
									</div>
									<div class="col-md-3 text-left">
										<button type="button" class="adjunto btn _eliminarColor btn-sm"
										id="EliminarArchiServer2">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>							
							</div>
						</div>
						</div>
						<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP3"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
						</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu3">	
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario4"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP4" data-destino="detalleItem"
								data-accionEnExito="">
								
					<input  type="hidden" name="pre4" id="pre4" value="">
					<input  type="hidden" name="pre4_1" id="pre4_1" value="">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE PARTICIPACIÓN CIUDADANA</h5>
						<div class="card-body">
							<table id="tablaRegistrosMecanismosParticionCiudadanaFE"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th style="text-align: left; font-size: x-small;">MECANISMOS
											DE PARTICIPACIÓN CIUDADANA</th>
										<th style="text-align: left; font-size: x-small;">PONGA
											SI O NO</th>
										<th style="text-align: left; font-size: x-small;">NÚMERO
											DE MECANISMOS IMPLEMENTADOS EN EL AÑO</th>
										<th style="text-align: left; font-size: x-small;">MEDIO
											DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta4">¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia3);"
										id="cmbPregunta4" required="required" name="cmbPregunta4">
										<option value="">Seleccione...</option>
										<option value="1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA">1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA</option>
										<option value="2. ACTA - MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA - CIUDADANOS Y REGISTROS DE ASISTENCIA">2. ACTA - MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA - CIUDADANOS Y REGISTROS DE ASISTENCIA</option>
										<option value="3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN">3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia3" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia3">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
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
										data-rutaCarga="${rutaModuloRetroalimentacion}">
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
														
							<div id="VerArchivoEvdidencia1" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia3">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink3"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink3" id="evidenciaRutaLink3" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm "
									id="EliminarArchiServer3">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>	
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5">¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia3_1);"
										id="cmbPregunta5" required="required" name="cmbPregunta5">
										<option value="">Seleccione...</option>
										<option value="1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA">1. ACTA CONSTITUTIVA DE LAS INSTANCIAS DE PARTICIPACIÓN Y REGISTROS DE ASISTENCIA</option>
										<option value="2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA">2. ACTA/ MEMORIAS DE REUNIONES CON LA FIRMA DE LOS DELEGADOS DE LA ASAMBLEA CIUDADANA / CIUDADANOS Y REGISTROS DE ASISTENCIA</option>
										<option value="3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN">3. SISTEMATIZACIÓN DE PROCESOS DE PARTICIPACIÓN</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia3_1" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia3_1">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia3_1"
										name="evidencia3_1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo3_1" id="rutaArchivo3_1"
										name="rutaArchivo3_1" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo3_1"
										class="subirArchivo3_1 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo3_1 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo3_1" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
							</div>
							</div>
														
							<div id="VerArchivoEvdidencia3_1" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia3_1">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink3_1"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink3_1" id="evidenciaRutaLink3_1" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer3_1">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>		
							
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP4"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
				</div>
				<div class="tab-pane container fade" id="menu4">
				<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario5"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP5" data-destino="detalleItem"
								data-accionEnExito="">
								
								
								
					<input type="hidden" name="pre5" id="pre5" value="">
					<input type="hidden" name="pre5_1" id="pre5_1" value="">
					<input type="hidden" name="pre5_2" id="pre5_2" value="">
					<input type="hidden" name="pre5_3" id="pre5_3" value="">
					<input type="hidden" name="pre5_4" id="pre5_4" value="">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">

					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESO DE
							RENDICIÓN DE CUENTAS</h5>
						<div class="card-body">
							<table id="TablaRendicionFases"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th style="font-size: xx-small;">#</th>
										<th style="font-size: xx-small;">FASE</th>
										<th style="font-size: xx-small;">PROCESO DE RENDICIÓN DE
											CUENTAS</th>
										<th style="font-size: xx-small;">PONGA SI O NO</th>
										<th style="font-size: xx-small;">DESCRIBA LA EJECUCIÓN DE
											LOS PASOS</th>
										<th style="font-size: xx-small;">LINK AL MEDIO DE
											VERIFICACIÓN</th>

									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>


							<table id="TablaRendicionFasesAporte"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6">¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia4);"
										id="cmbPregunta6" required="required" name="cmbPregunta6">
										<option value="">Seleccione...</option>
										<option value="1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS (FÍSICO O DIGITAL), DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO">1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS (FÍSICO O DIGITAL), DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO</option>
										<option value="2. ACTA DE REUNIÓN DONDE CONSTA EL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO">2. ACTA DE REUNIÓN DONDE CONSTA EL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO</option>
										<option value="3. CAPTURA DE PANTALLA DE LOS  TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA POR CORREO Y/O MEDIOS VIRTUALES A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO">3. CAPTURA DE PANTALLA DE LOS  TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA POR CORREO Y/O MEDIOS VIRTUALES A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO IMPLEMENTÓ">6. NO IMPLEMENTÓ</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
										
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia4" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia4"
										name="evidencia4" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4" id="rutaArchivo4"
										name="rutaArchivo4" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4"
										class="subirArchivo4 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo4 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo4" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia4" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia4">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink4"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink4" id="evidenciaRutaLink4" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm "
									id="EliminarArchiServer4">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>	

							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7">¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia4_1);"
										id="cmbPregunta7" required="required" name="cmbPregunta7">
										<option value="">Seleccione...</option>
										<option value="1. DOCUMENTO DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN">1. DOCUMENTO DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN.</option>
										<option value="2. ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA E.P DEL GAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN">2. ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA E.P DEL GAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN.</option>
										<option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
										<option value="4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="5. NO APLICA">5. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
										<option value="7. VACÍO">7. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia4_1" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4_1">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia4_1"
										name="evidencia4_1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4_1" id="rutaArchivo4_1"
										name="rutaArchivo4_1" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4_1"
										class="subirArchivo4_1 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo4_1 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo4_1" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
						 <div id="VerArchivoEvdidencia4_1" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia4_1">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink4_1"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink4_1" id="evidenciaRutaLink4_1" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer4_1">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>	
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8">¿EL GAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia4_2);"
										id="cmbPregunta8" required="required" name="cmbPregunta8">
										<option value="">Seleccione...</option>
										<option value="1. LINK AL VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA">1. LINK AL VIDEO EN EL QUE EL GAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA.</option>
										<option value="2. LINK AL VIDEO EN EL QUE EL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA">2. LINK AL VIDEO EN EL QUE EL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA</option>
										<option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
										<option value="4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="5. NO APLICA">5. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
										<option value="7. VACÍO">7. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
						<div id="divevidencia4_2" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4_2">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia4_2"
										name="evidencia4_2" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4_2" id="rutaArchivo4_2"
										name="rutaArchivo4_2" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4_2"
										class="subirArchivo4_2 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo4_2 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo4_2" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							 <div id="VerArchivoEvdidencia4_2" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia4_2">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink4_2"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink4_2" id="evidenciaRutaLink4_2" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer4_2">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta9">¿EL GAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia4_3);"
										id="cmbPregunta9" required="required" name="cmbPregunta9">
										<option value="">Seleccione...</option>
										<option value="1. DOCUMENTO DEL PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD">1. DOCUMENTO DEL PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD.</option>
										<option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
										<option value="3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="4. NO APLICA">4. NO APLICA</option>
										<option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
										<option value="6. VACÍO">6. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
						<div id="divevidencia4_3" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4_3">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia4_3"
										name="evidencia4_3" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4_3" id="rutaArchivo4_3"
										name="rutaArchivo4_3" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4_3"
										class="subirArchivo4_3 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo4_3 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo4_3" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							 <div id="VerArchivoEvdidencia4_3" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia4_3">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink4_3"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink4_3" id="evidenciaRutaLink4_3" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer4_3">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta10">¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia4_4);"
										id="cmbPregunta10" required="required" name="cmbPregunta10">
										<option value="">Seleccione...</option>
										<option value="1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA/ CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO">1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA/ CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO.</option>
										<option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
										<option value="3. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="4. NO APLICA">4. NO APLICA</option>
										<option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
										<option value="6. VACÍO">6. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia4_4" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4_4">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia4_4"
										name="evidencia4_4" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4_4" id="rutaArchivo4_4"
										name="rutaArchivo4_4" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4_4"
										class="subirArchivo4_4 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo4_4 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo4_4" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia4_4" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia4_4">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink4_4"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink4_4" id="evidenciaRutaLink4_4" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer4_4">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>

						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP5"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
				</div>
					<p></p>
					
				<div class="tab-pane container fade" id="menu5">	
				<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario6"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP6" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre6" id="pre6" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
				
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL</h5>
						<div class="card-body">
						
						<table id="TablaIncorporacionRecom"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th style="font-size:x-small;">SUGERENCIA DE LA COMUNIDAD</th>
								<th style="font-size:x-small;">hola RESULTADOS DE LA IMPLEMENTACIÓN DE LA SUGERENCIA CIUDADANA</th>
								<th style="font-size:x-small;">PORCENTAJE DE AVANCE DE LA IMPLEMENTACIÓN</th>
								<th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>								
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta11">¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia5);"
										id="cmbPregunta11" required="required" name="cmbPregunta11">
										<option value="">Seleccione...</option>
										<option value="1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN">1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRA LA IMPLEMENTACIÓN</option>
<!-- 										<option value="2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS">2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS</option> -->
										<option value="3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES">3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia5" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia5">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia5"
										name="evidencia5" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo5" id="rutaArchivo5"
										name="rutaArchivo5" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo5"
										class="subirArchivo5 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo5 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo5" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia5" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia5">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink5"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink5" id="evidenciaRutaLink5" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer5">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP6"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					
					</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu6">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario7"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP7" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre7" id="pre7" value="">
					<input type="hidden" name="pre7_1" id="pre7_1" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PRESUPUESTO PARTICIPATIVO</h5>
						<div class="card-body">
							<table id="TablaPorcentajePresupuesto"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
									<th class="tablaingreso" width="10%">#</th>
									<th class="tablaingreso" width="20%">TOTAL DE PRESUPUESTO DE LA INSTITUCIÓN</th>
									<th class="tablaingreso" width="20%">PRESUPUESTO TOTAL ASIGNADO AL PRESUPUESTO ASIGNADO PARA PRESUPUESTOS PARTICIPATIVOS</th>
									<th class="tablaingreso" width="20%">PORCENTAJE DE PRESUPUESTO INSTITUCIONAL ASIGNADO PARA PRESUPUESTOS PARTICIPATIVOS </th>
				       				<th class="tablaingreso" width="20%">MEDIOS DE VERIFICACIÓN (ACTO NORMATIVO DE PRESUPUESTO PARTICIPATIVO)</th>
									</tr>
								</thead>
								<tbody>
								</tbody>				
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta12">¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia6);"
										id="cmbPregunta12" required="required" name="cmbPregunta12">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
										
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							
							<div id="divevidencia6" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia6">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia6"
										name="evidencia6" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo6" id="rutaArchivo6"
										name="rutaArchivo6" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo6"
										class="subirArchivo6 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo6 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo6" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia6" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia6">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink6"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink6" id="evidenciaRutaLink6" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer6">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
							
								<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta13">¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?</label>
								</div>
								<div class="col-md-3 text-left">
										<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia6_1);"
										id="cmbPregunta13" required="required" name="cmbPregunta13">
										<option value="">Seleccione...</option>
										<option value="1. SI, CÉDULA PRESUPUESTARIA del GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO">1. SI, CÉDULA PRESUPUESTARIA del GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO</option>
										<option value="2. SI, ADJUNTAN ACTA DE LA ASAMBLEA DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO">2. SI, ADJUNTAN ACTA DE LA ASAMBLEA DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO</option>
										<option value="3. SI, ADJUNTAN UN DOCUMENTO OFICIAL DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO">3. SI, ADJUNTAN UN DOCUMENTO OFICIAL DEL GAD, QUE DETALLA EL VALOR REPORTADO, DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO PARTICIPATIVO Y LA EJECUCIÓN DEL MISMO</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia6_1" style="display:visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia6_1">Adjuntar captura de pantalla de
											la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia6_1"
											name="evidencia6_1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">
	
										<div class="estadoCarga">En espera de archivo... (Tamaño
											máximo ${tamanioArchivo})</div>
										<input type="hidden" class="rutaArchivo6_1" id="rutaArchivo6_1"
											name="rutaArchivo6_1" value="" />
										<div class="invalid-feedback">Por favor seleccione un
											archivo</div>
									</div>
	
									<div class="col-md-3 text-left">
										<button type="button" id="subirArchivo6_1"
											class="subirArchivo6_1 adjunto btn _nuevoColor btn-sm"
											data-rutaCarga="${rutaModuloRetroalimentacion}">
											<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
											archivo
										</button>
	
										<button type="button"
											class="EliminarArchivo6_1 adjunto btn _eliminarColor btn-sm Oculta"
											id="EliminarArchivo6_1" disabled="disabled">
											<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>
	
								</div>
							</div>
							
							<div id="VerArchivoEvdidencia6_1" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia6_1">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink6_1"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink6_1" id="evidenciaRutaLink6_1" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm "
									id="EliminarArchiServer6_1">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP7"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu7">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario8"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP8" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre8" id="pre8" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">DETALLE DEL PRESUPUESTO PARTICIPATIVO</h5>
						<div class="card-body">
					<table id="TablaProyPresupuestoParticipativo"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th width="5%">#</th>
								<th width="25%">PROGRAMAS Y PROYECTOS GENERADOS A PARTIR DE LA PRIORIZACIÓN PARTICIPATIVA DE LA INVERSIÓN</th>
								<th width="10%">MONTO PLANIFICADO</th>
								<th width="10%">MONTO EJECUTADO</th>
								<th width="10%">% DE AVANCE DE LA IMPLEMENTACIÓN DEL PROGRAMA / PROYECTO</th>
								<th width="25%">OBSERVACIONES</th>
								<th width="10%">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14">¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia7);"
										id="cmbPregunta14" required="required" name="cmbPregunta14">
										<option value="">Seleccione...</option>
										<option value="1. ACTA">1. ACTA</option>
										<option value="2. INFORME DE CUMPLIMIENTO">2. INFORME DE CUMPLIMIENTO</option>
										<option value="3. DOCUMENTO OFICIAL DEL GAD QUE EVIDENCIA LA EJECUCIÓN DEL COMPROMISO ASUMIDO, A PARTIR DE LO PROPUESTO POR LA CIUDADANÍA EN EL PRESUPUESTO PARTICIPATIVO, EN EL EJERCICIO FISCAL ANTERIOR">3. DOCUMENTO OFICIAL DEL GAD QUE EVIDENCIA LA EJECUCIÓN DEL COMPROMISO ASUMIDO, A PARTIR DE LO PROPUESTO POR LA CIUDADANÍA EN EL PRESUPUESTO PARTICIPATIVO, EN EL EJERCICIO FISCAL ANTERIOR.</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="6. RESPONDE EN 0">6. RESPONDE EN 0</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia7" style="display:visible">
							<div class="form-group row">
							
								<div class="col-md-3 text-left">
									<label for="evidencia7">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia7"
										name="evidencia7" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo7" id="rutaArchivo7"
										name="rutaArchivo7" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo7"
										class="subirArchivo7 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo7 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo7" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia7" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia7">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink7"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink7" id="evidenciaRutaLink7" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer7">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP8"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu8">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario9"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP9" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre9" id="pre9" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">SISTEMA DE PARTICIPACIÓN CIUDADANA</h5>
						<div class="card-body">
							<table id="TablaPartipCiudad"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th style="font-size: x-small;">#</th>
										<th style="font-size: x-small;">SISTEMA DE PARTICIPACIÓN CIUDADANA Art. 304</th>
										<th style="font-size: x-small;">PONGA SI O NO</th>
										<th style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>				
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta15">¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia8);"
										id="cmbPregunta15" required="required" name="cmbPregunta15">
										<option value="">Seleccione...</option>
										<option value="1. ORDENANZA, EN EL CASO DEL GAD CANTONAL O PROVINCIAL">1. ORDENANZA, EN EL CASO DEL GAD CANTONAL O PROVINCIAL</option>
										<option value="2. RESOLUCIÓN, EN EL CASO DE LOS GAD PARROQUIALES">2. RESOLUCIÓN, EN EL CASO DE LOS GAD PARROQUIALES.</option>
										<option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
										<option value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="5. NO APLICA">5. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
										<option value="7. VACÍO">7. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia8" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia8">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia8"
										name="evidencia8" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo8" id="rutaArchivo8"
										name="rutaArchivo8" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo8"
										class="subirArchivo8 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo8 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo8" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia8" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia8">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink8"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink8" id="evidenciaRutaLink8" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer8">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP9"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu9">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario10"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP10" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre10" id="pre10" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE CONTROL SOCIAL</h5>
						<div class="card-body">
							<table id="TablaContSocial"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th style="font-size: x-small;">#</th>
										<th style="font-size: x-small;">MECANISMOS DE CONTROL
											SOCIAL GENERADOS POR LA COMUNIDAD</th>
										<th style="font-size: x-small;">PONGA SI O NO</th>
										<th style="font-size: x-small;">NÚMERO DE MECANISMOS</th>
										<th style="font-size: x-small;">LINK AL MEDIO DE
											VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta16">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia9);"
 -->									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia9);"
										id="cmbPregunta16" required="required" name="cmbPregunta16">
										<option value="">Seleccione...</option>
										<option value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
										<option value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS">2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS</option>
										<option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia9" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia9">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia9"
										name="evidencia9" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo9" id="rutaArchivo9"
										name="rutaArchivo9" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo9"
										class="subirArchivo9 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo9 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo9" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div> 
							
							<div id="VerArchivoEvdidencia9" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia9">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink9"  target="_blank"
								     class="archivoCargado" >Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink9" id="evidenciaRutaLink9" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer9">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>							
							</div>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP10"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>

					<p></p>
					<div class="tab-pane container fade" id="menu10">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario11"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP11" data-destino="detalleItem"
								data-accionEnExito="">
				
				
					<input type="hidden" name="pre11" id="pre11" value="">
					<input type="hidden" name="pre11_1" id="pre11_1" value="">
					<input type="hidden" name="pre11_2" id="pre11_2" value="">
					<input type="hidden" name="pre11_3" id="pre11_3" value="">
					<input type="hidden" name="pre11_4" id="pre11_4" value="">
					<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">IMPLEMENTACIÓN
							DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
						<div class="card-body">
							<table id="TablaImpleIgualdad"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th style="font-size: x-small;">IMPLEMENTACIÓN DE
											POLÍTICAS PÚBLICAS PARA LA IGUALDAD</th>
										<th style="font-size: x-small;">PONGA SI O NO</th>
										<th style="font-size: x-small;">DESCRIBA LA POLÍTICA
											IMPLEMENTADA</th>
										<th style="font-size: x-small;">DETALLE PRINCIPALES
											RESULTADOS OBTENIDOS</th>
										<th style="font-size: x-small;">EXPLIQUE CÓMO APORTA EL
											RESULTADO AL CUMPLIMIENTO DE LAS AGENDAS DE IGUALDAD</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta20">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia10);"
 -->									<select class="custom-select custom-select-sm" 
										id="cmbPregunta20" required="required" name="cmbPregunta20">
										<option value="">Seleccione...</option>
										<option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y	DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="3. REPORTA NO">3. REPORTA NO</option>
										<option value="4. VACÍO">4. VACÍO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta18">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia10);"
 -->									<select class="custom-select custom-select-sm" 
										id="cmbPregunta18" required="required" name="cmbPregunta18">
										<option value="">Seleccione...</option>
										<option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y	DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="3. REPORTA NO">3. REPORTA NO</option>
										<option value="4. VACÍO">4. VACÍO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta19">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia10);"
 -->									<select class="custom-select custom-select-sm" 
										id="cmbPregunta19" required="required" name="cmbPregunta19">
										<option value="">Seleccione...</option>
										<option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y	DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="3. REPORTA NO">3. REPORTA NO</option>
										<option value="4. VACÍO">4. VACÍO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>

							

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta17">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia10);"
 -->									<select class="custom-select custom-select-sm" 
										id="cmbPregunta17" required="required" name="cmbPregunta17">
										<option value="">Seleccione...</option>
										<option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y	DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="3. REPORTA NO">3. REPORTA NO</option>
										<option value="4. VACÍO">4. VACÍO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta21">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?</label>
								</div>
								<div class="col-md-3 text-left">
<!-- 									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia10);"
 -->									<select class="custom-select custom-select-sm" 
										id="cmbPregunta21" required="required" name="cmbPregunta21">
										<option value="">Seleccione...</option>
										<option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y	DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
										<option value="3. REPORTA NO">3. REPORTA NO</option>
										<option value="4. VACÍO">4. VACÍO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<%-- <div id="divevidencia10" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia10">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia10"
										name="evidencia10" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo10" id="rutaArchivo10"
										name="rutaArchivo10" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo10"
										class="subirArchivo10 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo10 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo10" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div> --%>
						</div>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarP11"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>
					</div>
					<p></p>
					<div class="tab-pane container fade" id="menu11">
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario12"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmGADP12" data-destino="detalleItem"
								data-accionEnExito="ACTUALIZAR">
								
				     <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
					 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
					 
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Observación</h5>
						<div class="card-body">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="observacion">Describa la o las razones que
										motivaron la evaluación del presente informe, recuerde que
										está observación puede aparecer en el email que será remitido
										a la institución</label>
								</div>

								<textarea rows="4" cols="" class="form-control form-control-sm"
									id=observacion name="observacion"
									placeholder="Ingrese el comentario aquí"></textarea>
								<div class="invalid-feedback">Por favor ingrese el
									comentario</div>
							</div>


						</div>
					</div>
					<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarP12"
									class="btn _imprimirColor _guardar btn-sm mt-2 Oculta">Finalizar Evaluación</button>
					</div>
					</form:form>
					</div>
					</div>

			</div>
		</div>
	</div>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		$('.Oculta').hide();
		console.log('${pregunta1.idInfCal}');
		   if('${pregunta1.idInfCal}' !== ""){	
				$("#codigo").val('${pregunta1.idInfCal}');
				$("#pre1").val($("#codigo").val());	
				console.log(pre1);
				 cargarValorComboPorDefecto("cmbpregunta1",'${pregunta1.respuesta}');
			}
		   
	});
	
	$('a[data-toggle="pill"]').on('click', function(event) {
		var x = $(this).attr('href');
		switch (x) {
		case '#home':
			   obtenerdatosPreguntas();				   
		break;  
		case '#menu1':
			   obtenerdatosPreguntas();
			   tablaEjecucionPresupuestaria();	
		   
	   break;
		  case '#menu2':		 
			tablaProcesosContratacion();
			obtenerdatosPreguntas();
	   break;
		  case '#menu3':		  
			  tablaMecanismosParticionCiudadanaFE();
			  obtenerdatosPreguntas();
	   break;
		  case '#menu4':
			  obtenerdatosPreguntas();
			  tablaPRFE();
	   break;
		  case '#menu5':
			  obtenerdatosPreguntas();
			  tablaIncorporacionRecomenFE();
	   break;
		  case '#menu6':
			  tablaPresupuestoParticipativo();
				obtenerdatosPreguntas();
	   break;
		  case '#menu7':
			  tablaDetallePresupuestoParticipativo()
			  obtenerdatosPreguntas();
	   break;
		  case '#menu8':
			  tablaSistemaParticipacionCiudadana()
			  obtenerdatosPreguntas();
	   break;
		  case '#menu9':
			  tablaControlSocialFE();
			  obtenerdatosPreguntas();
	   break;
		  case '#menu10':
			  TablaImpleIgualdadFE()
			  obtenerdatosPreguntas();

	   break;
		  case '#menu11':
			  obtenerdatosPreguntas();
				 
			   break;
		}
		//validarIdInforme($("#infcod").val());
		//detalle8.idInfCal
		//$("#id_informe_4").val('${detalle4.idInfCal}');
	});


	
	
//--*-*-*-*-*-*-*-*-*-*- botones de guardar cada matrix

	$("#btnGuardarP1").click(	function(event) {
		var form = $("#formulario1")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			ejecutarJson(form);			
			$("#pre1").val($("#codigo").val());
		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP2").click(	function(event) {
		var form = $("#formulario2")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia1')==false ){
				 $("#evidencia1").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre2").val($("#codigo").val());					
			     }
		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP3").click(	function(event) {
		var form = $("#formulario3")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia2')==false ){
				 $("#evidencia2").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre3").val($("#codigo").val());				
			     }

		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP4").click(	function(event) {
		var form = $("#formulario4")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia3')==false ){
				 $("#evidencia3").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");	
		     }else if(ValidarArchivo('evidencia3_1')==false) {				    	
		    	 $("#evidencia3_1").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre4").val($("#codigo").val());	
						$("#pre4_1").val($("#codigo1").val());	
			     }
		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP5").click(	function(event) {
		var form = $("#formulario5")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			if(ValidarArchivo('evidencia4')==false ){
				 $("#evidencia4").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");	
		     }else if(ValidarArchivo('evidencia4_1')==false) {				    	
		    	 $("#evidencia4_1").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     }else if(ValidarArchivo('evidencia4_2')==false) {				    	
		    	 $("#evidencia4_2").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     }else if(ValidarArchivo('evidencia4_3')==false) {				    	
		    	 $("#evidencia4_3").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     }else if(ValidarArchivo('evidencia4_4')==false) {				    	
		    	 $("#evidencia4_4").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     }else{	
					ejecutarJson(form);			
					obtenerdatosPreguntas();
			     }
		}
		form.addClass('was-validated');
	});
	
	
	$("#btnGuardarP6").click(	function(event) {
		var form = $("#formulario6")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia5')==false ){
				 $("#evidencia5").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre6").val($("#codigo").val());		
			     }

		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP7").click(	function(event) {
		var form = $("#formulario7")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia6')==false ){
				 $("#evidencia6").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     }else if(ValidarArchivo('evidencia6_1')==false) {				    	
		    	 $("#evidencia6_1").addClass('rojo');			    	 
		    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre7").val($("#codigo").val());	
						$("#pre7_1").val($("#codigo1").val());	
			     }

		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP8").click(	function(event) {
		var form = $("#formulario8")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia7')==false ){
				 $("#evidencia7").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre8").val($("#codigo").val());
			     }

		}
		form.addClass('was-validated');
	});

	$("#btnGuardarP9").click(	function(event) {
		var form = $("#formulario9")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia8')==false ){
				 $("#evidencia8").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre9").val($("#codigo").val());
			     }

		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP10").click(	function(event) {
		var form = $("#formulario10")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia9')==false ){
				 $("#evidencia9").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
						ejecutarJson(form);			
						$("#pre10").val($("#codigo").val());
			     }
		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP11").click(	function(event) {
		var form = $("#formulario11")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			ejecutarJson(form);			
			obtenerdatosPreguntas();
		}
		form.addClass('was-validated');
	});
	
	$("#btnGuardarP12").click(function(event) {
		var form = $("#formulario12")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {	 
			    //ejecutarJson(form);
			 visualizarMensajeConfirmacion('ATENCIÓN', '¿Está seguro de Finalizar la evaluación?', form, 'basicconfir');
		}
		form.addClass('was-validated');
	

	});
	
//--*-*-*-*-*-*-*-*-*-*- Fin botones de guardar cada matrix

	function tablaEjecucionPresupuestaria() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaActualizarDetallePoa').DataTable({
							ajax : {
								data : parametros,
								url : "obtenerActualizarDetallePoa",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,
							bDestroy : true,
							columns : [
									{
										data : "contador"
									},
									{
										data : "depTipo"
									},
									{
										data : "depDescripcion"
									},
									{
										data : "depPresplan"
									},
									{
										data : "depPresejec"
									},
									{
										data : "depCumple"
									},
									{
										data : "depLink",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],
							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},
							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.depCodigo);
								//$(row).attr('class', 'item');
								//$(row).attr('data-rutaAplicacion', '');
								//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td:eq(3)").attr('title',
										data.nombres);
								$(row).find("td").css({
									"font-size" : "x-small",
								});

								$(row).find("td").css({
									"vertical-align" : "middle",
								});
							},
						});
	}

	function tablaProcesosContratacion() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$
				.ajax({
					url : "obtenerRegistrosProcesoContratacion",
					type : "post",
					dataType : "json",
					data : parametros,
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					success : function(result) {
						if (result['Error']) {
							$('#tabla').hide();
						} else if (result['data'].length != 0) {
							$('#nuevo').hide();
							$('#tablaRegistrosProcesosContratacion')
									.DataTable(
											{

												order : [ 0, "asc" ],
												paging : false,
												info : false,
												searching : false,
												bDestroy : true,
												buttons : [ {
													extend : 'copyHtml5'
												}, {
													extend : 'csvHtml5'
												}, {
													extend : 'excelHtml5'
												}, {
													extend : 'pdfHtml5',
													orientation : 'landscape',
													pageSize : 'A1'
												}, {
													extend : 'print'
												}, ],
												data : result.data,
												columns : [
														{
															data : "contador"
														},
														{
															data : "tipo"
														},
														{
															data : "",
															"render" : function(
																	data, type,
																	full, meta) {
																data = '<table class="table registros table-bordered"> <tr> <th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Finalizados</th> <th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Finalizados</th></tr><tr><td>'
																		+ full.numeroAdj
																		+ '</td><td>'
																		+ full.valorAdj
																		+ '</td><td>'
																		+ full.numeroFin
																		+ '</td><td>'
																		+ full.valorFin
																		+ '</td> </tr></table>'
																return data;
															}
														},
														{
															data : "link",
															render : function(
																	data) {
																if (data === "NO APLICA"
																		|| data === "S/N") {
																} else {
																	data = '<a href="' + data + '" style="color:blue;" target="_blank">'
																			+ data
																			+ '</a>';
																}

																return data;
															}
														} ],
												language : {
													url : "resources/json/lenguajeTablaDataTable.json"
												},
												createdRow : function(row,
														data, dataIndex) {
													$(row).attr('id',
															data.pcoCod);
													$(row).attr('ondragstart',
															'drag(event)');
													$(row).attr('draggable',
															'false');
													$(row).attr('data-destino',
															'detalleItem');
													$(row)
															.find("td:first")
															.css(
																	{
																		"font-weight" : "bold",
																		"white-space" : "nowrap"
																	});
												},
											});
						} else {
						}
					},
					error : function(errormessage) {
						alert(errormessage.responseText);
					}
				});
	}

	function tablaMecanismosParticionCiudadanaFE() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#tablaRegistrosMecanismosParticionCiudadanaFE')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerMecanismoParticipacionEjecutivo",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,
							bDestroy : true,
							buttons : [ {
								extend : 'excelHtml5'
							}, {
								extend : 'pdfHtml5',
								orientation : 'landscape',
								pageSize : 'A1'
							}, {
								extend : 'print'
							}, ],
							columns : [
									{
										data : "contador"
									},
									{
										data : "nombre"
									},
									{
										data : "implementado"
									},
									{
										data : "numero"
									},
									{
										data : "link",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],
							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},
							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.meca_cod);
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap"
								});
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap"
								});
							},
						});
	}

	function tablaPRFE() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaRendicionFases').DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerRendicionFases",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							pageLength : 12,
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,
							responsive : true,
							bDestroy : true,
							columns : [
									{
										data : "contador"
									},
									{
										data : "mecanismo"
									},
									{
										data : "proceso"
									},
									{
										data : "seleccion"
									},
									{
										data : "describa"
									},
									{
										data : "link",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},
							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.mecanismo_cod);
								//$(row).attr('class', 'item');
								$(row).attr('data-rutaAplicacion', 'rendicion');
								$(row).attr('data-opcion',
										'Frm_RendicionCuentasFasesActualizar');
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});

								$(row).find("td").css({
									"font-size" : "x-small",
								});

								$(row).find("td").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	

	function tablaIncorporacionRecomenFE() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaIncorporacionRecom')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerRegistrosCumplimientoSugerencias",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,

							bDestroy : true,
							columns : [
								{data : "contador" },
								{data : "sugerencias"},
								{data : "resultados"},
								{data : "porcAvance"},
								{
										data : "link",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},

							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.cscCod);
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td:eq(7)").css({
									"vertical-align" : "middle",
								});
								$(row).find("td:eq(8)").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	function tablaControlSocialFE() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaContSocial')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerControlSocial",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,
							responsive : true,

							bDestroy : true,
							columns : [
									{
										data : "contador"
									},
									{
										data : "sistema"
									},
									{
										data : "seleccion"
									},
									{
										data : "numero"
									},
									{
										data : "link",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},
							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.mec_cod);
								//$(row).attr('class', 'item');
								$(row).attr('data-rutaAplicacion', 'rendicion');
								$(row).attr('data-opcion',
										'Frm_MecanismosConstrolSocialActul');
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td:eq(5)").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	function TablaImpleIgualdadFE() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaImpleIgualdad')
				.DataTable(
						{
							ajax : {
								data : parametros,
								url : "obtenerImpletIgualdad",
								headers : {
									"X-CSRF-TOKEN" : csrfToken
								},
								type : "POST"
							},
							order : [ 0, "asc" ],
							paging : false,
							info : false,
							searching : false,
							responsive : true,
							bDestroy : true,
							columns : [
									{
										data : "contador"
									},
									{
										data : "politica"
									},
									{
										data : "seleccion"
									},
									{
										data : "descripcion"
									},
									{
										data : "detalle"
									},
									{
										data : "explique",
										render : function(data) {
											if (data === "NO APLICA"
													|| data === "S/N") {
											} else {
												data = '<a href="' + data + '" style="color:blue;" target="_blank">'
														+ data + '</a>';
											}

											return data;
										}
									} ],

							language : {
								url : "resources/json/lenguajeTablaDataTable.json"
							},

							createdRow : function(row, data, dataIndex) {
								$(row).attr('id', data.pi_cod);
								//$(row).attr('class', 'item');
								$(row).attr('data-rutaAplicacion', 'rendicion');
								$(row).attr('data-opcion',
										'Frm_ImplemetacionPoliticasActul');
								$(row).attr('ondragstart', 'drag(event)');
								$(row).attr('draggable', 'false');
								$(row).attr('data-destino', 'detalleItem');
								$(row).find("td:first").css({
									"font-weight" : "bold",
									"white-space" : "nowrap",
								});
								$(row).find("td").css({
									"font-size" : "x-small",
								});
								$(row).find("td:eq(6)").css({
									"vertical-align" : "middle",
								});

							},

						});

	}

	function tablaPresupuestoParticipativo() {
		var parametros = {
				"infCod" : $("#infcod").val()
			};
		$('#TablaPorcentajePresupuesto').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerPorcentajePresupuesto",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		bDestroy : true,
		columns : [
			{data : "contador"},
			{data : "infTotalpres"},
			{data : "infPresparticipativo"}, 
			{data : "infPorprespar"}, 
			{data : "infLinkpres",
				render : function(data) {
					if (data === "NO APLICA"
							|| data === "S/N") {
					} else {
						data = '<a href="' + data + '" style="color:blue;" target="_blank">'
								+ data + '</a>';
					}

					return data;
				}
	        }
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.presCod);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', '');
				//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});
		
				$(row).find("td:eq(3)").attr('title', data.nombres);			
		
			},	
			
		});

	}

	function tablaDetallePresupuestoParticipativo() {
		var parametros = {
				"infCod" : $("#infcod").val()
			};
		$('#TablaProyPresupuestoParticipativo').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerProyPresupuestoParticipativo",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		bDestroy : true,		
		columns : [			
			{data : "contador"},
			{data : "proyDescripcion"},
			{data : "proyMontoplan"}, 
			{data : "proyMontoejec"},
			{data : "proyPorcAvance"}, 
			{data : "proyObs"}, 
			{data : "proyLinks",
				render : function(data) {
					if (data === "NO APLICA"
							|| data === "S/N") {
					} else {
						data = '<a href="' + data + '" style="color:blue;" target="_blank">'
								+ data + '</a>';
					}

					return data;
				}}
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.proyCod);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', 'rendicion');
				//$(row).attr('data-opcion', 'Frm_MecanismosConstrolSocialActul');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});		
				$(row).find("td:eq(5)").css({
					"vertical-align" : "middle",									
				});				
			},	
		});
	}

	function tablaSistemaParticipacionCiudadana() {
		var parametros = {
				"infCod" : $("#infcod").val()
			};		$('#TablaPartipCiudad').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerPartCiudadana",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		bDestroy : true,
		columns : [			
			{data : "contador"},
			{data : "sistema"},
			{data : "seleccion"}, 
			{data : "link",
				render : function(data) {
					if (data === "NO APLICA"
							|| data === "S/N") {
					} else {
						data = '<a href="' + data + '" style="color:blue;" target="_blank">'
								+ data + '</a>';
					}

					return data;
				}}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pc_cod);
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_ParticipacionCiudadanaGadActul');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});		
					$(row).find("td:eq(4)").css({
					"vertical-align" : "middle",									
				});		
					$(row).find("td").css({
						"font-size"   : "x-small",			
					});	
				if(data.sistema ==='DESCRIBA LOS RESULTADOS ALCANZADOS POR EL SISTEMA DE PARTICIPACIÓN'){
			        $('td:eq(3)', row).attr('colspan', 2);		          
		            $('td:eq(2)', row).css('display', 'none');	      
		         
		           
		       }	
			/*	if(data.sistema ==='¿Cuenta con un SISTEMA DE PARTICIPACIÓN CIUDADANA Art. 304 en funcionamiento?'){
					
		             $('td:eq(1)', row).attr('rowspan', 5);

		          
		            $('td:eq(2)', row).css('display', 'none');
		            $('td:eq(3)', row).css('display', 'none');
		            $('td:eq(4)', row).css('display', 'none');
		            $('td:eq(5)', row).css('display', 'none');
		      
		           // console.log( this.api().cell($('td:eq(1)', row)).data('N/A'));
		           
		       }	*/
		
			},	
			
		});

	}

	$('button.subirArchivo1').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(
						".archivo");
				var rutaArchivo = boton.parent('div').parent('div')
						.find(".rutaArchivo1");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(
						".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#identificadorResponsable")
						.val()
						+ "_evidencia-1-"
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
					$('#EliminarArchivo1').show();
					$('#EliminarArchivo1').removeAttr("disabled");
					$('#subirArchivo1').hide();
					$('#evidenciaLink1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo1').val());							
					$("#evidenciaRutaLink1").val($('#rutaArchivo1').val());

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	
$('button.EliminarArchivo1').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(
				".estadoCarga");
		var archivourl = $("#rutaArchivo1").val();
		var rutaArchivo = boton.parent('div').parent('div').find(
				".rutaArchivo1");
		var archivo = boton.parent('div').parent('div')
				.find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
				estado, archivo, boton));
		$('#subirArchivo1').removeAttr("disabled");
		$('#evidencia1').val('');
		$('#EliminarArchivo1').hide();
		$('#subirArchivo1').show();
		$('#evidenciaLink1').attr('href', '');							
		$("#evidenciaRutaLink1").val('');
	});

$('button.subirArchivo2').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo2");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-2-"
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
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo2").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo2");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
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
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-3-"
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

$('button.subirArchivo3_1').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo3_1");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-3_1-"
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
				$('#EliminarArchivo3_1').show();
				$('#EliminarArchivo3_1').removeAttr("disabled");
				$('#subirArchivo3_1').hide();
				$('#evidenciaLink3_1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo3_1').val());							
				$("#evidenciaRutaLink3_1").val($('#rutaArchivo3_1').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo3_1').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo3_1").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo3_1");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo3_1').removeAttr("disabled");
	$('#evidencia3_1').val('');
	$('#EliminarArchivo3_1').hide();
	$('#subirArchivo3_1').show();
	$('#evidenciaLink3_1').attr('href', '');							
	$("#evidenciaRutaLink3_1").val('');
});


$('button.subirArchivo4').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo4");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-4-"
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
				$('#EliminarArchivo4').show();
				$('#EliminarArchivo4').removeAttr("disabled");
				$('#subirArchivo4').hide();
				$('#evidenciaLink4').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo4').val());							
				$("#evidenciaRutaLink4").val($('#rutaArchivo4').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo4').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo4").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo4");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo4').removeAttr("disabled");
	$('#evidencia4').val('');
	$('#EliminarArchivo4').hide();
	$('#subirArchivo4').show();
	$('#evidenciaLink4').attr('href', '');							
	$("#evidenciaRutaLink4").val('');
});


$('button.subirArchivo4_1').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo4_1");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-4_1-"
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
				$('#EliminarArchivo4_1').removeAttr("disabled");
				$('#EliminarArchivo4_1').show();
				$('#subirArchivo4_1').hide();
				$('#evidenciaLink4_1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo4_1').val());							
				$("#evidenciaRutaLink4_1").val($('#rutaArchivo4_1').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo4_1').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo4_1").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo4_1");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo4_1').removeAttr("disabled");
	$('#evidencia4_1').val('');
	$('#EliminarArchivo4_1').hide();
	$('#subirArchivo4_1').show();
	$('#evidenciaLink4_1').attr('href', '');							
	$("#evidenciaRutaLink4_1").val('');
});


$('button.subirArchivo4_2').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo4_2");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-4_2-"
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
				$('#EliminarArchivo4_2').removeAttr("disabled");
				$('#EliminarArchivo4_2').show();
				$('#subirArchivo4_2').hide();
				$('#evidenciaLink4_2').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo4_2').val());							
				$("#evidenciaRutaLink4_2").val($('#rutaArchivo4_2').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo4_2').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo4_2").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo4_2");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo4_2').removeAttr("disabled");
	$('#evidencia4_2').val('');
	$('#EliminarArchivo4_2').hide();
	$('#subirArchivo4_2').show();
	$('#evidenciaLink4_2').attr('href', '');							
	$("#evidenciaRutaLink4_2").val('');
});

$('button.subirArchivo4_3').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo4_3");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-4_3-"
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
				$('#EliminarArchivo4_3').removeAttr("disabled");
				$('#EliminarArchivo4_3').show();
				$('#subirArchivo4_3').hide();
				$('#evidenciaLink4_3').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo4_3').val());							
				$("#evidenciaRutaLink4_3").val($('#rutaArchivo4_3').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo4_3').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo4_3").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo4_3");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo4_3').removeAttr("disabled");
	$('#evidencia4_3').val('');
	$('#EliminarArchivo4_3').hide();
	$('#subirArchivo4_3').show();
	$('#evidenciaLink4_3').attr('href', '');							
	$("#evidenciaRutaLink4_3").val('');
});

$('button.subirArchivo4_4').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo4_4");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-4_4-"
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
				$('#EliminarArchivo4_4').removeAttr("disabled");
				$('#EliminarArchivo4_4').show();
				$('#subirArchivo4_4').hide();
				$('#evidenciaLink4_4').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo4_4').val());							
				$("#evidenciaRutaLink4_4").val($('#rutaArchivo4_4').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo4_4').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo4_4").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo4_4");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo4_4').removeAttr("disabled");
	$('#evidencia4_4').val('');
	$('#EliminarArchivo4_4').hide();
	$('#subirArchivo4_4').show();
	$('#evidenciaLink4_4').attr('href', '');							
	$("#evidenciaRutaLink4_4").val('');
});


$('button.subirArchivo5').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo5");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-5-"
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
				$('#EliminarArchivo5').removeAttr("disabled");
				$('#EliminarArchivo5').show();
				$('#subirArchivo5').hide();
				$('#evidenciaLink5').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo5').val());							
				$("#evidenciaRutaLink5").val($('#rutaArchivo5').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo5').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo5").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo5");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo5').removeAttr("disabled");
	$('#evidencia5').val('');
	$('#EliminarArchivo5').hide();
	$('#subirArchivo5').show();
	$('#evidenciaLink5').attr('href', '');							
	$("#evidenciaRutaLink5").val('');
});


$('button.subirArchivo6').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo6");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-6-"
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
				$('#EliminarArchivo6').removeAttr("disabled");
				$('#EliminarArchivo6').show();
				$('#subirArchivo6').hide();
				$('#evidenciaLink6').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo6').val());							
				$("#evidenciaRutaLink6").val($('#rutaArchivo6').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo6').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo6").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo6");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo6').removeAttr("disabled");
	$('#evidencia6').val('');
	$('#EliminarArchivo6').hide();
	$('#subirArchivo6').show();
	$('#evidenciaLink6').attr('href', '');							
	$("#evidenciaRutaLink6").val('');
});

$('button.subirArchivo6_1').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo6_1");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-6_1-"
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
				$('#EliminarArchivo6_1').removeAttr("disabled");
				$('#EliminarArchivo6_1').show();
				$('#subirArchivo6_1').hide();
				$('#evidenciaLink6_1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo6_1').val());							
				$("#evidenciaRutaLink6").val($('#rutaArchivo6_1').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo6_1').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo6_1").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo6_1");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo6_1').removeAttr("disabled");
	$('#evidencia6_1').val('');
	$('#EliminarArchivo6_1').hide();
	$('#subirArchivo6_1').show();
	$('#evidenciaLink6_1').attr('href', '');							
	$("#evidenciaRutaLink6_1").val('');
});


$('button.subirArchivo7').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo7");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-7-"
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
				$('#EliminarArchivo7').removeAttr("disabled");
				$('#EliminarArchivo7').show();
				$('#subirArchivo7').hide();
				$('#evidenciaLink7').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo7').val());							
				$("#evidenciaRutaLink7").val($('#rutaArchivo7').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo7').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo7").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo7");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo7').removeAttr("disabled");
	$('#evidencia7').val('');
	$('#EliminarArchivo7').hide();
	$('#subirArchivo7').show();
	$('#evidenciaLink7').attr('href', '');							
	$("#evidenciaRutaLink7").val('');
});

$('button.subirArchivo8').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo8");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-8-"
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
				$('#EliminarArchivo8').removeAttr("disabled");
				$('#EliminarArchivo8').show();
				$('#subirArchivo8').hide();
				$('#evidenciaLink8').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo8').val());							
				$("#evidenciaRutaLink8").val($('#rutaArchivo8').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo8').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo8").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo8");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo8').removeAttr("disabled");
	$('#evidencia8').val('');
	$('#EliminarArchivo8').hide();
	$('#subirArchivo8').show();
	$('#evidenciaLink8').attr('href', '');							
	$("#evidenciaRutaLink8").val('');
});




$('button.subirArchivo9').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo9");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-9-"
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
				$('#EliminarArchivo9').removeAttr("disabled");
				$('#EliminarArchivo9').show();
				$('#subirArchivo9').hide();
				$('#evidenciaLink9').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo9').val());							
				$("#evidenciaRutaLink9").val($('#rutaArchivo9').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo9').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo9").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo9");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo9').removeAttr("disabled");
	$('#evidencia9').val('');
	$('#EliminarArchivo9').hide();
	$('#subirArchivo9').show();
	$('#evidenciaLink9').attr('href', '');							
	$("#evidenciaRutaLink9").val('');
});

$('button.subirArchivo10').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(
					".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo10");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(
					".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable")
					.val()
					+ "_evidencia-10-"
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
				$('#EliminarArchivo10').removeAttr("disabled");
				$('#EliminarArchivo10').show();
				$('#subirArchivo10').hide();
				$('#evidenciaLink10').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo10').val());							
				$("#evidenciaRutaLink10").val($('#rutaArchivo10').val());

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo10').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(
			".estadoCarga");
	var archivourl = $("#rutaArchivo8").val();
	var rutaArchivo = boton.parent('div').parent('div').find(
			".rutaArchivo10");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo10').removeAttr("disabled");
	$('#evidencia10').val('');
	$('#EliminarArchivo10').hide();
	$('#subirArchivo10').show();
	$('#evidenciaLink10').attr('href', '');							
	$("#evidenciaRutaLink10").val('');
});


	$("#btnGuardar")
			.click(
					function(event) {
						var form = $("#formularioEvaluacion")
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

	function adjuntarEvidencia(select,div) {
		HiddeFileDiv(select,div);
	}
	//funcion para ocultar cargar archivo SOLO SI los 5 SELECT de politica de igualdad COINCIDEN
	function adjuntarEvidenciaMultiple(divName) {
		var cmbPregunta17 = $("#cmbPregunta17").val(); 
		var cmbPregunta18 = $("#cmbPregunta18").val(); 
		var cmbPregunta19 = $("#cmbPregunta19").val(); 
		var cmbPregunta20 = $("#cmbPregunta20").val(); 
		var cmbPregunta21 = $("#cmbPregunta21").val(); 
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ( (cmbPregunta17 == "4. VACÍO" || cmbPregunta17 == "3. REPORTA NO") && (cmbPregunta18 == "4. VACÍO" || cmbPregunta18 == "3. REPORTA NO") && (cmbPregunta19 == "4. VACÍO" || cmbPregunta19 == "3. REPORTA NO") && (cmbPregunta20 == "4. VACÍO" || cmbPregunta20 == "3. REPORTA NO") && (cmbPregunta21 == "4. VACÍO" || cmbPregunta21 == "3. REPORTA NO") ){
			$("#"+divId).hide();
			$("#"+elements).removeAttr("required");
				
		} else {
			$("#"+divId).show();
			$("#"+elements).attr("required", "required");
		}
	}
	
	function adjuntarEvidenciaMultiple2(divName) {
		var cmbPregunta6 = $("#cmbPregunta6").val(); 
		var cmbPregunta7 = $("#cmbPregunta7").val(); 
		var cmbPregunta8 = $("#cmbPregunta8").val(); 
		var cmbPregunta9 = $("#cmbPregunta9").val(); 
		var cmbPregunta10 = $("#cmbPregunta10").val(); 
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ( (cmbPregunta6 == ". VACÍO" || cmbPregunta6 == ". NO APLICA") && (cmbPregunta7 == ". VACÍO" || cmbPregunta7 == ". NO APLICA") && (cmbPregunta8 == ". VACÍO" || cmbPregunta8 == ". NO APLICA") && (cmbPregunta9 == ". VACÍO" || cmbPregunta9 == ". NO APLICA") && (cmbPregunta10 == ". VACÍO" || cmbPregunta10 == ". NO APLICA") ){
			$("#"+divId).hide();
			$("#"+elements).removeAttr("required");
				
		} else {
			$("#"+divId).show();
			$("#"+elements).attr("required", "required");
		}
	}
	function adjuntarEvidenciaDoble(divName) {
		var cmbPregunta4 = $("#cmbPregunta4").val(); 
		var cmbPregunta5 = $("#cmbPregunta5").val(); 
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ( (cmbPregunta4 == "8. VACÍO" || cmbPregunta4 == "6. NO APLICA") && (cmbPregunta5 == "8. VACÍO" || cmbPregunta5 == "6. NO APLICA")){
			$("#"+divId).hide();
			$("#"+elements).removeAttr("required");
				
		} else {
			$("#"+divId).show();
			$("#"+elements).attr("required", "required");
		}
		
	}
	
	

	function obtenerdatosPreguntas() {
		const parametros = {"infCod" : $("#infcod").val() };
		$.ajax({
			url : 'ObtenerPreguntas',
			headers : {	"X-CSRF-TOKEN" : csrfToken},
			type : "GET",
			dataType : 'json',
			data : parametros,
			success : function(result) {
				if(result.data.length==21){
					console.log("Mostrar botón");
					console.log("Datos recibidos:", result.data);
					$("#btnGuardarP12").show();
				}else{
					console.log("Ocultar botón");
					console.log("Datos recibidos:", result.data);
					$("#btnGuardarP12").hide();
				}
				$.each(result.data, function (i, op) {
					switch (op.pregunta) {
					case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
						$("#pre1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbpregunta1",op.respuesta);
					break;
					case'¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?':
						$("#pre2").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta2",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta2", "divevidencia1");					
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia1").hide();
							 $("#evidencia1").removeAttr("required");
							 $("#rutaArchivo1").val(op.evidencia);
							 $('#evidenciaLink1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink1").val(op.evidencia);
						 }							
						
					break;	
					case '¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':						
						$("#pre3").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta3",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta3", "divevidencia2");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia2").hide();
							 $("#evidencia2").removeAttr("required");
							 $("#rutaArchivo2").val(op.evidencia);
							 $('#evidenciaLink2').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink2").val(op.evidencia);	
						 }	
					break;
					case '¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?':						
						$("#pre4").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta4",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta4", "divevidencia3");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia3").hide();
							 $("#evidencia3").removeAttr("required");
							 $("#rutaArchivo3").val(op.evidencia);
							 $('#evidenciaLink3').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink3").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?':						
						$("#pre4_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta5",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta5", "divevidencia3_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia3_1").hide();
							 $("#evidencia3_1").removeAttr("required");
							 $("#rutaArchivo3_1").val(op.evidencia);
							 $('#evidenciaLink3_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink3_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?':						
						$("#pre5").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta6",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta6", "divevidencia4");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia4").hide();
							 $("#evidencia4").removeAttr("required");
							 $("#rutaArchivo4").val(op.evidencia);
							 $('#evidenciaLink4').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?':						
						$("#pre5_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta7",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta7", "divevidencia4_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){
							 $("#divevidencia4_1").hide();
							 $("#evidencia4_1").removeAttr("required");
							 $("#rutaArchivo4_1").val(op.evidencia);
							 $('#evidenciaLink4_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?':						
						$("#pre5_2").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta8",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta8", "divevidencia4_2");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia4_2").hide();
							 $("#evidencia4_2").removeAttr("required");
							 $("#rutaArchivo4_2").val(op.evidencia);
							 $('#evidenciaLink4_2').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4_2").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?':						
						$("#pre5_3").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta9",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta9", "divevidencia4_3");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia4_3").hide();
							 $("#evidencia4_3").removeAttr("required");
							 $("#rutaArchivo4_3").val(op.evidencia);
							 $('#evidenciaLink4_3').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4_3").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?':						
						$("#pre5_4").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta10",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta10", "divevidencia4_4");	
						 
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia4_4").hide();
							 $("#evidencia4_4").removeAttr("required");
							 $("#rutaArchivo4_4").val(op.evidencia);
							 $('#evidenciaLink4_4').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4_4").val(op.evidencia);
						 }
					break;
					case '¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?':						
						$("#pre6").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta11",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta11", "divevidencia5");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia5").hide();
							 $("#evidencia5").removeAttr("required");
							 $("#rutaArchivo5").val(op.evidencia);
							 $('#evidenciaLink5').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink5").val(op.evidencia);							 
						 }	
					break;
					
					case '¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?':						
						$("#pre7").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta12",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta12", "divevidencia6");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia6").hide();
							 $("#evidencia6").removeAttr("required");
							 $("#rutaArchivo6").val(op.evidencia);
							 $('#evidenciaLink6').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink6").val(op.evidencia);							 
						 }	
					break;
					case '¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?':						
						$("#pre7_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta13",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta13", "divevidencia6_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia6_1").hide();
							 $("#evidencia6_1").removeAttr("required");
							 $("#rutaArchivo6_1").val(op.evidencia);
							 $('#evidenciaLink6_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink6_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?':						
						$("#pre8").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta14",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta14", "divevidencia7");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia7").hide();
							 $("#evidencia7").removeAttr("required");
							 $("#rutaArchivo7").val(op.evidencia);
							 $('#evidenciaLink7').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink7").val(op.evidencia);							 
						 }	
					break;
					case '¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?':						
						$("#pre9").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta15",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta15", "divevidencia8");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){	
							 $("#divevidencia8").hide();
							 $("#evidencia8").removeAttr("required");
							 $("#rutaArchivo8").val(op.evidencia);
							 $('#evidenciaLink8').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink8").val(op.evidencia);							 
						 }	
					break;
					case '¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':						
						$("#pre10").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta16",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta16", "divevidencia9");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){		
							 $("#divevidencia9").hide();
							 $("#evidencia9").removeAttr("required");
							 $("#rutaArchivo9").val(op.evidencia);
							 $('#evidenciaLink9').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink9").val(op.evidencia);							 
						 }	
					break;
					
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?':						
						$("#pre11").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta17",op.respuesta);	

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?':						
						$("#pre11_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta18",op.respuesta);	

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?':						
						$("#pre11_2").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta19",op.respuesta);	

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?':						
						$("#pre11_3").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta20",op.respuesta);	

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?':						
						$("#pre11_4").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta21",op.respuesta);	

					break;
					

					default:
						break;
					}
				
				});			
			},
			error : function(result) {		
				mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");

			}
		});

	}
	


//////////////////////////////// eliminar archivos 
	
		$('#EliminarArchiServer1').click(function(event) {	
		var archivourl = $("#evidenciaRutaLink1").val();
		EliminarArchivo(archivourl, '', '', '');		
		$('#evidenciaLink1').attr('href', '');							
		$("#evidenciaRutaLink1").val('');
		
	});
	
	
		$('#EliminarArchiServer2').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink2").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink2').attr('href', '');							
			$("#evidenciaRutaLink2").val('');
			
		});
		
		$('#EliminarArchiServer3').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink3").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink3').attr('href', '');							
			$("#evidenciaRutaLink3").val('');
			
		});
		
		$('#EliminarArchiServer3_1').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink3_1").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink3_1').attr('href', '');							
			$("#evidenciaRutaLink3_1").val('');
			
		});
		
		$('#EliminarArchiServer4').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink4").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink4').attr('href', '');							
			$("#evidenciaRutaLink4").val('');
			
		});
		
		$('#EliminarArchiServer4_1').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink4_1").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink4_1').attr('href', '');							
			$("#evidenciaRutaLink4_1").val('');
			
		});
		
		$('#EliminarArchiServer4_2').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink4_2").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink4_2').attr('href', '');							
			$("#evidenciaRutaLink4_2").val('');
			
		});
		$('#EliminarArchiServer4_3').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink4_3").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink4_3').attr('href', '');							
			$("#evidenciaRutaLink4_3").val('');
			
		});
		$('#EliminarArchiServer4_4').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink4_4").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink4_4').attr('href', '');							
			$("#evidenciaRutaLink4_4").val('');
			
		});
		
		$('#EliminarArchiServer5').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink5").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink5').attr('href', '');							
			$("#evidenciaRutaLink5").val('');
			
		});
		
		$('#EliminarArchiServer6').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink6").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink6').attr('href', '');							
			$("#evidenciaRutaLink6").val('');
			
		});
		
		$('#EliminarArchiServer6_1').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink6_1").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink6_1').attr('href', '');							
			$("#evidenciaRutaLink6_1").val('');
			
		});
		
		$('#EliminarArchiServer7').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink7").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink7').attr('href', '');							
			$("#evidenciaRutaLink7").val('');
			
		});
		
		$('#EliminarArchiServer8').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink8").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink8').attr('href', '');							
			$("#evidenciaRutaLink8").val('');
			
		});
		
		$('#EliminarArchiServer9').click(function(event) {	
			var archivourl = $("#evidenciaRutaLink9").val();
			EliminarArchivo(archivourl, '', '', '');		
			$('#evidenciaLink9').attr('href', '');							
			$("#evidenciaRutaLink9").val('');
			
		});
		
		
		
		
		
////////////////////////////////eliminar archivos 
	
</script>
