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
						<h5 class="card-header text-white carHeaderBlue">PROCESOS DE
							CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
						<div class="card-body">

						

							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta2"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</span></label>
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
						<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS Y LABORALES</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta3"><span class="label success">¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?</span></label>
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
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta4"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</span></label>
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
						</div>
					</div>


					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">PROCESO DE
							RENDICIÓN DE CUENTAS</h5>
						<div class="card-body">
										


							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5"><span class="label success">¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?</span></label>
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
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta5_1"><span class="label success">¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta5_1"></label>
								</div>
							</div>
						<div class="form-group row">
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
								</div>
						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO	ANTERIOR</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta11"><span class="label success">¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?</span></label>
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
						<h5 class="card-header text-white carHeaderBlue">INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN)</h5>
						<div class="card-body">
							
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta12"><span class="label success">¿EL MEDIO SUSTENTA SU BALANCE GENERAL?</span></label>
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
						</div>
					</div>

					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">TIENE PROYECTO COMUNICACIONAL</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta6"><span class="label success">¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?</span></label>
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
									<label for="pregunta6_1"><span class="label success">¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta6_1"></label>
								</div>
							</div>
							<div class="form-group row">
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
								</div>
						
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">TIPO DE DERECHOS DE AUTORES APROBADOS POR EL SENADI</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta7"><span class="label success">¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?</span></label>
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
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta8"><span class="label success">¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?</span></label>
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
							
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL INDEPENDIENTE</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-9 text-left">
									<label for="pregunta9"><span class="label success">¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?</span></label>
								</div>
								<p><br/></p>
								<div class="col-md-9 text-left">
									<label id="respuesta9">${respuesta14}</label>
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
						</div>
					</div>
					<p></p>
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">MECANISMOS
							DE CONTROL SOCIAL</h5>
						<div class="card-body">
						
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
			console.log("ingresa");
				$.each(result.data, function (i, op) {
					switch (op.pregunta) {
					case '¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?':
						$('#respuesta1').html(op.respuesta); 
		
					    break;
					case'¿EL MEDIO SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?':
						$('#respuesta2').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo2").show()
							 $('#respuestaConArchivo2').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo2").show();				
						 }
					break;	
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES TRIBUTARIAS?':						
						$('#respuesta3').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo3").show()
							 $('#respuestaConArchivo3').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo3").show();				
						 }
					break;
					case '¿EL MEDIO JUSTIFICA EL CUMPLIMIENTO DE SUS OBLIGACIONES LABORALES?':						
						$('#respuesta3_1').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo3_1").show()
							 $('#respuestaConArchivo3_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo3_1").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?':						
						$('#respuesta4').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo4").show()
							 $('#respuestaConArchivo4').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo4").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LA EJECUCIÓN DEL ESPACIO DELIBERATIVO?':						
						$('#respuesta5').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo5").show()
							 $('#respuestaConArchivo5').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo5").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LA GENERACIÓN DE ACUERDOS Y COMPROMISOS CON LA CIUDADANÍA?':						
						$('#respuesta5_1').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo5_1").show()
							 $('#respuestaConArchivo5_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo5_1").show();				
						 }
					break;
					case '¿EL MEDIO ADMITE TENER PROYECTO COMUNICACIONAL?':						
						$('#respuesta6').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo6").show()
							 $('#respuestaConArchivo6').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo6").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA SU PROGRAMACIÓN EN PROMOCIÓN DE DERECHOS?':						
						$('#respuesta6_1').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo6_1").show()
							 $('#respuestaConArchivo6_1').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo6_1").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LOS PAGOS DE LOS DERECHOS DE AUTOR?':						
						$('#respuesta7').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo7").show()
							 $('#respuestaConArchivo7').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo7").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LOS ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL REPORTADOS?':						
						$('#respuesta8').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo8").show()
							 $('#respuestaConArchivo8').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo8").show();				
						 }
					break;
					case '¿EL MEDIO CUBRE EL PORCENTAJE DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL?':						
						$('#respuesta9').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo9").show()
							 $('#respuestaConArchivo9').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo9").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LA INCORPORACIÓN DE ACUERDOS Y COMPROMISOS DEL PROCESO PREVIO/ANTERIOR?':						
						$('#respuesta11').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo11").show()
							 $('#respuestaConArchivo11').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo11").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA SU BALANCE GENERAL?':						
						$('#respuesta12').html(op.respuesta); 
						 if(op.evidencia !="N/A" && op.evidencia !=""  && op.evidencia !=null){	
							 $("#respuestaConArchivo12").show()
							 $('#respuestaConArchivo12').attr('href', '${rutaArchivosAplicacion}'+op.evidencia);							
								
						 }	else  {
							 $("#respuestaSinArchivo12").show();				
						 }
					break;
					case '¿EL MEDIO SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?':						
						$('#respuesta10').html(op.respuesta); 						
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


	
</script>
