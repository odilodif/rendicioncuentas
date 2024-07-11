<%-- 
	version		: 1.0
    Document  	: Frm_GAD_ObjetivoPlanDesarrollo
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


	<c:choose>
	<c:when test="${inf_estado=='activo'}">
	<div class="card text-center mb-card15">
	<div class="card-header text-white carHeaderBlue">
		<h5>OBJETIVOS DEL PLAN DE DESARROLLO Y ORDENAMIENTO TERRITORIAL DE SU TERRITORIO</h5>
	</div>
	
	<div id="Mensaje">
		<div class="alert alert-primary" role="alert">En esta matriz debe ingresar todos los objetivos del Plan de Desarrollo y Ordenamiento Territorial, de uno en uno</div>
		</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblObjetivosPlanDesarrollo" id="ObjetivosPlan"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarObjetivosPlan" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					
	   <tr>
        <th>DESCRIBA EL OBJETIVO DE SU PLAN DE DESARROLLO TERRITORIAL:</th>
       </tr>
					
					<tr>
					<th class="tablaObjetivo">OBJETIVO</th>
					<tr>
					<td scope="row">
						
					
					
									<textarea rows="2" cols="" class="form-control form-control-sm"
										id="obj_nombre" required="required"
										name="objNombre"
										placeholder="Ingrese el objetivo lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
					
					</td>
					
					</tr>
					</table>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>
	</div>
	
	</div>
</c:when>
<c:when test="${inf_estado=='matriz'}">
<div id="ActualizarDatosObjetivo">
<div class="card text-center mb-card15">
	<div class="card-header text-white carHeaderBlue">
		<h5>OBJETIVOS DEL PLAN DE DESARROLLO Y ORDENAMIENTO TERRITORIAL DE SU TERRITORIO</h5>
	</div>
	<div id="Mensaje">
		<div class="alert alert-primary" role="alert">En esta matriz debe ingresar todos los objetivos del Plan de Desarrollo y Ordenamiento Territorial, de uno en uno</div>
		</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblObjetivosPlanDesarrollo" id="ObjetivosPlan"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table registros table-bordered">
	   <tr>
        <th>DESCRIBA EL OBJETIVO DE SU PLAN DE DESARROLLO TERRITORIAL:</th>
       </tr>
					
					<tr>
					<th class="tablaObjetivo">OBJETIVO</th>
					<tr>
					<td scope="row">
									<textarea rows="2" cols="" class="form-control form-control-sm"
										id="obj_nombre" required="required"
										name="obj_nombre"
										placeholder="Ingrese el objetivo lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
					</td>
					</tr>
					</table>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
							<button type="submit" id="btnActualziarObjetivo"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
						<input type="hidden" id="obj_cod" name="obj_cod">	</div>
	</div>
</div>

<div id="DatosObjetivo">
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
		
		
		<table>
				<tr>
				<th><p style="color:white;">.</p>
				</th>
				</tr>
			</table>
			<div id="Mensaje">
					<div class="alert alert-primary" role="alert">En esta matriz debe ingresar todos los objetivos del Plan de Desarrollo y Ordenamiento Territorial, de uno en uno	</div>
					</div>
			<table id="TablaObjetivosPlan"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  		
     				  </tr>
					<tr>
						<th style="font-size: xx-small;" >#</th>
						<th  style="font-size: xx-small;">OBJETIVOS DEL PLAN DE DESARROLLO DE SU TERRITORIO</th>
						<th  style="font-size: xx-small;"> </th>
						<th  style="font-size: xx-small;"> </th>
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

</html>

<script type="text/javascript">


$(document).ready(
		function() {

			if ('${inf_estado}' == 'matriz') {
				tabla();			
			}

			$("#DatosObjetivo").show();
			$("#ActualizarDatosObjetivo").hide();

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
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#ObjetivosPlan').attr('data-opcion',	'guardarObjetivosPlan');
					var form = $("#ObjetivosPlan")
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

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaObjetivosPlan').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerObjetivosPlan",
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
		{data : "objetivo"},
		{ data: "" ,"render": function (data, type, full, meta) {
			   if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
    				 data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';    
		}
             return data;
 		}},
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{                
	         if(full.avances=="0" &&  full.ejecucionesProgramaticas=="0" ){
	        	 data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"  style="text-align: center; font-size: x-small;"> Eliminar</button>';
		         }else{
		        	 data = '';   
			         }
            }
      
    return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.impleCod);
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
			$(row).find("td").css({
				"font-size"   : "x-small",			
			});	

			$(row).find("td").css({
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_objetivos_plan_desarrollo',campo:'obj_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaObjetivosPlan tr").length-2;

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
	$("#DatosObjetivo").hide();
	$("#ActualizarDatosObjetivo").show();
	$("#obj_cod").val(codigo);
	$("#obj_nombre").val(objetivo);
}

$("#btnActualziarObjetivo").click(
		function(event) {
		//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
			var form = $("#ObjetivosPlan")
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_objetivos_plan_desarrollo',columns:columnas,values:valores,condicion:'obj_cod',valorcondicion:$("#obj_cod").val()};
				  
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	 
</script>
