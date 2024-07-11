<%-- 
	version		: 1.0
    Document  	: Frm_EjecutivoCoberturaGeograficaAgregarNew
    Created on	: 19 mar. 2021; 11:56:08
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>

<div class="card text-center mb-card20" style="width:height:auto; height:auto; overflow: scroll;">


			<div class="card-header text-white carHeaderBlue" style="width:100%;">
				<h5>COBERTURA GEOGRÁFICA: UNIDADES DE ATENCIÓN O GESTIÓN QUE INTEGRA</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblCoberturaCeografica" id="CoberturaGeograficaNew"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarCoberturaGeografica"
							data-accionEnExito="ACTUALIZAR">	
							<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">					
	          <table class="table registros table-bordered">              
            
                <tr>
                    <th rowspan="1" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;  width: 30%;">
                      NIVEL DE UNIDADES DE ATENCIÓN 
                    </th>
                     <th rowspan="1" scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;  width: 10%;">
                      NO. DE UNIDADES DE ATENCIÓN
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;  width: 20%;">
                     COBERTURA
                    </th>                    

                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small; width: 10%;">
                      N. USUARIOS
                    </th>
                    <th scope="col" class="tablaingreso" colspan="3" style="text-align: center; font-size:x-small; width: 5%;">
                       GÉNERO
                    </th>
                    <th scope="col" class="tablaingreso" colspan="5" style="text-align: center; font-size:x-small; width: 5%;">
                       PUEBLOS Y NACIONALIDADES
                    </th>
                     <th scope="col" class="tablaingreso" colspan="5" style="text-align: center; font-size:x-small; width: 20%;">
                       LINK AL MEDIO DE VERIFICACIÓN
                    </th>
                </tr>
                <tr>                 
                  <td scope="row" rowspan="2" style="vertical-align: middle;">
                                   <select
										class="custom-select custom-select-sm" id="cgTipocobertura"
										name="cgTipocobertura" required="required">
											<option value="">Seleccione...</option>
											<option value="NACIONAL">NACIONAL</option>
											<option value="ZONA">ZONA</option>
											<option value="REGIÓN">REGIÓN</option>
											<option value="PROVINCIA">PROVINCIA</option>
											<option value="DISTRITO">DISTRITO</option>
											<option value="CIRCUITO">CIRCUITO</option>
											<option value="CANTÓN">CANTÓN</option>
											<option value="PARROQUIA">PARROQUIA</option>
											<option value="COMUNIDAD O RECINTO">COMUNIDAD O RECINTO</option>
									</select>
						<div class="invalid-feedback">Por Seleccione una opción</div>
                    </td>
                    <td scope="row" rowspan="2" style="vertical-align: middle;">
                    <input type="text" class="form-control form-control-sm" id="cgCantidad" name="cgCantidad" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
					<div class="invalid-feedback">Por favor ingrese No. de unidades de atención</div>
                    </td>
                     <td scope="row" rowspan="2" style="vertical-align: middle;">
                     <textarea rows="3" cols="" class="form-control form-control-sm" id="cgDescCobertura" name="cgDescCobertura" required="required" ></textarea>
							    <div class="invalid-feedback">Por favor Ingrese la observación</div>
                    </td>
                    <td scope="row" rowspan="2" style="vertical-align: middle;">
                      <input type="text" class="form-control form-control-sm usuarios1" id="cgTotal" name="cgTotal" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
					<div class="invalid-feedback">Por favor ingrese No. de usuario</div>
                    </td>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" >
                        MASCULINO
                        
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;" >
                        FEMENINO
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        GLBTI
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        MONTUBIOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        CHOLOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        INDIGENAS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        MESTIZOS
                    </th>
                    <th scope="col" class="tablaingreso" style="text-align: center; font-size:x-small;">
                        AFROECUATORIANOS
                    </th>
                     <td scope="row" rowspan="2" style="vertical-align: middle; width: 20%;">
                     <input type="url" class="form-control form-control-sm case2" id="cgLink" name="cgLink" 
								 required="required" placeholder="Dirección de página web" value="https://">							
				  <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato https:// o http://dirreccionDePaginaWeb</div>
                    </td>
                </tr>
                <tr align="center">
                  
                    <td scope="row">
                         <input type="text" class="form-control form-control-sm hombres1" id="cgHombres" name="cgHombres" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                         <input type="text" class="form-control form-control-sm mujeres1" id="cgMujeres" name="cgMujeres" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                           <input type="text" class="form-control form-control-sm glbti1" id="cgGlbti" name="cgGlbti" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                         <input type="text" class="form-control form-control-sm montubios1" id=cgMontubios name="cgMontubios" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                       <td scope="row">
                       <input type="text" class="form-control form-control-sm cholos1" id="cgCholos" name="cgCholos" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                         <input type="text" class="form-control form-control-sm indegenas1" id="cgIndigenas" name="cgIndigenas" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                    <td scope="row">
                      <input type="text" class="form-control form-control-sm mestizo1" id="cgMestizos" name="cgMestizos" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                 
                    <td scope="row">
                       <input type="text" class="form-control form-control-sm afro1" id="cgAfroecuatoriano" name="cgAfroecuatoriano" placeholder="000" maxlength="20" onkeypress="javascript:return validarnro(event);"
							required="required" min="0">
						<div class="invalid-feedback">Por Ingrese número Participantes</div>
                    </td>
                </tr>
            </table>
						
						</form:form>
					</div>
				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardarGrograficaNew1"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>
		

</div>
</html>

<script type="text/javascript">

$(document).ready(	function() {

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
			
$("#btnGuardarGrograficaNew1").click(function(event) {
				
	var form = $("#CoberturaGeograficaNew")
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
	mostrarMensaje(
	"Por favor ingrese toda la información solicitada!",
	"ERROR");
	} else {
		 if(validargenero1()==true && validarpueblos1()==true){
			 ejecutarJson(form);
			 }
			}
	form.addClass('was-validated');

});


$(".hombres1").change(function(){
	validargenero1();
	});
$(".mujeres1").change(function() {
	validargenero1();
	});
$(".glbti1").change(function() {
	validargenero1();
	});
$(".montubios1").change(function() {
	validarpueblos1();
	});
$(".cholos1").change(function() {
	validarpueblos1();
	});
$(".indegenas1").change(function() {
	validarpueblos1();
	});
$(".mestizo1").change(function() {
	validarpueblos1();
	});
$(".afro1").change(function() {
	validarpueblos1();
	});
function validargenero1() {
	var valida;
	var  h = ($(".hombres1").val()===""?0:parseInt($(".hombres1").val())) ;
	var m = ($(".mujeres1").val()===""?0:parseInt($(".mujeres1").val())) ;
	var  gl = ($(".glbti1").val()===""?0:parseInt($(".glbti1").val())) ; 
	var  usuario = ($(".usuarios1").val()===""?0:parseInt($(".usuarios1").val())) ; 
	var total = h+m+gl;
	 if(total>usuario)
	 {
		 mostrarMensaje("No se puede exeder el Número de Usuarios Género!", "ERROR");
			$("#btnGuardarGrograficaNew1").attr("disabled", true);	

			valida=false;
			
	 }else{
		 $("#btnGuardarGrograficaNew1").attr("disabled", false);
			valida=true;
	 }
	 return valida;
}

function validarpueblos1() {
	var valida;
	var  mo = ($(".montubios1").val()===""?0:parseInt($(".montubios1").val())) ;
	var cho = ($(".cholos1").val()===""?0:parseInt($(".cholos1").val())) ;
	var  ind = ($(".indegenas1").val()===""?0:parseInt($(".indegenas1").val())) ; 
	var  mes = ($(".mestizo1").val()===""?0:parseInt($(".mestizo1").val())) ; 
	var  afro = ($(".afro1").val()===""?0:parseInt($(".afro1").val())) ; 
	var  usuario = ($(".usuarios1").val()===""?0:parseInt($(".usuarios1").val())) ; 
	var total = mo+cho+ind+mes+afro;
	
	 if(total>usuario)
	 {
		 mostrarMensaje("No se puede exeder el Número de Usuarios Registrados Nacionalidades O Pueblos!", "ERROR");
		 $("#btnGuardarGrograficaNew1").attr("disabled", true);			
			valida=false;	
	 }else{
		 $("#btnGuardarGrograficaNew1").attr("disabled", false);		
			valida=true;	
	 }		 
	 return valida;
}
	
				
</script>
