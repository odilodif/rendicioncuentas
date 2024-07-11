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
	<div class="card-header ">
		<h5>Formulario para el fin de Gestión</h5>
	</div>
	<div class="card-body">

		<div class="row">

			<div class="col-md-12 order-md-1">




				<!-- Nav pills -->
				<ul class="nav nav-tabs nav-pills">
					<li class="nav-item "><a class="nav-link active"
						data-toggle="pill" href="#home">Matriz 1</a></li>
					<c:choose>
						<c:when test="${infcod!=null}">
							<li class="nav-item"><a class="nav-link" data-toggle="pill"
								href="#menu1">Matriz 2</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu2">Matriz
									3</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu3">Matriz
									4</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu4">Matriz
									5</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu5">Matriz
									6</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu6">Matriz
									7</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu7">Matriz
									8</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu8">Matriz
									9</a></li>
							<li><a class="nav-link" data-toggle="pill" href="#menu9">Matriz
									10</a></li>
						</c:when>
					</c:choose>
				</ul>
				<hr />
				<!-- Tab panes -->
				<div class="tab-content">
					<input type="hidden" name="infcod" id="infcod" value="${infcod}">
					<div class="tab-pane container active" id="home">
						<c:choose>
							<c:when test="${infotipo=='Nuevo'}">
								<form:form class="needs-validation" novalidate=""
									modelAttribute="TblInformeAutoridadFin" id="FmrFinGestion"
									data-rutaAplicacion="gestion"
									data-opcion="guardarRegistroFinGestion"
									data-accionEnExito="ACTUALIZAR">
									<input type="hidden" id="identificador" name="identificador"
										value="${identificador}">

									<h4 class="card-header text-white carHeaderBlue">Periodo
										de Rendición de Cuentas</h4>
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
														class="form-control form-control-sm" value=""
														maxlength="10"
														pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
													<div class="invalid-feedback">Por favor ingrese la
														fecha de inicio de gestión</div>
												</div>
											</div>
											<div class="col-md-3 text-left">
												<label for="fechaFinGestion">Fecha fin de gestión:</label>
											</div>
											<div class="col-md-2 text-left">
												<div class="input-group date">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i> </span> <input type="text"
														required="required" id="fechaFinGestion"
														name="fechaFinGestion"
														class="form-control form-control-sm" value=""
														maxlength="10"
														pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
													<div class="invalid-feedback">Por favor ingrese la
														fecha de inicio de gestión</div>
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
														required="required" id="fechaRendicion"
														name="fechaRendicion" class="form-control form-control-sm"
														value="" maxlength="10"
														pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
													<div class="invalid-feedback">Por favor ingrese su
														fecha de nacimiento con formato dd/mm/aaaa</div>
												</div>
											</div>
										</div>

										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="lugar">Lugar de la Rendición de Cuentas
													a la ciudadania:</label>
											</div>
											<div class="col-md-9">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="lugar"
													required="required" name="lugar"
													placeholder="Lugar donde se dio la rendición de cuentas a la ciudadania"
													maxlength="64" value=""
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese el lugar</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="numeroAsistentes" class="col-form-label">Número
													de asistentes<span class="text-muted"> (Escriba 0 si todavía no realizó su deliberación)</span>

												</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="number" class="form-control form-control-sm"
													id="numeroAsistentes" name="numeroAsistentes" required="required"
													placeholder="000" maxlength="20" pattern="^[0-9]+"
													min="0" onkeypress="mascaraEnteros(this)" onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese el
													numero de asistentes</div>
											</div>
										</div>
									</div>

								</form:form>
								<div class="col-md-12 text-center">
									<button type="submit" id="btnGuardar"
										class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
								</div>

							</c:when>
							<c:when test="${infotipo=='Editar'}">
								<h4 class="card-header text-white carHeaderBlue">
									Informe de Fin de Gestión Nro. ${numeroInforme} <br> <span
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
											<label for="institucionDignidad">Institución en la
												que ejerce la Dignidad:</label>
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
									<form:form class="needs-validation" novalidate=""
				modelAttribute="TblFuncionesAutoridadesFin"
				id="ActualziarfechasAutoridadesFin" data-rutaAplicacion="gestion"
				data-opcion="ActualizarDatos" >
									<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="fechaInicioGestion">Fecha de inicio de
													gestión:</label>
											</div>
											<div class="col-md-2 text-left">
												<div class="input-group date">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i> </span> <input type="text"
														required="required" id="inf_aut_desde"
														name="inf_aut_desde"
														class="form-control form-control-sm" value="${fechaInicio}"
														maxlength="10"
														pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
													<div class="invalid-feedback">Por favor ingrese la
														fecha de inicio de gestión</div>
												</div>
											</div>
										</div>
										<div class="form-group row">
										
											<div class="col-md-2 text-left">
												<label for="fechaFinGestion">Fecha fin de gestión:</label>
											</div>
											<div class="col-md-2 text-left">
												<div class="input-group date">
													<span class="input-group-addon"><i
														class="fa fa-calendar"></i> </span> <input type="text"
														required="required" id="inf_aut_hasta"
														name="inf_aut_hasta"
														class="form-control form-control-sm" value="${fechaFin}"
														maxlength="10"
														pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
													<div class="invalid-feedback">Por favor ingrese la
														fecha de inicio de gestión</div>
												</div>
											</div>
										</div>
										</form:form>
										<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizarM1"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>

								</div>
							</c:when>
						</c:choose>


					</div>
					<div class="tab-pane container" id="menu1">
						<c:choose>

							<c:when test="${infotipo=='Editar'}">
								<div id="tablaRC">
									<table id="InfoRcAutoridad"
										class="table table-striped table-bordered dataTable no-footer">
										<thead style="background-color: rgb(31, 137, 72);">
											<tr>
												<th colspan="5" style="font-size: xx-small;"><p
														style="color: white;">INFORME DE RENDICIÓN DE CUENTAS</p></th>
											</tr>
											<tr>
												<th style="font-size: xx-small;"><p
														style="color: white;">#</p></th>
												<th style="font-size: xx-small;"><p
														style="color: white;">FECHA DE LA RENDICIÓN DE CUENTAS</p></th>
												<th style="font-size: xx-small;"><p
														style="color: white;">LUGAR DE LA RENDICIÓN DE CUENTAS
														A LA CIUDADANÍA</p></th>
												<th style="font-size: xx-small;"><p
														style="color: white;">NÚMERO DE ASISTENTES</p></th>
												<th></th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
								</div>
								<div id="actRC" style="display: none">
									<div class="card-body">
										<form:form class="needs-validation" novalidate=""
											modelAttribute="TblInformeAutoridadFin"
											id="InformeAutoridadFin" data-rutaAplicacion="gestion"
											data-opcion="actualizarInformeAutoridadFin">
											<input type="hidden" id="infAutCod" name="infAutCod"
												value="${infcod}">
											<div class="card-header text-white carHeaderBlue">
												<h5>INFORMACIÓN SOBRE LA RENDICIÓN DE CUENTAS</h5>
											</div>
											<div class="row">
												<div class="col-md-12 order-md-1">

													<table class="table registros table-bordered">
														<tr>
															<th colspan="2"></th>
														</tr>
														<tr>
															<th class="tablaingreso" width="20%">FECHA DE LA
																RENDICIÓN DE CUENTAS</th>
															<th class="tablaingreso" width="60%">LUGAR DE LA
																RENDICIÓN DE CUENTAS A LA CIUDADANÍA</th>
															<th class="tablaingreso" width="20%">NÚMERO DE
																ASISTENTES</th>
														<tr>
															<td scope="row">

																<div class="form-group row">
																	<div class="input-group date">
																		<span class="input-group-addon"><i
																			class="fa fa-calendar"></i> </span> <input type="text"
																			required="required" id="fechaRendicion"
																			name="fechaRendicion"
																			class="form-control form-control-sm" value=""
																			maxlength="10"
																			pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
																		<div class="invalid-feedback">Por favor ingrese
																			su fecha de nacimiento con formato dd/mm/aaaa</div>
																	</div>
																</div>
															</td>
															<td scope="row">
																<div class="form-group row">
																	<input type="text" style="text-transform: uppercase;"
																		class="form-control form-control-sm " id="lugar"
																		required="required" name="lugar"
																		placeholder="Lugar donde se dio la rendición de cuentas a la ciudadania"
																		maxlength="64" value=""
																		pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
																	<div class="invalid-feedback col-md-6 text-left">Por
																		favor ingrese el lugar</div>
																</div>
															</td>
															<td scope="row">
																<div class="form-group row">

																	<input type="number"
																		class="form-control form-control-sm"
																		id="numeroAsistentes" name="numeroAsistentes"
																		placeholder="000" maxlength="20" pattern="^[0-9]+"
																		min="0" onkeypress="mascaraEnteros(this)" onpaste="return false">
																	<div class="invalid-feedback">Por favor ingrese
																		el numero de asistentes</div>
																</div>
															</td>
														</tr>
													</table>
												</div>
											</div>
											<div class="col-md-12 text-center">
												<button type="submit" id="btnGuardarM2"
													class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
											</div>
										</form:form>
									</div>
								</div>
							</c:when>
						</c:choose>
					</div>
					<div class="tab-pane container" id="menu2">
						<c:choose>
							<c:when test="${infotipo=='Editar'}">
								<h4 class="card-header text-white carHeaderBlue">
									CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL
										ORGANISMO COMPETENTE
								</h4>
								
								<!--  <div id="Mensaje">
									<div class="alert alert-primary" role="alert">Ingrese uno
										a uno las registos</div>
								</div>-->
								<div class="card card-secondary" id="NuevoM2">
									<form:form class="needs-validation" novalidate=""
										modelAttribute="TblPlanTrabajoFin" id="PlanTrabajoFin"
										data-rutaAplicacion="gestion"
										data-opcion="guardarPlanTrabajoFin">
										<input type="hidden" id="infAutCod" name="infAutCod"
											value="${infcod}">
										<div class="col-md-12 text-left">
											<table class="table registros table-bordered">

												<tr>
													<td scope="row" width="20%">EJE DEL PLAN DE TRABAJO
														PLANTEADO FORMALMENTE AL CNE</td>
													<td scope="row" width="80%"><textarea rows="2" cols=""
															class="form-control form-control-sm" id=pltPlan
															required="required" name="pltPlan"
															placeholder="Ingrese la información lo más detalladamente posible"></textarea>
														<div class="invalid-feedback">Por favor ingrese el Eje del Plan</div></td>
												</tr>
												<tr>
													<td scope="row">PRINCIPALES ACCIONES REALIZADAS</td>
													<td scope="row"><textarea rows="2" cols=""
															class="form-control form-control-sm" id="ptlAcciones"
															required="required" name="ptlAcciones"
															placeholder="Ingrese la información lo más detalladamente posible"></textarea>
														<div class="invalid-feedback">Por favor ingrese la Acción Realizada</div></td>
												</tr>
												<tr>
													<td scope="row">PRINCIPALES RESULTADOS OBTENIDOS</td>
													<td scope="row"><textarea rows="2" cols=""
															class="form-control form-control-sm" id="ptlResultados"
															required="required" name="ptlResultados"
															placeholder="Ingrese la información lo más detalladamente posible"></textarea>
														<div class="invalid-feedback">Por favor ingrese el Resultado</div></td>
												</tr>
												<tr>
													<td scope="row">OBSERVACIONES</td>
													<td scope="row"><textarea rows="2" cols=""
															class="form-control form-control-sm" id="ptlObs"
															required="required" name="ptlObs"
															placeholder="Ingrese la información lo más detalladamente posible"></textarea>
														<div class="invalid-feedback">Por favor ingrese la observación</div></td>
												</tr>

											</table>

										</div>
										<div class="col-md-12 text-center">
											<button type="submit" id="btnGuardarIF"
												class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
										</div>
									</form:form>
								</div>
										<div id="DatosFin">
		
			<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			<div class="row justify-content-center align-items-center">
			<div class="botones" role="group">
			<button type="submit" id="btnPlanFinalizar"  class="btn _nuevoColor _guardar btn-sm mt-2" data-rutaaplicacion="gestion" data-opcion="Frm_Plan_trabajo_Autoridad_Fin" data-destino="detalleItem" data-nombre="Nuevo">Nuevo</button>   
				</div>
			</div>
			</c:when>
			</c:choose>
			<table id="TablaPlanTrabajoFin"
				class="table table-striped table-bordered" style="width: 100%" >
				<thead style="background-color: rgb(31, 137, 72);">
					<tr ><th colspan="7" style="font-size: x-small;"><p style="color: white;">CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL ORGANISMO COMPETENTE</p></th>
					</tr>
					
					<tr>
						<th width="6%" style="font-size: xx-small;">#</th>
						<th width="21%" style="font-size: xx-small;">PLAN DE TRABAJO PLANTEADO FORMALMENTE AL CNE</th>
						<th width="21%" style="font-size: xx-small;">PRINCIPALES ACCIONES REALIZADAS EN CADA UNO DE LOS ASPECTOS DEL PLAN DEL TRABAJO</th>
						<th width="21%" style="font-size: xx-small;">PRINCIPALES RESULTADOS OBTENIDOS EN CADA UNO DE LOS ASPECTOS DEL PLAN DE TRABAJO</th>
						<th width="21%" style="font-size: xx-small;">OBSERVACIONES</th>
						<th width="5%"></th>
						<th width="5%"></th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
			</div>
						<div id="ActualizarDatosPlan">
			<form:form class="needs-validation" novalidate=""
								modelAttribute="TblPlanTrabajo" id="ActualziarPlanTrabajo"
								data-rutaAplicacion="gestion" data-opcion="ActualizarDatos">
					<div class="card-header text-white carHeaderBlue">
		<h5>CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL ORGANISMO COMPETENTE</h5>
	</div>
			<div class="table-responsive">
				<table class="table registros table-bordered">
			
					<tr>
					<td scope="row" width="20%">
						PLAN DE TRABAJO PLANTEADO FORMALMENTE AL CNE
					</td>
						<td scope="row" width="80%">
												
						<textarea rows="2" cols="" class="form-control form-control-sm" 
										id=plt_plan required="required"
										name="plt_plan" 
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRINCIPALES ACCIONES REALIZADAS EN CADA UNO DE LOS ASPECTOS DEL PLAN DEL TRABAJO 
					</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptl_acciones" required="required"
										name="ptl_acciones"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRINCIPALES RESULTADOS OBTENIDOS EN CADA UNO DE LOS ASPECTOS DEL PLAN DE TRABAJO 
					</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptl_resultados" required="required"
										name="ptl_resultados"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
				OBSERVACIONES							</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptl_obs" required="required"
										name="ptl_obs"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					</table>
					</div>
					</form:form>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualziarPlanTrabajoFin"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
						<input type="hidden" id="plt_cod" name="plt_cod">
			</div>
					</c:when>
					</c:choose>
				</div>
					<div class="tab-pane container" id="menu3">
						<c:choose>
							<c:when test="${infotipo=='Editar'}">
								<h4 class="card-header text-white carHeaderBlue">
									CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE LA AUTORIDAD
								</h4>
								
								<div class="card card-secondary" id="NuevoM3">
										<form:form class="needs-validation" novalidate=""
						modelAttribute="TblFuncionesAutoridadesFin" id="FuncionesAutoridadesFin"
						data-rutaAplicacion="gestion"
						data-opcion="guardarFuncionesAutoridadesFin">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infcod}">
						<div class="col-md-12 text-left">
							<table class="table registros table-bordered">

								<tr>
									<td scope="row" width="20%">FUNCIÓN ATRIBUIDA POR LA CONSTITUCIÓN Y LA LEY</td>
									<td scope="row" width="80%"><textarea rows="2" cols=""
											class="form-control form-control-sm" id=faFuncion
											required="required" name="faFuncion"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">PRINCIPALES ACCIONES REALIZADAS PARA
										CUMPLIR CON LAS FUNCIONES A SU CARGO</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faAcciones"
											required="required" name="faAcciones"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">PRINCIPALES RESULTADOS ALCANZADOS EN EL
										CUMPLIMIENTO DE SUS FUNCIONES</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faResultado"
											required="required" name="faResultado"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>
								<tr>
									<td scope="row">OBSERVACIONES</td>
									<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm" id="faObs"
											required="required" name="faObs"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div></td>
								</tr>

							</table>

						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarFunciones"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
								</div>
										<div id="DatosFunciones">
		
			<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			<div class="row justify-content-center align-items-center">
			<div class="botones" role="group">
			<button type="submit" id="btnFuncionesFin"  class="btn _nuevoColor _guardar btn-sm mt-2" data-rutaaplicacion="gestion" data-opcion="Frm_CumplimientoFunciones_AutoridadFin" data-destino="detalleItem" data-nombre="Nuevo">Nuevo</button>   
				</div>
			</div>
			</c:when>
			</c:choose>
			<table id="TablaFuncionesAutoridadesFin"
						class="table table-striped table-bordered" style="width: 100%">
						<thead style="background-color: rgb(31, 137, 72);">
							<tr>
								<th colspan="7" style="font-size: x-small;"><p
										style="color: white;">CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE
					LA AUTORIDAD</p></th>
							</tr>

							<tr>
								<th width="6%" style="font-size: xx-small;">#</th>
								<th width="21%" style="font-size: xx-small;">FUNCIONES ATRIBUÍDAS POR LA
								CONSTITUCIÓN Y LA LEY</th>
								<th width="21%" style="font-size: xx-small;">PRINCIPALES ACCIONES REALIZADAS PARA CUMPLIR
								CON LAS FUNCIONES A SU CARGO</th>
								<th width="21%" style="font-size: xx-small;">PRINCIPALES RESULTADOS ALCANZADOS EN EL
								CUMPLIMIENTO DE SUS FUNCIONES</th>
								<th width="21%" style="font-size: xx-small;">OBSERVACIONES</th>
								<th width="5%"></th>
								<th width="5%"></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
			</div>
						<div id="ActualizarFunciones">
			<form:form class="needs-validation" novalidate=""
				modelAttribute="TblFuncionesAutoridadesFin"
				id="ActualziarFuncionesAutoridadesFin" data-rutaAplicacion="gestion"
				data-opcion="ActualizarDatos" >
				<div class="card-header text-white carHeaderBlue">
					<h5>CUMPLIMIENTO DE FUNCIONES, ATRIBUCIONES O COMPETENCIAS DE
						LA AUTORIDAD</h5>
				</div>
				<div class="table-responsive">
					<table class="table registros table-bordered">

						<tr>
							<td scope="row" width="20%">FUNCIONES ATRIBUÍDAS POR LA
								CONSTITUCIÓN Y LA LEY</td>
							<td scope="row" width="80%"><textarea rows="2" cols=""
									class="form-control form-control-sm" id=fa_funcion
									required="required" name="fa_funcion"></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>


							</td>
						</tr>
						<tr>
							<td scope="row">PRINCIPALES ACCIONES REALIZADAS PARA CUMPLIR
								CON LAS FUNCIONES A SU CARGO</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_acciones"
									required="required" name="fa_acciones" ></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
						<tr>
							<td scope="row">PRINCIPALES RESULTADOS ALCANZADOS EN EL
								CUMPLIMIENTO DE SUS FUNCIONES</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_resultado"
									required="required" name="fa_resultado"></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
						<tr>
							<td scope="row">OBSERVACIONES</td>
							<td scope="row"><textarea rows="2" cols=""
									class="form-control form-control-sm" id="fa_obs"
									required="required" name="fa_obs" ></textarea>
								<div class="invalid-feedback">Por favor ingrese el detalle</div>
							</td>
						</tr>
					</table>
				</div>
			</form:form>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualziarFuncionesAutoridadesFin"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=fa_cod name="fa_cod">
			</div>
					</c:when>
					</c:choose>
				</div>
				<div class="tab-pane container" id="menu4">
								<h4 class="card-header text-white carHeaderBlue">
									CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS
								</h4>
								<div class="card card-secondary" id="NuevoM4">
									<form:form class="needs-validation" novalidate=""
						modelAttribute="TblInformeAutoridadFin" id="InformeAutoridadTribuFin"
						data-rutaAplicacion="gestion"
						data-opcion="guardarObligacionesAutoridadFin"
						>
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infcod}">
						<div class="row">
							<div class="col-md-12 order-md-1">
							<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso"  width="20%">CUMPLIMIENTO DE OBLIGACIONES</th>
										<th class="tablaingreso" width="20%">PONGA SI O NO</th>
										<th class="tablaingreso" width="60%">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</th>
									<tr>
										<td scope="row">

											TRIBUTARIAS
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="infAutTributo"
									name="infAutTributo" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="infAutMedioTributario" name="infAutMedioTributario" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarTributarias"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
								</div>
		<div id="DatosTributarios">
		<table class="table table-striped table-bordered dataTable no-footer" id="tributario">
					<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="5" style="font-size: xx-small;"><p style="color: white;">CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS</p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">CUMPLIMIENTO DE OBLIGACIONES</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">PONGA SI O NO</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</p></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
				</div>
					<div class="tab-pane container" id="menu5">
						<c:choose>
							<c:when test="${infotipo=='Editar'}">
								<h4 class="card-header text-white carHeaderBlue">
									PROPUESTAS DE ACCIONES DE LEGISLACIÓN, FISCALIZACIÓN,POLÍTICA PÚBLICA
								</h4>
								
								<div class="card card-secondary" id="NuevoM5">
							<form:form class="needs-validation" novalidate=""
							modelAttribute="TblPropuestas" id="PropuestasAutoridadesFin"
							data-rutaAplicacion="gestion"
							data-opcion="guardarPropuestasAutoridadFin">
							<input type="hidden" id="infAutCod" name="infAutCod"
								value="${infcod}">
							<div class="col-md-12 text-left">
								<table class="table registros table-bordered">

									<tr>
										<td scope="row" width="20%">PROPUESTAS</td>
										<td scope="row" width="80%"><textarea rows="2" cols=""
												class="form-control form-control-sm" id=proDescripcion
												required="required" name="proDescripcion"
												placeholder="Ingrese la información lo más detalladamente posible"
												></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
									<tr>
										<td scope="row">RESULTADOS</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm" id="proResultados"
												required="required" name="proResultados"
												placeholder="Ingrese la información lo más detalladamente posible"
												></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
								</table>

							</div>
							<div class="col-md-12 text-center">
								<button type="submit" id="btnGuardarPropuesta"
									class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
							</div>
						</form:form>
								</div>
										<div id="DatosPropuestas">
		
			<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			<div class="row justify-content-center align-items-center">
			<div class="botones" role="group">
			<button type="submit" id="btnPropuestasFin"  class="btn _nuevoColor _guardar btn-sm mt-2" data-rutaaplicacion="gestion" data-opcion="Frm_Propuestas_AutoridadFin" data-destino="detalleItem" data-nombre="Nuevo">Nuevo</button>   
				</div>
			</div>
			</c:when>
			</c:choose>
			<table id="TablaPropuetasAutoridadesFin"
								class="table table-striped table-bordered" style="width: 100%">
								<thead style="background-color: rgb(31, 137, 72);">
									<tr>
										<th colspan="5" style="font-size: x-small;"><p
												style="color: white;">PROPUESTAS DE ACCIONES DE
												LEGISLACIÓN, FISCALIZACIÓN, POLÍTICA PÚBLICA</p></th>
									</tr>

									<tr>
										<th width="4%" style="font-size: xx-small;">#</th>
										<th width="42%" style="font-size: xx-small;">PROPUESTAS</th>
										<th width="42%" style="font-size: xx-small;">RESULTADOS</th>
										<th width="6%"></th>
										<th width="6%"></th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
			</div>
						<div id="ActualizarPropuestas">
				<form:form class="needs-validation" novalidate=""
								modelAttribute="TblPropuestas"
								id="ActualziarPropuestasAutoridadesFin"
								data-rutaAplicacion="gestion" data-opcion="ActualizarDatos">
								<div class="card-header text-white carHeaderBlue">
									<h5>PROPUESTAS DE ACCIONES DE LEGISLACIÓN, FISCALIZACIÓN,
										POLÍTICA PÚBLICA</h5>
								</div>

								<table class="table registros table-bordered">

									<tr>
										<td scope="row" width="20%">PROPUESTAS</td>
										<td scope="row" width="80%"><textarea rows="2" cols=""
												class="form-control form-control-sm" id=pro_descripcion
												required="required" name="pro_descripcion" ></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
									<tr>
										<td scope="row">RESULTADOS</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm" id="pro_resultados"
												required="required" name="pro_resultados" ></textarea>
											<div class="invalid-feedback">Por favor ingrese el
												detalle</div></td>
									</tr>
								</table>

							</form:form>
							<div class="col-md-12 text-center">
								<button type="submit" id="btnActualziarPropuestasAutoridadesFin"
									class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
							</div>
							<input type="hidden" id=pro_id name="pro_id">
			</div>
					</c:when>
					</c:choose>
				</div>
					<div class="tab-pane container" id="menu6">
								<h4 class="card-header text-white carHeaderBlue">
									MECANISMOS DE PARTICIPACION CIUDADANA
								</h4>
								<div class="card card-secondary" id="NuevoM6">
									<form:form class="needs-validation" novalidate=""
						modelAttribute="TblAmecanismosPcFin" id="AmecanismosPcFin"
						data-rutaAplicacion="gestion"
						data-opcion="guardarAmecanismosPcFin"
						>
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infcod}">
						<div class="row">
							<div class="col-md-12 order-md-1">
								<table class="table registros table-bordered" >
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso"  width="20%">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th class="tablaingreso" width="20%">PONGA SI O NO</th>
										<th class="tablaingreso" width="60%">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</th>
									<tr>
										<td scope="row">

											ASAMBLEA LOCAL
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc1"
									name="ameDesc1" required="required" >
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url bloqueo" id="ameMedio1" name="ameMedio1" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											AUDIENCIA PÚBLICA
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc2"
									name="ameDesc2" required="required" >
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url bloqueo" id="ameMedio2" name="ameMedio2" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											CABILDO POPULAR
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc3"
									name="ameDesc3" required="required" >
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url bloqueo" id="ameMedio3" name="ameMedio3" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											CONSEJO DE PLANIFICACIÓN LOCAL
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc4"
									name="ameDesc4" required="required" >
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url bloqueo" id="ameMedio4" name="ameMedio4" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									<tr>
										<td scope="row">

											OTROS
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ameDesc5"
									name="ameDesc5" required="required" >
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url bloqueo" id="ameMedio5" name="ameMedio5" 
								 required="required" value="http://">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
										
									</tr>
									
									
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarMPC"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
								</div>
		<div id="DatosMPC">
			<table class="table table-striped table-bordered dataTable no-footer" id="tablaMPC" style="width: 100%">
					<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="5" style="font-size: xx-small;"><p style="color: white;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">PONGA SI O NO</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</p></th>
							<th></th>
						</tr>
					</thead>
					<tbody >
					</tbody>
				</table>
			</div>
			<div id="AmecanismosActualizarFin">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblAmecanismosPc" id="AmecanismosPcActualizarFin"
						data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos">
						
						<div class="card-header text-white carHeaderBlue">
							<h5>MECANISMOS DE PARTICIPACION CIUDADANA</h5>
						</div>
								<table class="table registros table-bordered">
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso"  width="20%">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th class="tablaingreso" width="20%">PONGA SI O NO</th>
										<th class="tablaingreso" width="60%">MEDIOS DE VERIFICACIÓN (Los establecerá la autoridad)</th>
									<tr>
										<td scope="row">
											<input type="text" class="form-control form-control-sm"
													id="ame_tipo" name="ame_tipo" 
												 required="required"  disabled>
										</td>
										<td scope="row">
											<select
									class="custom-select custom-select-sm" id="ame_desc"
									name="ame_desc" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
										</td>
										<td scope="row">
										
								<input type="url" class="form-control form-control-sm url" id="ame_medio" name="ame_medio" 
								 required="required" >							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
									</tr>
								</table>
							
						
						<div class="col-md-12 text-center">
				<button type="submit" id="btnAmecanismosActualizarFin"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=ame_cod name="ame_cod">
					</form:form>
				</div>
				</div>
				<div class="tab-pane container" id="menu7">
								<h4 class="card-header text-white carHeaderBlue">
									SE REFIERE AL PROCESO DE RENDICIÓN DE CUENTAS QUE HAN IMPLEMENTADO EN EL EJERCICIO DE SU DIGNIDAD
								</h4>
								<div class="card card-secondary" id="NuevoM7">
									<form:form class="needs-validation" novalidate=""
						modelAttribute="TblInformeAutoridadFin" id="InformeAutoridadprocesoFin"
						data-rutaAplicacion="gestion"
						data-opcion="actualizarInformeAutoridadRCFin"
						>
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infcod}">
						<div class="row">
							<div class="col-md-12 order-md-1">
							
								<table class="table registros table-bordered" >
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso">SE REFIERE AL PROCESO DE RENDICIÓN DE CUENTAS QUE HAN IMPLEMENTADO EN EL EJERCICIO DE SU DIGNIDAD</th>
									<tr>
										<td scope="row">
											<textarea rows="12" cols=""
											class="form-control form-control-sm" id=inaProcesoRc
											required="required" name="inaProcesoRc"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div>
											
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarProcesoFin"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
								</div>
		<div id="DatosEjercicio">
			<table class="table table-striped table-bordered dataTable no-footer" id="tablaEF">
					<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="3" style="font-size: xx-small;"><p style="color: white;"></p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">SE REFIERE AL PROCESO DE RENDICIÓN DE CUENTAS QUE HAN IMPLEMENTADO EN EL EJERCICIO DE SU DIGNIDAD</p></th>
							<th></th>
						</tr>
					</thead>
					<tbody >
					</tbody>
				</table>
			</div>
				</div>
			
				<div class="tab-pane container" id="menu8">
								<h4 class="card-header text-white carHeaderBlue">
									APORTES CIUDADANOS
								</h4>
							
								<div class="card card-secondary" id="NuevoM8">
									<form:form class="needs-validation" novalidate=""
						modelAttribute="TblInformeAutoridadFin" id="InformeAutoridadAporteFin"
						data-rutaAplicacion="gestion"
						data-opcion="actualizarInformeAutoridadAporteFin"
						>
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infcod}">
						<div class="row">
							<div class="col-md-12 order-md-1">
							
								<table class="table registros table-bordered" >
									<tr>
										<th colspan="2"></th>
									</tr>
									<tr>
										<th class="tablaingreso">PRINCIPALES APORTES CIUDADANOS RECIBIDOS EN EL PROCESO DE RENDICIÓN DE CUENTAS</th>
									<tr>
										<td scope="row">
											<textarea rows="12" cols=""
											class="form-control form-control-sm" id=inaAportesCiu
											required="required" name="inaAportesCiu"
											placeholder="Ingrese la información lo más detalladamente posible"
											></textarea>
										<div class="invalid-feedback">Por favor ingrese el
											detalle</div>
											
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarAportesFin"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
								</div>
		<div id="DatosAportes">
			<table class="table table-striped table-bordered dataTable no-footer" id="tablaDF">
					<thead style="background-color: rgb(31, 137, 72);">
						<tr>
							<th colspan="3" style="font-size: xx-small;"><p style="color: white;"></p></th>
						</tr>
						<tr>
							<th style="font-size: xx-small;"><p style="color: white;">#</p></th>
							<th style="font-size: xx-small;"><p style="color: white;">PRINCIPALES APORTES CIUDADANOS RECIBIDOS EN EL PROCESO DE RENDICIÓN DE CUENTAS</p></th>
							<th></th>
						</tr>
					</thead>
					<tbody >
					</tbody>
				</table>
			</div>
				</div>
				<div class="tab-pane container" id="menu9">
					<c:choose>
<c:when test="${infestadoinforme=='activo'}">
<div class="card text-center mb-card20">

<div class="card-body">
<h4 class="card-header text-white carHeaderBlue">
									FINALIZACIÓN DE INFORME DE RENDICIÓN DE CUENTAS
								</h4>
                    <div class="ibox" id="faltantes">
                        <div class="ibox-content">
                           <div class="text-center article-title">
                                <h1>
                                    Consejo de Participación Ciudadana y Control Social <strong> CPCCS</strong>.
                                </h1>
                            </div>
                            <p>
                                Le felicita por ser parte del proceso de Fin de Gestión Rendición de Cuentas.
                            </p>
 							<table class="table registros table-bordered">
					
					<tr>
					<td scope="row" width="20%"  style="vertical-align:middle;" >
						MATRICES QUE AUN NO CUENTAN CON INFORMACIÓN
					</td>
						<td scope="row" width="80%">
						   <div class="row  border-bottom white-bg dashboard-header">
                                  <div class="col-sm-8">
							  <ul class="list-group" id="listado">
                                </ul>	
                                </div>
                                </div>				
						</td>
					</tr>
					</table>		
 									
 									</div>
 									<form:form class="needs-validation vistaFasePeriodo" novalidate=""
										modelAttribute="TblInformeAutoridad" id="autCodigo"
										data-rutaAplicacion="rendicion"
										data-opcion="verificarInformeAutoridad">
                               
                               <input type="hidden" id="infAutCod" name="infAutCod" value="${infcod}"> 
                                </form:form>
                                </div>
                                 <div class="ibox" id="completo">
                        <div class="ibox-content">
                           <div class="text-center article-title">
                                <h1>
                                    Consejo de Participación Ciudadana y Control Social <strong> CPCCS</strong>.
                                </h1>
                            </div>
                            <p>
                                Le felicita por ser parte del proceso de Fin de Gestión Rendición de Cuentas.
                            </p>
 									</div>
 									<form:form class="needs-validation vistaFasePeriodo" novalidate=""
										modelAttribute="TblInformeAutoridad" id="finalizarInformeFin"
										data-rutaAplicacion="gestion"
										data-opcion="FinalizarInformeAutoridadFin">
                               
                               <input type="hidden" id="infAutCod" name="infAutCod" value="${infcod}"> 
                               
                                </form:form>
                                <div class="col-md-12 text-center">
										<button type="submit" id="btnFinalizarInformeFin"
											class="btn _nuevoColor _guardar btn-sm mt-2">Finalizar Informe</button>
									</div>
                                </div>
                           

                </div>
               </div> 

		</c:when>
		<c:otherwise>
				<div id="informacion">
					¡Información!... Usted aun no cuenta con un informe.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Informe.
				</div>
		</c:otherwise>
	</c:choose>
				</div>
			</div><!-- fin Tab panes -->



		</div>
	</div>
</div>
</div>
</html>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#AmecanismosActualizarFin').hide();
						$('#ActualizarDatosPlan').hide();
						$('#ActualizarFunciones').hide();
						$('#ActualizarPropuestas').hide();
						var f = new Date();
						var dia1 = "01";
						var dia30 = "30";
						var mes1 = "01";
						var dia31 = "31";
						var mes12 = "12";
						var dia31mayo = "31";
						var mesmayo = "05";
						var anio = f.getFullYear() - 1;
						var anioRC = f.getFullYear() - 4;
						var anioRC2 = f.getFullYear() - 5; //ticket 1689
						var anioFin = f.getFullYear();
						var fechaInicio = (dia1 + "/" + mes1 + "/" + anio);
						var fechaFin = (dia31 + "/" + mes12 + "/" + anio);
						var fechaFinRC = (dia31mayo + "/" + mes12 + "/" + f.getFullYear());
						var fechaHoy = (f.getDate() + "/" + (f.getMonth() + 1)
								+ "/" + f.getFullYear())
						var fechaInicioAutoridad = (dia1 + "/" + mes1 + "/" + anioFin);
						var fechaFinAutoridad = (dia31 + "/" + mes12 + "/" + anioFin);
						var fechaInicioRC = (dia1 + "/" + mes1 + "/" + anioRC);
						var fechaInicioGestion2 = (dia1 + "/" + mes1 + "/" + anioRC2);//ticket 1689
						$('#fechaFinGestion').datepicker({
							forceParse : true,
							todayBtn : false
						}).datepicker('setStartDate', fechaInicio);

						$('#fechaFinGestion').datepicker({

						}).datepicker('setEndDate', fechaFinRC);

						$('#fechaFinGestion').datepicker({

						}).datepicker('update', fechaHoy);
						$('#fechaFinGestion').datepicker({

						}).datepicker('update', '');
						///
							$('#inf_aut_hasta').datepicker({
							forceParse : true,
							todayBtn : false
						}).datepicker('setStartDate', fechaInicio);
						$('#inf_aut_hasta').datepicker({

						}).datepicker('update', $("#inf_aut_hasta").val());
						$('#inf_aut_hasta').datepicker({

						}).datepicker('setEndDate', fechaFinRC);
						///

						///
							$('#inf_aut_desde').datepicker({
							forceParse : true,
							todayBtn : false
						}).datepicker('setStartDate', fechaInicio-5);
						$('#inf_aut_desde').datepicker({

						}).datepicker('update', $("#inf_aut_desde").val());
						$('#inf_aut_desde').datepicker({

						}).datepicker('setEndDate', fechaFinRC);
						///
						$('#fechaInicioGestion').datepicker({
							forceParse : true,
							todayBtn : false
						}).datepicker('setStartDate', fechaInicioGestion2);

						$('#fechaInicioGestion').datepicker({

						}).datepicker('setEndDate', fechaFin);

						$('#fechaInicioGestion').datepicker({

						}).datepicker('update', fechaInicioRC);
						$('#fechaInicioGestion').datepicker({

						}).datepicker('update', '');

						$('#fechaRendicion').datepicker({
							forceParse : true,
							todayBtn : false
						}).datepicker('setStartDate', fechaInicio-5);

						$('#fechaRendicion').datepicker({

						}).datepicker('setEndDate', fechaFinRC);

						$('#fechaRendicion').datepicker({

						}).datepicker('update', fechaHoy);
						$('#fechaRendicion').datepicker({

						}).datepicker('update', '');

					});

	$("#btnGuardar")
			.click(
					function(event) {
						var form = $("#FmrFinGestion")
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
	$('a[data-toggle="pill"]').on(
			'click',
			function(event) {
				//cargarDatos();
				var x = $(this).attr('href');
				switch (x) {
				case '#menu1':
					infoRCAutoridad();
					break;
				case '#menu2':
					PlanTabajoFin();
					break;
				case '#menu3':
					FuncionesAutoridadFin();
					break;
				case '#menu4':
					InfoTributarios();
					break;
				case '#menu5':
					 PropuestasAutoridadFin();
					break;
				case '#menu6':
					MecanismoAutoridad();
					break;
				case '#menu7':
					EjerciciosDignidada();
					break;
				case '#menu8':
					AportesCiudadanos();
					break;
				case '#menu9':
					FinalizarFinGestion();
					break;
				}

			});
	function FinalizarFinGestion() {
		var parametros = {
				"infCod" : $("#infcod").val(),
				"estado":"activo"
				};
			$.ajax({
						url : "view/gestion/verificarFinGestionAutoridad",
						headers : {
							"X-CSRF-TOKEN" : csrfToken
						},
						type : 'POST',
						//async : false,
						dataType : 'text',
						data : parametros,
						success : function(result) {
							comprobarmatriz( result,":");
							if(result=='completo'){
								$('#faltantes').hide();
								$('#completo').show();
							}else{
								
								$('#completo').hide();
								$('#faltantes').show();
								
								
							}
						},
						error : function(result) {
							//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
						}
					});
	}
	function infoRCAutoridad() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerIfoRC",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {
						$('#InfoRcAutoridad').DataTable(
						{
						paging : false,
						info : false,
						searching : false,
						bDestroy : true,
						data : result.data,
						columns : [
						{data : "","render" : function(data, type,full, meta) {
						return meta.row + 1;
						}},
						{data : "fechaRendicion"},
						{data : "lugar"},
						{data : "numero"},
						{data : "","render" : function(data, type,full, meta) {
						if (full.estado === "finalizado") {
							data = '';
							} else {
								data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor" data-toggle="modal" data-target="#modalEliminar" onclick="ActualizarM2(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';
								}
						return data;}
						} ],
						language : {url : "resources/json/lenguajeTablaDataTable.json"
						},
						createdRow : function(row, data,dataIndex) {
						$(row).attr('id',data.infAutCod);
					    $(row).attr('ondragstart','drag(event)');
					    $(row).attr('draggable','false');
					    $(row).attr('data-destino','detalleItem');
					    $(row).find("td:first").css({"font-weight" : "bold",
													"white-space" : "nowrap"
					    });
						},
						});
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function PlanTabajoFin() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerPlanTrabajoFin",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {
						if(result.data.length>0){
							$("#DatosFin").show();
							$("#NuevoM2").hide();
							$('#TablaPlanTrabajoFin').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [
									{data : "","render" : function(data, type,full, meta) {
									return meta.row + 1;
									}},
									{data : "pltPlan"},
									{data : "ptlAcciones"},
									{data : "ptlResultados"},
									{data : "ptlObs"},

									{ data: "" ,"render": function (data, type, full, meta) {
										   if('${infestadoinforme}' === "finalizado"){
								            	 data = '';     
								             }else{
							        data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarPlanTrabajo(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';    
									}
							                return data;
							    }},
									{data : "" ,"render": function (data, type, full, meta) {

										if('${infestadoinforme}' === "finalizado"){
							            	 data = '';     
							             }else{
									data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;" > Eliminar</button>'; 
							             }
										return data;}}],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.pltCod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).attr('data-destino','detalleItem');
								    $(row).attr('data-tabla','esq_gestion.tbl_plan_trabajo_fin');
								    $(row).attr('tabla','TablaPlanTrabajoFin');
								    $(row).attr('data-campo','plt_cod');
								    $(row).attr('filas','2');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
						}else{
							$("#DatosFin").hide();
							$("#NuevoM2").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function AportesCiudadanos() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerAportes",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data[0].aportes!="VACIO"){
							$("#DatosAportes").show();
							$("#NuevoM8").hide();
							$('#tablaDF').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [
									{data : "","render" : function(data, type,full, meta) {
									return meta.row + 1;
									}},
									{data : "aportes"},

									{ data: "" ,"render": function (data, type, full, meta) {
										   if('${infestadoinforme}' === "finalizado"){
								            	 data = '';     
								             }else{
							        data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM8(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';    
									}
							                return data;
							    }}],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.infAutCod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosAportes").hide();
							$("#NuevoM8").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function InfoTributarios() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerTributarioFin",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data[0].opcion!="VACIO"){
							$("#DatosTributarios").show();
							$("#NuevoM4").hide();
							$('#tributario').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [
									{data : "","render" : function(data, type,full, meta) {
									return meta.row + 1;
									}},
									{data : "tipo"},
									{data : "opcion"},
									{data : "link"},

									{ data: "" ,"render": function (data, type, full, meta) {
										   if('${infestadoinforme}' === "finalizado"){
								            	 data = '';     
								             }else{
							        data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM4(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';    
									}
							                return data;
							    }}],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.infAutCod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosTributarios").hide();
							$("#NuevoM4").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function EjerciciosDignidada() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerRendicion",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data[0].proceso!="VACIO"){
							$("#DatosEjercicio").show();
							$("#NuevoM7").hide();
							$('#tablaEF').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [
									{data : "","render" : function(data, type,full, meta) {
									return meta.row + 1;
									}},
									{data : "proceso"},

									{ data: "" ,"render": function (data, type, full, meta) {
										   if('${infestadoinforme}' === "finalizado"){
								            	 data = '';     
								             }else{
							        data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM7(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';    
									}
							                return data;
							    }}],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.infAutCod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosEjercicio").hide();
							$("#NuevoM7").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function MecanismoAutoridad() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerTablaAmecanismosPcFin",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data.length>0){
							$("#DatosMPC").show();
							$("#NuevoM6").hide();
							$('#tablaMPC').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [
									{data : "contador"},
									{data : "tipo"},
									{data : "descripcion"},
									{data : "medio"},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM6(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
											}
											return data;
										}
									
									} ],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.ame_cod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosMPC").hide();
							$("#NuevoM6").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function FuncionesAutoridadFin() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerFuncionesAutoridadesFin",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data.length>0){
							$("#DatosFunciones").show();
							$("#NuevoM3").hide();
							$('#TablaFuncionesAutoridadesFin').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [{
										data : "contador"
									},
									{
										data : "funcion"
									},
									{
										data : "accion"
									},
									{
										data : "resultado"
									},
									{
										data : "observacion"
									},

									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM3(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
											}
											return data;
										}
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {

											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;" > Eliminar</button>';
											}
											return data;
										}
									} ],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.fa_cod);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).attr('data-tabla','esq_gestion.tbl_funciones_autoridades_fin');
								    $(row).attr('tabla','TablaFuncionesAutoridadesFin');
								    $(row).attr('data-campo','fa_cod');
								    $(row).attr('filas','2');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosFunciones").hide();
							$("#NuevoM3").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function PropuestasAutoridadFin() {
		var parametros = {
			"infCod" : $("#infcod").val()
			};
		$.ajax({
					url : "view/gestion/obtenerPropuestasAutoridadFin",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : 'POST',
					//async : false,
					dataType : 'json',
					data : parametros,
					success : function(result) {						
						if(result.data.length>0){
							$("#DatosPropuestas").show();
							$("#NuevoM5").hide();
							$('#TablaPropuetasAutoridadesFin').DataTable(
									{
									paging : false,
									info : false,
									searching : false,
									bDestroy : true,
									data : result.data,
									columns : [{
										data : "contador"
									},
									{
										data : "descripcion"
									},
									{
										data : "resultado"
									},

									{
										data : "",
										"render" : function(data, type, full,
												meta) {
											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="ActualizarM5(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
											}
											return data;
										}
									},
									{
										data : "",
										"render" : function(data, type, full,
												meta) {

											if ('${infestadoinforme}' === "finalizado") {
												data = '';
											} else {
												data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;" > Eliminar</button>';
											}
											return data;
										}
									} ],
									language : {url : "resources/json/lenguajeTablaDataTable.json"
									},
									createdRow : function(row, data,dataIndex) {
									$(row).attr('id',data.pro_id);
								    $(row).attr('ondragstart','drag(event)');
								    $(row).attr('draggable','false');
								    $(row).attr('data-tabla','esq_gestion.tbl_propuestas_fin');
								    $(row).attr('tabla','TablaPropuetasAutoridadesFin');
								    $(row).attr('data-campo','pro_id');
								    $(row).attr('filas','2');
								    $(row).find("td:first").css({"font-weight" : "bold",
																"white-space" : "nowrap"
								    });
									},
									});
							}else{
							$("#DatosPropuestas").hide();
							$("#NuevoM5").show();
						}
					
					},
					error : function(result) {
						//mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION", "3000");
					}
				});
	}
	function ActualizarM2(element) {
		$('#InfoRcAutoridad tbody').on(
				'click',
				'tr',
				function() {
					const codigo = $(element).parent().parent()
							.find("td:eq(0)").text();
					const fecha = $(element).parent().parent().find("td:eq(1)")
							.text();
					const lugar = $(element).parent().parent().find("td:eq(2)")
							.text();
					const numero = $(element).parent().parent()
							.find("td:eq(3)").text();
					$('#tablaRC').hide();
					$('#fechaRendicion').val(fecha)
					$('#lugar').val(lugar)
					$('#numeroAsistentes').val(numero)
					$('#actRC').show();
				});

	}
	function ActualizarM3(element) {
		$('#DatosFunciones').hide();
		const codigo = $(element).closest('tr').attr('id');
		const faFuncion = $(element).parent().parent().find("td:eq(1)").text();
		const faAcciones = $(element).parent().parent().find("td:eq(2)").text();
		const faResultado = $(element).parent().parent().find("td:eq(3)").text();
		const faObs = $(element).parent().parent().find("td:eq(4)").text();
		$("#fa_cod").val(codigo);
		$("#fa_funcion").val(faFuncion);
		$("#fa_acciones").val(faAcciones);
		$("#fa_resultado").val(faResultado);
		$("#fa_obs").val(faObs);
		$("#ActualizarFunciones").show();
	}
	function ActualizarM8(element) {
		$('#DatosAportes').hide();
		const aportesc = $(element).parent().parent().find("td:eq(1)")
		.text();
		$("#inaAportesCiu").val(aportesc);
		$("#NuevoM8").show();
	}
	function ActualizarM7(element) {
		$('#DatosEjercicio').hide();
		const aportesc = $(element).parent().parent().find("td:eq(1)").text();
		$("#inaProcesoRc").val(aportesc);
		$("#NuevoM7").show();
	}
	function ActualizarM6(element) {

		const codigo = $(element).closest('tr').attr('id');
		const tipo = $(element).parent().parent().find("td:eq(1)").text();
		const descripcion = $(element).parent().parent().find("td:eq(2)").text();
		const medio = $(element).parent().parent().find("td:eq(3)").text();

		$("#tablaMPC").hide();
		$("#AmecanismosActualizarFin").show();
		$("#ame_cod").val(codigo);
		$("#ame_tipo").val(tipo);
		$("#ame_desc").val(descripcion);
		$("#ame_medio").val(medio);

	}
	function ActualizarPlanTrabajo(element) {

		const codigo = $(element).closest('tr').attr('id');
		const pltPlan = $(element).parent().parent().find("td:eq(1)").text();
		const ptlAcciones = $(element).parent().parent().find("td:eq(2)").text();
		const ptlResultados = $(element).parent().parent().find("td:eq(3)").text();
		const ptlObs = $(element).parent().parent().find("td:eq(4)").text();
		
		$("#DatosFin").hide();
		$("#ActualizarDatosPlan").show();
		$("#plt_cod").val(codigo);
		$("#plt_plan").val(pltPlan);
		$("#ptl_acciones").val(ptlAcciones);
		$("#ptl_resultados").val(ptlResultados);
		$("#ptl_obs").val(ptlObs);

	}
	function ActualizarM4(element) {
      const descripcion = $(element).parent().parent().find("td:eq(2)").text();
		const medio = $(element).parent().parent().find("td:eq(3)").text();

		$("#DatosTributarios").hide();
		$("#NuevoM4").show();
		$("#infAutTributo").val(descripcion);
		$("#infAutMedioTributario").val(medio);

	}
	function ActualizarM5(element) {
		var codigo = $(element).closest('tr').attr('id');
		var proDescripcion = $(element).parent().parent().find("td:eq(1)")
				.text();
		var proResultados = $(element).parent().parent().find("td:eq(2)")
				.text();

		$("#DatosPropuestas").hide();
		$("#ActualizarPropuestas").show();
		$("#pro_id").val(codigo);
		$("#pro_descripcion").val(proDescripcion);
		$("#pro_resultados").val(proResultados);

		}
	$("#btnGuardarM2")
			.click(
					function(event) {
						var form = $("#InformeAutoridadFin")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {

							ejecutarJson(form);
							abrir($("#menuAplicacion #menu a.linkAbierto"),
									null, true);
						}
						form.addClass('was-validated');

					});
	$("#btnGuardarIF")
	.click(
			function(event) {
				var form = $("#PlanTrabajoFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {

					ejecutarJson(form);
					abrir($("#menuAplicacion #menu a.linkAbierto"),null, true);
				}
				form.addClass('was-validated');

			});
	$("#btnPlanFinalizar").click(function(event) {
		 var codigoinfo = $("#infcod").val();
		 abrirPaguina($(this), "#" + $(this).attr("data-destino"), codigoinfo);
	});
	$("#btnFuncionesFin").click(function(event) {
		 var codigoinfo = $("#infcod").val();
		 abrirPaguina($(this), "#" + $(this).attr("data-destino"), codigoinfo);
	});
	$("#btnPropuestasFin").click(function(event) {
		 var codigoinfo = $("#infcod").val();
		 abrirPaguina($(this), "#" + $(this).attr("data-destino"), codigoinfo);
	});
	
	function Eliminar(element) {	
		const codigo = $(element).closest('tr').attr('id');	
        const tabla=$(element).closest('tr').attr("data-tabla");
        const campo=$(element).closest('tr').attr("data-campo");
        const dataTable=$(element).closest('tr').attr("tabla");
        const filas=$(element).closest('tr').attr("filas");
		 $.ajax({
		        url: 'view/gestion/eliminarDatos',
		        headers: {"X-CSRF-TOKEN": csrfToken},
		        type: "POST",
		        dataType: 'json',
		        data: {codigo: codigo,tabla:tabla,campo:campo},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                      
		                     var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#"+dataTable+" tr").length-filas;
	                         
	                         if (nFilas==0){                            	
	                        	 abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
	                             }
	               } else {
	                    $("#cargando").delay("slow").fadeOut();
	                    
	                         mostrarMensaje(msg.mensaje, "ERROR");
	               }
		        },
		        error: function (result) {

		        }
		    });
	}
	$("#btnGuardarAportesFin")
	.click(
			function(event) {
				
				var form = $("#InformeAutoridadAporteFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {

					ejecutarJson(form);
					abrir($("#menuAplicacion #menu a.linkAbierto"),
							null, true);
				}
				form.addClass('was-validated');

			});
	$("#btnGuardarProcesoFin")
	.click(
			function(event) {
				
				var form = $("#InformeAutoridadprocesoFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {

					ejecutarJson(form);
					abrir($("#menuAplicacion #menu a.linkAbierto"),
							null, true);
				}
				form.addClass('was-validated');

			});
	$("#ame_desc").change(function() {
		var seleccion = $("#ame_desc").val();
		const url=document.getElementById("ame_medio");
		if (seleccion == "SI") {
			$(".url").removeAttr("disabled");
			$(".url").prop("required", true);
			$(".url").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$(".url").val("NO APLICA");
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");
			url.type = 'text';

		} else {
			$(".url").val("");
			$(".url").prop("disabled", "disabled");
			$(".url").removeAttr("required");
			url.type = 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#ameDesc1").change(function() {
		var seleccion = $("#ameDesc1").val();
		const url=document.getElementById("ameMedio1");
		if (seleccion == "SI") {
			$("#ameMedio1").removeAttr("disabled");
			$("#ameMedio1").prop("required", true);
			$("#ameMedio1").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$("#ameMedio1").val("NO APLICA");
			$("#ameMedio1").prop("disabled", "disabled");
			$("#ameMedio1").removeAttr("required");
			url.type = 'text';
		} else {
			$(".ameMedio1").val("");
			$("#ameMedio1").prop("disabled", "disabled");
			$("#ameMedio1").removeAttr("required");
			url.type = 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	$("#ameDesc2").change(function() {
		var seleccion = $("#ameDesc2").val();
		const url=document.getElementById("ameMedio2");
		if (seleccion == "SI") {
			$("#ameMedio2").removeAttr("disabled");
			$("#ameMedio2").prop("required", true);
			$("#ameMedio2").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$("#ameMedio2").val("NO APLICA");
			$("#ameMedio2").prop("disabled", "disabled");
			$("#ameMedio2").removeAttr("required");
			url.type = 'text';
		} else {
			$(".ameMedio2").val("");
			$("#ameMedio2").prop("disabled", "disabled");
			$("#ameMedio2").removeAttr("required");
			url.type = 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	$("#ameDesc3").change(function() {
		var seleccion = $("#ameDesc3").val();
		const url=document.getElementById("ameMedio3");
		if (seleccion == "SI") {
			$("#ameMedio3").removeAttr("disabled");
			$("#ameMedio3").prop("required", true);
			$("#ameMedio3").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$("#ameMedio3").val("NO APLICA");
			$("#ameMedio3").prop("disabled", "disabled");
			$("#ameMedio3").removeAttr("required");
			url.type = 'text';
		} else {
			$(".ameMedio3").val("");
			$("#ameMedio3").prop("disabled", "disabled");
			$("#ameMedio3").removeAttr("required");
			url.type = 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	$("#ameDesc4").change(function() {
		var seleccion = $("#ameDesc4").val();
		const url=document.getElementById("ameMedio4");
		if (seleccion == "SI") {
			$("#ameMedio4").removeAttr("disabled");
			$("#ameMedio4").prop("required", true);
			$("#ameMedio4").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$("#ameMedio4").val("NO APLICA");
			$("#ameMedio4").prop("disabled", "disabled");
			$("#ameMedio4").removeAttr("required");
			url.type = 'text';
		} else {
			$(".ameMedio4").val("");
			$("#ameMedio4").prop("disabled", "disabled");
			$("#ameMedio4").removeAttr("required");
			url.type= 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});
	$("#ameDesc5").change(function() {
		var seleccion = $("#ameDesc5").val();
		const url=document.getElementById("ameMedio5");
		if (seleccion == "SI") {
			$("#ameMedio5").removeAttr("disabled");
			$("#ameMedio5").prop("required", true);
			$("#ameMedio5").val("http://");
			url.type = 'url';
		} else if (seleccion == "NO") {
			$("#ameMedio5").val("NO APLICA");
			$("#ameMedio5").prop("disabled", "disabled");
			$("#ameMedio5").removeAttr("required");
			url.type = 'text';
		} else {
			$(".ameMedio5").val("");
			$("#ameMedio5").prop("disabled", "disabled");
			$("#ameMedio5").removeAttr("required");
			url.type= 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	});

	$("#btnGuardarMPC")
	.click(
			function(event) {
				var form = $("#AmecanismosPcFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {

					$("#ameMedio1").prop("required", false);
					$("#ameMedio2").prop("required", false);
					$("#ameMedio3").prop("required", false);
					$("#ameMedio4").prop("required", false);
					$("#ameMedio5").prop("required", false);
					
					$("#ameMedio1").removeAttr("disabled");
					$("#ameMedio2").removeAttr("disabled");
					$("#ameMedio3").removeAttr("disabled");
					$("#ameMedio4").removeAttr("disabled");
					$("#ameMedio5").removeAttr("disabled");
					ejecutarJson(form);
				}
				form.addClass('was-validated');
				abrir($("#menuAplicacion #menu a.linkAbierto"),
						null, true);
			});
	$("#btnAmecanismosActualizarFin")
	.click(
			function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
				var form = $("#AmecanismosPcActualizarFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {

					$(".url").removeAttr("disabled");
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
						tabla : 'esq_gestion.tbl_amecanismos_pc_fin',
						columns : columnas,
						values : valores,
						condicion : 'ame_cod',
						valorcondicion : $("#ame_cod").val()
					};

				
					
					ejecutarJsonUpdate(form, data);
					abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});
	$("#btnGuardarTributarias")
	.click(
			function(event) {
				var form = $("#InformeAutoridadTribuFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {
					$("#infAutMedioTributario").removeAttr("disabled")
					ejecutarJson(form);
					abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});
	$("#infAutTributo").change(function() {
		var seleccion = $("#infAutTributo").val();
		const url=document.getElementById("infAutMedioTributario");
		if (seleccion == "SI") {
			$("#infAutMedioTributario").removeAttr("disabled");
			$("#infAutMedioTributario").prop("required", true);
			$("#infAutMedioTributario").val("http://");
			url.type= 'url';
		} else if (seleccion == "NO") {
			$("#infAutMedioTributario").val("S/N");
			$("#infAutMedioTributario").prop("disabled", "disabled");
			$("#infAutMedioTributario").removeAttr("required");
			url.type= 'text';

		} else {
			$("#infAutMedioTributario").val("");
			$("#infAutMedioTributario").prop("disabled", "disabled");
			$("#infAutMedioTributario").removeAttr("required");
			url.type= 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	$("#btnActualziarPlanTrabajoFin").click(
			function(event) {
			//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
				var form = $("#ActualziarPlanTrabajo")
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
					  var data = {tabla: 'esq_gestion.tbl_plan_trabajo_fin',columns:columnas,values:valores,condicion:'plt_cod',valorcondicion:$("#plt_cod").val()};
					  
					  ejecutarJsonUpdate(form,data);
					  abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});	 
	$("#btnGuardarFunciones")
	.click(
			function(event) {
				var form = $("#FuncionesAutoridadesFin")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {
					ejecutarJson(form);
					 abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');
			});
	$("#btnActualziarFuncionesAutoridadesFin")
	.click(
			function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
				var form = $("#ActualziarFuncionesAutoridadesFin")
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
						tabla : 'esq_gestion.tbl_funciones_autoridades_fin',
						columns : columnas,
						values : valores,
						condicion : 'fa_cod',
						valorcondicion : $("#fa_cod").val()
					};

					ejecutarJsonUpdate(form, data);
					abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});
	
	$("#btnGuardarPropuesta")
	.click(
			function(event) {
				var form = $("#PropuestasAutoridadesFin")
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
				abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
			});
	$("#btnActualziarPropuestasAutoridadesFin")
	.click(
			function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
				var form = $("#ActualziarPropuestasAutoridadesFin")
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
						tabla : 'esq_gestion.tbl_propuestas_fin',
						columns : columnas,
						values : valores,
						condicion : 'pro_id',
						valorcondicion : $("#pro_id").val()
					};

					ejecutarJsonUpdate(form, data);
					abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});
	$("#btnActualizarM1")
	.click(
			function(event) {
		
				var form = $("#ActualziarfechasAutoridadesFin")
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
						tabla : 'esq_gestion.tbl_informe_autoridad_fin',
						columns : columnas,
						values : valores,
						condicion : 'inf_aut_cod',
						valorcondicion : $("#infcod").val()
					};

					ejecutarJsonUpdate(form, data);
					abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
				}
				form.addClass('was-validated');

			});
	
	$("#btnFinalizarInformeFin").click(function(event) {
		
		//mostrarMensaje("Todas las matrices tienen información, puede finalizar el informe!",	"EXITO");
			var form = $("#finalizarInformeFin")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
			
				ejecutarJson(form);
				abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
			}
			form.addClass('was-validated');
	});
</script>