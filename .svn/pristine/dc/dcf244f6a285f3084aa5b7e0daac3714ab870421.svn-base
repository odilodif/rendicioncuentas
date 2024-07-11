<%-- 
	version		: 1.0
    Document  	: Frm_ImplementacionGads
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

<div class="card  mb-card20">

	<c:choose>
		<c:when test="${inf_estado=='activo'}">
			<div class="card card-secondary">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblImplementacionPresupuesto"
					id="ImplementacionPresupuesto" data-rutaAplicacion="rendicion"
					data-opcion="guardarImplementacionPre"
					data-accionEnExito="ACTUALIZAR">
					<h5 class="card-header text-white carHeaderBlue" align="center">IMPLEMENTACIÓN
						DE POLÍTICAS PÚBLICAS GRUPOS DE ATENCIÓN PRIORITARIA: PRESUPUESTO</h5>
					<input type="hidden" id="infCod" name="infCod" value="${inf_Cod}">
					<div class="col-md-12 text-left">

						<table id="ImplePresuGad" class="table registros table-bordered">
							<thead>
							<tr>
								<td class="tablaingreso">SE ASIGNÓ UN PORCENTAJE DE LOS
									INGRESOS TRIBUTARIOS DEL GAD A LOS GRUPOS DE ATENCIÓN
									PRIORITARIA</td>
								<td class="tablaingreso">IDENTIFIQUE A QUÉ GRUPO DE
									ATENCIÓN PRIORITARIA</td>
								<td class="tablaingreso">QUÉ PORCENTAJE SE ASIGNÓ A LOS
									DISTINTOS GRUPOS</td>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td style="vertical-align: middle; width: 300px;" rowspan="13"
									align="center"><select
									class="custom-select custom-select-sm" id="seleccion"
									name="seleccion" required="required">
										<option value="">Seleccione...</option>
										<option value="SI">SI</option>
										<option value="NO">NO</option>
								</select></td>
								<td><label for="uno"><input type="checkbox"
										class="case" id="cbox1" name="cbox1"
										value="Personas adultas Mayores"> Personas adultas
										Mayores</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number" onkeypress="javascript:return validarnro(event);"
									id="porcentaje1" name="porcentaje1" min="1" max="100"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="dos"><input type="checkbox"
										class="case" id="cbox2" name="cbox2"
										value="Niñas, niños y adolecentes"> Niñas, niños y
										adolecentes</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje2" name="porcentaje2" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="tres"><input type="checkbox"
										class="case" id="cbox3" name="cbox3" value="Jóvenes">
										Jóvenes</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje3" name="porcentaje3" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="cuatro"><input type="checkbox"
										class="case" id="cbox4" name="cbox4"
										value="Mujeres Embarazadas"> Mujeres Embarazadas</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje4" name="porcentaje4" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="cinco"><input type="checkbox"
										class="case" id="cbox5" name="cbox5"
										value="Personas con Discapacidad"> Personas con
										Discapacidad</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje5" name="porcentaje5" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="seis"><input type="checkbox"
										class="case" id="cbox6" name="cbox6" value="Movilidad Humana">
										Movilidad Humana</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje6" name="porcentaje6" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="siete"><input type="checkbox"
										class="case" id="cbox7" name="cbox7"
										value="Personas Privadas de Libertad"> Personas
										Privadas de Libertad</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje7" name="porcentaje7" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="ocho"><input type="checkbox"
										class="case" id="cbox8" name="cbox8"
										value="Personas con Enfermedades Catastróficas">
										Personas con Enfermedades Catastróficas</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje8" name="porcentaje8" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="nueve"><input type="checkbox"
										class="case" id="cbox9" name="cbox9"
										value="Personas Usuarias y Consumidoras"> Personas
										Usuarias y Consumidoras</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje9" name="porcentaje9" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="diez"><input type="checkbox"
										class="case" id="cbox10" name="cbox10"
										value="Personas en Situación de Riesgos"> Personas en
										Situación de Riesgos</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje10" name="porcentaje10" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="once"><input type="checkbox"
										class="case" id="cbox11" name="cbox11"
										value="Víctima de violencia Doméstica y Sexual">
										Víctima de violencia Doméstica y Sexual</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje11" name="porcentaje11" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="doce"><input type="checkbox"
										class="case" id="cbox12" name="cbox12"
										value="Maltrato Infantil"> Maltrato Infantil</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje12" name="porcentaje12" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							<tr>
								<td><label for="trece"><input type="checkbox"
										id="cbox13" name="cbox13" class="case"
										value="Desastres Naturales o Antropogénicos">
										Desastres Naturales o Antropogénicos</label>
									<div class="invalid-feedback">Marque el check</div></td>
								<td style="width: 150px;"><input type="number"
									id="porcentaje13" name="porcentaje13" min="1" max="100" onkeypress="javascript:return validarnro(event);"
									step="0.01" class="form-control form-control-sm number">
									<div class="invalid-feedback">Ingrese el porcentaje</div></td>
							</tr>
							</tbody>

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
		<c:choose>
			<c:when test="${infestadoinforme=='activo'}">
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
		      </c:when>
			</c:choose>	
			<table id="TablaImplePresu"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th>SE ASIGNÓ UN PORCENTAJE DE LOS INGRESOS TRIBUTARIOS DEL GAD A LOS GRUPOS DE ATENCIÓN PRIORITARIA</th>
						<th>INDIQUE EL % DEL PRESUPUESTO TOTAL</th>
						<th>IDENTIFIQUE A QUÉ GRUPO DE ATENCIÓN PRIORITARIA</th>
						<th>QUÉ PORCENTAJE SE ASIGNÓ A LOS DISTINTOS GRUPOS</th>
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
		$(".case").prop("disabled", "disabled");
		$(".number").prop("disabled", "disabled");
		if ('${inf_estado}' == 'matriz') {
			tabla();			
		}
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
		
	});

	$("#seleccion").change(function() {
		var seleccion = $("#seleccion").val();
		if (seleccion == "SI") {
			$(".case").removeAttr("disabled");
			$(".number").removeAttr("disabled");

		} else if (seleccion == "NO") {
			$(".number").removeAttr("required");
			$(".case").prop("checked", false);
			$(".number").val("");
			$(".case").prop("disabled", "disabled");
			$(".number").prop("disabled", "disabled");

		} else {
			$(".number").removeAttr("required");
			$(".case").prop("checked", false);
			$(".number").val("");
			$(".case").prop("disabled", "disabled");
			$(".number").prop("disabled", "disabled");
			mostrarMensaje("Seleccione una opcion", "ERROR-NOTIFICACION");

		}

	});
	

	$("#cbox1").change(function() {

		if ($("#cbox1")[0].checked == true) {
			$("#porcentaje1").prop("required", true);
		} else {
			$("#porcentaje1").removeAttr("required");
		}
	});
	$("#cbox2").change(function() {

		if ($("#cbox2")[0].checked == true) {
			$("#porcentaje2").prop("required", true);
		} else {
			$("#porcentaje2").removeAttr("required");
		}
	});

	$("#cbox3").change(function() {

		if ($("#cbox3")[0].checked == true) {
			$("#porcentaje3").prop("required", true);
		} else {
			$("#porcentaje3").removeAttr("required");
		}
	});

	$("#cbox4").change(function() {

		if ($("#cbox4")[0].checked == true) {
			$("#porcentaje4").prop("required", true);
		} else {
			$("#porcentaje4").removeAttr("required");
		}
	});

	$("#cbox5").change(function() {

		if ($("#cbox5")[0].checked == true) {
			$("#porcentaje5").prop("required", true);
		} else {
			$("#porcentaje5").removeAttr("required");
		}
	});

	$("#cbox6").change(function() {

		if ($("#cbox6")[0].checked == true) {
			$("#porcentaje6").prop("required", true);
		} else {
			$("#porcentaje6").removeAttr("required");
		}
	});

	$("#cbox7").change(function() {

		if ($("#cbox7")[0].checked == true) {
			$("#porcentaje7").prop("required", true);
		} else {
			$("#porcentaje7").removeAttr("required");
		}
	});
	$("#cbox8").change(function() {

		if ($("#cbox8")[0].checked == true) {
			$("#porcentaje8").prop("required", true);
		} else {
			$("#porcentaje8").removeAttr("required");
		}
	});

	$("#cbox9").change(function() {

		if ($("#cbox9")[0].checked == true) {
			$("#porcentaje9").prop("required", true);
		} else {
			$("#porcentaje9").removeAttr("required");
		}
	});

	$("#cbox10").change(function() {

		if ($("#cbox10")[0].checked == true) {
			$("#porcentaje10").prop("required", true);
		} else {
			$("#porcentaje10").removeAttr("required");
		}
	});

	$("#cbox11").change(function() {

		if ($("#cbox11")[0].checked == true) {
			$("#porcentaje11").prop("required", true);
		} else {
			$("#porcentaje11").removeAttr("required");
		}
	});

	$("#cbox12").change(function() {

		if ($("#cbox12")[0].checked == true) {
			$("#porcentaje12").prop("required", true);
		} else {
			$("#porcentaje12").removeAttr("required");
		}
	});

	$("#cbox13").change(function() {

		if ($("#cbox13")[0].checked == true) {
			$("#porcentaje13").prop("required", true);
		} else {
			$("#porcentaje13").removeAttr("required");
		}
	});

	$("#btnGuardarI").click(function(event) {
						//$('#autCodigo').attr('data-opcion',	'guardarRegistroPeriodo');
		var form = $("#ImplementacionPresupuesto")
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje("Por favor ingrese toda la información solicitada!",	"ERROR");
			} else {
				var seleccion = $("#seleccion").val();
				if (seleccion == "SI") {
				if ($('input[type=checkbox]:checked').length === 0) {
				mostrarMensaje("Debe seleccionar al menos un valor","ERROR-NOTIFICACION");

				} else {
					ejecutarJson(form);
				 	}
				} else {
					ejecutarJson(form);

				      }

				}
			form.addClass('was-validated');

	});

	function tabla() {
		var parametros = {"infCod" : '${inf_Cod}'};
		$('#TablaImplePresu').DataTable({
		ajax : {
		data : parametros,
		url : "obtenerImpletPresu",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	},
		order : [ 0, "asc" ],	
		bDestroy : true,	
		columns : [
			{data : "contador"},
			{data : "seleccion"},
			{data : "totalPorcentaje"}, 
			{data : "grupo"},
			{data : "PorsentajeGrupo"}, 
			{ data: "" ,"render": function (data, type, full, meta) {
			    if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_eliminar btn _eliminarColor" data-toggle="modal" data-target="#modalEliminar" onclick="Eliminar(this)" title="Eliminar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Eliminar</button>';    
	             }
                return data;
            }}
			],	
			
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
				$(row).attr('id', data.imple_cod);				
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:first").css({
					"font-weight" : "bold",
					"white-space" : "nowrap",				
				});
				$(row).find("td:eq(5)").css({
					"vertical-align" : "middle",									
				});		
		
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
		        data: {codigo: codigo,tabla:'esq_rendicioncuentas.tbl_implementacion_presupuesto',campo:'imple_cod'},
		        success: function (msg) {
		            if (msg.estado == "exito") {
                             mostrarMensaje(msg.mensaje, "EXITO");
                             var td = element.parentNode;
                             var tr = td.parentNode;
                             var table = tr.parentNode;      
                             table.removeChild(tr);
                             var nFilas = $("#TablaImplePresu tr").length-1;
                           
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