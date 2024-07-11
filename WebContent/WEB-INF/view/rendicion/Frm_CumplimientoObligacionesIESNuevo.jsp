<%-- 
	version		: 1.0
    Document  	: Frm_CumplimientoObligaciones
    Created on	: 22 mar. 2021; 16:16:38
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

<div class="card  mb-card15">
<c:choose>
	<c:when test="${inf_estado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>CUMPLIMIENTO DE OBLIGACIONES INTERNAS INSTITUCIONES DE EDUCACIÓN SUPERIOR</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblObligacionesEducacion" id="ObligacionesEducacion"
						data-rutaAplicacion="rendicion" data-opcion="guardarCumplimientoObligacionesIES"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${inf_Cod}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">OBLIGACIONES</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PONGA SÍ O NO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">ACCIONES REALIZADAS </th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PRINCIPALES RESULTADOS </th>
								</tr>
								<tr>
									 	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm avance" id="oeObligacion" name="oeObligacion" required="required" >
												<option value="">Seleccione...</option>
												<option value="PROCESOS ELECTORALES INTERNOS">PROCESOS ELECTORALES INTERNOS</option>
												<option value="SERVICIOS PARA LA COMUNIDAD EN PRÁCTICAS PRE-PROFESIONALES">SERVICIOS PARA LA COMUNIDAD EN PRÁCTICAS PRE-PROFESIONALES</option>
												<option value="PROCESOS DE AUTOEVALUACIÓN">PROCESOS DE AUTOEVALUACIÓN</option>
												<option value="PROGRAMAS VINCULADOS CON LA SOCIEDAD">PROGRAMAS VINCULADOS CON LA SOCIEDAD</option>
												<option value="CONCURSOS PÚBLICOS DE MÉRITOS Y OPOSICIÓN PARA PROFESORES">CONCURSOS PÚBLICOS DE MÉRITOS Y OPOSICIÓN PARA PROFESORES</option>
												<option value="RÉGIMEN DISCIPLINARIO">RÉGIMEN DISCIPLINARIO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm " id="oeCumple"  onchange="validar(this)" name="oeCumple" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								   	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									<textarea rows="3" cols=""
											class="form-control form-control-sm nombre" id="oeAcciones"
											name="oeAcciones" required="required"></textarea>
										<div class="invalid-feedback">Por ingrese las acciones realizadas</div>
									</td>
								    <td scope="row" style="vertical-align: middle; font-size: x-small;">
								    <textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="oeResultados"
											name="oeResultados" required="required"></textarea>
										<div class="invalid-feedback">Por ingrese los resultados</div>
								    </td>
									

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				
	
				</div>
		</div>

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
 
 
			<div id="nuevo">
	<div class="card-header text-white carHeaderBlue">
		<h5>INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR EN LA GESTIÓN INSTITUCIONAL</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
						<input type="hidden" id="infCod" name="infCod"
							value="${inf_Cod}">
						
				<table id="TablaObligacionesEducacion"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>			<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">#</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">OBLIGACIONES</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PONGA SÍ O NO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">ACCIONES REALIZADAS </th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PRINCIPALES RESULTADOS </th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;"></th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;"></th>
					</tr>
				</thead>
					<tbody>
					</tbody>				
				</table>
			</div>
		</div>

	</div>
	</div>
	<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="tbl_obligaciones_educacion" id="ObligacionesEducacionActul"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<div class="table-responsive-xl">
						<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">OBLIGACIONES</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PONGA SÍ O NO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">ACCIONES REALIZADAS </th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PRINCIPALES RESULTADOS </th>
								</tr>
								<tr>
									 	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm avance" id="oe_obligacion" name="oe_obligacion" required="required" >
												<option value="">Seleccione...</option>
												<option value="PROCESOS ELECTORALES INTERNOS">PROCESOS ELECTORALES INTERNOS</option>
												<option value="SERVICIOS PARA LA COMUNIDAD EN PRÁCTICAS PRE-PROFESIONALES">SERVICIOS PARA LA COMUNIDAD EN PRÁCTICAS PRE-PROFESIONALES</option>
												<option value="PROCESOS DE AUTOEVALUACIÓN">PROCESOS DE AUTOEVALUACIÓN</option>
												<option value="PROGRAMAS VINCULADOS CON LA SOCIEDAD">PROGRAMAS VINCULADOS CON LA SOCIEDAD</option>
												<option value="CONCURSOS PÚBLICOS DE MÉRITOS Y OPOSICIÓN PARA PROFESORES">CONCURSOS PÚBLICOS DE MÉRITOS Y OPOSICIÓN PARA PROFESORES</option>
												<option value="RÉGIMEN DISCIPLINARIO">RÉGIMEN DISCIPLINARIO</option>
												
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm " id="oe_cumple"  onchange="validar(this)" name="oe_cumple" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								   	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									<textarea rows="3" cols=""
											class="form-control form-control-sm nombre" id="oe_acciones"
											name="oe_acciones" required="required"></textarea>
										<div class="invalid-feedback">Por ingrese las acciones realizadas</div>
									</td>
								    <td scope="row" style="vertical-align: middle; font-size: x-small;">
								    <textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="oe_resultados"
											name="oe_resultados" required="required"></textarea>
										<div class="invalid-feedback">Por ingrese los resultados</div>
								    </td>
									

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="oe_cod" name="oe_cod">
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
	 $("#nuevo").show();
	 if ('${inf_estado}' == 'matriz') {
	 tabla();
	 }
});

function tabla() {
	var parametros = {"infCod" : '${inf_Cod}'};
	$.ajax({
        url: "obtenerCumplimientoObligacionesIES",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {
        	 if (result['Error']) {
                 $('#tabla').hide();
             }{
        $('#TablaObligacionesEducacion').DataTable( {   
        	
          order: [ 0, "asc" ],
	     dom: '<"html5buttons"B>lTfgitp',
	     paging:   false,
			info:     false,
			searching: false,
			responsive: true,
			scrollX: true,
	      buttons: [   ],
    data: result.data,
    columns : [
		{data : "contador" },
		{data : "obligacion"},
		{data : "cumple"},
		{data : "acciones"},
		{data : "resultado"},
		{ data: "" ,"render": function (data, type, full, meta) {
			 if('${infestado}' === "finalizado"){
            	 data = '';     
             }else{
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
             }return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	 if('${infestado}' === "finalizado"){
        	 data = '';     
         }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
         } return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	   $(row).attr('id', data.oe_cod);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }
	 },
     error: function (errormessage) {
         alert(errormessage.responseText);
     }
 });
}


$("#btnGuardar").click(function(event) {
	var form = $("#ObligacionesEducacion")
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje(
				"Por favor ingrese toda la información solicitada!",
				"ERROR");
	} else {
		$(".nombre").removeAttr("disabled");
		$(".campo").removeAttr("disabled");
		$(".avance").removeAttr("disabled");
		$(".url").removeAttr("disabled");
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_obligaciones_educacion',campo:'oe_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                            mostrarMensaje(msg.mensaje, "EXITO");
                            var td = element.parentNode;
                            var tr = td.parentNode;
                            var table = tr.parentNode;      
                            table.removeChild(tr);
                            var nFilas = $("#TablaObligacionesEducacion tr").length-1;
                            if (nFilas==0){ 
                             	 abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
                        		  $("#nuevo").show();
                     
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


$("#btnActualizar").click(function(event) {
			var form = $("#ObligacionesEducacionActul")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
				$(".nombre").removeAttr("disabled");
				$(".campo").removeAttr("disabled");
				$(".avance").removeAttr("disabled");
				$(".url").removeAttr("disabled");
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_obligaciones_educacion',columns:columnas,values:valores,condicion:'oe_cod',valorcondicion:$("#oe_cod").val()};
				  
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	

function Modificar(element) {	

	var codigo = $(element).closest('tr').attr('id');
	var nombre = $(element).parent().parent().find("td:eq(1)").text();
	var implemento = $(element).parent().parent().find("td:eq(2)").text();
	var avance = $(element).parent().parent().find("td:eq(3)").text();
	var descripcion = $(element).parent().parent().find("td:eq(4)").text();
	  $("#nuevo").hide();
	  $("#tabla").hide();
	  $("#botones").hide();
	  $("#actualizar").show();

	  $("#oe_cod").val(codigo);
	  $("#oe_obligacion").val(nombre);
	  $("#oe_cumple").val(implemento);
	  $("#oe_acciones").val(avance);	
	  $("#oe_resultados").val(descripcion);		  
	
	  
	  if ($(element).val() === "SI"){
			 $("#oeAcciones").removeAttr('disabled');
			 $("#oeAcciones").prop("required", true);
			 $("#oeAcciones").val("");
			
			 $("#oeResultados").removeAttr('disabled');
			 $("#oeResultados").prop("required", true);
			 $("#oeResultados").val("");
			 $("#oeObligacion").removeAttr('disabled');
			$("#oeObligacion").prop("required", true);
			 $("#oeObligacion").val("");
			
		}else if($(element).val() === "NO"){
		    $("#oeObligacion").removeAttr('required');
			$("#oeObligacion").prop("disabled", "disabled");
			$("#oeObligacion").val("N/A");

			 $("#oeAcciones").removeAttr('required');
			$("#oeAcciones").prop("disabled", "disabled");
			$("#oeAcciones").val("N/A");

			 $("#oeResultados").removeAttr('required');
				$("#oeResultados").prop("disabled", "disabled");
				$("#oeResultados").val("N/A");
		
		}else{
			 $("#oeAcciones").removeAttr('disabled');
			 $("#oeAcciones").prop("required", true);
			 $("#oeAcciones").val("");
			 $("#oeResultados").removeAttr('disabled');
			 $("#oeResultados").prop("required", true);
			 $("#oeResultados").val("");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
}

function validar(elemento) {
	
	if ($(elemento).val() === "SI"){
		 $("#oeAcciones").removeAttr('disabled');
		 $("#oeAcciones").prop("required", true);
		 $("#oeAcciones").val("");
		
		 $("#oeResultados").removeAttr('disabled');
		 $("#oeResultados").prop("required", true);
		 $("#oeResultados").val("");
		 $("#oeObligacion").removeAttr('disabled');
		$("#oeObligacion").prop("required", true);
		 $("#oeObligacion").val("");
		
	}else if($(elemento).val() === "NO"){
	
		$("#oeObligacion").removeAttr('disabled');
		$("#oeObligacion").prop("required", true);
		// $("#oeObligacion").val("");

		 $("#oeAcciones").removeAttr('required');
		$("#oeAcciones").prop("disabled", "disabled");
		$("#oeAcciones").val("N/A");

		 $("#oeResultados").removeAttr('required');
			$("#oeResultados").prop("disabled", "disabled");
			$("#oeResultados").val("N/A");
	
	}else{
		 $("#oeAcciones").removeAttr('disabled');
		 $("#oeAcciones").prop("required", true);
		 $("#oeAcciones").val("");
		 $("#oeResultados").removeAttr('disabled');
		 $("#oeResultados").prop("required", true);
		 $("#oeResultados").val("");
		mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
}


	</script>
