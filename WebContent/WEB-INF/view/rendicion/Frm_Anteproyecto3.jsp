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
							modelAttribute="TblAnteproyectoPresupuesto" id="anteCod"
							data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
							data-accionEnExito="ACTUALIZAR">
							<table class="table registros table-bordered">
								<tr>
									<th class="tablaingreso" width="50%"></th>
									<th class="tablaingreso" width="25%">PONGA SI O NO</th>
									<th class="tablaingreso" width="25%">ATRAVÉS DE QUÉ MEDIO
									</th>
								<tr>
									<td scope="row">UNA VEZ QUE EL LEGISLATIVO APROBÓ EL
										ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE DIÓ A CONOCER A
										LA CIUDADANÍA
									<td scope="row"><select
										class="custom-select custom-select-sm " id="ante_opc"
										name="ante_opc" onchange="validar3(this)" required="required">
											<option value="">Seleccione...</option>
											<option value="SI">SI</option>
											<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados
											de Implementación</div></td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="ante_descrip"
											required="required" name="ante_descrip"
											placeholder="Ingrese el nombre lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											nombre</div></td>
								</tr>
							</table>
						</form:form>
					</div>
					<input type="hidden" id="ante_cod" name="ante_cod"
						value="${anteCod}">
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnActualizar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
				</div>
			</div>
		</c:when>
		<c:when test="${infestado=='matriz'}">
			<table id="TablaAnteproyectoPresupuesto3"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th colspan="6"></th>
					</tr>
					<tr>
						<th class="tablaingreso" width="5%">#</th>
						<th class="tablaingreso" width="60%">ANTEPROYECTOS</th>
						<th class="tablaingreso" width="10%">PONGA SI O NO</th>
						<th class="tablaingreso" width="20%">ATRAVÉS DE QUÉ MEDIO</th>
						<th class="tablaingreso" width="5%"></th>
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
		cargarValorComboPorDefecto("ante_opc", '${anteOpc}');
		document.getElementById("ante_descrip").value = "${anteDescrip}";

	   if ('${anteOpc}' == 'NO') {
			console.log("entraNO");
			$('textarea[name="ante_descrip"]').prop('disabled', true);

		} else {
			console.log("entrasi");
			$('textarea[name="ante_descrip"]').prop('disabled', false);
			document.getElementById("ante_descrip").value = "${anteDescrip}";
		}
	});

	$("#btnActualizar")
			.click(
					function(event) {
						var form = $("#anteCod")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {

							$("textarea").prop('disabled', false);
							

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
							//console.log(data);
							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');
					});

	function Actualizar3(element) {
		$('#TablaAnteproyectoPresupuesto3 tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
	}

	function validar3(elemento) {
		if ($(elemento).val() === "SI") {
			$("textarea").text("");
			$("textarea").prop('disabled', false);
			} else if ($(elemento).val() === "NO") {
				$("textarea").prop('disabled', true);
				$("textarea").prop('required', false);
				$("textarea").val("NO APLICA");
				$("#ante_descrip").val("NO APLICA");

		} else

		{
		}
	}
</script>
