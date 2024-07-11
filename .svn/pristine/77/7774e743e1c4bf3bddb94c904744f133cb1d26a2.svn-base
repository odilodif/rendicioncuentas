<%-- 
	version		: 1.0
    Document  	: Frm_FondoPrestacional
    Created on	: 25 mar. 2021; 08:34:14
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
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

<div class="card  mb-card15">
	<c:choose>
		<c:when test="${inf_estado=='activo'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>PLANIFICACIÓN: SE REFIERE A LA ARTICULACIÓN DE POLÍTICAS</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblFondoPrestacional" id="FondoPrestacional"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarFondoPrestacional"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
							<div class="ibox-content">
								<div class="table-responsive">
									<table class="table table-bordered" id="tablaid">
										<thead>
											<tr>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">FONDO PRESTACIONAL</th>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">TOTAL PRESUPUESTO
													INSTITUCIONAL</th>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">GASTO CORRIENTE
													PLANIFICADO</th>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">GASTO CORRIENTE EJECUTADO</th>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">GASTO DE INVERSIÓN
													PLANIFICADO</th>
												<th scope="col" class="tablaingreso"
													style="font-size: x-small;">GASTO DE INVERSIÓN
													EJECUTADO</th>

											</tr>
										</thead>
										<tbody>
											<tr id="fila0">
												<td scope="row"><label id="fpDesc">SALUD</label> <input
													type="hidden" id="fpDesc[]" name="fpDesc[]"
													class="form-control form-control-sm" value="SALUD">
													<div class="invalid-feedback">Por Ingrese las
														Sugerencias Ciudadanas</div></td>

												<td scope="row"><input type="text"
													class="form-control form-control-sm campo total"
													id="fpPresins[]" name="fpPresins[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoCorr"
													id="fpGastcp[]" name="fpGastcp[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoCorri"
													id="fpGastce[]" name="fpGastce[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoInver"
													id="fpGastip[]" name="fpGastip[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoInver"
													id="fpGastie[]" name="fpGastie[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>

											</tr>
											<tr id="fila1">
												<td scope="row"><label id="fpDesc">SEGURO
														SOCIAL CAMPESINO</label> <input type="hidden" id="fpDesc[]"
													name="fpDesc[]" class="form-control form-control-sm"
													value="SEGURO SOCIAL CAMPESINO">
													<div class="invalid-feedback">Por Ingrese las
														Sugerencias Ciudadanas</div></td>

												<td scope="row"><input type="text"
													class="form-control form-control-sm campo total"
													id="fpPresins[]" name="fpPresins[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoCorr"
													id="fpGastcp[]" name="fpGastcp[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoCorri"
													id="fpGastce[]" name="fpGastce[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoInver"
													id="fpGastip[]" name="fpGastip[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoInver"
													id="fpGastie[]" name="fpGastie[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>

											</tr>
											<tr id="fila2">
												<td scope="row"><label id="fpDesc">SEGURO
														RIESGOS DEL TRABAJO</label> <input type="hidden" id="fpDesc[]"
													name="fpDesc[]" class="form-control form-control-sm"
													value="SEGURO RIESGOS DEL TRABAJO">
													<div class="invalid-feedback">Por Ingrese las
														Sugerencias Ciudadanas</div></td>

												<td scope="row"><input type="text"
													class="form-control form-control-sm campo total"
													id="fpPresins[]" name="fpPresins[]" placeholder="0.00" 
													maxlength="13" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoCorr"
													id="fpGastcp[]" name="fpGastcp[]" placeholder="0.00" 
													maxlength="13" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoCorri"
													id="fpGastce[]" name="fpGastce[]" placeholder="0.00" 
													maxlength="13" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoInver"
													id="fpGastip[]" name="fpGastip[]" placeholder="0.00" 
													maxlength="13" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoInver"
													id="fpGastie[]" name="fpGastie[]" placeholder="0.00" 
													maxlength="13" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>

											</tr>
											<tr id="fila3">
												<td scope="row"><label id="fpDesc">PENSIONES</label> <input
													type="hidden" id="fpDesc[]" name="fpDesc[]"
													class="form-control form-control-sm" value="PENSIONES">
													<div class="invalid-feedback">Por Ingrese las
														Sugerencias Ciudadanas</div></td>

												<td scope="row"><input type="text"
													class="form-control form-control-sm campo total"
													id="fpPresins[]" name="fpPresins[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoCorr"
													id="fpGastcp[]" name="fpGastcp[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoCorri"
													id="fpGastce[]" name="fpGastce[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo planificadoInver"
													id="fpGastip[]" name="fpGastip[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>
												<td scope="row"><input type="text"
													class="form-control form-control-sm campo ejecutadoInver"
													id="fpGastie[]" name="fpGastie[]" placeholder="0.00" 
													maxlength="20" required="required" min="0"
													onkeypress="mascara(this,cpf)" onpaste="return false">
													<div class="invalid-feedback">Por favor ingrese el
														cantidad</div></td>

											</tr>

										</tbody>
									</table>
								</div>
							</div>
						</form:form>
					</div>

				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>
		</c:when>
		<c:when test="${inf_estado=='matriz'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>PLANIFICACIÓN: SE REFIERE A LA ARTICULACIÓN DE POLÍTICAS</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div id="actualizar">
						<div class="col-md-12 order-md-1">
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblFondoPrestacional"
								id="FondoPrestacionalActul" data-rutaAplicacion="rendicion"
								data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
								<div class="ibox-content">
									<div class="table-responsive">
										<table class="table  table-bordered" id="tablaid">
											<thead>
												<tr>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">FONDO PRESTACIONAL</th>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">TOTAL PRESUPUESTO
														INSTITUCIONAL</th>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">GASTO CORRIENTE
														PLANIFICADO</th>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">GASTO CORRIENTE EJECUTADO</th>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">GASTO DE INVERSIÓN
														PLANIFICADO</th>
													<th scope="col" class="tablaingreso"
														style="font-size: x-small;">GASTO DE INVERSIÓN
														EJECUTADO</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													<td scope="row"><label id="fp_desc"></label></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm total" id="fp_presins"
														name="fp_presins" placeholder="0.00"  maxlength="13"
														required="required" min="0" onkeypress="mascara(this,cpf)"
														onpaste="return false">
														<div class="invalid-feedback">Por favor ingrese el
															cantidad</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm planificadoCorr" id="fp_gastcp"
														name="fp_gastcp" placeholder="0.00"  maxlength="13"
														required="required" min="0" onkeypress="mascara(this,cpf)"
														onpaste="return false">
														<div class="invalid-feedback">Por favor ingrese el
															cantidad</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm ejecutadoCorri" id="fp_gastce"
														name="fp_gastce" placeholder="0.00"  maxlength="13"
														required="required" min="0" onkeypress="mascara(this,cpf)"
														onpaste="return false">
														<div class="invalid-feedback">Por favor ingrese el
															cantidad</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm planificadoInver" id="fp_gastip"
														name="fp_gastip" placeholder="0.00"  maxlength="13"
														required="required" min="0" onkeypress="mascara(this,cpf)"
														onpaste="return false">
														<div class="invalid-feedback">Por favor ingrese el
															cantidad</div></td>
													<td scope="row"><input type="text"
														class="form-control form-control-sm ejecutadoInver" id="fp_gastie"
														name="fp_gastie" placeholder="0.00"  maxlength="13"
														required="required" min="0" onkeypress="mascara(this,cpf)"
														onpaste="return false">
														<div class="invalid-feedback">Por favor ingrese el
															cantidad</div></td>

												</tr>
											</tbody>

										</table>
									</div>
								</div>
							</form:form>
						</div>

						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
						<input type="hidden" id="fp_cod" name="fp_cod">
					</div>

					<div id="tabla" class="col-md-12 order-md-1">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="tablaRegistrosPlanificacionPoliticas"
									class="table table-striped table-bordered" style="width: 100%">
									<thead>
										<tr>
											<th>#</th>
											<th style="font-size: x-small;">FONDO PRESTACIONAL</th>
											<th style="font-size: x-small;">TOTAL PRESUPUESTO
												INSTITUCIONAL</th>
											<th style="font-size: x-small;">GASTO CORRIENTE
												PLANIFICADO</th>
											<th style="font-size: x-small;">GASTO CORRIENTE
												EJECUTADO</th>
											<th style="font-size: x-small;">GASTO DE INVERSIÓN
												PLANIFICADO</th>
											<th style="font-size: x-small;">GASTO DE INVERSIÓN
												EJECUTADO</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
								<hr />
							</div>
						</div>
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
			$(".campo").prop("disabled", "disabled");
			$(".total").removeAttr('disabled');
			$("#actualizar").hide();
			 if ('${inf_estado}' == 'matriz'||'${infestadoinforme}' == 'finalizado') {
				tabla();			
			}
});
			
$("#btnGuardar").click(function(event) {
	var form = $("#FondoPrestacional");	
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje(
				"Por favor ingrese toda la información solicitada!",
				"ERROR");
	} else {
		$(".campo").removeAttr("disabled");
		ejecutarJson(form);
	}
	form.addClass('was-validated');
});

function tabla() {
	var parametros = {"infCod" : '${inf_Cod}'};
	$('#tablaRegistrosPlanificacionPoliticas').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosFondoPrestacional",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
		order : [ 0, "asc" ],
		bDestroy : true,
	    columns : [
	    	{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
			 	}},
			 	{data : "fpDesc"},
				{data : "fpPresins"},
				{data : "fpGastcp"},
				{data : "fpGastce"},	
				{data : "fpGastip"},
				{data : "fpGastie"},
			/*{data : "contador" },
			{data : "descripcion"},
			{data : "PresuInsti"},
			{data : "PresuCorriPlan"},
			{data : "PresuCorrEjec"},	
			{data : "PresuInverPlan"},
			{data : "PresuInverEjec"},*/
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Editar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             } return data;
    }}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.fpCod);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td").css({
				"font-size"   : "x-small",			
			});	
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
    var descripcion = $(element).parent().parent().find("td:eq(1)").text();
    var PresuInsti = $(element).parent().parent().find("td:eq(2)").text();
    var PresuCorriPlan = $(element).parent().parent().find("td:eq(3)").text();
    var PresuCorrEjec = $(element).parent().parent().find("td:eq(4)").text();
    var PresuInverPlan = $(element).parent().parent().find("td:eq(5)").text();
    var PresuInverEjec = $(element).parent().parent().find("td:eq(6)").text();
    

	    $("#actualizar").show();
	    $("#tabla").hide();	
	   	
		 $("#fp_cod").val(codigo);
		 $("#fp_desc").text(descripcion);	
		 $("#fp_presins").val(PresuInsti);
		 $("#fp_gastcp").val(PresuCorriPlan);
		 $("#fp_gastce").val(PresuCorrEjec);
		 $("#fp_gastip").val(PresuInverPlan);
		 $("#fp_gastie").val(PresuInverEjec);	
}
function replazarmiles(Numero) {
	return Numero.replace(/[^\d,]/g,"");
	 
}

function replazarmilesActualizar(Numero) {
	var a= Numero.replace(/[^\d.]/g,"");
	 return a
	 
}

function milesNumeros(numero) {
    return numero.toString().replace(/(\.\d+)|\B(?=(\d{3})+(?!\d))/g, function(m,g1){
        return g1 || ","
    });
};

$("#btnActualizar").click(function(event) {
			var form = $("#FondoPrestacionalActul")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
				$("#fp_presins").val(replazarmilesActualizar($("#fp_presins").val()));
				$("#fp_gastcp").val(replazarmilesActualizar($("#fp_gastcp").val()));
				$("#fp_gastce").val(replazarmilesActualizar($("#fp_gastce").val()));
				$("#fp_gastip").val(replazarmilesActualizar($("#fp_gastip").val()));
				$("#fp_gastie").val(replazarmilesActualizar($("#fp_gastie").val()));
	
				var columnas = '';
				 var x = $(form).serializeArray();
				    $.each(x, function(i, field){
				    	columnas+= field.name+ ',99';
				    	if (columnas.length > 0) {
				    		columnas = columnas.substr(0, columnas.length - 1);
                        }
				    });
				    var valores = '';
					 var x = $(form).serializeArray();
					    $.each(x, function(i, field){
					    	valores+= field.value+ ',99';
					    	if (valores.length > 0) {
					    		valores = valores.substr(0, valores.length - 1);
	                        }
					    });
				  var data = {tabla: 'esq_rendicioncuentas.tbl_fondo_prestacional',columns:columnas,values:valores,condicion:'fp_cod',valorcondicion:$("#fp_cod").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	

$("#tablaid tr td").find(".total").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");
        $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
        $(this).closest('tr').find(".planificadoCorr").removeAttr("required");
        $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
        $(this).closest('tr').find(".ejecutadoCorri").removeAttr("required");
        $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
        $(this).closest('tr').find(".planificadoInver").removeAttr("required");
        $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
        $(this).closest('tr').find(".ejecutadoInver").removeAttr("required");
        $(this).closest('tr').find(".planificadoCorr").val("0");
        $(this).closest('tr').find(".ejecutadoCorri").val("0");
        $(this).closest('tr').find(".planificadoInver").val("0");
        $(this).closest('tr').find(".ejecutadoInver").val("0");
   
   }else{
	
	   $(this).closest('tr').find(".campo").removeAttr('disabled');
       $(this).closest('tr').find(".campo").prop("required", true);
       $(this).closest('tr').find(".planificadoCorr").val("");
       $(this).closest('tr').find(".ejecutadoCorri").val("");
       $(this).closest('tr').find(".planificadoInver").val("");
       $(this).closest('tr').find(".ejecutadoInver").val("");
    

   }
});


$("#tablaid tr td").find(".planificadoCorr").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Corriente = 0;
	$('.ejecutadoCorri', row).each(function() {
		Ejecutado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
	
		if(Planificado_Corriente > total){
			$(this).closest('tr').find(".total").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
			   $("#btnGuardar").attr("disabled", true);
			   $("#btnActualizar").attr("disabled", true);
			   
				mostrarMensaje( "El valor del gasto corriente planificado no puede ser mayor al presupuesto institucional!","ERROR");
              
			}else{
				$(this).closest('tr').find(".total").removeAttr('disabled');
				   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');
				   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
				   $("#btnGuardar").removeAttr('disabled');
				   $("#btnActualizar").removeAttr('disabled');

				}
   }
});

$("#tablaid tr td").find(".ejecutadoCorri").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Corriente = 0;
	$('.ejecutadoCorri', row).each(function() {
		Ejecutado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{	  
		if(Ejecutado_Corriente  > Planificado_Corriente){
			$(this).closest('tr').find(".total").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
			   $("#btnGuardar").attr("disabled", true);
			   $("#btnActualizar").attr("disabled", true);
			   mostrarMensaje( "El valor del gasto corriente Ejecutado no puede ser mayor al gasto corriente planificado!","ERROR");

			}else{
				$(this).closest('tr').find(".total").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');;
				   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
				   $("#btnGuardar").removeAttr('disabled');
				   $("#btnActualizar").removeAttr('disabled');
				}
   }
});


$("#tablaid tr td").find(".planificadoInver").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Inversion = 0;
	$('.planificadoInver', row).each(function() {
		Planificado_Inversion +=  Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
		if((parseFloat(total)- parseFloat(Planificado_Corriente) >= Planificado_Inversion ) ){
			$(this).closest('tr').find(".total").removeAttr('disabled');
			   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
			   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');;
			   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
			   $("#btnGuardar").removeAttr('disabled');
			   $("#btnActualizar").removeAttr('disabled');
			 
			}else{
				$(this).closest('tr').find(".total").prop("disabled", true);
				   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
				   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
				   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
				   $("#btnGuardar").attr("disabled", true);
				   $("#btnActualizar").attr("disabled", true);
				   mostrarMensaje( "El gasto inversión planificado no pude ser mayor que la diferencia ente(Presupuesto Intitucional - Gasto corriente planificado)!","ERROR");

				}
	   
	 
   }
});

$("#tablaid tr td").find(".ejecutadoInver").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Inversion = 0;
	$('.planificadoInver', row).each(function() {
		Planificado_Inversion += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Inversion = 0;
	$('.ejecutadoInver', row).each(function() {
		Ejecutado_Inversion +=  Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
		if(Ejecutado_Inversion > Planificado_Inversion ){
	   $(this).closest('tr').find(".total").prop("disabled", true);
	   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
	   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
	   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
	   $("#btnGuardar").attr("disabled", true);
	   $("#btnActualizar").attr("disabled", true);
	   mostrarMensaje( "El gasto inversión e jecutado no pude ser mayor al gasto inversión planificado!","ERROR");

	  }else{
	   $(this).closest('tr').find(".total").removeAttr('disabled');
	   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
	   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');;
	   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');
	   $("#btnGuardar").removeAttr('disabled');
	   $("#btnActualizar").removeAttr('disabled');
		}
   }
});
/*

$("#tablaid tr td").find(".total").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
	
	   $(this).closest('tr').find(".campo").removeAttr('disabled');
       $(this).closest('tr').find(".campo").prop("required", true);
       $(this).closest('tr').find(".planificadoCorr").val("");
       $(this).closest('tr').find(".ejecutadoCorri").val("");
       $(this).closest('tr').find(".planificadoInver").val("");
       $(this).closest('tr').find(".ejecutadoInver").val("");
    

   }
});


$("#tablaid tr td").find(".planificadoCorr").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Corriente = 0;
	$('.ejecutadoCorri', row).each(function() {
		Ejecutado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
	
		if(Planificado_Corriente > total){
			$(this).closest('tr').find(".total").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
			   $("#btnGuardar").attr("disabled", true);
				mostrarMensaje( "El valor del gasto corriente planificado no puede ser mayor al presupuesto institucional!","ERROR");
              
			}else{
				$(this).closest('tr').find(".total").removeAttr('disabled');
				   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');
				   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
				   $("#btnGuardar").removeAttr('disabled');

				}
   }
});

$("#tablaid tr td").find(".ejecutadoCorri").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Corriente = 0;
	$('.ejecutadoCorri', row).each(function() {
		Ejecutado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{	  
		if(Ejecutado_Corriente  > Planificado_Corriente){
			$(this).closest('tr').find(".total").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
			   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
			   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
			   $("#btnGuardar").attr("disabled", true);
			   mostrarMensaje( "El valor del gasto corriente Ejecutado no puede ser mayor al gasto corriente planificado!","ERROR");

			}else{
				$(this).closest('tr').find(".total").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
				   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');;
				   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
				   $("#btnGuardar").removeAttr('disabled');
				}
   }
});


$("#tablaid tr td").find(".planificadoInver").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Corriente = 0;
	$('.planificadoCorr', row).each(function() {
		Planificado_Corriente += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Inversion = 0;
	$('.planificadoInver', row).each(function() {
		Planificado_Inversion +=  Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
		if((parseFloat(total)- parseFloat(Planificado_Corriente) >= Planificado_Inversion ) ){
			$(this).closest('tr').find(".total").removeAttr('disabled');
			   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
			   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');;
			   $(this).closest('tr').find(".ejecutadoInver").removeAttr('disabled');
			   $("#btnGuardar").removeAttr('disabled');
			 
			}else{
				$(this).closest('tr').find(".total").prop("disabled", true);
				   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
				   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
				   $(this).closest('tr').find(".ejecutadoInver").prop("disabled", true);
				   $("#btnGuardar").attr("disabled", true);
				   mostrarMensaje( "El gasto inversión planificado no pude ser mayor que la diferencia ente(Presupuesto Intitucional - Gasto corriente planificado)!","ERROR");

				}
	   
	 
   }
});

$("#tablaid tr td").find(".ejecutadoInver").change(function () {
	var row = $(this).closest('tr');
	var total = 0;
	$('.total', row).each(function() {
        total += Number($(this).val().replace(/,/g, ""));
    });
	var Planificado_Inversion = 0;
	$('.planificadoInver', row).each(function() {
		Planificado_Inversion += Number($(this).val().replace(/,/g, ""));
    });
	var Ejecutado_Inversion = 0;
	$('.ejecutadoInver', row).each(function() {
		Ejecutado_Inversion +=  Number($(this).val().replace(/,/g, ""));
    });
   if(total==0){	   
	    $(this).closest('tr').find(".campo").prop("disabled", true);
        $(this).closest('tr').find(".campo").removeAttr("required");
        $(this).closest('tr').find(".campo").val("0");
        $(this).closest('tr').find(".total").removeAttr("disabled");

   }else{
		if(Ejecutado_Inversion > Planificado_Inversion ){
	   $(this).closest('tr').find(".total").prop("disabled", true);
	   $(this).closest('tr').find(".planificadoCorr").prop("disabled", true);
	   $(this).closest('tr').find(".ejecutadoCorri").prop("disabled", true);
	   $(this).closest('tr').find(".planificadoInver").prop("disabled", true);
	   $("#btnGuardar").attr("disabled", true);
	   mostrarMensaje( "El gasto inversión e jecutado no pude ser mayor al gasto inversión planificado!","ERROR");

	  }else{
	   $(this).closest('tr').find(".total").removeAttr('disabled');
	   $(this).closest('tr').find(".planificadoCorr").removeAttr('disabled');
	   $(this).closest('tr').find(".ejecutadoCorri").removeAttr('disabled');;
	   $(this).closest('tr').find(".planificadoInver").removeAttr('disabled');
	   $("#btnGuardar").removeAttr('disabled');
		}
   }
});*/

</script>
