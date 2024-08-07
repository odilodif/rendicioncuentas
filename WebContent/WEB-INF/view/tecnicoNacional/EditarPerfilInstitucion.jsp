<%-- 
	version		: 1.0
    Document  	: EditarPerfilInstitucion
    Created on	: 03/02/2021; 14:23:30
    Author		: Carlos Morocho
    Mail		: carlosmorocho339@gmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<spring:url value="/resources/" var="urlPublic" />
<sec:authentication var="usuario" property="principal" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/rendicion.css">
</head>
<div class="card text-center mb-card15">
	<h5 class="card-header text-white carHeaderBlue">Editar datos
		Usuario</h5>
	<div class="card-body">

		<div class="card card-secondary">
			<form:form class="needs-validation" novalidate=""
				modelAttribute="TblUsuario" id="ActualizarPerfil"
				data-rutaAplicacion="tecnicoNacional"
				data-opcion="ActualizarDatosPerfil" data-destino="detalleItem"
				data-accionEnExito="ACTUALIZAR">

				<input type="hidden" id="codigoUser" name="codigoUser"
					value="${codigoUser}">
				<input type="hidden" id="codigotipo" name="codigotipo"
					value="${codigotipo}">
				<input type="hidden" id="tipo" name="tipo" value="${tipo}">
				<input type="hidden" id="emailIdentificador"
					name="emailIdentificador" value="${correo}">

				<div class="card">
					<br>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="NombreResponRegis">Nombre del responsable de
								llenar el informe / Autoridad:</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="NombreResponRegis"
								required="required" name="NombreResponRegis"
								placeholder="INGRESE NOMBRES Y PELLIDOS" minlength="3"
								maxlength="64" value="${nombres}"
								pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
							<div class="invalid-feedback">Por favor ingrese sus
								Apellidos y Nombres</div>
							<!-- <div class="valid-tooltip">todo bien</div> -->
						</div>
						<div class="col-md-1 text-left"></div>

						<div class="col-md-2 text-left">
							<label for="CargoResponRegis">Cargo del responsable de
								llenar el informe / Dignidad:</label>
						</div>
						<c:choose>
							<c:when test="${tipo=='autoridad'}">
								<div class="col-md-3 text-left ">
									<select class="custom-select custom-select-sm"
										id="CargoResponRegis" name="CargoResponRegis"
										required="required">
										<option value="">Seleccione...</option>
										<option value="VOCALES DE GAD PARROQUIAL">VOCALES DE
											GAD PARROQUIAL</option>
										<option
											value="VICEPRESIDENTA/ VICEPRESIDENTE DE GAD PARROQUIAL">VICEPRESIDENTA/
											VICEPRESIDENTE DE GAD PARROQUIAL</option>
										<option value="PRESIDENTA/ PRESIDENTE DE GAD PARROQUIAL">PRESIDENTA/
											PRESIDENTE DE GAD PARROQUIAL</option>
										<option value="CONSEJALAS/ CONCEJALES RURALES">CONSEJALAS/
											CONCEJALES RURALES</option>
										<option value="CONSEJALAS/CONCEJALES URBANOS">CONSEJALAS/CONCEJALES
											URBANOS</option>
										<option value="VICEALCALDESA/ VICEALCALDE">VICEALCALDESA/
											VICEALCALDE</option>
										<option value="ALCALDESA/ ALCALDE">ALCALDESA/ ALCALDE</option>
										<option value="VICEPREFECTA/ VICEPREFECTO">VICEPREFECTA/
											VICEPREFECTO</option>
										<option value="PREFECTA/PREFECTO">PREFECTA/PREFECTO</option>
										<option value="ASAMBLEÍSTA NACIONAL">ASAMBLEÍSTA
											NACIONAL</option>
										<option value="ASAMBLEÍSTA PROVINCIAL">ASAMBLEÍSTA
											PROVINCIAL</option>
										<option value="ASAMBLEÍSTA POR CIRCUNSCRIPCIÓN TERRITORIAL">ASAMBLEÍSTA
											POR CIRCUNSCRIPCIÓN TERRITORIAL</option>
										<option value="ASAMBLEÍSTA REPRESENTANTE EXTRANJERO">ASAMBLEÍSTA
											REPRESENTANTE EXTRANJERO</option>
										<option value="PARLAMENTARIA / PARLAMENTARIO ANDINO">PARLAMENTARIA
											/ PARLAMENTARIO ANDINO</option>
										<option value="CONSEJERA/ CONSEJERO DEL CPCCS">CONSEJERA/
											CONSEJERO DEL CPCCS</option>
										<option value="VICEPRESIDENTE DE LA REPÚBLICA">VICEPRESIDENTE
											DE LA REPÚBLICA</option>
										<option value="PRESIDENTE DE LA REPÚBLICA">PRESIDENTE
											DE LA REPÚBLICA</option>

									</select>
									<div class="invalid-feedback">Por favor seleccione el
										ámbito</div>
								</div>

							</c:when>
							<c:otherwise>

								<div class="col-md-3 text-left ">
									<input type="text" style="text-transform: uppercase;"
										class="form-control form-control-sm" id="CargoResponRegis"
										required="required" name="CargoResponRegis"
										placeholder="INGRESE EL CARGO" minlength="3" maxlength="64"
										value="${cargo}">

									<div class="invalid-feedback">Por favor ingrese el Cargo</div>
								</div>
							</c:otherwise>

						</c:choose>


					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="CorreoResponRegis"> Email de Notificación: <span
								class="text-muted"> (Usuario)</span>
							</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="email" class="form-control form-control-sm"
								id="CorreoResponRegis" required="required" value="${correo}"
								name="CorreoResponRegis" placeholder="INGRESE SU EMAIL">

							<div class="invalid-feedback">Por favor ingrese una
								dirección de correo válida</div>
						</div>

						<div class="col-md-1"></div>
						<div class="col-md-2 text-left">
							<label for="CedulaResponRegis" class="col-form-label">Cédula
								de Ciudadania:</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" class="form-control form-control-sm"
								id="CedulaResponRegis" required="required" value="${cedula}"
								name="CedulaResponRegis" placeholder="9999999999" maxlength="10"
								pattern="^([a-zA-Z0-9]{10,10})+$"
								onchange="validarDocumento(this.value)" />
							<div class="invalid-feedback">Por favor ingrese su # de
								cédula</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="celularp" class="col-form-label">Celular:</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" class="form-control form-control-sm"
								id="celularp" required="required"
								value="${celular}"
								name="celularp" placeholder="(00) 0000-0000"
								maxlength="14" pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
								data-inputmask="'mask': '(99) 9999-9999'">
							<div class="invalid-feedback">Por favor ingrese su celular</div>
						</div>
						<div class="col-md-1"></div>
						<c:choose>
							<c:when test="${tipo=='institucion'}">
						<div class="col-md-2 text-left">
							<label for="fechaDesignacion">Fecha de Designación:</label>
						</div>
						<div class="col-md-3 text-left">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i>
								</span> <input type="text" required="required" id="fechaDesignacion"
									name="fechaDesignacion" class="form-control form-control-sm"
									value="${fechaDesignacion}" maxlength="10"
									pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
								<div class="invalid-feedback">Por favor ingrese la fecha
									con formato dd/mm/aaaa</div>
							</div>
						</div>
						</c:when>
						</c:choose>

					</div>

					<div class="form-group row">
					<%-- 	<div class="col-md-2 text-left">
							<label for="NombreAbuelaResponRegistro" class="col-form-label">Nombre
								Abuela Materna:</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm"
								id="NombreAbuelaResponRegistro" required="required"
								name="NombreAbuelaResponRegistro"
								placeholder="INGRESE EL NOMBRE DE SU ABUELA MATERNA"
								maxlength="256" value="${nombreAbuela}"
								pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$">
							<div class="invalid-feedback">Por favor ingrese el dato
								solicitado</div>
						</div>
						<div class="col-md-1"></div> --%>
						<div class="col-md-2 text-left">
							<label for="fechaNacimiento">Fecha de Nacimiento:</label>
						</div>
						<div class="col-md-3 text-left">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i>
								</span> <input type="text" required="required" id="fechaNacimiento"
									name="fechaNacimiento" class="form-control form-control-sm"
									value="${fechaNaciomiento}" maxlength="10"
									pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
								<div class="invalid-feedback">Por favor ingrese su fecha
									de nacimiento con formato dd/mm/aaaa</div>
							</div>
						</div>

					</div>
										
					
					
					
					
					<div class="form-group row">
						<div class="col-md-12 text-center">
							<hr>
							<label for="clave text-left">*La contraseña debe contener
								entre 6 y 12 caracteres, se recomienda que tenga letras
								minúsculas, mayúsculas, números y al algún carácter siguiente (<b>#$@!%*.?</b>),
								Ejemplo: ProcesoRC2021*
							</label>
						</div>
					</div>

					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="passwordResponRegis">Cree su contraseña:</label>
						</div>
						<div class="col-md-9 text-left">
							<input type="text" class="form-control form-control-sm"
								id="passwordResponRegis" required="required"
								name="passwordResponRegis" minlength="6" maxlength="12"
								value="${passwordResponRegis}"
								placeholder="INGRESE SU CONTRASEÑA">
							<div class="invalid-feedback">
								Su contraseña no cumple con: tener de 6 a 12 caracteres, letras
								minúsculas, mayúsculas, números y al algún carácter siguiente (<b>#$@!%*.?</b>)
								Ejemplo: Consejo2021@
							</div>
						</div>
					</div>

					<c:choose>
						<c:when test="${tipo == 'autoridad'}">
						<hr/>

									<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="provincia">Provincia</label>
											</div>
											<div class="col-md-2 text-left">
												<select class="custom-select custom-select-sm"
													id="provincia2" required="required" name="provincia2">
													<option value="">Seleccione...</option>
													<c:forEach var="listadoLocalizacionProvincia"
														items="${listadoLocalizacionProvincia}">
														<option
															value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
													</c:forEach>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													provincia</div>
											</div>
											<div class="col-md-1 text-left">
												<label for="canton">Cantón</label>
											</div>
											<div class="col-md-2 text-left">
												<select class="custom-select custom-select-sm" id="canton"
													required="required" name="canton">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													cantón</div>
											</div>
											<div class="col-md-2 text-left">
												<label for="parroquia">Parroquia</label>
											</div>
											<div class="col-md-2  text-left">
												<select class="custom-select custom-select-sm"
													required="required"
													id="parroquia" name="parroquia">
													<option value="">Seleccione...</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione la
													parroquia</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="direccion" class="col-form-label">Dirección</label>
											</div>
											<div class="col-md-9 text-left">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm" id="direccion"
													required="required" name="direccion"
													placeholder="Ingrese su dirección" maxlength="256" value="${tblAutoridad.direccion}"
													pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü.#-/°0-9 ]+$">
												<div class="invalid-feedback">Por favor ingrese la
													dirección o no tiene el minimo de caracteres permitidos</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="web">Página Web o red social</label>
											</div>
											<div class="col-md-9">
												<input type="url" 
													class="form-control form-control-sm " id="web"
													required="required" name="web"
													placeholder="Dirección de página web" 
													value="${tblAutoridad.web}" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="telefono" class="col-form-label">Teléfono<span class="text-muted"> (Opcional)</span>
													
												</label>
											</div>
											<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="telefono" name="telefono" placeholder="(00) 000-0000"
													maxlength="13" value="${tblAutoridad.telefono}"
													pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
													data-inputmask="'mask': '(99) 999-9999'">
												<div class="invalid-feedback">Por favor ingrese su
													teléfono</div>
											</div>
										</div>
										
										<div class="form-group row">
										    <div class="col-md-2 text-left">
												<label for="dignidad">Institución en la que ejerce la dignidad:</label>
											</div>
											<div class="col-md-9">
												<input type="text" style="text-transform: uppercase;"
													class="form-control form-control-sm " id="institucion_dignidad"
													required="required" name="institucion_dignidad"
													placeholder="Nombre de la institución en la que ejerce la diginidad" maxlength="64"
													value="${tblAutoridad.institucionDignidad }" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
												<div class="invalid-feedback col-md-6 text-left">Por
													favor ingrese la dignidad</div>
											</div>
										</div>
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="ambito">Ámbito </label>
											</div>
											<div class="col-md-3  text-left">
												<select class="custom-select custom-select-sm" id="ambito"
													name="ambito" required="required">
													<option value="">Seleccione...</option>
													<option value="NACIONAL">Nacional</option>
													<option value="PROVINCIAL">Provincial</option>
													<option value="DISTRITO METROPOLITANO">Distrito Metropolitano</option>
													<option value="CANTONAL">Cantonal</option>
													<option value="PARROQUIAL">Parroquial</option>
													<option value="EXTERIOR">Exterior</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													ámbito</div>
											</div>
										</div>
										
										<div class="form-group row">
											<div class="col-md-2 text-left">
												<label for="ambito">Tipo de Autoridad </label>
											</div>
											<div class="col-md-3  text-left">
												<select class="custom-select custom-select-sm" id="tipoAutoridad"
													name="tipoAutoridad" required="required">
													<option value="">Seleccione...</option>
													<option value="PRINCIPAL">PRINCIPAL</option>
													<option value="SUPLENTE PRINCIPALIZADO">SUPLENTE PRINCIPALIZADO</option>
												</select>
												<div class="invalid-feedback">Por favor seleccione el
													ámbito</div>
											</div>
										</div>		
							<hr />
					    </c:when>
					</c:choose>	
					

				</div>
				<button type="submit" id="btnRegistro"
					class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
			</form:form>
		</div>





	</div>


</div>


</html>
<script src="${urlPublic}js/rendicion.ingreso.js"></script>
<script>

$(document).ready(function() {	

	construirValidador();
	

	cargarValorComboPorDefecto("provincia2", '${tblAutoridad.provincia}');
	cargarValorComboPorDefecto("ambito", '${tblAutoridad.ambito}');
	cargarValorComboPorDefecto("tipoAutoridad", '${tblAutoridad.tipoAutoridad}');

	if('${tipo}'=='autoridad'){
		cargarValorComboPorDefecto("CargoResponRegis", '${cargo}');

		}

	var f = new Date();
	var dia1 ="01";
	var mes1 ="01";
	var dia31 ="31";
	var mes12 ="12";
	var anioIcio = f.getFullYear()-70;
	
	var anioFin = f.getFullYear()-20;
	
	
	var fechaInicio=(dia1 + "/" + mes1 + "/" + anioIcio);

	var  fechaFin=(dia31 + "/" + mes12 + "/" + anioFin);
	var fechaFin2= (f.getDate()+ "/" + (f.getMonth()+1) + "/" + f.getFullYear());
	
$('#fechaNacimiento').datepicker({
	  forceParse: true,
	  todayBtn: false
}).datepicker('setStartDate', fechaInicio);
	
$('#fechaNacimiento').datepicker({

}).datepicker('setEndDate', fechaFin);


$('#fechaDesignacion').datepicker({
	  forceParse: true,
	  todayBtn: false
}).datepicker('setStartDate', fechaInicio);
$('#fechaDesignacion').datepicker({
	useCurrent: false,
    language: "es",
    autoclose: true,
    todayHighlight: true
}).datepicker('setEndDate', fechaFin2);

if('${provincia2}'!=null){
    
	scanton ='0';
		scanton = '<option value="">Seleccione...</option>';
		<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
		      if ($("#provincia").val()=="${listadoLocalizacionCanton.idLocalizacionPadre}"){
		      	scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
		      }
		</c:forEach>
		$('#canton').html(scanton);
		$('#parroquia').html('<option value="">Seleccione...</option>');

		cargarValorComboPorDefecto("canton",'${tblAutoridad.canton}');
		if('${canton}'!=null){
			sparroquia = '0';
			sparroquia = '<option value="">Seleccione...</option>';
			<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
			if ($("#canton").val() == "${listadoLocalizacionParroquia.idLocalizacionPadre}") {
				sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
			}
			</c:forEach>
			$('#parroquia').html(sparroquia);			
			cargarValorComboPorDefecto("parroquia",'${tblAutoridad.parroquia}');
 		}
     }

});


$("#provincia2").change(
		function() {
			scanton = '0';
			scanton = '<option value="">Seleccione...</option>';
			<c:forEach var="listadoLocalizacionCanton" items="${listadoLocalizacionCanton}">
			if ($("#provincia2").val() == "${listadoLocalizacionCanton.idLocalizacionPadre}") {
				scanton += '<option value="${listadoLocalizacionCanton.idLocalizacion}">${listadoLocalizacionCanton.nombre}</option>';
			}
			</c:forEach>
			$('#canton').html(scanton);
			$('#parroquia').html(
					'<option value="">Seleccione...</option>');
		}
		
		);
$("#canton").change(
		function() {
			sparroquia = '0';
			sparroquia = '<option value="">Seleccione...</option>';
			<c:forEach var="listadoLocalizacionParroquia" items="${listadoLocalizacionParroquia}">
			if ($("#canton").val() == "${listadoLocalizacionParroquia.idLocalizacionPadre}") {
				sparroquia += '<option value="${listadoLocalizacionParroquia.idLocalizacion}">${listadoLocalizacionParroquia.nombre}</option>';
			}
			</c:forEach>
			$('#parroquia').html(sparroquia);
		});


$("#CorreoResponRegis").change(function(event) {	
	 var correo = $("#CorreoResponRegis").val().toLowerCase();	 
	 var codigo =$('#codigoUser').val();
	  $.ajax({
     url: 'ValidarUsuarioPerfil',
     headers: {"X-CSRF-TOKEN": csrfToken},
     type: "POST",
     dataType: 'json',
     data: {correo: correo,codigo:codigo },
     success: function (result) {
   	  if(result.valida ==="nuevo"){   
   		  mostrarMensaje("Ususario disponible!","EXITO-NOTIFICACION","3000"); 
     		
     		}
   	  else if(result.valida ==="existe"){   
   		  mostrarMensaje("Email ya registrado, ingrese uno diferente!","ERROR-NOTIFICACION","3000"); 
   		  $("#CorreoResponRegis").val("");
     		}
     	  else if(result.valida ==="vacio"){   
   		  mostrarMensaje("Ingrese email de usuario !","ERROR-NOTIFICACION","3000"); 
     		
     		}
	  
     },
     error: function (result) {       
   		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
   		

     }
 });

});

$("#btnRegistro").click(function(event) {
	//$('#ActualizarPerfil').attr('data-opcion','ActualizarDatosPerfil');	
		var form = $("#ActualizarPerfil")	
		event.preventDefault();
		event.stopPropagation();
		if (form[0].checkValidity() === false) {
			mostrarMensaje(
					"Por favor ingrese toda la información solicitada!",
					"ERROR");
		} else {
			
				ejecutarJson(form);	
				//abrir($("#Frm_ListaRegistro"),event,false);
		}
		form.addClass('was-validated');
	
	});


validarDocumento  = function() {          		
	 numero = $("#CedulaResponRegis").val();
		      var suma = 0;      
	      var residuo = 0;      
	      var pri = false;      
	      var pub = false;            
	      var nat = false;      
	      var numeroProvincias = 24;                  
	      var modulo = 11;
	                  
	      /* Verifico que el campo no contenga letras */                  
	      var ok=1;
	      for (i=0; i<numero.length && ok==1 ; i++){
	         var n = parseInt(numero.charAt(i));
	         if (isNaN(n)) ok=0;
	      }
	      if (ok==0){
	         mostrarMensaje("No puede ingresar caracteres aquí",	"ERROR");        
	         $("#CedulaResponRegis").val("");
	         return false;
	      }
	      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
	      if (numero.length < 10 ){              
	         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
	         $("#CedulaResponRegis").val("");
	         return false;
	      }

	      if (numero=="1212121212" || numero=="1010101010" || numero=="2222222222" || numero=="1414141414" || numero=="1616161616" || numero=="2424242424" || numero=="2020202020"  ) {
				 mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");	
				 $("#CedulaResponRegis").val("");
		     	 return false;
	      }
		     
	      /* Los primeros dos digitos corresponden al codigo de la provincia */
	      provincia = numero.substr(0,2);      
	      if (provincia < 1 || provincia > numeroProvincias){           
	         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
	         $("#CedulaResponRegis").val("");
	    	 return false;       
	      }

	      /* Aqui almacenamos los digitos de la cedula en variables. */
	      d1  = numero.substr(0,1);         
	      d2  = numero.substr(1,1);         
	      d3  = numero.substr(2,1);         
	      d4  = numero.substr(3,1);         
	      d5  = numero.substr(4,1);         
	      d6  = numero.substr(5,1);         
	      d7  = numero.substr(6,1);         
	      d8  = numero.substr(7,1);         
	      d9  = numero.substr(8,1);         
	      d10 = numero.substr(9,1);                
	         
	      /* El tercer digito es: */                           
	      /* 9 para sociedades privadas y extranjeros   */         
	      /* 6 para sociedades publicas */         
	      /* menor que 6 (0,1,2,3,4,5) para personas naturales */ 

	      if (d3==7 || d3==8){           
	         mostrarMensaje("El tercer dígito ingresado es inválido!",	"ERROR");                  
	         $("#CedulaResponRegis").val("");
	         return false;
	      }         
	         
	      /* Solo para personas naturales (modulo 10) */         
	      if (d3 < 6){           
	         nat = true;            
	         p1 = d1 * 2;  if (p1 >= 10) p1 -= 9;
	         p2 = d2 * 1;  if (p2 >= 10) p2 -= 9;
	         p3 = d3 * 2;  if (p3 >= 10) p3 -= 9;
	         p4 = d4 * 1;  if (p4 >= 10) p4 -= 9;
	         p5 = d5 * 2;  if (p5 >= 10) p5 -= 9;
	         p6 = d6 * 1;  if (p6 >= 10) p6 -= 9; 
	         p7 = d7 * 2;  if (p7 >= 10) p7 -= 9;
	         p8 = d8 * 1;  if (p8 >= 10) p8 -= 9;
	         p9 = d9 * 2;  if (p9 >= 10) p9 -= 9;             
	         modulo = 10;
	      }         

	      /* Solo para sociedades publicas (modulo 11) */                  
	      /* Aqui el digito verficador esta en la posicion 9, en las otras 2 en la pos. 10 */
	      else if(d3 == 6){           
	         pub = true;             
	         p1 = d1 * 3;
	         p2 = d2 * 2;
	         p3 = d3 * 7;
	         p4 = d4 * 6;
	         p5 = d5 * 5;
	         p6 = d6 * 4;
	         p7 = d7 * 3;
	         p8 = d8 * 2;            
	         p9 = 0;            
	      }         
	         
	      /* Solo para entidades privadas (modulo 11) */         
	      else if(d3 == 9) {           
	         pri = true;                                   
	         p1 = d1 * 4;
	         p2 = d2 * 3;
	         p3 = d3 * 2;
	         p4 = d4 * 7;
	         p5 = d5 * 6;
	         p6 = d6 * 5;
	         p7 = d7 * 4;
	         p8 = d8 * 3;
	         p9 = d9 * 2;            
	      }
	                
	      suma = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9;                
	      residuo = suma % modulo;                                         

	      /* Si residuo=0, dig.ver.=0, caso contrario 10 - residuo*/
	      digitoVerificador = residuo==0 ? 0: modulo - residuo;                

	      /* ahora comparamos el elemento de la posicion 10 con el dig. ver.*/                         
	      if (pub==true){           
	         if (digitoVerificador != d9){                          
	            mostrarMensaje("El ruc de la empresa del sector público es incorrecto!",	"ERROR");         
	            $("#CedulaResponRegis").val("");
	            return false;
	         }                  
	         /* El ruc de las empresas del sector publico terminan con 0001*/         
	         if ( numero.substr(9,4) != '0001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }         
	      else if(pri == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }         
	         if ( numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }      

	      else if(nat == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }         
	         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
	            $("#CedulaResponRegis").val("");
	            return false;
	         }
	      }      
	      mostrarMensaje("El dato ingresado es correto!",	"EXITO");
	      return true; 
}




</script>