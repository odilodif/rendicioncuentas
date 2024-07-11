<%-- 
	version		: 1.0
    Document  	: Frm_GAD_Asamblea
    Created on	: 17/02/2021; 15:57:14
    Author		: Juan Carlos Vega
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
					modelAttribute="TblAsambleaCiudadana"
					id="acCod" data-rutaAplicacion="rendicion"
					data-opcion="guardarAsambleaCiudadana"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">ASAMBLEA CIUDADANA</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">
					<table class="table registros table-bordered">
					<tr>
					<th colspan="2"></th>
					
					<tr>
					<td scope="row">
						MECANISMOS - ESPACIOS DE PARTICIPACIÓN
					</td>
						<td>
						ASAMBLEA CIUDADANA LOCAL (definición extraida de la LOPC, Art. 65)
						</td>
					</tr>
					
					<tr>
					<td scope="row">
						EXISTE UNA ASAMBLEA CIUDADANA EN SU TERRITORIO
					</td>
						<td scope="row">
									<select class="custom-select custom-select-sm " id="acExiste"  name="acExiste" onchange="validar(this)"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
						SÓLO SI CONTESTÓ SI INGRESE LOS DATOS DEL REPRESENTANTE 
					</td>
					<td>		<div class="form-group row">
											<div class="col-md-6 text-left">
												<label for="nombre">Nombres y Apellidos del presidente o Representante de la Asamblea Ciudadana</label>
											</div>
											<div class="col-md-6">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="acNomRespon"
													required="required" name="acNomRespon"
													placeholder="Ingrese Nombres y Apellidos" maxlength="64"
													value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese sus Apellidos y Nombres</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6 text-left">
												<label for="email">Correo electrónico</label>
												
											</div>
											<div class="col-md-6 text-left">
												<input type="email" class="form-control form-control-sm"
													id="acMeilRespon" required="required"
													name="acMeilRespon" placeholder="Ingrese su email"
													pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

												<div class="invalid-feedback">Por favor ingrese una
													dirección de correo electrónico válida</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-6 text-left">
												<label for="telefono" class="col-form-label">Teléfono<span class="text-muted"> (Opcional)</span>
													
												</label>
											</div>
											<div class="col-md-6 text-left">
												<input type="text" class="form-control form-control-sm"
													id="acTelfRespon" name="acTelfRespon" placeholder="(00) 000-0000"
													maxlength="20" 
													pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
													data-inputmask="'mask': '(99) 999-9999'">
												<div class="invalid-feedback">Por favor ingrese su
													teléfono</div>
											</div>
										</div>
										
							</td>
					</tr>
					
					<tr>
					<td scope="row">
						PLANIFICÓ LA GESTIÓN DEL TERRITORIO CON LA PARTICIPACIÓN DE LA ASAMBLEA CIUDADANA 
					</td>
						<td scope="row">
									<select class="custom-select custom-select-sm " id="acValidaGestTerritorio"  name="acValidaGestTerritorio"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
					¿EN QUÉ FASES DE LA PLANIFICACIÓN PARTICIPARON LAS ASAMBLEAS CIUDADANAS Y CÓMO?					</td>
						<td scope="row">
								<textarea rows="2" cols="" class="form-control form-control-sm"
										id="acDescrPlanficacion" required="required"
										name="acDescrPlanficacion"
										placeholder="Ingrese el detalle lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
							QUÉ ACTORES PARTICIPARON					</td>
						<td>
								<!-- <div class="checkbox-group">				
   								<label for="uno"><input type="checkbox" id="faseActor1"  name="checkbox" onclick="return ValidatePetSelection();" value="REPRESENTACIÓN TERRITORIAL"> REPRESENTACIÓN TERRITORIAL</label><br>
   								<label for="dos"><input type="checkbox" id="faseActor2" name="checkbox" onclick="return ValidatePetSelection();" value="GRUPOS DE INTERES ESPECÍFICO"> GRUPOS DE INTERES ESPECÍFICO</label><br>
   								<label for="tres"><input type="checkbox" id="faseActor3"  name="checkbox" onclick="return ValidatePetSelection();" value="GRUPOS DE ATENCIÓN PRIORITARIA"> GRUPOS DE ATENCIÓN PRIORITARIA</label>
   								<label for="uno"><input type="checkbox" id="faseActor4"  name="checkbox" onclick="return ValidatePetSelection();" value="GREMIAL"> GREMIAL</label><br>
   								<label for="dos"><input type="checkbox" id="faseActor5" name="checkbox" onclick="return ValidatePetSelection();" value="SOCIO ORGANIZATIVA"> SOCIO ORGANIZATIVA</label><br>
   								<label for="tres"><input type="checkbox" id="faseActor6"  name="checkbox" onclick="return ValidatePetSelection();" value="UNIDADES BÁSICAS DE PARTICIPACIÓN"> UNIDADES BÁSICAS DE PARTICIPACIÓN</label>
   								<label for="tres"><input type="checkbox" id="faseActor7"  name="checkbox" onclick="return ValidatePetSelection();" value="GRUPOS ETARIOS"> GRUPOS ETARIOS</label>
   								<label for="tres"><input type="checkbox" id="faseActor8"  name="checkbox" onclick="return ValidatePetSelection();" value="OTROS"> OTROS</label>
   								
   								<br> 
        						 </div> -->
        						 
        						 <table class="tablacheckbox">
											<tr>
												<td style="vertical-align: middle;"><label for="uno"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="REPRESENTACIÓN TERRITORIAL"> REPRESENTACIÓN TERRITORIAL</label></td>
											
											
												<td style="vertical-align: middle;"><label for="dos"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="GRUPOS DE INTERES ESPECÍFICO">
														GRUPOS DE INTERES ESPECÍFICO</label></td>
											
											
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="GRUPOS DE ATENCIÓN PRIORITARIA">
														GRUPOS DE ATENCIÓN PRIORITARIA</label></td>
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="GRUPOS ETARIOS">
														GRUPOS ETARIOS</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="uno"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="GREMIAL"> GREMIAL</label></td>
											
											
												<td style="vertical-align: middle;"><label for="dos"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="SOCIO ORGANIZATIVA">
														SOCIO ORGANIZATIVA</label></td>
											
											
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="UNIDADES BÁSICAS DE PARTICIPACIÓN">
														UNIDADES BÁSICAS DE PARTICIPACIÓN</label></td>
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="OTROS">
														OTROS</label></td>
											</tr>
										</table> <input type="hidden" class="form-control form-control-sm"
										id="ante_descrip" name="ante_descrip">
										<div class="invalid-feedback">Seleccione un almenos un
											checkbox</div>
						</td>
					</tr>
					<tr>
					<td scope="row">
							DESCRIBA LOS LOGROS ALCANZADOS EN EL AÑO					</td>
						<td scope="row">
								<textarea rows="2" cols="" class="form-control form-control-sm"
										id="acDescLogros" required="required"
										name="acDescLogros"
										placeholder="Ingrese el detalle lo más detalladamente posible"
										></textarea>
							<div class="invalid-feedback">Por favor ingrese el detalle</div>
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
		<c:when test="${inf_estado=='matriz'}">
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
			<table id="TablaAsamblea"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th class="tablaingreso" width="2%" style="font-size: xx-small;">#</th>
						<th class="tablaingreso" width="10%" style="font-size: xx-small;">MECANISMOS - ESPACIOS DE PARTICIPACIÓN</th>
						<th class="tablaingreso" width="5%" style="font-size: xx-small;">EXISTE UNA ASAMBLEA CIUDADANA EN SU TERRITORIO</th>
						<th class="tablaingreso" width="10%" style="font-size: xx-small;">SÓLO SI CONTESTÓ SI INGRESE LOS DATOS DEL REPRESENTANTE</th>
						<th class="tablaingreso" width="5%" style="font-size: xx-small;">PLANIFICÓ LA GESTIÓN DEL TERRITORIO CON LA PARTICIPACIÓN DE LA ASAMBLEA CIUDADANA</th>
						<th class="tablaingreso" width="20%" style="font-size: xx-small;">¿EN QUE FASES DE LA PLANIFICACIÓN PARTICIPARON LAS ASAMBLEAS CIUDADANAS Y CÓMO</th>
						<th class="tablaingreso" width="20%" style="font-size: xx-small;">DESCRIBA LOS LOGROS ALCANZADOS EN EL AÑO</th>
						<th class="tablaingreso" width="15%" style="font-size: xx-small;">QUÉ ACTORES PARTICIPARON</th>
						<th class="tablaingreso" width="3%" style="font-size: xx-small;"> </th>
					</tr>
					
				</thead>
				<tbody>
				</tbody>				
			</table>
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
<script src="${urlPublic}js/rendicion.ingreso.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		construirValidador();
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
		
		$('[id="checks[]"]').click(function() {
			var arr = $('[id="checks[]"]:checked').map(function() {
				return this.value;
			}).get();
			var str = arr.join('<br>');
			$('#ante_descrip').val(str);
		});
		
	});

	$("#btnGuardarI").click(function(event) {

		var form = $("#acCod")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
			    $("#infCod").attr("disabled", false);
				
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_asamblea_ciudadana',campo:'ac_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaAsamblea tr").length-1;
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

	function tabla() {
		var parametros = {"infCod" : '${infCod}'};
		$('#TablaAsamblea').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerAsambleaCiudadana",
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
			{data : "acEspaciosParticipa"},
			{data : "acExiste"}, 
			{data : "acNomRespon"}, 
			{data : "acValidaGestTerritorio"}, 
			{data : "acDescrPlanficacion"}, 
			{data : "acDescLogros"}, 
			{data : "acRepreTerri"}, 
			{ data: "" ,"render": function (data, type, full, meta) {

				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{

		            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
	             }
		     return data;
	        }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.acCod);
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

				$(row).find("td").css({
					"font-size"   : "x-small",			
				});	

				$(row).find("td").css({
					"vertical-align" : "middle",
				});
		
				$(row).find("td:eq(3)").attr('title', data.nombres);			
		
			},	
			
		});

	}

	
	function corregir() {
	if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS CONCURRENTES"){
		$('#foCod').hide();
		$("#foCod").attr("disabled", true);
		$('#eprCompetenciaConcurr').show();
		$("#eprCompetenciaConcurr").attr("disabled", false);
		
	  }else{
		  if (document.getElementById("eprTipoCompetencia").value === "COMPETENCIAS EXCLUSIVAS"){
			  $('#foCod').show();
			  $("#foCod").attr("disabled", false);
				$('#eprCompetenciaConcurr').hide();
			$("#eprCompetenciaConcurr").attr("disabled", true);
			
		}else{
			$('#foCod').hide();
			$('#eprCompetenciaConcurr').hide();
			$("#foCod").attr("disabled", false);
			$("#eprCompetenciaConcurr").attr("disabled", false);
			}
	  }		
	}	     

	function validar(elemento) {

		if ($(elemento).val() === "SI"){
	
			 
				$("#acNomRespon").attr("disabled", false);
			    $("#acMeilRespon").attr("disabled", false);
			    $("#acTelfRespon").attr("disabled", false);
			    $("#acValidaGestTerritorio").attr("disabled", false);
			    $("#acDescrPlanficacion").attr("disabled", false);
			    $("#acDescLogros").attr("disabled", false);
			    $('input').prop('disabled', false);
				$('#ante_descrip').val("");	
				
		}else if($(elemento).val() === "NO"){
			
			
			
		    $("#acNomRespon").attr("disabled", true);
		    $("#acMeilRespon").attr("disabled", true);
		    $("#acTelfRespon").attr("disabled", true);
		    $("#acValidaGestTerritorio").attr("disabled", true);
		    $("#acDescrPlanficacion").attr("disabled", true);
		    $("#acDescLogros").attr("disabled", true);
		    
		    $('input').prop('disabled', true);
			$('input').prop('checked', false);
			$('#ante_descrip').prop('disabled', false);
			$('#ante_descrip').val("NO APLICA");	
		    
		    
		}else
		
		{
			
		}
	}


	function ValidatePetSelection()  
	{  
	    var checkboxes = document.getElementsByName("checkbox");  
	    var numberOfCheckedItems = 0;  
	    for(var i = 0; i < checkboxes.length; i++)  
	    {  
	        if(checkboxes[i].checked)  
	            numberOfCheckedItems++;  
	    }  
	    if(numberOfCheckedItems < 1)  
	    {  
	         
	    	mostrarMensaje("Favor seleccione al menos un Actor!",	"ERROR");
	    }  
	}   
</script>