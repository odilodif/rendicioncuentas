<%-- 
	version		: 1.0
    Document  	: Frm_PromocionDerechos
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
		<h5>RECLAMOS PRESENTADOS POR LA CIUDADANÍA. Reglamento General LOC Art. 23</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblReclamosMedios" id="TblReclamosMediosGuardar"
						data-rutaAplicacion="rendicion" data-opcion="guardarTblReclamosMedios"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">RECLAMOS PRESENTADOS POR</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE RECLAMOS PRESENTADOS</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS EN PROCESO INGRESADOS</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">TIPO DE RECLAMO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS FAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS DESFAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									<td scope="row"><select class="custom-select custom-select-sm select"
											id="rmPresentado" name="rmPresentado" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="LA CIUDADANIA">LA CIUDADANIA</option>
												<option value="DEFENSOR DE AUDIENCIAS">DEFENSOR DE AUDIENCIAS</option>
												<!-- <option value="SUPERCOM">SUPERCOM</option> -->
												<option value="NO SE RECIBIERON APORTES">NO SE RECIBIERON APORTES</option>
												
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
								   <td scope="row">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="rmNreclamos" name="rmNreclamos" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								   </td>
									<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rmNproceso" name="rmNproceso" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
										<td scope="row"><select class="custom-select custom-select-sm select campo"
											id="rmTipoReclamo" name="rmTipoReclamo" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="DERECHO A LA RECTIFICACIÓN">DERECHO A LA RECTIFICACIÓN</option>
												<option value="DERECHOS A LA RÉPLICA">DERECHOS A LA RÉPLICA</option>
												<option value="RECLAMO">RECLAMO</option>
												<option value="NO SE RECIBIERON APORTES">NO SE RECIBIERON APORTES</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rmNreclamofavorable" name="rmNreclamofavorable" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
										<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rmNreclamodesfavorable" name="rmNreclamodesfavorable" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="rmLink" name="rmLink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											
											</td>

								</tr>
							</table>
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
						modelAttribute="TblPlanTrabajoGad" id="ActualizarReclamos"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">


						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">RECLAMOS PRESENTADOS POR</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE RECLAMOS PRESENTADOS</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS EN PROCESO INGRESADOS</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">TIPO DE RECLAMO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS FAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS DESFAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									<td scope="row"><select class="custom-select custom-select-sm select"
											id="rm_presentado" name="rm_presentado" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="LA CIUDADANIA">LA CIUDADANIA</option>
												<option value="DEFENSOR DE AUDIENCIAS">DEFENSOR DE AUDIENCIAS</option>
											<!-- 	<option value="SUPERCOM">SUPERCOM</option> -->
												<option value="NO SE RECIBIERON APORTES">NO SE RECIBIERON APORTES</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
								   <td scope="row">
									<input type="text" onkeypress="javascript:return validarnro(event);"
									id="rm_nreclamos" name="rm_nreclamos" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div>
								   </td>
									<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rm_nproceso" name="rm_nproceso" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
										<td scope="row"><select class="custom-select custom-select-sm select campo"
											id="rm_tipo_reclamo" name="rm_tipo_reclamo" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="DERECHO A LA RECTIFICACIÓN">DERECHO A LA RECTIFICACIÓN</option>
												<option value="DERECHOS A LA RÉPLICA">DERECHOS A LA RÉPLICA</option>
												<option value="RECLAMO">RECLAMO</option>
												<option value="NO SE RECIBIERON APORTES">NO SE RECIBIERON APORTES</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rm_nreclamofavorable" name="rm_nreclamofavorable" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
										<td scope="row"><input type="text" onkeypress="javascript:return validarnro(event);"
									id="rm_nreclamodesfavorable" name="rm_nreclamodesfavorable" min="" max="100"
									step="0.01" class="form-control form-control-sm number">
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="rm_link" name="rm_link" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											
											</td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="rm_cod" name="rm_cod">
				</div>
				<div id="tabla">
				<div class="row justify-content-center align-items-center">
	
		       <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
	            </div>
	              <hr/>
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
							<th></th>
									<th scope="col" class="tablaingreso" width="15%"
										style="text-align: center; font-size: x-small;">RECLAMOS PRESENTADOS POR:</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">NÚMERO DE RECLAMOS PRESENTADOS</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS EN PROCESO INGRESADOS</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">TIPO DE RECLAMO</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS FAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">CANTIDAD DE RECLAMOS DESFAVORABLES PARA EL USUARIO</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
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
		<h5>CUMPLIMIENTO DE PARÁMETROS DEL PROYECTO COMUNICACIONAL (LOC Art.110 / LOCPCCS Art. 10)</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
 <input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
 <table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
						<tr>
						<th></th>
								<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">PARÁMETROS DEL PLAN DE COMUNICACIÓN</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">FRECUENCIA</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								<th></th>
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
$(document).ready(function(){
	 $("#actualizar").hide();
	 if ('${infestado}' == 'activo'||'${infestado}' == 'finalizado') {
	 tabla();}
});
function tabla() {
	var parametros = {
            "infCod" :$("#infCod").val(),"tipo" :'${tipo}'
        };
	$.ajax({
        url: "obtenerReclamosmedios",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {    	
        	 if (result['Error']) {
                 $('#tabla').hide();
                 $('#nuevo').show();
                 
             } else if(result['data'].length!=0){
            	 $('#nuevo').hide();
        $('#tablaRegistros').DataTable( {          	
          order: [ 0, "asc" ],
	      responsive: true,
	      searching: false,
	      buttons: [
	      {extend: 'copyHtml5'},
          {extend: 'csvHtml5'},
          {extend: 'excelHtml5'},
    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
    {extend: 'print'},
    ],
    data: result.data,
    columns : [
    	{data: "" ,"render": function (data, type, full, meta) {
			 return  meta.row + 1;
		 	}},
		 	{data : "rmPresentado"},
			{data : "rmNreclamos"},
			{data : "rmNproceso"},
			{data : "rmTipoReclamo"},
			{data : "rmNreclamofavorable"},
			{data : "rmNreclamodesfavorable"},
			{data : "rmLink"},	
    	/*{data : "contador" },
		{data : "presentado"},
		{data : "nreclamos"},
		{data : "proceso"},
		{data : "rmTipoReclamo"},
		{data : "reclamofavorable"},
		{data : "rmNreclamodesfavorable"},
		{data : "link"},*/
		{ data: "" ,"render": function (data, type, full, meta) {
			   if('${infestado}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Editar</button>';    
		}
                return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	if('${infestado}' === "finalizado"){
       	 data = '';     
        }else{
    	data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Eliminar</button>';    
        }return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.rmCod);
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
        // alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardar").click(
				function(event) {
					var form = $("#TblReclamosMediosGuardar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						$(".campo").removeAttr("disabled");
						$(".number").removeAttr("disabled");
						$(".url").removeAttr("disabled");
						ejecutarJson(form);
					}
					form.addClass('was-validated');

				});	
		$("#btnNuevo").click(function(event) {
			 $('#tabla').hide();
			 $('#nuevo').show();
		});	
		function Eliminar(element) {	
			var codigo = $(element).closest('tr').attr('id');	
			 $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_reclamos_medios',campo:'rm_cod'},
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
			var proyecto = $(element).parent().parent().find("td:eq(1)").text();
			var reclamos = $(element).parent().parent().find("td:eq(2)").text();
			var proceso = $(element).parent().parent().find("td:eq(3)").text();
			var tipo = $(element).parent().parent().find("td:eq(4)").text();
			var reclamofavorable = $(element).parent().parent().find("td:eq(5)").text();
			var reclamodesfavorable = $(element).parent().parent().find("td:eq(6)").text();
			var link = $(element).parent().parent().find("td:eq(7)").text();
			 $("#nuevo").hide();
			  $("#actualizar").show();
			  $('#tabla').hide();
			  $("#rm_cod").val(codigo);
			  cargarValorComboPorDefecto("rm_presentado",proyecto);
			  cargarValorComboPorDefecto("rm_tipo_reclamo",tipo);
			  $("#rm_nreclamos").val(reclamos);
			  $("#rm_nproceso").val(proceso);
			  $("#rm_nreclamofavorable").val(reclamofavorable);		
			  $("#rm_nreclamodesfavorable").val(reclamodesfavorable);
			  $("#rm_link").val(link);
			  if (proyecto == "NO SE RECIBIERON APORTES") {
					$(".url").val("NO APLICA");
					$(".number").val("0");
					$(".url").prop("disabled", "disabled");
					$(".url").removeAttr("required");				
					 cargarValorComboPorDefecto("rm_tipo_reclamo","NO SE RECIBIERON APORTES");
					 $(".campo").prop("disabled", "disabled");
					 $(".number").prop("disabled", "disabled");
					 $(".url").get(0).type = 'text';
				} else {
					 $(".url").get(0).type = 'url';
					$(".url").removeAttr("disabled");
					$(".url").prop("required", true);
					$(".number").removeAttr("disabled");
					$(".number").val("");
					$(".number").prop("required", true);
					 cargarValorComboPorDefecto("rm_tipo_reclamo","");
					 $(".campo").removeAttr("disabled");
					$(".url").val("http://");
				}
		}
		$("#btnActualizar").click(
				function(event) {
					var form = $("#ActualizarReclamos")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						$(".campo").removeAttr("disabled");
						$(".number").removeAttr("disabled");
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
						  var data = {tabla: 'esq_rendicioncuentas.tbl_reclamos_medios',columns:columnas,values:valores,condicion:'rm_cod',valorcondicion:$("#rm_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
		$("#rmPresentado").change(function() {
			var seleccion = $("#rmPresentado").val();
			 if (seleccion == "NO SE RECIBIERON APORTES") {
				$(".url").val("NO APLICA");
				$(".number").val("0");
				$(".url").prop("disabled", "disabled");
				$(".url").removeAttr("required");				
				 cargarValorComboPorDefecto("rmTipoReclamo","NO SE RECIBIERON APORTES");
				 $(".campo").prop("disabled", "disabled");
				 $(".number").prop("disabled", "disabled");
				 $(".url").get(0).type = 'text';
			} else {
				 $(".url").get(0).type = 'url';
				$(".url").removeAttr("disabled");
				$(".url").prop("required", true);
				$(".number").removeAttr("disabled");
				$(".number").val("");
				$(".number").prop("required", true);
				 cargarValorComboPorDefecto("rmTipoReclamo","");
				 $(".campo").removeAttr("disabled");
				$(".url").val("http://");
			}

		});
		$("#rm_presentado").change(function() {
			var seleccion = $("#rm_presentado").val();
			 if (seleccion == "NO SE RECIBIERON APORTES") {
				$(".url").val("NO APLICA");
				$(".number").val("0");
				$(".url").prop("disabled", "disabled");
				$(".url").removeAttr("required");				
				 cargarValorComboPorDefecto("rm_tipo_reclamo","NO SE RECIBIERON APORTES");
				 $(".campo").prop("disabled", "disabled");
				 $(".number").prop("disabled", "disabled");
				 $(".url").get(0).type = 'text';
			} else {
				 $(".url").get(0).type = 'url';
				$(".url").removeAttr("disabled");
				$(".url").prop("required", true);
				$(".number").removeAttr("disabled");
				$(".number").val("");
				$(".number").prop("required", true);
				 cargarValorComboPorDefecto("rm_tipo_reclamo","");
				 $(".campo").removeAttr("disabled");
				$(".url").val("http://");
			}

		});
	</script>
