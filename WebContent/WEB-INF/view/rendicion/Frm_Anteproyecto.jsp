<%-- 
	version		: 1.0
    Document  	: Frm_FasesPresupuesto
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
	<c:when test="${infestado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblAnteproyectoPresupuesto" id="anteCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarAnteproyectoPresupuesto" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="50%"></th>
					<th class="tablaingreso" width="25%">PONGA SI O NO </th>
					<th class="tablaingreso" width="25%">CON QUÉ ACTOR SE REALIZÓ</th>
       				<tr>
					<td scope="row">
					EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE DIÓ A CONOCER A LA CIUDADANÍA DEL 20 AL 31 DE OCTUBRE				
					<td scope="row">
									<select class="custom-select custom-select-sm " id="anteOpc"  name="anteOpc" onchange="validar(this)"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div></td>
					<td align="center" style="vertical-align: middle;">
										<table class="tablacheckbox">
											<tr>
												<td style="vertical-align: middle;"><label for="uno"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="ASAMBLEA CIUDADANA"> ASAMBLEA CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="dos"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="INSTANCIA DE PARTICIPACIÓN CIUDADANA">
														INSTANCIA DE PARTICIPACIÓN CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelection();" id="checks[]"
														value="ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN">
														ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN</label></td>
											</tr>
										</table> <input type="hidden" class="form-control form-control-sm"
										id="ante_descrip" name="ante_descrip">
										<div class="invalid-feedback">Seleccione un almenos un
											checkbox</div>

									</td>
							
							
					</tr>
					<tr>
					<th class="tablaingreso" width="50%"></th>
					</tr>
					<tr>
					
					<td colspan="2">
					“¿HASTA QUE FECHA SE PRESENTÓ EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO AL LEGISLATIVO DEL GAD?:
					</td>
					<td colspan="2" scope="row">
									<div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="anteFecha"
											name="anteFecha"
											class="form-control form-control-sm" value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de inicio de gestión</div>
									</div></td>
					
					</tr>
					<tr>
					<th class="tablaingreso" width="50%"></th>
					<th class="tablaingreso" width="25%">PONGA SI O NO </th>
					<th class="tablaingreso" width="25%">ATRAVÉS DE QUÉ MEDIO </th>
       				<tr>
					<td scope="row">
					UNA VEZ QUE EL LEGISLATIVO APROBÓ EL ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO SE DIÓ A CONOCER A LA CIUDADANÍA				
					<td scope="row">
									<select class="custom-select custom-select-sm " id="anteOpc2"  name="anteOpc2" onchange="validar2(this)"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div></td>
					<td scope="row">
										<textarea rows="2" cols="" class="form-control form-control-sm"
										id="anteDescrip" required="required"
										name="anteDescrip"
										placeholder="Ingrese el nombre lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
						</td>
							
							
					</tr>
					</table>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>
	</div>
</c:when>
<c:when test="${infestado=='matriz'}">
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
			<table id="TablaAnteproyectoPresupuesto1"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="6">ANTEPROYECTO DEL PRESUPUESTO PARTICIPATIVO:</th>
     				  </tr>
					<tr>
				    <th class="tablaingreso" width="5%">#</th>
					<th class="tablaingreso" width="50%"></th>
					<th class="tablaingreso" width="10%">PONGA SI O NO</th>
					<th class="tablaingreso" width="30%">CON QUÉ ACTOR SE REALIZO </th>
					<th class="tablaingreso" width="5%"> </th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
			<table id="TablaAnteproyectoPresupuesto2"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="6"></th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="5%">#</th>
					<th class="tablaingreso" width="80%"></th>
					<th class="tablaingreso" width="10%">FECHA</th>
					<th class="tablaingreso" width="5%"> </th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
			<table id="TablaAnteproyectoPresupuesto3"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="6"></th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="5%">#</th>
					<th class="tablaingreso" width="60%"></th>
					<th class="tablaingreso" width="10%">PONGA SI O NO</th>
					<th class="tablaingreso" width="20%">ATRAVÉS DE QUÉ MEDIO </th>
					<th class="tablaingreso" width="5%"> </th>
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

<script type="text/javascript">

$(document).ready(
		function() {

			if ('${infestado}' == 'matriz') {
				tabla1();
				tabla2();
				tabla3();			
			}
			
			var f = new Date();
			var dia1 = "01";
			var dia30 = "30";
			var mes1 = "01"; 
			var dia31 ="31";
			var mes12 ="12";
			var anio = f.getFullYear()-2;
			var aniofin = f.getFullYear()-1; 
			
			var fechaInicio=(dia1 + "/" + mes1 + "/" + anio);
			var fechaFin=(dia31 + "/" + mes12 + "/" + aniofin);


			$('#anteFecha').datepicker({
				  forceParse: true,
				  todayBtn: false
			}).datepicker('setStartDate', fechaInicio);
				
			$('#anteFecha').datepicker({

			}).datepicker('setEndDate', fechaFin);
				
			$('#anteFecha').datepicker({

			}).datepicker('update', fechaInicio);
			$('#anteFecha').datepicker({

			}).datepicker('update','');

			$('[id="checks[]"]').click(function() {
				var arr = $('[id="checks[]"]:checked').map(function() {
					return this.value;
				}).get();
				var str = arr.join('<br>');
				$('#ante_descrip').val(str);
			});

			cargarValorComboPorDefecto("anteOpc", '${anteOpc}');
			if ('${anteOpc}' === "NO") {
				$('input').prop('disabled', true);
				$('input').prop('checked', false);
				$("#ante_descrip").val("NO APLICA");	

			} else {
				$('input').prop('disabled', false);
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


});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#anteCod').attr('data-opcion',	'guardarAnteproyectoPresupuesto');
					var form = $("#anteCod")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						 $('input').prop('disabled', false);

							if($('#ante_descrip').val()==""){
							mostrarMensaje(
									"Por favor ingrese al menos un actor!",
									"ERROR");
							}else{
						ejecutarJson(form);
							}
					}
					form.addClass('was-validated');
});

function tabla1() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaAnteproyectoPresupuesto1').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerAnteproyectoPresupuesto1",
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
		{data : "anteNom"},
		{data : "anteOpc"}, 
		{data : "anteDescrip"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{

			data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar1(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';
            }    
    return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.anteCod);
			//$(row).attr('class', 'item');
		    $(row).attr('data-rutaAplicacion', 'rendicion');
			$(row).attr('data-opcion', 'Frm_Anteproyecto1');
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

function tabla2() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaAnteproyectoPresupuesto2').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerAnteproyectoPresupuesto2",
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
		{data : "anteNom"},
		{data : "anteFecha"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
			data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar2(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
            }
		    return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.anteCod);
			//$(row).attr('class', 'item');
		    $(row).attr('data-rutaAplicacion', 'rendicion');
			$(row).attr('data-opcion', 'Frm_Anteproyecto2');
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

function tabla3() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaAnteproyectoPresupuesto3').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerAnteproyectoPresupuesto3",
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
		{data : "anteNom"},
		{data : "anteOpc"}, 
		{data : "anteDescrip"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
			data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Actualizar3(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
            }
		    return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.anteCod);
			//$(row).attr('class', 'item');
		    $(row).attr('data-rutaAplicacion', 'rendicion');
			$(row).attr('data-opcion', 'Frm_Anteproyecto3');
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

function Actualizar1(element) {	
	$('#TablaAnteproyectoPresupuesto1 tbody').on('click', 'tr', function() {
		abrir($(this), "#" + $(this).attr("data-destino"), false);
	});
		
}

function Actualizar2(element) {	
	$('#TablaAnteproyectoPresupuesto2 tbody').on('click', 'tr', function() {
		abrir($(this), "#" + $(this).attr("data-destino"), false);
	});
		
}

function Actualizar3(element) {	
	$('#TablaAnteproyectoPresupuesto3 tbody').on('click', 'tr', function() {
		abrir($(this), "#" + $(this).attr("data-destino"), false);
	});
		
}

function validar(elemento) {
	
	if ($(elemento).val() === "SI") {
		$('input').prop('disabled', false);
		$('#ante_descrip').val("");	
		} else if ($(elemento).val() === "NO") {
		$('input').prop('disabled', true);
		$('input').prop('checked', false);
		$('#ante_descrip').prop('disabled', false);
		$('#ante_descrip').val("NO APLICA");	
		$('#anteFecha').prop('disabled', false);
		$('#infCod').prop('disabled', false);
		
	} else

	{
	}
}

function validar2(elemento) {
	
	if ($(elemento).val() === "SI") {
		$("textarea").text("");
		$("textarea").prop('disabled', false);
		} else if ($(elemento).val() === "NO") {
			$("textarea").prop('disabled', true);
			$("textarea").prop('required', false);
			$("textarea").text("NO APLICA");

	} else

	{
	}
}

function ValidateSelection() {
	
	var checkboxes = $('[id="checks[]"]:checked').map(function() {
		return this.value;
	}).get();
	var valor = checkboxes.length
	if (checkboxes.length === 0) {
		mostrarMensaje("Favor seleccione al menos un Actor!", "ERROR");
	}
	return valor
} 
				
</script>
