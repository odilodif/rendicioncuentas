<%-- 
	version		: 1.0
	Document  	: ActualizarCatastroAutoridad
	Property   	: CPCCS
	Author		: Juan Carlos Vega
	Mail		: jc.vega@live.com
    Date		: 04/06/2021, 12:02:19
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
		<h5>Formulario para actualizar catastro de Autoridades</h5>
	</div>
	<div class="card-body">
				<form:form class="needs-validation" novalidate=""  
				modelAttribute="TblAutoridad"
					id="ActualiarCatastro"  data-rutaAplicacion="tecnicoNacional"
					 data-opcion="GuardarActualiarCatastroAutoridad" data-destino="detalleItem" 
					 data-accionEnExito="ACTUALIZAR" >
					<input type="hidden" id="identificadorEjecuto" name="identificadorEjecuto" value="${usuario.username}">
					<input type="hidden" id="instCond" name="instCond" value="${instCond}">
					
					<div class="card" >
						<h5 class="card-header text-white carHeaderBlue">Actualizar datos de una Autoridad</h5>
						<div class="card-body">
						
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="nombres">Nombres:</label>
								</div>
								<div class="col-md-5 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instNom" required name="instNom"
										placeholder="Ingrese el Nombre Institución" minlength="3" maxlength="64"
										value="${instNom}" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$"/>
									<div class="invalid-feedback">Por favor ingrese el nombre de la autoridad</div>
									<!-- <div class="valid-tooltip">todo bien</div> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-1 text-left">
									<label for="ruc">Cédula</label>
								</div>
								<div class="col-md-2 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instRuc" required
										name="instRuc" placeholder="Ingrese Ruc" value="${instRuc}"
										placeholder="9999999999999" minlength="10" maxlength="10"
										pattern="^([a-zA-Z0-9]{10,10})+$">
									<div class="invalid-feedback">Por favor ingrese Ruc</div>
								</div>
							</div>	
							
					     <div class="form-group row">
								<div class="col-md-2 text-left">
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
								<div class="col-md-2 text-left">
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
								<div class="col-md-2 text-left">
									<label for="funcion">Dignidad</label>
								</div>
								<div class="col-md-5  text-left">
									<select class="custom-select custom-select-sm "  required="required"
										id="instFunCod" name="instFunCod">
										<option value="">Seleccione...</option>
										<option value="VOCALES DE GAD PARROQUIAL">VOCALES DE GAD PARROQUIAL</option>
												<option value="VICEPRESIDENTA/ VICEPRESIDENTE DE GAD PARROQUIAL">VICEPRESIDENTA/ VICEPRESIDENTE DE GAD PARROQUIAL</option>
												<option value="PRESIDENTA/ PRESIDENTE DE GAD PARROQUIAL">PRESIDENTA/ PRESIDENTE DE GAD PARROQUIAL</option>
												<option value="CONSEJALAS/ CONCEJALES RURALES">CONSEJALAS/ CONCEJALES RURALES</option>
												<option value="CONSEJALAS/CONCEJALES URBANOS">CONSEJALAS/CONCEJALES URBANOS</option>
												<option value="VICEALCALDESA/ VICEALCALDE">VICEALCALDESA/ VICEALCALDE</option>
												<option value="ALCALDESA/ ALCALDE">ALCALDESA/ ALCALDE</option>
												<option value="VICEPREFECTA/ VICEPREFECTO">VICEPREFECTA/ VICEPREFECTO</option>
												<option value="PREFECTA/PREFECTO">PREFECTA/PREFECTO</option>
												<option value="ASAMBLEÍSTA NACIONAL">ASAMBLEÍSTA NACIONAL</option>
												<option value="ASAMBLEÍSTA PROVINCIAL">ASAMBLEÍSTA PROVINCIAL</option>
												<option value="ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL">ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL</option>
												<option value="ASAMBLEÍSTA REPRESENTANTE EXTRANJERO">ASAMBLEÍSTA REPRESENTANTE EXTRANJERO</option>
												<option value="PARLAMENTARIA / PARLAMENTARIO ANDINO">PARLAMENTARIA / PARLAMENTARIO ANDINO</option>
												<option value="CONSEJERA/ CONSEJERO DEL CPCCS">CONSEJERA/ CONSEJERO DEL CPCCS</option>
												<option value="VICEPRESIDENTE DE LA REPÚBLICA">VICEPRESIDENTE DE LA REPÚBLICA</option>
												<option value="PRESIDENTE DE LA REPÚBLICA">PRESIDENTE DE LA REPÚBLICA</option>
									</select>
									<div class="invalid-feedback">Seleccione la Dignidad</div>
								</div>
								
							</div> 	
						 	
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="instDesUdaf">Institución en la que ejerce la dignidad</label>
								</div>
									<div class="col-md-5 text-left">
									<input type="text" class="form-control form-control-sm"
										id="instDesUdaf" name="instDesUdaf"
										placeholder="Ingrese el Nombre Udaf" minlength="8" maxlength="64"
										value="${InstitucionDignidad}" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$"/>
									<div class="invalid-feedback">Ingrese la Institución en la que ejerce la dignidad</div>
									<!-- <div class="valid-tooltip">todo bien</div> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-1 text-left">
									<label for="instTipDes">Ámbito</label>
								</div>
									<div class="col-md-2 text-left">
									<select class="custom-select custom-select-sm "  required="required"
										id="instTipDes" name="instTipDes">
										<option value="">Seleccione...</option>
										<option value="NACIONAL">Nacional</option>
												<option value="PROVINCIAL">Provincial</option>
												<option value="DISTRITO METROPOLITANO">Distrito Metropolitano</option>
												<option value="CANTONAL">Cantonal</option>
												<option value="PARROQUIAL">Parroquial</option>
												<option value="EXTERIOR">Exterior</option>													
									</select>
									<div class="invalid-feedback">Seleccione el Ámbito</div>
								    </div>
							</div> 	
								<div class="form-group row">
								<div class="col-md-2 text-left">
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
							
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left">
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
						
							</div> 	
															
											<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="descripcion">Seleccionar campos modificados</label>
											</div>
											<div class="col-md-9 text-left waves-effect float-left">
												
											 
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Nombre Autoridad"> Nombre</label></td>		
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Cédula"> Cédula  </label></td>
											 <td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Provincia"> Provincia  </label></td>									
										</tr>
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Cantón"> Cantón  </label></td>		
											<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Parroquia"> Parroquia  </label></td>
											 <td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Dignidad"> Dignidad  </label></td>									
										
										</tr>
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Ámbito"> Ámbito</label></td>		
								
											 									
									
										
										</tr>				
										<tr>
										<td style="vertical-align: middle; font-size: x-small;"><label
												for="uno"><input type="checkbox" class="case"
													 name="checks[]" value="Institucion Dignidad"> Institución de la dignidad</label></td>											
																				
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

		 
		cargarValorComboPorDefecto("provCod",'${provCod}');
		
		cargarValorComboPorDefecto("instFunCod",'${instFunCod}');
		cargarValorComboPorDefecto("instTipDes",'${instTipDes}');
		cargarValorComboPorDefecto("instTfCod",'${instTfCod}');
		cargarValorComboPorDefecto("instSecCod",'${instSecCod}');


	
		
		$('#instTfCod').prop("disabled", "disabled");

		
	

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
   if (ruc.length==10) {
	   mostrarMensaje("Verificar en la tabla de la parte inferior si alguna autoridad ya está registrada con la cédula ingresada.!","EXITO","3000");
	   Verificar();
	 
	
  } else {
	//imprimimos en consola si la cedula tiene mas o menos de 10 digitos

	mostrarMensaje("Esta cédula tiene menos de 10 Digitos",
			"ERROR-NOTIFICACION");
	      $("#instRuc").val("");
	      var table = $('#tablaRegistro').DataTable();
          table.clear();
	      table.destroy();
	       // $('#tablaRegistro').empty();

}
   
	});
	

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
