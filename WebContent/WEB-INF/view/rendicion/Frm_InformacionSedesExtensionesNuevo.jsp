<%-- 
	version		: 1.0
    Document  	: Frm_InformacionSedesExtensiones
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

<div class="card text-center mb-card15">
	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card-body">
			<div class="row">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblSede" id="Sede" data-rutaAplicacion="rendicion"
					data-opcion="guardarSede" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">INFORMACIÓN
						DE SEDES Y EXTENSIONES DE LAS INSTITUCIONES DE EDUCACIÓN SUPERIOR
						COBERTURA GEOGRÁFICA Y DE ATENCIÓN DE LAS SEDES Y EXTENSIONES DE
						IES</h5>
					<div id="Mensaje">
						<div class="alert alert-primary" role="alert">En caso de
							contar con extensiones llenar los siguientes campos</div>
					</div>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
						<table class="table registros table-bordered">
							<tr>
								<th colspan="8"></th>
							</tr>
							<tr>
								<td scope="row">NOMBRE DE LA EXTENSIÓN O SEDE</td>
								<td scope="row" colspan="6"><textarea rows="2" cols=""
										class="form-control form-control-sm" id="seNombre"
										required="required" name="seNombre"
										placeholder="Ingrese lo solicitado lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Ingrese lo solicitado</div></td>
							</tr>

							<tr>
								<td scope="row">LOCALIZACIÓN</td>
								<td scope="row" colspan="6">

									<div class="col-md-3 text-left">
										<label for="seProvincia">PROVINCIA</label>
									</div> <select class="custom-select custom-select-sm" id="seProvincia"
									required="required" name="seProvincia">
										<option value="">Seleccione...</option>
										<c:forEach var="listadoLocalizacionProvincia"
											items="${listadoLocalizacionProvincia}">
											<option
												value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
										</c:forEach>
								</select>
									<div class="invalid-feedback">Por favor seleccione la
										provincia</div>


									<div class="col-md-3 text-left">
										<label for="seCanton">CANTÓN</label>
									</div> <select class="custom-select custom-select-sm" id="seCanton"
									required="required" name="seCanton">
										<option value="">Seleccione...</option>
								</select>
									<div class="invalid-feedback">Por favor seleccione el
										cantón</div>
									<div class="form-group row">
										<div class="col-md-3 text-left">
											<label for="seParroquia">PARROQUIA</label>
										</div>
										<select class="custom-select custom-select-sm"
											required="required" id="seParroquia" name="seParroquia">
											<option value="">Seleccione...</option>
										</select>
										<div class="invalid-feedback">Por favor seleccione la
											parroquia</div>
									</div>

								</td>
							</tr>
							<tr>
								<td scope="row">DIRECCIÓN</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm" id="seDireccion"
									required="required" name="seDireccion"
									placeholder="INGRESAR DIRECCIÓN" maxlength="256" value=""
									pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$" minlength="8">
									<div class="invalid-feedback">Por favor ingrese la
										dirección o no tiene el mínimo de caracteres permitidos</div></td>
							</tr>

							<tr>
								<td scope="row">CORREO ELECTRÓNICO DE LA SEDE</td>
								<td scope="row" colspan="6"><input type="email"
									class="form-control form-control-sm" id="seMail"
									required="required" name="seMail"
									placeholder="INGRESE EL EMAIL"
									pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Por favor ingrese una
										dirección de correo electrónico valida</div></td>
							</tr>
							<tr>
								<td scope="row">PÁGINA WEB</td>
								<td scope="row" colspan="6"><input type="url"
									class="form-control form-control-sm" id="seWeb"
									required="required" name="seWeb"
									placeholder="INGRESAR PAGINA WEB" value="http://">
									<div class="invalid-feedback">Por favor ingrese la
										dirección en el siguiente formato http://dirreccionDePaginaWeb</div>
								</td>
							</tr>
							<tr>
								<td scope="row">RUC</td>
								<td scope="row" colspan="6"><input type="text"
									class="form-control form-control-sm" id="seRuc"
									required="required" name="seRuc"
									placeholder="9999999999999" minlength="13" maxlength="13"
									pattern="^([a-zA-Z0-9]{7,13})+$"
									onchange="ValidateRuc(this.value)" />
									<div class="invalid-feedback">Por favor ingrese su Ruc</div></td>
							</tr>
							<tr>
								<td scope="row">NOMBRE DEL REPRESENTANTE LEGAL</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm " id="seRepresentante"
									required="required" name="seRepresentante"
									placeholder="Ingrese Nombres y Apellidos" minlength="3"
									maxlength="64" value="" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
									<div class="invalid-feedback col-md-6 text-left">Por
										favor ingrese sus Apellidos y Nombres</div></td>
							</tr>
							<tr>
								<td scope="row">CARGO DEL REPRESENTANTE LEGAL</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm" id="seCargo"
									required="required" name="seCargo"
									placeholder="INGRESE EL CARGO" minlength="3" maxlength="64"
									value="">
									<div class="invalid-feedback">Por favor ingrese el Cargo</div>
								</td>
							</tr>
							<tr>
								<td scope="row">CORREO ELECTRÓNICO DEL REPRESENTANTE LEGAL
								</td>
								<td scope="row" colspan="6"><input type="email"
									class="form-control form-control-sm" id="seMailrep"
									required="required" name="seMailrep"
									placeholder="INGRESE EL EMAIL"
									pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$">

									<div class="invalid-feedback">Por favor ingrese una
										dirección de correo electrónico valida</div></td>
							</tr>

							<tr>
								<td scope="row">FECHA DE DESIGNACIÓN:</td>
								<td scope="row" colspan="6">

									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="seDesignacion"
											name="seDesignacion" class="form-control form-control-sm"
											value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de designación con formato dd/mm/aaaa</div>
									</div>

								</td>
							</tr>
							<tr>
								<td scope="row">TELÉFONOS:</td>
								<td scope="row" colspan="6"><input type="text"
									class="form-control form-control-sm" id="seTelrep"
									name="seTelrep" required="required" placeholder="(00) 000-0000"
									maxlength="13"
									pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
									data-inputmask="'mask': '(99) 999-9999'">
									<div class="invalid-feedback">Por favor ingrese su
										teléfono</div></td>
							</tr>
							<tr>
								<td scope="row">No. UNIDADES (CAMPUS)</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seUnidades"
									required="required" name="seUnidades" placeholder="99999"
									minlength="13" maxlength="13" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>

							<tr>
								<td scope="row">COBERTURA GEOGRÁFICA</td>
								<td scope="row" colspan="6"><input type="text"
									style="text-transform: uppercase;"
									class="form-control form-control-sm" id="seCobertura"
									required="required" name="seCobertura"
									placeholder="INGRESE EL CARGO" minlength="3" maxlength="64"
									value="">
									<div class="invalid-feedback">Por favor ingrese el Cargo</div>
								</td>
							</tr>
							<tr>
								<td scope="row">No. DE ESTUDIANTES</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seEstudiantes"
									required="required" name="seEstudiantes" placeholder="99999"
									minlength="13" maxlength="13" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>
							<tr>
								<td rowspan="2" scope="row">DETALLE EL No. DE ESTUIDANTES
									POR GÉNERO</td>
								<th scope="col" colspan="2" style="text-align: center; font-size: x-small;"
									width="10%">MASCULINO</th>
								<th scope="col" colspan="2" style="text-align: center; font-size: x-small;"
									width="10%">FEMENINO</th>
								<th scope="col" colspan="2"  style="text-align: center; font-size: x-small;"
									width="10%">GLBTI</th>
							</tr>

							<tr align="center">
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seHombre"
									name="seHombre" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seMujeres"
									name="seMujeres" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row" colspan="2" ><input type="text"
									class="form-control form-control-sm" id="seGlbti"
									name="seGlbti" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
							</tr>
							<tr>
								<td rowspan="2" scope="row">DETALLE EL No. DE ESTUIDANTES
									POR PUEBLOS Y NACIONALIDADES</td>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">MONTUBIOS</th>
									<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">MESTIZO</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">CHOLOS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">INDIGENAS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">AFROECUATORIANOS</th>
								<th scope="col" style="text-align: center; font-size: x-small;"
									width="10%">EXTRANJEROS</th>
								
							</tr>

							<tr align="center">
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seMontubios"
									name="seMontubios" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seMestizos"
									name="seMestizos" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seCholos"
									name="seCholos" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seIndigenas"
									name="seIndigenas" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seAfroecuatorianos"
									name="seAfroecuatorianos" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								<td scope="row"><input type="text"
									class="form-control form-control-sm" id="seExtranjeros"
									name="seExtranjeros" required="required" />
									<div class="invalid-feedback">Por Ingrese número
										Participantes</div></td>
								
							</tr>
							
							<tr>
								<td scope="row">No. DE ESTUDIANTES CON DICAPACIDAD</td>
								<td scope="row" colspan="6"><input type="number"
									class="form-control form-control-sm" id="seDiscapacitados"
									required="required" name="seDiscapacitados" placeholder="99999"
									minlength="13" maxlength="13" step "1" min="0"
									pattern="^([a-zA-Z0-9]{7,13})+$" onkeypress="mascaraEnteros(this)" onpaste="return false"/>
									<div class="invalid-feedback">Por favor ingrese el número</div>
								</td>
							</tr>
							<tr>
								<td scope="row">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td scope="row" colspan="6">
								<input type="text"
									class="form-control form-control-sm" id="seLink"
									required="required" name="seLink"
									placeholder="INGRESAR PAGINA WEB" value="http://">
									<div class="invalid-feedback">Por favor ingrese la
										dirección en el siguiente formato http://dirreccionDePaginaWeb</div>
							
							
							</tr>
						
						</table>
					
					
					</form:form>
						
					<div class="col-md-12 text-center">
						<button type="submit" id="btnGuardarI"
							class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
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
		
		var f = new Date();
		var fecha=(f.getDate() + "/" + (f.getMonth() +1) + "/" + f.getFullYear());
		
		$('#seDesignacion').datepicker({
		  forceParse: true,
		  todayBtn: false
		}).datepicker('setStartDate', '01/01/2010');
		
		$('#seDesignacion').datepicker({

		}).datepicker('setEndDate', fecha);
		
		$('#seDesignacion').datepicker({

		}).datepicker('update', fecha);
		
		$('#seDesignacion').datepicker({

		}).datepicker('update','');


	
		
	});

	$("#btnGuardarI").click(function(event) {

		var form = $("#Sede")
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
		$('#TablaSedes').DataTable({
		ajax : {
		
		data : parametros,
		url : "obtenerSedes",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		/* bPaginate: false,
        bFilter: false,
        bInfo: false,
        responsive: true, */
    
        order : [ 0, "asc" ],		
        paging:   false,
		info:     false,
		searching: false,
		responsive: true,
		scrollX: true,
		buttons: [
			{extend: 'copyHtml5'},
		    {extend: 'csvHtml5'},
		    {extend: 'excelHtml5'},
		    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
		    {extend: 'print'},
		    ],
		columns : [
			{data : "nombreSede"},
			{data : "provincia"},
			{data : "canton"}, 
			{data : "parroquia"}, 
			{data : "direccion"}, 
			{data : "correo"}, 
			{data : "paginaWeb"}, 
			{data : "ruc"}, 
			{ data: "" ,"render": function (data, type, full, meta) {

				if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{

		            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
	             }
		     return data;
	        }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.seCod);
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



	$("#seProvincia").change(function() {
		scanton = '0';
		scanton = '<option value="0">Seleccione...</option>';
		<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
		if ($("#seProvincia").val() == "${listadoLocalizacionCanton.idLocalizacionPadre}") {
			scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
		}
		</c:forEach>
		$('#seCanton').html(scanton);
	});

	$("#seCanton").change(function() {
		sparroquia = '0';
		sparroquia = '<option value="0" selected="true">Seleccione...</option>';
		<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
		if ($("#seCanton").val() == "${listadoLocalizacionParroquia.idLocalizacionPadre}") {
		  sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
		}
		</c:forEach>
		$('#seParroquia').html(sparroquia);
	});


	function ValidateRuc()  
	{  

		 if (validarDocumento()){
				mostrarMensaje("El ruc ingresado es correto!",	"EXITO");
				$('#btnGuardarI').prop('disabled', false);

	}else{

				$('#btnGuardarI').prop('disabled', true);

			 }
		  
				
	}   

	   validarDocumento  = function() {          		
		 numero = $("#seRuc").val();
			      var suma = 0;      
		      var residuo = 0;      
		      var pri = false;      
		      var pub = false;            
		      var nat = false;      
		      var numeroProvincias = 24;                  
		      var modulo = 11;
		                  
		      /* Verifico que el campo no contenga letras */                  
		      var ok=1;
		      for (i=0; i<numero.length && ok==1 ; i++){
		         var n = parseInt(numero.charAt(i));
		         if (isNaN(n)) ok=0;
		      }
		      if (ok==0){
		         mostrarMensaje("No puede ingresar caracteres aquí",	"ERROR");        
		         return false;
		      }
		      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
		      if (numero.length < 13 ){              
		         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
		         return false;
		      }
		     
		      /* Los primeros dos digitos corresponden al codigo de la provincia */
		      provincia = numero.substr(0,2);      
		      if (provincia < 1 || provincia > numeroProvincias){           
		         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
		     return false;       
		      }

		      /* Aqui almacenamos los digitos de la cedula en variables. */
		      d1  = numero.substr(0,1);         
		      d2  = numero.substr(1,1);         
		      d3  = numero.substr(2,1);         
		      d4  = numero.substr(3,1);         
		      d5  = numero.substr(4,1);         
		      d6  = numero.substr(5,1);         
		      d7  = numero.substr(6,1);         
		      d8  = numero.substr(7,1);         
		      d9  = numero.substr(8,1);         
		      d10 = numero.substr(9,1);                
		         
		      /* El tercer digito es: */                           
		      /* 9 para sociedades privadas y extranjeros   */         
		      /* 6 para sociedades publicas */         
		      /* menor que 6 (0,1,2,3,4,5) para personas naturales */ 

		      if (d3==7 || d3==8){           
		         mostrarMensaje("El tercer dígito ingresado es inválido!",	"ERROR");                  
		         return false;
		      }         
		         
		      /* Solo para personas naturales (modulo 10) */         
		      if (d3 < 6){           
		         nat = true;            
		         p1 = d1 * 2;  if (p1 >= 10) p1 -= 9;
		         p2 = d2 * 1;  if (p2 >= 10) p2 -= 9;
		         p3 = d3 * 2;  if (p3 >= 10) p3 -= 9;
		         p4 = d4 * 1;  if (p4 >= 10) p4 -= 9;
		         p5 = d5 * 2;  if (p5 >= 10) p5 -= 9;
		         p6 = d6 * 1;  if (p6 >= 10) p6 -= 9; 
		         p7 = d7 * 2;  if (p7 >= 10) p7 -= 9;
		         p8 = d8 * 1;  if (p8 >= 10) p8 -= 9;
		         p9 = d9 * 2;  if (p9 >= 10) p9 -= 9;             
		         modulo = 10;
		      }         

		      /* Solo para sociedades publicas (modulo 11) */                  
		      /* Aqui el digito verficador esta en la posicion 9, en las otras 2 en la pos. 10 */
		      else if(d3 == 6){           
		         pub = true;             
		         p1 = d1 * 3;
		         p2 = d2 * 2;
		         p3 = d3 * 7;
		         p4 = d4 * 6;
		         p5 = d5 * 5;
		         p6 = d6 * 4;
		         p7 = d7 * 3;
		         p8 = d8 * 2;            
		         p9 = 0;            
		      }         
		         
		      /* Solo para entidades privadas (modulo 11) */         
		      else if(d3 == 9) {           
		         pri = true;                                   
		         p1 = d1 * 4;
		         p2 = d2 * 3;
		         p3 = d3 * 2;
		         p4 = d4 * 7;
		         p5 = d5 * 6;
		         p6 = d6 * 5;
		         p7 = d7 * 4;
		         p8 = d8 * 3;
		         p9 = d9 * 2;            
		      }
		                
		      suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;                
		      residuo = suma % modulo;                                         

		      /* Si residuo=0, dig.ver.=0, caso contrario 10 - residuo*/
		      digitoVerificador = residuo==0 ? 0: modulo - residuo;                

		      /* ahora comparamos el elemento de la posicion 10 con el dig. ver.*/                         
		      if (pub==true){           
		         if (digitoVerificador != d9){                          
		            mostrarMensaje("El ruc de la empresa del sector público es incorrecto!",	"ERROR");         
		            return false;
		         }                  
		         /* El ruc de las empresas del sector publico terminan con 0001*/         
		         if ( numero.substr(9,4) != '0001' ){                    
		            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
		            return false;
		         }
		      }         
		      else if(pri == true){         
		         if (digitoVerificador != d10){                          
		            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
		            return false;
		         }         
		         if ( numero.substr(10,3) != '001' ){                    
		            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
		            return false;
		         }
		      }      

		      else if(nat == true){         
		         if (digitoVerificador != d10){                          
		            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
		            return false;
		         }         
		         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
		            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
		            return false;
		         }
		      }      
		      return true; 

		     
	}

  
	
	
</script>