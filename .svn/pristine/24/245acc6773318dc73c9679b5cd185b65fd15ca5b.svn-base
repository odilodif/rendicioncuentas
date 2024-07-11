<%-- 
	version		: 1.0
    Document  	: Frm_InformacionSedesExtensiones
    Created on	: 17/02/2021; 15:57:14
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

<div class="card text-center mb-card15">
	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card-body">
			<div class="row">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblSede" id="Sede" data-rutaAplicacion="rendicion"
					data-opcion="guardarActualizarSedeDetalle" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">INFORMACIÓN
						DE SEDES Y EXTENSIONES DE LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR
						COBERTURA GEOGRÁFICA Y DE ATENCIÓN DE LAS SEDES Y EXTENSIONES DE
						IES</h5>
					<div id="Mensaje">
						<div class="alert alert-primary" role="alert">En caso de
							contar con extensiones llenar los siguientes campos</div>
					</div>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<input type="hidden" id="seCod" name="seCod" value="${seCod}">
					
						<table class="table registros table-bordered">
							<tr>
								<th colspan="8"></th>
							</tr>
							<tr>
								<td scope="row">NOMBRE DEL REPRESENTANTE LEGAL</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm " id="seRepresentante"
									required="required" name="seRepresentante"
									value="${nombreRepresentante}" minlength="3"
									maxlength="64" value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
									<div class="invalid-feedback col-md-6 text-left">Por
										favor ingrese sus Apellidos y Nombres</div></td>
							</tr>
							<tr>
								<td scope="row">CARGO DEL REPRESENTANTE LEGAL</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm" id="seCargo"
									required="required" name="seCargo"
									value="${cargo}" minlength="3" maxlength="64"
									value="">
									<div class="invalid-feedback">Por favor ingrese el Cargo</div>
								</td>
							</tr>
							<tr>
								<td scope="row">CORREO ELECTRÓNICO DEL REPRESENTANTE LEGAL
								</td>
								<td scope="row" colspan="6"><input type="email"
									class="form-control form-control-sm" id="seMailrep"
									required="required" name="seMailrep"
									value="${correo}"
									pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Por favor ingrese una
										dirección de correo electrónico valida</div></td>
							</tr>

							<tr>
								<td scope="row">FECHA DE DESIGNACIÓN:</td>
								<td scope="row" colspan="6">

									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="seDesignacion"
											name="seDesignacion" class="form-control form-control-sm"
											placeholder="${designacion}" value="${designacion}">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de designación con formato dd/mm/aaaa</div>
									</div>

								</td>
							</tr>
							<tr>
								<td scope="row">TELÉFONO:</td>
								<td scope="row" colspan="6"><input type="text"
									class="form-control form-control-sm" id="seTelrep"
									name="seTelrep" required="required" value="${telefono}"
									maxlength="13"
									pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
									data-inputmask="'mask': '(99) 999-9999'">
									<div class="invalid-feedback">Por favor ingrese su
										teléfono</div></td>
							</tr>
						</table>
					</form:form>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
					</div>
			</div>
			</div>
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
		construirValidador();
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
		
		var f = new Date();
		var fecha=(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
		
		$('#seDesignacion').datepicker({
		  forceParse: true,
		  todayBtn: false
		}).datepicker('setStartDate', '01/01/2010');
		
		$('#seDesignacion').datepicker({

		}).datepicker('setEndDate', fecha);
		
		$('#seDesignacion').datepicker({

		}).datepicker('update', fecha);
		
		$('#seDesignacion').datepicker({

		}).datepicker('update','');


	
		
	});

	$("#btnGuardarI").click(function(event) {

		var form = $("#Sede")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
			    $("#infCod").attr("disabled", false);
				
			    ejecutarJson(form);
				 	}
			form.addClass('was-validated');

	});
	
	

  
	
	
</script>