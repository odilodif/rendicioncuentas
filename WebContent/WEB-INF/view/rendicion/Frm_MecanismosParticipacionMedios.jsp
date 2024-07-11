<%-- 
	version		: 1.0
    Document  	: Frm_MecanismosParticipacionMedios
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
		<c:when test="${inf_estado=='activo'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>MECANISMOS DE PARTICIPACIÓN CIUDADANA</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblMecanismoParticipacionCiudadana"
							id="TblMecanismoParticipacionCiudadana"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarMecanismoParticipacionEjecutivo"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
							<table class="table table-bordered" id="miTabla">
								<thead>
									<tr>
										<th scope="col" class="tablaingreso" width="12%"
											style="text-align: center; font-size: x-small;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">PONGA SI
											O NO</th>
										<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">NÚMERO DE MECANISMOS IMPLEMENTADOS EN EL AÑO</th>
										<th scope="col" class="tablaingreso" width="25%"
											style="text-align: center; font-size: x-small;">MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
										
									</tr>
								</thead>
								<tbody>
									<tr id="fila0">
										<td scope="row"><label id="mecaniNombre">ASAMBLEA LOCAL</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="ASAMBLEA LOCAL">
											</td>
										<td scope="row">
										<select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="number"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"  
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
									    <td scope="row">
									   <input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											</td>
									</tr>
									<tr id="fila1">
										<td scope="row">
										<label id="mecaniNombre">AUDIENCIA PÚBLICA</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="AUDIENCIA PÚBLICA">
										</td>
										<td scope="row">
										<select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div>
										</td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>									
										<td scope="row">
										<input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
									    </td>
									</tr>
									<tr id="fila2">
										<td scope="row">
										<label id="mecaniNombre">CABILDO POPULAR</label> <input type="hidden" id="mecaNombre[]" name="mecaNombre[]" class="form-control form-control-sm"
											value="CABILDO POPULAR">
										</td>
										<td scope="row">
										<select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div>
										</td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>										
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
										</td>
									</tr>
									<tr id="fila3">
										<td scope="row"><label id="mecaniNombre">CONSEJOS CONSULTIVOS</label> <input type="hidden" id="mecaNombre[]" name="mecaNombre[]" class="form-control form-control-sm"
											value="CONSEJOS CONSULTIVOS">
											</td>
										<td scope="row">
										<select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div>
										</td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>										
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
										</td>
									</tr>
									<tr id="fila4">
										<td scope="row"><label id="mecaniNombre">OTROS</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="OTROS">
											</td>
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
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
		<c:when test="${inf_estado=='matriz'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>MECANISMOS DE PARTICIPACIÓN CIUDADANA:</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div id="actualizar">
						<div class="col-md-12 order-md-1">
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblMecanismoParticipacionCiudadana"
						      	id="TblMecanismoParticipacionCiudadanaActual"
								data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
								data-accionEnExito="ACTUALIZAR">

								<table class="table  table-bordered" >
									<thead>
										<tr>
											<th scope="col" class="tablaingreso" width="12%"
											style="text-align: center; font-size: x-small;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">PONGA SI
											O NO</th>
										<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">NÚMERO DE MECANISMOS IMPLEMENTADOS EN EL AÑO</th>
										<th scope="col" class="tablaingreso" width="25%"
											style="text-align: center; font-size: x-small;">MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>

										</tr>
									</thead>
									<tbody>
									<tr>
										<td scope="row"><label id="meca_nombre"></label> 
											</td>
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="meca_implementado" name="meca_implementado" onchange="validar(this)"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="meca_numero" name="meca_numero"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="meca_medioverifica" name="meca_medioverifica"
											required="required" placeholder="Dirección de página web"
											value="http://">
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
						<input type="hidden" id="meca_cod" name="meca_cod">
					</div>

					<div id="tabla" class="col-md-12 order-md-1">
						<table id="tablaRegistros"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>#</th>	
										<th style="text-align: left; font-size: x-small;">MECANISMOS DE PARTICIPACIÓN CIUDADANA</th>
										<th style="text-align: left; font-size: x-small;">PONGA SI O NO</th>
										<th style="text-align: left; font-size: x-small;">NÚMERO DE MECANISMOS IMPLEMENTADOS EN EL AÑO</th>
										<th style="text-align: left; font-size: x-small;">MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
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
			 $("#actualizar").hide();
			if ('${inf_estado}' == 'matriz') {
				tabla();			
			}
		
});
$("#btnGuardar").click(function(event) {
	var form = $("#TblMecanismoParticipacionCiudadana");	
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
	var parametros = {"infCod" : '${inf_Cod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerMecanismoParticipacionEjecutivo",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
		info:     false,
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
			{data : "contador" },
			{data : "nombre"},
			{data : "implementado"},
			{data : "numero"},			
			{data : "link"},	
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             }  return data;
    }}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.meca_cod);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td").css({
				"font-size"   : "x-small",			
			});	
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var nombre = $(element).parent().parent().find("td:eq(1)").text();
		var opcion = $(element).parent().parent().find("td:eq(2)").text();
		var numero = $(element).parent().parent().find("td:eq(3)").text();
		var link = $(element).parent().parent().find("td:eq(4)").text();
	     $("#actualizar").show();
	     $("#tabla").hide();	 	
		 $("#meca_cod").val(codigo);		 
		 $("#meca_nombre").text(nombre);
		 $("#meca_implementado").val(opcion);		  
		  if(opcion=="SI"){
			 $(".campo").removeAttr('disabled');		
			 $(".campo").prop("required", true); 
			 $("#meca_numero").val(numero);
			 $("#meca_numero").val(numero);
			 $("#meca_medioverifica").val(link);
		  }else if(opcion=="NO"){
			  $(".campo").prop("disabled", "disabled"); 
			  $("#meca_numero").val(numero);		
			  $("#meca_medioverifica").val(link);
			  $("#meca_medioverifica").get(0).type = 'text';
		      $(".campo").removeAttr("required");
		  }
	  
}
$("#btnActualizar").click(function(event) {
			var form = $("#TblMecanismoParticipacionCiudadanaActual")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
				 $(".campo").removeAttr("disabled");
				 $(".numero").removeAttr("disabled");			
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_mecanismo_participacion_ciudadana',columns:columnas,values:valores,condicion:'meca_cod',valorcondicion:$("#meca_cod").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	


$("#miTabla tr td").find("select").change(function () {
    if($(this).closest('td').index() == 1){
        if($(this).val() === "SI"){
            $(this).closest('tr').find(".campo").removeAttr('disabled');     
            $(this).closest('tr').find(".campo").prop("required", true);
            $(this).closest('tr').find(".url").val("http://");
            $(this).closest('tr').find(".url").get(0).type = 'url';
            
            }
        else if($(this).val() === "NO"){
            $(this).closest('tr').find(".campo").prop("disabled", true);
           $(this).closest('tr').find(".campo").val("");
           $(this).closest('tr').find(".campo").removeAttr("required");
           $(this).closest('tr').find(".url").val("NO APLICA");
           $(this).closest('tr').find(".url").get(0).type = 'text';
           $(this).closest('tr').find(".checkbox").prop("disabled", true);
           $(this).closest('tr').find(".bloqueo").val("0");
           $(this).closest('tr').find(".numero").val("0");
           
        }
        else{
        	   $(this).closest('tr').find(".campo").prop("disabled", true);
               $(this).closest('tr').find(".campo").val("");
               $(this).closest('tr').find(".campo").prop("required", true);
      
               $(this).closest('tr').find(".url").val("");
               $(this).closest('tr').find(".url").get(0).type = 'url';
               $(this).closest('tr').find(".url").prop("disabled", true);
               $(this).closest('tr').find(".url").prop("required", true);
               $(this).closest('tr').find(".numero").val("");
               $(this).closest('tr').find(".numero").prop("required", true);
               $(this).closest('tr').find(".numero").prop("disabled", true);
        	mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
            }
    }

});

function validar(elemento) {

	if ($(elemento).val() === "SI"){
		 $(".campo").removeAttr('disabled');		
		 $(".campo").prop("required", true);
		 $(".numero").val("");
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
	}
	else if($(elemento).val() === "NO"){
		    $(".campo").prop("disabled", "disabled");
			$(".numero").val("0");
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
		
	}else{
		 $(".campo").prop("disabled", true);
		 $(".campo").val("");
		 $(".campo").prop("required", true);  
		 $(".url").val("");
		 $(".url").get(0).type = 'url';
		 $(".url").prop("disabled", true);
		 $(".url").prop("required", true);
         $(".numero").val("");
         $(".numero").prop("required", true);
         $(".numero").prop("disabled", true);
    	mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
	}
}

</script>