<%-- 
	version		: 1.0
    Document  	: Fmr_MediosComunicacion
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
	
	<div class="card-header text-white carHeaderBlue">
		<h5>DIFUSIÓN Y COMUNICACIÓN DE LA GESTIÓN INSTITUCIONAL:</h5>
	</div>
	<div class="card-body">
		<div class="row" >
		
			<div class="col-md-12 order-md-1" id="nuevo2">
			
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblComunicacionGestion" id="TblDetalleComunicagestion"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarTblDetalleComunicagestion" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="cgCod" name="cgCod" value="${cgCod}">		
               <table class="table table-bordered"  id="tablaid">
                       <thead>
								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">MEDIO DE COMUNICACIÓN</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NOMBRE</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">MONTO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">MINUTOS</th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row"><label id="dcNombre" >${nombre}</label>
										</td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor numero"  id="dcNombre" name="dcNombre" required="required"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="dcMonto" name="dcMonto" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  onpaste="return false"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="dcMinutos" name="dcMinutos" required="required" placeholder="0.00"  onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
								
								</tr>
								
								</tbody>	
							</table>
            
			</form:form>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>	
			</div>
			
		
	
		 
	   <div id="actualizar2">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="tblaactualizardetalleid"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table  table-bordered" >
                <thead>
								<tr>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NOMBRE</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">MONTO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">MINUTOS</th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor numero"  id="dc_nombre" name="dc_nombre" required="required"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="dc_monto" name="dc_monto" required="required" placeholder="0.00"  onkeypress="mascara(this,cpf)"  onpaste="return false"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="dc_minutos" name="dc_minutos" required="required" placeholder="0.00"  onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
								
								</tr>
								
								</tbody>	
                
            </table>
			</form:form>
		
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizar2"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="cg_cod2" name="cg_cod2">
	   </div>
	 <div id="tabla2" class="col-md-12 order-md-1">
					<table id="tablaRegistros2" class="table table-striped table-bordered" >
				<thead>
					<tr>
						<th >#</th>
						<th >Nombre</th>
						<th>Monto</th>
						<th>minutos</th>
						<th ></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	      <hr/>
		</div>	
			</div>		
</div>
</div>
</html>

<script type="text/javascript">

$(document).ready(function() {
			 $("#actualizar2").hide();
			tabla();	
			
			
});


$("#btnGuardar").click(function(event) {
	var form = $("#TblDetalleComunicagestion");	
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
		var parametros = {
	            "codigo" :$("#cgCod").val()
	        };
		$.ajax({
	        url: "obtenerRegistrosDetalleMediosComunicacion",
	        type: "post",
	        dataType: "json",
	        data: parametros,
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        success: function (result) {
	        	 if (result['Error']) {
	                 $('#tabla2').hide();
	             }{ 
	        $('#tablaRegistros2').DataTable( {   
	        	
	          order: [ 0, "asc" ],
		      responsive: true,
		
	    data: result.data,
	    columns : [
			{data : "contador" },
			{data : "radios"},
			{data : "valor"},
			{data : "minutos"},{ data: "" ,"render": function (data, type, full, meta) {
				if('${infestado}' === "finalizado"){
		           	 data = '';     
		            }else{
		                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
		            }  return data;
		    }}
			],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.cgCod2);
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

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var nombre = $(element).parent().parent().find("td:eq(1)").text();
		var numero1 = $(element).parent().parent().find("td:eq(2)").text();
		var numero2 = $(element).parent().parent().find("td:eq(3)").text();
	  $("#actualizar2").show();
	  $("#nuevo2").hide();
	  $("#tabla2").hide();	 	
		 $("#cg_cod2").val(codigo);
		  $("#dc_nombre").val(nombre);
		  $("#dc_monto").val(numero1);
		  $("#dc_minutos").val(numero2);
		
	  
}
$("#btnActualizar2").click(
		function(event) {
			var form = $("#tblaactualizardetalleid")
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
					    	if(field.name=="dc_monto"){
					    		field.value=field.value.replace(/,/g, "");
					    	}
					    	valores+= field.value+ ',99';
					    	if (valores.length > 0) {
					    		valores = valores.substr(0, valores.length - 1);
	                        }
					    });
				  var data = {tabla: 'esq_rendicioncuentas.tbl_detalle_comunicagestion',columns:columnas,values:valores,condicion:'cg_cod2',valorcondicion:$("#cg_cod2").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	


				
</script>
