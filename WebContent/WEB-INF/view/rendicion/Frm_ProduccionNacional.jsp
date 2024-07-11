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

<div class="card  mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblProduccionAudiovisual"
					id="TblProduccionAudiovisualGuardar" data-rutaAplicacion="rendicion"
					data-opcion="guardarProduccionAudiovisual"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL(LOC Art. 97)</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table id="tablaproduccion" class="table registros table-bordered">
							<thead>
							<tr>
							    <td class="tablaingreso" style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL</td>
								<td class="tablaingreso" style="font-size: x-small;">PORCENTAJE PROMEDIO SEMANAL</td>
									<td class="tablaingreso" style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</td>
								<td class="tablaingreso" style="font-size: x-small;">NOMBRE DEL PROGRAMA / ESPACIO	</td>
								<td class="tablaingreso" style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</td>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 150px;" rowspan="6"
									align="center"><label id="mecaniNombre">PRODUCCIÓN NACIONAL</label> <input type="hidden" id="paTipo"
											name="paTipo" class="form-control form-control-sm"
											value="PRODUCCIÓN NACIONAL"></td>
									<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number"
									id="paPorcentaje" name="paPorcentaje"  max="150" required="required" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal" min="0">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td style="font-size: x-small;  width: 150px;" ><label id="mecaniNombre">INFORMATIVO</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="INFORMATIVO">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td style="font-size: x-small;  width: 250px;"><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							<tr>
							<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0"
									id="paPorcentaje" name="paPorcentaje"  max="100" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td><label id="mecaniNombre">OPINIÓN</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="OPINIÓN">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							<tr>
							<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0"
									id="paPorcentaje" name="paPorcentaje"  max="100" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td style="font-size: x-small;"><label id="mecaniNombre">FORMATIVO, EDUCATIVO Y CULTURAL</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="FORMATIVO, EDUCATIVO Y CULTURAL">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							<tr>
							<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0"
									id="paPorcentaje" name="paPorcentaje"  max="100" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td style="font-size: x-small;"><label id="mecaniNombre">ENTRETENIMIENTO</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="ENTRETENIMIENTO">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							<tr style="font-size: x-small;">
							<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0" 
									id="paPorcentaje" name="paPorcentaje"  max="100" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td><label id="mecaniNombre">DEPORTIVOS</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="DEPORTIVOS">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							<tr>
							<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0"
									id="paPorcentaje" name="paPorcentaje"  max="100" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td style="font-size: x-small;"><label id="mecaniNombre">PUBLICITARIOS</label> <input type="hidden" id="paContenido"
											name="paContenido" class="form-control form-control-sm"
											value="PUBLICITARIOS">
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="paPeriocidad"
											name="paPeriocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td><input type="url" class="form-control form-control-sm campo url" id="paMedio" name="paMedio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							</tbody>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">
		<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			        <div id="boton">
					<div class="row justify-content-center align-items-center">
						<div class="botones" role="group">
						
						<button type="button" id="_eliminar"
							class="btn _eliminarColor _eliminar btn-sm mt-2" onclick="Eliminar(this)">Eliminar</button>
						
						</div>
					</div>
					</div>
		      </c:when>
			</c:choose>	
			<div id="actualizar">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblProduccionAudiovisual"
					id="TblProduccionAudiovisualUpdate" data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">ESPACIOS PRODUCCIÓN AUDIOVISUAL NACIONAL(LOC Art. 97 y RGLOC Art. 72)</h5>
					<div class="col-md-12 text-left">

						<table id="tablaproduccion"  class="table registros table-bordered">
							<thead>
							<tr>
							    <td class="tablaingreso" style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL</td>
								<td class="tablaingreso" style="font-size: x-small;">PORCENTAJE PROMEDIO SEMANAL</td>
									<td class="tablaingreso" style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</td>
								<td class="tablaingreso" style="font-size: x-small;">NOMBRE DEL PROGRAMA / ESPACIO	</td>
								<td class="tablaingreso" style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</td>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td style="vertical-align: middle; font-size: x-small; width: 150px;" 
									align="center"><label id="pa_tipo"></label></td>
									<td style="vertical-align: middle; font-size: x-small; width: 100px;" 
									align="center"><input type="number" min="0"
									id="pa_porcentaje" name="pa_porcentaje"  max="150" required="required" onkeypress="javascript:return validardecimal(event);"
									step="0.01" class="form-control form-control-sm numberTotal">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
								<td style="font-size: x-small;  width: 150px;" ><label id="pa_contenido"></label> 
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 250px; font-size: x-small;"><textarea rows="2" cols=""
											class="form-control form-control-sm campo" id="pa_periocidad"
											name="pa_periocidad" required="required"></textarea>
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
									<td style="font-size: x-small;  width: 250px;"><input type="url" class="form-control form-control-sm campo url" id="pa_medio" name="pa_medio" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							</tr>
							</tbody>

						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
					</div>
					<input type="hidden" id="pa_cod" name="pa_cod">
				</form:form>
			</div>
			<div id="tablanacional">
			<table id="TablaImplePresu"class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL</th>
						<th style="font-size: x-small;">PORCENTAJE PROMEDIO SEMANAL</th>
						<th style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</th>
						<th style="font-size: x-small;">NOMBRE DEL PROGRAMA / ESPACIO</th>
						<th style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
				<tfoot>
            <tr>
                <th colspan="2" style="text-align:right">Total:</th>
                <th></th>
            </tr>
        </tfoot>				
			</table>
			</div>
		</c:when>
		 <c:when test="${inf_estado=='finalizado'}">
		 <table id="TablaImplePresu"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">CUMPLIMIENTO DE ESPACIOS DE PRODUCCIÓN AUDIOVISUAL NACIONAL</th>
						<th style="font-size: x-small;">PORCENTAJE PROMEDIO SEMANAL</th>
						<th style="font-size: x-small;">DETALLE TIPO DE CONTENIDO</th>
						<th style="font-size: x-small;">NOMBRE DEL PROGRAMA / ESPACIO</th>
						<th style="font-size: x-small;">MEDIOS DE VERIFICACIÓN</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>	
				<tfoot>
            <tr>
                <th colspan="2" style="text-align:right">Total:</th>
                <th></th>
            </tr>
        </tfoot>			
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
		if ('${inf_estado}' == 'matriz'||'${inf_estado}' == 'finalizado') {
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
		 $("#actualizar").hide();
	});




	$("#btnGuardarI").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#TblProduccionAudiovisualGuardar")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
				$(".campo").removeAttr("disabled");
				$(".url").removeAttr("disabled");
					ejecutarJson(form);
				 	
				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}',"tipo":"PRODUCCIÓN NACIONAL"};
		$('#TablaImplePresu').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerProduccionAudiovisual",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],	
		bDestroy : true,
		  info : false,
		  searching : false,
		columns : [
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
			{data : "paTipo"},
			{data : "paPorcentaje"}, 
			{data : "paContenido"},
			{data : "paPeriocidad"}, 
			{data : "paMedio"}, 
			/*{data : "contador"},
			{data : "tipo"},
			{data : "porcentage"}, 
			{data : "contenido"},
			{data : "programa"}, 
			{data : "link"}, 	*/
			{ data: "" ,"render": function (data, type, full, meta) {
				if('${infestadoinforme}' === "finalizado"){
		           	 data = '';     
		            }else{
		                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Editar</button>';    
		            }  return data;
		    }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.paCod);				
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});
				$(row).find("td:eq(1)").attr('title', data.tipo);	
				
				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	

				$(row).find("td").css({
					"vertical-align" : "middle",
				});
		
			},	 "footerCallback": function ( row, data, start, end, display ) {
	            var api = this.api(), data;
	            
	            // Remove the formatting to get integer data for summation
	            var intVal = function ( i ) {
	                return typeof i === 'string' ?
	                    i.replace(/[\$,]/g, '')*1 :
	                    typeof i === 'number' ?
	                        i : 0;
	            };
	 
	            // Total over all pages
	            total = api
	                .column(2)
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Total over this page
	            pageTotal = api
	                .column( 2, { page: 'current'} )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $( api.column(2).footer() ).html(
	                pageTotal+' %' 
	            );
	        }
			
		});

	}

	function Eliminar(element) {	
		   var codigo ='${inf_Cod}';	
		 Swal.fire({
			  title: 'ATENCIÓN',
			  text: '¿Está seguro de Eliminar la Matriz?',
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonClass: "btn-info",
			  cancelButtonColor: '#d33',
			  confirmButtonText: "Aceptar",
	          cancelButtonText: 'Cancelar',
			}).then((result) => {
			  if (result.value) {
					
				  $.ajax({
				        url: 'view/rendicion/eliminarDatosproduccion',
				        headers: {"X-CSRF-TOKEN": csrfToken},
				        type: "POST",
				        dataType: 'json',
				        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_produccion_audiovisual',campo:'inf_cod',tipo:"pa_tipo",valor:"PRODUCCIÓN NACIONAL"},
				        success: function (msg) {
				            if (msg.estado == "exito") {
		                             mostrarMensaje(msg.mensaje, "EXITO");
		                             var td = element.parentNode;
		                             var tr = td.parentNode;
		                             var table = tr.parentNode;      
		                             table.removeChild(tr);
		                                                        	
		                             abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
		                                 
		                        
		                   } else {
		                        $("#cargando").delay("slow").fadeOut();
		                        
		                             mostrarMensaje(msg.mensaje, "ERROR");
		                   }
				        },
				        error: function (result) {

				        }
				    });
				    
			  }else{
				  return false;
			  }
			})
	}

	function Modificar(element) {	
		var codigo = $(element).closest('tr').attr('id');
		var proyecto = $(element).parent().parent().find("td:eq(1)").text();
		var porcentage = $(element).parent().parent().find("td:eq(2)").text();
		var detalle = $(element).parent().parent().find("td:eq(3)").text();
		var programa = $(element).parent().parent().find("td:eq(4)").text();
		var link = $(element).parent().parent().find("td:eq(5)").text();
		  $("#actualizar").show();
		  $('#tablanacional').hide();
		  $('#boton').hide();
		  $("#pa_cod").val(codigo);
		  document.getElementById("pa_tipo").innerHTML=proyecto;
		  document.getElementById("pa_contenido").innerHTML=detalle;
		  $("#pa_porcentaje").val(parseInt(porcentage));
		  $("#pa_periocidad").val(programa);	  
		  $("#pa_medio").val(link);
		  if(parseInt(porcentage)==0){
			    $(".campo").prop("disabled", true);
		        $(".campo").val("");
		        $(".campo").removeAttr("required");
		        $(".campo").val("NO APLICA");
		        $(".url").val("NO APLICA");
		        $(".url").get(0).type = 'text';
		   }else{
			   $(".campo").val("");
			   $(".campo").removeAttr('disabled');
		       $(".campo").prop("required", true);
		       $(".url").val("http://");
		       $(".url").get(0).type = 'url'; 
		   }
	}

	$("#btnActualizar").click(
			function(event) {
				var form = $("#TblProduccionAudiovisualUpdate")
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
						    	valores+= field.value+ ',99';
						    	if (valores.length > 0) {
						    		valores = valores.substr(0, valores.length - 1);
		                        }
						    });
					  var data = {tabla: 'esq_rendicioncuentas.tbl_produccion_audiovisual',columns:columnas,values:valores,condicion:'pa_cod',valorcondicion:$("#pa_cod").val()};
					 
					  ejecutarJsonUpdate(form,data);
				}
				form.addClass('was-validated');

			});	
	
	$("#tablaproduccion tr td").find(".numberTotal").change(function () {		  
		var row = $(this).closest('tr');
		var total = 0;
		$('.numberTotal', row).each(function() {
	        total += Number($(this).val());
	    });
	   if(total==0){
		    $(this).closest('tr').find(".campo").prop("disabled", true);
	        $(this).closest('tr').find(".campo").val("");
	        $(this).closest('tr').find(".campo").removeAttr("required");
	        $(this).closest('tr').find(".campo").val("NO APLICA");
	        $(this).closest('tr').find(".url").val("NO APLICA");
	        $(this).closest('tr').find(".url").get(0).type = 'text';
	   }else{
		   $(this).closest('tr').find(".campo").val("");
		   $(this).closest('tr').find(".campo").removeAttr('disabled');
	       $(this).closest('tr').find(".campo").prop("required", true);
	       $(this).closest('tr').find(".url").val("http://");
	       $(this).closest('tr').find(".url").get(0).type = 'url'; 
	   }
	});
</script>