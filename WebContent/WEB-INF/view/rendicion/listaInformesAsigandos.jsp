<%-- 
	version		: 1.0
    Document  	: listaInformesAsignados
    Created on	: 02/11/2018, 12:15:59
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
    Property   	: CPCCS
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<spring:url value="/resources/" var="urlPublic" />

<!DOCTYPE">
<html>
<div class="card-body">
	<div class="row">

		<div class="col-lg-12">
			<div class="card">
				<div class="card-body">
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="cmbPeriodo">Seleccione el periodo</label>
						</div>
						<div class="col-md-3 text-left">
							<select class="custom-select custom-select-sm" id="cmbPeriodo"
								required="required" name="cmbPeriodo" onchange="cargarTabla();">

								<c:forEach var="i" begin="${anio}" end="${anioActual-1}"
									step="1" varStatus="status">
									<c:set var="selected" value="" />
									<c:choose>
										<c:when test="${anio==i}">
											<option value="0">Seleccione...</option>
										</c:when>
									</c:choose>
									<option ${selected} value="${i}">${i}</option>
								</c:forEach>
							</select>
							<div class="invalid-feedback">Por favor seleccione el
								periodo</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="divtabla">
	<div class="card-body">
		<div class="row">

			<div class="col-lg-12">
				<div class="card">
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
					<hr />

					<table id="tablaRegistros"
						class="table table-striped table-bordered" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>Nro. de Informe</th>
								<th>Nombre Institución</th>
								<th>Ruc</th>
								<th>Fecha Asignación</th>
								<th>Asigando por</th>
								<th>Asigando a</th>
								<th>Estado</th>
								<th style="display: none;">Informe</th><!--<th>Informe</th>-->
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
</html>
<script>
	$(document).ready(function() {
		$("#divtabla").hide();

	});

	function cargarTabla() {
		$('#tablaRegistros').DataTable().clear();
		$('#tablaRegistros').DataTable().destroy();
		$("#divtabla").show();
		$("#detalleItem")
				.html(
						'<div class="mensajeInicial">Arrastre aqui un registro para revisarlo.</div>');
		var parametros = {
			"periodo" : $("#cmbPeriodo").val(),
			estado : "asignado"
		};
		$('#tablaRegistros').DataTable(
				{
					ajax : {
						data : parametros,
						url : "obtenerRegistrosInformesAsignados",
						headers : {
							"X-CSRF-TOKEN" : csrfToken
						},
						type : "POST"
					},
					dom : '<"html5buttons"B>lTfgitp',
					buttons : [ 'copyHtml5', 'csvHtml5', 'excelHtml5',
							'pdfHtml5', 'print', ],
					columns : [

					{
						data : "contador"
					}, {
						data : "inf_cod"
					}, {
						data : "inst_nom"
					}, {
						data : "inst_ruc"
					}, {
						data : "fecha"
					}, {
						data : "asigandor"
					}, {
						data : "asignado"
					},{
						data : "estado"
					}, {
						data : "informe",
						className : 'ocultar'
					} ],
					language : {
						url : "resources/json/lenguajeTablaDataTable.json"
					},
					createdRow : function(row, data, dataIndex) {
						var pagina = null;
						if (data.estado = "en trámite - admisión") {
							switch (data.informe) {
							case "6":
								pagina = "valoracionInformeFE";
								break;
							case "8":
								pagina = "valoracionInformeIESS";
								break;
							case "3":
								pagina = "valoracionInformeFEEP";
								break;
							case "1":
								pagina = "valoracionInformeGAD";
								break;
							case "2":
								pagina = "valoracionInformeGADEP";
								break;
							case "4":
								pagina = "valoracionInformeGADVinculada";
								break;
							case "7":
								pagina = "valoracionInformeMedio";
								break;
							case "5":
								pagina = "valoracionInformeES";
								break;
							default:
								pagina = null;
								break;
							}
						}else if(data.estado = "asignado"){
							switch (data.informe) {
							case "6":
								pagina = "valoracionInformeFE";
								break;
							case "8":
								pagina = "valoracionInformeIESS";
								break;
							case "3":
								pagina = "valoracionInformeFEEP";
								break;
							case "1":
								pagina = "valoracionInformeGAD";
								break;
							case "2":
								pagina = "valoracionInformeGADEP";
								break;
							case "4":
								pagina = "valoracionInformeGADVinculada";
								break;
							case "7":
								pagina = "valoracionInformeMedio";
								break;
							case "5":
								pagina = "valoracionInformeES";
								break;
							default:
								pagina = null;
								break;
							}
						}
						$(row).attr('id', data.inf_cod+("-")+parametros.periodo);
						$(row).attr('class', 'item');
						$(row).attr('data-rutaAplicacion', 'rendicion/valoracion');
						$(row).attr('data-opcion', pagina);
						$(row).attr('ondragstart', 'drag(event)');
						$(row).attr('draggable', 'true');
						$(row).attr('data-destino', 'detalleItem');
						$(row).find("td:first").css({
							"font-weight" : "bold",
							"white-space" : "nowrap"
						});
					},
				});
	
	}
</script>
