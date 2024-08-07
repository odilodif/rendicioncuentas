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
		<h5>TIPO DE DERECHOS DE AUTORES</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblDerechosAutor" id="TblDerechosAutorGuardar"
						data-rutaAplicacion="rendicion" data-opcion="guardarTblDerechosAutor"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">

						<input type="hidden" id="infCod" name="infCod"
							value="${codigo_informe}">
						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="15%"
										style="text-align: center; font-size: x-small;">TIPO DE DERECHOS DE AUTORES APROBADOS POR LA SENADI</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS POR TIPO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS PAGADOS</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									
									<td scope="row"><select class="custom-select custom-select-sm select" style="text-align: center; font-size: x-small;"
											id="daTipo" name="daTipo"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="NOVELAS">NOVELAS</option>
												<option value="POEMAS">POEMAS</option>
												<option value="OBRAS DE TEATRO">OBRAS DE TEATRO</option>
												<option value="PROGRAMAS INFORMATIVOS">PROGRAMAS INFORMATIVOS</option>
												<option value="PELICULAS">PELICULAS</option>
												<option value="COMPOSICIONES MUSICALES">COMPOSICIONES MUSICALES</option>
												<option value="COREOGRAFIA">COREOGRAFIA</option>
												<option value="PINTURA">PINTURA</option>
												<option value="DIBUJOS">DIBUJOS</option>
												<option value="FOTOGRAFIAS">FOTOGRAFIAS</option>
												<option value="PUBLICIDAD">PUBLICIDAD</option>
												<option value="OTRAS">OTRAS</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><input type="text"
										class="form-control form-control-sm" id="daNumero"
										name="daNumero" required="required" onkeypress="javascript:return validarnro(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										
									<td scope="row"><input type="text"
										class="form-control form-control-sm" id="daNumeropagado"
										name="daNumeropagado" required="required" onkeypress="javascript:return validarnro(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="dalink1" name="dalink1" required="required" placeholder="Dirección de página web"
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
						modelAttribute="TblPlanTrabajoGad" id="Actualizarderechos"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">


						<div class="table-responsive-xl">
							<table class="table registros table-bordered">
								<tr>
									<th scope="col" class="tablaingreso" width="15%"
										style="text-align: center; font-size: x-small;">TIPO DE DERECHOS DE AUTORES APROBADOS POR LA SENADI</th>
									<th scope="col" class="tablaingreso" width="7%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS POR TIPO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS PAGADOS</th>
											<th scope="col" class="tablaingreso" width="30%"
										style="text-align: center; font-size: x-small;">LINK MEDIO DE VERIFICACIÓN</th>
								</tr>
								<tr>
									
									<td scope="row"><select class="custom-select custom-select-sm select" style="text-align: center; font-size: x-small;"
											id="da_tipo" name="da_tipo"
											required="required" >
												<option value="">Seleccione...</option>
												<option value="NOVELAS">NOVELAS</option>
												<option value="POEMAS">POEMAS</option>
												<option value="OBRAS DE TEATRO">OBRAS DE TEATRO</option>
												<option value="PROGRAMAS INFORMATIVOS">PROGRAMAS INFORMATIVOS</option>
												<option value="PELICULAS">PELICULAS</option>
												<option value="COMPOSICIONES MUSICALES">COMPOSICIONES MUSICALES</option>
												<option value="COREOGRAFIA">COREOGRAFIA</option>
												<option value="PINTURA">PINTURA</option>
												<option value="DIBUJOS">DIBUJOS</option>
												<option value="FOTOGRAFIAS">FOTOGRAFIAS</option>
												<option value="PUBLICIDAD">PUBLICIDAD</option>
												<option value="OTRAS">OTRAS</option>
										</select>
										<div class="invalid-feedback">Por Seleccione tipo</div></td>
										<td scope="row"><input type="text"
										class="form-control form-control-sm" id="da_numero"
										name="da_numero" required="required" onkeypress="javascript:return validarnro(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese los Resultados</div></td>
										
									<td scope="row"><input type="text"
										class="form-control form-control-sm" id="da_numeropagado"
										name="da_numeropagado" required="required" onkeypress="javascript:return validarnro(event);"  placeholder="00.00" maxlength="5"/>
										<div class="invalid-feedback">Por Ingrese el Porcentage</div></td>
										
									<td scope="row"><input type="url" class="form-control form-control-sm url"  id="dalink" name="dalink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											</td>

								</tr>
							</table>
						</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizarPlan"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="da_cod" name="da_cod">
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
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">TIPO DE DERECHOS DE AUTORES APROBADOS POR LA SENADI</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS POR TIPO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS PAGADOS</th>
											<th scope="col" class="tablaingreso" width="40%"
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
		<h5>TIPO DE DERECHOS DE AUTORES</h5>
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
									<th scope="col" class="tablaingreso" width="20%"
										style="text-align: center; font-size: x-small;">TIPO DE DERECHOS DE AUTORES APROBADOS POR LA SENADI</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS POR TIPO</th>
									<th scope="col" class="tablaingreso" width="10%"
										style="text-align: center; font-size: x-small;">NÚMERO DE DERECHOS PAGADOS</th>
											<th scope="col" class="tablaingreso" width="40%"
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
            "infCod" :$("#infCod").val()
        };
	$.ajax({
        url: "obtenerMediosDerechos",
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
	      searching: true,
	      select: true,
	     
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
		{data : "daTipo"},
		{data : "daNumero"},
		{data : "daNumeropagado"},
		{data : "dalink"},

    	/*{data : "contador" },
		{data : "tipo"},
		{data : "numero"},
		{data : "numeropagado"},
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
	     $(row).attr('id', data.daCod);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }else{
        	   $('#tabla').hide();
               $('#nuevo').show();
        }
	 },
     error: function (errormessage) {
        // alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardar").click(
				function(event) {
					var form = $("#TblDerechosAutorGuardar")
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
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_derechos_autor',campo:'da_cod'},
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
			var opcion = $(element).parent().parent().find("td:eq(1)").text();
			var numero = $(element).parent().parent().find("td:eq(2)").text();
			var nemeropagado = $(element).parent().parent().find("td:eq(3)").text();
			var link = $(element).parent().parent().find("td:eq(4)").text();
			 $("#nuevo").hide();
			  $("#actualizar").show();
			  $('#tabla').hide();
			  $("#da_cod").val(codigo);
			  cargarValorComboPorDefecto("da_tipo",opcion);
			  $("#da_numero").val(numero);
			  $("#da_numeropagado").val(nemeropagado);		
			  $("#dalink").val(link);
		}
		$("#btnActualizarPlan").click(
				function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#Actualizarderechos")
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
						  var data = {tabla: 'esq_rendicioncuentas.tbl_derechos_autor',columns:columnas,values:valores,condicion:'da_cod',valorcondicion:$("#da_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	
	</script>
