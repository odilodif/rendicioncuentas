<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasGadFase3
    Created on	: 26/02/2021; 9:27:49
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<%@ page session="false"%>
<sec:authentication var="usuario" property="principal" />


<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblMecanismoRendicionCuentas"
						id="RendicionCuentasFase3" data-rutaAplicacion="rendicion"
						data-opcion="guardarRendiconCuentasFase3" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>

					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
							<td class="tablaingreso">FASES</td>
								<td class="tablaingreso">PROCESO DE RENDICIÓN DE CUENTAS</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">DESCRIBA LA EJECUCIÓN DE LOS PASOS</td>
								<td class="tablaingreso">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td class="tablaingreso">OBSERVACIONES</td>
							</tr>
							<tr>
							 <td style="vertical-align: middle; font-size: x-small; width: 50px;" rowspan="9">
							 <label for="fase3" >FASE 3</label>
								    <input type="hidden" id="fase3" name="fase3" value="FASE 3">
							 </td>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl1" >1. LA ENTIDAD DIFUNDIÓ EL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE QUÉ MEDIOS</label>
								    <input type="hidden" id="rc1" name="rc1" value="1. LA ENTIDAD DIFUNDIÓ EL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE QUÉ MEDIOS">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion1"
									name="seleccion1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
							 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="PAG WEB"> PAG WEB</label></td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="dos"><input type="checkbox" class="case"
													 name="checks[]" value="REDES SOCIALES">
													REDES SOCIALES</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="tres"><input type="checkbox" class="case"
													 name="checks[]" value="RADIO"> RADIO</label></td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="cuatro"><input type="checkbox" class="case"
													 name="checks[]" value="CARTELERAS">
													CARTELERAS</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="cinco"><input type="checkbox" class="case"
													 name="checks[]" value="PRENSA"> PRENSA</label></td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="seis"><input type="checkbox" class="case"
													 name="checks[]" value="IMPRESOS">
													IMPRESOS</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="siete"><input type="checkbox" class="case"
													 name="checks[]" value="TV"> TV</label></td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;"><label
												for="ocho"><input type="checkbox" class="case"
													 name="checks[]" value="OTROS">
													OTROS</label></td>
										</tr>

									</table>
									
								    <input type="hidden" class="form-control form-control-sm descripcion1" id="descripcion1" name="descripcion1"  >
									<div class="invalid-feedback">Seleccione al menos un check</div>

								</td>
						
							
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion1" id="observacion1" name="observacion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;"><label for="lbl2" >2. LA ENTIDAD INVITÓ A LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS A LOS ACTORES SOCIALES DEL MAPEO DE ACTORES QUE ENTREGÓ LA ASAMBLEA CIUDADANA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS A LOS ACTORES SOCIALES DEL MAPEO DE ACTORES QUE ENTREGÓ LA ASAMBLEA CIUDADANA</label>
								    <input type="hidden" id="rc2" name="rc2" value="2. LA ENTIDAD INVITÓ A LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS A LOS ACTORES SOCIALES DEL MAPEO DE ACTORES QUE ENTREGÓ LA ASAMBLEA CIUDADANA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS A LOS ACTORES SOCIALES DEL MAPEO DE ACTORES QUE ENTREGÓ LA ASAMBLEA CIUDADANA">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion2"
									name="seleccion2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion2" id="descripcion2" name="descripcion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion2" id="observacion2" name="observacion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl3" >3. LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME INSTITUCIONAL SE REALIZÓ DE FORMA PRESENCIAL REALIZÓ DE FORMA PRESENCIAL Y, ADICIONALMENTE, SE RETRANSMITIÓ EN VIVO, A TRAVÉS DE PLATAFORMAS INTERACTIVAS</label>
								    <input type="hidden" id="rc3" name="rc3" value="3. LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME INSTITUCIONAL SE REALIZÓ DE FORMA PRESENCIAL REALIZÓ DE FORMA PRESENCIAL Y, ADICIONALMENTE, SE RETRANSMITIÓ EN VIVO, A TRAVÉS DE PLATAFORMAS INTERACTIVAS">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion3"
									name="seleccion3" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion3" id="descripcion3" name="descripcion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case3" id="link3" name="link3" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion3" id="observacion3" name="observacion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl4" >4. LA ASAMBLEA CIUDADANA / CIUDADANÍA CONTÓ CON UN TIEMPO DE EXPOSICIÓN EN LA AGENDA DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS DE LA ENTIDAD</label>
								    <input type="hidden" id="rc4" name="rc4" value="4. LA ASAMBLEA CIUDADANA / CIUDADANÍA CONTÓ CON UN TIEMPO DE EXPOSICIÓN EN LA AGENDA DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS DE LA ENTIDAD">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion4"
									name="seleccion4" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 	 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								 <select
									class="custom-select custom-select-sm descripcion4"
									id="descripcion4" name="descripcion4">
										<option value="">Seleccione...</option>
										<option value="0-30 min">0-30 min</option>
										<option value="31 min - 1 hora">31 min - 1 hora</option>
										<option value="1 hora - 2 horas">1 hora - 2 horas</option>
										<option value="Mas de 2 horas">Mas de 2 horas</option>
								</select>
									<div class="invalid-feedback">Seleccione una opción</div></td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<input type="url" class="form-control form-control-sm case4" id="link4" name="link4" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
									</td>
							
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion4" id="observacion4" name="observacion4" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl5" >5. UNA VEZ QUE  LA ASAMBLEA CIUDADANA / CIUDADANÍA PRESENTÓ SUS OPINIONES, LA MÁXIMA AUTORIDAD DE LA ENTIDAD EXPUSO SU INFORME DE RENDICIÓN DE CUENTAS</label>
								    <input type="hidden" id="rc5" name="rc5" value="5. UNA VEZ QUE  LA ASAMBLEA CIUDADANA / CIUDADANÍA PRESENTÓ SUS OPINIONES, LA MÁXIMA AUTORIDAD DE LA ENTIDAD EXPUSO SU INFORME DE RENDICIÓN DE CUENTAS">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion5"
									name="seleccion5" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small;">
									<textarea rows="4" cols="" class="form-control form-control-sm descripcion5" id="descripcion5" name="descripcion5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>									
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case5" id="link5" name="link5" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion5" id="observacion5" name="observacion5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl6" >6. EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS, LA MÁXIMA AUTORIDAD DE LA ENTIDAD RESPONDIÓ LAS DEMANDAS CIUDADANAS</label>
								    <input type="hidden" id="rc6" name="rc6" value="6. EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS, LA MÁXIMA AUTORIDAD DE LA ENTIDAD RESPONDIÓ LAS DEMANDAS CIUDADANAS">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion6"
									name="seleccion6" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion6" id="descripcion6" name="descripcion6" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case6" id="link6" name="link6" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion6" id="observacion6" name="observacion6" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl7" >7. LA COMISIÓN LIDERADA POR LA CIUDADANÍA - RECOGIÓ LAS SUGERENCIAS CIUDADANAS DE CADA MESA QUE SE PRESENTARON EN PLENARIA</label>
								    <input type="hidden" id="rc7" name="rc7" value="7. LA COMISIÓN LIDERADA POR LA CIUDADANÍA - RECOGIÓ LAS SUGERENCIAS CIUDADANAS DE CADA MESA QUE SE PRESENTARON EN PLENARIA">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion7"
									name="seleccion7" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
									<textarea rows="4" cols="" class="form-control form-control-sm descripcion7" id="descripcion7" name="descripcion7" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								</td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case7" id="link7" name="link7" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion7" id="observacion7" name="observacion7" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl8" >8. EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS SE REALIZARON MESAS DE TRABAJO O COMISIONES PARA QUE LOS CIUDADANOS Y CIUDADANAS DEBATAN  Y ELABOREN LAS RECOMENDACIONES PARA MEJORAR LA GESTIÓN DE LA ENTIDAD</label>
								    <input type="hidden" id="rc8" name="rc8" value="8. EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS SE REALIZARON MESAS DE TRABAJO O COMISIONES PARA QUE LOS CIUDADANOS Y CIUDADANAS DEBATAN  Y ELABOREN LAS RECOMENDACIONES PARA MEJORAR LA GESTIÓN DE LA ENTIDAD">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion8"
									name="seleccion8" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								 <textarea rows="4" cols="" class="form-control form-control-sm descripcion8" id="descripcion8" name="descripcion8" required="required" ></textarea>
							     <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case8" id="link8" name="link8" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion8" id="observacion8" name="observacion8" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 200px;">
								<label for="lbl9" >9. LOS REPRESENTANTES CIUDADANOS /  ASAMBLEA CIUDADANA FIRMARON EL ACTA EN LA QUE SE RECOGIÓ LAS SUGERENCIAS CIUDADANAS QUE SE PRESENTARON EN LA PLENARIA</label>
								    <input type="hidden" id="rc9" name="rc9" value="9. LOS REPRESENTANTES CIUDADANOS /  ASAMBLEA CIUDADANA FIRMARON EL ACTA EN LA QUE SE RECOGIÓ LAS SUGERENCIAS CIUDADANAS QUE SE PRESENTARON EN LA PLENARIA">
								</td>
								<td style="vertical-align: middle; font-size: x-small; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion9"
									name="seleccion9" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; font-size: x-small; width: 200px;">
								 <textarea rows="4" cols="" class="form-control form-control-sm descripcion9" id="descripcion9" name="descripcion9" required="required" ></textarea>
							     <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle; font-size: x-small;">
								<input type="url" class="form-control form-control-sm case9" id="link9" name="link9" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle; font-size: x-small;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion9" id="observacion9" name="observacion9" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
								 </td>														
							</tr>
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarRendicionCuentasF3"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
			<table id="TablaRendicionFase3"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">PROCESO DE RENDICIÓN DE CUENTAS</th>
						<th style="font-size: x-small;">PONGA SI O NO</th>
						<th style="font-size: x-small;">DESCRIBA LA EJECUCIÓN DE LOS PASOS</th>
						<th style="font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>
						<th style="font-size: x-small;">OBSERVACIONES</th>
						<th> </th>						
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
		</c:when>
		<c:otherwise>

			<div>
				<div id="informacion">
					¡Información!... Usted aun no cuenta con un informe.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Informe.
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
</html>

<script type="text/javascript">

	$(document).ready(function() {
		$(".case").prop("disabled", "disabled");
		$(".case1").prop("disabled", "disabled");
		$(".descripcion1").prop("disabled", "disabled");
		$(".observacion1").prop("disabled", "disabled");		
		$(".case2").prop("disabled", "disabled");
		$(".descripcion2").prop("disabled", "disabled");
		$(".observacion2").prop("disabled", "disabled");
		$(".case3").prop("disabled", "disabled");
		$(".descripcion3").prop("disabled", "disabled");
		$(".observacion3").prop("disabled", "disabled");
		$(".case4").prop("disabled", "disabled");
		$(".descripcion4").prop("disabled", "disabled");
		$(".observacion4").prop("disabled", "disabled");
		$(".case5").prop("disabled", "disabled");
		$(".descripcion5").prop("disabled", "disabled");
		$(".observacion5").prop("disabled", "disabled");
		$(".case6").prop("disabled", "disabled");
		$(".descripcion6").prop("disabled", "disabled");
		$(".observacion6").prop("disabled", "disabled");
		$(".case7").prop("disabled", "disabled");
		$(".descripcion7").prop("disabled", "disabled");
		$(".observacion7").prop("disabled", "disabled");
		$(".case8").prop("disabled", "disabled");
		$(".descripcion8").prop("disabled", "disabled");
		$(".observacion8").prop("disabled", "disabled");
		$(".case9").prop("disabled", "disabled");
		$(".descripcion9").prop("disabled", "disabled");
		$(".observacion9").prop("disabled", "disabled");
			if ('${inf_estado}' == 'matriz') {
			tabla();			
		}
			if('${infestadoinforme}' == 'finalizado'){
				
				var inputs = document.getElementsByTagName("input"); 
			    for (var i = 0; i < inputs.length; i++) {
			        inputs[i].disabled = true;
			    } 
			    var buttons = document.getElementsByTagName("button");
			    for (var i = 0; i < buttons.length; i++) { 
			    	buttons[i].disabled = true;
			    } 
			}	
		 $('[name="checks[]"]').click(function() {		      
			    var arr = $('[name="checks[]"]:checked').map(function(){
			      return this.value;
			    }).get();
			    var str = arr.join('<br>');	
			    $('#descripcion1').val(str);			  
			  });
		
	});
	$("#seleccion1").change(function() {
		 var url;
		   url=document.getElementById("link1");
		var seleccion = $("#seleccion1").val();
		if (seleccion == "SI") {									
			$(".observacion1").val(""); 
			$(".descripcion1").val(""); 
			$(".case1").val("http://");
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);
			$(".descripcion1").removeAttr("disabled");
			$(".descripcion1").prop("required", true);
			$(".observacion1").removeAttr("disabled");
			$(".observacion1").removeAttr("required");			
			$(".case").removeAttr("disabled");
			url.type = "url";
			
		} else if (seleccion == "NO") {
			$(".observacion1").val("S/N"); 
			$(".descripcion1").val("S/N");
			$(".case1").val("NO APLICA");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".descripcion1").prop("disabled", "disabled");
			$(".descripcion1").removeAttr("required");
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			$(".case").prop("checked", false);
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion1").val(""); 
			$(".descripcion1").val("");
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".descripcion1").prop("disabled", "disabled");
			$(".descripcion1").removeAttr("required");
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			$(".case").prop("checked", false);
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});

	$("#seleccion2").change(function() {
		 var url;
		 url=document.getElementById("link2");
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {			
			$(".observacion2").val(""); 
			$(".descripcion2").val(""); 
			$(".case2").val("http://");
			$(".case2").removeAttr("disabled");
			$(".case2").prop("required", true);
			$(".descripcion2").removeAttr("disabled");
			$(".descripcion2").prop("required", true);
			$(".observacion2").removeAttr("disabled");
			$(".observacion2").removeAttr("required");
			url.type = "url";
			
		} else if (seleccion == "NO") {
			$(".observacion2").val("S/N"); 
			$(".descripcion2").val("S/N");
			$(".case2").val("NO APLICA");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".descripcion2").prop("disabled", "disabled");
			$(".descripcion2").removeAttr("required");
			$(".observacion2").prop("disabled", "disabled");
			$(".observacion2").removeAttr("required");
			url.type = "text";
			

		} else {
			$(".observacion2").val(""); 
			$(".descripcion2").val("");
			$(".case2").val("");
			$(".case2").prop("disabled", "disabled");
			$(".case2").removeAttr("required");
			$(".descripcion2").prop("disabled", "disabled");
			$(".descripcion2").removeAttr("required");
			$(".observacion2").prop("disabled", "disabled");
			$(".observacion2").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion3").change(function() {
		 var url;
		 url=document.getElementById("link3");
		var seleccion = $("#seleccion3").val();
		if (seleccion == "SI") {			
			$(".observacion3").val(""); 
			$(".descripcion3").val(""); 
			$(".case3").val("http://");
			$(".case3").removeAttr("disabled");
			$(".case2").prop("required", true);
			$(".descripcion3").removeAttr("disabled");
			$(".descripcion3").prop("required", true);
			$(".observacion3").removeAttr("disabled");
			$(".observacion3").removeAttr("required");
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".observacion3").val("S/N"); 
			$(".descripcion3").val("S/N");
			$(".case3").val("NO APLICA");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".descripcion3").prop("disabled", "disabled");
			$(".descripcion3").removeAttr("required");
			$(".observacion3").prop("disabled", "disabled");
			$(".observacion3").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion3").val(""); 
			$(".descripcion3").val("");
			$(".case3").val("");
			$(".case3").prop("disabled", "disabled");
			$(".case3").removeAttr("required");
			$(".descripcion3").prop("disabled", "disabled");
			$(".descripcion3").removeAttr("required");
			$(".observacion3").prop("disabled", "disabled");
			$(".observacion3").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});

	
	

	$("#seleccion4").change(function() {
		var url;
		url=document.getElementById("link4");
		var seleccion = $("#seleccion4").val();
		if (seleccion == "SI") {			
			$(".observacion4").val(""); 
			$(".descripcion4").val(""); 
			$(".case4").val("http://");
			$(".case4").removeAttr("disabled");
			$(".case4").prop("required", true);
			$(".descripcion4").removeAttr("disabled");
			$(".descripcion4").prop("required", true);
			$(".observacion4").removeAttr("disabled");
			$(".observacion4").removeAttr("required");
			url.type = "url";
		} else if (seleccion == "NO") {
			$(".observacion4").val("S/N"); 
			$(".descripcion4").val("");
			$(".case4").val("NO APLICA");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			$(".descripcion4").prop("disabled", "disabled");
			$(".descripcion4").removeAttr("required");
			$(".observacion4").prop("disabled", "disabled");
			$(".observacion4").removeAttr("required");
			url.type = "text";
		} else {
			$(".observacion4").val(""); 
			$(".descripcion4").val("");
			$(".case4").val("");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			$(".descripcion4").prop("disabled", "disabled");
			$(".descripcion4").removeAttr("required");
			$(".observacion4").prop("disabled", "disabled");
			$(".observacion4").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion5").change(function() {
		var url;
		url=document.getElementById("link5");
		var seleccion = $("#seleccion5").val();
		if (seleccion == "SI") {			
			$(".observacion5").val(""); 
			$(".descripcion5").val(""); 
			$(".case5").val("http://");
			$(".case5").removeAttr("disabled");
			$(".case5").prop("required", true);
			$(".descripcion5").removeAttr("disabled");
			$(".descripcion5").prop("required", true);
			$(".observacion5").removeAttr("disabled");
			$(".observacion5").removeAttr("required");
			url.type = "url";	

		} else if (seleccion == "NO") {
			$(".observacion5").val("S/N"); 
			$(".descripcion5").val("S/N");
			$(".case5").val("NO APLICA");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			$(".descripcion5").prop("disabled", "disabled");
			$(".descripcion5").removeAttr("required");
			$(".observacion5").prop("disabled", "disabled");
			$(".observacion5").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion5").val(""); 
			$(".descripcion5").val("");
			$(".case5").val("");
			$(".case5").prop("disabled", "disabled");
			$(".case5").removeAttr("required");
			$(".descripcion5").prop("disabled", "disabled");
			$(".descripcion5").removeAttr("required");
			$(".observacion5").prop("disabled", "disabled");
			$(".observacion5").removeAttr("required");
			url.type = "url";				
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion6").change(function() {
		var url;
		url=document.getElementById("link6");
		var seleccion = $("#seleccion6").val();
		if (seleccion == "SI") {			
			$(".observacion6").val(""); 
			$(".descripcion6").val(""); 
			$(".case6").val("http://");
			$(".case6").removeAttr("disabled");
			$(".case6").prop("required", true);
			$(".descripcion6").removeAttr("disabled");
			$(".descripcion6").prop("required", true);
			$(".observacion6").removeAttr("disabled");
			$(".observacion6").removeAttr("required");
			url.type = "url";	

		} else if (seleccion == "NO") {
			$(".observacion6").val("S/N"); 
			$(".descripcion6").val("S/N");
			$(".case6").val("NO APLICA");
			$(".case6").prop("disabled", "disabled");
			$(".case6").removeAttr("required");
			$(".descripcion6").prop("disabled", "disabled");
			$(".descripcion6").removeAttr("required");
			$(".observacion6").prop("disabled", "disabled");
			$(".observacion6").removeAttr("required");
			url.type = "text";	

		} else {
			$(".observacion6").val(""); 
			$(".descripcion6").val("");
			$(".case6").val("");
			$(".case6").prop("disabled", "disabled");
			$(".case6").removeAttr("required");
			$(".descripcion6").prop("disabled", "disabled");
			$(".descripcion6").removeAttr("required");
			$(".observacion6").prop("disabled", "disabled");
			$(".observacion6").removeAttr("required");
			url.type = "url";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion7").change(function() {
		var url;
		url=document.getElementById("link7");
		var seleccion = $("#seleccion7").val();
		if (seleccion == "SI") {			
			$(".observacion7").val(""); 
			$(".descripcion7").val(""); 
			$(".case7").val("http://");
			$(".case7").removeAttr("disabled");
			$(".case7").prop("required", true);
			$(".descripcion7").removeAttr("disabled");
			$(".descripcion7").prop("required", true);
			$(".observacion7").removeAttr("disabled");
			$(".observacion7").removeAttr("required");
			url.type = "url";	

		} else if (seleccion == "NO") {
			$(".observacion7").val("S/N"); 
			$(".descripcion7").val("S/N");
			$(".case7").val("NO APLICA");
			$(".case7").prop("disabled", "disabled");
			$(".case7").removeAttr("required");
			$(".descripcion7").prop("disabled", "disabled");
			$(".descripcion7").removeAttr("required");
			$(".observacion7").prop("disabled", "disabled");
			$(".observacion7").removeAttr("required");
			url.type = "text";	

		} else {
			$(".observacion7").val(""); 
			$(".descripcion7").val("");
			$(".case7").val("");
			$(".case7").prop("disabled", "disabled");
			$(".case7").removeAttr("required");
			$(".descripcion7").prop("disabled", "disabled");
			$(".descripcion7").removeAttr("required");
			$(".observacion7").prop("disabled", "disabled");
			$(".observacion7").removeAttr("required");
			url.type = "url";	
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion8").change(function() {
		var url;
		url=document.getElementById("link8");
		var seleccion = $("#seleccion8").val();
		if (seleccion == "SI") {			
			$(".observacion8").val(""); 
			$(".descripcion8").val(""); 
			$(".case8").val("http://");
			$(".case8").removeAttr("disabled");
			$(".case8").prop("required", true);
			$(".descripcion8").removeAttr("disabled");
			$(".descripcion8").prop("required", true);
			$(".observacion8").removeAttr("disabled");
			$(".observacion8").removeAttr("required");
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".observacion8").val("S/N"); 
			$(".descripcion8").val("S/N");
			$(".case8").val("NO APLICA");
			$(".case8").prop("disabled", "disabled");
			$(".case8").removeAttr("required");
			$(".descripcion8").prop("disabled", "disabled");
			$(".descripcion8").removeAttr("required");
			$(".observacion8").prop("disabled", "disabled");
			$(".observacion8").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion8").val(""); 
			$(".descripcion8").val("");
			$(".case8").val("");
			$(".case8").prop("disabled", "disabled");
			$(".case8").removeAttr("required");
			$(".descripcion8").prop("disabled", "disabled");
			$(".descripcion8").removeAttr("required");
			$(".observacion8").prop("disabled", "disabled");
			$(".observacion8").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#seleccion9").change(function() {
		var url;
		url=document.getElementById("link9");
		var seleccion = $("#seleccion9").val();
		if (seleccion == "SI") {			
			$(".observacion9").val(""); 
			$(".descripcion9").val(""); 
			$(".case9").val("http://");
			$(".case9").removeAttr("disabled");
			$(".case9").prop("required", true);
			$(".descripcion9").removeAttr("disabled");
			$(".descripcion9").prop("required", true);
			$(".observacion9").removeAttr("disabled");
			$(".observacion9").removeAttr("required");
			url.type = "url";

		} else if (seleccion == "NO") {
			$(".observacion9").val("S/N"); 
			$(".descripcion9").val("S/N");
			$(".case9").val("NO APLICA");
			$(".case9").prop("disabled", "disabled");
			$(".case9").removeAttr("required");
			$(".descripcion9").prop("disabled", "disabled");
			$(".descripcion9").removeAttr("required");
			$(".observacion9").prop("disabled", "disabled");
			$(".observacion9").removeAttr("required");
			url.type = "text";

		} else {
			$(".observacion9").val(""); 
			$(".descripcion9").val("");
			$(".case9").val("");
			$(".case9").prop("disabled", "disabled");
			$(".case9").removeAttr("required");
			$(".descripcion9").prop("disabled", "disabled");
			$(".descripcion9").removeAttr("required");
			$(".observacion9").prop("disabled", "disabled");
			$(".observacion9").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	
	
	$("#btnGuardarRendicionCuentasF3").click(function(event) {
		var form = $("#RendicionCuentasFase3")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {	
					var seleccion = $("#seleccion1").val();
					if (seleccion == "SI") {
					if ($('input[type=checkbox]:checked').length === 0) {
					mostrarMensaje("Debe seleccionar al menos un valor de los checkbox","ERROR-NOTIFICACION");

					} else{
						desbloqueo();
						ejecutarJson(form);

						}
					}
					 else {
					
						 desbloqueo();
						ejecutarJson(form);

					      }

					
			}
			form.addClass('was-validated');

	});

function desbloqueo(){
	  $(".case1").removeAttr("disabled");
		$(".descripcion1").removeAttr("disabled");
		$(".observacion1").removeAttr("disabled");
		$(".case2").removeAttr("disabled");
		$(".descripcion2").removeAttr("disabled");
		$(".observacion2").removeAttr("disabled");			
		$(".case3").removeAttr("disabled");
		$(".descripcion3").removeAttr("disabled");
		$(".observacion3").removeAttr("disabled");	
		$(".case4").removeAttr("disabled");
		$(".descripcion4").removeAttr("disabled");
		$(".observacion4").removeAttr("disabled");
		$(".case5").removeAttr("disabled");
		$(".descripcion5").removeAttr("disabled");
		$(".observacion5").removeAttr("disabled");
		$(".case6").removeAttr("disabled");
		$(".descripcion6").removeAttr("disabled");
		$(".observacion6").removeAttr("disabled");
		$(".case7").removeAttr("disabled");
		$(".descripcion7").removeAttr("disabled");
		$(".observacion7").removeAttr("disabled");
		$(".case8").removeAttr("disabled");
		$(".descripcion8").removeAttr("disabled");
		$(".observacion8").removeAttr("disabled");
		$(".case9").removeAttr("disabled");
		$(".descripcion9").removeAttr("disabled");
		$(".observacion9").removeAttr("disabled");
}
	
	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaRendicionFase3').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerRendicionFase3",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,	
		order : [ 0, "asc" ],		
		columns : [			
			{data : "contador"},
			{data : "proceso"},
			{data : "seleccion"}, 
			{data : "describa"},
			{data : "link"}, 
			{data : "observaciones"},
			{ data: "" ,"render": function (data, type, full, meta) {
				   if('${infestadoinforme}' === "finalizado"){
		            	 data = '';     
		             }else{	
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
		             }
     			  return data;
      			  
              }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.mecanismo_cod);
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'rendicion');
				$(row).attr('data-opcion', 'Frm_RendicionCuentasGadFasesActl');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});		
				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	
				$(row).find("td:eq(6)").css({
					"vertical-align" : "middle",									
				});				
		           
			},	
			
		});

	}
	

	function Actualizar(element) {	
		$('#TablaRendicionFase3 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
	
</script>