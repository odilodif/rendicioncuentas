<%-- 
	version		: 1.0
    Document  	: Crear_Perfiles
    Created on	: 30 mar. 2021; 10:24:42
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
<link rel="stylesheet" href="${urlPublic}css/rendicion.ingreso.css">
<link rel="stylesheet" href="${urlPublic}css/rendicion.css">
</head>

<div class="card text-center mb-card20">
	<h5 class="card-header text-white carHeaderBlue">Editar datos
		Usuario</h5>
	<div class="card-body">

		<div class="card card-secondary">
			<form:form class="needs-validation" novalidate=""
				modelAttribute="TblUsuario" id="CrearPerfil"
				data-rutaAplicacion="tecnicoNacional"
				data-opcion="GuardarCrearPerfil" data-destino="detalleItem"
				data-accionEnExito="ACTUALIZAR">
				<input type="hidden" id="idUser" name="idUser"
							value="${DatosUsuario.idUser}">

				<div class="card">
					<br>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="Nombres">Nombre y Apellido</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="nombre"
								required="required" name="nombre" placeholder="NOMBRE Y PELLIDO"
								minlength="3" maxlength="64" value="${DatosUsuario.nombre}"
								pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
							<div class="invalid-feedback">Ingrese Nombre y Apellido</div>
							<!-- <div class="valid-tooltip">todo bien</div> -->
						</div>
						<div class="col-md-1 text-left"></div>
						<div class="col-md-2 text-left">
							<label for="Cedula" class="col-form-label">Cédula de
								Ciudadania:</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" class="form-control form-control-sm"
								id="cedula" required="required" name="cedula" value="${DatosUsuario.identificador}"
								placeholder="9999999999" maxlength="10"
								pattern="^([a-zA-Z0-9]{10,10})+$"   onchange="validarDocumento(this.value)" />
							<div class="invalid-feedback">Por favor ingrese su # de
								cédula</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="nacionalidad">Nacionalidad</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="nacionalidad"
								required="required" name="nacionalidad"
								placeholder="NACIONALIDAD" minlength="3" maxlength="64"
								value="${DatosUsuario.nacionalidad}" pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
							<div class="invalid-feedback">Ingrese Nacionalidad</div>
						</div>
						<div class="col-md-1 text-left"></div>
						<div class="col-md-2 text-left">
							<label for="genero" class="col-form-label">Genero</label>
						</div>
						<div class="col-md-3 text-left">
							<select class="custom-select custom-select-sm" id="genero"
								name="genero" required="required"> 
								<option value="">Seleccione...</option>
								<option value="MASCULINO">MASCULINO</option>
								<option value="FEMENINO">FEMENINO</option>
							</select>
							<div class="invalid-feedback">Seleccione una opción</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="fechaNacimiento">Fecha de Nacimiento:</label>
						</div>
						<div class="col-md-3 text-left">
							<div class="input-group date">
								<span class="input-group-addon"><i class="fa fa-calendar"></i>
								</span> <input type="text" required="required" id="fechaNacimiento"
									name="fechaNacimiento" class="form-control form-control-sm"
									value="${DatosUsuario.fechanacimiento}" maxlength="10"
									pattern="^(?:(?:(?:0?[1-9]|1\d|2[0-8])[/](?:0?[1-9]|1[0-2])|(?:29|30)[/](?:0?[13-9]|1[0-2])|31[/](?:0?[13578]|1[02]))[/](?:0{2,3}[1-9]|0{1,2}[1-9]\d|0?[1-9]\d{2}|[1-9]\d{3})|29[/]0?2[/](?:\d{1,2}(?:0[48]|[2468][048]|[13579][26])|(?:0?[48]|[13579][26]|[2468][048])00))$">
								<div class="invalid-feedback">Por favor ingrese su fecha
									de nacimiento con formato dd/mm/aaaa</div>
							</div>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2 text-left">
							<label for="provincia">Provincia:</label>
						</div>
						<div class="col-md-3 text-left">
							<select class="custom-select custom-select-sm" id="provincia" 
								required="required" name="provincia">
								<option value="">Seleccione...</option>
								<c:forEach var="listadoLocalizacionProvincia"
									items="${listadoLocalizacionProvincia}">
									<option value="${listadoLocalizacionProvincia.idLocalizacion}">${listadoLocalizacionProvincia.nombre}</option>
								</c:forEach>
							</select>
							<div class="invalid-feedback">Por favor seleccione la
								provincia</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="CorreoResponRegis"> Email de Notificación: <span
								class="text-muted"> (Usuario)</span>
							</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="email" class="form-control form-control-sm"
								id="CorreoResponRegis" required="required" value="${DatosUsuario.email}"
								name="CorreoResponRegis" placeholder="INGRESE EMAIL">

							<div class="invalid-feedback">Por favor ingrese una
								dirección de correo válida</div>
						</div>
						<div class="col-md-1"></div>
						<div class="col-md-2 text-left">
							<label for="rol" class="col-form-label">Rol</label>
						</div>
						<div class="col-md-3 text-left">
							<select class="custom-select custom-select-sm" id="rol"
								name="rol" required="required">
								<option value="">Seleccione...</option>
								<option value="2">TECNICO NACIONAL</option>
								<option value="3">TECNICO PROVINCIAL</option>
								<option value="4">TECNICO ADMINISTRADOR</option>
							</select>
							<div class="invalid-feedback">Seleccione una opción</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="abuela">Nombre Abuela Materna:</label>
						</div>
						<div class="col-md-3 text-lef">
							<input type="text" style="text-transform: uppercase;"
								class="form-control form-control-sm " id="abuela"
								required="required" name="abuela" placeholder="NOMBRE Y PELLIDO"
								minlength="3" maxlength="64" value="${DatosUsuario.nombreAbuela}"
								pattern="^[A-Za-zñÑÁáÉéÍíÓóÚúÜü ]+$" />
							<div class="invalid-feedback">Ingrese Nombre</div>
							<!-- <div class="valid-tooltip">todo bien</div> -->
						</div>
						<div class="col-md-1 text-left"></div>
						<div class="col-md-2 text-left">
							<label for="correopersonal"> Email: <span
								class="text-muted"> (Personal)</span>
							</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="email" class="form-control form-control-sm"
								id="correopersonal" required="required"
								value="${DatosUsuario.mailPersonal}" name="correopersonal"
								placeholder="INGRESE EMAIL">

							<div class="invalid-feedback">Por favor ingrese una
								dirección de correo válida</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="telefono" class="col-form-label">Teléfono:<span
								class="text-muted"> (Opcional)</span></label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" class="form-control form-control-sm"
								id="telefono" name="telefono" placeholder="(00) 000-0000"
								maxlength="13" value="${DatosUsuario.convencional}"
								pattern="^\([0-9]{2}\) [0-9]{3}-[0-9]{4}( ext. [0-9]{1,4})?"
								data-inputmask="'mask': '(99) 999-9999'">
							<div class="invalid-feedback">Por favor ingrese su teléfono</div>
						</div>
						<div class="col-md-1"></div>						<div class="col-md-2 text-left">
							<label for="celular" class="col-form-label">Celular:</label>
						</div>
						<div class="col-md-3 text-left">
							<input type="text" class="form-control form-control-sm"
								id="celular" required="required" name="celular"
								placeholder="(00) 0000-0000" maxlength="14" value="${DatosUsuario.celular}"
								pattern="^\([0-9]{2}\) [0-9]{4}-[0-9]{4}"
								data-inputmask="'mask': '(99) 9999-9999'">
							<div class="invalid-feedback">Por favor ingrese su celular</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="Cargo">Cargo</label>
						</div>
						<div class="col-md-3 text-left">
									<select class="custom-select custom-select-sm"  required="required"
										id="Cargo" name="Cargo">
										<option value="">Seleccione...</option>
										<option value="PRESIDENTE">PRESIDENTE</option>	
										<option value="CONSEJERO">CONSEJERO</option>
										<option value="COORDINADOR">COORDINADOR</option>
										<option value="SUBCOORDINADOR">SUBCOORDINADOR</option>
										<option value="ESPECIALISTA"> ESPECIALISTA </option>
										<option value="ANALISTA">ANALISTA</option>
										<option value="ASISTENTE">ASISTENTE</option>
									</select>
									<div class="invalid-feedback">Seleccione el Cargo</div>
								    </div>
						
					</div>
					<div class="form-group row">
						<div class="col-md-12 text-center">
							<hr>
							<label for="clave text-left">* Su contraseña debe
								contener entre 6 y 12 caracteres, letras minúsculas, mayúsculas,
								números y al algún carácter siguiente (<b>#$@!%*.?</b>),
								Ejemplo: ProcesoRC2021*
							</label>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-md-2 text-left">
							<label for="password">Cree su contraseña:</label>
						</div>
						<div class="col-md-9 text-left">
							<input type="text" class="form-control form-control-sm"
								id="password" required="required" name="password" maxlength="12"
								value="${DatosUsuario.codigoTemporal=='' && DatosUsuario.codigoTemporal==null ?password:DatosUsuario.codigoTemporal}" placeholder="INGRESE SU CONTRASEÑA"
								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[#$@!%*?&.])([A-Za-z\d#$@!%*?&.]|[^ ]){6,12}$">
							<div class="invalid-feedback">
								Su contraseña no cumple con: tener de 6 a 12 caracteres, letras
								minúsculas, mayúsculas, números y al algún carácter siguiente (<b>#$@!%*.?</b>)
								Ejemplo: Consejo2021@
							</div>
						</div>
					</div>

					<!--  -->

				</div>
				<button type="submit" id="btnRegistros"
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
		var f = new Date();
		var dia1 = "01";
		var mes1 = "01";
		var dia31 = "31";
		var mes12 = "12";
		var anioIcio = f.getFullYear() - 70;

		var anioFin = f.getFullYear() - 20;

		var fechaInicio = (dia1 + "/" + mes1 + "/" + anioIcio);

		var fechaFin = (dia31 + "/" + mes12 + "/" + anioFin);

		$('#fechaNacimiento').datepicker({
			forceParse : true,
			todayBtn : false
		}).datepicker('setStartDate', fechaInicio);

		$('#fechaNacimiento').datepicker({

		}).datepicker('setEndDate', fechaFin);
		cargarValorComboPorDefecto("genero", '${DatosUsuario.genero}');
		cargarValorComboPorDefecto("provincia", '${DatosUsuario.provincia}');
		cargarValorComboPorDefecto("rol", '${DatosUsuario.rol}');
		cargarValorComboPorDefecto("Cargo", '${DatosUsuario.cargo}');
		

	});

	$("#CorreoResponRegis").change(function(event) {
		var opcion = $("#CorreoResponRegis").val().toLowerCase();
		$.ajax({
			url : 'ValidarUsuario',
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST",
			dataType : 'json',
			data : {
				codigo : opcion
			},
			success : function(result) {
				if (result.valida === "nuevo") {
					mostrarMensaje(
							"Ususario disponible!",
							"EXITO-NOTIFICACION",
							"3000");

				} else if (result.valida === "existe") {
					mostrarMensaje(
							"Email ya registrado, ingrese uno diferente!",
							"ERROR-NOTIFICACION",
							"3000");
					$("#CorreoResponRegis").val("");
				} else if (result.valida === "vacio") {
					mostrarMensaje(
							"Ingrese email de usuario !",
							"ERROR-NOTIFICACION",
							"3000");

				}

			},
			error : function(result) {
				mostrarMensaje(
						"Consulta no encontrada !",
						"ERROR-NOTIFICACION", "3000");

			}
		});

	});

	$("#btnRegistros").click(function(event) {
			var form = $("#CrearPerfil")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {

				ejecutarJson(form);
			}
			form.addClass('was-validated');

		});

	validarDocumento  = function() {          		
		 numero = $("#cedula").val();
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
		         $("#cedula").val("");					
		         return false;
		      }
		      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
		      if (numero.length < 10 ){              
		         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
		         $("#cedula").val("");	
			         return false;
		         
		      }

		      if (numero=="1212121212" || numero=="1010101010" || numero=="2222222222" || numero=="1414141414" || numero=="1616161616" || numero=="2424242424" || numero=="2020202020"  ) {
					 mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");	
					 $("#cedula").val("");	
			     	 return false;
		      }
			     
		      /* Los primeros dos digitos corresponden al codigo de la provincia */
		      provincia = numero.substr(0,2);      
		      if (provincia < 1 || provincia > numeroProvincias){           
		         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
		         $("#cedula").val("");	
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
		         $("#cedula").val("");	
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
		            $("#cedula").val("");	
		            return false;
		         }                  
		         /* El ruc de las empresas del sector publico terminan con 0001*/         
		         if ( numero.substr(9,4) != '0001' ){                    
		            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
		            $("#cedula").val("");	
		            return false;
		         }
		      }         
		      else if(pri == true){         
		         if (digitoVerificador != d10){                          
		            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
		            $("#cedula").val("");	
		            return false;
		         }         
		         if ( numero.substr(10,3) != '001' ){                    
		            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
		            $("#cedula").val("");	
		            return false;
		         }
		      }      

		      else if(nat == true){         
		         if (digitoVerificador != d10){                          
		            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
		            $("#cedula").val("");	
		            return false;
		         }         
		         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
		            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
		            $("#cedula").val("");	
		            return false;
		         }
		      }      
		      mostrarMensaje("El dato ingresado es correto!",	"EXITO");
		      return true; 
	}
	 

/*
	$("#cedula").change(function(event){	
		 var opcion = $("#cedula").val();	 
		  $.ajax({
	      url: 'ValidarUsuarioPerfilCedula',
	      headers: {"X-CSRF-TOKEN": csrfToken},
	      type: "POST",
	      dataType: 'json',
	      data: {codigo: opcion},
	      success: function (result) {
	    	  if(result.valida ==="nuevo"){   
	    		  mostrarMensaje("Ususario disponible!","EXITO-NOTIFICACION","3000"); 
	      		
	      		}
	    	  else if(result.valida ==="existe"){   
	    		  mostrarMensaje("Usuario ya registrado, Verifiar en listad de funcionarios!","ERROR-NOTIFICACION","3000"); 
	    		  $("#cedula").val("");
	      		}
	      	  else if(result.valida ==="vacio"){   
	    		  mostrarMensaje("Ingrese Cedula de usuario !","ERROR-NOTIFICACION","3000"); 
	      		
	      		}
		  
	      },
	      error: function (result) {       
	    		mostrarMensaje("Consulta no encontrada !","ERROR-NOTIFICACION","3000");
	    		

	      }
	  });

	});*/
</script>