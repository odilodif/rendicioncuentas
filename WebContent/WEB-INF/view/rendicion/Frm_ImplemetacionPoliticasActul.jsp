<%-- 
	version		: 1.0
    Document  	: Frm_ImplemetacionPoliticasActul
    Created on	: 22/02/2021; 18:26:30
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
			<div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblImplementacionIgualdad"
						id="ImplementacionPoltIgualdadActl" data-rutaAplicacion="rendicion"
						data-opcion="guardarImplementacionIgualdadActu" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">IMPLEMENTACIÓN DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
					<input type="hidden" id="PiCod" name="PiCod" value="${PiCod}">
					<div class="col-md-12 text-left">

						<table id="PoliticasActalizar" class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">POLÍTICAS PÚBLICAS PARA LA IGUALDAD</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">DESCRIBA LA POLÍTICA / PROYECTO / ACCIÓN IMPLEMENTADA</td>
								<td class="tablaingreso">DETALLE PRINCIPALES RESULTADOS OBTENIDOS</td>
								<td class="tablaingreso">EXPLIQUE COMÓ APORTA EL RESULTADO AL CUMPLIMIENTO DE LAS AGENDAS DE IGUALDAD</td>
							</tr>
							<tr>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl" >${polit} </label>
								    <input type="hidden" id="polit" name="polit" value="${polit}">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="seleccion"
									name="seleccion" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
								<td style="vertical-align: middle;">
								<textarea rows="3" cols="" class="form-control form-control-sm case" id="descripcion" name="descripcion"  required="required" >${descripcion}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese la descripción</div>
								 </td>
								<td style="vertical-align: middle;">	
								<textarea rows="3" cols="" class="form-control form-control-sm case" id="detalle" name="detalle" required="required" >${detalle}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese el detalle</div>
								</td>
								<td style="vertical-align: middle;">
								<textarea rows="3" cols="" class="form-control form-control-sm case" id="explicacion" name="explicacion" required="required" >${explicacion}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese la explicación</div>
								</td>
							</tr>
							

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarIgualdadAct"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
	
	
		
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		cargarValorComboPorDefecto("seleccion",'${seleccion}');
		if('${seleccion}'=='NO'){
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			}
		
	});

	$("#seleccion").change(function() {
		var seleccion = $("#seleccion").val();
		if (seleccion == "SI") {
			$(".case").removeAttr("disabled");
			$(".case").prop("required", true);

		} else if (seleccion == "NO") {
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			

		} else {
			$(".case").val("");
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	
	

	$("#btnGuardarIgualdadAct").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#ImplementacionPoltIgualdadActl")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {				
					ejecutarJson(form);

				}
			form.addClass('was-validated');

	});

	
</script>