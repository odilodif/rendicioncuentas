<%-- 
	version		: 1.0
    Document  	: Frm_CoberturaNacional

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

<div class="card text-center mb-card15">
	<c:choose>
	<c:when test="${infestado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>COBERTURA TERRITORIAL INSTITUCIONAL</h5>
	</div>
	<div class="card-body">
		
		<div id="Mensaje">
		<div class="alert alert-primary" role="alert">En caso de contar con Entidades Operativas Desconcentradas / Entidades Vinculadas que manejan fondos públicos</div>
		</div>
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblCoberturaInstitucional" id="ciCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarCoberturaInstitucional" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					
	   <tr>
        <th colspan="2"></th>
       </tr>
					
					<tr>
					<th class="tablaingreso" width="50%">Nombre de la institución / entidad (Máximo 200 Caracteres)</th>
					<th class="tablaingreso" width="50%">Cobertura geográfica: (de la institución / entidad UDAF y de cada una de sus EOD)
(Máximo 200 Caracteres)</th>
					<tr>
					<td scope="row">
						
					
					
									<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ciNombre" required="required"
										name="ciNombre"
										placeholder="Ingrese el nombre lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
					
					</td>
						<td scope="row">
								<textarea rows="2" cols="" class="form-control form-control-sm"
										id="ciDetalle" required="required"
										name="ciDetalle"
										placeholder="Ingrese el detalle lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
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
			
			<table>
				<tr>
				<th><p style="color:white;">.</p>
				</th>
				</tr>
			</table>
			<div id="Mensaje">
					<div class="alert alert-primary" role="alert">En caso de contar con Entidades Operativas Desconcentradas / Entidades Vinculadas que manejan fondos públicos	</div>
					</div>
			
			<table id="TablaCoberturaTerritorial"
				class="table table-striped table-bordered" style="width: 100%">
				<thead style="background-color: rgb(31, 137, 72);">
					 <tr>
      				  	<th colspan="4" style="font-size: xx-small;"><p style="color:white;" >COBERTURA TERRITORIAL INSTITUCIONAL </p></th>
     				  </tr>
					<tr>
						<th style="font-size: xx-small;">#</th>
						<th style="font-size: xx-small;">NOMBRE</th>
						<th style="font-size: xx-small;">COBERTURA GEOGRÁFICA</th>
						<th style="font-size: xx-small;"> </th>
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

$(document).ready(
		function() {

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
					$('#ciCod').attr('data-opcion',	'guardarCoberturaInstitucional');
					var form = $("#ciCod")
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
	
	$('#TablaCoberturaTerritorial').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerCoberturasTerritoriales",
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
		{data : "nombre"},
		{data : "cobertura"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor  btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Eliminar</button>';
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
			$(row).find("td").css({
				"font-size"   : "x-small",			
			});	

			$(row).find("td").css({
				"vertical-align" : "middle",
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_cobertura_institucional',campo:'ci_cod'},
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
