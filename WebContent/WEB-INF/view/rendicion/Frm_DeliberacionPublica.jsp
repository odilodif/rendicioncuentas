<%-- 
	version		: 1.0
    Document  	: Frm_DeliberacionPublica
    Author		: Wilmer Guaman
    Mail		: guamanw@gmail.com
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
		<h5>DATOS DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="TblDatosInforme"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarDatosInforme" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
               
                <tr>
                    <th colspan="7" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                            FECHA EN QUE SE REALIZÓ LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS:
                    </th>
                    <td colspan="3">
                       <div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="inf_fecharc"
											name="inf_fecharc"
											class="form-control form-control-sm calendario" value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de deliberación</div>
									</div>
                    </td>
                </tr>
                <tr>
                    <th rowspan="3" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                       
                            PARTICIPANTES EN EL EVENTO DE RENDICIÓN DE CUENTAS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        NO. DE PARTICIPANTES
                    </th>
                    <th scope="col" class="tablaingreso" colspan="3" style="text-align: center; font-size:x-small;">
                       GÉNERO
                    </th>
                    <th scope="col" class="tablaingreso" colspan="5" style="text-align: center; font-size:x-small;">
                       PUEBLOS Y NACIONALIDADES
                    </th>
                </tr>
                <tr>
                    <td scope="row" rowspan="2">
                      <input type="number" class="form-control form-control-sm usuarios" id="inf_usuarios"  name="inf_usuarios" required="required" 
                      maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MASCULINO
                        
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        FEMENINO
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%" >
                        GLBTI
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MONTUBIOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        CHOLOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        INDIGENAS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MESTIZOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        AFROECUATORIANOS
                    </th>
                </tr>
                <tr align="center">
                    <td scope="row">
                        <input type="number" class="form-control form-control-sm hombres" id="inf_hombre"  name="inf_hombre" required="required" 
                        maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                      <input type="number" class="form-control form-control-sm mujeres" id="inf_mujeres"  name="inf_mujeres" required="required" 
                       maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm glbti" id="inf_glbti"  name="inf_glbti" required="required"
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm montubios" id="inf_montubios"  name="inf_montubios" required="required" 
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                      <input type="number" class="form-control form-control-sm cholos" id="inf_cholos"  name="inf_cholos" required="required" 
                      maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm indegenas" id="inf_indigenas"  name="inf_indigenas" required="required" 
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                         <input type="number" class="form-control form-control-sm mestizo" id="inf_mestizos"  name="inf_mestizos" required="required" 
                         maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                       <input type="number" class="form-control form-control-sm afro" id="inf_afroecuatorianos"  name="inf_afroecuatorianos" 
                       maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
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

<div class="card-header text-white carHeaderBlue">
		<h5>DATOS DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS</h5>
	</div>
	<div class="card-body">
		<div class="row">
		   <div id="actualizar">
			<div class="col-md-12 order-md-1" >
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblDatosInforme" id="TblDatosInformeActualizar"
					data-rutaAplicacion="rendicion"
					data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">	
					
			<table class="table registros table-bordered">
               
                <tr>
                    <th colspan="7" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                            FECHA EN QUE SE REALIZÓ LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS:
                    </th>
                    <td colspan="3">
                       <div class="input-group date">
										<span class="input-group-addon"><i
											class="fa fa-calendar"></i> </span> <input type="text"
											required="required" id="inf_fecharc"
											name="inf_fecharc"
											class="form-control form-control-sm" value="" maxlength="10"
											pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
										<div class="invalid-feedback">Por favor ingrese la fecha
											de deliberación</div>
									</div>
                    </td>
                </tr>
                <tr>
                    <th rowspan="3" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                       
                            PARTICIPANTES EN EL EVENTO DE RENDICIÓN DE CUENTAS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        NO. DE PARTICIPANTES
                    </th>
                    <th scope="col" class="tablaingreso" colspan="3" style="text-align: center; font-size:x-small;">
                       GÉNERO
                    </th>
                    <th scope="col" class="tablaingreso" colspan="5" style="text-align: center; font-size:x-small;">
                       PUEBLOS Y NACIONALIDADES
                    </th>
                </tr>
                <tr>
                    <td scope="row" rowspan="2">
                      <input type="number" class="form-control form-control-sm usuarios" id="inf_usuarios"  name="inf_usuarios" required="required" 
                      maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MASCULINO
                        
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        FEMENINO
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%" >
                        GLBTI
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MONTUBIOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        CHOLOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        INDIGENAS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        MESTIZOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" width="10%">
                        AFROECUATORIANOS
                    </th>
                </tr>
                <tr align="center">
                    <td scope="row">
                        <input type="number" class="form-control form-control-sm hombres" id="inf_hombre"  name="inf_hombre" required="required" 
                        maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                      <input type="number" class="form-control form-control-sm mujeres" id="inf_mujeres"  name="inf_mujeres" required="required" 
                      maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm glbti" id="inf_glbti"  name="inf_glbti" required="required"
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm montubios" id="inf_montubios"  name="inf_montubios" required="required" 
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                      <input type="number" class="form-control form-control-sm cholos" id="inf_cholos"  name="inf_cholos" required="required" 
                      maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                          <input type="number" class="form-control form-control-sm indegenas" id="inf_indigenas"  name="inf_indigenas" required="required" 
                          maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                         <input type="number" class="form-control form-control-sm mestizo" id="inf_mestizos"  name="inf_mestizos" required="required" 
                         maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                       <input type="number" class="form-control form-control-sm afro" id="inf_afroecuatorianos"  name="inf_afroecuatorianos" 
                       maxlength="10" min="0" onpaste="return false" onkeypress="mascaraEnteros(this)"/>
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                </tr>
            </table>
			</form:form>
			</div>
		
			<div class="col-md-12 text-center">
				<button type="submit" id="btnActualizarPlan"
					class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
			</div>
			<input type="hidden" id="id_datos" name="id_datos">
	   </div>
	   
	 <div id="tabla" class="col-md-12 order-md-1">
					<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
						<th width="20%" style="text-align: center; font-size:x-small;">FECHA EN QUE SE REALIZÓ LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">NO. DE PARTICIPANTES </th>
						<th width="30%" style="text-align: center; font-size:x-small;">GÉNERO</th>
						<th width="40%" style="text-align: center; font-size:x-small;">PUEBLOS Y NACIONALIDADES</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	      <hr/>
		</div>
	</div>
	</div>
	
			
		</c:when>
<c:when test="${infestado=='finalizado'}">

<div class="card-header text-white carHeaderBlue">
		<h5>DATOS DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
			<input type="hidden" id="infCod" name="infCod" value="${infCod}">
				<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th >#</th>
						<th width="20%" style="text-align: center; font-size:x-small;">FECHA EN QUE SE REALIZÓ LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DE RENDICIÓN DE CUENTAS</th>
						<th width="10%" style="text-align: center; font-size:x-small;">NO. DE PARTICIPANTES </th>
						<th width="30%" style="text-align: center; font-size:x-small;">GÉNERO</th>
						<th width="40%" style="text-align: center; font-size:x-small;">PUEBLOS Y NACIONALIDADES</th>
						<th></th>
						<th  ></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
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

$(document).ready(
		function() {
			
			 $("#actualizar").hide();
			if ('${infestado}' == 'matriz'||'${infestado}' == 'finalizado') {
				tabla();			
			}

			var f = new Date();
			var dia1 = "01";
			var dia30 = "30";
			var mes1 = "01"; 
			var dia31 ="31";
			var mes12 ="12";
			var anio = f.getFullYear()-1;
			var anioRC = f.getFullYear()-4;
			var anioFin = f.getFullYear();
			var fechaInicio=(dia1 + "/" + mes1 + "/" + anio);
			var fechaFin=(dia31 + "/" + mes12 + "/" + anio);
			var fechaHoy=(f.getDate() + "/" + (f.getMonth()+1) + "/" + f.getFullYear())
			var fechaInicioAutoridad=(dia1 + "/" + mes1 + "/" + anioFin);
			var fechaFinAutoridad=(dia31 + "/" + mes12 + "/" + anioFin);
			var fechaInicioRC=(dia1 + "/" + mes1 + "/" + anioRC);


			$('#inf_fecharc').datepicker({
				  forceParse: true,
				  todayBtn: false
			}).datepicker('setStartDate', fechaInicioAutoridad);
				
			$('#inf_fecharc').datepicker({

			}).datepicker('setEndDate', fechaHoy);
				
			$('#inf_fecharc').datepicker({

			}).datepicker('update', fechaHoy);
			$('#inf_fecharc').datepicker({

			}).datepicker('update','');
           			
});
	
$(".hombres").change(function() {
	validargenero();
	});
$(".mujeres").change(function() {
	validargenero();
	});
$(".glbti").change(function() {
	validargenero();
	});
$(".montubios").change(function() {
	validarpueblos();
	});
$(".cholos").change(function() {
	validarpueblos();
	});
$(".indegenas").change(function() {
	validarpueblos();
	});
$(".mestizo").change(function() {
	validarpueblos();
	});
$(".afro").change(function() {
	validarpueblos();
	});
function validargenero() {
	var  h = ($(".hombres").val()===""?0:parseInt($(".hombres").val())) ;
	var m = ($(".mujeres").val()===""?0:parseInt($(".mujeres").val())) ;
	var  gl = ($(".glbti").val()===""?0:parseInt($(".glbti").val())) ; 
	var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
	var total = h+m+gl;
	
	 if(total>usuario)
	 {
		 mostrarMensaje("No se puede exeder el Número de Usuarios Género!", "ERROR");
			$("#btnGuardar").attr("disabled", true);
			$("#btnActualizarPlan").attr("disabled", true);
			
	 }else{
		 $("#btnGuardar").attr("disabled", false);
			$("#btnActualizarPlan").attr("disabled", false);
	 }
}

function validarpueblos() {
	var  mo = ($(".montubios").val()===""?0:parseInt($(".montubios").val())) ;
	var cho = ($(".cholos").val()===""?0:parseInt($(".cholos").val())) ;
	var  ind = ($(".indegenas").val()===""?0:parseInt($(".indegenas").val())) ; 
	var  mes = ($(".mestizo").val()===""?0:parseInt($(".mestizo").val())) ; 
	var  afro = ($(".afro").val()===""?0:parseInt($(".afro").val())) ; 
	var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
	var total = mo+cho+ind+mes+afro;
	
	 if(total>usuario)
	 {
		 mostrarMensaje("No se puede exeder el Número de Usuarios Registrados Nacionalidades O Pueblos!", "ERROR");
			$("#btnGuardar").attr("disabled", true);
			$("#btnActualizarPlan").attr("disabled", true);
			
	 }else{
		 $("#btnGuardar").attr("disabled", false);
			$("#btnActualizarPlan").attr("disabled", false);
	 }
}
function  validarpueblosuma() {
	var  mo = ($(".montubios").val()===""?0:parseInt($(".montubios").val())) ;
	var cho = ($(".cholos").val()===""?0:parseInt($(".cholos").val())) ;
	var  ind = ($(".indegenas").val()===""?0:parseInt($(".indegenas").val())) ; 
	var  mes = ($(".mestizo").val()===""?0:parseInt($(".mestizo").val())) ; 
	var  afro = ($(".afro").val()===""?0:parseInt($(".afro").val())) ; 
	var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
	var total = mo+cho+ind+mes+afro;
	var numero;
	 if(total>usuario)
	 {
		 numero=1;
			
	 }else{
		 numero=0;
	 }
	return  numero
}
function validargenerosuma() {
	var  h = ($(".hombres").val()===""?0:parseInt($(".hombres").val())) ;
	var m = ($(".mujeres").val()===""?0:parseInt($(".mujeres").val())) ;
	var  gl = ($(".glbti").val()===""?0:parseInt($(".glbti").val())) ; 
	var  usuario = ($(".usuarios").val()===""?0:parseInt($(".usuarios").val())) ; 
	var total = h+m+gl;
	var numero;
	 if(total>usuario)
	 {
		 numero=1;
			
	 }else{
		 numero=0;
	 }
	return  numero

}

$("#btnGuardar").click(
				function(event) {
					var form = $("#TblDatosInforme");
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						var genero= parseInt(validargenerosuma());
						var nacionalidad =parseInt(validarpueblosuma());
					if(genero==1||nacionalidad==1){
						 mostrarMensaje("No se puede exeder el Número de Usuarios Registrados Nacionalidades O Pueblos!", "ERROR");
					}else{
						ejecutarJson(form);
					}
						
					}
					form.addClass('was-validated');

});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosDatosInforme",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
		paging:   false,
		info:     false,
		searching: false,
		 bDestroy : true,
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
			{data : "contador" },
			{data : "fecha"},
			{data : "usuarios"},
			{data : "","render": function (data, type, full, meta) {
				 data ='<table class="table registros table-bordered"> <tr> <th style="font-size: 5px;" class="tablainterna" width="5%">MASCULINO</th><th style="font-size: 7px;" class="tablainterna" width="5%">FEMENINO</th><th style="font-size: 7px;" class="tablainterna" width="5%">GLBTI</th> </tr><tr><td>'+full.hombre+ '</td><td>'+full.mujer+ '</td><td>'+full.glbti+ '</td> </tr></table>'
				   return data;
		    }},
			{data : "","render": function (data, type, full, meta) {
				 data ='<table class="table registros table-bordered"> <tr> <th style="font-size: 5px;" class="tablainterna" width="5%">MONTUBIOS</th><th style="font-size: 7px;" class="tablainterna" width="5%">CHOLOS</th><th style="font-size: 7px;" class="tablainterna" width="5%">INDIGENAS</th><th style="font-size: 7px;" class="tablainterna" width="5%">MESTIZOS</th><th style="font-size: 7px;" class="tablainterna" width="5%">AFROECUATORIANOS</th> </tr><tr><td>'+full.montubios+ '</td><td>'+full.cholos+ '</td><td>'+full.indigenas+ '</td> <td>'+full.mestizos+ '</td><td>'+full.afroecuatorianos+ '</td></tr></table>'
				   return data;
		    }},
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestado}' === "finalizado"){
	            	 data = '';     
	             }else{
	                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor  btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             }return data;
	    }},
	    { data: "" ,"render": function (data, type, full, meta) {
	    	 if('${infestado}' === "finalizado"){
            	 data = '';     
             }else{
	                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor  btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
             } return data;
	    }} ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.idDatos);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	       $(row).find("td").css({
				"font-size"   : "x-small",			
			});	

			$(row).find("td").css({
				"vertical-align" : "middle",
			});

           },
	    } );

	$(row).find("td").css({
		"font-size"   : "x-small",			
	});	

	$(row).find("td").css({
		"vertical-align" : "middle",
	});	



}



function Eliminar(element) {	
	var codigo = $(element).closest('tr').attr('id');	
	 $.ajax({
	        url: 'view/rendicion/eliminarDatos',
	        headers: {"X-CSRF-TOKEN": csrfToken},
	        type: "POST",
	        dataType: 'json',
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_datos_informe',campo:'id_datos'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#tablaRegistros tr").length-1;
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
function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	var fecha = $(element).parent().parent().find("td:eq(1)").text();
	var usuarios = $(element).parent().parent().find("td:eq(2)").text();
	var hombres = $(element).parent().parent().find("td:eq(4)").text();
	var mujeres = $(element).parent().parent().find("td:eq(5)").text();
	var glbti = $(element).parent().parent().find("td:eq(6)").text();
	var montubios = $(element).parent().parent().find("td:eq(8)").text();
	var cholos = $(element).parent().parent().find("td:eq(9)").text();
	var indigenas = $(element).parent().parent().find("td:eq(10)").text();
	var mestizos = $(element).parent().parent().find("td:eq(11)").text();
	var afros = $(element).parent().parent().find("td:eq(12)").text();
	  $("#actualizar").show();
	  $("#tabla").hide();	  
	  $("#id_datos").val(codigo);
	  $("#inf_fecharc").val(fecha);
	  $("#inf_usuarios").val(usuarios);
	  $("#inf_hombre").val(hombres);
	  $("#inf_mujeres").val(mujeres);
	  $("#inf_glbti").val(glbti);
	  $("#inf_montubios").val(montubios);
	  $("#inf_cholos").val(cholos);
	  $("#inf_indigenas").val(indigenas);
	  $("#inf_mestizos").val(mestizos);
	  $("#inf_afroecuatorianos").val(afros);
	  
	  
}
$("#btnActualizarPlan").click(
		function(event) {
			var form = $("#TblDatosInformeActualizar")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
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
				  var data = {tabla: 'esq_rendicioncuentas.tbl_datos_informe',columns:columnas,values:valores,condicion:'id_datos',valorcondicion:$("#id_datos").val()};
				  
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	
 
				
</script>
