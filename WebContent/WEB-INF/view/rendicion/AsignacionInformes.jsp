<%-- 
	version		: 1.0
	Document  	: asignarInformes
	Property   	: CPCCS
	Author		: Juan Carlos Vega
	Mail		: jc.vega@live.com
    Date		: 24/08/2021, 10:16:19
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<head>
</head>
<!-- <div class="card text-center mb-card10"> -->
<!-- <div class="card text-center mb-card15"> -->
	<div class="card-header">
		<h5>Formulario para la asignación de Instituciones y sus informes
			a los tecnicos de Rendición de Cuentas</h5>
	</div>
	<div class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="card-body">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="form-group row">
								<div class="col-md-12 text-left"></div>
							</div>
							<div class="col-md-12 order-md-1">

								<form:form class="needs-validation" novalidate=""
									id="listarReportes" data-rutaAplicacion="tecnicoNacional"
									data-opcion="AsignacionInformesAtecnicos"
									data-destino="tablaMecanismo" data-nombre="Reporte">
									<input type="hidden" id="asignador" name="asignador"
										value="${asignador}">
									<div class="card-body">
										<div class="form-group row">
											<div class="col-md-2 text-left">

												<label for="cmbPeriodo">Periodo</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="cmbPeriodo" required="required" name="cmbPeriodo"
													onchange="graficoAsignacionInformePorTecnico();">

													<c:forEach var="i" begin="${anio}" end="${anioActual-1}"
														step="1" varStatus="status">
														<c:set var="selected" value="" />
														<c:choose>
															<c:when test="${anio==i}">
																<option value="">Seleccione...</option>
															</c:when>
														</c:choose>
														<option ${selected} value="${i}">${i}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													periodo</div>
											</div>

											<div class="col-md-2 text-left">
												<label for="theJson"> Número de informes a asignar</label>
											</div>
											<div class="col-md-3 text-left">
												<div id="theJson"></div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="cmbProvincia">Provincia</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="cmbProvincia" required="required" name="cmbProvincia">
													<option value="">Seleccione...</option>
													<c:forEach var="listadoLocalizacionProvincia"
														items="${listadoLocalizacionProvincia}">
														<option
															value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													provincia</div>
											</div>


											<div class="col-md-2 text-left funcionario">
												<label for="cmbTecnicos">Técnico de rendición de
													cuentas</label>
											</div>
											<div class="col-md-3 text-left funcionario">
												<select class="custom-select custom-select-sm"
													id="cmbTecnicos" required="required" name="cmbTecnicos">
													<option value="">Seleccione...</option>
													<c:forEach var="listaTecnicos" items="${listaTecnicos}">
														<option value="${listaTecnicos.identificador}">${listaTecnicos.nombre}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione un
													técnico</div>
											</div>


										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="cmbFuncion">Tipo de función</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="cmbFuncion" required="required" name="cmbFuncion">
													<option value="">Seleccione...</option>
													<c:forEach var="listadoFunciones"
														items="${listadoFunciones}">
														<option value="${listadoFunciones.funCod}">${listadoFunciones.funDes}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione un
													formulario</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="cmbDescripcion">Descripción</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="cmbDescripcion" name="cmbDescripcion"
													required="required">
													<option value="">Seleccione...</option>
													<!--	 <option value="ASOCIACIONES">ASOCIACIONES</option>
								<option value="COMUNITARIA">COMUNITARIA</option>
								<option value="EMPRESAS PÚBLICAS">EMPRESAS PÚBLICAS</option>
								<option value="EOD">EOD</option>
								<option value="UDAF">UDAF</option>
								<option value="GAD">GAD</option>
								<option value="INSTITUCIONES VINCULADAS">INSTITUCIONES
									VINCULADAS</option>
								<option value="MANCOMUNIDADES Y  CONSORCIOS/ COMPETENCIAS A GAD">
									MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD</option>
								<option value="ORGANISMO DE DERECHO PRIVADO SIN FINES DE LUCRO">
									ORGANISMO DE DERECHO PRIVADO SIN FINES DE LUCRO</option>
								<option value="OTRA INSTITUCIONALIDAD DEL ESTADO">OTRA
									INSTITUCIONALIDAD DEL ESTADO</option>
								<option value="PRIVADO">PRIVADO</option>
								<option value="PÚBLICO">PÚBLICO</option> -->
												</select>
												<div class="invalid-feedback">Por favor seleccione un
													formulario</div>
											</div>
										</div>

										<div class="col-md-1"></div>
										<div class="form-group row">
											<div class="col-md-2 ">
												<button type="button" id="btnBuscar"
													class="btn _nuevoColor _buscar btn-sm ">Buscar</button>
												<button type="button" id="btnAsignar"
													class="btn _nuevoColor _buscar btn-sm ">Asignar</button>

											</div>

											<div class="col-md-2 "></div>

										</div>

									</div>
								</form:form>
							</div>
						</div>
						<!-- primer y segundo div en caso de cambio -->
					</div>
				</div>
			</div>
		</div>
	</div>

<div class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="card-body">
				<div class="row">
					<div class="col-lg-12">
		<div class="card">

			<div class="">
				<figure class="highcharts-figure col-md-12 mx-auto">
					<div id="container1"></div>

				</figure>
			</div>
		</div>
		<!-- primer y segundo div en caso de cambio -->
	</div>
</div>
</div>
</div>
</div>
<!-- </div> -->

</html>

<script type="text/javascript">
	$(document).ready(function() {
		$("#btnAsignar").hide();
		$("#theJson").val(0);
		$(".funcionario").hide();
		//graficoAsignacionInformePorTecnico();

	});
	/*
	
	$(document).ready(function asignacionInformes() {
		
	}
	$("#Prueba").click(function () {
		console.log("TExto funcionario>> ",)
	});

	);*/

	$('#btnAsignar').click(
			function() {
				$('#cmbTecnicos').attr('required', 'required');
				mostrarCargarAnimacion();
				var parametros = {
					"periodo" : $("#cmbPeriodo").val(),
					"provincia" : $("#cmbProvincia").val(),
					"tipoformulario" : $("#cmbTipoformulario").val(),
					"funcion" : $("#cmbFuncion").val(),
					"descripcion" : $("#cmbDescripcion").val(),
					"tecnico" : $("#cmbTecnicos").val(),
					"asignador" : $("#asignador").val()
				};
				$.ajax({
					url : 'view/rendicion/postJSONAsignacion',
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					dataType : 'json',
					data : parametros,
					success : function(result) {
						console.log(result);
						mostrarMensaje("Informes Asignados a: "
								+ $("#cmbTecnicos option:selected").text(),
								"EXITO", "5000");
						$('#btnAsignar').hide();
						$('#btnBuscar').show();
						$(".funcionario").hide();
						graficoAsignacionInformePorTecnico();
						resetSelect(), ocultarCargarAnimacion();
					},
					error : function() {
						alert("error");
					}
				});

			});

	$('#btnBuscar')
			.click(
					function() {
						$('#cmbTecnicos').removeAttr('required');
						$(".funcionario").hide();
						$("#theJson").empty();

						var form = $("#listarReportes")
						event.preventDefault();
						event.stopPropagation();
						if ((form[0].checkValidity() === false)
								|| ($("#cmbDescripcion").val() === "Seleccione...")) {
							mostrarMensaje(
									"Seleccione los datos para la busqueda!",
									"ERROR");
						} else {
							var parametros = {
								"periodo" : $("#cmbPeriodo").val(),
								"provincia" : $("#cmbProvincia").val(),
								"tipoformulario" : $("#cmbTipoformulario")
										.val(),
								"funcion" : $("#cmbFuncion").val(),
								"descripcion" : $("#cmbDescripcion").val()
							};
							$
									.ajax({
										url : 'view/rendicion/postJSONBuscar',
										headers : {
											"X-CSRF-TOKEN" : csrfToken
										},
										type : 'POST',
										dataType : 'json',
										data : parametros,
										success : function(result) {
											if (result == 0) {
												mostrarMensaje(
														"No se encontraron informes para Asignar!",
														"ERROR-NOTIFICACION",
														"5000");
											} else {
												$("#theJson").html(result);
												$("#theJson").val(result);
												$(".funcionario").show();
												mostrarMensaje(
														"Se encontro "
																+ result
																+ " informes para Asignar, Seleccion al Técnico!",
														"EXITO-NOTIFICACION",
														"5000");
											}

										},
										error : function() {
											alert("error");
										}
									});

						}
						form.addClass('was-validated');

					});

	$("#cmbTecnicos").change(function() {
		if ($("#cmbTecnicos").val() == "" || $("#theJson").val() == "0") {
			$("#btnBuscar").show();
			$("#btnAsignar").hide();
		} else {
			$("#btnBuscar").hide();
			$("#btnAsignar").show();
		}
	});

	$("#cmbProvincia").change(
			function() {
				var select = document.getElementById("cmbFuncion");
				var length = select.options.length;
				for (i = length - 1; i >= 0; i--) {
					select.options[i] = null;
				}

				var select2 = document.getElementById("cmbDescripcion");
				var length2 = select2.options.length;
				for (i = length2 - 1; i >= 0; i--) {
					select2.options[i] = null;
				}

				if ($("#cmbProvincia").val() == 259
						|| $("#cmbProvincia").val() == 241
						|| $("#cmbProvincia").val() == 250
						|| $("#cmbProvincia").val() == 263
						|| $("#cmbProvincia").val() == 254
						|| $("#cmbProvincia").val() == 252
						|| $("#cmbProvincia").val() == 247
						|| $("#cmbProvincia").val() == 245) {
					stringFunciones = '0';
					var stringFunciones = [ "Seleccione...",
							"FUNCIÓN JUDICIAL", "FUNCIÓN ELECTORAL",
							"FUNCIÓN LEGISLATIVA", "FUNCIÓN DE TRANSPARENCIA",
							"FUNCIÓN EJECUTIVA", "MEDIOS DE COMUNICACIÓN",
							"INSTITUCIONES DE EDUCACIÓN SUPERIOR",
							"GAD MUNICIPAL", "GAD PROVINCIAL",
							"GAD PARROQUIAL", "ASOCIACIONES GADS",
							"OTRAS INSTITUCIONES DEL ESTADO" ];
				} else {
					stringFunciones = '0';
					var stringFunciones = [ "Seleccione...", "TODOS",
							"TODAS FUNCIONES",
							"OTRAS INSTITUCIONES DEL ESTADO", "TODOS GAD",
							"TODOS LOS GAD PARROQUIALES",
							"TODOS LOS GAD MUNICIPALES",
							"TODOS LOS GAD PROVINCIALES",
							"TODAS LAS ASOCIACIONES GAD",
							"TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR",
							"TODOS LOS MEDIOS DE COMUNICACIÓN" ];

				}

				var select = document.getElementById("cmbFuncion"); //Seleccionamos el select

				for (var i = 0; i < stringFunciones.length; i++) {

					var option = document.createElement("option"); //Creamos la opcion
					option.innerHTML = stringFunciones[i]; //Metemos el texto en la opción
					select.appendChild(option); //Metemos la opción en el select
				}

				var select = document.getElementById("cmbDescripcion"); //Seleccionamos el select

				var option = document.createElement("option"); //Creamos la opcion
				option.innerHTML = "Seleccione..."
				select.appendChild(option); //Metemos la opción en el select

			});

	$("#cmbFuncion")
			.change(
					function() {

						var select = document.getElementById("cmbDescripcion");
						var length = select.options.length;
						for (i = length - 1; i >= 0; i--) {
							select.options[i] = null;
						}
						switch ($("#cmbFuncion").val()) {
						case "TODOS":
							stringDescripcion = '0';
							var stringDescripcion = [ "TODOS" ];
							break;
						case "TODAS FUNCIONES":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD", "EMPRESAS PÚBLICAS",
									"INSTITUCIONES VINCULADAS", "PRIVADO",
									"PÚBLICO" ];
							break;
						case "OTRAS INSTITUCIONES DEL ESTADO":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD",
									"OTRA INSTITUCIONALIDAD DEL ESTADO",
									"ORGANISMO DE DERECHO PRIVADO SIN FINES DE LUCRO" ];
							break;
						case "TODOS GAD":
							stringFunciones = '0';
							var stringDescripcion = [
									"Seleccione...",
									"TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS",
									"GAD",
									"MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD",
									"PÚBLICO" ];
							break;
						case "TODOS LOS GAD PARROQUIALES":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS" ];
							break;
						case "TODOS LOS GAD MUNICIPALES":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS",
									"MANCOMUNIDADES Y  CONSORCIOS/ COMPETENCIAS A GAD" ];
							break;
						case "TODOS LOS GAD PROVINCIALES":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS", "PÚBLICO" ];
							break;
						case "TODAS LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"EOD", "EMPRESAS PÚBLICAS", "GADS",
									"PÚBLICO", "PRIVADO" ];
							break;
						case "TODOS LOS MEDIOS DE COMUNICACIÓN":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"PÚBLICO", "PRIVADO", "COMUNITARIA", "UDAF" ];
							break;
						case "TODAS LAS ASOCIACIONES GAD":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"ASOCIACIONES", "EMPRESAS PÚBLICAS",
									"MANCOMUNIDADES Y  CONSORCIOS/ COMPETENCIAS A GAD" ];
							break;

						case "FUNCIÓN JUDICIAL":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD" ];
							break;
						case "FUNCIÓN ELECTORAL":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD" ];
							break;
						case "FUNCIÓN LEGISLATIVA":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF" ];
							break;
						case "FUNCIÓN DE TRANSPARENCIA":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD" ];
							break;
						case "FUNCIÓN EJECUTIVA":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD", "EMPRESAS PÚBLICAS",
									"INSTITUCIONES VINCULADAS", "PRIVADO",
									"PÚBLICO" ];
							break;
						case "INSTITUCIONES DE EDUCACIÓN SUPERIOR":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"EOD", "EMPRESAS PÚBLICAS", "GADS",
									"PÚBLICO", "PRIVADO" ];
							break;
						case "MEDIOS DE COMUNICACIÓN":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"PÚBLICO", "PRIVADO", "COMUNITARIA", "UDAF" ];
							break;
						case "GAD PARROQUIAL":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS" ];
							break;
						case "GAD MUNICIPAL":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS",
									"MANCOMUNIDADES Y  CONSORCIOS/ COMPETENCIAS A GAD" ];
							break;
						case "GAD PROVINCIAL":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"INSTITUCIONES VINCULADAS",
									"EMPRESAS PÚBLICAS GAD", "GADS", "PÚBLICO" ];
							break;
						case "ASOCIACIONES GADS":
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"ASOCIACIONES", "EMPRESAS PÚBLICAS",
									"MANCOMUNIDADES Y  CONSORCIOS/ COMPETENCIAS A GAD" ];
							break;

						case ("OTRAS INSTITUCIONES DEL ESTADO"):
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione...", "TODOS",
									"UDAF", "EOD",
									"OTRA INSTITUCIONALIDAD DEL ESTADO" ];
							break;
						case ("Seleccione..."):
							stringFunciones = '0';
							var stringDescripcion = [ "Seleccione..." ];
							break;
						}

						var select = document.getElementById("cmbDescripcion"); //Seleccionamos el select

						for (var i = 0; i < stringDescripcion.length; i++) {

							var option = document.createElement("option"); //Creamos la opcion
							option.innerHTML = stringDescripcion[i]; //Metemos el texto en la opción
							select.appendChild(option); //Metemos la opción en el select
						}

					});
	/*
	 function graficoAsignacionInformePorTecnico() {

	 var chart;
	 $.ajax({
	 url : 'GraficaAsignacionInformeTecnico',
	 type : "POST",
	 headers : {
	 "X-CSRF-TOKEN" : csrfToken
	 },
	 dataType : "json",
	 success : function(Result) {
	 var categories = [];
	 var seriesData1 = [];
	 var seriesData2 = [];
	 for ( var i in Result) {
	 categories.push(Result[i].fecha);
	 seriesData1.push(parseInt(Result[i].cumplido));
	 seriesData2.push(parseInt(Result[i].incumplido));

	 }
	 Graficalinea(categories, seriesData1, seriesData2,
	 "container1", "Informes Asignados x Técnico",
	 "Sistema Nacional de Rendición de Cuentas",
	 "Asignados", "Calificados")
	 },
	 error : function(xhr) {
	 alert('error');
	 }
	 });

	 }
	 */
	function graficoAsignacionInformePorTecnico() {
		var chart;
		var selectedYear = $("#cmbPeriodo").val(); // Obtenemos el valor seleccionado del select
		$.ajax({
			url : 'GraficaAsignacionInformeTecnico',
			type : "POST",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			data : {
				year : selectedYear
			}, // Enviamos el año seleccionado al servidor
			dataType : "json",
			success : function(Result) {
				var categories = [];
				var seriesData1 = [];
				var seriesData2 = [];
				for ( var i in Result) {
					categories.push(Result[i].fecha);
					seriesData1.push(parseInt(Result[i].cumplido));
					seriesData2.push(parseInt(Result[i].incumplido));
				}
				// Concatenamos el año seleccionado con el texto del título de la gráfica
				var titulo = "Informes Asignados x Técnico " + selectedYear;
				Graficalinea(categories, seriesData1, seriesData2,
						"container1", titulo,
						"Sistema Nacional de Rendición de Cuentas",
						"Asignados", "Calificados")
			},
			error : function(xhr) {
				alert('error');
			}
		});
	}

	function mostrarCargarAnimacion() {
		var contenedor = document.getElementById('contenedor_carga');
		contenedor.style.visibility = 'visible';
		contenedor.style.opacity = '1';
	}
	function ocultarCargarAnimacion() {
		var contenedor = document.getElementById('contenedor_carga');
		contenedor.style.visibility = 'hidden';
		contenedor.style.opacity = '0';
	}
	function resetSelect() {
		$('#cmbTecnicos').prop('selectedIndex', 0);
		//descomentar si se quiere que el resto de select box se reseteen
		//$('#cmbPeriodo').prop('selectedIndex', 0);
		$('#cmbProvincia').prop('selectedIndex', 0);
		$('#cmbFuncion').prop('selectedIndex', 0);
		$('#cmbDescripcion').prop('selectedIndex', 0);
		$("#theJson").val(0);
		$("#theJson").empty();
	}
</script>
