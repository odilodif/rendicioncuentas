<%-- 
	version		: 1.0
    Document  	: Frm_FasesPresupuesto
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
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

<div class="card text-center mb-card15">
	<c:choose>
	<c:when test="${infestado=='activo'}">
	
	<div class="card-header text-white carHeaderBlue">
		<h5>FASES DEL PRESUPUESTO PARTICIPATIVO </h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<form:form class="needs-validation" novalidate=""
					modelAttribute="TblFasePresupuestoParticipativo" id="faseCod"
					data-rutaAplicacion="rendicion"
					data-opcion="guardarFasePresupuestoParticipativo" data-accionEnExito="ACTUALIZAR">	
					<input type="hidden" id="infCod" name="infCod" value="${infCod}">
					
			<table class="table registros table-bordered">
					<tr>
					<th class="tablaingreso" width="20%">FASES DEL PRESUPUESTO PARTICIPATIVO </th>
					<th class="tablaingreso" width="15%">PONGA SI O NO </th>
					<th class="tablaingreso" width="25%">CON QUÉ ACTOR SE REALIZÓ</th>
       				<th class="tablaingreso" width="20%">SE DISCUTIÓ DESDE:(se refiere a la organización territorial con la población)  </th>
					<th class="tablaingreso" width="20%">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
					<tr>
					<td scope="row">
					SE REALIZÓ LA DEFINICIÓN PARTICIPATIVA DE PRIORIDADES DE INVERSIÓN DEL AÑO SIGUIENTE:				
					<td scope="row">
									<select class="custom-select custom-select-sm " id="faseOpcion"  name="faseOpcion" onchange="validar(this)"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div></td>
					<td>
        						 <table class="tablacheckbox">
											<tr>
												<td style="vertical-align: middle;"><label for="uno"><input
														type="checkbox" class="case"
														onclick="return ValidateSelectionPP();" id="checks[]"
														value="ASAMBLEA CIUDADANA"> ASAMBLEA CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="dos"><input
														type="checkbox" class="case"
														onclick="return ValidateSelectionPP();" id="checks[]"
														value="INSTANCIA DE PARTICIPACIÓN CIUDADANA">
														INSTANCIA DE PARTICIPACIÓN CIUDADANA</label></td>
											</tr>
											<tr>
												<td style="vertical-align: middle;"><label for="tres"><input
														type="checkbox" class="case"
														onclick="return ValidateSelectionPP();" id="checks[]"
														value="ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN">
														ASAMBLEA DEL SISTEMA DE PARTICIPACIÓN</label></td>
											</tr>
										</table> <input type="hidden" class="form-control form-control-sm"
										id="ante_descrip" name="ante_descrip">
						</td>
							<td scope="row">
												<textarea rows="2" cols="" class="form-control form-control-sm"
										id="faseGrupo" required="required"
										name="faseGrupo"
										placeholder="Ingrese el nombre lo más detalladamente posible"
										></textarea>
									<div class="invalid-feedback">Por favor ingrese el nombre</div>
						</td>
							<td scope="row">
                                    <input type="url" class="form-control form-control-sm campo url" id="faseLink" name="faseLink" 
                                    required="required" placeholder="Dirección de página web" value="http://">
									<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
							
					</tr>
					<tr>
					<td colspan="3">
					Para la elaboración de los programas subprogramas y proyectos se incorporó la priorización de la inversión que realizó la población del territorio:
					</td>
					<td colspan="2" scope="row">
									<select class="custom-select custom-select-sm " id="faseSubprogramas"  name="faseSubprogramas"  required="required" >
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
									</select>
										<div class="invalid-feedback">Por Ingrese los Resultados de Implementación</div></td>
					
					</tr>
					</table>
			</form:form>
			</div>
		</div>
			<div class="col-md-12 text-center">
				<button type="submit" id="btnGuardar"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</div>
	</div>
</c:when>
<c:when test="${infestado=='matriz'}">

<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
					<div class="row justify-content-center align-items-center">
						<div class="botones" role="group">
						
						<button type="button" id="_eliminar"
							class="btn _eliminarColor _eliminar btn-sm mt-2" onclick="Eliminar(this)">Eliminar</button>
						
						</div>
					</div>
		      </c:when>
			</c:choose>	
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
			<table id="TablaFasePresupuestoParticipativo"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					 <tr>
      				  	<th colspan="6">FASES DEL PRESUPUESTO PARTICIPATIVO:</th>
     				  </tr>
					<tr>
					<th class="tablaingreso" width="10%">#</th>
					<th class="tablaingreso" width="20%">FASES DEL PRESUPUESTO PARTICIPATIVO</th>
					<th class="tablaingreso" width="5%">PONGA SI O NO</th>
					<th class="tablaingreso" width="20%">CON QUÉ ACTOR SE REALIZO </th>
       				<th class="tablaingreso" width="20%">SE DISCUTIÓ DESDE: (se refiere a la organización territorial con la población) </th>
       				<th class="tablaingreso" width="20%">LINK AL MEDIO DE VERIFICACIÓN</th>
					
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

var csrfToken = $('input[name="_csrf"]').val();

$(document).ready(
		function() {

			if ('${infestado}' == 'matriz') {
				tabla();			
			}

			$('[id="checks[]"]').click(function() {
				var arr = $('[id="checks[]"]:checked').map(function() {
					return this.value;
				}).get();
				var str = arr.join('<br>');
				$('#ante_descrip').val(str);
			});
			
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
			$('#ante_descrip').val("");	
			
});
			
$("#btnGuardar")
		.click(
				function(event) {
					$('#presCod').attr('data-opcion',	'guardarFasePresupuestoParticipativo');
					var form = $("#faseCod")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						ValidatePetSelection();
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {

							if($('#ante_descrip').val()==""){
							mostrarMensaje(
									"Por favor ingrese al menos un actor!",
									"ERROR");
							}else{
							 ejecutarJson(form);
							}	

					}
					form.addClass('was-validated');
});

function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#TablaFasePresupuestoParticipativo').DataTable({
	ajax : {
	data : parametros,
	url : "obtenerFasePresupuestoParticipativo",
	headers : {"X-CSRF-TOKEN" : csrfToken},
	type : "POST"	},
	order : [ 0, "asc" ],		
	paging : false,
	info : false,
	searching : false,
	responsive : true,
	scrollX : true,
	bDestroy : true,
	columns : [
		{data : "contador"},
		{data : "faseOpcion"},
		{data : "faseNombre"}, 
		{data : "faseActor"}, 
		{data : "faseGrupo"}, 
		{data : "faseLink"}
		
		],	
		
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
	
		createdRow : function(row, data, dataIndex) {
			$(row).attr('id', data.faseCod);
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


			if(data.faseOpcion ==='PARA LA ELABORACIÓN DE LOS PROGRAMAS SUBPROGRAMAS Y PROYECTOS SE INCORPORÓ LA PRIORIZACIÓN DE LA INVERSIÓN QUE REALIZÓ LA POBLACIÓN DEL TERRITORIO'){
				 $('td:eq(0)', row).css('display', 'none');	
			     $('td:eq(1)', row).attr('colspan', 5);		          
	             $('td:eq(2)', row).css('display', 'none');	      
	             $('td:eq(5)', row).attr('colspan', 1);	
	             $('td:eq(3)', row).css('display', 'none');	  
	             $('td:eq(4)', row).css('display', 'none');	  
	           
	       }
			
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
	        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_fase_presupuesto_participativo',campo:'fase_cod'},
	        success: function (msg) {
	            if (msg.estado == "exito") {
                         mostrarMensaje(msg.mensaje, "EXITO");
                         var td = element.parentNode;
                         var tr = td.parentNode;
                         var table = tr.parentNode;      
                         table.removeChild(tr);
                         var nFilas = $("#TablaFasePresupuestoParticipativo tr").length-2;
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



function ValidatePetSelection()  
{  
    var checkboxes = document.getElementsByName("checkbox");  
    var numberOfCheckedItems = 0;  
    for(var i = 0; i < checkboxes.length; i++)  
    {  
        if(checkboxes[i].checked)  
            numberOfCheckedItems++;  
    }  
    if(numberOfCheckedItems < 1)  
    {  
         
    	mostrarMensaje("Favor seleccione al menos un Actor!",	"ERROR");
    }  
}  

function Eliminar(element) {	
	//var codigo = $(element).closest('tr').attr('id');	
	   var codigo ='${infCod}';	

	 Swal.fire({
		  title: 'ATENCIÓN',
		  text: '¿Está seguro de Eliminar la Matriz?',
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonClass: "btn-info",
		  cancelButtonColor: '#d33',
		  confirmButtonText: "Aceptar",
          cancelButtonText: 'Cancelar',
		}).then((result) => {
		  if (result.value) {
				
			  $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_fase_presupuesto_participativo',campo:'info_cod'},
			        success: function (msg) {
			            if (msg.estado == "exito") {
	                             mostrarMensaje(msg.mensaje, "EXITO");
	                             var td = element.parentNode;
	                             var tr = td.parentNode;
	                             var table = tr.parentNode;      
	                             table.removeChild(tr);
	                                                        	
	                             abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
	                                 
	                        
	                   } else {
	                        $("#cargando").delay("slow").fadeOut();
	                        
	                             mostrarMensaje(msg.mensaje, "ERROR");
	                   }
			        },
			        error: function (result) {

			        }
			    });
			    
		  }else{
			  return false;
		  }
		})
}

function validar(elemento) {
	
	if ($(elemento).val() === "SI") {
		$('input').prop('disabled', false);
		$('#ante_descrip').val("");	
		$('#faseGrupo').prop('disabled', false);
		document.getElementById("faseLink").required = false;
		} else if ($(elemento).val() === "NO") {
		$('input').prop('disabled', true);
		$('input').prop('checked', false);
		$('#ante_descrip').prop('disabled', false);
		$('#ante_descrip').val("NO APLICA");	
		$('#faseGrupo').prop('disabled', true);
		$('#infCod').prop('disabled', false);
	} else
	{
	}
}


function ValidateSelectionPP() {
	
	var checkboxes = $('[id="checks[]"]:checked').map(function() {
		return this.value;
	}).get();
	var valor = checkboxes.length
	if (checkboxes.length === 0) {
		mostrarMensaje("Favor seleccione al menos un Actor!", "ERROR");
	}
	return valor
} 
</script>
