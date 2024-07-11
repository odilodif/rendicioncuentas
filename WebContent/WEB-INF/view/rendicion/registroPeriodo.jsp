<%-- 
	version		: 1.0
    Document  	: registroPeriodo
    Created on	: 02/02/2021, 16:11:34
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com

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
<c:set var="tamanioArchivo"
	value="<%=Constantes.TAMANIO_ARCHIVO_25_MEGAS%>" />
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_ARCHIVOS_APLICACION%>" />
<c:set var="rutaModuloInscripcion"
	value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />


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
	<c:choose>
		<c:when test="${infAutEstado=='activo'|| infAutEstado=='finalizado'}">
			<div class="card card-secondary">
				<!-- <div>
					<div id="informacion">
						¡Excelente!... Usted ya tiene asignado un informe.<br /> <span
							style="font-weight: bold;"></span> <br />Dirigase al menú
						siguiente.
					</div>
				</div> -->

				<div class="card">
					<h4 class="card-header text-white carHeaderBlue">
						Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
							class="text-white">Periodo ${periodo}</span>
					</h4>
					<div class="card-body">
						<div id="MensajeEdad">
							<div class="alert alert-warning" role="alert">Datos
								Generales</div>
						</div>

						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="nombreAutoridad">Nombre de la Autoridad:</label>
							</div>
							<div class="col-md-6 text-left">
								<input type="text" class="form-control form-control-sm"
									id="nombreAutoridad" name="nombreAutoridad" disabled
									value="${nombreAutoridad}" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="identificadorAutoridad">Cédula:</label>
							</div>
							<div class="col-md-6 text-left">
								<input type="text" class="form-control form-control-sm"
									id="identificadorAutoridad" name="identificadorAutoridad"
									disabled value="${identificadorAutoridad}" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="institucionDignidad">Institución en la que
									ejerce la Dignidad:</label>
							</div>
							<div class="col-md-6 text-left">
								<input type="text" class="form-control form-control-sm"
									id="institucionDignidad" name="institucionDignidad" disabled
									value="${institucionDignidad}" />
							</div>
						</div>

						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="dignidad">Dignidad que ejerce:</label>
							</div>
							<div class="col-md-6 text-left">
								<input type="text" class="form-control form-control-sm"
									id="dignidad" name="dignidad" disabled value="${dignidad}" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="ambito">Ámbito de representación de la
									Dignidad:</label>
							</div>
							<div class="col-md-6 text-left">
								<input type="text" class="form-control form-control-sm"
									id="ambito" name="ambito" disabled value="${ambito}" />
							</div>
						</div>

					</div>
				</div>

			</div>

		</c:when>


		<c:when
			test="${infAutEstado=='CONCLUIDO'|| infAutEstado=='concluido'}">

			<div>
				<div id="informacion">
					<!--  Autoridades y Gads -->

					“En cumplimiento de los artículos 20 y 21 del Reglamento de
					Rendición de Cuentas vigente, se informa que el Sistema Informático
					se habilitará después de quince días de concluido el plazo (31 de
					mayo del ${anio}) para la entrega del Informe de Rendición de
					Cuentas al Consejo de Participación Ciudadana y Control
					Social.Luego de ello, éste sistema se habilitará hasta el 31 de
					diciembre del año en curso para aquellas institucionesy entidades
					que no entregaron su informe en el plazo establecido, sin modificar
					la condición de incumplido.”
					<!--  	¡Información!... Recuerde que de acuerdo con el Reglamento de Rendición de Cuentas del proceso ${periodo}, el sistema permanecerá suspendido temporalmente para su sector hasta el ${fechaApertura} del ${anio}<br /> <span
						style="font-weight: bold;"></span> A partir del día siguiente, se le permitirá finalizar su informe fuera del plazo reglamentario, hasta el 31 de diciembre de ${anio}.
				-->
				</div>

			</div>
		</c:when>

		<c:otherwise>
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformeAutoridad" id="autCodigo"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarRegistroPeriodo"
					data-accionEnExito="ACTUALIZAR">
					<input type="hidden" id="identificadorSolicitante" name="email"
						value="${email}">
					<input type="hidden" id="tipo" name="tipo" value="${tipo}">
					<input type="hidden" id="estadoInforme" name="estadoInforme"
						value="${estadoInforme}">
					<input type="hidden" id="identificador" name="identificador"
						value="${identificador}">
					<div class="card">
						<h4 class="card-header text-white carHeaderBlue">Periodo de
							Rendición de Cuentas</h4>
						<div class="card-body">
							<div id="MensajeEdad">
								<div class="alert alert-warning" role="alert">Seleccione
									el periodo de su gestión</div>
							</div>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="fechaInicioGestion">Fecha de inicio de
										gestión:</label>
								</div>
								<div class="col-md-2 text-left">
									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="fechaInicioGestion"
											name="fechaInicioGestion"
											class="form-control form-control-sm" value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de inicio de gestión</div>
									</div>
								</div>
								<div class="col-md-3 text-left">
									<label for="fechaFinGestion">Fecha fin de gestión,
										dentro del año fiscal:</label>
								</div>
								<div class="col-md-2 text-left">
									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="fechaFinGestion"
											name="fechaFinGestion" class="form-control form-control-sm"
											value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de inicio de gestión</div>
									</div>
								</div>
							</div>

							<div class="form-group row">


								<div class="col-md-3 text-left">
									<label for="fechaNacimiento">Fecha de Rendición de
										Cuentas:</label>
								</div>
								<div class="col-md-2 text-left">
									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="fechaRendicion" name="fechaRendicion"
											class="form-control form-control-sm" value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese su fecha
											de nacimiento con formato dd/mm/aaaa</div>
									</div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="lugar">Lugar de la Rendición de Cuentas a
										la ciudadania:</label>
								</div>
								<div class="col-md-9">
									<input type="text" style="text-transform: uppercase;"
										class="form-control form-control-sm " id="lugar"
										required="required" name="lugar"
										placeholder="Lugar donde se dio la rendición de cuentas a la ciudadania"
										maxlength="64" value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
									<div class="invalid-feedback col-md-6 text-left">Por
										favor ingrese el lugar</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="numeroAsistentes" class="col-form-label">Número
										de asistentes<span class="text-muted"> (Opcional)</span>

									</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="number" class="form-control form-control-sm"
										id="numeroAsistentes" name="numeroAsistentes"
										placeholder="000" maxlength="20" min="0" pattern="^[0-9]+" onkeypress="mascaraEnteros(this)" onpaste="return false">
									<div class="invalid-feedback">Por favor ingrese el numero
										de asistentes</div>
								</div>
							</div>
						</div>
					</div>
				</form:form>
			</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>

		</c:otherwise>
	</c:choose>
</div>
</html>

<script type="text/javascript">
	var csrfToken = $('input[name="_csrf"]').val();

	$(document).ready(function() {

		var f = new Date();
		var dia1 = "01";
		var dia30 = "30";
		var mes1 = "01";
		var dia31 = "31";
		var mes12 = "12";
		var anio = f.getFullYear() - 1;
		var anioRC = f.getFullYear() - 4;
		var anioFin = f.getFullYear();
		var fechaInicio = (dia1 + "/" + mes1 + "/" + anio);
		var fechaFin = (dia31 + "/" + mes12 + "/" + anio);
		var fechaHoy = (dia31 + "/" + mes12 + "/" + f.getFullYear())
		//var fechaInicioAutoridad=(dia1 + "/" + mes1 + "/" + anioFin);
		var fechaInicioAutoridad = (dia1 + "/" + mes1 + "/" + anio);
		var fechaFinAutoridad = (dia31 + "/" + mes12 + "/" + anioFin);

		var fechaInicioRC = (dia1 + "/" + mes1 + "/" + anioRC);
		$('#fechaFinGestion').datepicker({
			forceParse : true,
			todayBtn : false
		}).datepicker('setStartDate', fechaInicio);

		$('#fechaFinGestion').datepicker({

		}).datepicker('setEndDate', fechaFin);

		$('#fechaFinGestion').datepicker({

		}).datepicker('update', fechaFin);
		$('#fechaFinGestion').datepicker({

		}).datepicker('update', '');

		$('#fechaInicioGestion').datepicker({
			forceParse : true,
			todayBtn : false
		}).datepicker('setStartDate', fechaInicioRC);

		$('#fechaInicioGestion').datepicker({

		}).datepicker('setEndDate', fechaFin);

		$('#fechaInicioGestion').datepicker({

		}).datepicker('update', fechaInicioRC);
		$('#fechaInicioGestion').datepicker({

		}).datepicker('update', '');

		var estado = '<c:out value="${estado}" />';

		$('#fechaRendicion').datepicker({
			forceParse : true,
			todayBtn : false
		}).datepicker('setStartDate', fechaInicioAutoridad);
		$('#fechaRendicion').datepicker({

		}).datepicker('setEndDate', fechaFinAutoridad);

		$('#fechaRendicion').datepicker({

		}).datepicker('setEndDate', fechaHoy);

		/*	$('#fechaRendicion').datepicker({

			}).datepicker('minDate', fechaHoy);*/

		/*	$('#fechaRendicion').datepicker({

			}).datepicker('update','');*/

	});

	$("#btnGuardar")
			.click(
					function(event) {
						$('#autCodigo').attr('data-opcion',
								'guardarRegistroPeriodo');
						var form = $("#autCodigo")
						event.preventDefault();
						event.stopPropagation();
						var numeroAsistentesInput = $("#numeroAsistentes");//si no ingresa asistentes, dado que es opcional
						if (numeroAsistentesInput.val() === "") {
							numeroAsistentesInput.val(0);//se le pone en cero
						}
						if (form[0].checkValidity() === true) {
							ejecutarJson(form);
						}else {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
							form.addClass('was-validated');
						}

					});
</script>