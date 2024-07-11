<%-- 
	version		: 1.0
    Document  	: Frm_CoberturaNacional
    update      : Carlos morocho
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
	<c:choose>
	<c:when test="${inst_tip_des=='GAD'}">
	<div class="card-header text-white carHeaderBlue">
		<h5>COBERTURA GEOGRÁFICA INSTITUCIONAL:UNIDAD ADMINISTRATIVA FINANCIERA</h5>
	</div>
	</c:when>
	<c:otherwise>
	<div class="card-header text-white carHeaderBlue">
		<h5>COBERTURA GEOGRÁFICA NACIONAL: UNIDAD DE ADMINISTRACIÓN FINANCIERA</h5>
	</div>		
	</c:otherwise>	
	</c:choose>
	
	<div class="card-body">
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
					
					 <c:choose>
	                <c:when test="${Tipo_Formulario=='1'}">
	           	  <td scope="row">
						<select class="custom-select custom-select-sm" id="cnCobertura"
												name="cnCobertura" required="required">
												<option value="">Seleccione...</option>
												<option value="PROVINCIAL">PROVINCIAL</option>
												<option value="CANTONAL">CANTONAL</option>
												<option value="PARROQUIAL" >PARROQUIAL</option>
											</select>
											
					</td>
						
					<input type="hidden" id="tipo" name="tipo" value="GAD" maxlength="10">
							 
										
					</c:when>
					<c:otherwise>
				 <td scope="row">
						<select class="custom-select custom-select-sm" id="cnCobertura"
												name="cnCobertura" required="required">
												<option value="">Seleccione...</option>
												<option value="NACIONAL">NACIONAL</option>
												<option value="ZONAL">ZONAL</option>
												<option value="REGIONAL">REGIONAL</option>
												<option value="PROVINCIAL">PROVINCIAL</option>
												<option value="DISTRITAL">DISTRITAL</option>
												<option value="CIRCUITAL"> CIRCUITAL </option> 
											</select>
											
					</td>
												<input type="hidden" id="tipo" name="tipo" value="UDAF">
				
				
									
					</c:otherwise>
					</c:choose> 
					
						<td scope="row" >
												<input type="text" onkeypress="javascript:return validarnroEntero(event);" maxlength="9" class="form-control form-control-sm"
													id="cnUnidades" name="cnUnidades" placeholder="000"
													 required="required" min="0" 
													pattern="^[0-9]+">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											
					
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
			<table id="TablaCoberturaNacional"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th style="font-size: xx-small;">N°</th>
						<th style="font-size: xx-small;">COBERTURA</th>
						<th style="font-size: xx-small;">NO. DE UNIDADES</th>
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

$(document).ready(function() {

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

			
$("#btnGuardar").click(
				function(event) {
					$('#cncod').attr('data-opcion',	'guardarCobertura');
					var form = $("#cncod")
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
	var parametros = {"infCod" : '${infCod}',"TipoFormulario" : '${Tipo_Formulario}'};
	$('#TablaCoberturaNacional').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerCoberturasNacionales",
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
		{data: "" ,"render": function (data, type, full, meta) {
			 return  meta.row + 1;
		 }},
		{data : "cobertura"},
		{data : "unidades"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			
             if('${infestadoinforme}' === "finalizado"){
            	 data = '';     
             }else{
            	 data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Eliminar</button>';     
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_cobertura_nacional',campo:'cn_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaCoberturaNacional tr").length-1;
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
