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
					data-opcion="guardarActualizarSedeDetalle2" data-accionEnExito="ACTUALIZAR">
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
								<td scope="row">No. UNIDADES (CAMPUS)</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seUnidades"
									required="required" name="seUnidades" value="${numeroUnidades}"
									minlength="13" maxlength="20" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>

							<tr>
								<td scope="row">COBERTURA GEOGRÁFICA</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm" id="seCobertura"
									required="required" name="seCobertura"
									value="${cobertura}" minlength="3" maxlength="64"
									value="">
									<div class="invalid-feedback">Por favor ingrese la cobertura</div>
								</td>
							</tr>
							<tr>
								<td scope="row">No. DE ESTUDIANTES</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seEstudiantes"
									required="required" name="seEstudiantes" value="${estudiantes}"
									minlength="13" maxlength="20" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>
							<tr>
								<td rowspan="2" scope="row">DETALLE EL No. DE ESTUIDANTES
									POR GÉNERO</td>
								<th scope="col" colspan="2" style="text-align: center; font-size: x-small;"
									width="10%">MASCULINO</th>
								<th scope="col" colspan="2" style="text-align: center; font-size: x-small;"
									width="10%">FEMENINO</th>
								<th scope="col" colspan="2"  style="text-align: center; font-size: x-small;"
									width="10%">GLBTI</th>
							</tr>

							<tr align="center">
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seHombre"
									name="seHombre" required="required" value="${hombre}" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seMujeres"
									name="seMujeres" required="required" value="${mujer}" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seGlbti"
									name="seGlbti" required="required" value="${glbti}" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
							</tr>
							<tr>
								<td rowspan="2" scope="row">DETALLE EL No. DE ESTUIDANTES
									POR PUEBLOS Y NACIONALIDADES</td>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">MONTUBIOS</th>
									<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">MESTIZO</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">CHOLOS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">INDIGENAS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">AFROECUATORIANOS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">EXTRANJEROS</th>
								
							</tr>

							<tr align="center">
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seMontubios"
									name="seMontubios" required="required" value="${montubio}"/>
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seMestizos"
									name="seMestizos" required="required" value="${mestizo}" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seCholos"
									name="seCholos" required="required" value="${cholo}" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seIndigenas"
									name="seIndigenas" required="required" value="${indigena}"/>
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seAfroecuatorianos"
									name="seAfroecuatorianos" required="required" value="${afro}"/>
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seExtranjeros"
									name="seExtranjeros" required="required" value="${extranjeros}"/>
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								
							</tr>
							
							<tr>
								<td scope="row">No. DE ESTUDIANTES CON DICAPACIDAD</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seDiscapacitados"
									required="required" name="seDiscapacitados" value="${discapacidad}"
									minlength="13" maxlength="20" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>
							<tr>
								<td scope="row">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td scope="row" colspan="6">
								<input type="text"
									class="form-control form-control-sm" id="seLink"
									required="required" name="seLink"
									placeholder="INGRESAR PAGINA WEB" value="${link}">
									<div class="invalid-feedback">Por favor ingrese la
										dirección en el siguiente formato http://dirreccionDePaginaWeb</div>
							
							
							</tr>
						
						</table>
					
					
					</form:form>
						
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
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
	});

	$("#btnGuardarI").click(function(event) {
		
		var form = $("#Sede")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
			    $("#infCod").attr("disabled", false);
				var te = parseInt($("#seEstudiantes").val());   
				var totalE = te | 0 ;
				var h = parseInt($("#seHombre").val());
				var m = parseInt($("#seMujeres").val());
				var g = parseInt($("#seGlbti").val());
				var mo = parseInt($("#seMontubios").val());
				var me = parseInt($("#seMestizos").val());
				var ch = parseInt($("#seCholos").val());
				var ind = parseInt($("#seIndigenas").val());
				var afro = parseInt($("#seAfroecuatorianos").val());
				var ex = parseInt($("#seExtranjeros").val());
				var disca = parseInt($("#seDiscapacitados").val());
				var discapa = disca | 0;
			
				var genero = h  +  m  + g ;
				
				var pueblos = mo  + me  + ch  + ind  + afro  + ex;
				if (genero>totalE){
					mostrarMensaje("La suma de los generos no puede ser mayor al Numero de Estudiantes!",	"ERROR");
					}else if (pueblos>totalE){
					mostrarMensaje("La suma de los pueblos y nacionalidades no puede ser mayor al Numero de Estudiantes!",	"ERROR");
					}else if (discapa>totalE){
					mostrarMensaje("El numero de alumnos con discapacidad no puede ser mayor al Numero de Estudiantes!",	"ERROR");
					}	else{
						ejecutarJson(form);
						}
			
				 	}
			form.addClass('was-validated');

	});

	

	
  
	
	
</script>