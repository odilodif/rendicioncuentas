<%-- 
	version		: 1.0
    Document  	: Frm_GAD_PlandeDesarrollo
    Created on	: 17/02/2021; 15:57:14
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
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
					modelAttribute="TblPlanDesarrollo"
					id="ReporteAvances" data-rutaAplicacion="rendicion"
					data-opcion="guardarReporteAvances"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">PLAN DE DESARROLLO: REPORTE EL AVANCE RESPECTO A TODOS LOS OBJETIVOS INGRESADOS </h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th colspan="2"></th>
					<tr>
					<td scope="row">
						ELIJA LOS OBJETIVOS DEL PLAN DE DESARROLLO
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
						PORCENTAJE DE AVANCE ACUMULADO DE LA GESTIÓN DEL OBJETIVO 
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="number" class="form-control form-control-sm"
													id="pdPorcAvanceAcum" name="pdPorcAvanceAcum" placeholder="000.00"
													maxlength="20" required="required" step="0.01"  max="100" min="0"
													pattern="^[0-9]+">
												<div class="invalid-feedback">Por favor ingrese el porcentaje, no puede ser mayor a 100</div>
											</div>
						</td>
					</tr>
					
					<tr>
					<td scope="row">
						¿QUÉ NO SE AVANZÓ Y POR QUÉ? 
					</td>
						<td scope="row">
					
					<textarea rows="2" cols="" class="form-control form-control-sm"
										id="pdRazon" required="required"
										name="pdRazon"
										placeholder="Ingrese lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese la razón</div>	
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
		<c:when test="${inf_estado=='matriz'}">
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
			<table id="TablaAvance"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th>PLAN DE DESARROLLO: REPORTE EL AVANCE RESPECTO A TODOS LOS OBJETIVOS INGRESADOS</th>
						<th>PORCENTAJE DE AVANCE ACUMULADO DE LA GESTIÓN DEL OBJETIVO</th>
						<th>QUÉ NO SE AVANZÓ Y ¿POR QUÉ?</th>
						<th> </th>
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
		
		if ('${inf_estado}' == 'matriz') {
			tabla();			
		}
		
	});

	$("#btnGuardarI").click(function(event) {

		var form = $("#ReporteAvances")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
					ejecutarJson(form);
				 	}
			form.addClass('was-validated');

	});

	function Eliminar(element) {	
		var codigo = $(element).closest('tr').attr('id');	
		 $.ajax({
		        url: 'view/rendicion/eliminarDatos',
		        headers: {"X-CSRF-TOKEN": csrfToken},
		        type: "POST",
		        dataType: 'json',
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_plan_desarrollo',campo:'pd_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaCoberturaTerritorial tr").length-2;
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

	function tabla() {
		var parametros = {"infCod" : '${infCod}'};
		$('#TablaAvance').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerAvances",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		columns : [
			{data : "contador"},
			{data : "objCod"},
			{data : "pdPorcAvanceAcum"}, 
			{data : "pdRazon"}, 
			{ data: "" ,"render": function (data, type, full, meta) {
	            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
	    return data;
	        }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.pdCod);
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

	
	function corregir() {
	if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS CONCURRENTES"){
		$('#foCod').hide();
		$("#foCod").attr("disabled", true);
		$('#eprCompetenciaConcurr').show();
		$("#eprCompetenciaConcurr").attr("disabled", false);
		
	  }else{
		  if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS EXCLUSIVAS"){
			  $('#foCod').show();
			  $("#foCod").attr("disabled", false);
				$('#eprCompetenciaConcurr').hide();
			$("#eprCompetenciaConcurr").attr("disabled", true);
			
		}else{
			$('#foCod').hide();
			$('#eprCompetenciaConcurr').hide();
			$("#foCod").attr("disabled", false);
			$("#eprCompetenciaConcurr").attr("disabled", false);
			}
	  }		
	}	     
		 
</script>