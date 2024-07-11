<%-- 
	version		: 1.0
    Document  	: Fmr_MecanismoParticipacion
    Author		: Wilmer Guaman
    Mail		: guamanw@gmail.com
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

<div class="card text-center mb-card15">
	<c:choose>
		<c:when test="${infestado=='activo'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>MECANISMOS DE PARTICIPACIÓN CIUDADANA:</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-md-12 order-md-1">
						<form:form class="needs-validation" novalidate=""
							modelAttribute="TblMecanismoParticipacionCiudadana"
							id="TblMecanismoParticipacionCiudadana"
							data-rutaAplicacion="rendicion"
							data-opcion="guardarMecanismoParticipacion"
							data-accionEnExito="ACTUALIZAR">
							<input type="hidden" id="infCod" name="infCod" value="${infCod}">
							<table class="table table-bordered" id="miTabla">
								<thead>
									<tr>
										<th scope="col" class="tablaingreso" width="12%"
											style="text-align: center; font-size: x-small;">ESPACIOS-MECANISMOS
											DE PARTICIPACIÓN CIUDADANA</th>
										<th scope="col" class="tablaingreso" width="10%"
											style="text-align: center; font-size: x-small;">PONGA SI
											O NO</th>
										<th scope="col" class="tablaingreso" width="8%"
											style="text-align: center; font-size: x-small;">CUÁNTAS
											VECES CONVOCÓ AL GAD</th>
										<th scope="col" class="tablaingreso" width="25%"
											style="text-align: center; font-size: x-small;">QUÉ
											ACTORES PARTICIPARON</th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">DESCRIBA
											LOS LOGROS ALCANZADOS EN EL AÑO</th>
										<th scope="col" class="tablaingreso" width="20%"
											style="text-align: center; font-size: x-small;">LINK AL
											MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG. WEB DE LA
											INSTITUCIÓN</th>

									</tr>
								</thead>
								<tbody>
									<tr id="fila0">
										<td scope="row"><label id="mecaniNombre">INSTANCIA DE PARTICIPACIÓN</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="INSTANCIA DE PARTICIPACIÓN">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
										
										<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks1[]" value="SECTORES"> <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks1[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks1[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox" type="checkbox"
													id="checks[]" name="checks1[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
										
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion1" id="mecaSec[]" name="mecaSec[]" required="required" >
												<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
                                            
									</tr>
									<tr id="fila1">
										<td scope="row"><label id="mecaniNombre">AUDIENCIA PÚBLICA</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="AUDIENCIA PÚBLICA">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
											<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks2[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks2[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox" type="checkbox"
													id="checks[]" name="checks2[]" value="ORGANIZACIONES"> <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks2[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion2" id="mecaSec[]" name="mecaSec[]" required="required">
												<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr id="fila2">
										<td scope="row"><label id="mecaniNombre"> CABILDO POPULAR</label> <input type="hidden" id="mecaNombre[]" name="mecaNombre[]" class="form-control form-control-sm"
											value="CABILDO POPULAR">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
										<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks3[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks3[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks3[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks3[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion3" id="mecaSec[]" name="mecaSec[]" required="required">
											<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr id="fila3">
										<td scope="row"><label id="mecaniNombre">CONSEJO DE PLANIFICACIÓN LOCAL</label> <input type="hidden" id="mecaNombre[]" name="mecaNombre[]" class="form-control form-control-sm"
											value="CONSEJO DE PLANIFICACIÓN LOCAL">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
										<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks4[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks4[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks4[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks4[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion4" id="mecaSec[]" name="mecaSec[]" required="required">
											<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr id="fila4">
										<td scope="row"><label id="mecaniNombre">SILLA VACÍA</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="SILLA VACÍA">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
										<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox" type="checkbox"
													id="checks[]" name="checks5[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks5[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks5[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox" type="checkbox"
													id="checks[]" name="checks5[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											
										<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion5" id="mecaSec[]" name="mecaSec[]" required="required">
										<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
											</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr id="fila5">
										<td scope="row"><label id="mecaniNombre">CONSEJOS CONSULTIVOS</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="CONSEJOS CONSULTIVOS">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
											<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks6[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks6[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks6[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks6[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion6" id="mecaSec[]" name="mecaSec[]" required="required">
										<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
										<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
									</tr>
									<tr id="fila6">
										<td scope="row"><label id="mecaniNombre">OTROS</label> <input type="hidden" id="mecaNombre[]"
											name="mecaNombre[]" class="form-control form-control-sm"
											value="OTROS">
										<td scope="row"><select
											class="custom-select custom-select-sm "
											id="mecaImplementado[]" name="mecaImplementado[]"
											required="required">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="mecaNumero[]" name="mecaNumero[]"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
										<table class="tablacheckbox">
											<tr>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks7[]" value="SECTORES" > <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]"  name="checks7[]" value="ENTIDADES"> <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											</td>
											<td style="vertical-align: middle; font-size: x-small; width: 100px;">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox" type="checkbox"
													id="checks[]" name="checks7[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox" type="checkbox"
													id="checks[]" name="checks7[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
											<input type="hidden" class="form-control form-control-sm bloqueo campo descripcion7" id="mecaSec[]" name="mecaSec[]" required="required">
										<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										</td>
										</tr>
										</table>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="mecaDescLogros[]" name="mecaDescLogros[]"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="mecaMedioverifica[]" name="mecaMedioverifica[]"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>
                                         
									</tr>
								</tbody>
							</table>
						</form:form>
					</div>

				</div>
				<div class="col-md-12 text-center">
					<button type="submit" id="btnGuardar"
						class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
				</div>
			</div>
		</c:when>
		<c:when test="${infestado=='matriz'}">

			<div class="card-header text-white carHeaderBlue">
				<h5>MECANISMOS DE PARTICIPACIÓN CIUDADANA:</h5>
			</div>
			<div class="card-body">
				<div class="row">
					<div id="actualizar">
						<div class="col-md-12 order-md-1">
							<form:form class="needs-validation" novalidate=""
								modelAttribute="TblDatosInforme" id="TblMecanismosupdate"
								data-rutaAplicacion="rendicion" data-opcion="ActualizarDatos"
								data-accionEnExito="ACTUALIZAR">

								<table class="table  table-bordered" >
									<thead>
										<tr>
											<th scope="col" class="tablaingreso" width="12%"
												style="text-align: center; font-size: x-small;">ESPACIOS-MECANISMOS
											DE PARTICIPACIÓN CIUDADANA</th>
											<th scope="col" class="tablaingreso" width="11%"
												style="text-align: center; font-size: x-small;">PONGA
												SI O NO</th>
												<th scope="col" class="tablaingreso" width="10%"
												style="text-align: center; font-size: x-small;">CUÁNTAS
											VECES CONVOCÓ AL GAD</th>
											<th scope="col" class="tablaingreso" width="25%"
												style="text-align: center; font-size: x-small;">QUÉ
											ACTORES PARTICIPARON</th>
											<th scope="col" class="tablaingreso" width="20%"
												style="text-align: center; font-size: x-small;">DESCRIBA
											LOS LOGROS ALCANZADOS EN EL AÑO</th>
											<th scope="col" class="tablaingreso" width="20%"
												style="text-align: center; font-size: x-small;">LINK AL
												MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
												INSTITUCIÓN</th>

										</tr>
									</thead>
									<tbody>
										<tr>
											<td scope="row"><label id="mecani_nombre"></label></td>
											<td scope="row"><select
											class="custom-select custom-select-sm "
											id="meca_implementado" name="meca_implementado" 
											required="required" onchange="validar(this)">
												<option value="">Seleccione...</option>
												<option value="SI">SI</option>
												<option value="NO">NO</option>
										</select>
											<div class="invalid-feedback">Por Ingrese los
												Resultados de Implementación</div></td>
										<td scope="row">
											<input type="text"
											class="form-control form-control-sm campo numero"
											id="meca_numero" name="meca_numero"
											required="required" placeholder="0" onkeypress="javascript:return validarnroEntero(event);">
											<div class="invalid-feedback">ingrese el numero</div>
										</td>
										<td scope="row">
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox 1" type="checkbox"
													id="checks[]" name="checks1[]" value="SECTORES"> <label
													class="form-check-label" for="inlineCheckbox1" style="text-align: center; font-size: x-small;">SECTORES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox 2" type="checkbox"
													id="checks[]"  name="checks1[]" value="ENTIDADES" > <label
													class="form-check-label" for="inlineCheckbox2" style="text-align: center; font-size: x-small;">ENTIDADES</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input  checkbox 3" type="checkbox"
													id="checks[]" name="checks1[]" value="ORGANIZACIONES" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">ORGANIZACIONES
													</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input checkbox 4" type="checkbox"
													id="checks[]" name="checks1[]" value="OTROS" > <label
													class="form-check-label" for="inlineCheckbox3" style="text-align: center; font-size: x-small;">OTROS
													</label>
											</div>
										
											<input type="hidden" class="form-control form-control-sm campo bloqueo descripcion1" id="meca_sec" name="meca_sec" required="required" >
												<div class="invalid-feedback">Seleccione un almenos un checkbox</div>
										</td>
										<td scope="row"><textarea rows="2" cols=""
												class="form-control form-control-sm campo"
												id="meca_desc_logros" name="meca_desc_logros"
												required="required"></textarea>
											<div class="invalid-feedback">describa los logros alcanzados</div></td>
										<td scope="row"><input type="url"
											class="form-control form-control-sm campo url"
											id="meca_medioverifica" name="meca_medioverifica"
											required="required" placeholder="Dirección de página web"
											value="http://">
											<div class="invalid-feedback">Por favor ingrese su página web con el siguiente formato http://dirreccionDePaginaWeb</div></td>

										</tr>
									</tbody>

								</table>
							</form:form>
						</div>

						<div class="col-md-12 text-center">
							<button type="submit" id="btnActualizar"
								class="btn _nuevoColor _guardar btn-sm mt-2">Actualizar</button>
						</div>
						<input type="hidden" id="meca_cod" name="meca_cod">
					</div>

					<div id="tabla" class="col-md-12 order-md-1">
						<table id="tablaRegistros"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>#</th>
									<th  style="text-align: center; font-size: x-small;">ESPACIOS-MECANISMOS
											DE PARTICIPACIÓN CIUDADANA</th>
									<th style="text-align: center; font-size: x-small;">PONGA
										SI O NO</th>
										<th style="text-align: center; font-size: x-small;">CUÁNTAS
											VECES CONVOCÓ AL GAD</th>
										<th  style="text-align: center; font-size: x-small;">QUÉ
											ACTORES PARTICIPARON</th>
										<th style="text-align: center; font-size: x-small;">DESCRIBA
											LOS LOGROS ALCANZADOS EN EL AÑO</th>
									<th style="text-align: center; font-size: x-small;">LINK
										AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
										INSTITUCIÓN</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
						<hr />
					</div>
				</div>
			</div>


		</c:when>
		<c:when test="${infestadoinforme=='finalizado'}">
		<div class="card-header text-white carHeaderBlue">
				<h5>MECANISMOS DE PARTICIPACIÓN CIUDADANA:</h5>
			</div>
		<div class="card-body">
		<div class="row">
			<div class="col-md-12 order-md-1" >
			<input type="hidden" id="infCod" name="infCod" value="${infCod}">
			<table id="tablaRegistros"
							class="table table-striped table-bordered" style="width: 100%">
							<thead>
								<tr>
									<th>#</th>
									<th  style="text-align: center; font-size: x-small;">ESPACIOS-MECANISMOS
											DE PARTICIPACIÓN CIUDADANA</th>
									<th style="text-align: center; font-size: x-small;">PONGA
										SI O NO</th>
										<th style="text-align: center; font-size: x-small;">CUÁNTAS
											VECES CONVOCÓ AL GAD</th>
										<th  style="text-align: center; font-size: x-small;">QUÉ
											ACTORES PARTICIPARON</th>
										<th style="text-align: center; font-size: x-small;">DESCRIBA
											LOS LOGROS ALCANZADOS EN EL AÑO</th>
									<th style="text-align: center; font-size: x-small;">LINK
										AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
										INSTITUCIÓN</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							</tbody>
						</table>
			</div>
			</div>
			</div>
		</c:when>
		<c:otherwise>

			<div>
				<div id="informacion">
					¡Información!... Usted aun no cuenta con un informe.<br /> <span
						style="font-weight: bold;"></span> <br />Dirigase al menú Datos
					del Informe.
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</div>
</html>

<script type="text/javascript">

$(document).ready(
		function() {
			 $("#actualizar").hide();
			if ('${infestado}' == 'matriz'||'${infestadoinforme}' == 'finalizado') {
				tabla();			
			}
		
});
			
$("#btnGuardar").click(function(event) {
	var form = $("#TblMecanismoParticipacionCiudadana");	
	event.preventDefault();
	event.stopPropagation();
	if (form[0].checkValidity() === false) {
		mostrarMensaje(
				"Por favor ingrese toda la información solicitada!",
				"ERROR");
	} else {
		if( $(".descripcion1").val()=="" || $(".descripcion2").val()=="" || $(".descripcion3").val()=="" || $(".descripcion4").val()=="" || $(".descripcion5").val()=="" || $(".descripcion6").val()=="" || $(".descripcion7").val()==""){
			mostrarMensaje("Por favor ingrese los actores",	"ERROR");

		}else{
			$(".campo").removeAttr("disabled");
				ejecutarJson(form);
		}
	
	}
	form.addClass('was-validated');
});


function tabla() {
	var parametros = {"infCod" : '${infCod}'};
	$('#tablaRegistros').DataTable( {   
		ajax: {
		     data:parametros,
			url:"obtenerRegistrosMecanismoParticipacion",
			headers: {"X-CSRF-TOKEN": csrfToken},
		  	type:"POST"
			  },
	    order: [ 0, "asc" ],
		info:     false,
		paging : false,
		info : false,
		searching : false,
		responsive : true,
		scrollX : true,
		bDestroy : true,	
		buttons: [
		{extend: 'copyHtml5'},
	    {extend: 'csvHtml5'},
	    {extend: 'excelHtml5'},
	    {extend: 'pdfHtml5',orientation: 'landscape', pageSize: 'A1'},
	    {extend: 'print'},
	    ],
	    columns : [
			{data : "contador" },
			{data : "nombre"},
			{data : "implementado"},
			{data : "numero"},
			{data : "actores"},
			{data : "logros"},
			{data : "link"},	
			{ data: "" ,"render": function (data, type, full, meta) {
				 if('${infestadoinforme}' === "finalizado"){
	            	 data = '';     
	             }else{
                data = '<button type="button" id="Eliminar" class="_modificar btn _actualizarColor btn-sm"  onclick="Modificar(this)" title="Editar Registro" data-toggle="tooltip" data-placement="bottom" style="font-size:x-small;"> Editar</button>';    
	             }  return data;
    }}  ],
			language: {
	              url: "resources/json/lenguajeTablaDataTable.json"
	          },
		createdRow: function( row, data, dataIndex ) {
		     $(row).attr('id', data.mecaCod);
	       $(row).attr('ondragstart', 'drag(event)');
	       $(row).attr('draggable', 'false');
	       $(row).attr('data-destino', 'detalleItem');
	       $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
		                },
	    } );


}

function Modificar(element) {	
	var codigo = $(element).closest('tr').attr('id');
	  var nombre = $(element).parent().parent().find("td:eq(1)").text();
		var opcion = $(element).parent().parent().find("td:eq(2)").text();
		var numero = $(element).parent().parent().find("td:eq(3)").text();
		var actores = $(element).parent().parent().find("td:eq(4)").html();
		var logros = $(element).parent().parent().find("td:eq(5)").text();
		var link = $(element).parent().parent().find("td:eq(6)").text();
	  $("#actualizar").show();
	  $("#tabla").hide();	 	
		 $("#meca_cod").val(codigo);
		 var nombres = actores.split("<br>");
		 for (var i = 0; i < nombres.length; i++){
			 var supp = nombres[i];
			   switch (supp) {
			   case 'SECTORES':
				   $(".1").attr('checked','checked')
					   break;
			   case 'ENTIDADES':
				   $(".2").attr('checked','checked')
				   break;
			   case 'ORGANIZACIONES':
				   $(".3").attr('checked','checked')
				   break;
			   case 'OTROS':
				   $(".4").attr('checked','checked')
				   break;
			   }
			   
		 }
		 document.getElementById("mecani_nombre").innerHTML=nombre;
		  cargarValorComboPorDefecto("meca_implementado",opcion);
		  $("#meca_numero").val(numero);
		  $("#meca_desc_logros").val(logros);
		  $("#meca_medioverifica").val(link);
		  if(opcion=="SI"){
			  $(".campo").removeAttr('disabled');
			  $(".checkbox").removeAttr('disabled');
			 $(".campo").prop("required", true); 
			
		  }else if(opcion=="NO"){
			  $(".campo").prop("disabled", "disabled");
			  $(".checkbox").prop("disabled", "disabled");
				$("#meca_medioverifica").val("NO APLICA");
				 $("#meca_medioverifica").get(0).type = 'text';
				$(".campo").removeAttr("required");
		  }
	  
}
$("#btnActualizar").click(
		function(event) {
			var form = $("#TblMecanismosupdate")
			event.preventDefault();
			event.stopPropagation();
			if (form[0].checkValidity() === false) {
				mostrarMensaje(
						"Por favor ingrese toda la información solicitada!",
						"ERROR");
			} else {
				 $(".campo").removeAttr("disabled");
				 $("#meca_numero").removeAttr("disabled");
				 //
				 $(".1").prop("disabled", "disabled"); 
				 $(".2").prop("disabled", "disabled");
				 $(".3").prop("disabled", "disabled");
				 $(".4").prop("disabled", "disabled");
				if($("#meca_implementado").val()=="NO"){
						$("#meca_numero").val("0");
				}else{
					
				}
				var columnas = '';
				 var x = $(form).serializeArray();
				    $.each(x, function(i, field){
				    	columnas+= field.name+ ',99';
				    	if (columnas.length > 0) {
				    		columnas = columnas.substr(0, columnas.length - 1);
                        }
				    });
				    var valores = '';
					 var x = $(form).serializeArray();
					    $.each(x, function(i, field){
					    	valores+= field.value+ ',99';
					    	if (valores.length > 0) {
					    		valores = valores.substr(0, valores.length - 1);
	                        }
					    });
				  var data = {tabla: 'esq_rendicioncuentas.tbl_mecanismo_participacion_ciudadana',columns:columnas,values:valores,condicion:'meca_cod',valorcondicion:$("#meca_cod").val()};
				 
				  ejecutarJsonUpdate(form,data);
			}
			form.addClass('was-validated');

		});	

function validar(elemento) {

	if ($(elemento).val() === "SI"){
		 $(".campo").removeAttr('disabled');
		 $(".checkbox").removeAttr('disabled');
		 $(".campo").prop("required", true);
		 $(".url").val("http://");
		 $(".url").get(0).type = 'url';
		 $("#meca_numero").val("");
	
	}else if($(elemento).val() === "NO"){
		  $(".campo").prop("disabled", "disabled");
		  $(".checkbox").prop("disabled", "disabled");
			$("#meca_numero").val("0");
			$(".campo").val("");
			 $(".bloqueo").val("");
			 $("#meca_medioverifica").val("NO APLICA");
			 $(".checkbox").prop("disabled", "disabled");
			 $(".checkbox").prop('checked', false);
			 $("#meca_medioverifica").get(0).type = 'text';
			$(".campo").removeAttr("required");
		
	}else
	
	{
		
	}
}
$("#miTabla tr td").find("select").change(function () {
    if($(this).closest('td').index() == 1){
        if($(this).val() === "SI"){
            $(this).closest('tr').find(".campo").removeAttr('disabled');
            $(this).closest('tr').find(".checkbox").removeAttr('disabled');       
            $(this).closest('tr').find(".campo").prop("required", true);
            $(this).closest('tr').find(".url").val("http://");
            $(this).closest('tr').find(".url").get(0).type = 'url';
            $(this).closest('tr').find(".bloqueo").val("");
            }
        else if($(this).val() === "NO"){
            $(this).closest('tr').find(".campo").prop("disabled", true);
           $(this).closest('tr').find(".campo").val("");
           $(this).closest('tr').find(".campo").removeAttr("required");
           $(this).closest('tr').find(".campo").val("");
           $(this).closest('tr').find(".campo").val("");
           $(this).closest('tr').find(".url").val("NO APLICA");
           $(this).closest('tr').find(".url").get(0).type = 'text';
           $(this).closest('tr').find(".checkbox").prop("disabled", true);
           $(this).closest('tr').find(".bloqueo").val("0");
           $(this).closest('tr').find(".numero").val("0");
           
        }
        else{
        	$(this).closest('tr').find(".bloqueo").val("");
            }
    }

});
$('[name="checks1[]"]').click(function () {   
	 var arr = $('[name="checks1[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	 
	    $(this).closest('tr').find(".descripcion1").val(str);    
	  });
   
$('[name="checks2[]"]').click(function () {   
	 var arr = $('[name="checks2[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion2").val(str);		    
	  });
$('[name="checks3[]"]').click(function () {   
	 var arr = $('[name="checks3[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion3").val(str);		    
	  });
$('[name="checks4[]"]').click(function () {   
	 var arr = $('[name="checks4[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion4").val(str);		    
	  });
$('[name="checks5[]"]').click(function () {   
	 var arr = $('[name="checks5[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion5").val(str);		    
	  });	
$('[name="checks6[]"]').click(function () {   
	 var arr = $('[name="checks6[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion6").val(str);		    
	  });
$('[name="checks7[]"]').click(function () {   
	 var arr = $('[name="checks7[]"]:checked').map(function(){
	      return this.value;
	    }).get();
	    var str = arr.join('<br>');	
	    var row = $(this).closest("tr");   
	     $(this).closest('tr').find(".descripcion7").val(str);		    
	  });
</script>
