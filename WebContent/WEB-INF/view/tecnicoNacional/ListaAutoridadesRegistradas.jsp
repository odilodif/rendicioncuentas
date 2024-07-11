<%-- 
	version		: 1.0
    Document  	: ListaInstitucionesActivas
    Created on	: 6 abr. 2021; 10:57:12
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<spring:url value="/resources/" var="urlPublic" />
<div class="ibox-content">
<h5 class="card-header text-white carHeaderBlue" align="center">Técnico ${rol}
	 <br>
	 Listado de Autoridades Registradas </h5>
	<div class="table-responsive">
		<table id="tablaRegistros" class="table table-striped table-bordered"
			style="width: 100%">
			<thead>
				<tr>
					<th>#</th>
					<th>Nombre Autoridad</th>
					<th>Cédula</th>
					<th>Provincia</th>
					<th>Dignidad</th>
					<th>Fecha</th>
					<th>Estado</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<hr />
	</div>
</div>
</html>
<script>
	$(document).ready(function() {
		if ('${rol}' == 'Nacional' || '${rol}' == 'Administrador') {
			nacional();
		} else if ('${rol}' == 'Provincial') {
			provincial();
		}
	});

	function nacional() {
		var parametros = {"estado" : 'registrado'};
		$('#tablaRegistros').DataTable({
			ajax : {
				data : parametros,
				url : "obtenerAutoridadesActivasTecNacional",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : "POST"
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
				 {data : "contador"},
				 {data : "nombre"}, 
				 {data : "ruc"},
				 {data : "provincia"},
				 {data : "funcion"}, 
				 {data : "fecha"},
				 {data : "estado"} 
				 ],
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.aut_codigo);
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap"
				});
			},
		});

	}

	function provincial() {

		var parametros = {"provincia" : '${provincia}',"estado" : 'registrado'};
		$('#tablaRegistros').DataTable({
			ajax : {
				data : parametros,
				url : "obtenerAutoridadesActivasTecRovincial",
				headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
				type : "POST"
			},
			order : [ 0, "asc" ],
			bDestroy : true,
			dom : '<"html5buttons"B>lTfgitp',
			buttons : [
				{extend : 'excelHtml5'},
			    {extend : 'pdfHtml5', orientation : 'landscape',	pageSize : 'A1'	}, 
				{extend : 'print'}, 
				],
			columns : [ 
			 {data : "contador"},
			 {data : "nombre"}, 
			 {data : "ruc"},
			 {data : "provincia"},
			 {data : "funcion"}, 
			 {data : "fecha"},
			 {data : "estado"} 
			 ],
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.aut_codigo);
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap"
				});
			},
		});

	}
</script>