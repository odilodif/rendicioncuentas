<%-- 
	version		: 1.0
    Document  	: Fmr_TrasparenciaInformacion
    Author		: Wilmer Guaman
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
		<h5>PROYECTO COMUNICACIONAL:</h5>
		
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblProyectoComunicacional" id="TblProyectoComunicacionalGuardar"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarProyecto" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">		
               <table class="table table-bordered" id="miTabla">
                       <thead>

								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;"></th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;"></th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row">
										<label for="lbl1" >TIENE PROYECTO COMUNICACIONAL	</label>
								    <input type="hidden" id="proNombre" name="proNombre" value="TIENE PROYECTO COMUNICACIONAL"></td>
									<td scope="row">
									<select
									class="custom-select custom-select-sm" id="proOpcion"
									name="proOpcion" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
										<div class="invalid-feedback">Por seleccione una opción</div></td>
									
									

								</tr>
							
								</tbody>	
							</table>
            
			</form:form>
			</div>
			
		</div>	
		<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>		
	</div>
</c:when>
<c:when test="${infestado=='matriz'}">

<div class="card-header text-white carHeaderBlue">
		<h5>PROYECTO COMUNICACIONAL:</h5>
	</div>
	<div class="card-body">
		<div class="row justify-content-center">
		   <div id="actualizar" class="">
			<div class="col-md-12 order-md-1" >
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="TblProyectoComunicacionalUpdate"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table registros table-bordered">
              
							<tr>
									<td scope="row" >
									<label id="pro_nombre" style="width: 250px"></label>
									</td>
									<td scope="row" style="width: 150px">
									<select
									class="custom-select custom-select-sm" id="pro_opcion"
									name="pro_opcion" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
										<div class="invalid-feedback">Por Ingrese el pasivo</div></td>
										
								
								</tr>
			    
            </table>
			</form:form>
			</div>
		
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="pro_codigo" name="pro_codigo">
	   </div>
	   
	 <div id="tabla" class="col-md-12 order-md-1">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
			
					<tr>
						<th >#</th>
						<th width="50%" style="text-align: center; font-size:x-small;"></th>
						<th width="10%" style="text-align: center; font-size:x-small;"></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	      <hr/>
		</div>
	</div>
	</div>
	
			
		</c:when>
		<c:when test="${infestadoinforme=='finalizado'}">
		<div class="card-header text-white carHeaderBlue">
		<h5>PROYECTO COMUNICACIONAL:</h5>
	</div>
		<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
				<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
						<th width="50%" style="text-align: center; font-size:x-small;"></th>
						<th width="10%" style="text-align: center; font-size:x-small;"></th>
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

$(document).ready(
		function() {
			 $("#actualizar").hide();
			 if ('${infestado}' == 'matriz'||'${infestadoinforme}' == 'finalizado') {
				tabla();			
			}
});
			
$("#btnGuardar").click(function(event) {
	var form = $("#TblProyectoComunicacionalGuardar");	
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje(
				"Por favor ingrese toda la información solicitada!",
				"ERROR");
	} else {
		$(".campo").removeAttr("disabled");
		ejecutarJson(form);
	}
	form.addClass('was-validated');
});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosProyectos", 
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
		paging:   false,
		info:     false,
		searching: false,
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
	    	{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
   		 	}},
   		 	{data : "proNombre"},
   			{data : "proOpcion"},
   		 	
   		 	/*{data : "contador" },
			{data : "proNombre"},
			{data : "proOpcion"},	*/
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             } return data;
    }}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.proCodigo);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var nombre = $(element).parent().parent().find("td:eq(1)").text();
		var opcion = $(element).parent().parent().find("td:eq(2)").text();
	  $("#actualizar").show();
	  $("#tabla").hide();	 	
		 $("#pro_codigo").val(codigo);
		 document.getElementById("pro_nombre").innerHTML=nombre;
		  cargarValorComboPorDefecto("pro_opcion",opcion);
	  
}
$("#btnActualizar").click(
		function(event) {
			var form = $("#TblProyectoComunicacionalUpdate")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
				 $(".campo").removeAttr("disabled");
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_proyecto_comunicacional',columns:columnas,values:valores,condicion:'pro_codigo',valorcondicion:$("#pro_codigo").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	



				
</script>
