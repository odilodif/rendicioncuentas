<%-- 
	version		: 1.0
    Document  	: Frm_ActualizarDetallePoa
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
    Mail		: jc.vega@live.com
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

<div class="card text-center mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDetalleEjecucionp"
					id="ActualizarDetallePoa" data-rutaAplicacion="rendicion"
					data-opcion="guardarActualizarDetallePoa"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE EJECUCIÓN PRESUPUESTARIA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div id="Mensaje">
						<div class="alert alert-primary" role="alert">Seleccione un solo TIPO DE EJECUCIÓN y manténgalo como criterio para completar toda la ejecución presupuestaria de su institución.</div>
					</div>
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th width="30%"></th>
					<th width="70%"></th>
					<tr>
					<td scope="row">
						TIPO DE EJECUCIÓN
					</td>
						<td scope="row">
												
						<select class="custom-select custom-select-sm" id="depTipo"
										required="required" name="depTipo" onchange="corregir()">
										<option value="">Seleccione una Meta</option>
										<c:forEach var="tipoMetas"
											items="${tipoMeta}">
											<option
												value="${tipoMetas}">${tipoMetas}</option>
								</c:forEach>
							</select>
						
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN 
					</td>
						<td scope="row">
						<select class="custom-select custom-select-sm" id="epMeta"
										required="required" name="epMeta" >
										<option value="">elegir tipo de reporte</option>
										<c:forEach var="listadoMetas"
											items="${listadoMetas}">
											<option
												value="${listadoMetas.eprMeta}">${listadoMetas.eprMeta}</option>
								</c:forEach>
							</select>
						<textarea rows="2" cols="" class="form-control form-control-sm"
										id="depDescripcion" required="required"
										name="depDescripcion"
										placeholder="Ingrese la descripcion lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO CODIFICADO: 
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="depPresplan" name="depPresplan" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO EJECUTADO:
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="depPresejec" name="depPresejec" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" >
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						 LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN: 
					</td>
						<td scope="row">
						<!-- <td style="vertical-align: middle;">
							</td> -->
								<input type="url" class="form-control form-control-sm case" id="depLink" name="depLink"  value="http://"
								 required="required">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
						</td>
					</tr>
					</table>
						
					</div>
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
					</div>
				</form:form>
			</div>
		</c:when>
		<c:when test="${inf_estado=='sinEjecucionProgramatica'}">
		
		<div>
				<div id="informacion">
					¡Información!... se requiere que ingrese metas.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú EJECUCIÓN PROGRAMATICA.
				</div>
			</div>
		
		</c:when>
		
		<c:when test="${inf_estado=='matriz'}">
			<div id="ActualizarDatosEp">
				
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDetalleEjecucionp"
					id="ActualizarDetallePoa" data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE EJECUCIÓN PRESUPUESTARIA</h5>
					<div id="Mensaje">
						<div class="alert alert-primary" role="alert">Seleccione un solo TIPO DE EJECUCIÓN y manténgalo como criterio para completar toda la ejecución presupuestaria de su institución.</div>
					</div>
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th width="30%"></th>
					<th width="70%"></th>
					<tr>
					<td scope="row">
						TIPO DE EJECUCIÓN
					</td>
						<td scope="row">
												
							<label id=dep_tipo></label>
						
						
						</td>
					</tr>
					<tr>
					<td scope="row">
						DESCRIPCIÓN 
					</td>
						<td scope="row">
									<label id=dep_descripcion></label>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO CODIFICADO: 
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="dep_presplan" name="dep_presplan" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						PRESUPUESTO EJECUTADO:
					</td>
						<td scope="row">
						<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="dep_presejec" name="dep_presejec" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" >
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
											</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						 LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN: 
					</td>
						<td scope="row">
						<!-- <td style="vertical-align: middle;">
							</td> -->
								<input type="url" class="form-control form-control-sm case" id="dep_link" name="dep_link"  value="http://"
								 required="required">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
						</td>
					</tr>
					</table>
						
					</div>
					<div class="col-md-12 text-center">
				<button type="submit" id="btnActualziarEP"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id=dep_cod name="dep_cod">
			<input type="hidden" id=dep_cumple name="dep_cumple">
				</form:form>
			</div>
			
			
			<div id="DatosEp">
			<div class="card text-center mb-card20">
				<div class="card-body">
			<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
			<div class="row justify-content-center align-items-center">
				<div class="botones" role="group">
					<c:forEach items="${acciones}" var="a">
						<a class="btn ${a[5]} btn-sm" id="${a[2]}"
							data-rutaAplicacion="${a[4]}" data-opcion="${a[1]}"
							data-destino="detalleItem"> <c:if
								test="${a[2]=='_seleccionar'}">
								<span class='cantidadItemsSeleccionados'>0</span>
							</c:if> <c:if test="${a[2]!='_seleccionar'}">
								<span class="${a[2]}"></span>
							</c:if> <span>${a[3]}</span></a>
					</c:forEach>
				</div>
			</div>
			</c:when>
			</c:choose>
			<table id="TablaActualizarDetallePoa"
				class="table table-striped table-bordered" style="width:100%">
				<thead>
					<tr>
						<th width="5%" style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
						<th width="5%" style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO</th>
						<th width="30%" style="text-align: center; vertical-align: middle; font-size: x-small;">DESCRIPCIÓN</th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO CODIFICADO</th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO EJECUTADO</th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;">% CUMPLIMIENTO DEL PRESUPUESTO</th>
						<th width="20%" style="text-align: center; vertical-align: middle; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
						<th width="10%" style="text-align: center; vertical-align: middle; font-size: x-small;"></th>
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



$(document).ready(function() {
		if ('${inf_estado}' == 'matriz') {
			tabla();
		}
		$('#depDescripcion').hide();
		$('#epMeta').hide();

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


		$("#DatosEp").show();
		$("#ActualizarDatosEp").hide();
		
	});

	$("#btnGuardarI").click(function(event) {
		var form = $("#ActualizarDetallePoa")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {

				
					ejecutarJson(form);
					
				 	}
			form.addClass('was-validated');
	});


	function tabla() {
		var parametros = {"infCod" : '${infCod}'};
		$('#TablaActualizarDetallePoa').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerActualizarDetallePoa",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,
		columns : [
			{data : "contador"},
			{data : "depTipo"},
			{data : "depDescripcion"}, 
			{data : "depPresplan"},
			{data : "depPresejec"},
			{data : "depCumple"}, 
			{data : "depLink"},
			{
				data : "",
				"render" : function(data, type, full,
						meta) {
					if ('${infestadoinforme}' === "finalizado") {
						data = '';
					} else {
						data = '<button type="button" id="Modificar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" style="text-align: center; font-size: x-small;"> Editar</button>';
					}
					return data;
				}
			},
			{data : "" ,"render": function (data, type, full, meta) {

				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
				data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor  btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="text-align: center; font-size: x-small;"> Eliminar</button>'; 
	             }
				return data;}}
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.depCodigo);
				//$(row).attr('class', 'item');
			    //$(row).attr('data-rutaAplicacion', '');
				//$(row).attr('data-opcion', 'EditarPerfilInstitucion');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});
				$(row).find("td:eq(3)").attr('title', data.nombres);	
				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	

				$(row).find("td").css({
					"vertical-align" : "middle",
				});			
			},	
		});
	}
	
	function Eliminar(element) {	
		var codigo = $(element).closest('tr').attr('id');	
       
		 $.ajax({
		        url: 'view/rendicion/eliminarDatos',
		        headers: {"X-CSRF-TOKEN": csrfToken},
		        type: "POST",
		        dataType: 'json',
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_detalle_ejecucionp',campo:'dep_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaActualizarDetallePoa tr").length-1;
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

	function corregir() {
	if (document.getElementById("depTipo").value === "META"){
		$('#depDescripcion').hide();
		$("#depDescripcion").attr("disabled", true);
		$('#epMeta').show();
		$("#epMeta").attr("disabled", false);
		
	  }else{
		  if (document.getElementById("depTipo").value === "PROGRAMA Y/O PROYECTO" || document.getElementById("depTipo").value === "AREA"){
		  $('#depDescripcion').show();
			$("#depDescripcion").attr("disabled", false);
			$('#epMeta').hide();
			$("#epMeta").attr("disabled", true);
		  }else{

				$('#depDescripcion').hide();
				$('#epMeta').hide();
			  }
	  }		
	}	   


	function Modificar(element) {
		var codigo = $(element).closest('tr').attr('id');
		var depTipo = $(element).parent().parent().find("td:eq(1)").text();
		var depDescripcion = $(element).parent().parent().find("td:eq(2)").text();
		var depPresplan = $(element).parent().parent().find("td:eq(3)").text();
		var depPresejec = $(element).parent().parent().find("td:eq(4)").text();
		var depLink = $(element).parent().parent().find("td:eq(6)").text();
		$("#DatosEp").hide();
		$("#ActualizarDatosEp").show();
		$("#dep_cod").val(codigo);
		$("#dep_tipo").text(depTipo);
		$("#dep_descripcion").text(depDescripcion);
		$("#dep_presplan").val(depPresplan);
		$("#dep_presejec").val(depPresejec);
		$("#dep_link").val(depLink);
	}
	$("#btnActualziarEP")
			.click(
					function(event) {
						//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
						var form = $("#ActualizarDetallePoa")
						event.preventDefault();
						event.stopPropagation();
						if (form[0].checkValidity() === false) {
							mostrarMensaje(
									"Por favor ingrese toda la información solicitada!",
									"ERROR");
						} else {
							var columnas = '';
							var x = $(form).serializeArray();
							$.each(x, function(i, field) {
								columnas += field.name + ',99';
								if (columnas.length > 0) {
									columnas = columnas.substr(0,
											columnas.length - 1);
								}
							});
							var valores = '';

							var tP= parseFloat($("#dep_presplan").val().replace(/,/g, ""));
							var tC= parseFloat($("#dep_presejec").val().replace(/,/g, "")); 

							if (tP===0){
								$("#dep_total").val(0);
								}else{
									var PorcentajeGestion= parseFloat(Math.round(tC * 100) / tP).toFixed(2);
									$("#dep_cumple").val(PorcentajeGestion);

									}
							$("#dep_presplan").val(replazarmilesActualizar($("#dep_presplan").val()));
							$("#dep_presejec").val(replazarmilesActualizar($("#dep_presejec").val()));
							
							var x = $(form).serializeArray();
							$.each(x, function(i, field) {
								valores += field.value + ',99';
								if (valores.length > 0) {
									valores = valores.substr(0,
											valores.length - 1);
								}
							});
							var data = {
								tabla : 'esq_rendicioncuentas.tbl_detalle_ejecucionp',
								columns : columnas,
								values : valores,
								condicion : 'dep_cod',
								valorcondicion : $("#dep_cod").val()
							};

							ejecutarJsonUpdate(form, data);
						}
						form.addClass('was-validated');

					});
		  
	function replazarmilesActualizar(Numero) {
		var a = Numero.replace(/[^\d.]/g, "");
		return a
	}

	function formatearNumero(nStr) {
	    nStr += '';
	    x = nStr.split(',');
	    x1 = x[0];
	    x2 = x.length > 1 ? '.' + x[1] : '';
	    var rgx = /(\d+)(\d{3})/;
	    while (rgx.test(x1)) {
	            x1 = x1.replace(rgx, '$1' + ',' + '$2');
	    }
	    return x1 + x2;
	}
	
		 
</script>