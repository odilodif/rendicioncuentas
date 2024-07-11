<%-- 
	version		: 1.0
    Document  	: Frm_GAD_EjecucionProgramatica
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

<div class="card text-center mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
		<div class="alert alert-primary" role="alert">En caso de no contar con competencias o funciones favor agregarlas en el primer menú Datos del Informe</div>
		</div>
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblEjecucionProgramatica"
					id="EjecucionProgramatica" data-rutaAplicacion="rendicion"
					data-opcion="guardarEjecucionProgramatica"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">EJECUCIÓN PROGRAMÁTICA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th colspan="2"></th>
					<tr>
					<td scope="row">
						ELIJA LOS OBJETIVOS DEL PLAN DE DESARROLLO DE SU TERRITORIO
					</td>
						<td scope="row">
						<select class="custom-select custom-select-sm" id="objCod"
										required="required" name="objCod">
										<option value="">Seleccione un Objetivo</option>
										<c:forEach var="listadoObjetivosPlan"
											items="${listadoObjetivosPlan}">
											<option
												value="${listadoObjetivosPlan.objCod}">${listadoObjetivosPlan.objNombre}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
					<td scope="row">
						TIPO DE COMPETENCIAS (ELIJA Ó DESCRIBA)
					</td>
						<td scope="row">
						<c:choose>
						<c:when test="${TipoFormulario=='Gad'}">
						<select class="custom-select custom-select-sm" id="eprTipoCompetencia"
												name="eprTipoCompetencia" required="required" onchange="corregir()">
												<option value="">Seleccione...</option>
												<option value="COMPETENCIAS / FUNCIONES">COMPETENCIAS  / FUNCIONES</option>
												<option value="COMPETENCIAS EXCLUSIVAS">COMPETENCIAS EXCLUSIVAS</option>
												
											</select>
												<select class="custom-select custom-select-sm" id="foCodExclusivas"
										required="required" name="foCodExclusivas" >
										<option value="">Seleccione una Competencia Exclusivas</option>
										<c:forEach var="listadoFuncionesObjetivos"
											items="${listadoFuncionesObjetivos}">
											<option
												value="${listadoFuncionesObjetivos.foCod}">${listadoFuncionesObjetivos.foNom}</option>
								</c:forEach>
								
							</select>
								<select class="custom-select custom-select-sm" id="foCodConcurrentes"
										required="required" name="foCodConcurrentes" >
										<option value="">Seleccione una Competencia Concurrente</option>
										<c:forEach var="listadoCompetenciasConcurrentes"
											items="${listadoCompetenciasConcurrentes}">
											<option
												value="${listadoCompetenciasConcurrentes.foCod}">${listadoCompetenciasConcurrentes.foNom}</option>
								</c:forEach>
							</select>
						</c:when>	
						<c:when test="${TipoFormulario=='Vinculadas'}">
						<select class="custom-select custom-select-sm" id="eprTipoCompetencia"
												name="eprTipoCompetencia" required="required" onchange="corregir2()">
												<option value="">Seleccione...</option>
												<option value="OBJETIVOS ESTRATÉGICOS">OBJETIVOS ESTRATÉGICOS</option>
									<option value="FUNCIONES">FUNCIONES</option>
									<option value="FINES">FINES</option>
												
											</select>
														<select class="custom-select custom-select-sm" id="foCodExclusivas"
										required="required" name="foCodExclusivas" >
										<option value="">Seleccione una Objetivo Extratégico</option>
										<c:forEach var="listadoFuncionesObjetivos"
											items="${listadoFuncionesObjetivosEstategicos}">
											<option
												value="${listadoFuncionesObjetivos.foCod}">${listadoFuncionesObjetivos.foNom}</option>
								</c:forEach>
							</select>
								<select class="custom-select custom-select-sm" id="foCodConcurrentes"
										required="required" name="foCodConcurrentes" >
										<option value="">Seleccione una función</option>
										<c:forEach var="listadoFuncionesObjetivosFunciones"
											items="${listadoFuncionesObjetivosFunciones}">
											<option
												value="${listadoFuncionesObjetivosFunciones.foCod}">${listadoFuncionesObjetivosFunciones.foNom}</option>
								</c:forEach>
							</select>
							</select>
								<select class="custom-select custom-select-sm" id="foCodFines"
										required="required" name="foCodFines" >
										<option value="">Seleccione los Fines</option>
										<c:forEach var="listadoFuncionesObjetivosFines"
											items="${listadoFuncionesObjetivosFines}">
											<option
												value="${listadoFuncionesObjetivosFines.foCod}">${listadoFuncionesObjetivosFines.foNom}</option>
								</c:forEach>
							</select>
						</c:when>			
						</c:choose>
							
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						NO. DE META: 
					</td>
						<td scope="row">
												<input type="number" class="form-control form-control-sm"
													id="eprNumero" name="eprNumero" placeholder="000"
													maxlength="20" required="required" min="0"
													pattern="^[0-9]+" onkeypress="mascaraEnteros(this)" onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE LA META:
					</td>
						<td scope="row">
						
						<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="eprMeta" name="eprMeta" placeholder="Ingrese la descripcion de la meta"
													 required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div>
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						 INDICADORES: 
					</td>
						<td scope="row">
						<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="eprIndicador" name="eprIndicador" placeholder="Ingrese el indicador"
													 required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div>
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						TOTAL DE RESULTADOS PLANIFICADOS
					</td>
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="eprPresultadopl" name="eprPresultadopl" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						TOTALES DE RESULTADOS CUMPLIDOS 
					</td>
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="eprPresultadocm" name="eprPresultadocm" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE LA GESTIÓN POR META:
					</td>
						<td scope="row">
						
						
						
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="eprGestion" required="required"
										name="eprGestion"
										placeholder="Describa los resultados de la gestión ejecutada detallando población, sectores a los que beneficiaron estos resultados"
										></textarea>
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE CÓMO APORTA EL RESULTADO ALCANZADO AL LOGRO DEL PLAN DE DESARROLLO
					</td>
						<td scope="row">
						
						
						
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="eprAporteResult" required="required"
										name="eprAporteResult"
										placeholder="Describa como la gestión ejecutada en el año aportó a logro de los objetivos del Plan de Desarrollo "
										></textarea>
						
						</td>
					
					
					
					</tr>
					
					</table>
						
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		
		<c:when test="${inf_estado=='sinObjetivo'}">
		
		<div>
				<div id="informacion">
					¡Información!... se requiere que ingrese la matriz de objetivos del plan .<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú OBJETIVOS DEL PLAN
					del Informe.
				</div>
			</div>
		
		</c:when>
		
		<c:when test="${inf_estado=='matriz'}">
					<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Para eliminar un meta de esta matriz, verifique que no este asociada a un meta de la matriz de Ejecución Presupuestaria</div>

		</div>
				<div id="ActualizarDatosEp">
				
				
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblEjecucionProgramatica"
					id="EjecucionProgramaticaActualizar" data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">EJECUCIÓN PROGRAMÁTICA</h5>
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th colspan="2"></th>
					<tr>
					<td scope="row" width="30%">
						OBJETIVO DEL PLAN DE DESARROLLO DE SU TERRITORIO
					</td>
						<td width="70%" scope="row">
								<label id=objCodNombre></label>
						</td>
					</tr>
					<tr>
					<td scope="row">
						TIPO DE COMPETENCIAS (ELIJA Ó DESCRIBA)
					</td>
						<td scope="row">
														<label id=epr_tipo_competencia></label>
														<br>
														<label id=epr_competencia_concurr></label>
						</td>
					</tr>
						<tr>
					<td scope="row">
						DESCRIPCIÓN DE LA META:
					</td>
						<td scope="row">
						<label id=epr_meta></label>
						<!-- <input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="epr_meta" name="epr_meta" placeholder="Ingrese la descripcion de la meta"
													maxlength="20"  required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div> -->
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						NO. DE META: 
					</td>
						<td scope="row">
												<input type="number" class="form-control form-control-sm"
													id="epr_numero" name="epr_numero" placeholder="000"
													maxlength="20" required="required" min="0"
													pattern="^[0-9]+" onkeypress="mascaraEnteros(this)" onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											
						</td>
					</tr>
				
					<tr>
					<td scope="row">
						 INDICADORES: 
					</td>
						<td scope="row">
						<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="epr_indicador" name="epr_indicador" placeholder="Ingrese el indicador"
													 required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div>
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						TOTAL DE RESULTADOS PLANIFICADOS
					</td>
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="epr_presultadopl" name="epr_presultadopl" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						TOTALES DE RESULTADOS CUMPLIDOS 
					</td>
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="epr_presultadocm" name="epr_presultadocm" placeholder="0.00" 
													 required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE LA GESTIÓN POR META:
					</td>
						<td scope="row">
						
						
						
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="epr_gestion" required="required"
										name="epr_gestion"
										placeholder="Describa los resultados de la gestión ejecutada detallando población, sectores a los que beneficiaron estos resultados"
										></textarea>
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE CÓMO APORTA EL RESULTADO ALCANZADO AL LOGRO DEL PLAN DE DESARROLLO
					</td>
						<td scope="row">
						
						
						
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="epr_aporte_result" required="required"
										name="epr_aporte_result"
										placeholder="Describa como la gestión ejecutada en el año aportó a logro de los objetivos del Plan de Desarrollo "
										></textarea>
						</td>
					</tr>
					</table>
					</div>
				<div class="col-md-12 text-center">
				<button type="submit" id="btnActualziarEP"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=epr_cod name="epr_cod">
			<input type="hidden" id=epr_total name="epr_total">
				</form:form>
				</div>
			<div id="DatosEp">
			<div class="card text-center mb-card20">
				<div class="card-body">
			<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			<div class="row justify-content-center align-items-center">
				<div class="botones" role="group">
					<c:forEach items="${acciones}" var="a">
						<a class="btn ${a[5]} btn-sm" id="${a[2]}"
							data-rutaAplicacion="${a[4]}" data-opcion="${a[1]}"
							data-destino="detalleItem"> <c:if
								test="${a[2]=='_seleccionar'}">
								<span class='cantidadItemsSeleccionados'>0</span>
							</c:if> <c:if test="${a[2]!='_seleccionar'}">
								<span class="${a[2]}"></span>
							</c:if> <span>${a[3]}</span></a>
					</c:forEach>
				</div>
			</div>
			</c:when>
			</c:choose>
			<table id="TablaEjecucionesProgramaticas"
				class="table table-striped table-bordered" style="width: 100%">
				<thead style="background-color: rgb(31, 137, 72);">
					<tr>
					<th rowspan="2" style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
					<th rowspan="2" style="text-align: center; vertical-align: middle; font-size: x-small;">OBJETIVO DEL PLAN DE DESARROLLO DE SU TERRITORIO</th>
					<th colspan="2" style="text-align: center; vertical-align: middle; font-size: x-small;"><p style="color:white;">COMPETENCIAS</p></th>
					<th colspan="3" style="text-align: center; vertical-align: middle; font-size: x-small;"><p style="color:white;">META</p></th>
					<th colspan="5" style="text-align: center; vertical-align: middle; font-size: x-small;"><p style="color:white;">RESULTADOS</p></th>
					<th rowspan="2" style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
				 	<th rowspan="2" style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
					</tr>
					<tr>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO DE COMPETENCIAS </th>
 						<th width="5%"  style="text-align: center; vertical-align: middle; font-size: x-small;">DESCRIPCION COMPETENCIAS </th>
 						<th width="5%"  style="text-align: center; vertical-align: middle; font-size: x-small;">NO. DE META </th>
 						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">META POA </th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">INDICADOR DE LA META</th>
						<th width="5%" style="text-align: center; vertical-align: middle; font-size: x-small;">TOTALES PLANIFICADOS </th>
						<th width="5%" style="text-align: center; vertical-align: middle; font-size: x-small;">TOTALES CUMPLIDOS</th>
						<th width="5%" style="text-align: center; vertical-align: middle; font-size: x-small;">% DE LA GESTIÓN</th>
						<th width="20%" style="text-align: center; vertical-align: middle; font-size: x-small;">DESCRIPCIÓN DE LA GESTIÓN POR META</th>
						<th width="20%" style="text-align: center; vertical-align: middle; font-size: x-small;">¿CÓMO APORTA EL RESULTADO ALCANZADO AL LOGRO DEL PLAN DE DESARROLLO?</th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
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
</html>

<script type="text/javascript">



$(document).ready(function() {
		if ('${inf_estado}' == 'matriz') {
			tabla();
		}
		$("#DatosEp").show();
		$("#ActualizarDatosEp").hide();
	$('#foCodExclusivas').hide();
	$('#foCodConcurrentes').hide();
	$('#foCodFines').hide();
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
			
 	 	var form = $("#EjecucionProgramatica")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
				ejecutarJson(form);
		 	}
	form.addClass('was-validated');
           
	});

	function tabla() {
		var parametros = {"infCod" : '${infCod}'};
		$('#TablaEjecucionesProgramaticas').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerEjecucionesProgramaticas",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,
		columns : [
			{data : "contador"},
			{data : "codigoObjetivo"},
			{data : "tipoCompetencia"}, 
 			{data : "descripcionCompetencia"},
 			{data : "numeroMeta"},
 			{data : "meta"}, 
			{data : "indicadorMeta"},
			{data : "tp"},
			{data : "tc"},
			{data : "porcentajeGestion"},
			{data : "descripcionGestion"},
			{data : "aporte"},
			{
				data : "",
				"render" : function(data, type, full,
						meta) {
					if ('${infestadoinforme}' === "finalizado") {
						data = '';
					} else {
						data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
					}
					return data;
				}
			} ,
			{data : "" ,"render": function (data, type, full, meta) {
				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
	            	 if(full.Bandera === "1"){
						 data = '';
						}else{
				data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"  data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip"  style="text-align: center; font-size: x-small;"> Eliminar</button>';

						}
				
	             }
				 return data;}} 
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.eprCod);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', '');
				//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});

				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	

				$(row).find("td").css({
					"vertical-align" : "middle",
				});	
				$(row).find("td:eq(3)").attr('title', data.nombres);			
			},	
		});
	}
		
	function Eliminar(element) {	
		var codigo = $(element).closest('tr').attr('id');	
       
		 $.ajax({
		        url: 'view/rendicion/eliminarDatos',
		        headers: {"X-CSRF-TOKEN": csrfToken},
		        type: "POST",
		        dataType: 'json',
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_ejecucion_programatica',campo:'epr_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaEjecucionesProgramaticas tr").length-2;
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

	function corregir() {
	if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS / FUNCIONES"){
		$('#foCodExclusivas').hide();
		$("#foCodExclusivas").attr("disabled", true);
		$('#foCodConcurrentes').show();
		$("#foCodConcurrentes").attr("disabled", false);
	
		
	  }else{
		  if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS EXCLUSIVAS"){
			  $('#foCodExclusivas').show();
			  $("#foCodExclusivas").attr("disabled", false);
				$('#foCodConcurrentes').hide();
			$("#foCodConcurrentes").attr("disabled", true);
			
		}else{
			$('#foCodExclusivas').hide();
			$('#foCodConcurrentes').hide();
			$("#foCodExclusivas").attr("disabled", false);
			$("#foCodConcurrentes").attr("disabled", false);
			}
	  }		
	}	   
	function corregir2() {
		if (document.getElementById("eprTipoCompetencia").value === "OBJETIVOS ESTRATÉGICOS"){
				 $('#foCodExclusivas').show();
		  $("#foCodExclusivas").attr("disabled", false);
			$('#foCodConcurrentes').hide();
		$("#foCodConcurrentes").attr("disabled", true);
		$('#foCodFines').hide();
		  $("#foCodFines").attr("disabled", true);
		}else if(document.getElementById("eprTipoCompetencia").value === "FUNCIONES"){
			  $('#foCodConcurrentes').show();
			  $("#foCodConcurrentes").attr("disabled", false);
				$('#foCodExclusivas').hide();
			$("#foCodExclusivas").attr("disabled", true);
			$('#foCodFines').hide();
			  $("#foCodFines").attr("disabled", true);
		}
		else if(document.getElementById("eprTipoCompetencia").value === "FINES"){
			  $('#foCodFines').show();
			  $("#foCodFines").attr("disabled", false);
			$('#foCodExclusivas').hide();
			$("#foCodExclusivas").attr("disabled", true);
			$('#foCodConcurrentes').hide();
			$("#foCodConcurrentes").attr("disabled", true);
		}
	}
	function Modificar(element) {
		var codigo = $(element).closest('tr').attr('id');
		var objCodNombre = $(element).parent().parent().find("td:eq(1)").text();
		var TipoCompetencia = $(element).parent().parent().find("td:eq(2)").text();
		var DescripcionCompetencia = $(element).parent().parent().find("td:eq(3)").text();
		var NumeroMeta = $(element).parent().parent().find("td:eq(4)").text();
		var Meta = $(element).parent().parent().find("td:eq(5)").text();
		var IndicadorMeta = $(element).parent().parent().find("td:eq(6)").text();
		var tP = $(element).parent().parent().find("td:eq(7)").text();
		var tC = $(element).parent().parent().find("td:eq(8)").text();
		var DescripcionGestion = $(element).parent().parent().find("td:eq(10)").text();
		var Aporte = $(element).parent().parent().find("td:eq(11)").text();
		$("#DatosEp").hide();
		$("#Mensaje").hide();
		$("#ActualizarDatosEp").show();
		$("#epr_cod").val(codigo);
		$("#objCodNombre").text(objCodNombre);
		$("#epr_tipo_competencia").text(TipoCompetencia);
		$("#epr_competencia_concurr").text(DescripcionCompetencia);
		$("#epr_numero").val(NumeroMeta);
		$("#epr_meta").text(Meta);
		$("#epr_indicador").val(IndicadorMeta);
		$("#epr_presultadopl").val(tP);
		$("#epr_presultadocm").val(tC);
		$("#epr_gestion").val(DescripcionGestion);
		$("#epr_aporte_result").val(Aporte);
		$("#epr_aporte_result").val(Aporte);
	}
	$("#btnActualziarEP")
			.click(
					function(event) {
						//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
						var form = $("#EjecucionProgramaticaActualizar")
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

							var tP= parseFloat($("#epr_presultadopl").val().replace(/,/g, ""));
							var tC= parseFloat($("#epr_presultadocm").val().replace(/,/g, "")); 

							if (tP===0){
								$("#epr_total").val(0);
								}else{
									var PorcentajeGestion= parseFloat(Math.round(tC * 100) / tP).toFixed(2);
									var sresultado = formatearNumero(PorcentajeGestion);
									$("#epr_total").val(sresultado);

									}
							$("#epr_presultadopl").val(replazarmilesActualizar($("#epr_presultadopl").val()));
							$("#epr_presultadocm").val(replazarmilesActualizar($("#epr_presultadocm").val()));
							
							var x = $(form).serializeArray();
							$.each(x, function(i, field) {
								valores += field.value + ',99';
								if (valores.length > 0) {
									valores = valores.substr(0,
											valores.length - 1);
								}
							});
							var data = {
								tabla : 'esq_rendicioncuentas.tbl_ejecucion_programatica',
								columns : columnas,
								values : valores,
								condicion : 'epr_cod',
								valorcondicion : $("#epr_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});
		  
	function replazarmilesActualizar(Numero) {
		var a = Numero.replace(/[^\d.]/g, "");
		return a
	}

	function formatearNumero(nStr) {
	    nStr += '';
	    x = nStr.split(',');
	    x1 = x[0];
	    x2 = x.length > 1 ? '.' + x[1] : '';
	    var rgx = /(\d+)(\d{3})/;
	    while (rgx.test(x1)) {
	            x1 = x1.replace(rgx, '$1' + ',' + '$2');
	    }
	    return x1 + x2;
	}
	
</script>