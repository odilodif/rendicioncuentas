
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<c:set var="ruta" value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<!DOCTYPE html>
<html>


<iframe src='https://view.officeapps.live.com/op/embed.aspx?src=${rutaPDF}' width='100%' height='600px' frameborder='0'> </iframe>
</html>