<%-- 
	version		: 1.0
	Document  	: valoracionInformeMedio
	Property   	: CPCCS
	Author		: Carlos Morocho
	Mail		: carlosmorcho339@gmail.com
    Date		: 20/09/2022
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

<div class="card text-center mb-card15">

	<div class="card-body">	
	<input type="hidden" name="codigo" id="codigo" value="">		
	<input type="hidden" name="codigo1" id="codigo1" value="">		
		<div class="col-lg-12">
			<br />
			<div class="tabs-container">
				<ul class="nav nav-tabs nav-pills">
					<li class="nav-item "><a class="nav-link active" data-toggle="pill" href="#menu1">Matriz 1</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu2">Matriz 2</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu3">Matriz 3</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu4">Matriz 4</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu5">Matriz 5</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu12">Matriz 6</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu13">Matriz 7</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu6">Matriz 8</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu7">Matriz 9</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu8">Matriz 10</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu9">Matriz 11</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu10">Matriz 12</a></li>
					<li class="nav-item "><a class="nav-link " data-toggle="pill" href="#menu11">Matriz 13</a></li>
				</ul>
				<div class="tab-content">
					<div id="menu1" class="tab-pane container active">
						<div class="panel-body">
							<br />
					<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario1"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP1" data-destino="detalleItem"
								data-accionEnExito="">	
								
						<input type="hidden" name="pre1" id="pre1" value="">		
				        <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						<input type="hidden" name="infcod" id="infcod" value="${infcod}">
						<input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
																	
									<div class="card">
										<h5 class="card-header text-white carHeaderBlue">Datos de
											la institución</h5>
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
														id="identificadorInstitucion" name="Institucion" disabled
														value="${identificadorInstitucion}" />
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
													<label for="representanteLegal">Representante
														Legal:</label>
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
													<label for="pregunta1">¿EL MEDIO PRESENTÓ SU
														INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO
														CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?</label>
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
					</div>
					<div id="menu2" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
								CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>

							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario2"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP2" data-destino="detalleItem"
								data-accionEnExito="">
								
					    <input type="hidden" name="pre2" id="pre2" value="">
				        <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						<input type="hidden" name="infcod" id="infcod" value="${infcod}">
						<input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								<table id="tablaRegistrosProcesosContratacion"
									class="table table-striped table-bordered"
									style="width: 100% !important;">
									<thead>
										<tr>
											<th style="text-align: center; font-size: x-small;">#</th>
											<th style="text-align: center; font-size: x-small;">TIPO
												DE CONTRATACIÓN</th>
											<th style="text-align: center; font-size: x-small;">ESTADO
												ACTUAL</th>
											<th style="text-align: center; font-size: x-small;">LINK
												AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG. WEB DE LA
												INSTITUCIÓN</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>

								<div class="form-group row">
									<div class="col-md-9 text-left">
										<label for="pregunta2">¿EL MEDIO SUSTENTA LA EJECUCIÓN
											DE SUS CONTRATACIONES PÚBLICAS?</label>
									</div>
									<div class="col-md-3 text-left">
										<select class="custom-select custom-select-sm"
											onchange="adjuntarEvidencia(this, divevidencia1);"
											id="cmbPregunta2" required="required" name="cmbPregunta2">
											<option value="">Seleccione...</option>
											<option
												value="1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP">1.
												PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN
												PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP</option>
											<option
												value="2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS">2.
												LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS
												DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS</option>
											<option
												value="3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN">3.
												PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN</option>
											<option
												value="4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)">4.
												PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)</option>
											<option
												value="5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA">5.
												LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS
												DE CONTRATACIÓN PÚBLICA</option>
											<option
												value="6. PRIVADO Y COMUNITARIO: INFORME DE EJECUCIÓN DE CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE">6.
												PRIVADO Y COMUNITARIO: INFORME DE EJECUCIÓN DE
												CONTRATACIONES PÚBLICAS APROBADO POR AUTORIDAD COMPETENTE</option>
											<option value="7. NO ABRE EL LINK">7. NO ABRE EL
												LINK</option>
											<option
												value="8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">8.
												EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
											<option value="9. RESPONDE EN 0">9. RESPONDE EN O</option>
											<option value="10. OTROS, NO CUMPLE">10. OTROS, NO
												CUMPLE</option>
											<option value="11. VACÍO">11. VACÍO</option>
										</select>
										<div class="invalid-feedback">Por favor seleccione la
											respuesta</div>
									</div>
								</div>
								<div id="divevidencia1" style="display: visible">
									<div class="form-group row">
										<div class="col-md-3 text-left">
											<label for="evidencia1">Adjuntar captura de pantalla
												de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf,
												.doc, .docx</label>
										</div>
										<div class="col-md-5 text-left waves-effect float-left">
											<input type="file" required="required"
												class="form-control-file archivo gris" id="evidencia1"
												name="evidencia1"
												accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

											<div class="estadoCarga">En espera de archivo...
												(Tamaño máximo ${tamanioArchivo})</div>
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
					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP2"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
					</form:form>

						</div>
					</div>
					<!-- panel informes veedores -->
					<div id="menu3" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario3"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP3" data-destino="detalleItem"
								data-accionEnExito="">
								  <input type="hidden" name="pre3" id="pre3" value="">
								  <input type="hidden" name="pre3_1" id="pre3_1" value="">
				        		  <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								  <input type="hidden" name="infcod" id="infcod" value="${infcod}">
								  <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								
								<div class="card">
									<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
										DE OBLIGACIONES TRIBUTARIAS Y LABORALES</h5>
									<div class="card-body">

										<table id="tablaRegistrosObligacionesTributariasLaborales"
											class="table table-striped table-bordered"
											style="width: 100%">
											<thead>

												<tr>
													<th>#</th>
													<th style="text-align: center; font-size: x-small;">LABORALES</th>
													<th style="text-align: center; font-size: x-small;">TRIBUTARIAS</th>
													<th style="text-align: center; font-size: x-small;">LINK
														AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
														INSTITUCIÓN</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
										<hr />

										<div class="form-group row">
											<div class="col-md-9 text-left">
												<label for="pregunta3">¿EL MEDIO JUSTIFICA EL
													CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?</label>
											</div>
											<div class="col-md-3 text-left">
												<!--  onchange="adjuntarEvidenciaDoble1(divevidencia2);"-->
												<select class="custom-select custom-select-sm"												
													onchange="adjuntarEvidencia(this, divevidencia2);"												
													id="cmbPregunta3" required="required" name="cmbPregunta3">
													<option value="">Seleccione...</option>
													<option
														value="1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI">1.
														CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI</option>
													<option value="2. NO ABRE EL LINK">2. NO ABRE EL
														LINK</option>
													<option
														value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3.
														EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
													<option value="4. NO APLICA">4. NO APLICA</option>
													<option value="5. OTROS, NO CUMPLE">5. OTROS, NO
														CUMPLE</option>
													<option value="6. VACÍO">6. VACÍO</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													respuesta</div>
											</div>
										</div>
										
										<div id="divevidencia2" style="display: visible">
											<div class="form-group row">
												<div class="col-md-3 text-left">
													<label for="evidencia2">Adjuntar captura de
														pantalla de la matriz evaluada: Formato .jpeg, .jpg, .png,
														.pdf, .doc, .docx</label>
												</div>
												<div class="col-md-5 text-left waves-effect float-left">
													<input type="file" required="required"
														class="form-control-file archivo gris" id="evidencia2"
														name="evidencia2"
														accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

													<div class="estadoCarga">En espera de archivo...
														(Tamaño máximo ${tamanioArchivo})</div>
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
										
										
									<div id="VerArchivoEvdidencia2" class="form-group row">
											<div class="col-md-3 text-left">
													<label for="linkEvidencia2">Archivo de Verificación </label>
											</div>
											<div class="col-md-3 text-left">
												 <a id="evidenciaLink2"  target="_blank"
											  class="archivoCargado">Click aquí para ver archivo</a>
									        <input type="hidden" name="evidenciaRutaLink2" id="evidenciaRutaLink2" value="">
									</div>
									<div class="col-md-3 text-left">
										<button type="button" class="adjunto btn _eliminarColor btn-sm"
										id="EliminarArchiServer2">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>
									
									</div>				
										
										<div class="form-group row">
											<div class="col-md-9 text-left">
												<label for="pregunta4">¿EL MEDIO JUSTIFICA EL
													CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?</label>
											</div>
											<div class="col-md-3 text-left">
											<!--  adjuntarEvidenciaDoble1(divevidencia2);"-->
												<select class="custom-select custom-select-sm"
													onchange="adjuntarEvidencia(this, divevidencia2_1);"
													id="cmbPregunta4" required="required" name="cmbPregunta4">
													<option value="">Seleccione...</option>
													<option
														value="1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS">1.
														CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS</option>
													<option value="2. NO ABRE EL LINK">2. NO ABRE EL
														LINK</option>
													<option
														value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3.
														EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
													<option value="4. NO APLICA">4. NO APLICA</option>
													<option value="5. OTROS, NO CUMPLE">5. OTROS, NO
														CUMPLE</option>
													<option value="6. VACÍO">6. VACÍO</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													respuesta</div>
											</div>
										</div>
										<!-- ver -->
										
										
										<div id="divevidencia2_1" style="display: visible">
											<div class="form-group row">
												<div class="col-md-3 text-left">
													<label for="evidencia2_1">Adjuntar captura de
														pantalla de la matriz evaluada: Formato .jpeg, .jpg, .png,
														.pdf, .doc, .docx</label>
												</div>
												<div class="col-md-5 text-left waves-effect float-left">
													<input type="file" required="required"
														class="form-control-file archivo gris" id="evidencia2_1"
														name="evidencia2_1"
														accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

													<div class="estadoCarga">En espera de archivo...
														(Tamaño máximo ${tamanioArchivo})</div>
													<input type="hidden" class="rutaArchivo2_1" id="rutaArchivo2_1"
														name="rutaArchivo2_1" value="" />
													<div class="invalid-feedback">Por favor seleccione un
														archivo</div>
												</div>

												<div class="col-md-3 text-left">
													<button type="button" id="subirArchivo2_1"
														class="subirArchivo2_1 adjunto btn _nuevoColor btn-sm"
														data-rutaCarga="${rutaModuloRetroalimentacion}">
														<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
														archivo
													</button>

													<button type="button"
														class="EliminarArchivo2_1 adjunto btn _eliminarColor btn-sm Oculta"
														id="EliminarArchivo2_1" disabled="disabled">
														<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
													</button>
												</div>

											</div>
										</div>
										
										<div id="VerArchivoEvdidencia2_1" class="form-group row">
											<div class="col-md-3 text-left">
													<label for="linkEvidencia2_1">Archivo de Verificación </label>
											</div>
											<div class="col-md-3 text-left">
												 <a id="evidenciaLink2_1"  target="_blank"
											  class="archivoCargado" >Click aquí para ver archivo</a>
									        <input type="hidden" name="evidenciaRutaLink2_1" id="evidenciaRutaLink2_1" value="">
									</div>
									<div class="col-md-3 text-left">
										<button type="button" class="adjunto btn _eliminarColor btn-sm"
										id="EliminarArchiServer2_1">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>
									
									</div>				
										
										<!-- -->
										
									</div>
								</div>
					 <div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP3"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
			</form:form>


						</div>
					</div>
					<!-- panel informes Tecnicos -->
					<div id="menu4" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario4"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP4" data-destino="detalleItem"
								data-accionEnExito="">
								 <input type="hidden" name="pre4" id="pre4" value="">
				        		  <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								  <input type="hidden" name="infcod" id="infcod" value="${infcod}">
								  <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
						
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
									<label for="pregunta5">¿EL MEDIO SUSTENTA LA EJECUCIÓN
										DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia3);"
										id="cmbPregunta5" required="required" name="cmbPregunta5">
										<option value="">Seleccione...</option>
										<option
											value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">1.
											ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
										<option
											value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS">2.
											INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO
											IMPLEMENTADO Y REGISTRO DE ASISTENCIAS</option>
										<option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3.
											ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia3" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia3">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia3"
											name="evidencia3"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
							
					<div id="VerArchivoEvdidencia3" class="form-group row">
					<div class="col-md-3 text-left">
					<label for="linkEvidencia3">Archivo de Verificación </label>
					</div>
					<div class="col-md-3 text-left">
					   <a id="evidenciaLink3"  target="_blank"
					     class="archivoCargado" id="archivoCargado">Click aquí para ver archivo</a>
					        <input type="hidden" name="evidenciaRutaLink3" id="evidenciaRutaLink3" value="">
					</div>
					<div class="col-md-3 text-left">
						<button type="button" class="adjunto btn _eliminarColor btn-sm"
						id="EliminarArchiServer3">
						<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
						</button>
					</div>
					
					</div>		
						</div>
						
						<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP4"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
			</form:form>



						</div>
					</div>
					<!-- panel informes Tecnicos -->
					<div id="menu5" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario5"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP5" data-destino="detalleItem"
								data-accionEnExito="">
								<input type="hidden" name="pre5" id="pre5" value="">
								  <input type="hidden" name="pre5_1" id="pre5_1" value="">
				        		  <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								  <input type="hidden" name="infcod" id="infcod" value="${infcod}">
								  <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								  <h5 class="card-header text-white carHeaderBlue">PROCESO DE
								  RENDICIÓN DE CUENTAS</h5>
								  	<div class="card-body">
								  	<table id="TablaRendicionFases"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th style="font-size: xx-small;">#</th>
										<th style="font-size: xx-small;">FASE</th>
										<th style="font-size: xx-small;">PROCESO DE RENDICIÓN DE CUENTAS</th>
										<th style="font-size: xx-small;">PONGA SI O NO</th>
										<th style="font-size: xx-small;">DESCRIBA LA EJECUCIÓN DE LOS PASOS</th>
										<th style="font-size: xx-small;">LINK AL MEDIO DE VERIFICACIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<table id="TablaRendicionFasesAporte"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
								</thead>
								<tbody>
								</tbody>
							</table>						  	
								<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6">¿EL MEDIO SUSTENTA LA EJECUCIÓN
										DEL ESPACIO DELIBERATIVO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia4);"
										id="cmbPregunta6" required="required" name="cmbPregunta6">
										<option value="">Seleccione...</option>
										<option
											value="1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ">1.
											LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE
											DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ</option>
										<option
											value="2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS">2.
											ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO
											DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS</option>
										<option
											value="3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ">3.
											LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE
											DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="5. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>  	
								<div id="divevidencia4" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia4">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia4"
											name="evidencia4"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
											class="EliminarArchivo4 adjunto btn _eliminarColor btn-sm Oculta"
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
								<button type="button" class="adjunto btn _eliminarColor btn-sm"
								id="EliminarArchiServer4">
								<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
								</button>
							</div>
							
							</div>	
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7">¿EL MEDIO SUSTENTA LA GENERACIÓN
										DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia4_1);"
										id="cmbPregunta7" required="required" name="cmbPregunta7">
										<option value="">Seleccione...</option>
										<option
											value="1. ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO">1.
											ACTA DE REALIZACIÓN DEL EVENTO QUE CONTENGA LOS APORTES
											CIUDADANOS QUE SE GENERARON EN ESE ESPACIO</option>
										<option
											value="2. ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS">2.
											ACTA DE REALIZACIÓN DEL EVENTO QUE RECONOCE QUE NO HUBIERON
											APORTES/ACUERDOS</option>
										<option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
										<option
											value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="5. NO APLICA">5. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">6. OTROS, NO
											CUMPLE</option>
										<option value="7. VACÍO">7. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>	 
							<div id="divevidencia4_1" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia4_1">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia4_1"
											name="evidencia4_1"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
							     class="archivoCargado">Click aquí para ver archivo</a>
							        <input type="hidden" name="evidenciaRutaLink4_1" id="evidenciaRutaLink4_1" value="">
							</div>
							<div class="col-md-3 text-left">
								<button type="button" class="adjunto btn _eliminarColor btn-sm"
								id="EliminarArchiServer4_1">
								<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
								</button>
							</div>
							
							</div>		
							<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP5"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div> 	
								  	
								  	</div>
						</form:form>
							
						</div>
					</div>
					<div id="menu6" class="tab-pane container fade">
						<div class="panel-body">
							<br />
						<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario6"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP6" data-destino="detalleItem"
								data-accionEnExito="">
								<input type="hidden" name="pre6" id="pre6" value="">
								  <input type="hidden" name="pre6_1" id="pre6_1" value="">
				        		  <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								  <input type="hidden" name="infcod" id="infcod" value="${infcod}">
								  <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
						<h5 class="card-header text-white carHeaderBlue">PROYECTO COMUNICACIONAL</h5>
						<div class="card-body">
							<table id="tablaRegistrosPC"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th width="50%"
											style="text-align: center; font-size: x-small;"></th>
										<th width="10%"
											style="text-align: center; font-size: x-small;"></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						<h5 class="card-header text-white carHeaderCeleste3">PROMOCIÓN DE DERECHOS</h5>	
						<table id="tablaRegistrosPCPromoDerechos"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
								<th></th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">PARÁMETROS DEL PLAN DE COMUNICACIÓN</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
												<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">FRECUENCIA</th>
												<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
												<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
												<th scope="col" class="tablaingreso" width="30%"
											style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>

								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<h5 class="card-header text-white carHeaderCeleste3">PARTICIPACIÓN</h5>	
						<table id="tablaRegistrosPCParticipacion"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
								<th></th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">PARÁMETROS DEL PLAN DE COMUNICACIÓN</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
												<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">FRECUENCIA</th>
												<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
												<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
												<th scope="col" class="tablaingreso" width="30%"
											style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>

								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<h5 class="card-header text-white carHeaderCeleste3">DIÁLOGO</h5>	
						<table id="tablaRegistrosPCDialogo"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
								<th></th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
										<th scope="col" class="tablaingreso" width="7%"
											style="text-align: center; font-size: x-small;">PARÁMETROS DEL PLAN DE COMUNICACIÓN</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
												<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">FRECUENCIA</th>
												<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
												<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
												<th scope="col" class="tablaingreso" width="30%"
											style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>

								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
							
						<hr/>	
							
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta10">¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia6);"
										id="cmbPregunta10" required="required" name="cmbPregunta10">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia6" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia6">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia6"
											name="evidencia6"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
					     class="archivoCargado">Click aquí para ver archivo</a>
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
									<label for="pregunta11">¿EL MEDIO SUSTENTA SU
										PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia6_1);"
										id="cmbPregunta11" required="required" name="cmbPregunta11">
										<option value="">Seleccione...</option>
										<option
											value="1. EN PROMOCIÓN DE DERECHOS REPORTA SI EN DISCAPACIDADES E INTERCULTURAL">1.
											EN PROMOCIÓN DE DERECHOS REPORTA SI EN DISCAPACIDADES E
											INTERCULTURAL</option>
										<option
											value="2. EN PROMOCIÓN DE DERECHOS REPORTA SI SÓLO EN DISCAPACIDADES O INTERCULTURAL">2.
											EN PROMOCIÓN DE DERECHOS REPORTA SI SÓLO EN DISCAPACIDADES O
											INTERCULTURAL</option>
										<option
											value="3. EN PROMOCIÓN DE DERECHOS REPORTA SI EN INTERGENERACIONAL, GENERO O MOVILIDAD HUMANA">3.
											EN PROMOCIÓN DE DERECHOS REPORTA SI EN INTERGENERACIONAL,
											GENERO O MOVILIDAD HUMANA</option>
										<option value="4. REPORTA SI EN PARTICIPACIÓN O DIÁLOGO">4.
											REPORTA SI EN PARTICIPACIÓN O DIÁLOGO</option>
										<option value="5. VARIAS DE LAS OPCIONES ANTERIORES">5.
											VARIAS DE LAS OPCIONES ANTERIORES</option>
										<option value="6. NO ABRE EL LINK">6. NO ABRE EL LINK</option>
										<option
											value="7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">7.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="8. NO APLICA">8. NO APLICA</option>
										<option value="9. OTROS, NO CUMPLE">9. OTROS, NO
											CUMPLE</option>
										<option value="10. VACÍO">10. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia6_1" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia6_1">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia6_1"
											name="evidencia6_1"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
					     class="archivoCargado">Click aquí para ver archivo</a>
					        <input type="hidden" name="evidenciaRutaLink6_1" id="evidenciaRutaLink6_1" value="">
					</div>
					<div class="col-md-3 text-left">
						<button type="button" class="adjunto btn _eliminarColor btn-sm"
						id="EliminarArchiServer6_1">
						<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
						</button>
					</div>
					
					</div>
					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP6"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
							
						</div>
					</form:form>
							
							

						</div>
					</div>
					<div id="menu7" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario7"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP7" data-destino="detalleItem"
								data-accionEnExito="">
								<input type="hidden" name="pre7" id="pre7" value="">
				        		<input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								<input type="hidden" name="infcod" id="infcod" value="${infcod}">
								<input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								
						<h5 class="card-header text-white carHeaderBlue">TIPO DE
							DERECHOS DE AUTORES APROBADOS POR EL SENADI</h5>
						<div class="card-body">
							<table id="tablaRegistrosDA"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th></th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">TIPO DE
											DERECHOS DE AUTORES APROBADOS POR LA SENADI</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">NÚMERO
											DE DERECHOS POR TIPO</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">NÚMERO
											DE DERECHOS PAGADOS</th>
										<th scope="col" class="tablaingreso" width="40%"
											style="text-align: center; font-size: x-small;">LINK
											MEDIO DE VERIFICACIÓN</th>


									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta12">¿EL MEDIO SUSTENTA LOS PAGOS DE
										LOS DERECHOS DE AUTOR?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia7);"
										id="cmbPregunta12" required="required" name="cmbPregunta12">
										<option value="">Seleccione...</option>
										<option
											value="1. COMPROBANTE DE DERECHOS DE AUTOR REGISTRADOS POR EL MEDIO EN SENADI COMO PRODUCCIÓN MUSICAL, PRODUCCIÓN PERIODÍSTICA Y CONTENIDO PUBLICITARIO">1.
											COMPROBANTE DE DERECHOS DE AUTOR REGISTRADOS POR EL MEDIO EN
											SENADI COMO PRODUCCIÓN MUSICAL, PRODUCCIÓN PERIODÍSTICA Y
											CONTENIDO PUBLICITARIO</option>
										<option
											value="2. REGISTRO DE PAGOS REALIZADOS A LOS GREMIOS DE AUTORES DE DERECHOS DE AUTOR (SAYCE, SOPROFON Y OTROS) POR EL USO DE LAS CREACIONES USADAS POR EL MEDIO">2.
											REGISTRO DE PAGOS REALIZADOS A LOS GREMIOS DE AUTORES DE
											DERECHOS DE AUTOR (SAYCE, SOPROFON Y OTROS) POR EL USO DE LAS
											CREACIONES USADAS POR EL MEDIO</option>
										<option value="3. VARIAS DE LAS OPCIONES ANTERIORES">3.
											VARIAS DE LAS OPCIONES ANTERIORES</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia7" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia7">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia7"
											name="evidencia7"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
					     class="archivoCargado">Click aquí para ver archivo</a>
					        <input type="hidden" name="evidenciaRutaLink7" id="evidenciaRutaLink7" value="">
					</div>
					<div class="col-md-3 text-left">
						<button type="button" class="adjunto btn _eliminarColor btn-sm"
						id="EliminarArchiServer7">
						<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
						</button>
					</div>
					
					</div>	
					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP7"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
							
						</div>
					</form:form>

						</div>
					</div>
					<div id="menu8" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario8"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP8" data-destino="detalleItem"
								data-accionEnExito="">
								<input type="hidden" name="pre8" id="pre8" value="">
				        		  <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
								  <input type="hidden" name="infcod" id="infcod" value="${infcod}">
								  <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS
							PRODUCCIÓN AUDIOVISUAL NACIONAL</h5>
						<div class="card-body">
							<table id="TablaEspaciosProNacional"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS
											DE PRODUCCIÓN AUDIOVISUAL NACIONAL</th>
										<th style="font-size: x-small;">PORCENTAJE PROMEDIO
											SEMANAL</th>
										<th style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</th>
										<th style="font-size: x-small;">NOMBRE DEL PROGRAMA /
											ESPACIO</th>
										<th style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
								<tfoot>
									<tr>
										<th colspan="2" style="text-align: right">Total:</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta13">¿EL MEDIO SUSTENTA LOS ESPACIOS
										DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia8);"
										id="cmbPregunta13" required="required" name="cmbPregunta13">
										<option value="">Seleccione...</option>
										<option
											value="1. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR SI EL PRODUCTO ES PRODUCCIÓN NACIONAL">1.
											DOCUMENTO OFICIAL QUE PERMITE VERIFICAR SI EL PRODUCTO ES
											PRODUCCIÓN NACIONAL</option>
										<option
											value="2. DOCUMENTO OFICIAL QUE PERMITE VERIFICAR LA EXISTENCIA DEL PRODUCTO">2.
											DOCUMENTO OFICIAL QUE PERMITE VERIFICAR LA EXISTENCIA DEL
											PRODUCTO</option>
										<option value="3. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="5. NO APLICA">6. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="7. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
								<div id="divevidencia8" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia8">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia8"
											name="evidencia8"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
								     class="archivoCargado">Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink8" id="evidenciaRutaLink8" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer8">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
							
							</div>			
							<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP8"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>			
					</div>
					</form:form>

						</div>
					</div>
					<div id="menu9" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario9"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP9" data-destino="detalleItem"
								data-accionEnExito="">
								
						 <input type="hidden" name="pre9" id="pre9" value="">
				         <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
						 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">		
						
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS
							PRODUCCIÓN AUDIOVISUAL NACIONAL INDEPENDIENTE</h5>
						<div class="card-body">
							<table id="TablaEspaciosProIndependiente"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS
											DE PRODUCCIÓN AUDIOVISUAL INDEPENDIENTE</th>
										<th style="font-size: x-small;">PORCENTAJE PROMEDIO
											SEMANAL</th>
										<th style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</th>
										<th style="font-size: x-small;">NOMBRE DEL PROGRAMA /
											ESPACIO</th>
										<th style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
								<tfoot>
									<tr>
										<th colspan="2" style="text-align: right">Total:</th>
										<th></th>
									</tr>
								</tfoot>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14">¿EL MEDIO CUBRE EL PORCENTAJE
										DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										onchange="adjuntarEvidencia(this, divevidencia9);"
										id="cmbPregunta14" required="required" name="cmbPregunta14">
										<option value="">Seleccione...</option>
										<option
											value="1. LA PRODUCCIÓN NACIONAL INDEPENDIENTE SUMA UN TOTAL DE 10% O MÁS">1.
											LA PRODUCCIÓN NACIONAL INDEPENDIENTE SUMA UN TOTAL DE 10% O
											MÁS</option>
										<option value="2. ENTRE AMBOS TOTALES SUMAN 60% O MÁS">2.
											ENTRE AMBOS TOTALES SUMAN 60% O MÁS</option>
										<option
											value="3. LA PRODUCCIÓN NACIONAL SUMA UN TOTAL DE 60% O MÁS">3.
											LA PRODUCCIÓN NACIONAL SUMA UN TOTAL DE 60% O MÁS</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia9" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia9">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia9"
											name="evidencia9"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
								     class="archivoCargado">Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink9" id="evidenciaRutaLink9" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer9">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP9"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
							
							
						</div>
					</form:form>

						</div>
					</div>
					<div id="menu10" class="tab-pane container fade">
						<div class="panel-body">
							<br />
						<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario10"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP10" data-destino="detalleItem"
								data-accionEnExito="">
						<input type="hidden" name="pre10" id="pre10" value="">
				         <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
						 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">				
								
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
									<label for="pregunta15">¿EL MEDIO SUSTENTA LA
										REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- 									<select class="custom-select custom-select-sm"    onchange="adjuntarEvidencia(this, divevidencia11);"
 -->
									<select class="custom-select custom-select-sm"
										id="cmbPregunta15" required="required" name="cmbPregunta15">
										<option value="">Seleccione...</option>
										<option
											value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">1.
											ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
										<option
											value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE	ASISTENCIAS">2.
											INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO
											IMPLEMENTADO Y REGISTRO DE ASISTENCIAS</option>
										<option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3.
											ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
										<option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
										<option
											value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5.
											EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="6. NO APLICA">6. NO APLICA</option>
										<option value="7. OTROS, NO CUMPLE">7. OTROS, NO
											CUMPLE</option>
										<option value="8. VACÍO">8. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<%-- 							<div id="divevidencia11" style="display:visible">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia11">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" required="required"
										class="form-control-file archivo gris" id="evidencia11"
										name="evidencia11" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo11" id="rutaArchivo11"
										name="rutaArchivo11" value="" />
									<div class="invalid-feedback">Por favor seleccione un
										archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo11"
										class="subirArchivo11 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
										archivo
									</button>

									<button type="button"
										class="EliminarArchivo11 adjunto btn _eliminarColor btn-sm Oculta"
										id="EliminarArchivo11" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>							
 --%>
 					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP10"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
 
						</div>
				</form:form>

						</div>
					</div>
					<div id="menu11" class="tab-pane container fade">
						<div class="panel-body">
							<br />
						<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario11"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP11" data-destino="detalleItem"
								data-accionEnExito="ACTUALIZAR">
				     <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
					 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
					 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">
								  			
								
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
									id="observacion" name="observacion"
									placeholder="Ingrese el comentario aquí"></textarea>
								<div class="invalid-feedback">Por favor ingrese el
									comentario</div>
							</div>
						</div>					
					<div class="col-md-12 text-center">
									<button type="submit" id="btnGuardarP11"
										class="btn _imprimirColor _guardar btn-sm mt-2 Oculta">Finalizar Evaluación</button>
					</div>
					</form:form>
					

						</div>
					</div>
					
					
					
					<div id="menu12" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario12"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP12" data-destino="detalleItem"
								data-accionEnExito="">
								
						 <input type="hidden" name="pre12" id="pre12" value="">
				         <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
						 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">		
						
						<h5 class="card-header text-white carHeaderBlue">INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR</h5>
						<div class="card-body">
							<table id="TablaIncorporacionRecom"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th style="font-size: x-small;">#</th>
										<th style="font-size: x-small;">ENTIDAD QUE RECOMIENDA</th>
										<th style="font-size: x-small;">NO. DE INFORME DE LA
											ENTIDAD QUE RECOMIENDA</th>
										<th style="font-size: x-small;">NO. DE INFORME DE
											CUMPLIMIENTO</th>
										<th style="font-size: x-small;">% DE CUMPLIMIENTO DE LAS
											RECOMENDACIONES</th>
										<th style="font-size: x-small;">OBSERVACIONES</th>
										<th style="font-size: x-small;">LINK AL MEDIO DE
											VERIFICACIÓN</th>

									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta16">¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"    onchange="adjuntarEvidencia(this, divevidencia10);"
										id="cmbPregunta16" required="required" name="cmbPregunta16">
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
							
							<div id="divevidencia10" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia10">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia10"
											name="evidencia10"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

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
											class="EliminarArchivo10 adjunto btn _eliminarColor btn-sm Oculta"
											id="EliminarArchivo10" disabled="disabled">
											<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>

								</div>
							</div>
							<div id="VerArchivoEvdidencia10" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia10">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink10"  target="_blank"
								     class="archivoCargado">Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink10" id="evidenciaRutaLink10" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer10">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP12"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
							
							
						</div>
					</form:form>

						</div>
					</div>
					
					
					<div id="menu13" class="tab-pane container fade">
						<div class="panel-body">
							<br />
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblInformeCalificado" id="formulario13"
								data-rutaAplicacion="rendicion/valoracion"
								data-opcion="GuardarFrmMediosP13" data-destino="detalleItem"
								data-accionEnExito="">
								
						 <input type="hidden" name="pre13" id="pre13" value="">
				         <input type="hidden" name="identificadorResponsable" id="identificadorResponsable" value="${identificadorResponsable}">
						 <input type="hidden" name="infcod" id="infcod" value="${infcod}">
						 <input type="hidden" name="periodoInforme" id="periodoInforme"	value="${periodoInforme}">		
						
						<h5 class="card-header text-white carHeaderBlue">INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)</h5>
						<div class="card-body">
							<table id="tablaRegistrosIF" class="table table-striped table-bordered"
								style="width: 100%">
								<thead>
								    <tr>
								    <th style="background-color: #1f8948;color: white;" colspan="6"><h5>BALANCE GENERAL</h5></th>
								    </tr>
									<tr>
										<th >#</th>
										<th width="10%" style="text-align: center; font-size:x-small;">ACTIVOS</th>
										<th width="10%" style="text-align: center; font-size:x-small;">PASIVOS</th>
										<th width="10%" style="text-align: center; font-size:x-small;">PATRIMONIO</th>
										<th width="50%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta17">¿EL MEDIO SUSTENTA SU BALANCE GENERAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"    onchange="adjuntarEvidencia(this, divevidencia11);"
										id="cmbPregunta17" required="required" name="cmbPregunta17">
										<option value="">Seleccione...</option>
										<option value="1. BALANCE GENERAL DIGITALIZADO">1. BALANCE GENERAL DIGITALIZADO</option>
										<option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
										<option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE
											VERIFICACIÓN</option>
										<option value="4. RESPONDE EN 0">4. RESPONDE EN 0</option>
										<option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
										<option value="6. VACÍO">6. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia11" style="display: visible">
								<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="evidencia11">Adjuntar captura de pantalla
											de la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
											.docx</label>
									</div>
									<div class="col-md-5 text-left waves-effect float-left">
										<input type="file" required="required"
											class="form-control-file archivo gris" id="evidencia11"
											name="evidencia11"
											accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

										<div class="estadoCarga">En espera de archivo... (Tamaño
											máximo ${tamanioArchivo})</div>
										<input type="hidden" class="rutaArchivo11" id="rutaArchivo11"
											name="rutaArchivo11" value="" />
										<div class="invalid-feedback">Por favor seleccione un
											archivo</div>
									</div>

									<div class="col-md-3 text-left">
										<button type="button" id="subirArchivo11"
											class="subirArchivo11 adjunto btn _nuevoColor btn-sm"
											data-rutaCarga="${rutaModuloRetroalimentacion}">
											<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
											archivo
										</button>

										<button type="button"
											class="EliminarArchivo11 adjunto btn _eliminarColor btn-sm Oculta"
											id="EliminarArchivo11" disabled="disabled">
											<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
										</button>
									</div>

								</div>
							</div>
							<div id="VerArchivoEvdidencia11" class="form-group row">
								<div class="col-md-3 text-left">
								<label for="linkEvidencia11">Archivo de Verificación </label>
								</div>
								<div class="col-md-3 text-left">
								   <a id="evidenciaLink11"  target="_blank"
								     class="archivoCargado">Click aquí para ver archivo</a>
								        <input type="hidden" name="evidenciaRutaLink11" id="evidenciaRutaLink11" value="">
								</div>
								<div class="col-md-3 text-left">
									<button type="button" class="adjunto btn _eliminarColor btn-sm"
									id="EliminarArchiServer11">
									<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarP13"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
							
							
						</div>
					</form:form>

						</div>
					</div>
					
					
					<!-- fin paneles tab-->
				</div>
<!-- fin paneles tab container-->

			</div>
		</div>
	</div>
</div>

</html>

<script type="text/javascript">
$(document).ready(function() {
	$('.Oculta').hide();
   if('${pregunta1.idInfCal}' !== ""){	
		$("#codigo").val('${pregunta1.idInfCal}');
		$("#pre1").val($("#codigo").val());		
		 cargarValorComboPorDefecto("cmbpregunta1",'${pregunta1.respuesta}');
	}
});
$('a[data-toggle="pill"]').on('click', function(event) {
	var x = $(this).attr('href');
	switch (x) {
	  case '#menu1':
		   obtenerdatosPreguntas();

   break;
	  case '#menu2':		 
		tablaProcesosContratacion();
		obtenerdatosPreguntas();
   break;
	  case '#menu3':		  
		  tablaCumplimientoObligacionesTL();
		  obtenerdatosPreguntas();
   break;
	  case '#menu4':
		  tablaMecanismosParticionCiudadanaFE();
		  obtenerdatosPreguntas();
   break;
	  case '#menu5':
		  tablaPRFE();
		  tablaPRFE2();
		  obtenerdatosPreguntas();
   break;
	  case '#menu6':
		  tablaPC();
		  tablaPCPromoDerechos()
		  tablaPCParticipacion()
		  tablaPCDialogo()
		  obtenerdatosPreguntas();
   break;
	  case '#menu7':
		  tablaDA();
		  obtenerdatosPreguntas();
   break;
	  case '#menu8':
		  tablaPN();
		  obtenerdatosPreguntas();
   break;
	  case '#menu9':
		  tablaPI();
		  obtenerdatosPreguntas();
   break;
	  case '#menu10':
		  tablaControlSocialFE();
		  obtenerdatosPreguntas();
   break;
	  case '#menu11':
		  obtenerdatosPreguntas();
	break;
	  case '#menu12':
		  tablaIncorporacionRecomenFE();
		  obtenerdatosPreguntas();
   break;
	  case '#menu13':
		  tablaInformacionFinanciera();
		  obtenerdatosPreguntas();
   break;
	}
	//validarIdInforme($("#infcod").val());
	//detalle8.idInfCal
	//$("#id_informe_4").val('${detalle4.idInfCal}');
});

	function obtenerdatosPreguntas() {
		const parametros = {"infCod" : $("#infcod").val() };
		$.ajax({
			url : 'ObtenerPreguntas',
			headers : {	"X-CSRF-TOKEN" : csrfToken},
			type : "GET",
			dataType : 'json',
			data : parametros,
			success : function(result) {				
				if(result.data.length==15){
					$("#btnGuardarP11").show();
				}else{
					$("#btnGuardarP11").hide();
				}
				
				$.each(result.data, function (i, op) {
					switch (op.pregunta) {
					case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
						$("#pre1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbpregunta1",op.respuesta);
					    break;
					case'¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':
						$("#pre2").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta2",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta2", "divevidencia1");					
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink1").val(op.evidencia);
						 }							
						
					break;	
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?':						
						$("#pre3").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta3",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta3", "divevidencia2");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink2').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink2").val(op.evidencia);	
						 }	
					break;
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?':						
						$("#pre3_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta4",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta4", "divevidencia2_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink2_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink2_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?':						
						$("#pre4").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta5",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta5", "divevidencia3");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink3').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink3").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?':						
						$("#pre5").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta6",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta6", "divevidencia4");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink4').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?':						
						$("#pre5_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta7",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta7", "divevidencia4_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink4_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink4_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?':						
						$("#pre6").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta10",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta10", "divevidencia6");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink6').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink6").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?':						
						$("#pre6_1").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta11",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta11", "divevidencia7");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink6_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink6_1").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?':						
						$("#pre7").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta12",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta12", "divevidencia6_1");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink7').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink7").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?':						
						$("#pre8").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta13",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta13", "divevidencia8");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink8').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink8").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?':						
						$("#pre9").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta14",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta14", "divevidencia9");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink9').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink9").val(op.evidencia);							 
						 }
					break;			
					case '¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?':						
						$("#pre12").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta16",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta16", "divevidencia10");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink10').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink10").val(op.evidencia);							 
						 }
					break;			
					case '¿EL MEDIO SUSTENTA SU BALANCE GENERAL?':						
						$("#pre13").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta17",op.respuesta);	
						 adjuntarEvidencia("cmbPregunta17", "divevidencia11");						
						 if(op.evidencia !="N/A" && op.evidencia !=""){								
							 $('#evidenciaLink11').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
							 $("#evidenciaRutaLink11").val(op.evidencia);							 
						 }	
					break;
					case '¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':						
						$("#pre10").val(op.idInfCal);
						 cargarValorComboPorDefecto("cmbPregunta15",op.respuesta);	
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
	//Presgunta 2
	$('#EliminarArchiServer1').click(function(event) {	
		var archivourl = $("#evidenciaRutaLink1").val();
		EliminarArchivo(archivourl, '', '', '');		
		$('#evidenciaLink1').attr('href', '');							
		$("#evidenciaRutaLink1").val('');
		
	});
	//Pregunta 3
	$('#EliminarArchiServer2').click(function(event) {	
		var archivourl = $("#evidenciaRutaLink2").val();
		EliminarArchivo(archivourl, '', '', '');		
		$('#evidenciaLink2').attr('href', '');							
		$("#evidenciaRutaLink2").val('');
		
	});	
	$('#EliminarArchiServer2_1').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink2_1").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink2_1').attr('href', '');							
		$("#evidenciaRutaLink2_1").val('');
		
	});
	
	//Pregunta 4
	$('#EliminarArchiServer3').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink3").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink3').attr('href', '');							
		$("#evidenciaRutaLink3").val('');		
	});
	//Pregunta 5
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
	//Pregunta 6
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
	//Pregunta 7
	$('#EliminarArchiServer7').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink7").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink7').attr('href', '');							
		$("#evidenciaRutaLink7").val('');		
	});
	//Pregunta 8
	$('#EliminarArchiServer8').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink8").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink8').attr('href', '');							
		$("#evidenciaRutaLink8").val('');		
	});
	//Pregunta 9
	$('#EliminarArchiServer9').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink9").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink9').attr('href', '');							
		$("#evidenciaRutaLink9").val('');		
	});
	
	//Pregunta INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR
	$('#EliminarArchiServer10').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink10").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink10').attr('href', '');							
		$("#evidenciaRutaLink10").val('');		
	});
	
	//Pregunta INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)
	$('#EliminarArchiServer11').click(function(event) {			
		var archivourl = $("#evidenciaRutaLink11").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink11').attr('href', '');							
		$("#evidenciaRutaLink11").val('');		
	});
		
	//Metodos guardar 
	//Pregunta 1
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
	//Pregunta 2
	$("#btnGuardarP2").click(function(event) {
		var form = $("#formulario2")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia1')){
				 ejecutarJson(form);
				 $("#pre2").val($("#codigo").val());
			     } else {	
			    	$("#evidencia1").addClass('rojo');
					mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     }		
		}
		form.addClass('was-validated');		
	});
	//Pregunta 3
	$("#btnGuardarP3").click(function(event) {
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
			     }else if(ValidarArchivo('evidencia2_1')==false) {				    	
			    	 $("#evidencia2_1").addClass('rojo');			    	 
			    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     }else{			    	 
			    	 ejecutarJson(form);
						$("#pre3").val($("#codigo").val());
						$("#pre3_1").val($("#codigo1").val());
			     }		
		}
		form.addClass('was-validated');
	});
	//Pregunta 4
	$("#btnGuardarP4").click(function(event) {	
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
			     }else{			    	 
			    	 ejecutarJson(form);	
						$("#pre4").val($("#codigo").val());					
			     }			
		}
		form.addClass('was-validated');

	});
	//Pregunta 5
	$("#btnGuardarP5").click(function(event) {
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
			     }else{			    	 
			    	 ejecutarJson(form);
						$("#pre5").val($("#codigo").val());
						$("#pre5_1").val($("#codigo1").val());
			     }
			
		}
		form.addClass('was-validated');
	

	});
	
	//Pregunta 6
	$("#btnGuardarP6").click(function(event) {
		var form = $("#formulario6")
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
						$("#pre6").val($("#codigo").val());
						$("#pre6_1").val($("#codigo1").val());
			     }
			
		}
		form.addClass('was-validated');
	

	});
	
	//Pregunta 7
	$("#btnGuardarP7").click(function(event) {
		var form = $("#formulario7")
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
						$("#pre7").val($("#codigo").val());						
			     }
			
		}
		form.addClass('was-validated');
	

	});
	//Pregunta 8
	$("#btnGuardarP8").click(function(event) {
		var form = $("#formulario8")
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
						$("#pre8").val($("#codigo").val());						
			     }
			
		}
		form.addClass('was-validated');
	

	});
	
	//Pregunta 9
	$("#btnGuardarP9").click(function(event) {
		var form = $("#formulario9")
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
						$("#pre9").val($("#codigo").val());						
			     }
			
		}
		form.addClass('was-validated');
	

	});
	//Pregunta 10
	$("#btnGuardarP10").click(function(event) {
		var form = $("#formulario10")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {	 
			    ejecutarJson(form);
				$("#pre10").val($("#codigo").val());		
		}
		form.addClass('was-validated');
	

	});
	
	//Pregunta 11
	$("#btnGuardarP11").click(function(event) {
		var form = $("#formulario11")
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
	
	//Pregunta INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR
	$("#btnGuardarP12").click(function(event) {
		var form = $("#formulario12")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia10')==false ){
				 $("#evidencia10").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 
					    ejecutarJson(form);
						$("#pre12").val($("#codigo").val());						
			     }			
		}
		form.addClass('was-validated');
	

	});
	
	//Pregunta INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)
	$("#btnGuardarP13").click(function(event) {
		var form = $("#formulario13")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			 if(ValidarArchivo('evidencia11')==false ){
				 $("#evidencia11").addClass('rojo');
				 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
			     }else{			    	 						
					    ejecutarJson(form);
						$("#pre13").val($("#codigo").val());						
			     }	

		}
		form.addClass('was-validated');
	

	});
	
	
	
function tablaCumplimientoObligacionesTL() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$('#tablaRegistrosObligacionesTributariasLaborales').DataTable({
						ajax : {
							data : parametros,
							url : "obtenerRegistrosCumplimientoInformacion",
							headers : {
								"X-CSRF-TOKEN" : csrfToken
							},
							type : "POST"
						},					
						paging : false,
						info : false,
						searching : false,	
						bDestroy : true,
						columns : [
								{data : "contador"},
								{data : "laborales"},
								{data : "tributarios"},
								{data : "link",	render : function(data) {
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
							$(row).attr('id', data.CumOblCod);
							$(row).attr('ondragstart', 'drag(event)');
							$(row).attr('draggable', 'false');
							$(row).attr('data-destino', 'detalleItem');
							$(row).find("td:first").css({
								"font-weight" : "bold",
								"white-space" : "nowrap"
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


function tablaProcesosContratacion() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$.ajax({
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
						$('#tablaRegistrosProcesosContratacion').DataTable(	{
						paging : false,
						info : false,
						searching : false,	
						bDestroy : true,
						data : result.data,
						columns : [
								{data : "contador"},
								{data : "tipo"},
								{data : "","render" : function(	data, type,	full, meta) {
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
								{data : "link", render : function(data) {
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
						createdRow : function(row,data, dataIndex) {
							$(row).attr('id',data.pcoCod);
							$(row).attr('ondragstart','drag(event)');
							$(row).attr('draggable','false');
							$(row).attr('data-destino',	'detalleItem');
							$(row).find("td:first").css({
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
	$('#tablaRegistrosMecanismosParticionCiudadanaFE').DataTable({
		ajax : {
				data : parametros,
				url : "obtenerMecanismoParticipacionEjecutivo",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
					},
				type : "POST"
				},
				paging : false,
				info : false,
				searching : false,
				bDestroy : true,
			columns : [
					{data : "contador"},
					{data : "nombre"},
					{data : "implementado"},
					{data : "numero"},
					{data : "link",render : function(data) {
					    if (data === "NO APLICA" || data === "S/N") {
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
	$('#TablaRendicionFases').DataTable({
			ajax : {
				data : parametros,
				url : "obtenerRendicionFases",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : "POST"
			},		
			paging : false,
			info : false,
			searching : false,	
			bDestroy : true,
			columns : [
					{data : "contador"},
					{data : "mecanismo"},
					{data : "proceso"},
					{data : "seleccion"},
					{data : "describa"},
					{data : "link",render : function(data) {
					    if (data === "NO APLICA" || data === "S/N") {
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

function tablaPRFE2() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$('#TablaRendicionFasesAporte').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerRendicionAporte",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
		paging : false,
		info : false,
		searching : false,
		bDestroy : true,	
		columns : [ 
			{data : "contador"}, 
			{data : "proceso"}, 
			{data : "describa"}
		],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.mecanismo_cod);
			//$(row).attr('class', 'item');
			$(row).attr('data-rutaAplicacion', 'rendicion');
			$(row).attr('data-opcion', 'Frm_RendicionCuentasFaseAportes');
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

function tablaPC() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$('#tablaRegistrosPC').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerRegistrosProyectos",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
	
		paging : false,
		info : false,
		searching : false,	
		bDestroy : true,
		columns : [ 
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
  		 	}},
  		 	{data : "proNombre"},
  			{data : "proOpcion"},
			/*{data : "contador"}, 
			{data : "nombre"}, 
			{data : "opcion"}*/
			],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.ProCodigo);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap"
			});
		},
	});

}

function tablaPCPromoDerechos() {
	var parametros = {
		"infCod" : $("#infcod").val(),
		"tipo" :'PROMOCIÓN DE DERECHOS'
	};
	$('#tablaRegistrosPCPromoDerechos').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerCumplimientoMediosDerechos",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
	
		paging : false,
		info : false,
		searching : false,	
		bDestroy : true,
		columns : [ 
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
				{data : "cmValidaProyecto"},
				{data : "cmDescParametro"},
				{data : "cmOpciones"},
				{data : "cmNomPrograma"},
				{data : "cmFrecuencia"},
				{data : "cmDescProgramacion"},
				{data : "cmPorcDifusion"},
				{data : "cmLink"},
			
			/*{data : "contador"},
			{data : "proyecto"},
			{data : "parametro"},
			{data : "opcion"},
			{data : "programanombre"},
			{data : "frecuencia"},
			{data : "desprograma"},
			{data : "porcentage"},
			{data : "link"}*/
			],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.ProCodigo);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap"
			});
		},
	});

}

function tablaPCParticipacion() {
	var parametros = {
		"infCod" : $("#infcod").val(),
		"tipo" :'PARTICIPACIÓN'
	};
	$('#tablaRegistrosPCParticipacion').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerCumplimientoMediosDerechos",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
	
		paging : false,
		info : false,
		searching : false,	
		bDestroy : true,
		columns : [ 
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
				{data : "cmValidaProyecto"},
				{data : "cmDescParametro"},
				{data : "cmOpciones"},
				{data : "cmNomPrograma"},
				{data : "cmFrecuencia"},
				{data : "cmDescProgramacion"},
				{data : "cmPorcDifusion"},
				{data : "cmLink"},
			/*{data : "contador"},
			{data : "proyecto"},
			{data : "parametro"},
			{data : "opcion"},
			{data : "programanombre"},
			{data : "frecuencia"},
			{data : "desprograma"},
			{data : "porcentage"},
			{data : "link"}*/
			],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.ProCodigo);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap"
			});
		},
	});

}

function tablaPCDialogo() {
	var parametros = {
		"infCod" : $("#infcod").val(),
		"tipo" :'DIÁLOGO'
	};
	$('#tablaRegistrosPCDialogo').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerCumplimientoMediosDerechos",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
	
		paging : false,
		info : false,
		searching : false,	
		bDestroy : true,
		columns : [ 
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
				{data : "cmValidaProyecto"},
				{data : "cmDescParametro"},
				{data : "cmOpciones"},
				{data : "cmNomPrograma"},
				{data : "cmFrecuencia"},
				{data : "cmDescProgramacion"},
				{data : "cmPorcDifusion"},
				{data : "cmLink"},
			/*{data : "contador"},
			{data : "proyecto"},
			{data : "parametro"},
			{data : "opcion"},
			{data : "programanombre"},
			{data : "frecuencia"},
			{data : "desprograma"},
			{data : "porcentage"},
			{data : "link"}*/
			],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.ProCodigo);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap"
			});
		},
	});

}

function tablaDA() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$.ajax({
		url : "obtenerMediosDerechos",
		type : "post",
		dataType : "json",
		data : parametros,
		headers : {
			"X-CSRF-TOKEN" : csrfToken
		},
		success : function(result) {
			if (result['Error']) {
				$('#tabla').hide();
				$('#nuevo').show();

			} else if (result['data'].length != 0) {
				$('#nuevo').hide();
				$('#tablaRegistrosDA').DataTable(	{							
				paging : false,
				info : false,
				searching : false,	
				bDestroy : true,
				data : result.data,
				columns : [
					{data: "" ,"render": function (data, type, full, meta) {
						 return  meta.row + 1;
					 	}},
					{data : "daTipo"},
					{data : "daNumero"},
					{data : "daNumeropagado"},
					
					/*{data : "contador"},
					{data : "tipo"},
					{data : "numero"},
					{data : "numeropagado"},*/
					{data : "dalink",render : function(data) {
						if (data === "NO APLICA" || data === "S/N") {
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
				createdRow : function(row,data, dataIndex) {
					$(row).attr('id',data.DaCod);
					$(row).attr('ondragstart','drag(event)');
					$(row).attr('draggable','false');
					$(row).attr('data-destino','detalleItem');
					$(row).find("td:first").css(
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
			// alert(errormessage.responseText);
		}
	});
}


function tablaPN() {
	var parametros = {
		"infCod" : $("#infcod").val(),
		"tipo" : "PRODUCCIÓN NACIONAL"
	};
	$('#TablaEspaciosProNacional').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerProduccionAudiovisual",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
	
		paging : false,
		info : false,
		searching : false,	
		bDestroy : true,
		columns : [
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
			{data : "paTipo"},
			{data : "paPorcentaje"}, 
			{data : "paContenido"},
			{data : "paPeriocidad"}, 
			
			/*{data : "contador"},
				{data : "tipo"},
				{data : "porcentage"},
				{data : "contenido"},
				{data : "programa"},*/
				{data : "paMedio",	render : function(data) {
				if (data === "NO APLICA" || data === "S/N") {
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
			$(row).attr('id', data.PaCod);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap",
			});
			$(row).find("td:eq(1)")
					.attr('title', data.tipo);

			$(row).find("td").css({
				"font-size" : "x-small",
			});

			$(row).find("td").css({
				"vertical-align" : "middle",
			});

		},
		"footerCallback" : function(row, data, start, end,	display) {
			var api = this.api(), data;
			// Remove the formatting to get integer data for summation
			var intVal = function(i) {
				return typeof i === 'string' ? i.replace(
						/[\$,]/g, '') * 1
						: typeof i === 'number' ? i : 0;
			};

			// Total over all pages
			total = api.column(2).data().reduce(
					function(a, b) {
						return intVal(a) + intVal(b);
					}, 0);

			// Total over this page
			pageTotal = api.column(2, {
				page : 'current'
			}).data().reduce(function(a, b) {
				return intVal(a) + intVal(b);
			}, 0);

			// Update footer
			$(api.column(2).footer())
					.html(pageTotal + ' %');
		}

	});

}

function tablaPI() {
	var parametros = {
		"infCod" : $("#infcod").val(),
		"tipo" : "PRODUCCIÓN NACIONAL INDEPENDIENTE"
	};
	$('#TablaEspaciosProIndependiente').DataTable({
			ajax : {
				data : parametros,
				url : "obtenerProduccionAudiovisual",
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
				{data: "" ,"render": function (data, type, full, meta) {
					 return  meta.row + 1;
				 	}},
				{data : "paTipo"},
				{data : "paPorcentaje"}, 
				{data : "paContenido"},
				{data : "paPeriocidad"}, 
				
				/*{data : "contador"},
				{data : "tipo"},
				{data : "porcentage"},
				{data : "contenido"},
				{data : "programa"},*/
				{data : "paMedio",render : function(data) {
				if (data === "NO APLICA"|| data === "S/N") {
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
				$(row).attr('id', data.PaCod);
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",
				});
				$(row).find("td:eq(1)")
						.attr('title', data.tipo);

				$(row).find("td").css({
					"font-size" : "x-small",
				});

				$(row).find("td").css({
					"vertical-align" : "middle",
				});

			},
			"footerCallback" : function(row, data, start, end,
					display) {
				var api = this.api(), data;

				// Remove the formatting to get integer data for summation
				var intVal = function(i) {
					return typeof i === 'string' ? i.replace(
							/[\$,]/g, '') * 1
							: typeof i === 'number' ? i : 0;
				};

				// Total over all pages
				total = api.column(2).data().reduce(
						function(a, b) {
							return intVal(a) + intVal(b);
						}, 0);

				// Total over this page
				pageTotal = api.column(2, {
					page : 'current'
				}).data().reduce(function(a, b) {
					return intVal(a) + intVal(b);
				}, 0);

				// Update footer
				$(api.column(2).footer())
						.html(pageTotal + ' %');
			}

		});

}

function tablaControlSocialFE() {
	var parametros = {
		"infCod" : $("#infcod").val()
	};
	$('#TablaContSocial').DataTable({
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
		bDestroy : true,
		columns : [
			{data : "contador"},
			{data : "sistema"},
			{data : "seleccion"},
			{data : "numero"},
			{data : "link",render : function(data) {
			if (data === "NO APLICA" || data === "S/N") {
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


function tablaInformacionFinanciera() {
	var parametros = {
			"infCod" : $("#infcod").val()
		};
	$('#tablaRegistrosIF').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosInformacionFinanciera",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
	    paging : false,
		info : false,
		searching : false,
		responsive : true,
		bDestroy : true,
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
			{data : "contador" },
			{data : "activo"},
			{data : "pasivos"},
			{data : "patrimonio"},
			{data : "link",
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
				}}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.CodFinan);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


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
							url : "obtenerIncorporacionRecom",
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
									data : "entidad"
								},
								{
									data : "informeRecom"
								},
								{
									data : "informeCumpl"
								},
								{
									data : "porcentaje"
								},
								{
									data : "observacion"
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
							$(row).attr('id', data.ire_cod);
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


// Fin carga de tablas 

//inicio de carga de archivos 
//pregunta 2
	$('button.subirArchivo1').click(function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo1");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'
					|| extension[extension.length - 1]
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
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,new carga(estado, archivo, boton),
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

	$('button.EliminarArchivo1').click(	function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var archivourl = $("#rutaArchivo1").val();
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo1");
				var archivo = boton.parent('div').parent('div').find(".archivo");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));							
				$('#subirArchivo1').removeAttr("disabled");
				$('#evidencia1').val('');	
				$('#EliminarArchivo1').hide();
				$('#subirArchivo1').show();
				$('#evidenciaLink1').attr('href', '');							
				$("#evidenciaRutaLink1").val('');
				
				
			});
	//pregunta 3

	$('button.subirArchivo2').click( function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo2");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'
					|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG'
					|| extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP'
					|| extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");			
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
			EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
			$('#subirArchivo2').removeAttr("disabled");
			$('#evidencia2').val('');	
			$('#EliminarArchivo2').hide();
			$('#subirArchivo2').show();
			$('#evidenciaLink2').attr('href', '');							
			$("#evidenciaRutaLink2").val('');
		});
	
	$('button.subirArchivo2_1').click( function(event) {
		var boton = $(this);
		var archivo = boton.parent('div').parent('div').find(".archivo");
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo2_1");
		var extension = archivo.val().split('.');
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var fecha = new Date();
		var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
		if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
				|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
				|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
				|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
			subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
					new carga(estado, archivo, boton),"${tamanioArchivo}");			
			$('#EliminarArchivo2_1').show();
			$('#EliminarArchivo2_1').removeAttr("disabled");
			$('#subirArchivo2_1').hide();
			$('#evidenciaLink2_1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo2_1').val());							
			$("#evidenciaRutaLink2_1").val($('#rutaArchivo2_1').val());

		} else {
			estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
			archivo.val("");
		}
	});

$('button.EliminarArchivo2_1').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var archivourl = $("#rutaArchivo2_1").val();
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo2_1");
		var archivo = boton.parent('div').parent('div').find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
		$('#subirArchivo2_1').removeAttr("disabled");
		$('#evidencia2_1').val('');	
		$('#EliminarArchivo2_1').hide();
		$('#subirArchivo2_1').show();
		$('#evidenciaLink2_1').attr('href', '');							
		$("#evidenciaRutaLink2_1").val('');
	});
	
	
	//Pregunta 4

	$('button.subirArchivo3').click(function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo3");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'
					|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG'
					|| extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP'
					|| extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");
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

	$('button.EliminarArchivo3').click(	function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var archivourl = $("#rutaArchivo3").val();
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo3");
		var archivo = boton.parent('div').parent('div').find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));			
		$('#subirArchivo3').removeAttr("disabled");
		$('#evidencia3').val('');	
		$('#EliminarArchivo3').hide();
		$('#subirArchivo3').show();
		$('#evidenciaLink3').attr('href', '');							
		$("#evidenciaRutaLink3").val('');
	});
//Pregunta 5 
	$('button.subirArchivo4').click(function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo4");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'
					|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG'
					|| extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP'
					|| extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");				
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
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var archivourl = $("#rutaArchivo4").val();
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo4");
				var archivo = boton.parent('div').parent('div').find(".archivo");
				EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
				$('#subirArchivo4').removeAttr("disabled");
				$('#evidencia4').val('');	
				$('#EliminarArchivo4').hide();
				$('#subirArchivo4').show();
				$('#evidenciaLink4').attr('href', '');							
				$("#evidenciaRutaLink4").val('');
				
			});
	
	$('button.subirArchivo4_1').click(function(event) {
		var boton = $(this);
		var archivo = boton.parent('div').parent('div').find(".archivo");
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo4_1");
		var extension = archivo.val().split('.');
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
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
		if (extension[extension.length - 1].toUpperCase() == 'PDF'
				|| extension[extension.length - 1].toUpperCase() == 'JPEG'
				|| extension[extension.length - 1].toUpperCase() == 'JPG'
				|| extension[extension.length - 1].toUpperCase() == 'PNG'
				|| extension[extension.length - 1].toUpperCase() == 'BMP'
				|| extension[extension.length - 1].toUpperCase() == 'DOC'
				|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
			subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
					new carga(estado, archivo, boton),"${tamanioArchivo}");				
			$('#EliminarArchivo4_1').show();
			$('#EliminarArchivo4_1').removeAttr("disabled");
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
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var archivourl = $("#rutaArchivo4_1").val();
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo4_1");
			var archivo = boton.parent('div').parent('div').find(".archivo");
			EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
			$('#subirArchivo4_1').removeAttr("disabled");
			$('#evidencia4_1').val('');	
			$('#EliminarArchivo4_1').hide();
			$('#subirArchivo4_1').show();
			$('#evidenciaLink4_1').attr('href', '');							
			$("#evidenciaRutaLink4_1").val('');
			
		});
	
	
	//Pregunta 6
	$('button.subirArchivo6').click( function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");			
				$('#EliminarArchivo6').show();
				$('#EliminarArchivo6').removeAttr("disabled");
				$('#subirArchivo6').hide();
				$('#evidenciaLink6').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo6').val());							
				$("#evidenciaRutaLink6").val($('#rutaArchivo6').val());

			} else {
				estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

	$('button.EliminarArchivo6').click(function(event) {
			var boton = $(this);
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var archivourl = $("#rutaArchivo6").val();
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6");
			var archivo = boton.parent('div').parent('div').find(".archivo");
			EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
			$('#subirArchivo6').removeAttr("disabled");
			$('#evidencia6').val('');	
			$('#EliminarArchivo6').hide();
			$('#subirArchivo6').show();
			$('#evidenciaLink6').attr('href', '');							
			$("#evidenciaRutaLink6").val('');
		});
	
	
	$('button.subirArchivo6_1').click( function(event) {
		var boton = $(this);
		var archivo = boton.parent('div').parent('div').find(".archivo");
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6_1");
		var extension = archivo.val().split('.');
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var fecha = new Date();
		var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
		if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
				|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
				|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
				|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
			subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
					new carga(estado, archivo, boton),"${tamanioArchivo}");			
			$('#EliminarArchivo6_1').show();
			$('#EliminarArchivo6_1').removeAttr("disabled");
			$('#subirArchivo6_1').hide();
			$('#evidenciaLink6_1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo6_1').val());							
			$("#evidenciaRutaLink6_1").val($('#rutaArchivo6_1').val());

		} else {
			estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
			archivo.val("");
		}
	});

$('button.EliminarArchivo6_1').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var archivourl = $("#rutaArchivo6_1").val();
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6_1");
		var archivo = boton.parent('div').parent('div').find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
		$('#subirArchivo6_1').removeAttr("disabled");
		$('#evidencia6_1').val('');	
		$('#EliminarArchivo6_1').hide();
		$('#subirArchivo6_1').show();
		$('#evidenciaLink6_1').attr('href', '');							
		$("#evidenciaRutaLink6_1").val('');
	});
	
	//Pregunta 7

			$('button.subirArchivo7').click( function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivo");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo7");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
				if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
						|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
						|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
						|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
							new carga(estado, archivo, boton),"${tamanioArchivo}");			
					$('#EliminarArchivo7').show();
					$('#EliminarArchivo7').removeAttr("disabled");
					$('#subirArchivo7').hide();
					$('#evidenciaLink7').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo7').val());							
					$("#evidenciaRutaLink7").val($('#rutaArchivo7').val());

				} else {
					estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});

		$('button.EliminarArchivo7').click(function(event) {
				var boton = $(this);
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var archivourl = $("#rutaArchivo7").val();
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo7");
				var archivo = boton.parent('div').parent('div').find(".archivo");
				EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
				$('#subirArchivo7').removeAttr("disabled");
				$('#evidencia7').val('');	
				$('#EliminarArchivo7').hide();
				$('#subirArchivo7').show();
				$('#evidenciaLink7').attr('href', '');							
				$("#evidenciaRutaLink7").val('');
			});
	//Pregunta 8
	$('button.subirArchivo8').click( function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo8");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");			
				$('#EliminarArchivo8').show();
				$('#EliminarArchivo8').removeAttr("disabled");
				$('#subirArchivo8').hide();
				$('#evidenciaLink8').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo8').val());							
				$("#evidenciaRutaLink8").val($('#rutaArchivo8').val());

			} else {
				estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

	$('button.EliminarArchivo8').click(function(event) {
			var boton = $(this);
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var archivourl = $("#rutaArchivo8").val();
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo8");
			var archivo = boton.parent('div').parent('div').find(".archivo");
			EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
			$('#subirArchivo8').removeAttr("disabled");
			$('#evidencia8').val('');	
			$('#EliminarArchivo8').hide();
			$('#subirArchivo8').show();
			$('#evidenciaLink8').attr('href', '');							
			$("#evidenciaRutaLink8").val('');
		});
	
	//Pregunta 9
		$('button.subirArchivo9').click( function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo9");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var fecha = new Date();
			var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
			if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
					|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
					|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
					|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
				subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
						new carga(estado, archivo, boton),"${tamanioArchivo}");			
				$('#EliminarArchivo9').show();
				$('#EliminarArchivo9').removeAttr("disabled");
				$('#subirArchivo9').hide();
				$('#evidenciaLink9').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo9').val());							
				$("#evidenciaRutaLink9").val($('#rutaArchivo9').val());

			} else {
				estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

	$('button.EliminarArchivo9').click(function(event) {
			var boton = $(this);
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
			var archivourl = $("#rutaArchivo9").val();
			var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo9");
			var archivo = boton.parent('div').parent('div').find(".archivo");
			EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
			$('#subirArchivo9').removeAttr("disabled");
			$('#evidencia9').val('');	
			$('#EliminarArchivo9').hide();
			$('#subirArchivo9').show();
			$('#evidenciaLink9').attr('href', '');							
			$("#evidenciaRutaLink9").val('');
		});
	
	//Pregunta INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR
	$('button.subirArchivo10').click( function(event) {
		var boton = $(this);
		var archivo = boton.parent('div').parent('div').find(".archivo");
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo10");
		var extension = archivo.val().split('.');
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var fecha = new Date();
		var nombreNuevoArchivo = $("#identificadorResponsable").val()
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
		if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
				|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
				|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
				|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
			subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
					new carga(estado, archivo, boton),"${tamanioArchivo}");			
			$('#EliminarArchivo10').show();
			$('#EliminarArchivo10').removeAttr("disabled");
			$('#subirArchivo10').hide();
			$('#evidenciaLink10').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo10').val());							
			$("#evidenciaRutaLink10").val($('#rutaArchivo10').val());

		} else {
			estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
			archivo.val("");
		}
	});

$('button.EliminarArchivo10').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(".estadoCarga");
		var archivourl = $("#rutaArchivo10").val();
		var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo10");
		var archivo = boton.parent('div').parent('div').find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
		$('#subirArchivo10').removeAttr("disabled");
		$('#evidencia10').val('');	
		$('#EliminarArchivo10').hide();
		$('#subirArchivo10').show();
		$('#evidenciaLink10').attr('href', '');							
		$("#evidenciaRutaLink10").val('');
	});
	
//Pregunta INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)
$('button.subirArchivo11').click( function(event) {
	var boton = $(this);
	var archivo = boton.parent('div').parent('div').find(".archivo");
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo11");
	var extension = archivo.val().split('.');
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var fecha = new Date();
	var nombreNuevoArchivo = $("#identificadorResponsable").val()
			+ "_evidencia-11-"
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
	if (extension[extension.length - 1].toUpperCase() == 'PDF'	|| extension[extension.length - 1].toUpperCase() == 'JPEG'
			|| extension[extension.length - 1].toUpperCase() == 'JPG' || extension[extension.length - 1].toUpperCase() == 'PNG'
			|| extension[extension.length - 1].toUpperCase() == 'BMP' || extension[extension.length - 1].toUpperCase() == 'DOC'
			|| extension[extension.length - 1].toUpperCase() == 'DOCX') {
		subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo,
				new carga(estado, archivo, boton),"${tamanioArchivo}");			
		$('#EliminarArchivo11').show();
		$('#EliminarArchivo11').removeAttr("disabled");
		$('#subirArchivo11').hide();
		$('#evidenciaLink11').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo11').val());							
		$("#evidenciaRutaLink11").val($('#rutaArchivo11').val());

	} else {
		estado.html('Formato incorrecto, solo se admite archivos en formato PDF');
		archivo.val("");
	}
});

$('button.EliminarArchivo11').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo11").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo11");
	var archivo = boton.parent('div').parent('div').find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo,new carga(estado, archivo, boton));			
	$('#subirArchivo11').removeAttr("disabled");
	$('#evidencia11').val('');	
	$('#EliminarArchivo11').hide();
	$('#subirArchivo11').show();
	$('#evidenciaLink11').attr('href', '');							
	$("#evidenciaRutaLink11").val('');
});
		
	function adjuntarEvidencia(select, div) {
	
		HiddeFileDiv(select, div);
	}
	function adjuntarEvidenciaDoble1(divName) {
		var cmbPregunta3 = $("#cmbPregunta3").val();
		var cmbPregunta4 = $("#cmbPregunta4").val();
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ((cmbPregunta3 == "6. VACÍO" || cmbPregunta3 == "4. NO APLICA")
				&& (cmbPregunta4 == "6. VACÍO" || cmbPregunta4 == "4. NO APLICA")) {
			$("#" + divId).hide();
			$("#" + elements).removeAttr("required");

		} else {
			$("#" + divId).show();
			$("#" + elements).attr("required", "required");
		}

	}
	function adjuntarEvidenciaDoble2(divName) {
		var cmbPregunta6 = $("#cmbPregunta6").val();
		var cmbPregunta7 = $("#cmbPregunta7").val();
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ((cmbPregunta6 == "8. VACÍO" || cmbPregunta6 == "6. NO APLICA")
				&& (cmbPregunta7 == "7. VACÍO" || cmbPregunta7 == "5. NO APLICA")) {
			$("#" + divId).hide();
			$("#" + elements).removeAttr("required");

		} else {
			$("#" + divId).show();
			$("#" + elements).attr("required", "required");
		}

	}
	
</script>
