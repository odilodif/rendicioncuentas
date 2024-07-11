<%-- 
	version		: 1.0
    Document  	: Fmr_DatosMedios
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
		<h5>DATOS DEL MEDIO:</h5>
	</div>
	<div class="card-body">

		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosMedio" id="TblDatosMedioid"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarDatosMedio" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
		       
                <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia">FRECUENCIA (S) DEL ESPECTRO RADIOELÉCTRICO (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmFrecuencia" name="dmFrecuencia" required="required"></textarea>
								    <div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
				</div>
                
                    <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">NÚMERO DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dmNumrepetidoras" name="dmNumrepetidoras" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">UBICACIÓN DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmUbicrepetidoras" name="dmUbicrepetidoras" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">FECHA DE OTORGAMIENTO DE LA CONCESIÓN/ CREACIÓN DEL MEDIO IMPRESO:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dmFechinicioconcesion"
															name="dmFechinicioconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
                 <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia"> FECHA DE VENCIMIENTO DE LA CONCESIÓN:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dmFechfinconcesion"
															name="dmFechfinconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
            <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> NÚMERO DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dmNumscursales" name="dmNumscursales" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
            </div>
             <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> UBICACIÓN DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmUbicsucursales" name="dmUbicsucursales" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
               <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> DETALLAR LOS PRODUCTOS IMPRESOS (REVISTAS, PERIÓDICOS):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dmProductos" name="dmProductos" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
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
 <div id="actualizar">
 <div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosMedio" id="TblDatosupdate"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
						       
                <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia">FRECUENCIA (S) DEL ESPECTRO RADIOELÉCTRICO (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dm_frecuencia" name="dm_frecuencia" required="required"></textarea>
								    <div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
				</div>
                
                    <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">NÚMERO DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dm_numrepetidoras" name="dm_numrepetidoras" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">UBICACIÓN DE REPETIDORAS (RADIO/TV):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dm_ubicrepetidoras" name="dm_ubicrepetidoras" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
                    </div>
                      <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia">FECHA DE OTORGAMIENTO DE LA CONCESIÓN/ CREACIÓN DEL MEDIO IMPRESO:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dm_fechinicioconcesion"
															name="dm_fechinicioconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
                 <div class="form-group row">
                    <div class="col-md-3 text-left">
									<label for="parroquia"> FECHA DE VENCIMIENTO DE LA CONCESIÓN:</label>
								</div>
								<div class="col-md-3  text-left">
									 <div class="input-group date">
														<span class="input-group-addon"><i
															class="fa fa-calendar"></i> </span> <input type="text" 
															required="required" id="dm_fechfinconcesion"
															name="dm_fechfinconcesion"
															class="form-control form-control-sm" value=""
															maxlength="10"
															pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
														<div class="invalid-feedback">Por favor ingrese la fecha de designación
															con formato dd/mm/aaaa</div>
													</div>
								</div>
                    </div>
            <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> NÚMERO DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="dm_numscursales" name="dm_numscursales" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								</div>
            </div>
             <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> UBICACIÓN DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dm_ubicsucursales" name="dm_ubicsucursales" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
               <div class="form-group row">
              <div class="col-md-3 text-left">
									<label for="parroquia"> DETALLAR LOS PRODUCTOS IMPRESOS (REVISTAS, PERIÓDICOS):</label>
								</div>
								<div class="col-md-4  text-left">
									 <textarea rows="1" class="form-control form-control-sm case" id="dm_productos" name="dm_productos" required="required"></textarea>
						<div class="invalid-feedback">Por favor Ingrese el N° de informe de la entidad que recomienda</div>
								</div>
            </div>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="dm_cod" name="dm_cod">
	</div>
 
 </div>
<div id="tabla" class="table-responsive">
<div class="row justify-content-center align-items-center">
				
				<c:choose>
							<c:when test="${infestadoinforme=='finalizado'}">
							
									</c:when>
									<c:when test="${infestadoinforme=='activo'}">
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
				</c:when>
									</c:choose>
			</div>
		
			<table id="TablaCoberturaTerritorial"
				class="table table-striped table-bordered "  style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="3">DATOS DEL MEDIO:</th>
     				  </tr>
					<tr>
						<th>#</th>
						<th  style="font-size:x-small;">FRECUENCIA (S) DEL ESPECTRO RADIOELÉCTRICO (RADIO/TV)</th>
						<th  style="font-size:x-small;">NÚMERO DE REPETIDORAS (RADIO/TV)</th>
						<th  style="font-size:x-small;">UBICACIÓN DE REPETIDORAS (RADIO/TV)</th>
						<th  style="font-size:x-small;">FECHA DE OTORGAMIENTO DE LA CONCESIÓN/ CREACIÓN DEL MEDIO IMPRESO</th>
						<th  style="font-size:x-small;">FECHA DE VENCIMIENTO DE LA CONCESIÓN</th>
						<th  style="font-size:x-small;">NÚMERO DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES)</th>
						<th  style="font-size:x-small;">UBICACIÓN DE SUCURSALES O AGENCIAS (MEDIOS IMPRESOS Y DIGITALES)</th>
						<th  style="font-size:x-small;">DETALLAR LOS PRODUCTOS IMPRESOS (REVISTAS, PERIÓDICOS)</th>
						<th> </th>
						<th> </th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
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
			if ('${infestado}' == 'matriz') {
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
			$('#dmFechinicioconcesion').datepicker();
			$('#dmFechfinconcesion').datepicker();
			$('#dm_fechinicioconcesion').datepicker();
			$('#dm_fechfinconcesion').datepicker();
			
});
			
$("#btnGuardar")
		.click(
				function(event) {
					var form = $("#TblDatosMedioid")
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
$("#btnActualizar").click(
		function(event) {
			var form = $("#TblDatosupdate")
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_datos_medio',columns:columnas,values:valores,condicion:'dm_cod',valorcondicion:$("#dm_cod").val()};
				  
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	
function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaCoberturaTerritorial').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerDatosMedio",
	headers : {"X-CSRF-TOKEN" : csrfToken},
	type : "POST"	},
	order : [ 0, "asc" ],
	responsive: true,
	searching: false,
	columns : [
    	{data: "" ,"render": function (data, type, full, meta) {
			 return  meta.row + 1;
		 	}},
		{data : "dmFrecuencia"},
		{data : "dmNumrepetidoras"}, 
		{data : "dmUbicrepetidoras"}, 
		{data : "dmFechinicioconcesion"}, 
		{data : "dmFechfinconcesion"}, 
		{data : "dmNumscursales"}, 
		{data : "dmUbicsucursales"}, 
		{data : "dmProductos"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
            data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';
            }    
    return data;
        }},
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';
            }    
    return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.dmCod);
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap",				
			});
			
	
		},	
		
	});

}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	var frecuencia = $(element).parent().parent().find("td:eq(1)").text();
	var repetidoras = $(element).parent().parent().find("td:eq(2)").text();
	var ubicacionrep = $(element).parent().parent().find("td:eq(3)").text();
	var fechainicio = $(element).parent().parent().find("td:eq(4)").text();
	var fechafin = $(element).parent().parent().find("td:eq(5)").text();
	var sucursale = $(element).parent().parent().find("td:eq(6)").text();
	var ubsucursales = $(element).parent().parent().find("td:eq(7)").text();
	var productos = $(element).parent().parent().find("td:eq(8)").text();
	 $("#tabla").hide();
	  $("#actualizar").show();
	  $("#dm_cod").val(codigo);
	  $("#dm_frecuencia").val(frecuencia);
	  $("#dm_numrepetidoras").val(repetidoras);
	  $("#dm_ubicrepetidoras").val(ubicacionrep);
	  $("#dm_fechinicioconcesion").val(fechainicio);
	  $("#dm_fechfinconcesion").val(fechafin);
	  $("#dm_numscursales").val(sucursale);
	  $("#dm_ubicsucursales").val(ubsucursales);
	  $("#dm_productos").val(productos);
}

function Eliminar(element) {	
	var codigo = $(element).closest('tr').attr('id');	
	 $.ajax({
	        url: 'view/rendicion/eliminarDatos',
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        type: "POST",
	        dataType: 'json',
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_datos_medio',campo:'dm_cod'},
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
 
				
</script>
