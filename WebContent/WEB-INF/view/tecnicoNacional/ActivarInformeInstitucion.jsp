<%-- 
	version		: 1.0
    Document  	: ActivarInformeInstitucion
    Created on	: 16/04/2021; 9:32:24
    Author		: Juan Carlos Vega
    Mail		: jc.vega@live.com
    Property   	: CPCCS
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"	prefix="sec"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<%@ page session="false"%>
<sec:authentication var="usuario" property="principal" />
<!DOCTYPE>
<html>
<spring:url value="/resources/" var="urlPublic" />  
   	
   	<div class="card-body">
		<div id="nacional" class="card card-secondary">
   	
   	 <div id="Mensaje">
	<div class="alert alert-primary"role="alert">Buscar por RUC y luego dar doble clic sobre los datos de la institución, para poder activar el informe</div>
	</div>  
	<div class="form-group row">
											<div class="col-md-3 text-left">
												<label for="tipoIdentificacion" class="col-form-label">Ingrese el Ruc de la Institución</label>
											</div>
											
																														
											<div class="col-md-3 text-left">
												<input type="text" class="form-control form-control-sm"
													id="identificador" required="required" name="identificador"
													placeholder="9999999999999" onchange="validarDocumento(this.value)"  minlength="13" maxlength="13"
													 />
												<div class="invalid-feedback">Por favor ingrese su Ruc</div>
											
											</div>
										
												<button type="button" id="btnBuscar" class="btn _nuevoColor _buscar btn-sm ">Buscar</button>
											
										</div>		
	
	        
	<table id="tablaRegistros" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
              <th>#</th>
              <th>Ruc</th>
              <th>Nombre de la Institución</th>
                <th>Función</th>
                <th>Provincia</th>
               <th>Fecha de registro</th>
               <th>Fecha de activación</th>
               <th>Fecha de finalización informe</th>
               <th>Estado Informe</th>
               <th># Aperturas</th>
            </tr>
        </thead>
        <tbody>
		</tbody>
	</table>
	<hr/>
	
</div>
	</div>
	
	
	<div id="tecnico">
				<div id="informacion">
					¡Información!... No tiene permiso para realizar esta acción.<br /> <span
						style="font-weight: bold;"></span> <br />Comuniquese con un Técnico Nacional.
				</div>
			</div>
	
</html>
<script>	


$(document).ready(function() {
	if ('${rol}' == 'Nacional' || '${rol}' == 'Administrador') {
		$("#tecnico").hide()
		$("#tablaRegistros").hide()
		
	} else if ('${rol}' == 'Provincial') {

		$("#nacional").hide()
		$("#tecnico").show()
	}
});

$("#btnBuscar")
.click(
		function(event) {

	if($("#identificador").val()===null||$("#identificador").val()==="" ){
		mostrarMensaje("Por favor ingrese un Ruc!",	"ERROR");
		}else{
			nacional();
			}
			

});
function nacional() {
	$("#tablaRegistros").show()
	var parametros = {"ruc" : $("#identificador").val()};
	$('#tablaRegistros').DataTable({
		ajax : {
			data : parametros,
			url : "obtenerIntitucionesConInformeFinalizado",
			headers : {
				"X-CSRF-TOKEN" : csrfToken
			},
			type : "POST"
		},
		order : [ 0, "asc" ],
		bDestroy : true,
		dom : '<"html5buttons"B>lTfgitp',
		buttons : [ 
		 {extend : 'excelHtml5'},
		 {extend : 'pdfHtml5',orientation : 'landscape',pageSize : 'A1'	},
		 {extend : 'print'},
			 ],
		columns : [ 
			 {data : "contador"},
			 {data : "ruc"}, 
			 {data : "nombre"},
			 {data : "funcion"},
			 {data : "provincia"},
			 {data : "fechaRegistro"},
			 {data : "fechaActivacion"},
			 {data : "fechaFin"},
			 {data : "estado"}, 
			 {data : "reaperturas"} 
			 ],
		language : {
			url : "resources/json/lenguajeTablaDataTable.json"
		},
		createdRow: function( row, data, dataIndex ) {
            $(row).attr('id', data.inf_cod );
            $(row).attr( 'ruc', data.ruc );
            $(row).attr('class', 'item');
            $(row).attr('data-rutaAplicacion', 'tecnicoNacional');
            $(row).attr('data-opcion','DatosActivarInformeInstitucion');
            $(row).attr('ondragstart', 'drag(event)');
            $(row).attr('draggable', 'false');
            $(row).attr('data-destino', 'detalleItem');
            $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
            $(row).find("td:eq(3)").attr('title',data.nombres );
        },
	});

}

   

validarDocumento  = function() {          		
	 numero = $("#identificador").val();
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
	         return false;
	      }
	      /* 10 digitos valida cedula pasaporte y ruc, 14 digitos solo valida ruc */   
	      if (numero.length < 13 ){              
	         mostrarMensaje("El número ingresado no es válido!",	"ERROR");                
	         return false;
	      }
	     
	      /* Los primeros dos digitos corresponden al codigo de la provincia */
	      provincia = numero.substr(0,2);      
	      if (provincia < 1 || provincia > numeroProvincias){           
	         mostrarMensaje("El código de la provincia (dos primeros dígitos) es inválido!",	"ERROR");
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
	            return false;
	         }                  
	         /* El ruc de las empresas del sector publico terminan con 0001*/         
	         if ( numero.substr(9,4) != '0001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector público debe terminar con 0001!",	"ERROR");
	            return false;
	         }
	      }         
	      else if(pri == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El ruc de la empresa del sector privado es incorrecto!",	"ERROR");
	            return false;
	         }         
	         if ( numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la empresa del sector privado debe terminar con 001!",	"ERROR");
	            return false;
	         }
	      }      

	      else if(nat == true){         
	         if (digitoVerificador != d10){                          
	            mostrarMensaje("El número de cédula de la persona natural es incorrecto.!",	"ERROR");
	            return false;
	         }         
	         if (numero.length >10 && numero.substr(10,3) != '001' ){                    
	            mostrarMensaje("El ruc de la persona natural debe terminar con 001!",	"ERROR");
	            return false;
	         }
	      }      
	      return true; 
}
   

</script>