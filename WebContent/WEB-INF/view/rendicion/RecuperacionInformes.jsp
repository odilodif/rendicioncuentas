<%-- 
	version		: 1.0
    Document  	: RecuperacionInformes
    Created on	: 9 ene. 2023 ; 15:14:01
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
    Celular     : 0995491200
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

<!-- <div class="card text-center mb-card10"> -->

<div class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="card-body">
			<div class="row">
				<div class="col-lg-12">
					<div class="card">
						<div class="card-header text-center mb-card15">
							<h5>Formulario para la asignación de Instituciones y sus
								informes a los tecnicos de Rendición de Cuentas</h5>
						</div>
						<div class="form-group row">
							<div class="col-md-12 text-left">
								<form:form class="needs-validation" novalidate=""
									id="FrmRecuperarAdignaciones" data-rutaAplicacion="rendicion"
									data-opcion="EliminacionAsignacion" data-accionEnExito="ACTUALIZAR"
									data-destino="TblAsignacion" data-nombre="Reporte">
									<input type="hidden" id="asignador" name="asignador"
										value="${asignador}">
									<div class="card-body">
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="cmbPeriodo">Seleccione el periodo</label>
											</div>
											<div class="col-md-3 text-left">
												<select class="custom-select custom-select-sm"
													id="cmbPeriodo" required="required" name="cmbPeriodo"
													onchange="cargarDatosUsuario()">

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
										</div>
										<%-- <div class="form-group row">

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
											<div class="col-md-2 ">
												<button type="button" id="btnBuscar"
													class="btn _nuevoColor _buscar btn-sm ">Recuperar</button>

											</div>
										</div> --%>

										<div class="form-group row">
											<div class="col-md-2 text-left funcionario">
												<label for="cmbTecnicos">Técnico de rendición de
													cuentas</label>
											</div>
											<div class="col-md-3 text-left funcionario">
												<select class="custom-select custom-select-sm"
													id="cmbTecnicos" required="required" name="cmbTecnicos">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione un
													técnico</div>
											</div>
											
										</div>
										<div class="form-group row">
										<div class="col-md-2">
												<button type="button" id="btnBuscar"
													class="btn _nuevoColor _buscar btn-sm">Recuperar</button>
											</div>
										</div>
									</div>
								</form:form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {

	});
	/* 
	$('#btnBuscar')
			.click(
					function() {
						var form = $("#FrmRecuperarAdignaciones")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Seleccione los datos para la busqueda!",
									"ERROR");
						} else {
							visualizarMensajeConfirmacion(
									'ATENCIÓN',
									'¿Está seguro de recuperar los informes asignados '
											+ $(
													'select[name="cmbTecnicos"] option:selected')
													.text() + '?', form,
									'basicconfir');
							/*var parametros = {
								"rendicion" : $("#cmbPeriodo").val(),
								"provincia" : $("#cmbProvincia").val(),
								"tipoformulario" : $("#cmbTipoformulario")
										.val(),
								"funcion" : $("#cmbFuncion").val(),
								"descripcion" : $("#cmbDescripcion").val()
							};*/

						/*}
						form.addClass('was-validated');

					}); */
	
	/*
	 $("#cmbTecnicos").change(function() {
	 if ($("#cmbTecnicos").val() == "" || $("#theJson").val() == "0") {
	 $("#btnBuscar").show();
	 $("#btnAsignar").hide();
	 } else {
	 $("#btnBuscar").hide();
	 $("#btnAsignar").show();
	 }
	 });*/
	function cargarDatosUsuario() {
		var selectedYear = $("#cmbPeriodo").val();
		$.ajax({
			url : 'getTecnicosPorPeriodo',
			type : 'GET',
			data : {
				periodo : selectedYear
			},
			dataType : 'json',
			success : function(data) {
				// Clear the cmbTecnicos options
				$('#cmbTecnicos').empty();
				$('#cmbTecnicos').append($('<option>', {
					value : "",
					text : "Seleccione..."
				}));
				// Append new options based on the fetched data
				$.each(data, function(index, tecnico) {
					$('#cmbTecnicos').append($('<option>', {
						value : tecnico.identificador,
						text : tecnico.nombre
					}));
				});
			},
			error : function(xhr, status, error) {
				// Handle error if needed
				console.error(error);
			}
		});
	}
	 $('#btnBuscar')
		.click(
				function() {
					var form = $("#FrmRecuperarAdignaciones");
					
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Seleccione los datos para la busqueda!",
								"ERROR");
					} else {
						visualizarMensajeConfirmacion(
								'ATENCIÓN',
								'¿Está seguro de recuperar los informes asignados '
										+ $(
												'select[name="cmbTecnicos"] option:selected')
												.text() + '?', form,
								'basicconfir');
						/*var parametros = {
							"rendicion" : $("#cmbPeriodo").val(),
							"provincia" : $("#cmbProvincia").val(),
							"tipoformulario" : $("#cmbTipoformulario")
									.val(),
							"funcion" : $("#cmbFuncion").val(),
							"descripcion" : $("#cmbDescripcion").val()
						};*/

					}
					form.addClass('was-validated');

				});
</script>
