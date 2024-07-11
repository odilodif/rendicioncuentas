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
	<c:choose>
	<c:when test="${infestado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>DIFUSIÓN Y COMUNICACIÓN DE LA GESTIÓN INSTITUCIONAL:</h5>
	</div>
	
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblComunicacionGestion" id="TblComunicacionGestionid"
					data-rutaAplicacion="rendicion" data-opcion="guardarMediosComunicacion" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">		
               <table class="table table-bordered"  id="tablaid">
                       <thead>
								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">MEDIOS DE COMUNICACIÓN</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NO. DE MEDIOS</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS LOCALES Y REGIONALES</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS NACIONAL</th>
										<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO DEL PAUTAJE QUE SE DESTINÓ A MEDIOS INTERNACIONALES</th>
										<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
						</thead>
						<tbody>	
								<tr id="fila0">
									<td scope="row"><label id="mecaniNombre">Radio</label>
										<input type="hidden"  id="cgNombre[]" name="cgNombre[]" class="form-control form-control-sm"  value="Radio">
										</td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm  valor numero"  id="cgNumero[]" name="cgNumero[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorlocales[]" name="cgPorlocales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPornacionales[]" name="cgPornacionales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorinternacional[]" name="cgPorinternacional[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="cgMedioverif[]" name="cgMedioverif[]" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
								<tr id="fila1">
									<td scope="row"><label id="mecaniNombre">Prensa</label>
										<input type="hidden"  id="cgNombre[]" name="cgNombre[]" class="form-control form-control-sm"  value="Prensa">
										<div class="invalid-feedback">Por Ingrese las Sugerencias Ciudadanas</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm valor numero"  id="cgNumero[]" name="cgNumero[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor "  id="cgPorlocales[]" name="cgPorlocales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPornacionales[]" name="cgPornacionales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorinternacional[]" name="cgPorinternacional[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="cgMedioverif[]" name="cgMedioverif[]" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
								<tr id="fila2">
									<td scope="row"><label id="mecaniNombre">Televisión</label>
										<input type="hidden"  id="cgNombre[]" name="cgNombre[]" class="form-control form-control-sm"  value="Televisión">
										<div class="invalid-feedback">Por Ingrese las Sugerencias Ciudadanas</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm valor numero"  id="cgNumero[]" name="cgNumero[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorlocales[]" name="cgPorlocales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPornacionales[]" name="cgPornacionales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorinternacional[]" name="cgPorinternacional[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="cgMedioverif[]" name="cgMedioverif[]" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
								<tr id="fila3">
									<td scope="row"><label id="mecaniNombre">Medios digitales</label>
										<input type="hidden"  id="cgNombre[]" name="cgNombre[]" class="form-control form-control-sm"  value="Medios digitales">
										<div class="invalid-feedback">Por Ingrese las Sugerencias Ciudadanas</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm valor numero"  id="cgNumero[]" name="cgNumero[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorlocales[]" name="cgPorlocales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPornacionales[]" name="cgPornacionales[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cgPorinternacional[]" name="cgPorinternacional[]" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="cgMedioverif[]" name="cgMedioverif[]" required="required" placeholder="Dirección de página web" value="http://">
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
		<h5>DIFUSIÓN Y COMUNICACIÓN DE LA GESTIÓN INSTITUCIONAL:</h5>
	</div>
	<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Para agregar los nombre de las radios, monto y minutos dar clic en el boton "Ingresar Detalle Medios"</div>
		</div>
	<div class="card-body">
		<div class="row">
		   <div id="actualizar">
			<div class="col-md-12 order-md-1" >
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="tblaactualizarid"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table  table-bordered" width="100%" >
                <thead>
								<tr>
									<th scope="col" class="tablaingreso" width="15%"
										style="text-align: center; font-size: x-small;">MEDIOS DE COMUNICACIÓN</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NO. DE MEDIOS</th>
										<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS LOCALES Y REGIONALES</th>
										<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS NACIONAL</th>
										<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DEL PPTO DEL PAUTAJE QUE SE DESTINÓ A MEDIOS INTERNACIONALES</th>
										<th scope="col" class="tablaingreso" width="40%"
										style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
									
								</tr>
								
						</thead>
						<tbody>
							<tr>
									<td scope="row">
									<label id="mecani_nombre"></label>
										
									</td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm  valor"  id="cg_numero" name="cg_numero" required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cg_porlocales" name="cg_porlocales" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cg_pornacionales" name="cg_pornacionales" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
									<input type="text" class="form-control form-control-sm campo valor"  id="cg_porinternacional" name="cg_porinternacional" required="required" placeholder="0.00" onkeypress="javascript:return validarnro(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm url" id="cg_medioverif" name="cg_medioverif" required="required" placeholder="Dirección de página web" value="http://">
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
			<input type="hidden" id="cg_cod" name="cg_cod">
	   </div>
	   
	 <div id="tabla" class="col-md-12 order-md-1">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
						<th></th>
						<th width="15%" style="text-align: center; font-size:x-small;">MEDIOS DE VERIFICACIÓN</th>
						<th width="10%" style="text-align: center; font-size:x-small;">No. DE MEDIOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINO A MEDIOS LOCALES Y REGIONALES</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS NACIONAL</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO DEL PAUTAJE QUE SE DESTINO A MEDIOS INTERNACIONALES</th>
						<th width="30%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
						<th></th>
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
		<c:when test="${infestado=='finalizado'}">

<div class="card-header text-white carHeaderBlue">
		<h5>DIFUSIÓN Y COMUNICACIÓN DE LA GESTIÓN INSTITUCIONAL:</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
			  <div id="tabla" class="col-md-12 order-md-1">
			  <input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
					    <th></th> 
						<th width="15%" style="text-align: center; font-size:x-small;">MEDIOS DE VERIFICACIÓN</th>
						<th width="10%" style="text-align: center; font-size:x-small;">No. DE MEDIOS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINO A MEDIOS LOCALES Y REGIONALES</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO. DEL PAUTAJE QUE SE DESTINÓ A MEDIOS NACIONAL</th>
						<th width="10%" style="text-align: center; font-size:x-small;">PORCENTAJE DEL PPTO DEL PAUTAJE QUE SE DESTINO A MEDIOS INTERNACIONALES</th>
						<th width="30%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
						<th></th>
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
			 if ('${infestado}' == 'matriz'||'${infestado}' == 'finalizado') {
				tabla();			
			}
});
 function DetalleMedios(elemento){
	 var codigo = $(elemento).closest('tr').attr('id');
	abrir($(elemento), "#" + $(elemento).attr("data-destino"), codigo);
 }
function format ( d ) {
	
	var parametros = {//Las variables que le paso
	        "codigo":d.cgCod, //Aqui tengo el id de la historia
	         
	    };	     
	    $.ajax ({
	        data: parametros,
	        "url": "obtenerRegistrosDetalleMediosComunicacion", //web a la que llamo y hace el trabajo.
	        headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST",
		  	 beforeSend: function(){
                 $("#datatable_tabletools").html("");
                 },
	        success: function(data){
	            objJson=JSON.parse(data);
	            
	        }   
	    });        
    var results = '<table id="datatable_tabletools" class="table table-striped table-hover">';
	results += '<thead> <tr><th>#</th> <th>NOMBRE DE LA RADIO</th> <th>MONTO</th> <th>MINUTOS</th>';
	results += '</tr> </thead> <tbody>';
	if (objJson.data.length != 0)
		{
		$.each(objJson.data, function() {

				results += '<tr>';
				results +='<td>' + this.contador + '</td>';
				results +='<td>' + this.radios + '</td>';
				results +='<td>' + this.valor + '</td>';
				results +='<td>' + this.minutos + '</td>';
				results +='</tr>';	
		});
		results += '</tbody></table>';
	    return results;}
}

$("#btnGuardar").click(function(event) {
	var form = $("#TblComunicacionGestionid");	
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
			url:"obtenerRegistrosMediosComunicacion",
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
			{data : "contador" },
			 {data:"","render": function (data, type, full, meta) {
				 
		        	 if(full.numero==0){
		        		 data = ''; 
		        	 }else{
		        		 data = '<button type="button" id="mostrar" class="_mostrar btn _seleccionarColor btn-sm " onclick="Mostrar(this)" title="Mostrar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"></button>';    
		        	 }
		        	 return data;
				 
			 }
            },
			{data : "nombre"},
			{data : "numero"},
			{data : "porclocal"},
			{data : "porcnacional"},
			{data : "porcinternacional"},
			{data : "link"},	
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestado}' === "finalizado"){
		        	 data = '';     
		         }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
		         } return data;
            }},{ data: "" ,"render": function (data, type, full, meta) {
		 if('${infestado}' === "finalizado"){
        	 data = '';     
         }else{
        	 if(full.numero==0){
        		 data = ''; 
        	 }else{
        data = '<button type="button" id="'+full.cgCod+'" class="_modificar btn _actualizarColor btn-sm"  onclick="DetalleMedios(this)" data-rutaAplicacion="rendicion" data-opcion="Frm_DetalleMedios" title="Ingresar Detalle Medios" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;" data-destino="detalleItem"> Ingresar Detalle</button>';    
        	 }} return data;
         }} ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.cgCod);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


	
}

    
    
function Mostrar(element) {	
	var detailRows = [];
    var tr = $(element).closest('tr');
    var row = $('#tablaRegistros').DataTable().row(tr);

    if ( row.child.isShown() ) {
        // This row is already open - close it
        row.child.hide();
        tr.removeClass('shown');
    }
    else {
        // Open this row	    
        row.child( format(row.data()) ).show();
        tr.addClass('shown');
     
       
    }

}
function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var nombre = $(element).parent().parent().find("td:eq(2)").text();
		var numero1 = $(element).parent().parent().find("td:eq(3)").text();
		var numero2 = $(element).parent().parent().find("td:eq(4)").text();
		var numero3 = $(element).parent().parent().find("td:eq(5)").text();
		var numero4 = $(element).parent().parent().find("td:eq(6)").text();
		var link = $(element).parent().parent().find("td:eq(7)").text();
	  $("#actualizar").show();
	  $("#tabla").hide();	 	
		 $("#cg_cod").val(codigo);
		 document.getElementById("mecani_nombre").innerHTML=nombre;
		  $("#cg_numero").val(numero1);
		  $("#cg_porlocales").val(numero2);
		  $("#cg_pornacionales").val(numero3);
		  $("#cg_porinternacional").val(numero4);
		  $("#cg_medioverif").val(link);
		  if(numero1==0){
			    $(".campo").prop("disabled", true);
		        $(".campo").val("");
		        $(".campo").removeAttr("required");
		        $(".campo").val("0");
		        $(".url").val("NO APLICA");
		        $(".url").get(0).type = 'text';
		   }else{			
			   $(".campo").removeAttr('disabled');
		       $(".campo").prop("required", true);
		       $(".url").get(0).type = 'url'; 
		   }
	  
}
$("#btnActualizar").click(
		function(event) {
			var form = $("#tblaactualizarid")
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
					    	if(field.name=="cg_porlocales"||field.name=="cg_pornacionales"||field.name=="cg_porinternacional"){
					    		field.value=field.value.replace(",", ".");
					    	}
					    	valores+= field.value+ ',99';
					    	if (valores.length > 0) {
					    		valores = valores.substr(0, valores.length - 1);
	                        }
					    });
				  var data = {tabla: 'esq_rendicioncuentas.tbl_comunicacion_gestion',columns:columnas,values:valores,condicion:'cg_cod',valorcondicion:$("#cg_cod").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	

$("#tablaid tr td").find(".numero").change(function () {
  
	var row = $(this).closest('tr');
	var total = 0;
	$('.numero', row).each(function() {
        total += Number($(this).val());
    });
   if(total==0){
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").val("");
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".url").val("NO APLICA");
        $(this).closest('tr').find(".url").get(0).type = 'text';
   }else{
	
	   $(this).closest('tr').find(".campo").removeAttr('disabled');
       $(this).closest('tr').find(".campo").prop("required", true);
       $(this).closest('tr').find(".url").val("http://");
       $(this).closest('tr').find(".url").get(0).type = 'url'; 
   }
});
$("#cg_numero").change(function() {
	var total = 0;
        total += Number($('#cg_numero').val());
	   if(total==0){
		    $(this).closest('tr').find(".campo").prop("disabled", true);
	        $(this).closest('tr').find(".campo").val("");
	        $(this).closest('tr').find(".campo").removeAttr("required");
	        $(this).closest('tr').find(".campo").val("0");
	        $(this).closest('tr').find(".url").val("NO APLICA");
	        $(this).closest('tr').find(".url").get(0).type = 'text';
	   }else{
		
		   $(this).closest('tr').find(".campo").removeAttr('disabled');
	       $(this).closest('tr').find(".campo").prop("required", true);
	       $(this).closest('tr').find(".url").val("http://");
	       $(this).closest('tr').find(".campo").val("");
	       $(this).closest('tr').find(".url").get(0).type = 'url'; 
	   }
});
				
</script>
