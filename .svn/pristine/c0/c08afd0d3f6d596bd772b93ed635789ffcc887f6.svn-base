
//Funciones para bloquear el back del navegador Chrome, Firefox, Edge, Opera//

nobackbutton();
function nobackbutton(){
	
   window.location.hash="";
	
   window.location.hash="" //chrome
	
   window.onhashchange=function(){window.location.hash="";}
	
}

//Funcion para inavilitar clic derecho o menucontextual//

document.oncontextmenu = contextual;
function contextual(){
	return false
	}	
//Funcion para bloquear F12 y  Prevent Ctrl+Shift+I //
window.onkeydown=tecla;
function tecla(event){
			num = event.keyCode;
				if(num==123){
				return false
				 }
				else if (event.ctrlKey && event.shiftKey && event.keyCode == 73) { // Prevent Ctrl+Shift+I        
			        return false;
			    }
}
