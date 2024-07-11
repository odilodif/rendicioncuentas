<%-- 
	version		: 1.0
    Document  	: menuNavBody
    Created on	: 01/17/2018, 16:01:01
    Author		: Carlos Anchundia
    Mail		: e.du.ingcharles@hotmail.com
    Property   	: CPCCS
--%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/resources/" var="urlPublic" />

<div class="sidebar-nav"></div>


<script type="text/javascript">
 var row = [];
 <c:forEach items="${menuAplicacion}" var="id">
     row.push(["${id[0]}","${id[1]}","${id[2]}","${id[3]}","${id[4]}","${id[5]}"]); 
 </c:forEach>
 var nombreApp='<c:out value="${nombreApp}" />';
 var urlPublic='<c:out value="${urlPublic}" />';
$(document).ready(function() {
  
	if(nombreApp != "general"){
  		$("head").append("<link rel='stylesheet' href='"+urlPublic+"css/"+nombreApp+"/estilos.css'>");
   	}
  
	contruirMenu(row,nombreApp);
	$('.menu').metisMenu();
	var itemMenu=$("#menuAplicacion [data-destino='areaTrabajo #listadoItems']").first();
	if(itemMenu.length!==0)
		abrir(itemMenu,"",true);
	
	if(itemMenu.parent('li').parent('ul').parent('li').html()!==undefined){
		itemMenu.parentsUntil('.has-arrow').parent('li').addClass('mm-active');
		itemMenu.parentsUntil('.has-arrow').parent('li').parent('ul').addClass('mm-show');
		itemMenu.parent('li').parent('ul').addClass('mm-show');

	//	Visita();
	}

	
});

// function Visita(){
// 	$.ajax({
// 		url: 'view/admision/visitas',
		
// 		});
// }
</script>
