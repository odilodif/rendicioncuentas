<%-- 
	version		: 1.0
    Document  	: Frm_PlanTrabajo
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
		<h5>ENAJENACIÓN, DONACIONES Y EXPROPIACIONES DE BIENES:</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblEnajenacionBienes" id="TblEnajenacionBienes"
						data-rutaAplicacion="rendicion" data-opcion="guardarEnagenacion"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infCod" name="infCod"
							value="${infCod}">
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">TIPO</label>
								</div>
								<div class="col-md-2  text-left">
									<select class="custom-select custom-select-sm select"
											id="enbTipo" name="enbTipo"
											required="required" onchange="validar(this)">
												<option value="">Seleccione...</option>
												<option value="ENAJENACIÓN">ENAJENACIÓN</option>
												<option value="EXPROPIACIONES">EXPROPIACIONES</option>
												<option value="DONACIONES RECIBIDAS">DONACIONES RECIBIDAS</option>
												<option value="DONACIONES REALIZADAS">DONACIONES REALIZADAS</option>
												<option value="NINGUNA">NINGUNA</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">BIEN</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo"  id="enbDescripcion" name="enbDescripcion" required="required"/>
									<div class="invalid-feedback">Por Ingrese el tipo de bien</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">VALOR</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="enbValor" name="enbValor" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false"/>
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">LINK</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="enbLink" name="enbLink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Añadir</button>
						</div>
					</form:form>
					<hr />
				</div>
				<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblEnajenacionBienes" id="TblEnajenacionBienesActualizar"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">TIPO</label>
								</div>
								<div class="col-md-2  text-left">
									<select class="custom-select custom-select-sm"
											id="enb_tipo" name="enb_tipo"
											required="required" onchange="validar1(this)">
												<option value="">Seleccione...</option>
												<option value="ENAJENACIÓN">ENAJENACIÓN</option>
												<option value="EXPROPIACIONES">EXPROPIACIONES</option>
												<option value="DONACIONES RECIBIDAS">DONACIONES RECIBIDAS</option>
												<option value="DONACIONES REALIZADAS">DONACIONES REALIZADAS</option>
												<option value="NINGUNA">NINGUNA</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">BIEN</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo"  id="enb_descripcion" name="enb_descripcion" required="required"/>
									<div class="invalid-feedback">Por Ingrese el tipo de bien</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">VALOR</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="enb_valor" name="enb_valor" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false"/>
								    <div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia">LINK</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="enb_link" name="enb_link" required="required" placeholder="Dirección de página web"
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
					<input type="hidden" id="enb_cod" name="enb_cod">
				</div>
				<div id="tabla">
				 <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
								<th width="20%"  style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO</th>
								<th width="20%"  style="text-align: center; vertical-align: middle; font-size: x-small;">BIEN</th>
								<th  style="text-align: center; vertical-align: middle; font-size: x-small;">VALOR TOTAL</th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
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
		<h5>ENAJENACIÓN, DONACIONES Y EXPROPIACIONES DE BIENES:</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<input type="hidden" id="infCod" name="infCod"
							value="${infCod}">
			<div id="tabla">
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
								<th width="20%" style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO</th>
								<th width="20%" style="text-align: center; vertical-align: middle; font-size: x-small;">BIEN</th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;">VALOR TOTAL</th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
								<th style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
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
	 tabla();
	 }
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
        url: "obtenerRegistrosEnagenacion",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {
        	
        	 if (result['Error']) {
                 $('#tabla').hide();
             }else if(result['data'].length!=0){
            	 $('#nuevo').hide();
        $('#tablaRegistros').DataTable( {   
        	
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
    data: result.data,
    columns : [
		{data : "contador" },
		{data : "tipo"},
		{data : "descripcion"},
		{data : "valor"},
		{data : "link"},
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestado}' === "finalizado"){
           	 data = '';     
            }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Editar</button>';    
            }  return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	if('${infestado}' === "finalizado"){
       	 data = '';     
        }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Eliminar</button>';    
        } return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.enbCod);
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
					var form = $("#TblEnajenacionBienes")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						 $(".campo").removeAttr("disabled");
						 $(".url").removeAttr("disabled");
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
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_enajenacion_bienes',campo:'enb_cod'},
			        success: function (msg) {
			            if (msg.estado == "exito") {
	                             mostrarMensaje(msg.mensaje, "EXITO");
	                             var td = element.parentNode;
	                             var tr = td.parentNode;
	                             var table = tr.parentNode;      
	                             table.removeChild(tr);
	                             var nFilas = $("#tablaRegistros tr").length-1;
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
			var tipo = $(element).parent().parent().find("td:eq(1)").text();
			var decripcion = $(element).parent().parent().find("td:eq(2)").text();
			var valor = $(element).parent().parent().find("td:eq(3)").text();
			var link = $(element).parent().parent().find("td:eq(4)").text();
			 $("#nuevo").hide();
			 $("#tabla").hide();
			  $("#actualizar").show();
			  $("#enb_cod").val(codigo);
			  cargarValorComboPorDefecto("enb_tipo",tipo);
			  if(tipo=="NINGUNA"){
				  $(".campo").prop("disabled", "disabled");
					 $(".url").prop("disabled", "disabled");
						$(".campo").val("NO APLICA");
						$(".url").val("NO APLICA");
						$(".valor").val("0");
						 $("#enb_link").get(0).type = 'text';
						$(".campo").removeAttr("required"); 
			  }
			  $("#enb_descripcion").val(decripcion);
			  $("#enb_valor").val(valor);
			  $("#enb_link").val(link);
		}
		$("#btnActualizar").click(
				function(event) {
					var form = $("#TblEnajenacionBienesActualizar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						 $(".campo").removeAttr("disabled");
						 $(".url").removeAttr("disabled");
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
							    	if(field.name=="enb_valor"){
							    		field.value=field.value.replace(/,/g, "");
							    	}
							    	valores+= field.value+ ',99';
							    	if (valores.length > 0) {
							    		valores = valores.substr(0, valores.length - 1);
			                        }
							    });
						  var data = {tabla: 'esq_rendicioncuentas.tbl_enajenacion_bienes',columns:columnas,values:valores,condicion:'enb_cod',valorcondicion:$("#enb_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
		function validar(element) {
			var seleccion = $(element).val();
		    if(seleccion=="NINGUNA"){		    	 
				 $(".campo").prop("disabled", "disabled");
				 $(".url").prop("disabled", "disabled");
					$(".campo").val("NO APLICA");
					$(".url").val("NO APLICA");
					$(".valor").val("0");
					 $(".url").get(0).type = 'text';
					$(".campo").removeAttr("required");
		    }else{
		    	$(".campo").removeAttr('disabled');
		    	 $(".url").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".url").val("http://");
				 $(".campo").val("");
				 $(".url").get(0).type = 'url';
		    }

		}
		function validar1 (element) {
			var seleccion = $(element).val();
		    if(seleccion=="NINGUNA"){		    	 
				 $(".campo").prop("disabled", "disabled");
				 $(".url").prop("disabled", "disabled");
					$(".campo").val("NO APLICA");
					$(".url").val("NO APLICA");
					$(".valor").val("0");
					 $("#enb_link").get(0).type = 'text';
					$(".campo").removeAttr("required");
		    }else{
		    	$(".campo").removeAttr('disabled');
		    	 $(".url").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $("enb_link").val("http://");
				 $(".campo").val("");
				 $("#enb_link").get(0).type = 'url';
		    }

		}
	</script>
