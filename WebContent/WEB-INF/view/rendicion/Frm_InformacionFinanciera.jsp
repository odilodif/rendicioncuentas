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
		<h5>INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN):</h5>
		
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblInformacionFinanciera" id="TblInformacionFinancieraGuardar"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarInformacionFinanciera" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">		
               <table class="table table-bordered" id="miTabla">
                       <thead>
                       <tr>
				    <th style="background-color: #1f8948;color: white;" colspan="6">BALANCE GENERAL</th>
				    </tr>
								<tr>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">ACTIVO</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">PASIVO</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">PATRIMONIO</th>
										<th scope="col" class="tablaingreso" width="40%"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row">
										<input type="text" class="form-control form-control-sm campo valor"  id="infActivos" name="infActivos" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)" 
											 onpaste="return false" onchange="verificaActivo(this.value)"/>
										<div class="invalid-feedback">Por Ingrese el activo</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="infPasivos" name="infPasivos" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)" 
										 onpaste="return false" onchange="calculoPasivo(this.value)" /> 
										<div class="invalid-feedback">Por Ingrese el pasivo</div></td>
										<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="infPatrimonio" name="infPatrimonio" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  
									onpaste="return false"/>
										<div class="invalid-feedback">Por Ingrese el patrimonio</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="infLinkbalance" name="infLinkbalance" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

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
		<h5>INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN):</h5>
	</div>
		   <div id="actualizarDos">
			<div class="col-md-12 order-md-1" >
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="TblInformacionFinancieraUpdate"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table  table-bordered" width="100%">
                <thead>
                <tr>
				    <th style="background-color: #1f8948;color: white;" colspan="6">BALANCE GENERAL</th>
				    </tr>
								<tr>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">ACTIVOS</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">PASIVOS</th>
										<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">PATRIMONIO</th>
										<th scope="col" class="tablaingreso" width="40%"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
								
						</thead>
						<tbody>
							<tr>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="inf_activos" name="inf_activos" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="verifica_activo(this.value)"/>
										<div class="invalid-feedback" >Por Ingrese el activo</div>
									</td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="inf_pasivos" name="inf_pasivos" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="calculo_pasivo(this.value)" />
										<div class="invalid-feedback">Por Ingrese el pasivo</div></td>
										<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="inf_patrimonio" name="inf_patrimonio" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  onpaste="return false"/>
										<div class="invalid-feedback">Por Ingrese el patrimonio</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="inf_linkbalance" name="inf_linkbalance" required="required" placeholder="Dirección de página web" >
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
						</tbody>
                
            </table>
			</form:form>
			</div>
		
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="cod_finan" name="cod_finan">
	   </div>
	   
	 <div id="tabla" class="col-md-12 order-md-1">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
				<tr>
				    <th style="background-color: #1f8948;color: white;" colspan="6"><h5>BALANCE GENERAL</h5> </th>
				    </tr>
					<tr>
						<th >#</th>
						<th width="10%" style="text-align: center; font-size:x-small;">ACTIVOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PASIVOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PATRIMONIO</th>
						<th width="50%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	      <hr/>
		</div>
	
			
		</c:when>
		<c:when test="${infestadoinforme=='finalizado'}">
		<div class="card-header text-white carHeaderBlue">
		<h5>INFORMACIÓN FINANCIERA (LOCPCCS Art. 10, LEY DE EMPRESAS PÚBLICAS ART. 45 SISTEMAS DE INFORMACIÓN):</h5>
	</div>
		<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
				<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
				    <tr>
				    <th style="background-color: #1f8948;color: white;" colspan="6"><h5>BALANCE GENERAL</h5></th>
				    </tr>
					<tr>
						<th >#</th>
						<th width="10%" style="text-align: center; font-size:x-small;">ACTIVOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PASIVOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PATRIMONIO</th>
						<th width="50%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
			 $("#actualizarDos").hide();
			 if ('${infestado}' == 'matriz'||'${infestadoinforme}' == 'finalizado') {
				tabla();			
			}

			 $("#infPasivos").attr("disabled", true);
				$("#infPatrimonio").attr("disabled", true);
				$("#infLinkbalance").attr("disabled", true); 
				
});
			
$("#btnGuardar").click(function(event) {
	var form = $("#TblInformacionFinancieraGuardar");	
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje(
				"Por favor ingrese toda la información solicitada!",
				"ERROR");
	} else {
		$(".campo").removeAttr("disabled");
		 $("#infPasivos").removeAttr("disabled");
			$("#infPatrimonio").removeAttr("disabled");
			$("#infLinkbalance").removeAttr("disabled"); 
		ejecutarJson(form);
	}
	form.addClass('was-validated');
});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosInformacionFinanciera",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
	    paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
			{data : "contador" },
			{data : "activo"},
			{data : "pasivos"},
			{data : "patrimonio"},
			{data : "link"},	
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Editar</button>';    
	             } return data;
    }}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.codFinan);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var activo = $(element).parent().parent().find("td:eq(1)").text();
		var pasivo = $(element).parent().parent().find("td:eq(2)").text();
		var patrimonio = $(element).parent().parent().find("td:eq(3)").text();
		var link = $(element).parent().parent().find("td:eq(4)").text();
	  $("#actualizarDos").show();
	  $("#tabla").hide();	 	
		 $("#cod_finan").val(codigo);
		 $("#inf_activos").val(activo);
		 $("#inf_pasivos").val(pasivo);
		 $("#inf_patrimonio").val(patrimonio);
		  $("#inf_linkbalance").val(link);

		  $("#inf_pasivos").attr("disabled", true);
			$("#inf_patrimonio").attr("disabled", true);
		
	  
}
$("#btnActualizar").click(
		function(event) {
			var form = $("#TblInformacionFinancieraUpdate")
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
					    	if(field.name=="inf_pasivos"){
					    		field.value=field.value.replace(/,/g, "");
					    	}
					    	if(field.name=="inf_activos"){
					    		field.value=field.value.replace(/,/g, "");
					    	}
					    	if(field.name=="inf_patrimonio"){
					    		field.value=field.value.replace(/,/g, "");
					    	}
					    	valores+= field.value+ ',99';
					    	if (valores.length > 0) {
					    		valores = valores.substr(0, valores.length - 1);
	                        }
					    });
				  var data = {tabla: 'esq_rendicioncuentas.tbl_informacion_financiera',columns:columnas,values:valores,condicion:'cod_finan',valorcondicion:$("#cod_finan").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	



function verificaActivo(val) {

	if (val == 0) {

		$("#infPasivos").val(0);
		$("#infPatrimonio").val(0);
		$("#infPasivos").attr("disabled", true);
		$("#infPatrimonio").attr("disabled", true);
		$("#infLinkbalance").attr("disabled", true);
		$("#infLinkbalance").val("NO APLICA");

		$("#inf_pasivos").val(0);
		$("#inf_patrimonio").val(0);
		$("#inf_pasivos").attr("disabled", true);
		$("#inf_patrimonio").attr("disabled", true);
		$("#inf_linkbalance").attr("disabled", true);
		$("#inf_linkbalance").val("NO APLICA");
		
		
		}else{
			$("#infPasivos").attr("disabled", false);
			$("#infPatrimonio").attr("disabled", true);
			$("#infLinkbalance").attr("disabled", false);
			$("#infLinkbalance").val("http://");

			$("#inf_pasivos").attr("disabled", false);
			$("#inf_patrimonio").attr("disabled", true);
			$("#inf_linkbalance").attr("disabled", false);
			$("#inf_linkbalance").val("http://");
			
		
	}
}

function verifica_activo(val) {

	if (val == 0) {

	
		$("#inf_pasivos").val(0);
		$("#inf_patrimonio").val(0);
		$("#inf_pasivos").attr("disabled", true);
		$("#inf_patrimonio").attr("disabled", true);
		$("#inf_linkbalance").attr("disabled", true);
		$("#inf_linkbalance").val("NO APLICA");
		
		
		}else{
		

			$("#inf_pasivos").attr("disabled", false);
			$("#inf_patrimonio").attr("disabled", true);
			$("#inf_linkbalance").attr("disabled", false);
		
			
		
	}
}

function calculoPasivo(val) {
	var p = parseFloat($("#infActivos").val().replace(/,/g, ""));
	var pp =parseFloat($("#infPasivos").val().replace(/,/g, ""));
	
	if (pp > p){

		var resultado = (p - pp);
		var conDecimal = resultado.toFixed(2); 
		var sresultado = formatearNumero(conDecimal);
		$("#infPatrimonio").val(sresultado);
		/* mostrarMensaje("El valor del pasivo no puede superar al activo!", "ERROR");
		$("#btnGuardar").attr("disabled", true);
		$("#infPatrimonio").attr("disabled", true);
		$("#infLinkbalance").attr("disabled", true); */
	}else{
		if (pp == p){
			
			$("#infPatrimonio").val(0);
			$("#infPatrimonio").attr("disabled", false);
			$("#infLinkbalance").attr("disabled", false);
			$("#infLinkbalance").val("http://");
			$("#btnGuardar").attr("disabled", false);
			}else{
				$("#infPatrimonio").attr("disabled", true);
				$("#btnGuardar").attr("disabled", false);
				$("#infPatrimonio").attr("disabled", true);
				$("#infLinkbalance").attr("disabled", false);
				$("#infLinkbalance").val("http://");
				var resultado = (p - pp);
				var conDecimal = resultado.toFixed(2); 
				var sresultado = formatearNumero(conDecimal);
				$("#infPatrimonio").val(sresultado);
				}
	}
}

function calculo_pasivo(val) {
	var p = parseFloat($("#inf_activos").val().replace(/,/g, ""));
	var pp =parseFloat($("#inf_pasivos").val().replace(/,/g, ""));
	
	if (pp > p){
		var resultado = (p - pp);
		var conDecimal = resultado.toFixed(2); 
		var sresultado = formatearNumero(conDecimal);
		$("#infPatrimonio").val(sresultado);
		/* mostrarMensaje("El valor del pasivo no puede superar al activo!", "ERROR");
		$("#btnGuardar").attr("disabled", true);
		$("#inf_patrimonio").attr("disabled", true);
		$("#inf_linkbalance").attr("disabled", true); */
	}else{
		if (pp == p){
			
			$("#inf_patrimonio").val(0);
			$("#inf_patrimonio").attr("disabled", true);
			$("#inf_linkbalance").attr("disabled", false);
		
			$("#btnGuardar").attr("disabled", false);
			}else{
				$("#inf_patrimonio").attr("disabled", true);
				$("#btnGuardar").attr("disabled", false);
				$("#inf_patrimonio").attr("disabled", true);
				$("#inf_linkbalance").attr("disabled", false);
				
				var resultado = (p - pp);
				var conDecimal = resultado.toFixed(2); 
				var sresultado = formatearNumero(conDecimal);
				$("#inf_patrimonio").val(sresultado);
				}
	}
}
  
function formatearNumero(nStr) {
    nStr += '';
    x = nStr.split(',');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{3})/;
    while (rgx.test(x1)) {
            x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}
</script>
