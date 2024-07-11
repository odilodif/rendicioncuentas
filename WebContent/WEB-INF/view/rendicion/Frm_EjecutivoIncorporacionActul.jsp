<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoIncorporacionActul
    Created on	: 01/03/2021; 18:39:18
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

<div class="card  mb-card20">

			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblIncoporacionRecomendaciones"
					id="IncorporacionRecomendacionesActul" data-rutaAplicacion="rendicion"
					data-opcion="guardarRecomenIncorp"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">INCORPORACIÓN DE RECOMENDACIONES Y DICTÁMENES</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

					<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<td colspan="2" class="tablaingreso" align="center">INCORPORACIÓN DE RECOMENDACIONES Y DICTÁMENES POR PARTE DE LAS ENTIDADES DE LA FUNCIÓN DE TRANSPARENCIA Y CONTROL SOCIAL, LA PROCURADURÍA GENERAL DEL ESTADO Y CACES:</td>
								</tr>
								<tr>
									<td><label for="entidad">ENTIDAD QUE RECOMIENDA </label></td>
									<td><select class="custom-select custom-select-sm"
										id="seleccion" name="seleccion" required="required">
											<option value="">Seleccione...</option>
											<option value="CONTRALORÍA GENERAL DEL ESTADO">CONTRALORÍA
												GENERAL DEL ESTADO</option>
											<option
												value="SUPERINTENDENCIA DE ORDENAMIENTO TERRITORIAL">SUPERINTENDENCIA
												 DE ORDENAMIENTO TERRITORIAL</option>
											<option value="SUPERINTENDENCIA DE BANCOS Y SEGUROS">SUPERINTENDENCIA
												DE BANCOS Y SEGUROS</option>
											<option value="SUPERINTENDENCIA DE COMPAÑIAS Y VALORES">SUPERINTENDENCIA
												DE COMPAÑIAS Y VALORES</option>
											<option value="SUPERINTENDENCIA DE TELECOMUNICACIONES">SUPERINTENDENCIA
												DE TELECOMUNICACIONES</option>
											<option value="DEFENSORÍA DEL PUEBLO">DEFENSORÍA DEL
												PUEBLO</option>
											<option
												value="CONSEJO DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL">CONSEJO
												DE PARTICIPACIÓN CIUDADANA Y CONTROL SOCIAL</option>
											<option
												value="SUPERINTENDENCIA DE ECONOMÍA POPULAR Y SOLIDARIA">SUPERINTENDENCIA
												DE ECONOMÍA POPULAR Y SOLIDARIA</option>
											<option
												value="SUPERINTENDENCIA DE CONTROL DEL PODER DE MERCADO">SUPERINTENDENCIA
												DE CONTROL DEL PODER DE MERCADO</option>
											<option	value="CONSEJO DE REGULACIÓN, DESARROLLO Y PROMOCIÓN DE LA INFORMACIÓN Y COMUNICACIÓN">CONSEJO DE REGULACIÓN, DESARROLLO Y PROMOCIÓN DE LA INFORMACIÓN Y COMUNICACIÓN</option>
											<option value="PROCURADURÍA GENERAL DEL ESTADO">PROCURADURÍA
												GENERAL DEL ESTADO</option>
											<option
												value="CONSEJO DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR">CONSEJO
												DE ASEGURAMIENTO DE LA CALIDAD DE LA EDUCACIÓN SUPERIOR</option>
											<option
												value="NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR">NO
												HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR</option>
									</select>
										<div class="invalid-feedback">Seleccione una opción</div></td>
								</tr>
								<tr>
									<td><label for="InformeR">NO. DE INFORME DE LA
											ENTIDAD QUE RECOMIENDA</label></td>
									<td><textarea rows="1"
											class="form-control form-control-sm case" id="informeRecom"
											name="informeRecom" required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe de la entidad que recomienda</div></td>
								</tr>
								<tr>
									<td><label for="InformeC">NO. DE INFORME DE
											CUMPLIMIENTO</label></td>
									<td><textarea rows="1"
											class="form-control form-control-sm case" id="informeCumpli"
											name="informeCumpli" required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe</div></td>
								</tr>
								<tr>
									<td><label for="porcetaje">% DE CUMPLIMIENTO DE LAS RECOMENDACIONES</label></td>
									<td><input type="number" onkeypress="javascript:return validarnro(event);"
									id="porcentaje" name="porcentaje" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								</tr>
								<tr>
									<td><label for="observacion">OBSERVACIONES</label></td>
									<td><textarea rows="1"
											class="form-control form-control-sm case" id="observacion"
											name="observacion" required="required"></textarea>
										<div class="invalid-feedback">Por favor Ingrese el N° de
											informe</div></td>
								</tr>							
									<tr>
									<td><label for="observacion">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</label></td>
									<td><input type="url" class="form-control form-control-sm url" id="link" name="link" 
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
								</tr>

							</table>
						</div>
					
					
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarIncorpRecomActul"
								class="btn _nuevoColor _guardar btn-sm mt-2">Añadir</button>
					</div>
				</form:form>
			</div>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		$(".case").prop("disabled", "disabled");
		$(".number").prop("disabled", "disabled");
		$(".url").prop("disabled", "disabled");	
	});

	$("#seleccion").change(function() {
		var url;
		url=document.getElementById("link");
		var seleccion = $("#seleccion").val();
		if (seleccion != "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {	

			$(".case").val("");
			$(".case").removeAttr("disabled");
			$(".case").prop("required", true);
			$(".number").val("");
			$(".number").removeAttr("disabled");
			$(".number").prop("required", true);
			$(".url").val("http://");
			$(".url").removeAttr("disabled");
			$(".url").prop("required", true);
			url.type = "url";
			
		} else if (seleccion == "NO HE RECIBIDO OBSERVACIONES NI DICTÁMENES EN EL AÑO ANTERIOR") {
			$(".case").val("S/N"); 
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			$(".number").val("0"); 
			$(".number").prop("disabled", "disabled");
			$(".number").removeAttr("required");
			$(".url").val("NO APLICA"); 
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");
			url.type = "text";		

		} else {
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");	
			$(".number").val("");
			$(".number").prop("disabled", "disabled");
			$(".number").removeAttr("required");		
			$(".url").val("");
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");	
			url.type = "url";		
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	
	$("#btnGuardarIncorpRecomActul").click(function(event) {
		var form = $("#IncorporacionRecomendacionesActul")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
				$(".case").removeAttr("disabled");
				$(".number").removeAttr("disabled");
				$(".url").removeAttr("disabled");
					ejecutarJson(form);
				}
				form.addClass('was-validated');

	});


	


		 
</script>