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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 								<option value="" selected="selected">Seleccione...</option>
								<c:forEach var="anio" items="${anios}">
									<option ${selected} value="${anio}">${anio}</option>
								</c:forEach>
								
							</select>
							<div class="invalid-feedback">Por favor seleccione el periodo</div>
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
									data-destino="detalleItem">
									<c:if test="${a[2]=='_seleccionar'}">
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
								<th>Estado</th>
								<th style="display: none;">Informe</th>
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
