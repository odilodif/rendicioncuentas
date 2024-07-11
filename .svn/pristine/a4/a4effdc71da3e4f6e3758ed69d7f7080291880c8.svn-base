<%-- 
	version		: 1.0
    Document  	: Frm_GAD_PlandeDesarrollo
    Created on	: 17/02/2021; 15:57:14
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

<div class="card text-center mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblObjetivosPlanDesarrollo"
					id="ObjetivosPlan" data-rutaAplicacion="rendicion"
					data-opcion="guardarObjetivosPlan"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue">OBJETIVOS DEL PLAN DE DESARROLLO DE SU TERRITORIO</h5>
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					<div class="col-md-12 text-left">

						<table class="table registros table-bordered ">
							<tr>
								<td class="tablaingreso" align="center">ESCOJA LOS OBJETIVOS DEL PLAN DE DESARROLLO 2017 - 2021 DE SU TERRITORIO</td>
							</tr>
							<tr>
								<td><label for="uno"><input type="checkbox"
										class="case" id="cbox1" name="cbox1"
										value="OBJETIVO 1: GARANTIZAR UNA VIDA DIGNA CON IGUALES OPORTUNIDADES PARA TODAS LAS PERSONAS"> <strong>OBJETIVO 1:</strong> GARANTIZAR UNA VIDA DIGNA CON IGUALES OPORTUNIDADES PARA TODAS LAS PERSONAS</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="dos"><input type="checkbox"
										class="case" id="cbox2" name="cbox2"
										value="OBJETIVO  2:  AFIRMAR LA INTERCULTURALIDAD Y PLURINACIONALIDAD, REVALORIZANDO LAS IDENTIDADES DIVERSAS"> <strong>OBJETIVO 2:</strong>  AFIRMAR LA INTERCULTURALIDAD Y PLURINACIONALIDAD, REVALORIZANDO LAS IDENTIDADES DIVERSAS</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="tres"><input type="checkbox"
										class="case" id="cbox3" name="cbox3" value="OBJETIVO 3: GARANTIZAR LOS DERECHOS DE LA NATURALEZA PARA LAS ACTUALES Y FUTURAS GENERACIONES">
										<strong>OBJETIVO 3:</strong> GARANTIZAR LOS DERECHOS DE LA NATURALEZA PARA LAS ACTUALES Y FUTURAS GENERACIONES</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="cuatro"><input type="checkbox"
										class="case" id="cbox4" name="cbox4"
										value="OBJETIVO 4: CONSOLIDAR LA SOSTENIBILIDAD DEL SISTEMA ECONÓMICO SOCIAL Y SOLIDARIO, Y AFIANZAR LA DOLARIZACIÓN"> <strong>OBJETIVO 4:</strong> CONSOLIDAR LA SOSTENIBILIDAD DEL SISTEMA ECONÓMICO SOCIAL Y SOLIDARIO, Y AFIANZAR LA DOLARIZACIÓN</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="cinco"><input type="checkbox"
										class="case" id="cbox5" name="cbox5"
										value="OBJETIVO 5:  IMPULSAR LA PRODUCTIVIDAD Y COMPETITIVIDAD PARA EL CRECIMIENTO ECONÓMICO SUSTENTABLE DE MANERA REDISTRIBUTIVA Y SOLIDARIA"> <strong>OBJETIVO 5:</strong>  IMPULSAR LA PRODUCTIVIDAD Y COMPETITIVIDAD PARA EL CRECIMIENTO ECONÓMICO SUSTENTABLE DE MANERA REDISTRIBUTIVA Y SOLIDARIA</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="seis"><input type="checkbox"
										class="case" id="cbox6" name="cbox6" value="OBJETIVO 6: DESARROLLAR LAS CAPACIDADES PRODUCTIVAS Y DEL ENTORNO PARA LOGRAR LA SOBERANÍA ALIMENTARIA Y EL DESARROLLO RURAL INTEGRAL">
										<strong>OBJETIVO 6:</strong> DESARROLLAR LAS CAPACIDADES PRODUCTIVAS Y DEL ENTORNO PARA LOGRAR LA SOBERANÍA ALIMENTARIA Y EL DESARROLLO RURAL INTEGRAL</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="siete"><input type="checkbox"
										class="case" id="cbox7" name="cbox7"
										value="OBJETIVO 7: INCENTIVAR UNA SOCIEDAD PARTICIPATIVA, CON UN ESTADO CERCANO AL SERVICIO DE LA CIUDADANÍA"> <strong>OBJETIVO 7:</strong> INCENTIVAR UNA SOCIEDAD PARTICIPATIVA, CON UN ESTADO CERCANO AL SERVICIO DE LA CIUDADANÍA</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="ocho"><input type="checkbox"
										class="case" id="cbox8" name="cbox8"
										value="OBJETIVO 8: PROMOVER LA TRANSPARENCIA Y LA CORRESPONSABILIDAD PARA UNA NUEVA ÉTICA SOCIAL">
										<strong>OBJETIVO 8:</strong> PROMOVER LA TRANSPARENCIA Y LA CORRESPONSABILIDAD PARA UNA NUEVA ÉTICA SOCIAL</label>
									<div class="invalid-feedback">Marque el check</div></td>
							</tr>
							<tr>
								<td><label for="nueve"><input type="checkbox"
										class="case" id="cbox9" name="cbox9"
										value="OBJETIVO 9:  GARANTIZAR LA SOBERANÍA Y LA PAZ, Y POSICIONAR ESTRATÉGICAMENTE AL PAÍS EN LA REGIÓN Y EL MUNDO"> <strong>OBJETIVO 9:</strong>  GARANTIZAR LA SOBERANÍA Y LA PAZ, Y POSICIONAR ESTRATÉGICAMENTE AL PAÍS EN LA REGIÓN Y EL MUNDO</label>
									<div class="invalid-feedback">Marque el check</div></td>
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
			<table id="TablaObjetivosPlan"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th>OBJETIVOS DEL PLAN DE DESARROLLO DE SU TERRITORIO</th>
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
	$(document).ready(function() {
		
		if ('${inf_estado}' == 'matriz') {
			tabla();			
		}

	});

	

	$("#btnGuardarI").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#ObjetivosPlan")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
				var seleccion = $("#seleccion").val();
				
				if ($('input[type=checkbox]:checked').length === 0) {
				mostrarMensaje("Debe seleccionar al menos un Objetivo","ERROR-NOTIFICACION");

				} else {
					ejecutarJson(form);
				 	}
				 

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${infCod}'};
		$('#TablaObjetivosPlan').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerObjetivosPlan",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		columns : [
			{data : "contador"},
			{data : "objetivo"},
			{ data: "" ,"render": function (data, type, full, meta) {
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
        return data;
            }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.imple_cod);
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_objetivos_plan_desarrollo',campo:'obj_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
	                         mostrarMensaje(msg.mensaje, "EXITO");
	                         var td = element.parentNode;
	                         var tr = td.parentNode;
	                         var table = tr.parentNode;      
	                         table.removeChild(tr);
	                         var nFilas = $("#TablaObjetivosPlan tr").length-1;
	                         
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
     
		     
		 
</script>