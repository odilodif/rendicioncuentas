<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasGadFases
    Created on	: 25/02/2021; 18:18:39
    Author		: Juan Carlos Vega
    Mail		: jcmono@gmail.com
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
						id="RendicionCuentasFases" data-rutaAplicacion="rendicion"
						data-opcion="guardarFasesRendicionCuentas" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>

					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
							<td class="tablaingreso" width="5%">FASES</td>
							<td class="tablaingreso" width="25%">PROCESO DE RENDICIÓN DE CUENTAS</td>
							<td class="tablaingreso" width="15%">PONGA SI O NO</td>
							<td class="tablaingreso" width="35%">DESCRIBA LA EJECUCIÓN DE LOS PASOS</td>
							<td class="tablaingreso" width="20%">LINK AL MEDIO DE VERIFICACIÓN</td>
							
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px;" rowspan="2">
							 <label for="fase0" >FASE 0</label>
								    <input type="hidden" id="fase0" name="fase0" value="FASE 0">
							 </td>
						
							
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl1" >CONFORMACIÓN DEL EQUIPO DE RENDICIÓN DE CUENTAS</label>
								    <input type="hidden" id="rc1" name="rc1" value="CONFORMACIÓN DEL EQUIPO DE RENDICIÓN DE CUENTAS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion1"
									name="seleccion1" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion1" id="descripcion1" name="descripcion1" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case1" id="link1" name="link1" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																				
							</tr>
							<tr>
								
								<td style="vertical-align: middle; width: 200px;"><label for="lbl2" >DISEÑO DE LA PROPUESTA DEL PROCESO DE RENDICIÓN DE CUENTAS</label>
								    <input type="hidden" id="rc2" name="rc2" value="DISEÑO DE LA PROPUESTA DEL PROCESO DE RENDICIÓN DE CUENTAS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion2"
									name="seleccion2" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion2" id="descripcion2" name="descripcion2" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case2" id="link2" name="link2" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px;" rowspan="4">
							 <label for="fase1" >FASE 1</label>
								    <input type="hidden" id="fase1" name="fase1" value="FASE 1">
							 </td>
						
							
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl3" >EVALUACIÓN DE LA GESTIÓN INSTITUCIONAL:</label>
								    <input type="hidden" id="rc3" name="rc3" value="EVALUACIÓN DE LA GESTIÓN INSTITUCIONAL:">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion3"
									name="seleccion3" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion3" id="descripcion3" name="descripcion3" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case3" id="link3" name="link3" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;"><label for="lbl4" >LLENADO DEL FORMULARIO DE INFORME DE RENDICIÓN DE CUENTAS ESTABLECIDO POR EL CPCCS</label>
								    <input type="hidden" id="rc4" name="rc4" value="LLENADO DEL FORMULARIO DE INFORME DE RENDICIÓN DE CUENTAS ESTABLECIDO POR EL CPCCS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion4"
									name="seleccion4" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion4" id="descripcion4" name="descripcion4" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case4" id="link4" name="link4" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl5" >REDACCIÓN DEL INFORME DE RENDICIÓN DE CUENTAS</label>
								    <input type="hidden" id="rc5" name="rc5" value="REDACCIÓN DEL INFORME DE RENDICIÓN DE CUENTAS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion5"
									name="seleccion5" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion5" id="descripcion5" name="descripcion5" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case5" id="link5" name="link5" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl6" >SOCIALIZACIÓN INTERNA Y APROBACIÓN DEL INFORME DE RENDICIÓN DE CUENTAS POR PARTE DE LOS RESPONSABLES</label>
								    <input type="hidden" id="rc6" name="rc6" value="SOCIALIZACIÓN INTERNA Y APROBACIÓN DEL INFORME DE RENDICIÓN DE CUENTAS POR PARTE DE LOS RESPONSABLES">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion6"
									name="seleccion6" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion6" id="descripcion6" name="descripcion6" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case6" id="link6" name="link6" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px;" rowspan="5">
							 <label for="fase2" >FASE 2</label>
								    <input type="hidden" id="fase2" name="fase2" value="FASE 2">
							 </td>
						
							
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl7" >DIFUSIÓN DEL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE DISTINTOS MEDIOS</label>
								    <input type="hidden" id="rc7" name="rc7" value="DIFUSIÓN DEL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE DISTINTOS MEDIOS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion7"
									name="seleccion7" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion7" id="descripcion7" name="descripcion7" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case7" id="link7" name="link7" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
								
								<td style="vertical-align: middle; width: 200px;"><label for="lbl8" >PLANIFICACIÓN DE LOS EVENTOS PARTICIPATIVOS</label>
								    <input type="hidden" id="rc8" name="rc8" value="PLANIFICACIÓN DE LOS EVENTOS PARTICIPATIVOS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion8"
									name="seleccion8" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion8" id="descripcion8" name="descripcion8" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case8" id="link8" name="link8" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl9" >REALIZACIÓN DEL EVENTO DE RENDICIÓN DE CUENTAS A LA CIUDADANÍA</label>
								    <input type="hidden" id="rc9" name="rc9" value="REALIZACIÓN DEL EVENTO DE RENDICIÓN DE CUENTAS A LA CIUDADANÍA">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion9"
									name="seleccion9" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion9" id="descripcion9" name="descripcion9" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case9" id="link9" name="link9" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl10" >RINDIÓ CUENTAS A LA CIUDADANÍA EN LA PLAZO ESTABLECIDO</label>
								    <input type="hidden" id="rc10" name="rc10" value="RINDIÓ CUENTAS A LA CIUDADANÍA EN LA PLAZO ESTABLECIDO">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion10"
									name="seleccion10" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion10" id="descripcion10" name="descripcion10" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case10" id="link10" name="link10" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																					
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl11" >INCORPORACIÓN DE LOS APORTES CIUDADANOS EN EL INFORME DE RENDICIÓN DE CUENTAS</label>
								    <input type="hidden" id="rc11" name="rc11" value="INCORPORACIÓN DE LOS APORTES CIUDADANOS EN EL INFORME DE RENDICIÓN DE CUENTAS">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion11"
									name="seleccion11" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion11" id="descripcion11" name="descripcion11" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case11" id="link11" name="link11" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																						
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px;" rowspan="1">
							 <label for="fase3" >FASE 3</label>
								    <input type="hidden" id="fase3" name="fase3" value="FASE 3">
							 </td>
						
							
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl12" >ENTREGA DEL INFORME DE RENDICIÓN DE CUENTAS AL CPCCS, A TRAVÉS DEL INGRESO DEL INFORME EN EL SISTEMA VIRTUAL</label>
								    <input type="hidden" id="rc12" name="rc12" value="ENTREGA DEL INFORME DE RENDICIÓN DE CUENTAS AL CPCCS, A TRAVÉS DEL INGRESO DEL INFORME EN EL SISTEMA VIRTUAL">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion12"
									name="seleccion12" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								 <td style="vertical-align: middle; width: 200px;">
								
								<textarea rows="4" cols="" class="form-control form-control-sm descripcion12" id="descripcion12" name="descripcion12" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
									
									</td>
								<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case12" id="link12" name="link12" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
																				
							</tr>
							
							<tr>
							 <td style="vertical-align: middle; width: 50px;" rowspan="1">
							 <label for="describa" >DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS RECIBIDOS:</label>
								    <input type="hidden" id="describa" name="describa" value="DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS RECIBIDOS:">
							 </td>
						
							
								<td style="vertical-align: middle;" colspan="4">
										<textarea rows="4"
											cols="" class="form-control form-control-sm"
											id="describaAporte" name="describaAporte" required="required"></textarea>
										<div class="invalid-feedback">>Por favor ingrese la descripción</div>
								</td>
							</tr>
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarRendicionCuentas"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
			
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
						<th style="font-size: xx-small;"> </th>						
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
		$(".case1").prop("disabled", "disabled");
		$(".descripcion1").prop("disabled", "disabled");
		$(".case2").prop("disabled", "disabled");
		$(".descripcion2").prop("disabled", "disabled");
		$(".case3").prop("disabled", "disabled");
		$(".descripcion3").prop("disabled", "disabled");
		$(".case4").prop("disabled", "disabled");
		$(".descripcion4").prop("disabled", "disabled");
		$(".case5").prop("disabled", "disabled");
		$(".descripcion5").prop("disabled", "disabled");
		$(".case6").prop("disabled", "disabled");
		$(".descripcion6").prop("disabled", "disabled");
		$(".case7").prop("disabled", "disabled");
		$(".descripcion7").prop("disabled", "disabled");
		$(".case8").prop("disabled", "disabled");
		$(".descripcion8").prop("disabled", "disabled");
		$(".case9").prop("disabled", "disabled");
		$(".descripcion9").prop("disabled", "disabled");
		$(".case10").prop("disabled", "disabled");
		$(".descripcion10").prop("disabled", "disabled");
		$(".case11").prop("disabled", "disabled");
		$(".descripcion11").prop("disabled", "disabled");
		$(".case12").prop("disabled", "disabled");
		$(".descripcion12").prop("disabled", "disabled");
		
		if ('${inf_estado}' == 'matriz') {
			tabla();
			tabla2();			
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
	
		
	});
	$("#seleccion1").change(function() {
		 var url;
		 url=document.getElementById("link1");
		var seleccion = $("#seleccion1").val();
		if (seleccion == "SI") {
			$(".descripcion1").val(""); 
			$(".case1").val("http://");
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);
			$(".descripcion1").removeAttr("disabled");
			$(".descripcion1").prop("required", true);
			$(".observacion1").removeAttr("disabled");
			$(".observacion1").removeAttr("required");
			url.type = "url";
		} else if (seleccion == "NO") {
			$(".descripcion1").val("S/N");
			$(".case1").val("NO APLICA");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".descripcion1").prop("disabled", "disabled");
			$(".descripcion1").removeAttr("required");
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			url.type = "text";
		} else {
			$(".descripcion1").val("");
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".descripcion1").prop("disabled", "disabled");
			$(".descripcion1").removeAttr("required");
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	

	$("#seleccion2").change(function() {
		 var url;
		 url=document.getElementById("link2");
		var seleccion = $("#seleccion2").val();
		if (seleccion == "SI") {			
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
			$(".descripcion3").val(""); 
			$(".case3").val("http://");
			$(".case3").removeAttr("disabled");
			$(".case3").prop("required", true);
			$(".descripcion3").removeAttr("disabled");
			$(".descripcion3").prop("required", true);
			$(".observacion3").removeAttr("disabled");
			$(".observacion3").removeAttr("required");
			url.type = "url";

		} else if (seleccion == "NO") {
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
			$(".descripcion4").val("S/N");
			$(".case4").val("NO APLICA");
			$(".case4").prop("disabled", "disabled");
			$(".case4").removeAttr("required");
			$(".descripcion4").prop("disabled", "disabled");
			$(".descripcion4").removeAttr("required");
			$(".observacion4").prop("disabled", "disabled");
			$(".observacion4").removeAttr("required");
			url.type = "text";

		} else {
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
	
	$("#seleccion10").change(function() {
		 var url;
		 url=document.getElementById("link10");
		var seleccion = $("#seleccion10").val();
		if (seleccion == "SI") {
			$(".descripcion10").val(""); 
			$(".case10").val("http://");
			$(".case10").removeAttr("disabled");
			$(".case10").prop("required", true);
			$(".descripcion10").removeAttr("disabled");
			$(".descripcion10").prop("required", true);
			$(".observacion10").removeAttr("disabled");
			$(".observacion10").removeAttr("required");
			url.type = "url";
		} else if (seleccion == "NO") {
			$(".descripcion10").val("S/N");
			$(".case10").val("NO APLICA");
			$(".case10").prop("disabled", "disabled");
			$(".case10").removeAttr("required");
			$(".descripcion10").prop("disabled", "disabled");
			$(".descripcion10").removeAttr("required");
			$(".observacion10").prop("disabled", "disabled");
			$(".observacion10").removeAttr("required");
			url.type = "text";
		} else {
			$(".descripcion10").val("");
			$(".case10").val("");
			$(".case10").prop("disabled", "disabled");
			$(".case10").removeAttr("required");
			$(".descripcion10").prop("disabled", "disabled");
			$(".descripcion10").removeAttr("required");
			$(".observacion10").prop("disabled", "disabled");
			$(".observacion10").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});

	$("#seleccion11").change(function() {
		 var url;
		 url=document.getElementById("link11");
		var seleccion = $("#seleccion11").val();
		if (seleccion == "SI") {
			$(".descripcion11").val(""); 
			$(".case11").val("http://");
			$(".case11").removeAttr("disabled");
			$(".case11").prop("required", true);
			$(".descripcion11").removeAttr("disabled");
			$(".descripcion11").prop("required", true);
			$(".observacion11").removeAttr("disabled");
			$(".observacion11").removeAttr("required");
			url.type = "url";
		} else if (seleccion == "NO") {
			$(".descripcion11").val("S/N");
			$(".case11").val("NO APLICA");
			$(".case11").prop("disabled", "disabled");
			$(".case11").removeAttr("required");
			$(".descripcion11").prop("disabled", "disabled");
			$(".descripcion11").removeAttr("required");
			$(".observacion11").prop("disabled", "disabled");
			$(".observacion11").removeAttr("required");
			url.type = "text";
		} else {
			$(".descripcion11").val("");
			$(".case11").val("");
			$(".case11").prop("disabled", "disabled");
			$(".case11").removeAttr("required");
			$(".descripcion11").prop("disabled", "disabled");
			$(".descripcion11").removeAttr("required");
			$(".observacion11").prop("disabled", "disabled");
			$(".observacion11").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});

	$("#seleccion12").change(function() {
		 var url;
		 url=document.getElementById("link12");
		var seleccion = $("#seleccion12").val();
		if (seleccion == "SI") {
			$(".descripcion12").val(""); 
			$(".case12").val("http://");
			$(".case12").removeAttr("disabled");
			$(".case12").prop("required", true);
			$(".descripcion12").removeAttr("disabled");
			$(".descripcion12").prop("required", true);
			$(".observacion12").removeAttr("disabled");
			$(".observacion12").removeAttr("required");
			url.type = "url";
		} else if (seleccion == "NO") {
			$(".descripcion12").val("S/N");
			$(".case12").val("NO APLICA");
			$(".case12").prop("disabled", "disabled");
			$(".case12").removeAttr("required");
			$(".descripcion12").prop("disabled", "disabled");
			$(".descripcion12").removeAttr("required");
			$(".observacion12").prop("disabled", "disabled");
			$(".observacion12").removeAttr("required");
			url.type = "text";
		} else {
			$(".descripcion12").val("");
			$(".case12").val("");
			$(".case12").prop("disabled", "disabled");
			$(".case12").removeAttr("required");
			$(".descripcion12").prop("disabled", "disabled");
			$(".descripcion12").removeAttr("required");
			$(".observacion12").prop("disabled", "disabled");
			$(".observacion12").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	
	$("#btnGuardarRendicionCuentas").click(function(event) {
		var form = $("#RendicionCuentasFases")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {	
				$(".case1").removeAttr("disabled");
				$(".descripcion1").removeAttr("disabled");
				$(".case2").removeAttr("disabled");
				$(".descripcion2").removeAttr("disabled");
				$(".case3").removeAttr("disabled");
				$(".descripcion3").removeAttr("disabled");
				$(".case4").removeAttr("disabled");
				$(".descripcion4").removeAttr("disabled");
				$(".case5").removeAttr("disabled");
				$(".descripcion5").removeAttr("disabled");
				$(".case6").removeAttr("disabled");
				$(".descripcion6").removeAttr("disabled");
				$(".case7").removeAttr("disabled");
				$(".descripcion7").removeAttr("disabled");
				$(".case8").removeAttr("disabled");
				$(".descripcion8").removeAttr("disabled");
				$(".case9").removeAttr("disabled");
				$(".descripcion9").removeAttr("disabled");
				$(".case10").removeAttr("disabled");
				$(".descripcion10").removeAttr("disabled");
				$(".case11").removeAttr("disabled");
				$(".descripcion11").removeAttr("disabled");
				$(".case12").removeAttr("disabled");
				$(".descripcion12").removeAttr("disabled");
				ejecutarJson(form);
				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaRendicionFases').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerRendicionFases",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		pageLength : 12,
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,
		columns : [			
			{data : "contador"},
			{data : "mecanismo"},
			{data : "proceso"},
			{data : "seleccion"}, 
			{data : "describa"},
			{data : "link"}, 
			{ data: "" ,"render": function (data, type, full, meta) {
				   if('${infestadoinforme}' === "finalizado"){
		            	 data = '';     
		             }else{	
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor  btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
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
				$(row).attr('data-opcion', 'Frm_RendicionCuentasFasesActualizar');
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

				$(row).find("td").css({
					"vertical-align" : "middle",
				});		
		           
			},	
			
		});

	}

	function tabla2() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaRendicionFasesAporte').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerRendicionAporte",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		pageLength : 12,
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,
		columns : [			
			{data : "contador"},
			{data : "proceso"},
			{data : "describa"},
			{ data: "" ,"render": function (data, type, full, meta) {
				   if('${infestadoinforme}' === "finalizado"){
		            	 data = '';     
		             }else{	
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor  btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar2(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
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
				$(row).attr('data-opcion', 'Frm_RendicionCuentasFaseAportes');
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

				$(row).find("td").css({
					"vertical-align" : "middle",
				});	

						
		           
			},	
			
		});

	}
	

	function Actualizar(element) {	
		$('#TablaRendicionFases tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}

	function Actualizar2(element) {	
		$('#TablaRendicionFasesAporte tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
</script>