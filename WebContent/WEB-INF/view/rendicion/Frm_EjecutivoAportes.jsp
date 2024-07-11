<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoAportes
    Created on	: 22 mar. 2021; 16:16:38
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
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

<div class="card  mb-card15">
<c:choose>
	<c:when test="${inf_estado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR EN LA GESTIÓN INSTITUCIONAL</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblCompromisosInformeant" id="CompromisosInformesAnter"
						data-rutaAplicacion="rendicion" data-opcion="guardarCompromisosInformesAnter"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${inf_Cod}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS REPORTADOS EN LA RENDICIÓN DE CUENTAS DEL PERIODO ANTERIOR</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">¿INCORPORÓ EL APORTE CIUDADANO EN LA GESTIÓN INSTITUCIONAL?(PONGA SÍ O NO)</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PORCENTAJE DE AVANCES DE CUMPLIMIENTO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIPCIÓN DE RESULTADOS</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								</tr>
								<tr>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									<textarea rows="3" cols=""
											class="form-control form-control-sm nombre" id="caNombre"
											name="caNombre" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los principales aportes</div>
									</td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm " id="caImplementado"  onchange="validar(this)" name="caImplementado" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm avance" id="caAvance" name="caAvance" required="required" >
												<option value="">Seleccione...</option>
												<option value="0">0</option>
												<option value="1-25">1-25</option>
												<option value="26-50">26-50</option>
												<option value="51-75">51-75</option>
												<option value="76-100">76-100</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    <td scope="row" style="vertical-align: middle; font-size: x-small;">
								    <textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="caDes"
											name="caDes" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese las demandas</div>
								    </td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
                                    <input type="url" class="form-control form-control-sm url" id="caMedioverif" name="caMedioverif" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				
	
				</div>
		</div>

	</div>

	</c:when>
 <c:when test="${inf_estado=='matriz'}">
 	<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
					<div id="botones"  class="row justify-content-center align-items-center">
						<div class="botones" role="group">
						
						<button type="button" id="_nuevo"
							class="btn _nuevoColor _nuevo btn-sm mt-2" onclick="nuevo(this)">Añadir</button>
						
						</div>
					</div>
		      </c:when>
			</c:choose>	
			<div id="nuevo">
	<div class="card-header text-white carHeaderBlue">
		<h5>INCORPORACIÓN DE LOS APORTES CIUDADANOS DE LA RENDICIÓN DE CUENTAS DEL AÑO ANTERIOR EN LA GESTIÓN INSTITUCIONAL</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblCompromisosInformeant" id="CompromisosInformesAnter"
						data-rutaAplicacion="rendicion" data-opcion="guardarCompromisosInformesAnter"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${inf_Cod}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS REPORTADOS EN LA RENDICIÓN DE CUENTAS DEL PERIODO ANTERIOR</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">¿INCORPORÓ EL APORTE CIUDADANO EN LA GESTIÓN INSTITUCIONAL?(PONGA SÍ O NO)</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PORCENTAJE DE AVANCES DE CUMPLIMIENTO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIPCIÓN DE RESULTADOS</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								</tr>
								<tr>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									<textarea rows="3" cols=""
											class="form-control form-control-sm nombre" id="caNombre"
											name="caNombre" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los principales aportes</div>
									</td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm " id="caImplementado"  onchange="validar(this)" name="caImplementado" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm avance" id="caAvance" name="caAvance" required="required" >
												<option value="">Seleccione...</option>
												<option value="0">0</option>
												<option value="1-25">1-25</option>
												<option value="26-50">26-50</option>
												<option value="51-75">51-75</option>
												<option value="76-100">76-100</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    <td scope="row" style="vertical-align: middle; font-size: x-small;">
								    <textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="caDes"
											name="caDes" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese las demandas</div>
								    </td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
                                    <input type="url" class="form-control form-control-sm url" id="caMedioverif" name="caMedioverif" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnNuevo"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
				
	
				</div>
		</div>

	</div>
	</div>
	<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="tbl_compromisos_informeant" id="CompromisosInformesAnterActul"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<div class="table-responsive-xl">
						<table class="table registros table-bordered">
							<tr>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS REPORTADOS EN LA RENDICIÓN DE CUENTAS DEL PERIODO ANTERIOR</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">¿INCORPORÓ EL APORTE CIUDADANO EN LA GESTIÓN INSTITUCIONAL?(PONGA SÍ O NO)</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">PORCENTAJE DE AVANCES DE CUMPLIMIENTO</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">DESCRIPCIÓN DE RESULTADOS</th>
									<th scope="col" class="tablaingreso" width="" style="vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								</tr>
								<tr>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									<textarea rows="3" cols=""
											class="form-control form-control-sm nombre" id="ca_nombre"
											name="ca_nombre" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los principales aportes</div>
									</td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm " id="ca_implementado"  onchange="validar(this)" name="ca_implementado" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    	<td scope="row" style="vertical-align: middle; font-size: x-small;">
									
									<select class="custom-select custom-select-sm avance" id="ca_avance" name="ca_avance" required="required" >
												<option value="">Seleccione...</option>
												<option value="0">0</option>
												<option value="1-25">1-25</option>
												<option value="26-50">26-50</option>
												<option value="51-75">51-75</option>
												<option value="76-100">76-100</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
								    <td scope="row" style="vertical-align: middle; font-size: x-small;">
								    <textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="ca_des"
											name="ca_des" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese las demandas</div>
								    </td>
									<td scope="row" style="vertical-align: middle; font-size: x-small;">
                                    <input type="url" class="form-control form-control-sm url" id="ca_medioverif" name="ca_medioverif" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="ca_cod" name="ca_cod">
				</div>
				<div id="tabla">
					<table id="tablaRegistrosCompromisosAnt"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th style="font-size:x-small;">DESCRIBA LOS PRINCIPALES APORTES CIUDADANOS REPORTADOS EN LA RENDICIÓN DE CUENTAS DEL PERIODO ANTERIOR</th>
								<th style="font-size:x-small;">¿INCORPORÓ EL APORTE CIUDADANO EN LA GESTIÓN INSTITUCIONAL?(PONGA SÍ O NO)</th>
								<th style="font-size:x-small;">PORCENTAJE DE AVANCES DE CUMPLIMIENTO</th>
								<th style="font-size:x-small;">DESCRIPCIÓN DE RESULTADOS</th>
								<th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
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
	 $("#nuevo").hide();
	 if ('${inf_estado}' == 'matriz') {
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

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$.ajax({
	        url: "obtenerRegistrosCompromisosAnteriores",
	        type: "post",
	        dataType: "json",
	        data: parametros,
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        success: function (result) {
	        	 if (result['Error']) {
	                 $('#tabla').hide();
	             }else if(result['data'].length!=0){
	            	 $('#nuevo').hide();
	        $('#tablaRegistrosCompromisosAnt').DataTable( {   
	        	
	          order: [ 0, "asc" ],
		 	paging : false,
			info : false,
			searching : false,
			responsive : true,
			scrollX : true,
			bDestroy : true,
		      buttons: [   ],
	    data: result.data,
	    columns : [
			{data : "contador" },
			{data : "nombre"},
			{data : "implementado"},
			{data : "avance"},
			{data : "descripcion"},
			{data : "link"},
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
	                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             }return data;
	    }},{ data: "" ,"render": function (data, type, full, meta) {
	    	 if('${infestadoinforme}' === "finalizado"){
	        	 data = '';     
	         }else{
	                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
	         } return data;
	    }} ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		   $(row).attr('id', data.ca_cod);
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
	        }else {}

		 },
	     error: function (errormessage) {
	         alert(errormessage.responseText);
	     }
	 });
	}
	$("#btnGuardar").click(function(event) {
				var form = $("#CompromisosInformesAnter")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {
					$(".nombre").removeAttr("disabled");
					$(".campo").removeAttr("disabled");
					$(".avance").removeAttr("disabled");
					$(".url").removeAttr("disabled");
					ejecutarJson(form);
				}
				form.addClass('was-validated');
	
			});	
	
	$("#btnNuevo").click(function(event) {
		var form = $("#CompromisosInformesAnter")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			$(".nombre").removeAttr("disabled");
			$(".campo").removeAttr("disabled");
			$(".avance").removeAttr("disabled");
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_compromisos_informeant',campo:'ca_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                            mostrarMensaje(msg.mensaje, "EXITO");
	                            var td = element.parentNode;
	                            var tr = td.parentNode;
	                            var table = tr.parentNode;      
	                            table.removeChild(tr);
	                            var nFilas = $("#tablaRegistrosCompromisosAnt tr").length-1;
	                            if (nFilas==0){ 
	                             	 abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
	                        		  $("#nuevo").show();
	                     
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
		var nombre = $(element).parent().parent().find("td:eq(1)").text();
		var implemento = $(element).parent().parent().find("td:eq(2)").text();
		var avance = $(element).parent().parent().find("td:eq(3)").text();
		var descripcion = $(element).parent().parent().find("td:eq(4)").text();
		var url = $(element).parent().parent().find("td:eq(5)").text();
		  $("#nuevo").hide();
		  $("#tabla").hide();
		  $("#botones").hide();
		  $("#actualizar").show();

		  $("#ca_cod").val(codigo);
		  $("#ca_nombre").val(nombre);
		  $("#ca_implementado").val(implemento);
		 
		  $("#ca_avance").val(avance);	
		  $("#ca_des").val(descripcion);		  
		  $("#ca_medioverif").val(url);
		  	  
		  if(implemento=="SI"){	
				 $(".nombre").removeAttr("disabled");
				 $(".nombre").prop("required", true);
			     $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
				 $(".avance").removeAttr('disabled');
				 $(".avance").prop("required", true);		
				 $("#ca_medioverif").get(0).type = 'url';
				 $(".url").removeAttr('disabled');
				 $(".url").prop("required", true);
		  }else if(implemento=="NO"){
			    $(".nombre").removeAttr('disabled');
			    $(".nombre").prop("required", true);
				/*$(".nombre").val("");	
				$(".nombre").prop("disabled", "disabled");
				$(".nombre").removeAttr('required');*/
			    $(".campo").prop("disabled", "disabled");
				$(".campo").removeAttr('required');
				$(".campo").val("");	
				$(".avance").prop("disabled", "disabled");
				$(".url").prop("disabled", "disabled");
				$(".url").val("NO APLICA");		
				$("#ca_medioverif").get(0).type = 'text';
				$(".url").removeAttr('required');
		  }
	}

	function nuevo(element) {	
		
		  $("#nuevo").show();		 
		  $("#tabla").hide();
		  $("#botones").hide();
		  $("#actualizar").hide();
		 
	}

	$("#btnActualizar").click(function(event) {
				var form = $("#CompromisosInformesAnterActul")
				event.preventDefault();
				event.stopPropagation();
				if (form[0].checkValidity() === false) {
					mostrarMensaje(
							"Por favor ingrese toda la información solicitada!",
							"ERROR");
				} else {
					$(".nombre").removeAttr("disabled");
					$(".campo").removeAttr("disabled");
					$(".avance").removeAttr("disabled");
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
					  var data = {tabla: 'esq_rendicioncuentas.tbl_compromisos_informeant',columns:columnas,values:valores,condicion:'ca_cod',valorcondicion:$("#ca_cod").val()};
					  
					  ejecutarJsonUpdate(form,data);
				}
				form.addClass('was-validated');
	
			});	
	function validar(elemento) {
		if ($(elemento).val() === "SI"){
			$(".nombre").removeAttr('disabled');
			 $(".nombre").prop("required", true);
			 //$(".nombre").val("");
			 $(".campo").removeAttr('disabled');
			 $(".campo").prop("required", true);
			 $(".avance").removeAttr('disabled');
			 $(".avance").prop("required", true);
			 $(".avance").val("");
			 $(".url").val("http://");		
			 $(".url").get(0).type = 'url';
			 $(".url").removeAttr('disabled');
			 $(".url").prop("required", true);
		}else if($(elemento).val() === "NO"){
			$(".nombre").removeAttr('disabled');
			 $(".nombre").prop("required", true);
		  /*  $(".nombre").removeAttr('required');
			$(".nombre").prop("disabled", "disabled");*/
			$(".nombre").val("");
			$(".campo").prop("disabled", "disabled");
			$(".campo").removeAttr('required');
			$(".avance").prop("disabled", "disabled");
			$(".avance").val("0");
			$(".url").prop("disabled", "disabled");
			$(".url").val("NO APLICA");		
			$(".url").get(0).type = 'text';
			$(".url").removeAttr('required');
		
		}else{
			$(".nombre").val("");	
			$(".campo").prop("disabled", "disabled");
			$(".campo").removeAttr('required');
			$(".campo").prop("required", true);
			$(".avance").prop("disabled", "disabled");
			$(".avance").val("");
			$(".avance").prop("required", true);
			$(".url").prop("disabled", "disabled");
			$(".url").val("");	
			$(".url").prop("required", true);	
			$(".url").get(0).type = 'url';
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");
		}
	}
	</script>
