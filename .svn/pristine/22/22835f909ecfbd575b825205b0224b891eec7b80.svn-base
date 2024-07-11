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
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<c:set var="rutaModuloRetroalimentacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
	<c:set var="periodo"
	value="<%=Constantes.periodo()%>" />
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
<div class="card text-center mb-card20">
	<div class="card-header ">
		<h5>Formulario para revisar la valoración de informes</h5>
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
										value="${fechaValoracion}" />
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta1"><span class="label success">¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodo}?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta1">${respuesta1}</label>
								</div>
							</div>

						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
							DE LA EJECUCIÓN PRESUPUESTARIA</h5>
						<div class="card-body">

						

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta2"><span class="label success">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta2">${respuesta2}</label>
								</div>
							</div>
									<div class="form-group row">
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
								</div>
						</div>

					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">BALANCE GENERAL</h5>
						<div class="card-body">

						

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3"><span class="label success">¿LA EMPRESA PÚBLICA PRESENTA SU BALANCE GENERAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta3">${respuesta3}</label>
								</div>
							</div>
									<div class="form-group row">
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
								</div>
						</div>

					</div>
					
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
							CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta4"><span class="label success">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta4">${respuesta4}</label>
								</div>
							
							</div>
						<div class="form-group row">
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
								</div>						
					</div>
					</div>
<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES</h5>
						<div class="card-body">
										


							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5"><span class="label success">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta5">${respuesta5}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6"><span class="label success">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES LABORALES?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta6">${respuesta6}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE PARTICIPACIÓN CIUDADANA</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7"><span class="label success">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta7">${respuesta7}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						</div>
					</div>


					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESO DE
							RENDICIÓN DE CUENTAS</h5>
						<div class="card-body">
										


							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8"><span class="label success">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta8">${respuesta8}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta9"><span class="label success">¿LA ENTIDAD SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta9">${respuesta9}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta10"><span class="label success">¿LA ENTIDAD SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta10">${respuesta10}</label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE CONTROL SOCIAL</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta11"><span class="label success">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta11">${respuesta11}</label>
								</div>
							</div>
						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">IMPLEMENTACIÓN
							DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta12"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta12">${respuesta12}</label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta13"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta13">${respuesta13}</label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta14">${respuesta14}</label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta15"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta15">${respuesta15}</label>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta16"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="respuesta16">${respuesta16}</label>
								</div>
							</div>
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Observación</h5>
						<div class="card-body">
							<p><br/></p>
								<div class="col-md-9 text-left">
									<label for="comentario">${comentario}</label>
								</div>


						</div>
					</div>

					
				</form:form>
			</div>
		</div>
	</div>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		
	});



	
</script>
