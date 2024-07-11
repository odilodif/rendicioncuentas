<%-- 
	version		: 1.0
	Document  	: ActualizarCatastro
	Property   	: CPCCS
	Author		: Carlos Morocho
	Mail		: carlosmorocho339@gmail.com
    Date		: 04/05/2021, 12:02:19
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
		<h5>Formulario para actualizar catastro de Instituciones</h5>
	</div>
	<div class="card-body">
		<div class="row">
				<form:form class="needs-validation" novalidate=""  
				modelAttribute="TblInstitucion"
					id="ActualiarCatastro"  data-rutaAplicacion="tecnicoNacional"
					 data-opcion="GuardarActualiarCatastro" data-destino="detalleItem" 
					 data-accionEnExito="ACTUALIZAR" >
					<input type="hidden" id="identificadorEjecuto" name="identificadorEjecuto" value="${usuario.username}">
					<input type="hidden" id="instCond" name="instCond" value="${instCond}">
					
					<div class="card">
						<h5 class="card-header text-white carHeaderBlue">Actualizar Registro Institución</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="nombres">Nombres Institución:</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instNom" required name="instNom"
										placeholder="Ingrese el Nombre Institución" minlength="3" maxlength="500"
										value="${instNom}" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü\.#/\-°0-9 ]+$"/>
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
										name="instRuc" placeholder="Ingrese Ruc" value="${instRuc}"
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
									<select class="custom-select custom-select-sm case"  required="required"
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
									<select class="custom-select custom-select-sm case"  required="required"
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
									<select class="custom-select custom-select-sm case"  required="required"
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
								<div class="col-md-6 text-left" >
									<label for="instTmeCod">Tipo de Medio</label>
								</div>
									<div class="col-md-6 text-left">
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
								    <div id="tipoiess" style="display: none" class="row">
								    	<div class="col-md-5 text-left" >
									<label for="instTmeCod">Tipo de Instituto de Educación</label>
								</div >
									<div class="col-md-4 text-left">
									<select class="custom-select custom-select-sm"  required="required"
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
									<select class="custom-select custom-select-sm case"  required="required"
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
										value="${instDesUdaf}" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü\.#/\-°0-9 ]+$"/>
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
								<div class="col-md-1"></div>
						<%-- 			<div class="col-md-2 text-left">
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
								</div>
								 --%>
							</div> 	
															
											<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="descripcion">Seleccionar campos modificados</label>
											</div>
											<div class="col-md-9 text-left waves-effect float-left">
												
											 
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Nombres Institución"> Nombres Institución</label></td>		
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Ruc"> Ruc  </label></td>
											 <td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Provincia"> Provincia  </label></td>									
										</tr>
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Cantón"> Cantón  </label></td>		
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Parroquia"> Parroquia  </label></td>
											 <td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Función"> Función  </label></td>									
										
										</tr>
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Descripción de institución"> Descripción de institución</label></td>		
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Tipo de Medio"> Tipo de Medio</label></td>
											 <td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Sector"> Sector</label></td>									
									
										
										</tr>				
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="UDAF a la que se vincula"> UDAF a la que se vincula (Opcional)</label></td>											
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case1"
													 name="checks[]" value="Tipo de Formulario"> Tipo de Formulario</label></td>										
										</tr>							

									</table>
									
								    <input type="hidden" class="form-control form-control-sm descripcion2" id="descripcion" name="descripcion"  >
									<div class="invalid-feedback">Seleccione al menos un check</div>

								
												
											</div>

											

										</div>
										
							
								<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="cargo">Adjuntar Documento de verificación: Formato .pdf</label>
											</div>
											<div class="col-md-5 text-left waves-effect float-left">
												<input type="file" required="required"
													class="form-control-file archivo gris" id="informe2"
													name="informe2" accept=".png, .jpg, .jpeg, .pdf">

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
						<th>#</th>
						<th>Nombre Institución</th>
						<th>Ruc</th>
						<th>Provincia</th>
						<th>Función</th>
						<th>Fecha</th>
						<th>Estado</th>

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
		
		$('#EliminarArchivo2').hide();	
		$(".case").prop("disabled", "disabled");
		$(".case1").prop("disabled", "disabled");
        cargarValorComboPorDefecto("provCod",'${provCod}')
		cargarValorComboPorDefecto("instFunCod",'${instFunCod}');
		cargarValorComboPorDefecto("instTipDes",'${instTipDes}');
		cargarValorComboPorDefecto("instTfCod",'${instTfCod}');

		cargarValorComboPorDefecto("instSecCod",'${instSecCod}');

		
		if($('#instFunCod').val()==='7'){	
			$('#tipoMedio').hide();
			$('#tipoiess').show();
			$('#instTmeCod').val(0)
			$('#instTmeCod').prop("disabled", "disabled");
			cargarValorComboPorDefecto("tiesCod",'${tipoIes}');
		}else{
			$('#tipoMedio').show();
			$('#tipoiess').hide();
			$('#tiesCod').prop("disabled", "disabled");
			cargarValorComboPorDefecto("instTmeCod",'${instTmeCod}');
		}
		 
		


		if ('${estado}' == 'activo' ) {
			$(".case").prop("disabled", "disabled");
			$(".case1").removeAttr("disabled");
		} else if ('${estado}' == 'inactivo') {
			$(".case").removeAttr("disabled");
			$(".case1").removeAttr("disabled");
		}
		
	

		
	

         if('${provCod}'!=null){
            
        	scanton ='0';
     		scanton = '<option value="">Seleccione...</option>';
     		<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
     		      if ($("#provCod").val()=="${listadoLocalizacionCanton.idLocalizacionPadre}"){
     		      	scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
     		      }
     		</c:forEach>
     		$('#cantCod').html(scanton);
     		$('#parroCod').html('<option value="">Seleccione...</option>');

     		cargarValorComboPorDefecto("cantCod",'${cantCod}');
     		if('${cantCod}'!=null){
     			sparroquia ='0';
     			sparroquia = '<option value="">Seleccione...</option>';
     			<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
     				if ($("#cantCod").val()=="${listadoLocalizacionParroquia.idLocalizacionPadre}"){
     					sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
     			    } 
     			</c:forEach>
     			$('#parroCod').html(sparroquia);
     			
     			cargarValorComboPorDefecto("parroCod",'${parroCod}');

         		}

 
             }
		
	});
	
	$("#instFunCod").change(function(){
		if($('#instFunCod').val()==='7'){	
			$('#instTmeCod').val(0)
			$('#tipoMedio').hide();
			$('#tipoiess').show();
			$('#instTmeCod').prop("disabled", "disabled");
			$('#tiesCod').removeAttr("disabled");			
		}else{
			$('#tipoMedio').show();
			$('#tipoiess').hide();
			$('#tiesCod').prop("disabled", "disabled");
			$('#instTmeCod').removeAttr("disabled");

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

		var form = $("#ActualiarCatastro")	
		event.preventDefault();
		event.stopPropagation();

		if (form[0].checkValidity() === false  ) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
		}
		else{ if($("#pathModuloVerifica").val()==""){
	          $("#informe2").addClass('rojo');
				mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
		     } else {		
		    	 

		    		if ($('input[type=checkbox]:checked').length === 0) {
						mostrarMensaje("Debe seleccionar al menos un valor de los checkbox","ERROR-NOTIFICACION");

						} else{
							$(".case").removeAttr("disabled");					  
				    		ejecutarJson(form);  

							}
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
			 {data : "fecha"},
			 {data : "estado"} 
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
					"white-space" : "nowrap"
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
				var nombreNuevoArchivo = $("#identificador")
						.val()
						+ "_nombramiento-"
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
				if (extension[extension.length - 1].toUpperCase() == 'PDF' ||extension[extension.length - 1].toUpperCase() == 'JPEG'||extension[extension.length - 1].toUpperCase() == 'JPG' ||extension[extension.length - 1].toUpperCase() == 'PNG'){
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
