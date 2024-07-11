<%-- 
	version		: 1.0
    Document  	: TablaPerilInstitucion
    Created on	: 03/02/2021; 9:32:24
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"	prefix="sec"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<%@ page session="false"%>
<sec:authentication var="usuario" property="principal" />
<!DOCTYPE>
<html>
<spring:url value="/resources/" var="urlPublic" />  
   	 <div id="MensajeEdad">
	<div class="alert alert-primary" role="alert">Dar doble clic sobre los datos del usuario, para poder editar los datos</div>
	</div>          
	<table id="TablaPerilInstitucion" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
              <th>#</th>
              <th>Ruc</th>
              <th>Institución</th>
              <th>Nombres Y apellidos</th>
               <th>Email</th>
               <th>Cedula</th>
               <th>Fecha</th>
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


	$('#TablaPerilInstitucion').DataTable( {	     		   
		ajax: {
		     data:parametros,
			url:"obtenerUsuPerfilIntitucion",

			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"},
	    order: [ 0, "asc" ],
	    
        columns : [
			{data : "contador" },
			{data : "intitucion"},
			{data : "nomInsti"},
			{data : "nombres"},
			{data : "email"},
			{data : "cedula"},
			{data : "pregunta2"},

			],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		                    $(row).attr('id', data.id_user);
		                    $(row).attr('class', 'item');
		                    $(row).attr('data-rutaAplicacion', 'tecnicoNacional');
		                    $(row).attr('data-opcion','EditarPerfilInstitucion');
		                    $(row).attr('ondragstart', 'drag(event)');
		                    $(row).attr('draggable', 'false');
		                    $(row).attr('data-destino', 'detalleItem');
		                    $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                    $(row).find("td:eq(3)").attr('title',data.nombres );
		                },
	    } );
});
</script>