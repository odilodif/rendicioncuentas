<%-- 
  version   : 1.0
    Document    : listaReportesPedidosDenunciasTabla
    Created on  : 03/04/2018, 11:11:05
    Author    : Carlos Anchundia
    Mail    : e.du.ingcharles@hotmail.com
    Property    : CPCCS
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

<form:form class="needs-validation" novalidate="" id="generarReportePDF" data-rutaAplicacion="admision"	data-opcion="crearNotificacionMenbrete" data-destino="detalleItem" data-nombre="Reportes">
	
			<input type="hidden" name="provincia" value="${provincia}"/>

	
	</form:form>
	<table id="tablaRegistros" class="table table-striped table-bordered"
				style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th>Nombre Institución</th>
						<th>Ruc</th>
						<th>Provincia</th>
						<th>Función</th>
						<th>Fecha</th>
						<th>Dias Trascurridos</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
	<hr/>
</html>
<script>	
	$(document).ready(function(){

		var parametros = {
	            "provincia" :$("#provincia").val()
	        };
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosInstituciones",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
		dom: '<"html5buttons"B>lTfgitp',
		buttons: [
		{extend: 'copyHtml5'},
        {extend: 'csvHtml5'},
        {extend: 'excelHtml5'},
        {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
        {extend: 'print'},
        ],
        columns : [
			{data : "contador" },
			{data : "nombre"},
			{data : "ruc"},
			{data : "provincia"},
			{data : "funcion"},
			{data : "fecha"},
			{data : "dias_transcurridos"},{data : "estado"} ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.inst_cod);
          $(row).attr('class', 'item');
          $(row).attr('data-rutaAplicacion', 'rendicion');
           $(row).attr('data-opcion', 'ActivarInstitucion');
           $(row).attr('ondragstart', 'drag(event)');
           $(row).attr('draggable', 'false');
           $(row).attr('data-destino', 'detalleItem');
           $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );

	});
	
</script>