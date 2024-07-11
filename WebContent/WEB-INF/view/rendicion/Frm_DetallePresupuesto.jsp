<%-- 
	version		: 1.0
    Document  	: Frm_DetallePresupuesto
    Created on	: 24/02/2021; 9:21:03
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
<div class="card mb-card20">
	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblProyPresupuestoParticipativo"
					id="ProyPresupuestoParticipativo" data-rutaAplicacion="rendicion"
					data-opcion="guardarProyPresupuestoParticipativo"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">DETALLE
						DEL PRESUPUESTO PARTICIPATIVO</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">
						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso" width="20%">DESCRIBA LOS PROGRAMAS
									Y PROYECTOS GENERADOS A PARTIR DE LA PRIORIZACIÓN PARTICIPATIVA
									DE LA INVERSIÓN</td>
								<td class="tablaingreso" width="15%">MONTO PLANIFICADO</td>
								<td class="tablaingreso" width="15%">MONTO EJECUTADO</td>
								<td class="tablaingreso" width="10%">% DE AVANCE DE LA
									IMPLEMENTACIÓN DEL PROGRAMA / PROYECTO</td>
									<td class="tablaingreso" width="20%">OBSERVACIONES</td>
								<td class="tablaingreso" width="20%">LINK AL MEDIO DE
									VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</td>
							</tr>
							<tr>
								<td scope="row"><textarea rows="2" cols=""
										class="form-control form-control-sm" id="proyDescripcion"
										required="required" name="proyDescripcion"
										placeholder="Ingrese el nombre lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
								</td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="proyMontoplan"
									name="proyMontoplan"placeholder="0.00"  
									required="required"  min="0" onkeypress="mascara(this,cpf)"  onpaste="return false"">
									<div class="invalid-feedback">Por favor ingrese el número
										de unidades</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="proyMontoejec"
									name="proyMontoejec" placeholder="0.00"  
									required="required" min="0" onkeypress="mascara(this,cpf)"  onpaste="return false"">
									<div class="invalid-feedback">Por favor ingrese el número
										de unidades</div></td>
								<td scope="row"><select
									class="custom-select custom-select-sm " id="proyPorcAvance"
									name="proyPorcAvance" required="required">
										<option value="">Seleccione...</option>
										<option value="0">0</option>
										<option value="1-25">1-25</option>
										<option value="25-50">25-50</option>
										<option value="51-75">51-75</option>
										<option value="76-100">76-100</option>
										
								</select>
									<div class="invalid-feedback">Por Ingrese los Resultados
										de Implementación</div></td>
								<td scope="row"><textarea rows="2" cols=""
										class="form-control form-control-sm" id="proyObs"
										required="required" name="proyObs"
										placeholder="Ingrese el nombre lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
								</td>
								
								<td scope="row"><input type="url"
									class="form-control form-control-sm campo url" id="proyLinks"
									name="proyLinks" required="required"
									placeholder="Dirección de página web" value="http://">
									<div class="invalid-feedback">Por favor ingrese su página
										web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardar"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
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
			<table id="TablaProyPresupuestoParticipativo"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th width="5%">#</th>
						<th width="25%">PROGRAMAS Y PROYECTOS GENERADOS A PARTIR DE LA PRIORIZACIÓN PARTICIPATIVA DE LA INVERSIÓN</th>
						<th width="10%">MONTO PLANIFICADO</th>
						<th width="10%">MONTO EJECUTADO</th>
						<th width="10%">% DE AVANCE DE LA IMPLEMENTACIÓN DEL PROGRAMA / PROYECTO</th>
						<th width="25%">OBSERVACIONES</th>
						<th width="10%">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
	
	$("#btnGuardar").click(function(event) {
		var form = $("#ProyPresupuestoParticipativo")
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
		$('#TablaProyPresupuestoParticipativo').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerProyPresupuestoParticipativo",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		columns : [			
			{data : "contador"},
			{data : "proyDescripcion"},
			{data : "proyMontoplan"}, 
			{data : "proyMontoejec"},
			{data : "proyPorcAvance"}, 
			{data : "proyObs"}, 
			{data : "proyLinks"}, 			
			{ data: "" ,"render": function (data, type, full, meta) {
				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
				data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
	             }
    			  return data;
              }}
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.proyCod);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', 'rendicion');
				//$(row).attr('data-opcion', 'Frm_MecanismosConstrolSocialActul');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_proy_presupuesto_participativo',campo:'proy_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaProyPresupuestoParticipativo tr").length-1;
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

/* 	function calculoMontoEjecutado(val) {
		var p = parseFloat($("#proyMontoplan").val().replace(/,/g, ""));
		var pe =parseFloat($("#proyMontoejec").val().replace(/,/g, ""));
		if (pe > p){
			mostrarMensaje("El monto ejectutado no puede superar al monto planificado!", "ERROR");
			$("#btnGuardar").attr("disabled", true);
		}else{
			$("#btnGuardar").attr("disabled", false);
		}
		} */

	
</script>