<%-- 
    version     : 1.0
    Document    : valoracionInformeGAD
    Property    : CPCCS
    Author      : Juan Carlos Vega
    Mail        : jc.vega@live.com
    Date        : 15/10/2021, 7:39
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
    prefix="sec"%>
<%@ page import="gob.cpccs.utilidades.Constantes"%>
<spring:url value="/resources/" var="urlPublic" />
<c:set var="tamanioArchivo"
    value="<%=Constantes.TAMANIO_ARCHIVO_25_MEGAS%>" />
<c:set var="rutaModuloRetroalimentacion"
    value="<%=Constantes.RUTA_ARCHIVOS_MODULO_RETROALIMENTACION%>" />
    <c:set var="periodo"
    value="<%=Constantes.periodo()%>" />
<sec:authentication var="usuario" property="principal" />
<c:set var="rutaArchivosAplicacion" value="<%=Constantes.RUTA_SERVIDOR_ARCHIVOS%>" />
<%@ page session="false"%>
<!DOCTYPE">
<html>
<div class="card text-center mb-card20">
    <div class="card-header ">
        <h5>Formulario para la valoración de informes</h5>
    </div>
    <div class="card-body">

        <div class="row">

            <div class="col-md-12 order-md-1">
                <!--form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="formularioEvaluacion"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" "-->
                    
                    
                    <!-- Nav pills -->
                <ul class="nav nav-tabs nav-pills">
                    <li class="nav-item"><a class="nav-link active" data-toggle="pill" href="#home">MATRIZ 1</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu1">MATRIZ 2</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu2">MATRIZ 3</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu3">MATRIZ 4</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu4">MATRIZ 5</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu5">MATRIZ 6</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu6">MATRIZ 7</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu7">MATRIZ 8</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu8">MATRIZ 9</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu9">MATRIZ 10</a></li>
                    <li class="nav-item"><a class="nav-link" data-toggle="pill" href="#menu10">MATRIZ 11</a></li>
                </ul>
   <hr/>
                <!-- Tab panes -->
                
                <!-- Tab panes -->
                <div class="tab-content">
                    <div class="tab-pane container active" id="home">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_1"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <input type="hidden" name="identificadorResponsable"
                        id="identificadorResponsable" value="${identificadorResponsable}">

                    <input type="hidden" name="infcod" id="infcod" value="${infcod}">
                    <input type="hidden" name="periodoInforme" id="periodoInforme" value="${periodoInforme}">                   
                    
            
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">Datos de la
                            institución</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_1" name="id_informe_1" value="${detalle1.idInfCal}">
                        
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="nombreInstitución">Nombre de la
                                        Institución:</label>
                                </div>
                                <div class="col-md-9 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="nombreInstitución" name="nombreInstitución" disabled
                                        value="${nombreInstitución}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="identificadorInstitucion">Ruc:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="identificadorInstitucion" name="Institucion"
                                        disabled value="${identificadorInstitucion}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="funcionInstitucion">Función:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="funcionInstitucion" name="funcionInstitucion" disabled
                                        value="${funcionInstitucion}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="descripcionInstitucion">Descripción:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="descripcionInstitucion" name="descripcionInstitucion"
                                        disabled value="${descripcionInstitucion}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="sectorInstitucion">Sector:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="sectorInstitucion" name="sectorInstitucion" disabled
                                        value="${sectorInstitucion}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="representanteLegal">Representante Legal:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="representanteLegal" name="representanteLegal" disabled
                                        value="${representanteLegal}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="numeroInforme">Número de Informe:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="numeroInforme" name="numeroInforme" disabled
                                        value="${infcod}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="tipoInforme">Tipo de Informe:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="tipoInforme" name="tipoInforme" disabled
                                        value="${tipoFormulario}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="fechaFinInforme">Fecha de presentación:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="fechaFinInforme" name="fechaFinInforme" disabled
                                        value="${fecha}" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-md-2 text-left">
                                    <label for="estadoInforme">Estado Informe:</label>
                                </div>
                                <div class="col-md-6 text-left">
                                    <input type="text" class="form-control form-control-sm"
                                        id="estadoInforme" name="estadoInforme" disabled
                                        value="${estado}" />
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta1">¿LA ENTIDAD PRESENTÓ SU INFORME DE RENDICIÓN DE CUENTAS DENTRO DEL PLAZO CORRESPONDIENTE PARA EL PROCESO ${periodoInforme}?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm"
                                        id="cmbpregunta1" required="required" name="cmbpregunta1">
                                        <option value="">Seleccione...</option>
                                        <option value="SI">SI</option>
                                        <option value="NO">NO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>

                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu1">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_2"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO
                            DE LA EJECUCIÓN PRESUPUESTARIA</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_2" name="id_informe_2" value="${detalle2.idInfCal}">
                    
                    

                            <table id="TablaActualizarDetallePoa"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th width="5%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">#</th>
                                        <th width="5%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">TIPO</th>
                                        <th width="30%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">DESCRIPCIÓN</th>
                                        <th width="10%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO
                                            CODIFICADO</th>
                                        <th width="10%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">PRESUPUESTO
                                            EJECUTADO</th>
                                        <th width="10%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">%
                                            CUMPLIMIENTO DEL PRESUPUESTO</th>
                                        <th width="20%"
                                            style="text-align: center; vertical-align: middle; font-size: x-small;">LINK
                                            AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA
                                            INSTITUCIÓN</th>

                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta2">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SU PRESUPUESTO?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta2" required="required" name="cmbPregunta2">
                                        <option value="">Seleccione...</option>
                                        <option value="1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS">1. CÉDULA PRESUPUESTARIA DEL MINISTERIO DE FINANZAS</option>
                                        <option value="2. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN">2. DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA EL PRESUPUESTO Y SU EJECUCIÓN</option>
                                        <option value="3. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE">3. INFORME DE GESTIÓN FINANCIERA APROBADO POR AUTORIDAD COMPETENTE</option>
                                        <option value="4. ESTADOS FINANCIEROS APROBADOS POR SUPERRICAS O SRI">4. ESTADOS FINANCIEROS APROBADOS POR SUPERRICAS O SRI</option>
                                        <option value="5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA">5. MATRIZ DE LOTAIP QUE SÍ DIRECCIONA A LA CÉDULA PRESUPUESTARIA</option>
                                        <option value="6. E.P EN LIQUIDACIÓN - DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA Y LIQUIDA EL PRESUPUESTO">6. E.P EN LIQUIDACIÓN - DOCUMENTO OFICIAL DONDE LA AUTORIDAD APRUEBA Y LIQUIDA EL PRESUPUESTO</option>
                                        <option value="7. NO ABRE EL LINK">7. NO ABRE EL LINK</option>
                                        <option value="8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">8. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="9. RESPONDE EN 0">9. RESPONDE EN 0</option>
                                        <option value="10. OTROS, NO CUMPLE">10. OTROS, NO CUMPLE</option>
                                        <option value="11. VACÍO">11. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia1" style="display:${detalle2.evidencia != null ? 'none' : detalle2.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia1">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle2.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia1"
                                        name="evidencia1" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo1" id="rutaArchivo1"
                                        name="rutaArchivo1" value="${detalle2.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo1"
                                        class="subirArchivo1 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo1 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo1" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia1" class="form-group row" >
                                        <%-- style="display:${detalle2.evidencia == null ? 'none' : detalle2.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia1">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink1" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle2.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink1" id="evidenciaRutaLink1"
                                                    value="${detalle2.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer1">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>

                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu2">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_3"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">BALANCE GENERAL</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_3" name="id_informe_3" value="${detalle3.idInfCal}">
                    

                    <table id="tablaRegistrosBalanceGeneral" class="table table-striped table-bordered"
                style="width: 100%">
                <thead>
                    <tr>
                        <th >#</th>
                        <th width="10%" style="text-align: center; font-size:x-small;">ACTIVOS</th>
                        <th width="10%" style="text-align: center; font-size:x-small;">PASIVOS</th>
                        <th width="10%" style="text-align: center; font-size:x-small;">PATRIMONIO</th>
                        <th width="50%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
       

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta3">¿LA EMPRESA PÚBLICA PRESENTA SU BALANCE GENERAL?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta3" required="required" name="cmbPregunta3">
                                        <option value="">Seleccione...</option>
                                        <option value="1. BALANCE GENERAL">1. BALANCE GENERAL</option>
                                        <option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
                                        <option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="4. RESPONDE EN 0">4. RESPONDE EN 0</option>
                                        <option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
                                        <option value="6. VACÍO">6. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia2" style="display:${detalle3.evidencia != null ? 'none' : detalle3.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia2">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle3.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia2"
                                        name="evidencia2" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo2" id="rutaArchivo2"
                                        name="rutaArchivo2" value="" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo2"
                                        class="subirArchivo2 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo2 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo2" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia2" class="form-group row" >
                                        <%-- style="display:${detalle3.evidencia == null ? 'none' : detalle3.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia2">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink2" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle3.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink2" id="evidenciaRutaLink2"
                                                    value="${detalle3.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer2">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>

                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu3">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_4"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">PROCESOS DE
                            CONTRATACIÓN Y COMPRAS PÚBLICAS DE BIENES Y SERVICIOS</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_4" name="id_informe_4" value="${detalle4.idInfCal}">
                    
                    
                            <table id="tablaRegistrosProcesosContratacion"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>TIPO DE CONTRATACIÓN</th>
                                        <th>ESTADO ACTUAL</th>
                                        <th>LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PAG.
                                            WEB DE LA INSTITUCIÓN</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta4">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE SUS CONTRATACIONES PÚBLICAS?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta4" required="required" name="cmbPregunta4">
                                        <option value="">Seleccione...</option>
                                        <option value="1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP">1. PRESENTA DOS REPORTES SEMESTRALES POR TIPO DE CONTRATACIÓN PUBLICA, DESCARGADOS DEL SISTEMA DE SERCOP</option>
                                        <option value="2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS">2. LLEVA A LINK AL REPORTE PÚBLICO DE INTELIGENCIA DE NEGOCIOS DE SERCOP, DEL SUJETO OBLIGADO A RENDIR CUENTAS</option>
                                        <option value="3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN">3. PRESENTA ACTAS DE ADJUDICACIÓN E INFORMES DE LIQUIDACIÓN</option>
                                        <option value="4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)">4. PRESENTA ACTA ENTREGA RECEPCIÓN DE PROCESOS (DEFINITVA)</option>
                                        <option value="5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA">5. LLEVA A MATRIZ DE LOTAIP, QUE SI DIRECCIONA A LOS PROCESOS DE CONTRATACIÓN PÚBLICA</option>
                                        <option value="6. NO ABRE EL LINK">6. NO ABRE EL LINK</option>
                                        <option value="7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">7. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="8. RESPONDE EN 0">8. RESPONDE EN 0</option>
                                        <option value="9. OTROS, NO CUMPLE">9. OTROS, NO CUMPLE</option>
                                        <option value="10. VACÍO">10. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia3" style="display:${detalle4.evidencia != null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}">
                        <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia3">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle4.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia3"
                                        name="evidencia3" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo3" id="rutaArchivo3"
                                        name="rutaArchivo3" value="${detalle4.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo3"
                                        class="subirArchivo3 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo3 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo3" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>      
                            </div>  
                            
                            <div id="VerArchivoEvdidencia3" class="form-group row" >
                                        <%-- style="display:${detalle4.evidencia == null ? 'none' : detalle4.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia3">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink3" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle4.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink3" id="evidenciaRutaLink3"
                                                    value="${detalle4.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer3">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                                        
                    </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu4">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_5"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DE OBLIGACIONES (LOCPCCS Art. 10 NUMERAL 7)</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_5" name="id_informe_5" value="${detalle5.idInfCal}">
                        <input type="hidden" id="id_informe_6" name="id_informe_6" value="${detalle6.idInfCal}">
                    

                    <table id="tablaRegistrosCO" class="table table-striped table-bordered"
                style="width: 100%">
                <thead>
            
                    <tr>
                        <th >#</th>
                        <th width="10%" style="text-align: center; font-size:x-small;">LABORALES</th>
                        <th width="10%" style="text-align: center; font-size:x-small;">TRIBUTARIAS</th>
                        <th width="80%" style="text-align: center; font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
       

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta5">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES TRIBUTARIAS?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm"
                                        id="cmbPregunta5" required="required" name="cmbPregunta5">
                                        <option value="">Seleccione...</option>
                                        <option value="1.CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI">1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL SRI</option>
                                        <option value="2.CERTIFICADO EMITIDO POR SRI Y SENAE">2. CERTIFICADO EMITIDO POR SRI Y SENAE</option>
                                        <option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
                                        <option value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="5. NO APLICA">5. NO APLICA</option>
                                        <option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
                                        <option value="7. VACÍO">7. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div id="divevidencia4" style="display:${detalle5.evidencia != null ? 'none' : detalle5.evidencia == 'N/A' ? 'none' : 'visible'}">
                        <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia4">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle5.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia4"
                                        name="evidencia4" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo4" id="rutaArchivo4"
                                        name="rutaArchivo4" value="${detalle5.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo4"
                                        class="subirArchivo4 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo4 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo4" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>      
                            </div>  
                            
                            <div id="VerArchivoEvdidencia4" class="form-group row" >
                                        <%-- style="display:${detalle5.evidencia == null ? 'none' : detalle5.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia4">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink4" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle5.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink4" id="evidenciaRutaLink4"
                                                    value="${detalle5.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer4">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                                        
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta6">¿LA EMPRESA PÚBLICA PRESENTA INFORMACIÓN DE CUMPLIMIENTO DE OBLIGACIONES LABORALES?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm"
                                        id="cmbPregunta6" required="required" name="cmbPregunta6">
                                        <option value="">Seleccione...</option>
                                        <option value="1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS">1. CERTIFICADO DE NO TENER OBLIGACIONES PENDIENTES EN EL IESS</option>
                                        <option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
                                        <option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="4. NO APLICA">4. NO APLICA</option>
                                        <option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
                                        <option value="6. VACÍO">6. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia5" style="display:${detalle6.evidencia != null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia5">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle6.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia5"
                                        name="evidencia5" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo5" id="rutaArchivo5"
                                        name="rutaArchivo5" value="${detalle6.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo5"
                                        class="subirArchivo5 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo5 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo5" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia5" class="form-group row" >
                                        <%-- style="display:${detalle6.evidencia == null ? 'none' : detalle6.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia5">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink5" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle6.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink5" id="evidenciaRutaLink5"
                                                    value="${detalle6.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer5">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>

                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu5">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_6"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">MECANISMOS
                            DE PARTICIPACIÓN CIUDADANA</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_7" name="id_informe_7" value="${detalle7.idInfCal}">
                    
                    
                            <table id="tablaRegistrosMecanismosParticionCiudadanaFE"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th style="text-align: left; font-size: x-small;">MECANISMOS
                                            DE PARTICIPACIÓN CIUDADANA</th>
                                        <th style="text-align: left; font-size: x-small;">PONGA
                                            SI O NO</th>
                                        <th style="text-align: left; font-size: x-small;">NÚMERO
                                            DE MECANISMOS IMPLEMENTADOS EN EL AÑO</th>
                                        <th style="text-align: left; font-size: x-small;">MEDIO
                                            DE VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta7">¿LA ENTIDAD SUSTENTA LA EJECUCIÓN DE MECANISMOS DE PARTICIPACIÓN CIUDADANA?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm"
                                        id="cmbPregunta7" required="required" name="cmbPregunta7">
                                        <option value="">Seleccione...</option>
                                        <option value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
                                        <option value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS">2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS</option>
                                        <option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
                                        <option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
                                        <option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN</option>
                                        <option value="6. NO APLICA">6. NO APLICA</option>
                                        <option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
                                        <option value="8. VACÍO">8. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia6" style="display:${detalle7.evidencia != null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia6">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle7.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia6"
                                        name="evidencia6" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo6" id="rutaArchivo6"
                                        name="rutaArchivo6" value="${detalle7.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo6"
                                        class="subirArchivo6 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo6 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo6" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia6" class="form-group row" >
                                        <%-- style="display:${detalle7.evidencia == null ? 'none' : detalle7.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia6">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink6" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle7.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink6" id="evidenciaRutaLink6"
                                                    value="${detalle7.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer6">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu6">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_7"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">PROCESO DE
                            RENDICIÓN DE CUENTAS</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_8" name="id_informe_8" value="${detalle8.idInfCal}">
                        <input type="hidden" id="id_informe_9" name="id_informe_9" value="${detalle9.idInfCal}">
                        <input type="hidden" id="id_informe_10" name="id_informe_10" value="${detalle10.idInfCal}">
                        <input type="hidden" id="id_informe_11" name="id_informe_11" value="${detalle11.idInfCal}">
                        <input type="hidden" id="id_informe_12" name="id_informe_12" value="${detalle12.idInfCal}">
                    
                    
                            <table id="TablaRendicionFases"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th style="font-size: xx-small;">#</th>
                                        <th style="font-size: xx-small;">FASE</th>
                                        <th style="font-size: xx-small;">PROCESO DE RENDICIÓN DE
                                            CUENTAS</th>
                                        <th style="font-size: xx-small;">PONGA SI O NO</th>
                                        <th style="font-size: xx-small;">DESCRIBA LA EJECUCIÓN DE
                                            LOS PASOS</th>
                                        <th style="font-size: xx-small;">LINK AL MEDIO DE
                                            VERIFICACIÓN</th>

                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>


                            <table id="TablaRendicionFasesAporte"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta8">¿LA ENTIDAD SUSTENTA LA RECEPCIÓN DEL LISTADO DE TEMAS SOBRE LOS CUALES LA CIUDADANÍA SOLICITA SE RINDA CUENTAS?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta8" required="required" name="cmbPregunta8">
                                        <option value="">Seleccione...</option>
                                        
                                        <option value="1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS, DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DE LA E.P DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO">1. OFICIO O DOCUMENTO FIRMADO POR LOS CIUDADANOS, DEL LISTADO DE TEMAS SOBRE LOS CUALES SOLICITA A LA AUTORIDAD DE LA E.P DEL GAD QUE RINDA CUENTAS, CON SU RESPECTIVO RECIBIDO</option>
                                        <option value="2. RESPALDO DE LOS TEMAS QUE LOS CIUDADANOS PRESENTARON, A TRAVÉS DE MECANISMOS DIGITALES, A LA AUTORIDAD DE LA E.P DEL GAD PARA QUE RINDA CUENTAS">2. RESPALDO DE LOS TEMAS QUE LOS CIUDADANOS PRESENTARON, A TRAVÉS DE MECANISMOS DIGITALES, A LA AUTORIDAD DE LA E.P DEL GAD PARA QUE RINDA CUENTAS</option>
                                        <option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
                                        <option value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE  VERIFICACIÓN</option>
                                        <option value="5. NO APLICA">5. NO APLICA</option>
                                        <option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
                                        <option value="7. VACÍO">7. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div id="divevidencia7" style="display:${detalle8.evidencia != null ? 'none' : detalle8.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia7">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle8.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia7"
                                        name="evidencia7" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo7" id="rutaArchivo7"
                                        name="rutaArchivo7" value="${detalle7.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo7"
                                        class="subirArchivo7 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo7 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo7" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia7" class="form-group row" >
                                        <%-- style="display:${detalle8.evidencia == null ? 'none' : detalle8.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia7">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink7" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle8.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink7" id="evidenciaRutaLink7"
                                                    value="${detalle8.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer7">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                            
                            
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta9">¿LA ENTIDAD SUSTENTA LA ENTREGA DEL INFORME PRELIMINAR Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL CON 15 DÍAS DE ANTELACIÓN?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta9" required="required" name="cmbPregunta9">
                                        <option value="">Seleccione...</option>
                                        <option value="1. EL DOCUMENTO DE LA E.P DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN">1. EL DOCUMENTO DE LA E.P DEL GAD EN EL QUE LA ASAMBLEA CIUDADANA /CIUDADANÍA AFIRMAN HABER RECIBIDO EL INFORME & FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, CON 15 DÍAS DE ANTELACIÓN</option>
                                        <option value="2. ENVÍO VIRTUAL DEL INFORME Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA E.P DEL GAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN">2. ENVÍO VIRTUAL DEL INFORME Y FORMULARIO DE RENDICIÓN DE CUENTAS INSTITUCIONAL, POR PARTE DE LA E.P DEL GAD A LA ASAMBLEA CIUDADANA /CIUDADANÍA, Y CONFIRMACIÓN CIUDADANA DE RECIBIDO, CON 15 DÍAS DE ANTELACIÓN</option>
                                        <option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
                                        <option value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="5. NO APLICA">5. NO APLICA</option>
                                        <option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
                                        <option value="7. VACÍO">7. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div id="divevidencia8" style="display:${detalle9.evidencia != null ? 'none' : detalle9.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia8">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle9.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia8"
                                        name="evidencia8" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo8" id="rutaArchivo8"
                                        name="rutaArchivo8" value="${detalle9.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo8"
                                        class="subirArchivo8 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo8 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo8" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia8" class="form-group row" >
                                        <%-- style="display:${detalle9.evidencia == null ? 'none' : detalle9.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia8">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink8" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle9.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink8" id="evidenciaRutaLink8"
                                                    value="${detalle9.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer8">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                                <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta10">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DEL VIDEO DE LA DELIBERACIÓN PÚBLICA CON LA INTERVENCIÓN DE LA CIUDADANÍA?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta10" required="required" name="cmbPregunta10">
                                        <option value="">Seleccione...</option>
                                        <option value="1. LINK AL VIDEO EN EL QUE LA E.P DEL GAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA  -CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA">1. LINK AL VIDEO EN EL QUE LA E.P DEL GAD DEMUESTRA QUE LA ASAMBLEA CIUDADANA  -CIUDADANÍA SI TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA.</option>
                                        <option value="2. LINK AL VIDEO EN EL QUE LA E.P DEL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA">2. LINK AL VIDEO EN EL QUE LA E.P DEL GAD REALIZÓ LA DELIBERACIÓN PÚBLICA, PERO LA ASAMBLEA CIUDADANA /CIUDADANÍA NO TUVO UN TIEMPO PARA EVALUAR LA ENTIDAD EN LA DELIBERACIÓN PÚBLICA.</option>
                                        <option value="3. NO ABRE EL LINK">3. NO ABRE EL LINK</option>
                                        <option value="4. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">4. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="5. NO APLICA">5. NO APLICA</option>
                                        <option value="6. OTROS, NO CUMPLE">6. OTROS, NO CUMPLE</option>
                                        <option value="7. VACÍO">7. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div id="divevidencia9" style="display:${detalle10.evidencia != null ? 'none' : detalle10.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia9">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle10.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia9"
                                        name="evidencia9" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo9" id="rutaArchivo9"
                                        name="rutaArchivo9" value="${detalle10.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo9"
                                        class="subirArchivo9 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo9 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo9" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia9" class="form-group row" >
                                        <%-- style="display:${detalle10.evidencia == null ? 'none' : detalle10.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia9">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink9" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle10.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink9" id="evidenciaRutaLink9"
                                                    value="${detalle10.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer9">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                            
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta11">¿LA ENTIDAD SUSTENTA PLAN DE TRABAJO QUE INCORPORA LAS SUGERENCIAS CIUDADANAS EN SU GESTIÓN?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta11" required="required" name="cmbPregunta11">
                                        <option value="">Seleccione...</option>
                                        <option value="1. DOCUMENTO DEL PLAN DE TRABAJO DE LA E.P DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD">1. DOCUMENTO DEL PLAN DE TRABAJO DE LA E.P DEL GAD ELABORADO A PARTIR DE LOS INSUMOS DE LA DELIBERACIÓN PÚBLICA DEL GAD</option>
                                        <option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
                                        <option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="4. NO APLICA">4. NO APLICA</option>
                                        <option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
                                        <option value="6. VACÍO">6. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div id="divevidencia10" style="display:${detalle11.evidencia != null ? 'none' : detalle11.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia10">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle11.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia10"
                                        name="evidencia10" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo10" id="rutaArchivo10"
                                        name="rutaArchivo10" value="${detalle11.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo10"
                                        class="subirArchivo10 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo10 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo10" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia10" class="form-group row" >
                                        <%-- style="display:${detalle11.evidencia == null ? 'none' : detalle11.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia10">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink10" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle11.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink10" id="evidenciaRutaLink10"
                                                    value="${detalle11.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer10">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                        
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta12">¿LA ENTIDAD SUSTENTA LA ENTREGA DEL PLAN DE TRABAJO A LA ASAMBLEA CIUDADANA CON SU RESPECTIVO RECIBIDO?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta12" required="required" name="cmbPregunta12">
                                        <option value="">Seleccione...</option>
                                        <option value="1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA - CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO">1. DOCUMENTOS (DIGITAL O FÍSICO) CON EL RECIBIDO DE: LA ASAMBLEA CIUDADANA - CIUDADANÍA, CONSEJO DE PARTICIPACIÓN E INSTANCIA DE PARTICIPACIÓN, DE CONSTANCIA DE ENTREGA DEL PLAN DE TRABAJO</option>
                                        <option value="2. NO ABRE EL LINK">2. NO ABRE EL LINK</option>
                                        <option value="3. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">3. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="4. NO APLICA">4. NO APLICA</option>
                                        <option value="5. OTROS, NO CUMPLE">5. OTROS, NO CUMPLE</option>
                                        <option value="6. VACÍO">6. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia11" style="display:${detalle12.evidencia != null ? 'none' : detalle12.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia11">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle12.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia11"
                                        name="evidencia11" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo11" id="rutaArchivo11"
                                        name="rutaArchivo11" value="${detalle12.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo11"
                                        class="subirArchivo11 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo11 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo11" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia11" class="form-group row" >
                                        <%-- style="display:${detalle12.evidencia == null ? 'none' : detalle12.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia11">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink11" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle12.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink11" id="evidenciaRutaLink11"
                                                    value="${detalle12.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer11">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu7">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_8"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">CUMPLIMIENTO DEL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR IMPLEMENTADAS EN LA GESTIÓN INSTITUCIONAL</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_13" name="id_informe_13" value="${detalle13.idInfCal}">
                    
                        <table id="TablaIncorporacionRecom"
                        class="table table-striped table-bordered" style="width: 100%">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th style="font-size:x-small;">SUGERENCIA DE LA COMUNIDAD</th>
                                <th style="font-size:x-small;">RESULTADOS DE LA IMPLEMENTACIÓN DE LA SUGERENCIA CIUDADANA</th>
                                <th style="font-size:x-small;">PORCENTAJE DE AVANCE DE LA IMPLEMENTACIÓN</th>
                                <th style="font-size:x-small;">LINK AL MEDIO DE VERIFICACIÓN</th>                           
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                        
                                <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta13">¿LA ENTIDAD SUSTENTA HABER CUMPLIDO EL PLAN DE SUGERENCIAS CIUDADANAS DEL AÑO ANTERIOR, EN SU GESTIÓN INSTITUCIONAL?</label>
                                </div>
                                <div class="col-md-3 text-left">
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta13" required="required" name="cmbPregunta13">
                                        <option value="">Seleccione...</option>
                                        <option value="1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DE CUENTA DE LA IMPLEMENTACIÓN">1. ACTA, INFORME O DOCUMENTO OFICIAL QUE DE CUENTA DE LA IMPLEMENTACIÓN</option>
<!--                                        <option value="2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS">2. NO APLICA, PORQUE SE CREA EN EL AÑO DE RENDICIÓN DE CUENTAS</option> -->
                                        <option value="3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES">3. NO APLICA, PORQUE EL PROCESO ANTERIOR NO RECIBIÓ APORTES</option>
                                        <option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
                                        <option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="6. NO APLICA">6.  NO APLICA</option>
                                        <option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
                                        <option value="8. VACÍO">8. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <div id="divevidencia12" style="display:${detalle13.evidencia != null ? 'none' : detalle13.evidencia == 'N/A' ? 'none' : 'visible'}">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia12">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" ${detalle13.evidencia == null ? 'required="required"' : ''}
                                        class="form-control-file archivo gris" id="evidencia12"
                                        name="evidencia12" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo12" id="rutaArchivo12"
                                        name="rutaArchivo12" value="${detalle13.evidencia}" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo12"
                                        class="subirArchivo12 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo12 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo12" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div>
                            
                            <div id="VerArchivoEvdidencia12" class="form-group row" >
                                        <%-- style="display:${detalle13.evidencia == null ? 'none' : detalle13.evidencia == 'N/A' ? 'none' : 'visible'}"> --%>
                                            <div class="col-md-3 text-left">
                                                <label for="linkEvidencia12">Archivo de Verificación
                                                </label>
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <a id="evidenciaLink12" target="_blank"
                                                    href="${rutaArchivosAplicacion}${detalle13.evidencia}" class="archivoCargado">Click
                                                    aquí para ver archivo</a> <input type="hidden"
                                                    name="evidenciaRutaLink12" id="evidenciaRutaLink12"
                                                    value="${detalle13.evidencia}">
                                            </div>
                                            <div class="col-md-3 text-left">
                                                <button type="button"
                                                    class="adjunto btn _eliminarColor btn-sm"
                                                    id="EliminarArchiServer12">
                                                    <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                                </button>
                                            </div>

                                        </div>
                                        
                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu8">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_9"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">MECANISMOS
                            DE CONTROL SOCIAL</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_14" name="id_informe_14" value="${detalle14.idInfCal}">
                    
                    
                            <table id="TablaContSocial"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th style="font-size: x-small;">#</th>
                                        <th style="font-size: x-small;">MECANISMOS DE CONTROL
                                            SOCIAL GENERADOS POR LA COMUNIDAD</th>
                                        <th style="font-size: x-small;">PONGA SI O NO</th>
                                        <th style="font-size: x-small;">NÚMERO DE MECANISMOS</th>
                                        <th style="font-size: x-small;">LINK AL MEDIO DE
                                            VERIFICACIÓN PUBLICADO EN LA PÁG. WEB DE LA INSTITUCIÓN</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta14">¿LA ENTIDAD SUSTENTA LA REALIZACIÓN DE MECANISMOS DE CONTROL SOCIAL?</label>
                                </div>
                                <div class="col-md-3 text-left">
        <!--                            <select class="custom-select custom-select-sm" onchange="adjuntarEvidencia(this, divevidencia8);" -->
                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta14" required="required" name="cmbPregunta14">
                                        <option value="">Seleccione...</option>
                                        <option value="1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA">1. ACTA O MEMORIAS DE REUNIONES Y REGISTROS DE ASISTENCIA</option>
                                        <option value="2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE ASISTENCIAS">2. INFORME DE IMPLEMENTACIÓN ANUAL POR CADA MECANISMO IMPLEMENTADO Y REGISTRO DE   ASISTENCIAS</option>
                                        <option value="3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)">3. ACTA/ MEMORIAS DE REUNIONES (VALE MITAD)</option>
                                        <option value="4. NO ABRE EL LINK">4. NO ABRE EL LINK</option>
                                        <option value="5. EL LINK NO DIRECCIONA AL MEDIO DE VERIFICACIÓN">5. EL LINK NO DIRECCIONA AL MEDIO DE
                                            VERIFICACIÓN</option>
                                        <option value="6. NO APLICA">6. NO APLICA</option>
                                        <option value="7. OTROS, NO CUMPLE">7. OTROS, NO CUMPLE</option>
                                        <option value="8. VACÍO">8. VACÍO</option>
                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <%-- <div id="divevidencia8" style="display:visible">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia8">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" required="required"
                                        class="form-control-file archivo gris" id="evidencia8"
                                        name="evidencia8" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo8" id="rutaArchivo8"
                                        name="rutaArchivo8" value="" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo8"
                                        class="subirArchivo8 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo8 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo8" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>
                                </div>
                            </div> --%>
                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu9">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="matriz_10"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">IMPLEMENTACIÓN
                            DE POLÍTICAS PÚBLICAS PARA LA IGUALDAD</h5>
                        <div class="card-body">
                        
                        <input type="hidden" id="id_informe_15" name="id_informe_15" value="${detalle15.idInfCal}">
                        <input type="hidden" id="id_informe_16" name="id_informe_16" value="${detalle16.idInfCal}">
                        <input type="hidden" id="id_informe_17" name="id_informe_17" value="${detalle17.idInfCal}">
                        <input type="hidden" id="id_informe_18" name="id_informe_18" value="${detalle18.idInfCal}">
                        <input type="hidden" id="id_informe_19" name="id_informe_19" value="${detalle19.idInfCal}">
                    
                            <table id="TablaImpleIgualdad"
                                class="table table-striped table-bordered" style="width: 100%">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th style="font-size: x-small;">IMPLEMENTACIÓN DE
                                            POLÍTICAS PÚBLICAS PARA LA IGUALDAD</th>
                                        <th style="font-size: x-small;">PONGA SI O NO</th>
                                        <th style="font-size: x-small;">DESCRIBA LA POLÍTICA
                                            IMPLEMENTADA</th>
                                        <th style="font-size: x-small;">DETALLE PRINCIPALES
                                            RESULTADOS OBTENIDOS</th>
                                        <th style="font-size: x-small;">EXPLIQUE CÓMO APORTA EL
                                            RESULTADO AL CUMPLIMIENTO DE LAS AGENDAS DE IGUALDAD</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta18">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD INTERCULTURAL?</label>
                                </div>
                                <div class="col-md-3 text-left">
<!--                                    <select class="custom-select custom-select-sm" onchange="adjuntarEvidenciaMultiple(divevidencia9);"
 -->                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta18" required="required" name="cmbPregunta18">
                                        <option value="">Seleccione...</option>
                                        <option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y  DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="3. REPORTA NO">3. REPORTA NO</option>
                                        <option value="4. VACÍO">4. VACÍO</option>

                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta16">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD GENERACIONAL?</label>
                                </div>
                                <div class="col-md-3 text-left">
<!--                                    <select class="custom-select custom-select-sm" onchange="adjuntarEvidenciaMultiple(divevidencia9);"
 -->                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta16" required="required" name="cmbPregunta16">
                                        <option value="">Seleccione...</option>
                                        <option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y  DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="3. REPORTA NO">3. REPORTA NO</option>
                                        <option value="4. VACÍO">4. VACÍO</option>

                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta17">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN DISCAPACIDADES?</label>
                                </div>
                                <div class="col-md-3 text-left">
<!--                                    <select class="custom-select custom-select-sm" onchange="adjuntarEvidenciaMultiple(divevidencia9);"
 -->                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta17" required="required" name="cmbPregunta17">
                                        <option value="">Seleccione...</option>
                                        <option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y  DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="3. REPORTA NO">3. REPORTA NO</option>
                                        <option value="4. VACÍO">4. VACÍO</option>

                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta15">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN GÉNERO?</label>
                                </div>
                                <div class="col-md-3 text-left">
<!--                                    <select class="custom-select custom-select-sm" onchange="adjuntarEvidenciaMultiple(divevidencia9);"
 -->                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta15" required="required" name="cmbPregunta15">
                                        <option value="">Seleccione...</option>
                                        <option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y  DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="3. REPORTA NO">3. REPORTA NO</option>
                                        <option value="4. VACÍO">4. VACÍO</option>

                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>

                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="pregunta19">¿LA ENTIDAD ARGUMENTA LA REALIZACIÓN DE LA(S) POLÍTICAS DE IGUALDAD EN MOVILIDAD HUMANA?</label>
                                </div>
                                <div class="col-md-3 text-left">
<!--                                    <select class="custom-select custom-select-sm" onchange="adjuntarEvidenciaMultiple(divevidencia9);"
 -->                                    <select class="custom-select custom-select-sm" 
                                        id="cmbPregunta19" required="required" name="cmbPregunta19">
                                        <option value="">Seleccione...</option>
                                        <option value="1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">1. SI, Y REPORTA INFORMACIÓN EN AMBAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA Y  DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS">2. SI, Y REPORTA INFORMACIÓN EN UNA DE LAS COLUMNAS DESCRIBA LA POLÍTICA IMPLEMENTADA O DETALLE LOS PRINCIPALES RESULTADOS IMPLEMENTADOS</option>
                                        <option value="3. REPORTA NO">3. REPORTA NO</option>
                                        <option value="4. VACÍO">4. VACÍO</option>

                                    </select>
                                    <div class="invalid-feedback">Por favor seleccione la
                                        respuesta</div>
                                </div>
                            </div>
                            <%-- <div id="divevidencia9" style="display:visible">
                            <div class="form-group row">
                                <div class="col-md-3 text-left">
                                    <label for="evidencia9">Adjuntar captura de pantalla de
                                        la matriz evaluada: Formato .jpeg, .jpg, .png, .pdf, .doc,
                                        .docx</label>
                                </div>
                                <div class="col-md-5 text-left waves-effect float-left">
                                    <input type="file" required="required"
                                        class="form-control-file archivo gris" id="evidencia9"
                                        name="evidencia9" accept="application/pdf,application/msword,application/vnd.openxmlformats-officedocument.wordprocessingml.document,image/jpeg,image/gif,image/bmp,image/png">

                                    <div class="estadoCarga">En espera de archivo... (Tamaño
                                        máximo ${tamanioArchivo})</div>
                                    <input type="hidden" class="rutaArchivo9" id="rutaArchivo9"
                                        name="rutaArchivo9" value="" />
                                    <div class="invalid-feedback">Por favor seleccione un
                                        archivo</div>
                                </div>

                                <div class="col-md-3 text-left">
                                    <button type="button" id="subirArchivo9"
                                        class="subirArchivo9 adjunto btn _nuevoColor btn-sm"
                                        data-rutaCarga="${rutaModuloRetroalimentacion}">
                                        <i class="fas fa-cloud-upload-alt mr-1" aria-hidden="true"></i>Subir
                                        archivo
                                    </button>

                                    <button type="button"
                                        class="EliminarArchivo9 adjunto btn _eliminarColor btn-sm"
                                        id="EliminarArchivo9" disabled="disabled">
                                        <i class="fas fa-trash mr-1" aria-hidden="true"></i>Eliminar
                                    </button>
                                </div>

                            </div>
                            </div> --%>
                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    <div class="tab-pane container fade" id="menu10">
                    
                    <form:form class="needs-validation" novalidate=""
                    modelAttribute="TblInformeCalificado" id="formularioEvaluacion"
                    data-rutaAplicacion="rendicion/valoracion" data-opcion="guardarEvaluacionGADEP"
                    data-destino="detalleItem" data-accionEnExito=" ">
                    
                    <div class="card">
                        <h5 class="card-header text-white carHeaderBlue">Observación</h5>
                        <div class="card-body">
                            <div class="form-group row">
                                <div class="col-md-9 text-left">
                                    <label for="observacion">Describa la o las razones que
                                        motivaron la evaluación del presente informe, recuerde que
                                        está observación puede aparecer en el email que será remitido
                                        a la institución</label>
                                </div>

                                <textarea rows="4" cols="" class="form-control form-control-sm"
                                    id="observacion" name="observacion"
                                    placeholder="Ingrese el comentario aquí"></textarea>
                                <div class="invalid-feedback">Por favor ingrese el
                                    comentario</div>
                            </div>


                        </div>
                    </div>
                    
                    </form:form>
                    
                    </div>
                    
                    
                    
                </div>
    
                    
                    <div class="col-md-12 text-center">
                        <button type="submit" id="btnGuardar"
                            class="btn _nuevoColor _guardar btn-sm mt-2">Guardar</button>
                    </div>
                    
                    <div class="col-md-12 text-center">
                        <button type="submit" id="btnFinalizar" hidden="true"
                            class="btn _imprimirColor _guardar btn-sm mt-2">Finalizar Evaluación</button>
                    </div>

            </div>
        </div>
    </div>
</div>
</html>

<script type="text/javascript">

var nombreFormulario;
var retornoJson;
var nombreDiv="";
var nombreDiv1="";
var nombreDiv2="";
var nombreDiv3="";
var nombreDiv4="";
var v1, v2, v3, v4, v5, v6, v7, v8, v9, v10;

function cargaDatos(id) {
    
    validarIdInforme(id);
    
}

$("#EliminarArchiServer1").click(function(event) {
    
    $("#divevidencia1").show();
    $("#evidenciaLink1").val(null);
    $("#evidencia1").val(null);
    $("#rutaArchivo1").val(null);
    $("#subirArchivo1").disabled = true;
    
    //document.getElementById("evidencia1").required = true;
    //this.form.reset();
    $("#evidencia1").attr("required", "required");
    //$("#VerArchivoEvdidencia1").hide();
    
});

$("#cmbPregunta2").change(function(event) {

    if("11. VACÍO" === $("#cmbPregunta2").val()){
        document.getElementById("evidencia1").required = false;
        $("#evidencia1").removeAttr("required");
        $("#evidenciaLink1").val(null);
        $("#evidencia1").val(null);
        $("#rutaArchivo1").val(null);
        $("#divevidencia1").hide(); 
        //$("#VerArchivoEvdidencia1").hide();
    }else {
        
        //document.getElementById("evidencia1").required = true;
        $("#evidencia1").attr("required", "required");
        $("#divevidencia1").show();
        //$("#VerArchivoEvdidencia1").hide();

    }
    
});

$("#EliminarArchiServer2").click(function(event) {
    
    $("#divevidencia2").show();
    $("#evidenciaLink2").val(null);
    $("#evidencia2").val(null);
    $("#rutaArchivo2").val(null);
    $("#subirArchivo2").disabled = true; 
    
    //document.getElementById("evidencia2").required = true;
    $("#evidencia2").attr("required", "required");
    //$("#VerArchivoEvdidencia2").hide();
    
});

$("#cmbPregunta3").change(function(event) {

    if("6. VACÍO" === $("#cmbPregunta3").val()){
        //document.getElementById("evidencia2").required = false;
        $("#evidencia2").removeAttr("required");    
        $("#evidenciaLink2").val(null);
        $("#evidencia2").val(null);
        $("#rutaArchivo2").val(null);
        $("#divevidencia2").hide();
        //$("#VerArchivoEvdidencia2").hide();
    }else {
        
        //document.getElementById("evidencia2").required = true;
        $("#evidencia2").attr("required", "required");
        $("#divevidencia2").show();
        //$("#VerArchivoEvdidencia2").hide();

    }
    
});

$("#EliminarArchiServer3").click(function(event) {
    
    $("#divevidencia3").show();
    $("#evidenciaLink3").val(null);
    $("#evidencia3").val(null);
    $("#rutaArchivo3").val(null);
    $("#subirArchivo3").disabled = true; 
    
    //document.getElementById("evidencia3").required = true;
    $("#evidencia3").attr("required", "required");
    //$("#VerArchivoEvdidencia3").hide();
    
});

$("#cmbPregunta4").change(function(event) {

    if("10. VACÍO" === $("#cmbPregunta4").val()){
        //document.getElementById("evidencia3").required = false;
        $("#evidencia3").removeAttr("required");        
        $("#evidenciaLink3").val(null);
        $("#evidencia3").val(null);
        $("#rutaArchivo3").val(null);
        $("#divevidencia3").hide();
    //  $("#VerArchivoEvdidencia3").hide();
    }else {
        
        //document.getElementById("evidencia3").required = true;
        $("#evidencia3").attr("required", "required");
        $("#divevidencia3").show();
    //  $("#VerArchivoEvdidencia3").hide();

    }
    
});

$("#EliminarArchiServer4").click(function(event) {
    
    $("#divevidencia4").show();
    $("#evidenciaLink4").val(null);
    $("#evidencia4").val(null);
    $("#rutaArchivo4").val(null);
    $("#subirArchivo4").disabled = true; 
    
    //document.getElementById("evidencia4").required = true;
    $("#evidencia4").attr("required", "required");
    //$("#VerArchivoEvdidencia4").hide();
    
});

$("#cmbPregunta5").change(function(event) {

    if(("7. VACÍO" === $("#cmbPregunta5").val()) || ("5. NO APLICA" === $("#cmbPregunta6").val())){
        document.getElementById("evidencia4").required = false;
        $("#evidencia4").removeAttr("required");
        $("#evidenciaLink4").val(null);
        $("#evidencia4").val(null);
        $("#rutaArchivo4").val(null);
        $("#divevidencia4").hide();
        //$("#VerArchivoEvdidencia4").hide();
    }else {
        
        //document.getElementById("evidencia4").required = true;
        $("#evidencia4").attr("required", "required");
        $("#divevidencia4").show();
        //$("#VerArchivoEvdidencia4").hide();

    }
    
});

$("#EliminarArchiServer5").click(function(event) {
    
    $("#divevidencia5").show();
    $("#evidenciaLink5").val(null);
    $("#evidencia5").val(null);
    $("#rutaArchivo5").val(null);
    $("#subirArchivo5").disabled = true; 
    
    //document.getElementById("evidencia5").required = true;
    $("#evidencia5").attr("required", "required");
    //$("#VerArchivoEvdidencia5").hide();
    
});

$("#cmbPregunta6").change(function(event) {

    if(("6. VACÍO" === $("#cmbPregunta6").val()) || ("4. NO APLICA" === $("#cmbPregunta6").val())){
        //document.getElementById("evidencia5").required = false;
        $("#evidencia5").removeAttr("required");
        $("#evidenciaLink5").val(null);
        $("#evidencia5").val(null);
        $("#rutaArchivo5").val(null);
        $("#divevidencia5").hide();
        //$("#VerArchivoEvdidencia5").hide();
    }else {
        
        //document.getElementById("evidencia5").required = true;
        $("#evidencia5").attr("required", "required");
        $("#divevidencia5").show();
        //$("#VerArchivoEvdidencia5").hide();

    }
    
});

$("#EliminarArchiServer6").click(function(event) {
    
    $("#divevidencia6").show();
    $("#evidenciaLink6").val(null);
    $("#evidencia6").val(null);
    $("#rutaArchivo6").val(null);
    $("#subirArchivo6").disabled = true; 
    
    //document.getElementById("evidencia6").required = true;
    $("#evidencia6").attr("required", "required");
    //$("#VerArchivoEvdidencia6").hide();
    
});

$("#cmbPregunta7").change(function(event) {

    if(("8. VACÍO" === $("#cmbPregunta7").val()) || ("6. NO APLICA" === $("#cmbPregunta7").val())){
        //document.getElementById("evidencia6").required = false;
        $("#evidencia6").removeAttr("required");
        $("#evidenciaLink6").val(null);
        $("#evidencia6").val(null);
        $("#rutaArchivo6").val(null);
        $("#divevidencia6").hide();
        //$("#VerArchivoEvdidencia6").hide();
    }else {
        
        //document.getElementById("evidencia6").required = true;
        $("#evidencia6").attr("required", "required");
        $("#divevidencia6").show();
        //$("#VerArchivoEvdidencia6").hide();

    }
    
});

$("#EliminarArchiServer7").click(function(event) {
    
    $("#divevidencia7").show();
    $("#evidenciaLink7").val(null);
    $("#evidencia7").val(null);
    $("#rutaArchivo7").val(null);
    $("#subirArchivo7").disabled = true; 
    
    //document.getElementById("evidencia7").required = true;
    $("#evidencia7").attr("required", "required");  
    //$("#VerArchivoEvdidencia7").hide();
    
});

$("#cmbPregunta8").change(function(event) {

    if(("7. VACÍO" === $("#cmbPregunta8").val()) || ("5. NO APLICA" === $("#cmbPregunta8").val())){
    //  document.getElementById("evidencia7").required = false;
        $("#evidencia7").removeAttr("required");
        $("#evidenciaLink7").val(null);
        $("#evidencia7").val(null);
        $("#rutaArchivo7").val(null);
        $("#divevidencia7").hide();
        //$("#VerArchivoEvdidencia7").hide();
    }else {
        
        //document.getElementById("evidencia7").required = true;
        $("#evidencia7").attr("required", "required");  
        $("#divevidencia7").show();
        //$("#VerArchivoEvdidencia7").hide();

    }
    
});

$("#EliminarArchiServer8").click(function(event) {
    
    $("#divevidencia8").show();
    $("#evidenciaLink8").val(null);
    $("#evidencia8").val(null);
    $("#rutaArchivo8").val(null);
    $("#subirArchivo8").disabled = true; 
    
    //document.getElementById("evidencia8").required = true;
    $("#evidencia8").attr("required", "required");
    //$("#VerArchivoEvdidencia8").hide();
    
});

$("#cmbPregunta9").change(function(event) {

    if(("7. VACÍO" === $("#cmbPregunta9").val()) || ("5. NO APLICA" === $("#cmbPregunta9").val())){
        //document.getElementById("evidencia8").required = false;
        $("#evidencia8").removeAttr("required");        
        $("#evidenciaLink8").val(null);
        $("#evidencia8").val(null);
        $("#rutaArchivo8").val(null);
        $("#divevidencia8").hide();
        //$("#VerArchivoEvdidencia8").hide();
    }else {
        
        //document.getElementById("evidencia8").required = true;
        $("#evidencia8").attr("required", "required");
        $("#divevidencia8").show();
        //$("#VerArchivoEvdidencia8").hide();

    }
    
});

$("#EliminarArchiServer9").click(function(event) {
    
    $("#divevidencia9").show();
    $("#evidenciaLink9").val(null);
    $("#evidencia9").val(null);
    $("#rutaArchivo9").val(null);
    $("#subirArchivo9").disabled = true; 
    
    //document.getElementById("evidencia9").required = true;
    $("#evidencia9").attr("required", "required");
    //$("#VerArchivoEvdidencia9").hide();
    
});

$("#cmbPregunta10").change(function(event) {

    if(("7. VACÍO" === $("#cmbPregunta10").val()) || ("5. NO APLICA" === $("#cmbPregunta10").val())){
        document.getElementById("evidencia9").required = false;
        $("#evidencia9").removeAttr("required");        
        $("#evidenciaLink9").val(null);
        $("#evidencia9").val(null);
        $("#rutaArchivo9").val(null);
        $("#divevidencia9").hide();
        //$("#VerArchivoEvdidencia9").hide();
    }else {
        
        //document.getElementById("evidencia9").required = true;
        $("#evidencia9").attr("required", "required");
        $("#divevidencia9").show();
        //$("#VerArchivoEvdidencia9").hide();

    }
    
});

$("#EliminarArchiServer10").click(function(event) {
    
    $("#divevidencia10").show();
    $("#evidenciaLink10").val(null);
    $("#evidencia10").val(null);
    $("#rutaArchivo10").val(null);
    $("#subirArchivo10").disabled = true; 
    
    //document.getElementById("evidencia10").required = true;
    $("#evidencia10").attr("required", "required");
    //$("#VerArchivoEvdidencia10").hide();
    
});

$("#cmbPregunta11").change(function(event) {

    if(("6. VACÍO" === $("#cmbPregunta11").val()) || ("4. NO APLICA" === $("#cmbPregunta11").val())){
        //document.getElementById("evidencia10").required = false;
        $("#evidencia10").removeAttr("required");   
        $("#evidenciaLink10").val(null);
        $("#evidencia10").val(null);
        $("#rutaArchivo10").val(null);
        $("#divevidencia10").hide();
        //$("#VerArchivoEvdidencia10").hide();
    }else {
        
        //document.getElementById("evidencia10").required = true;
        $("#evidencia10").attr("required", "required");
        $("#divevidencia10").show();
        //$("#VerArchivoEvdidencia10").hide();

    }
    
});

$("#EliminarArchiServer11").click(function(event) {
    
    $("#divevidencia11").show();
    $("#evidenciaLink11").val(null);
    $("#evidencia11").val(null);
    $("#rutaArchivo11").val(null);
    $("#subirArchivo11").disabled = true; 
    
    //document.getElementById("evidencia11").required = true;
    $("#evidencia11").attr("required", "required");
    //$("#VerArchivoEvdidencia11").hide();
    
});

$("#cmbPregunta12").change(function(event) {

    if(("6. VACÍO" === $("#cmbPregunta12").val()) || ("4. NO APLICA" === $("#cmbPregunta12").val())){
        //document.getElementById("evidencia11").required = false;
        $("#evidencia11").removeAttr("required");       
        $("#evidenciaLink11").val(null);
        $("#evidencia11").val(null);
        $("#rutaArchivo11").val(null);
        $("#divevidencia11").hide();
        //$("#VerArchivoEvdidencia11").hide();
    }else {
        
        //document.getElementById("evidencia11").required = true;
        $("#evidencia11").attr("required", "required");
        $("#divevidencia11").show();
        //$("#VerArchivoEvdidencia11").hide();

    }
    
});

$("#EliminarArchiServer12").click(function(event) {
    
    $("#divevidencia12").show();
    $("#evidenciaLink12").val(null);
    $("#evidencia12").val(null);
    $("#rutaArchivo12").val(null);
    $("#subirArchivo12").disabled = true; 
    
    //document.getElementById("evidencia12").required = true;
    $("#evidencia12").attr("required", "required");
    //$("#VerArchivoEvdidencia12").hide();
    
});

$("#cmbPregunta13").change(function(event) {

    if(("8. VACÍO" === $("#cmbPregunta13").val()) || ("6. NO APLICA" === $("#cmbPregunta13").val())){
        //document.getElementById("evidencia12").required = false;
        $("#evidencia12").removeAttr("required");
        $("#evidenciaLink12").val(null);
        $("#evidencia12").val(null);
        $("#rutaArchivo12").val(null);
        $("#divevidencia12").hide();
        //$("#VerArchivoEvdidencia12").hide();
    }else {
        
        //document.getElementById("evidencia12").required = true;
        $("#evidencia12").attr("required", "required");
        $("#divevidencia12").show();
        //$("#VerArchivoEvdidencia12").hide();

    }
    
});


    $(document).ready(function() {
        
        nombreFormulario = $("#matriz_1");
        cargarValorComboPorDefecto("cmbpregunta1",'${detalle1.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta2",'${detalle2.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta3",'${detalle3.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta4",'${detalle4.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta5",'${detalle5.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta6",'${detalle6.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta7",'${detalle7.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta8",'${detalle8.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta9",'${detalle9.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta10",'${detalle10.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta11",'${detalle11.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta12",'${detalle12.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta13",'${detalle13.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta14",'${detalle14.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta15",'${detalle15.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta16",'${detalle16.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta17",'${detalle17.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta18",'${detalle18.respuesta}');
        cargarValorComboPorDefecto("cmbPregunta19",'${detalle19.respuesta}');
        

        $('a[data-toggle="pill"]').on('shown.bs.tab', function(e){
               $($.fn.dataTable.tables(true)).DataTable()
                  .columns.adjust();
        });
        
        //validarIdInforme(idInforme);
        
        
        $('a[data-toggle="pill"]').on('click', function(event) {
            var x = $(this).attr('href');
            //console.log(x);
            cargaDatos($("#infcod").val());
            nombreFormulario=""; 
            nombreDiv=""; 
            nombreDiv1="";
            nombreDiv2=""; 
            nombreDiv3=""; 
            nombreDiv4="";          
            switch (x) {
                case '#home':               
                nombreFormulario = $("#matriz_1");
                document.getElementById("btnFinalizar").hidden = true;
                document.getElementById("btnGuardar").hidden = false;
                v1 = true;
                 break;
          case '#menu1':
              //validarPreguntaInforme($("#infcod").val(), $("#id_informe_2").val());             
              nombreFormulario = $("#matriz_2");
              nombreDiv="evidencia1";
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
                v2 = true;
              break;
          case '#menu2':              
              nombreFormulario = $("#matriz_3");
              nombreDiv="evidencia2"; 
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v3 = true;
              break;
          case '#menu3':              
              nombreFormulario = $("#matriz_4");
              nombreDiv="evidencia3"; 
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v4 = true;
              break;
          case '#menu4':              
              nombreFormulario = $("#matriz_5");
              nombreDiv="evidencia4"; 
              nombreDiv1="evidencia5"; 
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v5 = true;
              break;
          case '#menu5':              
              nombreFormulario = $("#matriz_6");
              nombreDiv="evidencia6"; 
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v6 = true;
              break;
          case '#menu6':              
              nombreFormulario = $("#matriz_7");
                nombreDiv="evidencia7"; 
                nombreDiv1="evidencia8"; 
                nombreDiv2="evidencia9"; 
                nombreDiv3="evidencia10"; 
                nombreDiv4="evidencia11";           
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v7 = true;
              break;
          case '#menu7':
              nombreFormulario = $("#matriz_8");
                nombreDiv="evidencia12"; 
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v8 = true;
              break;
          case '#menu8':

              //nombreFormulario = $("#matriz_8");
              nombreFormulario = $("#matriz_9");
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
              v9 = true;
              break;
        case '#menu9':

              nombreFormulario = $("#matriz_10");
              document.getElementById("btnFinalizar").hidden = true;
              document.getElementById("btnGuardar").hidden = false;
            v10 = true;
              break;
        case '#menu10':
              //nombreFormulario = $("#matriz_10");
              document.getElementById("btnFinalizar").hidden = false;
              document.getElementById("btnGuardar").hidden = true;
              break;
        
              
            }
            
        });
        
        tablaEjecucionPresupuestaria();
        tablaProcesosContratacion();
        tablaMecanismosParticionCiudadanaFE();
        tablaPRFE();
        tablaIncorporacionRecomenFE();
        tablaBalanceGeneral();
        tablaCO();
        tablaControlSocialFE();
        TablaImpleIgualdadFE();
        
    });

    $("#btnAcceso").click(function(event) {

        console.log("ingreso");

        /*  abrir($(this), "#" + $(this).attr("data-destino"), false);
        window.location="https://sudappstest.cpccs.gob.ec/sistemacpccs/registro";*/
    });

    function tablaEjecucionPresupuestaria() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $('#TablaActualizarDetallePoa')
                .DataTable(
                        {
                            ajax : {
                                data : parametros,
                                url : "obtenerActualizarDetallePoa",
                                headers : {
                                    "X-CSRF-TOKEN" : csrfToken
                                },
                                type : "POST"
                            },
                            order : [ 0, "asc" ],
                            paging : false,
                            info : false,
                            searching : false,
                            responsive : true,
                            scrollX : true,
                            bDestroy : true,
                            columns : [
                                    {
                                        data : "contador"
                                    },
                                    {
                                        data : "depTipo"
                                    },
                                    {
                                        data : "depDescripcion"
                                    },
                                    {
                                        data : "depPresplan"
                                    },
                                    {
                                        data : "depPresejec"
                                    },
                                    {
                                        data : "depCumple"
                                    },
                                    {
                                        data : "depLink",
                                        render : function(data) {
                                            if (data === "NO APLICA"
                                                    || data === "S/N") {
                                            } else {
                                                data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                        + data + '</a>';
                                            }

                                            return data;
                                        }
                                    } ],
                            language : {
                                url : "resources/json/lenguajeTablaDataTable.json"
                            },
                            createdRow : function(row, data, dataIndex) {
                                $(row).attr('id', data.depCodigo);
                                //$(row).attr('class', 'item');
                                //$(row).attr('data-rutaAplicacion', '');
                                //$(row).attr('data-opcion', 'EditarPerfilInstitucion');
                                $(row).attr('ondragstart', 'drag(event)');
                                $(row).attr('draggable', 'false');
                                $(row).attr('data-destino', 'detalleItem');
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap",
                                });
                                $(row).find("td:eq(3)").attr('title',
                                        data.nombres);
                                $(row).find("td").css({
                                    "font-size" : "x-small",
                                });

                                $(row).find("td").css({
                                    "vertical-align" : "middle",
                                });
                            },
                        });
    }

    function tablaProcesosContratacion() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $
                .ajax({
                    url : "obtenerRegistrosProcesoContratacion",
                    type : "post",
                    dataType : "json",
                    data : parametros,
                    headers : {
                        "X-CSRF-TOKEN" : csrfToken
                    },
                    success : function(result) {
                        if (result['Error']) {
                            $('#tabla').hide();
                        } else if (result['data'].length != 0) {
                            $('#nuevo').hide();
                            $('#tablaRegistrosProcesosContratacion')
                                    .DataTable(
                                            {

                                                order : [ 0, "asc" ],
                                                paging : false,
                                                info : false,
                                                searching : false,
                                                responsive : true,
                                                scrollX : true,
                                                bDestroy : true,
                                                buttons : [ {
                                                    extend : 'copyHtml5'
                                                }, {
                                                    extend : 'csvHtml5'
                                                }, {
                                                    extend : 'excelHtml5'
                                                }, {
                                                    extend : 'pdfHtml5',
                                                    orientation : 'landscape',
                                                    pageSize : 'A1'
                                                }, {
                                                    extend : 'print'
                                                }, ],
                                                data : result.data,
                                                columns : [
                                                        {
                                                            data : "contador"
                                                        },
                                                        {
                                                            data : "tipo"
                                                        },
                                                        {
                                                            data : "",
                                                            "render" : function(
                                                                    data, type,
                                                                    full, meta) {
                                                                data = '<table class="table registros table-bordered"> <tr> <th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Adjudicados</th><th style="font-size: 7px;" class="tablainterna" width="5%">Número Total Finalizados</th> <th style="font-size: 7px;" class="tablainterna" width="5%">Valor Total Finalizados</th></tr><tr><td>'
                                                                        + full.numeroAdj
                                                                        + '</td><td>'
                                                                        + full.valorAdj
                                                                        + '</td><td>'
                                                                        + full.numeroFin
                                                                        + '</td><td>'
                                                                        + full.valorFin
                                                                        + '</td> </tr></table>'
                                                                return data;
                                                            }
                                                        },
                                                        {
                                                            data : "link",
                                                            render : function(
                                                                    data) {
                                                                if (data === "NO APLICA"
                                                                        || data === "S/N") {
                                                                } else {
                                                                    data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                                            + data
                                                                            + '</a>';
                                                                }

                                                                return data;
                                                            }
                                                        } ],
                                                language : {
                                                    url : "resources/json/lenguajeTablaDataTable.json"
                                                },
                                                createdRow : function(row,
                                                        data, dataIndex) {
                                                    $(row).attr('id',
                                                            data.pcoCod);
                                                    $(row).attr('ondragstart',
                                                            'drag(event)');
                                                    $(row).attr('draggable',
                                                            'false');
                                                    $(row).attr('data-destino',
                                                            'detalleItem');
                                                    $(row)
                                                            .find("td:first")
                                                            .css(
                                                                    {
                                                                        "font-weight" : "bold",
                                                                        "white-space" : "nowrap"
                                                                    });
                                                },
                                            });
                        } else {
                        }
                    },
                    error : function(errormessage) {
                        alert(errormessage.responseText);
                    }
                });
    }

    function tablaMecanismosParticionCiudadanaFE() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $('#tablaRegistrosMecanismosParticionCiudadanaFE')
                .DataTable(
                        {
                            ajax : {
                                data : parametros,
                                url : "obtenerMecanismoParticipacionEjecutivo",
                                headers : {
                                    "X-CSRF-TOKEN" : csrfToken
                                },
                                type : "POST"
                            },
                            order : [ 0, "asc" ],
                            paging : false,
                            info : false,
                            searching : false,
                            responsive : true,
                            scrollX : true,
                            bDestroy : true,
                            buttons : [ {
                                extend : 'excelHtml5'
                            }, {
                                extend : 'pdfHtml5',
                                orientation : 'landscape',
                                pageSize : 'A1'
                            }, {
                                extend : 'print'
                            }, ],
                            columns : [
                                    {
                                        data : "contador"
                                    },
                                    {
                                        data : "nombre"
                                    },
                                    {
                                        data : "implementado"
                                    },
                                    {
                                        data : "numero"
                                    },
                                    {
                                        data : "link",
                                        render : function(data) {
                                            if (data === "NO APLICA"
                                                    || data === "S/N") {
                                            } else {
                                                data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                        + data + '</a>';
                                            }

                                            return data;
                                        }
                                    } ],
                            language : {
                                url : "resources/json/lenguajeTablaDataTable.json"
                            },
                            createdRow : function(row, data, dataIndex) {
                                $(row).attr('id', data.meca_cod);
                                $(row).attr('ondragstart', 'drag(event)');
                                $(row).attr('draggable', 'false');
                                $(row).attr('data-destino', 'detalleItem');
                                $(row).find("td").css({
                                    "font-size" : "x-small",
                                });
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap"
                                });
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap"
                                });
                            },
                        });
    }

    function tablaPRFE() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $('#TablaRendicionFases')
                .DataTable(
                        {
                            ajax : {
                                data : parametros,
                                url : "obtenerRendicionFases",
                                headers : {
                                    "X-CSRF-TOKEN" : csrfToken
                                },
                                type : "POST"
                            },
                            pageLength : 12,
                            order : [ 0, "asc" ],
                            paging : false,
                            info : false,
                            searching : false,
                            responsive : true,
                            scrollX : true,
                            bDestroy : true,
                            columns : [
                                    {
                                        data : "contador"
                                    },
                                    {
                                        data : "mecanismo"
                                    },
                                    {
                                        data : "proceso"
                                    },
                                    {
                                        data : "seleccion"
                                    },
                                    {
                                        data : "describa"
                                    },
                                    {
                                        data : "link",
                                        render : function(data) {
                                            if (data === "NO APLICA"
                                                    || data === "S/N") {
                                            } else {
                                                data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                        + data + '</a>';
                                            }

                                            return data;
                                        }
                                    } ],

                            language : {
                                url : "resources/json/lenguajeTablaDataTable.json"
                            },
                            createdRow : function(row, data, dataIndex) {
                                $(row).attr('id', data.mecanismo_cod);
                                //$(row).attr('class', 'item');
                                $(row).attr('data-rutaAplicacion', 'rendicion');
                                $(row).attr('data-opcion',
                                        'Frm_RendicionCuentasFasesActualizar');
                                $(row).attr('ondragstart', 'drag(event)');
                                $(row).attr('draggable', 'false');
                                $(row).attr('data-destino', 'detalleItem');
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap",
                                });

                                $(row).find("td").css({
                                    "font-size" : "x-small",
                                });

                                $(row).find("td").css({
                                    "vertical-align" : "middle",
                                });

                            },

                        });

    }



    function tablaIncorporacionRecomenFE() {
            var parametros = {
                "infCod" : $("#infcod").val()
            };
            $('#TablaIncorporacionRecom')
                    .DataTable(
                            {
                                ajax : {
                                    data : parametros,
                                    url : "obtenerRegistrosCumplimientoSugerencias",
                                    headers : {
                                        "X-CSRF-TOKEN" : csrfToken
                                    },
                                    type : "POST"
                                },
                                order : [ 0, "asc" ],
                                paging : false,
                                info : false,
                                searching : false,
                                responsive : true,
                                scrollX : true,
                                bDestroy : true,
                                columns : [
                                    {data : "contador" },
                                    {data : "sugerencias"},
                                    {data : "resultados"},
                                    {data : "porcAvance"},
                                    {
                                            data : "link",
                                            render : function(data) {
                                                if (data === "NO APLICA"
                                                        || data === "S/N") {
                                                } else {
                                                    data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                            + data + '</a>';
                                                }

                                                return data;
                                            }
                                        } ],

                                language : {
                                    url : "resources/json/lenguajeTablaDataTable.json"
                                },

                                createdRow : function(row, data, dataIndex) {
                                    $(row).attr('id', data.cscCod);
                                    $(row).attr('ondragstart', 'drag(event)');
                                    $(row).attr('draggable', 'false');
                                    $(row).attr('data-destino', 'detalleItem');
                                    $(row).find("td:first").css({
                                        "font-weight" : "bold",
                                        "white-space" : "nowrap",
                                    });
                                    $(row).find("td").css({
                                        "font-size" : "x-small",
                                    });
                                    $(row).find("td:eq(7)").css({
                                        "vertical-align" : "middle",
                                    });
                                    $(row).find("td:eq(8)").css({
                                        "vertical-align" : "middle",
                                    });

                                },

                            });

        }
    function tablaControlSocialFE() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $('#TablaContSocial')
                .DataTable(
                        {
                            ajax : {
                                data : parametros,
                                url : "obtenerControlSocial",
                                headers : {
                                    "X-CSRF-TOKEN" : csrfToken
                                },
                                type : "POST"
                            },
                            order : [ 0, "asc" ],
                            paging : false,
                            info : false,
                            searching : false,
                            responsive : true,
                            scrollX : true,
                            bDestroy : true,
                            columns : [
                                    {
                                        data : "contador"
                                    },
                                    {
                                        data : "sistema"
                                    },
                                    {
                                        data : "seleccion"
                                    },
                                    {
                                        data : "numero"
                                    },
                                    {
                                        data : "link",
                                        render : function(data) {
                                            if (data === "NO APLICA"
                                                    || data === "S/N") {
                                            } else {
                                                data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                        + data + '</a>';
                                            }

                                            return data;
                                        }
                                    } ],

                            language : {
                                url : "resources/json/lenguajeTablaDataTable.json"
                            },
                            createdRow : function(row, data, dataIndex) {
                                $(row).attr('id', data.mec_cod);
                                //$(row).attr('class', 'item');
                                $(row).attr('data-rutaAplicacion', 'rendicion');
                                $(row).attr('data-opcion',
                                        'Frm_MecanismosConstrolSocialActul');
                                $(row).attr('ondragstart', 'drag(event)');
                                $(row).attr('draggable', 'false');
                                $(row).attr('data-destino', 'detalleItem');
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap",
                                });
                                $(row).find("td").css({
                                    "font-size" : "x-small",
                                });
                                $(row).find("td:eq(5)").css({
                                    "vertical-align" : "middle",
                                });

                            },

                        });

    }

    function TablaImpleIgualdadFE() {
        var parametros = {
            "infCod" : $("#infcod").val()
        };
        $('#TablaImpleIgualdad')
                .DataTable(
                        {
                            ajax : {
                                data : parametros,
                                url : "obtenerImpletIgualdad",
                                headers : {
                                    "X-CSRF-TOKEN" : csrfToken
                                },
                                type : "POST"
                            },
                            order : [ 0, "asc" ],
                            paging : false,
                            info : false,
                            searching : false,
                            responsive : true,
                            scrollX : true,
                            bDestroy : true,
                            columns : [
                                    {
                                        data : "contador"
                                    },
                                    {
                                        data : "politica"
                                    },
                                    {
                                        data : "seleccion"
                                    },
                                    {
                                        data : "descripcion"
                                    },
                                    {
                                        data : "detalle"
                                    },
                                    {
                                        data : "explique",
                                        render : function(data) {
                                            if (data === "NO APLICA"
                                                    || data === "S/N") {
                                            } else {
                                                data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                                        + data + '</a>';
                                            }

                                            return data;
                                        }
                                    } ],

                            language : {
                                url : "resources/json/lenguajeTablaDataTable.json"
                            },

                            createdRow : function(row, data, dataIndex) {
                                $(row).attr('id', data.pi_cod);
                                //$(row).attr('class', 'item');
                                $(row).attr('data-rutaAplicacion', 'rendicion');
                                $(row).attr('data-opcion',
                                        'Frm_ImplemetacionPoliticasActul');
                                $(row).attr('ondragstart', 'drag(event)');
                                $(row).attr('draggable', 'false');
                                $(row).attr('data-destino', 'detalleItem');
                                $(row).find("td:first").css({
                                    "font-weight" : "bold",
                                    "white-space" : "nowrap",
                                });
                                $(row).find("td").css({
                                    "font-size" : "x-small",
                                });
                                $(row).find("td:eq(6)").css({
                                    "vertical-align" : "middle",
                                });

                            },

                        });

    }

    function tablaBalanceGeneral() {
        var parametros = {
                "infCod" : $("#infcod").val()
            };
        $('#tablaRegistrosBalanceGeneral').DataTable( {   
            ajax: {
                 data:parametros,
                url:"obtenerRegistrosInformacionFinanciera",
                headers: {"X-CSRF-TOKEN": csrfToken},
                type:"POST"
                  },
            order: [ 0, "asc" ],
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
                {data : "activo"},
                {data : "pasivos"},
                {data : "patrimonio"},
                {data : "link",
                    render : function(data) {
                        if (data === "NO APLICA"
                                || data === "S/N") {
                        } else {
                            data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                    + data + '</a>';
                        }

                        return data;
                    }
        }  ],
                language: {
                      url: "resources/json/lenguajeTablaDataTable.json"
                  },
            createdRow: function( row, data, dataIndex ) {
                 $(row).attr('id', data.CodFinan);
               $(row).attr('ondragstart', 'drag(event)');
               $(row).attr('draggable', 'false');
               $(row).attr('data-destino', 'detalleItem');
               $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
                            },
            } );


    }


    function tablaCO() {
        var parametros = {
                "infCod" : $("#infcod").val()
            };      $('#tablaRegistrosCO').DataTable( {   
            ajax: {
                 data:parametros,
                url:"obtenerRegistrosCumplimientoInformacion",
                headers: {"X-CSRF-TOKEN": csrfToken},
                type:"POST"
                  },
            order: [ 0, "asc" ],
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
                {data : "laborales"},
                {data : "tributarios"},
                {data : "link",
                    render : function(data) {
                        if (data === "NO APLICA"
                                || data === "S/N") {
                        } else {
                            data = '<a href="' + data + '" style="color:blue;" target="_blank">'
                                    + data + '</a>';
                        }

                        return data;
                    }}  ],
                language: {
                      url: "resources/json/lenguajeTablaDataTable.json"
                  },
            createdRow: function( row, data, dataIndex ) {
                 $(row).attr('id', data.CumOblCod);
               $(row).attr('ondragstart', 'drag(event)');
               $(row).attr('draggable', 'false');
               $(row).attr('data-destino', 'detalleItem');
               $(row).find("td:first").css({"font-weight":"bold","white-space":"nowrap" });
               $(row).find("td").css({
                    "font-size"   : "x-small",          
                }); 

                $(row).find("td").css({
                    "vertical-align" : "middle",
                }); 
                            },
            } );


    }

    $('button.subirArchivo1').click(
            function(event) {
                var boton = $(this);
                var archivo = boton.parent('div').parent('div').find(
                        ".archivo");
                var rutaArchivo = boton.parent('div').parent('div')
                        .find(".rutaArchivo1");
                var extension = archivo.val().split('.');
                var estado = boton.parent('div').parent('div').find(
                        ".estadoCarga");
                var fecha = new Date();
                var nombreNuevoArchivo = $("#identificadorResponsable")
                        .val()
                        + "_evidencia-1-"
                        + fecha.getFullYear()
                        + "_"
                        + (fecha.getMonth() + 1)
                        + "_"
                        + fecha.getDate()
                        + "-"
                        + fecha.getHours()
                        + "_"
                        + fecha.getMinutes()
                        + "_"
                        + fecha.getSeconds();
                if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
                .toUpperCase() == 'JPEG'
                    || extension[extension.length - 1]
                            .toUpperCase() == 'JPG'
                    || extension[extension.length - 1]
                            .toUpperCase() == 'PNG' 
                    || extension[extension.length - 1]
                            .toUpperCase() == 'BMP'
                    || extension[extension.length - 1]
                            .toUpperCase() == 'DOC'
                    || extension[extension.length - 1]
                            .toUpperCase() == 'DOCX') {
                    subirArchivo(archivo, nombreNuevoArchivo, boton
                            .attr("data-rutaCarga"), rutaArchivo,
                            new carga(estado, archivo, boton),
                            "${tamanioArchivo}");
                    $('#EliminarArchivo1').removeAttr("disabled");

                } else {
                    estado
                            .html('Formato incorrecto, solo se admite archivos en formato PDF');
                    archivo.val("");
                }
                
                document.querySelector("a#evidenciaLink1").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo1").val();
                //$("#divevidencia1").hide();
                //$("#VerArchivoEvdidencia1").show();
                                
            });
    
$('button.EliminarArchivo1').click(function(event) {
        var boton = $(this);
        var estado = boton.parent('div').parent('div').find(
                ".estadoCarga");
        var archivourl = $("#rutaArchivo1").val();
        var rutaArchivo = boton.parent('div').parent('div').find(
                ".rutaArchivo1");
        var archivo = boton.parent('div').parent('div')
                .find(".archivo");
        EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
                estado, archivo, boton));
        $('#subirArchivo1').removeAttr("disabled");
        $('#evidencia1').val('');
    });

$('button.subirArchivo2').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo2");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-2-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo2').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink2").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo2").val();
            //$("#divevidencia2").hide();
            //$("#VerArchivoEvdidencia2").show();
            
        });

$('button.EliminarArchivo2').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo2").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo2");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo2').removeAttr("disabled");
    $('#evidencia2').val('');
});

$('button.subirArchivo3').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo3");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-3-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo3').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink3").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo3").val();
            //$("#divevidencia3").hide();
            //$("#VerArchivoEvdidencia3").show();
            
        });

$('button.EliminarArchivo3').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo3").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo3");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo3').removeAttr("disabled");
    $('#evidencia3').val('');
});


$('button.subirArchivo4').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo4");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-4-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo4').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink4").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo4").val();
            //$("#divevidencia4").hide();
            //$("#VerArchivoEvdidencia4").show();
            
        });

$('button.EliminarArchivo4').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo4").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo4");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo4').removeAttr("disabled");
    $('#evidencia4').val('');
});


$('button.subirArchivo5').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo5");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-5-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo5').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink5").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo5").val();
            //$("#divevidencia5").hide();
            //$("#VerArchivoEvdidencia5").show();
            
        });

$('button.EliminarArchivo5').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo5").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo5");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo5').removeAttr("disabled");
    $('#evidencia5').val('');
});


$('button.subirArchivo6').click(function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo6");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-6-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo6').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink6").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo6").val();
            //$("#divevidencia6").hide();
            //$("#VerArchivoEvdidencia6").show();
            
        });

$('button.EliminarArchivo6').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo6").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo6");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo6').removeAttr("disabled");
    $('#evidencia6').val('');
});


$('button.subirArchivo7').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo7");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-7-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo7').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink7").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo7").val();
            //$("#divevidencia7").hide();
            //$("#VerArchivoEvdidencia7").show();
            
        });

$('button.EliminarArchivo7').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo7").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo7");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo7').removeAttr("disabled");
    $('#evidencia7').val('');
});

$('button.subirArchivo8').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo8");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-8-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo8').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink8").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo8").val();
            //$("#divevidencia8").hide();
            //$("#VerArchivoEvdidencia8").show();
            
        });

$('button.EliminarArchivo8').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo8").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo8");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo8').removeAttr("disabled");
    $('#evidencia8').val('');
});




$('button.subirArchivo9').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo9");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-9-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo9').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink9").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo9").val();
            //$("#divevidencia9").hide();
            //$("#VerArchivoEvdidencia9").show();
            
        });

$('button.EliminarArchivo9').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo9").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo9");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo9').removeAttr("disabled");
    $('#evidencia9').val('');
});


$('button.subirArchivo10').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo10");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-9-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo10').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink10").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo10").val();
            //$("#divevidencia10").hide();
            //$("#VerArchivoEvdidencia10").show();
            
        });

$('button.EliminarArchivo10').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo10").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo10");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo10').removeAttr("disabled");
    $('#evidencia10').val('');
});

$('button.subirArchivo11').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo11");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-9-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo11').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink11").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo11").val();
            //$("#divevidencia11").hide();
            //$("#VerArchivoEvdidencia11").show();
            
        });

$('button.EliminarArchivo11').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo11").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo11");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo11').removeAttr("disabled");
    $('#evidencia11').val('');
});

$('button.subirArchivo12').click(
        function(event) {
            var boton = $(this);
            var archivo = boton.parent('div').parent('div').find(
                    ".archivo");
            var rutaArchivo = boton.parent('div').parent('div')
                    .find(".rutaArchivo12");
            var extension = archivo.val().split('.');
            var estado = boton.parent('div').parent('div').find(
                    ".estadoCarga");
            var fecha = new Date();
            var nombreNuevoArchivo = $("#identificadorResponsable")
                    .val()
                    + "_evidencia-9-"
                    + fecha.getFullYear()
                    + "_"
                    + (fecha.getMonth() + 1)
                    + "_"
                    + fecha.getDate()
                    + "-"
                    + fecha.getHours()
                    + "_"
                    + fecha.getMinutes()
                    + "_"
                    + fecha.getSeconds();
            if (extension[extension.length - 1].toUpperCase() == 'PDF' || extension[extension.length - 1]
            .toUpperCase() == 'JPEG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'JPG'
                || extension[extension.length - 1]
                        .toUpperCase() == 'PNG' 
                || extension[extension.length - 1]
                        .toUpperCase() == 'BMP'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOC'
                || extension[extension.length - 1]
                        .toUpperCase() == 'DOCX') {
                subirArchivo(archivo, nombreNuevoArchivo, boton
                        .attr("data-rutaCarga"), rutaArchivo,
                        new carga(estado, archivo, boton),
                        "${tamanioArchivo}");
                $('#EliminarArchivo12').removeAttr("disabled");

            } else {
                estado
                        .html('Formato incorrecto, solo se admite archivos en formato PDF');
                archivo.val("");
            }
            
            document.querySelector("a#evidenciaLink12").href = '${rutaArchivosAplicacion}'+$("#rutaArchivo12").val();
            //$("#divevidencia12").hide();
            //$("#VerArchivoEvdidencia12").show();
            
        });

$('button.EliminarArchivo12').click(function(event) {
    var boton = $(this);
    var estado = boton.parent('div').parent('div').find(
            ".estadoCarga");
    var archivourl = $("#rutaArchivo12").val();
    var rutaArchivo = boton.parent('div').parent('div').find(
            ".rutaArchivo12");
    var archivo = boton.parent('div').parent('div')
            .find(".archivo");
    EliminarArchivo(archivourl, archivo, rutaArchivo, new carga(
            estado, archivo, boton));
    $('#subirArchivo12').removeAttr("disabled");
    $('#evidencia12').val('');
});


    $("#btnGuardar").click(function(event) {
                        
        var form = nombreFormulario;
        //var form = $("#formularioEvaluacion")
        var divEvi=nombreDiv;
        var divEvi1=nombreDiv1;
        var divEvi2=nombreDiv2;
        var divEvi3=nombreDiv3;
        var divEvi4=nombreDiv4;
        
        event.preventDefault();
        event.stopPropagation();
        if (form[0].checkValidity() === false) {
            mostrarMensaje(
                    "Por favor ingrese toda la información solicitada!",
                    "ERROR");
        } else {

            if(ValidarArchivo(divEvi)==false ){
                $("#"+divEvi).addClass('rojo');     
                     mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");                   
                 }else if(ValidarArchivo(divEvi1)==false) {                     
                     $("#"+divEvi1).addClass('rojo');            
                     mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
                 }else if(ValidarArchivo(divEvi2)==false) {                     
                     $("#"+divEvi2).addClass('rojo');            
                     mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
                 }else if(ValidarArchivo(divEvi3)==false) {                     
                     $("#"+divEvi3).addClass('rojo');            
                     mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
                 }else if(ValidarArchivo(divEvi4)==false) {                     
                     $("#"+divEvi4).addClass('rojo');            
                     mostrarMensaje("Por favor subir el archivo seleccionado !","ERROR");
                 }else{                  
                     guardar("GUARDAR");
                 }      
            
        }
        form.addClass('was-validated');

    });

    $("#btnFinalizar").click(function(event) {
        var form = $("#formularioEvaluacion")
        event.preventDefault();
        event.stopPropagation();
        if (form[0].checkValidity() === false) {
            mostrarMensaje(
                    "Por favor ingrese toda la información solicitada!",
                    "ERROR");
        } else {

            if((v1 == true) && (v2 == true) && (v3 == true)
            && (v4 == true) && (v5 == true) && (v6 == true)
            && (v7 == true) && (v8 == true) && (v9 == true)
            && (v10 == true)){
                Swal.fire({
                      title: 'ATENCIÓN',
                      type: 'warning',
                      text: "¿Está seguro de Finalizar la evaluación?",
                      //icon: 'warning',
                      showCancelButton: true,
                      confirmButtonColor: '#3085d6',
                      cancelButtonColor: '#d33',
                      confirmButtonText: 'Aceptar',
                      cancelButtonText: 'Cancelar'
                    }).then((result) => {
                      if (result.value) {
                            guardar("FINALIZAR");
                            abrir($("#menuAplicacion #menu a.linkAbierto"), null, true);
                      }
                    });
            } else {
                Swal.fire({
                      type: 'warning',
                      title: 'Oops...',
                      text: 'Por favor Revice Las Matrices para poder Completar y Finalizar el Proceso.....!!!!!!!!!',
                    });
            }
            
        }
        form.addClass('was-validated');

    });
    
    
    /*function adjuntarEvidencia(select,div) {
        HiddeFileDiv(select,div);
    }*/
    //funcion para ocultar cargar archivo SOLO SI los 5 SELECT de politica de igualdad COINCIDEN
    /*function adjuntarEvidenciaMultiple(divName) {
        var cmbPregunta8 = $("#cmbPregunta8").val(); 
        var cmbPregunta9 = $("#cmbPregunta9").val(); 
        var cmbPregunta10 = $("#cmbPregunta10").val(); 
        var cmbPregunta11 = $("#cmbPregunta11").val(); 
        var cmbPregunta12 = $("#cmbPregunta12").val(); 
        var divId = divName.id;
        var elements = divId.replace('div', '');
        if ( (cmbPregunta8 == "7. VACÍO" || cmbPregunta8 == "5. NO APLICA") && (cmbPregunta9 == "7. VACÍO" || cmbPregunta9 == "5. NO APLICA") && (cmbPregunta10 == "7. VACÍO" || cmbPregunta10 == "5. NO APLICA") && (cmbPregunta11 == "6. VACÍO" || cmbPregunta11 == "4. NO APLICA") && (cmbPregunta12 == "6. VACÍO" || cmbPregunta12 == "4. NO APLICA") ){
            $("#"+divId).hide();
            $("#"+elements).removeAttr("required");
                
        } else {
            $("#"+divId).show();
            $("#"+elements).attr("required", "required");
        }
        
        
    }*/
    function adjuntarEvidenciaDoble(divName) {
        var cmbPregunta5 = $("#cmbPregunta5").val(); 
        var cmbPregunta6 = $("#cmbPregunta6").val(); 
        var divId = divName.id;
        var elements = divId.replace('div', '');
        if ( (cmbPregunta5 == "7. VACÍO" || cmbPregunta5 == "5. NO APLICA") && (cmbPregunta6 == "6. VACÍO" || cmbPregunta6 == "4. NO APLICA")){
            $("#"+divId).hide();
            $("#"+elements).removeAttr("required");
                
        } else {
            $("#"+divId).show();
            $("#"+elements).attr("required", "required");
        }
        
    }
    
function validarPreguntaInforme(idInforme, idPregunta) {

    var parametros = {
        infCod : idInforme,
        idInforme : idPregunta
    };

    $.ajax({
        url : "checkInformeCalificado",
        headers : {
            "X-CSRF-TOKEN" : csrfToken
        },
        type : 'GET',
        async : false,
        dataType : 'json',
        data : parametros,
        success : function(respuestaJson) {
            
            retornoJson = respuestaJson;
        },
        error : function(result) {
            mostrarMensaje("Consulta no encontrada !",
                    "ERROR-NOTIFICACION", "3000");

        }
    });
}

function validarIdInforme(idInforme) {

    var parametros = {
        infCod : idInforme
    };

    $.ajax({
        url : "ObtenerPreguntas",
        headers : {
            "X-CSRF-TOKEN" : csrfToken
        },
        type : 'GET',
        //async: false,
        dataType : 'json',
        data : parametros,
        success : function(respuestaJson) {

            $.each(respuestaJson.data, function(index, detalle) {
                $("#id_informe_" + (index + 1)).val(detalle.idInfCal);
            });

        },
        error : function(result) {
            mostrarMensaje("Consulta no encontrada !",
                    "ERROR-NOTIFICACION", "3000");

        }
    });
}

function guardar(validar) {
    $.ajax({
                url : 'view/rendicion/valoracion/guardarEvaluacionGADEP',
                type : 'POST',//json
                headers : {
                    "X-CSRF-TOKEN" : csrfToken
                },
                dataType : 'json',
                data : {
                    identificadorResponsable : $('#identificadorResponsable').val(),
                    infcod : $('#infcod').val(),
                    id_informe_1 : $('#id_informe_1').val(),
                    id_informe_2 : $('#id_informe_2').val(),
                    id_informe_3 : $('#id_informe_3').val(),
                    id_informe_4 : $('#id_informe_4').val(),
                    id_informe_5 : $('#id_informe_5').val(),
                    id_informe_6 : $('#id_informe_6').val(),
                    id_informe_7 : $('#id_informe_7').val(),
                    id_informe_8 : $('#id_informe_8').val(),
                    id_informe_9 : $('#id_informe_9').val(),
                    id_informe_10 : $('#id_informe_10').val(),
                    id_informe_11 : $('#id_informe_11').val(),
                    id_informe_12 : $('#id_informe_12').val(),
                    id_informe_13 : $('#id_informe_13').val(),
                    id_informe_14 : $('#id_informe_14').val(),
                    id_informe_15 : $('#id_informe_15').val(),
                    id_informe_16 : $('#id_informe_16').val(),
                    id_informe_17 : $('#id_informe_17').val(),
                    id_informe_18 : $('#id_informe_18').val(),
                    id_informe_19 : $('#id_informe_19').val(),
                    finInforme : validar,
                    cmbpregunta1 : $('#cmbpregunta1').val(),
                    cmbPregunta2 : $('#cmbPregunta2').val(),
                    rutaArchivo1 : $('#rutaArchivo1').val(),
                    cmbPregunta3 : $('#cmbPregunta3').val(), 
                    rutaArchivo2 : $('#rutaArchivo2').val(),
                    cmbPregunta4 : $('#cmbPregunta4').val(),
                    rutaArchivo3 : $('#rutaArchivo3').val(),
                    cmbPregunta5 : $('#cmbPregunta5').val(),
                    rutaArchivo4 : $('#rutaArchivo4').val(),
                    cmbPregunta6 : $('#cmbPregunta6').val(),
                    rutaArchivo5 : $('#rutaArchivo5').val(),
                    cmbPregunta7 : $('#cmbPregunta7').val(),
                    rutaArchivo6 : $('#rutaArchivo6').val(),
                    cmbPregunta8 : $('#cmbPregunta8').val(),
                    rutaArchivo7 : $('#rutaArchivo7').val(),
                    cmbPregunta9 : $('#cmbPregunta9').val(),
                    rutaArchivo8 : $('#rutaArchivo8').val(),
                    cmbPregunta10 : $('#cmbPregunta10').val(),
                    rutaArchivo9 : $('#rutaArchivo9').val(),
                    cmbPregunta11 : $('#cmbPregunta11').val(),
                    rutaArchivo10 : $('#rutaArchivo10').val(),
                    cmbPregunta12 : $('#cmbPregunta12').val(),
                    rutaArchivo11 : $('#rutaArchivo11').val(),                  
                    cmbPregunta13 : $('#cmbPregunta13').val(),
                    rutaArchivo12 : $('#rutaArchivo12').val(),
                    cmbPregunta14 : $('#cmbPregunta14').val(),
                    cmbPregunta15 : $('#cmbPregunta15').val(),  
                    cmbPregunta16 : $('#cmbPregunta16').val(),
                    cmbPregunta17 : $('#cmbPregunta17').val(),
                    cmbPregunta18 : $('#cmbPregunta18').val(),
                    cmbPregunta19 : $('#cmbPregunta19').val(),
                    observacion : $('#observacion').val(),
                    periodoInforme : $('#periodoInforme').val()
                },
                async : true,
                beforeSend : function(jqXHR) {

                    if ($("#cargando").length) {
                        // hacer algo aquí si el elemento existe
                        $("#detalleItem").find("#cargando").fadeIn();
                    } else {

                        $("#detalleItem").append(
                                "<div id='cargando'>Cargando...</div>")
                                .fadeIn();
                    }

                },
                success : function(msg) {
                    if (msg.estado == "exito") {
                        toastr.clear();
                        mostrarMensaje(msg.mensaje, "EXITO");
                        $("#cargando").delay("slow").fadeOut();
                        cargaDatos($("#infcod").val());

                    } else {
                        $("#cargando").delay("slow").fadeOut();
                        mostrarMensaje(msg.mensaje, "ERROR");

                    }
                }
            });
}
    
</script>
