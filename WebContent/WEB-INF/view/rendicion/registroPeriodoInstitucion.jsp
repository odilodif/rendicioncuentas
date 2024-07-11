<%-- 
	version		: 1.0
    Document  	: registroPeriodoInstitucion
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

<c:set var="ListaCEMunicipales"
	value="<%=Constantes.ListaCompetenciasExclusivasGadMunicipal()%>" />
<c:set var="ListaCEParroquiales"
	value="<%=Constantes.ListaCompetenciasExclusivasGadParroquial()%>" />
<c:set var="ListaCEProvinciales"
	value="<%=Constantes.ListaCompetenciasExclusivasGadProvincial()%>" />
<c:set var="ListaCEMunicipalesA"
	value="<%=Constantes.ListaCompetenciasExclusivasGadMunicipal()%>" />
<c:set var="ListaCEParroquialesA"
	value="<%=Constantes.ListaCompetenciasExclusivasGadParroquial()%>" />
<c:set var="ListaCEProvincialesA"
	value="<%=Constantes.ListaCompetenciasExclusivasGadProvincial()%>" />

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


<form:form class="needs-validation vistaFasePeriodoEliminado" novalidate=""
		>

		<div class="card">
			<div>
				<div id="informacion">
					¡Información!... Su institución fue eliminada del Catastro.<br /> <span
						style="font-weight: bold;"></span> <br />Comuniquese con un técnico de la Subcoordinación Nacional de Rendición de Cuentas del CPCCS.
				</div>
			</div>
		</div>
	
	</form:form>

	<form:form class="needs-validation vistaFasePeriodo" novalidate=""
		modelAttribute="TblInforme" id="autCodigo"
		data-rutaAplicacion="rendicion"
		data-opcion="guardarRegistroPeriodoInstitucion"
		data-accionEnExito="ACTUALIZAR">

		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">Periodo de
					Rendición de Cuentas</h4>
				<div class="card-body">
					<div id="MensajeEdad">
						<div class="alert alert-primary" role="alert">Seleccione el
							periodo de su gestión</div>
					</div>

					<div class="form-group row">
						<div class="col-md-3 text-left">
							<label for="fechaInicioGestion">Fecha de inicio:</label>
						</div>
						<div class="col-md-2 text-left">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i>
								</span> <input type="text" required="required" id="fechaInicioGestion"
									name="fechaInicioGestion" class="form-control form-control-sm"
									value="" maxlength="10"
									pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
								<div class="invalid-feedback">Por favor ingrese la fecha
									de inicio de gestión</div>
							</div>
						</div>

						<div class="col-md-3 text-left">
							<label for="fechaFinGestion">Fecha fin:</label>
						</div>
						<div class="col-md-2 text-left">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i>
								</span> <input type="text" required="required" id="fechaFinGestion"
									name="fechaFinGestion" class="form-control form-control-sm"
									value="" maxlength="10"
									pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
								<div class="invalid-feedback">Por favor ingrese la fecha
									de inicio de gestión</div>
							</div>
						</div>

						<c:choose>
							<c:when test="${Tipo_Formulario==5}">
								<div class="col-md-2 text-left">
									<select class="custom-select custom-select-sm"
										id="infProyComun" name="infProyComun" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione si o
										no</div>
								</div>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardar"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>

	<form:form class="needs-validation vistaCompetenciasExclusivas"
		novalidate="" modelAttribute="TblFuncionesObjetivos" id="Gad"
		data-rutaAplicacion="rendicion"
		data-opcion="guardarObjetivosFuncionesCE"
		data-accionEnExito="ACTUALIZAR">

		<div class="card-body">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Competencias/Funciones</div>
					</div>

					<div class="col-md-12 text-left">
						<table
							class="table tablaingreso table-bordered dataTable">
							<thead>
								<tr>
									<th class="ocultar">codigo</th>
									<th style="vertical-align: middle; font-size: xx-small;">Detalle</th>
									<th style="vertical-align: middle; font-size: xx-small;">Tipo</th>
									<!-- <th>Quitar</th> -->
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasExclusivas}">
									<tr id="r_${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td style="vertical-align: middle; font-size: xx-small;"><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td style="vertical-align: middle; font-size: xx-small;"><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<!-- <td class="text-center"><button type="button"
																onclick='EliminarFuncioneObjetivo(this)'
																class="_eliminarColor _eliminar"></button></td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

		<div id="Mensaje">
			<div class="alert alert-primary" role="alert">En el caso de tener competencias / funciones, favor ingresarlas una a una</div>
		</div>
					<fieldset class="vistaAgregarFuncionesObjetivosGad">
						<legend>Lista</legend>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivos">Competencia</label>
							</div>
							<div class="col-md-5 text-left" id="resultadoFuncionesObjetivos">
								<input type="hidden" class="form-control form-control-sm"
									id="idFuncionObjetivoGad" name="idFuncionObjetivoGad" />
								<textarea rows="1" cols="" class="form-control form-control-sm"
									id="nFuncionObjetivoGad" 
									name="nFuncionObjetivoGad"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarFuncionesObjetivosGad"
									name="agregarFuncionesObjetivosGad"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesObjetivosGad">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesObjetivosGad" name="cmbFuncionesObjetivosGad"
									>
									<option value="1">Seleccione...</option>
									<option value="COMPETENCIAS / FUNCIONES">COMPETENCIAS / FUNCIONES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>
						</div>
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th style="vertical-align: middle; font-size: xx-small;">Detalle</th>
										<th style="vertical-align: middle; font-size: xx-small;">Tipo</th>
										<th style="vertical-align: middle; font-size: xx-small;">Quitar</th>
									</tr>
								</thead>
								<tbody id="tablaFuncionesObjetivosGad">
									<c:forEach var="objectList"
										items="${listadoFuncionesObjetivos}">
										<tr id="r_${objectList[0]}">
											<td class="ocultar"><input type="hidden" id="codigo"
												name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aFuncionObjetivo"
												name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden" id="bFuncioneObjetivo"
												name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivo(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>



					</fieldset>



				</div>
			</div>
		
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarGadCE"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
		<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
		</div>
	</form:form>

	<form:form class="needs-validation vistaCompetenciasExclusivasActualizar"
		novalidate="" modelAttribute="TblFuncionesObjetivos"
		id="GadActualizar" data-rutaAplicacion="rendicion"
		data-opcion="guardarObjetivosFunciones"
		data-accionEnExito="ACTUALIZAR">
		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Actualizar
							Competencias / Funciones</div>
					</div>

					<div class="col-md-12 text-left">
						<table
							class="table competenciasExclusivasMostrar table-bordered dataTable">
							<thead>
								<tr>

									<th colspan="4" class="tablaingreso">COMPETENCIAS
										EXCLUSIVAS</th>

								</tr>
								<tr>
									<th class="ocultar">codigo</th>
									<th class="tablaingreso">Detalle</th>
									<th class="tablaingreso">Tipo</th>
									<!-- <th>Quitar</th> -->
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasExclusivasActualizar}">
									<tr id="r_${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<!-- <td class="text-center"><button type="button"
																onclick='EliminarFuncioneObjetivo(this)'
																class="_eliminarColor _eliminar"></button></td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="col-md-12 text-left">
						<table
							class="table competenciasConcurrenteActualziar table-bordered dataTable">
							<thead>
								<tr>

									<th colspan="4" class="tablaingreso">COMPETENCIAS / FUNCIONES</th>

								</tr>
								<tr>
									<th width="10%" class="ocultar">codigo</th>
									<th width="60%" class="tablaingreso">Detalle</th>
									<th width="10%" class="tablaingreso">Tipo</th>
									<th width="10%" class="tablaingreso"></th>
									<th width="10%" class="tablaingreso"></th>
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasConcurrentesActualizar}">
									<tr id="${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<td class="text-center"><button type="button"
												id="Modificar"
												class="_modificar btn _actualizarColor btn-sm"
												onclick="ModificarDatosTabla(this)" title="Editar Registro"
												data-toggle="tooltip"
												style="text-align: center; font-size: x-small;">
												Editar</button></td>
										<c:choose>
											<c:when test="${objectList[4]==null}">

												<td class="text-center"><button type="button"
														onclick='Eliminar(this)'
														class="_eliminarColor _eliminar  btn-sm"
														style="text-align: center; font-size: x-small;">Eliminar</button></td>
											</c:when>

										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<fieldset class="vistaAgregarFuncionesObjetivosGadActualizar">
						<legend>Lista</legend>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivosActualizar">Competencia</label>
							</div>
							<div class="col-md-5 text-left"
								id="resultadoFuncionesObjetivosActualizar">
								<input type="hidden" class="form-control form-control-sm"
									id="idFuncionObjetivoGadActualizar"
									name="idFuncionObjetivoGadActualizar" />
								<textarea rows="2" cols="" class="form-control form-control-sm"
									id="nFuncionObjetivoGadActualizar" required="required"
									name="nFuncionObjetivoGadActualizar"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button"
									id="agregarFuncionesObjetivosGadActualizar"
									name="agregarFuncionesObjetivosGadActualizar"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesObjetivosGadActualizar">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesObjetivosGadActualizar"
									name="cmbFuncionesObjetivosGadActualizar" required="required">
									<option value="1">Seleccione...</option>
									<option value="COMPETENCIAS / FUNCIONES">COMPETENCIAS / FUNCIONES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>
						</div>
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th>Detalle</th>
										<th>Tipo</th>
										<th></th>
									</tr>
								</thead>
								<tbody id="tablaFuncionesObjetivosGadActualizar">
									<c:forEach var="objectList"
										items="${listaCompetenciasConcurrentes}">
										<tr id="r_${objectList[0]}">
											<td class="ocultar"><input type="hidden" id="codigo"
												name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aFuncionObjetivo"
												name="aFuncioneObjetivoActualizar[]"
												value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden"
												id="bFuncioneObjetivoActualizar"
												name="bFuncioneObjetivoActualizar[]"
												value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivo(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>



				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarGadActualizar"
				class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
		</div>
	</form:form>
	
<!-- ejectuvio  -->


 <form:form class="needs-validation vistaFOEjecutivoActualizar"
		novalidate="" modelAttribute="TblFuncionesObjetivos"
		id="EjecutivoActualizar" data-rutaAplicacion="rendicion"
		data-opcion="guardarObjetivosFunciones"
		data-accionEnExito="ACTUALIZAR">
		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Actualizar 
							Funciones / Objetivos / Fines</div>
					</div>


					<div class="col-md-12 text-left">
						<table
							class="table competenciasConcurrenteActualziar table-bordered dataTable">
							<thead>
								<tr>

									<th colspan="4" class="tablaingreso">Funciones / Objetivos
										/ Fines</th>

								</tr>
								<tr>
									<th width="10%" class="ocultar">codigo</th>
									<th width="60%" class="tablaingreso">Detalle</th>
									<th width="10%" class="tablaingreso">Tipo</th>
									<th width="10%" class="tablaingreso"></th>
									<th width="10%" class="tablaingreso"></th>
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasConcurrentesActualizar}">
									<tr id="${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<td class="text-center"><button type="button"
												id="Modificar"
												class="_modificar btn _actualizarColor btn-sm"
												onclick="ModificarDatosTablaEjecutivo(this)"
												title="Editar Registro" data-toggle="tooltip"
												style="text-align: center; font-size: x-small;">
												Editar</button></td>
										<c:choose>
											<c:when test="${objectList[4]==null}">

												<td class="text-center"><button type="button"
														onclick='Eliminar(this)'
														class="_eliminarColor _eliminar  btn-sm"
														style="text-align: center; font-size: x-small;">Eliminar</button></td>
											</c:when>

										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<fieldset class="vistaAgregarFuncionesObjetivosGadActualizar">
						<legend>Lista</legend>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivosActualizar">Competencia</label>
							</div>
							<div class="col-md-5 text-left"
								id="resultadoFuncionesObjetivosActualizar">
								<input type="hidden" class="form-control form-control-sm"
									id="idFuncionObjetivoActualizar"
									name="idFuncionObjetivoActualizar" />
								<textarea rows="2" cols="" class="form-control form-control-sm"
									id="nFuncionObjetivoActualizarE" required="required"
									name="nFuncionObjetivoActualizarE"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarFuncionesObjetivosActualizar"
									name="agregarFuncionesObjetivosActualizar"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesObjetivosActualizar">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<!-- ejecutivo -->
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesObjetivosActualizarE"
									name="cmbFuncionesObjetivosActualizarE" required="required">
									<option value="1">Seleccione...</option>
									<option value="OBJETIVOS ESTRATÉGICOS">OBJETIVOS
										ESTRATÉGICOS</option>
									<option value="FUNCIONES">FUNCIONES</option>
									<option value="FINES">FINES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>
						</div>
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th>Detalle</th>
										<th>Tipo</th>
										<th></th>
									</tr>
								</thead>
								<tbody id="tablaFuncionesObjetivosActualizarE">
									<c:forEach var="objectList"
										items="${listaCompetenciasConcurrentes}">
										<tr id="r_${objectList[0]}">
											<td class="ocultar"><input type="hidden" id="codigo"
												name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aFuncionObjetivoE"
												name="aFuncionObjetivoActualizarE[]"
												value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden"
												id="bFuncioneObjetivoActualizarE"
												name="bFuncioneObjetivoActualizarE[]"
												value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivoE(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>



				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarActualizar"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>

	<form:form class="needs-validation vistaFaseFuncionObjetivo"
		novalidate="" modelAttribute="TblFuncionesObjetivos" id="foCod"
		data-rutaAplicacion="rendicion"
		data-opcion="guardarObjetivosFuncionesEjecutivo"
		data-accionEnExito="ACTUALIZAR">

		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Objetivos
							Estratégicos</div>
					</div>


					<fieldset class="vistaAgregarFuncionesObjetivos">
						<legend>Lista</legend>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivos">Objetivos
									Estratégicos/Funciones o Fines</label>
							</div>
							<div class="col-md-5 text-left" id="resultadoFuncionesObjetivos">
								<input type="hidden" class="form-control form-control-sm"
									id="idFuncionObjetivoEjecutivo"
									name="idFuncionObjetivoEjecutivo" />
								<textarea rows="2" cols="" class="form-control form-control-sm"
									id="nFuncionObjetivoEjecutivo" required="required"
									name="nFuncionObjetivoEjecutivo"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarFuncionesObjetivosEjecutivo"
									name="agregarFuncionesObjetivosEjecutivo"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesObjetivosEjecutivo">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesObjetivosEjecutivo"
									name="cmbFuncionesObjetivosEjecutivo" required="required">
									<option value="1">Seleccione...</option>
									<option value="OBJETIVOS ESTRATÉGICOS">OBJETIVOS
										ESTRATÉGICOS</option>
									<option value="FUNCIONES">FUNCIONES</option>
									<option value="FINES">FINES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>
						</div>
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th>Detalle</th>
										<th>Tipo</th>
										<th>Quitar</th>
									</tr>
								</thead>
								<tbody id="tablaFuncionesObjetivosEjecutivo">
									<c:forEach var="objectList"
										items="${listadoFuncionesObjetivos}">
										<tr id="r_${objectList[0]}">
											<td><input type="hidden" id="codigoEjecutivo"
												name="codigoEjecutivo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aFuncioneObjetivoEjecutivo"
												name="aFuncioneObjetivoEjecutivo[]" value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden" id="bFuncioneObjetivoEjecutivo"
												name="bFuncioneObjetivoEjecutivo[]" value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivoEjecutivo(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarFuncionObjetivoEjecutivo"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>

	<form:form class="needs-validation vistaFaseDatos">
		<div class="card">
			<h4 class="card-header text-white carHeaderBlue">
				Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
					class="text-white">Periodo ${periodo}</span>
			</h4>
			<div class="card-body">
				<div id="MensajeEdad">
					<div class="alert alert-primary" role="alert">Datos Generales</div>
				</div>

				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="nombreInstitución">Nombre de la Institución:</label>
					</div>
					<div class="col-md-8 text-left">
						<input type="text" class="form-control form-control-sm"
							id="nombreInstitución" name="nombreInstitución" disabled
							value="${nombreInstitución}" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="identificadorInstitucion">Ruc:</label>
					</div>
					<div class="col-md-6 text-left">
						<input type="text" class="form-control form-control-sm"
							id="identificadorInstitucion" name="identificadorInstitucion"
							disabled value="${identificadorInstitucion}" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="representanteLegal">Representante Legal:</label>
					</div>
					<div class="col-md-6 text-left">
						<input type="text" class="form-control form-control-sm"
							id="representanteLegal" name="representanteLegal" disabled
							value="${representanteLegal}" />
					</div>
				</div>

				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="funcione">Funcion:</label>
					</div>
					<div class="col-md-6 text-left">
						<input type="text" class="form-control form-control-sm"
							id="funcione" name="funcione" disabled value="${funcion}" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="tipo">Tipo:</label>
					</div>
					<div class="col-md-6 text-left">
						<input type="text" class="form-control form-control-sm" id="tipo"
							name="tipo" disabled value="${tipo}" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-md-2 text-left">
						<label for="pertenece">Pertenece a:</label>
					</div>
					<div class="col-md-8 text-left">
						<input type="text" class="form-control form-control-sm"
							id="pertenece" name="pertenece" disabled value="${pertenece}" />
					</div>
				</div>

			</div>
		</div>
		<c:choose>
			<c:when test="${estadoInforme=='activo'}">
				<div class="col-md-12 text-center">
					<button type="button" id="btnFuncionesObjetivosCompetencias"
						class="btn _nuevoColor _buscar btn-sm mt-2">Ver
						Funciones/Objetivos/Competencias</button>
				</div>
			</c:when>
		</c:choose>
	</form:form>

	<form:form class="needs-validation vistaInstitucionesVinculadas"
		novalidate="" modelAttribute="TblFuncionesObjetivos" id="Vinculadas"
		data-rutaAplicacion="rendicion"
		data-opcion="guardarCompetenciasVinculadas"
		data-accionEnExito="ACTUALIZAR">

		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Competencias / Funciones</div>
					</div>



					<fieldset class="vistaAgregarFuncionesObjetivosGad">
						<legend>Lista</legend>


						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesCompetenciasVinculadas">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesCompetenciasVinculadas"
									name="cmbFuncionesCompetenciasVinculadas" required="required">
									<option value="1">Seleccione...</option>
									<!--<option value="COMPETENCIAS CONCURRENTES / FUNCIONES">COMPETENCIAS CONCURRENTES / FUNCIONES</option>-->
									  <option value="COMPETENCIAS / FUNCIONES">COMPETENCIAS / FUNCIONES</option> 
									<option value="COMPETENCIAS EXCLUSIVAS">COMPETENCIAS EXCLUSIVAS</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarCompetenciasEVinculadas"
									name="agregarCompetenciasEVinculadas"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>

						<div id="cmbCompetenciasVinculadasTipo" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesCompetenciasVinculadasTipo">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesCompetenciasVinculadasTipo"
									name="cmbFuncionesCompetenciasVinculadasTipo"
									required="required">
									<option value="0">Seleccione...</option>
									<option value="1">COMPETENCIAS EXCLUSIVAS MUNICIPALES</option>
									<option value="2">COMPETENCIAS EXCLUSIVAS PROVINCIALES</option>
									<option value="3">COMPETENCIAS EXCLUSIVAS PARROQUIALES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>


							</div>
						</div>

						<div id="CListaCEMunicipales" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEMunicipales">COMPETENCIAS
									EXCLUSIVAS MUNICIPALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEMunicipales" required="required"
									name="ListaCEMunicipales">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEMunicipales"
										items="${ListaCEMunicipales}">
										<option value="${ListaCEMunicipales}">${ListaCEMunicipales}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>

						<div id="CListaCEParroquiales" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEParroquiales">COMPETENCIAS
									EXCLUSIVAS PARROQUIALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEParroquiales" required="required"
									name="ListaCEParroquiales">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEParroquiales"
										items="${ListaCEParroquiales}">
										<option value="${ListaCEParroquiales}">${ListaCEParroquiales}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>

						<div id="CListaCEProvinciales" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEProvinciales">COMPETENCIAS
									EXCLUSIVAS PROVINCIALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEProvinciales" required="required"
									name="ListaCEProvinciales">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEProvinciales"
										items="${ListaCEProvinciales}">
										<option value="${ListaCEProvinciales}">${ListaCEProvinciales}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>
						<div id="competenciaConcurrente" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivos">Función/Objetivo</label>
							</div>
							<div class="col-md-5 text-left" id="resultadoFuncionesObjetivos">
								<input type="hidden" class="form-control form-control-sm"
									id="idComteneciaVinculada" name="idComteneciaVinculada" />
								<textarea rows="2" cols="" class="form-control form-control-sm"
									id="nComteneciaVinculada" required="required"
									name="nComteneciaVinculada"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarCompetenciasVinculadas"
									name="agregarCompetenciasVinculadas"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>

						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th>Detalle</th>
										<th>Tipo</th>
										<th>Quitar</th>
									</tr>
								</thead>
								<tbody id="tablaCompetenciasVinculada">
									<c:forEach var="objectList"
										items="${listadoFuncionesObjetivos}">
										<tr id="r_${objectList[0]}">
											<td class="ocultar"><input type="hidden" id="codigo"
												name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aCompentenciaVinculada[]"
												name="aCompentenciaVinculada[]" value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden" id="bCompentenciaVinculada[]"
												name="bCompentenciaVinculada[]" value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivo(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>



				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="button" id="btnGuardarGadVinculadas"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>

	<form:form class="needs-validation ActualizarCompetencia" novalidate=""
		modelAttribute="TblFuncionesObjetivos"
		id="ActualizarCompetenciaConcurrente" data-rutaAplicacion="rendicion"
		data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">


		<table class="table registros table-bordered">
			<tr>
				<th class="tablaingreso" width="50%">TIPO</th>
				<th class="tablaingreso" width="50%">DETALLE</th>
			</tr>
			<tr>
				<td scope="row"><label id=fo_tip></label></td>

				<td scope="row"><input type="text"
					style="text-transform: uppercase;"
					class="form-control form-control-sm" id="fo_nom" name="fo_nom"
					placeholder="Ingrese la información solicitada" required="required">
					<div class="invalid-feedback">Por favor ingrese la
						información</div></td>

			</tr>
		</table>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnActualziarCC"
				class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
		</div>
		<input type="hidden" id=fo_cod name="fo_cod">



	</form:form>

	<form:form class="needs-validation vistaCompetenciasVinculadasActualizar"
		novalidate="" modelAttribute="TblFuncionesObjetivos"
		id="GadActualizarA" data-rutaAplicacion="rendicion"
		data-opcion="guardarObjetivosFuncionesActualizarA"
		data-accionEnExito="ACTUALIZAR">
		<div class="card">
			<input type="hidden" id="identificadorSolicitante" name="email"
				value="${email}"> <input type="hidden" id="tipo" name="tipo"
				value="${tipo}"> <input type="hidden" id="estadoInforme"
				name="estadoInforme" value="${estadoInforme}"> <input
				type="hidden" id="identificador" name="identificador"
				value="${identificador}">
			<div class="card">
				<h4 class="card-header text-white carHeaderBlue">
					Informe de Rendición de Cuentas Nro. ${numeroInforme} <br> <span
						class="text-white">Periodo ${periodo}</span>
				</h4>

				<div class="card-body">
					<div id="MensajeFuncionObjetivo">
						<div class="alert alert-primary" role="alert">Actualizar
							Competencias / Funciones</div>
					</div>

					<div class="col-md-12 text-left">
						<table
							class="table competenciasExclusivasMostrar table-bordered dataTable">
							<thead>
								<tr>

									<th colspan="4" class="tablaingreso">COMPETENCIAS
										EXCLUSIVAS</th>

								</tr>
								<tr>
									<th class="ocultar">codigo</th>
									<th class="tablaingreso">Detalle</th>
									<th class="tablaingreso">Tipo</th>
									<!-- <th>Quitar</th> -->
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasExclusivasActualizar}">
									<tr id="r_${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<!-- <td class="text-center"><button type="button"
																onclick='EliminarFuncioneObjetivo(this)'
																class="_eliminarColor _eliminar"></button></td> -->
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="col-md-12 text-left">
						<table
							class="table competenciasConcurrenteActualziar table-bordered dataTable">
							<thead>
								<tr>

									<th colspan="4" class="tablaingreso">COMPETENCIAS
										CONCURRENTES</th>

								</tr>
								<tr>
									<th width="10%" class="ocultar">codigo</th>
									<th width="60%" class="tablaingreso">Detalle</th>
									<th width="10%" class="tablaingreso">Tipo</th>
									<th width="10%" class="tablaingreso"></th>
									<th width="10%" class="tablaingreso"></th>
								</tr>
							</thead>
							<tbody id="tablaCompetenciasExclusivas">
								<c:forEach var="objectList"
									items="${listaCompetenciasConcurrentesActualizar}">
									<tr id="${objectList[0]}">
										<td class="ocultar"><input type="hidden" id="codigo"
											name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
										<td><input type="hidden" id="aFuncioneObjetivo"
											name="aFuncioneObjetivo[]" value="${objectList[1]}" />${objectList[1]}</td>
										<td><input type="hidden" id="bFuncioneObjetivo"
											name="bFuncioneObjetivo[]" value="${objectList[2]}" />${objectList[2]}</td>
										<td class="text-center"><button type="button"
												id="Modificar"
												class="_modificar btn _actualizarColor btn-sm"
												onclick="ModificarDatosTabla(this)" title="Editar Registro"
												data-toggle="tooltip"
												style="text-align: center; font-size: x-small;">
												Editar</button></td>
										<c:choose>
											<c:when test="${objectList[4]==null}">

												<td class="text-center"><button type="button"
														onclick='Eliminar(this)'
														class="_eliminarColor _eliminar  btn-sm"
														style="text-align: center; font-size: x-small;">Eliminar</button></td>
											</c:when>

										</c:choose>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


					<fieldset class="vistaAgregarFuncionesObjetivosGad">
						<legend>Lista</legend>


						<div class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesCompetenciasVinculadasA">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesCompetenciasVinculadasA"
									name="cmbFuncionesCompetenciasVinculadasA" required="required">
									<option value="1">Seleccione...</option>
									<!-- <option value="COMPETENCIAS CONCURRENTES / FUNCIONES">COMPETENCIAS CONCURRENTES / FUNCIONES</option> -->
									<option value="COMPETENCIAS / FUNCIONES">COMPETENCIAS / FUNCIONES</option>  
									<option value="COMPETENCIAS EXCLUSIVAS">COMPETENCIAS EXCLUSIVAS</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarCompetenciasEVinculadasAA"
									name="agregarCompetenciasEVinculadasAA"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>

						<div id="cmbCompetenciasVinculadasTipoA" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbFuncionesCompetenciasVinculadasTipoA">Tipo:</label>
							</div>
							<div class="col-md-5  text-left">
								<select class="custom-select custom-select-sm"
									id="cmbFuncionesCompetenciasVinculadasTipoA"
									name="cmbFuncionesCompetenciasVinculadasTipoA"
									required="required">
									<option value="0">Seleccione...</option>
									<option value="1">COMPETENCIAS EXCLUSIVAS MUNICIPALES</option>
									<option value="2">COMPETENCIAS EXCLUSIVAS PROVINCIALES</option>
									<option value="3">COMPETENCIAS EXCLUSIVAS PARROQUIALES</option>
								</select>
								<div class="invalid-feedback">Por favor seleccione alguno</div>


							</div>
						</div>

						<div id="CListaCEMunicipalesA" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEMunicipalesA">COMPETENCIAS
									EXCLUSIVAS MUNICIPALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEMunicipalesA" required="required"
									name="ListaCEMunicipalesA">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEMunicipalesA"
										items="${ListaCEMunicipalesA}">
										<option value="${ListaCEMunicipalesA}">${ListaCEMunicipalesA}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>

						<div id="CListaCEParroquialesA" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEParroquialesA">COMPETENCIAS
									EXCLUSIVAS PARROQUIALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEParroquialesA" required="required"
									name="ListaCEParroquialesA">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEParroquialesA"
										items="${ListaCEParroquialesA}">
										<option value="${ListaCEParroquialesA}">${ListaCEParroquialesA}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>

						<div id="CListaCEProvincialesA" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="cmbListaCEProvincialesA">COMPETENCIAS
									EXCLUSIVAS PROVINCIALES:</label>
							</div>
							<div class="col-md-5 text-left">
								<select class="custom-select custom-select-sm"
									id="ListaCEProvincialesA" required="required"
									name="ListaCEProvincialesA">
									<option value="">Seleccione...</option>
									<c:forEach var="ListaCEProvincialesA"
										items="${ListaCEProvincialesA}">
										<option value="${ListaCEProvincialesA}">${ListaCEProvincialesA}</option>
									</c:forEach>
								</select>
								<div class="invalid-feedback">Por favor seleccione una
									opción</div>
							</div>
						</div>
						<div id="competenciaConcurrenteA" class="form-group row">
							<div class="col-md-3 text-left">
								<label for="FuncionesObjetivosA">Función/Objetivo</label>
							</div>
							<div class="col-md-5 text-left" id="resultadoFuncionesObjetivosA">
								<input type="hidden" class="form-control form-control-sm"
									id="idComteneciaVinculadaA" name="idComteneciaVinculadaA" />
								<textarea rows="2" cols="" class="form-control form-control-sm"
									id="nComteneciaVinculadaA" required="required"
									name="nComteneciaVinculadaA"
									placeholder="Ingrese la descripción lo más detalladamente posible"></textarea>
								<div class="invalid-feedback">Por favor ingrese la
									descripción</div>
							</div>

							<div class="col-md-3 text-left">
								<button type="button" id="agregarCompetenciasVinculadasA"
									name="agregarCompetenciasVinculadasA"
									class="btn _nuevoColor _agregarConTexto btn-sm">Agregar</button>
							</div>
						</div>

						<div class="col-md-12 text-left">
							<table class="table registros table-bordered dataTable">
								<thead>
									<tr>
										<th class="ocultar">codigo</th>
										<th>Detalle</th>
										<th>Tipo</th>
										<th>Quitar</th>
									</tr>
								</thead>
								<tbody id="tablaCompetenciasVinculadaA">
									<c:forEach var="objectList"
										items="${listadoFuncionesObjetivos}">
										<tr id="r_${objectList[0]}">
											<td class="ocultar"><input type="hidden" id="codigo"
												name="codigo" value="${objectList[0]}" />${objectList[0]}</td>
											<td><input type="hidden" id="aCompentenciaVinculadaA[]"
												name="aCompentenciaVinculadaA[]" value="${objectList[1]}" />${objectList[1]}</td>
											<td><input type="hidden" id="bCompentenciaVinculadaA[]"
												name="bCompentenciaVinculadaA[]" value="${objectList[2]}" />${objectList[2]}</td>
											<td class="text-center"><button type="button"
													onclick='EliminarFuncioneObjetivoA(this)'
													class="_eliminarColor _eliminar"></button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</fieldset>



				</div>
			</div>
		</div>
		<div class="col-md-12 text-center">
			<button type="submit" id="btnGuardarGadActualizarA"
				class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
		</div>
	</form:form>


	<form:form class="needs-validation concluido">
			
			<div>
				<div id="informacion">
				
				<!-- Funciones medios iess -->
				
				¡Información!...  “En cumplimiento de los artículos 20 y 21 del Reglamento de Rendición de Cuentas vigente, 
				se informa que el Sistema Informático se habilitará después de quince días de concluido el plazo (30 de abril del ${anio}) 
				para la entrega del Informe de Rendición de Cuentas al Consejo de Participación Ciudadana y Control Social.Luego de ello, 
				éste sistema se habilitará hasta el 31 de diciembre del año en curso para aquellas institucionesy entidades que no entregaron su informe en el plazo establecido, 
				sin modificar la condición de incumplido.” 
				
				<!--  	¡Información!... Recuerde que de acuerdo con el Reglamento de Rendición de Cuentas del proceso ${periodo}, el sistema permanecerá suspendido temporalmente para su sector hasta el ${fechaApertura} del ${anio}<br /> <span
						style="font-weight: bold;"></span> A partir del día siguiente, se le permitirá finalizar su informe fuera del plazo reglamentario, hasta el 31 de diciembre del presente año.
				-->
				</div>
			</div>
			
		
	</form:form>




</div>
</html>
<script type="text/javascript">
		
var informe='<c:out value="${estadoInforme}" />';
var gad='<c:out value="${gad}" />';
var funcionObjetivo='<c:out value="${funcionObjetivo}" />';
var tipoInstitucion='<c:out value="${tipoInstitucion}" />';
var codigoEjecutivo= 0;	
		
		$(document).ready(function() {

			//console.log("informe: ",informe);
			//console.log("gad: ",gad);
			//console.log("funcion objetivo: ",funcionObjetivo);
			//console.log("tipo institucion: ",tipoInstitucion);
					mostrarBotones();
					  $('.vistaCompetenciasVinculadasActualizar').hide();
					  $('#agregarCompetenciasEVinculadas').hide();
					  $(".vistaCompetenciasExclusivasActualizar").hide();
					  $("#agregarCompetenciasEVinculadasA").hide();
					var f = new Date();
					var dia1 = "01";
					var dia30 = "30";
					var mes1 = "01"; 
					var dia31 ="31";
					var mes12 ="12";
					var anio = f.getFullYear()-1;

					var fechaInicio=(dia1 + "/" + mes1 + "/" + anio);
					var fechaFin=(dia31 + "/" + mes12 + "/" + anio);

					
					$('#fechaFinGestion').datepicker({
						  forceParse: true,
						  todayBtn: false
					}).datepicker('setStartDate', fechaInicio);
						
					$('#fechaFinGestion').datepicker({

					}).datepicker('setEndDate', fechaFin);
						
					$('#fechaFinGestion').datepicker({

					}).datepicker('update', fechaFin);
					$('#fechaFinGestion').datepicker({

					}).datepicker('update','');
					

					$('#fechaInicioGestion').datepicker({
						  forceParse: true,
						  todayBtn: false
					}).datepicker('setStartDate', fechaInicio);
						
					$('#fechaInicioGestion').datepicker({

					}).datepicker('setEndDate', fechaFin);
						
					$('#fechaInicioGestion').datepicker({

					}).datepicker('update', fechaInicio);
					$('#fechaInicioGestion').datepicker({

					}).datepicker('update','');

					if (informe==="CONCLUIDO"){
						
						  $(".concluido").show();
						  $(".vistaFasePeriodo").hide();
							 $(".vistaFaseDatos").hide();
							  $(".vistaFaseFuncionObjetivo").hide();
							  $(".vistaCompetenciasExclusivas").hide();
								$(".vistaInstitucionesVinculadas").hide();
								$(".ActualizarCompetencia").hide();
								$(".vistaFOEjecutivoActualizar").hide();
								$(".ActualizarEjectutivo").hide();
								$(".vistaFasePeriodoEliminado").hide();
								
						
					}else{

					
					if ((informe==="activo" || informe==="finalizado") && funcionObjetivo==="activo" ) {
						  $(".vistaFaseDatos").show();
						  $(".vistaFaseFuncionObjetivo").hide();
						  $(".vistaCompetenciasExclusivas").hide();
						  $(".vistaFasePeriodo").hide();
						$(".vistaInstitucionesVinculadas").hide();
						$(".ActualizarCompetencia").hide();
						$(".vistaFOEjecutivoActualizar").hide();
						$(".ActualizarEjectutivo").hide();
						$(".concluido").hide();
						$(".vistaFasePeriodoEliminado").hide();
						
						
						
						} else if (informe==="activo"  && funcionObjetivo==="vacio") {
								if (gad==="gad") {
									$(".vistaCompetenciasExclusivas").show();
									$(".vistaFaseDatos").hide();
									$(".vistaFaseFuncionObjetivo").hide();
									$(".vistaInstitucionesVinculadas").hide();
									$(".vistaFasePeriodo").hide();
									$(".ActualizarCompetencia").hide();
									$(".vistaFOEjecutivoActualizar").hide();
									$(".ActualizarEjectutivo").hide();
									$(".concluido").hide();
									$(".vistaFasePeriodoEliminado").hide();
									
									
									
						
								}else{

									if (gad==="institucionesVinculadas") {
										$(".vistaInstitucionesVinculadas").show();
										$(".vistaFaseDatos").hide();
										  $(".vistaFaseFuncionObjetivo").hide();
											 $(".vistaCompetenciasExclusivas").hide();
											 $(".vistaFasePeriodo").hide();
												$(".ActualizarCompetencia").hide();
												$(".vistaFOEjecutivoActualizar").hide();
												$(".ActualizarEjectutivo").hide();
												$(".concluido").hide();
												$(".vistaFasePeriodoEliminado").hide();
												
												
							
									}else{
										  $(".vistaFaseFuncionObjetivo").show();
										$(".vistaFaseDatos").hide();
											$(".vistaInstitucionesVinculadas").hide();
											 $(".vistaCompetenciasExclusivas").hide();
											 $(".vistaFasePeriodo").hide();
												$(".ActualizarCompetencia").hide();
												$(".vistaFOEjecutivoActualizar").hide();
												$(".ActualizarEjectutivo").hide();
												$(".concluido").hide();
												$(".vistaFasePeriodoEliminado").hide();
												
												
										}
									}	  
						} else {

							if(informe==="eliminado" ) {
									$(".vistaFasePeriodoEliminado").show();

								  $(".vistaFasePeriodo").hide();
									 $(".vistaFaseDatos").hide();
									  $(".vistaFaseFuncionObjetivo").hide();
									  $(".vistaCompetenciasExclusivas").hide();
										$(".vistaInstitucionesVinculadas").hide();
										$(".ActualizarCompetencia").hide();
										$(".vistaFOEjecutivoActualizar").hide();
										$(".ActualizarEjectutivo").hide();
										$(".concluido").hide();
									}else{
							  $(".vistaFasePeriodo").show();
							 $(".vistaFaseDatos").hide();
							  $(".vistaFaseFuncionObjetivo").hide();
							  $(".vistaCompetenciasExclusivas").hide();
								$(".vistaInstitucionesVinculadas").hide();
								$(".ActualizarCompetencia").hide();
								$(".vistaFOEjecutivoActualizar").hide();
								$(".ActualizarEjectutivo").hide();
								$(".concluido").hide();
								$(".vistaFasePeriodoEliminado").hide();
								
									}
						}

					$("#cmbCompetenciasVinculadasTipo").hide();
					$("#competenciaConcurrente").hide();
					$("#CListaCEParroquiales").hide();
					$("#CListaCEProvinciales").hide();
					$("#CListaCEMunicipales").hide();
					$(".concluido").hide();
					

					}
						
					});

		$("#btnGuardar")
		.click(
				function(event) {
					$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodoInstitucion');
					var form = $("#autCodigo")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');

				});

		
		$("#btnGuardarFuncionObjetivo")
		.click(
				function(event) {
					$('#foCod').attr('data-opcion',	'guardarObjetivosFunciones');
					var form = $("#foCod")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');

				});


		$("#btnGuardarFuncionObjetivoEjecutivo")
		.click(
				function(event) {
					$('#foCod').attr('data-opcion',	'guardarObjetivosFuncionesEjecutivo');
					var form = $("#foCod")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');

				});
		
		$("#btnGuardarGad")
		.click(
				function(event) {
					$('#Gad').attr('data-opcion',	'guardarObjetivosFunciones');
					var form = $("#Gad")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');
				});

		$("#btnGuardarGadCE")
		.click(
				function(event) {
					$('#Gad').attr('data-opcion',	'guardarObjetivosFuncionesCE');
					var form = $("#Gad")
					event.preventDefault();
					event.stopPropagation();
					ejecutarJson(form);
					
					form.addClass('was-validated');
				});
		

		$("#btnGuardarGadVinculadas")
		.click(
				function(event) {

					$("#cmbCompetenciasVinculadasTipo").removeAttr("requerid");
					$("#competenciaConcurrente").removeAttr("required");
					$("#ListaCEParroquiales").removeAttr("required");
					$("#ListaCEProvinciales").removeAttr("required");
					$("#ListaCEMunicipales").removeAttr("required");
					$("#nComteneciaVinculada").removeAttr("required");

					$('#Vinculadas').attr('data-opcion',	'guardarCompetenciasVinculadas');
					var form = $("#Vinculadas")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');
				});
		$("#btnGuardarGadActualizar")
		.click(
				function(event) {
					$('#GadActualizar').attr('data-opcion',	'guardarObjetivosFuncionesActualizar');
					var form = $("#GadActualizar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese por lo menos una competencia!",
								"ERROR");
					} else {

						
							ejecutarJson(form)
						
					}
					form.addClass('was-validated');
				});

		$("#btnGuardarGadActualizarA")
		.click(
				function(event) {
					$('#GadActualizarA').attr('data-opcion',	'guardarObjetivosFuncionesActualizarA');
					var form = $("#GadActualizarA")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese por lo menos una competencia!",
								"ERROR");
					} else {

						
							ejecutarJson(form)
						
					}
					form.addClass('was-validated');
				});


		$("#btnGuardarActualizar")
		.click(
				function(event) {
					$('#EjecutivoActualizar').attr('data-opcion',	'guardarObjetivosFuncionesActualizarEjecutivo');
					var form = $("#EjecutivoActualizar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese por lo menos un objetivo!",
								"ERROR");
					} else {

						
							ejecutarJson(form)
						
					}
					form.addClass('was-validated');
				});

		
		$("#btnFuncionesObjetivosCompetencias")
		.click(
				function(event) {
					
					switch(tipoInstitucion) {
					  case "vinculada":
						  $(".vistaFaseDatos").hide();
						  $(".vistaFaseFuncionObjetivo").hide();
						  $(".vistaCompetenciasExclusivas").hide();
						  $(".vistaFasePeriodo").hide();
						  $(".vistaCompetenciasExclusivasActualizar").hide();
						  $(".vistaFOEjecutivoActualizar").hide();
						  $('#agregarCompetenciasEVinculadas').hide();
						  $('.vistaCompetenciasVinculadasActualizar').show();
						  $("#CListaCEParroquialesA").hide();
						  $("#CListaCEProvincialesA").hide();
						  $("#CListaCEMunicipalesA").hide();
						  $("#CListaCEMunicipalesA").hide();
						  $("#competenciaConcurrenteA").hide();
						  $("#cmbCompetenciasVinculadasTipoA").hide();
						  $("#agregarCompetenciasEVinculadasA").hide();
						  $("#agregarCompetenciasEVinculadasAA").hide();
						
					    break;
					  case "gad":
						  	$(".vistaFaseDatos").hide();
						  	$(".vistaFaseFuncionObjetivo").hide();
						  	$(".vistaCompetenciasExclusivasActualizar").show();
						 	$(".vistaFasePeriodo").hide();
							$(".vistaFOEjecutivoActualizar").hide();
							$(".vistaFOEjecutivoActualizar").hide();
							  $('.vistaCompetenciasVinculadasActualizar').hide();
							
							  
					    break;
					  case "ejecutivo":
						  $(".vistaCompetenciasExclusivasActualizar").hide();
					      $(".vistaFaseDatos").hide();
						  $(".vistaFaseFuncionObjetivo").hide();
						  $(".vistaCompetenciasExclusivas").hide();
						  $(".vistaFasePeriodo").hide();
							$(".vistaFOEjecutivoActualizar").hide();
							$(".vistaFOEjecutivoActualizar").show();
							  $('.vistaCompetenciasVinculadasActualizar').hide();
							 
						 break;
					 default:
					  $(".vistaCompetenciasExclusivasActualizar").hide();
				      $(".vistaFaseDatos").hide();
					  $(".vistaFaseFuncionObjetivo").hide();
					  $(".vistaCompetenciasExclusivas").hide();
					  $(".vistaFasePeriodo").hide();
					  $(".vistaFOEjecutivoActualizar").hide();
					  $(".vistaFOEjecutivoActualizar").hide();	
					  $('.vistaCompetenciasVinculadasActualizar').hide();
					  console.log(4);
					}

					
				});

		
		 $("#agregarFuncionesObjetivos").click(function(event){
		   	 	var error = false;
		   	 	if ($("#nFuncionObjetivo").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese una función u objetivo!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#cmbFuncionesObjetivos").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}
			   		

		   	 $('#tablaFuncionesObjetivos tr').each(function (event) {
		      		if($(this).find('input[id="aFuncionObjetivo"]').val()==$("#nFuncionObjetivo").val()){
		      			error = true;
		      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    	var codigo=$("#idFuncionObjetivo").val();
		   	    	$("#tablaFuncionesObjetivos").append("<tr id='r_"+codigo+"'><td><input type='hidden' id='aFuncionObjetivo' name='aFuncionObjetivo[]' value='"+$("#nFuncionObjetivo").val()+"'/>"+$("#nFuncionObjetivo").val()
				   	    	+"</td><td><input type='hidden' id='bFuncionObjetivo' name='bFuncionObjetivo[]' value='"+$("#cmbFuncionesObjetivos").val()+"'/>"+$("#cmbFuncionesObjetivos").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarFuncioneObjetivo(\"#r_"+codigo+"\")' class='_eliminarColor _quitar'></button></td></tr>");
		  	 	}
			   		}	
		   	});

		 

 $("#agregarCompetenciasEVinculadas").click(function(event){
   	 	var error = false;
		   	 	if ($("#cmbFuncionesCompetenciasVinculadasTipo").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese un tipo de competencia!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#ListaCEParroquiales").val() === ""  && $("#ListaCEProvinciales").val() === "" && $("#ListaCEMunicipales").val() === ""){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo  para poder agregar!","ERROR-NOTIFICACION","3000")

					}else{

						var DatoCompentencia= "";
					   	if($("#ListaCEParroquiales").val()!==""){
					   		$("#ListaCEMunicipales").val("");
					   		$("#ListaCEProvinciales").val("");
					   		DatoCompentencia = $('#ListaCEParroquiales option:selected').html();
								   	}else if($("#ListaCEProvinciales").val()!==""){
								   		$("#ListaCEMunicipales").val("");
								   		$("#ListaCEParroquiales").val("");
				 				DatoCompentencia = $('#ListaCEProvinciales option:selected').html();
				   				}else if($("#ListaCEMunicipales").val()!==""){
				   					$("#ListaCEProvinciales").val("");
							   		$("#ListaCEParroquiales").val("");
				   					DatoCompentencia = $('#ListaCEMunicipales option:selected').html();
						   		}else{
						   			mostrarMensaje("actualice la página!","ERROR-NOTIFICACION","3000")
										
							   		}

						if(DatoCompentencia!==""){
						
						
			   		   	 $('#tablaCompetenciasVinculada tr').each(function (event) {

			   	


					      		if($(this).find('input[id="aCompentenciaVinculada"]').val()===DatoCompentencia){
				      			error = true;
				      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
				      		}
				  	    });
				  	 	if (!error){
				   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
				   	    	var codigoConcurenteVinculada=  $("#tablaCompetenciasVinculada tr").length + 1;
				   	    	$("#tablaCompetenciasVinculada").append("<tr id='r_"+codigoConcurenteVinculada+"'><td><input type='hidden' id='aCompentenciaVinculada' name='aCompentenciaVinculada[]' value='"+DatoCompentencia+"'/>"+DatoCompentencia+"</td><td><input type='hidden' id='bCompentenciaVinculada' name='bCompentenciaVinculada[]' value='"+$("#cmbFuncionesCompetenciasVinculadas").val()+"'/>"+$("#cmbFuncionesCompetenciasVinculadas").val()
						   	    	+"</td><td class='text-center'><button type='button' onclick='quitarCompetenciaVinculada(\"#r_"+codigoConcurenteVinculada +"\")' class='_eliminarColor _quitar'></button></td></tr>");

				   	    	$("#ListaCEMunicipales").val("");
					   		$("#ListaCEProvinciales").val("");
					   		$("#ListaCEParroquiales").val("");
					   		$("#ListaCEParroquiales").removeAttr("required");
							$("#ListaCEProvinciales").removeAttr("required");
							$("#ListaCEMunicipales").removeAttr("required");
					   		DatoCompentencia= "";
					  	 	}
	
		   			}
			   	}		

		   		}
 });

 ///////////////////DFsafsadfsd
 		$("#agregarCompetenciasEVinculadasAA").click(function(event){
	 	var error = false;
		   	 	if ($("#cmbFuncionesCompetenciasVinculadasTipoA").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese un tipo de competencia!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#ListaCEParroquialesA").val() === ""  && $("#ListaCEProvincialesA").val() === "" && $("#ListaCEMunicipalesA").val() === ""){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo  para poder agregar!","ERROR-NOTIFICACION","3000")

					}else{

						var DatoCompentencia= "";
					   	if($("#ListaCEParroquialesA").val()!==""){
					   		$("#ListaCEMunicipalesA").val("");
					   		$("#ListaCEProvincialesA").val("");
					   		DatoCompentencia = $('#ListaCEParroquialesA option:selected').html();
								   	}else if($("#ListaCEProvincialesA").val()!==""){
								   		$("#ListaCEMunicipalesA").val("");
								   		$("#ListaCEParroquialesA").val("");
				 				DatoCompentencia = $('#ListaCEProvincialesA option:selected').html();
				   				}else if($("#ListaCEMunicipalesA").val()!==""){
				   					$("#ListaCEProvincialesA").val("");
							   		$("#ListaCEParroquialesA").val("");
				   					DatoCompentencia = $('#ListaCEMunicipalesA option:selected').html();
						   		}else{
						   			mostrarMensaje("actualice la página!","ERROR-NOTIFICACION","3000")
										
							   		}

						if(DatoCompentencia!==""){
						
						
			   		   	 $('#tablaCompetenciasVinculadaA tr').each(function (event) {

			   	


					      		if($(this).find('input[id="aCompentenciaVinculadaA"]').val()===DatoCompentencia){
				      			error = true;
				      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
				      		}
				  	    });
				  	 	if (!error){
				   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
				   	    	var codigoConcurenteVinculada=  $("#tablaCompetenciasVinculadaA tr").length + 1;
				   	    	$("#tablaCompetenciasVinculadaA").append("<tr id='r_"+codigoConcurenteVinculada+"'><td><input type='hidden' id='aCompentenciaVinculadaA' name='aCompentenciaVinculadaA[]' value='"+DatoCompentencia+"'/>"+DatoCompentencia+"</td><td><input type='hidden' id='bCompentenciaVinculadaA' name='bCompentenciaVinculadaA[]' value='"+$("#cmbFuncionesCompetenciasVinculadasA").val()+"'/>"+$("#cmbFuncionesCompetenciasVinculadasA").val()
						   	    	+"</td><td class='text-center'><button type='button' onclick='quitarCompetenciaVinculadaA(\"#r_"+codigoConcurenteVinculada +"\")' class='_eliminarColor _quitar'></button></td></tr>");

				   	    	$("#ListaCEMunicipalesA").val("");
					   		$("#ListaCEProvincialesA").val("");
					   		$("#ListaCEParroquialesA").val("");
					   		$("#ListaCEParroquialesA").removeAttr("required");
							$("#ListaCEProvincialesA").removeAttr("required");
							$("#ListaCEMunicipalesA").removeAttr("required");
							$("#nComteneciaVinculadaA").removeAttr("required");


					   		DatoCompentencia= "";
					  	 	}
	
		   			}
			   	}		

		   		}
});
		
		 
		 $("#agregarCompetenciasVinculadas").click(function(event){
		   	 	var error = false;
		   	

		   	 	
		   	 	if ($("#nComteneciaVinculada").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese una función u objetivo!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#cmbFuncionesCompetenciasVinculadas").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}
			   		

		   	 $('#tablaCompetenciasVinculada tr').each(function (event) {
		      		if($(this).find('input[id="aCompentenciaVinculada"]').val()==$("#nComteneciaVinculada").val()){
		      			error = true;
		      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    	var codigoConcurenteVinculada=  $("#tablaCompetenciasVinculada tr").length + 1;
		   	    	$("#tablaCompetenciasVinculada").append("<tr id='r_"+codigoConcurenteVinculada+"'><td><input type='hidden' id='aCompentenciaVinculada' name='aCompentenciaVinculada[]' value='"+$("#nComteneciaVinculada").val()+"'/>"+$("#nComteneciaVinculada").val()
				   	    	+"</td><td><input type='hidden' id='bCompentenciaVinculada' name='bCompentenciaVinculada[]' value='"+$("#cmbFuncionesCompetenciasVinculadas").val()+"'/>"+$("#cmbFuncionesCompetenciasVinculadas").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarCompetenciaVinculada(\"#r_"+codigoConcurenteVinculada +"\")' class='_eliminarColor _quitar'></button></td></tr>");
		  	 	}
			   		}	
		   	});

		 $("#agregarCompetenciasVinculadasA").click(function(event){
		   	 	var error = false;
		   	

		   	 	
		   	 	if ($("#nComteneciaVinculadaA").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese una función u objetivo!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#cmbFuncionesCompetenciasVinculadasA").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}
			   		

		   	 $('#tablaCompetenciasVinculadaA tr').each(function (event) {
		      		if($(this).find('input[id="aCompentenciaVinculadaA"]').val()==$("#nComteneciaVinculadaA").val()){
		      			error = true;
		      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    	var codigoConcurenteVinculada=  $("#tablaCompetenciasVinculadaA tr").length + 1;
		   	    	$("#tablaCompetenciasVinculadaA").append("<tr id='r_"+codigoConcurenteVinculada+"'><td><input type='hidden' id='aCompentenciaVinculadaA' name='aCompentenciaVinculadaA[]' value='"+$("#nComteneciaVinculadaA").val()+"'/>"+$("#nComteneciaVinculadaA").val()
				   	    	+"</td><td><input type='hidden' id='bCompentenciaVinculadaA' name='bCompentenciaVinculadaA[]' value='"+$("#cmbFuncionesCompetenciasVinculadasA").val()+"'/>"+$("#cmbFuncionesCompetenciasVinculadasA").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarCompetenciaVinculadaA(\"#r_"+codigoConcurenteVinculada +"\")' class='_eliminarColor _quitar'></button></td></tr>");
		  	 	}
		  		$("#ListaCEParroquialesA").removeAttr("required");
				$("#ListaCEProvincialesA").removeAttr("required");
				$("#ListaCEMunicipalesA").removeAttr("required");
			   		}	
		   	});
		 
		 $("#agregarFuncionesObjetivosEjecutivo").click(function(event){
		   	 	var error = false;
		   	 	if ($("#nFuncionObjetivoEjecutivo").val() ==  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese una función u objetivo!","ERROR-NOTIFICACION","3000")
		   		}else{
		   			if ($("#cmbFuncionesObjetivosEjecutivo").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}
			   		

		   	 $('#tablaFuncionesObjetivosEjecutivo tr').each(function (event) {
		      		if($(this).find('input[id="aFuncionObjetivoEjecutivo"]').val()==$("#nFuncionObjetivoEjecutivo").val()){
		      			error = true;
		      			mostrarMensaje("La Funcion / Objetivo ya se se encuentra agregado!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	       codigoEjecutivo=codigoEjecutivo+1
		   	    	$("#tablaFuncionesObjetivosEjecutivo").append("<tr id='r_"+codigoEjecutivo+"'><td><input type='hidden' id='aFuncionObjetivoEjecutivo' name='aFuncionObjetivoEjecutivo[]' value='"+$("#nFuncionObjetivoEjecutivo").val()+"'/>"+$("#nFuncionObjetivoEjecutivo").val()
				   	    	+"</td><td><input type='hidden' id='bFuncionObjetivoEjecutivo' name='bFuncionObjetivoEjecutivo[]' value='"+$("#cmbFuncionesObjetivosEjecutivo").val()+"'/>"+$("#cmbFuncionesObjetivosEjecutivo").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarFuncioneObjetivoEjecutivo(\"#r_"+codigoEjecutivo+"\")' class='_eliminarColor _quitar'></button></td></tr>");
		  	 	}
			   		}	
		   	});


		 var nFilas = $("#tablaInstituciones tr").length + 1; 		     		
		 	$("#tablaInstituciones").append("<tr id='row_"+nFilas+"'><td><input type='hidden' id='item' name='item[]' value='"+nFilas
				   	+"'/>"+nFilas+"</td> <td><input type='hidden' id='cantidad' name='cantidad[]' value='"+$("#cantidad1").val()
				   	+"'/>"+$("#cantidad1").val()+"</td> <td><input type='hidden' id='descripcion' name='descripcion[]' value='"+$("#descripcion1").val()
				   	+"'/>"+$("#descripcion1").val()+"</td>  <td><input type='hidden' id='precio' name='precio[]' value='"+$("#precio1").val()
				   	+"'/>"+$("#precio1").val()+"</td> <td class='subtotal'><input type='hidden' id='valorVenta' name='valorVenta[]' value='"+$("#valorVenta1").val()
				   	+"'/>"+$("#valorVenta1").val()+"</td><td class='text-center'><button type='button' onclick='quitarInstitucion(\"#row_"+nFilas+"\")' class='_eliminarColor _quitar'></button></td></tr>");

			$("#Datos").modal("hide");
		 

		 $("#agregarFuncionesObjetivosGad").click(function(event){
		   	 	var error = false;
		   	 	if ($("#nFuncionObjetivoGad").val() ===  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese un nombre para poder agregar!","ERROR-NOTIFICACION","3000")
		   		}else{
					
		   			if ($("#cmbFuncionesObjetivosGad").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}

		   	 $('#tablaFuncionesObjetivosGad tr').each(function (event) {
			   	if($(this).find('input[id="aFuncionObjetivo"]').val()==$("#nFuncionObjetivoGad").val()){
			   		 			error = true;
		      			mostrarMensaje("La competencia concurrente ya se encuentra agregada!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		   	   
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    	var codigo=$("#idFuncionObjetivoGad").val();
		   	    	$("#tablaFuncionesObjetivosGad").append("<tr id='r_"+codigo+"'><td><input type='hidden' id='aFuncionObjetivo' name='aFuncionObjetivo[]' value='"+$("#nFuncionObjetivoGad").val()+"'/>"+$("#nFuncionObjetivoGad").val()
				   	    	+"</td><td><input type='hidden' id='bFuncionObjetivo' name='bFuncionObjetivo[]' value='"+$("#cmbFuncionesObjetivosGad").val()+"'/>"+$("#cmbFuncionesObjetivosGad").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarFuncioneObjetivoGad(\"#r_"+codigo+"\")' class='_eliminarColor _quitar'></button></td></tr>");
		   		}
		   		}	
		   	});


		 function mostrarBotones(){
			 var nFilas = $("#tablaFuncionesObjetivosGadActualizar tr").length;
		     if (nFilas==0){                            	
	        	$("#btnGuardarGadActualizar").hide();
			}else{
				 $("#btnGuardarGadActualizar").show();
				}
		 }	   	

		 

		 $("#agregarFuncionesObjetivosGadActualizar").click(function(event){
		   	 	var error = false;
		   	 	if ($("#nFuncionObjetivoGadActualizar").val() ===  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese un nombre para poder agregar!","ERROR-NOTIFICACION","3000")
		   		}else{
					
		   			if ($("#cmbFuncionesObjetivosGadActualizar").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}

		   	 $('#tablaFuncionesObjetivosGadActualizar tr').each(function (event) {
			   	if($(this).find('input[id="aFuncionObjetivoActualizar"]').val()==$("#nFuncionObjetivoGadActualizar").val()){
			   		 			error = true;
		      			mostrarMensaje("La competencia concurrente ya se encuentra agregada!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		   	   
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    
		   	    	var codigo=$("#idFuncionObjetivoGad").val();
		   	    	$("#tablaFuncionesObjetivosGadActualizar").append("<tr id='r_"+codigo+"'><td><input type='hidden' id='aFuncionObjetivoActualizar' name='aFuncionObjetivoActualizar[]' value='"+$("#nFuncionObjetivoGadActualizar").val()+"'/>"+$("#nFuncionObjetivoGadActualizar").val()
				   	    	+"</td><td><input type='hidden' id='bFuncionObjetivoActualizar' name='bFuncionObjetivoActualizar[]' value='"+$("#cmbFuncionesObjetivosGadActualizar").val()+"'/>"+$("#cmbFuncionesObjetivosGadActualizar").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarFuncioneObjetivoGadActualizar(\"#r_"+codigo+"\")' class='_eliminarColor _quitar'></button></td></tr>");
		   		}
		  	 	mostrarBotones();
		   		}	
		   	});


		 $("#agregarFuncionesObjetivosActualizar").click(function(event){
		   	 	var error = false;
		   	 	if ($("#nFuncionObjetivoActualizarE").val() ===  0){
		   			error = true;
		   			mostrarMensaje("Por favor ingrese un nombre para poder agregar!","ERROR-NOTIFICACION","3000")
		   		}else{
					
		   			if ($("#cmbFuncionesObjetivosActualizarE").val() === "1" ){
						error = true;
			   			mostrarMensaje("Por favor seleccione un tipo para poder agregar!","ERROR-NOTIFICACION","3000")
					}

		   	 $('#tablaFuncionesObjetivosActualizarE tr').each(function (event) {
			   	if($(this).find('input[id="aFuncionObjetivoActualizarE"]').val()==$("#nFuncionObjetivoGadActualizarE").val()){
			   		 			error = true;
		      			mostrarMensaje("La competencia concurrente ya se encuentra agregada!","ERROR-NOTIFICACION","3000");
		      		}
		  	    });
		   	   
		  	 	if (!error){
		   	   	   mostrarMensaje("Registro agregado exitosamente!","EXITO-NOTIFICACION","3000")
		   	    
		   	    	var codigo=$("#idFuncionObjetivoActualizar").val();
	   	    	$("#tablaFuncionesObjetivosActualizarE").append("<tr id='r_"+codigo+"'><td><input type='hidden' id='aFuncionObjetivoActualizarE' name='aFuncionObjetivoActualizarE[]' value='"+$("#nFuncionObjetivoActualizarE").val()+"'/>"+$("#nFuncionObjetivoActualizarE").val()
				   	    	+"</td><td><input type='hidden' id='bFuncionObjetivoActualizarE' name='bFuncionObjetivoActualizarE[]' value='"+$("#cmbFuncionesObjetivosActualizarE").val()+"'/>"+$("#cmbFuncionesObjetivosActualizarE").val()
				   	    	+"</td><td class='text-center'><button type='button' onclick='quitarFuncioneObjetivoActualizarE(\"#r_"+codigo+"\")' class='_eliminarColor _quitar'></button></td></tr>");
		   		}
		  	 	mostrarBotones();
		   		}	
		   	});
		 


		 

		 function quitarCompetenciaVinculada(fila){
		  		$("#tablaCompetenciasVinculada tr").eq($(fila).index()).remove();
		}

		 function quitarCompetenciaVinculadaA(fila){
		  		$("#tablaCompetenciasVinculadaA tr").eq($(fila).index()).remove();
		}
			
			function quitarFuncioneObjetivo(fila){
		  		$("#tablaFuncionesObjetivos tr").eq($(fila).index()).remove();
		}


		function quitarFuncioneObjetivoEjecutivo(fila){
	
			$("#tablaFuncionesObjetivosEjecutivo tr").eq($(fila).index()).remove();
	}
	
		
		function quitarFuncioneObjetivoGad(fila){
		  		$("#tablaFuncionesObjetivosGad tr").eq($(fila).index()).remove();
		}

		function quitarFuncioneObjetivoGadActualizar(fila){
	  		$("#tablaFuncionesObjetivosGadActualizar tr").eq($(fila).index()).remove();
	  		mostrarBotones();

	  			}


		
		function quitarFuncioneObjetivoActualizarE(fila){
	  		$("#tablaFuncionesObjetivosActualizarE tr").eq($(fila).index()).remove();
	  		mostrarBotones();

	  			}

		 function EliminarFuncioneObjetivo(element){
			  var documento = $(element).parent().parent().find("td:eq(0)").text();  
				
				
			   $.ajax({
				        url: 'view/rendicion/eliminarDatos',
				        headers: {"X-CSRF-TOKEN": csrfToken},
				        type: "POST",
				        dataType: 'json',
				        data: {codigo: documento},
				        success: function (msg) {
				            if (msg.estado == "exito") {
		                             mostrarMensaje(msg.mensaje, "EXITO");
		                             var td = element.parentNode;
		                            
		                             var tr = td.parentNode;
		                             var table = tr.parentNode;      
		                             table.removeChild(tr);
		                   } else {
		                        $("#cargando").delay("slow").fadeOut();
		                        
		                             mostrarMensaje(msg.mensaje, "ERROR");
		                   }
				        },
				        error: function (result) {

				        }
				    });
		  }

		 function EliminarFuncioneObjetivoEjecutivo(element){
			  var documento = $(element).parent().parent().find("td:eq(0)").text();  
				
				
			   $.ajax({
				        url: 'view/rendicion/eliminarDatos',
				        headers: {"X-CSRF-TOKEN": csrfToken},
				        type: "POST",
				        dataType: 'json',
				        data: {codigo: documento},
				        success: function (msg) {
				            if (msg.estado == "exito") {
		                             mostrarMensaje(msg.mensaje, "EXITO");
		                             var td = element.parentNode;
		                             
		                             var tr = td.parentNode;
		                             var table = tr.parentNode;      
		                             table.removeChild(tr);
		                   } else {
		                        $("#cargando").delay("slow").fadeOut();
		                        
		                             mostrarMensaje(msg.mensaje, "ERROR");
		                   }
				        },
				        error: function (result) {

				        }
				    });
		  }
		 

		 function Eliminar(element) {	
				var codigo = $(element).closest('tr').attr('id');	
		       
				 $.ajax({
				        url: 'view/rendicion/eliminarDatos',
				        headers: {"X-CSRF-TOKEN": csrfToken},
				        type: "POST",
				        dataType: 'json',
				        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_funciones_objetivos',campo:'fo_cod'},
				        success: function (msg) {
				            if (msg.estado == "exito") {
			                         mostrarMensaje(msg.mensaje, "EXITO");
			                         var td = element.parentNode;
			                         var tr = td.parentNode;
			                         var table = tr.parentNode;      
			                         table.removeChild(tr);
			                         var nFilas = $("#TablaEjecucionesProgramaticas tr").length-1;
			                         if (nFilas==0){                            	
			                        	 abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
			                             }
			               			}else {
			                    $("#cargando").delay("slow").fadeOut();
			                    
			                         mostrarMensaje(msg.mensaje, "ERROR");
			               }
				        },
				        error: function (result) {

				        }
				    });
			}
				  

		 function ModificarDatosTabla(element) {
				
				var codigo = $(element).closest('tr').attr('id');
				var nombre = $(element).parent().parent().find("td:eq(1)").text();
				var Tipo = $(element).parent().parent().find("td:eq(2)").text();
///XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX				
	  			$(".vistaFaseDatos").hide();
				$(".vistaFaseFuncionObjetivo").hide();
				$(".vistaCompetenciasExclusivas").hide();
				$(".vistaFasePeriodo").hide();
				$(".vistaCompetenciasExclusivasActualizar").hide();
				$(".ActualizarCompetencia").show();
				$(".vistaCompetenciasVinculadasActualizar").hide();
				
				
				$("#fo_cod").val(codigo);
				$("#fo_nom").val(nombre);
				$("#fo_tip").text(Tipo);
				
			}

		 function ModificarDatosTablaEjecutivo(element2) {
			
				var codigo1 = $(element2).closest('tr').attr('id');
				var nombre1 = $(element2).parent().parent().find("td:eq(1)").text();
				var Tipo1 = $(element2).parent().parent().find("td:eq(2)").text();
				
	  			$(".vistaFaseDatos").hide();
				$(".vistaFaseFuncionObjetivo").hide();
				$(".vistaCompetenciasExclusivas").hide();
				$(".vistaFasePeriodo").hide();
				$(".vistaCompetenciasExclusivasActualizar").hide();
				$(".ActualizarCompetencia").show();
				$(".vistaFOEjecutivoActualizar").hide();
				$("#fo_cod").val(codigo1);
				$("#fo_nom").val(nombre1);
				$("#fo_tip").text(Tipo1);
			;
			}
			
			$("#btnActualziarCC")
					.click(
							function(event) {
								//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
								var form = $("#ActualizarCompetenciaConcurrente")
								event.preventDefault();
								event.stopPropagation();
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
										tabla : 'esq_rendicioncuentas.tbl_funciones_objetivos',
										columns : columnas,
										values : valores,
										condicion : 'fo_cod',
										valorcondicion : $("#fo_cod").val()
									};

									ejecutarJsonUpdate(form, data);
								}
								form.addClass('was-validated');

							});

		

			$("#cmbFuncionesCompetenciasVinculadas")
			.change(
					function() {

						    //if($("#cmbFuncionesCompetenciasVinculadas").val()=="COMPETENCIAS CONCURRENTES / FUNCIONES"){
							if($("#cmbFuncionesCompetenciasVinculadas").val()=="COMPETENCIAS / FUNCIONES"){
										$("#competenciaConcurrente").show();
										$("#cmbCompetenciasVinculadasTipo").hide();
										$("#CListaCEParroquiales").hide();
										$("#CListaCEProvinciales").hide();
										$("#CListaCEMunicipales").hide();
										$('#agregarCompetenciasEVinculadas').hide();
							}else{
										$("#competenciaConcurrente").hide();
										$("#cmbCompetenciasVinculadasTipo").show();
										$('#agregarCompetenciasEVinculadas').show();
										
			
							}

					});

			$("#cmbFuncionesCompetenciasVinculadasA")
			.change(
					function() {

						//if($("#cmbFuncionesCompetenciasVinculadasA").val()=="COMPETENCIAS CONCURRENTES / FUNCIONES"){
						if($("#cmbFuncionesCompetenciasVinculadasA").val()=="COMPETENCIAS / FUNCIONES"){		
										$("#competenciaConcurrenteA").show();
										$("#cmbCompetenciasVinculadasTipoA").hide();
										$("#CListaCEParroquialesA").hide();
										$("#CListaCEProvincialesA").hide();
										$("#CListaCEMunicipalesA").hide();
										$('#agregarCompetenciasEVinculadasA').show();
										$('#agregarCompetenciasEVinculadasAA').hide();
							}else{

								if($("#cmbFuncionesCompetenciasVinculadasA").val()=="COMPETENCIAS EXCLUSIVAS"){
										$("#competenciaConcurrenteA").hide();
										$("#cmbCompetenciasVinculadasTipoA").show();
										$('#agregarCompetenciasEVinculadasAA').show();
										$('#agregarCompetenciasEVinculadasA').hide();
								}else{
									$("#competenciaConcurrenteA").hide();
									$("#cmbCompetenciasVinculadasTipoA").hide();
									$('#agregarCompetenciasEVinculadasAA').hide();
									$('#agregarCompetenciasEVinculadasA').hide();

									}
							}

					});


			$("#cmbFuncionesCompetenciasVinculadasTipo")
			.change(
					function() {

			if($("#cmbFuncionesCompetenciasVinculadasTipo").val()=="1"){
				$("#CListaCEParroquiales").hide();
				$("#CListaCEProvinciales").hide();
				$("#CListaCEMunicipales").show();
		}else{

			if($("#cmbFuncionesCompetenciasVinculadasTipo").val()=="2"){
				$("#CListaCEParroquiales").hide();
				$("#CListaCEProvinciales").show();
				$("#CListaCEMunicipales").hide();
		}else{
			if($("#cmbFuncionesCompetenciasVinculadasTipo").val()=="3"){
			$("#CListaCEParroquiales").show();
			$("#CListaCEProvinciales").hide();
			$("#CListaCEMunicipales").hide();
			}else{
				$("#CListaCEParroquiales").hide();
				$("#CListaCEProvinciales").hide();
				$("#CListaCEMunicipales").hide();
				}
		}	
			}
					});

			$("#cmbFuncionesCompetenciasVinculadasTipoA")
			.change(
					function() {

			if($("#cmbFuncionesCompetenciasVinculadasTipoA").val()=="1"){
				$("#CListaCEParroquialesA").hide();
				$("#CListaCEProvincialesA").hide();
				$("#CListaCEMunicipalesA").show();
		}else{

			if($("#cmbFuncionesCompetenciasVinculadasTipoA").val()=="2"){
				$("#CListaCEParroquialesA").hide();
				$("#CListaCEProvincialesA").show();
				$("#CListaCEMunicipalesA").hide();
		}else{
			if($("#cmbFuncionesCompetenciasVinculadasTipoA").val()=="3"){
			$("#CListaCEParroquialesA").show();
			$("#CListaCEProvincialesA").hide();
			$("#CListaCEMunicipalesA").hide();
			}else{
				$("#CListaCEParroquialesA").hide();
				$("#CListaCEProvincialesA").hide();
				$("#CListaCEMunicipalesA").hide();
				}
		}	
			}
					});

			
	</script>