
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<%@ page session="false"%>
<spring:url value="/resources/" var="urlPublic" />
<c:set var="rutaArchivosAplicacion"
	value="<%=Constantes.RUTA_ARCHIVOS_APLICACION%>" />
<sec:authentication var="usuario" property="principal" />


<!DOCTYPE">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta name="expires" content="Wed, 01 Jan 1997 00:00:00 GMT">
</head>
<div class="card text-center mb-card15">
	<div class="card-header ">
		<h5>Credenciales de usuario</h5>
	</div>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1">
				<form:form class="needs-validation" novalidate=""
					modelAttribute="TblUsuarios" id="guardarDatosUsuario"
					data-rutaAplicacion="uath" data-opcion="guardarDatosUsuario"
					data-destino="detalleItem" data-accionEnExito="NADA">
					<input type="hidden" name="identificador" id="identificador"
						value="${identificador}">


					<div class="card">

						<h5 class="card-header text-white carHeaderBlue">Datos</h5>
						<div class="card-body">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="institucion">Cédula </label>
								</div>

								<div class="col-md-3 text-left ">
									<input type="text" class="form-control form-control-sm"
										disabled id="cedula" name="cedula" value="${identificador}" />
								</div>

							</div>
						</div>
						<div class="card-body">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="nombreUsuario" class="col-form-label">#
										Nombre de Usuario</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="text" class="form-control form-control-sm"
										id="nombreUsuario" required="required" name="nombreUsuario"
										maxlength="64" pattern="^([a-zA-Z0-9ñÑÁáÉéÍíÓóÚúÜü ])+$"
										value="${nombreUsuario}" />
									<div class="invalid-feedback">Por favor ingrese un alias
										como nombre de usuario</div>
								</div>
							</div>
						</div>
					</div>
					<p></p>
					<div class="card">

						<h5 class="card-header text-white carHeaderBlue">Cambio de
							clave</h5>
						<div class="card-body">
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="claveActual">Contraseña actual</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="password" class="form-control form-control-sm"
										id="claveActual" required="required" name="claveActual"
										minlength="6" maxlength="12"
										placeholder="Ingrese su contraseña"
										pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
									<div class="invalid-feedback">
										Su contraseña de contener entre 6 y 12 caracteres, letras
										minusculas, m
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="clave">Contraseña nueva</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="password" class="form-control form-control-sm"
										id="claveNueva" required="required" name="claveNueva"
										minlength="6" maxlength="12"
										placeholder="Ingrese la contraseña nueva"
										pattern="^(?=.*[a-z])([a-z]|[^ ]){6,12}$">
									<div class="invalid-feedback">
										Su contraseña de contener entre 6 y 12 caracteres, letras
										minusculas
									</div>
								</div>
							</div>

							<div class="form-group row">
								<div class="col-md-3 text-left">
									<label for="contrseniaConfirmacion">Repita la
										contraseña nueva</label>
								</div>
								<div class="col-md-3 text-left">
									<input type="password" class="form-control form-control-sm"
										id="confirmacionClaveNueva" required="required"
										name="confirmacionClaveNueva"
										placeholder="Confirme la contraseña" minlength="6"
										maxlength="12"
										pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%*?&.])([A-Za-z\d#$@!%*?&.]|[^ ]){6,12}$">
									<div class="invalid-feedback">
										Su contraseña de contener entre 6 y 12 caracteres, letras
										minusculas, mayusculas ,números y al algún caracter siguiente
										(<b>#$@!%*.?&</b>)
									</div>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-md-12 text-left">
									<label for="notaContrasenia"><b>NOTA: </b>Ingrese una
										nueva contraseña, la misma debe contener entre 6 y 12
										caracteres, letras minusculas, mayusculas ,números y al algún
										caracter siguiente (#$@!%*.?&)</label>
								</div>
							</div>
						</div>
					</div>

					<div class="form-group row">
						<div class="col-md-4"></div>
						<div class="col-md-4 text-center">
							<button type="submit" id="btnGuardar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar
							</button>
						</div>
						<div class="col-md-4"></div>

					</div>


				</form:form>
				<p></p>

	<div class="ibox-content">
      <div class="table-responsive">
			
			<table id="TablaUsuarioResponsable"
				class="table table-striped table-bordered" style="width: 100%">
				<thead>
					<tr>
						<th>#</th>
						<th style="font-size: x-small;">NOMBRES</th>
                        <th style="font-size: x-small;">TIPO</th> 
						<th> </th> 
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


</div>
</html>

<script type="text/javascript">
	$(document).ready(function() {
		tabla();
	});

	$("#btnGuardar").click(	function(event) {	
		var form = $("#guardarDatosUsuario")
			event.preventDefault();
			event.stopPropagation();

			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR")
			} else {
				var obj = ejecutarJson(form,
						new exitoDatosUsuario(), null, null);
			}
			form.addClass('was-validated');

		});

	function exitoDatosUsuario() {
		this.ejecutar = function(msg) {
			mostrarMensaje("Los datos han sido actualizados correctamente",
					"EXITO");
			$("#nombre").html($("#nombreUsuario").val());
		};
	}
	
	
function tabla() {
	var parametros = {
	        "codigoIntitucionAutorida" :'${codigoIntitucionAutorida}',
	        "tipoUser":'${tipoUser}'
	        };
		
		$('#TablaUsuarioResponsable').DataTable({
		ajax : {
		data:parametros,
		url : "obtenerListaResponsables",
		headers : {"X-CSRF-TOKEN" : csrfToken},
		type : "POST"	
		},
		order : [ 0, "asc" ],		
		bDestroy : true,	
		columns : [
			{data: "" ,"render": function (data, type, full, meta) {
				 return  meta.row + 1;
   			 }},
			{data : "nombre"},		
   			{data : "tipo"},
   			{ data: "" ,"render": function (data, type, full, meta) {
		      data = '<button type="button" id="Editar" class="Editar btn btn-link"  onclick="ActualizarUSU(this)" title="Actualizar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-big;"><i class="fas fa-address-card fa-lg"></i></button>';   
						//data = '<i class="fas fa-ban"></i>'; 
   			  return data; 
   			}}
			
			],	
			language : {
				url : "resources/json/lenguajeTablaDataTable.json"
			},
		
			createdRow : function(row, data, dataIndex) {
			   	$(row).attr('id', data.codigo +":"+ data.categoria);			   	
				//$(row).attr('class', 'item');
			    $(row).attr('data-rutaAplicacion', 'uath');			
				$(row).attr('data-opcion', 'EditarDatosUsuario');
				$(row).attr('ondragstart', 'drag(event)');
				$(row).attr('draggable', 'false');
				$(row).attr('data-destino', 'detalleItem');
				$(row).find("td:eq(4)").attr('align','center');
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
	
function ActualizarUSU(element) {	
	$('#TablaUsuarioResponsable tbody').on('click', 'tr', function() {
		abrir($(this), "#" + $(this).attr("data-destino"), false);
	});
		
}
</script>
