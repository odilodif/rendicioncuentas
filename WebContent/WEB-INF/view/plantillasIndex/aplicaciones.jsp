<%-- 
	version		: 1.0
    Document  	: ventanaAplicacion
    Created on	: 02/04/2018, 10:34:53
    Author		: Carlos Anchundia
    Mail		: e.du.ingcharles@hotmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<spring:url value="/resources/" var="urlPublic" />
<spring:url value="/" var="urlRoot" />
<section id="areaTrabajo">
	
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">
			<div class="panel panel-default">
				<div class="panel-heading active" role="tab" id="headingOne">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne" aria-expanded="true"
							aria-controls="collapseOne">
							Inicio / Aplicaciones <span></span>
						</a>
					</h4>

				</div>
				<div id="collapseOne" class="panel-collapse in collapse show"
					role="tabpanel" aria-labelledby="headingOne">
					<div class="panel-body" id="listadoItems">
						<div class="wrapper wrapper-content animated fadeInRight" >
							<div class="row">
								<c:forEach items="${aplicaciones}" var="aplicacion">
									<div class="col-6 col-lg-3 aplicacion"
										ondragstart="drag(event)" draggable="true"
										id="${aplicacion[0]}" data-rutaAplicacion="${aplicacion[2]}"
										data-opcion="index" data-nombreAplicacion="${aplicacion[1]}"
										data-destino="menuAplicacion" data-color="${aplicacion[4]}">
										<div class="widget-head-color-box ${aplicacion[4]} p-xs text-center">
											<div class="titulo-aplicacion">
												<h4 class="font-bold no-margins">
													<span>${aplicacion[1]}</span>
												</h4>
											</div>
											<img src="${urlPublic}img/${aplicacion[5]}"
												class="img-circle2 circle-border m-b-xs" alt="profile">
											
										</div>
										<div class="widget-text-box">
											<p class="m-n">
												<b>${aplicacion[3]} </b>
												
												</p>
												
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel panel-default" id="two">
				<div class="panel-heading" role="tab" id="headingTwo"
					style="display: none;"  ondragover="allowDrop(event)" ondrop="drop(event)">
					<h4 class="panel-title panel-title-segundo">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapseTwo"
							aria-expanded="false" aria-controls="collapseTwo">
							<span>Formularios</span>
						</a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse"
					role="tabpanel aaa" aria-labelledby="headingTwo">
					<div class="panel-body" id="detalleItem"></div>
				</div>
			</div>
		</div>
</section>
<script type="text/javascript">
var cadenaValores="";
var valores="";
if('${aplicaciones.size()}'>0){
	<c:forEach var="idAplicacion" items="${aplicaciones}">
	cadenaValores+='"aplicacion${idAplicacion[0]}":".aplicacion-${idAplicacion[0]}",';
	</c:forEach>
 	valores = cadenaValores.substr(0, cadenaValores.length-1);
}



</script>
