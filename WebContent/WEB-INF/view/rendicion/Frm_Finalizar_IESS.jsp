<%-- 
	version		: 1.0
    Document  	: Frm_Finalizar_Informe_IESS.jsp
    Created on	: 24/02/2021; 21:25:14
    Author		: Juan Vega
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


<c:choose>
<c:when test="${inf_estado=='activo'}">
<div class="card text-center mb-card20">
<div class="card-header text-white carHeaderBlue">
<h5>FINALIZACIÓN DE INFORME DE RENDICIÓN DE CUENTAS</h5>
</div>
<div class="card-body">
	<div class="card card-secondary">
	<div class="row justify-content-md-center">
		<div class="col-lg-10">
                    <div class="ibox">
                        <div class="ibox-content">
                           <div class="text-center article-title">
                                <h1>
                                    Consejo de Participación Ciudadana y Control Social <strong> CPCCS</strong>.
                                </h1>
                            </div>
                            <p>
                                Le felicita por ser parte del proceso de Rendición de Cuentas para el periodo ${infAutPeriodo}.
                            </p>
 							<table class="table registros table-bordered">
					
					<tr>
					<td scope="row" width="20%"  style="vertical-align:middle;" >
						MATRICES QUE AUN NO CUENTAN CON INFORMACIÓN
					</td>
						<td scope="row" width="80%">
						   <div class="row  border-bottom white-bg dashboard-header">
                                  <div class="col-sm-8">
							  <ul class="list-group" id="listado">
                                </ul>	
                                </div>
                                </div>				
						</td>
					</tr>
					</table>		
 									
 									</div>
 									<form:form class="needs-validation vistaFasePeriodo" novalidate=""
										modelAttribute="TblInformeAutoridad" id="autCodigo"
										data-rutaAplicacion="rendicion"
										data-opcion="verificarInformeAutoridad"
										data-accionEnExito="ACTUALIZAR">
                               
                               <input type="hidden" id="infAutCod" name="infAutCod" value="${infAutCod}"> 
                               <input type="hidden" id="infAutPeriodo" name="infAutPeriodo" value="${infAutPeriodo}">
                                
                                </form:form>
   
                        <!--  <div class="col-md-12 text-center">
										<button type="submit" id="btnVerificarInforme"
											class="btn _nuevoColor _buscar btn-sm mt-2">Verificar Informe</button>
									</div> -->
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
               </div> 

		</c:when>
		<c:when test="${inf_estado=='completo'}">
<div class="card text-center mb-card20">
<div class="card-header text-white carHeaderBlue">
<h5>FINALIZACIÓN DE INFORME DE RENDICIÓN DE CUENTAS</h5>
</div>
<div class="card-body">
	<div class="card card-secondary">
	<div class="row justify-content-md-center">
		<div class="col-lg-10">
                    <div class="ibox">
                        <div class="ibox-content">
                           <div class="text-center article-title">
                                <h1>
                                    Consejo de Participación Ciudadana y Control Social <strong> CPCCS</strong>.
                                </h1>
                            </div>
                            <p>
                                Le felicita por ser parte del proceso de Rendición de Cuentas para el periodo ${infAutPeriodo}..
                            </p>
 									</div>
 									<form:form class="needs-validation vistaFasePeriodo" novalidate=""
										modelAttribute="TblInformeAutoridad" id="finalizarInformeFE"
										data-rutaAplicacion="rendicion"
										data-opcion="FinalizarInformeFE"
										data-accionEnExito="ACTUALIZAR">
                               
                               <input type="hidden" id="infAutCod" name="infAutCod" value="${infAutCod}"> 
                               <input type="hidden" id="infAutPeriodo" name="infAutPeriodo" value="${infAutPeriodo}"> 
                               
                                </form:form>
                                <div class="col-md-12 text-center">
										<button type="submit" id="btnFinalizarInforme"
											class="btn _nuevoColor _guardar btn-sm mt-2">Finalizar Informe</button>
									</div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
               </div> 

		</c:when>
		
		<c:when test="${inf_estado=='finalizado'}">
<div class="card text-center mb-card20">
<div class="card-header text-white carHeaderBlue">
<h5>FINALIZACIÓN DE INFORME DE RENDICIÓN DE CUENTAS</h5>
</div>
<div class="card-body">
	<div class="card card-secondary">
	<div class="row justify-content-md-center">
		<div class="col-lg-10">
                    <div class="ibox">
                        <div class="ibox-content">
                           <div class="text-center article-title">
                                <h1>
                                    Consejo de Participación Ciudadana y Control Social <strong> CPCCS</strong>.
                                </h1>
                            </div>
                            <p>
                                Ha concluido el Informe de Rendición de Cuentas del periodo fiscal ${infAutPeriodo}.<br>
                                IMPRIMA SU FORMULARIO, COMO CONSTANCIA DE HABER FINALZIADO SU PROCESO.
                            </p>
 									</div>
 									<form:form class="needs-validation vistaFasePeriodo" novalidate=""
										modelAttribute="TblInformeAutoridad" id="finalizarInformeFE"
										data-rutaAplicacion="rendicion"
										data-opcion="FinalizarInformeFE"
										data-accionEnExito="ACTUALIZAR">
                               
                               <input type="hidden" id="infAutCod" name="infAutCod" value="${infAutCod}"> 
                               <input type="hidden" id="infAutPeriodo" name="infAutPeriodo" value="${infAutPeriodo}"> 
                                </form:form>
                                 <div class="col-md-12 text-center">
											<form:form class="needs-validation" novalidate="" id="Imprimirid" data-rutaAplicacion="rendicion" data-opcion="ImprimirFormulario" data-destino="detalleItem">
				<input type="hidden" name="infocod" id="infocod" value="${infAutCod}">
							<div class="form-group row">
								<div class="col-md-12 text-center">
									<button type="submit" id="btnImprimir"
										class="btn _imprimirColor _imprimir btn-sm mt-2">Imprimir Informe</button>
								</div>
							</div>										
							</form:form>
									</div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
               </div> 

		</c:when>
		<c:otherwise>
				<div id="informacion">
					¡Información!... Usted aun no cuenta con un informe.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Informe.
				</div>
		</c:otherwise>
	</c:choose>
</html>

<script type="text/javascript">

$(document).ready(function() {
	comprobarmatriz( '${mensaje}',":");
});

$("#btnVerificarInforme").click(function(event) {
		
		//mostrarMensaje("Todas las matrices tienen información, puede finalizar el informe!",	"EXITO");
			var form = $("#autCodigo")
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

$("#btnFinalizarInforme").click(function(event) {
	
	//mostrarMensaje("Todas las matrices tienen información, puede finalizar el informe!",	"EXITO");
		var form = $("#finalizarInformeFE")
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

$("#btnImprimir").click(function(event) {
	   var form = $("#Imprimirid")

	   	abrir(form,event,false);
	    
	
		});
</script>