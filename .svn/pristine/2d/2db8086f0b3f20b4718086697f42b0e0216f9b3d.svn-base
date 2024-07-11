<%-- 
	version		: 1.0
    Document  	: Frm_SugerenciasCiudadanas
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
		<h5>DESCRIBA LAS SUGERENCIAS CIUDADANAS PLANTEADAS A LA GESTIÓN DEL GAD EN LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA</h5>
	</div>
	<div id="Mensaje">
		<div class="alert alert-primary" role="alert">Ingrese una a una las sugerencias ciudadanas</div>
		</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblSugerenciaCiudadana" id="tblSugerenciaciudadana"
						data-rutaAplicacion="rendicion" data-opcion="guardarSugerenciaCiudadana"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DEMANDAS PLANTEADAS POR LA ASAMBLEA CIUDADANA / CIUDADANÍA</th>
									<th scope="col" class="tablaingreso" width="11%"
										style="text-align: center; font-size: x-small;">¿SE TRANSFORMÓ EN COMPROMISO EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS?</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">
										LINK AL MEDIO DE VERIFICACIÓN (Acta de la deliberación pública firmada por los delegados de la Asamblea / ciudadanía)</th>
									
								</tr>
								<tr>
									<td scope="row"><textarea rows="4" cols=""
											class="form-control form-control-sm campo" id="secDemandas"
											name="secDemandas" required="required"></textarea>
										<div class="invalid-feedback">Por Ingrese las demandas</div></td>
									<td scope="row">
									<select class="custom-select custom-select-sm " id="secValida"  onchange="validar(this)" name="secValida" required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div></td>
									<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo" id="secMedioVerificacione" name="secMedioVerificacione" required="required" placeholder="Dirección de página web" value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

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
						modelAttribute="tbl_sugerencia_ciudadana" id="ActualizarSugerencia"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">


						<div class="table-responsive-xl">
						<table class="table registros table-bordered">
							<tr>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">DEMANDAS PLANTEADAS POR LA ASAMBLEA CIUDADANA / CIUDADANÍA</th>
									<th scope="col" class="tablaingreso" width="11%"
										style="text-align: center; font-size: x-small;">¿SE TRANSFORMÓ EN COMPROMISO EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS?</th>
									<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">
										LINK AL MEDIO DE VERIFICACIÓN (Acta de la deliberación pública firmada por los delegados de la Asamblea / ciudadanía)</th>
									
								</tr>
								<tr>
									<td scope="row"><textarea rows="3" cols=""
											class="form-control form-control-sm campo" id="sec_demandas"
											name="sec_demandas" required="required" ></textarea>
										<div class="invalid-feedback">Por Ingrese las demandas</div></td>
									<td scope="row">
									<select class="custom-select custom-select-sm" id="sec_valida"
												name="sec_valida" required="required" onchange="validar(this)" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div></td>
									<td scope="row">
									 <input type="url" class="form-control form-control-sm campo" id="sec_medio_verificacione" name="sec_medio_verificacione" required="required" placeholder="Dirección de página web" value="http://" >
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
					<input type="hidden" id="sec_code" name="sec_code">
				</div>
				<div id="tabla">
				<div class="row justify-content-center align-items-center">
	
		       <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
	            </div>
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th style="font-size:x-small;">DEMANDAS PLANTEADAS POR LA ASAMBLEA CIUDADANA / CIUDADANÍA</th>
								<th style="font-size:x-small;">¿SE TRANSFORMÓ EN COMPROMISO EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS?</th>
								<th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>
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
		<h5>DESCRIBA LAS SUGERENCIAS CIUDADANAS PLANTEADAS A LA GESTIÓN DEL GAD EN LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
			<div id="tabla">
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th style="font-size:x-small;">DEMANDAS PLANTEADAS POR LA ASAMBLEA CIUDADANA / CIUDADANÍA</th>
								<th style="font-size:x-small;">¿SE TRANSFORMÓ EN COMPROMISO EN LA DELIBERACIÓN PÚBLICA DE RENDICIÓN DE CUENTAS?</th>
								<th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>
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
        url: "obtenerRegistrosSugerencias",
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
        data: result.data,
    columns : [
		{data : "contador" },
		{data : "demandas"},
		{data : "valida"},
		{data : "link"},
		{ data: "" ,"render": function (data, type, full, meta) {
			 if('${infestado}' === "finalizado"){
            	 data = '';     
             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
             }return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	 if('${infestado}' === "finalizado"){
        	 data = '';     
         }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
         } return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.secCode);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }else{}
	 },
     error: function (errormessage) {
         alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardar").click(
				function(event) {
					var form = $("#tblSugerenciaciudadana")
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
		function Eliminar(element) {	
			var codigo = $(element).closest('tr').attr('id');	
			 $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_sugerencia_ciudadana',campo:'sec_code'},
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
			var demanda = $(element).parent().parent().find("td:eq(1)").text();
			var valida = $(element).parent().parent().find("td:eq(2)").text();
			var url = $(element).parent().parent().find("td:eq(3)").text();
			 $("#nuevo").hide();
			  $("#actualizar").show();
			  $("#sec_code").val(codigo);
			  $("#sec_demandas").val(demanda);
			  cargarValorComboPorDefecto("sec_valida",valida);
			  $("#sec_medio_verificacione").val(url);
			  if(valida=="SI"){
				  $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true); 
			  }else if(valida=="NO"){
				  $(".campo").prop("disabled", "disabled");
					$("#sec_demandas").val("");
					$("#sec_medio_verificacione").val("http://");
					$(".campo").removeAttr("required");
			  }
		}
		$("#btnActualizar").click(
				function(event) {
					var form = $("#ActualizarSugerencia")
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
							    	valores+= field.value+ ',99';
							    	if (valores.length > 0) {
							    		valores = valores.substr(0, valores.length - 1);
			                        }
							    });
						  var data = {tabla: 'esq_rendicioncuentas.tbl_sugerencia_ciudadana',columns:columnas,values:valores,condicion:'sec_code',valorcondicion:$("#sec_code").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
		function validar(elemento) {
			if ($(elemento).val() === "SI"){
				 $(".campo").removeAttr('disabled');
				 $(".campo").prop("required", true);
			}else if($(elemento).val() === "NO"){
				$(".campo").prop("disabled", "disabled");
				$("#sec_demandas").val("");
				$("#sec_medio_verificacione").val("http://");
				$(".campo").removeAttr("required");
			}else
			
			{
				
			}
		}
	</script>
