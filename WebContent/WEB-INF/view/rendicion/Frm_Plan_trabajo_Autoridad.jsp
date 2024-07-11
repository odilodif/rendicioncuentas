<%-- 
	version		: 1.0
    Document  	: Frm_Plan_trabajo_Autoridad.jsp
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
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


	<c:choose>
		<c:when test="${inf_estado=='activo'}">
	<div class="card text-center mb-card20">
		
	<div class="card-header text-white carHeaderBlue">
		<h5>CUMPLIMIENTO DEL PLAN DE TRABAJO PRESENTADO AL ORGANISMO COMPETENTE</h5>
	</div>
<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Ingrese uno a uno las registos</div>
		</div>			
	<div class="card-body">
	
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
						modelAttribute="TblPlanTrabajo" id="PlanTrabajo"
						data-rutaAplicacion="rendicion"
						data-opcion="guardarPlanTrabajo"
						data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infAutCod" name="infAutCod"
							value="${infAutCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					
					<tr>
					<td scope="row" width="20%">
						EJE DEL PLAN DE TRABAJO PLANTEADO FORMALMENTE AL CNE
					</td>
						<td scope="row" width="80%">
												
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id=pltPlan required="required"
										name="pltPlan"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
							PRINCIPALES ACCIONES REALIZADAS 					
					</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlAcciones" required="required"
										name="ptlAcciones"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRINCIPALES RESULTADOS OBTENIDOS 					</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlResultados" required="required"
										name="ptlResultados"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
				OBSERVACIONES							</td>
						<td scope="row">
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ptlObs" required="required"
										name="ptlObs"
										placeholder="Ingrese la información lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
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
				</div>
						</div>
		</c:when>
		
		<c:when test="${inf_estado=='matriz'}">
			<div id="ActualizarDatos">
			<form:form class="needs-validation" novalidate=""
								modelAttribute="TblPlanTrabajo" id="ActualziarPlanTrabajo"
								data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
								data-accionEnExito="ACTUALIZAR">
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
							<button type="submit" id="btnActualziarPlanTrabajo"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
						<input type="hidden" id="plt_cod" name="plt_cod">
			</div>
			<div id="Datos">
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
			<table id="TablaPlanTrabajo"
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
		 $("#Datos").show();
		 $("#ActualizarDatos").hide();
	});

	$("#btnGuardarI").click(function(event) {
		var form = $("#PlanTrabajo")
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
		var parametros = {"infAutCod" : '${infAutCod}'};
		$('#TablaPlanTrabajo').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerPlanTrabajo",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		paging:   false,
		info:     false,
		searching: false,
		responsive: true,
		scrollX: true,
		bDestroy: true,
		columns : [
			{data : "contador"},
			{data : "pltPlan"},
			{data : "ptlAcciones"}, 
			{data : "ptlResultados"},
			{data : "ptlObs"},

			{ data: "" ,"render": function (data, type, full, meta) {
				   if('${infestadoinforme}' === "finalizado"){
		            	 data = '';     
		             }else{
	        data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" "> Editar</button>';    
			}
	                return data;
	    }},
			{data : "" ,"render": function (data, type, full, meta) {

				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
			data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" " > Eliminar</button>'; 
	             }
				return data;}}
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pltCod);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', '');
				//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				//$(row).find("td:eq(5)").attr('align','center');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});
				$(row).find("td:eq(3)").attr('title', data.nombres);	

				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	
				$(row).find("td:eq(6)").css({
					"vertical-align" : "middle",									
				});	
				$(row).find("td:eq(5)").css({
					"vertical-align" : "middle",									
				});	
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_plan_trabajo',campo:'plt_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                      
		                     var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaPlanTrabajo tr").length-2;
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


	function Modificar(element) {	
		
		var codigo = $(element).closest('tr').attr('id');
		var pltPlan = $(element).parent().parent().find("td:eq(1)").text();
		var ptlAcciones = $(element).parent().parent().find("td:eq(2)").text();
		var ptlResultados = $(element).parent().parent().find("td:eq(3)").text();
		var ptlObs = $(element).parent().parent().find("td:eq(4)").text();
	

		$("#Datos").hide();
		$("#ActualizarDatos").show();
		$("#plt_cod").val(codigo);
		$("#plt_plan").val(pltPlan);
		$("#ptl_acciones").val(ptlAcciones);
		$("#ptl_resultados").val(ptlResultados);
		$("#ptl_obs").val(ptlObs);
	}
	
	$("#btnActualziarPlanTrabajo").click(
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
					  var data = {tabla: 'esq_rendicioncuentas.tbl_plan_trabajo',columns:columnas,values:valores,condicion:'plt_cod',valorcondicion:$("#plt_cod").val()};
					  
					  ejecutarJsonUpdate(form,data);
				}
				form.addClass('was-validated');

			});	 
</script>