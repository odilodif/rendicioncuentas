<%-- 
	version		: 1.0
    Document  	: Fmr_CumplimientoObligaciones
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
		<h5>CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7):</h5>
		
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblCumplimientoObligaciones" id="TblCumplimientoObligacionesGuardar"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarCumplimientoObligaciones" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">		
               <table class="table table-bordered" id="miTabla">
                       <thead>
								<tr>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">LABORALES</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">TRIBUTARIAS</th>
										<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row">
										<select class="custom-select custom-select-sm " id="infLaborales" name="infLaborales" onchange="validar(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
										<div class="invalid-feedback">Por seleccione el campo</div></td>
									<td scope="row">
									<select class="custom-select custom-select-sm " id="infTributarias" name="infTributarias" onchange="validar2(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
										<div class="invalid-feedback">Por seleccione el campo</div></td>
									
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="infLinkcumplimiento" name="infLinkcumplimiento" required="required" placeholder="Dirección de página web" value="http://">
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
		<h5>CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7):</h5>
	</div>
	<div class="card-body">
		<div class="row">
		   <div id="actualizar">
			<div class="col-md-12 order-md-1" >
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="TblCumplimientoObligacionesUpdate"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table  table-bordered" width="100%">
                <thead>
               
								<tr>
									<th scope="col" class="tablaingreso" width="150px"
										style="text-align: center; font-size: x-small;">LABORALES</th>
										<th scope="col" class="tablaingreso" width="150px"
										style="text-align: center; font-size: x-small;">TRIBUTARIAS</th>
										<th scope="col" class="tablaingreso" width="600px"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
								
						</thead>
						<tbody>
							<tr>
								
									<td scope="row">
									<select class="custom-select custom-select-sm " id="inf_laborales" name="inf_laborales"  onchange="validar3(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
										<div class="invalid-feedback">Por seleccione el campo</div></td>
										<td scope="row">
									<select class="custom-select custom-select-sm " id="inf_tributarias" name="inf_tributarias" onchange="validar4(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
										<div class="invalid-feedback">Por seleccione el campo</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="inf_linkcumplimiento" name="inf_linkcumplimiento" required="required" placeholder="Dirección de página web" >
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
			<input type="hidden" id="cum_obl_cod" name="cum_obl_cod">
	   </div>
	   
	 <div id="tabla" class="col-md-12 order-md-1">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
			
					<tr>
						<th >#</th>
						<th width="10%" style="text-align: center; font-size:x-small;">LABORALES</th>
						<th width="10%" style="text-align: center; font-size:x-small;">TRIBUTARIAS</th>
						<th width="80%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
		<h5>CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7):</h5>
	</div>
		<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
				<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
						<th width="10%" style="text-align: center; font-size:x-small;">LABORALES</th>
						<th width="10%" style="text-align: center; font-size:x-small;">TRIBUTARIAS</th>
						<th width="80%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
	var form = $("#TblCumplimientoObligacionesGuardar");	
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


function validar(elemento) {
	if ($(elemento).val() === "NO"){
		if($("#infTributarias").val()=== "NO"){
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
			}else{
				 $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".url").val("http://");
				 $(".url").get(0).type = 'url';
				}
	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		}
}


function validar2(elemento) {
	if ($(elemento).val() === "NO"){
		if($("#infLaborales").val()=== "NO" ){
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
			}else{
				 $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".url").val("http://");
				 $(".url").get(0).type = 'url';
				}
	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		}
}

function validar3(elemento) {
	if ($("#inf_laborales").val() === "NO"){
		if($("#inf_tributarias").val()=== "NO"){
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
		}else{
				 $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".url").val("http://");
				 $(".url").get(0).type = 'url';
				}
	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		}
}

function validar4(elemento) {
	if ($("#inf_tributarias").val() === "NO"){
		if($("#inf_laborales").val()=== "NO"){
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
			}else{
				 $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".url").val("http://");
				 $(".url").get(0).type = 'url';
				}
	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		}
}

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosCumplimientoInformacion",
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
			{data : "laborales"},
			{data : "tributarios"},
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
		     $(row).attr('id', data.cumOblCod);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	       $(row).find("td").css({
				"font-size"   : "x-small",			
			});	

			$(row).find("td").css({
				"vertical-align" : "middle",
			});	
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var laborales = $(element).parent().parent().find("td:eq(1)").text();
		var tributarios = $(element).parent().parent().find("td:eq(2)").text();
		var link = $(element).parent().parent().find("td:eq(3)").text();
	  $("#actualizar").show();
	  $("#tabla").hide();	 	
		 $("#cum_obl_cod").val(codigo);
		 $("#inf_laborales").val(laborales);
		 $("#inf_tributarias").val(tributarios);
		  $("#inf_linkcumplimiento").val(link);
	  
}
$("#btnActualizar").click(
		function(event) {
			var form = $("#TblCumplimientoObligacionesUpdate")
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_cumplimiento_obligaciones',columns:columnas,values:valores,condicion:'cum_obl_cod',valorcondicion:$("#cum_obl_cod").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	



				
</script>
