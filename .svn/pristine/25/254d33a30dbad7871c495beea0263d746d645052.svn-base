<%-- 
	version		: 1.0
    Document  	: Fmr_EstadoObras
    Author		: wilmer Guaman
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
		<h5>ESTADO DE OBRAS PÚBLICAS</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblObrasAnteriores" id="TblObrasAnterioresid"
						data-rutaAplicacion="rendicion" data-opcion="guardarEstadoObras"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod" value="${codigo_informe}">
						<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE OBRAS PÚBLICAS</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm" id="obaObra" name="obaObra" required="required"></textarea>
									<div class="invalid-feedback">Por Ingrese la descripción de las obras</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" class="form-control form-control-sm"  id="obaValor" name="obaValor" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false" />
								<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">ESTADO ACTUAL</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm campo" id="obaEstado" name="obaEstado" required="required"></textarea>
								<div class="invalid-feedback">Por Ingrese el estado actual</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">OBSERVACIONES</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm campo" id="obaObs" name="obaObs" required="required"></textarea>
									<div class="invalid-feedback">Por Ingrese las observaciones</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-3 text-left" >
									<label for="parroquia" style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="obaLink" name="obaLink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
					<hr />
				</div>
				<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblPlanTrabajoGad" id="ActualizarObras"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
                        <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE OBRAS PÚBLICAS</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm" id="oba_obra" name="oba_obra" required="required"></textarea>
									<div class="invalid-feedback">Por Ingrese la descripción de las obras</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR</label>
								</div>
								<div class="col-md-1  text-left">
									<input type="text" class="form-control form-control-sm"  id="oba_valor" name="oba_valor" required="required"  placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false"/>
								<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">ESTADO ACTUAL</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm campo" id="oba_estado" name="oba_estado" required="required"></textarea>
								<div class="invalid-feedback">Por Ingrese el estado actual</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">OBSERVACIONES</label>
								</div>
								<div class="col-md-6  text-left">
									<textarea rows="2" cols="" class="form-control form-control-sm campo" id="oba_obs" name="oba_obs" required="required"></textarea>
									<div class="invalid-feedback">Por Ingrese las observaciones</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-3 text-left" >
									<label for="parroquia" style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="oba_link" name="oba_link" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="oba_cod" name="oba_cod">
				</div>
				<div id="tabla">
					<div class="row justify-content-center align-items-center">
	
		       <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
	            </div>
					<table id="tablaRegistrosobras"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>DESCRIPCIÓN DE OBRAS PÚBLICAS</th>
								<th>VALOR</th>
								<th>ESTADO ACTUAL</th>
								<th>OBSERVACIONES</th>
								<th>LINK AL MEDIO DE VERIFICACIÓN EN LA PÁG. WEB</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
				</div>
			</div>
		</div>

	</div>
 </c:when>
 <c:when test="${infestado=='finalizado'}">
	<div class="card-header text-white carHeaderBlue">
		<h5>ESTADO DE OBRAS PÚBLICAS DE ADMINISTRACIONES ANTERIORES</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<input type="hidden" id="infCod" name="infCod" value="${codigo_informe}">
			<div id="tabla">
					<table id="tablaRegistrosobras"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>DESCRIPCIÓN DE OBRAS PÚBLICAS</th>
								<th>VALOR</th>
								<th>ESTADO ACTUAL</th>
								<th>OBSERVACIONES</th>
								<th>LINK AL MEDIO DE VERIFICACIÓN EN LA PÁG. WEB</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
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
$(document).ready(function(){
	 $("#actualizar").hide();
	 if ('${infestado}' == 'activo'||'${infestado}' == 'finalizado') {
	 tabla();}
});

$("#btnNuevo").click(function(event) {
	 $('#tabla').hide();
	 $('#nuevo').show();
});	
function tabla() {
	
	var parametros = {
            "infCod" :$("#infCod").val()
        };
	$.ajax({
        url: "obtenerRegistrosObrasAnteriores",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {
        	 if (result['Error']) {
                 $('#tabla').hide();
                 
             }else if(result['data'].length!=0){
            	 $('#nuevo').hide();
        $('#tablaRegistrosobras').DataTable( {         	
          order: [ 0, "asc" ],
	      responsive: true,
	      bDestroy : true,
			info : false,
			searching : false,
	      buttons: [
	      {extend: 'copyHtml5'},
          {extend: 'csvHtml5'},
          {extend: 'excelHtml5'},
    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
    {extend: 'print'},
    ],
    data: result.data,
    columns : [
		{data : "contador" },
		{data : "obra"},
		{data : "valor"},
		{data : "estado"},
		{data : "observacion"},
		{data : "link"},
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestado}' === "finalizado"){
		       	 data = '';     
		        }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
		        } return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	if('${infestado}' === "finalizado"){
          	 data = '';     
           }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
           } return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.obaCod);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }else{
        	
        }
	 },
     error: function (errormessage) {
         alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardar").click(
				function(event) {
					var form = $("#TblObrasAnterioresid")
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
		function Eliminar(element) {	
			var codigo = $(element).closest('tr').attr('id');	
			 $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_obras_anteriores',campo:'oba_cod'},
			        success: function (msg) {
			            if (msg.estado == "exito") {
	                             mostrarMensaje(msg.mensaje, "EXITO");
	                             var td = element.parentNode;
	                             var tr = td.parentNode;
	                             var table = tr.parentNode;      
	                             table.removeChild(tr);
	                             var nFilas = $("#tablaRegistrosobras tr").length-1;
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
			var obra = $(element).parent().parent().find("td:eq(1)").text();
			var valor = $(element).parent().parent().find("td:eq(2)").text();
			var estado = $(element).parent().parent().find("td:eq(3)").text();
			var observacion = $(element).parent().parent().find("td:eq(4)").text();
			var link = $(element).parent().parent().find("td:eq(5)").text();
			 $("#nuevo").hide();
			 $("#tabla").hide();
			  $("#actualizar").show();
			  $("#oba_cod").val(codigo);
			  $("#oba_obra").val(obra);
			  $("#oba_valor").val(valor);
			  $("#oba_estado").val(estado);
			  $("#oba_link").val(link);
			  $("#oba_obs").val(observacion);
		}
		$("#btnActualizar").click(
				function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#ActualizarObras")
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
							    	
							    	if(field.name=="oba_valor"){
							    		field.value=field.value.replace(/,/g, "");
							    	}
							    	valores+= field.value+ ',99';
							    	if (valores.length > 0) {
							    		valores = valores.substr(0, valores.length - 1);
			                        }
							    });
						  var data = {tabla: 'esq_rendicioncuentas.tbl_obras_anteriores',columns:columnas,values:valores,condicion:'oba_cod',valorcondicion:$("#oba_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
	</script>
