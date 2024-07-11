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


<div class="row">
<div class="col-md-12 p-10">


<h2>PLATAFORMA CPCCS</h2>
<p>El Sistema Unificado de Aplicaciones del CPCCS - PLATAFORMA CPCCS es un SII (Sistema de Información Integrado).</p>
<hr/>
<!-- <h3>TUTORIALES DE MÓDULOS DE SERVICIOS</h3>
<table style="width:100%"  id="tablaRegistros" class="table table-striped">
	<thead>
		<tr>
			<th style="width:80%"></th>
			<th align="center">TUTORIAL</th>
			<th align="center">YOUTUBE</th>
			<th align="center">PDF</th>
		</tr>
	</thead>
	<tbody>
	  <tr>
	    <td>SISTEMA DE TRANSPORTE</td>
	    <td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/transportes/index.htm" target="_blank"><img src="${urlPublic}img/ayuda/video.png" width="31" height="31"  alt=""/></a></td>
	  </tr>
	  <tr>
	  	<td>REGISTRO DE OPERADOR</td>
	    <td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/vue/regguia.html" target="_blank"><img src="${urlPublic}img/ayuda/video.png" width="31" height="31"  alt=""/></a></td>
		<td align="center"><a href="https://www.youtube.com/watch?v=L5hg_RqfeNE"target="_blank"><img src="${urlPublic}img/ayuda/youtube.png" width="31" height="31"  alt=""/></a></td>
		<td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/pdf/Registro_Sistema_Guia.pdf" target="_blank"><img src="${urlPublic}img/ayuda/pdf.png" width="31" height="31"  alt=""/></a></td>					
	  </tr>
	</tbody>
</table> -->


<h3>SERVICIOS</h3>
<table style="width:100%"  id="tablaRegistros" class="table table-striped">
	<thead>
		<tr>
			<th style="width:86%"></th>
			<th>WEB</th>
			<th>TUTORIAL</th>
			<!--th>YOUTUBE</th-->
			<th>PDF</th>
		</tr>
	</thead>
	<tbody>
	  <!-- <tr>
	    <td width="277">AGROBOX</td>
	    <td align="center"><a href="http://agrobox.agrocalidad.gob.ec" target="_blank"><img src="${urlPublic}img/ayuda/web.png" width="31" height="31"  alt=""/></td>
	    <td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/agrobox/index.html" target="_blank"><img src="${urlPublic}img/ayuda/video.png" width="31" height="31"  alt=""/></a></td>
		<td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/pdf/agrobox.pdf" target="_blank"><img src="${urlPublic}img/ayuda/pdf.png" width="31" height="31"  alt=""/></a></td>
		
	  </tr>
	   -->

	  <tr>
	    <td>GLPI</td>
	    <td align="center"><a href="http://ayuda.cpccs.gob.ec" target="_blank"><img src="${urlPublic}img/ayuda/web.png" width="31" height="31"  alt=""/></a></td>
	    <!-- <td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/glpi/index.html" target="_blank"><img src="${urlPublic}img/ayuda/video.png" width="31" height="31"  alt=""/></td>
		<td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/pdf/Manual_GLPI.pdf" target="_blank"><img src="${urlPublic}img/ayuda/pdf.png" width="31" height="31"  alt=""/></a></td>
		 -->
	  </tr>
	    <tr>
	    <td>CORREO ELECTRÓNICO</td>
	    <td align="center"><a href="http://mail.cpccs.gob.ec" target="_blank"><img src="${urlPublic}img/ayuda/web.png" width="31" height="31"  alt=""/></a></td>
	    <!-- <td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/glpi/index.html" target="_blank"><img src="${urlPublic}img/ayuda/video.png" width="31" height="31"  alt=""/></td>
		<td align="center"><a href="https://guia.agrocalidad.gob.ec/tutoriales/pdf/Manual_GLPI.pdf" target="_blank"><img src="${urlPublic}img/ayuda/pdf.png" width="31" height="31"  alt=""/></a></td>
		 -->
	  </tr>
	  </tbody>
</table>
<hr/>
</div>
</div>