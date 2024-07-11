<%-- 
	version		: 1.0
    Document  	: menuTopLogout
    Created on	: 01/15/2018, 15:04:50
    Author		: Carlos Anchundia
    Mail		: e.du.ingcharles@hotmail.com
    Property   	: CPCCS
--%>

<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<spring:url value="/" var="urlRoot" />
<section class="row" id="barraGeneral">
	<div class="col-sm-12 col-sm-offset-2">
		<div class="d-flex align-items-center">
			<div class="p-2">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn "
						href="#"><i class="fa fa-bars"></i> </a>
				</div>
			</div>

			<div class="mr-auto inicioAplicacion">
				<a href="#" title="Inicio" id="0"
					data-rutaAplicacion="plantillasIndex" class="_inicio"
					data-nombreAplicacion="Aplicaciones"
					data-destino="seccionVentanaAplicacion"
					style="color: #3e91c3; font-weight: bold;"> <i
					class="fa fa-home fa-3x"></i>INICIO
				</a>
			</div>

			<!-- <div class="p-2">
				<ul>
					<li class="dropdown"><a class="count-info"
						data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-lg"></i>
							<span class="label label-primary m-t-n-lg m-l-sm">3</span>
					</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li><a href="about"> <i class="fa fa-envelope fa-fw"></i>
									Acerca <span class="pull-right text-muted small">Apps -
										CPCCS T</span>
							</a></li>
							<li class="divider"></li>
							<li><a href="grid_options.html"> <i
									class="fa fa-database fa-fw"></i> Servidor en línea <span
									class="pull-right text-muted small">Sin Intermitencia</span>
							</a></li>
							<li class="divider"></li>
							<li><a href="grid_options.html"> <i
									class="fa fa-edit fa-fw"></i> Cambiar contraseña <span
									class="pull-right text-muted small">2 días</span>
							</a></li>
						</ul></li>
				</ul>
			</div> -->
			<div class="p-2 m-t-md21">
				<span style="font-family: cursive; font-weight: bold;" id="nombre" >${nombreUsuario}</span>
			</div>
			<div class="padding-logout m-t-xs3">
				<c:url value="/logout" var="logoutUrl" />
				<form id="logout" action="${logoutUrl}" method="post" style="margin: 0;">
					<sec:csrfInput />
				</form>

				<a style="padding-right: 5px; padding-left: 5px; font-weight: bold;"
					href="javascript:document.getElementById('logout').submit()"><i
					class="fa fa-sign-in fa-fw fa-lg m-t-md21"></i>SALIR </a>

			</div>
		</div>
	</div>
</section>
