
 
 <%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false"%>
<spring:url value="/resources/" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<sec:authentication var="usuario" property="principal" />
<!DOCTYPE html>
<html>
<spring:url value="/resources/" var="urlPublic" />
<head>
 <link href="${urlPublic}css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Dashboard Instituciones</title>


</head>
<body>

		<input type="hidden" id="provincia" name="provincia" value="${provincia}">
       <div class="card mb-card20">
          <h5 class="card-header text-white carHeaderBlue" align="center">Cumplimento del Proceso</h5>
          </div>
        <div class="row">
                    <div class="col-lg-4">
                        <div class="ibox " style="cursor: pointer" onclick="mostrarCumplidasAtiempo()">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-success float-right">Cumplido a Tiempo</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${cumplidasAtiempo}</h1>
                                <div class="stat-percent font-bold text-success">${porcentajeAtiempo}% <i class="fa fa-bolt"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="ibox " style="cursor: pointer" onclick="mostrarCumplidasAdestiempo()">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-info float-right">Cumplido a Destiempo</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${cumplidasAdestiempo}</h1>
                                <div class="stat-percent font-bold text-info">${porcentajeAdestiempo}% <i class="fa fa-level-up"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="ibox " style="cursor: pointer" onclick="mostrarCumplidasIncumplidas()">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-danger float-right">Incumplido</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${incumplidas}</h1>
                                <div class="stat-percent font-bold text-danger">${porcentajeIncumplidas}% <i class="fa fa-level-down"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
            </div>
        </div>
         <div class="card mb-card20">
          <h5 class="card-header text-white carHeaderBlue" align="center">Estado del Catastro - Nro. de Instituciones Catastradas: ${catastro}  </h5>
          </div>
        <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-success float-right">Finalizadas</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${finalizadas}</h1>                                     
                                <div class="stat-percent font-bold text-success">${porcentajeFinalizadas}% <i class="fa fa-bolt"></i> </div>
                                <small>Porcentaje del catastro</small>
                            </div>
                            
                        </div>
                    </div>
                    <div class="col-lg-3">
                         <div class="ibox" style="cursor: pointer" onclick="mostrarActivas()">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-info float-right">Activas</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${activas}</h1>
                                <div class="stat-percent font-bold text-info">${porcentajeActivas}% <i class="fa fa-level-up"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox" style="cursor: pointer" onclick="mostrarRegistradas()">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-primary float-right" >Registradas</span> 
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${registradas}</h1>
                                <div class="stat-percent font-bold text-navy">${porcentajeRegistradas}% <i class="fa fa-level-up"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox ">
                            <div class="ibox-title">
                                <div class="ibox-tools">
                                    <span class="label label-danger float-right">Inactivas</span>
                                </div>
                                <h5>Instituciones</h5>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${incactivas}</h1>
                                <div class="stat-percent font-bold text-danger">${porcentajeIncactivas}% <i class="fa fa-level-down"></i></div>
                                <small>Porcentaje del catastro</small>
                            </div>
                        </div>
            </div>
          </div>
         
  <!--  <figure class="highcharts-figure">
    <div id="container"></div>
 
   </figure>
   -->
  
    
</body>
<div class="modal fade" id="Vtn_Registrados" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg"  role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Instituciones Registradas</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >
		<div class="table-responsive">
	
		<table id="tablaRegistrados" class="table table-striped table-bordered  dt-responsive nowrap" style="width:100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Ruc</th>
					<th>Nombre Institución</th>
					<th>Provincia</th>
					<th>Función</th>
					<th>Estado</th>
					<th>Fecha de Registro</th>
					<th>Nombre Representante</th>
					<th>Email Representante</th>
					<th>Telenofno Representante</th>
					<th>Nombre Responsableo</th>
					<th>Email Responsable</th>
					<th>Telenofno Responsable</th>
					<th>Nombre Registro</th>
					<th>Email Registro</th>
					<th>Telenofno Registro</th>
					
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	</div>
		</div>
				</div>
			</div>
</div>

<div class="modal fade" id="Vtn_Activados" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg"  role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Instituciones Activadas</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >
		<div class="table-responsive">
	
		<table id="tablaRegistrosActivados" class="table table-striped table-bordered  dt-responsive nowrap" style="width:100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Ruc</th>
					<th>Nombre Institución</th>
					<th>Provincia</th>
					<th>Función</th>
					<th>Estado</th>
					<th>Fecha de Registro</th>
					<th>Nombre Representante</th>
					<th>Email Representante</th>
					<th>Telenofno Representante</th>
					<th>Nombre Responsableo</th>
					<th>Email Responsable</th>
					<th>Telenofno Responsable</th>
					<th>Nombre Registro</th>
					<th>Email Registro</th>
					<th>Telenofno Registro</th>
					
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	</div>
		</div>
				</div>
			</div>
</div>

<div class="modal fade" id="Vtn_CumplidasAtiempo" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg"  role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Instituciones Cumplidas a Tiempo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >
		<div class="table-responsive">
	
		<table id="tablaRegistrosCumplidoAtiempo" class="table table-striped table-bordered  dt-responsive nowrap" style="width:100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Ruc</th>
					<th>Nombre Institución</th>
					<th>Función</th>
					<th>Descripción</th>
					<th>Provincia</th>
					<th>Número Informe</th>
					<th>Formulario</th>
					<th>Fecha Finalización</th>
					<th>Cumplimiento</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	</div>
		</div>
				</div>
			</div>
</div>

<div class="modal fade" id="Vtn_CumplidasAdestiempo" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg"  role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Instituciones Cumplidas a Destiempo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >
		<div class="table-responsive">
	
		<table id="tablaRegistrosCumplidoAdestiempo" class="table table-striped table-bordered  dt-responsive nowrap" style="width:100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Ruc</th>
					<th>Nombre Institución</th>
					<th>Función</th>
					<th>Descripción</th>
					<th>Provincia</th>
					<th>Número Informe</th>
					<th>Formulario</th>
					<th>Fecha Finalización</th>
					<th>Cumplimiento</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	</div>
		</div>
				</div>
			</div>
</div>

<div class="modal fade" id="Vtn_Incumplidas" tabindex="-1" role="dialog" >
	<div class="modal-dialog modal-lg"  role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="HistorialLabelActl">Instituciones Incumplidas</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body" >
		<div class="table-responsive">
	
		<table id="tablaRegistrosIncumplidas" class="table table-striped table-bordered  dt-responsive nowrap" style="width:100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Ruc</th>
					<th>Nombre Institución</th>
					<th>Función</th>
					<th>Descripción</th>
					<th>Provincia</th>
					<th>Número Informe</th>
					<th>Formulario</th>
					<th>Fecha Finalización</th>
					<th>Cumplimiento</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		
	</div>
		</div>
				</div>
			</div>
</div>

<script type="text/javascript">


$(document).ready(function(){

	


 

});


	 function mostrarRegistradas(){
		 tablaInstitucionesRegistradas();
			$("#Vtn_Registrados").modal('show');
		}

	 function mostrarActivas(){
		 tablaInstitucionesActivas();
			$("#Vtn_Activados").modal('show');
		}


	 function mostrarCumplidasAtiempo(){
		 tablaInstitucionesCumplidasAtiempo();
			$("#Vtn_CumplidasAtiempo").modal('show');
		}


	 function mostrarCumplidasAdestiempo(){
		 tablaInstitucionesCumplidasAdestiempo();
			$("#Vtn_CumplidasAdestiempo").modal('show');
		}

	 
	 function mostrarCumplidasIncumplidas(){
		 tablaInstitucionesIncumplidas();
			$("#Vtn_Incumplidas").modal('show');
		}

	 function tablaInstitucionesRegistradas() {
			var parametros = {"estado" : 'registrado', "provincia" : '${provincia}'};
			$('#tablaRegistrados').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesDatosResponsablesxprovincia",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "provincia"},
					 {data : "funcion"}, 
					 {data : "estado"},
					 {data : "fecha"},
					 {data : "NombreRepresentante"},
					 {data : "EmailRepresentante"},
					 {data : "TelenofnoRepresentante"},
					 {data : "NombreResponsable"},
					 {data : "EmailResponsable"},
					 {data : "TelenofnoResponsable"},
					 {data : "NombreRegistro"},
					 {data : "EmailRegistro"},
					 {data : "TelenofnoRegistro"}
					   
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}


	 function tablaProvincia() {
			var parametros = { "provincia" : '${provincia}'};
			$('#tablaRegistrados').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesDatosResponsablesxprovinciaTodas",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "provincia"},
					 {data : "funcion"}, 
					 {data : "estado"},
					 {data : "fecha"},
					 {data : "NombreRepresentante"},
					 {data : "EmailRepresentante"},
					 {data : "TelenofnoRepresentante"},
					 {data : "NombreResponsable"},
					 {data : "EmailResponsable"},
					 {data : "TelenofnoResponsable"},
					 {data : "NombreRegistro"},
					 {data : "EmailRegistro"},
					 {data : "TelenofnoRegistro"}
					   
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}
		
	 function tablaInstitucionesActivas() {
			var parametros = {"estado" : 'activo', "provincia" : '${provincia}'};
			$('#tablaRegistrosActivados').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesDatosResponsablesxprovincia",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				processing: true,
				serverSide: false,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "provincia"},
					 {data : "funcion"}, 
					 {data : "estado"},
					 {data : "fecha"},
					 {data : "NombreRepresentante"},
					 {data : "EmailRepresentante"},
					 {data : "TelenofnoRepresentante"},
					 {data : "NombreResponsable"},
					 {data : "EmailResponsable"},
					 {data : "TelenofnoResponsable"},
					 {data : "NombreRegistro"},
					 {data : "EmailRegistro"},
					 {data : "TelenofnoRegistro"}
					   
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}


	 function tablaInstitucionesCumplidasAtiempo() {
			var parametros = {"estado" : 'A TIEMPO', "provincia" : '${provincia}'};
			$('#tablaRegistrosCumplidoAtiempo').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesxCumplimientoProvincia",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				processing: true,
				serverSide: false,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "funcion"},
					 {data : "descripcion"},
					 {data : "provincia"},
					 {data : "numeroInforme"}, 
					 {data : "formulario"},
					 {data : "fecha"},
					 {data : "cumplimiento"}
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}


	 function tablaInstitucionesCumplidasAdestiempo() {
			var parametros = {"estado" : 'A DESTIEMPO', "provincia" : '${provincia}'};
			$('#tablaRegistrosCumplidoAdestiempo').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesxCumplimientoProvincia",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				processing: true,
				serverSide: false,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "funcion"},
					 {data : "descripcion"},
					 {data : "provincia"},
					 {data : "numeroInforme"}, 
					 {data : "formulario"},
					 {data : "fecha"},
					 {data : "cumplimiento"}
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}

	 

	 function tablaInstitucionesIncumplidas() {
			var parametros = {"estado" : 'incumplido', "provincia" : '${provincia}'};
			$('#tablaRegistrosIncumplidas').DataTable({
				ajax : {
					data : parametros,
					url : "obtenerIntitucionesxIncumplidasProvincia",
					headers : {
						"X-CSRF-TOKEN" : csrfToken
					},
					type : "POST"
				},
				pageLength : 5,
				order : [ 0, "asc" ],
				bDestroy : true,
				responsive : true,
				processing: true,
				serverSide: false,
				bAutoWidth: true,
				dom : '<"html5buttons"B>lTfgitp',
				buttons : [ 
				 {extend : 'excelHtml5'},
				 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
				 {extend : 'print'},
					 ],
				columns : [ 
					 {data : "contador"},
					 {data : "ruc"},
					 {data : "nombre"}, 
					 {data : "funcion"},
					 {data : "descripcion"},
					 {data : "provincia"},
					 {data : "numeroInforme"}, 
					 {data : "formulario"},
					 {data : "fecha"},
					 {data : "cumplimiento"}
					 ],
				language : {
					url : "resources/json/lenguajeTablaDataTable.json"
				},
				createdRow : function(row, data, dataIndex) {
					$(row).attr('id', data.inst_cod);
					$(row).attr('ondragstart', 'drag(event)');
					$(row).attr('draggable', 'false');
					$(row).attr('data-destino', 'detalleItem');
					$(row).find("td:first").css({
						"font-weight" : "bold",
						"white-space" : "nowrap"
					});
					$(row).find("td").css({
						"font-size"   : "x-small",	
						"vertical-align" : "middle",	
	                });
				},
			});

		}

$("#btnGuardar").click(function(event){
	   var form = $("#escogerProvincia")
		
	    if (form[0].checkValidity() === false   ) {
		mostrarMensaje("Por favor ingrese toda la información solicitada!","ERROR");
	    }else{
	   
	    	abrir($("#escogerProvincia"),event,false);
	    }
});
</script>
</html>

 
 
 