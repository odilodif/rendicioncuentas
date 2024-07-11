<%-- 
	version		: 1.0
    Document  	: Frm_FasesPresupuesto
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
		<c:when test="${infestado=='activo'}">
			<div class="card-header text-white carHeaderBlue">
				<h5>ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblAnteproyectoPresupuesto1" id="anteCod"
							data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
							data-accionEnExito="ACTUALIZAR">
							<table class="table registros table-bordered">
								<tr>
									<th class="tablaingreso" width="50%"></th>
									<th class="tablaingreso" width="25%">PONGA SI O NO</th>
									<th class="tablaingreso" width="25%">CON QUÉ ACTOR SE
										REALIZÓ</th>
								<tr>
									<td scope="row">EL ANTEPROYECTO DEL PRESUPUESTO
										PARTICIPATIVO SE DIÓ A CONOCER A LA CIUDADANÍA DEL 20 AL 31 DE
										OCTUBRE
									<td scope="row"><select
										class="custom-select custom-select-sm " id="ante_opc"
										name="ante_opc" onchange="validar(this)" required="required">
											<option value="">Seleccione...</option>
											<option value="SI">SI</option>
											<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados
											de Implementación</div></td>

									<td align="center" style="vertical-align: middle;">
										<table class="tablacheckbox">
											<tr>
												<td style="vertical-align: middle;"><label for="uno"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="ASAMBLEA CIUDADANA"> ASAMBLEA CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="dos"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="INSTANCIA DE PARTICIPACIÓN CIUDADANA">
														INSTANCIA DE PARTICIPACIÓN CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN">
														ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN</label></td>
											</tr>
										</table> <input type="hidden" class="form-control form-control-sm"
										id="ante_descrip" name="ante_descrip">
										<div class="invalid-feedback">Seleccione un almenos un
											checkbox</div>

									</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnActualizar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
				</div>
				<input type="hidden" id="ante_cod" name="ante_cod"
					value="${anteCod}">
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
		$('[id="checks[]"]').click(function() {
			var arr = $('[id="checks[]"]:checked').map(function() {
				return this.value;
			}).get();
			var str = arr.join('<br>');
			$('#ante_descrip').val(str);
		});
		cargarValorComboPorDefecto("ante_opc", '${anteOpc}');
		if ('${anteOpc}' === "NO") {
			$('input').prop('disabled', true);
			$('input').prop('checked', false);
			$("#ante_descrip").val("NO APLICA");	

		} else {
			$('input').prop('disabled', false);
		}

	});

	$("#btnActualizar")
			.click(
					function(event) {
						var form = $("#anteCod")
						var numero = ValidateSelection()
						event.preventDefault();
						event.stopPropagation();
						if ($('#ante_opc').val() === "NO"){

							if (form[0].checkValidity() === false) {
								mostrarMensaje(
										"Por favor ingrese toda la información solicitada!",
										"ERROR");
							} else {
								var columnas = '';
								var x = $(form).serializeArray();
								$.each(x, function(i, field) {
									columnas += field.name + ',99';
									if (columnas.length > 0) {
										columnas = columnas.substr(0,
												columnas.length - 1);
									}
								});
								var valores = '';
								var x = $(form).serializeArray();
								$.each(x, function(i, field) {
									valores += field.value + ',99';
									if (valores.length > 0) {
										valores = valores.substr(0,
												valores.length - 1);
									}
								});
								var data = {
									tabla : 'esq_rendicioncuentas.tbl_anteproyecto_presupuesto',
									columns : columnas,
									values : valores,
									condicion : 'ante_cod',
									valorcondicion : $("#ante_cod").val()
								};
								
								ejecutarJsonUpdate(form, data);
							}

							}else{

							if (numero === 0 || form[0].checkValidity() === false) {
								mostrarMensaje(
										"Por favor ingrese toda la información solicitada!",
										"ERROR");
							} else {
								var columnas = '';
								var x = $(form).serializeArray();
								$.each(x, function(i, field) {
									columnas += field.name + ',99';
									if (columnas.length > 0) {
										columnas = columnas.substr(0,
												columnas.length - 1);
									}
								});
								var valores = '';
								var x = $(form).serializeArray();
								$.each(x, function(i, field) {
									valores += field.value + ',99';
									if (valores.length > 0) {
										valores = valores.substr(0,
												valores.length - 1);
									}
								});
								var data = {
									tabla : 'esq_rendicioncuentas.tbl_anteproyecto_presupuesto',
									columns : columnas,
									values : valores,
									condicion : 'ante_cod',
									valorcondicion : $("#ante_cod").val()
								};

								
								ejecutarJsonUpdate(form, data);
							}

							}
						form.addClass('was-validated');
						
					});

	function Actualizar1(element) {
		$('#TablaAnteproyectoPresupuesto1 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
	}

	function validar(elemento) {
		
		if ($(elemento).val() === "SI") {
			$('input').prop('disabled', false);
			$('#ante_descrip').val("");	
			} else if ($(elemento).val() === "NO") {
			$('input').prop('disabled', true);
			$('input').prop('checked', false);
			$('#ante_descrip').prop('disabled', false);
			$('#ante_descrip').val("NO APLICA");	
	

		} else

		{
		}
	}

	function ValidateSelection() {
		
		var checkboxes = $('[id="checks[]"]:checked').map(function() {
			return this.value;
		}).get();
		var valor = checkboxes.length
		if (checkboxes.length === 0) {
			mostrarMensaje("Favor seleccione al menos un Actor!", "ERROR");
		}
		
		return valor
	}
</script>
