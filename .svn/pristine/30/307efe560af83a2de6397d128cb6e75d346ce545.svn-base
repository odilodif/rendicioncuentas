<%-- 
	version		: 1.0
	Document  	: InformeGADVinculadoValorado
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
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<c:set var="rutaModuloRetroalimentacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<c:set var="periodo" value="<%=Constantes.periodo()%>" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<style>
.label {
	color: white;
	padding: 8px;
	font-family: Arial;
}

.success {
	background-color: #04AA6D;
} /* Green */
.info {
	background-color: #2196F3;
} /* Blue */
.warning {
	background-color: #ff9800;
} /* Orange */
.danger {
	background-color: #f44336;
} /* Red */
.other {
	background-color: #e7e7e7;
	color: black;
} /* Gray */
</style>
<div class="card text-center mb-card20" id="contenido">
	<div class="card-header ">
		<h5>RETROALIMENTACIÓN AL INFORME N°: ${infcod} DE RENDICIÓN DE CUENTAS DEL PERIODO ${infPeriodo}</h5>
	</div>
	<div class="card-header hidden" id="fecha-impresion">
		<h5>FECHA DE IMPRESIÓN: </h5>
	</div>
	<div class="card-body">

		<div class="row">

			<div class="col-md-12 order-md-1">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeCalificado" id="formularioEvaluacion"
					data-rutaAplicacion="rendicion" data-opcion="guardarEvaluacion"
					data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
					<input type="hidden" name="identificadorResponsable"
						id="identificadorResponsable" value="${identificadorResponsable}">

					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
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
								<div class="col-md-2 text-left">
									<label for="fechaFinInforme">Fecha de valoración del
										informe:</label>
								</div>
								<div class="col-md-6 text-left">
									<input type="text" class="form-control form-control-sm"
										id="fechaFinInforme" name="fechaFinInforme" disabled
										value="${fechaValoracion == null ? 'EN PROCESO' : fechaValoracion }" />
								</div>
							</div>

							<c:if test="${estadoInforme eq true}">
								<div class="form-group row">
									<div class="col-md-9 text-left">
										<label for="pregunta1"><span class="label success">¿LA
												ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO
												DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?</span></label>
									</div>
									<p>
										<br />
									</p>
									<div class="col-md-9 text-left">
										<label id="respuesta1"></label>
									</div>
								</div>
							</c:if>
							

						</div>
					</div>
					<p></p>
					<c:if test="${estadoInforme eq false}">
						<!-- Hide this div if estadoInforme is false -->
						<div class="card">
							<div class="card-body">
								<div class="form-group row">
									<!-- Content to show when estadoInforme is false -->
									<div class="col-md-9 text-left">
										<label for="respuesta"><span class="label danger">SU
												INFORME SE ENCUENTRA EN PROCESO DE VALORACIÓN</span></label>
									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${estadoInforme eq true}">
					<p></p>
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
									<label for="pregunta2"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta2"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo1==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo1}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
						</div>

					</div>

					<p></p>
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
									<label for="pregunta3"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta3"></label>
								</div>
							</div>

							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo2==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo2}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>

						</div>
					</div>

					<p></p>
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
									<label for="pregunta4"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN
											CIUDADANA?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta4"></label>
								</div>
							</div>


							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo3==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo3}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>

						</div>
					</div>

					<p></p>
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
									<label for="pregunta5"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS
											CUALES LA CIUDADANÍA SOLICITA SE RINDA CUENTAS?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta5"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo4==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo4}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y
											FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS
											DE ANTELACIÓN?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta6"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo5==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo5}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN
											PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta7"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo6==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo6}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8"><span class="label success">¿LA
											ENTIDAD SUSTENTA PLAN DE TRABAJO QUE INCORPORA LAS
											SUGERENCIAS CIUDADANAS EN SU GESTIÓN?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta8"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo7==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo7}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta9"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA
											CIUDADANA CON SU RESPECTIVO RECIBIDO?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta9"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo8==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo8}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
							DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS
							EN LA GESTIÓN INSTITUCIONAL</h5>
						<div class="card-body">
							<table id="TablaIncorporacionRecom"
								class="table table-striped table-bordered" style="width: 100%">
								<thead>
									<tr>
										<th>#</th>
										<th style="font-size: x-small;">SUGERENCIA DE LA
											COMUNIDAD</th>
										<th style="font-size: x-small;">RESULTADOS DE LA
											IMPLEMENTACIÓN DE LA SUGERENCIA CIUDADANA</th>
										<th style="font-size: x-small;">PORCENTAJE DE AVANCE DE
											LA IMPLEMENTACIÓN</th>
										<th style="font-size: x-small;">LINK AL MEDIO DE
											VERIFICACIÓN</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta10"><span class="label success">¿LA
											ENTIDAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS
											CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta10"></label>
								</div>
							</div>
							<%-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										<c:choose>
											<c:when test="${archivoRespaldo9==null}">
												<span class="alerta">No ha subido ningún archivo aún</span>
											</c:when>
											<c:otherwise>
												<a href="${rutaModuloRetroalimentacion}${archivoRespaldo9}"
													target="_blank" class="archivoCargado" id="archivoCargado">Click
													aquí para ver archivo</a>
												<br />
											</c:otherwise>
										</c:choose>
									</div>
								</div> --%>
						</div>
					</div>
					<p></p>
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
									<label for="pregunta11"><span class="label success">¿LA
											ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL
											SOCIAL?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta11"></label>
								</div>
							</div>
						</div>
					</div>

					<p></p>
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
									<label for="pregunta12"><span class="label success">¿LA
											ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE
											IGUALDAD EN GÉNERO?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta12"></label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta13"><span class="label success">¿LA
											ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE
											IGUALDAD GENERACIONAL?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta13"></label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14"><span class="label success">¿LA
											ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE
											IGUALDAD EN DISCAPACIDADES?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta14"></label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta15"><span class="label success">¿LA
											ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE
											IGUALDAD INTERCULTURAL?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta15"></label>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta16"><span class="label success">¿LA
											ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE
											IGUALDAD EN MOVILIDAD HUMANA?</span></label>
								</div>
								<p>
									<br />
								</p>
								<div class="col-md-9 text-left">
									<label id="respuesta16"></label>
								</div>
							</div>
						</div>
					</div>
					<p></p>
					<%-- <div class="card">
						<h5 class="card-header text-white carHeaderBlue">Observación</h5>
						<div class="card-body">
							<p>
								<br />
							</p>
							<div class="col-md-9 text-left">
								<label id="comentario">${comentario}</label>
							</div>


						</div>
					</div> --%>
						<div class="card">
							<div class="form-group row">

								<div class="col-md-6 text-left">
									<p>
										<br />
									</p>
									<label for="nombreInstitución">PORCENTAJE DE
										INFORMACIÓN CORRECTAMENTE PRESENTADA:</label>
								</div>
								<div class="col-md-2 text-left">

									<br /> <input type="text" class="form-control form-control-sm"
										id="nombreInstitución" name="nombreInstitución" disabled
										value="${porcentajeTotal} %" />
								</div>
							</div>
						</div>
					</c:if>
				</form:form>
			</div>
		</div>
	</div>
</div>
<div class="form-group row">
		<div class="col-md-12 text-center">
			<button onclick="printDiv('contenido')" class="btn _imprimirColor _imprimir btn-sm mt-2" type="submit">Imprimir Contenido</button>
		</div>
	</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		obtenerdatosPreguntas();
		//caegamos las tablas
		tablaEjecucionPresupuestaria();
		tablaProcesosContratacion();
		tablaMecanismosParticionCiudadanaFE();
		tablaPRFE();
		tablaIncorporacionRecomenFE();
		tablaPresupuestoParticipativo();
		TablaImpleIgualdadFE();
		tablaControlSocialFE();
		tablaDetallePresupuestoParticipativo();
		
		tablaSistemaParticipacionCiudadana();
	});

	function obtenerdatosPreguntas() {
		$('.Oculta').hide();
		const parametros = {
			"infCod" : $("#infcod").val()
		};
		$
				.ajax({
					url : 'ObtenerPreguntas',
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "GET",
					dataType : 'json',
					data : parametros,
					success : function(result) {
						$
								.each(
										result.data,
										function(i, op) {
											console.log(op.respuesta);
											switch (op.pregunta) {
											case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
												//$('#respuesta1').html(op.respuesta);
												if (op.respuesta==='SI') {
													$('#respuesta1').html('LA ENTIDAD PRESENTÓ SU INFORME DENTRO DEL PLAZO ESTABLECIDO');
												} else{
													$('#respuesta1').html('EL INFORME DEBE PRESENTARSE DENTRO DEL PLAZO ESTABLECIDO');
												}
												break;
											case '¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?':
												//$('#respuesta2').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ') || op.respuesta.includes('4. ')) {
												    $('#respuesta2').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN PRESUPUESTARIA DE LA ENTIDAD');
												} else {
												    $('#respuesta2').html(
											                'PARA VERIFICAR LA  EJECUCIÓN PRESUPUESTARIA SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS</li>' +
											                '<li>DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN</li>' +
											                '<li>INFORME DE GESTIÓN  FINANCIERA APROBADO POR LA AUTORIDAD COMPETENTE</li>' +
											                '<li>MATRIZ DE LOTAIP QUE SI DIRECCIONA A LA CÉDULA PRESUPUESTARIA</li>' +
											                '</ol>'
											            );
												} 
												break;
											case '¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':
												//$('#respuesta3').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ') || op.respuesta.includes('4. ') || op.respuesta.includes('5. ') || op.respuesta.includes('6. ')) {
												    $('#respuesta3').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LOS PROCESOS DE CONTRATACIÓN PÚBLICA DE LA ENTIDAD');
												} else {
												    $('#respuesta3').html(
											                'PARA VERIFICAR LA CONTRATACIÓN PÚBLICA SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>DOS (2) REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PÚBLICA , REMITIDOS A SERCOP</li>' +
											                '<li>LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP DE LA ENTIDAD QUE RINDE CUENTAS</li>' +
											                '<li>ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN DE LOS PROCESOS DE CONTRATACIÓN</li>' +
											                '<li>ACTA DEFINITIVA DE ENTREGA-RECEPCIÓN DE LOS PROCESOS </li>' +
											                '<li>MEMORANDO E INFORME OFICIAL DE CONTRATACIONES PÚBLICAS, QUE CONTENGA EL DETALLE DE LOS PROCESOS DEL AÑO</li>' +
											                '<li>MATRIZ DE LOTAIP QUE SI DIRECCIONE A TODOS LOS PROCESOS DE CONTRATACIÓN PÚBLICA</li>' +
											                '</ol>'
											            );
												}	
												break;
											case '¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?':
												//$('#respuesta4').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
												    $('#respuesta4').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA');
												} else if (op.respuesta.includes('3. ')) {
												    $('#respuesta4').html('ADEMÁS DEL ACTA DE REUNIONES, SE DEBE ADJUNTAR EL/LOS REGISTRO(S) DE ASISTENCIA PARA EVIDENCIAR LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA');
												} else {
												    $('#respuesta4').html(
											                'PARA VERIFICAR LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>ACTA/ MEMORIAS DE REUNIÓN DE LOS MECANISMOS DE PARTICIPACIÓN CIUDADANA Y EL/LOS REGISTRO(S) DE ASISTENCIA </li>' +
											                '<li>INFORME DE IMPLEMENTACIÓN ANUAL DE CADA MENCANISMO IMPLEMENTADO Y SU REGISTRO DE ASISTENCIAS </li>' +
											                '</ol>'
											            );
												} 
												break;
											case '¿LA ENTIDAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?':
												//$('#respuesta5').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
												    $('#respuesta5').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS');
												} else {
												    $('#respuesta5').html(
											                'PARA VERIFICAR LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS, SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS (FÍSICO O DIGITAL), DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO</li>' +
											                '<li>RESPALDO DE TEMAS QUE LOS CIUDADANOS PRESENTARON A LA AUTORIDAD DE LA ENTIDAD, A TRAVÉS DE MECANISMOS DIGITALES, PARA QUE RINDA CUENTAS</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?':
												//$('#respuesta6').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
												    $('#respuesta6').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA ENTREGA DEL INFORME PRELIMINAR Y EL FORMULARIO DE RENDICIÓN DE CUENTAS CON 15 DÍAS DE ANTELACIÓN');
												} else {
												    $('#respuesta6').html(
											                'PARA VERIFICAR LA ENTREGA DEL INFORME PRELIMINAR Y EL FORMULARIO DE RENDICIÓN DE CUENTAS, SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>DOCUMENTO DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMA HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN</li>' +
											                '<li>ENVÍO VIRTUAL DEL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA ENTIDAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?':
												//$('#respuesta7').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
												    $('#respuesta7').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DEL ESPACIO DE RENDICIÓN DE CUENTAS');
												} else {
												    $('#respuesta7').html(
											                'PARA VERIFICAR LA EJECUCIÓN DEL ESPACIO DE RENDICIÓN DE CUENTAS SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD, DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI TUVO TIEMPO PARA EVUAR A LA ENTIDAD</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?':
												//$('#respuesta8').html(op.respuesta);
												if (op.respuesta.includes('1. ')) {
												    $('#respuesta8').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR QUE EL PLAN DE TRABAJO INCORPORA LAS SUGERENCIAS CIUDADANAS');
												} else {
												    $('#respuesta8').html(
											                'PARA VERIFICAR QUE EL PLAN DE TRABAJO INCORPORA LAS SUGERENCIAS CIUDADANAS, SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN:  <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>DOCUMENTO DEL PLAN DE TRABAJO DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?':
												//$('#respuesta9').html(op.respuesta);
												if (op.respuesta.includes('1. ')) {
												    $('#respuesta9').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR QUE EL PLAN DE TRABAJO INCORPORA LAS SUGERENCIAS CIUDADANAS');
												} else {
												    $('#respuesta9').html(
											                'PARA VERIFICAR QUE SE ENTREGÓ A LA ASAMBLEA CIUDADANA EL PLAN DE TRABAJO , SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>DOCUMENTO(S) DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA/ CIUDADANÍA, EL CONSEJO E INSTANCIA DE PARTICIPACIÓN</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?':
												//$('#respuesta10').html(op.respuesta);
												if (op.respuesta.includes('1. ')) {
												    $('#respuesta10').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR QUE EL PLAN DE TRABAJO INCORPORA LAS SUGERENCIAS CIUDADANAS');
												} else {
												    $('#respuesta10').html(
											                'PARA VERIFICAR QUE SE ENTREGÓ A LA ASAMBLEA CIUDADANA EL PLAN DE TRABAJO , SE DEBE COLOCAR COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>DOCUMENTO(S) DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA/ CIUDADANÍA, EL CONSEJO E INSTANCIA DE PARTICIPACIÓN</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':
												//$('#respuesta11').html(op.respuesta);
												if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
												    $('#respuesta11').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DE MECANISMOS DE CONTROL SOCIAL');
												} else if (op.respuesta.includes('3. ')) {
												    $('#respuesta11').html('ADEMÁS DEL ACTA DE REUNIONES, SE DEBE ADJUNTAR EL/LOS REGISTRO(S) DE ASISTENCIA PARA EVIDENCIAR LA EJECUCIÓN DE MECANISMOS DE CONTROL SOCIAL');
												} else if (op.respuesta.includes('OTROS, NO CUMPLE')) {
												    $('#respuesta11').html('LAS ENTIDADES QUE MANEJAN RECURSOS PÚBLICOS DEBEN RESPALDAR LAS INICIATIVAS DE CONTROL SOCIAL IMPULSADAS DE FORMA AUTÓNOMA POR LA CIUDADANÍA');
												} else {
												    $('#respuesta11').html(
											                'PARA VERIFICAR LA EJECUCIÓN DE MECANISMOS DE CONTROL SOCIAL SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN: <br>' +
											                '<ol style="padding-left: 20px; margin: 10px 0;">' +
											                '<li>ACTA/ MEMORIAS DE REUNIÓN DE LOS MECANISMOS DE CONTROL SOCIAL Y EL/LOS REGISTRO(S) DE ASISTENCIA</li>' +
											                '<li>INFORME DE IMPLEMENTACIÓN ANUAL DE CADA MENCANISMO IMPLEMENTADO Y SU REGISTRO DE ASISTENCIAS</li>' +
											                '</ol>'
											            );
												}
												break;
											case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?':
												//$('#respuesta12').html(op.respuesta);
												$('#respuesta12').html('LAS ENTIDADES DEL SECTOR PÚBLICO DEBEN FORMULAR Y ADOPTAR POLÍTICAS PARA ALCANZAR LA IGUALDAD ENTRE HOMBRES Y MUJERES, ADOPTANDO EL ENFOQUE DE GÉNERO EN SUS PLANES Y PROGRAMAS');
												break;
											case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?':
												//$('#respuesta13').html(op.respuesta);
												$('#respuesta13').html('LAS ENTIDADES DEL SECTOR PÚBLICOS DEBEN ADOPTAR MEDIDAS DE ACCIÓN AFIRMATIVA PARA PROMOVER LA IGUALDAD Y EL DESARROLLO INTERGENERACIONAL, EN FAVOR DE LOS TITULARES DE DERECHOS QUE SE ENCUENTREN EN SITUACIÓN DE DESIGUALDAD');
												break;
											case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?':
												//$('#respuesta14').html(op.respuesta);
												$('#respuesta14').html('LAS ENTIDADES DEL SECTOR PÚBLICOS DEBEN GARANTIZAR POLÍTICAS DE PREVENCIÓN DE LAS DISCAPACIDADES, LA EQUIPARACIÓN DE OPORTUNIDADES PARA PERSONAS CON DISCAPACIDAD Y SU INTEGRACIÓN SOCIAL');
												break;
											case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?':
												//$('#respuesta15').html(op.respuesta);
												$('#respuesta15').html('LAS ENTIDADES DEL SECTOR PÚBLICOS DEBEN ADOPTAR MEDIDAS PARA PROMOVER EL EJERCICIO DE DERECHOS DE LAS PERSONAS, APLICANDO EL PRINCIPIO DE INTERCULTURALIDAD');
												break;
											case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?':
												//$('#respuesta16').html(op.respuesta);
												$('#respuesta16').html('LAS ENTIDADES DEL SECTOR PÚBLICOS DEBEN ADOPTAR MEDIDAS PARA PROMOVER EL EJERCICIO DE DERECHOS DE LAS PERSONAS EN MOVILIDAD HUMANA');
												break;

											}
										});

					},
					error : function(result) {
						mostrarMensaje("Consulta no encontrada !",
								"ERROR-NOTIFICACION", "3000");

					}
				});

	}
	
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
				},	paging : false,
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
							},	paging : false,
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
		$('#TablaRendicionFases').DataTable({
					ajax : {
						data : parametros,
						url : "obtenerRendicionFases",
						headers : {
							"X-CSRF-TOKEN" : csrfToken
						},
						type : "POST"
					},	paging : false,
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
							},	paging : false,
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
								},	paging : false,
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
							},	paging : false,
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
							},	paging : false,
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
		paging : false,
		info : false,
		searching : false,	
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
		paging : false,
		info : false,
		searching : false,	
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
		paging : false,
		info : false,
		searching : false,	
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
	function printDiv(divId) {
var fechaActual = new Date().toLocaleString();
	    
	    // Actualiza el contenido del elemento <h5> con la fecha actual
	    document.getElementById('fecha-impresion').innerText = 'FECHA DE IMPRESIÓN: ' + fechaActual;
        var divContent = document.getElementById(divId).innerHTML;
        var myWindow = window.open('', '', 'width=800,height=600');

        myWindow.document.write('<html><head><title>Retroalimentación de Informes</title>');

        // Copia todos los estilos de la página
        var styles = document.querySelectorAll('style, link[rel="stylesheet"]');
        styles.forEach(function(style) {
            myWindow.document.write(style.outerHTML);
        });

        myWindow.document.write('</head><body>');
        myWindow.document.write(divContent);
        myWindow.document.write('</body></html>');
        myWindow.document.close();
        myWindow.focus();

        // Asegúrate de que los estilos se carguen antes de imprimir
        myWindow.onload = function() {
            myWindow.print();
            myWindow.close();
        };
    }
</script>
