<%-- 
	version		: 1.0
	Document  	: valoracionInformeFE
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
<body>
<div class="card text-center mb-card20">
	<div class="card-header ">
		<h5>Formulario para la valoración de informes</h5>
	</div>
	
	<!--form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_1"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito="ACTUALIZAR"-->
					
	<div class="card-body">

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
				</ul>
   <hr/>
				<!-- Tab panes -->
				<div class="tab-content">
				
				
					<div class="tab-pane container active" id="home">
					
	
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_1"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					<div class="card">


						<h5 class="card-header text-white carHeaderBlue">Datos de la
							institución</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_1" name="id_informe_1" value="${detalle1.idInfCal}">
						
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
					
			</form:form>
					
					</div>
					
					
					
					<div class="tab-pane container fade" id="menu1">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_2"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
							DE LA EJECUCIÓN PRESUPUESTARIA</h5>
						<div class="card-body">

						<input type="hidden" id="id_informe_2" name="id_informe_2" value="${detalle2.idInfCal}">

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
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta2" required="required" name="cmbPregunta2">
										<option value="">Seleccione...</option>
										<option value="1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS">1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS</option>
										<option value="2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE">2. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE</option>
										<option value="3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA">3. MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA</option>
										<option value="4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA">4. EOD: INFORME OFICIAL DE EJECUCIÓN PRESUPUESTARIA QUE CONTENGA SU CÉDULA PRESUPUESTARIA/ DETALLE DE EJECUCIÓN PRESUPUESTARIA</option>
										<option value="5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA">5. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD): NO APLICA</option>
										<option value="6. NO ABRE EL LINK">6. NO ABRE EL LINK</option>
										<option value="7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
<!-- 										<option value="8. RESPONDE EN 0">8. RESPONDE EN 0</option> -->
										<option value="8. NO APLICA">8. NO APLICA</option>
										<option value="9. OTROS, NO CUMPLE">9. OTROS, NO CUMPLE</option>
										<option value="10. VACÍO">10. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia1" style="display:${detalle2.evidencia != null ? 'none' : detalle2.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia1">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle2.evidencia == null ? 'required="required"' : ''}
										class="form-control-file archivo gris" id="evidencia1"
										name="evidencia1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo1" id="rutaArchivo1"
										name="rutaArchivo1" value="${detalle2.evidencia}" />
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
										class="EliminarArchivo1 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo1" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>

										<div id="VerArchivoEvdidencia1" class="form-group row" >
										<%-- style="display:${detalle2.evidencia == null ? 'none' : detalle2.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia1">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink1" target="_blank"
													href="${rutaArchivosAplicacion}${detalle2.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink1" id="evidenciaRutaLink1"
													value="${detalle2.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer1">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>

									</div>

					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu2">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_3"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
							CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_3" name="id_informe_3" value="${detalle3.idInfCal}">
						
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
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta3" required="required" name="cmbPregunta3">
										<option value="">Seleccione...</option>
										<option value="1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP">1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP</option>
										<option value="2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS">2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS</option>
										<option value="3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN">3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN</option>
										<option value="4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)">4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)</option>
										<option value="5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA">5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA</option>
										<option value="6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO">6. EOD: PRESENTA UN INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO</option>
										<option value="7. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA">7. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA</option>
										<option value="8. NO ABRE EL LINK">8. NO ABRE EL LINK</option>
										<option value="9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">9. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="10. RESPONDE EN 0">10. RESPONDE EN 0</option>
										<option value="11. OTROS, NO CUMPLE">11. OTROS, NO CUMPLE</option>
										<option value="12. VACÍO">12. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia2" style="display:${detalle3.evidencia != null ? 'none' : detalle3.evidencia == 'N/A' ? 'none' : 'visible'}">
						<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia2">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle3.evidencia == null ? 'required="required"' : ''}								
										class="form-control-file archivo gris" id="evidencia2"
										name="evidencia2" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo2" id="rutaArchivo2"
										name="rutaArchivo2" value="${detalle3.evidencia}" />
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
										class="EliminarArchivo2 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo2" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>	
							
							<div id="VerArchivoEvdidencia2" class="form-group row" >
<%-- 										style="display:${detalle3.evidencia == null ? 'none' : detalle3.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia2">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink2" target="_blank"
													href="${rutaArchivosAplicacion}${detalle3.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink2" id="evidenciaRutaLink2"
													value="${detalle3.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer2">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
																	
					</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu3">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_4"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE PARTICIPACIÓN CIUDADANA</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_4" name="id_informe_4" value="${detalle4.idInfCal}">
						
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
									<label for="pregunta4">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta4" required="required" name="cmbPregunta4">
										<option value="">Seleccione...</option>
										<option value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
										<option value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS">2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS</option>
										<option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
										<option value="4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA">4. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA</option>
										<option value="5. NO ABRE EL LINK">5. NO ABRE EL LINK</option>
										<option value="6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">6. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="7. NO APLICA">7. NO APLICA</option>
										<option value="8. OTROS, NO CUMPLE">8. OTROS, NO CUMPLE</option>
										<option value="9. VACÍO">9. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							<div id="divevidencia3" style="display:${detalle4.evidencia != null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia3">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle4.evidencia == null ? 'required="required"' : ''}
										class="form-control-file archivo gris" id="evidencia3"
										name="evidencia3" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo3" id="rutaArchivo3"
										name="rutaArchivo3" value="${detalle4.evidencia}" />
									<div class="invalid-feedback">Por favor seleccione un archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo3"
										class="subirArchivo3 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir archivo
									</button>

									<button type="button"
										class="EliminarArchivo3 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo3" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
						 </div>
						 
						 <div id="VerArchivoEvdidencia3" class="form-group row" >
										<%-- style="display:${detalle4.evidencia == null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia3">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink3" target="_blank"
													href="${rutaArchivosAplicacion}${detalle4.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink3" id="evidenciaRutaLink3"
													value="${detalle4.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer3">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
										
						</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu4">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_5"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESO DE
							RENDICIÓN DE CUENTAS</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_5" name="id_informe_5" value="${detalle5.idInfCal}">
						<input type="hidden" id="id_informe_6" name="id_informe_6" value="${detalle6.idInfCal}">
						
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
									<tr>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta5" required="required" name="cmbPregunta5">
										<option value="">Seleccione...</option>
										<option value="1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ">1. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ</option>
										<option value="2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS">2. ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA: LINK AL VIDEO DEL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS</option>
										<option value="3. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA">3. UNIDAD DE ATENCIÓN (OTRA INSTITUCIONALIDAD) NO APLICA</option>
										<option value="4. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ">4. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA	CIUDADANÍA NO PARTICIPÓ</option>
										<option value="5. NO ABRE EL LINK">5. NO ABRE EL LINK</option>
										<option value="6. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">6. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN</option>
										<option value="7. NO APLICA">7. NO APLICA</option>
										<option value="8. OTROS, NO CUMPLE">8. OTROS, NO CUMPLE</option>
										<option value="9. VACÍO">9. VACÍO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										respuesta</div>
								</div>
							</div>
							
							<div id="divevidencia4" style="display:${detalle5.evidencia != null ? 'none' : detalle5.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle5.evidencia == null ? 'required="required"' : ''}
										class="form-control-file archivo gris" id="evidencia4"
										name="evidencia4" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4" id="rutaArchivo4"
										name="rutaArchivo4" value="${detalle5.evidencia}" />
									<div class="invalid-feedback">Por favor seleccione un archivo</div>
								</div>

								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo4"
										class="subirArchivo4 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir archivo
									</button>

									<button type="button"
										class="EliminarArchivo4 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo4" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia4" class="form-group row" >
										<%-- style="display:${detalle5.evidencia == null ? 'none' : detalle5.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia4">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink4" target="_blank"
													href="${rutaArchivosAplicacion}${detalle5.evidencia}" class="archivoCargado">Click aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink4" id="evidenciaRutaLink4"
													value="${detalle5.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer4">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
										
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6">¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta6" required="required" name="cmbPregunta6">
										<option value="">Seleccione...</option>
										<option value="1. ACTA DE REALIZACIÓN DEL	EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO">1. ACTA DE REALIZACIÓN DEL	EVENTO QUE CONTENGA LOS APORTES CIUDADANOS QUE SE GENERARON EN ESE ESPACIO</option>
										<option value="2. ACTA DE REALIZACIÓN DEL	EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS">2. ACTA DE REALIZACIÓN DEL	EVENTO QUE RECONOCE QUE NO HUBIERON APORTES/ACUERDOS</option>
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
							<div id="divevidencia5" style="display:${detalle6.evidencia != null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia5">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle6.evidencia == null ? 'required="required"' : ''}
										class="form-control-file archivo gris" id="evidencia5"
										name="evidencia5" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo5" id="rutaArchivo5"
										name="rutaArchivo5" value="${detalle6.evidencia}" />
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
										class="EliminarArchivo5 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo5" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia5" class="form-group row" >
										<%-- style="display:${detalle6.evidencia == null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia1">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink5" target="_blank"
													href="${rutaArchivosAplicacion}${detalle6.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink5" id="evidenciaRutaLink5"
													value="${detalle6.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer5">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
										
						</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu5">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_6"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_7" name="id_informe_7" value="${detalle7.idInfCal}">
						
							<table id="TablaIncorporacionRecom"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th style="font-size:x-small;">DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS REPORTADOS EN LA RENDICIÓN DE CUENTAS DEL PERIODO ANTERIOR</th>
								<th style="font-size:x-small;">¿INCORPORÓ EL APORTE CIUDADANO EN LA GESTIÓN INSTITUCIONAL?(PONGA SÍ O NO)</th>
								<th style="font-size:x-small;">PORCENTAJE DE AVANCES DE CUMPLIMIENTO</th>
								<th style="font-size:x-small;">DESCRIPCIÓN DE RESULTADOS</th>
								<th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>							
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7">¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta7" required="required" name="cmbPregunta7">
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
							<div id="divevidencia6" style="display:${detalle7.evidencia != null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia6">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" ${detalle7.evidencia == null ? 'required="required"' : ''}
										class="form-control-file archivo gris" id="evidencia6"
										name="evidencia6" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo6" id="rutaArchivo6"
										name="rutaArchivo6" value="${detalle7.evidencia}" />
									<div class="invalid-feedback">Por favor seleccione un archivo</div>
								</div>
								
								<div class="col-md-3 text-left">
									<button type="button" id="subirArchivo6"
										class="subirArchivo6 adjunto btn _nuevoColor btn-sm"
										data-rutaCarga="${rutaModuloRetroalimentacion}">
										<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir archivo</button>

									<button type="button"
										class="EliminarArchivo6 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo6" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar</button>
								</div>

							</div>
							</div>
							
							<div id="VerArchivoEvdidencia6" class="form-group row" >
										<%-- style="display:${detalle7.evidencia == null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
											<div class="col-md-3 text-left">
												<label for="linkEvidencia6">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink6" target="_blank"
													href="${rutaArchivosAplicacion}${detalle7.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink6" id="evidenciaRutaLink6"
													value="${detalle7.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer6">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
										
						</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu6">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_7"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE CONTROL SOCIAL</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_8" name="id_informe_8" value="${detalle8.idInfCal}">
						
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
									<label for="pregunta8">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidencia(this, divevidencia6);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta8" required="required" name="cmbPregunta8">
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
							<%-- <div id="divevidencia6" style="display:visible">
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
										class="EliminarArchivo6 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo6" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div> --%>
						</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu7">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="matriz_8"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">IMPLEMENTACIÓN
							DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
						<div class="card-body">
						
						<input type="hidden" id="id_informe_9" name="id_informe_9" value="${detalle9.idInfCal}">
						<input type="hidden" id="id_informe_10" name="id_informe_10" value="${detalle10.idInfCal}">
						<input type="hidden" id="id_informe_11" name="id_informe_11" value="${detalle11.idInfCal}">
						<input type="hidden" id="id_informe_12" name="id_informe_12" value="${detalle12.idInfCal}">
						<input type="hidden" id="id_informe_13" name="id_informe_13" value="${detalle13.idInfCal}">
						
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
									<label for="pregunta12">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm"
										id="cmbPregunta12" required="required" name="cmbPregunta12">
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
									<label for="pregunta10">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta10" required="required" name="cmbPregunta10">
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
									<label for="pregunta11">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta11" required="required" name="cmbPregunta11">
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
									<label for="pregunta9">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta9" required="required" name="cmbPregunta9">
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
									<label for="pregunta13">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta13" required="required" name="cmbPregunta13">
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
							<%-- <div id="divevidencia7" style="display:visible">
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
										class="EliminarArchivo7 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo7" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div> --%>
						</div>
					</div>
					
					</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu8">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formularioEvaluacion"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito=" ">
					
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
									id="observacion"  name="observacion"
									placeholder="Ingrese el comentario aquí"></textarea>
								<div class="invalid-feedback">Por favor ingrese el
									comentario</div>
							</div>


						</div>
					</div>
					
					</form:form>
					
					</div>
				</div>

					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardar" 
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>

					<div class="col-md-12 text-center">
						<button type="submit" id="btnFinalizar" hidden="true"
							class="btn _imprimirColor _guardar btn-sm mt-2">Finalizar Evaluación</button>
					</div>
				
			</div>
		</div>
	</div>
	
	<!--/form:form-->

	
</div>


</html>

<script type="text/javascript">

var retornoJson;
var nombreFormulario;
var nombreDiv="";
var nombreDiv1="";
var v1, v2, v3, v4, v5, v6, v7, v8;


function cargaDatos(id) {
	
	validarIdInforme(id);
	
}

$("#EliminarArchiServer1").click(function(event) {
	
	$("#divevidencia1").show();
	$("#evidenciaLink1").val(null);
	$("#evidencia1").val(null);
	$("#rutaArchivo1").val(null);
	//document.getElementById("evidencia1").required = true;
	$("#evidencia1").attr("required", "required");
	//$("#VerArchivoEvdidencia1").hide();
	
});

$("#cmbPregunta2").change(function(event) {

	if(("10. VACÍO" === $("#cmbPregunta2").val() || ("8. NO APLICA" === $("#cmbPregunta2").val()))){
		//document.getElementById("evidencia1").required = false;
		$("#evidencia1").removeAttr("required");
		$("#evidenciaLink1").val(null);
		$("#evidencia1").val(null);
		$("#rutaArchivo1").val(null);
		$("#divevidencia1").hide();
		//$("#VerArchivoEvdidencia1").hide();
	}else {
		$("#evidencia1").attr("required", "required");
		//document.getElementById("evidencia1").required = true;
		$("#divevidencia1").show();
		//$("#VerArchivoEvdidencia1").hide();

	}
	
});

$("#EliminarArchiServer2").click(function(event) {
	
	$("#divevidencia2").show();
	$("#evidenciaLink2").val(null);
	$("#evidencia2").val(null);
	$("#rutaArchivo2").val(null);
	
	//document.getElementById("evidencia2").required = true;
	$("#evidencia2").attr("required", "required");
	//$("#VerArchivoEvdidencia2").hide();
	
});

$("#cmbPregunta3").change(function(event) {

	if("12. VACÍO" === $("#cmbPregunta3").val()){
		//document.getElementById("evidencia2").required = false;
		$("#evidencia2").removeAttr("required");
		$("#evidenciaLink2").val(null);
		$("#evidencia2").val(null);
		$("#rutaArchivo2").val(null);
		$("#divevidencia2").hide();
		//$("#VerArchivoEvdidencia2").hide();
	}else {		
		//document.getElementById("evidencia2").required = true;
		$("#evidencia2").attr("required", "required");
		$("#divevidencia2").show();
		//$("#VerArchivoEvdidencia2").hide();
	}
	
});

$("#EliminarArchiServer3").click(function(event) {
	
	$("#divevidencia3").show();
	$("#evidenciaLink3").val(null);
	$("#evidencia3").val(null);
	$("#rutaArchivo3").val(null);
	
	//document.getElementById("evidencia3").required = true;
	$("#evidencia3").attr("required", "required");
	//$("#VerArchivoEvdidencia3").hide();
	
});

$("#cmbPregunta4").change(function(event) {
	
	if(("9. VACÍO" === $("#cmbPregunta4").val() || ("7. NO APLICA" === $("#cmbPregunta4").val()))){
		//document.getElementById("evidencia3").required = false;
		$("#evidencia3").removeAttr("required");
		$("#evidenciaLink3").val(null);
		$("#evidencia3").val(null);
		$("#rutaArchivo3").val(null);
		$("#divevidencia3").hide();
		//$("#VerArchivoEvdidencia3").hide();
	}else {
		
		//document.getElementById("evidencia3").required = true;		
		$("#evidencia3").attr("required", "required");
		$("#divevidencia3").show();
		//$("#VerArchivoEvdidencia3").hide();
		
	}
	
});

$("#EliminarArchiServer4").click(function(event) {
	
	$("#divevidencia4").show();
	$("#evidenciaLink4").val(null);
	$("#evidencia4").val(null);
	$("#rutaArchivo4").val(null);
	
	//document.getElementById("evidencia4").required = true;
	$("#evidencia4").attr("required", "required");
	
	//$("#VerArchivoEvdidencia4").hide();
	
});

$("#cmbPregunta5").change(function(event) {
	
	if(("9. VACÍO" === $("#cmbPregunta5").val() || ("7. NO APLICA" === $("#cmbPregunta5").val()))){
		//document.getElementById("evidencia4").required = false;
		$("#evidencia4").removeAttr("required");
		
		$("#evidenciaLink4").val(null);
		$("#evidencia4").val(null);
		$("#rutaArchivo4").val(null);
		$("#divevidencia4").hide();
		//$("#VerArchivoEvdidencia4").hide();
	}else {		
		//document.getElementById("evidencia4").required = true;
		$("#evidencia4").attr("required", "required");
		$("#divevidencia4").show();
	//	$("#VerArchivoEvdidencia4").hide();
		
	}
	
});

$("#EliminarArchiServer5").click(function(event) {
	
	$("#divevidencia5").show();
	$("#evidenciaLink5").val(null);
	$("#evidencia5").val(null);
	$("#rutaArchivo5").val(null);
	
	//document.getElementById("evidencia5").required = true;
	$("#evidencia5").attr("required", "required");	
	//$("#VerArchivoEvdidencia5").hide();
	
});

$("#cmbPregunta6").change(function(event) {
	
	if(("7. VACÍO" === $("#cmbPregunta6").val() || ("5. NO APLICA" === $("#cmbPregunta6").val()))){
		//document.getElementById("evidencia5").required = false;
	    $("#evidencia5").removeAttr("required");
		$("#evidenciaLink5").val(null);
		$("#evidencia5").val(null);
		$("#rutaArchivo5").val(null);
		$("#divevidencia5").hide();
		//$("#VerArchivoEvdidencia5").hide();
		
	}else {		
		//document.getElementById("evidencia5").required = true;
		$("#evidencia5").attr("required", "required");
		$("#divevidencia5").show();
		//$("#VerArchivoEvdidencia5").hide();
		
	}
	
});

$("#EliminarArchiServer6").click(function(event) {
	
	$("#divevidencia6").show();
	$("#evidenciaLink6").val(null);
	$("#evidencia6").val(null);
	$("#rutaArchivo6").val(null);
	
	//document.getElementById("evidencia6").required = true;	
	$("#evidencia6").attr("required", "required");
	//$("#VerArchivoEvdidencia6").hide();
	
});

$("#cmbPregunta7").change(function(event) {

	if(("8. VACÍO" === $("#cmbPregunta7").val() || ("6. NO APLICA" === $("#cmbPregunta7").val()))){
		//document.getElementById("evidencia5").required = false;
		$("#evidencia6").removeAttr("required");
		$("#evidenciaLink6").val(null);
		$("#evidencia6").val(null);
		$("#rutaArchivo6").val(null);
		$("#divevidencia6").hide();
		//$("#VerArchivoEvdidencia6").hide();
		
	}else {		
		//document.getElementById("evidencia5").required = true;
		$("#evidencia6").attr("required", "required");
		$("#divevidencia6").show();
		//$("#VerArchivoEvdidencia6").hide();

	}
	
});

/*function ejecutarPorDefecto() {
    nombreFormulario = $("#matriz_1");
    document.getElementById("btnFinalizar").hidden = true;
    document.getElementById("btnGuardar").hidden = false;
    v1 = true;
    console.log(v1)
}*/
/*function valiSelePreg() {
	  var elementos = ["cmbPregunta1", "cmbPregunta2", "cmbPregunta3", "cmbPregunta4", "cmbPregunta5", "cmbPregunta6", "cmbPregunta7", "cmbPregunta8"];
	  var valores = {};

	  elementos.forEach(function (elementId, index) {
	    var element = document.getElementById(elementId);
	    var valor = element.value;

	    if (valor) {
	      console.log('Preg' + (index + 2), valor);
	      window['v' + (index + 2)] = true;

	      if (index === 4) {
	        valores.cmbPregunta5 = valor;
	      } else if (index === 5) {
	        valores.cmbPregunta6 = valor;
	      }
	    }
	  });

	  if (valores.cmbPregunta5 !== "" && valores.cmbPregunta6 !== "") {
	    v5 = true;
	  }
	}*/
	
	function valiSelePreg (){

		var selePreg1= document.getElementById("cmbpregunta1");
		 if(selePreg1.value != ""){
			
			 v1 = true;
		 }else{
			 v1 = false
		 }
		var selePreg2= document.getElementById("cmbPregunta2");
		 if(selePreg2.value != ""){
			 
			 v2 = true;
		 }else{
			 v2 = false
		 }
		 var selePreg3=  document.getElementById("cmbPregunta3");
		 if(selePreg3.value != ""){
			 v3 = true;
		 }else{
			 v3 = false;
		 }
		 var selePreg4=  document.getElementById("cmbPregunta4");
		 if(selePreg4.value != ""){
			 
			 v4 = true;
		 }else{
			v4 = false
		 }
		 var selePreg5 =  document.getElementById("cmbPregunta5");
		 var selePreg6 =  document.getElementById("cmbPregunta6");
		 if(selePreg5.value != "" && selePreg6.value != ""){
			
			v5 = true;
		}else{
			v5= false
		}

		var selePreg7=  document.getElementById("cmbPregunta7");
		if(selePreg7.value != ""){
			v6 = true;
		}else{
			v6 = false
		}
		
		var selePreg8=  document.getElementById("cmbPregunta8");
		if(selePreg8.value != ""){
			v7 = true;
		}else{
			v7 = false;
		}

		var selePreg9 =  document.getElementById("cmbPregunta9");
		var selePreg10 =  document.getElementById("cmbPregunta10");
		var selePreg11 =  document.getElementById("cmbPregunta11");
		var selePreg12 =  document.getElementById("cmbPregunta12");
		var selePreg13 =  document.getElementById("cmbPregunta13");

		if(selePreg9.value != "" && selePreg10.value != "" && selePreg11.value != "" && selePreg12.value != "" &&  selePreg13.value){
			
			v8 = true;
		}else{
			v8 = false
		}
		
	}





// Ejecutar la función por defecto al cargar la página



	$(document).ready(function() {
		 
		nombreFormulario = $("#matriz_1");
		cargarValorComboPorDefecto("cmbpregunta1",'${detalle1.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta2",'${detalle2.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta3",'${detalle3.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta4",'${detalle4.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta5",'${detalle5.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta6",'${detalle6.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta7",'${detalle7.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta8",'${detalle8.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta9",'${detalle9.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta10",'${detalle10.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta11",'${detalle11.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta12",'${detalle12.respuesta}');
		cargarValorComboPorDefecto("cmbPregunta13",'${detalle13.respuesta}');

		  console.log(cargarValorComboPorDefecto("cmbPregunta4",'${detalle4.respuesta}'))
		$('a[data-toggle="pill"]').on('shown.bs.tab', function(e){
			   $($.fn.dataTable.tables(true)).DataTable()
			      .columns.adjust();
		});
				

		 //ejecutarPorDefecto();
		 valiSelePreg();

		$('a[data-toggle="pill"]').on('click', function(event) {
    		var x = $(this).attr('href');
    		
    		cargaDatos($("#infcod").val());
    		nombreFormulario="";
    		nombreDiv="";
			nombreDiv1="";
    	switch (x) {
  		  case '#home':

  			nombreFormulario = $("#matriz_1");
  			document.getElementById("btnFinalizar").hidden = true;
  			document.getElementById("btnGuardar").hidden = false;
  			v1 = true;
  			 break;
		  case '#menu1':

			  nombreFormulario = $("#matriz_2");
			  nombreDiv="evidencia1";
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			 
			  v2 = true;
			  break;
		  case '#menu2':
			  
			  nombreFormulario = $("#matriz_3");
			  nombreDiv="evidencia2";
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v3 = true;
			  break;
		  case '#menu3':
			  
			  nombreFormulario = $("#matriz_4");
			  nombreDiv="evidencia3";
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v4 = true;
			  break;
		  case '#menu4':
			  
			  nombreFormulario = $("#matriz_5");
			  nombreDiv="evidencia4";
			  nombreDiv1="evidencia5";
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v5 = true;
			  break;
		  case '#menu5':
			  
			  nombreFormulario = $("#matriz_6");
			  nombreDiv="evidencia6";
			  nombreDiv1="evidencia6";
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v6 = true;
			  break;
		  case '#menu6':
			  
			  nombreFormulario = $("#matriz_7");			
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v7 = true;
			  break;
		  case '#menu7':
			  nombreDiv="";
			  nombreDiv1="";
			  nombreFormulario = $("#matriz_8");
			  document.getElementById("btnFinalizar").hidden = true;
			  document.getElementById("btnGuardar").hidden = false;
			  v8 = true;
			  break;
		  case '#menu8':
			  nombreDiv="";
			  nombreDiv1="";
			  document.getElementById("btnFinalizar").hidden = false;
			  document.getElementById("btnGuardar").hidden = true;
			  break;

    		}
    		
		});
		
		tablaEjecucionPresupuestaria();
		tablaProcesosContratacion();
		tablaMecanismosParticionCiudadanaFE();
		tablaPRFE();
		tablaPRFE2();
		tablaIncorporacionRecomenFE();
		tablaControlSocialFE();
		TablaImpleIgualdadFE();
	});
/*
	$("#btnAcceso").click(function(event) {

		console.log("ingreso");

		//$("#divevidencia1").visible = true;
		
		
		document.getElementById( 'divevidencia1' ).style.display = 'none';
	});*/

	function tablaEjecucionPresupuestaria() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaActualizarDetallePoa')
				.DataTable(
						{
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
							responsive : true,
							scrollX : true,
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
												responsive : true,
												scrollX : true,
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
							responsive : true,
							scrollX : true,
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
		$('#TablaRendicionFases')
				.DataTable(
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
							scrollX : true,
							bDestroy : true,
							 autoWidth: false,
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
			pageLength : 12,
			order : [ 0, "asc" ],
			paging : false,
			info : false,
			searching : false,
			responsive : true,
			scrollX : true,
			bDestroy : true,
			columns : [ {
				data : "contador"
			}, {
				data : "proceso"
			}, {
				data : "describa"
			}

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

	function tablaIncorporacionRecomenFE() {
			var parametros = {
				"infCod" : $("#infcod").val()
			};
			$('#TablaIncorporacionRecom')
					.DataTable(
							{
								ajax : {
									data : parametros,
									url : "obtenerRegistrosCompromisosAnteriores",
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
								scrollX : true,
								bDestroy : true,
								columns : [
									{data : "contador" },
									{data : "nombre"},
									{data : "implementado"},
									{data : "avance"},
									{data : "descripcion"},
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
									$(row).attr('id', data.CscCod);
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
							scrollX : true,
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
							scrollX : true,
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
					$('#EliminarArchivo1').removeAttr("disabled");
					//$('#evidenciaLink1').attr('href', '${rutaArchivosAplicacion}'+$('#rutaArchivo1').val());
				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
				
				document.querySelector("#evidenciaLink1").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo1").val();
				//$("#VerArchivoEvdidencia1").show();
				//$("#divevidencia1").hide();
				
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
				$('#EliminarArchivo2').removeAttr("disabled");

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink2").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo2").val();
			//$("#VerArchivoEvdidencia2").show();
			//$("#divevidencia2").hide();
			
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
				$('#EliminarArchivo3').removeAttr("disabled");

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink3").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo3").val();
			//$("#VerArchivoEvdidencia3").show();
			//$("#divevidencia3").hide();
			
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
				$('#EliminarArchivo4').removeAttr("disabled");

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink4").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo4").val();
			//$("#VerArchivoEvdidencia4").show();
			//$("#divevidencia4").hide();
			
		});

$('button.EliminarArchivo4').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo4").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo4");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
	$('#subirArchivo4').removeAttr("disabled");
	$('#evidencia4').val('');
});


$('button.subirArchivo5').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo5");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
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

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink5").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo5").val();
			//$("#VerArchivoEvdidencia5").show();
			//$("#divevidencia5").hide();
			
		});

$('button.EliminarArchivo5').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo5").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo5");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
	$('#subirArchivo5').removeAttr("disabled");
	$('#evidencia5').val('');
});


$('button.subirArchivo6').click(
		function(event) {
			var boton = $(this);
			var archivo = boton.parent('div').parent('div').find(".archivo");
			var rutaArchivo = boton.parent('div').parent('div')
					.find(".rutaArchivo6");
			var extension = archivo.val().split('.');
			var estado = boton.parent('div').parent('div').find(".estadoCarga");
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

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink6").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo6").val();
			//$("#VerArchivoEvdidencia6").show();
			//$("#divevidencia6").hide();
			
		});

$('button.EliminarArchivo6').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo6").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
	$('#subirArchivo6').removeAttr("disabled");
	$('#evidencia6').val('');
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

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
			
			document.querySelector("#evidenciaLink7").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo7").val();
			//$("#VerArchivoEvdidencia7").show();
			//$("#divevidencia7").hide();
			
		});

$('button.EliminarArchivo7').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo7").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo7");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(estado, archivo, boton));
	$('#subirArchivo7').removeAttr("disabled");
	$('#evidencia7').val('');
});

	$("#btnGuardar").click(function(event) {
		
			var form = nombreFormulario;	
			var divEvi=nombreDiv;
			var divEvi1=nombreDiv1;
			event.preventDefault();
			event.stopPropagation();
			
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {	
				if(ValidarArchivo(divEvi)==false ){
					$("#"+divEvi).addClass('rojo');		
						 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
				     }else if(ValidarArchivo(divEvi1)==false) {				    	
				    	 $("#"+divEvi1).addClass('rojo');	    	 
				    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
				     }else{			    	 
				    	 guardar("GUARDAR");
				     }		

			}
			form.addClass('was-validated');
			
		});

	$("#btnFinalizar").click(function(event) {
		var form = $("#formularioEvaluacion")
		event.preventDefault();
		event.stopPropagation();
		console.log(v1, v2, v3, v4, v5, v6, v7, v8);
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			/*console.log('Test1',v1)
			console.log('Test2',v2)
			console.log('Test3',v3)
			console.log('Test4',v4)
			console.log('Test5',v5)
			console.log('Test6',v6)
			console.log('Test7',v7)
			console.log('Test8',v8)*/
			if((v1 == true) && (v2 == true) && (v3 == true)
					&& (v4 == true) && (v5 == true) && (v6 == true)
					&& (v7 == true) && (v8 == true)){
				Swal.fire({
					  title: 'ATENCIÓN',
					  text: "¿Está seguro de Finalizar la evaluación?",
					  type: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Aceptar',
					  cancelButtonText: 'Cancelar'
					}).then((result) => {						 
					  if (result.value) {						
							guardar("FINALIZAR");
							abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
					  }
					});
				
			} else {
				Swal.fire({
					  type: 'warning',
					  title: 'Oops...',
					  text: 'Por favor Revice Las Matrices para poder Completar y Finalizar el Proceso.....!!!!!!!!!',
					});
			}
			
			
				
			
		}
		form.addClass('was-validated');

	});
	/*function adjuntarEvidencia(select, div) {
		HiddeFileDiv(select, div);
	}*/
	//funcion para ocultar cargar archivo SOLO SI los 5 SELECT de politica de igualdad COINCIDEN
	/*function adjuntarEvidenciaMultiple(divName) {
		var cmbPregunta9 = $("#cmbPregunta9").val();
		var cmbPregunta10 = $("#cmbPregunta10").val();
		var cmbPregunta11 = $("#cmbPregunta11").val();
		var cmbPregunta12 = $("#cmbPregunta12").val();
		var cmbPregunta13 = $("#cmbPregunta13").val();
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ((cmbPregunta9 == "4. VACÍO" || cmbPregunta9 == "3. REPORTA NO")
				&& (cmbPregunta10 == "4. VACÍO" || cmbPregunta10 == "3. REPORTA NO")
				&& (cmbPregunta11 == "4. VACÍO" || cmbPregunta11 == "3. REPORTA NO")
				&& (cmbPregunta12 == "4. VACÍO" || cmbPregunta12 == "3. REPORTA NO")
				&& (cmbPregunta13 == "4. VACÍO" || cmbPregunta13 == "3. REPORTA NO")) {
			$("#" + divId).hide();
			$("#" + elements).removeAttr("required");

		} else {
			$("#" + divId).show();
			$("#" + elements).attr("required", "required");
		}

	}*/
	/*function adjuntarEvidenciaDoble(divName) {
		var cmbPregunta5 = $("#cmbPregunta5").val();
		var cmbPregunta6 = $("#cmbPregunta6").val();
		var divId = divName.id;
		var elements = divId.replace('div', '');
		if ((cmbPregunta5 == "9. VACÍO" || cmbPregunta5 == "7. NO APLICA")
				&& (cmbPregunta6 == "7. VACÍO" || cmbPregunta6 == "5. NO APLICA")) {
			$("#" + divId).hide();
			$("#" + elements).removeAttr("required");

		} else {
			$("#" + divId).show();
			$("#" + elements).attr("required", "required");
		}

	}*/

	function validarPreguntaInforme(idInforme, idPregunta) {

		var parametros = {
			infCod : idInforme,
			idInforme : idPregunta
		};

		$.ajax({
			url : "checkInformeCalificado",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : 'GET',
			async : false,
			dataType : 'json',
			data : parametros,
			success : function(respuestaJson) {
				
				retornoJson = respuestaJson;
			},
			error : function(result) {
				mostrarMensaje("Consulta no encontrada !",
						"ERROR-NOTIFICACION", "3000");

			}
		});
	}

	function validarIdInforme(idInforme) {

		var parametros = {
			infCod : idInforme
		};

		$.ajax({
			url : "ObtenerPreguntas",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : 'GET',
			//async: false,
			dataType : 'json',
			data : parametros,
			success : function(respuestaJson) {

				$.each(respuestaJson.data, function(index, detalle) {
					$("#id_informe_" + (index + 1)).val(detalle.idInfCal);
				});

			},
			error : function(result) {
				mostrarMensaje("Consulta no encontrada !",
						"ERROR-NOTIFICACION", "3000");

			}
		});
	}

	function guardar(validar) {

		$.ajax({
			url : 'view/rendicion/valoracion/guardarEvaluacion',
			type : 'POST',//json
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			dataType : 'json',
			data : {
				id_informe_1 : $('#id_informe_1').val(),
				id_informe_2 : $('#id_informe_2').val(),
				id_informe_3 : $('#id_informe_3').val(),
				id_informe_4 : $('#id_informe_4').val(),
				id_informe_5 : $('#id_informe_5').val(),
				id_informe_6 : $('#id_informe_6').val(),
				id_informe_7 : $('#id_informe_7').val(),
				id_informe_8 : $('#id_informe_8').val(),
				id_informe_9 : $('#id_informe_9').val(),
				id_informe_10 : $('#id_informe_10').val(),
				id_informe_11 : $('#id_informe_11').val(),
				id_informe_12 : $('#id_informe_12').val(),
				id_informe_13 : $('#id_informe_13').val(),
				finInforme : validar,
				identificadorResponsable : $('#identificadorResponsable').val(),
				infcod : $('#infcod').val(),
				cmbpregunta1 : $('#cmbpregunta1').val(),
				cmbPregunta2 : $('#cmbPregunta2').val(),
				rutaArchivo1 : $('#rutaArchivo1').val(),
				cmbPregunta3 : $('#cmbPregunta3').val(),
				rutaArchivo2 : $('#rutaArchivo2').val(),
				cmbPregunta4 : $('#cmbPregunta4').val(),
				rutaArchivo3 : $('#rutaArchivo3').val(),
				cmbPregunta5 : $('#cmbPregunta5').val(),
				cmbPregunta6 : $('#cmbPregunta6').val(),
				rutaArchivo4 : $('#rutaArchivo4').val(),
				cmbPregunta7 : $('#cmbPregunta7').val(),
				rutaArchivo5 : $('#rutaArchivo5').val(),
				rutaArchivo6 : $('#rutaArchivo6').val(),
				cmbPregunta8 : $('#cmbPregunta8').val(),
				cmbPregunta9 : $('#cmbPregunta9').val(),
				cmbPregunta10 : $('#cmbPregunta10').val(),
				cmbPregunta11 : $('#cmbPregunta11').val(),
				cmbPregunta12 : $('#cmbPregunta12').val(),
				cmbPregunta13 : $('#cmbPregunta13').val(),
				observacion : $('#observacion').val(),
				periodoInforme : $('#periodoInforme').val()
			},
			async : true,
			beforeSend : function(jqXHR) {

				if ($("#cargando").length) {
					// hacer algo aquí si el elemento existe
					$("#detalleItem").find("#cargando").fadeIn();
				} else {

					$("#detalleItem").append(
							"<div id='cargando'>Cargando...</div>")
							.fadeIn();
				}

			},
			success : function(msg) {
				if (msg.estado == "exito") {
					toastr.clear();
					mostrarMensaje(msg.mensaje, "EXITO");
					$("#cargando").delay("slow").fadeOut();
					cargaDatos($("#infcod").val());

				} else {
					$("#cargando").delay("slow").fadeOut();
					mostrarMensaje(msg.mensaje, "ERROR");

				}
			}
		});
	}
</script>
<!--script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script-->