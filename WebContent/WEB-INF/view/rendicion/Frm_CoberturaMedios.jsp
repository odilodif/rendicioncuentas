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
		<h5>COBERTURA GEOGRÁFICA INSTITUCIONAL:</h5>
	</div>
	<div class="card-body">
		
<!-- 		<div id="Mensaje"> -->
<!-- 		<div class="alert alert-primary" role="alert">COBERTURA TERRITORIAL INSTITUCIONAL(En el caso de contar con entidades operativas desconsentradas que manejen fondos): -->
<!-- </div> -->
<!-- 		</div> -->
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblCoberturaNacional" id="cncod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarCobertura" data-accionEnExito="ACTUALIZAR">		
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="50%">COBERTURA</th>
					<th class="tablaingreso" width="50%">NO. DE UNIDADES</th>
					</tr>
					<tr>
	                <td scope="row">
						<select class="custom-select custom-select-sm" id="cnCobertura"
												name="cnCobertura" required="required">
												<option value="">Seleccione...</option>
												<option value="NACIONALES">NACIONALES</option>
												<option value="REGIONALES">REGIONALES</option>
												<option value="LOCALES">LOCALES</option>
											</select>
												<input type="hidden" id="tipo" name="tipo" value="MDC">
					</td>			
					
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="cnUnidades" name="cnUnidades" placeholder="000"
													maxlength="20" required="required" min="0"
													pattern="^[0-9]+" onkeypress="javascript:return validarnro(event);">
												<div class="invalid-feedback">Por favor ingrese el número de unidades</div>
											
					
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
</c:when>
<c:when test="${infestado=='matriz'}">
 <div id="actualizar">
 <div class="card-body">
		
<!-- 		<div id="Mensaje"> -->
<!-- 		<div class="alert alert-primary" role="alert">COBERTURA TERRITORIAL INSTITUCIONAL(En el caso de contar con entidades operativas desconsentradas que manejen fondos): -->
<!-- </div> -->
<!-- 		</div> -->
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosMedio" id="Tblmediosupdate"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
						       
                <table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="50%">COBERTURA</th>
					<th class="tablaingreso" width="50%">NO. DE UNIDADES</th>
					</tr>
					<tr>
	                <td scope="row">
						<select class="custom-select custom-select-sm" id="cn_cobertura"
												name="cn_cobertura" required="required">
												<option value="">Seleccione...</option>
												<option value="NACIONALES">NACIONALES</option>
												<option value="REGIONALES">REGIONALES</option>
												<option value="LOCALES">LOCALES</option>
											</select>
					</td>			
					
						<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="cn_unidades" name="cn_unidades" placeholder="000"
													maxlength="20" required="required" min="0"
													pattern="^[0-9]+" onkeypress="javascript:return validarnro(event);" >
												<div class="invalid-feedback">Por favor ingrese el número de unidades</div>
											
					
						</td>
					</tr>
					</table>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="cn_cod" name="cn_cod">
	</div>
 
 </div>
<div id="tabla">
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
			<table id="TablaRegistro"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
					<th>#</th>
						<th>COBERTURA</th>
						<th>NO. DE UNIDADES</th>
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
});
			
$("#btnGuardar")
		.click(
				function(event) {
					var form = $("#cncod");
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
			var form = $("#Tblmediosupdate")
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_cobertura_nacional',columns:columnas,values:valores,condicion:'cn_cod',valorcondicion:$("#cn_cod").val()};
				  
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	
function tabla() {
	var parametros = {"infCod" : '${infCod}',"TipoFormulario" : '${Tipo_Formulario}'};
	$('#TablaRegistro').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerCoberturasNacionalesMedios",
	headers : {"X-CSRF-TOKEN" : csrfToken},
	type : "POST"	},
	order : [ 0, "asc" ],	
	searching: false,
	columns : [
    	{data: "" ,"render": function (data, type, full, meta) {
			 return  meta.row + 1;
		 	}},
		{data : "cnCobertura"},
		{data : "cnUnidades"},
		/*{data : "contador"},
		{data : "cobertura"},
		{data : "unidades"}, */
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
			
			$(row).attr('id', data.cnCod);
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
	
	var tipo = $(element).parent().parent().find("td:eq(1)").text();
	var numero = $(element).parent().parent().find("td:eq(2)").text();
	 $("#tabla").hide();
	  $("#actualizar").show();
	  $("#cn_cod").val(codigo);
	  cargarValorComboPorDefecto("cn_cobertura",tipo);
	  $("#cn_unidades").val(numero);
}
function Eliminar(element) {	
	var codigo = $(element).closest('tr').attr('id');	
	 $.ajax({
	        url: 'view/rendicion/eliminarDatos',
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        type: "POST",
	        dataType: 'json',
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_cobertura_nacional',campo:'cn_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaRegistro tr").length-1;
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
