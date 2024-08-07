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
									<label for="pregunta1"><span class="label success">¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta1"></label>
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
									<label id="respuesta2"></label>
								</div>
							</div>
								<div class="form-group row">
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
									<label for="pregunta3"><span class="label success">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta3"></label>
								</div>
							
							</div>

								<div class="form-group row">
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
									<label for="pregunta4"><span class="label success">¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta4"></label>
								</div>
							</div>
							
							<div class="form-group row">
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
								</div>	
							
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5"><span class="label success">¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta5"></label>
								</div>
							</div>
							<div class="form-group row">
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
									<label for="pregunta6"><span class="label success">¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta6"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7"><span class="label success">¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta7"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							
							
								<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8"><span class="label success">¿EL GAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta8"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta9"><span class="label success">¿EL GAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta9"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							
							
								<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta10"><span class="label success">¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta10"></label>
								</div>
							</div>
							<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>									
									<div class="col-md-9 text-left">										
												<span id="respuestaSinArchivo10" class="alerta Oculta">No ha subido ningún archivo aún</span>											
												<a href="" id ="respuestaConArchivo10"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>										
									</div>
								</div>

						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta11"><span class="label success">¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta11"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						</div>
					</div>
					
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PRESUPUESTO PARTICIPATIVO</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta12"><span class="label success">¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta12"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
							
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta13"><span class="label success">¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta13"></label>
								</div>
							</div>
							<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>									
									<div class="col-md-9 text-left">										
												<span id="respuestaSinArchivo13" class="alerta Oculta">No ha subido ningún archivo aún</span>											
												<a href="" id ="respuestaConArchivo13"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>										
									</div>
								</div>
						</div>
					</div>
					
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">DETALLE DEL PRESUPUESTO PARTICIPATIVO</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta14"><span class="label success">¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta14"></label>
								</div>
							</div>
						
							<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>									
									<div class="col-md-9 text-left">										
												<span id="respuestaSinArchivo14" class="alerta Oculta">No ha subido ningún archivo aún</span>											
												<a href="" id ="respuestaConArchivo14"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>										
									</div>
								</div>
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">SISTEMA DE PARTICIPACIÓN CIUDADANA</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta15"><span class="label success">¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta15"></label>
								</div>
							</div>
						
							<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>									
									<div class="col-md-9 text-left">										
												<span id="respuestaSinArchivo15" class="alerta Oculta">No ha subido ningún archivo aún</span>											
												<a href="" id ="respuestaConArchivo15"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>										
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
									<label for="pregunta16"><span class="label success">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta16"></label>
								</div>
							</div>
							<div class="form-group row">
									<div class="col-md-3 text-left">
										<label for="archivoAdjunto">Archivo adjunto de la
											documentación de respaldo</label>
									</div>									
									<div class="col-md-9 text-left">										
												<span id="respuestaSinArchivo16" class="alerta Oculta">No ha subido ningún archivo aún</span>											
												<a href="" id ="respuestaConArchivo16"
													target="_blank" class="archivoCargado Oculta">Click
													aquí para ver archivo</a>										
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
									<label for="pregunta17"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta17"></label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta18"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta18"></label>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta19"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta19"></label>
								</div>
							</div>
													
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta20"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta20"></label>
								</div>
							</div>


							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta21"><span class="label success">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta21"></label>
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
		$('.Oculta').hide();
		obtenerdatosPreguntas();
		
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

				$.each(result.data, function (i, op) {
					console.log(op.respuesta);
					switch (op.pregunta) {
					case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
						$('#respuesta1').html(op.respuesta); 
					break;
					case'¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?':
						$('#respuesta2').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo2").show()
							 $('#respuestaConArchivo2').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo2").show();				
						 }		
					break;	
					case '¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':	
						$('#respuesta3').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo3").show()
							 $('#respuestaConArchivo3').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo3").show();				
						 }	

					break;
					case '¿EL GAD SUSTENTA LA CONFORMACIÓN DEL CONSEJO DE PLANIFICACIÓN?':	
						$('#respuesta4').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo4").show()
							 $('#respuestaConArchivo4').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo4").show();				
						 }		
					break;
					case '¿EL GAD SUSTENTA LA CONFORMACIÓN DE LA INSTANCIA DE PARTICIPACIÓN?':
						$('#respuesta5').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo5").show()
							 $('#respuestaConArchivo5').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo5").show();				
						 }	
					break;
					case '¿EL GAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA QUE SE RINDA CUENTAS?':						
						$('#respuesta6').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo6").show()
							 $('#respuestaConArchivo6').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo6").show();				
						 }	
					break;
					case '¿EL GAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?':						
						$('#respuesta7').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo7").show()
							 $('#respuestaConArchivo7').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo7").show();				
						 }	
					break;
					case '¿EL GAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?':	
						$('#respuesta8').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo8").show()
							 $('#respuestaConArchivo8').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo8").show();				
						 }	
	
					break;
					case '¿EL GAD SUSTENTA EL PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?':	
						$('#respuesta9').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo9").show()
							 $('#respuestaConArchivo9').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo9").show();				
						 }	
	
					break;
					case '¿EL GAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?':	
						$('#respuesta10').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo10").show()
							 $('#respuestaConArchivo10').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo10").show();				
						 }	

					break;
					case '¿EL GAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?':						
						$('#respuesta11').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo11").show()
							 $('#respuestaConArchivo11').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo11").show();				
						 }	
					break;
					
					case '¿EL GAD REALIZÓ EL PRESUPUESTO PARTICIPATIVO?':	
						$('#respuesta12').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo12").show()
							 $('#respuestaConArchivo12').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo12").show();				
						 }
	
					break;
					case '¿COINCIDEN LOS VALORES DEL PRESUPUESTO PARTICIPATIVO DEL FORMULARIO CON EL MEDIO DE VERIFICACIÓN?':	
						$('#respuesta13').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo13").show()
							 $('#respuestaConArchivo13').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo13").show();				
						 }

					break;
					case '¿EL GAD SUSTENTA LOS VALORES EJECUTADOS DEL PRESUPUESTO PARTICIPATIVO?':	
						$('#respuesta14').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo14").show()
							 $('#respuestaConArchivo14').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo14").show();				
						 }

					break;
					case '¿EL GAD SUSTENTA QUE MANTIENE ACTIVO EL SISTEMA DE PARTICIPACIÓN CIUDADANA?':		
						$('#respuesta15').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo15").show()
							 $('#respuestaConArchivo15').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo15").show();				
						 }
	
					break;
					case '¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':	
						$('#respuesta16').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo16").show()
							 $('#respuestaConArchivo16').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo16").show();				
						 }

					break;
					
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?':	
						$('#respuesta17').html(op.respuesta); 

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?':	
						$('#respuesta18').html(op.respuesta); 

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?':	
						$('#respuesta19').html(op.respuesta); 

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?':		
						$('#respuesta20').html(op.respuesta); 

					break;
					case '¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?':
						$('#respuesta21').html(op.respuesta); 

					break;

					}
				
				});			
			},
			error : function(result) {		
				mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");

			}
		});

	}



	
</script>
