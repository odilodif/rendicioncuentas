<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasFaseAportes
    Created on	: 25/02/2021; 16:17:21
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
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
						modelAttribute="TblMecanismoRendicionCuentas"
						id="RendicionCuentasFaseAportes" data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>
					<input type="hidden" id="mecanismo_cod" name="mecanismo_cod" value="${mecanismo_cod}">
					<div class="col-md-12 text-left">

						<table id="tablaActul" class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso">FASE</td>
								<td class="tablaingreso">APORTES</td>
							</tr>
							<tr>
							<td style="vertical-align: middle; width: 200px;">
								<label for="lbl1" >${mecanismo_fase}</label>
								    <input type="hidden" id="mecanismo_nombre" name="mecanismo_nombre" value="${mecanismo_fase}">
								</td>
						 <td style="vertical-align: middle;">
								<textarea rows="8" cols="" class="form-control form-control-sm observacion1" id="mecanismo_nombre" name="mecanismo_nombre" required="required" >${mecanismo_nombre}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese el link</div>
								 </td>	
																						
							</tr>
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarFaseAportes"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
</div>
</html>

<script type="text/javascript">

		
$(document).ready(function() {
		
		 
	});

	$("#btnGuardarFaseAportes").click(function(event) {
		var form = $("#RendicionCuentasFaseAportes")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			var columnas = '';
			 var x = $(form).serializeArray();
			    $.each(x, function(i, field){
			    	columnas+= field.name+ ',99';
			    	if (columnas.length > 0) {
			    		columnas = columnas.substr(0, columnas.length - 1);
                    }
			    });
			    var valores = '';
				 var x = $(form).serializeArray();
				    $.each(x, function(i, field){
				    	valores+= field.value+ ',99';
				    	if (valores.length > 0) {
				    		valores = valores.substr(0, valores.length - 1);
                        }
				    });
			  var data = {tabla: 'esq_rendicioncuentas.tbl_mecanismo_rendicion_cuentas',columns:columnas,values:valores,condicion:'mecanismo_cod',valorcondicion:$("#mecanismo_cod").val()};
			
			  ejecutarJsonUpdate(form,data);
		}
		form.addClass('was-validated');


	});



	
</script>