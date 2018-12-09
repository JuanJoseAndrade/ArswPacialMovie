var OrdersControllerModule = (function () {
  
//------------------Metodos Get---------------
  var getEmpresa = function (empresa,tipox) {
    var callback = {
		
        onSuccess: function(ordersList){
			document.getElementById("tablaRespuesta").innerHTML=JSON.stringify(ordersList);
            },
        onFailed: function(exception){
			alert(exception);
        }
    }
	tipo=empresa.toUpperCase()+'/'+tipox.toLowerCase()+'/';
    RestControllerModule.getEmpresa(tipo,callback);
  };
  
 

  return {
	getEmpresa: getEmpresa

  };

})();