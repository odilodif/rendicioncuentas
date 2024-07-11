<%-- 
	version		: 1.0
    Document  	: ListarSeguiminetoInstituciones
    Created on	: 6 may. 2022 ; 11:01:32
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
    Celular     : 0995491200
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
	<h5 class="card-header text-white carHeaderBlue" align="center">
		Técnico ${rol} <br> Seguimineto Instituciones
	</h5>


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

	<form:form class="needs-validation" novalidate=""
		modelAttribute="TblInstitucion" id="SeguiminetoInstitucion"
		data-rutaAplicacion="tecnicoNacional" data-opcion=""
		data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
		<div class="form-group row">
			<div class="col-md-2 text-left">
				<label for="provincia">Periodo</label>
			</div>
			<div class="col-md-3 text-left">
				<select class="custom-select custom-select-sm" id="periodo"
					required="required" name="periodo">

					<c:forEach var="i" begin="${anio}" end="${anioActual-1}" step="1"
						varStatus="status">
						<c:set var="selected" value="" />
						<c:choose>
							<c:when test="${anio==i}">
								<option value="">Seleccione...</option>
							</c:when>
						</c:choose>
						<option ${selected} value="${i}">${i}</option>
					</c:forEach>
				</select>
				<div class="invalid-feedback">Por favor seleccione el año</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2 ">
				<button type="button" id="btnGuardar"
					class="btn _nuevoColor _buscar btn-sm ">Generar</button>
			</div>
		</div>
		<div class="ibox-content">

			<div class="table-responsive">

				<table id="TablaSeguimineto"
					class="table table-striped table-bordered" style="width: 100%">
					<thead>
						<tr>
							<th>#</th>					
							<th style="font-size: x-small;">Código</th>
							<th style="font-size: x-small;">Nombre</th>
						  	<th style="font-size: x-small;">Ruc</th> 
							<th style="font-size: x-small;">Función</th>
							<th style="font-size: x-small;">Provincia</th>
							<th style="font-size: x-small;">Cantón</th>
							<th style="font-size: x-small;">Descripción</th>
							<th style="font-size: x-small;">Estado</th>
							<th style="font-size: x-small;">Fecha Registro</th>
							<th style="font-size: x-small;">Fecha Activación</th>
							<th style="font-size: x-small;">Estado Informe</th>
							<th style="font-size: x-small;">Fecha Inicio Informe</th>
							<th style="font-size: x-small;">Fecha Fin Informe</th>
							<th style="font-size: x-small;">Cumplio</th>
							<th style="font-size: x-small;">Responsable Legal</th>
							<th style="font-size: x-small;">Celular Responsable Legal</th>
							<th style="font-size: x-small;">Email Responsable Legal</th>
							<th style="font-size: x-small;">Responsable Rendición</th>
							<th style="font-size: x-small;">Celular Responsable	Rendición</th>
							<th style="font-size: x-small;">Email Responsable Rendición</th>
							<th style="font-size: x-small;">Responsable Registro</th>
							<th style="font-size: x-small;">Celular Responsable Registro</th>
							<th style="font-size: x-small;">Email Responsable Registro</th>

						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>



	</form:form>




</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {

	});
	
	$("#btnGuardar").click(function(event){		  
		    var form = $("#SeguiminetoInstitucion")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {				
				tabla();
	
			}
			form.addClass('was-validated');
		   
	});

	
	function tabla() {
	var parametros = {"periodo" : $("#periodo").val()};
     $('#TablaSeguimineto').DataTable({
		ajax : {
			data: parametros,			
			url : "obtenerSeguiminetoInstituciones",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST",			
		},
		order : [ 0, "asc" ],
		bDestroy : true,
		dom : '<"html5buttons"B>lTfgitp',
		buttons : [ 
		 {extend : 'excelHtml5'},
		 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
		 {extend : 'print'},
			 ],
		columns : [
			 { data : "contador"},
             { data: "inst_cod" },    
             { data: "inst_nom" },
             { data: "inst_ruc" },
             { data: "funcion" },
             { data: "provincia" },
             { data : "canton"},
             { data: "inst_tip_des" },
             { data: "inst_estado" },
             { data: "inst_fecha_registro" },
             { data: "inst_fecha_activar" },
             { data: "inf_estado" },
             { data: "inf_fechaini" },
             { data: "inf_fechafin" },
             { data: "inf_verificador" },
             { data: "nombrerepresentante" },
             { data: "emailrepresentante" },
             { data: "celularrepresentante" },
             { data: "nombreresponsable" },
             { data: "emailresponsable" },
             { data: "celularresponsable" },
             { data: "nombreregistro" },
             { data: "emailregistro" },
             { data: "celularregistro" }
				],

		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},

		createdRow : function(row, data, dataIndex) {
			$(row).attr('codigo', data.inst_cod);
			//$(row).attr('class', 'item');
			// $(row).attr('data-rutaAplicacion', 'rendicion');
			//$(row).attr('data-opcion', 'Frm_ImplemetacionPoliticasActul');
			$(row).attr('ondragstart', 'drag(event)');
			$(row).attr('draggable', 'false');
			$(row).attr('data-destino', 'detalleItem');
			$(row).find("td:eq(6)").attr('align', 'center');
			$(row).find("td:first").css({
				"font-weight" : "bold",
				"white-space" : "nowrap",
			});
			$(row).find("td").css({
				"font-size" : "x-small",
				"align-items" : "center",
				"vertical-align" : "middle",
			});
			
		},

	});

	}


/*
	function tabla() {		  
	      //   $('#tablaListaFinalizar').dataTable().fnDestroy();
	        const parametros = {"periodo" : $("#periodo").val()};  
	             $.ajax({
	            	data: parametros,			
	     			url : "obtenerPrueba",
	     			headers : {
	     				"X-CSRF-TOKEN" : csrfToken
	     			},
	     			type : "POST",                            
	                 success: function (result) {	             	
	                console.log("ingresa ver json>>",result);   
	                console.log("ingresa ver json>>",JSON.parse(result)); 	                       
	                     $('#TablaSeguimineto').DataTable({                         
	                         data: JSON.parse(result),
	                     	order : [ 0, "asc" ],
	                		bDestroy : true,
	                		dom : '<"html5buttons"B>lTfgitp',
	                		buttons : [ 
	                		 {extend : 'excelHtml5'},
	                		 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
	                		 {extend : 'print'},
	                			 ],
	                         columns: [
	                        	 { data : "contador"},
	                             { data: "inst_cod" },    
	                             { data: "inst_nom" },
	                             { data: "inst_ruc" },
	                             { data: "funcion" },
	                             { data: "provincia" },
	                             { data : "canton"},
	                             { data: "inst_tip_des" },
	                             { data: "inst_estado" },
	                             { data: "inst_fecha_registro" },
	                             { data: "inst_fecha_activar" },
	                             { data: "inf_estado" },
	                             { data: "inf_fechaini" },
	                             { data: "inf_fechafin" },
	                             { data: "inf_verificador" },
	                             { data: "nombrerepresentante" },
	                             { data: "emailrepresentante" },
	                             { data: "celularrepresentante" },
	                             { data: "nombreresponsable" },
	                             { data: "emailresponsable" },
	                             { data: "celularresponsable" },
	                             { data: "nombreregistro" },
	                             { data: "emailregistro" },
	                             { data: "celularregistro" }	                           
	                           
	                         ],                       
	                         language: {
	                 			url : "resources/json/lenguajeTablaDataTable.json"
	                           
	                         }, rowCallback: function (row, data, index) {
	                             
	                             if (data.descripcion == "Devuelto") {
	                                 $('td', row).css('background-color', '#FF5757');
	                                 $('td', row).css('color', '#000000');
	                                 $('td', row).css('font-size', 'x-small');
	                             }         
	                     },
	                         createdRow: function (row, data, dataIndex) {
	                             $(row).attr('id', data.inst_cod);
	                             // $(row).attr('class', 'item');
	                             // $(row).attr('data-rutaAplicacion', 'ServicioSecretaria.asmx');
	                             //$(row).attr('data-opcion', 'EditarTratimete');
	                             //$(row).attr('ondragstart', 'drag(event)');
	                             //$(row).attr('draggable', 'false');
	                             // $(row).attr('data-destino', 'detalleItem');
	                             //$(row).find("td:first").css({ "font-weight": "bold", "white-space": "nowrap" });
	                             $(row).find("td").css({
	                                 "font-size": "x-small",
	                                 "vertical-align": "middle",
	                             });
	                         },
	                     });
	                 },
	                 error: function (errormessage) {
	                     alert(errormessage.responseText);
	                 }
	             });       

	     }*/
	
	
</script>