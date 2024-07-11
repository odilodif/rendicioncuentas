<%-- 
	version		: 1.0
	Document  	: valoracionInformeFEEP
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
	<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
	<c:set var="periodo"
	value="<%=Constantes.periodo()%>" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<div class="card text-center mb-card20">
	<div class="card-header ">
		<h5>Formulario para la valoración de informes</h5>
	</div>
	<div class="card-body">

		<div class="row">

			<div class="col-md-12 order-md-1">
			
			
			

<!-- Nav pills -->
				<ul class="nav nav-tabs nav-pills">
					<li class="nav-item "><a class="nav-link active" data-toggle="pill" href="#home">Matriz 1</a></li>
					<li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu1">Matriz 2</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu2">Matriz 3</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu3">Matriz 4</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu4">Matriz 5</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu5">Matriz 6</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu6">Matriz 7</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu7">Matriz 8</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu8">Matriz 9</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu9">Matriz 10</a></li>
					<li ><a class="nav-link" data-toggle="pill" href="#menu10">Matriz 11</a></li>
				</ul>
                <hr/>
				<!-- Tab panes -->
				<div class="tab-content">
				<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<div class="tab-pane container active" id="home">
					
					<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz1"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
					<input type="hidden" name="matriz"
						id="matriz" value="1">
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
		                        <input type="hidden" id="id_informe_1" name="id_informe_1" value="${detalle1.idInfCal}">

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
						<button type="submit" id="btnGuardar"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
					
					</div>
					<div class="tab-pane container fade" id="menu1">
					
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
                            <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz2"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
					<input type="hidden" id="id_informe_2" name="id_informe_2" value="${detalle2.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="2">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta2">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?</label>
								</div>
								<div class="col-md-3 text-left">
								
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this, divevidencia1,rutaArchivo1);"
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
									<input type="file" "${detalle2.evidencia != null?'required':detalle2.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia1"
										name="evidencia1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo1" id="rutaArchivo1"
										name="rutaArchivo1" value="${detalle2.evidencia != null ? detalle2.evidencia : detalle2.evidencia == 'N/A' ? detalle2.evidencia : ''}" />
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
								<div id="VerArchivoEvdidencia1" class="form-group row" 
										style="display:${detalle2.evidencia == null ? 'none' : detalle2.evidencia == 'N/A' ? 'none' : 'visible'}">
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
						<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz2"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
                          
					</div>
					
					</div>
						<div class="tab-pane container fade" id="menu2">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">BALANCE GENERAL</h5>
						<div class="card-body">

							<table id="tablaRegistrosBalanceGeneral" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
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
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz3"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
				<input type="hidden" id="id_informe_3" name="id_informe_3" value="${detalle3.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="3">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
					
			<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3">¿LA EMPRESA PÚBLICA PRESENTA SU BALANCE GENERAL?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this, divevidencia2,rutaArchivo2);"
										id="cmbPregunta3" required="required" name="cmbPregunta3">
										<option value="">Seleccione...</option>
										<option value="1. BALANCE GENERAL">1. BALANCE GENERAL</option>
										<option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
										<option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
										<option value="4. RESPONDE EN 0">4. RESPONDE EN 0</option>
										<option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
										<option value="6. VACÍO">6. VACÍO</option>
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
									<input type="file" "${detalle3.evidencia != null?'required':detalle3.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia2"
										name="evidencia2" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo2" id="rutaArchivo2"
										name="rutaArchivo2" value="${detalle3.evidencia != null ? detalle3.evidencia : detalle3.evidencia == 'N/A' ? detalle3.evidencia : ''}" />
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
								<div id="VerArchivoEvdidencia2" class="form-group row" 
										style="display:${detalle3.evidencia == null ? 'none' : detalle3.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia1">Archivo de Verificación
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
								<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz3"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>

					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu3">
					
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
							        <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz4"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
					<input type="hidden" id="id_informe_4" name="id_informe_4" value="${detalle4.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="4">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this, divevidencia3,rutaArchivo3);"
										id="cmbPregunta4" required="required" name="cmbPregunta4">
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
							<div id="divevidencia3" style="display:${detalle4.evidencia != null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}">
						<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia2">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle4.evidencia != null?'required':detalle4.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia3"
										name="evidencia3" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo3" id="rutaArchivo3"
										name="rutaArchivo3"  value="${detalle4.evidencia != null ? detalle4.evidencia : detalle4.evidencia == 'N/A' ? detalle4.evidencia : ''}"/>
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
										class="EliminarArchivo3 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo3" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>	
								<div id="VerArchivoEvdidencia3" class="form-group row" 
										style="display:${detalle4.evidencia == null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia1">Archivo de Verificación
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
									<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz4"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>						
					</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu5">
					
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
							<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz6"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
				<input type="hidden" id="id_informe_7" name="id_informe_7" value="${detalle7.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="6">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta4">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this, divevidencia6,rutaArchivo6);"
										id="cmbPregunta7" required="required" name="cmbPregunta7">
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
							<div id="divevidencia6" style="display:${detalle7.evidencia != null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia6">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle7.evidencia != null?'required':detalle7.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia6"
										name="evidencia6" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo6" id="rutaArchivo6"
										name="rutaArchivo6" value="${detalle7.evidencia != null ? detalle7.evidencia : detalle7.evidencia == 'N/A' ? detalle7.evidencia : ''}" />
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
						 </div>
						 			<div id="VerArchivoEvdidencia6" class="form-group row" 
										style="display:${detalle7.evidencia == null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}">
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
						 		<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz6"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu6">
					
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
							<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz7"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
					<input type="hidden" id="id_informe_8" name="id_informe_8" value="${detalle8.idInfCal}">
						<input type="hidden" id="id_informe_9" name="id_informe_9" value="${detalle9.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="7">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this,divevidencia7,rutaArchivo7);"
										id="cmbPregunta8" required="required" name="cmbPregunta8">
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
							<div id="divevidencia7" style="display:${detalle8.evidencia != null ? 'none' : detalle8.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia7">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle8.evidencia != null?'required':detalle8.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia7"
										name="evidencia7" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo7" id="rutaArchivo7"
										name="rutaArchivo7"  value="${detalle8.evidencia != null ? detalle8.evidencia : detalle8.evidencia == 'N/A' ? detalle8.evidencia : ''}"/>
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
							</div>
							<div id="VerArchivoEvdidencia7" class="form-group row" 
										style="display:${detalle8.evidencia == null ? 'none' : detalle8.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia7">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink6" target="_blank"
													href="${rutaArchivosAplicacion}${detalle8.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink7" id="evidenciaRutaLink7"
													value="${detalle8.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer7">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6">¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm" onchange="adjuntarEvidencias(this,divevidencia8,rutaArchivo8);"
										id="cmbPregunta9" required="required" name="cmbPregunta9">
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
							<div id="divevidencia8" style="display:${detalle9.evidencia != null ? 'none' : detalle9.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia8">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle9.evidencia != null?'required':detalle9.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia8"
										name="evidencia8" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo8" id="rutaArchivo8"
										name="rutaArchivo8"  value="${detalle9.evidencia != null ? detalle9.evidencia : detalle9.evidencia == 'N/A' ? detalle9.evidencia : ''}"/>
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
										class="EliminarArchivo8 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo8" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
								<div id="VerArchivoEvdidencia8" class="form-group row" 
										style="display:${detalle9.evidencia == null ? 'none' : detalle9.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia8">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink8" target="_blank"
													href="${rutaArchivosAplicacion}${detalle9.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink8" id="evidenciaRutaLink8"
													value="${detalle9.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer8">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
							 		<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz7"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					
				<div class="tab-pane container fade" id="menu4">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES</h5>
						<div class="card-body">
						
								<table id="tablaRegistrosCOT" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
			
					<tr>
						<th >#</th>
						<th width="10%" style="text-align: center; font-size:x-small;">LABORALES</th>
						<th width="10%" style="text-align: center; font-size:x-small;">TRIBUTARIAS</th>
						<th width="80%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			    </table>
			     <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz5"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
					<input type="hidden" id="id_informe_5" name="id_informe_5" value="${detalle5.idInfCal}">
					<input type="hidden" id="id_informe_6" name="id_informe_6" value="${detalle6.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="5">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
                      <div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencias(this,divevidencia4,rutaArchivo4);"
										id="cmbPregunta5" required="required" name="cmbPregunta5">
										<option value="">Seleccione...</option>
										<option value="1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI">1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI</option>
										<option value="2. CERTIFICADO EMITIDO POR SRI Y SENAE">2. CERTIFICADO EMITIDO POR SRI Y SENAE</option>
										<option value="3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA CIUDADANÍA NO PARTICIPÓ">3. LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD DONDE SE DEMUESTRA QUE LA	CIUDADANÍA NO PARTICIPÓ</option>
										<option value="4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE	VERIFICACIÓN</option>
										<option value="5. NO APLICA">5. NO APLICA</option>
										<option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
										<option value="7. VACÍO">7. VACÍO</option>
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
									<input type="file" "${detalle5.evidencia != null?'required':detalle5.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia4"
										name="evidencia4" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo4" id="rutaArchivo4"
										name="rutaArchivo4" value="${detalle5.evidencia != null ? detalle5.evidencia : detalle5.evidencia == 'N/A' ? detalle5.evidencia : ''}"/>
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
								<div id="VerArchivoEvdidencia4" class="form-group row" 
										style="display:${detalle5.evidencia == null ? 'none' : detalle5.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia4">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink4" target="_blank"
													href="${rutaArchivosAplicacion}${detalle5.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
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
									<label for="pregunta6">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES LABORALES?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencias(this,divevidencia5,rutaArchivo5);"
										id="cmbPregunta6" required="required" name="cmbPregunta6">
										<option value="">Seleccione...</option>
										<option value="1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS">1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS</option>
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
							<div id="divevidencia5" style="display:${detalle6.evidencia != null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia4">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle6.evidencia != null?'required':detalle6.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia5"
										name="evidencia5" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo5" id="rutaArchivo5"
										name="rutaArchivo5" value="${detalle6.evidencia != null ? detalle6.evidencia : detalle6.evidencia == 'N/A' ? detalle6.evidencia : ''}" />
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
									<div id="VerArchivoEvdidencia5" class="form-group row" 
										style="display:${detalle6.evidencia == null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia5">Archivo de Verificación
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
									<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz5"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu7">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR</h5>
						<div class="card-body">
						
						
						
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
					 <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz8"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
				<input type="hidden" id="id_informe_10" name="id_informe_10" value="${detalle10.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="8">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7">¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  onchange="adjuntarEvidencias(this, divevidencia9,rutaArchivo9);"
										id="cmbPregunta10" required="required" name="cmbPregunta10">
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
							<div id="divevidencia9" style="display:${detalle10.evidencia != null ? 'none' : detalle10.evidencia == 'N/A' ? 'none' : 'visible'}">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="evidencia9">Adjuntar captura de pantalla de
										la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
										.docx</label>
								</div>
								<div class="col-md-5 text-left waves-effect float-left">
									<input type="file" "${detalle10.evidencia != null?'required':detalle10.evidencia == 'N/A' ? 'required' : ' '}"
										class="form-control-file archivo gris" id="evidencia9"
										name="evidencia9" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

									<div class="estadoCarga">En espera de archivo... (Tamaño
										máximo ${tamanioArchivo})</div>
									<input type="hidden" class="rutaArchivo9" id="rutaArchivo9"
										name="rutaArchivo9" value="${detalle10.evidencia != null ? detalle10.evidencia : detalle10.evidencia == 'N/A' ? detalle10.evidencia : ''}"/>
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
										class="EliminarArchivo9 adjunto btn _eliminarColor btn-sm"
										id="EliminarArchivo9" disabled="disabled">
										<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
									</button>
								</div>

							</div>
							</div>
								<div id="VerArchivoEvdidencia9" class="form-group row" 
										style="display:${detalle10.evidencia == null ? 'none' : detalle10.evidencia == 'N/A' ? 'none' : 'visible'}">
											<div class="col-md-3 text-left">
												<label for="linkEvidencia9">Archivo de Verificación
												</label>
											</div>
											<div class="col-md-3 text-left">
												<a id="evidenciaLink9" target="_blank"
													href="${rutaArchivosAplicacion}${detalle10.evidencia}" class="archivoCargado">Click
													aquí para ver archivo</a> <input type="hidden"
													name="evidenciaRutaLink9" id="evidenciaRutaLink9"
													value="${detalle10.evidencia}">
											</div>
											<div class="col-md-3 text-left">
												<button type="button"
													class="adjunto btn _eliminarColor btn-sm"
													id="EliminarArchiServer9">
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
									<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz8"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu8">
					
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
							 <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz9"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
				<input type="hidden" id="id_informe_11" name="id_informe_11" value="${detalle11.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="9">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</label>
								</div>
								<div class="col-md-3 text-left">
									
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta11" required="required" name="cmbPregunta11">
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
								<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz9"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu9">
					
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
								 <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatriz10"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionFEEP"
					data-destino="detalleItem" data-accionEnExito=" ">
						<input type="hidden" id="id_informe_12" name="id_informe_12" value="${detalle12.idInfCal}">
						<input type="hidden" id="id_informe_13" name="id_informe_13" value="${detalle13.idInfCal}">
						<input type="hidden" id="id_informe_14" name="id_informe_14" value="${detalle14.idInfCal}">
						<input type="hidden" id="id_informe_15" name="id_informe_15" value="${detalle15.idInfCal}">
						<input type="hidden" id="id_informe_16" name="id_informe_16" value="${detalle16.idInfCal}">
					<input type="hidden" name="matriz"
						id="matriz" value="10">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
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
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</label>
								</div>
								<div class="col-md-3 text-left">
									<!-- <select class="custom-select custom-select-sm"  onchange="adjuntarEvidenciaMultiple(divevidencia7);" -->
									<select class="custom-select custom-select-sm" 
										id="cmbPregunta14" required="required" name="cmbPregunta14">
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
										id="cmbPregunta15" required="required" name="cmbPregunta15">
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
										id="cmbPregunta16" required="required" name="cmbPregunta16">
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
	
									<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarMatriz10"
							class="btn _nuevoColor _guardar btn-sm mt-2 valoracionbtn" >Guardar</button>
					</div>
				</form:form>
						</div>
					</div>
					
					</div>
					<div class="tab-pane container fade" id="menu10">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Observación</h5>
						<div class="card-body">
						             <form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formulariomatrizFinal"
					data-rutaAplicacion="rendicion/valoracion" data-opcion="FinalizarValoracionFEEP"
					data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">
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

                            	<div class="col-md-12 text-center">
									<button type="submit" id="btnGuardarFinalizar"
										class="btn _imprimirColor _guardar btn-sm mt-2 Oculta">Finalizar Evaluación</button>
					</div>
					</form:form>
						</div>
					</div>
					
					</div>
				</div>


					
			</div>
		</div>
	</div>
</div>
</html>

<script type="text/javascript">
var retornoJson;
	$(document).ready(function() {
		cargarValorComboPorDefecto("cmbpregunta1",'${detalle1.respuesta}');						
	});
	
	$('a[data-toggle="pill"]').on('click', function(event) {
		//cargarDatos();
		var x = $(this).attr('href');
		switch (x) {
		 case '#home':
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_1").val());	
	      break;
		  case '#menu1':
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_2").val());
			  tablaEjecucionPresupuestaria();  			
	      break;
		  case '#menu2':
			  tablaBalanceGeneral();
			     validarPreguntaInforme($("#infcod").val(), $("#id_informe_3").val());
			 
	      break;
		  case '#menu3':
			  tablaProcesosContratacion();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_4").val());
			 
	      break;
		  case '#menu4':
			  tablaCOT();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_5").val());    			 
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_6").val());
	      break;
		  case '#menu5':
			  tablaMecanismosParticionCiudadanaFE();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_7").val());
			
	      break;
		  case '#menu6':
			  tablaPRFE();
				tablaPRFE2();
				 validarPreguntaInforme($("#infcod").val(), $("#id_informe_8").val());
				
				 validarPreguntaInforme($("#infcod").val(), $("#id_informe_9").val());
				
	      break;
		  case '#menu7':
			  tablaIncorporacionRecomenFE();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_10").val());
  			  
	      break;
		  case '#menu8':
			  tablaControlSocialFE();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_11").val());
			 
	      break;
		  case '#menu9':
			  TablaImpleIgualdadFE();
			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_12").val());
  			  validarPreguntaInforme($("#infcod").val(), $("#id_informe_13").val());
  			validarPreguntaInforme($("#infcod").val(), $("#id_informe_14").val());
				validarPreguntaInforme($("#infcod").val(), $("#id_informe_15").val());
  			validarPreguntaInforme($("#infcod").val(), $("#id_informe_16").val());			  
			  
	      break;
		  case '#menu10':		  
			  cargarDatos();
	      break;
		}
		
	});

	function tablaEjecucionPresupuestaria() {
		var parametros = {
			"infCod" : $("#infcod").val()
		};
		$('#TablaActualizarDetallePoa').DataTable(
						{
                         ajax : {
								data : parametros,
								url : "obtenerActualizarDetallePoa",
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

												paging : false,
												info : false,
												searching : false,	
												bDestroy : true,
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
							paging : false,
							info : false,
							searching : false,	
							bDestroy : true,
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
							paging : false,
							info : false,
							searching : false,	
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
								paging : false,
								info : false,
								searching : false,	
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
							paging : false,
							info : false,
							searching : false,	
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
							paging : false,
							info : false,
							searching : false,	
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

			} else {
				estado
						.html('Formato incorrecto, solo se admite archivos en formato PDF');
				archivo.val("");
			}
		});

$('button.EliminarArchivo6').click(function(event) {
	var boton = $(this);
	var estado = boton.parent('div').parent('div').find(".estadoCarga");
	var archivourl = $("#rutaArchivo6").val();
	var rutaArchivo = boton.parent('div').parent('div').find(".rutaArchivo6");
	var archivo = boton.parent('div').parent('div').find(".archivo");
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
			var nombreNuevoArchivo = $("#identificadorResponsable")	.val()
					+ "_evidencia-7-"+ fecha.getFullYear()
					+ "_"	+ (fecha.getMonth() + 1)
					+ "_"+ fecha.getDate()
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
			var nombreNuevoArchivo = $("#identificadorResponsable")	.val()
					+ "_evidencia-8-"+ fecha.getFullYear()
					+ "_"	+ (fecha.getMonth() + 1)
					+ "_"+ fecha.getDate()
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
			".rutaArchivo7");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo8').removeAttr("disabled");
	$('#evidencia8').val('');
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
			var nombreNuevoArchivo = $("#identificadorResponsable")	.val()
					+ "_evidencia-9-"+ fecha.getFullYear()
					+ "_"	+ (fecha.getMonth() + 1)
					+ "_"+ fecha.getDate()
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
			".rutaArchivo7");
	var archivo = boton.parent('div').parent('div')
			.find(".archivo");
	EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
			estado, archivo, boton));
	$('#subirArchivo9').removeAttr("disabled");
	$('#evidencia9').val('');
});
$("button.valoracionbtn").click(function(event) {
		
		var x = this.form.id
		var form;
          switch (x) {		
		case 'formulariomatriz1':
			 form = $("#formulariomatriz1");
		break;
		case 'formulariomatriz2':
			 form = $("#formulariomatriz2");
		break;
		case 'formulariomatriz3':
			 form = $("#formulariomatriz3");
		break;
		case 'formulariomatriz4':
			 form = $("#formulariomatriz4");
		break;
		case 'formulariomatriz5':
			 form = $("#formulariomatriz5");
		break;
		case 'formulariomatriz6':
			 form = $("#formulariomatriz6");
		break;
		case 'formulariomatriz7':
			 form = $("#formulariomatriz7");
		break;
        case 'formulariomatriz8':
	     form = $("#formulariomatriz8");
         break;
          case 'formulariomatriz9':
	      form = $("#formulariomatriz9");
          break;
          case 'formulariomatriz10':
	      form = $("#formulariomatriz10");
          break;
          }
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							 if(x=="formulariomatriz1"){
								 ejecutarJson(form);
								 cargarDatos();
							 }else if(x=="formulariomatriz7"){
								 
								 if(ValidarArchivo('evidencia7')==false ){
									 $("#evidencia7").addClass('rojo');
									 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
								     }else if(ValidarArchivo('evidencia8')==false) {				    	
								    	 $("#evidencia8").addClass('rojo');			    	 
								    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
								     }else{
								    	 ejecutarJson(form);
										 cargarDatos();
								     }
							 }else if(x=="formulariomatriz5"){
								 
								 if(ValidarArchivo('evidencia4')==false ){
									 $("#evidencia4").addClass('rojo');
									 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");					
								     }else if(ValidarArchivo('evidencia5')==false) {				    	
								    	 $("#evidencia5").addClass('rojo');			    	 
								    	 mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
								     }else{
								    	 ejecutarJson(form);
										 cargarDatos();
								     }
							 }
							 else{
								 const articles = form.parent('div').parent('div').find(".archivo");						
								console.log(articles);	
								 if(articles.length>0){
										if(ValidarArchivo(articles[0].id)){
											 ejecutarJson(form);
											 cargarDatos();
										
										     } else {	
										    	$("#"+articles[0].id).addClass('rojo');
												mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
					
										     }	
									}else{
										ejecutarJson(form);
										 cargarDatos();
									}
							 }
											
						}
						form.addClass('was-validated');
						
					});
					
	function cargarDatos(){
		validarIdInforme($("#infcod").val());
		$("#id_informe_1").val("${detalle1.idInfCal}");
		$("#id_informe_2").val("${detalle2.idInfCal}");
		$("#id_informe_3").val("${detalle3.idInfCal}");
		$("#id_informe_4").val("${detalle4.idInfCal}");
		$("#id_informe_5").val("${detalle5.idInfCal}");
		$("#id_informe_6").val("${detalle6.idInfCal}");
		$("#id_informe_7").val("${detalle7.idInfCal}");
		$("#id_informe_8").val("${detalle8.idInfCal}");
		$("#id_informe_9").val("${detalle9.idInfCal}");
		$("#id_informe_10").val("${detalle10.idInfCal}");
		$("#id_informe_11").val("${detalle11.idInfCal}");
		$("#id_informe_12").val("${detalle12.idInfCal}");
		$("#id_informe_13").val("${detalle13.idInfCal}");
		$("#id_informe_14").val("${detalle14.idInfCal}");
		$("#id_informe_15").val("${detalle15.idInfCal}");
		$("#id_informe_16").val("${detalle16.idInfCal}");
	}
	function adjuntarEvidencias(select,div,archivo) {
		HiddeFileDiv(select,div);
		$("#"+archivo.id).val(null);
	}
	
	
	function validarIdInforme(idInforme) {
		var parametros = {
				infCod : idInforme
			};
			
			$.ajax({
				url : "ObtenerPreguntasOrden",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : 'GET',
				//async: false,
				dataType : 'json',
				data : parametros,
				success : function(respuestaJson) {                  
					$.each(respuestaJson.data, function(index, detalle) {
						if(detalle.orden=="1"){
							$("#id_informe_1").val(detalle.idInfCal);
						}else if (detalle.orden=="2")
						{$("#id_informe_2").val(detalle.idInfCal);
						$("#divevidencia1").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia1").show();	
						$('#evidenciaLink1').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink1").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="3")
						{$("#id_informe_3").val(detalle.idInfCal);
						$("#divevidencia2").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia2").show();	
						$('#evidenciaLink2').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink2").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="4")
						{$("#id_informe_4").val(detalle.idInfCal);
						$("#divevidencia3").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia3").show();	
						$('#evidenciaLink3').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink3").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="5")
						{$("#id_informe_5").val(detalle.idInfCal);
						$("#divevidencia4").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){
								$("#VerArchivoEvdidencia4").show();		
						$('#evidenciaLink4').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink4").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="6")
						{$("#id_informe_6").val(detalle.idInfCal);
						$("#divevidencia5").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia5").show();	
						$('#evidenciaLink5').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink5").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="7")
						{$("#id_informe_7").val(detalle.idInfCal);
						$("#divevidencia6").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){
								$("#VerArchivoEvdidencia6").show();		
						$('#evidenciaLink6').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink6").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="8")
						{$("#id_informe_8").val(detalle.idInfCal);
						$("#divevidencia7").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia7").show();	
						$('#evidenciaLink7').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink6").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="9")
						{$("#id_informe_9").val(detalle.idInfCal);
						$("#divevidencia8").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia8").show();	
						$('#evidenciaLink8').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink8").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="10")
						{$("#id_informe_10").val(detalle.idInfCal);
						$("#divevidencia9").hide();
						 if(detalle.evidencia !="N/A" && detalle.evidencia !=""){	
								$("#VerArchivoEvdidencia9").show();	
						$('#evidenciaLink9').attr('href', '${rutaArchivosAplicacion}'+detalle.evidencia);							
						 $("#evidenciaRutaLink9").val(detalle.evidencia);
						 }
						}
						else if (detalle.orden=="11")
						{$("#id_informe_11").val(detalle.idInfCal);
						}
						else if (detalle.orden=="12")
						{$("#id_informe_12").val(detalle.idInfCal);
						}
						else if (detalle.orden=="13")
						{$("#id_informe_13").val(detalle.idInfCal);
						}
						else if (detalle.orden=="14")
						{$("#id_informe_14").val(detalle.idInfCal);
						}
						else if (detalle.orden=="15")
						{$("#id_informe_15").val(detalle.idInfCal);
						}
						else if (detalle.orden=="16")
						{$("#id_informe_16").val(detalle.idInfCal);
						}
					});
					if(respuestaJson.data.length==16){
						$("#btnGuardarFinalizar").show();
					}else{
						$("#btnGuardarFinalizar").hide();
					}
				},
				error : function(result) {
					mostrarMensaje("Consulta no encontrada !",
							"ERROR-NOTIFICACION", "3000");

				}
			});
	}
	
	$("#btnGuardarFinalizar").click(function(event) {
		var form = $("#formulariomatrizFinal")
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
	
	
	function tablaBalanceGeneral() {
		var parametros = {
				"infCod" : $("#infcod").val()
			};
		$('#tablaRegistrosBalanceGeneral').DataTable( {   
			ajax: {
			     data:parametros,
				url:"obtenerRegistrosInformacionFinanciera",
				headers: {"X-CSRF-TOKEN": csrfToken},
			  	type:"POST"
				  },paging : false,
					info : false,
					searching : false,	
					bDestroy : true,
		    columns : [
				{data : "contador" },
				{data : "activo"},
				{data : "pasivos"},
				{data : "patrimonio"},
				{data : "link",
					render : function(data) {
						if (data === "NO APLICA"
								|| data === "S/N") {
						} else {
							data = '<a href="' + data + '" style="color:blue;" target="_blank">'
									+ data + '</a>';
						}

						return data;
					}
	    }  ],
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
	function tablaCOT() {
		var parametros = {
				"infCod" : $("#infcod").val()
			};
		$('#tablaRegistrosCOT').DataTable( {   
			ajax: {
			     data:parametros,
				url:"obtenerRegistrosCumplimientoInformacion",
				headers: {"X-CSRF-TOKEN": csrfToken},
			  	type:"POST"
				  },paging : false,
					info : false,
					searching : false,	
					bDestroy : true,
		    columns : [
				{data : "contador" },
				{data : "laborales"},
				{data : "tributarios"},
				{data : "link",
					render : function(data) {
						if (data === "NO APLICA"
								|| data === "S/N") {
						} else {
							data = '<a href="' + data + '" style="color:blue;" target="_blank">'
									+ data + '</a>';
						}

						return data;
					}}  ],
				language: {
		              url: "resources/json/lenguajeTablaDataTable.json"
		          },
			createdRow: function( row, data, dataIndex ) {
			     $(row).attr('id', data.CumOblCod);
		       $(row).attr('ondragstart', 'drag(event)');
		       $(row).attr('draggable', 'false');
		       $(row).attr('data-destino', 'detalleItem');
		       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		       $(row).find("td").css({
					"font-size"   : "x-small",			
				});	

				$(row).find("td").css({
					"vertical-align" : "middle",
				});	
			                },
		    } );


	}
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
			//async : false,
			dataType : 'json',
			data : parametros,
			success : function(respuestaJson) {		
				retornoJson = respuestaJson;		
				var valores =retornoJson.orden;
				if(valores!==null){
					switch (valores) {
				
					case 2:
						cargarValorComboPorDefecto("cmbPregunta2",retornoJson.respuesta);
						
					    break;
					case 3:
						cargarValorComboPorDefecto("cmbPregunta3",respuestaJson.respuesta);
						
					    break;
					case 4:
						cargarValorComboPorDefecto("cmbPregunta4",retornoJson.respuesta);
						//$("cmbpregunta4").find("option:selected").val(respuestaJson.respuesta);
						 
					    break;
					case 5:
						cargarValorComboPorDefecto("cmbPregunta5",respuestaJson.respuesta);
						
					    break;
					case 6:
						cargarValorComboPorDefecto("cmbPregunta6",respuestaJson.respuesta);
						
					    break;
					case 7:
						cargarValorComboPorDefecto("cmbPregunta7",respuestaJson.respuesta);
						
					    break;
					case 8:
						cargarValorComboPorDefecto("cmbPregunta8",respuestaJson.respuesta);
						
					    break;
					case 9:
						cargarValorComboPorDefecto("cmbPregunta9",respuestaJson.respuesta);
						
					    break;
					case 10:
						cargarValorComboPorDefecto("cmbPregunta10",respuestaJson.respuesta);
						
					    break;
					case 11:
						cargarValorComboPorDefecto("cmbPregunta11",respuestaJson.respuesta);
						
					    break;
					case 12:
						cargarValorComboPorDefecto("cmbPregunta12",respuestaJson.respuesta);
						
					    break;
					case 13:
						cargarValorComboPorDefecto("cmbPregunta13",respuestaJson.respuesta);
						
					    break;
					case 14:
						cargarValorComboPorDefecto("cmbPregunta14",respuestaJson.respuesta);
						
					    break;
					case 15:
						cargarValorComboPorDefecto("cmbPregunta15",respuestaJson.respuesta);
						
					    break;
					case 16:
						cargarValorComboPorDefecto("cmbPregunta16",respuestaJson.respuesta);
						
					    break;
					    
					  }
					}
			
			},
			error : function(result) {
				//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
			}
		});
	}
	$('#EliminarArchiServer1').click(function(event) {
		$("#VerArchivoEvdidencia1").hide();
		$("#divevidencia1").show();
		document.getElementById("evidencia1").required = true;
	var archivourl = $("#evidenciaRutaLink1").val();
	EliminarArchivo(archivourl, '', '', '');		
	$('#evidenciaLink1').attr('href', '');							
	$("#evidenciaRutaLink1").val('');

	});
	//Pregunta 3
	$('#EliminarArchiServer2').click(function(event) {	
		$("#VerArchivoEvdidencia2").hide();
		$("#divevidencia2").show();
		document.getElementById("evidencia2").required = true;
	var archivourl = $("#evidenciaRutaLink2").val();
	EliminarArchivo(archivourl, '', '', '');		
	$('#evidenciaLink2').attr('href', '');							
	$("#evidenciaRutaLink2").val('');

	});	
	$('#EliminarArchiServer3').click(function(event) {	
		$("#VerArchivoEvdidencia3").hide();
		$("#divevidencia3").show();
		document.getElementById("evidencia3").required = true;
	var archivourl = $("#evidenciaRutaLink3").val();
	EliminarArchivo(archivourl, '', '', '');	
	$('#evidenciaLink3').attr('href', '');							
	$("#evidenciaRutaLink3").val('');

	});


	$('#EliminarArchiServer4').click(function(event) {
		$("#VerArchivoEvdidencia4").hide();
		$("#divevidencia4").show();
		document.getElementById("evidencia4").required = true;
	var archivourl = $("#evidenciaRutaLink4").val();
	EliminarArchivo(archivourl, '', '', '');	
	$('#evidenciaLink4').attr('href', '');							
	$("#evidenciaRutaLink4").val('');		
	});

	$('#EliminarArchiServer5').click(function(event) {	
		$("#VerArchivoEvdidencia5").hide();
		$("#divevidencia5").show();
		document.getElementById("evidencia5").required = true;
	var archivourl = $("#evidenciaRutaLink5").val();
	EliminarArchivo(archivourl, '', '', '');	
	$('#evidenciaLink5').attr('href', '');							
	$("#evidenciaRutaLink5").val('');		
	});
	//Pregunta 6
	$('#EliminarArchiServer6').click(function(event) {	
		$("#VerArchivoEvdidencia6").hide();
		$("#divevidencia6").show();
		document.getElementById("evidencia6").required = true;
	var archivourl = $("#evidenciaRutaLink6").val();
	EliminarArchivo(archivourl, '', '', '');	
	$('#evidenciaLink6').attr('href', '');							
	$("#evidenciaRutaLink6").val('');		
	});


	//Pregunta 7
	$('#EliminarArchiServer7').click(function(event) {	
		$("#VerArchivoEvdidencia7").hide();
		$("#divevidencia7").show();
		document.getElementById("evidencia7").required = true;
	var archivourl = $("#evidenciaRutaLink7").val();
	EliminarArchivo(archivourl, '', '', '');	
	$('#evidenciaLink7').attr('href', '');							
	$("#evidenciaRutaLink7").val('');		
	});
	$('#EliminarArchiServer8').click(function(event) {	
		$("#VerArchivoEvdidencia8").hide();
		$("#divevidencia8").show();
		document.getElementById("evidencia8").required = true;
		var archivourl = $("#evidenciaRutaLink8").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink8').attr('href', '');							
		$("#evidenciaRutaLink8").val('');		
		});
	$('#EliminarArchiServer9').click(function(event) {	
		$("#VerArchivoEvdidencia9").hide();
		$("#divevidencia9").show();
		document.getElementById("evidencia9").required = true;
		var archivourl = $("#evidenciaRutaLink9").val();
		EliminarArchivo(archivourl, '', '', '');	
		$('#evidenciaLink9').attr('href', '');							
		$("#evidenciaRutaLink9").val('');		
		});
</script>
