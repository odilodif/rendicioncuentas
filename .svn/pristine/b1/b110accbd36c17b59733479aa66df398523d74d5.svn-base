<%-- 
	version		: 1.0
    Document  	: ListaFuncionarios
    Created on	: 31 mar. 2021; 09:12:39
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
<h5 class="card-header text-white carHeaderBlue" align="center">Técnico ${rol}
	 <br>
	 Listado de Usuarios Internos</h5>
<c:choose>
<c:when test="${Verificador=='acceso' }">

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
			<div class="ibox-content">

                        <div class="table-responsive">
			
			<table id="TablaUsuario"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">NOMBRES</th>
						<th style="font-size: x-small;">CEDULA</th>
						<th style="font-size: x-small;">EMAIL</th>
						<th style="font-size: x-small;">PROVINCIA</th>
						<th style="font-size: x-small;">TIPO</th>
						<th > </th>
						<th > </th>
					</tr>
				</thead>
				<tbody>
				</tbody>				
			</table>
	</div>
	</div>
		</c:when>
		<c:otherwise>

				<div>
				<div id="AccesoNegado">
					¡Acceso Negado!... Usted no es administrador.  <br /> <span
						style="font-weight: bold;"></span>No puede acceder a este modulo <br />
				</div>
			</div>
		
		</c:otherwise>
	</c:choose>
</div>
</html>

<script type="text/javascript">
 $(document).ready(function(){

		if ('${Verificador}' == 'acceso') {
			tabla();			
		}
	});

 function tabla() {
		
		$('#TablaUsuario').DataTable({
		ajax : {
		url : "obtenerListaFuncionarios",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],		
		bDestroy : true,
		dom: '<"html5buttons"B>lTfgitp',
		buttons: [	
        {extend: 'csvHtml5'},
        {extend: 'excelHtml5'},
        {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
        ],
		columns : [
			{data : "contador"},
			{data : "nombres"},
			{data : "cedula"}, 
			{data : "email"}, 
			{data : "provincia"}, 
			{data : "rol"},
			{ data: "" ,"render": function (data, type, full, meta) {				
		             if (full.estado==1) {
		            	 data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
					} else {
						 data = '<button type="button" id="Activar" class="_modificar btn _actualizarColor btn-xs"  onclick="Modificar(this)" title="Activar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;">Activar</button>';    

					}
     			  return data; 
     			}},
			{ data: "" ,"render": function (data, type, full, meta) {					
		             if (full.estado==1) {
		            	 data = '<button type="button" id="Editar" class="Editar btn btn-link"  onclick="Actualizar(this)" title="Actualizar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-big;"><i class="fas fa-address-card fa-lg"></i></button>';   
					} else {
						data = '<i class="fas fa-ban"></i>';  		

					}
    			  return data; 
    			}}
			],	
			
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.id_user);
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'tecnicoNacional');
				$(row).attr('data-opcion', 'Crear_Perfiles');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:eq(6)").attr('align','center');
				$(row).find("td:eq(7)").attr('align','center');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});		
				$(row).find("td").css({
					"font-size"   : "x-small",	
					"vertical-align" : "middle",	
					"align-items" : "center",					
				});	
		
			},	
			
		});

	}
 function Eliminar(element) {	
	 var opcion = $(element).closest('tr').attr('id');
	// console.log(opcion);
	  $.ajax({
      url: 'DesactivarPerfil',
      headers: {"X-CSRF-TOKEN": csrfToken},
      type: "POST",
      dataType: 'json',
      data: {codigo: opcion},
      success: function (result) {
    	 
    	  if(result.valida ==="deshabilitado"){   
    		  mostrarMensaje("Ususario deshabilitado!","EXITO-NOTIFICACION","3000"); 
    		  abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
      		}    	
      	  else if(result.valida ==="vacio"){   
    		  mostrarMensaje("Usuario no deshabilitado verificar con el departamento de Sistemas !","ERROR-NOTIFICACION","3000"); 
      		
      		}else{
      			mostrarMensaje(result.mensaje,"ERROR","3000"); 
      			
      		}
	  
      },
      error: function (result) {       
    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
    		

      }
  });

}
 
 function Modificar(element) {
	 var opcion = $(element).closest('tr').attr('id');
		// console.log(opcion);
		  $.ajax({
	      url: 'ActivarPerfil',
	      headers: {"X-CSRF-TOKEN": csrfToken},
	      type: "POST",
	      dataType: 'json',
	      data: {codigo: opcion},
	      success: function (result) {
	    	  if(result.valida ==="PerfilActivo"){   
	    		  mostrarMensaje("Ususario Activo!","EXITO-NOTIFICACION","3000"); 
	    		  abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
	      		}    	
	      	  else if(result.valida ==="vacio"){   
	    		  mostrarMensaje("Usuario no deshabilitado verificar con el departamento de Sistemas !","ERROR-NOTIFICACION","3000"); 
	      		
	      		}
		  
	      },
	      error: function (result) {       
	    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
	    		

	      }
	  });
		 
	 
 }
	function Actualizar(element) {	
		$('#TablaUsuario tbody').on('click', 'tr', function() {
			abrir($(this), "#" + $(this).attr("data-destino"), false);
		});
			
	}
	
</script>