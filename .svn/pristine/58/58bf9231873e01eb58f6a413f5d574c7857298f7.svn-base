<%-- 
	version		: 1.0
    Document  	: Frm_Ejectuvio_EjecucionProgramaticaNuevo
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
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblEjecucionProgramatica"
					id="EjecucionProgramatica" data-rutaAplicacion="rendicion"
					data-opcion="guardarEjecutivoEjecucionProgramatica"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">EJECUCIÓN PROGRAMÁTICA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th colspan="2"></th>
					
					<tr>
					<td scope="row">
						OBJETIVO ESTRATÉGICOS /COMPETENCIAS/FUNCIONES
					</td>
						<td scope="row">
									<select class="custom-select custom-select-sm" id="foCod"
										required="required" name="foCod" >
										<option value="">Seleccione</option>
										<c:forEach var="listadoFuncionesObjetivos"
											items="${listadoFuncionesObjetivos}">
											<option
												value="${listadoFuncionesObjetivos.foCod}">${listadoFuncionesObjetivos.foNom}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
					<td scope="row">
						NO. DE META: 
					</td>
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="eprNumero" name="eprNumero" placeholder="000"
													 required="required" min="0" onkeypress="javascript:return validarnroEntero(event);"
													>
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
						<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="eprGestion" name="eprGestion" placeholder="Ingrese la descripción de la gestión de la meta"
													 required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div>
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN DE CÓMO APORTA EL RESULTADO ALCANZADO AL LOGRO DEL PLAN DE DESARROLLO
					</td>
						<td scope="row">
						<input type="text" style="text-transform: uppercase;" class="form-control form-control-sm"
													id="eprAporteResult" name="eprAporteResult" placeholder="Ingrese la descripción del aporte"
													 required="required">
												<div class="invalid-feedback">Por favor ingrese la información</div>
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
				<thead>
					<tr>
						<th width="1%">#</th>
						<th width="10%">OBJETIVO ESTRATÉGICOS /COMPETENCIAS/FUNCIONES</th>
<!-- 						<th width="5%">NO. DE META </th>
 -->						<th width="10%">META POA </th>
						<th width="10%">INDICADOR DE LA META</th>
						<th width="5%">% DE LA GESTIÓN</th>
						<th width="20%">DESCRIPCIÓN DE LA GESTIÓN POR META</th>
						<th width="20%">¿CÓMO APORTA EL RESULTADO ALCANZADO AL LOGRO DEL PLAN DE DESARROLLO?</th>
						<th width="5%"></th>
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

var csrfToken = $('input[name="_csrf"]').val();

$(document).ready(function() {
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
		url : "obtenerEjecucionesProgramaticasEjecutivo",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		columns : [
			{data : "contador"},
			{data : "objetivo"}, 
/* 			{data : "NumeroMeta"},
 */			{data : "Meta"}, 
			{data : "IndicadorMeta"},
			{data : "PorcentajeGestion"},
			{data : "DescripcionCompetencia"},
			{data : "Aporte"},
			{data : "" ,"render": function (data, type, full, meta) {
				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{

				data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';
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
	                         var nFilas = $("#TablaEjecucionesProgramaticas tr").length-1;
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

	
		  
		 
</script>