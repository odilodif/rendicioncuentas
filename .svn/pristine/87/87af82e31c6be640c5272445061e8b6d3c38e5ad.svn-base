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
		<h5>CUMPLIMIENTO DE PARÁMETROS DEL PROYECTO COMUNICACIONAL (LOC Art.5 / LOCPCCS Art. 10)</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblCumplimientoMedios" id="TblCumplimientoMediosGuardar"
						data-rutaAplicacion="rendicion" data-opcion="guardarTblCumplimientoMedios"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">PARÁMETROS DE LOS CONTENIDOS COMUNICACIONALES</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">FRECUENCIA</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
											<th scope="col" class="tablaingreso" width="8%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									<td scope="row">
									<label id="mecaniNombre" style="text-align: center; font-size: x-small;">${proyecto}</label>
									<input type="hidden" class="form-control form-control-sm campo"  id=cmValidaProyecto value="${proyecto}" name="cmValidaProyecto" required="required" disabled="disabled"/>
								   </td>
								   <td scope="row">
									<label id="mecaniNombre" style="text-align: center; font-size: x-small;">PARTICIPACIÓN</label>
									<input type="hidden" class="form-control form-control-sm campo"  id="cmDescParametro" value="PARTICIPACIÓN" name="cmDescParametro" required="required" disabled="disabled"/>
								   </td>
									<td scope="row"><select class="custom-select custom-select-sm select" style="text-align: center; font-size: x-small;"
											id="cmOpciones" name="cmOpciones"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="PERIODISMO CIUDADANO">PERIODISMO CIUDADANO</option>
												<option value="COMUNICACIÓN PÚBLICA">COMUNICACIÓN PÚBLICA</option>
												<option value="PARTICIPACIÓN E INFORMACIÓN COMUNITARIA">PARTICIPACIÓN E INFORMACIÓN COMUNITARIA</option>
												<option value="CAPACITACIÓN INTERNA">CAPACITACIÓN INTERNA</option>
												<option value="CAPACITACIÓN EXTERNA">CAPACITACIÓN EXTERNA</option>
												<option value="NO SE IMPLEMENTÓ NINGÚN ENFOQUE">NO SE IMPLEMENTÓ NINGÚN ENFOQUE</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm texto" id="cmNomPrograma"
											name="cmNomPrograma" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										<td scope="row"><select class="custom-select custom-select-sm select campo"
											id="cmFrecuencia" name="cmFrecuencia" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="DIARIO">DIARIO</option>
												<option value="SEMANAL">SEMANAL</option>
												<option value="QUINCENAL">QUINCENAL</option>
												<option value="MENSUAL">MENSUAL</option>
												<option value="NO SE IMPLEMENTÓ NINGÚN ENFOQUE">NO SE IMPLEMENTÓ NINGÚN ENFOQUE</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm texto" id="cmDescProgramacion"
											name="cmDescProgramacion" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
									<td scope="row"><input type="text"
										class="form-control form-control-sm numero" id="cmPorcDifusion"
										name="cmPorcDifusion" required="required" onkeypress="javascript:return validardecimal(event);"  placeholder="00.00" maxlength="20"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="cmLink" name="cmLink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											<input type="hidden" id="CmTipo" name="CmTipo" value="PARTICIPACIÓN">
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
						modelAttribute="TblPlanTrabajoGad" id="Actualizarplantrabajo"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">


						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">PARÁMETROS DE LOS CONTENIDOS COMUNICACIONALES</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">FRECUENCIA</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
											<th scope="col" class="tablaingreso" width="8%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									<td scope="row">
									<label id="cm_valida_proyecto" style="text-align: center; font-size: x-small;"></label>
								   </td>
								   <td scope="row">
									<label id="cm_desc_parametro" style="text-align: center; font-size: x-small;"></label>
								 </td>
									<td scope="row"><select class="custom-select custom-select-sm select" style="text-align: center; font-size: x-small;"
											id="cm_opciones" name="cm_opciones"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="PERIODISMO CIUDADANO">PERIODISMO CIUDADANO</option>
												<option value="COMUNICACIÓN PÚBLICA">COMUNICACIÓN PÚBLICA</option>
												<option value="PARTICIPACIÓN E INFORMACIÓN COMUNITARIA">PARTICIPACIÓN E INFORMACIÓN COMUNITARIA</option>
												<option value="CAPACITACIÓN INTERNA">CAPACITACIÓN INTERNA</option>
												<option value="CAPACITACIÓN EXTERNA">CAPACITACIÓN EXTERNA</option>
												<option value="NO SE IMPLEMENTÓ NINGÚN ENFOQUE">NO SE IMPLEMENTÓ NINGÚN ENFOQUE</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm texto" id="cm_nom_programa"
											name="cm_nom_programa" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										<td scope="row"><select class="custom-select custom-select-sm select campo"
											id="cm_frecuencia" name="cm_frecuencia" style="text-align: center; font-size: x-small;"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="DIARIO">DIARIO</option>
												<option value="SEMANAL">SEMANAL</option>
												<option value="QUINCENAL">QUINCENAL</option>
												<option value="MENSUAL">MENSUAL</option>
												<option value="NO SE IMPLEMENTÓ NINGÚN ENFOQUE">NO SE IMPLEMENTÓ NINGÚN ENFOQUE</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><textarea rows="2" cols=""
											class="form-control form-control-sm texto" id="cm_desc_programacion"
											name="cm_desc_programacion" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
									<td scope="row"><input type="text"
										class="form-control form-control-sm numero" id="cm_porc_difusion"
										name="cm_porc_difusion" required="required" onkeypress="javascript:return validardecimal(event);"  placeholder="00.00" maxlength="20"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="cm_link" name="cm_link" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizarPlan"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="cm_cod" name="cm_cod">
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
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">TIENE PROYECTO COMUNICACIONAL</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">PARÁMETROS DE LOS CONTENIDOS COMUNICACIONALES</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">FRECUENCIA</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
											<th scope="col" class="tablaingreso" width="8%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
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
		<h5>CUMPLIMIENTO DE PARÁMETROS DEL PROYECTO COMUNICACIONAL (LOC Art.5 / LOCPCCS Art. 10)</h5>
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
										style="text-align: center; font-size: x-small;">PARÁMETROS DE LOS CONTENIDOS COMUNICACIONALES</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">SELECCIONE LA OPCIÓN O DESCRIBA</th>
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">NOMBRE DEL PROGRAMA/S O ESPACIO/S</th>
											<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">FRECUENCIA</th>
											<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">DESCRIPCIÓN DE LA PROGRAMACIÓN O ESPACIOS IMPRESOS</th>
											<th scope="col" class="tablaingreso" width="8%"
										style="text-align: center; font-size: x-small;">PORCENTAJE DE DIFUSIÓN DE PROGRAMACIÓN</th>
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
  <c:when test="${infestado=='proyecto'}">
  <div>
				<div id="informacion">
					¡Información!... Usted aun no ha llenado la Matriz de Proyecto Comunicacional.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Medio opción Proyecto Comunicacional.
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
        url: "obtenerCumplimientoMediosDerechos",
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
			{data : "cmValidaProyecto"},
			{data : "cmDescParametro"},
			{data : "cmOpciones"},
			{data : "cmNomPrograma"},
			{data : "cmFrecuencia"},
			{data : "cmDescProgramacion"},
			{data : "cmPorcDifusion"},
			{data : "cmLink"},
		 	
		/*{data : "contador" },
		{data : "proyecto"},
		{data : "parametro"},
		{data : "opcion"},
		{data : "programanombre"},
		{data : "frecuencia"},
		{data : "desprograma"},
		{data : "porcentage"},
		{data : "link"},*/
		{ data: "" ,"render": function (data, type, full, meta) {
			   if('${infestado}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Editar</button>';    
		}
                return data;
    }},
    { data: "" ,"render": function (data, type, full, meta) {
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
	     $(row).attr('id', data.cmCod);
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
					var form = $("#TblCumplimientoMediosGuardar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						$(".campo").removeAttr("disabled");
						$(".texto").removeAttr("disabled");
						$(".numero").removeAttr("disabled");
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
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_cumplimiento_medios',campo:'cm_cod'},
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
			var parametro = $(element).parent().parent().find("td:eq(2)").text();
			var opcion = $(element).parent().parent().find("td:eq(3)").text();
			var programa = $(element).parent().parent().find("td:eq(4)").text();
			var frecuencia = $(element).parent().parent().find("td:eq(5)").text();
			var desprogama = $(element).parent().parent().find("td:eq(6)").text();
			var porcentage = $(element).parent().parent().find("td:eq(7)").text();
			var link = $(element).parent().parent().find("td:eq(8)").text();
			 $("#nuevo").hide();
			  $("#actualizar").show();
			  $('#tabla').hide();
			  $("#cm_cod").val(codigo);
			  document.getElementById("cm_valida_proyecto").innerHTML=proyecto;
			  document.getElementById("cm_desc_parametro").innerHTML=parametro;
			  cargarValorComboPorDefecto("cm_opciones",opcion);
			  $("#cm_nom_programa").val(programa);
			  cargarValorComboPorDefecto("cm_frecuencia",frecuencia);
			  $("#cm_desc_programacion").val(desprogama);		
			  $("#cm_porc_difusion").val(porcentage);
			  $("#cm_link").val(link);
			  if (opcion == "NO SE IMPLEMENTÓ NINGÚN ENFOQUE") {
					$(".url").val("NO APLICA");
					$(".texto").val("NO APLICA");
					$(".numero").val("0");
					$(".texto").prop("disabled", "disabled");
					$(".url").prop("disabled", "disabled");
					$(".url").removeAttr("required");				
					 cargarValorComboPorDefecto("cm_frecuencia","NO SE IMPLEMENTÓ NINGÚN ENFOQUE");
					 $(".campo").prop("disabled", "disabled");
					 $(".numero").prop("disabled", "disabled");
					 $(".url").get(0).type = 'text';
				} else {
					 $(".url").get(0).type = 'url';
						$(".url").removeAttr("disabled");
						$(".url").prop("required", true);
						$(".texto").removeAttr("disabled");
						$(".numero").removeAttr("disabled");
						$(".texto").prop("required", true);
						$(".numero").prop("required", true);
						 cargarValorComboPorDefecto("cm_frecuencia",frecuencia);
						 $(".campo").removeAttr("disabled");
				}

		}
		$("#btnActualizarPlan").click(
				function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#Actualizarplantrabajo")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						$(".campo").removeAttr("disabled");
						$(".texto").removeAttr("disabled");
						$(".numero").removeAttr("disabled");
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
						  var data = {tabla: 'esq_rendicioncuentas.tbl_cumplimiento_medios',columns:columnas,values:valores,condicion:'cm_cod',valorcondicion:$("#cm_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
		$("#cmOpciones").change(function() {
			var seleccion = $("#cmOpciones").val();
			 if (seleccion == "NO SE IMPLEMENTÓ NINGÚN ENFOQUE") {
				$(".url").val("NO APLICA");
				$(".texto").val("NO APLICA");
				$(".numero").val("0");
				$(".texto").prop("disabled", "disabled");
				$(".url").prop("disabled", "disabled");
				$(".url").removeAttr("required");				
				 cargarValorComboPorDefecto("cmFrecuencia","NO SE IMPLEMENTÓ NINGÚN ENFOQUE");
				 $(".campo").prop("disabled", "disabled");
				 $(".numero").prop("disabled", "disabled");
				 $(".url").get(0).type = 'text';
			} else {
				 $(".url").get(0).type = 'url';
				$(".url").removeAttr("disabled");
				$(".url").prop("required", true);
				$(".texto").removeAttr("disabled");
				$(".numero").removeAttr("disabled");
				$(".texto").prop("required", true);
				$(".texto").val("");
				$(".numero").val("");
				$(".numero").prop("required", true);
				 cargarValorComboPorDefecto("cmFrecuencia","");
				 $(".campo").removeAttr("disabled");
				$(".url").val("http://");
			}

		});
		$("#cm_opciones").change(function() {
			var seleccion = $("#cm_opciones").val();
			 if (seleccion == "NO SE IMPLEMENTÓ NINGÚN ENFOQUE") {
				$(".url").val("NO APLICA");
				$(".texto").val("NO APLICA");
				$(".numero").val("0");
				$(".texto").prop("disabled", "disabled");
				$(".url").prop("disabled", "disabled");
				$(".url").removeAttr("required");				
				 cargarValorComboPorDefecto("cm_frecuencia","NO SE IMPLEMENTÓ NINGÚN ENFOQUE");
				 $(".campo").prop("disabled", "disabled");
				 $(".numero").prop("disabled", "disabled");
				 $(".url").get(0).type = 'text';
			} else {
				 $(".url").get(0).type = 'url';
				$(".url").removeAttr("disabled");
				$(".url").prop("required", true);
				$(".texto").removeAttr("disabled");
				$(".numero").removeAttr("disabled");
				$(".texto").prop("required", true);
				$(".texto").val("");
				$(".numero").val("");
				$(".numero").prop("required", true);
				 cargarValorComboPorDefecto("cm_frecuencia","");
				 $(".campo").removeAttr("disabled");
				$(".url").val("http://");
			}

		});
	</script>
