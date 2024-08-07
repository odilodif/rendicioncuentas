<%-- 
	version		: 1.0
    Document  	: nuevoCatastro
    Created on	: 16/08/2019, 11:11:34
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ page session="false" %>
<c:set var="tamanioArchivo" value="<%=Constantes.TAMANIO_ARCHIVO_5_MEGAS%>" />
<c:set var="rutaModuloRegistro" value="<%=Constantes.RUTA_ARCHIVOS_MODULO_DOCUMENTO%>" />
<c:set var="rutaArchivosAplicacion"	value="<%=Constantes.RUTA_ARCHIVOS_APLICACION%>" />
<sec:authentication var="usuario" property="principal" />
<spring:url value="/resources/" var="urlPublic" />
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
	<div class="card-header ">
		<h5>Formulario para el registro de catastro</h5>
	</div>
	<div class="card-body">
		<div class="row">
				<form:form class="needs-validation" novalidate=""  
				modelAttribute="TblInstitucion"
					id="NuevoCatastro"  data-rutaAplicacion="tecnicoNacional"
					 data-opcion="GuardarNuevoCatastro" data-destino="detalleItem" 
					 data-accionEnExito="ACTUALIZAR" >
					<input type="hidden" id="identificadorSolicitante" name="identificadorSolicitante" value="${usuario.username}">
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Datos Nuevo Registro Institución</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="nombres">Nombres Institución:</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instNom" required name="instNom"
										placeholder="Ingrese el Nombre Institución" minlength="3" maxlength="500"
										value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$"/>
									<div class="invalid-feedback">Por favor ingrese el nombre Institución</div>
									<!-- <div class="valid-tooltip">todo bien</div> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="ruc">Ruc</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instRuc" required
										name="instRuc" placeholder="Ingrese Ruc"
										placeholder="9999999999999" minlength="13" maxlength="13"
										pattern="^([a-zA-Z0-9]{13,13})+$">
									<div class="invalid-feedback">Por favor ingrese Ruc</div>
								</div>
							</div>	
							
					     <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="provincia">Provincia </label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										id="provCod" required="required" name="provCod">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoLocalizacionProvincia"
											items="${listadoLocalizacionProvincia}">
											<option
												value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="canton">Cantón<span class="text-muted"> (Opcional)</span></label>
								</div>
								<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"
										id="cantCod" name="cantCod">
										<option value="">Seleccione...</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione el cantón</div>
								</div>
							</div> 

					 <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="parroquia">Parroquia <span class="text-muted"> (Opcional)</span></label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"
										id="parroCod" name="parroCod">
										<option value="">Seleccione...</option>
									</select>
									<div class="invalid-feedback">Por favor seleccione la parroquia</div>
								</div>
								<div class="col-md-1"></div>															
							</div> 	
						
						 <div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="funcion">Función</label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="instFunCod" name="instFunCod">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncion"
											items="${listadoFuncion}">
											<option
												value="${listadoFuncion.funCod}">${listadoFuncion.funDes}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione la Función</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="instTipDes">Descripción de institución</label>
								</div>
									<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="instTipDes" name="instTipDes">
										<option value="">Seleccione...</option>
										<option value="UDAF">UDAF</option>	
										<option value="EOD">EOD</option>
										<option value="GAD">GAD</option>
										<option value="PRIVADO">PRIVADO</option>
										<option value="PÚBLICO">PÚBLICO</option>
										<option value="ASOCIACIONES">ASOCIACIONES</option>
										<option value="COMUNITARIA">COMUNITARIA</option>
										<option value="EMPRESAS PÚBLICAS">EMPRESAS PÚBLICAS</option>	
						    <!--  			<option value="MINISTERIOS SECTORIALES">MINISTERIOS SECTORIALES</option>	-->								
										<option value="INSTITUCIONES VINCULADAS">INSTITUCIONES VINCULADAS</option>
							<!-- 		    <option value="SOCIEDAD ANÓNIMA CON PARTICIPACIÓN PÚBLICA">SOCIEDAD ANÓNIMA CON PARTICIPACIÓN PÚBLICA</option>  -->	
										<option value="ORGANISMO DE DERECHO PRIVADO SIN FINES DE LUCRO">ORGANISMO DE DERECHO PRIVADO SIN FINES DE LUCRO</option>
										<option value="MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD">MANCOMUNIDADES Y CONSORCIOS/ COMPETENCIAS DE GAD</option>													
										<option value="BANCA PÚBLICA">BANCA PÚBLICA</option>	
									</select>
									<div class="invalid-feedback">Seleccione el tipo de descripción Institución</div>
								    </div>
							</div> 	
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="instTfCod">Tipo de Formulario</label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="instTfCod" name="instTfCod">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoTipoInforme"
											items="${listadoTipoInforme}">
											<option
												value="${listadoTipoInforme.tfCod}">${listadoTipoInforme.tfNom}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione la Función</div>
								</div>
								<div class="col-md-1"></div>
								<!---aki los cambios medios-->
								<div id="tipoMedio" class="row">
								<div class="col-md-7 text-left">
									<label for="instTmeCod">Tipo de Medio</label>
								</div>
									<div class="col-md-5 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="instTmeCod" name="instTmeCod">
										<option value="">Seleccione...</option>	
										<c:forEach var="listadoTipoMedio"
											items="${listadoTipoMedio}">
											<option
												value="${listadoTipoMedio.tmeCod}">${listadoTipoMedio.tmeDes}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione el tipo de Medio</div>
								    </div>
								 </div>
								 
							<div><br></div>
							
							 <div id="tipoiess" style="display: none" class="row">
								    	<div class="col-md-5 text-left" >
									<label for="instTmeCod">Tipo de Instituto de Educación</label>
								</div >
									<div class="col-md-4 text-left">
									<select class="custom-select custom-select-sm case"  required="required"
										id="tiesCod" name="tiesCod">
										<option value="">Seleccione...</option>										
										<c:forEach var="ListaTipoIes"
											items="${ListaTipoIes}">
											<option
												value="${ListaTipoIes.tiesCod}">${ListaTipoIes.tiesDes}</option>
										</c:forEach>									
									</select>
									<div class="invalid-feedback">Seleccione el tipo de Medio</div>
								    </div>
								    </div>
								    
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="instSecCod">Sector</label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="instSecCod" name="instSecCod">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoTipoSector"
											items="${listadoTipoSector}">
											<option
												value="${listadoTipoSector.secCod}">${listadoTipoSector.secDes}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione el sector</div>
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-2 text-left">
									<label for="instDesUdaf">UDAF a la que se vincula</label>
								</div>
									<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instDesUdaf" name="instDesUdaf"
										placeholder="Ingrese el Nombre Udaf" minlength="8" maxlength="64"
										value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$"/>
									<div class="invalid-feedback">Ingrese la Udaf vinculada</div>
									<!-- <div class="valid-tooltip">todo bien</div> -->
								</div>
							</div> 	
								<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="instSecCod">Aprobado Por</label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="aprobado" name="aprobado">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionario"
											items="${listadoFuncionario}">
											<option
												value="${listadoFuncionario.idDatoFuncionario}">${listadoFuncionario.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione al Subcoordinador</div>
								</div>
							<%-- 	<div class="col-md-1"></div>
									<div class="col-md-2 text-left">
									<label for="instSecCod">Solicitado Por</label>
								</div>
								<div class="col-md-3  text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="solicitado" name="solicitado">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoFuncionariosRc"
											items="${listadoFuncionariosRc}">
											<option
												value="${listadoFuncionariosRc.idDatoFuncionario}">${listadoFuncionariosRc.nombre}</option>
										</c:forEach>
									</select>
									<div class="invalid-feedback">Seleccione el nombre de quien
										Solicito la eliminación</div>
								</div> --%>
								
							</div> 	
								<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="cargo">Adjuntar Documento de verificación: Formato .jpeg, .jpg, .png, .pdf</label>
											</div>
											<div class="col-md-5 text-left waves-effect float-left">
												<input type="file" required="required"
													class="form-control-file archivo gris" id="informe2"
													name="informe2" accept=".pdf, .jpeg, .jpg, .png,">

												<div class="estadoCarga">En espera de archivo...
													(Tamaño máximo ${tamanioArchivo})</div>
												<input type="hidden" class="rutaModuloRegistro"
													id="pathModuloVerifica" name="pathModuloVerifica" value="" />
												<div class="invalid-feedback">Por favor seleccione un
													archivo</div>
											</div>

											<div class="col-md-3 text-left">
												<button type="button" id="subirArchivo2"
													class="subirArchivo2 adjunto btn _nuevoColor btn-sm"
													data-rutaCarga="${rutaModuloRegistro}">
													<i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
													archivo
												</button>

												<button type="button"
													class="EliminarArchivo2 adjunto btn _eliminarColor btn-sm"
													style="display:none;"
													id="EliminarArchivo2" disabled="disabled" >
													<i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
												</button>
											</div>

										</div>
									
						</div>
					</div>
					<button type="submit" id="btnGuardar" class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</form:form>
			</div>
		
		</div>
	<div class="ibox-content">

		<div class="table-responsive">
			<div id="MensajeEdad">
				<div class="alert alert-primary" role="alert">Verificar si alguna institución tiene el mismo ruc y el mismo nombre, si es el caso no registrar en el catastro a la institución , y si no existe información registrar a la institución en el catastro. </div>
			</div>
			<table id="tablaRegistro" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
						<tr>
							<th  style="display: none;"> #</th>
							<th>Nombre Institución</th>
							<th>Ruc</th>
							<th>Provincia</th>
							<th>Función</th>					
							<th>Estado</th>
							<th>Técnico_RCuentas, Fecha_acción, Acción_ralizada</th>
							<th>Archivo verificador</th>	
						</tr>
				</thead>
				<tbody>
				</tbody>
			</table>

		</div>
	</div>
</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		 $('[name="checks[]"]').click(function() {		      
			    var arr = $('[name="checks[]"]:checked').map(function(){
			      return this.value;
			    }).get();
			    var str = arr.join('<br>');	
			    $('#descripcion').val(str);			  
			  });

     cargarValorComboPorDefecto("provCod",'${provCod}')
		cargarValorComboPorDefecto("instFunCod",'${instFunCod}');
		cargarValorComboPorDefecto("instTipDes",'${instTipDes}');
		cargarValorComboPorDefecto("instTfCod",'${instTfCod}');
		cargarValorComboPorDefecto("instTmeCod",'${instTmeCod}');
		cargarValorComboPorDefecto("instSecCod",'${instSecCod}');
		cargarValorComboPorDefecto("tiesCod",'${tipoIes}');
		if($('#instFunCod').val()==='7'){
			$('#instTmeCod').val(0);
			$('#tipoMedio').hide();
			
			$('#tipoiess').show();
			
			//$('#instTmeCod').attr("disabled")
		}else{
			$('#tiesCod').val(0);
			$('#tipoMedio').show();
			$('#tipoiess').hide();
		}
	});
	
	$("#instFunCod").change(function(){
		
		if($('#instFunCod').val()==='7'){	
			$('#instTmeCod').val(0);
			selectIES = '<option value="">Seleccione...</option>';
			<c:forEach var="ListaTipoIes" items="${ListaTipoIes}">			      
			   selectIES += '<option value="${ListaTipoIes.tiesCod}">${ListaTipoIes.tiesDes}</option>';			      
			</c:forEach>		
			$('#tiesCod').html(selectIES);
			$('#tipoMedio').hide();
			
			$('#tipoiess').show();
			console.log("gasdasd-------" + $('#instTmeCod').val());
			//$('#instTmeCod').attr("disabled")
		}else{
			$('#tiesCod').val(0);
			selectTodos = '<option value="">Seleccione...</option>';
			<c:forEach var="listadoTipoMedio" items="${listadoTipoMedio}">			    
			    	  selectTodos += '<option value="${listadoTipoMedio.tmeCod}">${listadoTipoMedio.tmeDes}</option>';			 
			</c:forEach>
			$('#instTmeCod').html(selectTodos);
			$('#tipoMedio').show();
			$('#tipoiess').hide();
			console.log($('#tiesCod').val());
		}
		
	});
	
	$("#provCod").change(function(){
		scanton ='0';
		scanton = '<option value="">Seleccione...</option>';
		<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
		      if ($("#provCod").val()=="${listadoLocalizacionCanton.idLocalizacionPadre}"){
		      	scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
		      }
		</c:forEach>
		$('#cantCod').html(scanton);
		$('#parroCod').html('<option value="">Seleccione...</option>');
	});
	 
	$("#cantCod").change(function(){
		sparroquia ='0';
		sparroquia = '<option value="">Seleccione...</option>';
		<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
			if ($("#cantCod").val()=="${listadoLocalizacionParroquia.idLocalizacionPadre}"){
				sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
		    } 
		</c:forEach>
		$('#parroCod').html(sparroquia);
	});
	

	$("#btnGuardar").click(function(event) {
		//console.log("prueba");

		var form = $("#NuevoCatastro")	
		event.preventDefault();
		event.stopPropagation();

		if (form[0].checkValidity() === false  ) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
		}
		else{ if($("#pathModuloVerifica").val()==""){
	          $("#informe2").addClass('rojo');
				mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     } else {							  
		    		ejecutarJson(form);  
		     }
			
		     }
		
		form.addClass('was-validated');


	});

   $("#instRuc").change(function(){
   var ruc= $("#instRuc").val();
   if (ruc.length==13) {
	   mostrarMensaje("Verificar en la tabla de la parte inferior si alguna institución ya está registrada con el ruc ingresado.!","EXITO","3000");
	   Verificar();
	 
	
  } else {
	//imprimimos en consola si la cedula tiene mas o menos de 10 digitos

	mostrarMensaje("Esta Ruc tiene menos de 13 Digitos",
			"ERROR-NOTIFICACION");
	      $("#instRuc").val("");
	      var table = $('#tablaRegistro').DataTable();
          table.clear();
	      table.destroy();
	       // $('#tablaRegistro').empty();

}
   
	});
	
	function Verificar() {
		var opcion=$("#instRuc").val();
		$('#tablaRegistro').DataTable({
			ajax : {
				data : {codigo:opcion},
				url : "obtenerRegistrosRuc",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : "POST"
			},
			order : [ 0, "asc" ],
			bDestroy : true,
			dom : '<"html5buttons"B>lTfgitp',
			buttons : [
				{extend : 'excelHtml5'},
			    {extend : 'pdfHtml5', orientation : 'landscape',	pageSize : 'A1'	}, 
				{extend : 'print'}, 
				],
			columns : [ 
				 {data : "contador"},
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
			 ],
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.inst_cod);
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",
				    "display"     : "none"
				});
				$(row).find("td").css({
					"font-size"   : "x-small",	
					"vertical-align" : "middle",	
                });		
			},
		});


	}



	$('button.subirArchivo2').click(
			function(event) {
				var boton = $(this);
				var archivo = boton.parent('div').parent('div').find(".archivo");
				var rutaArchivo = boton.parent('div').parent('div').find(".rutaModuloRegistro");
				var extension = archivo.val().split('.');
				var estado = boton.parent('div').parent('div').find(".estadoCarga");
				var fecha = new Date();
				var nombreNuevoArchivo = $("#instRuc")
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
				if (extension[extension.length - 1].toUpperCase() == 'PDF'  ||extension[extension.length - 1].toUpperCase() == 'JPEG'||extension[extension.length - 1].toUpperCase() == 'JPG' ||extension[extension.length - 1].toUpperCase() == 'PNG' ) {
					subirArchivo(archivo, nombreNuevoArchivo, boton.attr("data-rutaCarga"), rutaArchivo, new carga(estado, archivo, boton), "${tamanioArchivo}");
					$('#EliminarArchivo2').show();
					$('#EliminarArchivo2').removeAttr("disabled");
					$('#subirArchivo2').hide();

				} else {
					estado
							.html('Formato incorrecto, solo se admite archivos en formato PDF');
					archivo.val("");
				}
			});
	$('button.EliminarArchivo2').click(function(event) {
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
		$('#subirArchivo2').removeAttr("disabled");
		$('#informe2').val('');	
		$('#EliminarArchivo2').hide();
		$('#subirArchivo2').show();
		

	});

		
	
</script> 
