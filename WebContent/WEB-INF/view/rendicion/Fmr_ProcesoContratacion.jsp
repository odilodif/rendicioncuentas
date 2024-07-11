<%-- 
	version		: 1.0
    Document  	: Fmr_ProcesoContratacion
    Author		: wilmer Guaman
    Mail		: guamanw@gmail.com
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
		<h5>PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS:</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<div id="nuevo">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblProcesosContratacion" id="TblProcesosContratacion"
						data-rutaAplicacion="rendicion" data-opcion="guardarProceso"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<input type="hidden" id="infCod" name="infCod"
							value="${infCod}">
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">TIPO DE CONTRATACIÓN</label>
								</div>
								<div class="col-md-2  text-left">
									<select class="custom-select custom-select-sm select"
											id="pcoTipoContrat" name="pcoTipoContrat"
											onchange="validar(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="ÍNFIMA CUANTÍA">ÍNFIMA CUANTÍA</option>
												<option value="PUBLICACIÓN">PUBLICACIÓN</option>
												<option value="TERMINACIÓN UNILATERAL">TERMINACIÓN UNILATERAL</option>
												<option value="CONSULTORÍA">CONSULTORÍA</option>
												<option value="SEGUROS">SEGUROS</option>
												<option value="LICITACIÓN">LICITACIÓN</option>
												<option value="SUBASTA INVERSA ELECTRÓNICA">SUBASTA INVERSA ELECTRÓNICA</option>
												<option value="FERIA INCLUSIVA">FERIA INCLUSIVA</option>
												<option value="PROCESOS DE DECLARATORIA DE EMERGENCIA">PROCESOS DE DECLARATORIA DE EMERGENCIA</option>
												<option value="CONCURSO PÚBLICO">CONCURSO PÚBLICO</option>
												<option value="CONTRATACIÓN DIRECTA">CONTRATACIÓN DIRECTA</option>
												<option value="MENOR CUANTÍA OBRAS">MENOR CUANTÍA OBRAS</option>
												<option value="LISTA CORTA">LISTA CORTA</option>
												<option value="CONTRATACIÓN EN SITUACIONES DE EMERGENCIA">CONTRATACIÓN EN SITUACIONES DE EMERGENCIA</option>
												<option value="COMPRA DE BIENES INMUEBLES">COMPRA DE BIENES INMUEBLES</option>
												<option value="ARRENDAMIENTO DE BIENES INMUEBLES">ARRENDAMIENTO DE BIENES INMUEBLES</option>
												<option value="ARRENDAMIENTO DE BIENES MUEBLES">ARRENDAMIENTO DE BIENES MUEBLES</option>
												<option value="CATÁLOGO ELECTRÓNICO">CATÁLOGO ELECTRÓNICO</option>
												<option value="RÉGIMEN ESPECIAL (Todos los procesos) ">RÉGIMEN ESPECIAL (Todos los procesos) </option>
												<option value="COTIZACIÓN">COTIZACIÓN</option>
												<option value="FERIAS INCLUSIVAS">FERIAS INCLUSIVAS</option>
												<option value="COMPRA POR CATALOGO">COMPRA POR CATALOGO</option>
												<option value="PRODUCCIÓN NACIONAL">PRODUCCIÓN NACIONAL</option>
												<option value="MENOR CUANTÍA B Y S">MENOR CUANTÍA B Y S</option>
												<option value="CONTRATO INTEGRAL POR PRECIO FIJO">CONTRATO INTEGRAL POR PRECIO FIJO</option>
												<option value="OTRAS">OTRAS</option>
												<option value="NO SE REALIZARON CONTRATACIONES">NO SE REALIZARON CONTRATACIONES</option>
										</select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">NÚMERO TOTAL ADJUDICADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo"  id="pcoNumeroAdj" name="pcoNumeroAdj" required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el tipo de bien</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR TOTAL ADJUDICADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="pcoValorAdj" name="pcoValorAdj" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false" />
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">NÚMERO TOTAL FINALIZADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="pcoNumeroFin" name="pcoNumeroFin" required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR TOTAL FINALIZADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="pcoValorFin" name="pcoValorFin" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)" onchange="calculoPresupuesto(this.value)" onpaste="return false" />
									<div class="invalid-feedback"   >Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left" >
									<label for="parroquia" style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="pcoLink" name="pcoLink" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
						</div>
					</form:form>
					<hr />
				</div>
				<div id="actualizar">
					<form:form class="needs-validation" novalidate=""
						modelAttribute="TblEnajenacionBienes" id="TblEnajenacionBienesActualizar"
						data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
						data-destino="detalleItem" data-accionEnExito="ACTUALIZAR">
						<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">TIPO DE CONTRATACIÓN</label>
								</div>
								<div class="col-md-2  text-left">
									<select class="custom-select custom-select-sm select"
											id="pco_tipo_contrat" name="pco_tipo_contrat"
											onchange="validar2(this)"  required="required">
												<option value="">Seleccione...</option>
												<option value="ÍNFIMA CUANTÍA">ÍNFIMA CUANTÍA</option>
												<option value="PUBLICACIÓN">PUBLICACIÓN</option>
												<option value="TERMINACIÓN UNILATERAL">TERMINACIÓN UNILATERAL</option>
												<option value="CONSULTORÍA">CONSULTORÍA</option>
												<option value="SEGUROS">SEGUROS</option>
												<option value="LICITACIÓN">LICITACIÓN</option>
												<option value="SUBASTA INVERSA ELECTRÓNICA">SUBASTA INVERSA ELECTRÓNICA</option>
												<option value="FERIA INCLUSIVA">FERIA INCLUSIVA</option>
												<option value="PROCESOS DE DECLARATORIA DE EMERGENCIA">PROCESOS DE DECLARATORIA DE EMERGENCIA</option>
												<option value="CONCURSO PÚBLICO">CONCURSO PÚBLICO</option>
												<option value="CONTRATACIÓN DIRECTA">CONTRATACIÓN DIRECTA</option>
												<option value="MENOR CUANTÍA OBRAS">MENOR CUANTÍA OBRAS</option>
												<option value="LISTA CORTA">LISTA CORTA</option>
												<option value="CONTRATACIÓN EN SITUACIONES DE EMERGENCIA">CONTRATACIÓN EN SITUACIONES DE EMERGENCIA</option>
												<option value="COMPRA DE BIENES INMUEBLES">COMPRA DE BIENES INMUEBLES</option>
												<option value="ARRENDAMIENTO DE BIENES INMUEBLES">ARRENDAMIENTO DE BIENES INMUEBLES</option>
												<option value="ARRENDAMIENTO DE BIENES MUEBLES">ARRENDAMIENTO DE BIENES MUEBLES</option>
												<option value="CATÁLOGO ELECTRÓNICO">CATÁLOGO ELECTRÓNICO</option>
												<option value="RÉGIMEN ESPECIAL (Todos los procesos) ">RÉGIMEN ESPECIAL (Todos los procesos) </option>
												<option value="COTIZACIÓN">COTIZACIÓN</option>
												<option value="FERIAS INCLUSIVAS">FERIAS INCLUSIVAS</option>
												<option value="COMPRA POR CATALOGO">COMPRA POR CATALOGO</option>
												<option value="PRODUCCIÓN NACIONAL">PRODUCCIÓN NACIONAL</option>
												<option value="MENOR CUANTÍA B Y S">MENOR CUANTÍA B Y S</option>
												<option value="CONTRATO INTEGRAL POR PRECIO FIJO">CONTRATO INTEGRAL POR PRECIO FIJO</option>
												<option value="OTRAS">OTRAS</option>
												<option value="NO SE REALIZARON CONTRATACIONES">NO SE REALIZARON CONTRATACIONES</option>
												
										</select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">NÚMERO TOTAL ADJUDICADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo"  id="pco_numero_adj" name="pco_numero_adj" required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el tipo de bien</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR TOTAL ADJUDICADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="pco_valor_adj" name="pco_valor_adj" required="required" placeholder="0.00" onkeypress="mascara(this,cpf)"  onpaste="return false" />
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">NÚMERO TOTAL FINALIZADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"  id="pco_numero_fin" name="pco_numero_fin" required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);"/>
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-2 text-left">
									<label for="parroquia" style="text-align: center; font-size: x-small;">VALOR TOTAL FINALIZADOS</label>
								</div>
								<div class="col-md-2  text-left">
									<input type="text" class="form-control form-control-sm campo valor"   id="pco_valor_fin" name="pco_valor_fin" required="required" placeholder="0.00" onchange="calculoPresupuestoActualizar(this.value)" onkeypress="mascara(this,cpf)"  onpaste="return false" />
									<div class="invalid-feedback">Por Ingrese el valor</div>
								</div>
							</div>
								<div class="form-group row">
								<div class="col-md-2 text-left" >
									<label for="parroquia" style="text-align: center; font-size: x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</label>
								</div>
								<div class="col-md-4  text-left">
									<input type="url" class="form-control form-control-sm url"  id="pco_link" name="pco_link" required="required" placeholder="Dirección de página web"
											value="http://"/>
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
								</div>
								
							</div>
						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
					</form:form>
					<hr />
					<input type="hidden" id="pco_cod" name="pco_cod">
				</div>
				<div id="tabla">
				<div class="row justify-content-center align-items-center">
	
		       <div class="botones" role="group">
		       <button type="submit" id="btnNuevo"
								class="btn _nuevoColor _nuevo btn-sm mt-2">Añadir</button>
		     	
	          	</div>
	            </div>
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th >TIPO DE CONTRATACIÓN</th>
								<th >ESTADO ACTUAL</th>
								<th>LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG. WEB DE LA INSTITUCIÓN</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
				</div>
			</div>
		</div>

	</div>
 </c:when>
 <c:when test="${infestado=='finalizado'}">
 <div class="card-header text-white carHeaderBlue">
		<h5>PROCESOS DE CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS:</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
			<input type="hidden" id="infCod" name="infCod"
							value="${infCod}">
			<div id="tabla">
					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th >TIPO DE CONTRATACIÓN</th>
								<th >ESTADO ACTUAL</th>
								<th>LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG. WEB DE LA INSTITUCIÓN</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
					<hr />
				</div>
			</div>
			</div>
			</div>
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
$(document).ready(function(){
	 $("#actualizar").hide();
	 if ('${infestado}' == 'activo'||'${infestado}' == 'finalizado') {
	 tabla();
	 }
});
$("#btnNuevo").click(function(event) {
	 $('#tabla').hide();
	 $('#nuevo').show();
});


function validar(elemento) {
	if ($(elemento).val() === "NO SE REALIZARON CONTRATACIONES"){
		
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
			 $("#pcoNumeroAdj").val(0);
			 $("#pcoValorAdj").val(0);
			 $("#pcoNumeroFin").val(0);
			 $("#pcoValorFin").val(0);
				

	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		 $("#pcoNumeroAdj").val('');
		 $("#pcoValorAdj").val('');
		 $("#pcoNumeroFin").val('');
		 $("#pcoValorFin").val('');
		}
}

function validar2(elemento) {
	if ($(elemento).val() === "NO SE REALIZARON CONTRATACIONES"){
		
			$(".url").val("NO APLICA");
			$(".url").get(0).type = 'text';
			$(".campo").removeAttr("required");
			 $("#pco_numero_adj").val(0);
			 $("#pco_valor_adj").val(0);
			 $("#pco_numero_fin").val(0);
			 $("#pco_valor_fin").val(0);
				

	}else{
		$(".campo").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		 $("#pco_numero_adj").val('');
		 $("#pco_valor_adj").val('');
		 $("#pco_numero_fin").val('');
		 $("#pco_valor_fin").val('');
		}
}

function tabla() {
	var parametros = {
            "infCod" :$("#infCod").val()
        };
	$.ajax({
        url: "obtenerRegistrosProcesoContratacion",
        type: "post",
        dataType: "json",
        data: parametros,
        headers: {"X-CSRF-TOKEN": csrfToken},
        success: function (result) {
        	 if (result['Error']) {
                 $('#tabla').hide();
             }else if(result['data'].length!=0){
            	 $('#nuevo').hide();
        $('#tablaRegistros').DataTable( {   
        	
          order: [ 0, "asc" ],
          paging : false,
  		info : false,
  		searching : false,
  		responsive : true,
  		scrollX : true,
  		bDestroy : true,	
	      buttons: [
	      {extend: 'copyHtml5'},
          {extend: 'csvHtml5'},
          {extend: 'excelHtml5'},
    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
    {extend: 'print'},
    ],
    data: result.data,
    columns : [
		{data : "contador" },
		{data : "tipo"},
		{data : "","render": function (data, type, full, meta) {
			 data ='<table class="table registros table-bordered"> <tr> <th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Finalizados</th> <th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Finalizados</th></tr><tr><td>'+full.numeroAdj+ '</td><td>'+full.valorAdj+ '</td><td>'+full.numeroFin+ '</td><td>'+full.valorFin+ '</td> </tr></table>'
			   return data;
	    }},
		{data : "link"},
		{ data: "" ,"render": function (data, type, full, meta) {
			 if('${infestado}' === "finalizado"){
            	 data = '';     
             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom"> Editar</button>';    
             } return data;
    }},{ data: "" ,"render": function (data, type, full, meta) {
    	 if('${infestado}' === "finalizado"){
        	 data = '';     
         }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor btn-sm"   onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom"> Eliminar</button>';    
         } return data;
    }} ],
		language: {
              url: "resources/json/lenguajeTablaDataTable.json"
          },
	createdRow: function( row, data, dataIndex ) {
	     $(row).attr('id', data.pcoCod);
       $(row).attr('ondragstart', 'drag(event)');
       $(row).attr('draggable', 'false');
       $(row).attr('data-destino', 'detalleItem');
       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
	                },
    } );
        }else{}
	 },
     error: function (errormessage) {
         alert(errormessage.responseText);
     }
 });
}
		$("#btnGuardar").click(
				function(event) {
					var form = $("#TblProcesosContratacion")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						 $(".campo").removeAttr("disabled");
						 $(".url").removeAttr("disabled");
						ejecutarJson(form);
					}
					form.addClass('was-validated');

				});	
		function Eliminar(element) {	
			var codigo = $(element).closest('tr').attr('id');	
			 $.ajax({
			        url: 'view/rendicion/eliminarDatos',
			        headers: {"X-CSRF-TOKEN": csrfToken},
			        type: "POST",
			        dataType: 'json',
			        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_procesos_contratacion',campo:'pco_cod'},
			        success: function (msg) {
			            if (msg.estado == "exito") {
	                             mostrarMensaje(msg.mensaje, "EXITO");
	                             var td = element.parentNode;
	                             var tr = td.parentNode;
	                             var table = tr.parentNode;      
	                             table.removeChild(tr);
	                             var nFilas = $("#tablaRegistros tr").length-1;
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
		function Modificar(element) {	
			var codigo = $(element).closest('tr').attr('id');
			var tipo = $(element).parent().parent().find("td:eq(1)").text();
			var numeroAdj = $(element).parent().parent().find("td:eq(3)").text();
			var valorAdj = $(element).parent().parent().find("td:eq(4)").text();
			var numeroFin = $(element).parent().parent().find("td:eq(5)").text();
			var valorFin = $(element).parent().parent().find("td:eq(6)").text();
			var link = $(element).parent().parent().find("td:eq(7)").text();
			 $("#nuevo").hide();
			 $("#tabla").hide();
			  $("#actualizar").show();
			  $("#pco_cod").val(codigo);
			  cargarValorComboPorDefecto("pco_tipo_contrat",tipo);
			  $("#pco_numero_adj").val(numeroAdj);
			  $("#pco_valor_adj").val(valorAdj);
			  $("#pco_numero_fin").val(numeroFin);
			  $("#pco_valor_fin").val(valorFin);
			  $("#pco_link").val(link);
		}
		$("#btnActualizar").click(
				function(event) {
				//	$('#plantrabajo').attr('data-opcion','guardarPlantrabajo');
					var form = $("#TblEnajenacionBienesActualizar")
					event.preventDefault();
					event.stopPropagation();
					if (form[0].checkValidity() === false) {
						mostrarMensaje(
								"Por favor ingrese toda la información solicitada!",
								"ERROR");
					} else {
						 $(".campo").removeAttr("disabled");
						 $(".url").removeAttr("disabled");
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
							    	if(field.name=="pco_valor_adj"||field.name=="pco_valor_fin"){
							    		field.value=field.value.replace(/,/g, "");
							    	}
							    	valores+= field.value+ ',99';
							    	if (valores.length > 0) {
							    		valores = valores.substr(0, valores.length - 1);
			                        }
							    });
						  var data = {tabla: 'esq_rendicioncuentas.tbl_procesos_contratacion',columns:columnas,values:valores,condicion:'pco_cod',valorcondicion:$("#pco_cod").val()};
						  
						  ejecutarJsonUpdate(form,data);
					}
					form.addClass('was-validated');

				});	


		/* function calculoPresupuesto(val) {
			var p = parseFloat($("#pcoValorAdj").val().replace(/,/g, ""));
			var pp =parseFloat($("#pcoValorFin").val().replace(/,/g, ""));
			if (pp > p){
				mostrarMensaje("El valor total finalizado no puede ser mayor al valor total adjudicado!", "ERROR");
				$("#btnGuardar").attr("disabled", true);
			}else{
				$("#btnGuardar").attr("disabled", false);
				
		}
				
			} */
		
	
	</script>
