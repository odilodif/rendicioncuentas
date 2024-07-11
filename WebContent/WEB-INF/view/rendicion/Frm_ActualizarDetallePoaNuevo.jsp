<%-- 
	version		: 1.0
    Document  	: Frm_GAD_EjecucionProgramatica
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
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

<div class="card text-center mb-card20">

	<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDetalleEjecucionp"
					id="ActualizarDetallePoaNuevo" data-rutaAplicacion="rendicion"
					data-opcion="guardarActualizarDetallePoa"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE EJECUCIÓN PRESUPUESTARIA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div id="Mensaje">
						<div class="alert alert-primary" role="alert">Seleccione un solo TIPO DE EJECUCIÓN y manténgalo como criterio para completar toda la ejecución presupuestaria de su institución.</div>
					</div>
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th width="30%"></th>
					<th width="70%"></th>
					<tr>
					<td scope="row">
						TIPO DE EJECUCIÓN
					</td>
						<td scope="row">
												
						<select class="custom-select custom-select-sm" id="depTipo"
										required="required" name="depTipo" onchange="corregir()">
										<option value="">elegir tipo de reporte</option>
										<c:forEach var="tipoMetas"
											items="${tipoMeta}">
											<option
												value="${tipoMetas}">${tipoMetas}</option>
								</c:forEach>
							</select>
						
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN
					</td>
						<td scope="row">
						<select class="custom-select custom-select-sm" id="epMeta"
										required="required" name="epMeta" >
										<option value="">Seleccione una Meta</option>
										<c:forEach var="listadoMetas"
											items="${listadoMetas}">
											<option
												value="${listadoMetas.eprMeta}">${listadoMetas.eprMeta}</option>
								</c:forEach>
							</select>
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="depDescripcion" required="required"
										name="depDescripcion"
										placeholder="Ingrese la descripcion lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO PLANIFICADO: 
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="depPresplan" name="depPresplan" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO EJECUTADO:
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="depPresejec" name="depPresejec" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" >
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						 LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN: 
					</td>
						<td scope="row">
						<!-- <td style="vertical-align: middle;">
							</td> -->
								<input type="url" class="form-control form-control-sm case" id="depLink" name="depLink"  value="http://"
								 required="required">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
						</td>
					</tr>
					</table>
						
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarNuevo"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
</div>
</html>

<script type="text/javascript">


$(document).ready(function() {
		
		$('#depDescripcion').hide();
		$('#epMeta').hide();
	});


$("#btnGuardarNuevo").click(function(event) {
	var form = $("#ActualizarDetallePoaNuevo")
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
		} else {

			
				ejecutarJson(form);
				
			 	}
		form.addClass('was-validated');
});

	

	function corregir() {
	if (document.getElementById("depTipo").value === "META"){
		$('#depDescripcion').hide();
		$("#depDescripcion").attr("disabled", true);
		$('#epMeta').show();
		$("#epMeta").attr("disabled", false);
		
	  }else{
		  if (document.getElementById("depTipo").value === "PROGRAMA Y/O PROYECTO" || document.getElementById("depTipo").value === "AREA"){
		  $('#depDescripcion').show();
			$("#depDescripcion").attr("disabled", false);
			$('#epMeta').hide();
			$("#epMeta").attr("disabled", true);
		  }else{

				$('#depDescripcion').hide();
				$('#epMeta').hide();
			  }
	  }		
	}


 	     
		 
</script>