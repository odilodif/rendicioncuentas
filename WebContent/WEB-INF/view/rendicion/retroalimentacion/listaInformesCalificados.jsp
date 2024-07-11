y<%-- 
	version		: 1.0
    Document  	: listaInformesCalificados
    Created on	: 15/04/2024, 11:14:00
    Author		: Jhonatan Loor
    Mail		: jloor@cpccs.gob.ec
    Property   	: CPCCS
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<spring:url value="/resources/" var="urlPublic" />

<!DOCTYPE">
<html>
<div class="card text-center mb-card20">
	<div class="card-header text-white carHeaderBlue">
		<h4>RETROALIMENTACIÓN DE RENDICIÓN DE CUENTAS</h4>
	</div>

	<div class="card-body">

		<div class="row">

			<div class="col-lg-12">
				<div class="card">
					<div class="card-body">
						<div class="form-group row">
							<div class="col-md-2 text-left">
								<label for="cmbPeriodo">Seleccione el periodo a
									visualizar </label>
							</div>
							<div class="col-md-3 text-left">
								<select class="form-control" id="cmbInstituciones"
									required="required" name="cmbInstituciones">
									<option value="">Seleccione...</option>
								</select>

								<div class="invalid-feedback">Por favor seleccione el
									periodo</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="divtabla">
		<button type="submit" id="btnPlanFinalizar"
			class="btn _nuevoColor _guardar btn-sm mt-2"
			data-rutaaplicacion="rendicion" data-opcion=""
			data-destino="detalleItem" data-nombre="Nuevo">Nuevo</button>
	</div>
</div>
</html>
<script>
	var codInstitucionInforme = "${codigoTipoInforme}"; //variable global, obtenemos el tipo de informe de la institucion enviado por el controller.
	$(document).ready(function() {
		$("#divtabla").hide();

		//console.log(#listaInstitucionesJson);

		// Obtener el JSON de la lista de instituciones desde el modelo
		var listaInstitucionesJson = "${listaInstituciones}";
		// Deserializar el JSON a un array de objetos JavaScript
		var listaInstituciones = JSON.parse(listaInstitucionesJson);
		// Obtener el select
		var cmbInstituciones = document.getElementById("cmbInstituciones");
		// Iterar sobre la lista de instituciones y agregar opciones al select
		listaInstituciones.forEach(function(institucion) {
			var option = document.createElement("option");
			option.value = institucion[0]; // Acceder al primer elemento del subarray (código de institución)
			option.text = institucion[1]; // Acceder al segundo elemento del subarray (periodo)
			cmbInstituciones.appendChild(option);
		});
		$('#cmbInstituciones').change(function() {
			// Pass the select element to the cargarTabla function
			//cargarTabla(this);
			$("#btnPlanFinalizar").click();
		});
	});
	$("#btnPlanFinalizar").click(
			function(event) {
				var selectedOption = $('#cmbInstituciones').val(); // Get the selected option value
				var selectedText = $('#cmbInstituciones').find(
						"option:selected").text(); // Get the selected option text
				var mergedValueText = selectedOption + "-" + selectedText; // Merge value and text with "-"
				var btnPlanFinalizar = document
						.getElementById('btnPlanFinalizar');// Obtener el botón por su ID
				//segun el tipo de institucion llamamos a un tipo diferente de vista y metodo de controller
				switch (codInstitucionInforme) {
				case "1":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeGADValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "2":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeGADEPValorado');//ok
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "3":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeFEEPValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "4":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeGADVinculadoValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "5":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeESValorado');//ok
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "6":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeFEValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "7":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeMedioValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				case "8":
					btnPlanFinalizar.setAttribute('data-opcion',
							'RetroalimentacionInformeIESSValorado');
					abrirPaguina($(this), "#" + $(this).attr("data-destino"),
							mergedValueText);
					break;
				default:
	                console.log('Código de institución no reconocido:', codInstitucionInforme);
				}

			});
	/*
	function cargarTabla(selectElement) {
		$("#btnPlanFinalizar").click();
		
		// Event listener for change event on select
	    	var selectedOption = $(selectElement).val(); // Get the selected option value
			 var selectedText = $(selectElement).find("option:selected").text(); // Get the selected option text

			// Merge value and text with "-"
			var mergedValueText = selectedOption + "-" + selectedText;
	        // Load the selected JSP file via AJAX
	        $.ajax({
	            url: 'view/rendicion/RetroalimentacionInformeGADEPValorado',
	            headers : {
					"X-CSRF-TOKEN" : csrfToken
				},
	            type: 'GET',
	            data : {
	            	id : mergedValueText
				},
				success : function(data) {
					// Display the loaded content in a designated area
					console.log("se obtuvo los datos");
	                
	            },
	            error: function(xhr, status, error) {
	                // Handle errors if needed
	                console.error(error);
	            }
	        });
	 */
</script>
