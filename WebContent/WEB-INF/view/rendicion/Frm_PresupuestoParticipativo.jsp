<%-- 
	version		: 1.0
    Document  	: Frm_PresupuestoParticipativo
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
		<h5>PRESUPUESTO CODIFICADO</h5>
		<h5>CUENTA CON PRESUPUESTO PARTICIPATIVO</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblPorcentajePresupuesto" id="presCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarPorcentajePresupuesto" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="20%">MARQUE SI O NO</th>
					<th class="tablaingreso" width="20%">TOTAL DE PRESUPUESTO DE LA INSTITUCIÓN </th>
					<th class="tablaingreso" width="20%">PRESUPUESTO TOTAL ASIGNADO AL PRESUPUESTO ASIGNADO PARA PRESUPUESTOS PARTICIPATIVOS </th>
       				<th class="tablaingreso" width="40%">MEDIOS DE VERIFICACIÓN (ACTO NORMATIVO DE PRESUPUESTO PARTICIPATIVO)  </th>

					<tr>
					<td scope="row">
									<select class="custom-select custom-select-sm " id="infTieneprespar"  name="infTieneprespar" onchange="validar(this)"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div></td>
					<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infTotalpres" name="infTotalpres" placeholder="0.00" 													maxlength="20" required="required"  min="0"
													onkeypress="mascara(this,cpf)"  onpaste="return false">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infPresparticipativo" name="infPresparticipativo" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													onkeypress="mascara(this,cpf)"  onpaste="return false"   onchange="calculoPresupuesto(this.value)"> 
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="infLinkpres" name="infLinkpres" 
                                    required="required" placeholder="Dirección de página web" value="http://">
									<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							
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
			<table id="TablaPorcentajePresupuesto"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="6">PRESUPUESTO PARTICIPATIVO:</th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="10%">#</th>
					<th class="tablaingreso" width="20%">TOTAL DE PRESUPUESTO DE LA INSTITUCIÓN</th>
					<th class="tablaingreso" width="20%">PRESUPUESTO TOTAL ASIGNADO AL PRESUPUESTO ASIGNADO PARA PRESUPUESTOS PARTICIPATIVOS</th>
					<th class="tablaingreso" width="20%">PORCENTAJE DE PRESUPUESTO INSTITUCIONAL ASIGNADO PARA PRESUPUESTOS PARTICIPATIVOS </th>
       				<th class="tablaingreso" width="20%">MEDIOS DE VERIFICACIÓN (ACTO NORMATIVO DE PRESUPUESTO PARTICIPATIVO)</th>
					<th> </th>
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

var csrfToken = $('input[name="_csrf"]').val();

$(document).ready(
		function() {

			if ('${infestado}' == 'matriz') {
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
});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#presCod').attr('data-opcion',	'guardarPorcentajePresupuesto');
					var form = $("#presCod")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
					
						ejecutarJson(form);
					}
					form.addClass('was-validated');

});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaPorcentajePresupuesto').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerPorcentajePresupuesto",
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
		{data : "infTotalpres"},
		{data : "infPresparticipativo"}, 
		{data : "infPorprespar"}, 
		{data : "infLinkpres"}, 
		{ data: "" ,"render": function (data, type, full, meta) {
			if('${infestadoinforme}' === "finalizado"){
           	 data = '';     
            }else{
	            data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor  btn-sm" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"  style="text-align: center; font-size: x-small;"> Eliminar</button>';    
            }
	            return data;
        }}
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.presCod);
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

function Eliminar(element) {	
	var codigo = $(element).closest('tr').attr('id');	
	 $.ajax({
	        url: 'view/rendicion/eliminarDatos',
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        type: "POST",
	        dataType: 'json',
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_porcentaje_presupuesto',campo:'pres_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaPorcentajePresupuesto tr").length-2;
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

function validar(elemento) {

	if ($(elemento).val() === "SI"){
		 $(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		 $("#infTotalpres").prop("required", true);
		 $("#infPorprespar").prop("required", true);
		 $("#infTotalpres").attr("disabled", false);
	     $("#infPorprespar").attr("disabled", false);
		 $("#infPresparticipativo").attr("disabled", false);
	     
	     
	}else if($(elemento).val() === "NO"){
		$(this).closest('tr').find("input").prop("disabled", true);		
		$(".campo").prop("disabled", "disabled");
		$(".url").val("NO APLICA");
		$(".url").get(0).type = 'text';
		$(".campo").removeAttr("required");
		$("#infTotalpres").attr("disabled", true);
		$('#infTotalpres').val('');
		$("#infPorprespar").attr("disabled", true);
		$('#infPorprespar').val('');
		$("#infPresparticipativo").attr("disabled", true);
		$('#infPresparticipativo').val('');
		
	}else
	
	{
		
	}
}

function calculoPresupuesto(val) {
	var p = parseFloat($("#infTotalpres").val().replace(/,/g, ""));
	var pp =parseFloat($("#infPresparticipativo").val().replace(/,/g, ""));
	if (pp > p){
		mostrarMensaje("El presupuesto asignado no puede superar al presupuesto de la institución!", "ERROR");
		$("#btnGuardar").attr("disabled", true);
		

		
		
	}else{
		$("#btnGuardar").attr("disabled", false);
		
}
		
	}


				
</script>
