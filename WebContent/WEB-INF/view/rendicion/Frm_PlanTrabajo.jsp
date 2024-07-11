<%-- 
	version		: 1.0
    Document  	: Frm_PlanTrabajo
    Author		: wilmer Guaman
    Mail		: guamanw@gmail.com
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

<div class="card text-center mb-card15">
<c:choose>
	<c:when test="${infestado=='activo'}">
	<div class="card-header text-white carHeaderBlue">
		<h5>PLAN DE TRABAJO (OFERTA ELECTORAL)</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblPlanTrabajoGad" id="plantrabajo"
						data-rutaAplicacion="rendicion" data-opcion="guardarPlantrabajo"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS OBJETIVOS/ OFERTAS DEL PLAN DE TRABAJO</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS PROGRAMAS / PROYECTOS RELACIONADOS CON EL OBJETIVO DEL
										PLAN DE TRABAJO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">
										PORCENTAJE DE AVANCE</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS RESULTADOS ALCANZADOS</th>
								</tr>
								<tr>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm " id="ptgObjetivo"
											name="ptgObjetivo" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Objetivos</div></td>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm " id="ptgDescPrograma"
											name="ptgDescPrograma" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese el Programa</div></td>
									<td scope="row"><input type="text"
										class="form-control form-control-sm" id="ptgPorcAvance"
										name="ptgPorcAvance" required="required" onkeypress="javascript:return validardecimal(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm " id="ptgDescResultados"
											name="ptgDescResultados" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardarPlan"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
					<hr />
				</div>
				<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblPlanTrabajoGad" id="Actualizarplantrabajo"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">


						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS OBJETIVOS/ OFERTAS DEL PLAN DE TRABAJO</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS PROGRAMAS / PROYECTOS RELACIONADOS CON EL OBJETIVO DEL
										PLAN DE TRABAJO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">
										PORCENTAJE DE AVANCE</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DESCRIBA
										LOS RESULTADOS ALCANZADOS</th>
								</tr>
								<tr>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm " id="ptg_objetivo"
											name="ptg_objetivo" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Objetivos</div></td>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm " id="ptg_desc_programa"
											name="ptg_desc_programa" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese el Programa</div></td>
									<td scope="row"><input type="text"
										class="form-control form-control-sm" id="ptg_porc_avance"
										name="ptg_porc_avance" required="required" onkeypress="javascript:return validardecimal(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm "
											id="ptg_desc_resultados" name="ptg_desc_resultados"
											required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizarPlan"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="ptg_cod" name="ptg_cod">
				</div>
				<div id="tabla">
				<div class="row justify-content-center align-items-center">
	
		       <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
	            </div>
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>DESCRIBA LOS OBJETIVOS/ OFERTAS DEL PLAN DE TRABAJO</th>
								<th>DESCRIBA LOS PROGRAMAS / PROYECTOS RELACIONADOS CON EL
									OBJETIVO DEL PLAN DE TRABAJO</th>
								<th>PORCENTAJE DE AVANCE</th>
								<th>DESCRIBA LOS RESULTADOS ALCANZADOS</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
				</div>
			</div>
		</div>

	</div>
 </c:when>
 <c:when test="${infestado=='finalizado'}">
 <div class="card-header text-white carHeaderBlue">
		<h5>PLAN DE TRABAJO (OFERTA ELECTORAL)</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
 <input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
 <table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>DESCRIBA LOS OBJETIVOS/ OFERTAS DEL PLAN DE TRABAJO</th>
								<th>DESCRIBA LOS PROGRAMAS / PROYECTOS RELACIONADOS CON EL
									OBJETIVO DEL PLAN DE TRABAJO</th>
								<th>PORCENTAJE DE AVANCE</th>
								<th>DESCRIBA LOS RESULTADOS ALCANZADOS</th>
								<th></th>
								<th></th>
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
$(document).ready(function(){
	 $("#actualizar").hide();
	 if ('${infestado}' == 'activo'||'${infestado}' == 'finalizado') {
	 tabla();}
});
$("#btnNuevo").click(function(event) {
	 $('#tabla').hide();
	 $('#nuevo').show();
});	
function tabla() {
	var parametros = {
            "infCod" :$("#infCod").val()
        };
	$.ajax({
        url: "obtenerRegistrosPlan",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {
        	 if (result['Error']) {
                 $('#tabla').hide();
             }else if(result['data'].length!=0){
            	 $('#nuevo').hide();
        $('#tablaRegistros').DataTable( {   
        	
          order: [ 0, "asc" ],
	      responsive: true,
	      bDestroy : true,
			info : false,
			searching : false,
	      buttons: [
	      {extend: 'copyHtml5'},
          {extend: 'csvHtml5'},
          {extend: 'excelHtml5'},
    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
    {extend: 'print'},
    ],
    data: result.data,
    columns : [
		{data : "contador" },
		{data : "objetivo"},
		{data : "programa"},
		{data : "porcAvance"},
		{data : "resultados"},
		{ data: "" ,"render": function (data, type, full, meta) {
			   if('${infestado}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
		}
                return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	if('${infestado}' === "finalizado"){
       	 data = '';     
        }else{
    	data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
        }return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.ptgCod);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }else{
        	
        }
	 },
     error: function (errormessage) {
        // alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardarPlan").click(
				function(event) {
					var form = $("#plantrabajo")
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
		function Eliminar(element) {	
			var codigo = $(element).closest('tr').attr('id');	
			 $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_plan_trabajo_gad',campo:'ptg_cod'},
			        success: function (msg) {
			            if (msg.estado == "exito") {
	                             mostrarMensaje(msg.mensaje, "EXITO");
	                             var td = element.parentNode;
	                             var tr = td.parentNode;
	                             var table = tr.parentNode;      
	                             table.removeChild(tr);
	                             var nFilas = $("#tablaRegistros tr").length-1;
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
			var objetivo = $(element).parent().parent().find("td:eq(1)").text();
			var programa = $(element).parent().parent().find("td:eq(2)").text();
			var porcentage = $(element).parent().parent().find("td:eq(3)").text();
			var resultados = $(element).parent().parent().find("td:eq(4)").text();
			 $("#nuevo").hide();
			 $("#tabla").hide();
			  $("#actualizar").show();
			  $("#ptg_cod").val(codigo);
			  $("#ptg_objetivo").val(objetivo);
			  $("#ptg_desc_programa").val(programa);
			  $("#ptg_porc_avance").val(porcentage.replace(/,/g, "."));
			  
			  $("#ptg_desc_resultados").val(resultados);
		}
		$("#btnActualizarPlan").click(
				function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#Actualizarplantrabajo")
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
							    	if(field.name=="ptg_porc_avance"){
							    		field.value=field.value.replace(/,/g, ".");
							    	}
							    	valores+= field.value+ ',99';
							    	if (valores.length > 0) {
							    		valores = valores.substr(0, valores.length - 1);
			                        }
							    });
						  var data = {tabla: 'esq_rendicioncuentas.tbl_plan_trabajo_gad',columns:columnas,values:valores,condicion:'ptg_cod',valorcondicion:$("#ptg_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
	</script>
