<%-- 
	version		: 1.0
    Document  	: Frm_RendicionCuentasGadFasesActl
    Created on	: 25/02/2021; 16:17:21
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

<div class="card mb-card20">


			<div class="card card-secondary">		
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblMecanismoRendicionCuentas"
						id="RendicionCuentasFaseActul" data-rutaAplicacion="rendicion"
						data-opcion="ActualizarDatos" data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">RENDICIÓN DE CUENTAS</h5>
					<input type="hidden" id="mecanismo_cod" name="mecanismo_cod" value="${mecanismo_cod}">
					<div class="col-md-12 text-left">

						<table id="tablaActul" class="table registros table-bordered ">
							<tr>
							<td class="tablaingreso">FASES</td>
								<td class="tablaingreso">PROCESO DE RENDICIÓN DE CUENTAS</td>
								<td class="tablaingreso">PONGA SI O NO</td>
								<td class="tablaingreso">DESCRIBA LA EJECUCIÓN DE LOS PASOS</td>
								<td class="tablaingreso">LINK AL MEDIO DE VERIFICACIÓN</td>
								<td class="tablaingreso">OBSERVACIONES</td>
							</tr>
							<tr>
							 <td style="vertical-align: middle; width: 50px;" >
							 <label for="fase1" >${mecanismo_fase}</label>
								    <input type="hidden" id="mecanismo_fase" name="mecanismo_fase" value="${mecanismo_fase}">
							 </td>
								<td style="vertical-align: middle; width: 200px;">
								<label for="lbl1" >${mecanismo_nombre}</label>
								    <input type="hidden" id="mecanismo_nombre" name="mecanismo_nombre" value="${mecanismo_nombre}">
								</td>
								<td style="vertical-align: middle; width: 120px;">
								<select
									class="custom-select custom-select-sm" id="mecanismo_implementado"
									name="mecanismo_implementado" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select>
								<div class="invalid-feedback">Seleccione una opción</div>
								 </td>
						<c:choose>
							<c:when
								test="${mecanismo_nombre=='1. LA CIUDADANÍA / ASAMBLEA LOCAL CIUDADANA PRESENTÓ LA LISTA DE TEMAS SOBRE LOS QUE DESEA SER INFORMADA'}">

								<td style="vertical-align: middle; width: 200px;">
								<select
									class="custom-select custom-select-sm descripcion1"
									id="mecanismo_ejecucion" name="mecanismo_ejecucion">
										<option value="">Seleccione...</option>
										<option value="ASAMBLEA CIUDADANA">ASAMBLEA CIUDADANA</option>
										<option
											value="CIUDADANOS DEL CONSEJO DE PLANIFICACIÓN Y/O CIUDADANOS DE LA INSTANCIA DE PARTICIPACIÓN O LOS CIUDADANOS DESDE LA CONVOCATORIA DIRECTA DEL GAD">CIUDADANOS
											DEL CONSEJO DE PLANIFICACIÓN Y/O CIUDADANOS DE LA INSTANCIA
											DE PARTICIPACIÓN O LOS CIUDADANOS DESDE LA CONVOCATORIA
											DIRECTA DEL GAD</option>
								</select>
									<div class="invalid-feedback">Seleccione una opción</div>
									</td>

							</c:when>
							<c:when test="${mecanismo_nombre=='5. LA ENTIDAD ENVIÓ EL INFORME DE RENDICIÓN DE CUENTAS INSTITUCIONAL A LA INSTANCIA DE PARTICIPACIÓN Y A LA ASAMBLEA CIUDADANA'}">
							 <td style="vertical-align: middle; width: 200px;">
								 <select
									class="custom-select custom-select-sm descripcion1"
									id="mecanismo_ejecucion" name="mecanismo_ejecucion">
										<option value="">Seleccione...</option>
										<option value="1 DÍA">1 DÍA</option>
										<option value="2 DÍAS">4 DÍAS</option>
										<option value="3 DÍAS">3 DÍAS</option>
										<option value="4 DÍAS">4 DÍAS</option>
										<option value="5 DÍAS">5 DÍAS</option>
										<option value="6 DÍAS">6 DÍAS</option>
										<option value="7 DÍAS">7 DÍAS</option>
										<option value="8 DÍAS">8 DÍAS</option>
										<option value="MÁS DÍAS">MÁS DÍAS</option>
								</select>
									<div class="invalid-feedback">Seleccione una opción</div></td>
							</c:when>
							<c:when test="${mecanismo_nombre=='1. LA ENTIDAD DIFUNDIÓ EL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE QUÉ MEDIOS'}">
								 <td style="vertical-align: middle; width: 200px;">
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle; width: 100px;"><label
												for="uno"><input type="checkbox" class="case 1"
													 id="checks[]" value="PAG WEB"> PAG WEB</label></td>
											<td style="vertical-align: middle; width: 100px;"><label
												for="dos"><input type="checkbox" class="case 2"
													 id="checks[]" value="REDES SOCIALES">
													REDES SOCIALES</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; width: 100px;"><label
												for="tres"><input type="checkbox" class="case 3"
													 id="checks[]" value="RADIO"> RADIO</label></td>
											<td style="vertical-align: middle; width: 100px;"><label
												for="cuatro"><input type="checkbox" class="case 4"
													 id="checks[]" value="CARTELERAS">
													CARTELERAS</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; width: 100px;"><label
												for="cinco"><input type="checkbox" class="case 5"
													 id="checks[]" value="PRENSA"> PRENSA</label></td>
											<td style="vertical-align: middle; width: 100px;"><label
												for="seis"><input type="checkbox" class="case 6"
													 id="checks[]" value="IMPRESOS">
													IMPRESOS</label></td>
										</tr>
										<tr>
											<td style="vertical-align: middle; width: 100px;"><label
												for="siete"><input type="checkbox" class="case 7"
													 id="checks[]" value="TV"> TV</label></td>
											<td style="vertical-align: middle; width: 100px;"><label
												for="ocho"><input type="checkbox" class="case 8"
													 id="checks[]" value="OTROS">
													OTROS</label></td>
										</tr>

									</table>
									<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										<input type="hidden"  class="form-control form-control-sm descripcion1"
										id="mecanismo_ejecucion" name="mecanismo_ejecucion" required="required" value="${mecanismo_ejecucion}">

								</td>
							
							
							</c:when>
							<c:when test="${mecanismo_nombre=='4. LA ASAMBLEA CIUDADANA / CIUDADANÍA CONTÓ CON UN TIEMPO DE EXPOSICIÓN EN LA AGENDA DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS DE LA ENTIDAD'}">
								 <td style="vertical-align: middle; width: 200px;">
								 <select
									class="custom-select custom-select-sm descripcion1"
									id="mecanismo_ejecucion" name="mecanismo_ejecucion">
										<option value="">Seleccione...</option>
										<option value="0-30 min">0-30 min</option>
										<option value="31 min - 1 hora">31 min - 1 hora</option>
										<option value="1 hora - 2 horas">1 hora - 2 horas</option>
										<option value="Mas de 2 horas">Mas de 2 horas</option>
								</select>
									<div class="invalid-feedback">Seleccione una opción</div></td>
							</c:when>
							
							<c:when test="${mecanismo_nombre=='2. LA ENTIDAD ENTREGÓ EL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA, AL CONSEJO DE PLANIFICACIÓN Y A LA INSTANCIA DE PARTICIPACIÓN PARA SU MONITOREO'}">
							  <td align="center" style="vertical-align: middle; ">
								<table class="tablacheckbox">
										<tr>
											<td style="vertical-align: middle;"><label
												for="uno"><input type="checkbox" class="case 9"
													 id="checks[]" value="LA ASAMBLEA CIUDADANA"> LA ASAMBLEA CIUDADANA</label></td>											
										</tr>
										<tr>
										<td style="vertical-align: middle;"><label
												for="dos"><input type="checkbox" class="case 10"
													 id="checks[]" value="CONSEJO DE PLANIFICACIÓN">
													CONSEJO DE PLANIFICACIÓN</label></td>
										</tr>
										<tr>														
											<td style="vertical-align: middle;"><label
												for="tres"><input type="checkbox" class="case 11"
													 id="checks[]" value="INSTANCIA DE PARTICIPACIÓN"> INSTANCIA DE PARTICIPACIÓN</label></td>
										</tr>
										</table>
									
								    <input type="hidden" class="form-control form-control-sm descripcion1" id="mecanismo_ejecucion" name="mecanismo_ejecucion" value="${mecanismo_ejecucion}"  >
									<div class="invalid-feedback">Seleccione un almenos un checkbox</div>

								</td>
							</c:when>
							
							<c:otherwise>

								<td style="vertical-align: middle; width: 200px;">
								<textarea rows="4" cols=""	class="form-control form-control-sm descripcion1"
										id="mecanismo_ejecucion" name="mecanismo_ejecucion" required="required">${mecanismo_ejecucion}</textarea>
									<div class="invalid-feedback">Por favor Ingrese la
										observación</div></td>
							</c:otherwise>

						</c:choose>


						<td style="vertical-align: middle;">
								<input type="url" class="form-control form-control-sm case1" id="mecanismo_medioverifica" name="mecanismo_medioverifica" value="${mecanismo_medioverifica}"
								 required="required" placeholder="Dirección de página web">							
							    <div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								 </td>	
								 <td style="vertical-align: middle;">
								<textarea rows="4" cols="" class="form-control form-control-sm observacion1" id="mecanismo_observacion" name="mecanismo_observacion" required="required" >${mecanismo_observacion}</textarea>
							    <div class="invalid-feedback">Por favor Ingrese el link</div>
								 </td>														
							</tr>
							
					
						
						</table>
					</div>
					<div class="col-md-12 text-center">
						<button type="button" id="btnGuardarRendicionCuentaActul"
							class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
					</div>
				</form:form>
			</div>
</div>
</html>

<script type="text/javascript">

		
$(document).ready(function() {
		
		cargarValorComboPorDefecto("mecanismo_implementado",'${mecanismo_implementados}');
		console.log('${mecanismo_implementados}');
		if('${mecanismo_implementados}'=='NO'){	
			var url;
			 url=document.getElementById("mecanismo_medioverifica");					
			$(".case1").prop("disabled", "disabled");
			$(".descripcion1").prop("disabled", "disabled");		
			$(".observacion1").prop("disabled", "disabled");	
			$(".case").prop("disabled", "disabled");
			url.type = "text";
			
		}		
	  
		  if('${mecanismo_nombre}'=='1. LA ENTIDAD DIFUNDIÓ EL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE QUÉ MEDIOS'){
			  var descripcion= $('#mecanismo_ejecucion').val();
				  var nombres = descripcion.split("<br>");                          
			  for (var i = 0; i < nombres.length; i++){
					 var supp = nombres[i];
					   switch (supp) {
					   case 'PAG WEB':
						   $(".1").attr('checked','checked')
							   break;
					   case 'REDES SOCIALES':
						   $(".2").attr('checked','checked')
						   break;
					   case 'RADIO':
						   $(".3").attr('checked','checked')
						   break;
					   case 'CARTELERAS':
						   $(".4").attr('checked','checked')
						   break;
					   case 'PRENSA':
						   $(".5").attr('checked','checked')
						   break;
					   case 'IMPRESOS':
						   $(".6").attr('checked','checked')
						   break;
					   case 'TV':
						   $(".7").attr('checked','checked')
						   break;
					   case 'OTROS':
						   $(".8").attr('checked','checked')
						   break;
						   
					   }
					   
				 }

			  }else if ('${mecanismo_nombre}'=='2. LA ENTIDAD ENTREGÓ EL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA, AL CONSEJO DE PLANIFICACIÓN Y A LA INSTANCIA DE PARTICIPACIÓN PARA SU MONITOREO'){
			         var descripcion= $('#mecanismo_ejecucion').val();
	                
					  var nombres = descripcion.split("<br>");
				  for (var i = 0; i < nombres.length; i++){
						 var supp = nombres[i];
						   switch (supp) {
						   case 'LA ASAMBLEA CIUDADANA':
							   $(".9").attr('checked','checked')
								   break;
						   case 'CONSEJO DE PLANIFICACIÓN':
							   $(".10").attr('checked','checked')
							   break;
						   case 'INSTANCIA DE PARTICIPACIÓN':
							   $(".11").attr('checked','checked')
							   break;						
						   }
						   
					 }
				 
		 }if ('${mecanismo_nombre}'=='1. LA CIUDADANÍA / ASAMBLEA LOCAL CIUDADANA PRESENTÓ LA LISTA DE TEMAS SOBRE LOS QUE DESEA SER INFORMADA'|| '${mecanismo_nombre}'=='5. LA ENTIDAD ENVIÓ EL INFORME DE RENDICIÓN DE CUENTAS INSTITUCIONAL A LA INSTANCIA DE PARTICIPACIÓN Y A LA ASAMBLEA CIUDADANA'||'${mecanismo_nombre}'=='4. LA ASAMBLEA CIUDADANA / CIUDADANÍA CONTÓ CON UN TIEMPO DE EXPOSICIÓN EN LA AGENDA DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS DE LA ENTIDAD'){
			 cargarValorComboPorDefecto("mecanismo_ejecucion",'${mecanismo_ejecucion}');
		 }else{
			 
		 }

		  $('[id="checks[]"]').click(function() {		      
			    var arr = $('[id="checks[]"]:checked').map(function(){
			      return this.value;
			    }).get();
			    var str = arr.join('<br>');	
			    $('#mecanismo_ejecucion').val(str); 
			  });
	
		 
	});



	$("#mecanismo_implementado").change(function() {
		var url;
		 url=document.getElementById("mecanismo_medioverifica");
		var seleccion = $("#mecanismo_implementado").val();
		if (seleccion == "SI") {
     		$(".descripcion1").val("");
			$(".descripcion1").removeAttr("disabled");
			$(".descripcion1").prop("required", true);				
						 
			$(".case1").val("http://");
			$(".case1").removeAttr("disabled");
			$(".case1").prop("required", true);
			$(".observacion1").val("");	
			$(".observacion1").removeAttr("disabled");
			$(".observacion1").prop("required", true);
			$(".case").removeAttr("disabled");
			url.type = "url";

		} else if (seleccion == "NO") {
			if('${mecanismo_nombre}'=='1. LA CIUDADANÍA / ASAMBLEA LOCAL CIUDADANA PRESENTÓ LA LISTA DE TEMAS SOBRE LOS QUE DESEA SER INFORMADA')
				{
				$(".descripcion1").val("");			  
				}else if('${mecanismo_nombre}'=='5. LA ENTIDAD ENVIÓ EL INFORME DE RENDICIÓN DE CUENTAS INSTITUCIONAL A LA INSTANCIA DE PARTICIPACIÓN Y A LA ASAMBLEA CIUDADANA'){
					$(".descripcion1").val("");		
					}
				else if('${mecanismo_nombre}'=='1. LA ENTIDAD DIFUNDIÓ EL INFORME DE RENDICIÓN DE CUENTAS A TRAVÉS DE QUÉ MEDIOS'){
					$(".case").prop("checked", false);
					$(".case").prop("disabled", "disabled");
					$(".case").removeAttr("required");
					$(".descripcion1").val("S/N");
					}
				else if('${mecanismo_nombre}'=='4. LA ASAMBLEA CIUDADANA / CIUDADANÍA CONTÓ CON UN TIEMPO DE EXPOSICIÓN EN LA AGENDA DE LA DELIBERACIÓN PÚBLICA Y EVALUACIÓN CIUDADANA DEL INFORME DE RENDICIÓN DE CUENTAS DE LA ENTIDAD'){
					$(".descripcion1").val("");	
					}
				else if('${mecanismo_nombre}'=='2. LA ENTIDAD ENTREGÓ EL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA, AL CONSEJO DE PLANIFICACIÓN Y A LA INSTANCIA DE PARTICIPACIÓN PARA SU MONITOREO'){
					$(".case").prop("checked", false);
					$(".case").prop("disabled", "disabled");
					$(".case").removeAttr("required");
					$(".descripcion1").val("S/N");
					}
				else{
					$(".descripcion1").val("S/N");
				   
			      }		
			  $(".descripcion1").prop("disabled", "disabled");
			    $(".descripcion1").removeAttr("required");
			$(".case1").val("NO APLICA");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");
			$(".observacion1").val("S/N"); 
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			url.type = "text";

		} else {			
			$(".descripcion1").val("");
			$(".descripcion1").prop("disabled", "disabled");
		    $(".descripcion1").removeAttr("required");				
			$(".observacion1").val(""); 
			$(".case1").val("");
			$(".case1").prop("disabled", "disabled");
			$(".case1").removeAttr("required");			
			$(".observacion1").prop("disabled", "disabled");
			$(".observacion1").removeAttr("required");
			$(".case").prop("checked", false);
			$(".case").prop("disabled", "disabled");
			$(".case").removeAttr("required");
			url.type = "url";
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});


    	
	
	$("#btnGuardarRendicionCuentaActul").click(function(event) {
		var form = $("#RendicionCuentasFaseActul")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			  $(".case1").removeAttr("disabled");
			  $(".descripcion1").removeAttr("disabled");
			  $(".observacion1").removeAttr("disabled");
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
			  var data = {tabla: 'esq_rendicioncuentas.tbl_mecanismo_rendicion_cuentas',columns:columnas,values:valores,condicion:'mecanismo_cod',valorcondicion:$("#mecanismo_cod").val()};
			
			  ejecutarJsonUpdate(form,data);
		}
		form.addClass('was-validated');


	});



	
</script>