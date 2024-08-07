<%-- 
	version		: 1.0
    Document  	: ListadoCatastro.jsp
    Created on	: 14/04/2021; 10:11:00
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ page session="false" %>
<spring:url value="/resources/" var="urlPublic" /> 
<sec:authentication var="usuario" property="principal" />
<c:set var="tamanioArchivo" value="<%=Constantes.TAMANIO_ARCHIVO_5_MEGAS%>" />
<c:set var="rutaModuloRegistro" value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />

<!DOCTYPE">
<html>
	<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card mb-card20">
<h5 class="card-header text-white carHeaderBlue" align="center">Técnico ${rol}
	 <br>
	 Listado de Usuarios Internos</h5>
<c:choose>
<c:when test="${Verificador=='acceso' }">

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
			<div class="ibox-content">

            <div class="table-responsive">
			
				<table id="tablaRegistros" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th  style="display: none;"> #</th>
					<th>Código</th>
					<th>Autoridad</th>
					<th>Cedula</th>
					<th>Provincia</th>
					<th>Dignidad</th>					
					<th>Estado</th>
					<th>Técnico_RCuentas, Fecha_acción, Acción_ralizada</th>
					<th>Archivo verificador</th>				
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
			
	</div>
	</div>
		</c:when>
		<c:otherwise>

				<div>
				<div id="AccesoNegado">
					¡Acceso Negado!... Usted no es administrador.  <br /> <span
						style="font-weight: bold;"></span>No puede acceder a este modulo <br />
				</div>
			</div>
		
		</c:otherwise>
	</c:choose>
</div>

<div class="modal fade" id="Vnt_Eliminar" tabindex="-1" role="dialog" >
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabel">Eliminar
					Autoridad</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<span aria-hidden="true"></span>
				<div class="card">

					<div class="card-body">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblAutoridad" id="Eliminacion"
							data-rutaAplicacion="tecnicoNacional"
							data-opcion="EliminacionAutoridad" data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="identificador"
								name="identificador">
							<input type="hidden" name="identificadorResponsable"
								id="identificadorResponsable" value="${usuario.username}">
                             <input type="hidden" name="ruc" id="ruc">
							<%-- <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="solicito">Solicitado por:</label>
								</div>
								<div class="col-md-9 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="solicitado" name="solicitado">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionariosRc"
											items="${listadoFuncionariosRc}">
											<option
												value="${listadoFuncionariosRc.idDatoFuncionario}">${listadoFuncionariosRc.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione el nombre de quién
										Solicito la eliminación</div>
								</div>
							</div> --%>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="aprobo">Aprobado por:</label>
								</div>
								<div class="col-md-9 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="aprobado" name="aprobado">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionarioSubcordinador"
											items="${listadoFuncionarioSubcordinador}">
											<option
												value="${listadoFuncionarioSubcordinador.idDatoFuncionario}">${listadoFuncionarioSubcordinador.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione al Subcoordinador</div>
								</div>
							</div>

							<!-- <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="descripcion">Descripción</label>
								</div>
								<div class="col-md-9 text-left">
									<textarea id="descripcion"
										placeholder="Escribe aquí tu Descripción" name="descripcion"
										class="form-control form-control-sm" required rows="3"
										cols="40"></textarea>
								
									<div class="invalid-feedback">Por favor ingrese la
										descripción</div>								
								</div>								
							</div> -->
											<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="cargo">Adjuntar Documento de verificación: Formato .jpeg, .jpg, .png, .pdf</label>
											</div>
											<div class="col-md-5 text-left waves-effect float-left">
												<input type="file" required="required"
													class="form-control-file archivo gris" id="informe"
													name="informe" accept=".png, .jpg, .jpeg, .pdf">

												<div class="estadoCarga">En espera de archivo...
													(Tamaño máximo ${tamanioArchivo})</div>
												<input type="hidden" class="rutaModuloRegistro"
													id="pathModuloRegistro" name="pathModuloRegistro" value="" />
												<div class="invalid-feedback">Por favor seleccione un
													archivo</div>
											</div>

											<div class="col-md-3 text-left">
												<button type="button" id="subirArchivo"
													class="subirArchivo adjunto btn _nuevoColor btn-sm"
													data-rutaCarga="${rutaModuloRegistro}">
													<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
													archivo
												</button>

												<button type="button"
													class="EliminarArchivo adjunto btn _eliminarColor btn-sm"
													style="display:none;"
													id="EliminarArchivo" disabled="disabled" >
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
							<div class="text-center">
								<button type="button" class="btn btn-secondary  btn-sm mt-2"
									data-dismiss="modal">Close</button>
								<button type="submit" id="btnGuardarH"
									class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="Vtn_Actualizar" tabindex="-1" role="dialog" >
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Activar
					Autoridad</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">

				<span aria-hidden="true"></span>
				<div class="card">

					<div class="card-body">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblAutoridad" id="Activacion"
							data-rutaAplicacion="tecnicoNacional"
							data-opcion="ActivarAutoridad" data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="identificadorAct"
								name="identificadorAct">
							<input type="hidden" name="identificadorResponsableAct"
								id="identificadorResponsableAct" value="${usuario.username}">
							<input type="hidden" name="rucAct" id="rucAct">
							<%-- <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="solicito">Solicitado por:</label>
								</div>
								<div class="col-md-9 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="solicitadoAct" name="solicitadoAct">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionariosRc"
											items="${listadoFuncionariosRc}">
											<option
												value="${listadoFuncionariosRc.idDatoFuncionario}">${listadoFuncionariosRc.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione el nombre de quién
										Solicito la eliminación</div>
								</div>
							</div> --%>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="aprobo">Aprobado por:</label>
								</div>
								<div class="col-md-9 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="aprobadoAct" name="aprobadoAct">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionarioSubcordinador"
											items="${listadoFuncionarioSubcordinador}">
											<option
												value="${listadoFuncionarioSubcordinador.idDatoFuncionario}">${listadoFuncionarioSubcordinador.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione al Subcoordinador</div>
								</div>
							</div>

							<!-- <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="descripcion">Descripción</label>
								</div>
								<div class="col-md-9 text-left">
									<textarea id="descripcionAct"
										placeholder="Escribe aquí tu Descripción" name="descripcionAct"
										class="form-control form-control-sm" required rows="3"
										cols="40"></textarea>
							
									<div class="invalid-feedback">Por favor ingrese la
										descripción</div>
									<div class="valid-tooltip">todo bien</div>
								</div>						
							</div> -->
							  <div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="cargo">Adjuntar Documento de verificación: Formato .jpeg, .jpg, .png, .pdf</label>
											</div>
											<div class="col-md-5 text-left waves-effect float-left">
												<input type="file" required="required"
													class="form-control-file archivo gris" id="informe1"
													name="informe1" accept=".png, .jpg, .jpeg, .pdf">

												<div class="estadoCarga">En espera de archivo...
													(Tamaño máximo ${tamanioArchivo})</div>
												<input type="hidden" class="rutaModuloRegistro1"
													id="pathModuloRegistro1" name="pathModuloRegistro1" value="" />
												<div class="invalid-feedback">Por favor seleccione un
													archivo</div>
											</div>

											<div class="col-md-3 text-left">
												<button type="button" id="subirArchivo1"
													class="subirArchivo1 adjunto btn _nuevoColor btn-sm"
													data-rutaCarga="${rutaModuloRegistro}">
													<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
													archivo
												</button>

												<button type="button"
													class="EliminarArchivo1 adjunto btn _eliminarColor btn-sm"
													style="display:none;"
													id="EliminarArchivo1" disabled="disabled" >
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
							<div class="text-center">
								<button type="button" class="btn btn-secondary  btn-sm mt-2"
									data-dismiss="modal">Close</button>
								<button type="submit" id="btnActivarH"
									class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
							</div>

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
<script>	
	$(document).ready(function(){
		$('#EliminarArchivo').hide();	
		$('#EliminarArchivo1').hide();	
		if ('${rol}' == 'Administrador'||'${rol}' == 'Nacional') {
			Administrador();
		} 

	});

	$('button.subirArchivo').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivo");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaModuloRegistro");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#rucAct")
						.val()
						+ "_verificador-"
						+ fecha.getFullYear()
						+ "_"
						+ (fecha.getMonth() + 1)
						+ "_"
						+ fecha.getDate()
						+ "-"
						+ fecha.getHours()
						+ "_"
						+ fecha.getMinutes()
						+ "_"
						+ fecha.getSeconds();
				if (extension[extension.length - 1].toUpperCase() == 'PDF'  ||extension[extension.length - 1].toUpperCase() == 'JPEG'||extension[extension.length - 1].toUpperCase() == 'JPG' ||extension[extension.length - 1].toUpperCase() == 'PNG') {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo, new carga(estado, archivo, boton), "${tamanioArchivo}");
					$('#EliminarArchivo').show();
					$('#EliminarArchivo').removeAttr("disabled");
					$('#subirArchivo').hide();

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	$('button.EliminarArchivo').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(
				".estadoCarga");
		var archivourl = $("#rutaArchivo").val();
		var rutaArchivo = boton.parent('div').parent('div').find(
				".rutaModuloRegistro");
		var archivo = boton.parent('div').parent('div')
				.find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
				estado, archivo, boton));
		$('#subirArchivo').removeAttr("disabled");
		$('#informe').val('');	
		$('#EliminarArchivo').hide();
		$('#subirArchivo').show();
		

	});

	$('button.subirArchivo1').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivo");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaModuloRegistro1");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#rucAct")
						.val()
						+ "_verificador-"
						+ fecha.getFullYear()
						+ "_"
						+ (fecha.getMonth() + 1)
						+ "_"
						+ fecha.getDate()
						+ "-"
						+ fecha.getHours()
						+ "_"
						+ fecha.getMinutes()
						+ "_"
						+ fecha.getSeconds();
				if (extension[extension.length - 1].toUpperCase() == 'PDF'  ||extension[extension.length - 1].toUpperCase() == 'JPEG'||extension[extension.length - 1].toUpperCase() == 'JPG' ||extension[extension.length - 1].toUpperCase() == 'PNG') {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo, new carga(estado, archivo, boton), "${tamanioArchivo}");
					$('#EliminarArchivo1').show();
					$('#EliminarArchivo1').removeAttr("disabled");
					$('#subirArchivo1').hide();

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	$('button.EliminarArchivo1').click(function(event) {
		var boton = $(this);
		var estado = boton.parent('div').parent('div').find(
				".estadoCarga");
		var archivourl = $("#rutaArchivo").val();
		var rutaArchivo = boton.parent('div').parent('div').find(
				".rutaModuloRegistro1");
		var archivo = boton.parent('div').parent('div')
				.find(".archivo");
		EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
				estado, archivo, boton));
		$('#subirArchivo1').removeAttr("disabled");
		$('#informe1').val('');	
		$('#EliminarArchivo1').hide();
		$('#subirArchivo1').show();
		

	});
		
	function Administrador() {
		$('#tablaRegistros').DataTable({
			ajax : {
				url : "obtenerRegistrosCatastroAutoridades",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : "POST"
			},
			order : [ 0, "asc" ],
			bDestroy : true,
			"searching": true,
			dom : '<"html5buttons"B>lTfgitp',
			buttons : [ 
			 {extend : 'excelHtml5'},
			 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
			 {extend : 'print'},
				 ],
			columns : [ 
				 {data : "contador"},
				 {data : "inst_cod"},
				 {data : "nombre"}, 
				 {data : "ruc"},
				 {data : "provincia"},
				 {data : "funcion"}, 				
				 {data : "estado"},	
				 {data : "accion"},					
				 {data: "" ,"render": function (data, type, full, meta) {
					 if(full.archivo!="SN"){
						 data = '<a style="color:blue;"  href="'+'${rutaArchivosAplicacion}'+full.archivo +'" target="_blank">Documento_Verificador</a>';
						 }
					 else{
						 data='SN';
						 }
	     			  return data; 
	     			}},						
				 {data: "" ,"render": function (data, type, full, meta) {
					 if (full.estado == 'ACTIVO' || full.estado == 'REGISTRADO'){
			            	 data = '<button type="button" id="Editar" class="_gestionar btn _modificarColor"  onclick="Modificar(this)" title="Actualizar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
					 }else {						
							data = ''; 
							}
	     			  return data; 
	     			}},
	     			{data:"","render": function (data, type, full, meta) {
		     			
			             if (full.estado == 'REGISTRADO' || full.estado == 'ACTIVO'){
			            	 data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
						} else if(full.estado=='ELIMINADO') { 
							 data = '<button type="button" id="Activar" class="_actualizar btn _actualizarColor btn-xs" data-toggle="modal" data-target="#modalEliminar"  onclick="Activar(this)" title="Activar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;">Activar</button>';    
						} else {						
							data = ''; 

							}
		             	 return data; 
	     			}}
				 ],
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.inst_cod);
				$(row).attr('data-rutaAplicacion', 'tecnicoNacional');
                $(row).attr('data-opcion', 'ActualizarCatastroAutoridad');	
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"display"     : "none"
				});
				$(row).find("td:eq(1)").css({
					"font-weight" : "bold",					
				});
				$(row).find("td:eq(6)").css({
					"font-weight" : "bold",	
					"text-align": "center"				
				});
				$(row).find("td:eq(7)").css({
					"font-weight" : "bold",	
					"text-align": "center"				
				});
				$(row).find("td").css({
					"font-size"   : "x-small",	
					"vertical-align" : "middle",	
                });		
							
			},
		});

	}
	
	function Eliminar(element) {	
		var codigo = $(element).closest('tr').attr('id');	
	    var ruc = $(element).parent().parent().find("td:eq(2)").text();	
		$("#identificador").val(codigo);	
		$("#ruc").val(ruc);	
		$("#Vnt_Eliminar").modal("show");	
			
	}
	function Activar(element) {	
		var codigo = $(element).closest('tr').attr('id');
	    var ruc = $(element).parent().parent().find("td:eq(2)").text();	
		$("#rucAct").val(ruc);			
		$("#identificadorAct").val(codigo);					
		$("#Vtn_Actualizar").modal("show");
		
	}
	 
	 function Modificar(element) {
		
		 $('#tablaRegistros tbody').on('click', 'tr', function() {
				abrir($(this), "#" + $(this).attr("data-destino"), false);
			});		 
			
	 }

	
	$("#btnGuardarH").click(function(event) {			
		var form = $("#Eliminacion")	
		event.preventDefault();
		event.stopPropagation();

		if (form[0].checkValidity() === false  ) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
		}
		else{
			 if($("#pathModuloRegistro").val()==""){
		          $("#informe").addClass('rojo');
				mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     } else {
							  
		    	 ejecutarJson(form);			
					$("#Vnt_Eliminar").modal("hide");
		    		  $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
		    		  $('.modal-backdrop').remove();//eliminamos el backdrop del modal
		     }
		     
				
		     }
		
		form.addClass('was-validated');
	});
	
	$("#btnActivarH").click(function(event) {		
			var form = $("#Activacion")	
			event.preventDefault();
			event.stopPropagation();

			if (form[0].checkValidity() === false  ) {
				mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
			}
			else{
				 if($("#pathModuloRegistro1").val()==""){
			          $("#informe1").addClass('rojo');
					mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
			     } else {
								  
			    	 ejecutarJson(form);						
					 $("#Vtn_Actualizar").modal("hide");
		    		  $('body').removeClass('modal-open');//eliminamos la clase del body para poder hacer scroll
		    		  $('.modal-backdrop').remove();//eliminamos el backdrop del modal
			     }
					
			     }
			
			form.addClass('was-validated');
		});
		

	
	
</script>
	