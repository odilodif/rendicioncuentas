<%-- 
	version		: 1.0
	Document  	: InformeMedioValorado
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
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<c:set var="rutaModuloRetroalimentacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />	
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
.success {background-color: #04AA6D;} /* Green */
.info {background-color: #2196F3;} /* Blue */
.warning {background-color: #ff9800;} /* Orange */
.danger {background-color: #f44336;} /* Red */ 
.other {background-color: #e7e7e7; color: black;} /* Gray */ 
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
								<div class="col-md-2 text-left">
									<label for="fechaFinInforme">Fecha de valoración del informe:</label>
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
						<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
							CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
						<div class="card-body">
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
									<label for="pregunta2"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta2"></label>
								</div>
							</div>
									<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo2" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo2"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
												
								
										
									</div>
								</div> -->
						</div>

					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES</h5>
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
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3"><span class="label success">¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta3"></label>
								</div>
							
							</div>
							
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo3" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo3"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
									</div>
								</div> -->
								<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3_1"><span class="label success">¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta3_1">${respuesta4}</label>
								</div>
							
							</div>
					<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo3_1" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo3_1"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
									</div>
								</div>					
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
									<label for="pregunta4"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta4"></label>
								</div>
							</div>
						<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo4" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo4"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
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
									<label for="pregunta5"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta5"></label>
								</div>
							</div>
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo5" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo5"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5_1"><span class="label success">¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta5_1"></label>
								</div>
							</div>
						<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo5_1" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo5_1"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
						</div>
					</div>

					<p></p>
					<div class="card">
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
									<label for="pregunta11"><span class="label success">¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta11"></label>
								</div>
							</div>
						<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo11" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo11"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
						</div>
					</div>
					<p></p>
					<div class="card">
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
									<label for="pregunta12"><span class="label success">¿EL MEDIO SUSTENTA SU BALANCE GENERAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta12"></label>
								</div>
							</div>
						<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo12" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo12"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
						</div>
					</div>

					<p></p>
					<div class="card">
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
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6"><span class="label success">¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta6"></label>
								</div>
							</div>
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo6" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo6"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6_1"><span class="label success">¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta6_1"></label>
								</div>
							</div>
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo6_1" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo6_1"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
						
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">TIPO DE DERECHOS DE AUTORES APROBADOS POR EL SENADI</h5>
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
									<label for="pregunta7"><span class="label success">¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta7"></label>
								</div>
							</div>
			
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo7" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo7"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL</h5>
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
									<label for="pregunta8"><span class="label success">¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta8"></label>
								</div>
							</div>
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo8" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo8"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
							
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL INDEPENDIENTE</h5>
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
									<label for="pregunta9"><span class="label success">¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta9">${respuesta14}</label>
								</div>
							</div>
							<!-- <div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>
									<div class="col-md-9 text-left">
										
												<span id="respuestaSinArchivo9" class="alerta Oculta">No ha subido ningún archivo aún</span>
											
												<a href="" id ="respuestaConArchivo9"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>
										
									</div>
								</div> -->
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
									<label for="pregunta10"><span class="label success">¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta10"></label>
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
		$('.Oculta').hide();
		obtenerdatosPreguntas();
		tablaProcesosContratacion();
		tablaCumplimientoObligacionesTL();
		 tablaMecanismosParticionCiudadanaFE();
		 tablaPRFE();
		  tablaPRFE2();
		  tablaPC();
		  tablaPCPromoDerechos()
		  tablaPCParticipacion()
		  tablaPCDialogo()
		  obtenerdatosPreguntas();
		  tablaDA();
		  tablaPN();
		  tablaPI();
		  tablaControlSocialFE();
		  tablaIncorporacionRecomenFE();
		  tablaInformacionFinanciera();
		
	});
	function obtenerdatosPreguntas() {
		$('.Oculta').hide();
		const parametros = {"infCod" : $("#infcod").val() };
		$.ajax({
			url : 'ObtenerPreguntas',
			headers : {	"X-CSRF-TOKEN" : csrfToken},
			type : "GET",
			dataType : 'json',
			data : parametros,
			success : function(result) {				
			console.log("ingresa");
				$.each(result.data, function (i, op) {
					switch (op.pregunta) {
					case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
						//$('#respuesta1').html(op.respuesta); 
						if (op.respuesta==='SI') {
							$('#respuesta1').html('LA ENTIDAD PRESENTÓ SU INFORME DENTRO DEL PLAZO ESTABLECIDO');
						} else{
							$('#respuesta1').html('EL INFORME DEBE PRESENTARSE DENTRO DEL PLAZO ESTABLECIDO');
						}
					    break;
					case'¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':
						//$('#respuesta2').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ') || op.respuesta.includes('4. ') || op.respuesta.includes('5. ') || op.respuesta.includes('6. ') || op.respuesta.includes('7. ')) {
							$('#respuesta2').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LOS PROCESOS DE CONTRATACIÓN PÚBLICA DE LA ENTIDAD');
						} else{
							$('#respuesta2').html(
						    		'PARA VERIFICAR LA CONTRATACIÓN PÚBLICA EN MEDIOS PÚBLICOS SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>DOS (2) REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PÚBLICA , REMITIDOS A SERCOP</li>'+
						    		'<li>LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP DE LA ENTIDAD QUE RINDE CUENTAS</li>'+ 
						    		'<li>ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN DE LOS PROCESOS DE CONTRATACIÓN</li>'+
						    		'<li>ACTA DEFINITIVA DE ENTREGA-RECEPCIÓN DE LOS PROCESOS </li>'+
						    		'<li>MATRIZ DE LOTAIP QUE SI DIRECCIONE A TODOS LOS PROCESOS DE CONTRATACIÓN PÚBLICA</li>'+
						    		'</ol>'
						    );
						}
					break;	
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?':						
						//$('#respuesta3').html(op.respuesta); 
						if (op.respuesta.includes('1. ')) {
							$('#respuesta3').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LOS PROCESOS DE CONTRATACIÓN PÚBLICA DE LA ENTIDAD');
						} else{
							$('#respuesta3').html(
						    		'PARA VERIFICAR EL CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES CON EL SERVICIO DE RENTAS INTERNAS (SRI)</li>'+
						    		'<li>CERTIFICADO DE CUMPLIMIENTO DE OBLIGACIONES EMITIDO POR EL SRI Y EL SERVICIO NACIONAL DE ADUANAS (SENAE)</li>'+ 
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?':						
						//$('#respuesta3_1').html(op.respuesta); 
						if (op.respuesta.includes('1. ')) {
							$('#respuesta3_1').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR EL CUMPLIMIENTO DE OBLIGACIONES LABORALES DE LA ENTIDAD');
						} else{
							$('#respuesta3_1').html(
						    		'PARA VERIFICAR EL CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES CON EL SERVICIO DE RENTAS INTERNAS (SRI)</li>'+
						    		'<li>CERTIFICADO DE CUMPLIMIENTO DE OBLIGACIONES EMITIDO POR EL SRI Y EL SERVICIO NACIONAL DE ADUANAS (SENAE)</li>'+ 
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?':						
						//$('#respuesta4').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
							$('#respuesta4').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR EL CUMPLIMIENTO DE OBLIGACIONES LABORALES DE LA ENTIDAD');
						} if (op.respuesta.includes('3. ')) {
							$('#respuesta4').html('ADEMÁS DEL ACTA DE REUNIONES, SE DEBE ADJUNTAR EL/LOS REGISTRO(S) DE ASISTENCIA PARA EVIDENCIAR LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA');
						} else {
							$('#respuesta4').html(
						    		'PARA VERIFICAR LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>ACTA/ MEMORIAS DE REUNIÓN DE LOS MECANISMOS DE PARTICIPACIÓN CIUDADANA Y EL/LOS REGISTRO(S) DE ASISTENCIA</li>'+
						    		'<li>INFORME DE IMPLEMENTACIÓN ANUAL DE CADA MENCANISMO IMPLEMENTADO Y SU REGISTRO DE ASISTENCIAS</li>'+ 
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?':						
						//$('#respuesta5').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
							$('#respuesta5').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DEL ESPACIO DE RENDICIÓN DE CUENTAS');
						}else {
							$('#respuesta5').html(
						    		'PARA VERIFICAR LA EJECUCIÓN DEL ESPACIO DE RENDICIÓN DE CUENTAS SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>LINK AL VIDEO DEL ESPACIO DELIBERATIVO DE LA ENTIDAD, DONDE SE DEMUESTRA QUE LA CIUDADANÍA SI PARTICIPÓ</li>'+
						    		'<li>ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA EL LINK AL ESPACIO DELIBERATIVO Y LOS APORTES CIUDADANOS GENERADOS EN ESE ESPACIO</li>'+ 
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?':						
						//$('#respuesta5_1').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')) {
							$('#respuesta5_1').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA EN EL PROCESO DE RENDICIÓN DE CUENTAS');
						}else {
							$('#respuesta5_1').html(
						    		'PARA VERIFICAR LA EJECUCIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>ACTA DE REALIZACIÓN DEL EVENTO, QUE CONTENGA  LOS APORTES CIUDADANOS GENERADOS EN ESE ESPACIO</li>'+
						    		'<li>ACTA DE REALIZACIÓN DEL EVENTO, DONDE SE RECONOCE QUE NO HUBIERON APORTES/ ACUERDOS CON LA CIUDADANÍA</li>'+ 
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?':						
						//$('#respuesta6').html(op.respuesta); 
						$('#respuesta6').html('LOS MEDIOS DE COMUNICACIÓN DEBEN CONTAR CON UN PROYECTO COMUNICACIONAL (CUANDO TIENEN UNA CONCESIÓN DE  FRECUENCIA DEL ESPECTRO RADIOELÉCTRICO) O CON UN PLAN ESTRATÉGICO INSTITUCIONAL (PERIÓDICOS Y REVISTAS)');
						
					break;
					case '¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?':						
						//$('#respuesta6_1').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ') || op.respuesta.includes('4. ') || op.respuesta.includes('5. ')) {
							$('#respuesta6_1').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA EJECUCIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA EN EL PROCESO DE RENDICIÓN DE CUENTAS');
						}else {
							$('#respuesta6_1').html(
						    		'PARA VERIFICAR QUE LA PROGRAMACIÓN DEL MEDIO PROMUEVE EL ENFOQUE DE DERECHOS EN "DISCAPACIDADES", "INTERCULTURALIDAD" Y OTROS ENFOQUES, SE DEBE COLOCAR  COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>PARRILLA DE PROGRAMACIÓN DONDE SE EVIDENCIA LA EXISTENCIA DEL/LOS PROGRAMA(S) CON ENFOQUES DE DERECHOS, PARTICIPACIÓN Y/O DIÁLOGO</li>'+
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?':						
						//$('#respuesta7').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ')){
							$('#respuesta7').html('EL MEDIO DE VERIFICACIÓN COLOCADO SUSTENTA QUE CUMPLE CON LA NORMATIVA SOBRE LOS DERECHOS DE AUTOR');
						}else {
							$('#respuesta7').html(
						    		'PARA VERIFICAR QUE SE CUMPLE CON LA NORMATIVA SOBRE DERECHOS DE AUTOR, SE DEBE COLOCAR  COMO MEDIO DE VERIFICACIÓN ALGUNO DE LOS SIGUIENTES DOCUMENTOS: <br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>COMPROBANTE DE DERECHOS DE AUTOR REGISTRADOS POR EL MEDIO COMO "PRODUCCIÓN MUSICAL", "PRODUCCIÓN PERIDÍSTICA" Y "CONTENIDO PUBLICITARIO" EN SENADI</li>'+
						    		'<li>REGISTRO(S) DE PAGO(S) REALIZADOS A LOS GREMIOS DE AUTORES DE DERECHOS DE AUTOR (SAYCE, SOPROFON Y OTROS) POR EL USO DE LAS CREACIONES USADAS POR EL MEDIO</li>'+
						    		'</ol>'
						    );
						}
					break;
					case '¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?':						
						//$('#respuesta8').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')){
							$('#respuesta8').html('EL MEDIO DE VERIFICACIÓN COLOCADO SUSTENTA QUE CUMPLE CON LA NORMATIVA SOBRE PRODUCCIÓN AUDIOVISUAL NACIONAL');
						}else {
							$('#respuesta8').html(
						    		'PARA VERIFICAR QUE SE CUMPLE CON LA NORMATIVA SOBRE LA PRODUCCIÓN AUDIOVISUAL NACIONAL, SE DEBE COLOCAR  COMO MEDIO DE VERIFICACIÓN: <br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>FICHA TÉCNICA DEL/LOS PRODUCTO(S) COMUNICACIONAL(ES), QUE PERMITA VERIFICAR QUE SE TRATA DE UNA PRODUCCIÓN NACIONAL</li>'+
						    		'</ol>'
						    );
						} 
					break;
					case '¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?':						
						//$('#respuesta9').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ') || op.respuesta.includes('3. ')){
							$('#respuesta9').html('EL MEDIO DE VERIFICACIÓN COLOCADO SUSTENTA QUE CUMPLE CON LA NORMATIVA SOBRE PRODUCCIÓN AUDIOVISUAL NACIONAL');
						}else {
							$('#respuesta9').html(
						    		'PARA VERIFICAR QUE SE CUMPLE CON LA NORMATIVA SOBRE LA PRODUCCIÓN AUDIOVISUAL NACIONAL INDEPENDIENTE, SE DEBE COLOCAR  COMO MEDIO DE VERIFICACIÓN: <br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>FICHA TÉCNICA DEL/LOS PRODUCTO(S) COMUNICACIONAL(ES), QUE PERMITA VERIFICAR QUE SE TRATA DE UNA PRODUCCIÓN NACIONAL</li>'+
						    		'</ol>'
						    );
						}  
					break;
					case '¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?':						
						//$('#respuesta11').html(op.respuesta); 
						if (op.respuesta.includes('1. ') || op.respuesta.includes('2. ')){
							$('#respuesta11').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO DE RENDICIÓN DE CUENTAS PREVIO/ANTERIOR');
						}if (op.respuesta.includes('3. ')){
							$('#respuesta11').html('SI SU ENTIDAD MANEJA RECURSOS PÚBLICOS SE DEBE REPORTAR LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR. LAS ENTIDADES DEBEN REALIZAR CONVOCATORIAS PREVIAS Y AMPLIAS A SUS PROCESOS DE RENDICIÓN DE CUENTAS Y DEBEN PROPENDER A INCENTIVAR EL DEBATE SOBRE LA GESTIÓN REPORTADA EN SUS ESPACIOS DELIBERATIVOS. ');
						}else {
							$('#respuesta11').html(
						    		'PARA VERIFICAR LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR SE DEBE COLOCAR ALGUNO DE LOS SIGUIENTES DOCUMENTOS COMO MEDIO DE VERIFICACIÓN:<br>'+
						    		'<ol style="padding-left: 20px; margin: 10px 0;">' +
						    		'<li>ACTA, INFORME O DOCUMENTO OFICIAL QUE DEMUESTRE LA IMPLEMENTACIÓN DEL/LOS ACUERDO(S) </li>'+
						    		'</ol>'
						    );
						} 
					break;
					case '¿EL MEDIO SUSTENTA SU BALANCE GENERAL?':						
						//$('#respuesta12').html(op.respuesta); 
						if (op.respuesta.includes('1. ')){
							$('#respuesta12').html('EL MEDIO DE VERIFICACIÓN COLOCADO ES APROPIADO PARA VERIFICAR EL BALANCE GENERAL DE LA ENTIDAD');
						}else {
							$('#respuesta12').html('SE DEBE COLOCAR EL BALANCE GENERAL DE LA ENTIDAD PARA SU VERIFICACIÓN<br>');
						} 
					break;
					case '¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':						
						//$('#respuesta10').html(op.respuesta); 		
						$('#respuesta10').html(' LOS MEDIOS DE COMUNICACIÓN DEBEN CONTAR CON UN PROYECTO COMUNICACIONAL (CUANDO TIENEN UNA CONCESIÓN DE  FRECUENCIA DEL ESPECTRO RADIOELÉCTRICO) O CON UN PLAN ESTRATÉGICO INSTITUCIONAL (PERIÓDICOS Y REVISTAS) ');
						
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


	/*function printDiv(divId) {
        var content = document.getElementById(divId).innerHTML;
        var myWindow = window.open('', '', 'width=800,height=600');
        myWindow.document.write('<html><head><title>Imprimir Div</title>');
        //myWindow.document.write('<link rel="stylesheet" href="styles.css" type="text/css" />');
        // Copia todos los estilos de la página
            var styles = document.querySelectorAll('style, link[rel="stylesheet"]');
            for (var i = 0; i < styles.length; i++) {
                myWindow.document.write(styles[i].outerHTML);
            }
        myWindow.document.write('</head><body>');
        myWindow.document.write(content);
        myWindow.document.write('</body></html>');
        myWindow.document.close();
        myWindow.focus();
        myWindow.print();
        myWindow.close();
    }*/
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
        myWindow.document.write('<style> th { color: black !important; }</style>');
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
