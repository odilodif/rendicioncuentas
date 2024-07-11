<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" /> 
<c:set var="urlreportes"
	value="<%=Constantes.URL_SERVIDOR_REPORTES%>" />
<!DOCTYPE">
<html>
<div class="card mb-card20">
	<h5 class="card-header text-white carHeaderBlue" align="center">
	Informes de Fin de Gestión
	</h5>
	<c:choose>
	<c:when test="${accion==0}">
	<div class="row justify-content-center align-items-center">
		<div class="botones" role="group">
		<c:forEach items="${acciones}" var="a">
			<a class="btn ${a[5]} btn-sm" id="${a[2]}" data-rutaAplicacion="${a[4]}" data-opcion="${a[1]}"	data-destino="detalleItem">  
			
			<c:if test="${a[2]=='_seleccionar'}">
	 			<span class='cantidadItemsSeleccionados'>0</span>
			</c:if>
			
			<c:if test="${a[2]!='_seleccionar'}">
	 			<span class="${a[2]}"></span>
			</c:if>
			
			<span>${a[3]}</span></a>
		</c:forEach>
		</div>
	</div>
	<hr/>
	</c:when>
	</c:choose>
	
	
		
		<div class="ibox-content">

			<div class="table-responsive">
			
			
	<table id="tablaFinGestion" class="table table-striped table-bordered" style="width:100%">
         <thead>
         	<tr>
         		<th>#</th>
                <th style="font-size: x-small;">CÓDIGO INFORME</th>
                 <th style="font-size: x-small;">CÉDULA</th>
                  <th style="font-size: x-small;">NOMBRE AUTORIDAD</th>
                   <th style="font-size: x-small;">TIPO DE AUTORIDAD</th>
                <th style="font-size: x-small;">FECHA INICIO DE GESTIÓN </th>
                <th style="font-size: x-small;">FECHA FIN DE GESTION</th>
                <th style="font-size: x-small;">ESTADO</th>
                <th> </th>
            </tr>
         </thead>
         <tbody class="tbody"></tbody>
	</table>
	
	</div>
	
	</div>
	
</div>
</html>
<script>	
$(document).ready(function() {
	tablaGestion();					
});
function tablaGestion() {

	$('#tablaFinGestion').DataTable( {   
		ajax: {
			url:"view/gestion/obtenerFinGestion",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },paging : false,
				info : false,
				searching : false,	
				bDestroy : true,
	    columns : [
	    	{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
  		 	}},
			{data : "infAutCod"},
			{data : "cedula"},
			{data : "nombre"},
			{data : "dignidad"},
			{data : "fechaInicio"},
			{data : "fechaFin"},
			{data : "estado"},
			{data : "","render" : function(data, type, full,meta) {
	            if (full.estado == "activo") {
					data = '<button type="button" id="EditarFin" OnClick="EditarFinGestion(this);" class="Editar btn btn-link"  title="Editar Informe" data-toggle="tooltip" data-placement="bottom" style="font-size:x-big;"><i class="fas fa-edit fa-lg"></i></button>';
					} else {
						data = '<button type="button" id="Imprimir" class="Editar btn btn-link" title="Imprimir Informe" data-toggle="tooltip" data-placement="bottom" style="font-size:x-big;"><i class="fas fa-print fa-lg" onClick="datosAutoridad('+full.infAutCod+');"></i></button>';							     			 
				
				}
					return data;
				}},
			  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		   $(row).attr('id', data.idGestion);
	       $(row).attr('ondragstart', 'drag(event)');
	   	   $(row).attr('data-rutaAplicacion', 'gestion');
		   $(row).attr('data-opcion', 'FrmFinGestion');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	       },
	    } );
}
function EditarFinGestion(element) {
	 $('#tablaFinGestion tbody').on('click', 'tr', function() {
		 $(this).attr('data-nombre','Editar');
			abrir($(this), "#" + $(this).attr("data-destino"),false);
		});	}
function datosAutoridad(informe){
     
	const url='${urlreportes}'+"AutoridadesFinGestion&Codigo="+informe; 
     window.open(url);
 }
</script>