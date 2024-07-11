
var tryout = new XMLHttpRequest();

tryout.open("GET", "/rendicioncuentas/index",false);
tryout.send();
var csrfToken = tryout.getResponseHeader('X-CSRF-TOKEN');


//toastr.js
!function(e){e(["jquery"],function(e){return function(){function t(e,t,n){return f({type:O.error,iconClass:g().iconClasses.error,message:e,optionsOverride:n,title:t})}function n(t,n){return t||(t=g()),v=e("#"+t.containerId),v.length?v:(n&&(v=c(t)),v)}function i(e,t,n){return f({type:O.info,iconClass:g().iconClasses.info,message:e,optionsOverride:n,title:t})}function o(e){w=e}function s(e,t,n){return f({type:O.success,iconClass:g().iconClasses.success,message:e,optionsOverride:n,title:t})}function a(e,t,n){return f({type:O.warning,iconClass:g().iconClasses.warning,message:e,optionsOverride:n,title:t})}function r(e){var t=g();v||n(t),l(e,t)||u(t)}function d(t){var i=g();return v||n(i),t&&0===e(":focus",t).length?void h(t):void(v.children().length&&v.remove())}function u(t){for(var n=v.children(),i=n.length-1;i>=0;i--)l(e(n[i]),t)}function l(t,n){return t&&0===e(":focus",t).length?(t[n.hideMethod]({duration:n.hideDuration,easing:n.hideEasing,complete:function(){h(t)}}),!0):!1}function c(t){return v=e("<div/>").attr("id",t.containerId).addClass(t.positionClass).attr("aria-live","polite").attr("role","alert"),v.appendTo(e(t.target)),v}function p(){return{tapToDismiss:!0,toastClass:"toast",containerId:"toast-container",debug:!1,showMethod:"fadeIn",showDuration:300,showEasing:"swing",onShown:void 0,hideMethod:"fadeOut",hideDuration:1e3,hideEasing:"swing",onHidden:void 0,extendedTimeOut:1e3,iconClasses:{error:"toast-error",info:"toast-info",success:"toast-success",warning:"toast-warning"},iconClass:"toast-info",positionClass:"toast-top-right",timeOut:5e3,titleClass:"toast-title",messageClass:"toast-message",target:"body",closeHtml:'<button type="button">&times;</button>',newestOnTop:!0,preventDuplicates:!1,progressBar:!1}}function m(e){w&&w(e)}function f(t){function i(t){return!e(":focus",l).length||t?(clearTimeout(O.intervalId),l[r.hideMethod]({duration:r.hideDuration,easing:r.hideEasing,complete:function(){h(l),r.onHidden&&"hidden"!==b.state&&r.onHidden(),b.state="hidden",b.endTime=new Date,m(b)}})):void 0}function o(){(r.timeOut>0||r.extendedTimeOut>0)&&(u=setTimeout(i,r.extendedTimeOut),O.maxHideTime=parseFloat(r.extendedTimeOut),O.hideEta=(new Date).getTime()+O.maxHideTime)}function s(){clearTimeout(u),O.hideEta=0,l.stop(!0,!0)[r.showMethod]({duration:r.showDuration,easing:r.showEasing})}function a(){var e=(O.hideEta-(new Date).getTime())/O.maxHideTime*100;f.width(e+"%")}var r=g(),d=t.iconClass||r.iconClass;if("undefined"!=typeof t.optionsOverride&&(r=e.extend(r,t.optionsOverride),d=t.optionsOverride.iconClass||d),r.preventDuplicates){if(t.message===C)return;C=t.message}T++,v=n(r,!0);var u=null,l=e("<div/>"),c=e("<div/>"),p=e("<div/>"),f=e("<div/>"),w=e(r.closeHtml),O={intervalId:null,hideEta:null,maxHideTime:null},b={toastId:T,state:"visible",startTime:new Date,options:r,map:t};return t.iconClass&&l.addClass(r.toastClass).addClass(d),t.title&&(c.append(t.title).addClass(r.titleClass),l.append(c)),t.message&&(p.append(t.message).addClass(r.messageClass),l.append(p)),r.closeButton&&(w.addClass("toast-close-button").attr("role","button"),l.prepend(w)),r.progressBar&&(f.addClass("toast-progress"),l.prepend(f)),l.hide(),r.newestOnTop?v.prepend(l):v.append(l),l[r.showMethod]({duration:r.showDuration,easing:r.showEasing,complete:r.onShown}),r.timeOut>0&&(u=setTimeout(i,r.timeOut),O.maxHideTime=parseFloat(r.timeOut),O.hideEta=(new Date).getTime()+O.maxHideTime,r.progressBar&&(O.intervalId=setInterval(a,10))),l.hover(s,o),!r.onclick&&r.tapToDismiss&&l.click(i),r.closeButton&&w&&w.click(function(e){e.stopPropagation?e.stopPropagation():void 0!==e.cancelBubble&&e.cancelBubble!==!0&&(e.cancelBubble=!0),i(!0)}),r.onclick&&l.click(function(){r.onclick(),i()}),m(b),r.debug&&console&&console.log(b),l}function g(){return e.extend({},p(),b.options)}function h(e){v||(v=n()),e.is(":visible")||(e.remove(),e=null,0===v.children().length&&(v.remove(),C=void 0))}var v,w,C,T=0,O={error:"error",info:"info",success:"success",warning:"warning"},b={clear:r,remove:d,error:t,getContainer:n,info:i,options:{},subscribe:o,success:s,version:"2.1.0",warning:a};return b}()})}("function"==typeof define&&define.amd?define:function(e,t){"undefined"!=typeof module&&module.exports?module.exports=t(require("jquery")):window.toastr=t(window.jQuery)});


function notificacionBottomRight() {
    toastr.options = {
              "closeButton": false,
              "debug": false,
              "newestOnTop": false,
              "progressBar": true,
              "positionClass": "toast-bottom-right",
              "preventDuplicates": true,
              "onclick": null,
              "showDuration": "100",
              "hideDuration": "1000",
              "timeOut": "5500",
              "extendedTimeOut": "1000",
              "showEasing": "swing",
              "hideEasing": "linear",
              "showMethod": "show",
              "hideMethod": "hide"
    };
};

function mostrarMensaje(texto, tipo, tiempo) {
    toastr.clear();
    var tiempo = (typeof tiempo === 'undefined') ? '5500' : tiempo;
    toastr.options.timeOut = tiempo;
    switch (tipo) {
         case 'EXITO':
              toastr.success(texto);
         break;
         case 'ERROR':
              toastr.error(texto);
            
         break;
         case 'ERROR-NOTIFICACION':
              toastr.warning(texto);
         break;
         case 'EXITO-NOTIFICACION':
              toastr.info(texto);
         break;
         default:
              toastr.info("Error desconocido");
    }
}


notificacionBottomRight();



function mensajeErrorAjax(msgError,textStatus){
    var msg = '';
    var codigoError=msgError.status;
    if (codigoError === 0) {
        msg = 'No conectado, Verificar red.';
    } else if (codigoError == 404) {
        msg = 'Página solicitada no encontrada. [404]';
    } else if (codigoError == 405) {
        msg = 'Método de la solicitud no permitido. [405]';
    } else if (codigoError == 500) {
        msg = 'Error interno del servidor [500].';
    } else if (textStatus === 'parsererror') {
        msg = 'El JSON solicitado falló.';
    } else if (textStatus === 'timeout') {
        msg = 'Error de tiempo de espera.';
    } else if (textStatus === 'abort') {
        msg = 'Ajax petición abortada.';
    } else if (codigoError == 403) {
        msg = 'Su sesión ha caducado. [403]';
         function demorar() {
  	  window.location.href = "login?error=4";
  	}
    setTimeout(demorar, 3000); 
    } else {
        msg = 'Error no detectado.\n' + msgError.responseText;
    }
   
    mostrarMensaje(msg,"ERROR",3500);
}


function notificacioneseditar(element) {
   
    $.ajax({
        data: {idAplicacionNotificacion: element},
        url: 'actualizarNotificacion',
        type: "POST",
        dataType: "json",
        headers: {
            "X-CSRF-TOKEN": csrfToken
       },
        dataType: "json",
        success: function (result) {
            if(result[0].estado=="exito"){
        	mostrarMensaje(result[0].mensaje, "EXITO-NOTIFICACION",2500);
            }else if(result[0].estado=="error"){
        	mostrarMensaje(result[0].mensaje, "ERROR",3000);
            }
        },
        error: function (jqXHR, textStatus) {
           mensajeErrorAjax(jqXHR,textStatus);
        }
    });
}

function notificaciones(valoresObj,notificacionJson) {
    var notifications = new $.ttwNotificationMenu({
        notificationList: {
            anchor: 'item',
            offset: '0 15'
        }
    });

    notifications.initMenu(valoresObj);
    notifications.createNotification(JSON.parse(notificacionJson));
}

function validaUrl(input){
    var regex = new RegExp("^(http[s]?:\\/\\/(www\\.)?|ftp:\\/\\/(www\\.)?|www\\.){1}([0-9A-Za-z-\\.@:%_\+~#=]+)+((\\.[a-zA-Z]{2,3})+)(/(.)*)?(\\?(.)*)?");
    if (regex.test(input.value)) {      
       
    } else {
        mostrarMensaje("El link ingresado no es válido!","ERROR","4000");
        input.value = '';
    }
}
function validarnro(e) {
    var key;
    if (window.event) // IE
    {
        key = e.keyCode;
    }
    else if (e.which) // Netscape/Firefox/Opera
    {
        key = e.which;
    }

    if (key < 48 || key > 57) {
        if ( key == 8 || key ==44) // Detectar . (punto) y backspace (retroceso)
        {
            return true;
        }
        else {
            return false;
        }
    }
    return true;
}
function validardecimal(e) {
    var key;
    if (window.event) // IE
    {
        key = e.keyCode;
    }
    else if (e.which) // Netscape/Firefox/Opera
    {
        key = e.which;
    }

    if (key < 48 || key > 57) {
        if ( key == 8 || key ==46) // Detectar . (punto) y backspace (retroceso)
        {
            return true;
        }
        else {
            return false;
        }
    }
    return true;
}
function validarnroEntero(e) {
    var key;
    if (window.event) // IE
    {
        key = e.keyCode;
    }
    else if (e.which) // Netscape/Firefox/Opera
    {
        key = e.which;
    }

    if (key < 48 || key > 57) {
        if ( key == 8 ) // Detectar . (punto) y backspace (retroceso)
        {
            return true;
        }
        else {
            return false;
        }
    }
    return true;
}
//mascara, funcion para controlar ingreso en imput de tipo decimal.
function mascara(o,f){  
		v_obj=o;  
		v_fun=f;  
		setTimeout("execmascara()",1);  
	}  
	function execmascara(){   
		v_obj.value=v_fun(v_obj.value);
	}  
	function cpf(v){     
		v=v.replace(/([^0-9\.]+)/g,''); 
		v=v.replace(/^[\.]/,''); 
		v=v.replace(/[\.][\.]/g,''); 
		v=v.replace(/\.(\d)(\d)(\d)/g,'.$1$2'); 
		v=v.replace(/\.(\d{1,2})\./g,'.$1'); 
		v = v.toString().split('').reverse().join('').replace(/(\d{3})/g,'$1,');    
		v = v.split('').reverse().join('').replace(/^[\,]/,''); 
		return v;  
	}
		function addCommas(nStr){
		nStr += '';
		x = nStr.split('.');
		x1 = x[0];
		x2 = x.length > 1 ? '.' + x[1] : '';
		var rgx = /(\d+)(\d{3})/;
		while (rgx.test(x1)) {
			x1 = x1.replace(rgx, '$1' + ',' + '$2');
		}
		return x1 + x2;
	}
//funcion para controlar ingreso solo de numeros enteros en imput tipo entero.
function mascaraEnteros(o) {
    v_obj = o;
    v_fun = entero;
    setTimeout("execmascaraEntero()", 1);
}

function execmascaraEntero() {
    v_obj.value = v_fun(v_obj.value);
}

function entero(v) {
    // Remueve todo lo que no sea un número entero
    v = v.replace(/\D/g, '');
    // Si el valor está vacío, retorna 0, de lo contrario, retorna el número entero
    return v === '' ? '0' : parseInt(v, 10);
}
