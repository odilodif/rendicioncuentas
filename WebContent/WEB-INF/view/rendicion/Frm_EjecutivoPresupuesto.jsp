<%-- 
	version		: 1.0
    Document  	: Fmr_EjecutivoPresupuesto
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
		<h5>PRESUPUESTO INSTITUCIONAL</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblPresupuestoInstitucional" id="preInsti"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarPresupuestoInstitucional" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="20%">TOTAL DE PRESUPUESTO INSTITUCIONAL CODIFICADO</th>
					<th class="tablaingreso" width="20%">GASTO CORRIENTE PLANIFICADO</th>
					<th class="tablaingreso" width="20%">GASTO CORRIENTE EJECUTADO </th>
       				<th class="tablaingreso" width="20%">GASTO DE INVERSIÓN PLANIFICADO </th>
      				<th class="tablaingreso" width="20%">GASTO DE INVERSIÓN EJECUTADO </th>
					<tr>
					<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infPresupuesto" name="infPresupuesto" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="verificaPresupuesto(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
					<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infGastplan" name="infGastplan" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="calculoPlanificado(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infGastejec" name="infGastejec" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="verificarCEIE(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infGastinvplan" name="infGastinvplan" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="verificarInversionPlanificada(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="infGastinvejec" name="infGastinvejec" placeholder="0.00"   
													maxlength="20" required="required" min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="verificarCEIE(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
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
			<table id="TablaPresupuestoInstitucional"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="3">ADMINISTRACIONES TERRITORIALES:</th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="10%">#</th>
					<th class="tablaingreso" width="20%">TOTAL DE PRESUPUESTO INSTITUCIONAL CODIFICADO</th>
					<th class="tablaingreso" width="20%">GASTO CORRIENTE PLANIFICADO</th>
					<th class="tablaingreso" width="20%">GASTO CORRIENTE EJECUTADO </th>
       				<th class="tablaingreso" width="20%">GASTO DE INVERSIÓN PLANIFICADO </th>
      				<th class="tablaingreso" width="20%">GASTO DE INVERSIÓN EJECUTADO </th>
      				<th class="tablaingreso" width="10%">% EJECUCIÓN PRESUPUESTARIA </th>
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
		
			$("#infGastejec").attr("disabled", true);
			$("#infGastinvplan").attr("disabled", true);
			$("#infGastinvejec").attr("disabled", true); 
			$("#infGastplan").attr("disabled", true);
			
});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#preInsti').attr('data-opcion',	'guardarPresupuestoInstitucional');
					var form = $("#preInsti")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {

						$("#infGastplan").attr("disabled", false);
						$("#infGastejec").attr("disabled", false);
						$("#infGastinvplan").attr("disabled", false);
						$("#infGastinvejec").attr("disabled", false);
						ejecutarJson(form);
					}
					form.addClass('was-validated');

});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaPresupuestoInstitucional').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerPresupuestoInstitucional",
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
		{data : "infPresupuesto"},
		{data : "infGastplan"}, 
		{data : "infGastejec"}, 
		{data : "infGastinvplan"}, 
		{data : "inf_gastinvejec"}, 
		{data : "infPorcetejecpres"}, 
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
			$(row).attr('id', data.preInsti);
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_presupuesto_institucional',campo:'pre_insti'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaPresupuestoInstitucional tr").length-2;
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

function calculoPlanificado(val) {
	var p = parseFloat($("#infPresupuesto").val().replace(/,/g, ""));
	var gp =parseFloat($("#infGastplan").val().replace(/,/g, ""));
	if (gp > p){
		mostrarMensaje("El gasto corriente planificado no puede superar al codificado!", "ERROR");
		$("#infGastejec").val(0);
		$("#infGastinvplan").val(0);
		$("#infGastinvejec").val(0);
		$("#infGastejec").attr("disabled", true);
		$("#infGastinvplan").attr("disabled", true);
		$("#infGastinvejec").attr("disabled", true);
		$("#btnGuardar").attr("disabled", true);
		}else{
			if (gp == p){
			$("#infGastejec").attr("disabled", false);
			$("#infGastinvplan").attr("disabled", true);
			$("#infGastinvejec").attr("disabled", true);
			$("#infGastinvplan").val(0);
			$("#infGastinvejec").val(0);
			$("#btnGuardar").attr("disabled", false);
			}else{

				$("#infGastejec").attr("disabled", false);
				$("#infGastinvplan").attr("disabled", false);
				$("#infGastinvejec").attr("disabled", false);
				var resultado = (p - gp);
				var conDecimal = resultado.toFixed(2); 
				var sresultado = formatearNumero(conDecimal);
				$("#infGastinvplan").val(sresultado);
				$("#btnGuardar").attr("disabled", false);
				$("#infGastejec").val(null);
				$("#infGastinvejec").val(null);
					
				} 

			}
	}

/* function verificarGastoEjecutado(val) {

	var ge = parseFloat($("#infGastejec").val().replace(/,/g, ""));
	var gp =parseFloat($("#infGastplan").val().replace(/,/g, ""));
	
	if (ge > gp) {

		mostrarMensaje( "El valor del gasto cooriente ejecutado no puede ser mayor al gasto corriente planificado!","ERROR");
		$("#btnGuardar").attr("disabled", true);
	}else{
			$("#btnGuardar").attr("disabled", false);
	}
}
 */



function verificarInversionPlanificada(val) {

	var p = parseFloat($("#infPresupuesto").val().replace(/,/g, ""));
	var gp =parseFloat($("#infGastplan").val().replace(/,/g, ""));
	var ip =parseFloat($("#infGastinvplan").val().replace(/,/g, ""));
	var diferencia = p - gp;
	
	if (ip > diferencia) {

		mostrarMensaje( "El valor del gasto de inversión planificado no puede ser mayor a la diferencia entre el presupuesto institucional codificado y gasto corriente planificado!","ERROR");
		$("#btnGuardar").attr("disabled", true);
		}else{
			$("#btnGuardar").attr("disabled", false);
			
	}
}


 function verificarCEIE(val) {

		var p = parseFloat($("#infPresupuesto").val().replace(/,/g, ""));
		var gie =parseFloat($("#infGastinvejec").val().replace(/,/g, ""));
		var gce =parseFloat($("#infGastejec").val().replace(/,/g, ""));
		var sumaGastos = gie + gce;
		
		if (sumaGastos > p) {

			mostrarMensaje( "La suma de los gastos correiente y de inversión ejecutados no puede ser mayor al presupuesto institucional codificado!","ERROR");
			$("#btnGuardar").attr("disabled", true);
			}else{
				$("#btnGuardar").attr("disabled", false);
				
		}
	}

/* function verificarInversionEjecutado(val) {

	var ge = parseFloat($("#infGastinvejec").val().replace(/,/g, ""));
	var gp =parseFloat($("#infGastinvplan").val().replace(/,/g, ""));
	
	if (ge > gp) {

		mostrarMensaje( "El valor del gasto de inversión ejecutado no puede ser mayor al gasto inversión planificado!","ERROR");
		$("#btnGuardar").attr("disabled", true);
		}else{
			$("#btnGuardar").attr("disabled", false);
			
	}
} */

function verificaPresupuesto(val) {

	if (val == 0) {

		$("#infGastplan").val(0);
		$("#infGastejec").val(0);
		$("#infGastinvplan").val(0);
		$("#infGastinvejec").val(0);
		$("#infGastplan").attr("disabled", true);
		$("#infGastejec").attr("disabled", true);
		$("#infGastinvplan").attr("disabled", true);
		$("#infGastinvejec").attr("disabled", true);
		
		
		}else{
			$("#infGastplan").attr("disabled", false);
			$("#infGastejec").attr("disabled", false);
			$("#infGastinvplan").attr("disabled", false);
			$("#infGastinvejec").attr("disabled", false); 

			$("#infGastplan").val(null);
			$("#infGastejec").val(null);
			$("#infGastinvplan").val(null);
			$("#infGastinvejec").val(null);
			 
	}
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
