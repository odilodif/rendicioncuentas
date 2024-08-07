<%-- 
	version		: 1.0
    Document  	: Frm_PresupuestariosEducacion
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
		<h5>ASPECTOS PRESUPUESTARIOS DEL REGLAMENTO A LA LEY ORGÁNICA DE EDUCACIÓN SUPERIOR -LOES- </h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblPresupuestoEducacion" id="PresupuestoEducacion"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarPresupuestoEducacion" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="40%">ASPECTOS PRESUPUESTARIOS LEGALES </th>
					<th class="tablaingreso" width="20%">PRESUPUESTO PLANIFICADO</th>
					<th class="tablaingreso" width="20%">PRESUPUESTO EJECUTADO</th>
       				<th class="tablaingreso" width="20%">% CUMPLIMIENTO</th>
					<tr>
					<td scope="row">
												<select class="custom-select custom-select-sm avance" id="peAspecto" name="peAspecto" required="required" >
												<option value="">Seleccione...</option>
												<option value="FORMACIÓN Y CAPACITACIÓN DE PROFESORES  E INVESTIGADORES">FORMACIÓN Y CAPACITACIÓN DE PROFESORES  E INVESTIGADORES</option>
												<option value="PUBLICACIONES INDEXADAS, BECAS DE POSTGRADO PARA SUS PROFESORES E INVESTIGACIÓN">PUBLICACIONES INDEXADAS, BECAS DE POSTGRADO PARA SUS PROFESORES E INVESTIGACIÓN</option>
												<option value="PROGRAMAS DE BECAS O AYUDAS A ESTUDIANTES REGULARES">PROGRAMAS DE BECAS O AYUDAS A ESTUDIANTES REGULARES</option>
												<option value="POSTGRADOS DE DOCTORADOS PARA PROFESORES TITULADOS AGREGADOS EN UNIVERSIDADES PÚBLICAS">POSTGRADOS DE DOCTORADOS PARA PROFESORES TITULADOS AGREGADOS EN UNIVERSIDADES PÚBLICAS</option>
												<option value="USO DE FONDOS QUE NO SEAN PROVENIENTES DEL ESTADO">USO DE FONDOS QUE NO SEAN PROVENIENTES DEL ESTADO</option>
												<option value="ACTIVIDADES PRESUPUESTADAS CON EXCEDENTES FINANCIEROS DE COBROS DE ARANCELES A ESTUDIANTES">ACTIVIDADES PRESUPUESTADAS CON EXCEDENTES FINANCIEROS DE COBROS DE ARANCELES A ESTUDIANTES</option>
												
									</select>
										<div class="invalid-feedback">Por Ingrese su opción</div>
								    </td>
					<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="pePlanificado" name="pePlanificado" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="calculopePlanificado(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="peEjecutado" name="peEjecutado" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false" onchange="calculopeTotal(this.value)">
												<div class="invalid-feedback">Por favor ingrese la información solicitada</div>
						</td>
							<td scope="row">
												<input type="text" class="form-control form-control-sm"
													id="peTotal" name="peTotal" placeholder="0.00" 
													maxlength="20" required="required"  min="0"
													 onkeypress="mascara(this,cpf)"  onpaste="return false">
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
			<table id="TablaPresupuestoEducacion"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="3">ADMINISTRACIONES TERRITORIALES:</th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="50%">#</th>
					<th class="tablaingreso" width="40%">ASPECTOS PRESUPUESTARIOS LEGALES</th>
					<th class="tablaingreso" width="20%">PRESUPUESTO PLANIFICADO</th>
					<th class="tablaingreso" width="20%">PRESUPUESTO EJECUTADO</th>
       				<th class="tablaingreso" width="15%">% CUMPLIMIENTO</th>
      				<th> </th>
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

//Se comenta los disables, a pedido del ticker 1635, si se quiere no permitir en cero, descomentar TODOS los disables
$(document).ready(
		function() {

			if ('${infestado}' == 'matriz') {
				tabla();			
			}

			if('${infestadoinforme}' == 'finalizado'){
				var inputs = document.getElementsByTagName("input"); 
			    for (var i = 0; i < inputs.length; i++) {
			        //inputs[i].disabled = true;
			    } 
			    var buttons = document.getElementsByTagName("button");
			    for (var i = 0; i < buttons.length; i++) { 
			    	//buttons[i].disabled = true;
			    	
			    } 
			}
			
});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#PresupuestoEducacion').attr('data-opcion',	'guardarPresupuestoEducacion');
					var form = $("#PresupuestoEducacion")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {

						$("#peTotal").attr("disabled", false);
						
						ejecutarJson(form);
					}
					form.addClass('was-validated');

});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaPresupuestoEducacion').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerPresupuestoEducacion",
	headers : {"X-CSRF-TOKEN" : csrfToken},
	type : "POST"	},
	order : [ 0, "asc" ],		
	columns : [
		{data : "contador"},
		{data : "peAspecto"},
		{data : "pePlanificado"}, 
		{data : "peEjecutado"}, 
		{data : "peTotal"}, 
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
			$(row).attr('id', data.pe_cod);
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_presupuesto_educacion',campo:'pe_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaPresupuestoEducacion tr").length-2;
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


function calculopePlanificado(val) {
	var pl = parseFloat($("#pePlanificado").val().replace(/,/g, ""));
	var pe =parseFloat($("#peEjecutado").val().replace(/,/g, ""));

	if (pl < 0){
		mostrarMensaje("El presupuesto planificado no puede ser menor a 0!", "ERROR");
		//$("#btnGuardar").attr("disabled", true);
		}else{
			if (pl == 0 ||pl==null ||pl=="" ){
				$ ("#peTotal").val(0);
				$("#peTotal").attr("disabled", true);
				$("#peEjecutado").val(0);
				//$("#peEjecutado").attr("disabled", true);
				//$("#btnGuardar").attr("disabled", true);
		
			}else{

				$("#pePlanificado").attr("disabled", false);
			
				 if(pe==0){
					 mostrarMensaje("Ingrese el presupuesto ejecutado!", "ERROR");
						$("#peEjecutado").val("");
						$("#peEjecutado").attr("disabled", false);
						$("#btnGuardar").attr("disabled", false);
					 }else{
						 var resultado = (pe /pl *100);
							var conDecimal = resultado.toFixed(2); 
							var sresultado = formatearNumero(conDecimal);
							$("#peTotal").val(sresultado);
							$("#peTotal").attr("disabled", true)
						 }
				} 

			}
	}


function calculopeTotal(val) {
	var pl = parseFloat($("#pePlanificado").val().replace(/,/g, ""));
	var pe =parseFloat($("#peEjecutado").val().replace(/,/g, ""));
	if (pl < 0){
		mostrarMensaje("El presupuesto planificado no puede ser menor a 0!", "ERROR");
		//$("#btnGuardar").attr("disabled", true);
		}else{
			if (pl == 0 || pl==null ){
			$("#peTotal").val(0);
			$("#peTotal").attr("disabled", true);
			$("#pePlanificado").val(0);
			$("#pePlanificado").attr("disabled", true);
			$("#peEjecutado").val(0);
			//$("#peEjecutado").attr("disabled", true);
			$("#btnGuardar").attr("disabled", false);
			}else{
				if(pe>pl){

					mostrarMensaje("El presupuesto ejecutado no puede ser mayor al presupuesto planificado!", "ERROR");
					$("#btnGuardar").attr("disabled", true);
				}else{	
				var resultado = (pe /pl *100);
				var conDecimal = resultado.toFixed(2); 
				var sresultado = formatearNumero(conDecimal);
				$("#peTotal").val(sresultado);
				$("#btnGuardar").attr("disabled", false);
				$("#peTotal").attr("disabled", true)
				}		
				} 

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
